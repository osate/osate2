/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BooleanLiteralImpl#isBoolValue <em>Bool Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanLiteralImpl extends ValueConstantImpl implements BooleanLiteral
{
   /**
    * The default value of the '{@link #isBoolValue() <em>Bool Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isBoolValue()
    * @generated
    * @ordered
    */
   protected static final boolean BOOL_VALUE_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isBoolValue() <em>Bool Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isBoolValue()
    * @generated
    * @ordered
    */
   protected boolean boolValue = BOOL_VALUE_EDEFAULT;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected BooleanLiteralImpl()
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
      return AadlBaPackage.Literals.BOOLEAN_LITERAL;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isBoolValue()
   {
      return boolValue;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBoolValue(boolean newBoolValue)
   {
      boolean oldBoolValue = boolValue;
      boolValue = newBoolValue;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BOOLEAN_LITERAL__BOOL_VALUE, oldBoolValue, boolValue));
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
         case AadlBaPackage.BOOLEAN_LITERAL__BOOL_VALUE:
            return isBoolValue();
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
         case AadlBaPackage.BOOLEAN_LITERAL__BOOL_VALUE:
            setBoolValue((Boolean)newValue);
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
         case AadlBaPackage.BOOLEAN_LITERAL__BOOL_VALUE:
            setBoolValue(BOOL_VALUE_EDEFAULT);
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
         case AadlBaPackage.BOOLEAN_LITERAL__BOOL_VALUE:
            return boolValue != BOOL_VALUE_EDEFAULT;
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
      result.append(" (BoolValue: ");
      result.append(boolValue);
      result.append(')');
      return result.toString();
   }

} //BooleanLiteralImpl
