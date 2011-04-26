package org.osate.xtext.aadl2.valueconversion;

import java.util.Iterator;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ConnectionKind;
import org.osate.aadl2.DirectionType;

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
    
    @ValueConverter(rule = "ConnectionType")
    public IValueConverter<ConnectionKind> ConnectionType() {
        return new IValueConverter<ConnectionKind>() {
            public ConnectionKind toValue(String string, INode node) {
            	
				return ConnectionKind.get(string);
			}

            public String toString(ConnectionKind value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "ComponentCategoryKW")
    public IValueConverter<ComponentCategory> ComponentCategoryKW() {
        return new IValueConverter<ComponentCategory>() {
            public ComponentCategory toValue(String string, INode node) {
            	
				return ComponentCategory.get(string);
			}

            public String toString(ComponentCategory value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "SystemSubCategories")
    public IValueConverter<ComponentCategory> SystemSubCategories() {
        return new IValueConverter<ComponentCategory>() {
            public ComponentCategory toValue(String string, INode node) {
            	
				return ComponentCategory.get(string);
			}

            public String toString(ComponentCategory value) {
                return value.getName();
            }
        };
    }
    
}
