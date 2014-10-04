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
 * $Id: ConnectionReferenceImpl.java,v 1.3 2010-06-15 20:46:20 lwrage Exp $
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.ConnectionReferenceImpl#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean isActive(SystemOperationMode som) {
		return ((ConnectionInstance) getOwner()).isActive(som);
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
			// OsateDebug.osateDebug("[ConnectionReferenceImpl]   property owner=" + propOwner);

			if (propOwner instanceof MetaclassReference) {
				if ((((MetaclassReference) propOwner).getMetaclassNames().size() > 0)
						&& ((MetaclassReference) propOwner).getMetaclassNames().get(0).equals("all")) {
					// OsateDebug.osateDebug("[ConnectionReferenceImpl]   accept property");

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

} // ConnectionReferenceImpl
