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

	private static BusinessObjectContext findContextAncestorBoc(final BusinessObjectContext boc) {
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

	/**
	 * Finds a context. If the context BOC is the specified owner BOC, null is returned. It is expected that the owner's business object will be a valid context and is a container
	 * of the specified BOC. In such cases the function will return a context only if it is inside the owner business object context.
	 * @param boc
	 * @param ownerBoc
	 * @return
	 */
	public static Context findContextExcludeOwner(final BusinessObjectContext boc,
			final BusinessObjectContext ownerBoc) {
		final BusinessObjectContext contextBoc = findContextAncestorBoc(boc);
		return contextBoc == null || contextBoc == ownerBoc ? null : (Context) contextBoc.getBusinessObject();
	}
}
