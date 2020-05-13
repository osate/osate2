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
package org.osate.aadl2.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceUtil;

public class Aadl2Util {
	/**
	 * The property service to be used by the meta-model class to lookup property definitions. When using OSATE in the
	 * Eclipse IDE, an implementation is provided by the org.osate.xtext.aadl2.properties.ui plugin making use of
	 * GetProperties to search for property definitions in the workspace.
	 *
	 * @deprecated Will be removed in 2.7.
	 */
	@Deprecated
	public static IPropertyService propertyService = null;

	/**
	 * Xtext resolver leaves unresolved proxy when reference cannot be resolved.
	 * @param eo
	 * @return
	 */
	public static boolean isNull(EObject eo) {
		return eo == null || eo.eIsProxy();
	}

	/**
	 * Xtext resolver leaves unresolved proxy when reference cannot be resolved.
	 * @param eo
	 * @return
	 */
	public static boolean isUnresolved(EObject eo) {
		return eo.eIsProxy();
	}

	/**
	 * Check to see if the Property definitions are the same
	 * The methods compensates for the possible problem that the objects are different.
	 *
	 * @param p1 Property
	 * @param p2 Property
	 * @return true if they have the same name
	 */
	public static boolean sameProperty(Property p1, Property p2) {
		String p1Name = p1.getQualifiedName();
		String p2Name = p2.getQualifiedName();
		boolean sameName = p1Name.equalsIgnoreCase(p2Name);
		return sameName;
	}

	public static String getName(NamedElement ne) {
		if (ne.hasName()) {
			return ne.getName();
		}
		return getRefinedName(ne, ne);
	}

	/**
	 * refined Elements do not have an assigned name, but they have a reference to the Element they refine.
	 * One of them is the original with an actually assigned name
	 * @param ne Element whose name we are trying to retrieve
	 * @param root The start of the search. Used to detect cycles
	 * @return
	 */
	public static String getRefinedName(NamedElement ne, NamedElement root) {
		if (ne instanceof RefinableElement) {
			RefinableElement re = (RefinableElement) ne;
			RefinableElement ref = re.getRefinedElement();
			if (ref == root) {
				return null; // terminate on cycle
			}
			if (ref != null) {
				return getRefinedName(ref, root);
			}
			// no additional reference pointer, return name
			return ne.getName();
		}
		return null;
	}

	/**
	 * Find owned named elements. In the case of a thread implementation, subprogram implementation,
	 * or abstract implementation also look up subprogram calls.
	 * @param owner Classifier in which the lookup is performed
	 * @param name name of Element to be found
	 * @return NamedElement or null
	 */
	public static NamedElement findOwnedNamedElement(Classifier owner, String name) {
		for (Element e : owner.getOwnedElements()) {
			if (!(e instanceof NamedElement)) {
				continue;
			}
			NamedElement ne = (NamedElement) e;
			String neName = Aadl2Util.getName(ne);
			if (neName != null && neName.equalsIgnoreCase(name)) {
				return ne;
			}
		}
		if (owner instanceof BehavioredImplementation) {
			BehavioredImplementation bi = (BehavioredImplementation) owner;
			for (SubprogramCall sc : bi.getSubprogramCalls()) {
				if (sc.getName() != null && sc.getName().equalsIgnoreCase(name)) {
					return sc;
				}
			}
		}

		return null;
	}

	/**
	 * find property definition for given name. The property may be qualified by the property set name via the ps parameter
	 * For predeclared properties this is not required
	 * @param context EObject the model object that references the property definition
	 * @param ps String property set name, which may be null
	 * @param name String Property Definition name
	 * @return Property or null
	 * @deprecated Will be removed in 2.7.
	 */
	@Deprecated
	public static Property lookupPropertyDefinition(final EObject context, final String propSetName,
			final String propName) {
		if (propertyService != null) {
			return propertyService.lookupPropertyDefinition(context, propSetName, propName);
		}

		// When no property service is provided, search through the resources of the resource set.
		for (final Resource res : context.eResource().getResourceSet().getResources()) {
			if (!res.getContents().isEmpty()) {
				final EObject root = res.getContents().get(0);

				if (root instanceof PropertySet) {
					final PropertySet propSet = (PropertySet) root;

					if (propSetName.equals(propSet.getName())) {
						final NamedElement property = propSet.findNamedElement(propName);

						if (property instanceof Property) {
							return (Property) property;
						}
					}
				}
			}
		}

		return null;
	}

