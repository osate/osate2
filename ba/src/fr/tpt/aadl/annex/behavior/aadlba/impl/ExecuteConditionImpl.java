/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ExecuteConditionImpl#getValueExpression <em>Value Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ExecuteConditionImpl#isCatchTimeout <em>Catch Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteConditionImpl extends BehaviorConditionImpl implements ExecuteCondition
{
   /**
	 * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getValueExpression()
	 * @generated
	 * @ordered
	 */
   protected ValueExpression valueExpression;

   /**
	 * The default value of the '{@link #isCatchTimeout() <em>Catch Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isCatchTimeout()
	 * @generated
	 * @ordered
	 */
   protected static final boolean CATCH_TIMEOUT_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isCatchTimeout() <em>Catch Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isCatchTimeout()
	 * @generated
	 * @ordered
	 */
   protected boolean catchTimeout = CATCH_TIMEOUT_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ExecuteConditionImpl()
   {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass()
   {
		return AadlBaPackage.Literals.EXECUTE_CONDITION;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ValueExpression getValueExpression()
   {
		return valueExpression;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetValueExpression(ValueExpression newValueExpression, NotificationChain msgs)
   {
		ValueExpression oldValueExpression = valueExpression;
		valueExpression = newValueExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION, oldValueExpression, newValueExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setValueExpression(ValueExpression newValueExpression)
   {
		if (newValueExpression != valueExpression) {
			NotificationChain msgs = null;
			if (valueExpression != null)
				msgs = ((InternalEObject)valueExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION, null, msgs);
			if (newValueExpression != null)
				msgs = ((InternalEObject)newValueExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION, null, msgs);
			msgs = basicSetValueExpression(newValueExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION, newValueExpression, newValueExpression));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isCatchTimeout()
   {
		return catchTimeout;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setCatchTimeout(boolean newCatchTimeout)
   {
		boolean oldCatchTimeout = catchTimeout;
		catchTimeout = newCatchTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.EXECUTE_CONDITION__CATCH_TIMEOUT, oldCatchTimeout, catchTimeout));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
		switch (featureID) {
			case AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION:
				return basicSetValueExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
		switch (featureID) {
			case AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION:
				return getValueExpression();
			case AadlBaPackage.EXECUTE_CONDITION__CATCH_TIMEOUT:
				return isCatchTimeout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public void eSet(int featureID, Object newValue)
   {
		switch (featureID) {
			case AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION:
				setValueExpression((ValueExpression)newValue);
				return;
			case AadlBaPackage.EXECUTE_CONDITION__CATCH_TIMEOUT:
				setCatchTimeout((Boolean)newValue);
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
   public void eUnset(int featureID)
   {
		switch (featureID) {
			case AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION:
				setValueExpression((ValueExpression)null);
				return;
			case AadlBaPackage.EXECUTE_CONDITION__CATCH_TIMEOUT:
				setCatchTimeout(CATCH_TIMEOUT_EDEFAULT);
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
   public boolean eIsSet(int featureID)
   {
		switch (featureID) {
			case AadlBaPackage.EXECUTE_CONDITION__VALUE_EXPRESSION:
				return valueExpression != null;
			case AadlBaPackage.EXECUTE_CONDITION__CATCH_TIMEOUT:
				return catchTimeout != CATCH_TIMEOUT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String toString()
   {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (CatchTimeout: ");
		result.append(catchTimeout);
		result.append(')');
		return result.toString();
	}

} //ExecuteConditionImpl
