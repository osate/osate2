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
package org.osate.aadl2.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2Util;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Named Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.NamedElement#getNamespace() <em>Get Namespace</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#qualifiedName() <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#getPropertyValues(java.lang.String, java.lang.String) <em>Get Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedElementOperations extends ElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Namespace getNamespace(NamedElement namedElement) {
		// DONE: implement this method
		return namedElement.getOwner() instanceof Namespace ? (Namespace) namedElement.getOwner() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name, the qualified name is constructed from the names of the containing namespaces.
	 * if self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty() then
	 *   self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))
	 * else
	 *   ''
	 * endif
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static String qualifiedName(NamedElement namedElement) {
		if (namedElement.hasName()) {
			Namespace namespace = namedElement.getNamespace();
			if (namespace != null) {
				if (namespace instanceof PropertySet && namespace.hasName()) {
					return namespace.getName() + "::" + namedElement.getName();
				} else if (namespace instanceof PackageSection && ((AadlPackage) namespace.getOwner()).hasName()) {
					return ((AadlPackage) namespace.getOwner()).getName() + "::" + namedElement.getName();
				} else {
					return qualifiedName(namespace) + '.' + namedElement.getName();
				}
			} else {
				return namedElement.getName();
			}
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated Will be removed in 2.7.
	 * @generated NOT
	 */
	@Deprecated
	public static EList<PropertyExpression> getPropertyValues(NamedElement namedElement, String propertySetName,
			String propertyName) {
		final EList<PropertyExpression> result = new BasicEList<PropertyExpression>();
		final Property property = Aadl2Util.lookupPropertyDefinition(namedElement, propertySetName, propertyName);

		try {
			if (property.isList()) {
				result.addAll(namedElement.getPropertyValueList(property));
			} else {
				result.add(namedElement.getSimplePropertyValue(property));
			}
		} catch (final PropertyNotPresentException p_ex) {
			// We simply return an empty list when there is no property associations
		}

		return result;
	}

} // NamedElementOperations