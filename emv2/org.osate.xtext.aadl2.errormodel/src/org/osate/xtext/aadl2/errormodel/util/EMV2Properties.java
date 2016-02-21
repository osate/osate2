package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class EMV2Properties {

	public static final String INVALID_OCCURRENCE_TYPE = "unknown_distribution";

	/**
	 * convert enumeration literals or integer values possibly assigned as property constant into String labels
	 * @param val PropertyExpression
	 * @returns String
	 */
	public static String getEnumerationOrIntegerPropertyConstantPropertyValue(PropertyExpression val) {
		// added code to handle integer value and use of property constant instead of enumeration literal
		if (val instanceof NamedValue) {
			AbstractNamedValue eval = ((NamedValue) val).getNamedValue();
			if (eval instanceof EnumerationLiteral) {
				return ((EnumerationLiteral) eval).getName();

			} else if (eval instanceof PropertyConstant) {
				return ((PropertyConstant) eval).getName();
			}
		} else if (val instanceof IntegerLiteral) {
			return "" + ((IntegerLiteral) val).getValue();
		}
		return "";
	}

	public static PropertyExpression getPropertyValue(PropertyAssociation pa) {
		if (pa != null) {
			for (ModalPropertyValue modalPropertyValue : pa.getOwnedValues()) {
				PropertyExpression val = modalPropertyValue.getOwnedValue();
				return val;
			}
		}
		return null;
	}

	/**
	 * retrieve the probability
	 * @param ci component instance, subcomponent, or classifier
	 * @param ne named element for which we retrieve the probability
	 * @param ts type set
	 * @return
	 */
	public static double getProbability(NamedElement ci, NamedElement ne, TypeSet ts) {
		PropertyAssociation PA = EMV2Properties.getOccurenceDistributionProperty(ci, ne, ts);
		double prob = 0;
		if (PA != null) {
			prob = EMV2Properties.getOccurenceValue(PA);
		}
		return prob;
	}

	/**
	 *
	 * @param element - the EMV2 element that refers to the artifact
	 * @param relatedComponent - the component (instance, subcomponent or classifier that have the property association
	 * @return - the text related to the description part of the hazards property. Null if not defined
	 */
	public static String getDescription(NamedElement element, NamedElement relatedComponent) {
		TypeSet ts = null;

		if (element instanceof ErrorBehaviorState) {
			ts = ((ErrorBehaviorState) element).getTypeSet();
		}

		if (element instanceof ErrorPropagation) {
			ts = ((ErrorPropagation) element).getTypeSet();
		}

		if (element instanceof ErrorEvent) {
			ts = ((ErrorEvent) element).getTypeSet();
		}

		PropertyAssociation PA = EMV2Properties.getHazardsProperty(relatedComponent, element, ts);

		if (PA == null) {
			return null;
		}
		// XXX TODO we may get more than one back, one each for different types
		for (ModalPropertyValue modalPropertyValue : PA.getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue) {
				RecordValue rv = (RecordValue) val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "description");
				if (xref != null) {
					PropertyExpression peVal = xref.getOwnedValue();
					if (peVal instanceof StringLiteral) {
						return ((StringLiteral) peVal).getValue();
					}
				}
			}
			if (val instanceof ListValue) {
				ListValue lv = (ListValue) val;
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					if (pe instanceof RecordValue) {
						RecordValue rv = (RecordValue) pe;
						EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
						BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "description");
						if (xref != null) {
							PropertyExpression peVal = xref.getOwnedValue();
							if (peVal instanceof StringLiteral) {
								return ((StringLiteral) peVal).getValue();
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 *
	 * @param element - the EMV2 element that referes to the artifact
	 * @param relatedComponent - the component the component (instance, subcomponent or classifier) that have the property association
	 * @return - the text related to the failure part of the hazards property. Null if not defined
	 */
	public static String getFailure(NamedElement element, NamedElement relatedComponent) {
		TypeSet ts = null;

		if (element instanceof ErrorBehaviorState) {
			ts = ((ErrorBehaviorState) element).getTypeSet();
		}

		if (element instanceof ErrorPropagation) {
			ts = ((ErrorPropagation) element).getTypeSet();
		}

		if (element instanceof ErrorEvent) {
			ts = ((ErrorEvent) element).getTypeSet();
		}

		PropertyAssociation PA = EMV2Properties.getHazardsProperty(relatedComponent, element, ts);

		if (PA == null) {
			return null;
		}
		// XXX TODO we may get more than one back, one each for different types
		for (ModalPropertyValue modalPropertyValue : PA.getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue) {
				RecordValue rv = (RecordValue) val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "failure");
				if (xref != null) {
					PropertyExpression peVal = xref.getOwnedValue();
					if (peVal instanceof StringLiteral) {
						return ((StringLiteral) peVal).getValue();
					}
				}
			}
			if (val instanceof ListValue) {
				ListValue lv = (ListValue) val;
				for (PropertyExpression pe : lv.getOwnedListElements()) {
					if (pe instanceof RecordValue) {
						RecordValue rv = (RecordValue) pe;
						EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
						BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "failure");
						if (xref != null) {
							PropertyExpression peVal = xref.getOwnedValue();
							if (peVal instanceof StringLiteral) {
								return ((StringLiteral) peVal).getValue();
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * retrieve the hazards property
	 * @param ci Component instance, subcomponent or classifier
	 * @param target target error model element
	 * @param ts TypeSet
	 * @return
	 */
	public static PropertyAssociation getHazardsProperty(NamedElement ci, Element target, TypeSet ts) {
		PropertyAssociation result = getProperty("EMV2::hazards", ci, target, ts);
		if (result == null) {
			result = getProperty("ARP4761::hazards", ci, target, ts);
		}
		if (result == null) {
			result = getProperty("MILSTD882::hazards", ci, target, ts);
		}
		return result;
	}

	/**
	 * Retrieve the value of the OccurenceDistribution property of the
	 * EMV2 property. You can use it like this:
	 * 	ContainedNamedElement PA = EM2Util.getOccurenceDistributionProperty(instance,null,ee,null);
	 * res = EM2Util.getOccurenceValue (PA);
	 *
	 * @see		Util
	 * @param 	ci				Component instance, subcomponent or classifier that contains the property
	 * @param target			the property
	 * @param ts				corresponding typeset or null
	 * @return
	 */
	public static PropertyAssociation getOccurenceDistributionProperty(NamedElement ci, NamedElement target,
			TypeSet ts) {
		PropertyAssociation result = getProperty("EMV2::OccurrenceDistribution", ci, target, ts);

		if (result == null) {
			ComponentCategory cat = null;
			if (ci instanceof ComponentInstance) {
				cat = ((ComponentInstance) ci).getComponentClassifier().getCategory();
				// processor binding for instances only
//			} else if (ci instanceof Subcomponent){
//				cat = ((Subcomponent)ci).getCategory();
//			} else if (ci instanceof ComponentClassifier){
//				cat = ((ComponentClassifier)ci).getCategory();
			} else {
				return result;
			}
			if ((cat == ComponentCategory.PROCESS) || (cat == ComponentCategory.ABSTRACT)
					|| (cat == ComponentCategory.VIRTUAL_PROCESSOR) || (cat == ComponentCategory.SYSTEM)) {
				List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding((ComponentInstance) ci);
				ComponentInstance cpu = cpus.isEmpty() ? null : cpus.get(0);
				if (cpu != null) {
					return getOccurenceDistributionProperty(cpu, target, ts);
				}
			}

		}
		return result;
	}

	/**
	 * Retrieve the type/kind of distribution associated
	 * with the Occurrence property
	 * See PRISM converter to see how it is used.
	 *
	 * @param PAContainmentPath string value describing the distribution get from getOccurenceDistributionProperty
	 */
	public static String getOccurenceType(final PropertyAssociation PA) {
		if (PA == null) {
			return "unknown_distribution";
		}

		for (ModalPropertyValue modalPropertyValue : PA.getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue) {

				RecordValue rv = (RecordValue) val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				// for all error types/aliases in type set or the element identified in the containment clause
				for (BasicPropertyAssociation bpa : fields) {
					if (bpa.getProperty().getName().equalsIgnoreCase("distribution")) {
						if (bpa.getValue() instanceof NamedValue) {
							EnumerationLiteral el = (EnumerationLiteral) ((NamedValue) bpa.getValue()).getNamedValue();
							return (el.getName().toLowerCase());

							// RealLiteral rl = (NamedValue)bpa.getValue();
							// result = rl.getScaledValue();
						}
					}
				}
			}
		}
		return "unknown_distribution";
	}

	/**
	 * Retrieve the value associated with a containment path
	 * See RDB action to see how it is used.
	 *
	 * @param PA value get from getOccurenceDistributionProperty
	 */
	public static double getOccurenceValue(final PropertyAssociation PA) {
		double result;
		result = 0;
		if (PA == null) {
			return 0;
		}
		for (ModalPropertyValue modalPropertyValue : PA.getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();

			if (val instanceof RecordValue) {

				RecordValue rv = (RecordValue) val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				// for all error types/aliases in type set or the element identified in the containment clause
				for (BasicPropertyAssociation bpa : fields) {
					if (bpa.getProperty().getName().equalsIgnoreCase("probabilityvalue")) {
						if (bpa.getValue() instanceof RealLiteral) {
							RealLiteral rl = (RealLiteral) bpa.getValue();
							result = rl.getScaledValue();
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * get list of property associations in enclosing object within the error annex that has a properties section.
	 * ErrorModelLibrary, ErrorBehaviorStateMachine have properties sections
	 * Note: we assume the PA list in the subclause has been handled.
	 * @param element declarative model element or error annex element
	 * @return PS list of ErrorModelLibrary, ErrorBehaviorStateMachine
	 */
	public static Collection<PropertyAssociation> getPropertyAssociationListInContext(Element element) {
		EObject container = element;
		while (container != null) {
//			if (container instanceof ErrorModelSubclause ){
//				return ((ErrorModelSubclause)container).getProperties();
//			}
			if (container instanceof ErrorModelLibrary) {
				return ((ErrorModelLibrary) container).getProperties();
			}
			if (container instanceof ErrorBehaviorStateMachine) {
				return ((ErrorBehaviorStateMachine) container).getProperties();
			}
			container = container.eContainer();
		}
		return null;
	}

	/** return list of property associations that meet the property name
	 *
	 * @param props property association list from the properties section
	 * @param propertyName name of property
	 * @return EList<PropertyAssociation>
	 */
	public static Collection<PropertyAssociation> getPropertyAssociationsMatchingName(
			Collection<PropertyAssociation> props, String propertyName) {
		Collection<PropertyAssociation> result = new ArrayList<PropertyAssociation>();
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)) {
				result.add(propertyAssociation);
			}
		}
		return result;
	}

	/**
	 * return containment path of all PA in list that match the target.
	 * Should be only one matching.
	 * @param props list of property associations from the properties section in the error model of ci
	 * @param propertyName name of property we are looking for
	 * @param target the error model element
	 * @param ciStack stack of nested CI below the ci of the props; those names may show up in the path
	 * @return list of paths
	 */
	public static PropertyAssociation getMatchingPropertiesInList(Collection<PropertyAssociation> props,
			String propertyName, Element target, Stack<NamedElement> ciStack, TypeSet ts) {
		if (props.isEmpty()) {
			return null;
		}
		Collection<PropertyAssociation> result = new ArrayList<PropertyAssociation>();
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)) {
				PropertyAssociation res = isErrorModelElementProperty(propertyAssociation, target, ciStack, ts);
				if (res != null) {
					return res;
				}
			}
		}
		return null;
	}

	/**
	 * check to see if the first part of the path matches the stack.
	 * Note, the order of items on the stack is the inverse of that in the path.
	 * If ciStack is null or empty return true.
	 * @param ciStack
	 * @param cpes
	 * @return
	 */
	private static boolean matchCIStack(Stack<NamedElement> ciStack, List<ContainmentPathElement> cpes) {
		if (ciStack == null || ciStack.isEmpty()) {
			return true;
		}
		int offset = ciStack.size() - 1;
		int idx;
		for (int i = 0; i < ciStack.size(); i++) {
			idx = offset - i;
			/**
			 * Check that we does not go into out of bounds
			 * and raise an exception.
			 * FIXME-JD: check if this logic is correct.
			 */
			if (idx >= cpes.size()) {
				return false;
			}
			NamedElement el = ciStack.get(i);
			if (el instanceof ComponentInstance) {
				el = ((ComponentInstance) el).getSubcomponent();
			}
			if (el != cpes.get(idx).getNamedElement()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * return the containment path if the stack combined with the target and optionally the type set match the containment path of a property association.
	 * It is sufficient for one of the paths in the PA to match.
	 * ciStack represents the path from the context of the PA to the component instance whose property we want to retrieve
	 * The desired type set ts must be contained in the type set named in the containment path
	 * @param propertyAssociation PropertyAssociation that is the candidate
	 * @param ciStack (can be null or empty) ComponentInstance in instance model hierarchy with the error model element, whose property we are retrieving (or null)
	 * @param target Element the target object in the error model whose property we retrieve
	 * @param ts type set that must contain the last element if it is a type
	 * @return ContainedNamedElement the containment path that matches
	 */
	public static PropertyAssociation isErrorModelElementProperty(PropertyAssociation propertyAssociation,
			Element target, Stack<NamedElement> ciStack, TypeSet ts) {
		boolean matchStack = false;
		EList<ContainedNamedElement> applies = propertyAssociation.getAppliesTos();
		for (ContainedNamedElement containedNamedElement : applies) {
			EList<ContainmentPathElement> cpes = containedNamedElement.getContainmentPathElements();
			matchStack = matchCIStack(ciStack, cpes);
			if (matchStack) {
				// we are past the component portion of the path
				NamedElement typeelement = null;
				NamedElement lastel = null;
				if (cpes.size() > 1) {
					typeelement = cpes.get(cpes.size() - 1).getNamedElement();
					lastel = cpes.get(cpes.size() - 2).getNamedElement();
				} else if (cpes.size() > 0) {
					lastel = cpes.get(cpes.size() - 1).getNamedElement();
				}
				if (typeelement != null) {
					// check to see if the desired ts is contained in the PA containment path
					if (typeelement instanceof ErrorType) {
						// we refer to a type
						if ((lastel instanceof ErrorType) && (EM2TypeSetUtil.contains((ErrorType) lastel, ts))) {
							return propertyAssociation;
						}
					} else if (typeelement instanceof TypeSet) {
						// we refer to a type
						if (EM2TypeSetUtil.contains((TypeSet) typeelement, ts)) {
							// skip to next iteration
							return propertyAssociation;
						}
					} else {
						// last element is not a type or type set
						// must match target.
						// Note: property on target matches all targets with types
						if (typeelement == target) {
							return propertyAssociation;
						}
					}
				}

				/**
				 * Finally, in last resort, we try to see if the lastelement
				 * of the path corresponds to the target.
				 */
				if (lastel == target) {
					return propertyAssociation;
				}
				if (lastel instanceof ErrorTypes && target instanceof ErrorTypes) {
					if (EM2TypeSetUtil.contains((ErrorTypes) lastel, (ErrorTypes) target)) {
						return propertyAssociation;
					}
				}
			}
		}
		return null;
	}

	/**
	 * return containment paths of all PA in list whose property name and target/ts match
	 * @param props
	 * @param propertyName
	 * @param target
	 * @param ts
	 * @return PropertyAssociation
	 */
	public static PropertyAssociation getMatchingErrorModelElementPropertyAssociationsInList(
			Collection<PropertyAssociation> props, String propertyName, Element target, TypeSet ts) {
		if (props == null) {
			return null;
		}
		for (PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)) {
				PropertyAssociation res = isErrorModelElementProperty(propertyAssociation, target, null, ts);
				if (res != null) {
					return res;
				}
			}
		}
		return null;
	}

	/**
	 * find property by first looking for it down the component instance hierarchy to ci
	 * Then try to find it in the local context if not null. The context is the context object of the referenced target.
	 * For example: the transition for a state reference.
	 * Finally, we look for the property at the definition site of the referenced object.
	 * NOTE: the target element may actually be contained in a different context from the context in which we are interested in its property.
	 * For example, we are interested in the occurrence distribution for an error state. It actually is contained in an error behavior state machine.
	 * We are interested in its property value in the context of of the reference to the state, e.g., an error source.
	 * In some cases we are interested in the state as it is associated with the component via the use behavior clause.
	 * In that case there is no local context for the state reference.
	 * @param propertyName String
	 * @param ci ComponentInstance the component instance, subcomponent, or classifier with the error model element, whose property we are retrieving
	 * @param target Element the target object in the error model whose property we retrieve (the element may carry an error type)
	 * @param ts Type Set null or any error type in the type set as part of the target error model element
	 * @return
	 */
	public static PropertyAssociation getProperty(String propertyName, NamedElement ci, Element target, TypeSet ts) {
		PropertyAssociation result = getPropertyInInstanceHierarchy(propertyName, ci, target, ts);
		if (result == null) {
			// look up in context of target definition
			// for example: for a state reference the properties section of the EBSM that defines the state
			Collection<PropertyAssociation> props = getPropertyAssociationListInContext(target);
			if (props != null) {
				result = getMatchingErrorModelElementPropertyAssociationsInList(props, propertyName, target, ts);
			}
		}
		return result;
	}

	/**
	 * recurse up the component hierarchy to look for the PA from the outside in.
	 * For each component instance, handle inherited properties based on subclause inheritance ordering
	 * @param propertyName
	 * @param ci the component instance whose subclause property section we are looking for the property
	 * @param target
	 * @param ciStack stack of CIS that are down the hierarchy towards the target emv2 subclause
	 * @param ts
	 * @return
	 */
	private static PropertyAssociation getPropertyInInstanceHierarchy(String propertyName, ComponentInstance ci,
			Element target, Stack<NamedElement> ciStack, TypeSet ts) {
		if (ci != null) {
			if (ci.getContainingComponentInstance() != null) {
				ciStack.push(ci);
				PropertyAssociation result = getPropertyInInstanceHierarchy(propertyName,
						ci.getContainingComponentInstance(), target, ciStack, ts);
				ciStack.pop();
				if (result != null) {
					return result;
				}
			}
			// deals with inherited properties by walking subclause inheritance
			Collection<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(ci);
			for (ErrorModelSubclause ems : emslist) {
				Collection<PropertyAssociation> props = ems.getProperties();
				PropertyAssociation result = getMatchingPropertiesInList(props, propertyName, target, ciStack, ts);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element based on contained property associations
	 * in the annex subclause properties section.
	 * Here we come down the component instance hierarchy to find the outmost property association
	 * in the properties section of the annex subclauses. Those are the ones that can override down the component hierarchy.
	 * @param propertyName name of property we are looking for
	 * @param ci component instance whose EM element has the property
	 * @param target the error model element (which is optionally followed by a type that is contained in the typeset ts
	 * @param ts the type set
	 * @return Containmentpath of the PA that matches the parameters.
	 * we return the path because the PA applies to more than element
	 */
	public static PropertyAssociation getPropertyInInstanceHierarchy(String propertyName, NamedElement ci,
			Element target, TypeSet ts) {
		Stack<NamedElement> ciStack = new Stack<NamedElement>();
		ComponentClassifier cl = null;
		if (ci instanceof ComponentInstance) {
			return getPropertyInInstanceHierarchy(propertyName, (ComponentInstance) ci, target, ciStack, ts);
		}
		if (ci instanceof Subcomponent) {
			// look in enclosing component impl first. Then in classifier of subcomponent
			cl = (ComponentClassifier) ((Subcomponent) ci).getContainingClassifier();
			ciStack.push(ci);
			PropertyAssociation result = getPropertyInClassifier(propertyName, cl, target, ciStack, ts);
			if (result != null) {
				return result;
			}
			ciStack.pop();
			cl = ((Subcomponent) ci).getAllClassifier();
			return getPropertyInClassifier(propertyName, cl, target, ciStack, ts);
		}
		if (ci instanceof ComponentClassifier) {
			cl = (ComponentClassifier) ci;
			return getPropertyInClassifier(propertyName, cl, target, ciStack, ts);
		}
		return null;
	}

	/**
	 * retrieve an error model property (such as Hazard) attached to an error model element based on contained property associations
	 * in the annex subclause properties section of the classifier.
	 * @param propertyName name of property we are looking for
	 * @param ci component instance whose EM element has the property
	 * @param target the error model element (which is optionally followed by a type that is contained in the typeset ts
	 * @param ts the type set
	 * @return Containmentpath of the PA that matches the parameters.
	 * we return the path because the PA applies to more than element
	 */
	public static PropertyAssociation getPropertyInClassifier(String propertyName, Classifier cl, Element target,
			Stack<NamedElement> ciStack, TypeSet ts) {
		if (cl != null) {
			// deals with inherited properties by walking subclause inheritance
			EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(cl);
			for (ErrorModelSubclause ems : emslist) {
				Collection<PropertyAssociation> props = ems.getProperties();
				PropertyAssociation result = getMatchingPropertiesInList(props, propertyName, target, ciStack, ts);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	/**
	 * get Severity
	 * @param ci component instance, subcomponent, or classifier
	 * @param target Error Model element
	 * @param ts Typeset
	 * @return path to element with property
	 */
	public static PropertyAssociation getSeverityProperty(NamedElement ci, Element target, TypeSet ts) {
		return EMV2Properties.getProperty("EMV2::Severity", ci, target, ts);
	}

	/**
	 * get likelihood
	 * @param ci component instance, subcomponent, or classifier
	 * @param target Error Model element
	 * @param ts Typeset
	 * @return path to element with property
	 */
	public static PropertyAssociation getLikelihoodProperty(NamedElement ci, Element target, TypeSet ts) {
		return EMV2Properties.getProperty("EMV2::Likelihood", ci, target, ts);
	}

	public static NamedElement getPropagationElement(ErrorPropagation errorPropagation) {
		NamedElement el;

		return errorPropagation.getFeatureorPPRef().getFeatureorPP();
	}

}
