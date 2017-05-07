package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.ge.internal.query.Queryable;
import org.osate.xtext.aadl2.properties.util.GetProperties;

// TODO: Write code to get the actual property value. 
// Handle lists
// Handle inherit
// Handle constant?
// Return for various modes and arrays.
// Only plan to create graphics when not-modal, binding, or array specific? Will need indicator for such cases to notify the user that properties exist but aren't shown.
//   Could graphically represent modal properties.
//   Would want to highlight? Could be difficult. Keep it simple.
//   Could add text to indicate arrays to.
//           Example: Period => 20 applies to [0..1]
//      Connections would be different. Wouldn need to merge/fix for multiple properties with overlapping ranges...
// Don't worry about tooltips for now.

// The AadlPropertyResolver helps find relevant property associations
// It internally processes contained property associations for a queryable tree. 
// This allows it to retrieve property associations related to a processed queryable. In this case it will return property associations which have
// been applied to the queryable as well as contained property associations which reference descendants of the queryable.
// This is useful in the case of finding property associations which may reference queryables which are in the queryable tree.
// Local non-contained property associations which belong to elements which are not in the queryable tree will not be processed.
public class AadlPropertyResolver {
	private final Map<Queryable, PropertyNode> propertyNodeMap = new HashMap<>();
	
	// TODO: Rename
	private static class PropertyResult {
		// TODO: Make final?
		public boolean isModal;
		public boolean isBindingSpecific;
		public boolean hasArrayIndices;
		public Object value;
	}
	
	// TODO: Rename and move. Could be placed outside of this class entirely?
	public static PropertyResult resolveProperty(AadlPropertyResolver qr, final Queryable q, final Property p) {
		boolean anyHaveArrayIndices = false;
		boolean anyAreBindingSpecific = false;
		boolean anyAreModal = false;
		
		// TODO
		for(ProcessedPropertyAssociation ppa : qr.getProcessedPropertyAssociations(q, p)) {
			//TODO: Decide how to handle things.. Don't want to call functional needlessly but want to collect appropriate info..
			/*
			final boolean hasArrayIndices = ppa.hasArrayIndices();
			final boolean isBindingSpecific = ppa.isBindingSpecific();
			final boolean isModal = ppa.isModal();
			*/
					
			if(!anyHaveArrayIndices && ppa.hasArrayIndices()) {
				anyHaveArrayIndices = true;
			}
			
			if(!anyAreBindingSpecific && ppa.isBindingSpecific()) {
				anyAreBindingSpecific = true;
			}
			
			if(!anyAreModal && ppa.isModal()) {
				anyAreModal = true;
			}
		}
		
		// TODO: Calculate value
		
		return null;
	}
	
	// TODO: Use when resolving. Could be separate class?
	private static class PropertyValue {
		boolean finalized = false;
		Object value;
	}
		
