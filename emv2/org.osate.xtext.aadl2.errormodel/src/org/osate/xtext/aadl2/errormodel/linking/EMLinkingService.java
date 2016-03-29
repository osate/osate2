package org.osate.xtext.aadl2.errormodel.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class EMLinkingService extends PropertiesLinkingService {

	public EMLinkingService() {
		super();
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		EObject searchResult = null;
		if (requiredType == null) {
			return Collections.<EObject> emptyList();
		}
		final Element cxt = (Element) context;
		final String name = getCrossRefNodeAsString(node);
		if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			Element cxtElement = (Element) context;
			FeatureGroupType cxtFGT = null;
			String epFGPrefix = "";
			if (context instanceof ContainmentPathElement) {
				// containment path element: sequence of subcomponents
				Classifier cxtClassifier = EMV2Util.getAssociatedClassifier(((ContainmentPathElement) context));
				EObject previous = context.eContainer();
				if (previous instanceof ContainmentPathElement) {
					// deal with feature groups and features as identifiers of error propagations
					NamedElement ne = ((ContainmentPathElement) previous).getNamedElement();
					if (ne instanceof FeatureGroup) {
						FeatureGroup fg = (FeatureGroup) ne;
						cxtFGT = fg.getAllFeatureGroupType();
						EObject obj = previous;
						while (obj instanceof EMV2PathElement) {
							NamedElement prevne = ((EMV2PathElement) obj).getNamedElement();
							if (prevne instanceof FeatureGroup) {
								epFGPrefix = ((FeatureGroup) prevne).getName() + "." + epFGPrefix;
							} else {
								break;
							}
							obj = obj.eContainer();
						}
					} else if (ne instanceof ErrorPropagation) {
						// we resolved previous entry to an error propagation
						// It may represent the context of the feature, e.g., when both the fg and the feature have an error propagation
						Feature f = EMV2Util.getFeature((ErrorPropagation) ne);
						if (f instanceof FeatureGroup) {
							cxtFGT = ((FeatureGroup) f).getAllFeatureGroupType();
							epFGPrefix = EMV2Util.getPropagationName((ErrorPropagation) ne);
						}
						cxtElement = ne;
					} else if (ne instanceof Subcomponent) {
						// use the last component on the path as context for lookup of error model elements
						ComponentClassifier cxtPathComp = ((Subcomponent) ne).getAllClassifier();
						if (cxtPathComp != null) {
							cxtClassifier = cxtPathComp;
						}
					}
				}
				searchResult = cxtClassifier.findNamedElement(name);
				if (searchResult != null && searchResult instanceof Subcomponent) {
					return Collections.singletonList(searchResult);
				}
			}
			if (context instanceof EMV2PathElement) {
				// EMV2 model element and optional error type
				EObject previous = context.eContainer();
				// the default context element is the EMV2PathElement
				// It is used for lookup in an EMV2 library context
				if (previous instanceof EMV2PathElement) {
					// deal with feature groups and features as identifiers of error propagations
					NamedElement ne = ((EMV2PathElement) previous).getNamedElement();
					if (ne instanceof FeatureGroup) {
						FeatureGroup fg = (FeatureGroup) ne;
						cxtFGT = fg.getAllFeatureGroupType();
						EObject obj = previous;
						while (obj instanceof EMV2PathElement) {
							NamedElement prevne = ((EMV2PathElement) obj).getNamedElement();
							if (prevne instanceof FeatureGroup) {
								epFGPrefix = ((FeatureGroup) prevne).getName() + "." + epFGPrefix;
							} else {
								break;
							}
							obj = obj.eContainer();
						}
					} else if (ne instanceof ErrorPropagation) {
						// we resolved previous entry to an error propagation
						// It may represent the context of the feature, e.g., when both the fg and the feature have an error propagation
						Feature f = EMV2Util.getFeature((ErrorPropagation) ne);
						if (f instanceof FeatureGroup) {
							cxtFGT = ((FeatureGroup) f).getAllFeatureGroupType();
							epFGPrefix = EMV2Util.getPropagationName((ErrorPropagation) ne);
						}
						cxtElement = ne;
					} else if (ne instanceof Subcomponent) {
						// use the last component on the path as context for lookup of error model elements
						ComponentClassifier cxtPathComp = ((Subcomponent) ne).getAllClassifier();
						if (cxtPathComp != null) {
							searchResult = cxtPathComp.findNamedElement(name);
							if (searchResult != null && searchResult instanceof Subcomponent) {
								return Collections.singletonList(searchResult);
							}
							cxtElement = cxtPathComp;
						}
					} else if (!Aadl2Util.isNull(ne)) {
						cxtElement = ne;
					}
				} else {
					// we are at the top: EMV2Path
					// need to find the classifier of the containment path as context if it exists
					EMV2Path emv2path = (EMV2Path) previous;
					ContainmentPathElement last = EMV2Util.getLast(emv2path.getContainmentPath());
					if (last != null) {
						NamedElement ne = last.getNamedElement();
						if (ne instanceof Subcomponent) {
							Classifier cxtClassifier = ((Subcomponent) ne).getAllClassifier();
							if (cxtClassifier != null) {
								cxtElement = cxtClassifier;
							}
						}
					} else {
						Classifier cxtClassifier = EMV2Util.getAssociatedClassifier((Element) context);
						if (cxtClassifier != null) {
							cxtElement = cxtClassifier;
							searchResult = cxtClassifier.findNamedElement(name);
							if (searchResult != null && searchResult instanceof Subcomponent) {
								return Collections.singletonList(searchResult);
							}
						}
					}
				}
			}
			if (context instanceof ContainmentPathElement || context instanceof EMV2PathElement) {
				// The find methods understand if they are in a subclause
				// first we look for error propagations. This may resolve a feature group as propagation point.
				searchResult = EMV2Util.findErrorPropagation(cxtElement, epFGPrefix + name, DirectionType.OUT);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorPropagation(cxtElement, epFGPrefix + name, DirectionType.IN);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findPropagationPoint(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorContainment(cxtElement, epFGPrefix + name, DirectionType.OUT);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorContainment(cxtElement, epFGPrefix + name, DirectionType.IN);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorFlow(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorBehaviorEvent(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorBehaviorState(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorBehaviorTransition(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findErrorDetection(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findOutgoingPropagationCondition(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = EMV2Util.findConnectionErrorSource(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				if (cxtFGT != null) {
					// if previous element was feature group, look up next feature group in its type
					// we do not want to return features as they should get resolved to an error propagation
					searchResult = cxtFGT.findNamedElement(name);
					if (searchResult != null && (searchResult instanceof FeatureGroup)) {
						return Collections.singletonList(searchResult);
					}
				}
				// look up feature group in context or enclosing classifier
				// we do not want to return features as they should get resolved to an error propagation
				Classifier cl = cxtElement instanceof Classifier ? (Classifier) cxtElement
						: EMV2Util.getAssociatedClassifier(cxtElement);
				if (cl != null) {
					searchResult = cl.findNamedElement(name);
					if (searchResult != null && searchResult instanceof FeatureGroup) {
						return Collections.singletonList(searchResult);
					}
				}
				// We either have an EMV2 element or an ErrorModel Library as context for looking up types
				searchResult = findErrorType(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				searchResult = findTypeSet(cxtElement, name);
				if (searchResult != null) {
					return Collections.singletonList(searchResult);
				}
				// EMV2 path element or containment path element
			} else if (context instanceof RecoverEvent || context instanceof RepairEvent) {

				Classifier ns = EMV2Util.getAssociatedClassifier(cxt);
				searchResult = ns.findNamedElement(name);
// checked by validator
//				if (ne instanceof ModeTransition || ne instanceof EventPort || ne instanceof InternalEvent){
//					searchResult = ne;
//				}
			} else if (context instanceof FeatureorPPReference) {
				Classifier cl = null;
				if (context.eContainer() instanceof ErrorPropagation) {
					cl = EMV2Util.getAssociatedClassifier((Element) context);
				} else if (context.eContainer() instanceof FeatureorPPReference) {
					NamedElement fg = ((FeatureorPPReference) context.eContainer()).getFeatureorPP();
					if (fg instanceof FeatureGroup) {
						cl = ((FeatureGroup) fg).getFeatureGroupType();
					}
				}
				if (cl != null) {
					NamedElement ne = cl.findNamedElement(name);
					if (ne instanceof Feature || ne instanceof InternalFeature) {
						searchResult = ne;
					} else {
						// find propagation point
						searchResult = EMV2Util.findPropagationPoint(cl, name);
					}
				}
			}
			// end namedElement
		} else if (Aadl2Package.eINSTANCE.getTriggerPort() == requiredType)

		{
			Classifier ns = EMV2Util.getAssociatedClassifier((Element) context);
			NamedElement ne = ns.findNamedElement(name);
			if (ne instanceof Feature || ne instanceof InternalFeature) {
				searchResult = ne;
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorType() == requiredType)

		{
			searchResult = findErrorType(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeSet() == requiredType)

		{
			searchResult = findTypeSet(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorTypes() == requiredType)

		{
			searchResult = findErrorType(cxt, name);
			if (searchResult == null) {
				searchResult = findTypeSet(cxt, name);
			}

		} else if (ErrorModelPackage.eINSTANCE.getPropagationPoint() == requiredType)

		{
			ComponentClassifier cl;
			// find propagation point
			if (context instanceof QualifiedPropagationPoint) {
				QualifiedPropagationPoint qpp = (QualifiedPropagationPoint) context;
				SubcomponentElement sub = qpp.getSubcomponent();
				cl = sub.getSubcomponent().getAllClassifier();
				if (!Aadl2Util.isNull(cl))

				{
					searchResult = EMV2Util.findPropagationPoint(cl, name);
				}
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorModelLibrary() == requiredType)

		{
			searchResult = findErrorModelLibrary(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorPropagation() == requiredType)

		{
			if (reference.getName().equalsIgnoreCase("outgoing")) {
				searchResult = EMV2Util.findErrorPropagation(cxt, name, DirectionType.OUT);
			} else if (reference.getName().equalsIgnoreCase("incoming")) {
				searchResult = EMV2Util.findErrorPropagation(cxt, name, DirectionType.IN);
			} else {
				searchResult = EMV2Util.findErrorPropagation(cxt, name, null);
			}

		} else if (ErrorModelPackage.eINSTANCE.getTypeMappingSet() == requiredType)

		{
			searchResult = findTypeMappingSet(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeTransformationSet() == requiredType)

		{
			searchResult = findTypeTransformationSet(context, name);
		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine() == requiredType)

		{
			searchResult = findErrorBehaviorStateMachine(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorState() == requiredType)

		{
			searchResult = EMV2Util.findErrorBehaviorState((Element) context, name);

		} else if (ErrorModelPackage.eINSTANCE.getEventOrPropagation() == requiredType)

		{
// XXX allow subcomponent reference in outgoing propagation and transition as well
//			if (EMV2Util.getConditionExpressionContext((ConditionExpression) context) instanceof ErrorDetection ) {
			searchResult = EMV2Util.findSubcomponentOrIncomingErrorProparation(cxt, name);
//			}  else {
//				searchResult = EMV2Util.findIncomingErrorPropagation(cxt.getContainingClassifier(), name);
//			}
			if (searchResult == null) {
				searchResult = EMV2Util.findErrorBehaviorEvent(cxt, name);
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorEvent() == requiredType)

		{
			searchResult = EMV2Util.findErrorBehaviorEvent(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition() == requiredType)

		{
			searchResult = EMV2Util.findErrorBehaviorTransition(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorFlow() == requiredType)

		{
			searchResult = EMV2Util.findErrorFlow(EMV2Util.getAssociatedClassifier(cxt), name);

		} else if (Aadl2Package.eINSTANCE.getSubcomponent() == requiredType)

		{
//		} else if (Aadl2Package.eINSTANCE.getSubcomponent().isSuperTypeOf(requiredType)) {
			if (context instanceof SubcomponentElement) {

				EObject ce = context.eContainer().eContainer();
				Classifier ns;
				if (ce instanceof QualifiedPropagationPoint)

				{
					ns = ((QualifiedPropagationPoint) ce).getSubcomponent().getSubcomponent().getAllClassifier();
				} else if (ce instanceof QualifiedErrorBehaviorState)

				{
					ns = ((QualifiedErrorBehaviorState) ce).getSubcomponent().getSubcomponent().getAllClassifier();
				} else

				{
					ns = EMV2Util.getAssociatedClassifier(cxt);
				}
				if (ns != null)

				{
					EObject res = ns.findNamedElement(name);
					if (res instanceof Subcomponent) {
						searchResult = res;
					}
				}
			}
		} else if (Aadl2Package.eINSTANCE.getAbstractNamedValue() == requiredType) {
			// AbstractNamedValue: constant reference, property definition reference, unit literal, enumeration literal
			if (context instanceof NamedValue) {
				List<EObject> res = Collections.EMPTY_LIST;
				if (name.indexOf("::") == -1) {
					// names without qualifier. Must be enum/unit literal
					res = findEnumLiteralAsList(context, reference, name);
					if (res.isEmpty()) {
						res = findUnitLiteralAsList(context, reference, name);
					}
				}
				if (res.isEmpty()) {
					res = findPropertyConstant(context, reference, name);
				}
				if (res.isEmpty()) {
					res = findPropertyDefinitionAsList(context, reference, name);
				}
				return res;
			}

		} else if (Aadl2Package.eINSTANCE.getBasicProperty() == requiredType) {
			// look for record field definition
			if (context instanceof BasicPropertyAssociation) {
				BasicPropertyAssociation bpa = (BasicPropertyAssociation) context;
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				Element parent = bpa.getOwner();
				while (parent != null
						&& !(parent instanceof BasicPropertyAssociation || parent instanceof EMV2PropertyAssociation
								|| parent instanceof Property || parent instanceof PropertyConstant)) {
					parent = parent.getOwner();
				}
				PropertyType propertyType = null;
				if (parent instanceof BasicPropertyAssociation) {
					BasicProperty bp = ((BasicPropertyAssociation) parent).getProperty();
					if (bp != null) {
						propertyType = bp.getPropertyType();
					}
				} else if (parent instanceof EMV2PropertyAssociation) {
					Property pd = ((EMV2PropertyAssociation) parent).getProperty();
					if (pd != null) {
						propertyType = pd.getPropertyType();
					}
				} else if (parent instanceof Property) {
					propertyType = ((Property) parent).getPropertyType();
				} else if (parent instanceof PropertyConstant) {
					propertyType = ((PropertyConstant) parent).getPropertyType();
				}
				propertyType = AadlUtil.getBasePropertyType(propertyType);

				if (propertyType != null && propertyType instanceof RecordType) {
					BasicProperty rf = (BasicProperty) ((RecordType) propertyType).findNamedElement(name);
					if (rf != null) {
						searchResult = rf;
					}
				}
			}
		}

		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
//		if (cxt.getElementRoot() instanceof EMV2Root) {
		return super.getLinkedObjects(context, reference, node);
//		} else {
//			return Collections.<EObject> emptyList();
//		}
	}

	public static List<EObject> findUnitLiteralAsList(EObject context, EReference reference, String name) {
		EObject e = findUnitLiteral(context, reference, name);
		if (e == null) {
			return Collections.<EObject> emptyList();
		}
		return Collections.singletonList(e);
	}

	public static UnitLiteral findUnitLiteral(EObject context, EReference reference, String name) {
		// look for unit literal pointed to by baseUnit
		if (context instanceof UnitLiteral) {
			UnitsType unitsType = (UnitsType) ((UnitLiteral) context).getOwner();
			return (UnitLiteral) unitsType.findNamedElement(name);
		} else if (context instanceof NumberValue) {
			UnitsType unitsType = null;
			NumberValue numberValue = (NumberValue) context;
			Element owner = numberValue.getOwner();
			while (owner instanceof ListValue) {
				owner = owner.getOwner();
			}
			if (owner instanceof NumericRange) {
				// values of a number
				// property type.
				unitsType = ((NumberType) owner.getOwner()).getUnitsType();
			} else {
				if (owner instanceof RangeValue) {
					owner = owner.getOwner();
				}
				if (owner instanceof ListValue) {
					owner = owner.getOwner();
				}
				PropertyType propertyType = null;
				if (owner instanceof PropertyConstant) // Value of the
				// property
				// constant.
				{
					// TODO: Need to check that the type of the property
					// constant is correct for the value.
					// We should do this when the type of the constant is
					// resolved in PropertyTypeReference.
					propertyType = ((PropertyConstant) owner).getPropertyType();
				} else if (owner instanceof Property) // Default value of a
				// property
				// definition.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the type of the definition is
					// resolved in PropertyValuePropertyTypeReference.
					propertyType = ((Property) owner).getPropertyType();
				} else if (owner instanceof ModalPropertyValue && owner.getOwner() instanceof EMV2PropertyAssociation)
				// Value of an association.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the definition of the
					// association is resolved in
					// PropertyDefinitionReference.
					propertyType = ((EMV2PropertyAssociation) owner.getOwner()).getProperty().getPropertyType();
				} else if (owner instanceof BasicPropertyAssociation)
				// Inner value of a record value.
				{
					// TODO: Need to check that the type of the record field
					// is correct for the value.
					// We should do this when the record field of the record
					// value is resolved in PropertyRecordFieldReference.
					propertyType = ((BasicPropertyAssociation) owner).getProperty().getPropertyType();
				}
				propertyType = AadlUtil.getBasePropertyType(propertyType);
				if (propertyType instanceof NumberType) {
					unitsType = ((NumberType) propertyType).getUnitsType();
				} else if (propertyType instanceof RangeType) {
					RangeType rangeType = (RangeType) propertyType;
					// The number type could be null if the model is incomplete.
					if (rangeType.getNumberType() != null) {
						unitsType = rangeType.getNumberType().getUnitsType();
					}
				}
			}
			if (unitsType != null) {
				return unitsType.findLiteral(name);
			}
		}
		return null;
	}

	public static List<EObject> findEnumLiteralAsList(EObject context, EReference reference, String name) {
		// look for enumeration literal
		if (context instanceof NamedValue) {
			NamedValue value = (NamedValue) context;
			EObject owner = value.getOwner();
			while (owner instanceof ListValue) {
				owner = owner.eContainer();
			}
			PropertyType propertyType = null;
			if (owner instanceof PropertyConstant) // Value of the property
			// constant.
			{
				// TODO: Need to check that the type of the property
				// constant is correct for the value.
				// We should do this when the type of the constant is
				// resolved in PropertyTypeReference.
				propertyType = ((PropertyConstant) owner).getPropertyType();
			} else if (owner instanceof Property) // Default value of a
			// property definition.
			{
				// TODO: Need to check that the type of the property
				// definition is correct for the value.
				// We should do this when the type of the definition is
				// resolved in PropertyValuePropertyTypeReference.
				propertyType = ((Property) owner).getPropertyType();
			} else if (owner instanceof ModalPropertyValue && owner.eContainer() instanceof EMV2PropertyAssociation) // Value
			// of
			// an
			// association.
			{
				// TODO: Need to check that the type of the property
				// definition is correct for the value.
				// We should do this when the definition of the association
				// is resolved in PropertyDefinitionReference.
				Property p = ((EMV2PropertyAssociation) owner.eContainer()).getProperty();
				propertyType = p.getPropertyType();
			} else if (owner instanceof BasicPropertyAssociation) // Inner
			// value
			// of a
			// record
			// value.
			{
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				// We should do this when the record field of the record
				// value is resolved in PropertyRecordFieldReference.
				propertyType = ((BasicPropertyAssociation) owner).getProperty().getPropertyType();
			}

			propertyType = AadlUtil.getBasePropertyType(propertyType);
			if (propertyType != null && propertyType instanceof EnumerationType) {
				EnumerationLiteral literal = ((EnumerationType) propertyType).findLiteral(name);
				if (literal != null) {
					return Collections.singletonList((EObject) literal);
				}
			}
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * name is qualified with annex name
	 * @param context
	 * @param name
	 * @return
	 */
	public AnnexLibrary getActualAnnexLibrary(EObject context, String name) {
		return (ErrorModelLibrary) EMFIndexRetrieval.getEObjectOfType(context,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary(), name);
	}

	/**
	 * find the error model library. The String name refers to the package and the default EML name is added ("emv2")
	 * @param context context of search to identify package and EML
	 * @param name
	 * @return
	 */
	public ErrorModelLibrary findErrorModelLibrary(EObject context, String name) {
		ErrorModelLibrary eml = (ErrorModelLibrary) getActualAnnexLibrary(context, "emv2$" + name);
		if (eml != null) {
			return eml;
		}
		eml = (ErrorModelLibrary) getActualAnnexLibrary(context, name);
		if (eml != null) {
			return eml;
		}
		ErrorModelLibrary owneml = EMV2Util.getContainingErrorModelLibrary((Element) context);
		if (owneml != null) {
			AadlPackage pack = AadlUtil.getContainingPackage(context);
			if (pack != null) {
				String emlname = pack.getName();
				if (name.equalsIgnoreCase(emlname)) {
					return owneml;
				}
			}
		}
		// XXX TODO this next code should not return anything that is not already in teh global index
		AadlPackage ap = AadlUtil.findImportedPackage(name, AadlUtil.getContainingTopLevelNamespace(context));
		if (ap == null) {
			return null;
		}
		PackageSection ps = ap.getOwnedPublicSection();
		EList<AnnexLibrary> all = ps.getOwnedAnnexLibraries();
		for (AnnexLibrary al : all) {
			if (al instanceof DefaultAnnexLibrary) {
				DefaultAnnexLibrary dal = (DefaultAnnexLibrary) al;
				if (dal instanceof ErrorModelLibrary) {
					return (ErrorModelLibrary) dal.getParsedAnnexLibrary();
				}
			}
		}
		return null;
	}

	public TypeMappingSet findTypeMappingSet(EObject context, String name) {
		ErrorModelLibrary eml = findErrorModelLibrary(context, Aadl2Util.getPackageName(name));
		if (eml != null) {
			EList<TypeMappingSet> tmsl = eml.getMappings();
			for (TypeMappingSet tms : tmsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(tms.getName())) {
					return tms;
				}
			}
		}
		return null;
	}

	public TypeTransformationSet findTypeTransformationSet(EObject context, String name) {
		String packageName = Aadl2Util.getPackageName(name);
		ErrorModelLibrary eml;
		if (packageName != null) {
			eml = findErrorModelLibrary(context, packageName);
		} else {
			eml = EcoreUtil2.getContainerOfType(context, ErrorModelLibrary.class);
		}
		if (eml != null) {
			EList<TypeTransformationSet> tmsl = eml.getTransformations();
			for (TypeTransformationSet tms : tmsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(tms.getName())) {
					return tms;
				}
			}
		}
		return null;
	}

	public ErrorBehaviorStateMachine findErrorBehaviorStateMachine(EObject context, String name) {
		ErrorModelLibrary eml = findErrorModelLibrary(context, Aadl2Util.getPackageName(name));
		if (eml != null) {
			EList<ErrorBehaviorStateMachine> ebsml = eml.getBehaviors();
			for (ErrorBehaviorStateMachine ebsm : ebsml) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebsm.getName())) {
					return ebsm;
				}
			}
		}
		return null;
	}

	public ErrorType findErrorType(Element context, String typeName) {
		return (ErrorType) findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getErrorType());
	}

	public TypeSet findTypeSet(Element context, String typeName) {
		return (TypeSet) findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getTypeSet());
	}

	/**
	 * find an error type or type set
	 * The context is either an errormodel element, or a classifier as context of a containment path.
	 * @param context
	 * @param qualTypeName
	 * @param eclass
	 * @return
	 */
	public EObject findEMLNamedTypeElement(Element context, String qualTypeName, EClass eclass) {
		String packName = Aadl2Util.getPackageName(qualTypeName);
		String typeName = Aadl2Util.getItemNameWithoutQualification(qualTypeName);
		if (packName != null) {
			// qualified reference; look there only
			ErrorModelLibrary eml = findErrorModelLibrary(context, packName);
			// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
			return findEMLNamedTypeElement(eml, typeName, eclass);
		}
		EList<ErrorModelLibrary> usetypes = EMV2Util.getUseTypes(context);
		for (ErrorModelLibrary etll : usetypes) {
			// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
			EObject res = findEMLNamedTypeElement(etll, typeName, eclass);
			if (res != null) {
				return res;
			}
		}
		ErrorModelLibrary owneml = EMV2Util.getContainingErrorModelLibrary(context);
		if (context instanceof ErrorType || context instanceof TypeSet || owneml instanceof ErrorModelLibrary) {
			// lookup in own EML if we are inside an ErrorModelLibrary
			EObject res = findNamedTypeElementInThisEML(owneml, typeName, eclass);
			if (res != null)
				return res;
			if (!EMV2Util.checkCyclicExtends(owneml)) {
				EList<ErrorModelLibrary> otheremls = owneml.getExtends();
				if (otheremls != null) {
					for (ErrorModelLibrary etll : otheremls) {
						// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
						res = findEMLNamedTypeElement(etll, typeName, eclass);
						if (res != null) {
							return res;
						}
					}
				}
			}
		}
		return null;
	}

	public EObject findNamedTypeElementInThisEML(ErrorModelLibrary eml, String typeName, EClass eclass) {
		if (eml == null) {
			return null;
		}
		if (eclass == ErrorModelPackage.eINSTANCE.getErrorType()) {
			EList<ErrorType> elt = eml.getTypes();
			for (ErrorType ets : elt) {
				if (typeName.equalsIgnoreCase(ets.getName())) {
					return ets;
				}
			}
		} else {
			EList<TypeSet> elt = eml.getTypesets();
			for (TypeSet ets : elt) {
				if (typeName.equalsIgnoreCase(ets.getName())) {
					return ets;
				}
			}
		}
		return null;
	}

}
