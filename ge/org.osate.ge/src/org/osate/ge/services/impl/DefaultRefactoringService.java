package org.osate.ge.services.impl;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.RefactoringService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.ui.util.SelectionHelper;

public class DefaultRefactoringService implements RefactoringService {
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	
	public DefaultRefactoringService(final AadlModificationService aadlModService, DiagramModificationService diagramModService) {
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
	}
	
	public void renameElement(NamedElement ne, final String newName) {
		if(ne instanceof Classifier) {
			renameClassifier((Classifier)ne, newName);
		} else {
	    	aadlModService.modify(ne, new AbstractModifier<NamedElement, Object>() {
	    		private DiagramModificationService.Modification diagramMod;    		
	     		
	     		@Override
	    		public Object modify(final Resource resource, final NamedElement ne) {
	     			// Resolving allows the name change to propagate when editing without an Xtext document
	     			EcoreUtil.resolveAll(resource.getResourceSet());
	
	     			// Start the diagram modification
	     			diagramMod = diagramModService.startModification();
	     			 			
	     			// Update References
	     			updateReferences(ne, resource.getResourceSet(), diagramMod);
	     			
	     			// Mark linkages to the element as dirty 			
	     			diagramMod.markOpenLinkagesAsDirty(ne);
	     			
	     			// Set the element's name
	    			ne.setName(newName); 			
	    			
	    			return null;
	    		}	
	
	     		@Override
	    		public void beforeCommit(final Resource resource, final NamedElement ne, final Object modificationResult) {
	    			diagramMod.commit();
	    		}
	     	});
		}
    }
	
	// Special implementation of renaming functionality for Classifiers.
	private void renameClassifier(final Classifier classifier, final String newName) {
		aadlModService.modify(classifier, new AbstractModifier<Classifier, Object>() {
			private DiagramModificationService.Modification diagramMod;					
			
			@Override
			public Object modify(final Resource resource, final Classifier classifier) {		
				// Resolving allows the name change to propagate when editing without an Xtext document
				EcoreUtil.resolveAll(resource.getResourceSet());

				// Find diagrams that links to this classifier
				diagramMod = diagramModService.startModification();
				diagramMod.markLinkagesAsDirty(classifier);
				markLinkagesToOwnedMembersAsDirty(classifier, diagramMod);
				
				// Set the name
				classifier.setName(newName);
				
				// Special handling of renaming component implementations. Need to set the type so that they will update appropriately in all cases.
				if(classifier instanceof ComponentImplementation) {
					final ComponentImplementation ci = (ComponentImplementation)classifier;
					final String typeName = newName.split("\\.")[0];
					for(final NamedElement member : ci.getNamespace().getMembers()) {
						if(typeName.equalsIgnoreCase(member.getName())) {
							// Handle renames
							if(member instanceof ComponentTypeRename) {
								final ComponentTypeRename ctr = (ComponentTypeRename) member;
								if(ctr.getRenamedComponentType() != null) {
									ci.setType(ctr.getRenamedComponentType());
								}
							}
							
							// Component Types
							if(member instanceof ComponentType) {
								ci.setType((ComponentType)member);
							}
							break;
						}
						
					}
				}
				
				// Update References
     			updateReferences(classifier, resource.getResourceSet(), diagramMod);
				
				return null;
			}
			
			@Override
			public void afterCommit(final Resource resource, final Classifier classifier, final Object modificationResult) {
				// Build the project so that the index will be updated
				// This was formerly part of DefaultAadlModificationService but it causes deadlock under certain circumstances(renaming features).
				final IProject project = SelectionHelper.getProject(resource);
				try {
					project.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
				} catch(CoreException ex) {
					final Status status = new Status(IStatus.ERROR, Activator.getPluginId(), "An error building the AADL project after a graphical modification.", ex);
					StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				} catch(RuntimeException ex) {
					final Status status = new Status(IStatus.ERROR, Activator.getPluginId(), "An error building the AADL project after a graphical modification.", ex);
					StatusManager.getManager().handle(status, StatusManager.SHOW | StatusManager.LOG);
				}
				
				// Commit the diagram changes after the commit because the EMF index needs to be updated before the diagram can be
				diagramMod.commit();
				diagramMod = null;
			}	
		});
	}
	
