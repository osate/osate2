package org.osate.xtext.aadl2.propertyset.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.util.AadlUtil;
 

public class PropertysetJavaValidator extends AbstractPropertysetJavaValidator {


	@Check(CheckType.FAST)
	public void caseUnitsType(final UnitsType ut) {
		final Set seen = new HashSet();
		final EList literals = ut.getOwnedLiterals();
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(literals);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(ne, "Unit '" + ne.getName()
						+ "' previously declared in enumeration");
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseEnumerationType(final EnumerationType et) {
		final Set seen = new HashSet();
		final EList literals = et.getOwnedLiterals();
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(literals);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(ne, "Literal '" + ne.getName()
						+ "' previously declared in enumeration");
			}
		}
	}

	// enforced syntactically that all is by itself
//	@Check(CheckType.FAST)
//	public void caseProperty(final Property pdef) {
//		// check whether all is the only/first element in applies to
//		EList<MetaclassReference> mcl = pdef.getAppliesToMetaclasses();
//		for (MetaclassReference metaclassReference : mcl) {
//			if (metaclassReference.getMetaclassNames().size() > 0){
//				if(metaclassReference.getMetaclassNames().get(0).equalsIgnoreCase("all")){
//					if (mcl.size() > 1 || !pdef.getAppliesToClassifiers().isEmpty()){
//						error(pdef, "applies to of property definition '"+pdef.getName()+"' must contain 'all' by itself.");
//					}
//				}
//			}
//		}
//	}

}
