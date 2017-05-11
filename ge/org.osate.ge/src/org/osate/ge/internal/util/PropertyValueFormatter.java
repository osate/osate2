package org.osate.ge.internal.util;

import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComputedValue;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.ge.di.Names;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.util.PropertyResult.ReferenceValueWithContext;

public class PropertyValueFormatter {
	/**
	 * 
	 * @param propertyValueQueryable
	 * @param prv
	 * @param expandComplexValues if true values inside of lists and groups will be contained in the result.
	 * @return
	 */
	public static String getUserString(final @Named(Names.BUSINESS_OBJECT_CONTEXT) Queryable propertyValueQueryable, 
			final PropertyResultValue prv, 
			final boolean expandComplexValues) {
		if(propertyValueQueryable == null) {
			return "";
		}
		
		final StringBuilder sb = new StringBuilder();
		sb.append(prv.getProperty().getName());
		
		// Append Indices
		for(final Integer idx : prv.getArrayIndices()) {
			sb.append('[');
			sb.append(idx.intValue()+1);
			sb.append(']');
		}
		sb.append(": ");
		
		if(prv.getValue() == null) {
			// Append explanation for null value
			if(prv.getPropertyResult().nullReason != null) {
				final String nullReasonStr;
				switch(prv.getPropertyResult().nullReason) {
				case ARRAY_ELEMENT_SPECIFIC:
					nullReasonStr = "<array element specific>";
					break;
					
				case BINDING_SPECIFIC:
					nullReasonStr = "<binding specific>";
					break;
					
				case MODAL:
					nullReasonStr = "<modal>";					
					break;
					
				default:
					nullReasonStr = "";
					break;
				}
				
				sb.append(nullReasonStr);
			}
		} else {
			appendPropertyValue(propertyValueQueryable, prv.getValue(), expandComplexValues, sb);
		}
		
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static void appendPropertyValue(final Queryable q, 
			final Object value, 
			final boolean expandComplexValues, 
			final StringBuilder sb) {
		if(value instanceof List) {
			if(expandComplexValues) {
				sb.append('(');
				boolean isFirst = true;
				for(final Object element : (List<Object>)value) {
					if(!isFirst) {
						sb.append(", ");
					}
					isFirst = false;
					
					appendPropertyValue(q, element, expandComplexValues, sb);
				}
				sb.append(')');
			} else {
				sb.append("<list>");
			}
		} else {
			if(value instanceof BooleanLiteral) {
				final BooleanLiteral bl = (BooleanLiteral)value;
				sb.append(bl.getValue() ? "true" : "false");
			} else if(value instanceof ClassifierValue) {
				final ClassifierValue cv = (ClassifierValue)value;
				sb.append(cv.getClassifier() == null ? "<error>" : cv.getClassifier().getQualifiedName());
			} else if(value instanceof ComputedValue) {
				final ComputedValue cv = (ComputedValue)value;
				sb.append(cv.getFunction());
			} else if(value instanceof NamedValue) {
				final NamedValue nv = (NamedValue)value;
				if(nv.getNamedValue() == null) {
					sb.append("<null>");				
				} else {
					appendPropertyValue(q, nv.getNamedValue(), expandComplexValues, sb);
				}
			} else if(value instanceof AbstractNamedValue) {
				final AbstractNamedValue anv = (AbstractNamedValue)value;
				sb.append(anv instanceof NamedElement ? ((NamedElement)anv).getName() : "<error>");
			} else if(value instanceof IntegerLiteral) {
				final IntegerLiteral il = (IntegerLiteral)value;
				sb.append(il.getValue());
				if(il.getUnit() != null) {
					sb.append(' ');
					sb.append(il.getUnit().getName());
				}
			} else if(value instanceof RealLiteral) {
				final RealLiteral rl = (RealLiteral)value;
				sb.append(rl.getValue());
				if(rl.getUnit() != null) {
					sb.append(' ');
					sb.append(rl.getUnit().getName());
				}
			} else if(value instanceof RangeValue) {
				final RangeValue rv = (RangeValue)value;
				appendPropertyValue(q, rv.getMinimum(), expandComplexValues, sb);
				sb.append(" .. ");
				appendPropertyValue(q, rv.getMaximum(), expandComplexValues, sb);
				if(rv.getDeltaValue() != null) {
					sb.append("delta ");
					appendPropertyValue(q, rv.getDelta(), expandComplexValues, sb);
				}
			} else if(value instanceof RecordValue) {
				final RecordValue rv = (RecordValue)value;
				if(expandComplexValues) {
					sb.append('[');
					for(final BasicPropertyAssociation bpa : rv.getOwnedFieldValues()) {
						sb.append(bpa.getProperty() == null ? "<UnknownField>" : bpa.getProperty().getName());
						sb.append(" => ");
						appendPropertyValue(q, bpa.getValue(), expandComplexValues, sb);
						sb.append("; ");
					}
					sb.append(']');
				} else {
					sb.append("<record>");
				}
			} else if(value instanceof StringLiteral) {
				final StringLiteral sl = (StringLiteral)value;
				sb.append('"');
				sb.append(sl.getValue());
				sb.append('"');
			} else if(value instanceof ReferenceValueWithContext) {
				final ReferenceValueWithContext rv = (ReferenceValueWithContext)value;
				
				Queryable tmp = q;
				for(int i = 0; i < rv.ownerAncestorLevel; i++) {
					tmp = tmp.getParent();
					if(tmp == null) {
						return;
					}
				}
				
				// The reference is relative to the current value of tmp
				// Append Each Level Until Reaching the Containing Classifier
				String prefix = null;
				while(tmp != null && tmp.getBusinessObject() instanceof NamedElement && !(tmp.getBusinessObject() instanceof Classifier)) {
					final String containerName = ((NamedElement)tmp.getBusinessObject()).getName();
					if(containerName == null) {
						// TODO: Handle
						return;
					}
					
					if(prefix == null) {
						prefix = containerName;
					} else {
						prefix = containerName + "." + prefix;
					}
					
					tmp = tmp.getParent();
				}
				
				// Handle relative portion.. need to add appropriate ancestors.
				if(prefix != null) {
					sb.append(prefix);
				}
				boolean isFirst = prefix == null;
				for(ContainmentPathElement pathElement = rv.referenceValue.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
					if(!isFirst) {
						sb.append(".");
					}
					isFirst = false;
					
					final NamedElement ne = pathElement.getNamedElement();
					if(ne == null) {
						sb.append("<null>");					
					} else {
						sb.append(ne.getName());
					}
					
					for(final ArrayRange ar : pathElement.getArrayRanges()) {
						sb.append('[');
						sb.append(ar.getLowerBound());
						if(ar.getUpperBound() > 0) {
							sb.append(" .. ");
							sb.append(ar.getUpperBound());
						}
						sb.append(']');
					}
				}
				
			} else if(value instanceof InstanceReferenceValue) {
				final InstanceReferenceValue irv = (InstanceReferenceValue)value;
				if(irv.getReferencedInstanceObject() != null) {					
					sb.append(irv.getReferencedInstanceObject().getComponentInstancePath());
				} else {
					sb.append("?");
				}
			} else if(value instanceof EObject) {
				final INode n = NodeModelUtils.getNode((EObject)value);
				if(n != null) {
					final String txt = NodeModelUtils.getTokenText(n);
					if(txt != null) {
						sb.append(txt);
						return;
					}
				}
				sb.append("<Unable to Retrieve>");
			} else {
				sb.append("<Unsupported Value Type>");
			}
		}
	}
}
