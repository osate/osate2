package org.osate.xtext.aadl2.valueconversion;

import java.util.Iterator;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
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
            public String toValue(String string, INode node) {
            	if (node == null ) return string;
            	ILeafNode l1 = null;
            	ILeafNode l2 = null;
            	ILeafNode l3 = null;
        		Iterable<ILeafNode> n =  node.getParent().getLeafNodes();
        		  for (Iterator<ILeafNode> i = n.iterator(); i.hasNext(); ){
        		      l3 = l2;
        		      l2= l1;
        			  l1 = (ILeafNode)i.next();
        		  }
        		  if (l3 != null) return l3.getText()+"."+string;
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

            public String toString(String value) {
            	int idx = value.lastIndexOf(".");
            	if (idx > -1){
            		return value.substring(idx+1);
            	}
                return value;
            }
        };
    }

    @ValueConverter(rule = "REFINEDNAME")
    public IValueConverter<String> REFINEDNAME() {
        return new IValueConverter<String>() {
            public String toValue(String string, INode node) {
//            	if (node == null ) return string;
//            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
//            	if (e instanceof NamedElement){
//            		((NamedElement)e).setName(string);
//            	}
				return string;
			}

            public String toString(String value) {
                return value;
            }
        };
    }

    @ValueConverter(rule = "ID")
    public IValueConverter<String> ID() {
        return new IValueConverter<String>() {
            public String toValue(String string, INode node) {
//            	if (node == null ) return string;
//            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
//            	if (e instanceof NamedElement){
//            		((NamedElement)e).setName(string);
//            	}
				return string;
			}

            public String toString(String value) {
                int idx = value.lastIndexOf("::");
                if (idx < 0 ) return value;
            	return value.substring(idx+2);
            }
        };
    }

    @ValueConverter(rule = "PNAME")
    public IValueConverter<String> PNAME() {
        return new IValueConverter<String>() {
            public String toValue(String string, INode node) {
//            	if (node == null ) return string;
//            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
//            	if (e instanceof NamedElement){
//            		((NamedElement)e).setName(string);
//            	}
				return string;
			}

            public String toString(String value) {
                return value;
            }
        };
    }

    @ValueConverter(rule = "NoQuoteString")
    public IValueConverter<String> NoQuoteString() {
        return new IValueConverter<String>() {
            public String toValue(String string, INode node) {
            	if (string.charAt(0) == '"'){
            		string = string.substring(1);
            	}
            	if (string.endsWith("\"")){
            		string = string.substring(0, string.length()-1);
            	}
				return string;
			}

            public String toString(String value) {
            	if (value.charAt(0) == '"')
            		return value;
            	return '"'+value+'"';
            }
        };
    }

    
    
    @ValueConverter(rule = "PortCategory")
    public IValueConverter<PortCategory> PortCategory() {
        return new IValueConverter<PortCategory>() {
            public PortCategory toValue(String string, INode node) {
            	
				return PortCategory.get(string.toLowerCase());
			}

            public String toString(PortCategory value) {
                return value.getName();
            }
        };
    }

    
    @ValueConverter(rule = "PortDirection")
    public IValueConverter<DirectionType> PortDirection() {
        return new IValueConverter<DirectionType>() {
            public DirectionType toValue(String string, INode node) {
            	
				return DirectionType.get(string.toLowerCase());
			}

            public String toString(DirectionType value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "DirectionType")
    public IValueConverter<DirectionType> DirectionType() {
        return new IValueConverter<DirectionType>() {
            public DirectionType toValue(String string, INode node) {
            	
				return DirectionType.get(string.toLowerCase());
			}

            public String toString(DirectionType value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "InOutDirection")
    public IValueConverter<DirectionType> InOutDirection() {
        return new IValueConverter<DirectionType>() {
            public DirectionType toValue(String string, INode node) {
            	
				return DirectionType.get(string.toLowerCase());
			}

            public String toString(DirectionType value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "AccessDirection")
    public IValueConverter<AccessType> AccessDirection() {
        return new IValueConverter<AccessType>() {
            public AccessType toValue(String string, INode node) {
            	
				return AccessType.get(string.toLowerCase());
			}

            public String toString(AccessType value) {
                return value.getName();
            }
        };
    }
    
    
    @ValueConverter(rule = "ComponentCategory")
    public IValueConverter<ComponentCategory> ComponentCategory() {
        return new IValueConverter<ComponentCategory>() {
            public ComponentCategory toValue(String string, INode node) {
            	
				return ComponentCategory.get(string.toLowerCase());
			}

            public String toString(ComponentCategory value) {
                return value.getName();
            }
        };
    }

    @ValueConverter(rule = "AccessCategory")
    public IValueConverter<AccessCategory> AccessCategory() {
        return new IValueConverter<AccessCategory>() {
            public AccessCategory toValue(String string, INode node) {
            	
				return AccessCategory.get(string.toLowerCase());
			}

            public String toString(AccessCategory value) {
                return value.getName();
            }
        };
    }

    @ValueConverter(rule = "FlowSource")
    public IValueConverter<FlowKind> FlowSource() {
        return new IValueConverter<FlowKind>() {
            public FlowKind toValue(String string, INode node) {
            	
				return FlowKind.get(string.toLowerCase());
			}

            public String toString(FlowKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "FlowSink")
    public IValueConverter<FlowKind> FlowSink() {
        return new IValueConverter<FlowKind>() {
            public FlowKind toValue(String string, INode node) {
            	
				return FlowKind.get(string.toLowerCase());
			}

            public String toString(FlowKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "FlowPath")
    public IValueConverter<FlowKind> FlowPath() {
        return new IValueConverter<FlowKind>() {
            public FlowKind toValue(String string, INode node) {
            	
				return FlowKind.get(string.toLowerCase());
			}

            public String toString(FlowKind value) {
                return value.getName();
            }
        };
    }


}
