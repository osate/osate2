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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PackageRename;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package Rename</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PackageRenameImpl#getRenamedPackage <em>Renamed Package</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PackageRenameImpl#isRenameAll <em>Rename All</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageRenameImpl extends NamedElementImpl implements PackageRename {
	/**
	 * The cached value of the '{@link #getRenamedPackage() <em>Renamed Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenamedPackage()
	 * @generated
	 * @ordered
	 */
	protected AadlPackage renamedPackage;

	/**
	 * The default value of the '{@link #isRenameAll() <em>Rename All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenameAll()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RENAME_ALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRenameAll() <em>Rename All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRenameAll()
	 * @generated
	 * @ordered
	 */
	protected boolean renameAll = RENAME_ALL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageRenameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getPackageRename();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlPackage getRenamedPackage() {
		if (renamedPackage != null && ((EObject) renamedPackage).eIsProxy()) {
			InternalEObject oldRenamedPackage = (InternalEObject) renamedPackage;
			renamedPackage = (AadlPackage) eResolveProxy(oldRenamedPackage);
			if (renamedPackage != oldRenamedPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.PACKAGE_RENAME__RENAMED_PACKAGE, oldRenamedPackage, renamedPackage));
			}
		}
		return renamedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AadlPackage basicGetRenamedPackage() {
		return renamedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenamedPackage(AadlPackage newRenamedPackage) {
		AadlPackage oldRenamedPackage = renamedPackage;
		renamedPackage = newRenamedPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_RENAME__RENAMED_PACKAGE,
					oldRenamedPackage, renamedPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRenameAll() {
		return renameAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenameAll(boolean newRenameAll) {
		boolean oldRenameAll = renameAll;
		renameAll = newRenameAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PACKAGE_RENAME__RENAME_ALL, oldRenameAll,
					renameAll));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.PACKAGE_RENAME__RENAMED_PACKAGE:
			if (resolve)
				return getRenamedPackage();
			return basicGetRenamedPackage();
		case Aadl2Package.PACKAGE_RENAME__RENAME_ALL:
			return isRenameAll();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.PACKAGE_RENAME__RENAMED_PACKAGE:
			setRenamedPackage((AadlPackage) newValue);
			return;
		case Aadl2Package.PACKAGE_RENAME__RENAME_ALL:
			setRenameAll((Boolean) newValue);
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
		case Aadl2Package.PACKAGE_RENAME__RENAMED_PACKAGE:
			setRenamedPackage((AadlPackage) null);
			return;
		case Aadl2Package.PACKAGE_RENAME__RENAME_ALL:
			setRenameAll(RENAME_ALL_EDEFAULT);
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
		case Aadl2Package.PACKAGE_RENAME__RENAMED_PACKAGE:
			return renamedPackage != null;
		case Aadl2Package.PACKAGE_RENAME__RENAME_ALL:
			return renameAll != RENAME_ALL_EDEFAULT;
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
		result.append(" (renameAll: ");
		result.append(renameAll);
		result.append(')');
		return result.toString();
	}

} // PackageRenameImpl
