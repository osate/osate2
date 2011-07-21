package org.osate.xtext.aadl2.linking;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordField;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.xtext.aadl2.util.PSNode;

public class Aadl2LinkingService extends DefaultLinkingService {

	public List<EObject> getIndexedObjects(EObject context,
			EReference reference, INode node) {
		return super.getLinkedObjects(context, reference, node);
	}

	@Override
	public String getCrossRefNodeAsString(INode node)
			throws IllegalNodeException {
		if (node instanceof PSNode) {
			return getLinkingHelper().getCrossRefNodeAsString(node, false);
		} else {
			return getLinkingHelper().getCrossRefNodeAsString(node, true);
		}
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
		final EClass sct = Aadl2Package.eINSTANCE.getSubcomponentType();
		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
		final String s = getCrossRefNodeAsString(node);
		if (sct.isSuperTypeOf(requiredType) || cl.isSuperTypeOf(requiredType)) {
			// resolve classifier reference
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			final int idx = s.lastIndexOf("::");
			String packname = null;
			String cname = s;
			EObject e;
			PackageSection scope = getContainingPackageSection(context);
			if (idx != -1) {
				packname = s.substring(0, idx);
				cname = s.substring(idx + 2);
			}
			e = findNamedElementInAadlPackage(packname, cname, scope);
			if (e != null && requiredType.isSuperTypeOf(e.eClass())) {
				// the result satisfied the expected class
				return Collections.singletonList((EObject) e);
			}
			return Collections.<EObject> emptyList();
		} else if (sct.isSuperTypeOf(requiredType)) {
			// need to resolve prototype
			NamedElement searchResult = getContainingClassifier(context)
					.findNamedElement(s);
			if (searchResult instanceof ComponentPrototype) {
				return Collections.singletonList((EObject) searchResult);
			}
		} else if (Aadl2Package.eINSTANCE.getModelUnit() == requiredType) {
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			AadlPackage pack = findAadlPackage(context, s);
			if (pack != null) {
				return Collections.singletonList((EObject) pack);
			}
			PropertySet ps = findPropertySet(context, s);
			if (ps != null) {
				return Collections.singletonList((EObject) ps);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getAadlPackage() == requiredType) {
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			AadlPackage pack = findAadlPackage(context, s);
			if (pack != null) {
				return Collections.singletonList((EObject) pack);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPropertySet() == requiredType) {
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			PropertySet ps = findPropertySet(context, s);
			if (ps != null) {
				return Collections.singletonList((EObject) ps);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getConnectionEnd() == requiredType) {
			// resolve connection end
			Context cxt = ((ConnectedElement) context).getContext();
			Connection conn = (Connection) context.eContainer();
			ConnectionEnd ce = null;
			if (conn instanceof PortConnection) {
				ce = findPortConnectionEnd(
						(PortConnection) context.eContainer(), cxt, s);
			} else if (conn instanceof AccessConnection) {
				ce = findAccessConnectionEnd(
						(AccessConnection) context.eContainer(), cxt, s);
			} else if (conn instanceof FeatureGroupConnection) {
				ce = findFeatureGroupConnectionEnd(
						(FeatureGroupConnection) context.eContainer(), cxt, s);
			} else if (conn instanceof FeatureConnection) {
				ce = findFeatureConnectionEnd(
						(FeatureConnection) context.eContainer(), cxt, s);
			} else if (conn instanceof ParameterConnection) {
				ce = findParameterConnectionEnd(
						(ParameterConnection) context.eContainer(), cxt, s);
			}
			if (ce != null) {
				return Collections.singletonList((EObject) ce);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPort() == requiredType) {
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Feature) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null && searchResult instanceof Port) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFeature() == requiredType) {
			// Feature used in FlowSpec
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Feature) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null && searchResult instanceof Feature) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getContext() == requiredType) {
			// represents connection source/dest context as well as flowspec
			// context
			// also used in triggerport
			EObject searchResult = getContainingClassifier(context)
					.findNamedElement(s);
			if (context instanceof ConnectedElement) {
				// connection context
				EObject conn = context.eContainer();
				if (((conn instanceof FeatureGroupConnection
						|| conn instanceof FeatureConnection || conn instanceof AccessConnection) && (searchResult instanceof Subcomponent || searchResult instanceof FeatureGroup))
						|| ((conn instanceof ParameterConnection) && (searchResult instanceof Parameter
								|| searchResult instanceof SubprogramCall
								|| searchResult instanceof DataPort
								|| searchResult instanceof EventDataPort || searchResult instanceof FeatureGroup))
						|| ((conn instanceof PortConnection) && (searchResult instanceof FeatureGroup
								|| searchResult instanceof Subcomponent
								|| searchResult instanceof DataPort || searchResult instanceof EventDataPort)))
					return Collections.singletonList((EObject) searchResult);
			} else if (context instanceof TriggerPort
					|| context instanceof FlowSpecification
					|| context instanceof FlowSegment) {
				if (searchResult instanceof Subcomponent)
					return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCallContext() == requiredType) {
			EObject searchResult = getContainingClassifier(context)
					.findNamedElement(s);
			if (searchResult != null
					&& requiredType.isSuperTypeOf(searchResult.eClass())) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getCalledSubprogram() == requiredType) {
			// if cxt then search in context
			Classifier ns = getContainingClassifier(context);
			CallContext cxt = null;
			if (reference.getFeatureID() == Aadl2Package.SUBPROGRAM_CALL__CONTEXT) {
				cxt = ((SubprogramCall) context).getContext();
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null
					&& requiredType.isSuperTypeOf(searchResult.eClass())) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getPrototype() == requiredType) {
			// if context prototype then find in extension source (refined)
			// prototype binding as context
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Prototype) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null && searchResult instanceof Prototype) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getSubcomponent() == requiredType) {
			// if context Subcomponent then find in extension source (refined
			// to)
			// prototype binding as context
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Subcomponent) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult instanceof Subcomponent) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getProperty() == requiredType) {
			// look for property definition in property set
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			String psname = null;
			String pname = s;
			final int idx = s.lastIndexOf("::");
			if (idx != -1) {
				psname = s.substring(0, idx);
				pname = s.substring(idx + 2);
			}
			EObject e = findNamedElementInPropertySet(psname, pname,
					getContainingTopLevelNamespace(context), reference);
			if (e != null && e instanceof Property) {
				return Collections.singletonList((EObject) e);
			}
			return Collections.<EObject> emptyList();

		} else if (pt.isSuperTypeOf(requiredType)
				|| Aadl2Package.eINSTANCE.getType() == requiredType) {
			// look for property type in property set
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			String psname = null;
			String pname = s;
			final int idx = s.lastIndexOf("::");
			if (idx != -1) {
				psname = s.substring(0, idx);
				pname = s.substring(idx + 2);
			}
			EObject e = findNamedElementInPropertySet(psname, pname,
					getContainingPropertySet(context), reference);
			if (e != null && e instanceof PropertyType) {
				return Collections.singletonList((EObject) e);
			}
			return Collections.<EObject> emptyList();
			// AbstractNamedValue: constant reference, unit, enum,

		} else if (Aadl2Package.eINSTANCE.getPropertyConstant() == requiredType
				|| (Aadl2Package.eINSTANCE.getAbstractNamedValue() == requiredType && context instanceof NamedValue)) {
			// look for property constant in property set
			List<EObject> res = getIndexedObjects(context, reference, node);
			if (!res.isEmpty())
				return res;
			String psname = null;
			String pname = s;
			final int idx = s.lastIndexOf("::");
			if (idx != -1) {
				psname = s.substring(0, idx);
				pname = s.substring(idx + 2);
			}
			EObject e = findNamedElementInPropertySet(psname, pname,
					getContainingPropertySet(context), reference);
			if (e != null && e instanceof PropertyConstant) {
				return Collections.singletonList((EObject) e);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getUnitLiteral() == requiredType) {
			// look for unit literal pointed to by baseUnit
			if (context instanceof UnitLiteral) {
				UnitsType unitsType = (UnitsType) ((UnitLiteral) context)
						.getOwner();
				UnitLiteral baseUnit = (UnitLiteral) unitsType
						.findNamedElement(s);
				if (baseUnit != null) {
					if (unitsType.getOwnedLiterals().indexOf(baseUnit) < unitsType
							.getOwnedLiterals()
							.indexOf(((UnitLiteral) context)))
						return Collections.singletonList((EObject) baseUnit);
				}
			} else if (context instanceof NumberValue) {
				UnitsType unitsType = null;
				NumberValue numberValue = (NumberValue) context;
				Element owner = numberValue.getOwner();
				while (owner instanceof ListValue)
					owner = owner.getOwner();
				if (owner instanceof NumericRange) // Lower bound or upper bound
													// values of a number
													// property type.
					unitsType = ((NumberType) owner.getOwner()).getUnitsType();
				else {
					if (owner instanceof RangeValue)
						owner = owner.getOwner();
					PropertyType propertyType = null;
					if (owner instanceof PropertyConstant) // Value of the
															// property
															// constant.
					{
						// TODO: Need to check that the type of the property
						// constant is correct for the value.
						// We should do this when the type of the constant is
						// resolved in PropertyTypeReference.
						propertyType = (PropertyType) ((PropertyConstant) owner)
								.getType();
					} else if (owner instanceof Property) // Default value of a
															// property
															// definition.
					{
						// TODO: Need to check that the type of the property
						// definition is correct for the value.
						// We should do this when the type of the definition is
						// resolved in PropertyValuePropertyTypeReference.
						propertyType = (PropertyType) ((Property) owner)
								.getType();
					} else if (owner instanceof ModalPropertyValue
							&& owner.getOwner() instanceof PropertyAssociation) // Value
																				// of
																				// an
																				// association.
					{
						// TODO: Need to check that the type of the property
						// definition is correct for the value.
						// We should do this when the definition of the
						// association is resolved in
						// PropertyDefinitionReference.
						propertyType = (PropertyType) ((PropertyAssociation) owner
								.getOwner()).getProperty().getType();
					} else if (owner instanceof BasicPropertyAssociation) // Inner
																			// value
																			// of
																			// a
																			// record
																			// value.
					{
						// TODO: Need to check that the type of the record field
						// is correct for the value.
						// We should do this when the record field of the record
						// value is resolved in PropertyRecordFieldReference.
						propertyType = (PropertyType) ((BasicPropertyAssociation) owner)
								.getProperty().getType();
					}
					if (propertyType instanceof NumberType)
						unitsType = ((NumberType) propertyType).getUnitsType();
					else if (propertyType instanceof RangeType)
						unitsType = ((RangeType) propertyType).getNumberType()
								.getUnitsType();
				}
				if (unitsType != null) {
					UnitLiteral literal = (UnitLiteral) unitsType
							.findNamedElement(s);
					if (literal != null)
						return Collections.singletonList((EObject) literal);
				}
			}

			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEnumerationLiteral() == requiredType) {
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
					propertyType = (PropertyType) ((PropertyConstant) owner)
							.getType();
				} else if (owner instanceof Property) // Default value of a
														// property definition.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the type of the definition is
					// resolved in PropertyValuePropertyTypeReference.
					propertyType = (PropertyType) ((Property) owner).getType();
				} else if (owner instanceof ModalPropertyValue
						&& owner.eContainer() instanceof PropertyAssociation) // Value
																				// of
																				// an
																				// association.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the definition of the association
					// is resolved in PropertyDefinitionReference.
					propertyType = (PropertyType) ((PropertyAssociation) owner
							.eContainer()).getProperty().getType();
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
					propertyType = (PropertyType) ((BasicPropertyAssociation) owner)
							.getProperty().getType();
				}
				if (propertyType != null
						&& propertyType instanceof EnumerationType) {
					EnumerationLiteral literal = (EnumerationLiteral) ((EnumerationType) propertyType)
							.findNamedElement(s);
					if (literal != null)
						return Collections.singletonList((EObject) literal);
				}
			}

			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getRecordField() == requiredType) {
			// look for record field definition
			if (context instanceof BasicPropertyAssociation) {
				BasicPropertyAssociation bpa = (BasicPropertyAssociation) context;
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				// We should do this when the record field of the record value
				// is resolved in PropertyRecordFieldReference.
				PropertyType propertyType = (PropertyType) bpa.getProperty()
						.getType();
				if (propertyType != null && propertyType instanceof RecordType) {
					RecordField rf = (RecordField) ((RecordType) propertyType)
							.findNamedElement(s);
					if (rf != null)
						return Collections.singletonList((EObject) rf);
				}
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getMode() == requiredType) {
			// referenced by mode transition and inmodes
			EObject searchResult = getContainingClassifier(context)
					.findNamedElement(s);
			if (searchResult != null && searchResult instanceof Mode) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getModeTransition() == requiredType) {
			// referenced by in modes
			EObject searchResult = getContainingClassifier(context)
					.findNamedElement(s);
			if (searchResult != null && searchResult instanceof ModeTransition) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getFlowSpecification() == requiredType) {
			// refined flow spec
			// referenced by flow implementation
			// also referenced in flow elements in impl and etef
			Classifier ns = getContainingClassifier(context);
			if (context instanceof FlowSpecification) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null
					&& searchResult instanceof FlowSpecification) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getEndToEndFlow() == requiredType) {
			// refined flow spec
			// referenced by flow implementation
			// also referenced in flow elements in impl and etef
			Classifier ns = getContainingClassifier(context);
			if (context instanceof EndToEndFlow) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null && searchResult instanceof EndToEndFlow) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();

		} else if (Aadl2Package.eINSTANCE.getConnection() == requiredType) {
			// refined to, flow elements
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Connection) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject searchResult = ns.findNamedElement(s);
			if (searchResult != null && searchResult instanceof Connection) {
				return Collections.singletonList((EObject) searchResult);
			}
			return Collections.<EObject> emptyList();
		} else if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			// containment path element
			if (context instanceof ContainmentPathElement) {
				EObject searchResult = null;
				ContainedNamedElement path = (ContainedNamedElement) context
						.eContainer();
				EList<ContainmentPathElement> list = path
						.getContainmentPathElements();
				int idx = list.indexOf(context);
				if (idx > 0) {
					ContainmentPathElement el = list.get(idx - 1);
					NamedElement ne = el.getNamedElement();
					if (ne instanceof Subcomponent) {
						Classifier ns = ((Subcomponent) ne).getClassifier();
						if (ns != null)
							searchResult = ns.findNamedElement(s);
					} else if (ne instanceof FeatureGroup) {
						Classifier ns = ((FeatureGroup) ne)
								.getFeatureGroupType();
						if (ns != null)
							searchResult = ns.findNamedElement(s);
					}
				} else {
					Classifier ns = getContainingClassifier(context);
					if (ns != null)
						searchResult = ns.findNamedElement(s);
				}
				if (searchResult != null
						&& searchResult instanceof NamedElement) {
					return Collections.singletonList((EObject) searchResult);
				}
			}
			return Collections.<EObject> emptyList();
		}

		return Collections.emptyList();
	}

	public static ConnectionEnd findPortConnectionEnd(PortConnection conn,
			Context cxt, String portName) {
		if (cxt == null) {
			EObject searchResult = ((ComponentImplementation) getContainingClassifier(conn))
					.findNamedElement(portName);
			if (searchResult instanceof Port
					|| searchResult instanceof DataSubcomponent
					|| (searchResult instanceof DataAccess && ((DataAccess) searchResult)
							.getKind() == AccessType.REQUIRED))
				return ((ConnectionEnd) searchResult);
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				EObject searchResult = subcomponent.getClassifier()
						.findNamedElement(portName);
				if (searchResult instanceof Port
						|| (cxt instanceof DataSubcomponent && searchResult instanceof DataSubcomponent)
						|| // data subcomponent . data subcomponent
						(searchResult instanceof DataAccess && ((DataAccess) searchResult)
								.getKind() == AccessType.PROVIDED))
					return ((ConnectionEnd) searchResult);
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(portName);
					if (searchResult instanceof DataSubcomponent)
						return ((DataSubcomponent) searchResult);
				}
			}
		} else if (cxt instanceof DataPort || cxt instanceof EventDataPort)
		// DataPort or EventDataPort . data element
		{
			Feature context = (Port) cxt;
			while (context.getClassifier() == null
					&& context.getPrototype() == null
					&& context.getRefined() != null)
				context = context.getRefined();
			if (context.getClassifier() != null) {
				NamedElement searchResult = context.getClassifier()
						.findNamedElement(portName);
				if (searchResult instanceof DataSubcomponent)
					return ((DataSubcomponent) searchResult);
			} else if (context.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						(ComponentPrototype) context.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(portName);
					if (searchResult instanceof DataSubcomponent)
						return ((DataSubcomponent) searchResult);
				}
			}
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(portName);
				if (searchResult instanceof PortConnectionEnd)
					return ((PortConnectionEnd) searchResult);
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(portName);
					if (searchResult instanceof PortConnectionEnd)
						return ((PortConnectionEnd) searchResult);
				}
			}
		}
		return null;
	}

	public static ConnectionEnd findAccessConnectionEnd(AccessConnection conn,
			Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(conn)
					.findNamedElement(name);
			if (searchResult instanceof AccessConnectionEnd)
				return (AccessConnectionEnd) searchResult;
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof Access)
					return (Access) searchResult;
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof Access)
						return (Access) searchResult;
				}
			}
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof Access)
					return (Access) searchResult;
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof Access)
						return (Access) searchResult;
				}
			}
		}
		return null;
	}

	public static ConnectionEnd findParameterConnectionEnd(
			ParameterConnection conn, Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(conn)
					.findNamedElement(name);
			if (searchResult instanceof ParameterConnectionEnd)
				return (ParameterConnectionEnd) searchResult;
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof ParameterConnectionEnd)
					return (ParameterConnectionEnd) searchResult;
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof ParameterConnectionEnd)
						return (ParameterConnectionEnd) searchResult;
				}
			}
		} else if (cxt instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) cxt;
			if (subprogramCall.getCalledSubprogram() instanceof SubprogramClassifier) {
				NamedElement searchResult = ((SubprogramClassifier) subprogramCall
						.getCalledSubprogram()).findNamedElement(name);
				if (searchResult instanceof Parameter)
					return (Parameter) searchResult;
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramSubcomponent) {
				Subcomponent subcomponent = (SubprogramSubcomponent) subprogramCall
						.getCalledSubprogram();
				while (subcomponent.getClassifier() == null
						&& subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement searchResult = subcomponent.getClassifier()
							.findNamedElement(name);
					if (searchResult instanceof Parameter)
						return (Parameter) searchResult;
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(conn),
							subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement searchResult = classifier
								.findNamedElement(name);
						if (searchResult instanceof Parameter)
							return (Parameter) searchResult;
					}
				}
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramAccess) {
				Feature access = (SubprogramAccess) subprogramCall
						.getCalledSubprogram();
				while (access.getClassifier() == null
						&& access.getPrototype() == null
						&& access.getRefined() != null)
					access = access.getRefined();
				if (access.getClassifier() != null) {
					NamedElement searchResult = access.getClassifier()
							.findNamedElement(name);
					if (searchResult instanceof Parameter)
						return (Parameter) searchResult;
				} else if (access.getPrototype() instanceof ComponentPrototype) {
					CallContext callContext = subprogramCall.getContext();
					if (callContext instanceof AbstractType
							|| callContext instanceof DataType
							|| callContext instanceof SubprogramGroupType) {
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								(ComponentType) callContext,
								(ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier
									.findNamedElement(name);
							if (searchResult instanceof Parameter)
								return (Parameter) searchResult;
						}
					} else if (callContext instanceof FeatureGroup) {
						FeatureGroup callContextFeatureGroup = (FeatureGroup) callContext;
						FeatureGroupType prototypeContext;
						while (callContextFeatureGroup.getFeatureGroupType() == null
								&& callContextFeatureGroup.getPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup
									.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null)
							prototypeContext = callContextFeatureGroup
									.getFeatureGroupType();
						else if (callContextFeatureGroup.getPrototype() instanceof FeatureGroupPrototype) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									getContainingClassifier(conn),
									(FeatureGroupPrototype) callContextFeatureGroup
											.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(
									prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier
										.findNamedElement(name);
								if (searchResult instanceof Parameter)
									return (Parameter) searchResult;
							}
						}
					} else if (callContext instanceof SubprogramGroupAccess) {
						Feature callContextAccess = (SubprogramGroupAccess) callContext;
						Classifier prototypeContext;
						while (callContextAccess.getClassifier() == null
								&& callContextAccess.getPrototype() == null
								&& callContextAccess.getRefined() != null) {
							callContextAccess = callContextAccess.getRefined();
						}
						if (callContextAccess.getClassifier() != null)
							prototypeContext = callContextAccess
									.getClassifier();
						else if (callContextAccess.getPrototype() instanceof ComponentPrototype) {
							prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(conn),
									(ComponentPrototype) callContextAccess
											.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(
									prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier
										.findNamedElement(name);
								if (searchResult instanceof Parameter)
									return (Parameter) searchResult;
							}
						}
					} else if (callContext instanceof SubprogramGroupSubcomponent) {
						Subcomponent callContextSubcomponent = (SubprogramGroupSubcomponent) callContext;
						while (callContextSubcomponent.getClassifier() == null
								&& callContextSubcomponent.getPrototype() == null
								&& callContextSubcomponent.getRefined() != null) {
							callContextSubcomponent = callContextSubcomponent
									.getRefined();
						}
						if (callContextSubcomponent.getClassifier() != null) {
							ComponentClassifier classifier;
							if (callContextSubcomponent
									.getOwnedPrototypeBindings().isEmpty()) {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										(ComponentPrototype) access
												.getPrototype());
							} else {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										callContextSubcomponent,
										(ComponentPrototype) access
												.getPrototype());
							}
							if (classifier != null) {
								NamedElement searchResult = classifier
										.findNamedElement(name);
								if (searchResult instanceof Parameter)
									return (Parameter) searchResult;
							}
						} else if (callContextSubcomponent.getPrototype() != null) {
							Classifier prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(conn),
									callContextSubcomponent.getPrototype());
							if (prototypeContext != null) {
								ComponentClassifier classifier = findClassifierForComponentPrototype(
										prototypeContext,
										(ComponentPrototype) access
												.getPrototype());
								if (classifier != null) {
									NamedElement searchResult = classifier
											.findNamedElement(name);
									if (searchResult instanceof Parameter)
										return (Parameter) searchResult;
								}
							}
						}
					} else // callContext is null.
					{
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								getContainingClassifier(conn),
								(ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier
									.findNamedElement(name);
							if (searchResult instanceof Parameter)
								return (Parameter) searchResult;
						}
					}
				}
			} else // subprogramCall.getCalledSubprogram() is null. The
					// subprogram call refers to a prototype.
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						(ComponentPrototype) subprogramCall.getCalledSubprogram());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof Parameter)
						return (Parameter) searchResult;
				}
			}
		} else // connection.getSourceContext() is a Parameter, DataPort, or
				// EventDataPort
		{
			Feature sourceContext = (Feature) cxt;
			while (sourceContext.getClassifier() == null
					&& sourceContext.getPrototype() == null
					&& sourceContext.getRefined() != null) {
				sourceContext = sourceContext.getRefined();
			}
			if (sourceContext.getClassifier() != null) {
				NamedElement searchResult = sourceContext.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof DataSubcomponent)
					return (DataSubcomponent) searchResult;
			} else if (sourceContext.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						(ComponentPrototype) sourceContext.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof DataSubcomponent)
						return (DataSubcomponent) searchResult;
				}
			}
		}
		return null;
	}

	public static ConnectionEnd findFeatureGroupConnectionEnd(
			FeatureGroupConnection connection, Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(connection)
					.findNamedElement(name);
			if (searchResult instanceof FeatureGroupConnectionEnd)
				return (FeatureGroupConnectionEnd) searchResult;
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					return (FeatureGroupConnectionEnd) searchResult;
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						return (FeatureGroupConnectionEnd) searchResult;
				}
			}
		} else // connection.getSourceContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					return (FeatureGroupConnectionEnd) searchResult;
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						return ((FeatureGroupConnectionEnd) searchResult);
				}
			}
		}
		return null;
	}

	public static ConnectionEnd findFeatureConnectionEnd(
			FeatureConnection connection, Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(connection)
					.findNamedElement(name);
			if (searchResult instanceof FeatureConnectionEnd)
				return ((FeatureConnectionEnd) searchResult);
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof FeatureConnectionEnd)
					return ((FeatureConnectionEnd) searchResult);
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof FeatureConnectionEnd)
						return ((FeatureConnectionEnd) searchResult);
				}
			}
		} else // connection.getSourceContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof FeatureConnectionEnd)
					return ((FeatureConnectionEnd) searchResult);
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof FeatureConnectionEnd)
						return ((FeatureConnectionEnd) searchResult);
				}
			}
		}
		return null;
	}

	// private String reconstructPath(List<ContainmentPathElement> path)
	// {
	// if (path.size() == 0)
	// throw new IllegalArgumentException("path cannot be an empty list.");
	// StringBuilder pathAsString = new
	// StringBuilder(path.get(0).getNamedElement().getName());
	// for (int i = 1; i < path.size(); i++)
	// {
	// pathAsString.append('.');
	// pathAsString.append(path.get(i).getNamedElement().getName());
	// }
	// return pathAsString.toString();
	// }

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference,
	 * PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference. Based on the type of
	 * containingClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes. Example:
	 * 
	 * abstract a prototypes p1: subprogram group; p2: subprogram group; end a;
	 * 
	 * abstract implementation a.i ( p1 => p2, p2 => p1) subcomponents sub:
	 * subprogram group p1; calls sequence1: { call1: subprogram
	 * sub.access_feature_1; end a.i;
	 * 
	 * This will cause a stack overflow!
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(
			Classifier containingClassifier, ComponentPrototype prototype) {
		// TODO: Need to check that the prototype binding is a component
		// prototype binding. In PrototypeFormalReference,
		// we should check that component prototypes are bound by component
		// prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(
				containingClassifier, prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			SubcomponentType st = ((ComponentPrototypeActual) binding
					.getActuals().get(0)).getSubcomponentType();
			if (st instanceof ComponentClassifier)
				return (ComponentClassifier) st;
			else // It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						containingClassifier, (ComponentPrototype) st);
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null
				&& prototype.getRefined() != null) {
			// TODO: Need to check that the component prototype refines a
			// component prototype.
			// This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference,
	 * PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference. Based on the type of
	 * classifierPrototypeContext: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(
			Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext,
			ComponentPrototype prototype) {
		// TODO: Need to check that the prototype binding is a component
		// prototype binding. In PrototypeFormalReference,
		// we should check that component prototypes are bound by component
		// prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(
				classifierPrototypeContext, subcomponentPrototypeContext,
				prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			SubcomponentType st = ((ComponentPrototypeActual) binding
					.getActuals().get(0)).getSubcomponentType();
			if (st instanceof ComponentClassifier)
				return (ComponentClassifier) st;
			else // It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						classifierPrototypeContext,
						subcomponentPrototypeContext, ((ComponentPrototype) st));
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null
				&& prototype.getRefined() != null) {
			// TODO: Need to check that the component prototype refines a
			// component prototype.
			// This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * ClassifierReference, PrototypeOrClassifierReference,
	 * ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	// private ComponentClassifier
	// findClassifierForComponentPrototype(Classifier topLevelClassifier,
	// List<Subcomponent> subcomponents,
	// ComponentPrototype prototype)
	// {
	// if (subcomponents.size() == 1)
	// {
	// ComponentPrototypeBinding binding =
	// (ComponentPrototypeBinding)findPrototypeBinding(topLevelClassifier,
	// prototype);
	// if (binding != null && binding.getActuals().size() >= 1)
	// {
	// if (binding.getActuals().get(0) instanceof ComponentReference)
	// return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
	// else //It is a ComponentPrototypeReference
	// {
	// ComponentClassifier classifierForReferencedPrototype =
	// findClassifierForComponentPrototype(topLevelClassifier,
	// subcomponents,
	// ((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
	// if (classifierForReferencedPrototype != null)
	// return classifierForReferencedPrototype;
	// }
	// }
	// }
	// else
	// {
	// ComponentPrototypeBinding binding =
	// (ComponentPrototypeBinding)findPrototypeBinding(getContainingClassifier(subcomponents.get(subcomponents.size()
	// - 1)),
	// prototype);
	// if (binding != null && binding.getActuals().size() >= 1)
	// {
	// if (binding.getActuals().get(0) instanceof ComponentReference)
	// return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
	// else //It is a ComponentPrototypeReference
	// {
	// ComponentClassifier classifierForReferencedPrototype =
	// findClassifierForComponentPrototype(topLevelClassifier,
	// subcomponents,
	// ((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
	// if (classifierForReferencedPrototype != null)
	// return classifierForReferencedPrototype;
	// }
	// }
	// else
	// {
	// binding =
	// (ComponentPrototypeBinding)findPrototypeBinding(subcomponents.get(subcomponents.size()
	// - 2), prototype);
	// if (binding != null)
	// {
	// if (binding.getActuals().get(0) instanceof ComponentReference)
	// return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
	// else //It is a ComponentPrototypeReference
	// {
	// ComponentClassifier classifierForReferencedPrototype =
	// findClassifierForComponentPrototype(topLevelClassifier,
	// subcomponents.subList(0, subcomponents.size() - 1),
	// ((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
	// if (classifierForReferencedPrototype != null)
	// return classifierForReferencedPrototype;
	// }
	// }
	// }
	// }
	// while (prototype.getConstrainingClassifier() == null &&
	// prototype.getRefined() != null)
	// {
	// //TODO: Need to check that the component prototype refines a component
	// prototype.
	// // This should be done in ComponentPrototypeRefinementReference.
	// prototype = (ComponentPrototype)prototype.getRefined();
	// }
	// if (prototype.getConstrainingClassifier() != null)
	// return prototype.getConstrainingClassifier();
	// else
	// return null;
	// }

	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference,
	 * PrototypeOrFeatureGroupTypeReference,
	 * FeatureGroupPrototypeClassifierReference,
	 * FeatureGroupPrototypeRefinementReference. Based on the type of
	 * containingClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	// TODO: Check for circular dependencies with prototypes.
	private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(
			Classifier containingClassifier, FeatureGroupPrototype prototype) {
		// TODO: Need to check that the prototype binding is a feature group
		// prototype binding. In PrototypeFormalReference,
		// we should check that feature group prototypes are bound by feature
		// group prototype bindings.
		FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(
				containingClassifier, prototype);
		if (binding != null) {
			if (binding.getActual() instanceof FeatureGroupReference)
				return ((FeatureGroupReference) binding.getActual())
						.getFeatureGroupType();
			else // It is a FeatureGroupPrototypeReference
			{
				FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
						containingClassifier,
						((FeatureGroupPrototypeReference) binding.getActual())
								.getPrototype());
				if (featureGroupTypeForReferencedPrototype != null)
					return featureGroupTypeForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingFeatureGroupType() == null
				&& prototype.getRefined() != null) {
			// TODO: Need to check that the feature group prototype refines a
			// feature group prototype.
			// This should be done in FeatureGroupPrototypeRefinementReference.
			prototype = (FeatureGroupPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingFeatureGroupType() != null)
			return prototype.getConstrainingFeatureGroupType();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference,
	 * PrototypeOrFeatureGroupTypeReference,
	 * FeatureGroupPrototypeClassifierReference,
	 * FeatureGroupPrototypeRefinementReference. Based on the type of
	 * topLevelClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	// TODO: Check for circular dependencies with prototypes.
	// private FeatureGroupType
	// findFeatureGroupTypeForFeatureGroupPrototype(Classifier
	// topLevelClassifier,
	// List<StructuralFeature> subcomponentsAndFeatureGroups,
	// FeatureGroupPrototype prototype)
	// {
	// if (subcomponentsAndFeatureGroups.size() == 1)
	// {
	// FeatureGroupPrototypeBinding binding =
	// (FeatureGroupPrototypeBinding)findPrototypeBinding(topLevelClassifier,
	// prototype);
	// if (binding != null)
	// {
	// if (binding.getActual() instanceof FeatureGroupReference)
	// return
	// ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
	// else //It is a FeatureGroupPrototypeReference
	// {
	// FeatureGroupType featureGroupTypeForReferencedPrototype =
	// findFeatureGroupTypeForFeatureGroupPrototype(topLevelClassifier,
	// subcomponentsAndFeatureGroups,
	// ((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
	// if (featureGroupTypeForReferencedPrototype != null)
	// return featureGroupTypeForReferencedPrototype;
	// }
	// }
	// }
	// else
	// {
	// FeatureGroupPrototypeBinding binding =
	// (FeatureGroupPrototypeBinding)findPrototypeBinding(
	// getContainingClassifier(subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size()
	// - 1)), prototype);
	// if (binding != null)
	// {
	// if (binding.getActual() instanceof FeatureGroupReference)
	// return
	// ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
	// else //It is a FeatureGroupPrototypeReference
	// {
	// FeatureGroupType featureGroupTypeForReferencedPrototype =
	// findFeatureGroupTypeForFeatureGroupPrototype(topLevelClassifier,
	// subcomponentsAndFeatureGroups,
	// ((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
	// if (featureGroupTypeForReferencedPrototype != null)
	// return featureGroupTypeForReferencedPrototype;
	// }
	// }
	// else if
	// (subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() -
	// 2) instanceof Subcomponent)
	// {
	// binding = (FeatureGroupPrototypeBinding)findPrototypeBinding(
	// (Subcomponent)subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size()
	// - 2), prototype);
	// if (binding != null)
	// {
	// if (binding.getActual() instanceof FeatureGroupReference)
	// return
	// ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
	// else //It is a FeatureGroupPrototypeReference
	// {
	// FeatureGroupType featureGroupTypeForReferencedPrototype =
	// findFeatureGroupTypeForFeatureGroupPrototype(topLevelClassifier,
	// subcomponentsAndFeatureGroups.subList(0,
	// subcomponentsAndFeatureGroups.size() - 1),
	// ((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
	// if (featureGroupTypeForReferencedPrototype != null)
	// return featureGroupTypeForReferencedPrototype;
	// }
	// }
	// }
	// }
	// while (prototype.getConstrainingFeatureGroupType() == null &&
	// prototype.getRefined() != null)
	// prototype = (FeatureGroupPrototype)prototype.getRefined();
	// if (prototype.getConstrainingFeatureGroupType() != null)
	// return prototype.getConstrainingFeatureGroupType();
	// else
	// return null;
	// }

	public static AadlPackage findImportedPackage(String name, EObject context) {
		EList<ModelUnit> imports;
		if (!(context instanceof PropertySet || context instanceof PackageSection)) {
			context = getContainingTopLevelNamespace(context);
		}
		if (context instanceof PropertySet)
			imports = ((PropertySet) context).getImportedUnits();
		else
			imports = ((PackageSection) context).getImportedUnits();
		for (ModelUnit imported : imports) {
			if (imported instanceof AadlPackage) {
				String n = ((AadlPackage) imported).getName();
				if (name.equalsIgnoreCase(n))
					return (AadlPackage) imported;
			}
		}
		if (context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null)
			for (ModelUnit imported : ((AadlPackage) context.eContainer())
					.getOwnedPublicSection().getImportedUnits())
				if (imported instanceof AadlPackage
						&& ((AadlPackage) imported).getName().equalsIgnoreCase(
								name))
					return (AadlPackage) imported;
		// TODO need to handle public section declared in a separate package
		// declaration
		return null;
	}

	public static PropertySet findImportedPropertySet(String name,
			EObject context) {
		EList<ModelUnit> importedPropertySets;
		if (!(context instanceof PropertySet || context instanceof PackageSection)) {
			context = getContainingTopLevelNamespace(context);
		}
		if (context instanceof PropertySet)
			importedPropertySets = ((PropertySet) context).getImportedUnits();
		else
			importedPropertySets = ((PackageSection) context)
					.getImportedUnits();
		for (ModelUnit importedPropertySet : importedPropertySets)
			if (importedPropertySet instanceof PropertySet
					&& ((PropertySet) importedPropertySet).getName()
							.equalsIgnoreCase(name))
				return (PropertySet) importedPropertySet;
		return null;
	}

	public static PackageSection getContainingPackageSection(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PackageSection))
			container = container.eContainer();
		return (PackageSection) container;
	}

	public static PropertySet getContainingPropertySet(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PropertySet))
			container = container.eContainer();
		return (PropertySet) container;
	}

	public static Namespace getContainingTopLevelNamespace(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PackageSection)
				&& !(container instanceof PropertySet))
			container = container.eContainer();
		return (Namespace) container;
	}

	public static Namespace getContainingNamespace(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof Namespace))
			container = container.eContainer();
		return (Namespace) container;
	}

	// private PropertyAssociation
	// getContainingPropertyAssociation(ContainmentPathElement pathElement)
	// {
	// EObject container = pathelement.eContainer();
	// while (container != null && !(container instanceof PropertyAssociation))
	// container = container.eContainer();
	// return (PropertyAssociation)container;
	// }

	/**
	 * Search for a {@link NamedElement} in a package. If {@code context} is a
	 * {@link PublicPackageSection}, then this method will search through the
	 * {@link PublicPackageSection} only. If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will search through the
	 * {@link PrivatePackageSection} and its corresponding
	 * {@link PublicPackageSection}. This is different from
	 * {@link PrivatePackageSection#findNamedElement(String)} and
	 * {@link PrivatePackageSection#findNamedElement(String, boolean)} because
	 * those methods will not search through the corresponding
	 * {@link PublicPackageSection}. This method does use
	 * {@link PackageSection#findNamedElement(String, boolean)}, so it will
	 * search for {@link ComponentType}s and {@link FeatureGroupType}s in the
	 * renames statements.
	 * 
	 * Dependencies: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 * 
	 * @param name
	 *            The name of the {@link NamedElement} to search for.
	 * @param context
	 *            The {@link PackageSection} that contains the {@link Element}
	 *            that needs the search result.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public static NamedElement findNamedElementInAadlPackage(String name,
			PackageSection context) {
		NamedElement result = context.findNamedElement(name);
		if (result == null
				&& context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null)
			result = ((AadlPackage) context.eContainer())
					.getOwnedPublicSection().findNamedElement(name);
		return result;
	}

	/**
	 * Search for a {@link NamedElement} with the name {@code elementName} in
	 * the package specified by {@code packageName}. This method will first
	 * check that the specified package is accessible within {@code context}.
	 * This is done by checking that {@code packageName} appears in a with
	 * statement or package rename of {@code context} or {@code context}'s
	 * corresponding {@link PublicPackageSection} if {@code context} is a
	 * {@link PrivatePackageSection}. If the package is not accessible, then
	 * {@code null} will be returned. If the element cannot be found in the
	 * specified package, then {@code null} will be returned.
	 * 
	 * Dependencies: If packageName is null or refers to context: RenamesAll,
	 * ComponentTypeRename, FeatureGroupTypeRename. If packageName refers to a
	 * different package: WithStatementReference, PackageRenameReference.
	 * 
	 * @param packageName
	 *            The name of the package that contains the element to search
	 *            for.
	 * @param elementName
	 *            The name of the element to search for.
	 * @param context
	 *            The {@link PackageSection} that needs to refer to the
	 *            specified {@link Element}.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public static EObject findNamedElementInAadlPackage(String packageName,
			String elementName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || /*
											 * phf:
											 * ((AadlPackage)context.eContainer
											 * ())
											 */context.getName()
						.equalsIgnoreCase(packageName)))
			return findNamedElementInAadlPackage(elementName,
					(PackageSection) context);
		else {
			AadlPackage aadlPackage = null;

			if (context instanceof PackageSection) {
				PackageRename packageRename = findPackageRename(packageName,
						(PackageSection) context);
				if (packageRename != null)
					aadlPackage = packageRename.getRenamedPackage();
				else
					aadlPackage = findImportedPackage(packageName, context);
			} else
				aadlPackage = findImportedPackage(packageName, context);

			if (aadlPackage != null
					&& aadlPackage.getOwnedPublicSection() != null)
				return aadlPackage.getOwnedPublicSection().findNamedElement(
						elementName);
			else
				return null;
		}
	}

	private static final Set<String> PREDECLARED_PROPERTY_SET_NAMES;

	static {
		HashSet<String> predeclaredPropertySetNames = new HashSet<String>();
		predeclaredPropertySetNames.add("AADL_Project");
		predeclaredPropertySetNames.add("Deployment_Properties");
		predeclaredPropertySetNames.add("Thread_Properties");
		predeclaredPropertySetNames.add("Timing_Properties");
		predeclaredPropertySetNames.add("Communication_Properties");
		predeclaredPropertySetNames.add("Memory_Properties");
		predeclaredPropertySetNames.add("Programming_Properties");
		predeclaredPropertySetNames.add("Modeling_Properties");
		PREDECLARED_PROPERTY_SET_NAMES = Collections
				.unmodifiableSet(predeclaredPropertySetNames);
	}

	private static PSNode psNode = new PSNode();

	/**
	 * Dependencies: If propertySetName is the name of a different, non standard
	 * property set: WithStatementReference.
	 */
	public EObject findNamedElementInPropertySet(String propertySetName,
			String elementName, Namespace context, EReference reference) {
		if (propertySetName == null) {
			// for (String predeclaredPSName : PREDECLARED_PROPERTY_SET_NAMES) {
			// psNode.setText(getQualifiedName(predeclaredPSName, elementName));
			// List<EObject> res = getIndexedObjects(context, reference,
			// psNode);
			// if (!res.isEmpty())
			// return res.get(0);
			// }
			for (String predeclaredPSName : PREDECLARED_PROPERTY_SET_NAMES) {
				PropertySet predeclaredPropertySet = findPropertySet(context,
						predeclaredPSName);
				if (predeclaredPropertySet != null) {
					NamedElement searchResult = predeclaredPropertySet
							.findNamedElement(elementName);
					if (searchResult != null)
						return searchResult;
				}
			}
			return null;
		} else {
			PropertySet propertySet;
			if (context instanceof PropertySet
					&& ((PropertySet) context).getName().equalsIgnoreCase(
							propertySetName))
				propertySet = (PropertySet) context;
			else {
				propertySet = findImportedPropertySet(propertySetName, context);
				// if (propertySet == null)
				// for (PropertySet predeclaredPropertySet :
				// OsateResourceManager.getPredeclaredPropertySets())
				// if
				// (predeclaredPropertySet.getName().equalsIgnoreCase(propertySetName))
				// propertySet = predeclaredPropertySet;
			}
			if (propertySet != null)
				return propertySet.findNamedElement(elementName);
			else
				return null;
		}
	}

	/**
	 * Search for a {@link PackageRename} in a package. If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will also search through
	 * the {@link PackageRename}s of the corresponding
	 * {@link PublicPackageSection}. The {@link PackageRename#isRenameAll()
	 * renameAll} flag of the returned {@link PackageRename} will be
	 * {@code false}.
	 * 
	 * @param name
	 *            The name of the {@link PackageRename} to search for.
	 * @param context
	 *            The {@link PackageSection} that contains the {@link Element}
	 *            that needs a {@link PackageRename}.
	 * @return The {@link PackageRename} or {@code null} if it cannot be found.
	 */
	public static PackageRename findPackageRename(String name,
			PackageSection context) {
		NamedElement searchResult = context.findNamedElement(name, false);
		if (searchResult == null
				&& context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getPublicSection() != null) {
			searchResult = ((AadlPackage) context.eContainer())
					.getPublicSection().findNamedElement(name, false);
		}
		if (searchResult instanceof PackageRename)
			return (PackageRename) searchResult;
		else
			return null;
	}

	public String getQualifiedName(String packageOrPropertySetName,
			String elementName) {
		if (packageOrPropertySetName == null)
			return elementName;
		else
			return packageOrPropertySetName + "::" + elementName;
	}

	public static Classifier getContainingClassifier(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof Classifier))
			container = container.eContainer();
		return (Classifier) container;
	}

	/**
	 * Dependencies: PrototypeFormalReference. Based on the type of classifier:
	 * ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	public static PrototypeBinding findPrototypeBinding(Classifier classifier,
			Prototype prototype) {
		for (PrototypeBinding binding : classifier.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifier.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(
					generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference. Based on the type of
	 * classifierPrototypeContext: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	private static PrototypeBinding findPrototypeBinding(
			Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, Prototype prototype) {
		for (PrototypeBinding binding : subcomponentPrototypeContext
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (PrototypeBinding binding : classifierPrototypeContext
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifierPrototypeContext
				.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(
					generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}

	public static AadlPackage findAadlPackage(EObject context, String name) {
		if (name == null || name.length() == 0)
			return null;
		ResourceSet rs = context.eResource().getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof AadlPackage)
						&& ((AadlPackage) rootObject).getName()
								.equalsIgnoreCase(name))
					return (AadlPackage) rootObject;
			}
		}
		/* load the resource from the file system */
		Resource res = context.eResource();
		URI uri = res.getURI().trimFileExtension().trimSegments(1)
				.appendSegment(name).appendFileExtension("aadl2");
		Resource xtextResource;
		try {
			xtextResource = context.eResource().getResourceSet()
					.getResource(uri, true);
		} catch (Exception e) {
			try {
				xtextResource = context.eResource().getResourceSet()
						.getResource(uri, false);
				if (xtextResource != null) {
					xtextResource.delete(null);
				}
			} catch (Exception ee) {
			}
			return null;
		}
		if (xtextResource == null)
			return null;
		if (!xtextResource.getContents().isEmpty()) {
			EObject rootObject = xtextResource.getContents().get(0);
			if ((rootObject instanceof AadlPackage)
					&& ((AadlPackage) rootObject).getName().equalsIgnoreCase(
							name))
				return (AadlPackage) rootObject;
		} else {
			try {
				xtextResource.delete(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static PropertySet findPropertySet(EObject context, String name) {
		if (name == null || name.length() == 0)
			return null;
		ResourceSet rs = context.eResource().getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof PropertySet)
						&& ((PropertySet) rootObject).getName()
								.equalsIgnoreCase(name))
					return (PropertySet) rootObject;
			}
		}
		/* load the resource from the file system */
		Resource res = context.eResource();
		URI uri = res.getURI().trimFileExtension().trimSegments(1)
				.appendSegment(name).appendFileExtension("aadl2");
		Resource xtextResource;
		try {
			xtextResource = context.eResource().getResourceSet()
					.getResource(uri, true);
		} catch (Exception e) {
			try {
				xtextResource = context.eResource().getResourceSet()
						.getResource(uri, false);
				if (xtextResource != null) {
					xtextResource.delete(null);
				}
			} catch (Exception ee) {
			}
			return null;
		}
		if (xtextResource == null)
			return null;
		if (!xtextResource.getContents().isEmpty()) {
			EObject rootObject = xtextResource.getContents().get(0);
			if ((rootObject instanceof PropertySet)
					&& ((PropertySet) rootObject).getName().equalsIgnoreCase(
							name))
				return (PropertySet) rootObject;
		} else {
			try {
				xtextResource.delete(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference.
	 */
	private static PrototypeBinding findPrototypeBinding(
			Subcomponent subcomponent, Prototype prototype) {
		for (PrototypeBinding binding : subcomponent
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		return null;
	}

}
