package org.osate.ge.internal.ui.tools;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;

public class ToolUtil {
	/**
	 * Looks in ancestors and returns the first BOC which is associated with a ComponentImplementation.
	 * Returns null if any ancestor is not associated with a NamedElement.
	 * @param boc
	 * @return
	 */
	public static BusinessObjectContext findComponentImplementationBoc(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc;
		while(tmp != null) {
			if(tmp.getBusinessObject() instanceof ComponentImplementation) {
				return tmp;
			} else if(!(tmp.getBusinessObject() instanceof NamedElement)) {
				return null;
			}

			tmp = tmp.getParent();
		}

		return null;
	}

	public static BusinessObjectContext findContextAncestorBoc(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc.getParent();
		while(tmp != null) {
			if(tmp.getBusinessObject() instanceof Context) {
				return tmp;
			}

			tmp = tmp.getParent();
		}

		return null;
	}

	public static Context findContext(final BusinessObjectContext boc) {
		final BusinessObjectContext contextBoc = findContextAncestorBoc(boc);
		return contextBoc == null ? null : (Context)contextBoc.getBusinessObject();
	}
}