	/**
	 * A specialized version of UsageCrossReferencer. Ignores derived references. Created to avoid an exception caused by trying to find references to subprogram calls.
	 * @author philip.alldredge
	 *
	 */
	@SuppressWarnings("serial")
	private static class AgeUsageCrossReferencer extends UsageCrossReferencer {
		protected AgeUsageCrossReferencer(ResourceSet resourceSet) {
			super(resourceSet);
		}
		
		public static Collection<EStructuralFeature.Setting> find(EObject eObjectOfInterest, ResourceSet resourceSet)
	    {
			return new AgeUsageCrossReferencer(resourceSet).findUsage(eObjectOfInterest);
	    }
		
		@Override
		protected void add(InternalEObject eObject, EReference eReference, EObject crossReferencedEObject)
	    {
			if(!eReference.isDerived()) {
				getCollection(crossReferencedEObject).add(eObject.eSetting(eReference));
			}
	    }
		
	};
	
	private void updateReferences(final NamedElement ne, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
		for(final Setting s : AgeUsageCrossReferencer.find(ne, resourceSet)) {
			final EStructuralFeature sf = s.getEStructuralFeature();
			if(!sf.isDerived() && sf.isChangeable()) {
				if(ne instanceof Feature || ne instanceof InternalFeature || ne instanceof ProcessorFeature) {
	 				updateFeatureReference(ne, s, resourceSet, diagramMod);
	 			} else if(ne instanceof Mode) {
	 				updateModeReference((Mode)ne, s, resourceSet, diagramMod);
	 			} else if(ne instanceof Connection) {
	 				updateConnectionReference((Connection)ne, s, resourceSet, diagramMod);
	 			} else if(ne instanceof Subcomponent) {
	 				updateSubcomponentReference((Subcomponent)ne, s, resourceSet, diagramMod);
	 			} else if(ne instanceof FlowSpecification) {
	 				updateFlowSpecificationReference((FlowSpecification)ne, s, resourceSet, diagramMod);
	 			} else if(ne instanceof Classifier) {
	 				updateClassifierReference((Classifier)ne, s, resourceSet, diagramMod);
	 			} else if(ne instanceof SubprogramCall) {
	 				updateSubprogramCallReference((SubprogramCall)ne, s, resourceSet, diagramMod);
	 			}
			
				updateNamedElementReference(ne, s, resourceSet, diagramMod);
			}
		}
	}     		
		
	// Updates references that are shared between all named elements
	private void updateNamedElementReference(final NamedElement ne, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
		final EObject obj = setting.getEObject();
		
		// Check for references from ContainmentPathElements used by things like property associations.
		if(obj instanceof ContainmentPathElement) {
			final ContainmentPathElement pathEl = (ContainmentPathElement) obj;
			if(pathEl.getNamedElement() == ne) {
				pathEl.setNamedElement(null);
				pathEl.setNamedElement(ne);
			}     				
		}
	}
	
