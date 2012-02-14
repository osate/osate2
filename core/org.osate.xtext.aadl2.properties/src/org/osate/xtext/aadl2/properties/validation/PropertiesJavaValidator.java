package org.osate.xtext.aadl2.properties.validation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.Operation;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.util.Aadl2Util;

 

public class PropertiesJavaValidator extends AbstractPropertiesJavaValidator {


	@Check(CheckType.FAST)
	public void caseRangeValue(final RangeValue rv) {
		final NumberValue deltaNV = rv.getDeltaValue();
		if (deltaNV != null) {
			final double delta = deltaNV.getScaledValue();
			if (delta < 0) {
				error(rv, "Range value has a negative delta component");
			}
		}
	}

	@Check(CheckType.FAST)
	public void casePropertyAssociation(PropertyAssociation pa) {
		// propertyset name in with clause is already enforced by linkingservice
//		String s = pa.getProperty().getQualifiedName();
//		String psname = null;
//		final int idx = s.lastIndexOf("::");
//		if (idx != -1) {
//			psname = s.substring(0, idx);
//			if (PropertiesLinkingService.getPropertiesLinkingService(pa).isPredeclaredPropertySet(psname))
//				return;
//			EObject propertySet = PropertiesLinkingService.getPropertiesLinkingService(pa).findImportedPropertySet(
//					psname, pa);
//			if (propertySet == null) {
//				error(pa,
//						"Property set containing property is not listed in with clause");
//			}
//		}
		checkPropertyAssociation(pa);
	}
	
	/**
	 * Check ranges for correctness.
	 */
	@Check(CheckType.FAST)
	public void caseNumberType(NumberType nt) {
		checkNumberType(nt);
	}

	@Check(CheckType.FAST)
	public void caseAadlinteger(final AadlInteger ai) {
		checkAadlinteger(ai);
	}
	
	// checking methods
	
	/**
	 * Check that a number type is well formed.  The range values (if any)
	 * should be such that the lower bound is not greater than the upper bound.
	 * Satisfies legality rule from Section 10.1.1:
	 *
	 * <blockquote>
	 * The value of the first numeric literal that appears in a range of a
	 * number_type must not be greater than the value of the second numeric
	 * literal.
	 * </blockquote>
	 */
	private void checkNumberType(final NumberType nt) {
		/* NOTE: NumericResolver + Parser already make sure the bounds are
		 * both reals or both integers, as appropriate.
		 */
		final NumericRange range = nt.getRange();
		if (range == null) return;
		PropertyExpression	lowerPE = (PropertyExpression)range.getLowerBound();
		PropertyExpression	upperPE = (PropertyExpression)range.getUpperBound();
		// TODO : handle NamedValue
		if (lowerPE instanceof NamedValue){
			if (((NamedValue)lowerPE).getNamedValue() instanceof PropertyConstant){
				lowerPE=((PropertyConstant)((NamedValue)lowerPE).getNamedValue()).getConstantValue();
			}
		}
		if (upperPE instanceof NamedValue){
			if (((NamedValue)upperPE).getNamedValue() instanceof PropertyConstant){
				upperPE=((PropertyConstant)((NamedValue)upperPE).getNamedValue()).getConstantValue();
			}
		}
		NumberValue lowerNV = lowerPE instanceof NumberValue? (NumberValue)lowerPE: null;
		NumberValue upperNV = upperPE instanceof NumberValue? (NumberValue)upperPE: null;
		if (lowerNV != null && upperNV != null) {
			/* Check: (1) the bounds have units if the type has units;
			 * (2) the lower bounds is <= the upper bound.
			 */
			if (lowerNV instanceof NumberValue){
				
			}
			if (nt.getUnitsType() != null) {
				if (lowerNV.getUnit() == null) {
					error(nt,
							"lower bound is missing a unit");
				}
				if (upperNV.getUnit() == null) {
					error(nt,
							"upper bound is missing a unit");
				}
			}
			final double lower = lowerNV.getScaledValue();
			final double upper = upperNV.getScaledValue();
			if (lower > upper) {
				error(nt,
						"Range lower bound is greater than range upper bound");
			}
		}
	}

	/**
	 * Check that if an aadlinteger type has units that the units have only
	 * integer multipliers.
	 */
	private void checkAadlinteger(final AadlInteger ai) {
		final UnitsType units = ai.getUnitsType();
		if (units != null) {
			for (Iterator i = units.getOwnedLiterals().iterator(); i.hasNext();) {
				final UnitLiteral ul = (UnitLiteral) i.next();
				final NumberValue factor = ul.getFactor();
				if (factor != null && !(factor instanceof IntegerLiteral)) {
					error(ai,
							"Integer type has unit (" + ul.getName() +
							") with non-integer factor (" +
							ul.getFactor().toString() + ")");
				}
			}
		}
	}
	
