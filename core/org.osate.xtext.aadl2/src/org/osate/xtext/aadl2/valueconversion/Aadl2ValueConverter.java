package org.osate.xtext.aadl2.valueconversion;

import java.util.Iterator;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.ConnectionKind;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.PortCategory;

public class Aadl2ValueConverter extends DefaultTerminalConverters {
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
            	int idx = value.indexOf(".");
            	if (idx > -1){
            		return value.substring(idx+1);
            	}
                return value;
            }
        };
    }

    @ValueConverter(rule = "PortCategory")
    public IValueConverter<PortCategory> PortCategory() {
        return new IValueConverter<PortCategory>() {
            public PortCategory toValue(String string, INode node) {
            	
				return PortCategory.get(string);
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
            	
				return DirectionType.get(string);
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
            	
				return DirectionType.get(string);
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
            	
				return AccessType.get(string);
			}

            public String toString(AccessType value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "ConnectionKind")
    public IValueConverter<ConnectionKind> ConnectionKind() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "PortConnectionKind")
    public IValueConverter<ConnectionKind> PortConnectionKind() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "AccessConnectionKind")
    public IValueConverter<ConnectionKind> AccessConnectionKind() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "FeatureGroupConnectionKind")
    public IValueConverter<ConnectionKind> FeatureGroupConnectionKind() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "ParameterConnectionKind")
    public IValueConverter<ConnectionKind> ParameterConnectionKind() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    @ValueConverter(rule = "FeatureConnectionKind")
    public IValueConverter<ConnectionKind> FeatureConnectionKind() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "ComponentCategory")
    public IValueConverter<ComponentCategory> ComponentCategory() {
        return new IValueConverter<ComponentCategory>() {
            public ComponentCategory toValue(String string, INode node) {
            	
				return ComponentCategory.get(string);
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
            	
				return AccessCategory.get(string);
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
            	
				return FlowKind.get(string);
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
            	
				return FlowKind.get(string);
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
            	
				return FlowKind.get(string);
			}

            public String toString(FlowKind value) {
                return value.getName();
            }
        };
    }

    @ValueConverter(rule = "gINT")
    public IValueConverter<Integer> gINT() {
        return new IValueConverter<Integer>() {
            public Integer toValue(String string, INode node) {
            	
				return Integer.getInteger(string);
			}

            public String toString(Integer value) {
                return value.toString();
            }
        };
    }

}
