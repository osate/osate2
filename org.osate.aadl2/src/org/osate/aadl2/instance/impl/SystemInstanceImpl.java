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
 * $Id: SystemInstanceImpl.java,v 1.18 2010-06-14 17:29:03 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.SystemInstanceImpl#getSystemOperationModes <em>System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.SystemInstanceImpl#getComponentImplementation <em>Component Implementation</em>}</li>
 * </ul>
 * </p>
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
	@Override
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
	@Override
	public SystemOperationMode createSystemOperationMode() {
		SystemOperationMode newSystemOperationMode = (SystemOperationMode) create(InstancePackage.Literals.SYSTEM_OPERATION_MODE);
		getSystemOperationModes().add(newSystemOperationMode);
		return newSystemOperationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@SuppressWarnings("unchecked")
	@Override
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
	@Override
	public List<SystemOperationMode> getSystemOperationModesFor(List<ModeInstance> mis) {
		final List<SystemOperationMode> output = new ArrayList<SystemOperationMode>();
		for (SystemOperationMode som : getSystemOperationModes()) {
			if (som.getCurrentModes().containsAll(mis)) {
				output.add(som);
			}
		}
		return Collections.unmodifiableList(output);
	}

	@Override
	public void setCurrentSystemOperationMode(SystemOperationMode som) {
		clearCurrentSystemOperationMode();
		for (final Iterator<ModeInstance> i = som.getCurrentModes().iterator(); i.hasNext();) {
			final ModeInstance mi = i.next();
			final ComponentInstance ci = (ComponentInstance) mi.eContainer();
			ci.setCurrentMode(mi);
		}
		currentSOM = som;
	}

	@Override
	public SystemOperationMode getCurrentSystemOperationMode() {
		return currentSOM;
	}

	/**
	 * Clear the mode states for a given SystemInstance. That is, the modal
	 * adapters for the model all have their modes set to <code>null</code>.
	 */
	@Override
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
	@Override
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
	@Override
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

	@Override
	public final List<SystemOperationMode> getExistsInModes() {
		// System always exists
		return null;
	}

	/**
	 * get all SOMs that contain the mode instance
	 *
	 * @param mi Mode Instance
	 * @return List of SOM that contains the mode instance
	 */
	@Override
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

	@Override
	public final SystemOperationMode getInitialSystemOperationMode() {
		if (initialMode == null) {
			final List<SystemOperationMode> soms = getSystemOperationModes();
			for (SystemOperationMode som : soms) {
				if (som.isInitial()) {
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

	@Override
	public Iterable<ConnectionInstance> allConnectionInstances() {
		final TreeIterator<Object> iter = EcoreUtil.getAllContents(this, true);

		return new Iterable<ConnectionInstance>() {

			@Override
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

					@Override
					public boolean hasNext() {
						return next != null || advance();
					}

					@Override
					public ConnectionInstance next() {
						if (next == null && !advance()) {
							throw new NoSuchElementException();
						}
						ConnectionInstance result = next;
						next = null;
						return result;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}

		};
	}

	@Override
	public EList<ConnectionInstance> getAllConnectionInstances() {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();

		for (ConnectionInstance conni : allConnectionInstances()) {
			result.add(conni);
		}
		return result;
	}

} // SystemInstanceImpl
