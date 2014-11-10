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
 * $Id: ConnectionInstanceEndImpl.java,v 1.6 2010-06-14 17:29:03 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Instance End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl#getSrcConnectionInstances <em>Src Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceEndImpl#getDstConnectionInstances <em>Dst Connection Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectionInstanceEndImpl extends InstanceObjectImpl implements ConnectionInstanceEnd {
	/**
	 * The cached value of the '{@link #getSrcConnectionInstances() <em>Src Connection Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrcConnectionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> srcConnectionInstances;
	/**
	 * The cached value of the '{@link #getDstConnectionInstances() <em>Dst Connection Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDstConnectionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionInstance> dstConnectionInstances;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionInstanceEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.CONNECTION_INSTANCE_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionInstance> getSrcConnectionInstances() {
		if (srcConnectionInstances == null) {
			srcConnectionInstances = new EObjectWithInverseResolvingEList<ConnectionInstance>(ConnectionInstance.class,
					this, InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE,
					InstancePackage.CONNECTION_INSTANCE__SOURCE);
		}
		return srcConnectionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionInstance> getDstConnectionInstances() {
		if (dstConnectionInstances == null) {
			dstConnectionInstances = new EObjectWithInverseResolvingEList<ConnectionInstance>(ConnectionInstance.class,
					this, InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE,
					InstancePackage.CONNECTION_INSTANCE__DESTINATION);
		}
		return dstConnectionInstances;
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSrcConnectionInstances()).basicAdd(otherEnd,
					msgs);
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDstConnectionInstances()).basicAdd(otherEnd,
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return ((InternalEList<?>) getSrcConnectionInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return ((InternalEList<?>) getDstConnectionInstances()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return getSrcConnectionInstances();
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return getDstConnectionInstances();
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			getSrcConnectionInstances().clear();
			getSrcConnectionInstances().addAll((Collection<? extends ConnectionInstance>) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			getDstConnectionInstances().clear();
			getDstConnectionInstances().addAll((Collection<? extends ConnectionInstance>) newValue);
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			getSrcConnectionInstances().clear();
			return;
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			getDstConnectionInstances().clear();
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
		case InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE:
			return srcConnectionInstances != null && !srcConnectionInstances.isEmpty();
		case InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE:
			return dstConnectionInstances != null && !dstConnectionInstances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ConnectionInstanceEndImpl
