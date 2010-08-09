/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Time</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl#getIntegerValueOwned <em>Integer Value Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTimeImpl#getUnitIdentifier <em>Unit Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorTimeImpl extends ElementImpl implements BehaviorTime
{
   /**
	 * The cached value of the '{@link #getIntegerValueOwned() <em>Integer Value Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getIntegerValueOwned()
	 * @generated
	 * @ordered
	 */
   protected IntegerValue integerValueOwned;

   /**
	 * The default value of the '{@link #getUnitIdentifier() <em>Unit Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getUnitIdentifier()
	 * @generated
	 * @ordered
	 */
   protected static final String UNIT_IDENTIFIER_EDEFAULT = null;

   /**
	 * The cached value of the '{@link #getUnitIdentifier() <em>Unit Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getUnitIdentifier()
	 * @generated
	 * @ordered
	 */
   protected String unitIdentifier = UNIT_IDENTIFIER_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected BehaviorTimeImpl()
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
		return AadlBaPackage.Literals.BEHAVIOR_TIME;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public IntegerValue getIntegerValueOwned()
   {
		return integerValueOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetIntegerValueOwned(IntegerValue newIntegerValueOwned, NotificationChain msgs)
   {
		IntegerValue oldIntegerValueOwned = integerValueOwned;
		integerValueOwned = newIntegerValueOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED, oldIntegerValueOwned, newIntegerValueOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setIntegerValueOwned(IntegerValue newIntegerValueOwned)
   {
		if (newIntegerValueOwned != integerValueOwned) {
			NotificationChain msgs = null;
			if (integerValueOwned != null)
				msgs = ((InternalEObject)integerValueOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED, null, msgs);
			if (newIntegerValueOwned != null)
				msgs = ((InternalEObject)newIntegerValueOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED, null, msgs);
			msgs = basicSetIntegerValueOwned(newIntegerValueOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED, newIntegerValueOwned, newIntegerValueOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public String getUnitIdentifier()
   {
		return unitIdentifier;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setUnitIdentifier(String newUnitIdentifier)
   {
		String oldUnitIdentifier = unitIdentifier;
		unitIdentifier = newUnitIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER, oldUnitIdentifier, unitIdentifier));
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
			case AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED:
				return basicSetIntegerValueOwned(null, msgs);
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
			case AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED:
				return getIntegerValueOwned();
			case AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER:
				return getUnitIdentifier();
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
			case AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED:
				setIntegerValueOwned((IntegerValue)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER:
				setUnitIdentifier((String)newValue);
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
			case AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED:
				setIntegerValueOwned((IntegerValue)null);
				return;
			case AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER:
				setUnitIdentifier(UNIT_IDENTIFIER_EDEFAULT);
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
			case AadlBaPackage.BEHAVIOR_TIME__INTEGER_VALUE_OWNED:
				return integerValueOwned != null;
			case AadlBaPackage.BEHAVIOR_TIME__UNIT_IDENTIFIER:
				return UNIT_IDENTIFIER_EDEFAULT == null ? unitIdentifier != null : !UNIT_IDENTIFIER_EDEFAULT.equals(unitIdentifier);
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
		result.append(" (UnitIdentifier: ");
		result.append(unitIdentifier);
		result.append(')');
		return result.toString();
	}

} //BehaviorTimeImpl
