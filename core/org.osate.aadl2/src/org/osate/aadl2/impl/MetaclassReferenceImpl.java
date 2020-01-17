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
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.parsesupport.ParseUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metaclass Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.MetaclassReferenceImpl#getAnnexName <em>Annex Name</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.MetaclassReferenceImpl#getMetaclassNames <em>Metaclass Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaclassReferenceImpl extends PropertyOwnerImpl implements MetaclassReference {
	/**
	 * The default value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexName()
	 * @generated
	 * @ordered
	 */
	protected static final String ANNEX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnnexName() <em>Annex Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexName()
	 * @generated
	 * @ordered
	 */
	protected String annexName = ANNEX_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetaclassNames() <em>Metaclass Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaclassNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> metaclassNames;

	protected boolean resolved = false;
	protected EClass metaclass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaclassReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getMetaclassReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnnexName() {
		return annexName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnexName(String newAnnexName) {
		String oldAnnexName = annexName;
		annexName = newAnnexName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME,
					oldAnnexName, annexName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getMetaclassNames() {
		if (metaclassNames == null) {
			metaclassNames = new EDataTypeEList<String>(String.class, this,
					Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME);
		}
		return metaclassNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			return getAnnexName();
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			return getMetaclassNames();
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
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			setAnnexName((String) newValue);
			return;
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			getMetaclassNames().clear();
			getMetaclassNames().addAll((Collection<? extends String>) newValue);
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
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			setAnnexName(ANNEX_NAME_EDEFAULT);
			return;
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			getMetaclassNames().clear();
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
		case Aadl2Package.METACLASS_REFERENCE__ANNEX_NAME:
			return ANNEX_NAME_EDEFAULT == null ? annexName != null : !ANNEX_NAME_EDEFAULT.equals(annexName);
		case Aadl2Package.METACLASS_REFERENCE__METACLASS_NAME:
			return metaclassNames != null && !metaclassNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (annexName: ");
		result.append(annexName);
		result.append(", metaclassName: ");
		result.append(metaclassNames);
		result.append(')');
		return result.toString();
	}

	protected String errorMessage = null;

	protected void resolveMetaclass() {

		if (resolved) {
			return;
		}

		StringBuilder metaclassName = new StringBuilder();

		for (Iterator<String> iter = getMetaclassNames().iterator(); iter.hasNext();) {
			StringBuilder namePart = new StringBuilder(iter.next().toLowerCase());

			namePart.setCharAt(0, Character.toUpperCase(namePart.charAt(0)));
			metaclassName.append(namePart);
		}
		resolved = true;

		if (metaclassName.toString().equalsIgnoreCase("all")) {
			metaclass = Aadl2Package.eINSTANCE.getNamedElement();
		} else if (metaclassName.toString().equalsIgnoreCase("package")) {
			metaclass = Aadl2Package.eINSTANCE.getAadlPackage();
		} else {
			EPackage pack = Aadl2Package.eINSTANCE;

			if (getAnnexName() != null) {
				pack = getAnnexEPackage(getAnnexName());
			}

			EClassifier searchResult = getEClassifier(pack, metaclassName.toString());
			if (searchResult instanceof EClass) {
				EClass searchResultAsEClass = (EClass) searchResult;

				if (Aadl2Package.eINSTANCE.getNamedElement().isSuperTypeOf(searchResultAsEClass)) {
					metaclass = searchResultAsEClass;
				} else {
					errorMessage = "' is not a named element";
				}
			} else {
				errorMessage = "' does not exist in " + (getAnnexName() == null ? "AADL2" : getAnnexName());
			}

			if (errorMessage != null) {
				StringBuilder errorMessageBuilder = new StringBuilder("Metaclass '");
				for (Iterator<String> iter = getMetaclassNames().iterator(); iter.hasNext();) {
					errorMessageBuilder.append(iter.next());
					if (iter.hasNext()) {
						errorMessageBuilder.append(' ');
					}
				}
				errorMessageBuilder.append(errorMessage);
				errorMessage = errorMessageBuilder.toString();
			}
		}
	}

	public EClass getMetaclass() {
		resolveMetaclass();
		return metaclass;
	}

	public String getErrorMessage() {
		resolveMetaclass();
		return errorMessage;
	}

	public EClassifier getEClassifier(EPackage pack, String name) {
		for (EClassifier eClassifier : pack.getEClassifiers()) {
			if (eClassifier.getName().equalsIgnoreCase(name)) {
				return eClassifier;
			}
		}
		return null;
	}

	public EPackage getAnnexEPackage(String annexname) {

		String NSURI = ParseUtil.getAnnexNS(annexname);
		if (NSURI != null) {
			EPackage pack = EPackage.Registry.INSTANCE.getEPackage(NSURI);
			return pack;
		}

		return Aadl2Package.eINSTANCE;
	}

} // MetaclassReferenceImpl
