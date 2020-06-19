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
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.GlobalNamespace;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PublicPackageSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Global Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.GlobalNamespaceImpl#getMembers <em>Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.GlobalNamespaceImpl#getPackages <em>Package</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.GlobalNamespaceImpl#getPropertySets <em>Property Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalNamespaceImpl extends NamespaceImpl implements GlobalNamespace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalNamespaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getGlobalNamespace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.GLOBAL_NAMESPACE__MEMBER, MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getMembers() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MEMBER_ESUBSETS = new int[] { Aadl2Package.GLOBAL_NAMESPACE__OWNED_MEMBER,
			Aadl2Package.GLOBAL_NAMESPACE__PACKAGE, Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PublicPackageSection> getPackages() {
		// TODO: implement this method to return the 'Package' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertySet> getPropertySets() {
		// TODO: implement this method to return the 'Property Set' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.GLOBAL_NAMESPACE__PACKAGE:
			return getPackages();
		case Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET:
			return getPropertySets();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.GLOBAL_NAMESPACE__PACKAGE:
			getPackages().clear();
			getPackages().addAll((Collection<? extends PublicPackageSection>) newValue);
			return;
		case Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET:
			getPropertySets().clear();
			getPropertySets().addAll((Collection<? extends PropertySet>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.GLOBAL_NAMESPACE__PACKAGE:
			getPackages().clear();
			return;
		case Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET:
			getPropertySets().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.GLOBAL_NAMESPACE__MEMBER:
			return isSetMembers();
		case Aadl2Package.GLOBAL_NAMESPACE__PACKAGE:
			return !getPackages().isEmpty();
		case Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET:
			return !getPropertySets().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMembers() {
		return super.isSetMembers() || eIsSet(Aadl2Package.GLOBAL_NAMESPACE__PACKAGE)
				|| eIsSet(Aadl2Package.GLOBAL_NAMESPACE__PROPERTY_SET);
	}

} // GlobalNamespaceImpl