	protected void checkPropertyAssociation(PropertyAssociation pa){
		// type check value against type
		Property pdef = pa.getProperty();
		if (Aadl2Util.isNull(pdef)) return;
		PropertyType pt = pdef.getPropertyType();
		if (Aadl2Util.isNull(pt)) return;
		EList<ModalPropertyValue> pvl = pa.getOwnedValues();
		for (ModalPropertyValue modalPropertyValue : pvl) {
			typeCheckPropertyValues(pt, modalPropertyValue.getOwnedValue());
		}
		// check applies to
		NamedElement owner = (NamedElement)pa.getOwner();
		checkAssociationAppliesTo(owner, pa);
	}

	/**
	 * Check constraints that property applies to the element it is associated
	 * with per Section 10.3:
	 *
	 * <blockquote>The property named by a property association must list the
	 * category of the component type, component implementation, subcomponent,
	 * feature, connection, flow, or mode the property association is declared
	 * for in its Property_Owner_Category list. </blockquote>
	 */
	private void checkAssociationAppliesTo(
		final NamedElement element,
		final PropertyAssociation pa) {
		final Property pn = pa.getProperty();
		final EList<ContainedNamedElement> appliesTo = pa.getAppliesTos();
		if (appliesTo == null || appliesTo.size() == 0) {
			final boolean applies = element.acceptsProperty(pn);
			if (!applies) {
				error(pa,
						"Property "	+ pa.getProperty().getQualifiedName() +
						" does not apply to " + element.getName());
//				error(pa,
//						"Property "	+ pa.getQualifiedName() +
//						" does not apply to " + element.eClass().getName());
			}
		} else {
			for (ContainedNamedElement cna : appliesTo){
				EList<ContainmentPathElement> path = cna.getContainmentPathElements();
				// only the last value is interesting to us
				final ContainmentPathElement ph = (ContainmentPathElement) path.get(path.size()-1);
				final boolean applies = ph.getNamedElement().acceptsProperty(pn);
				if (!applies) {
					error(pa,
							"Property " + pa.getProperty().getQualifiedName() +
							" does not apply to "+unparseAppliesTo(cna));
				}
			}
		}
	}

