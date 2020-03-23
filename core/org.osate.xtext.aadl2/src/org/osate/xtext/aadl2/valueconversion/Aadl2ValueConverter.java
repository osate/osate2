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
package org.osate.xtext.aadl2.valueconversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.PortCategory;
import org.osate.xtext.aadl2.properties.valueconversion.PropertiesValueConverter;

public class Aadl2ValueConverter extends PropertiesValueConverter {
	@ValueConverter(rule = "INAME")
	public IValueConverter<String> INAME() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
				if (node == null) {
					return string;
				}
				ILeafNode l1 = null;
				ILeafNode l2 = null;
				ILeafNode l3 = null;
				Iterable<ILeafNode> n = node.getParent().getLeafNodes();
				for (ILeafNode currentNode : n) {
					if (!(currentNode instanceof HiddenLeafNode)) {
						l3 = l2;
						l2 = l1;
						l1 = currentNode;
					}
				}
				if (l3 != null) {
					return l3.getText().replaceAll(" ", "") + "." + string;
				}
//				int i;
//				forall (i = el.size() - 1; i > 0; i--) {
//					ILeafNode leafNode = el.get(i - 1);
//					String s = leafNode.getText();
//					char ch = s.charAt(0);
//					if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
//						return s + "." + string;
//					}
//				}
				return string;
			}

			@Override
			public String toString(String value) {
				int idx = value.lastIndexOf(".");
				if (idx > -1) {
					return value.substring(idx + 1);
				}
				return value;
			}
		};
	}

	@ValueConverter(rule = "REFINEDNAME")
	public IValueConverter<String> REFINEDNAME() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
//            	if (node == null ) return string;
//            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
//            	if (e instanceof NamedElement){
//            		((NamedElement)e).setName(string);
//            	}
				return string;
			}

			@Override
			public String toString(String value) {
				return value;
			}
		};
	}

	@Override
	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
//            	if (node == null ) return string;
//            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
//            	if (e instanceof NamedElement){
//            		((NamedElement)e).setName(string);
//            	}
				return string;
			}

			@Override
			public String toString(String value) {
				int idx = value.lastIndexOf("::");
				if (idx < 0) {
					return value;
				}
				return value.substring(idx + 2);
			}
		};
	}

	@ValueConverter(rule = "PNAME")
	public IValueConverter<String> PNAME() {
		return new IValueConverter<String>() {
			@Override
			public String toValue(String string, INode node) {
//            	if (node == null ) return string;
//            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
//            	if (e instanceof NamedElement){
//            		((NamedElement)e).setName(string);
//            	}
				return removeSpacesFromQualifiedName(string);
			}

			@Override
			public String toString(String value) {
				return value;
			}
		};
	}

	/**
	 * @since 2.0
	 */
	@ValueConverter(rule = "FQCREF")
	public IValueConverter<String> FQCREF() {
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

	@ValueConverter(rule = "PortCategory")
	public IValueConverter<PortCategory> PortCategory() {
		return new IValueConverter<PortCategory>() {
			@Override
			public PortCategory toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return PortCategory.get(string.toLowerCase());
			}

			@Override
			public String toString(PortCategory value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "PortDirection")
	public IValueConverter<DirectionType> PortDirection() {
		return new IValueConverter<DirectionType>() {
			@Override
			public DirectionType toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return DirectionType.get(string.toLowerCase());
			}

			@Override
			public String toString(DirectionType value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "DirectionType")
	public IValueConverter<DirectionType> DirectionType() {
		return new IValueConverter<DirectionType>() {
			@Override
			public DirectionType toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return DirectionType.get(string.toLowerCase());
			}

			@Override
			public String toString(DirectionType value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "InOutDirection")
	public IValueConverter<DirectionType> InOutDirection() {
		return new IValueConverter<DirectionType>() {
			@Override
			public DirectionType toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return DirectionType.get(string.toLowerCase());
			}

			@Override
			public String toString(DirectionType value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "AccessDirection")
	public IValueConverter<AccessType> AccessDirection() {
		return new IValueConverter<AccessType>() {
			@Override
			public AccessType toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return AccessType.get(string.toLowerCase());
			}

			@Override
			public String toString(AccessType value) {
				return value.getName();
			}
		};
	}

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

	@ValueConverter(rule = "AccessCategory")
	public IValueConverter<AccessCategory> AccessCategory() {
		return new IValueConverter<AccessCategory>() {
			@Override
			public AccessCategory toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return AccessCategory.get(string);
			}

			@Override
			public String toString(AccessCategory value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "FlowSource")
	public IValueConverter<FlowKind> FlowSource() {
		return new IValueConverter<FlowKind>() {
			@Override
			public FlowKind toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return FlowKind.get(string.toLowerCase());
			}

			@Override
			public String toString(FlowKind value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "FlowSink")
	public IValueConverter<FlowKind> FlowSink() {
		return new IValueConverter<FlowKind>() {
			@Override
			public FlowKind toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return FlowKind.get(string.toLowerCase());
			}

			@Override
			public String toString(FlowKind value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "FlowPath")
	public IValueConverter<FlowKind> FlowPath() {
		return new IValueConverter<FlowKind>() {
			@Override
			public FlowKind toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return FlowKind.get(string.toLowerCase());
			}

			@Override
			public String toString(FlowKind value) {
				return value.getName();
			}
		};
	}

}
