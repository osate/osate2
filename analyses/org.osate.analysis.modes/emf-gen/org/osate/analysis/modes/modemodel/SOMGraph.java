/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.modemodel;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SOM Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMGraph#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.osate.analysis.modes.modemodel.SOMGraph#getTriggers <em>Triggers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SOMGraph extends MinimalEObjectImpl.Container implements EObject {
	/**
	 * The cached value of the '{@link #getLevels() <em>Levels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevels()
	 * @generated
	 * @ordered
	 */
	protected EList<SOMLevel> levels;

	/**
	 * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTriggers()
	 * @generated
	 * @ordered
	 */
	protected EMap<TriggerKey, Trigger> triggers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOMGraph() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModemodelPackage.Literals.SOM_GRAPH;
	}

	/**
	 * Returns the value of the '<em><b>Levels</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.modes.modemodel.SOMLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Levels</em>' containment reference list.
	 * @generated
	 */
	public List<SOMLevel> getLevels() {
		if (levels == null) {
			levels = new EObjectContainmentEList<>(SOMLevel.class, this, ModemodelPackage.SOM_GRAPH__LEVELS);
		}
		return levels;
	}

	/**
	 * Returns the value of the '<em><b>Triggers</b></em>' map.
	 * The key is of type {@link org.osate.analysis.modes.modemodel.TriggerKey},
	 * and the value is of type {@link org.osate.analysis.modes.modemodel.Trigger},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggers</em>' map.
	 * @generated
	 */
	public Map<TriggerKey, Trigger> getTriggers() {
		if (triggers == null) {
			triggers = new EcoreEMap<>(ModemodelPackage.Literals.TRIGGER_MAP, TriggerMap.class, this,
					ModemodelPackage.SOM_GRAPH__TRIGGERS);
		}
		return triggers.map();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ModemodelPackage.SOM_GRAPH__LEVELS:
			return ((InternalEList<?>) getLevels()).basicRemove(otherEnd, msgs);
		case ModemodelPackage.SOM_GRAPH__TRIGGERS:
			return ((InternalEList<?>) ((EMap.InternalMapView<TriggerKey, Trigger>) getTriggers()).eMap())
					.basicRemove(otherEnd, msgs);
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
		case ModemodelPackage.SOM_GRAPH__LEVELS:
			return getLevels();
		case ModemodelPackage.SOM_GRAPH__TRIGGERS:
			if (coreType) {
				return ((EMap.InternalMapView<TriggerKey, Trigger>) getTriggers()).eMap();
			} else {
				return getTriggers();
			}
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
		case ModemodelPackage.SOM_GRAPH__LEVELS:
			getLevels().clear();
			getLevels().addAll((Collection<? extends SOMLevel>) newValue);
			return;
		case ModemodelPackage.SOM_GRAPH__TRIGGERS:
			((EStructuralFeature.Setting) ((EMap.InternalMapView<TriggerKey, Trigger>) getTriggers()).eMap())
					.set(newValue);
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
		case ModemodelPackage.SOM_GRAPH__LEVELS:
			getLevels().clear();
			return;
		case ModemodelPackage.SOM_GRAPH__TRIGGERS:
			getTriggers().clear();
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
		case ModemodelPackage.SOM_GRAPH__LEVELS:
			return levels != null && !levels.isEmpty();
		case ModemodelPackage.SOM_GRAPH__TRIGGERS:
			return triggers != null && !triggers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // SOMGraph