	public static String getPrintableSOMName(SystemOperationMode som) {
		if (som == null || InstanceUtil.isNoMode(som)) {
			return "";
		}
		return "In SystemMode " + som.getName();
	}

	public static String getPrintableSOMMembers(SystemOperationMode som) {
		String members = "";
		if (som == null || InstanceUtil.isNoMode(som)) {
			return "";
		}
		for (ModeInstance mode : som.getCurrentModes()) {
			if (members.isEmpty()) {
				members = mode.getComponentInstancePath();
			} else {
				members = members + ", " + mode.getComponentInstancePath();
			}
		}
		return "(" + members + ")";
	}

	public static boolean isPrintableSOMName(SystemOperationMode som) {
		return (som != null && !InstanceUtil.isNoMode(som));
	}

	public static String getPrintablePathName(ContainedNamedElement path) {
		String pathname = "";
		EList<ContainmentPathElement> pathelements = path.getContainmentPathElements();
		for (ContainmentPathElement containmentPathElement : pathelements) {
			pathname = pathname + (pathname.isEmpty() ? "" : ".") + containmentPathElement.getNamedElement().getName();
		}
		return pathname;
	}

	/**
	 * extract the item name from a qualified name, the identifier after the last ::
	 * @param qualname String Qualified name
	 * @return String item name
	 */
	public static String getItemNameWithoutQualification(String qualname) {
		final int idx = qualname.lastIndexOf("::");
		if (idx != -1) {
			return qualname.substring(idx + 2);
		}
		return qualname;
	}

	/**
	 * extract the package name of a qualified name, everything up to the last :: or null
	 * @param qualname
	 * @return String
	 */
	public static String getPackageName(String qualname) {
		final int idx = qualname.lastIndexOf("::");
		if (idx != -1) {
			return qualname.substring(0, idx);
		}
		return null;
	}

	public static boolean sameUnit(UnitLiteral l1, UnitLiteral l2) {
		String p1Name = l1.getQualifiedName();
		String p2Name = l2.getQualifiedName();
		return p1Name.equalsIgnoreCase(p2Name);
	}

	public static boolean isNoModes(SystemOperationMode som) {
		return (som == null || som.getName().equalsIgnoreCase("No Modes"));
	}

	/**
	 * Determines if two property types are equal.  This doesn't try to be very fancy because we
	 * want to use type names to compare more complicated types.  Two types are equal if
	 * <ul>
	 *   <li>They are both {@link ListType} and the {@link ListType#getElementType element types} are equal, or
	 *   <li>They are both {@link AadlBoolean}, {@link AadlString}, {@link AadlInteger}, or
	 *   {@link AadlReal} and both have {@code null} {@link NamedElement#getName() names} and equal
	 *   {@link NumberType#getUnitsType() units types} as determined by <code>==</code>, or
	 *   <li>Both types are equal as determined by the <code>==</code> operator.
	 * </ul>
	 *
	 * @since 3.0
	 */
	public static boolean arePropertyTypesEqual(final PropertyType type1, final PropertyType type2) {
		boolean equal = false;

		if (type1 instanceof ListType && type2 instanceof ListType) {
			equal = arePropertyTypesEqual(((ListType) type1).getElementType(), ((ListType) type2).getElementType());
		} else if (type1 instanceof AadlBoolean && type2 instanceof AadlBoolean) {
			equal = type1.getName() == null && type2.getName() == null;
		} else if (type1 instanceof AadlString && type2 instanceof AadlString) {
			equal = type1.getName() == null && type2.getName() == null;
		} else if (type1 instanceof AadlInteger && type2 instanceof AadlInteger) {
			final NumberType nt1 = (NumberType) type1;
			final NumberType nt2 = (NumberType) type2;
			equal = nt1.getName() == null && nt2.getName() == null && nt1.getUnitsType() == nt2.getUnitsType();
		} else if (type1 instanceof AadlReal && type2 instanceof AadlReal) {
			final NumberType nt1 = (NumberType) type1;
			final NumberType nt2 = (NumberType) type2;
			equal = nt1.getName() == null && nt2.getName() == null && nt1.getUnitsType() == nt2.getUnitsType();
		}

		return equal ? true : type1 == type2;
	}
}
