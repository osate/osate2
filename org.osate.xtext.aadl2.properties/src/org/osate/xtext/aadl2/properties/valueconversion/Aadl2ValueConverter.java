package org.osate.xtext.aadl2.properties.valueconversion;


import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.OperationKind;

public class Aadl2ValueConverter extends DefaultTerminalConverters {

    
    @ValueConverter(rule = "PlusMinus")
    public IValueConverter<OperationKind> PlusMinus() {
        return new IValueConverter<OperationKind>() {
            public OperationKind toValue(String string, INode node) {
            	
				return OperationKind.get(string);
			}

            public String toString(OperationKind value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "NotOp")
    public IValueConverter<OperationKind> NotOp() {
        return new IValueConverter<OperationKind>() {
            public OperationKind toValue(String string, INode node) {
            	
				return OperationKind.get(string);
			}

            public String toString(OperationKind value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "AndOp")
    public IValueConverter<OperationKind> AndOp() {
        return new IValueConverter<OperationKind>() {
            public OperationKind toValue(String string, INode node) {
            	
				return OperationKind.get(string);
			}

            public String toString(OperationKind value) {
                return value.getName();
            }
        };
    }
    
    @ValueConverter(rule = "OrOp")
    public IValueConverter<OperationKind> OrOp() {
        return new IValueConverter<OperationKind>() {
            public OperationKind toValue(String string, INode node) {
            	
				return OperationKind.get(string);
			}

            public String toString(OperationKind value) {
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
