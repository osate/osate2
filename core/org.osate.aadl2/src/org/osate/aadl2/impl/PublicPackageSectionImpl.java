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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Public Package Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PublicPackageSectionImpl#getPrivateSection <em>Private Section</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PublicPackageSectionImpl extends PackageSectionImpl implements PublicPackageSection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PublicPackageSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPublicPackageSection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivatePackageSection getPrivateSection() {
		PrivatePackageSection privateSection = basicGetPrivateSection();
		return privateSection != null && ((EObject) privateSection).eIsProxy()
				? (PrivatePackageSection) eResolveProxy((InternalEObject) privateSection)
				: privateSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public PrivatePackageSection basicGetPrivateSection() {
		// DONE: Implemented
		return ((AadlPackage) getOwner()).getPrivateSection();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.NamedElementImpl#getNamespace()
	 */
	public Namespace getNamespace() {
		// TODO: Return global namespace
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__PRIVATE_SECTION:
			if (resolve) {
				return getPrivateSection();
			}
			return basicGetPrivateSection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.PUBLIC_PACKAGE_SECTION__PRIVATE_SECTION:
			return basicGetPrivateSection() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Returns the name of the package.
	 */
	public String getName() {
		// DB: Add the public suffix like it is done for the private package section so that a public package section
		// has a different name than the package.
		return super.getName() + "_public";
	}
} // PublicPackageSectionImpl
