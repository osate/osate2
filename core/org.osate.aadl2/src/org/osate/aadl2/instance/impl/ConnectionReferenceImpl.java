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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Connection;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyOwner;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#isReverse <em>Reverse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionReferenceImpl extends InstanceObjectImpl implements ConnectionReference {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance context;

	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected Connection connection;

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
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstanceEnd destination;

	/**
	 * The default value of the '{@link #isReverse() <em>Reverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReverse()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVERSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReverse() <em>Reverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReverse()
	 * @generated
	 * @ordered
	 */
	protected boolean reverse = REVERSE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.CONNECTION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance getContext() {
		if (context != null && context.eIsProxy()) {
			InternalEObject oldContext = (InternalEObject) context;
			context = (ComponentInstance) eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.CONNECTION_REFERENCE__CONTEXT, oldContext, context));
				}
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(ComponentInstance newContext) {
		ComponentInstance oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_REFERENCE__CONTEXT,
					oldContext, context));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getConnection() {
		if (connection != null && ((EObject) connection).eIsProxy()) {
			InternalEObject oldConnection = (InternalEObject) connection;
			connection = (Connection) eResolveProxy(oldConnection);
			if (connection != oldConnection) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.CONNECTION_REFERENCE__CONNECTION, oldConnection, connection));
				}
			}
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection basicGetConnection() {
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnection(Connection newConnection) {
		Connection oldConnection = connection;
		connection = newConnection;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_REFERENCE__CONNECTION,
					oldConnection, connection));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstanceEnd getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (ConnectionInstanceEnd) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.CONNECTION_REFERENCE__SOURCE, oldSource, source));
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
	public void setSource(ConnectionInstanceEnd newSource) {
		ConnectionInstanceEnd oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_REFERENCE__SOURCE,
					oldSource, source));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstanceEnd getDestination() {
		if (destination != null && destination.eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (ConnectionInstanceEnd) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							InstancePackage.CONNECTION_REFERENCE__DESTINATION, oldDestination, destination));
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
	public void setDestination(ConnectionInstanceEnd newDestination) {
		ConnectionInstanceEnd oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_REFERENCE__DESTINATION,
					oldDestination, destination));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReverse() {
		return reverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReverse(boolean newReverse) {
		boolean oldReverse = reverse;
		reverse = newReverse;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, InstancePackage.CONNECTION_REFERENCE__REVERSE,
					oldReverse, reverse));
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
		case InstancePackage.CONNECTION_REFERENCE__CONTEXT:
			if (resolve) {
				return getContext();
			}
			return basicGetContext();
		case InstancePackage.CONNECTION_REFERENCE__CONNECTION:
			if (resolve) {
				return getConnection();
			}
			return basicGetConnection();
		case InstancePackage.CONNECTION_REFERENCE__SOURCE:
			if (resolve) {
				return getSource();
			}
			return basicGetSource();
		case InstancePackage.CONNECTION_REFERENCE__DESTINATION:
			if (resolve) {
				return getDestination();
			}
			return basicGetDestination();
		case InstancePackage.CONNECTION_REFERENCE__REVERSE:
			return isReverse();
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
		case InstancePackage.CONNECTION_REFERENCE__CONTEXT:
			setContext((ComponentInstance) newValue);
			return;
		case InstancePackage.CONNECTION_REFERENCE__CONNECTION:
			setConnection((Connection) newValue);
			return;
		case InstancePackage.CONNECTION_REFERENCE__SOURCE:
			setSource((ConnectionInstanceEnd) newValue);
			return;
		case InstancePackage.CONNECTION_REFERENCE__DESTINATION:
			setDestination((ConnectionInstanceEnd) newValue);
			return;
		case InstancePackage.CONNECTION_REFERENCE__REVERSE:
			setReverse((Boolean) newValue);
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
		case InstancePackage.CONNECTION_REFERENCE__CONTEXT:
			setContext((ComponentInstance) null);
			return;
		case InstancePackage.CONNECTION_REFERENCE__CONNECTION:
			setConnection((Connection) null);
			return;
		case InstancePackage.CONNECTION_REFERENCE__SOURCE:
			setSource((ConnectionInstanceEnd) null);
			return;
		case InstancePackage.CONNECTION_REFERENCE__DESTINATION:
			setDestination((ConnectionInstanceEnd) null);
			return;
		case InstancePackage.CONNECTION_REFERENCE__REVERSE:
			setReverse(REVERSE_EDEFAULT);
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
		case InstancePackage.CONNECTION_REFERENCE__CONTEXT:
			return context != null;
		case InstancePackage.CONNECTION_REFERENCE__CONNECTION:
			return connection != null;
		case InstancePackage.CONNECTION_REFERENCE__SOURCE:
			return source != null;
		case InstancePackage.CONNECTION_REFERENCE__DESTINATION:
			return destination != null;
		case InstancePackage.CONNECTION_REFERENCE__REVERSE:
			return reverse != REVERSE_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (reverse: "); //$NON-NLS-1$
		result.append(reverse);
		result.append(')');
		return result.toString();
	}

	public boolean isActive(SystemOperationMode som) {
		return ((ConnectionInstance) getOwner()).isActive(som) && getSource().isActive(som)
				&& getDestination().isActive(som);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.NamedElementImpl#getName()
	 */
	@Override
	public String getName() {
		return getConnection().getName();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.impl.NamedElementImpl#setName(java.lang.String)
	 */
	@Override
	public void setName(String newName) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#acceptsProperty(org.osate.aadl2.Property)
	 */
	@Override
	public boolean acceptsProperty(Property property) {
		final boolean result;
		for (final PropertyOwner propOwner : property.getAppliesTos()) {
			// OsateDebug.osateDebug("[ConnectionReferenceImpl] property owner=" + propOwner);

			if (propOwner instanceof MetaclassReference) {
				if ((((MetaclassReference) propOwner).getMetaclassNames().size() > 0)
						&& ((MetaclassReference) propOwner).getMetaclassNames().get(0).equals("all")) {
					// OsateDebug.osateDebug("[ConnectionReferenceImpl] accept property");

					return true;
				}

			}
		}
		// OsateDebug.osateDebug("[ConnectionReferenceImpl] acceptsProperty" + property);
		// OsateDebug.osateDebug("[ConnectionReferenceImpl] getConnection()=" + getConnection());

		result = getConnection().acceptsProperty(property);
		// OsateDebug.osateDebug("[ConnectionReferenceImpl] result=" + result);
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.impl.InstanceObjectImpl#getInstantiatedObjects()
	 */
	@Override
	public List<? extends NamedElement> getInstantiatedObjects() {
		return Collections.singletonList(getConnection());
	}

	@Override
	public final void getPropertyValueInternal(Property property, PropertyAcc pas, boolean fromInstanceSlaveCall,
			final boolean all) throws InvalidModelException {
		// Do nothing because there should be no properties looked up on a ConnectionReference.
	}

} // ConnectionReferenceImpl