	/**
	 * Recursive method that updates references to the feature. It recursively updates refinees.
	 * @param feature
	 * @param resourceSet
	 */
    private void updateFeatureReference(final NamedElement feature, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
    	final EObject obj = setting.getEObject();
		// Mark linkages to refinements as dirty
		if(feature instanceof Feature && obj instanceof Feature && ((Feature)obj).getRefined() == feature) {
			final Feature refinee = (Feature)obj;			
			diagramMod.markOpenLinkagesAsDirty(refinee);
			
			// Set the refined element to null and then set it again to trigger the change 
			refinee.setRefined(null);
			refinee.setRefined((Feature)feature);
			
			updateReferences(refinee, resourceSet, diagramMod);
		} else if(obj instanceof ConnectedElement) {
			final ConnectedElement connectedElement = (ConnectedElement)obj;
			if(connectedElement.getConnectionEnd() == feature) {
				// Reset the connection end. This will trigger and update by xtext
				connectedElement.setConnectionEnd(null);
				connectedElement.setConnectionEnd((ConnectionEnd)feature);							
			} 
		} else if(obj instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger)obj;
			if(mtt.getTriggerPort() == feature) {
				// Reset the port. This will trigger and update by xtext
				mtt.setTriggerPort(null);
				mtt.setTriggerPort((TriggerPort)feature);							
			} 
		} else if(obj instanceof FlowEnd) {
			final FlowEnd fe = (FlowEnd)obj;
			if(feature instanceof Feature && fe.getFeature() == feature) {
				// Reset the feature. This will trigger and update by xtext
				fe.setFeature(null);
				fe.setFeature((Feature)feature);
			}
			
			// Flow Implementations do not have a reference to the feature but rather to the flow specification. Trigger an update.
			if(fe.getOwner() instanceof FlowSpecification) {
				final FlowSpecification flowSpec = (FlowSpecification)fe.getOwner();
				updateReferences(flowSpec, resourceSet, diagramMod);
			}
		} else if(obj instanceof FlowSegment && obj instanceof FlowElement) {
			final FlowSegment fs = (FlowSegment)obj;
			if(fs.getFlowElement() == feature) {
				// Reset the flow element. This will trigger and update by xtext
				fs.setFlowElement(null);
				fs.setFlowElement((FlowElement)feature);							
			}
		}
    }
	    
   /**
	 * Recursive method that updates refinees as dirty and ensures that the source is regenerated with the name of the refined element
	 * @param element
	 * @param resourceSet
	 */
    private void updateConnectionReference(final org.osate.aadl2.Connection element, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
	final EObject obj = setting.getEObject();
		// Mark linkages to refinements as dirty
		if(obj instanceof org.osate.aadl2.Connection && ((org.osate.aadl2.Connection)obj).getRefined() == element) {
			final org.osate.aadl2.Connection refinee = (org.osate.aadl2.Connection)obj;
			
			diagramMod.markOpenLinkagesAsDirty(refinee);
			
			// Set the refined element to null and then set it again to trigger the change 
			refinee.setRefined(null);
			refinee.setRefined(element);
			
			updateReferences(refinee, resourceSet, diagramMod);
		} else if(obj instanceof FlowSegment) {
			final FlowSegment fs = (FlowSegment)obj;
			if(fs.getFlowElement() == element) {
				// Reset the flow element. This will trigger and update by xtext
				fs.setFlowElement(null);
				fs.setFlowElement(element);							
			}
		} else if(obj instanceof EndToEndFlowSegment) {
			final EndToEndFlowSegment fs = (EndToEndFlowSegment)obj;
			if(fs.getFlowElement() == element) {
				// Reset the flow element. This will trigger and update by xtext
				fs.setFlowElement(null);
				fs.setFlowElement(element);							
			}
		}
	    }
					
	private void updateModeReference(final Mode mode, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
		final EObject obj = setting.getEObject();
		
		// Check the mode source and destination
		if(obj instanceof ModeTransition) {
			final ModeTransition mt = (ModeTransition)obj;
			if(mt.getSource() == mode) {
				mt.setSource(null);
				mt.setSource(mode);
			}
			
			if(mt.getDestination() == mode) {
				mt.setDestination(null);
				mt.setDestination(mode);
			}
		}
	}

    private void updateSubcomponentReference(final Subcomponent element, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
    	final EObject obj = setting.getEObject();
		// Mark linkages to refinements as dirty
		if(obj instanceof Subcomponent && ((Subcomponent)obj).getRefined() == element) {
			final Subcomponent refinee = (Subcomponent)obj;
			
			diagramMod.markOpenLinkagesAsDirty(refinee);
			
			// Set the refined element to null and then set it again to trigger the change 
			refinee.setRefined(null);
			refinee.setRefined(element);
			
			updateReferences(refinee, resourceSet, diagramMod);
		}
		else if(obj instanceof ConnectedElement) {
			final ConnectedElement connectedElement = (ConnectedElement)obj;
			if(connectedElement.getContext() == element) {
				// Reset the context. This will trigger and update by xtext
				connectedElement.setContext(null);
				connectedElement.setContext(element);							
			}
		} else if(obj instanceof FlowSegment) {
			final FlowSegment fs = (FlowSegment)obj;
			if(fs.getContext() == element) {
				// Reset the context. This will trigger and update by xtext
				fs.setContext(null);
				fs.setContext(element);							
			}
		} else if(obj instanceof EndToEndFlowSegment) {
			final EndToEndFlowSegment fs = (EndToEndFlowSegment)obj;
			if(fs.getContext() == element) {
				// Reset the context. This will trigger and update by xtext
				fs.setContext(null);
				fs.setContext(element);							
			}
		} else if(obj instanceof ModeTransitionTrigger) {
			final ModeTransitionTrigger mtt = (ModeTransitionTrigger)obj;
			if(mtt.getContext() == element) {
				// Reset the context. This will trigger and update by xtext
				mtt.setContext(null);
				mtt.setContext(element);							
			}
		}
    }
    
	private void updateFlowSpecificationReference(final FlowSpecification flowSpec, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
		// Look for flow implementations
		final EObject obj = setting.getEObject();
		if(obj instanceof FlowImplementation) {
			final FlowImplementation fi = (FlowImplementation)obj;
			if(fi.getSpecification() == flowSpec) {
				fi.setSpecification(null);
				fi.setSpecification(flowSpec);
			}
		}
	}
	
	private void updateClassifierReference(final Classifier classifier, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
		// Check for cross references and update them
		// The extension changes are only needed when editing using an xtext document
		// Other changes are needed in all cases
		final EObject obj = setting.getEObject();
		if(obj instanceof TypeExtension) {
			final TypeExtension extension = (TypeExtension)obj;
			if(classifier == extension.getExtended()) {
				((ComponentType)extension.getSpecific()).createOwnedExtension().setExtended((ComponentType) classifier);
			}
		} else if(obj instanceof ImplementationExtension) {
			final ImplementationExtension extension = (ImplementationExtension)obj;
			if(classifier == extension.getExtended()) {
				((ComponentImplementation)extension.getSpecific()).createOwnedExtension().setExtended((ComponentImplementation)classifier);
			}
		} else if(obj instanceof GroupExtension) {
			final GroupExtension extension = (GroupExtension)obj;
			if(classifier == extension.getExtended()) {
				((FeatureGroupType)extension.getSpecific()).createOwnedExtension().setExtended((FeatureGroupType) classifier);
			}
		} else if(obj instanceof Realization && classifier instanceof ComponentType) {
			final Realization realization = (Realization)obj;
			final ComponentImplementation ci = (ComponentImplementation)realization.getSpecific();
			if(ci.getName() != null) {
				final String[] segs = ci.getName().split("\\.");
				if(segs.length == 2) {
					diagramMod.markOpenLinkagesAsDirty(ci);
					markOpenLinkagesToOwnedMembersAsDirty(ci, diagramMod);
					
					// Set the name
					ci.setName(classifier.getName() + "." + segs[1]);
				}
			}			
		} else if(obj instanceof ClassifierValue) { // ClassifierValue are used in property associations
			final ClassifierValue cv = (ClassifierValue)obj;
			if(cv.getClassifier() == classifier) {
				cv.setClassifier(null);
				cv.setClassifier(classifier);
			}
		}
	}
	
	private void updateSubprogramCallReference(final SubprogramCall call, final Setting setting, final ResourceSet resourceSet, final DiagramModificationService.Modification diagramMod) {
    	final EObject obj = setting.getEObject();
    	if(obj instanceof ConnectedElement) {
			final ConnectedElement connectedElement = (ConnectedElement)obj;
			if(connectedElement.getContext() == call) {
				// Reset the the context. This will trigger an update by xtext
				connectedElement.setContext(null);
				connectedElement.setContext(call);							
			}
    	}
	}
	
	private void markLinkagesToOwnedMembersAsDirty(final Namespace ns, final DiagramModificationService.Modification diagramMod) {
		for(final NamedElement member : ns.getOwnedMembers()) {
			diagramMod.markLinkagesAsDirty(member);
		}				
	}
	
	private void markOpenLinkagesToOwnedMembersAsDirty(final Namespace ns, final DiagramModificationService.Modification diagramMod) {
		for(final NamedElement member : ns.getOwnedMembers()) {
			diagramMod.markOpenLinkagesAsDirty(member);
		}				
	}
}
