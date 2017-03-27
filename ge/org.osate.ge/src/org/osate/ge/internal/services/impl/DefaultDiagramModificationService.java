/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

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
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Generalization;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.DiagramService.DiagramReference;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.util.Log;

public class DefaultDiagramModificationService implements DiagramModificationService {
	public static interface DiagramCallback {
		void onDiagram(final Diagram diagram);
	}
	
	private final DiagramService diagramService;
	private final InternalReferenceBuilderService refBuilder;
	private final BusinessObjectResolutionService bor;

	public DefaultDiagramModificationService(final DiagramService diagramService, final InternalReferenceBuilderService refBuilder, final BusinessObjectResolutionService bor) {
		this.diagramService = diagramService;
		this.refBuilder = refBuilder;
		this.bor = bor;
	}

	@Override
	public Modification startModification() {
		return new DefaultModification();
	}

	class DefaultModification implements Modification {
		private final Map<Diagram, Map<Object, PictogramElement[]>> diagramToDirtyLinkages = new HashMap<>();
		private final Set<DiagramReference> dirtyDiagramReferences = new HashSet<DiagramReference>();
		private List<DiagramReference> diagramReferences = null;
		
		/**
		 * Lazy initialize diagram list
		 * @return
		 */
		private List<DiagramReference> getDiagramReferences() {
			if(diagramReferences == null) {
				diagramReferences = diagramService.findDiagrams();
			}
			return diagramReferences;
		}
		
		private Map<Object, PictogramElement[]> getDirtyLinkages(final Diagram diagram) {
    		Map<Object, PictogramElement[]> dirtyLinkages = diagramToDirtyLinkages.get(diagram);
    		if(dirtyLinkages == null) {
    			dirtyLinkages = new HashMap<Object, PictogramElement[]>();
    			diagramToDirtyLinkages.put(diagram, dirtyLinkages);
    		}
    		return dirtyLinkages;
    	}

