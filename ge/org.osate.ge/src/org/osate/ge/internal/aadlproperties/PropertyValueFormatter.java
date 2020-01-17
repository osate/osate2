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
package org.osate.ge.internal.aadlproperties;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.ge.di.Names;
import org.osate.ge.internal.model.AgePropertyValue;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.query.Queryable;

import com.google.common.collect.Ordering;

public class PropertyValueFormatter {
	private final static Comparator<AgePropertyValue> arrayIndicesComparator = new Comparator<AgePropertyValue>() {
		@Override
		public int compare(final AgePropertyValue pv1, final AgePropertyValue pv2) {
			return compare(pv1.getArrayIndices(), pv2.getArrayIndices(), 0);
		}

		private int compare(final List<Integer> list1, final List<Integer> list2, final int index) {
			if(list1.size() < index) {
				return -1;
			}

			if(list2.size() < index) {
				return 1;
			}

			int result = Integer.compare(list1.get(index), list2.get(index));
			return result == 0 ? compare(list1, list2, index+1) : result;
		}
	};

	private static final Comparator<String> caseInsensitiveNullFirstComparator = Ordering.from(String.CASE_INSENSITIVE_ORDER).nullsFirst();
	private static final Comparator<AgePropertyValue> appliesToComparator = Comparator.comparing((AgePropertyValue pv) -> pv.getAppliesToRef(), caseInsensitiveNullFirstComparator);
	private static final Comparator<AgePropertyValue> propertyValueComparator = Ordering.from(appliesToComparator).compound(arrayIndicesComparator);


	/**
	 *
	 * @param propertyValueQueryable
	 * @param prv
	 * @param expandComplexValues if true values inside of lists and groups will be contained in the result.
	 * @return
	 */
	public static String getUserString(final @Named(Names.BUSINESS_OBJECT_CONTEXT) Queryable pvgQueryable,
			final boolean singleLine,
			final boolean includeOnlyValuesBasedOnCompletelyProcessedAssociations,
			final boolean includeValues,
			final boolean includeAppliesTo,
			final boolean expandComplexValues) {
		if(pvgQueryable == null || pvgQueryable.getParent() == null) {
			return "";
		}

		if(!(pvgQueryable.getBusinessObject() instanceof PropertyValueGroup)) {
			throw new RuntimeException("Queryable business object must be a PropertyValueGroup");
		}
		final PropertyValueGroup pvg = (PropertyValueGroup)pvgQueryable.getBusinessObject();

		final StringBuilder sb = new StringBuilder();

		Stream<AgePropertyValue> propertyValuesStream = pvg.getPropertyValues().stream();
		if(includeOnlyValuesBasedOnCompletelyProcessedAssociations) {
			propertyValuesStream = propertyValuesStream.filter(pv -> pv.isBasedOnCompletelyProcessedAssociation());
		}

		final List<AgePropertyValue> sortedPropertyValues = propertyValuesStream.
				sorted(propertyValueComparator).
				collect(Collectors.toList());

		if(singleLine && sortedPropertyValues.size() > 1) {
			sb.append(AadlUtil.getPropertySetElementName(pvg.getProperty()));

			if(includeValues) {
				sb.append(": <multiple>");
			}
		} else {
			final Queryable pvgParentQueryable = pvgQueryable.getParent();
			for(final AgePropertyValue pv : sortedPropertyValues) {
				if(sb.length() != 0) {
					sb.append('\n');
				}

				sb.append(AadlUtil.getPropertySetElementName(pvg.getProperty()));
				appendArrayIndices(sb, pv);

				if(includeValues) {
					sb.append(": ");
					appendPropertyResultValue(sb, pv.getPropertyResult(), pv.getValue(), pvgParentQueryable, expandComplexValues);
				}

				// Add applies to
				if(includeAppliesTo) {
					if(pv.getAppliesToRef() != null) {
						sb.append(" applies to ");
						sb.append(pv.getAppliesToRef());
					}
				}
			}
		}

		return sb.toString();
	}

	private static void appendArrayIndices(final StringBuilder sb,
			final AgePropertyValue pv) {
		// Append Indices
		for(final Integer idx : pv.getArrayIndices()) {
			sb.append('[');
			sb.append(idx.intValue()+1);
			sb.append(']');
		}
	}

	private static void appendPropertyResultValue(final StringBuilder sb,
			final PropertyResult pr,
			final Object valueToDisplay,
			final Queryable pvgParentQueryable,
			final boolean expandComplexValues) {
		if(valueToDisplay == null) {
			// Append explanation for null value
			if(pr.nullReason != null) {
				final String nullReasonStr;
				switch(pr.nullReason) {
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
			appendPropertyValue(pvgParentQueryable, valueToDisplay, expandComplexValues, sb);
		}
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
				for(int i = 0; i < rv.propertyAssociationOwnerAncestorLevel; i++) {
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
						// Ignore
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
