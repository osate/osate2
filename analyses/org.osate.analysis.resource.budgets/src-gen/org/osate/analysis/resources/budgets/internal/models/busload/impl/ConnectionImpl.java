/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.instance.ConnectionInstance;

import org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisElement;
import org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisPackage;
import org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage;
import org.osate.analysis.resources.budgets.internal.models.busload.Connection;
import org.osate.result.Result;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl#getResult <em>Result</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.ConnectionImpl#getConnectionInstance <em>Connection Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionImpl extends BusloadElementImpl implements Connection {
	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected Result result;
	/**
	 * The cached value of the '{@link #getConnectionInstance() <em>Connection Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionInstance()
	 * @generated
	 * @ordered
	 */
	protected ConnectionInstance connectionInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BusloadPackage.Literals.CONNECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Result getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (Result)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusloadPackage.CONNECTION__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Result basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(Result newResult) {
		Result oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BusloadPackage.CONNECTION__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionInstance getConnectionInstance() {
		if (connectionInstance != null && connectionInstance.eIsProxy()) {
			InternalEObject oldConnectionInstance = (InternalEObject)connectionInstance;
			connectionInstance = (ConnectionInstance)eResolveProxy(oldConnectionInstance);
			if (connectionInstance != oldConnectionInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusloadPackage.CONNECTION__CONNECTION_INSTANCE, oldConnectionInstance, connectionInstance));
			}
		}
		return connectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionInstance basicGetConnectionInstance() {
		return connectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectionInstance(ConnectionInstance newConnectionInstance) {
		ConnectionInstance oldConnectionInstance = connectionInstance;
		connectionInstance = newConnectionInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BusloadPackage.CONNECTION__CONNECTION_INSTANCE, oldConnectionInstance, connectionInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLeaf() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getOrderedChildren() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BusloadPackage.CONNECTION__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				if (resolve) return getConnectionInstance();
				return basicGetConnectionInstance();
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
			case BusloadPackage.CONNECTION__RESULT:
				setResult((Result)newValue);
				return;
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				setConnectionInstance((ConnectionInstance)newValue);
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
			case BusloadPackage.CONNECTION__RESULT:
				setResult((Result)null);
				return;
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				setConnectionInstance((ConnectionInstance)null);
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
			case BusloadPackage.CONNECTION__RESULT:
				return result != null;
			case BusloadPackage.CONNECTION__CONNECTION_INSTANCE:
				return connectionInstance != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AnalysisElement.class) {
			switch (derivedFeatureID) {
				case BusloadPackage.CONNECTION__RESULT: return AnalysisPackage.ANALYSIS_ELEMENT__RESULT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AnalysisElement.class) {
			switch (baseFeatureID) {
				case AnalysisPackage.ANALYSIS_ELEMENT__RESULT: return BusloadPackage.CONNECTION__RESULT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == AnalysisElement.class) {
			switch (baseOperationID) {
				case AnalysisPackage.ANALYSIS_ELEMENT___IS_LEAF: return BusloadPackage.CONNECTION___IS_LEAF;
				case AnalysisPackage.ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN: return BusloadPackage.CONNECTION___GET_ORDERED_CHILDREN;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BusloadPackage.CONNECTION___IS_LEAF:
				return isLeaf();
			case BusloadPackage.CONNECTION___GET_ORDERED_CHILDREN:
				return getOrderedChildren();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConnectionImpl
