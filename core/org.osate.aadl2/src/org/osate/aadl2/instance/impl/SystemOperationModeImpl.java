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
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Property;
import org.osate.aadl2.impl.ModeImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Operation Mode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.SystemOperationModeImpl#getCurrentModes <em>Current Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemOperationModeImpl extends ModeImpl implements SystemOperationMode {
	/**
	 * The cached value of the '{@link #getCurrentModes() <em>Current Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentModes()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeInstance> currentModes;

	private Boolean isInitial = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOperationModeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.SYSTEM_OPERATION_MODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeInstance> getCurrentModes() {
		if (currentModes == null) {
			currentModes = new EObjectResolvingEList<ModeInstance>(ModeInstance.class, this,
					InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE);
		}
		return currentModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			return getCurrentModes();
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
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			getCurrentModes().clear();
			getCurrentModes().addAll((Collection<? extends ModeInstance>) newValue);
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
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			getCurrentModes().clear();
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
		case InstancePackage.SYSTEM_OPERATION_MODE__CURRENT_MODE:
			return currentModes != null && !currentModes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * returns initial mode as true if it is a SOM without modes ("no Modes" aka NORMAL_SOM_NME)
	 * or if all of the modes are initial mode
	 */
	public final boolean isInitial() {
		if (isInitial == null) {
			Boolean value = Boolean.TRUE;
			final Iterator<ModeInstance> i = getCurrentModes().iterator();
			// Is the list empty?
			if (!i.hasNext()) {
				// The SOM has no modes. Check to make sure, it is the only SOM, i.e., "No Modes". Otherwise it is not initial
				if (((SystemInstance) eContainer()).getSystemOperationModes().size() != 1) {
					value = Boolean.FALSE;
				}
			} else {
				while (i.hasNext()) {
					final ModeInstance mi = i.next();
					final Mode m = mi.getMode();
					if (!m.isInitial()) {
						value = Boolean.FALSE;
						break;
					}
				}
			}
			isInitial = value;
		}
		return isInitial.booleanValue();
	}
	public boolean isDerived() {
		return false;
	}
	public String toString() {
		/*
		 * Don't return a string with spaces in it becase this is used to
		 * create a name for the object, and we cannot have spaces in our
		 * name, or else it messes up the XML/XMI processing.
		 */
		final StringBuffer name = new StringBuffer();
		EList<ModeInstance> ml = getCurrentModes();
		for (Iterator<ModeInstance> it = ml.iterator(); it.hasNext();) {
			final ModeInstance mi = it.next();
			final ComponentInstance ci = (ComponentInstance) mi.eContainer();
			name.append(ci.getComponentInstancePath());
			if (name.length() > 0) {
				name.append(".");
			}
			name.append(mi.getName());
			if (it.hasNext()) {
				name.append("#");
			}
		}
		return name.toString();
	}
	public boolean acceptsProperty(Property property) {
		// SystemOperationModes can't have properties.
		return false;
	}
	public void getPropertyValueInternal(Property prop, PropertyAcc pas, boolean fromInstanceSlaveCall, boolean all)
			throws InvalidModelException {
		// SystemOperationModes can't have properties.
	}
} // SystemOperationModeImpl
