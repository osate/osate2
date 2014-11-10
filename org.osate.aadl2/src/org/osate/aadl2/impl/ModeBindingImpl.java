/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 *
 * $Id: ModeBindingImpl.java,v 1.6 2009-06-05 16:43:25 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ModeBindingImpl#getParentMode <em>Parent Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ModeBindingImpl#getDerivedMode <em>Derived Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModeBindingImpl extends ElementImpl implements ModeBinding {
	/**
	 * The cached value of the '{@link #getParentMode() <em>Parent Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentMode()
	 * @generated
	 * @ordered
	 */
	protected Mode parentMode;

	/**
	 * The cached value of the '{@link #getDerivedMode() <em>Derived Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedMode()
	 * @generated
	 * @ordered
	 */
	protected Mode derivedMode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getModeBinding();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getParentMode() {
		if (parentMode != null && ((EObject) parentMode).eIsProxy()) {
			InternalEObject oldParentMode = (InternalEObject) parentMode;
			parentMode = (Mode) eResolveProxy(oldParentMode);
			if (parentMode != oldParentMode) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_BINDING__PARENT_MODE,
							oldParentMode, parentMode));
				}
			}
		}
		return parentMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetParentMode() {
		return parentMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentMode(Mode newParentMode) {
		Mode oldParentMode = parentMode;
		parentMode = newParentMode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_BINDING__PARENT_MODE,
					oldParentMode, parentMode));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getDerivedMode() {
		if (derivedMode != null && ((EObject) derivedMode).eIsProxy()) {
			InternalEObject oldDerivedMode = (InternalEObject) derivedMode;
			derivedMode = (Mode) eResolveProxy(oldDerivedMode);
			if (derivedMode != oldDerivedMode) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.MODE_BINDING__DERIVED_MODE,
							oldDerivedMode, derivedMode));
				}
			}
		}
		return derivedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetDerivedMode() {
		return derivedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDerivedMode(Mode newDerivedMode) {
		Mode oldDerivedMode = derivedMode;
		derivedMode = newDerivedMode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.MODE_BINDING__DERIVED_MODE,
					oldDerivedMode, derivedMode));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			if (resolve) {
				return getParentMode();
			}
			return basicGetParentMode();
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			if (resolve) {
				return getDerivedMode();
			}
			return basicGetDerivedMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			setParentMode((Mode) newValue);
			return;
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			setDerivedMode((Mode) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			setParentMode((Mode) null);
			return;
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			setDerivedMode((Mode) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.MODE_BINDING__PARENT_MODE:
			return parentMode != null;
		case Aadl2Package.MODE_BINDING__DERIVED_MODE:
			return derivedMode != null;
		}
		return super.eIsSet(featureID);
	}

} // ModeBindingImpl
