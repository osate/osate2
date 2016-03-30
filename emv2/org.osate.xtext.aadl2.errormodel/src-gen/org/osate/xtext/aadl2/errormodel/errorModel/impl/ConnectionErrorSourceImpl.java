/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.Connection;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ConnectionErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Error Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorSourceImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorSourceImpl#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorSourceImpl#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorSourceImpl#getFailureModeType <em>Failure Mode Type</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorSourceImpl#getFailureModeDescription <em>Failure Mode Description</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ConnectionErrorSourceImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionErrorSourceImpl extends NamedElementImpl implements ConnectionErrorSource {
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
	 * The default value of the '{@link #isAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAll()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAll() <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAll()
	 * @generated
	 * @ordered
	 */
	protected boolean all = ALL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypeTokenConstraint() <em>Type Token Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeTokenConstraint()
	 * @generated
	 * @ordered
	 */
	protected TypeSet typeTokenConstraint;

	/**
	 * The cached value of the '{@link #getFailureModeType() <em>Failure Mode Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModeType()
	 * @generated
	 * @ordered
	 */
	protected TypeSet failureModeType;

	/**
	 * The default value of the '{@link #getFailureModeDescription() <em>Failure Mode Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModeDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String FAILURE_MODE_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFailureModeDescription() <em>Failure Mode Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureModeDescription()
	 * @generated
	 * @ordered
	 */
	protected String failureModeDescription = FAILURE_MODE_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionErrorSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ErrorModelPackage.Literals.CONNECTION_ERROR_SOURCE;
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
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONNECTION, oldConnection, connection));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONNECTION,
					oldConnection, connection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAll() {
		return all;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAll(boolean newAll) {
		boolean oldAll = all;
		all = newAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONNECTION_ERROR_SOURCE__ALL,
					oldAll, all));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSet getTypeTokenConstraint() {
		return typeTokenConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeTokenConstraint(TypeSet newTypeTokenConstraint, NotificationChain msgs) {
		TypeSet oldTypeTokenConstraint = typeTokenConstraint;
		typeTokenConstraint = newTypeTokenConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT, oldTypeTokenConstraint,
					newTypeTokenConstraint);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeTokenConstraint(TypeSet newTypeTokenConstraint) {
		if (newTypeTokenConstraint != typeTokenConstraint) {
			NotificationChain msgs = null;
			if (typeTokenConstraint != null)
				msgs = ((InternalEObject) typeTokenConstraint).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT, null,
						msgs);
			if (newTypeTokenConstraint != null)
				msgs = ((InternalEObject) newTypeTokenConstraint).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT, null,
						msgs);
			msgs = basicSetTypeTokenConstraint(newTypeTokenConstraint, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT, newTypeTokenConstraint,
					newTypeTokenConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSet getFailureModeType() {
		return failureModeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFailureModeType(TypeSet newFailureModeType, NotificationChain msgs) {
		TypeSet oldFailureModeType = failureModeType;
		failureModeType = newFailureModeType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE, oldFailureModeType,
					newFailureModeType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureModeType(TypeSet newFailureModeType) {
		if (newFailureModeType != failureModeType) {
			NotificationChain msgs = null;
			if (failureModeType != null)
				msgs = ((InternalEObject) failureModeType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE, null,
						msgs);
			if (newFailureModeType != null)
				msgs = ((InternalEObject) newFailureModeType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE, null,
						msgs);
			msgs = basicSetFailureModeType(newFailureModeType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE, newFailureModeType,
					newFailureModeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFailureModeDescription() {
		return failureModeDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureModeDescription(String newFailureModeDescription) {
		String oldFailureModeDescription = failureModeDescription;
		failureModeDescription = newFailureModeDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_DESCRIPTION, oldFailureModeDescription,
					failureModeDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONDITION,
					oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT:
			return basicSetTypeTokenConstraint(null, msgs);
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE:
			return basicSetFailureModeType(null, msgs);
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
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONNECTION:
			if (resolve)
				return getConnection();
			return basicGetConnection();
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__ALL:
			return isAll();
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT:
			return getTypeTokenConstraint();
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE:
			return getFailureModeType();
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
			return getFailureModeDescription();
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONDITION:
			return getCondition();
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
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONNECTION:
			setConnection((Connection) newValue);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__ALL:
			setAll((Boolean) newValue);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT:
			setTypeTokenConstraint((TypeSet) newValue);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE:
			setFailureModeType((TypeSet) newValue);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
			setFailureModeDescription((String) newValue);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONDITION:
			setCondition((String) newValue);
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
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONNECTION:
			setConnection((Connection) null);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__ALL:
			setAll(ALL_EDEFAULT);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT:
			setTypeTokenConstraint((TypeSet) null);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE:
			setFailureModeType((TypeSet) null);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
			setFailureModeDescription(FAILURE_MODE_DESCRIPTION_EDEFAULT);
			return;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONDITION:
			setCondition(CONDITION_EDEFAULT);
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
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONNECTION:
			return connection != null;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__ALL:
			return all != ALL_EDEFAULT;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__TYPE_TOKEN_CONSTRAINT:
			return typeTokenConstraint != null;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_TYPE:
			return failureModeType != null;
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__FAILURE_MODE_DESCRIPTION:
			return FAILURE_MODE_DESCRIPTION_EDEFAULT == null ? failureModeDescription != null
					: !FAILURE_MODE_DESCRIPTION_EDEFAULT.equals(failureModeDescription);
		case ErrorModelPackage.CONNECTION_ERROR_SOURCE__CONDITION:
			return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (all: ");
		result.append(all);
		result.append(", failureModeDescription: ");
		result.append(failureModeDescription);
		result.append(", condition: ");
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} // ConnectionErrorSourceImpl
