package org.osate.results.valueconversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.parsesupport.ParseUtil;

import com.google.inject.Singleton;

@Singleton
public class ResultValueConverter extends DefaultTerminalConverters {

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

	@ValueConverter(rule = "SignedInt")
	public IValueConverter<Long> SignedInt() {
		return new IValueConverter<Long>() {
			@Override
			public Long toValue(String string, INode node) {
				long[] res = ParseUtil.parseAadlInteger(string);
				return Long.valueOf(res[1]);
			}

			@Override
			public String toString(Long value) {
				return value.toString();
			}
		};
	}

	@ValueConverter(rule = "SignedReal")
	public IValueConverter<Double> SignedReal() {
		return new IValueConverter<Double>() {
			@Override
			public Double toValue(String string, INode node) {
				return ParseUtil.parseAadlReal(string);
			}

			@Override
			public String toString(Double value) {
				return value.toString();
			}
		};
	}

}
