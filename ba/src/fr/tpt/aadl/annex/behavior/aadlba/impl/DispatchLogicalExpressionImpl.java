/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger;

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
 * An implementation of the model object '<em><b>Dispatch Logical Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl#isOrExpression <em>Or Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl#isAndExpression <em>And Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl#isXorExpression <em>Xor Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchLogicalExpressionImpl#isStop <em>Stop</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchLogicalExpressionImpl extends ElementImpl implements DispatchLogicalExpression
{
   /**
    * The cached value of the '{@link #getDispatchTriggers() <em>Dispatch Triggers</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getDispatchTriggers()
    * @generated
    * @ordered
    */
   protected EList<DispatchTrigger> dispatchTriggers;

   /**
    * The default value of the '{@link #isOrExpression() <em>Or Expression</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isOrExpression()
    * @generated
    * @ordered
    */
   protected static final boolean OR_EXPRESSION_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isOrExpression() <em>Or Expression</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isOrExpression()
    * @generated
    * @ordered
    */
   protected boolean orExpression = OR_EXPRESSION_EDEFAULT;

   /**
    * The default value of the '{@link #isAndExpression() <em>And Expression</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isAndExpression()
    * @generated
    * @ordered
    */
   protected static final boolean AND_EXPRESSION_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isAndExpression() <em>And Expression</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isAndExpression()
    * @generated
    * @ordered
    */
   protected boolean andExpression = AND_EXPRESSION_EDEFAULT;

   /**
    * The default value of the '{@link #isXorExpression() <em>Xor Expression</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isXorExpression()
    * @generated
    * @ordered
    */
   protected static final boolean XOR_EXPRESSION_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isXorExpression() <em>Xor Expression</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isXorExpression()
    * @generated
    * @ordered
    */
   protected boolean xorExpression = XOR_EXPRESSION_EDEFAULT;

   /**
    * The default value of the '{@link #isStop() <em>Stop</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isStop()
    * @generated
    * @ordered
    */
   protected static final boolean STOP_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isStop() <em>Stop</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isStop()
    * @generated
    * @ordered
    */
   protected boolean stop = STOP_EDEFAULT;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DispatchLogicalExpressionImpl()
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
      return AadlBaPackage.Literals.DISPATCH_LOGICAL_EXPRESSION;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<DispatchTrigger> getDispatchTriggers()
   {
      if (dispatchTriggers == null)
      {
         dispatchTriggers = new EObjectContainmentEList.Unsettable<DispatchTrigger>(DispatchTrigger.class, this, AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS);
      }
      return dispatchTriggers;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetDispatchTriggers()
   {
      if (dispatchTriggers != null) ((InternalEList.Unsettable<?>)dispatchTriggers).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetDispatchTriggers()
   {
      return dispatchTriggers != null && ((InternalEList.Unsettable<?>)dispatchTriggers).isSet();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isOrExpression()
   {
      return orExpression;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setOrExpression(boolean newOrExpression)
   {
      boolean oldOrExpression = orExpression;
      orExpression = newOrExpression;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION, oldOrExpression, orExpression));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isAndExpression()
   {
      return andExpression;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setAndExpression(boolean newAndExpression)
   {
      boolean oldAndExpression = andExpression;
      andExpression = newAndExpression;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION, oldAndExpression, andExpression));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isXorExpression()
   {
      return xorExpression;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setXorExpression(boolean newXorExpression)
   {
      boolean oldXorExpression = xorExpression;
      xorExpression = newXorExpression;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION, oldXorExpression, xorExpression));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isStop()
   {
      return stop;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setStop(boolean newStop)
   {
      boolean oldStop = stop;
      stop = newStop;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__STOP, oldStop, stop));
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
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS:
            return ((InternalEList<?>)getDispatchTriggers()).basicRemove(otherEnd, msgs);
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
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS:
            return getDispatchTriggers();
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION:
            return isOrExpression();
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION:
            return isAndExpression();
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION:
            return isXorExpression();
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__STOP:
            return isStop();
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
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS:
            getDispatchTriggers().clear();
            getDispatchTriggers().addAll((Collection<? extends DispatchTrigger>)newValue);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION:
            setOrExpression((Boolean)newValue);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION:
            setAndExpression((Boolean)newValue);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION:
            setXorExpression((Boolean)newValue);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__STOP:
            setStop((Boolean)newValue);
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
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS:
            unsetDispatchTriggers();
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION:
            setOrExpression(OR_EXPRESSION_EDEFAULT);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION:
            setAndExpression(AND_EXPRESSION_EDEFAULT);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION:
            setXorExpression(XOR_EXPRESSION_EDEFAULT);
            return;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__STOP:
            setStop(STOP_EDEFAULT);
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
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__DISPATCH_TRIGGERS:
            return isSetDispatchTriggers();
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__OR_EXPRESSION:
            return orExpression != OR_EXPRESSION_EDEFAULT;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__AND_EXPRESSION:
            return andExpression != AND_EXPRESSION_EDEFAULT;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__XOR_EXPRESSION:
            return xorExpression != XOR_EXPRESSION_EDEFAULT;
         case AadlBaPackage.DISPATCH_LOGICAL_EXPRESSION__STOP:
            return stop != STOP_EDEFAULT;
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
      result.append(" (OrExpression: ");
      result.append(orExpression);
      result.append(", AndExpression: ");
      result.append(andExpression);
      result.append(", XorExpression: ");
      result.append(xorExpression);
      result.append(", Stop: ");
      result.append(stop);
      result.append(')');
      return result.toString();
   }

} //DispatchLogicalExpressionImpl
