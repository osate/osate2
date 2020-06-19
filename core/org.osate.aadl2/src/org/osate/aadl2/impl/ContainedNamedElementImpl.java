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

import static org.eclipse.emf.common.util.ECollections.newBasicEList;
import static org.eclipse.emf.common.util.ECollections.unmodifiableEList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contained Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ContainedNamedElementImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ContainedNamedElementImpl#getContainmentPathElements <em>Containment Path Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainedNamedElementImpl extends ElementImpl implements ContainedNamedElement {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected ContainmentPathElement path;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainedNamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getContainedNamedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainmentPathElement getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPath(ContainmentPathElement newPath, NotificationChain msgs) {
		ContainmentPathElement oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH, oldPath, newPath);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(ContainmentPathElement newPath) {
		if (newPath != path) {
			NotificationChain msgs = null;
			if (path != null) {
				msgs = ((InternalEObject) path).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH, null, msgs);
			}
			if (newPath != null) {
				msgs = ((InternalEObject) newPath).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH, null, msgs);
			}
			msgs = basicSetPath(newPath, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH, newPath,
					newPath));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainmentPathElement createPath() {
		ContainmentPathElement newPath = (ContainmentPathElement) create(
				Aadl2Package.eINSTANCE.getContainmentPathElement());
		setPath(newPath);
		return newPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Get the path elements as a list. For backward-compatibility after metamodel change.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ContainmentPathElement> getContainmentPathElements() {
		EList<ContainmentPathElement> result = newBasicEList();
		ContainmentPathElement next = path;

		if (next != null) {
			do {
				result.add(next);
				next = next.getPath();
			} while (next != null);
		}
		return unmodifiableEList(result);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH:
			return basicSetPath(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH:
			return getPath();
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__CONTAINMENT_PATH_ELEMENT:
			return getContainmentPathElements();
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH:
			setPath((ContainmentPathElement) newValue);
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH:
			setPath((ContainmentPathElement) null);
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
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__PATH:
			return path != null;
		case Aadl2Package.CONTAINED_NAMED_ELEMENT__CONTAINMENT_PATH_ELEMENT:
			return !getContainmentPathElements().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ContainedNamedElementImpl
