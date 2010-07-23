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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Component Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DataComponentReferenceImpl#getElementsNameOwned <em>Elements Name Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataComponentReferenceImpl extends ElementImpl implements DataComponentReference
{
   /**
    * The cached value of the '{@link #getElementsNameOwned() <em>Elements Name Owned</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getElementsNameOwned()
    * @generated
    * @ordered
    */
   protected EList<Name> elementsNameOwned;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected DataComponentReferenceImpl()
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
      return AadlBaPackage.Literals.DATA_COMPONENT_REFERENCE;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Name> getElementsNameOwned()
   {
      if (elementsNameOwned == null)
      {
         elementsNameOwned = new EObjectContainmentEList.Unsettable<Name>(Name.class, this, AadlBaPackage.DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED);
      }
      return elementsNameOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetElementsNameOwned()
   {
      if (elementsNameOwned != null) ((InternalEList.Unsettable<?>)elementsNameOwned).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetElementsNameOwned()
   {
      return elementsNameOwned != null && ((InternalEList.Unsettable<?>)elementsNameOwned).isSet();
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
         case AadlBaPackage.DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED:
            return ((InternalEList<?>)getElementsNameOwned()).basicRemove(otherEnd, msgs);
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
         case AadlBaPackage.DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED:
            return getElementsNameOwned();
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
         case AadlBaPackage.DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED:
            getElementsNameOwned().clear();
            getElementsNameOwned().addAll((Collection<? extends Name>)newValue);
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
         case AadlBaPackage.DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED:
            unsetElementsNameOwned();
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
         case AadlBaPackage.DATA_COMPONENT_REFERENCE__ELEMENTS_NAME_OWNED:
            return isSetElementsNameOwned();
      }
      return super.eIsSet(featureID);
   }

} //DataComponentReferenceImpl
