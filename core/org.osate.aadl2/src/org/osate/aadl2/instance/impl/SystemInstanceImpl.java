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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>System Instance</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.SystemInstanceImpl#getSystemOperationModes <em>System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.SystemInstanceImpl#getComponentImplementation <em>Component Implementation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemInstanceImpl extends ComponentInstanceImpl implements SystemInstance {
	/**
	 * The cached value of the '{@link #getSystemOperationModes()
	 * <em>System Operation Mode</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getSystemOperationModes()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemOperationMode> systemOperationModes;

	/**
	 * The cached value of the '{@link #getComponentImplementation() <em>Component Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentImplementation()
	 * @generated
	 * @ordered
	 */
	protected ComponentImplementation componentImplementation;

	/**
	 * The current system operation mode.
	 *
	 * @see #setCurrentSystemOperationMode
	 */
	private SystemOperationMode currentSOM = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.SYSTEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SystemOperationMode> getSystemOperationModes() {
		if (systemOperationModes == null) {
			systemOperationModes = new EObjectContainmentEList<SystemOperationMode>(SystemOperationMode.class, this,
					InstancePackage.SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE);
		}
		return systemOperationModes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOperationMode createSystemOperationMode() {
		SystemOperationMode newSystemOperationMode = (SystemOperationMode) create(
				InstancePackage.Literals.SYSTEM_OPERATION_MODE);
		getSystemOperationModes().add(newSystemOperationMode);
		return newSystemOperationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementation getComponentImplementation() {
		if (componentImplementation != null && ((EObject) componentImplementation).eIsProxy()) {
			InternalEObject oldComponentImplementation = (InternalEObject) componentImplementation;
			componentImplementation = (ComponentImplementation) eResolveProxy(oldComponentImplementation);
			if (componentImplementation != oldComponentImplementation) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION, oldComponentImplementation,
							componentImplementation));
				}
			}
		}
		return componentImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementation basicGetComponentImplementation() {
		return componentImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentImplementation(ComponentImplementation newComponentImplementation) {
		ComponentImplementation oldComponentImplementation = componentImplementation;
		componentImplementation = newComponentImplementation;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION, oldComponentImplementation,
					componentImplementation));
		}
	}
	@Override
	public ComponentImplementation getComponentClassifier() {
		return getComponentImplementation();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE:
			return ((InternalEList<?>) getSystemOperationModes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE:
			return getSystemOperationModes();
		case InstancePackage.SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION:
			if (resolve) {
				return getComponentImplementation();
			}
			return basicGetComponentImplementation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE:
			getSystemOperationModes().clear();
			getSystemOperationModes().addAll((Collection<? extends SystemOperationMode>) newValue);
			return;
		case InstancePackage.SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION:
			setComponentImplementation((ComponentImplementation) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE:
			getSystemOperationModes().clear();
			return;
		case InstancePackage.SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION:
			setComponentImplementation((ComponentImplementation) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_OPERATION_MODE:
			return systemOperationModes != null && !systemOperationModes.isEmpty();
		case InstancePackage.SYSTEM_INSTANCE__COMPONENT_IMPLEMENTATION:
			return componentImplementation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * get all SOMs that contain the ModeInstance list
	 *
	 * @param mis List of mode instances
	 * @return SOM that match the ModeInstance list
	 */
	public List<SystemOperationMode> getSystemOperationModesFor(List<ModeInstance> mis) {
		final List<SystemOperationMode> output = new ArrayList<SystemOperationMode>();
		for (SystemOperationMode som : getSystemOperationModes()) {
			if (som.getCurrentModes().containsAll(mis)) {
				output.add(som);
			}
		}
		return Collections.unmodifiableList(output);
	}

	public void setCurrentSystemOperationMode(SystemOperationMode som) {
		clearCurrentSystemOperationMode();
		for (final Iterator<ModeInstance> i = som.getCurrentModes().iterator(); i.hasNext();) {
			final ModeInstance mi = i.next();
			final ComponentInstance ci = (ComponentInstance) mi.eContainer();
			ci.setCurrentMode(mi);
		}
		currentSOM = som;
	}

	public SystemOperationMode getCurrentSystemOperationMode() {
		return currentSOM;
	}

	/**
	 * Clear the mode states for a given SystemInstance. That is, the modal
	 * adapters for the model all have their modes set to <code>null</code>.
	 */
	public void clearCurrentSystemOperationMode() {
		/*
		 * Just walk the whole tree and clear the modes of all the components.
		 * We used to use the SOMs to do this so that we only touched those
		 * components that were modal. But we cannot be sure that any single SOM
		 * refers to all the modal components because some modal components may
		 * not exist in some SOMs.
		 */
		currentSOM = null;
		final LinkedList<ComponentInstance> comps = new LinkedList<ComponentInstance>();
		comps.add(this);
		while (!comps.isEmpty()) {
			final ComponentInstance ci = comps.removeFirst();
			ci.setCurrentMode(null);
			comps.addAll(ci.getComponentInstances());
		}
	}

	/*
	 * find connection instance in SystemInstance
	 * You may want to call on AadlUtil.findConnectionInstance as it can handle any endpoint, not just
	 * features on port connections.
	 */
	public ConnectionInstance findConnectionInstance(FeatureInstance srcFI, FeatureInstance dstFI) {
		EList<ConnectionInstance> subcl = getAllConnectionInstances();
		for (Iterator<ConnectionInstance> it = subcl.iterator(); it.hasNext();) {
			ConnectionInstance conni = it.next();

			if (conni.getKind() == ConnectionKind.PORT_CONNECTION) {
				ConnectionInstanceEnd srci = conni.getSource();
				if (srci instanceof FeatureInstance) {
					ConnectionInstanceEnd dsti = conni.getDestination();
					if (dsti instanceof FeatureInstance) {
						if (leadsOutof(conni, (FeatureInstance) srci, srcFI)) {
							if (leadsOutof(conni, (FeatureInstance) dsti, dstFI)) {
								return conni;
							}
						}
					}
				}
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.instance.SystemInstance#findConnectionInstance
	 * (org.osate.aadl2.Connection, org.osate.aadl2.Connection)
	 */
	public List<ConnectionInstance> findConnectionInstances(Connection first, Connection second) {
		List<ConnectionInstance> result = new LinkedList<ConnectionInstance>();

		for (ConnectionInstance conni : getAllConnectionInstances()) {
			boolean foundFirst = (first == second);

			for (ConnectionReference connRef : conni.getConnectionReferences()) {
				Connection conn = connRef.getConnection();

				if (!foundFirst) {
					foundFirst = (conn == first);
				} else {
					if (conn == second) {
						result.add(conni);
						break;
					}
				}
			}
		}
		return result;
	}

	/**
	 * Does the connection instance lead out of the flow specific feature
	 * instance The connection may start in a subcomponent
	 *
	 * @param conni ConnectionInstance
	 * @param cfi FeatureInstance the source feature instance
	 * @param ffi The feature instance involved in the flow
	 * @return true if connection goes through the ffi
	 */
	private boolean leadsOutof(ConnectionInstance conni, FeatureInstance cfi, FeatureInstance ffi) {
		if (cfi == ffi) {
			return true;
		}
		ComponentInstance flowci = ffi.getContainingComponentInstance();
		ComponentInstance connci = cfi.getContainingComponentInstance();
		while (connci != null) {
			if (flowci == connci) {
				return true;
			}
			connci = connci.getContainingComponentInstance();
		}
		return false;
	}

	/**
	 * get all SOMs that contain the mode instance
	 *
	 * @param mi Mode Instance
	 * @return List of SOM that contains the mode instance
	 */
	public List<SystemOperationMode> getSystemOperationModesFor(final ModeInstance mi) {
		final List<SystemOperationMode> output = new ArrayList<SystemOperationMode>();
		for (final Iterator<SystemOperationMode> i = getSystemOperationModes().iterator(); i.hasNext();) {
			final SystemOperationMode som = i.next();
			if (som.getCurrentModes().contains(mi)) {
				output.add(som);
			}
		}
		return Collections.unmodifiableList(output);
	}
	@Override
	public final List<ComponentImplementation> getInstantiatedObjects() {
		return Collections.singletonList(getComponentImplementation());
	}

	private SystemOperationMode initialMode = null;

	public final SystemOperationMode getInitialSystemOperationMode() {
		if (initialMode == null) {
			final List<SystemOperationMode> soms = getSystemOperationModes();
			for (SystemOperationMode som : soms) {
				if (som.isInitial()) {
					initialMode = som;
					return som;
				}
			}
			// Should only get here if the model is malformed.
			throw new IllegalStateException("Couldn't find initial system operation mode");
		}
		return initialMode;
	}
	@Override
	public boolean isActive(SystemOperationMode som) {
		return true;
	}

	public Iterable<ConnectionInstance> allConnectionInstances() {
		final TreeIterator<Object> iter = EcoreUtil.getAllContents(this, true);

		return new Iterable<ConnectionInstance>() {
			public Iterator<ConnectionInstance> iterator() {
				return new Iterator<ConnectionInstance>() {
					ConnectionInstance next;

					private boolean advance() {
						boolean found = false;

						next = null;
						while (iter.hasNext()) {
							Object obj = iter.next();
							if (found = obj instanceof ConnectionInstance) {
								next = (ConnectionInstance) obj;
								iter.prune();
								break;
							}
						}
						return found;
					}

					public boolean hasNext() {
						return next != null || advance();
					}

					public ConnectionInstance next() {
						if (next == null && !advance()) {
							throw new NoSuchElementException();
						}
						ConnectionInstance result = next;
						next = null;
						return result;
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	public EList<ConnectionInstance> getAllConnectionInstances() {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();

		for (ConnectionInstance conni : allConnectionInstances()) {
			result.add(conni);
		}
		return result;
	}

} // SystemInstanceImpl
