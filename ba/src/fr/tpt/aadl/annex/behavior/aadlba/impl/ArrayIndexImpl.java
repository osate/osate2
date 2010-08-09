/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ArrayIndexImpl#getIntegerValueVariableOwned <em>Integer Value Variable Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayIndexImpl extends ElementImpl implements ArrayIndex
{
   /**
	 * The cached value of the '{@link #getIntegerValueVariableOwned() <em>Integer Value Variable Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getIntegerValueVariableOwned()
	 * @generated
	 * @ordered
	 */
   protected ValueVariable integerValueVariableOwned;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ArrayIndexImpl()
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
		return AadlBaPackage.Literals.ARRAY_INDEX;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ValueVariable getIntegerValueVariableOwned()
   {
		return integerValueVariableOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetIntegerValueVariableOwned(ValueVariable newIntegerValueVariableOwned, NotificationChain msgs)
   {
		ValueVariable oldIntegerValueVariableOwned = integerValueVariableOwned;
		integerValueVariableOwned = newIntegerValueVariableOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED, oldIntegerValueVariableOwned, newIntegerValueVariableOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setIntegerValueVariableOwned(ValueVariable newIntegerValueVariableOwned)
   {
		if (newIntegerValueVariableOwned != integerValueVariableOwned) {
			NotificationChain msgs = null;
			if (integerValueVariableOwned != null)
				msgs = ((InternalEObject)integerValueVariableOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED, null, msgs);
			if (newIntegerValueVariableOwned != null)
				msgs = ((InternalEObject)newIntegerValueVariableOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED, null, msgs);
			msgs = basicSetIntegerValueVariableOwned(newIntegerValueVariableOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED, newIntegerValueVariableOwned, newIntegerValueVariableOwned));
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
			case AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED:
				return basicSetIntegerValueVariableOwned(null, msgs);
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
			case AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED:
				return getIntegerValueVariableOwned();
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
			case AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED:
				setIntegerValueVariableOwned((ValueVariable)newValue);
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
			case AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED:
				setIntegerValueVariableOwned((ValueVariable)null);
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
			case AadlBaPackage.ARRAY_INDEX__INTEGER_VALUE_VARIABLE_OWNED:
				return integerValueVariableOwned != null;
		}
		return super.eIsSet(featureID);
	}

} //ArrayIndexImpl
