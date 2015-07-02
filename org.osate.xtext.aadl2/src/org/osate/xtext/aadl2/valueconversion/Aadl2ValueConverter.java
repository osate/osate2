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
				return string;
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
