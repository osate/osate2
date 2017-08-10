package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.ge.internal.query.Queryable;

/**
 * This class is intended to retrieve all property associations associated with a Queryable.
 * Upon instantiation, it processes all contained property associations contained in the Queryable tree's business objects or in related classifiers. 
 * It associates processed associations with the Queryable cloeest to the element which it applies. 
 * This is useful in the case of finding property associations which may reference queryables which are in the queryable tree.
 * Local non-contained property associations which belong to elements which are not in the queryable tree will not be processed.
 * 
 * Caveat: This class relies on OSATE's PropertyAcc class to handle local property associations which does not support binding specific property associations
 * at this time. If a property contains property associations for multiple bindings, only the first one will be processed. 
 */
public class AadlPropertyResolver {
	private final Map<Queryable, PropertyNode> propertyNodeMap = new HashMap<>();
		
	/**
	 * A ProcessedPropertyAssociation is a property association whose applied to clause has been processed. 
	 * Each path specified in the applied to clause results in a new ProcessedPropertyAssociation. If no applied to clause exists,
	 * then only one ProcessedPropertyAssociation is created.  
	 * A ProcessedPropertyAssociation may have unprocessed applied to path elements. Such path elements refer to elements that do not exist in the Queryable tree.
	 */
	public static class ProcessedPropertyAssociation {
		public final PropertyAssociation propertyAssociation; // Property Association
		public final List<ContainmentPathElement> appliedToPathElements; // ContainedNamedElement - AppliesTo
		public final int processedAppliedToPathElements; // Count of number of ContainmentPathElement processed in the applies to
		
		public ProcessedPropertyAssociation(final PropertyAssociation propertyAssociation,
				final List<ContainmentPathElement> appliedToPathElements,
				final int processedAppliedToPathElements) {
			this.propertyAssociation = Objects.requireNonNull(propertyAssociation, "propertyAssociation must not be null");
			this.appliedToPathElements = Objects.requireNonNull(appliedToPathElements, "appliedToPathElements must not be null");
			this.processedAppliedToPathElements = processedAppliedToPathElements;
		}
		
		public boolean isCompletelyProcessed() {
			return appliedToPathElements.size() == processedAppliedToPathElements;
		}
		
		public List<ContainmentPathElement> getUnprocessedPathElements() {
			return appliedToPathElements.subList(processedAppliedToPathElements, appliedToPathElements.size());
		}
		
		public boolean hasArrayIndices() {
			for(final ContainmentPathElement e: appliedToPathElements) {
				if(e.getArrayRanges() != null && e.getArrayRanges().size() > 0) {
					return true;
				}
			}
			
			return false;
		}
		
		public boolean isBindingSpecific() {
			return propertyAssociation.getInBindings() != null && propertyAssociation.getInBindings().size() > 0;
		}
		
