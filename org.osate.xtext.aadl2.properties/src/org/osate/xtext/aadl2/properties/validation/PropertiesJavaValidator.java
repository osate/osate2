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
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierType;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.Operation;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyOwner;
import org.osate.aadl2.PropertySet;
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
import org.osate.aadl2.modelsupport.util.AadlUtil;
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
	 * Check Classifier reference for right type.
	 */

	@Check(CheckType.FAST)
	public void caseClassifierValue(ClassifierValue nt) {
			checkClassifierReference(nt.getClassifier(), nt);
	}

	
	// checking methods
	
	
	protected void checkPropertyAssociation(PropertyAssociation pa){
		// type check value against type
		Property pdef = pa.getProperty();
		checkPropertySetElementReference(pdef, pa);
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
		checkInBinding( pa);
	}
	
	protected void checkInBinding(final PropertyAssociation pa){
		for (Classifier c: pa.getInBindings()){
			checkClassifierReference(c, pa);
		}
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
		typeCheckPropertyValues(pt, pv, "");
	}
	
	/**
	 * checks and report mismatch in type of value and type	
	 * @param pt: PropertyType or unresolved proxy or null
	 * @param pv: PropertyExpression or null
	 * @param prefix: String prefix to error message used for lists
	 */
	protected void typeCheckPropertyValues(PropertyType pt, PropertyExpression pv, String prefix){
		if (Aadl2Util.isNull(pt)) return;
		if (pv == null) return;
		if (!prefix.isEmpty() && !prefix.startsWith(" ")) prefix = prefix+" ";
		if (pv instanceof ListValue ){
			if (pt instanceof ListType){
				typeMatchListElements(((ListType)pt).getElementType(), ((ListValue)pv).getOwnedListElements());
			} else {
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property does not match list of values");
			}
		} else 	if(pv instanceof Operation || pv instanceof BooleanLiteral ){
			if(!(pt instanceof AadlBoolean )) {
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match Boolean value");
			}
		} else 	if (pv instanceof StringLiteral){
			if (!( pt instanceof AadlString)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match String value");
			}
		} else if (pv instanceof EnumerationLiteral || (pv instanceof NamedValue && ((NamedValue)pv).getNamedValue() instanceof EnumerationLiteral) ){
			if (!(pt instanceof EnumerationType)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match Enumeration literal");
			}
		} else if (pv instanceof UnitLiteral || (pv instanceof NamedValue && ((NamedValue)pv).getNamedValue() instanceof UnitLiteral) ){
			if (!(pt instanceof UnitsType)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match Unit literal");
			}
		} else 	if (pv instanceof IntegerLiteral ){
			if(!(pt instanceof AadlInteger)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match Integer value");
			} else {
				checkUnits((AadlInteger)pt,(IntegerLiteral)pv);
			}
		} else if (pv instanceof RealLiteral ){
			if(!(pt instanceof AadlReal)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match Real value");
			} else {
				checkUnits((AadlReal)pt,(RealLiteral)pv);
			}
		} else if ( pv instanceof RangeValue){
			if(!(pt instanceof RangeType)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' type of property definition does not match Range value");
			} else {
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getMinimumValue());
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getMaximumValue());
				typeCheckPropertyValues(((RangeType)pt).getNumberType(),((RangeValue)pv).getDeltaValue());
			}
		} else if (pv instanceof ClassifierValue ){
			if(!(pt instanceof ClassifierType)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match reference value to a classifier");
			}
		} else if (pv instanceof RecordValue){
			if(!(pt instanceof RecordType )){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match record value");
			} else {
				typeMatchRecordFields(((RecordValue)pv).getOwnedFieldValues());
			}
		} else if (pv instanceof ReferenceValue ){
			if(!(pt instanceof ReferenceType)){
				error(pv, prefix+"type '"+pt.eClass().getName()+"' of property definition does not match reference value to a model element");
			}
		} else if (pv instanceof NamedValue ){
			AbstractNamedValue nv = ((NamedValue)pv).getNamedValue();
			if (nv instanceof PropertyConstant){
				typeCheckPropertyValues(pt,((PropertyConstant)pv).getConstantValue());
			} else if (nv instanceof Property){
				PropertyType pvt = ((Property)nv).getPropertyType();
				if (pvt.eClass() != pt.eClass()){
					error(pv, "Type "+pvt.eClass().getName()+" of referenced property does not match"+prefix+" type '"+pt.eClass().getName()+"' of property definition");
				}
			} else {
				error(pv, "Enum/Unit literal validation should have happened before");
			}
		} 
	}
	
	protected void typeMatchListElements(PropertyType pt, EList<PropertyExpression> pel){
		for (PropertyExpression propertyExpression : pel) {
			typeCheckPropertyValues(pt,propertyExpression,"list element");
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
	

	
	public void checkClassifierReference(Classifier cl, Element context){
		if (Aadl2Util.isNull(cl)) return;
		Namespace contextNS = AadlUtil.getContainingTopLevelNamespace(context);
		PackageSection referenceNS = (PackageSection)AadlUtil.getContainingTopLevelNamespace(cl);
		if (contextNS != referenceNS){
			if (!AadlUtil.isImportedPackage(AadlUtil.getContainingPackage(referenceNS), contextNS)){
				error(context, "The referenced package '" + AadlUtil.getContainingPackage(referenceNS).getName() +
						"' of classifier '"+ cl.getName() +"' is not listed in a with clause.");
			}
		}
	}

	
	public void checkPropertySetElementReference(NamedElement pse, Element context){
		if (Aadl2Util.isNull(pse)) return;
		Namespace contextNS = AadlUtil.getContainingTopLevelNamespace(context);
		PropertySet referenceNS = (PropertySet) AadlUtil.getContainingTopLevelNamespace(pse);
		if (contextNS != referenceNS){
			if (!AadlUtil.isImportedPropertySet(referenceNS, contextNS)){
				error(context, "The referenced property set '" + referenceNS.getName() +
						"' of "+ (pse instanceof Property ? "property '":(pse instanceof PropertyType? "property type '":"property constant '" ))
						+ pse.getName() +"' is not listed in a with clause.");
			}
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

	protected void info(EObject source, String message) {
		info(message, source, null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}

	protected void info(String message) {
		info(message, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				null);
	}

}
