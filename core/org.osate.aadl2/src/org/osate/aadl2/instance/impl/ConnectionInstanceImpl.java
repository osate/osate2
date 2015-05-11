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
 * $Id: ConnectionInstanceImpl.java,v 1.22 2010-06-14 17:29:03 lwrage Exp $
 */
package org.osate.aadl2.instance.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.util.OsateDebug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#getInSystemOperationModes <em>In System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#getInModeTransitions <em>In Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#isComplete <em>Complete</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#getConnectionReferences <em>Connection Reference</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionInstanceImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionInstanceImpl extends FlowElementInstanceImpl implements ConnectionInstance {
	/**
	 * The cached value of the '{@link #getInSystemOperationModes() <em>In System Operation Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSystemOperationModes()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemOperationMode> inSystemOperationModes;

	/**
	 * The cached value of the '{@link #getInModeTransitions() <em>In Mode Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransitionInstance> inModeTransitions;

	/**
	 * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
	protected boolean complete = COMPLETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ConnectionKind KIND_EDEFAULT = ConnectionKind.FEATURE_CONNECTION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ConnectionKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstanceEnd destination;

	/**
	 * The cached value of the '{@link #getConnectionReferences() <em>Connection Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionReference> connectionReferences;

	/**
	 * The default value of the '{@link #isBidirectional() <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBidirectional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIDIRECTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBidirectional() <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBidirectional()
	 * @generated
	 * @ordered
	 */
	protected boolean bidirectional = BIDIRECTIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstanceEnd source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.CONNECTION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SystemOperationMode> getInSystemOperationModes() {
		if (inSystemOperationModes == null) {
			inSystemOperationModes = new EObjectResolvingEList<SystemOperationMode>(SystemOperationMode.class, this,
					InstancePackage.CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE);
		}
		return inSystemOperationModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransitionInstance> getInModeTransitions() {
		if (inModeTransitions == null) {
			inModeTransitions = new EObjectResolvingEList<ModeTransitionInstance>(ModeTransitionInstance.class, this,
					InstancePackage.CONNECTION_INSTANCE__IN_MODE_TRANSITION);
		}
		return inModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isComplete() {
		return complete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComplete(boolean newComplete) {
		boolean oldComplete = complete;
		complete = newComplete;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_INSTANCE__COMPLETE,
					oldComplete, complete));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(ConnectionKind newKind) {
		ConnectionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_INSTANCE__KIND, oldKind,
					kind));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionInstanceEnd getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (ConnectionInstanceEnd) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.CONNECTION_INSTANCE__DESTINATION, oldDestination, destination));
				}
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstanceEnd basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(ConnectionInstanceEnd newDestination, NotificationChain msgs) {
		ConnectionInstanceEnd oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					InstancePackage.CONNECTION_INSTANCE__DESTINATION, oldDestination, newDestination);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDestination(ConnectionInstanceEnd newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE, ConnectionInstanceEnd.class,
						msgs);
			}
			if (newDestination != null) {
				msgs = ((InternalEObject) newDestination).eInverseAdd(this,
						InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE, ConnectionInstanceEnd.class,
						msgs);
			}
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_INSTANCE__DESTINATION,
					newDestination, newDestination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConnectionReference> getConnectionReferences() {
		if (connectionReferences == null) {
			connectionReferences = new EObjectContainmentEList<ConnectionReference>(ConnectionReference.class, this,
					InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE);
		}
		return connectionReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionReference createConnectionReference() {
		ConnectionReference newConnectionReference = (ConnectionReference) create(InstancePackage.Literals.CONNECTION_REFERENCE);
		getConnectionReferences().add(newConnectionReference);
		return newConnectionReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBidirectional() {
		return bidirectional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBidirectional(boolean newBidirectional) {
		boolean oldBidirectional = bidirectional;
		bidirectional = newBidirectional;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_INSTANCE__BIDIRECTIONAL,
					oldBidirectional, bidirectional));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionInstanceEnd getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (ConnectionInstanceEnd) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.CONNECTION_INSTANCE__SOURCE, oldSource, source));
				}
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstanceEnd basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ConnectionInstanceEnd newSource, NotificationChain msgs) {
		ConnectionInstanceEnd oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					InstancePackage.CONNECTION_INSTANCE__SOURCE, oldSource, newSource);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(ConnectionInstanceEnd newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this,
						InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE, ConnectionInstanceEnd.class,
						msgs);
			}
			if (newSource != null) {
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE, ConnectionInstanceEnd.class,
						msgs);
			}
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_INSTANCE__SOURCE,
					newSource, newSource));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.CONNECTION_INSTANCE__DESTINATION:
			if (destination != null) {
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						InstancePackage.CONNECTION_INSTANCE_END__DST_CONNECTION_INSTANCE, ConnectionInstanceEnd.class,
						msgs);
			}
			return basicSetDestination((ConnectionInstanceEnd) otherEnd, msgs);
		case InstancePackage.CONNECTION_INSTANCE__SOURCE:
			if (source != null) {
				msgs = ((InternalEObject) source).eInverseRemove(this,
						InstancePackage.CONNECTION_INSTANCE_END__SRC_CONNECTION_INSTANCE, ConnectionInstanceEnd.class,
						msgs);
			}
			return basicSetSource((ConnectionInstanceEnd) otherEnd, msgs);
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
		case InstancePackage.CONNECTION_INSTANCE__DESTINATION:
			return basicSetDestination(null, msgs);
		case InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE:
			return ((InternalEList<?>) getConnectionReferences()).basicRemove(otherEnd, msgs);
		case InstancePackage.CONNECTION_INSTANCE__SOURCE:
			return basicSetSource(null, msgs);
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
		case InstancePackage.CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			return getInSystemOperationModes();
		case InstancePackage.CONNECTION_INSTANCE__IN_MODE_TRANSITION:
			return getInModeTransitions();
		case InstancePackage.CONNECTION_INSTANCE__COMPLETE:
			return isComplete();
		case InstancePackage.CONNECTION_INSTANCE__KIND:
			return getKind();
		case InstancePackage.CONNECTION_INSTANCE__DESTINATION:
			if (resolve) {
				return getDestination();
			}
			return basicGetDestination();
		case InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE:
			return getConnectionReferences();
		case InstancePackage.CONNECTION_INSTANCE__BIDIRECTIONAL:
			return isBidirectional();
		case InstancePackage.CONNECTION_INSTANCE__SOURCE:
			if (resolve) {
				return getSource();
			}
			return basicGetSource();
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
		case InstancePackage.CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			getInSystemOperationModes().clear();
			getInSystemOperationModes().addAll((Collection<? extends SystemOperationMode>) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__IN_MODE_TRANSITION:
			getInModeTransitions().clear();
			getInModeTransitions().addAll((Collection<? extends ModeTransitionInstance>) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__COMPLETE:
			setComplete((Boolean) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__KIND:
			setKind((ConnectionKind) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__DESTINATION:
			setDestination((ConnectionInstanceEnd) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE:
			getConnectionReferences().clear();
			getConnectionReferences().addAll((Collection<? extends ConnectionReference>) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__BIDIRECTIONAL:
			setBidirectional((Boolean) newValue);
			return;
		case InstancePackage.CONNECTION_INSTANCE__SOURCE:
			setSource((ConnectionInstanceEnd) newValue);
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
		case InstancePackage.CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			getInSystemOperationModes().clear();
			return;
		case InstancePackage.CONNECTION_INSTANCE__IN_MODE_TRANSITION:
			getInModeTransitions().clear();
			return;
		case InstancePackage.CONNECTION_INSTANCE__COMPLETE:
			setComplete(COMPLETE_EDEFAULT);
			return;
		case InstancePackage.CONNECTION_INSTANCE__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case InstancePackage.CONNECTION_INSTANCE__DESTINATION:
			setDestination((ConnectionInstanceEnd) null);
			return;
		case InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE:
			getConnectionReferences().clear();
			return;
		case InstancePackage.CONNECTION_INSTANCE__BIDIRECTIONAL:
			setBidirectional(BIDIRECTIONAL_EDEFAULT);
			return;
		case InstancePackage.CONNECTION_INSTANCE__SOURCE:
			setSource((ConnectionInstanceEnd) null);
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
		case InstancePackage.CONNECTION_INSTANCE__IN_SYSTEM_OPERATION_MODE:
			return inSystemOperationModes != null && !inSystemOperationModes.isEmpty();
		case InstancePackage.CONNECTION_INSTANCE__IN_MODE_TRANSITION:
			return inModeTransitions != null && !inModeTransitions.isEmpty();
		case InstancePackage.CONNECTION_INSTANCE__COMPLETE:
			return complete != COMPLETE_EDEFAULT;
		case InstancePackage.CONNECTION_INSTANCE__KIND:
			return kind != KIND_EDEFAULT;
		case InstancePackage.CONNECTION_INSTANCE__DESTINATION:
			return destination != null;
		case InstancePackage.CONNECTION_INSTANCE__CONNECTION_REFERENCE:
			return connectionReferences != null && !connectionReferences.isEmpty();
		case InstancePackage.CONNECTION_INSTANCE__BIDIRECTIONAL:
			return bidirectional != BIDIRECTIONAL_EDEFAULT;
		case InstancePackage.CONNECTION_INSTANCE__SOURCE:
			return source != null;
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
		result.append(" (complete: "); //$NON-NLS-1$
		result.append(complete);
		result.append(", kind: "); //$NON-NLS-1$
		result.append(kind);
		result.append(", bidirectional: "); //$NON-NLS-1$
		result.append(bidirectional);
		result.append(')');
		return result.toString();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public final List<SystemOperationMode> getExistsInModes() {
		// be overly cautious
		final List<SystemOperationMode> inModes = getInSystemOperationModes();
		if (inModes == null || inModes.isEmpty()) {
			return null;
		} else {
			return inModes;
		}
	}

	/**
	 * Get the property value from the declarative model elements associated
	 * with the instance object. This implementation works for Semantic
	 * Connections and the multiple connections that are instantiated
	 * to create the single ConnectionInstance.
	 *
	 * @param property
	 * 			  The property to lookup
	 * @param pva
	 * 			  The property value accumulator to use to build the property
	 * 			  value
	 * @exception InvalidModelException Thrown if the property value cannot
	 * be retrieved because the model is incomplete or otherwise invalid.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	// protected void getPropertyValueFromDeclarativeModel(final Property property,
	// final AadlPropertyValue apv) throws InvalidModelException {
	// /*
	// * If there is more than one declarative spec that influences this
	// * instance object, then we pick the first one that has the property we
	// * are looking for. Semantic checks at the time the instance model is
	// * generated guarantee that it deosn't matter which of the declarative
	// * objects with the property value we look at. Right now this
	// * multiple-spec case only applies to semantic connections.
	// */
	// /*
	// * Sanity check: if there are no declarative connections then we have
	// * nothing to do! If the number of connections does not match the number
	// * of connection contexts then the model is ill-formed and we should not
	// * proceed.
	// */
	// final List<Connection> connections = getConnections();
	// final List<ComponentInstance> contexts = getConnectionContexts();
	// if ((connections.size() > 0) && (connections.size() == contexts.size())) {
	// /*
	// * This is sleazy: because using getPropertyValueInternal mutates
	// * the pva, we can't use it repeatedly until we find the particular
	// * declarative element that gives us the property value. If we do,
	// * we will corrupt the pva. But we cannot directly use
	// * getPropertyValue() either because it will trigger a cyclic
	// * dependency error. So we have to create a new PVA for each lookup;
	// * in this case we know that we always want a DeclarativeMPVA
	// * because the whole point is that we now have delcarative model
	// * elements.
	// *
	// * If all of them are "not present", then the value is not present,
	// * so we can pick an arbitrary declarative element to do the real
	// * work with a "normal" call to getPropertyValueInternal. If some of
	// * the values are present, then we can also pick an arbitrary one to
	// * use for getPropertyValueInternal.
	// */
	// Connection definingConnection = null;
	// ComponentInstance definingConnectionContext = null;
	// final Iterator<Connection> connIter = connections.iterator();
	// final Iterator<ComponentInstance> ctxtIter = contexts.iterator();
	// while ((definingConnection == null) && connIter.hasNext()) {
	// final Connection conn = connIter.next();
	// final ComponentInstance ctxt = ctxtIter.next();
	// final AadlPropertyValue apv1 = new AadlPropertyValue(property);
	// conn.getPropertyValueInternal(property, apv1, true);
	// // apv.addDefaultValue(property.getDefaultAadlValue());
	//
	// /*
	// * If the value exists for this connection, then we choose it.
	// * If the value is modal then make sure it exists for at least
	// * one mode.
	// */
	// if (apv1.isModal()) {
	// final Collection<ReflectiveAadlPropertyValue> vals = apv1.getAllValues();
	// for (final Iterator<ReflectiveAadlPropertyValue> valIter = vals.iterator(); valIter.hasNext();) {
	// final AadlPropertyValue apv = valIter.next();
	// if (!apv.isNotPresent() && apv.exists()) {
	// definingConnection = conn;
	// definingConnectionContext = ctxt;
	// break;
	// }
	// }
	// } else if (!apv1.getValue().isNotPresent()) {
	// definingConnection = conn;
	// definingConnectionContext = ctxt;
	// }
	// }
	// /*
	// * If definingConnection == null then all the values are not
	// * present, so we arbitrarily use the first component to compute the
	// * property value.
	// */
	// if (definingConnection == null) {
	// definingConnection = connections.get(0);
	// definingConnectionContext = contexts.get(0);
	// }
	// // apv.pushCurrentComponent(definingConnectionContext);
	// try {
	// definingConnection.getPropertyValueInternal(property, apv, true);
	// } finally {
	// // pva.popCurrentComponent();
	// }
	// }
	// }

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public List<Connection> getInstantiatedObjects() {
		List<Connection> conns = new LinkedList<Connection>();

		for (ConnectionReference ref : getConnectionReferences()) {
			conns.add(ref.getConnection());
		}
		return Collections.unmodifiableList(conns);
	}

	@Override
	public List<ModalPropertyValue> getConnectionPropertyValues(Property property) throws InvalidModelException {
		// TODO Auto-generated method stub
		return null;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// public List<AadlModalPropertyValue> getConnectionPropertyValues(final Property property)
	// throws InvalidModelException {
	// final List<Connection> connections = getConnections();
	// final List<ComponentInstance> contexts = getConnectionContexts();
	// final List<AadlModalPropertyValue> values = new ArrayList<AadlModalPropertyValue>(connections.size());
	//
	// final Iterator<Connection> connIter = connections.iterator();
	// final Iterator<ComponentInstance> ctxtIter = contexts.iterator();
	// while (connIter.hasNext()) {
	// final Connection conn = connIter.next();
	// final ComponentInstance ctxt = ctxtIter.next();
	// if (conn.acceptsProperty(property)) {
	// final AadlPropertyValue impva = new AadlPropertyValue(property);
	// // impva.pushCurrentComponent(ctxt);
	// /*
	// * Don't have lookup interpret the inherit flag in the
	// * declarative model because we need to interpret it in the
	// * instance model (below).
	// */
	// conn.getPropertyValueInternal(property, impva, true);
	// // impva.popCurrentComponent();
	// /*
	// * Must manually interpret the inherit flag here. We inherit
	// * along the subcomponent ancestors of the connection's context
	// * object.
	// */
	// if (property.isInherit()) {
	// ctxt.getPropertyValueInternal(property, impva, false);
	// }
	// // Must manually add the default property value
	// // impva.addDefaultValue(property.getDefaultAadlValue());
	// values.add(impva);
	// } else {
	// throw new IllegalArgumentException("Not accepted by connection \"" + conn.getName()
	// + "\" in classifier \"" + conn.getContainingClassifier().getName() + "\"");
	// }
	// }
	// return values;
	// }

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#acceptsProperty (org.osate.aadl2.Property)
	 */
	@Override
	public boolean acceptsProperty(Property property) {
		// OsateDebug.osateDebug("[ConnectionInstanceImpl] acceptsProperty" + property);

		for (ConnectionReference ref : getConnectionReferences()) {
			Connection conn = ref.getConnection();
			if (conn.acceptsProperty(property)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return list of Feature instances involved in a connection instance
	 * In case of a fan-in/fan-out it includes both the feature group and the feature
	 * For an end point in teh connection it may be a component instance
	 */
	@Override
	public List<InstanceObject> getThroughFeatureInstances() {
		final List<InstanceObject> featureList = new ArrayList<InstanceObject>();

		InstanceObject lastDest = null;
		for (ConnectionReference connRef : getConnectionReferences()) {
			Connection conn = connRef.getConnection();
			ComponentInstance ctxt = connRef.getContext();
			final ConnectionEnd srcF = conn.getAllSource();
			final Context srcCtxt = conn.getAllSourceContext();
			final InstanceObject srcInstance = getInstantiatedEndPoint(ctxt, srcF, srcCtxt);
			if (srcInstance != lastDest) {
				featureList.add(srcInstance);
			}

			final ConnectionEnd destF = conn.getAllDestination();
			final Context destCtxt = conn.getAllDestinationContext();
			final InstanceObject destInstance = getInstantiatedEndPoint(ctxt, destF, destCtxt);
			featureList.add(destInstance);
			lastDest = destInstance;
		}
		return featureList;
	}

	/**
	 * find the connection endpoint within the component instance
	 * @param ctxt component instance
	 * @param connEndPoint ConnectionEnd
	 * @param connCtxt Context of th eendpoint
	 */
	@Override
	public ConnectionInstanceEnd getInstantiatedEndPoint(final ComponentInstance ctxt,
			final ConnectionEnd connEndPoint, final Context connCtxt) {
		ConnectionInstanceEnd instance = null;
		if (connCtxt == null) {
			// lookup subcomponent using the connection src
			if (connEndPoint instanceof Subcomponent) {
				instance = ctxt.findSubcomponentInstance((Subcomponent) connEndPoint);
			}
			if (connEndPoint instanceof Feature) {
				instance = ctxt.findFeatureInstance((Feature) connEndPoint);
			}

			if (instance == null) {
				OsateDebug.osateDebug("[ConnectionInstanceImpl] Error while evaluating object");
			}

		} else if (connCtxt instanceof ComponentImplementation) {
			// lookup feature in the context using the connection src
			instance = ctxt.findFeatureInstance((Feature) connEndPoint);
		} else if (connCtxt instanceof Subcomponent) {
			// lookup feature in the subcomponent
			instance = ctxt.findSubcomponentInstance((Subcomponent) connCtxt).findFeatureInstance(
					(Feature) connEndPoint);
		} else if (connCtxt instanceof FeatureGroup) {
			// feature in a feature group...
			instance = ctxt.findFeatureInstance((FeatureGroup) connCtxt).findFeatureInstance((Feature) connEndPoint);
		}
		return instance;
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		if (getInSystemOperationModes().isEmpty() || getInSystemOperationModes().contains(som)) {
			return getContainingComponentInstance().isActive(som);
		}
		return false;
	}

} // ConnectionInstanceImpl
