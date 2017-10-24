package org.osate.ge.internal.util;

import java.util.List;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.BusinessObjectContext;

public class AadlSubcomponentUtil {
	public static ComponentClassifier getComponentClassifier(final BusinessObjectContext boc, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			if(sc.getClassifier() == null && sc.getRefined() != null) {
				return getComponentClassifier(boc, sc.getRefined());
			} else {
				return sc.getClassifier();
			}
		} else {
			return AadlPrototypeUtil.getComponentClassifier(AadlPrototypeUtil.getPrototypeBindingContext(boc), sc);
		}
	}

	/**
	 * Returns null if it is unable to build a non-empty string.
	 * @param sc
	 * @return
	 */
	public static String getSubcomponentTypeDescription(final Subcomponent sc, final BusinessObjectContext scBoc) {
		// Get top level component implementation.
		NamedElement implRoot = null;
		for(BusinessObjectContext tmpBoc = scBoc.getParent(); tmpBoc != null; tmpBoc = tmpBoc.getParent()) {
			if (tmpBoc.getBusinessObject() instanceof ComponentImplementation) {
				implRoot = ((ComponentImplementation) tmpBoc.getBusinessObject()).getElementRoot();
			}
		}

		String retVal = "";
		final SubcomponentType scType = getAllSubcomponentType(sc);

		if(scType != null) {
			retVal += scType.getElementRoot() == implRoot ? scType.getName() : scType.getQualifiedName();
		}

		// Add text for each of the implementation references (for arrays)
		final List<ComponentImplementationReference> implRefs = getArrayComponentImplementationReferences(sc);
		if(implRefs.size() != 0) {
			retVal += "\n(";
			for(int i = 0; i < implRefs.size(); i++) {
				final ComponentImplementationReference ref = implRefs.get(i);
				if(ref.getImplementation() != null) {
					if(ref.getImplementation().eIsProxy()) {
						retVal += "<unresolved>";
					} else {
						retVal += ref.getImplementation().getElementRoot() == implRoot
								? ref.getImplementation().getName()
								: ref.getImplementation().getQualifiedName();
					}
				}

				if(i == (implRefs.size() - 1)) {
					retVal += ")";
				} else {
					retVal += ",\n";
				}

			}
		}

		return retVal.length() == 0 ? null : retVal;
	}

	// Helper Methods
	private static SubcomponentType getAllSubcomponentType(Subcomponent sc) {
		SubcomponentType scType;
		do {
			scType = sc.getSubcomponentType();
			sc = sc.getRefined();
		} while(sc != null && scType == null);

		return scType;
	}

	private static List<ComponentImplementationReference> getArrayComponentImplementationReferences(final Subcomponent sc) {
		Subcomponent tmpSc = sc;
		List<ComponentImplementationReference> refs;

		do {
			refs = tmpSc.getImplementationReferences();
			tmpSc = tmpSc.getRefined();
		} while(tmpSc != null && refs.size() == 0);

		return refs;
	}
}
