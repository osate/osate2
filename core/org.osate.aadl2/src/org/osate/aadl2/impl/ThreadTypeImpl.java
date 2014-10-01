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
 * $Id: ThreadTypeImpl.java,v 1.19 2011-04-11 13:35:53 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.ThreadType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedFeatures <em>Owned Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedDataPorts <em>Owned Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedEventDataPorts <em>Owned Event Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedEventPorts <em>Owned Event Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedDataAccesses <em>Owned Data Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedSubprogramAccesses <em>Owned Subprogram Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ThreadTypeImpl#getOwnedSubprogramGroupAccesses <em>Owned Subprogram Group Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreadTypeImpl extends ComponentTypeImpl implements ThreadType {
	/**
	 * The cached value of the '{@link #getOwnedDataPorts() <em>Owned Data Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<DataPort> ownedDataPorts;
	/**
	 * The cached value of the '{@link #getOwnedEventDataPorts() <em>Owned Event Data Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDataPort> ownedEventDataPorts;
	/**
	 * The cached value of the '{@link #getOwnedEventPorts() <em>Owned Event Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPort> ownedEventPorts;
	/**
	 * The cached value of the '{@link #getOwnedDataAccesses() <em>Owned Data Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<DataAccess> ownedDataAccesses;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramAccesses() <em>Owned Subprogram Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramAccess> ownedSubprogramAccesses;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupAccesses() <em>Owned Subprogram Group Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupAccess> ownedSubprogramGroupAccesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getThreadType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Feature> getOwnedFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Feature> ownedFeatures = (EList<Feature>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getComponentType_OwnedFeature());
			if (ownedFeatures == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getComponentType_OwnedFeature(),
						ownedFeatures = new DerivedUnionEObjectEList<Feature>(Feature.class, this,
								Aadl2Package.THREAD_TYPE__OWNED_FEATURE, OWNED_FEATURE_ESUBSETS));
			}
			return ownedFeatures;
		}
		return new DerivedUnionEObjectEList<Feature>(Feature.class, this, Aadl2Package.THREAD_TYPE__OWNED_FEATURE,
				OWNED_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedFeatures() <em>Owned Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_FEATURE_ESUBSETS = new int[] { Aadl2Package.THREAD_TYPE__OWNED_FEATURE_GROUP,
			Aadl2Package.THREAD_TYPE__OWNED_ABSTRACT_FEATURE, Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT,
			Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT, Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT,
			Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS, Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS,
			Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataPort> getOwnedDataPorts() {
		if (ownedDataPorts == null) {
			ownedDataPorts = new EObjectContainmentEList<DataPort>(DataPort.class, this,
					Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT);
		}
		return ownedDataPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataPort createOwnedDataPort() {
		DataPort newOwnedDataPort = (DataPort) create(Aadl2Package.eINSTANCE.getDataPort());
		getOwnedDataPorts().add(newOwnedDataPort);
		return newOwnedDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventDataPort> getOwnedEventDataPorts() {
		if (ownedEventDataPorts == null) {
			ownedEventDataPorts = new EObjectContainmentEList<EventDataPort>(EventDataPort.class, this,
					Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT);
		}
		return ownedEventDataPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventDataPort createOwnedEventDataPort() {
		EventDataPort newOwnedEventDataPort = (EventDataPort) create(Aadl2Package.eINSTANCE.getEventDataPort());
		getOwnedEventDataPorts().add(newOwnedEventDataPort);
		return newOwnedEventDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventPort> getOwnedEventPorts() {
		if (ownedEventPorts == null) {
			ownedEventPorts = new EObjectContainmentEList<EventPort>(EventPort.class, this,
					Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT);
		}
		return ownedEventPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventPort createOwnedEventPort() {
		EventPort newOwnedEventPort = (EventPort) create(Aadl2Package.eINSTANCE.getEventPort());
		getOwnedEventPorts().add(newOwnedEventPort);
		return newOwnedEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataAccess> getOwnedDataAccesses() {
		if (ownedDataAccesses == null) {
			ownedDataAccesses = new EObjectContainmentEList<DataAccess>(DataAccess.class, this,
					Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS);
		}
		return ownedDataAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataAccess createOwnedDataAccess() {
		DataAccess newOwnedDataAccess = (DataAccess) create(Aadl2Package.eINSTANCE.getDataAccess());
		getOwnedDataAccesses().add(newOwnedDataAccess);
		return newOwnedDataAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramAccess> getOwnedSubprogramAccesses() {
		if (ownedSubprogramAccesses == null) {
			ownedSubprogramAccesses = new EObjectContainmentEList<SubprogramAccess>(SubprogramAccess.class, this,
					Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS);
		}
		return ownedSubprogramAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramAccess createOwnedSubprogramAccess() {
		SubprogramAccess newOwnedSubprogramAccess = (SubprogramAccess) create(Aadl2Package.eINSTANCE
				.getSubprogramAccess());
		getOwnedSubprogramAccesses().add(newOwnedSubprogramAccess);
		return newOwnedSubprogramAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramGroupAccess> getOwnedSubprogramGroupAccesses() {
		if (ownedSubprogramGroupAccesses == null) {
			ownedSubprogramGroupAccesses = new EObjectContainmentEList<SubprogramGroupAccess>(
					SubprogramGroupAccess.class, this, Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS);
		}
		return ownedSubprogramGroupAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramGroupAccess createOwnedSubprogramGroupAccess() {
		SubprogramGroupAccess newOwnedSubprogramGroupAccess = (SubprogramGroupAccess) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupAccess());
		getOwnedSubprogramGroupAccesses().add(newOwnedSubprogramGroupAccess);
		return newOwnedSubprogramGroupAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT:
			return ((InternalEList<?>) getOwnedDataPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT:
			return ((InternalEList<?>) getOwnedEventDataPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT:
			return ((InternalEList<?>) getOwnedEventPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS:
			return ((InternalEList<?>) getOwnedDataAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return ((InternalEList<?>) getOwnedSubprogramAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return ((InternalEList<?>) getOwnedSubprogramGroupAccesses()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT:
			return getOwnedDataPorts();
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT:
			return getOwnedEventDataPorts();
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT:
			return getOwnedEventPorts();
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS:
			return getOwnedDataAccesses();
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return getOwnedSubprogramAccesses();
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return getOwnedSubprogramGroupAccesses();
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
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT:
			getOwnedDataPorts().clear();
			getOwnedDataPorts().addAll((Collection<? extends DataPort>) newValue);
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT:
			getOwnedEventDataPorts().clear();
			getOwnedEventDataPorts().addAll((Collection<? extends EventDataPort>) newValue);
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT:
			getOwnedEventPorts().clear();
			getOwnedEventPorts().addAll((Collection<? extends EventPort>) newValue);
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS:
			getOwnedDataAccesses().clear();
			getOwnedDataAccesses().addAll((Collection<? extends DataAccess>) newValue);
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS:
			getOwnedSubprogramAccesses().clear();
			getOwnedSubprogramAccesses().addAll((Collection<? extends SubprogramAccess>) newValue);
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			getOwnedSubprogramGroupAccesses().clear();
			getOwnedSubprogramGroupAccesses().addAll((Collection<? extends SubprogramGroupAccess>) newValue);
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
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT:
			getOwnedDataPorts().clear();
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT:
			getOwnedEventDataPorts().clear();
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT:
			getOwnedEventPorts().clear();
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS:
			getOwnedDataAccesses().clear();
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS:
			getOwnedSubprogramAccesses().clear();
			return;
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			getOwnedSubprogramGroupAccesses().clear();
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
		case Aadl2Package.THREAD_TYPE__OWNED_FEATURE:
			return isSetOwnedFeatures();
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT:
			return ownedDataPorts != null && !ownedDataPorts.isEmpty();
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT:
			return ownedEventDataPorts != null && !ownedEventDataPorts.isEmpty();
		case Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT:
			return ownedEventPorts != null && !ownedEventPorts.isEmpty();
		case Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS:
			return ownedDataAccesses != null && !ownedDataAccesses.isEmpty();
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return ownedSubprogramAccesses != null && !ownedSubprogramAccesses.isEmpty();
		case Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return ownedSubprogramGroupAccesses != null && !ownedSubprogramGroupAccesses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedFeatures() {
		return super.isSetOwnedFeatures() || eIsSet(Aadl2Package.THREAD_TYPE__OWNED_DATA_PORT)
				|| eIsSet(Aadl2Package.THREAD_TYPE__OWNED_EVENT_DATA_PORT)
				|| eIsSet(Aadl2Package.THREAD_TYPE__OWNED_EVENT_PORT)
				|| eIsSet(Aadl2Package.THREAD_TYPE__OWNED_DATA_ACCESS)
				|| eIsSet(Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_ACCESS)
				|| eIsSet(Aadl2Package.THREAD_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS);
	}

	@Override
	public ComponentCategory getCategory() {
		return ComponentCategory.THREAD;
	}
} // ThreadTypeImpl
