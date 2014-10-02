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
 * $Id: FeatureGroupPrototypeActualImpl.java,v 1.2 2009-02-13 17:51:15 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.PrototypeBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Group Prototype Actual</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupPrototypeActualImpl#getBindings <em>Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupPrototypeActualImpl#getFeatureType <em>Feature Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureGroupPrototypeActualImpl extends FeaturePrototypeActualImpl implements FeatureGroupPrototypeActual {
	/**
	 * The cached value of the '{@link #getBindings() <em>Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<PrototypeBinding> bindings;
	/**
	 * The cached value of the '{@link #getFeatureType() <em>Feature Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureType()
	 * @generated
	 * @ordered
	 */
	protected FeatureType featureType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureGroupPrototypeActualImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeatureGroupPrototypeActual();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PrototypeBinding> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<PrototypeBinding>(PrototypeBinding.class, this,
					Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__BINDING);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrototypeBinding createBinding(EClass eClass) {
		PrototypeBinding newBinding = (PrototypeBinding) create(eClass);
		getBindings().add(newBinding);
		return newBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureType getFeatureType() {
		if (featureType != null && ((EObject) featureType).eIsProxy()) {
			InternalEObject oldFeatureType = (InternalEObject) featureType;
			featureType = (FeatureType) eResolveProxy(oldFeatureType);
			if (featureType != oldFeatureType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__FEATURE_TYPE, oldFeatureType, featureType));
				}
			}
		}
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType basicGetFeatureType() {
		return featureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeatureType(FeatureType newFeatureType) {
		FeatureType oldFeatureType = featureType;
		featureType = newFeatureType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__FEATURE_TYPE, oldFeatureType, featureType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__BINDING:
			return ((InternalEList<?>) getBindings()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__BINDING:
			return getBindings();
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__FEATURE_TYPE:
			if (resolve) {
				return getFeatureType();
			}
			return basicGetFeatureType();
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
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__BINDING:
			getBindings().clear();
			getBindings().addAll((Collection<? extends PrototypeBinding>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__FEATURE_TYPE:
			setFeatureType((FeatureType) newValue);
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
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__BINDING:
			getBindings().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__FEATURE_TYPE:
			setFeatureType((FeatureType) null);
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
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__BINDING:
			return bindings != null && !bindings.isEmpty();
		case Aadl2Package.FEATURE_GROUP_PROTOTYPE_ACTUAL__FEATURE_TYPE:
			return featureType != null;
		}
		return super.eIsSet(featureID);
	}

} // FeatureGroupPrototypeActualImpl