    	private void setDirtyLinkages(final Diagram diagram, final Object bo, PictogramElement[] pes) {
    		getDirtyLinkages(diagram).put(bo, pes);
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
    	
    	private Set<AadlPackage> getPackages(final List<Classifier> classifiers) {
    		final Set<AadlPackage> results = new HashSet<AadlPackage>();
    		
    		for(final Classifier c : classifiers) {
    			if(c.getElementRoot() instanceof AadlPackage) {
    				results.add((AadlPackage)c.getElementRoot());
    			}
    		}
    		
    		return results;
    	}
    	
    	@Override
    	public void markOpenRelatedDiagramsAsDirty(final Classifier c) {
    		if(c != null) {
    			// Create a list of relevant classifiers by build a list that contains the specified classifiers and all classifiers "derived"(that extend or implement it).    			
    			// Make a relevant element list that contains all the AADL elements that reference classifiers in the relevant classifier list
     			// For each diagram, 
    			// Mark as dirty if the diagram's BO is in the classifier list
    			// Mark as dirty if the diagram contains a shape whose BO is in the relevant element list
    			final List<Classifier> relevantClassifiers = getSelfAndSpecificClassifiers(c);
    			final Set<AadlPackage> relevantPackages = getPackages(relevantClassifiers);
    			
    			for(final DiagramReference tmpDiagramReference : getDiagramReferences()) {
    				if(tmpDiagramReference.isOpen()) {
	    				final Diagram tmpDiagram = tmpDiagramReference.getDiagram();
	    				if(tmpDiagram != null) {
			    			final Object tmpDiagramBo = bor.getBusinessObjectForPictogramElement(tmpDiagram);
			    			
			    			boolean markDiagram = false;
			    			
			    			if(relevantClassifiers.contains(tmpDiagramBo) || relevantPackages.contains(tmpDiagramBo)) {
			    				markDiagram = true;
			    			} else {
			    				// Only check if the diagram is linked to one of the relevant classifiers.
			    				// Creating a feature provider for every diagram is expensive.
			    				/*
				    			final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(tmpDiagram);
				    			for(final AadlElementWrapper relAadlElementWrapper : relevantElements) {
				    				if(featureProvider.getPictogramElementForBusinessObject(relAadlElementWrapper) != null) {
				    					markDiagram = true;
				    				}
				    			}
				    			*/
			    			}
			    			
			    			if(markDiagram) {
			    				dirtyDiagramReferences.add(tmpDiagramReference);
			    			}
	    				}
    				}
    			}
    		}
    	}
    	
    	@Override
    	public void markLinkagesAsDirty(final Object bo) {    		
    		// For each diagram
    		final String boRef = refBuilder.getAbsoluteReference(bo);
    		for(final DiagramReference diagramRef : getDiagramReferences()) {
    			markLinkagesAsDirty(bo, boRef, diagramRef);
    		}
    	}
    	
    	@Override
		public void markOpenLinkagesAsDirty(final Object bo) {
    		// For each diagram
    		final String boRef = refBuilder.getAbsoluteReference(bo);
    		for(final DiagramReference diagramRef : getDiagramReferences()) {
    			if(diagramRef.isOpen()) {
	    			markLinkagesAsDirty(bo, boRef, diagramRef);
    			}
    		}
    	}
    	
    	/**
    	 * Helper function for implementing public methods for marking linakges as dirty
    	 * @param elWrapper
    	 * @param diagram
    	 */
    	private void markLinkagesAsDirty(final Object bo, final String boRef, final DiagramReference diagramReference) {
    		final Diagram diagram = diagramReference.getDiagram();
    		if(diagram != null) {
    			
	    		// Create a feature provider and check if it is linked to the aadl element
				final IFeatureProvider featureProvider = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
				if(featureProvider != null) {
					final Object diagramBo = bor.getBusinessObjectForPictogramElement(diagram);
	
					// Find Linkages
					final List<PictogramElement> linkages = new ArrayList<PictogramElement>();
					
					// Get pictogram elements in the diagram that is linked to the element
					final PictogramElement[] pes = featureProvider.getAllPictogramElementsForBusinessObject(bo);
					for(PictogramElement pe : pes) {
						linkages.add(pe);
					}
	
					// Check if the diagram is linked to the element. Diagrams are not returned by getAllPictogramElementsForBusinessObject
					if(boRef.equals(refBuilder.getAbsoluteReference(diagramBo))) {
						linkages.add(diagram);
					}						
					
					// Add to dirty linkages
					if(linkages.size() > 0) {
						setDirtyLinkages(diagram, bo, linkages.toArray(new PictogramElement[0]));
						dirtyDiagramReferences.add(diagramReference);
					}
				}
    		}
    	}
    	
		@Override
		public void commit() {
			// Update dirty linkages and update each diagram
			for(final DiagramReference dirtyDiagramReference : dirtyDiagramReferences) {
				updateDiagram(dirtyDiagramReference, new DiagramCallback() {
					@Override
					public void onDiagram(final Diagram diagram) {						
						// Update any dirty linkages stored for the diagram
						final IFeatureProvider fp = GraphitiUi.getExtensionManager().createFeatureProvider(diagram);
						if(fp != null) {
							final Map<Object, PictogramElement[]> dirtyLinkagesMap = diagramToDirtyLinkages.get(diagram);
							if(dirtyLinkagesMap != null) {
				    			for(final Entry<Object, PictogramElement[]> dirtyLinkagesEntry : dirtyLinkagesMap.entrySet()) {
				    				final Object bo = dirtyLinkagesEntry.getKey();
				    				for(final PictogramElement pe : dirtyLinkagesEntry.getValue()) {
				    					fp.link(pe, bo);
				    				}
				    			}
							}
						}
					}    					
				});				
			}
			
			diagramToDirtyLinkages.clear();
			dirtyDiagramReferences.clear();
		}

		private void updateDiagram(final DiagramReference diagramReference, final DiagramCallback cb) {
			final Diagram diagram = diagramReference.getDiagram();
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
					
					if(diagramReference.isOpen()) {
						diagramReference.getEditor().updateDiagramWhenVisible();
					}
				}			
			});						
			
			// Only save the diagram if it is not open. Otherwise, the user can save the diagram using the editor
			if(!diagramReference.isOpen()) {
				// Save the resource
				try {
					// TODO: Save through the editor instead of saving the resource. Actually.. Would be better to update the saved resource and update the 
					// open diagram in memory. The user may not want to save at this point.
					//TODO:Migrate!
					resource.save(null);
				} catch (IOException e) {
					throw new RuntimeException("Error saving new diagram", e);
				}
			}
			
			// Dispose of the editing domain if we created it
			if(editingDomainCreated) {
				editingDomain.getCommandStack().flush();
				editingDomain.dispose();
			}
    	}
	}
}

