package edu.uah.rsesc.aadl.age.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.DiagramModificationService;
import edu.uah.rsesc.aadl.age.services.DiagramService;
import edu.uah.rsesc.aadl.age.util.Log;

public class DefaultDiagramModificationService implements DiagramModificationService {
	public static interface DiagramCallback {
		void onDiagram(final Diagram diagram);
	}
	
	private final DiagramService diagramService;
	private final BusinessObjectResolutionService bor;
	
	public DefaultDiagramModificationService(final DiagramService diagramService, final BusinessObjectResolutionService bor) {
		this.diagramService = diagramService;
		this.bor = bor;
	}

	@Override
	public Modification startModification() {
		return new DefaultModification();
	}

	class DefaultModification implements Modification {
		private final Map<Diagram, Map<NamedElement, PictogramElement[]>> diagramToDirtyLinkages = new HashMap<Diagram, Map<NamedElement, PictogramElement[]>>();
		private final List<Diagram> diagrams;
		
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
					}
				}
    		}
    	}
    	
		@Override
		public void commit() {
			updateDirtyLinkages();
			diagramToDirtyLinkages.clear();
		}
		
		private void updateDirtyLinkages() {
			for(final Entry<Diagram, Map<NamedElement, PictogramElement[]>> diagramToDirtyLinkagesEntry : diagramToDirtyLinkages.entrySet()) {
    			final Diagram diagram = diagramToDirtyLinkagesEntry.getKey();
				updateDiagram(diagram, new DiagramCallback() {
					@Override
					public void onDiagram(final Diagram diagram) {
						final IFeatureProvider fp = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
		    			for(final Entry<NamedElement, PictogramElement[]> dirtyLinkagesEntry : diagramToDirtyLinkagesEntry.getValue().entrySet()) {
		    				final AadlElementWrapper elWrapper = new AadlElementWrapper(dirtyLinkagesEntry.getKey());
		    				for(final PictogramElement pe : dirtyLinkagesEntry.getValue()) {
		    					fp.link(pe, elWrapper);
		    				}
		    			}
					}    					
				});
    		}
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

