/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ArraySize;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Size</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ArraySizeImpl#getIntegerValueConstant <em>Integer Value Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArraySizeImpl extends ElementImpl implements ArraySize
{
   /**
    * The cached value of the '{@link #getIntegerValueConstant() <em>Integer Value Constant</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getIntegerValueConstant()
    * @generated
    * @ordered
    */
   protected ValueConstant integerValueConstant;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ArraySizeImpl()
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
      return AadlBaPackage.Literals.ARRAY_SIZE;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ValueConstant getIntegerValueConstant()
   {
      return integerValueConstant;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetIntegerValueConstant(ValueConstant newIntegerValueConstant, NotificationChain msgs)
   {
      ValueConstant oldIntegerValueConstant = integerValueConstant;
      integerValueConstant = newIntegerValueConstant;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT, oldIntegerValueConstant, newIntegerValueConstant);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setIntegerValueConstant(ValueConstant newIntegerValueConstant)
   {
      if (newIntegerValueConstant != integerValueConstant)
      {
         NotificationChain msgs = null;
         if (integerValueConstant != null)
            msgs = ((InternalEObject)integerValueConstant).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT, null, msgs);
         if (newIntegerValueConstant != null)
            msgs = ((InternalEObject)newIntegerValueConstant).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT, null, msgs);
         msgs = basicSetIntegerValueConstant(newIntegerValueConstant, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT, newIntegerValueConstant, newIntegerValueConstant));
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
         case AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT:
            return basicSetIntegerValueConstant(null, msgs);
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
         case AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT:
            return getIntegerValueConstant();
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
         case AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT:
            setIntegerValueConstant((ValueConstant)newValue);
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
         case AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT:
            setIntegerValueConstant((ValueConstant)null);
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
         case AadlBaPackage.ARRAY_SIZE__INTEGER_VALUE_CONSTANT:
            return integerValueConstant != null;
      }
      return super.eIsSet(featureID);
   }

} //ArraySizeImpl
