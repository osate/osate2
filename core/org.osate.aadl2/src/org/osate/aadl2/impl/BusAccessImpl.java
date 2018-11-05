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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * $Id: BusAccessImpl.java,v 1.12 2009-06-04 14:59:51 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusFeatureClassifier;
import org.osate.aadl2.FeatureClassifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BusAccessImpl#getFeatureClassifier <em>Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BusAccessImpl#getBusFeatureClassifier <em>Bus Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BusAccessImpl#isVirtual <em>Virtual</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BusAccessImpl extends AccessImpl implements BusAccess {
	/**
	 * The cached value of the '{@link #getBusFeatureClassifier() <em>Bus Feature Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusFeatureClassifier()
	 * @generated
	 * @ordered
	 */
	protected BusFeatureClassifier busFeatureClassifier;

	/**
	 * The default value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIRTUAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean virtual = VIRTUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBusAccess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureClassifier getFeatureClassifier() {
		FeatureClassifier featureClassifier = basicGetFeatureClassifier();
		return featureClassifier != null && ((EObject) featureClassifier).eIsProxy()
				? (FeatureClassifier) eResolveProxy((InternalEObject) featureClassifier)
				: featureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureClassifier basicGetFeatureClassifier() {
		if (eIsSet(Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER)) {
			return basicGetBusFeatureClassifier();
		}
		return super.basicGetFeatureClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BusFeatureClassifier getBusFeatureClassifier() {
		if (busFeatureClassifier != null && ((EObject) busFeatureClassifier).eIsProxy()) {
			InternalEObject oldBusFeatureClassifier = (InternalEObject) busFeatureClassifier;
			busFeatureClassifier = (BusFeatureClassifier) eResolveProxy(oldBusFeatureClassifier);
			if (busFeatureClassifier != oldBusFeatureClassifier) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER, oldBusFeatureClassifier,
							busFeatureClassifier));
				}
			}
		}
		return busFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusFeatureClassifier basicGetBusFeatureClassifier() {
		return busFeatureClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBusFeatureClassifier(BusFeatureClassifier newBusFeatureClassifier) {
		BusFeatureClassifier oldBusFeatureClassifier = busFeatureClassifier;
		busFeatureClassifier = newBusFeatureClassifier;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER,
					oldBusFeatureClassifier, busFeatureClassifier));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isVirtual() {
		return virtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVirtual(boolean newVirtual) {
		boolean oldVirtual = virtual;
		virtual = newVirtual;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.BUS_ACCESS__VIRTUAL, oldVirtual,
					virtual));
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
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			if (resolve) {
				return getBusFeatureClassifier();
			}
			return basicGetBusFeatureClassifier();
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			return isVirtual();
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
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			setBusFeatureClassifier((BusFeatureClassifier) newValue);
			return;
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			setVirtual((Boolean) newValue);
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
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			setBusFeatureClassifier((BusFeatureClassifier) null);
			return;
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			setVirtual(VIRTUAL_EDEFAULT);
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
		case Aadl2Package.BUS_ACCESS__FEATURE_CLASSIFIER:
			return isSetFeatureClassifier();
		case Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER:
			return busFeatureClassifier != null;
		case Aadl2Package.BUS_ACCESS__VIRTUAL:
			return virtual != VIRTUAL_EDEFAULT;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (virtual: ");
		result.append(virtual);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetFeatureClassifier() {
		return super.isSetFeatureClassifier() || eIsSet(Aadl2Package.BUS_ACCESS__BUS_FEATURE_CLASSIFIER);
	}

} // BusAccessImpl
