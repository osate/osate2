/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.properties.valueconversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
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
}
