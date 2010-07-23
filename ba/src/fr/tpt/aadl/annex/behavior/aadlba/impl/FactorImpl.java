/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Value;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getValueOwned <em>Value Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getValueSdOwned <em>Value Sd Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#isHasBinaryNumericOperator <em>Has Binary Numeric Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#isHasUnaryNumericOperator <em>Has Unary Numeric Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.FactorImpl#isHasUnaryBooleanOperator <em>Has Unary Boolean Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FactorImpl extends ElementImpl implements Factor
{
   /**
    * The cached value of the '{@link #getValueOwned() <em>Value Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getValueOwned()
    * @generated
    * @ordered
    */
   protected Value valueOwned;

   /**
    * The cached value of the '{@link #getValueSdOwned() <em>Value Sd Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getValueSdOwned()
    * @generated
    * @ordered
    */
   protected Value valueSdOwned;

   /**
    * The default value of the '{@link #getBinaryNumericOperatorOwned() <em>Binary Numeric Operator Owned</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBinaryNumericOperatorOwned()
    * @generated
    * @ordered
    */
   protected static final BinaryNumericOperator BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT = BinaryNumericOperator.MULTIPLY_MULTIPLY;

   /**
    * The cached value of the '{@link #getBinaryNumericOperatorOwned() <em>Binary Numeric Operator Owned</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBinaryNumericOperatorOwned()
    * @generated
    * @ordered
    */
   protected BinaryNumericOperator binaryNumericOperatorOwned = BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;

   /**
    * The default value of the '{@link #getUnaryNumericOperatorOwned() <em>Unary Numeric Operator Owned</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getUnaryNumericOperatorOwned()
    * @generated
    * @ordered
    */
   protected static final UnaryNumericOperator UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT = UnaryNumericOperator.ABS;

   /**
    * The cached value of the '{@link #getUnaryNumericOperatorOwned() <em>Unary Numeric Operator Owned</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getUnaryNumericOperatorOwned()
    * @generated
    * @ordered
    */
   protected UnaryNumericOperator unaryNumericOperatorOwned = UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;

   /**
    * The default value of the '{@link #getUnaryBooleanOperatorOwned() <em>Unary Boolean Operator Owned</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getUnaryBooleanOperatorOwned()
    * @generated
    * @ordered
    */
   protected static final UnaryBooleanOperator UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT = UnaryBooleanOperator.NOT;

   /**
    * The cached value of the '{@link #getUnaryBooleanOperatorOwned() <em>Unary Boolean Operator Owned</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getUnaryBooleanOperatorOwned()
    * @generated
    * @ordered
    */
   protected UnaryBooleanOperator unaryBooleanOperatorOwned = UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT;

   /**
    * The default value of the '{@link #isHasBinaryNumericOperator() <em>Has Binary Numeric Operator</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasBinaryNumericOperator()
    * @generated
    * @ordered
    */
   protected static final boolean HAS_BINARY_NUMERIC_OPERATOR_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isHasBinaryNumericOperator() <em>Has Binary Numeric Operator</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasBinaryNumericOperator()
    * @generated
    * @ordered
    */
   protected boolean hasBinaryNumericOperator = HAS_BINARY_NUMERIC_OPERATOR_EDEFAULT;

   /**
    * The default value of the '{@link #isHasUnaryNumericOperator() <em>Has Unary Numeric Operator</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasUnaryNumericOperator()
    * @generated
    * @ordered
    */
   protected static final boolean HAS_UNARY_NUMERIC_OPERATOR_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isHasUnaryNumericOperator() <em>Has Unary Numeric Operator</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasUnaryNumericOperator()
    * @generated
    * @ordered
    */
   protected boolean hasUnaryNumericOperator = HAS_UNARY_NUMERIC_OPERATOR_EDEFAULT;

   /**
    * The default value of the '{@link #isHasUnaryBooleanOperator() <em>Has Unary Boolean Operator</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasUnaryBooleanOperator()
    * @generated
    * @ordered
    */
   protected static final boolean HAS_UNARY_BOOLEAN_OPERATOR_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isHasUnaryBooleanOperator() <em>Has Unary Boolean Operator</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasUnaryBooleanOperator()
    * @generated
    * @ordered
    */
   protected boolean hasUnaryBooleanOperator = HAS_UNARY_BOOLEAN_OPERATOR_EDEFAULT;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected FactorImpl()
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
      return AadlBaPackage.Literals.FACTOR;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Value getValueOwned()
   {
      return valueOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetValueOwned(Value newValueOwned, NotificationChain msgs)
   {
      Value oldValueOwned = valueOwned;
      valueOwned = newValueOwned;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_OWNED, oldValueOwned, newValueOwned);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setValueOwned(Value newValueOwned)
   {
      if (newValueOwned != valueOwned)
      {
         NotificationChain msgs = null;
         if (valueOwned != null)
            msgs = ((InternalEObject)valueOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_OWNED, null, msgs);
         if (newValueOwned != null)
            msgs = ((InternalEObject)newValueOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_OWNED, null, msgs);
         msgs = basicSetValueOwned(newValueOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_OWNED, newValueOwned, newValueOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Value getValueSdOwned()
   {
      return valueSdOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetValueSdOwned(Value newValueSdOwned, NotificationChain msgs)
   {
      Value oldValueSdOwned = valueSdOwned;
      valueSdOwned = newValueSdOwned;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_SD_OWNED, oldValueSdOwned, newValueSdOwned);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setValueSdOwned(Value newValueSdOwned)
   {
      if (newValueSdOwned != valueSdOwned)
      {
         NotificationChain msgs = null;
         if (valueSdOwned != null)
            msgs = ((InternalEObject)valueSdOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_SD_OWNED, null, msgs);
         if (newValueSdOwned != null)
            msgs = ((InternalEObject)newValueSdOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.FACTOR__VALUE_SD_OWNED, null, msgs);
         msgs = basicSetValueSdOwned(newValueSdOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__VALUE_SD_OWNED, newValueSdOwned, newValueSdOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public BinaryNumericOperator getBinaryNumericOperatorOwned()
   {
      return binaryNumericOperatorOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBinaryNumericOperatorOwned(BinaryNumericOperator newBinaryNumericOperatorOwned)
   {
      BinaryNumericOperator oldBinaryNumericOperatorOwned = binaryNumericOperatorOwned;
      binaryNumericOperatorOwned = newBinaryNumericOperatorOwned == null ? BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT : newBinaryNumericOperatorOwned;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED, oldBinaryNumericOperatorOwned, binaryNumericOperatorOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UnaryNumericOperator getUnaryNumericOperatorOwned()
   {
      return unaryNumericOperatorOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setUnaryNumericOperatorOwned(UnaryNumericOperator newUnaryNumericOperatorOwned)
   {
      UnaryNumericOperator oldUnaryNumericOperatorOwned = unaryNumericOperatorOwned;
      unaryNumericOperatorOwned = newUnaryNumericOperatorOwned == null ? UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT : newUnaryNumericOperatorOwned;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED, oldUnaryNumericOperatorOwned, unaryNumericOperatorOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public UnaryBooleanOperator getUnaryBooleanOperatorOwned()
   {
      return unaryBooleanOperatorOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setUnaryBooleanOperatorOwned(UnaryBooleanOperator newUnaryBooleanOperatorOwned)
   {
      UnaryBooleanOperator oldUnaryBooleanOperatorOwned = unaryBooleanOperatorOwned;
      unaryBooleanOperatorOwned = newUnaryBooleanOperatorOwned == null ? UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT : newUnaryBooleanOperatorOwned;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED, oldUnaryBooleanOperatorOwned, unaryBooleanOperatorOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isHasBinaryNumericOperator()
   {
      return hasBinaryNumericOperator;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setHasBinaryNumericOperator(boolean newHasBinaryNumericOperator)
   {
      boolean oldHasBinaryNumericOperator = hasBinaryNumericOperator;
      hasBinaryNumericOperator = newHasBinaryNumericOperator;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__HAS_BINARY_NUMERIC_OPERATOR, oldHasBinaryNumericOperator, hasBinaryNumericOperator));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isHasUnaryNumericOperator()
   {
      return hasUnaryNumericOperator;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setHasUnaryNumericOperator(boolean newHasUnaryNumericOperator)
   {
      boolean oldHasUnaryNumericOperator = hasUnaryNumericOperator;
      hasUnaryNumericOperator = newHasUnaryNumericOperator;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__HAS_UNARY_NUMERIC_OPERATOR, oldHasUnaryNumericOperator, hasUnaryNumericOperator));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isHasUnaryBooleanOperator()
   {
      return hasUnaryBooleanOperator;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setHasUnaryBooleanOperator(boolean newHasUnaryBooleanOperator)
   {
      boolean oldHasUnaryBooleanOperator = hasUnaryBooleanOperator;
      hasUnaryBooleanOperator = newHasUnaryBooleanOperator;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.FACTOR__HAS_UNARY_BOOLEAN_OPERATOR, oldHasUnaryBooleanOperator, hasUnaryBooleanOperator));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case AadlBaPackage.FACTOR__VALUE_OWNED:
            return basicSetValueOwned(null, msgs);
         case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
            return basicSetValueSdOwned(null, msgs);
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
      switch (featureID)
      {
         case AadlBaPackage.FACTOR__VALUE_OWNED:
            return getValueOwned();
         case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
            return getValueSdOwned();
         case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
            return getBinaryNumericOperatorOwned();
         case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
            return getUnaryNumericOperatorOwned();
         case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
            return getUnaryBooleanOperatorOwned();
         case AadlBaPackage.FACTOR__HAS_BINARY_NUMERIC_OPERATOR:
            return isHasBinaryNumericOperator();
         case AadlBaPackage.FACTOR__HAS_UNARY_NUMERIC_OPERATOR:
            return isHasUnaryNumericOperator();
         case AadlBaPackage.FACTOR__HAS_UNARY_BOOLEAN_OPERATOR:
            return isHasUnaryBooleanOperator();
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
      switch (featureID)
      {
         case AadlBaPackage.FACTOR__VALUE_OWNED:
            setValueOwned((Value)newValue);
            return;
         case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
            setValueSdOwned((Value)newValue);
            return;
         case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
            setBinaryNumericOperatorOwned((BinaryNumericOperator)newValue);
            return;
         case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
            setUnaryNumericOperatorOwned((UnaryNumericOperator)newValue);
            return;
         case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
            setUnaryBooleanOperatorOwned((UnaryBooleanOperator)newValue);
            return;
         case AadlBaPackage.FACTOR__HAS_BINARY_NUMERIC_OPERATOR:
            setHasBinaryNumericOperator((Boolean)newValue);
            return;
         case AadlBaPackage.FACTOR__HAS_UNARY_NUMERIC_OPERATOR:
            setHasUnaryNumericOperator((Boolean)newValue);
            return;
         case AadlBaPackage.FACTOR__HAS_UNARY_BOOLEAN_OPERATOR:
            setHasUnaryBooleanOperator((Boolean)newValue);
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
      switch (featureID)
      {
         case AadlBaPackage.FACTOR__VALUE_OWNED:
            setValueOwned((Value)null);
            return;
         case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
            setValueSdOwned((Value)null);
            return;
         case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
            setBinaryNumericOperatorOwned(BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT);
            return;
         case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
            setUnaryNumericOperatorOwned(UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT);
            return;
         case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
            setUnaryBooleanOperatorOwned(UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT);
            return;
         case AadlBaPackage.FACTOR__HAS_BINARY_NUMERIC_OPERATOR:
            setHasBinaryNumericOperator(HAS_BINARY_NUMERIC_OPERATOR_EDEFAULT);
            return;
         case AadlBaPackage.FACTOR__HAS_UNARY_NUMERIC_OPERATOR:
            setHasUnaryNumericOperator(HAS_UNARY_NUMERIC_OPERATOR_EDEFAULT);
            return;
         case AadlBaPackage.FACTOR__HAS_UNARY_BOOLEAN_OPERATOR:
            setHasUnaryBooleanOperator(HAS_UNARY_BOOLEAN_OPERATOR_EDEFAULT);
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
      switch (featureID)
      {
         case AadlBaPackage.FACTOR__VALUE_OWNED:
            return valueOwned != null;
         case AadlBaPackage.FACTOR__VALUE_SD_OWNED:
            return valueSdOwned != null;
         case AadlBaPackage.FACTOR__BINARY_NUMERIC_OPERATOR_OWNED:
            return binaryNumericOperatorOwned != BINARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;
         case AadlBaPackage.FACTOR__UNARY_NUMERIC_OPERATOR_OWNED:
            return unaryNumericOperatorOwned != UNARY_NUMERIC_OPERATOR_OWNED_EDEFAULT;
         case AadlBaPackage.FACTOR__UNARY_BOOLEAN_OPERATOR_OWNED:
            return unaryBooleanOperatorOwned != UNARY_BOOLEAN_OPERATOR_OWNED_EDEFAULT;
         case AadlBaPackage.FACTOR__HAS_BINARY_NUMERIC_OPERATOR:
            return hasBinaryNumericOperator != HAS_BINARY_NUMERIC_OPERATOR_EDEFAULT;
         case AadlBaPackage.FACTOR__HAS_UNARY_NUMERIC_OPERATOR:
            return hasUnaryNumericOperator != HAS_UNARY_NUMERIC_OPERATOR_EDEFAULT;
         case AadlBaPackage.FACTOR__HAS_UNARY_BOOLEAN_OPERATOR:
            return hasUnaryBooleanOperator != HAS_UNARY_BOOLEAN_OPERATOR_EDEFAULT;
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
      result.append(" (BinaryNumericOperatorOwned: ");
      result.append(binaryNumericOperatorOwned);
      result.append(", UnaryNumericOperatorOwned: ");
      result.append(unaryNumericOperatorOwned);
      result.append(", UnaryBooleanOperatorOwned: ");
      result.append(unaryBooleanOperatorOwned);
      result.append(", hasBinaryNumericOperator: ");
      result.append(hasBinaryNumericOperator);
      result.append(", hasUnaryNumericOperator: ");
      result.append(hasUnaryNumericOperator);
      result.append(", hasUnaryBooleanOperator: ");
      result.append(hasUnaryBooleanOperator);
      result.append(')');
      return result.toString();
   }

} //FactorImpl
