package edu.uah.rsesc.aadl.age.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.DiagramService;
import edu.uah.rsesc.aadl.age.ui.util.GhostPurger;
import edu.uah.rsesc.aadl.age.util.Log;

public class DefaultDiagramModificationService implements DiagramModificationService {
	public static interface DiagramCallback {
		void onDiagram(final Diagram diagram);
	}
	
	private final DiagramService diagramService;
	private final BusinessObjectResolutionService bor;
	private final GhostPurger ghostPurger;
	
	public DefaultDiagramModificationService(final DiagramService diagramService, final GhostPurger ghostPurger, final BusinessObjectResolutionService bor) {
		this.diagramService = diagramService;
		this.ghostPurger = ghostPurger;
		this.bor = bor;
	}

	@Override
	public Modification startModification() {
		return new DefaultModification();
	}

	class DefaultModification implements Modification {
		private final Map<Diagram, Map<NamedElement, PictogramElement[]>> diagramToDirtyLinkages = new HashMap<Diagram, Map<NamedElement, PictogramElement[]>>();
		private final Set<Diagram> dirtyDiagrams = new HashSet<Diagram>();
		private final List<Diagram> diagrams;
		
		@Override
		public List<Diagram> getDiagrams() {
			return diagrams;
		}
		
		private Map<NamedElement, PictogramElement[]> getDirtyLinkages(final Diagram diagram) {
    		Map<NamedElement, PictogramElement[]> dirtyLinkages = diagramToDirtyLinkages.get(diagram);
    		if(dirtyLinkages == null) {
    			dirtyLinkages = new HashMap<NamedElement, PictogramElement[]>();
    			diagramToDirtyLinkages.put(diagram, dirtyLinkages);
    		}
    		return dirtyLinkages;
    	}

    	private void setDirtyLinkages(final Diagram diagram, final NamedElement el, PictogramElement[] pes) {
    		getDirtyLinkages(diagram).put(el, pes);
    	}
    	
    	public DefaultModification() {
    		diagrams = diagramService.findDiagrams();
    	}
    	
    	@Override
    	public void markDiagramAsDirty(final Diagram diagram) {
    		dirtyDiagrams.add(diagram);
    	}
    	
    	private List<ComponentImplementation> getAllExtended(final ComponentImplementation ci) {
    		final List<ComponentImplementation> results = new ArrayList<ComponentImplementation>();		
    		for(ComponentImplementation tmp = ci.getExtended(); tmp != null; tmp = tmp.getExtended()) {
    			results.add(tmp);
    		}
    		return results;
    	}
    	
    	private boolean isExtendedFrom(final ComponentImplementation ci, ComponentImplementation baseComponentImplementation) {
    		for(final Classifier extended : getAllExtended(ci)) {
    			if(extended == baseComponentImplementation) {
    				return true;
    			}
    		}
    		return false;	
    	}
    	
    	@Override
    	public void markDiagramsOfDerivativeComponentImplementationsAsDirty(final ComponentImplementation ci) {
    		// Mark any diagrams that are linked to component implementations that extends the current component implementation as dirty
    		for(final Diagram tmpDiagram : getDiagrams()) {
    			final Object tmpDiagramBo = bor.getBusinessObjectForPictogramElement(tmpDiagram);
    			if(tmpDiagramBo instanceof ComponentImplementation) {
    				final ComponentImplementation tmpDiagramCi = (ComponentImplementation)tmpDiagramBo;
    				if(isExtendedFrom(tmpDiagramCi, ci)) {
    					markDiagramAsDirty(tmpDiagram);			
    				}
    			}					
    		}
    	}
    	
    	@Override
    	public void markLinkagesAsDirty(final NamedElement el) {
    		final AadlElementWrapper elWrapper = new AadlElementWrapper(el);
    		
    		// For each diagram
    		for(final Diagram diagram : diagrams) {
    			// Create a feature provider and check if it is linked to the aadl element
				final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
				if(featureProvider != null) {
					final Object diagramBo = bor.getBusinessObjectForPictogramElement(diagram);

					// Find Linkages
					final List<PictogramElement> linkages = new ArrayList<PictogramElement>();
					
					// Get pictogram elements in the diagram that is linked to the element
					final PictogramElement[] pes = featureProvider.getAllPictogramElementsForBusinessObject(elWrapper);
					for(PictogramElement pe : pes) {
						linkages.add(pe);
					}
	
					// Check if the diagram is linked to the element. Diagrams are not returned by getAllPictogramElementsForBusinessObject
					if(diagramBo instanceof NamedElement && el.getQualifiedName().equalsIgnoreCase(((NamedElement)diagramBo).getQualifiedName())) {
						linkages.add(diagram);
					}						
					
					// Add to dirty linkages
					if(linkages.size() > 0) {
						setDirtyLinkages(diagram, el, linkages.toArray(new PictogramElement[0]));
						dirtyDiagrams.add(diagram);
					}
				}
    		}
    	}
    	
		@Override
		public void commit() {
			// Update dirty linkages and update each diagram
			for(final Diagram dirtyDiagram : dirtyDiagrams) {
				updateDiagram(dirtyDiagram, new DiagramCallback() {
					@Override
					public void onDiagram(final Diagram diagram) {						
						// Update any dirty linkages stored for the diagram
						final IFeatureProvider fp = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
						final Map<NamedElement, PictogramElement[]> dirtyLinkagesMap = diagramToDirtyLinkages.get(diagram);
						if(dirtyLinkagesMap != null) {
			    			for(final Entry<NamedElement, PictogramElement[]> dirtyLinkagesEntry : dirtyLinkagesMap.entrySet()) {
			    				final AadlElementWrapper elWrapper = new AadlElementWrapper(dirtyLinkagesEntry.getKey());
			    				for(final PictogramElement pe : dirtyLinkagesEntry.getValue()) {
			    					fp.link(pe, elWrapper);
			    				}
			    			}
						}
					}    					
				});				
			}
			
			diagramToDirtyLinkages.clear();
			dirtyDiagrams.clear();
		}

		private void updateDiagram(final Diagram diagram, final DiagramCallback cb) {
    		final Resource resource = diagram.eResource();
    		final ResourceSet resourceSet = resource.getResourceSet();
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
			boolean editingDomainCreated = false;
			if(editingDomain == null) {
				Log.info("Creating an editing domain");
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
				editingDomainCreated = true;
			}

			// Execute a transaction to update the diagram's linkage
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					cb.onDiagram(diagram);
					
					// Update the entire diagram
					final IFeatureProvider fp = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
					fp.getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { diagram });
				}			
			});						
			
			// Save the resource
			try {
				// Delete all ghosts
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						ghostPurger.purgeGhosts(diagram);
					}				
				});	

				resource.save(null);
			} catch (IOException e) {
				throw new RuntimeException("Error saving new diagram", e);
			}
			
			// Dispose of the editing domain if we created it
			if(editingDomainCreated) {
				editingDomain.getCommandStack().flush();
				editingDomain.dispose();
			}
    	}
	}
}

