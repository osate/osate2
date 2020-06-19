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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.util.Aadl2Util;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Refinable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.RefinableElementImpl#getRefinedElement <em>Refined Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.RefinableElementImpl#getRefinementContext <em>Refinement Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RefinableElementImpl extends NamedElementImpl implements RefinableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefinableElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getRefinableElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier getRefinementContext() {
		Classifier refinementContext = basicGetRefinementContext();
		return refinementContext != null && ((EObject) refinementContext).eIsProxy()
				? (Classifier) eResolveProxy((InternalEObject) refinementContext)
				: refinementContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Classifier basicGetRefinementContext() {
		// DONE: implement this method to return the 'Refinement Context'
		// reference
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinableElement getRefinedElement() {
		RefinableElement refinedElement = basicGetRefinedElement();
		return refinedElement != null && ((EObject) refinedElement).eIsProxy()
				? (RefinableElement) eResolveProxy((InternalEObject) refinedElement)
				: refinedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinableElement basicGetRefinedElement() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.REFINABLE_ELEMENT__REFINED_ELEMENT:
			if (resolve) {
				return getRefinedElement();
			}
			return basicGetRefinedElement();
		case Aadl2Package.REFINABLE_ELEMENT__REFINEMENT_CONTEXT:
			if (resolve) {
				return getRefinementContext();
			}
			return basicGetRefinementContext();
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
		case Aadl2Package.REFINABLE_ELEMENT__REFINED_ELEMENT:
			return isSetRefinedElement();
		case Aadl2Package.REFINABLE_ELEMENT__REFINEMENT_CONTEXT:
			return basicGetRefinementContext() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefinedElement() {
		return false;
	}
	public String getName() {
		if (name == null) { // DB Avoids stack trace overflow when a component refines itself (seems to be supported by OSATE)
			if (!Aadl2Util.isNull(getRefinedElement()) && getRefinedElement() != this) {
				return getRefinedElement().getName();
			} else {
				return "";
			}
		}
		return name;
	}
	public void setName(final String newName) {
		// DB: Avoid setting a non null name to refined elements (causes a validation error during serialization
		// when both the name and refined element are set).
		final String actualName = Aadl2Util.isNull(getRefinedElement()) ? newName : null;

		super.setName(actualName);
	}
} // RefinableElementImpl
