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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Connection;
import org.osate.aadl2.SystemImplementation;
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
 *   <li>{@link org.osate.aadl2.instance.impl.SystemInstanceImpl#getSystemImplementation <em>System Implementation</em>}</li>
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
	 * The cached value of the '{@link #getSystemImplementation() <em>System Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemImplementation()
	 * @generated
	 * @ordered
	 */
	protected SystemImplementation systemImplementation;

	/**
	 * The current system operation mode.
	 * 
	 * @see #setCurrentSystemOperationMode
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
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
		SystemOperationMode newSystemOperationMode = (SystemOperationMode) create(InstancePackage.Literals.SYSTEM_OPERATION_MODE);
		getSystemOperationModes().add(newSystemOperationMode);
		return newSystemOperationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemImplementation getSystemImplementation() {
		if (systemImplementation != null && ((EObject) systemImplementation).eIsProxy()) {
			InternalEObject oldSystemImplementation = (InternalEObject) systemImplementation;
			systemImplementation = (SystemImplementation) eResolveProxy(oldSystemImplementation);
			if (systemImplementation != oldSystemImplementation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION, oldSystemImplementation,
							systemImplementation));
			}
		}
		return systemImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemImplementation basicGetSystemImplementation() {
		return systemImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemImplementation(SystemImplementation newSystemImplementation) {
		SystemImplementation oldSystemImplementation = systemImplementation;
		systemImplementation = newSystemImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					InstancePackage.SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION, oldSystemImplementation,
					systemImplementation));
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
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION:
			if (resolve)
				return getSystemImplementation();
			return basicGetSystemImplementation();
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
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION:
			setSystemImplementation((SystemImplementation) newValue);
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
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION:
			setSystemImplementation((SystemImplementation) null);
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
		case InstancePackage.SYSTEM_INSTANCE__SYSTEM_IMPLEMENTATION:
			return systemImplementation != null;
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
		for (final Iterator<SystemOperationMode> i = getSystemOperationModes().iterator(); i.hasNext();) {
			final SystemOperationMode som = i.next();
			if (som.getCurrentModes().containsAll(mis))
				output.add(som);
		}
		return Collections.unmodifiableList(output);
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public void setCurrentSystemOperationMode(SystemOperationMode som) {
		clearCurrentSystemOperationMode();
		for (final Iterator<ModeInstance> i = som.getCurrentModes().iterator(); i.hasNext();) {
			final ModeInstance mi = i.next();
			final ComponentInstance ci = (ComponentInstance) mi.eContainer();
			ci.setCurrentMode(mi);
		}
		currentSOM = som;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public SystemOperationMode getCurrentSystemOperationMode() {
		return currentSOM;
	}

	/**
	 * Clear the mode states for a given SystemInstance. That is, the modal
	 * adapters for the model all have their modes set to <code>null</code>.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
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
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osate.aadl2.instance.SystemInstance#findConnectionInstance
	 * (org.osate.aadl2.instance.FeatureInstance,
	 * org.osate.aadl2.instance.FeatureInstance)
	 */
	public ConnectionInstance findConnectionInstance(FeatureInstance srcFI, FeatureInstance dstFI) {
		EList<ConnectionInstance> subcl = getConnectionInstances();
		for (Iterator<ConnectionInstance> it = subcl.iterator(); it.hasNext();) {
			ConnectionInstance conni = it.next();

			if (conni.getKind() == ConnectionKind.PORT_CONNECTION) {
				ConnectionInstanceEnd srci = conni.getSource();
				if (srci instanceof FeatureInstance) {
					ConnectionInstanceEnd dsti = conni.getDestination();
					if (dsti instanceof FeatureInstance) {
						if (leadsOutof(conni, (FeatureInstance) srci, srcFI))
							if (leadsOutof(conni, (FeatureInstance) dsti, dstFI))
								return conni;
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

		for (ConnectionInstance conni : getConnectionInstances()) {
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
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	private boolean leadsOutof(ConnectionInstance conni, FeatureInstance cfi, FeatureInstance ffi) {
		if (cfi == ffi)
			return true;
		ComponentInstance flowci = ffi.getContainingComponentInstance();
		ComponentInstance connci = cfi.getContainingComponentInstance();
		while (connci != null) {
			if (flowci == connci)
				return true;
			connci = connci.getContainingComponentInstance();
		}
		return false;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
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
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public List<SystemOperationMode> getSystemOperationModesFor(final ModeInstance mi) {
		final List<SystemOperationMode> output = new ArrayList<SystemOperationMode>();
		for (final Iterator<SystemOperationMode> i = getSystemOperationModes().iterator(); i.hasNext();) {
			final SystemOperationMode som = i.next();
			if (som.getCurrentModes().contains(mi))
				output.add(som);
		}
		return Collections.unmodifiableList(output);
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final List<SystemImplementation> getInstantiatedObjects() {
		return Collections.singletonList(getSystemImplementation());
	}

	private SystemOperationMode initialMode = null;

	public final SystemOperationMode getInitialSystemOperationMode() {
		if (initialMode == null) {
			final List soms = this.getSystemOperationModes();
			for (final Iterator i = soms.iterator(); i.hasNext();) {
				final SystemOperationMode som = (SystemOperationMode) i.next();
				if (som.isInitial())
					return som;
			}
			// Should only get here if the model is malformed.
			throw new IllegalStateException("Couldn't find initial system operation mode");
		}
		return initialMode;
	}

	public boolean isActive(SystemOperationMode som) {
		return true;
	}

} // SystemInstanceImpl
