package org.osate.ge.tests;

import java.util.Objects;

import org.osate.ge.internal.util.StringUtil;

public class ToolTypes {
	public static String getToolItem(final Class<?> clazz) {
		return Objects.requireNonNull(StringUtil.camelCaseToUser(clazz.getSimpleName()),
				"Unsupported tool item: " + clazz);
	}
}
