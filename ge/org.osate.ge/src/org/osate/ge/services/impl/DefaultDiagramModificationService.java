/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.DiagramService;
import org.osate.ge.ui.util.GhostPurger;
import org.osate.ge.util.Log;

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
    	    	
    	private List<Classifier> getSelfAndSpecificClassifiers(final Classifier c) {
    		final List<Classifier> results = new ArrayList<Classifier>();
			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(c, c.eResource().getResourceSet())) {
				final EStructuralFeature sf = s.getEStructuralFeature();
				if(!sf.isDerived()) {
					final EObject obj = s.getEObject();
					if(obj instanceof Generalization) {
						final Generalization gen = (Generalization)obj;
						if(gen.getGeneral() == c && gen.getSpecific() != null) {
							results.add(gen.getSpecific());
						}
					}
				}
			}
			return results;
    	}
    	
    	private List<AadlElementWrapper> getRelevantElements(final List<Classifier> classifiers) {
    		final List<AadlElementWrapper> results = new ArrayList<AadlElementWrapper>();
    		for(final Classifier c : classifiers) {
    			for(final Setting s : EcoreUtil.UsageCrossReferencer.find(c, c.eResource().getResourceSet())) {
    				final EStructuralFeature sf = s.getEStructuralFeature();
    				if(!sf.isDerived()) {
    					final EObject obj = s.getEObject();
    					if(obj instanceof FeatureGroup || obj instanceof Subcomponent) {
    						results.add(new AadlElementWrapper((Element)obj));
    					}
    				}
    			}
    		}
    		return results;
    	}

    	@Override
    	public void markRelatedDiagramsAsDirty(final Classifier c) {
    		if(c != null) {
    			// Create a list of relevant classifiers by build a list that contains the specified classifiers and all classifiers "derived"(that extend or implement it).    			
    			// Make a relevant element list that contains all the AADL elements that reference classifiers in the relevant classifier list
     			// For each diagram, 
    			// Mark as dirty if the diagram's BO is in the classifier list
    			// Mark as dirty if the diagram contains a shape whose BO is in the relevant element list    			
    			final List<Classifier> relevantClassifiers = getSelfAndSpecificClassifiers(c);
    			final List<AadlElementWrapper> relevantElements = getRelevantElements(relevantClassifiers);
    			
    			for(final Diagram tmpDiagram : getDiagrams()) {
	    			final Object tmpDiagramBo = bor.getBusinessObjectForPictogramElement(tmpDiagram);
	    			boolean markDiagram = false;
	    			
	    			if(relevantClassifiers.contains(tmpDiagramBo)) {
	    				markDiagram = true;
	    			} else {		    			
		    			final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(tmpDiagram);
		    			for(final AadlElementWrapper relAadlElementWrapper : relevantElements) {
		    				if(featureProvider.getPictogramElementForBusinessObject(relAadlElementWrapper) != null) {
		    					markDiagram = true;
		    				}
		    			}
	    			}
	    			
	    			if(markDiagram) {
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

