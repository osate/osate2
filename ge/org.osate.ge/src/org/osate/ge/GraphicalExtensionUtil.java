package org.osate.ge;

import org.osate.ge.graphics.Style;
import org.osate.ge.internal.businessObjectHandlers.Styles;
import org.osate.ge.internal.util.AadlInheritanceUtil;

public class GraphicalExtensionUtil {
	// All methods are static
	private GraphicalExtensionUtil() {
	}

	public static boolean isInherited(final BusinessObjectContext boc) {
		return AadlInheritanceUtil.isInherited(boc);
	}

	public static final Style STYLE_INHERITED_ELEMENT = Styles.INHERITED_ELEMENT;
}