	private static String unparseAppliesTo(final ContainedNamedElement cna){
		final StringBuffer sb = new StringBuffer();
		EList<ContainmentPathElement> path = cna.getContainmentPathElements();
		for (final Iterator it = path.iterator(); it.hasNext();) {
			final ContainmentPathElement pc = (ContainmentPathElement) it.next();
			sb.append(pc.getNamedElement().getName());
			if (it.hasNext()) sb.append(".");
		}
		return sb.toString();
	}

	
	/**
	 * Make sure that a NamedValue object pointing to a property or property constant referenced as a
	 * subclause of a boolean expression actually refers to a boolean-valued
	 * property.  Also make sure that if the property reference is to a 
	 * property definition, then the property holder or property definition 
	 * that it is a part of should have a compatible applies to clause.
	 */
	protected void checkPropertyReference(final NamedValue pr) {
		final EObject parent = pr.eContainer();
		final AbstractNamedValue anv = pr.getNamedValue();
		if(anv instanceof Property){
			Property rp = (Property) anv;
			if (parent instanceof Operation) {
				final PropertyType pt = rp.getPropertyType();
				if (!(pt instanceof AadlBoolean) || rp.isList()) {
					error(pr, "Not a reference to a boolean-valued property");
				}
			}
			final Property refPD = (Property) rp;
			/* Find the property making reference to us.  It is either the PD
			 * from a property association, or the enclosing PD if our use is
			 * as a default value.
			 */
			Property pd = null;
			EObject current = parent;
			while (current != null) {
				if (current instanceof PropertyAssociation) {
					pd = ((PropertyAssociation) current).getProperty();
					break;
				}
				if (current instanceof Property) {
					pd = (Property) current;
					break;
				}
				current = current.eContainer();
			}
			
			if (current == null) {
				error("Couldn't find enclosing property association or property definition for property reference");
			} else {
				final List refAppliesTo = refPD.getAppliesTos();
				final List appliesTo = pd.getAppliesTos();
				if (!refAppliesTo.containsAll(appliesTo)) {
					error(pr, "Referenced property definition does not apply to all the categories that the referring property applies to");
				}

				final List refAppliesToClass = new ArrayList();
				for (final Iterator i = refPD.getAppliesToClassifiers().iterator(); i.hasNext();) {
					final ClassifierValue cv = (ClassifierValue) i.next();
					refAppliesToClass.add(cv.getClassifier());
				}
				final List appliesToClass = new ArrayList();
				for (final Iterator i = pd.getAppliesToClassifiers().iterator(); i.hasNext();) {
					final ClassifierValue cv = (ClassifierValue) i.next();
					appliesToClass.add(cv.getClassifier());
				}
				if (!refAppliesToClass.containsAll(appliesToClass)) {
					error(pr, "Referenced property definition does not apply to all the classifiers that the referring property applies to");
				}
				
			}
		}
	}

	
/**
 * checks and report mismatch in type of value and type	
 * @param pt: PropertyType or unresolved proxy or null
 * @param pv: PropertyExpression or null
 */
	protected void typeCheckPropertyValues(PropertyType pt, PropertyExpression pv){
		if (Aadl2Util.isNull(pt)) return;
		if (pv == null) return;
		if (pv instanceof ListValue ){
			if (pt instanceof ListType){
				typeMatchListElements(((ListType)pt).getElementType(), ((ListValue)pv).getOwnedListElements());
			} else {
				error(pv, pt.eClass().getName()+" type of property does not match list");
			}
		} else 	if(pv instanceof Operation || pv instanceof BooleanLiteral ){
			if(!(pt instanceof AadlBoolean )) {
				error(pv, pt.eClass().getName()+" type of property does not match Boolean value");
			}
		} else 	if (pv instanceof StringLiteral){
			if (!( pt instanceof AadlString)){
				error(pv, pt.eClass().getName()+" type of property does not match String value");
			}
		} else if (pv instanceof EnumerationLiteral || (pv instanceof NamedValue && ((NamedValue)pv).getNamedValue() instanceof EnumerationLiteral) ){
			if (!(pt instanceof EnumerationType)){
				error(pv, pt.eClass().getName()+" type of property does not match Enumeration literal");
			}
		} else if (pv instanceof UnitLiteral || (pv instanceof NamedValue && ((NamedValue)pv).getNamedValue() instanceof UnitLiteral) ){
			if (!(pt instanceof UnitsType)){
				error(pv, pt.eClass().getName()+" type of property does not match Unit literal");
			}
		} else 	if (pv instanceof IntegerLiteral ){
			if(!(pt instanceof AadlInteger)){
				error(pv, pt.eClass().getName()+" type of property does not match Integer value");
			} else {
				checkUnits((AadlInteger)pt,(IntegerLiteral)pv);
			}
		} else if (pv instanceof RealLiteral ){
			if(!(pt instanceof AadlReal)){
				error(pv, pt.eClass().getName()+" type of property does not match Real value");
			} else {
				checkUnits((AadlReal)pt,(RealLiteral)pv);
			}
		} else if ( pv instanceof RangeValue){
			if(!(pt instanceof RangeType)){
				error(pv, pt.eClass().getName()+" type of property does not match Range value");
			} else {
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getMinimumValue());
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getMaximumValue());
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getDeltaValue());
			}
		} else if (pv instanceof ClassifierValue ){
			if(!(pt instanceof ClassifierType)){
				error(pv, pt.eClass().getName()+" type of property does not match reference value to a classifier");
			}
		} else if (pv instanceof RecordValue){
			if(!(pt instanceof RecordType )){
				error(pv, pt.eClass().getName()+" type of property does not match record value");
			} else {
				typeMatchRecordFields(((RecordValue)pv).getOwnedFieldValues());
			}
		} else if (pv instanceof ReferenceValue ){
			if(!(pt instanceof ReferenceType)){
				error(pv, pt.eClass().getName()+" type of property does not match reference value to a model element");
			}
		} else if (pv instanceof NamedValue ){
			AbstractNamedValue nv = ((NamedValue)pv).getNamedValue();
			if (nv instanceof PropertyConstant){
				typeCheckPropertyValues(pt,((PropertyConstant)pv).getConstantValue());
			} else if (nv instanceof Property){
				PropertyType pvt = ((Property)nv).getPropertyType();
				if (pvt.eClass() != pt.eClass()){
					error(pv, "Type "+pvt.eClass().getName()+" of referenced property does not match type "+pt.eClass().getName()+" of property");
				}
			} else {
				error(pv, "Enum/Unit literal validation should have happened before");
			}
		} 
	}
	
	protected void typeMatchListElements(PropertyType pt, EList<PropertyExpression> pel){
		for (PropertyExpression propertyExpression : pel) {
			typeCheckPropertyValues(pt,propertyExpression);
		}
	}
	
	protected void typeMatchRecordFields(EList<BasicPropertyAssociation> rfl){
		for (BasicPropertyAssociation field : rfl) {
			if (field.getProperty() != null){
				typeCheckPropertyValues(field.getProperty().getPropertyType(), field.getValue());
			}
		}
	}
	
	
	protected void checkUnits(NumberType nt, NumberValue nv){
		UnitsType ut = nt.getUnitsType();
		UnitLiteral ul = nv.getUnit();
		if (Aadl2Util.isNull(ut) && Aadl2Util.isNull(ul)) return;
		if (ul == null){
			error(nv, "Number value is missing a unit");
		} else
		if (!ut.getOwnedLiterals().contains(ul)){
			error(nv, "Unit '"+ul.getName()+"'of number value is not of Units type "+ut.getQualifiedName());
		}
	}
	


	
	// helper methods

	protected void error(String message, EObject source,
			EStructuralFeature feature) {
		error(message, source, feature,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}

	protected void error(EObject source, String message) {
		error(message, source, null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}

	protected void error(String message) {
		error(message, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				null);
	}

	protected void warning(String message, EObject source,
			EStructuralFeature feature) {
		warning(message, source, feature,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}

	protected void warning(EObject source, String message) {
		warning(message, source, null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}

	protected void warning(String message) {
		warning(message, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				null);
	}

}
