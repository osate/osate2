/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.properties.valueconversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.OperationKind;
import org.osate.aadl2.parsesupport.ParseUtil;

public class PropertiesValueConverter extends DefaultTerminalConverters {

	@ValueConverter(rule = "PlusMinus")
	public IValueConverter<OperationKind> PlusMinus() {
		return new IValueConverter<OperationKind>() {
			@Override
			public OperationKind toValue(String string, INode node) {

				return OperationKind.get(string.toLowerCase());
			}

			@Override
			public String toString(OperationKind value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "NotOp")
	public IValueConverter<OperationKind> NotOp() {
		return new IValueConverter<OperationKind>() {
			@Override
			public OperationKind toValue(String string, INode node) {

				return OperationKind.get(string.toLowerCase());
			}

			@Override
			public String toString(OperationKind value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "AndOp")
	public IValueConverter<OperationKind> AndOp() {
		return new IValueConverter<OperationKind>() {
			@Override
			public OperationKind toValue(String string, INode node) {

				return OperationKind.get(string.toLowerCase());
			}

			@Override
			public String toString(OperationKind value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "OrOp")
	public IValueConverter<OperationKind> OrOp() {
		return new IValueConverter<OperationKind>() {
			@Override
			public OperationKind toValue(String string, INode node) {

				return OperationKind.get(string.toLowerCase());
			}

			@Override
			public String toString(OperationKind value) {
				return value.getName();
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

	/**
	 * @since 1.1
	 */
	@ValueConverter(rule = "QPREF")
	public IValueConverter<String> QPREF() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
				return removeSpacesFromQualifiedName(string);
			}

			@Override
			public String toString(String value) {
				return value;
			}
		};
	}

	/**
	 * @since 1.1
	 */
	@ValueConverter(rule = "QCREF")
	public IValueConverter<String> QCREF() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
				return removeSpacesFromQualifiedName(string);
			}

			@Override
			public String toString(String value) {
				return value;
			}
		};
	}

	/**
	 * Remove the spaces inserted into a qualified name string generated by
	 * {@link NodeModelUtils#getTokenText()}.  A single space may appear before
	 * or after a name segment. There will not be runs of 2 or more spaces.
	 *
	 * @param input A string generated by {@link NodeModelUtils#getTokenText()}
	 * @return {@code input} without any spaces.
	 * @since 1.1
	 */
	protected static String removeSpacesFromQualifiedName(final String input) {
		/*
		 * Could use String.replaceAll(" ", ""), but this seems faster then compiling
		 * and interpreting a regular expression.
		 */
		int indexOfSpace = input.indexOf(' ');
		if (indexOfSpace != -1) {
			int startOfSubstring = 0;
			final StringBuilder sb = new StringBuilder();
			while (indexOfSpace != -1) {
				sb.append(input.substring(startOfSubstring, indexOfSpace));
				startOfSubstring = indexOfSpace + 1;
				indexOfSpace = input.indexOf(' ', startOfSubstring);
			}
			sb.append(input.substring(startOfSubstring));
			return sb.toString();
		} else {
			// no spaces, return input string unchanged
			return input;
		}
	}
}
