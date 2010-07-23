/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl#isHasFrozenPorts <em>Has Frozen Ports</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchConditionImpl#getFrozenPorts <em>Frozen Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchConditionImpl extends BehaviorConditionImpl implements DispatchCondition
{
   /**
    * The default value of the '{@link #isHasFrozenPorts() <em>Has Frozen Ports</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasFrozenPorts()
    * @generated
    * @ordered
    */
   protected static final boolean HAS_FROZEN_PORTS_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isHasFrozenPorts() <em>Has Frozen Ports</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasFrozenPorts()
    * @generated
    * @ordered
    */
   protected boolean hasFrozenPorts = HAS_FROZEN_PORTS_EDEFAULT;

   /**
    * The cached value of the '{@link #getTheDispatchLogicalExpression() <em>The Dispatch Logical Expression</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTheDispatchLogicalExpression()
    * @generated
    * @ordered
    */
   protected DispatchLogicalExpression theDispatchLogicalExpression;

   /**
    * This is true if the The Dispatch Logical Expression containment reference has been set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   protected boolean theDispatchLogicalExpressionESet;

   /**
    * The cached value of the '{@link #getFrozenPorts() <em>Frozen Ports</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getFrozenPorts()
    * @generated
    * @ordered
    */
   protected EList<Identifier> frozenPorts;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DispatchConditionImpl()
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
      return AadlBaPackage.Literals.DISPATCH_CONDITION;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isHasFrozenPorts()
   {
      return hasFrozenPorts;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setHasFrozenPorts(boolean newHasFrozenPorts)
   {
      boolean oldHasFrozenPorts = hasFrozenPorts;
      hasFrozenPorts = newHasFrozenPorts;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__HAS_FROZEN_PORTS, oldHasFrozenPorts, hasFrozenPorts));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public DispatchLogicalExpression getTheDispatchLogicalExpression()
   {
      return theDispatchLogicalExpression;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetTheDispatchLogicalExpression(DispatchLogicalExpression newTheDispatchLogicalExpression, NotificationChain msgs)
   {
      DispatchLogicalExpression oldTheDispatchLogicalExpression = theDispatchLogicalExpression;
      theDispatchLogicalExpression = newTheDispatchLogicalExpression;
      boolean oldTheDispatchLogicalExpressionESet = theDispatchLogicalExpressionESet;
      theDispatchLogicalExpressionESet = true;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, oldTheDispatchLogicalExpression, newTheDispatchLogicalExpression, !oldTheDispatchLogicalExpressionESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTheDispatchLogicalExpression(DispatchLogicalExpression newTheDispatchLogicalExpression)
   {
      if (newTheDispatchLogicalExpression != theDispatchLogicalExpression)
      {
         NotificationChain msgs = null;
         if (theDispatchLogicalExpression != null)
            msgs = ((InternalEObject)theDispatchLogicalExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, null, msgs);
         if (newTheDispatchLogicalExpression != null)
            msgs = ((InternalEObject)newTheDispatchLogicalExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, null, msgs);
         msgs = basicSetTheDispatchLogicalExpression(newTheDispatchLogicalExpression, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldTheDispatchLogicalExpressionESet = theDispatchLogicalExpressionESet;
         theDispatchLogicalExpressionESet = true;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, newTheDispatchLogicalExpression, newTheDispatchLogicalExpression, !oldTheDispatchLogicalExpressionESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicUnsetTheDispatchLogicalExpression(NotificationChain msgs)
   {
      DispatchLogicalExpression oldTheDispatchLogicalExpression = theDispatchLogicalExpression;
      theDispatchLogicalExpression = null;
      boolean oldTheDispatchLogicalExpressionESet = theDispatchLogicalExpressionESet;
      theDispatchLogicalExpressionESet = false;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, oldTheDispatchLogicalExpression, null, oldTheDispatchLogicalExpressionESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetTheDispatchLogicalExpression()
   {
      if (theDispatchLogicalExpression != null)
      {
         NotificationChain msgs = null;
         msgs = ((InternalEObject)theDispatchLogicalExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, null, msgs);
         msgs = basicUnsetTheDispatchLogicalExpression(msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldTheDispatchLogicalExpressionESet = theDispatchLogicalExpressionESet;
         theDispatchLogicalExpressionESet = false;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION, null, null, oldTheDispatchLogicalExpressionESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetTheDispatchLogicalExpression()
   {
      return theDispatchLogicalExpressionESet;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Identifier> getFrozenPorts()
   {
      if (frozenPorts == null)
      {
         frozenPorts = new EObjectContainmentEList.Unsettable<Identifier>(Identifier.class, this, AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS);
      }
      return frozenPorts;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetFrozenPorts()
   {
      if (frozenPorts != null) ((InternalEList.Unsettable<?>)frozenPorts).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetFrozenPorts()
   {
      return frozenPorts != null && ((InternalEList.Unsettable<?>)frozenPorts).isSet();
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
         case AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION:
            return basicUnsetTheDispatchLogicalExpression(msgs);
         case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
            return ((InternalEList<?>)getFrozenPorts()).basicRemove(otherEnd, msgs);
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
         case AadlBaPackage.DISPATCH_CONDITION__HAS_FROZEN_PORTS:
            return isHasFrozenPorts();
         case AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION:
            return getTheDispatchLogicalExpression();
         case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
            return getFrozenPorts();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue)
   {
      switch (featureID)
      {
         case AadlBaPackage.DISPATCH_CONDITION__HAS_FROZEN_PORTS:
            setHasFrozenPorts((Boolean)newValue);
            return;
         case AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION:
            setTheDispatchLogicalExpression((DispatchLogicalExpression)newValue);
            return;
         case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
            getFrozenPorts().clear();
            getFrozenPorts().addAll((Collection<? extends Identifier>)newValue);
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
         case AadlBaPackage.DISPATCH_CONDITION__HAS_FROZEN_PORTS:
            setHasFrozenPorts(HAS_FROZEN_PORTS_EDEFAULT);
            return;
         case AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION:
            unsetTheDispatchLogicalExpression();
            return;
         case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
            unsetFrozenPorts();
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
         case AadlBaPackage.DISPATCH_CONDITION__HAS_FROZEN_PORTS:
            return hasFrozenPorts != HAS_FROZEN_PORTS_EDEFAULT;
         case AadlBaPackage.DISPATCH_CONDITION__THE_DISPATCH_LOGICAL_EXPRESSION:
            return isSetTheDispatchLogicalExpression();
         case AadlBaPackage.DISPATCH_CONDITION__FROZEN_PORTS:
            return isSetFrozenPorts();
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
      result.append(" (hasFrozenPorts: ");
      result.append(hasFrozenPorts);
      result.append(')');
      return result.toString();
   }

} //DispatchConditionImpl