		public boolean isModal() {
			for(final ModalPropertyValue mpv : propertyAssociation.getOwnedValues()) {
				if(mpv.getInModes() != null && mpv.getInModes().size() > 0) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * Contains processed property associations for a specific Queryable. 
	 *
	 */
	private static class ProcessedPropertyAssociationCollection {
		List<ProcessedPropertyAssociation> processedPropertyAssociations = new ArrayList<>();
		boolean includesLocalProperties = false;
	}
	
	private static class PropertyNode {
		ProcessedPropertyAssociationCollection getCreateProcessedPropertyAssociations(final Property property) {
			ProcessedPropertyAssociationCollection result = propertyNameToProcessedPropertyAssociationsMap.get(property);
			if(result == null) {
				result = new ProcessedPropertyAssociationCollection();
				propertyNameToProcessedPropertyAssociationsMap.put(property, result);
			}
			return result;
		}
		
		private final Map<Property, ProcessedPropertyAssociationCollection> propertyNameToProcessedPropertyAssociationsMap = new HashMap<>(); // Maping from property to Processed Property Association List
	}
	
	public AadlPropertyResolver(final Queryable topContext) {
		// Process Contained Property Associations
		if(topContext.getBusinessObject() instanceof Classifier) {
			processContainedPropertyAssociations(topContext, (Classifier)topContext.getBusinessObject());
		} else {
			processContainedPropertyAssociationsInChildren(topContext);				
		}
	}
		
	private void processContainedPropertyAssociationsInChildren(final Queryable q) {
		// Process contained property associations contained in children
		for(final Queryable childQueryable : q.getChildren()) {
			final Object childBo = childQueryable.getBusinessObject();
			if(!(childBo instanceof InstanceObject)) { // Don't process instance objects
				if(childBo instanceof Subcomponent || childBo instanceof FeatureGroup) {
					final NamedElement childNamedElement = (NamedElement)childBo;
					
					// Handle refinements
					RefinableElement tmpRefinable = (RefinableElement)childNamedElement;
					do {
						processContainedPropertyAssociations(childQueryable, tmpRefinable.getOwnedPropertyAssociations());
						tmpRefinable = tmpRefinable.getRefinedElement();
					} while(tmpRefinable != null);
					
					// Process contained property associations contained in the element's classifier
					if(childBo instanceof FeatureGroup) {
						final FeatureGroupType featureGroupType = AadlPrototypeUtil.getFeatureGroupType(AadlPrototypeUtil.getPrototypeBindingContext(childQueryable), (FeatureGroup)childBo);
						if(featureGroupType != null) {
							processContainedPropertyAssociations(childQueryable, featureGroupType);
						}
					} else if(childBo instanceof Subcomponent) {
						final Classifier subcomponentClassifier = AadlPrototypeUtil.getComponentClassifier(AadlPrototypeUtil.getPrototypeBindingContext(childQueryable), (Subcomponent)childBo);
						if(subcomponentClassifier != null) {
							processContainedPropertyAssociations(childQueryable, subcomponentClassifier);
						}
					}	
				} else if(childBo instanceof Classifier) {
					processContainedPropertyAssociations(childQueryable, ((Classifier)childBo));
				} else if(childBo instanceof AadlPackage) {
					processContainedPropertyAssociationsInChildren(childQueryable);
				}
			}
		}
	}
	
	/**
	 * Returns a list of processed property associations for a specific Queryable and property. The property associations order in the list
	 * will be such that elements earlier in the list should override elements later in the list.
	 * @param q
	 * @param property
	 * @return
	 */
	public final List<ProcessedPropertyAssociation> getProcessedPropertyAssociations(final Queryable q, final Property property) {
		final PropertyNode pn = getOrCreatePropertyNode(q);

		final ProcessedPropertyAssociationCollection ppas = pn.getCreateProcessedPropertyAssociations(property);
		
		// Add local property associations to the collection if it does not include them already.
		if(!ppas.includesLocalProperties) {
			final Object bo = q.getBusinessObject();
			if(bo instanceof NamedElement) {
				final NamedElement ne = (NamedElement)bo;
				final PropertyAcc pas = new PropertyAcc(property);
				ne.getPropertyValueInternal(property, pas, true);
				
				if(pas.getAssociations().size() > 0) {
					for(final PropertyAssociation localPa : pas.getAssociations()) {
						// Only process property associations without applies to. That should be the only kind contained in the PropertyAcc's list but
						// we check just to make sure. Property associations with applies to are contained property associations and have already been
						// processed
						if(localPa.getAppliesTos().size() == 0) {				
							ppas.processedPropertyAssociations.add(new ProcessedPropertyAssociation(localPa, Collections.emptyList(), 0));
						}
					}
				}
			}
			
			ppas.includesLocalProperties = true;
		}
		
		return ppas == null || ppas.processedPropertyAssociations == null ? Collections.emptyList() : Collections.unmodifiableList(ppas.processedPropertyAssociations);
	}
	
	private PropertyNode getOrCreatePropertyNode(final Queryable q) {
		Objects.requireNonNull(q, "q must not be null");
		
		// Get/Create the property node
		PropertyNode pn = propertyNodeMap.get(q);
		if(pn == null) {
			pn = new PropertyNode();
			propertyNodeMap.put(q, pn);
		}
		
		return pn;
	}
	
	private void processContainedPropertyAssociations(final Queryable q, final Classifier classifier) {
		// Process classifiers in the appropriate order while only processing elements that are included in the queryable tree.
		for(final Classifier tmpClassifier : classifier.getSelfPlusAllExtended()) {
			// Process the classifier's property associations
			processContainedPropertyAssociations(q, tmpClassifier.getOwnedPropertyAssociations());
		}

		processContainedPropertyAssociationsInChildren(q);
	}
	
	private void processContainedPropertyAssociations(final Queryable q, final List<PropertyAssociation> propertyAssociations) {
		for(final PropertyAssociation pa : propertyAssociations) {
			// Only process contained property associations
			if(pa.getAppliesTos().size() > 0) {
				if(pa.getProperty() == null) {
					continue;
				}
				
				// Find the queryable for each contained named element 
				for(final ContainedNamedElement cne : pa.getAppliesTos()) {
					// Try to find the queryable being referenced
					Queryable appliedToQueryable = q;
					final List<ContainmentPathElement> containmentPathElements = cne.getContainmentPathElements();
					int containmentPathElementIndex;
					for(containmentPathElementIndex = 0; containmentPathElementIndex < containmentPathElements.size(); containmentPathElementIndex++) {
						final ContainmentPathElement pathElement = containmentPathElements.get(containmentPathElementIndex);
						if(pathElement.getAnnexName() != null)  {
							break;
						}
						
						Queryable next = null;
						final String pathElementName = pathElement.getNamedElement().getName();
						if(pathElementName != null) {
							for(final Queryable child : appliedToQueryable.getChildren()) {
								final Object childBo = child.getBusinessObject();
								if(childBo instanceof NamedElement) {
									final NamedElement childNamedElement = (NamedElement)childBo;
									final String childName = childNamedElement.getName();
									if(childName != null) {
										if(pathElementName.equalsIgnoreCase(childName)) {
											next = child;
											break;
										}
									}
								}
							}
						}
						
						if(next == null) {
							break;
						}
						
						appliedToQueryable = next;
					}
					
					// Create and add the processed property association
					final PropertyNode pn = getOrCreatePropertyNode(appliedToQueryable);
					final ProcessedPropertyAssociationCollection ppas = pn.getCreateProcessedPropertyAssociations(pa.getProperty());
					ppas.processedPropertyAssociations.add(new ProcessedPropertyAssociation(pa, containmentPathElements, containmentPathElementIndex));
				}
			}
		}
	}
}
