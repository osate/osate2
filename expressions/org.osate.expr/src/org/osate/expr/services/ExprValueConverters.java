package org.osate.expr.services;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.ComponentCategory;

import com.google.inject.Singleton;

@Singleton
public class ExprValueConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "ComponentCategory")
	public IValueConverter<ComponentCategory> ComponentCategory() {
		return new IValueConverter<ComponentCategory>() {
			@Override
			public ComponentCategory toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return ComponentCategory.get(string.toLowerCase());
			}

			@Override
			public String toString(ComponentCategory value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "NoQuoteString")
	public IValueConverter<String> NoQuoteString() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				if (string.charAt(0) == '"') {
					string = string.substring(1);
				}
				if (string.endsWith("\"")) {
					string = string.substring(0, string.length() - 1);
				}
				return string;
			}

			@Override
			public String toString(String value) {
				if (!value.isEmpty() && value.charAt(0) == '"') {
					return value;
				}
				return '"' + value + '"';
			}
		};
	}

	@ValueConverter(rule = "INTVALUE")
	public IValueConverter<Long> INTVALUE() {
		return new IValueConverter<Long>() {
			@Override
			public Long toValue(String string, INode node) {
				if (string == null) {
					return 0L;
				}
				if (string.indexOf('_') != -1) {
					string = string.replaceAll("_", "");
				}
				return Long.valueOf(string);
			}

			@Override
			public String toString(Long value) {
				return value.toString();
			}
		};
	}

	@ValueConverter(rule = "QCREF")
	public IValueConverter<String> QCREF() {

		final char implSeparator = ':';

		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				int i = string.lastIndexOf(implSeparator);
				if (i < 0 || string.charAt(i - 1) == ':') {
					return string;
				}
				return string.substring(0, i) + "." + string.substring(i + 1);
			}

			@Override
			public String toString(String value) {
				int i = value.indexOf(".");
				if (i < 0) {
					return value;
				}
				return value.substring(0, i) + implSeparator + value.substring(i + 1);
			}
		};
	}

}