	// TODO: Rename
	// TODO: Contains information for a specific queryable 
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
				if(mpv.getInModes().size() > 0) {
					return true;
				}
			}
			
			return false;
		}
	}
	
	// TODO: Rename
	// Contained processed property associations for a specific queryable/property combination
	public static class ProcessedPropertyAssociationCollection {
		List<ProcessedPropertyAssociation> processedPropertyAssociations = new ArrayList<>();
		boolean includesLocalProperties = false;
	}
	
	public static class PropertyNode {
		// TODO: Rename?
		ProcessedPropertyAssociationCollection getProcessedPropertyAssociations(final Property property) {
			return propertyNameToProcessedPropertyAssociationsMap.get(property);
		}

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
		// Process contained property associations contained in subcomponents and features
		for(final Queryable childQueryable : q.getChildren()) {
			// TODO: Handle other components besides subcomponents
			final Object childBo = childQueryable.getBusinessObject();
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
	
	// TODO: This could be part of property node if property node stored the queryable?
	public final List<ProcessedPropertyAssociation> getProcessedPropertyAssociations(final Queryable q, final Property property) {
		final PropertyNode pn = getOrCreatePropertyNode(q);

		ProcessedPropertyAssociationCollection ppas = pn.getCreateProcessedPropertyAssociations(property);
		if(!ppas.includesLocalProperties) {
			// TODO: Add additional property associations if it hasn't been compled yet
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
	
	// TODO: Determine why the property association isn't being found
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
	
	/**
	 * Finds the queryable referenced by a contained name element. Uses the names of the path element
	 * @param q
	 * @param containedNamedElement
	 * @return
	 */
	// TODO: Need to handle not being able to completely resolve the path.
 	private Queryable getReferencedQueryable(final Queryable q, final ContainedNamedElement containedNamedElement) { 		
 		Queryable tmp = q;
		for(final ContainmentPathElement pathElement : containedNamedElement.getContainmentPathElements()) {
			// TODO: Support annexes and support array ranges.
			if(pathElement.getAnnexName() != null || (pathElement.getArrayRanges() != null && pathElement.getArrayRanges().size() > 0))  {
				return null;
			}
			
			Queryable next = null;
			final String pathElementName = pathElement.getNamedElement().getName();
			if(pathElementName != null) {
				for(final Queryable child : tmp.getChildren()) {
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
				return null;
			}
			
			tmp = next;
		}

		return tmp;
	}
	
	// TODO: Rework. Rename. Generalize
	private void processBinding(final PropertyAssociation pa, final Object paCtx) {
		// TODO: Check if already finalized
		//if(boundPictogramElement != null && !bindingTracker.isPictogramElementFinalized(boundPictogramElement)) {			
			// in the typical case(property association only applies to one object?)
			// Find referenced shapes			
			for(final ModalPropertyValue pv : pa.getOwnedValues()) {
				//final Object convertedValue = convertValue(pv.getOwnedValue());
				
				//if(convertedValue instanceof List) {
					// Iterate backwards so we can prepend bindings properly.
					/*
					for(int i = listPropExpressions.size() - 1; i >= 0; i--) {
						final PropertyExpression listPropExpression = listPropExpressions.get(i);
						if(listPropExpression instanceof ReferenceValue) {
							final ReferenceValue referenceValue = (ReferenceValue)listPropExpression;
							//final PictogramElement referencedPictogramElement = getReferencedPictogramElement(propAssocCtxShape, referenceValue);
							//bindingTracker.prependBinding(boundPictogramElement, referencedPictogramElement);
						}
					}
					*/
				//}
			}
			
			// Finalize the shape
			if(!pa.isAppend()) {
				// TODO
				//bindingTracker.finalizePictogramElement(boundPictogramElement);
			}
		//}
	}
	
	
	/*
	public Object getValue(final Queryable queryable, final String propertyQualifiedName) {
		
		if(!isBusinessObjectSupportedNamedElement(queryable.getBusinessObject())) {
			return null;
		}
		
		// Retrieve value from stored values
		final Map<String, PropertyValue> m = propertyValueMap.get(queryable);
		final PropertyValue propertyValue;
		if(m == null) {
			propertyValue = null;
		} else {
			propertyValue = m.get(propertyQualifiedName.toLowerCase());
		}
		
		if(propertyValue == null) {
			// Return the default value
			final Property p = GetProperties.lookupPropertyDefinition((NamedElement)queryable.getBusinessObject(), propertyQualifiedName);
			if(p == null) {
				return null;
			}
			
			// TODO: Convert default value to something useful
			return convertValue(p.getDefaultValue());
		}
		
		return propertyValue.value;
		
		return null;
	}

	private Object convertValue(final PropertyExpression propertyExpression) {
		if(propertyExpression == null) {
			return null;
		}
		
		if(propertyExpression instanceof ListValue) {
			// Convert the ListValue to a java list
			final ListValue lv = (ListValue)propertyExpression;
			final List<Object> convertedList = new ArrayList<>();
			for(final PropertyExpression innerExpression : lv.getOwnedListElements()) {
				final Object innerValue = convertValue(innerExpression);
				if(innerValue != null) {
					convertedList.add(innerValue);
				}
			}
			
			return convertedList;
		} else if(propertyExpression instanceof ReferenceValue) {
			// TODO: Resolve reference? Keep in mind that the referenced value may not be in the business object tree... How to store?
			// Need to return the ReferenceValue as well as a Queryable to provide context... Or return the path relative to something... 
			return null;
		} else {
			return propertyExpression;
		}
	}
	*/
}
