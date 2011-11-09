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
    

    @ValueConverter(rule = "INTVALUE")
    public IValueConverter<Long> INTVALUE() {
        return new IValueConverter<Long>() {
            public Long toValue(String string, INode node) {
            	if (string.indexOf('_')!=-1)
            	string = string.replaceAll("_", "");
				return Long.valueOf(string);
			}

            public String toString(Long value) {
                return value.toString();
            }
        };
    }

    @ValueConverter(rule = "SignedInt")
    public IValueConverter<Long> SignedInt() {
        return new IValueConverter<Long>() {
            public Long toValue(String string, INode node) {
            	long[] res = ParseUtil.parseAadlInteger(string);
				return Long.valueOf(res[1]);
			}

            public String toString(Long value) {
                return value.toString();
            }
        };
    }


    @ValueConverter(rule = "SignedReal")
    public IValueConverter<Double> SignedReal() {
        return new IValueConverter<Double>() {
            public Double toValue(String string, INode node) {
				return ParseUtil.parseAadlReal(string);
			}

            public String toString(Double value) {
                return value.toString();
            }
        };
    }

    

}
