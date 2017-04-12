package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
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
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.graphiti.services.GraphitiService;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.CachingService;
import org.osate.ge.internal.services.CachingService.Cache;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;

// TODO: Properly implement "inherit" and "constant" keyword support
public class AadlPropertyResolver {
	private final Map<Queryable, Map<String, PropertyValue>> propertyValueMap = new HashMap<>();
	
	// TODO: Should property expression be stored or should it be resolved... PropertyExpression is useless without context for references, etc..
	
	private static class PropertyValue {
		boolean finalized = false;
		Object value;
	}
	
	public AadlPropertyResolver(final Queryable topContext) {
		// Populate data structure to allow resolving properties
		if(isBusinessObjectSupportedNamedElement(topContext.getBusinessObject())) {
			processNamedElementPropertyAssociations(topContext, (NamedElement)topContext.getBusinessObject());
		} else {
			processChildren(topContext);				
		}
	}
	
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
	
	private void processChildren(final Queryable q) {
		for(final Queryable child : q.getChildren()) {
			if(isBusinessObjectSupportedNamedElement(child.getBusinessObject())) {
				processNamedElementPropertyAssociations(child, (NamedElement)child.getBusinessObject());
			}
		}
	}
	
	private void processNamedElementPropertyAssociations(final Queryable q, final NamedElement ne) {
		// Special handling for classifiers
		if(ne instanceof Classifier) {
			processClassifierPropertyAssociations(q, (Classifier)ne);
		} else { // Default handling
			processPropertyAssociations(q, ne.getOwnedPropertyAssociations());	
			processChildren(q);
		}
	}

	private static void addClassifierChildMapping(final Map<Classifier, Map<NamedElement, Queryable>> classifierToDefinedBusinessObjectsMap, final Queryable q, final NamedElement ne) {
		final Element owner = ne.getOwner();
		if(owner instanceof Classifier) {
			final Classifier classifier = (Classifier)owner;
			Map<NamedElement, Queryable> definedBusinessObjectToDiagramElementMap = classifierToDefinedBusinessObjectsMap.get(classifier);
			
			// Create inner map if it doesn't exist
			if(definedBusinessObjectToDiagramElementMap == null) {
				definedBusinessObjectToDiagramElementMap = new HashMap<>();
				classifierToDefinedBusinessObjectsMap.put(classifier, definedBusinessObjectToDiagramElementMap);
			}
			
			definedBusinessObjectToDiagramElementMap.put(ne, q);
		}
	}
	
	private void processClassifierPropertyAssociations(final Queryable q, final Classifier classifier) {
		// Build a mapping between classifiers to a map of supported owned children to the corresponding diagram element. 
		// In cases where an element is refined, a single diagram element will appear multiple times.		
		// This mapping will be used to determine if a child is defined in both the classifier and included in the diagram.
		final Map<Classifier, Map<NamedElement, Queryable>> classifierToDefinedBusinessObjectsMap = new HashMap<>();
		for(final Queryable childQueryable : q.getChildren()) {
			final Object childBo = childQueryable.getBusinessObject();
			if(isBusinessObjectSupportedNamedElement(childBo)) {
				if(childBo instanceof RefinableElement) {
					NamedElement tmp = (NamedElement)childBo;
					do {
						addClassifierChildMapping(classifierToDefinedBusinessObjectsMap, childQueryable, tmp);
						tmp = ((RefinableElement)tmp).getRefinedElement();
					} while(tmp != null);
				} else {
					addClassifierChildMapping(classifierToDefinedBusinessObjectsMap, childQueryable, (NamedElement)childBo);
				}
			}
		}

		// Process classifiers in the appropriate order while only processing elements that are included in the diagram.
		for(final Classifier tmpClassifier : classifier.getSelfPlusAllExtended()) {
			final Map<NamedElement, Queryable> definedElements = classifierToDefinedBusinessObjectsMap.get(tmpClassifier);
			
			// Process children(Subcomponents, connections, features, etc) which are defined in this classifier. Could be refinements
			if(definedElements != null) {
				for(final Entry<NamedElement, Queryable> definedElementEntry : definedElements.entrySet()) {
					final NamedElement definedElement = definedElementEntry.getKey();
					final Queryable definedElementQueryable = definedElementEntry.getValue();
					processNamedElementPropertyAssociations(definedElementQueryable, definedElement);
				}
			}

			// Process the classifier's property associations
			processPropertyAssociations(q, classifier.getOwnedPropertyAssociations());
		}

		// Process the subcomponent's classifiers last.
		for(final Queryable childQueryable : q.getChildren()) {
			if(childQueryable.getBusinessObject() instanceof Subcomponent) {
				final Subcomponent sc = (Subcomponent)childQueryable.getBusinessObject();
				final Classifier subcomponentClassifier = AadlPrototypeUtil.getComponentClassifier(classifier, sc);
				if(subcomponentClassifier != null) {
					processClassifierPropertyAssociations(childQueryable, subcomponentClassifier);
				}
			}
		}
	}
	
	// TODO: Determine why the property association isn't being found
	private void processPropertyAssociations(final Queryable q, final List<PropertyAssociation> propertyAssociations) {
		for(final PropertyAssociation pa : propertyAssociations) {
			// Get the diagram element it applies to
			for(final Queryable referencedQueryable : getQueryableFromAppliesTo(q, pa.getAppliesTos())) {
				System.err.println(pa.getProperty().getQualifiedName());
				//System.err.println("REFERENCED: " + referencedQueryable + " : " + pa);
				// TODO: When storing references. Keep in mind that referenced object may not be in the diagram.. but the property value may need to be shown
				// How to show such references?
				// TODO: Process the property association
				//processBinding(bindingTracker, ctxShape, pa, ctxShape);				
			}
		}
	}
	
	private List<Queryable> getQueryableFromAppliesTo(final Queryable q, final List<ContainedNamedElement> appliesTo) {
		if(appliesTo.size() == 0) {
			return Collections.singletonList(q);
		}
		
		// Find the queryable for each contained named element 
		final ArrayList<Queryable> queryables = new ArrayList<>();
		for(final ContainedNamedElement cne : appliesTo) {
			final Queryable referencedQueryable = getReferencedQueryable(q, cne);
			if(referencedQueryable != null) {
				queryables.add(referencedQueryable);
			}
		}
		
		return queryables;
	}
	
	/**
	 * Finds the queryable referenced by a contained name element. Uses the names of the path element
	 * @param q
	 * @param containedNamedElement
	 * @return
	 */
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
				final Object convertedValue = convertValue(pv.getOwnedValue());
				
				if(convertedValue instanceof List) {
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
				}
			}
			
			// Finalize the shape
			if(!pa.isAppend()) {
				// TODO
				//bindingTracker.finalizePictogramElement(boundPictogramElement);
			}
		//}
	}
	
	/**
	 * Returns true if the bo is a named element and the property service should process the element when determining property values
	 * @param bo
	 * @return
	 */
	private boolean isBusinessObjectSupportedNamedElement(final Object bo) {
		return bo instanceof AadlPackage ||
				bo instanceof Classifier ||
				bo instanceof Feature ||
				bo instanceof Subcomponent ||
				bo instanceof Connection ||
				bo instanceof FlowSpecification ||
				bo instanceof FlowImplementation ||
				bo instanceof EndToEndFlow ||
				bo instanceof SubprogramCallSequence ||
				bo instanceof SubprogramCall ||
				bo instanceof Mode ||
				bo instanceof ModeTransition;
	}
}
