package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.ComponentCategory;

import com.google.common.base.CaseFormat;

class FilterUtil {
	public static String componentCategoryToIdPrefix(final ComponentCategory cc) {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, cc.getLiteral().replace(" ", "_"));
	}
}
