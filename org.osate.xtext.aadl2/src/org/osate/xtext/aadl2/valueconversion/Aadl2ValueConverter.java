package org.osate.xtext.aadl2.valueconversion;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.OperationKind;
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
            	int idx = value.indexOf(".");
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
            	if (node == null ) return string;
            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
            	if (e instanceof NamedElement){
            		((NamedElement)e).setName(string);
            	}
				return string;
			}

            public String toString(String value) {
                return value;
            }
        };
    }

    @ValueConverter(rule = "PNAME")
    public IValueConverter<String> PNAME() {
        return new IValueConverter<String>() {
            public String toValue(String string, INode node) {
            	if (node == null ) return string;
            	EObject e = NodeModelUtils.findActualSemanticObjectFor(node);
            	if (e instanceof NamedElement){
            		((NamedElement)e).setName(string);
            	}
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
    @ValueConverter(rule = "DirectionType")
    public IValueConverter<DirectionType> DirectionType() {
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
//    @ValueConverter(rule = "PlusMinus")
//    public IValueConverter<OperationKind> PlusMinus() {
//        return new IValueConverter<OperationKind>() {
//            public OperationKind toValue(String string, INode node) {
//            	
//				return OperationKind.get(string);
//			}
//
//            public String toString(OperationKind value) {
//                return value.getName();
//            }
//        };
//    }
//    
//    @ValueConverter(rule = "NotOp")
//    public IValueConverter<OperationKind> NotOp() {
//        return new IValueConverter<OperationKind>() {
//            public OperationKind toValue(String string, INode node) {
//            	
//				return OperationKind.get(string);
//			}
//
//            public String toString(OperationKind value) {
//                return value.getName();
//            }
//        };
//    }
//    
//    @ValueConverter(rule = "AndOp")
//    public IValueConverter<OperationKind> AndOp() {
//        return new IValueConverter<OperationKind>() {
//            public OperationKind toValue(String string, INode node) {
//            	
//				return OperationKind.get(string);
//			}
//
//            public String toString(OperationKind value) {
//                return value.getName();
//            }
//        };
//    }
//    
//    @ValueConverter(rule = "OrOp")
//    public IValueConverter<OperationKind> OrOp() {
//        return new IValueConverter<OperationKind>() {
//            public OperationKind toValue(String string, INode node) {
//            	
//				return OperationKind.get(string);
//			}
//
//            public String toString(OperationKind value) {
//                return value.getName();
//            }
//        };
//    }
//    
//
//    @ValueConverter(rule = "INTVALUE")
//    public IValueConverter<Long> INTVALUE() {
//        return new IValueConverter<Long>() {
//            public Long toValue(String string, INode node) {
//            	if (string.indexOf('_')!=-1)
//            	string = string.replaceAll("_", "");
//				return Long.valueOf(string);
//			}
//
//            public String toString(Long value) {
//                return value.toString();
//            }
//        };
//    }
//
//    @ValueConverter(rule = "SignedInt")
//    public IValueConverter<Long> SignedInt() {
//        return new IValueConverter<Long>() {
//            public Long toValue(String string, INode node) {
//            	long[] res = parseAadlInteger(string);
//				return Long.valueOf(res[1]);
//			}
//
//            public String toString(Long value) {
//                return value.toString();
//            }
//        };
//    }
//
//
//    @ValueConverter(rule = "SignedReal")
//    public IValueConverter<Double> SignedReal() {
//        return new IValueConverter<Double>() {
//            public Double toValue(String string, INode node) {
//				return parseAadlReal(string);
//			}
//
//            public String toString(Double value) {
//                return value.toString();
//            }
//        };
//    }
//
//    
    
//	private static final char UNDERLINE = '_';
//	private static final char HASHMARK = '#';
//	private static final char EXPONENT = 'E';
//	private static final char PLUS = '+';
//	private static final char MINUS = '-';
//
//	/**
//	 * Parse a string representation of an aadlinteger.
//	 * @param stringValue The string to parse.
//	 * @return An array of length 2: the first element is the base
//	 * and the second element is the value.
//	 * @exception IllegalArgumentException thrown if there is some kind of 
//	 * parsing error.
//	 */
//	public static long[] parseAadlInteger(final String stringValue) {
//		/* First remove '_', convert to upper case, get as char[]. We assume
//		 * the result still has at least one 1 character in it. (Should have
//		 * at least one digit in it and have no '.' in it; otherwise the
//		 * parser/lexer failed us).
//		 */
//		final char[] valueAsChars = normalizeValue(stringValue);
//
//		// Get the sign
//		int currentIdx = 0;
//		final boolean isNegative;
//		if (valueAsChars[0] == PLUS) {
//			isNegative = false;
//			currentIdx = 1;
//		} else if (valueAsChars[0] == MINUS) {
//			isNegative = true;
//			currentIdx = 1;
//		} else {
//			isNegative = false;
//		}
//		
//		// Process as base 10 until we hit end of string, 'E' or '#'
//		long value = 0L;
//		for (; currentIdx < valueAsChars.length; currentIdx++) {
//			final char c = valueAsChars[currentIdx];
//			if (c == EXPONENT || c == HASHMARK) {
//				break;
//			} else if ('0' <= c && c <= '9') {
//				value = (value * 10) + Character.digit(c, 10);
//				if (value < 0) {
//					throw new IllegalArgumentException("Integer value is not representable");
//				}
//			} else {
//				throw new IllegalArgumentException("Unexpected character '" +
//						c + "' at string index " + currentIdx);
//			}
//		}
//		
//		final int base;
//		if (currentIdx == valueAsChars.length)  {
//			// Hit end of string, it's a simple decimal integer
//			base = 10;
//		} else {
//			if (valueAsChars[currentIdx] == EXPONENT) {
//				// Decimal integer with exponent
//				base = 10;
//			} else {
//				// based_integer
//				base = (int) value;
//				if (base < 2 || base > 16) { // base is bad
//					throw new IllegalArgumentException(
//							"Base not between 2 and 16: " + base);
//				} else { // base is good
//					value = 0L;
//					char c = valueAsChars[++currentIdx];
//					while (c != HASHMARK) {
//						final int digit = Character.digit(c, base);
//						if (digit == -1) {
//							throw new IllegalArgumentException(
//									"'" + c + "' at string index " + currentIdx +
//									" is not an extended digit in base " + base);
//						} else {
//							value = (value * base) + digit;
//							if (value < 0) {
//								throw new IllegalArgumentException(
//										"Integer value is not representable");
//							}
//						}
//						c = valueAsChars[++currentIdx];
//					}
//					// eat hashmark
//					currentIdx += 1;
//				}			
//			}
//			
//			// eat the 'e'; based integers don't have to have an exponent
//			if (++currentIdx < valueAsChars.length) {
//				// deal with sign
//				char c = valueAsChars[currentIdx];
//				if (c == MINUS) {
//					throw new IllegalArgumentException(
//							"Integers cannot have a negative exponent");
//				} else if (c == PLUS) {
//					currentIdx += 1;
//				}
//				
//				int exponent = 0;
//				while (currentIdx < valueAsChars.length) {
//					c = valueAsChars[currentIdx++];
//					if ('0' <= c && c <= '9') {
//						exponent = (exponent * 10) + Character.digit(c, 10);
//						if (exponent < 0) {
//							throw new IllegalArgumentException(
//								"Integer value is not representable: cannot represent exponent");
//						}
//					} else {
//						throw new IllegalArgumentException("Unexpected character '" +
//								c + "' at string index " + currentIdx);
//					}
//				}
//				
//				for (int i = 0; i < exponent; i++) {
//					value *= base;
//					if (value < 0) {
//						throw new IllegalArgumentException(
//								"Integer value is not representable");
//					}
//				}
//			}
//		}
//		
//		if (isNegative) value = -value;
//
//		return new long[] { base, value };
//	}
//	
//	/**
//	 * Parse a string representation of an aadlreal.
//	 * 
//	 * @param stringValue
//	 *            The real value to resolve.
//	 * @return The value
//	 * @exception IllegalArgumentException Thrown if the value is not
//	 * parsable into an aadlreal value.
//	 */
//	public static double parseAadlReal(final String stringValue) {
//		try {
//			return Double.parseDouble(stringValue);
//		} catch(final NumberFormatException e) {
//			throw new IllegalArgumentException(
//					"Couldn't resolve literal: " + e.getMessage());
//		}
//	}
//
//
//	/**
//	 * Remove the underlines, &ldquo; <code>_</code>,&rdquo; from the numeric
//	 * literal and forces letters to be uppercase.
//	 * 
//	 * @param value
//	 *            The string to process
//	 * @return The provided string with all the underlines removed, returned as
//	 *         a character array.
//	 */
//	private static char[] normalizeValue(final String value) {
//		int nextUnderlineLoc = value.indexOf(UNDERLINE);
//		if (nextUnderlineLoc == -1) {
//			return value.toUpperCase().toCharArray();
//		} else {
//			// size of the new string <= size of value
//			final StringBuffer working = new StringBuffer(value.length());
//			int lastUnderlineLoc = 0;
//			// already found the first underscore...
//			do {
//				working.append(value.substring(lastUnderlineLoc, nextUnderlineLoc).toUpperCase());
//				lastUnderlineLoc = nextUnderlineLoc+1;
//				nextUnderlineLoc = value.indexOf(UNDERLINE, lastUnderlineLoc);
//			} while (nextUnderlineLoc != -1);
//			// append the last portion of the string
//			working.append(value.substring(lastUnderlineLoc));
//			return working.toString().toCharArray();
//		}
//	}


}
