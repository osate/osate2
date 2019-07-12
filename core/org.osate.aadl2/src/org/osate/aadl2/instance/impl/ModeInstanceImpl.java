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
 * $Id: ModeInstanceImpl.java,v 1.12 2010-06-14 17:29:03 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Mode;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mode Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getSrcModeTransitions <em>Src Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getDstModeTransitions <em>Dst Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ModeInstanceImpl#getParents <em>Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModeInstanceImpl extends InstanceObjectImpl implements ModeInstance {
	/**
	 * The cached value of the '{@link #getSrcModeTransitions() <em>Src Mode Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> srcModeTransitions;

	/**
	 * The cached value of the '{@link #getDstModeTransitions() <em>Dst Mode Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> dstModeTransitions;

	/**
	 * The default value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INITIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
	protected boolean initial = INITIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected Mode mode;

	/**
	 * The default value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDerived() <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean derived = DERIVED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParents() <em>Parent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> parents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.MODE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransitionInstance> getSrcModeTransitions() {
		if (srcModeTransitions == null) {
			srcModeTransitions = new EObjectWithInverseEList<>(ModeTransitionInstance.class, this,
					InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION,
					InstancePackage.MODE_TRANSITION_INSTANCE__SOURCE);
		}
		return srcModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransitionInstance> getDstModeTransitions() {
		if (dstModeTransitions == null) {
			dstModeTransitions = new EObjectWithInverseEList<>(ModeTransitionInstance.class, this,
					InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION,
					InstancePackage.MODE_TRANSITION_INSTANCE__DESTINATION);
		}
		return dstModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getMode() {
		if (mode != null && ((EObject) mode).eIsProxy()) {
			InternalEObject oldMode = (InternalEObject) mode;
			mode = (Mode) eResolveProxy(oldMode);
			if (mode != oldMode) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, InstancePackage.MODE_INSTANCE__MODE,
							oldMode, mode));
				}
			}
		}
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode basicGetMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_INSTANCE__MODE, oldMode, mode));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDerived() {
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDerived(boolean newDerived) {
		boolean oldDerived = derived;
		derived = newDerived;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_INSTANCE__DERIVED, oldDerived,
					derived));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeInstance> getParents() {
		if (parents == null) {
			parents = new EObjectResolvingEList<>(ModeInstance.class, this,
					InstancePackage.MODE_INSTANCE__PARENT);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSrcModeTransitions()).basicAdd(otherEnd,
					msgs);
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDstModeTransitions()).basicAdd(otherEnd,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return ((InternalEList<?>) getSrcModeTransitions()).basicRemove(otherEnd, msgs);
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return ((InternalEList<?>) getDstModeTransitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitial(boolean newInitial) {
		boolean oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.MODE_INSTANCE__INITIAL, oldInitial,
					initial));
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return getSrcModeTransitions();
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return getDstModeTransitions();
		case InstancePackage.MODE_INSTANCE__INITIAL:
			return isInitial();
		case InstancePackage.MODE_INSTANCE__MODE:
			if (resolve) {
				return getMode();
			}
			return basicGetMode();
		case InstancePackage.MODE_INSTANCE__DERIVED:
			return isDerived();
		case InstancePackage.MODE_INSTANCE__PARENT:
			return getParents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			getSrcModeTransitions().clear();
			getSrcModeTransitions().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			getDstModeTransitions().clear();
			getDstModeTransitions().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__INITIAL:
			setInitial((Boolean) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__MODE:
			setMode((Mode) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__DERIVED:
			setDerived((Boolean) newValue);
			return;
		case InstancePackage.MODE_INSTANCE__PARENT:
			getParents().clear();
			getParents().addAll((Collection<? extends ModeInstance>) newValue);
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			getSrcModeTransitions().clear();
			return;
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			getDstModeTransitions().clear();
			return;
		case InstancePackage.MODE_INSTANCE__INITIAL:
			setInitial(INITIAL_EDEFAULT);
			return;
		case InstancePackage.MODE_INSTANCE__MODE:
			setMode((Mode) null);
			return;
		case InstancePackage.MODE_INSTANCE__DERIVED:
			setDerived(DERIVED_EDEFAULT);
			return;
		case InstancePackage.MODE_INSTANCE__PARENT:
			getParents().clear();
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
		case InstancePackage.MODE_INSTANCE__SRC_MODE_TRANSITION:
			return srcModeTransitions != null && !srcModeTransitions.isEmpty();
		case InstancePackage.MODE_INSTANCE__DST_MODE_TRANSITION:
			return dstModeTransitions != null && !dstModeTransitions.isEmpty();
		case InstancePackage.MODE_INSTANCE__INITIAL:
			return initial != INITIAL_EDEFAULT;
		case InstancePackage.MODE_INSTANCE__MODE:
			return mode != null;
		case InstancePackage.MODE_INSTANCE__DERIVED:
			return derived != DERIVED_EDEFAULT;
		case InstancePackage.MODE_INSTANCE__PARENT:
			return parents != null && !parents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (initial: "); //$NON-NLS-1$
		result.append(initial);
		result.append(", derived: "); //$NON-NLS-1$
		result.append(derived);
		result.append(')');
		return result.toString();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public List<Mode> getInstantiatedObjects() {
		return Collections.singletonList(getMode());
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		return getContainingComponentInstance().isActive(som);
	}

} // ModeInstanceImpl
