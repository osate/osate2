package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
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
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.properties.util.GetProperties;

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
		} else if (val instanceof RealLiteral) {
			return "" + ((RealLiteral) val).getValue();
		}
		return "";
	}

	public static PropertyExpression getPropertyValue(EMV2PropertyAssociation pa) {
		if (pa != null) {
			for (ModalPropertyValue modalPropertyValue : pa.getOwnedValues()) {
				PropertyExpression val = resolvePropertyConstant(modalPropertyValue.getOwnedValue());
				return val;
			}
		}
		return null;
	}

	public static PropertyExpression getPropertyValue(BasicPropertyAssociation bpa) {
		PropertyExpression pe = bpa.getValue();
		return resolvePropertyConstant(pe);
	}

	private static PropertyExpression resolvePropertyConstant(PropertyExpression pe) {
		if (pe instanceof NamedValue) {
			NamedValue nv = (NamedValue) pe;
			if (nv.getNamedValue() instanceof PropertyConstant) {
				PropertyConstant pc = (PropertyConstant) nv.getNamedValue();
				return pc.getConstantValue();
			}
		}
		return pe;
	}

	/**
	 * retrieve the probability
	 * @param ci component instance, subcomponent, or classifier
	 * @param ne named element for which we retrieve the probability
	 * @param ts type set
	 * @return
	 */
	public static double getProbability(NamedElement ci, NamedElement ne, ErrorTypes ts) {
		List<EMV2PropertyAssociation> PA = EMV2Properties.getOccurrenceDistributionProperty(ci, ne, ts);
		double prob = 0;
		for (EMV2PropertyAssociation emv2PropertyAssociation : PA) {
			prob += EMV2Properties.getOccurrenceValue(emv2PropertyAssociation);
		}
		return prob;
	}

	/**
	 *
	 * @param element - the EMV2 element that refers to the artifact
	 * @param relatedComponent - the component (instance, subcomponent or classifier that have the property association
	 * @return - the text related to the description part of the hazards property. Null if not defined
	 */
	public static String getHazardDescription(NamedElement element, NamedElement relatedComponent) {
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
		if (element instanceof ErrorSource) {
			ts = ((ErrorSource) element).getTypeTokenConstraint();
		}
		return getHazardDescription(element, relatedComponent, ts);
	}

	@Deprecated
	public static String getDescription(NamedElement element, NamedElement relatedComponent) {
		return getHazardDescription(element, relatedComponent);
	}

	@Deprecated
	public static String getDescription(NamedElement element, NamedElement relatedComponent, ErrorTypes ts) {
		return getHazardDescription(element, relatedComponent, ts);
	}

	public static String getHazardDescription(NamedElement element, NamedElement relatedComponent, ErrorTypes ts) {
		List<EMV2PropertyAssociation> PA = EMV2Properties.getHazardsProperty(relatedComponent, element, ts);

		if (PA.isEmpty()) {
			return null;
		}
		// XXX TODO we may get more than one back, one each for different types
		PropertyExpression val = getPropertyValue(PA.get(0));
		if (val instanceof RecordValue) {
			RecordValue rv = (RecordValue) val;
			EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
			BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "description");
			if (xref != null) {
				PropertyExpression peVal = getPropertyValue(xref);
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
						PropertyExpression peVal = getPropertyValue(xref);
						if (peVal instanceof StringLiteral) {
							return ((StringLiteral) peVal).getValue();
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

		List<EMV2PropertyAssociation> PA = EMV2Properties.getHazardsProperty(relatedComponent, element, ts);

		if (PA.isEmpty()) {
			return null;
		}
		// XXX TODO we may get more than one back, one each for different types
		PropertyExpression val = getPropertyValue(PA.get(0));
		if (val instanceof RecordValue) {
			RecordValue rv = (RecordValue) val;
			EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
			BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "failure");
			if (xref != null) {
				PropertyExpression peVal = getPropertyValue(xref);
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
						PropertyExpression peVal = getPropertyValue(xref);
						if (peVal instanceof StringLiteral) {
							return ((StringLiteral) peVal).getValue();
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
	public static List<EMV2PropertyAssociation> getHazardsProperty(NamedElement ci, NamedElement target, TypeSet ts) {
		List<EMV2PropertyAssociation> result = getProperty("EMV2::hazards", ci, target, ts);
		if (result.isEmpty()) {
			result = getProperty("ARP4761::hazards", ci, target, ts);
		}
		if (result.isEmpty()) {
			result = getProperty("MILSTD882::hazards", ci, target, ts);
		}
		return result;
	}

	public static List<EMV2PropertyAssociation> getARP4761HazardsProperty(NamedElement ci, NamedElement target,
			TypeSet ts) {
		List<EMV2PropertyAssociation> result = getProperty("ARP4761::hazards", ci, target, ts);
		return result;
	}

	public static List<EMV2PropertyAssociation> getMILSTD882HazardsProperty(NamedElement ci, NamedElement target,
			TypeSet ts) {
		List<EMV2PropertyAssociation> result = getProperty("MILSTD882::hazards", ci, target, ts);
		return result;
	}

	public static List<EMV2PropertyAssociation> getHazardsProperty(NamedElement ci, NamedElement target,
			ErrorTypes ts) {
		List<EMV2PropertyAssociation> result = getProperty("EMV2::hazards", ci, target, ts);
		if (result.isEmpty()) {
			result = getProperty("ARP4761::hazards", ci, target, ts);
		}
		if (result.isEmpty()) {
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
	public static List<EMV2PropertyAssociation> getOccurrenceDistributionProperty(NamedElement ci, NamedElement target,
			ErrorTypes ts) {
		List<EMV2PropertyAssociation> result = getProperty("EMV2::OccurrenceDistribution", ci, target, ts);
		return result;
	}

	/**
	 * Retrieve the value associated with a containment path
	 * See RDB action to see how it is used.
	 *
	 * @param PA value get from getOccurenceDistributionProperty
	 */
	public static double getOccurrenceValue(final EMV2PropertyAssociation PA) {
		double result;
		result = 0;
		if (PA == null) {
			return 0;
		}
		PropertyExpression val = getPropertyValue(PA);

		if (val instanceof RecordValue) {

			RecordValue rv = (RecordValue) val;
			EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
			// for all error types/aliases in type set or the element identified in the containment clause
			for (BasicPropertyAssociation bpa : fields) {
				if (bpa.getProperty().getName().equalsIgnoreCase("probabilityvalue")) {
					PropertyExpression bva = getPropertyValue(bpa);
					if (bva instanceof RealLiteral) {
						RealLiteral rl = (RealLiteral) bva;
						result = rl.getScaledValue();
					}
				}
			}
		}
		return result;
	}

	/**
	 *
	 */
	public static double getRealValue(final EMV2PropertyAssociation PA) {
		if (PA == null) {
			return 0.0;
		}
		PropertyExpression val = getPropertyValue(PA);
		if (val instanceof RealLiteral) {
			RealLiteral rl = (RealLiteral) val;
			return rl.getValue();
		}
		return 0.0;
	}

	public static double getModalRealValue(EMV2PropertyAssociation pa, SystemOperationMode som) {
		if (!isModal(pa)) {
			PropertyExpression val = getPropertyValue(pa);
			if (val instanceof RealLiteral) {
				RealLiteral rl = (RealLiteral) val;
				return rl.getValue();
			}
		} else if (som != null) {
			PropertyExpression defaultPE = null;
			// find value in SOM
			for (ModalPropertyValue mpv : pa.getOwnedValues()) {
				if (mpv.getInModes() == null || mpv.getInModes().size() == 0) {
					defaultPE = resolvePropertyConstant(mpv.getOwnedValue());
				} else if (mpv.getInModes().contains(som)) {
					PropertyExpression val = resolvePropertyConstant(mpv.getOwnedValue());
					if (val instanceof RealLiteral) {
						RealLiteral rl = (RealLiteral) val;
						return rl.getValue();
					}
				}
			}
			// default
			if (defaultPE != null) {
				if (defaultPE instanceof RealLiteral) {
					RealLiteral rl = (RealLiteral) defaultPE;
					return rl.getValue();
				}
			}
			// use global default
			PropertyExpression val = resolvePropertyConstant(pa.getProperty().getDefaultValue());
			if (val instanceof RealLiteral) {
				RealLiteral rl = (RealLiteral) val;
				return rl.getValue();
			}
		}
		return 0.0;

	}

	public static boolean isModal(EMV2PropertyAssociation pa) {
		int count = pa.getOwnedValues().size();

		if (count > 1) {
			return true;
		}
		if (count == 0) {
			return false;
		}
		return pa.getOwnedValues().get(0).getInModes() != null && !pa.getOwnedValues().get(0).getInModes().isEmpty();
	}

	/**
	 * get list of property associations in enclosing object within the error annex that has a properties section.
	 * ErrorModelLibrary, ErrorBehaviorStateMachine have properties sections
	 * Note: we assume the PA list in the subclause has been handled.
	 * @param element declarative model element or error annex element
	 * @return PS list of ErrorModelLibrary, ErrorBehaviorStateMachine
	 */
	public static List<EMV2PropertyAssociation> getPropertyAssociationListInContext(Element element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof ErrorModelSubclause) {
				return ((ErrorModelSubclause) container).getProperties();
			}
			if (container instanceof ErrorModelLibrary) {
				return ((ErrorModelLibrary) container).getProperties();
			}
			if (container instanceof ErrorBehaviorStateMachine) {
				return ((ErrorBehaviorStateMachine) container).getProperties();
			}
			container = container.eContainer();
		}
		return Collections.emptyList();
	}

	/** return list of property associations that meet the property name
	 *
	 * @param props property association list from the properties section
	 * @param propertyName name of property
	 * @return EList<PropertyAssociation>
	 */
	public static List<PropertyAssociation> getPropertyAssociationsMatchingName(List<PropertyAssociation> props,
			String propertyName) {
		List<PropertyAssociation> result = new ArrayList<PropertyAssociation>();
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
	public static List<EMV2PropertyAssociation> getMatchingPropertiesInList(List<EMV2PropertyAssociation> props,
			String propertyName, NamedElement target, Stack<NamedElement> ciStack, ErrorTypes ts) {
		if (props.isEmpty()) {
			return Collections.emptyList();
		}
		List<EMV2PropertyAssociation> result = new ArrayList<EMV2PropertyAssociation>();
		for (EMV2PropertyAssociation propertyAssociation : props) {
			Property prop = propertyAssociation.getProperty();
			String name = prop.getQualifiedName();
			if (propertyName.equalsIgnoreCase(name)) {
				EMV2PropertyAssociation res = isErrorModelElementProperty(propertyAssociation, target, ciStack, ts);
				if (res != null) {
					result.add(res);
				}
			}
		}
		return result;
	}

	/**
	 * return containment paths of all PA in list whose property name and target/ts match
	 * @param props
	 * @param propertyName
	 * @param target
	 * @param ts
	 * @return list of PropertyAssociation
	 */
	public static List<EMV2PropertyAssociation> getMatchingPropertiesInList(List<EMV2PropertyAssociation> props,
			String propertyName, NamedElement target, ErrorTypes ts) {
		return getMatchingPropertiesInList(props, propertyName, target, null, ts);
	}

	/**
	 * check to see if the first part of the path matches the stack.
	 * Note, the order of items on the stack is the inverse of that in the path.
	 * If ciStack is null or empty return true.
	 * @param ciStack
	 * @param cpes
	 * @return
	 */
	private static boolean matchCIStack(Stack<NamedElement> ciStack, ContainmentPathElement cp) {
		if (cp == null && (ciStack == null || ciStack.isEmpty())) {
			return true;
		}
		if (cp == null && (ciStack != null && !ciStack.isEmpty())
				|| cp != null && (ciStack == null || ciStack.isEmpty())) {
			return false;
		}
		ContainmentPathElement emv2ce = cp;
		for (NamedElement namedElement : ciStack) {
			if (emv2ce == null || !namedElement.getName().equalsIgnoreCase(emv2ce.getNamedElement().getName())) {
				return false;
			} else {
				emv2ce = emv2ce.getPath();
			}
		}
		return true;
	}

	private static boolean matchCIStack(Stack<NamedElement> ciStack, EMV2PathElement cp) {
		if (cp == null || (ciStack == null || ciStack.isEmpty())) {
			return true;
		}
		EMV2PathElement emv2ce = cp;
		for (NamedElement namedElement : ciStack) {
			if (emv2ce == null || !namedElement.getName().equalsIgnoreCase(emv2ce.getNamedElement().getName())) {
				return false;
			} else {
				emv2ce = emv2ce.getPath();
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
	public static EMV2PropertyAssociation isErrorModelElementProperty(EMV2PropertyAssociation propertyAssociation,
			NamedElement target, Stack<NamedElement> ciStack, ErrorTypes ts) {
		boolean matchStack = false;
		EList<EMV2Path> applies = propertyAssociation.getEmv2Path();
		for (EMV2Path emv2Path : applies) {
			ContainmentPathElement cp = emv2Path.getContainmentPath();
			if (cp != null) {
				matchStack = matchCIStack(ciStack, cp);
			} else {
				matchStack = matchCIStack(ciStack, emv2Path.getEmv2Target());
			}
			if (matchStack) {
				// we are past the component portion of the path
				String targetName = EMV2Util.getPrintName(target);
				NamedElement pathTargetEME = EMV2Util.getErrorModelElement(emv2Path);
				String pathName = EMV2Util.getPrintName(pathTargetEME);
				if (targetName.equalsIgnoreCase(pathName)) {
					ErrorTypes typeelement = EMV2Util.getErrorType(emv2Path);
					if (typeelement != null && ts != null) {
						// check to see if the desired ts is contained in the PA containment path
						if (EMV2TypeSetUtil.contains(ts, typeelement) || EMV2TypeSetUtil.contains(typeelement, ts)) {
							return propertyAssociation;
						}
					} else {
						return propertyAssociation;
					}
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
	public static List<EMV2PropertyAssociation> getProperty(String propertyName, NamedElement ci, NamedElement target,
			ErrorTypes ts) {
		List<EMV2PropertyAssociation> result = getPropertyInInstanceHierarchy(propertyName, ci, target, ts);
		if (result.isEmpty()) {
			// look up in context of target definition
			// for example: for a state reference the properties section of the EBSM that defines the state
			List<EMV2PropertyAssociation> props = getPropertyAssociationListInContext(target);
			if (!props.isEmpty()) {
				result = getMatchingPropertiesInList(props, propertyName, target, ts);
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
	private static List<EMV2PropertyAssociation> getPropertyInInstanceHierarchy(String propertyName,
			ComponentInstance ci, NamedElement target, Stack<NamedElement> ciStack, ErrorTypes ts) {
		if (ci != null) {
			if (ci.getContainingComponentInstance() != null) {
				ciStack.push(ci);
				List<EMV2PropertyAssociation> result = getPropertyInInstanceHierarchy(propertyName,
						ci.getContainingComponentInstance(), target, ciStack, ts);
				ciStack.pop();
				if (!result.isEmpty()) {
					return result;
				}
			}
			// deals with inherited properties by walking subclause inheritance
			List<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(ci);
			for (ErrorModelSubclause ems : emslist) {
				List<EMV2PropertyAssociation> props = ems.getProperties();
				List<EMV2PropertyAssociation> result = getMatchingPropertiesInList(props, propertyName, target, ciStack,
						ts);
				if (!result.isEmpty()) {
					return result;
				}
			}
		}
		return Collections.emptyList();
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
	public static List<EMV2PropertyAssociation> getPropertyInInstanceHierarchy(String propertyName, NamedElement ci,
			NamedElement target, ErrorTypes ts) {
		if (ci == null) {
			return Collections.emptyList();
		}
		Stack<NamedElement> ciStack = new Stack<NamedElement>();
		ComponentClassifier cl = null;
		if (ci instanceof ComponentInstance) {
			// ciStack will contain the nested set of component instances
			return getPropertyInInstanceHierarchy(propertyName, (ComponentInstance) ci, target, ciStack, ts);
		}
		if (ci instanceof Subcomponent) {
			// look in enclosing component impl first. Then in classifier of subcomponent
			cl = (ComponentClassifier) ((Subcomponent) ci).getContainingClassifier();
			ciStack.push(ci);
			// ciStack has subcomponent whose error model is of interest
			List<EMV2PropertyAssociation> result = getPropertyInClassifier(propertyName, cl, target, ciStack, ts);
			if (!result.isEmpty()) {
				return result;
			}
			ciStack.pop();
			cl = ((Subcomponent) ci).getAllClassifier();
			return getPropertyInClassifier(propertyName, cl, target, ciStack, ts);
		}
		if (ci instanceof ComponentClassifier) {
			cl = (ComponentClassifier) ci;
			// empty ciStack
			return getPropertyInClassifier(propertyName, cl, target, ciStack, ts);
		}
		return Collections.emptyList();
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
	public static List<EMV2PropertyAssociation> getPropertyInClassifier(String propertyName, Classifier cl,
			NamedElement target, Stack<NamedElement> ciStack, ErrorTypes ts) {
		if (cl != null) {
			// deals with inherited properties by walking subclause inheritance
			EList<ErrorModelSubclause> emslist = EMV2Util.getAllContainingClassifierEMV2Subclauses(cl);
			for (ErrorModelSubclause ems : emslist) {
				List<EMV2PropertyAssociation> props = ems.getProperties();
				List<EMV2PropertyAssociation> result = getMatchingPropertiesInList(props, propertyName, target, ciStack,
						ts);
				if (!result.isEmpty()) {
					return result;
				}
			}
		}
		return Collections.emptyList();
	}

	/**
	 * get Severity
	 * @param ci component instance, subcomponent, or classifier
	 * @param target Error Model element
	 * @param ts Typeset
	 * @return path to element with property
	 */
	public static List<EMV2PropertyAssociation> getSeverityProperty(NamedElement ci, NamedElement target,
			ErrorTypes ts) {
		return EMV2Properties.getProperty("EMV2::Severity", ci, target, ts);
	}

	/**
	 * get likelihood
	 * @param ci component instance, subcomponent, or classifier
	 * @param target Error Model element
	 * @param ts Typeset
	 * @return path to element with property
	 */
	public static List<EMV2PropertyAssociation> getLikelihoodProperty(NamedElement ci, NamedElement target,
			ErrorTypes ts) {
		return EMV2Properties.getProperty("EMV2::Likelihood", ci, target, ts);
	}

	public static NamedElement getPropagationElement(ErrorPropagation errorPropagation) {
		return errorPropagation.getFeatureorPPRef().getFeatureorPP();
	}

}
