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
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
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
import org.osate.aadl2.PropertyValue;
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
import org.osate.aadl2.util.AadlUtil;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

 

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
		Property pdef = pa.getProperty();
		if (AadlUtil.isNull(pdef)) return;
		PropertyType pt = pdef.getPropertyType();
		if (AadlUtil.isNull(pt)) return;
		EList<ModalPropertyValue> pvl = pa.getOwnedValues();
		for (ModalPropertyValue modalPropertyValue : pvl) {
			typeCheckPropertyValues(pt, modalPropertyValue.getOwnedValue());
		}
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
		if (AadlUtil.isNull(pt)) return;
		if (pv == null) return;
		if (pt instanceof ListType){
			if (pv instanceof ListValue){
				typeMatch(((ListType)pt).getElementType(), ((ListValue)pv).getOwnedListElements());
			} else if (pv instanceof PropertyConstant){
				typeCheckPropertyValues(pt,((PropertyConstant)pv).getConstantValue());
			} else {
				error(pv, "Expected a list");
			}
		} else 	if(pt instanceof AadlBoolean ){
			// TODO boolean property or constant reference
			if(!(pv instanceof Operation || pv instanceof BooleanLiteral)) {
				error(pv, "Expected a Boolean value");
			}
		} else 	if (pt instanceof AadlString){
			if (!(pv instanceof StringLiteral)){
				error(pv, "Expected a String value");
			}
		} else if (pt instanceof EnumerationType){
			if (!(pv instanceof EnumerationLiteral || (pv instanceof NamedValue && ((NamedValue)pv).getNamedValue() instanceof EnumerationLiteral))){
				error(pv, "Expected a Enumeration literal");
			}
		} else if (pt instanceof UnitsType){
			if (!(pv instanceof UnitLiteral || (pv instanceof NamedValue && ((NamedValue)pv).getNamedValue() instanceof UnitLiteral))){
				error(pv, "Expected a Enumeration literal");
			}
		} else 	if (pt instanceof AadlInteger){
			if(!(pv instanceof IntegerLiteral)){
				error(pv, "Expected an Integer value");
			} else {			checkUnits((AadlInteger)pt,(IntegerLiteral)pv);
			}
		} else
		if (pt instanceof AadlReal){
			if(!(pv instanceof RealLiteral)){
				error(pv, "Expected a Real value");
			} else {
				checkUnits((AadlReal)pt,(RealLiteral)pv);
			}
		} else
		if (pt instanceof RangeType){
			if(!(pv instanceof RangeValue)){
				error(pv, "Expected a Range value");
			} else {
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getMinimumValue());
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getMaximumValue());
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getDeltaValue());
			}
		} else
		if (pt instanceof ClassifierType){
			if(!(pv instanceof ClassifierValue)){
				error(pv, "Expected a reference to a classifier");
			}
		} else
		if (pt instanceof RecordType){
			if(!(pv instanceof RecordValue)){
				error(pv, "Expected record value");
			}
		} else
		if (pt instanceof ReferenceType){
			if(!(pv instanceof ReferenceValue)){
				error(pv, "Expected a reference to a model element");
			}
		}
	}
	
	protected void typeMatch(PropertyType pt, EList<PropertyExpression> pel){
		for (PropertyExpression propertyExpression : pel) {
			typeCheckPropertyValues(pt,propertyExpression);
		}
	}
	
	protected void classMatch(PropertyExpression nv, Class cl){
		// TODO needs to be tested.
//		if (nv instanceof NamedValue){
//			AbstractNamedValue ab = ((NamedValue)nv).getNamedValue();
//			if (ab instanceof PropertyConstant){
//				classMatch(((PropertyConstant)ab).getConstantValue(),cl);
//			} else
//			if (ab instanceof Property){
////				classMatch(((Property)ab).get,cl);
//			} else {
//				if (nv.eClass().getClass() != cl){
//					error(nv, "Expected a "+cl.getSimpleName());
//				}
//			}
//		} else {
//			if (nv.eClass().getClass() != cl){
//				error(nv, "Expected a "+cl.getSimpleName());
//			}
//		}
	}
	
	protected void checkUnits(NumberType nt, NumberValue nv){
		UnitsType ut = nt.getUnitsType();
		UnitLiteral ul = nv.getUnit();
		if (AadlUtil.isNull(ut) && AadlUtil.isNull(ul)) return;
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
