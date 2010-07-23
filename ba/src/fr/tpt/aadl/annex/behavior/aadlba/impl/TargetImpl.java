/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.Name;
import fr.tpt.aadl.annex.behavior.aadlba.Target;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl#getElementNameOwned <em>Element Name Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TargetImpl#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TargetImpl extends ParameterLabelImpl implements Target
{
   /**
    * The cached value of the '{@link #getElementNameOwned() <em>Element Name Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getElementNameOwned()
    * @generated
    * @ordered
    */
   protected Name elementNameOwned;

   /**
    * The cached value of the '{@link #getDataComponentReferenceOwned() <em>Data Component Reference Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getDataComponentReferenceOwned()
    * @generated
    * @ordered
    */
   protected DataComponentReference dataComponentReferenceOwned;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected TargetImpl()
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
      return AadlBaPackage.Literals.TARGET;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Name getElementNameOwned()
   {
      return elementNameOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetElementNameOwned(Name newElementNameOwned, NotificationChain msgs)
   {
      Name oldElementNameOwned = elementNameOwned;
      elementNameOwned = newElementNameOwned;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.TARGET__ELEMENT_NAME_OWNED, oldElementNameOwned, newElementNameOwned);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setElementNameOwned(Name newElementNameOwned)
   {
      if (newElementNameOwned != elementNameOwned)
      {
         NotificationChain msgs = null;
         if (elementNameOwned != null)
            msgs = ((InternalEObject)elementNameOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TARGET__ELEMENT_NAME_OWNED, null, msgs);
         if (newElementNameOwned != null)
            msgs = ((InternalEObject)newElementNameOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TARGET__ELEMENT_NAME_OWNED, null, msgs);
         msgs = basicSetElementNameOwned(newElementNameOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.TARGET__ELEMENT_NAME_OWNED, newElementNameOwned, newElementNameOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public DataComponentReference getDataComponentReferenceOwned()
   {
      return dataComponentReferenceOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetDataComponentReferenceOwned(DataComponentReference newDataComponentReferenceOwned, NotificationChain msgs)
   {
      DataComponentReference oldDataComponentReferenceOwned = dataComponentReferenceOwned;
      dataComponentReferenceOwned = newDataComponentReferenceOwned;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED, oldDataComponentReferenceOwned, newDataComponentReferenceOwned);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setDataComponentReferenceOwned(DataComponentReference newDataComponentReferenceOwned)
   {
      if (newDataComponentReferenceOwned != dataComponentReferenceOwned)
      {
         NotificationChain msgs = null;
         if (dataComponentReferenceOwned != null)
            msgs = ((InternalEObject)dataComponentReferenceOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED, null, msgs);
         if (newDataComponentReferenceOwned != null)
            msgs = ((InternalEObject)newDataComponentReferenceOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED, null, msgs);
         msgs = basicSetDataComponentReferenceOwned(newDataComponentReferenceOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED, newDataComponentReferenceOwned, newDataComponentReferenceOwned));
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
         case AadlBaPackage.TARGET__ELEMENT_NAME_OWNED:
            return basicSetElementNameOwned(null, msgs);
         case AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED:
            return basicSetDataComponentReferenceOwned(null, msgs);
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
         case AadlBaPackage.TARGET__ELEMENT_NAME_OWNED:
            return getElementNameOwned();
         case AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED:
            return getDataComponentReferenceOwned();
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
         case AadlBaPackage.TARGET__ELEMENT_NAME_OWNED:
            setElementNameOwned((Name)newValue);
            return;
         case AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED:
            setDataComponentReferenceOwned((DataComponentReference)newValue);
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
         case AadlBaPackage.TARGET__ELEMENT_NAME_OWNED:
            setElementNameOwned((Name)null);
            return;
         case AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED:
            setDataComponentReferenceOwned((DataComponentReference)null);
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
         case AadlBaPackage.TARGET__ELEMENT_NAME_OWNED:
            return elementNameOwned != null;
         case AadlBaPackage.TARGET__DATA_COMPONENT_REFERENCE_OWNED:
            return dataComponentReferenceOwned != null;
      }
      return super.eIsSet(featureID);
   }

} //TargetImpl
