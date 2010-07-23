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
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl#isInterrogation <em>Interrogation</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl#isCount <em>Count</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl#isFresh <em>Fresh</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl#isHasDataCptRef <em>Has Data Cpt Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ValueVariableImpl#getElementNameOwned <em>Element Name Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueVariableImpl extends ValueImpl implements ValueVariable
{
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
    * The default value of the '{@link #isInterrogation() <em>Interrogation</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isInterrogation()
    * @generated
    * @ordered
    */
   protected static final boolean INTERROGATION_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isInterrogation() <em>Interrogation</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isInterrogation()
    * @generated
    * @ordered
    */
   protected boolean interrogation = INTERROGATION_EDEFAULT;

   /**
    * The default value of the '{@link #isCount() <em>Count</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isCount()
    * @generated
    * @ordered
    */
   protected static final boolean COUNT_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isCount() <em>Count</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isCount()
    * @generated
    * @ordered
    */
   protected boolean count = COUNT_EDEFAULT;

   /**
    * The default value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isFresh()
    * @generated
    * @ordered
    */
   protected static final boolean FRESH_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isFresh()
    * @generated
    * @ordered
    */
   protected boolean fresh = FRESH_EDEFAULT;

   /**
    * The default value of the '{@link #isHasDataCptRef() <em>Has Data Cpt Ref</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasDataCptRef()
    * @generated
    * @ordered
    */
   protected static final boolean HAS_DATA_CPT_REF_EDEFAULT = false;

   /**
    * The cached value of the '{@link #isHasDataCptRef() <em>Has Data Cpt Ref</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isHasDataCptRef()
    * @generated
    * @ordered
    */
   protected boolean hasDataCptRef = HAS_DATA_CPT_REF_EDEFAULT;

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
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ValueVariableImpl()
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
      return AadlBaPackage.Literals.VALUE_VARIABLE;
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
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED, oldDataComponentReferenceOwned, newDataComponentReferenceOwned);
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
            msgs = ((InternalEObject)dataComponentReferenceOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED, null, msgs);
         if (newDataComponentReferenceOwned != null)
            msgs = ((InternalEObject)newDataComponentReferenceOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED, null, msgs);
         msgs = basicSetDataComponentReferenceOwned(newDataComponentReferenceOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED, newDataComponentReferenceOwned, newDataComponentReferenceOwned));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isInterrogation()
   {
      return interrogation;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setInterrogation(boolean newInterrogation)
   {
      boolean oldInterrogation = interrogation;
      interrogation = newInterrogation;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__INTERROGATION, oldInterrogation, interrogation));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isCount()
   {
      return count;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setCount(boolean newCount)
   {
      boolean oldCount = count;
      count = newCount;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__COUNT, oldCount, count));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isFresh()
   {
      return fresh;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setFresh(boolean newFresh)
   {
      boolean oldFresh = fresh;
      fresh = newFresh;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__FRESH, oldFresh, fresh));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isHasDataCptRef()
   {
      return hasDataCptRef;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setHasDataCptRef(boolean newHasDataCptRef)
   {
      boolean oldHasDataCptRef = hasDataCptRef;
      hasDataCptRef = newHasDataCptRef;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__HAS_DATA_CPT_REF, oldHasDataCptRef, hasDataCptRef));
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
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED, oldElementNameOwned, newElementNameOwned);
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
            msgs = ((InternalEObject)elementNameOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED, null, msgs);
         if (newElementNameOwned != null)
            msgs = ((InternalEObject)newElementNameOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED, null, msgs);
         msgs = basicSetElementNameOwned(newElementNameOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED, newElementNameOwned, newElementNameOwned));
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
         case AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED:
            return basicSetDataComponentReferenceOwned(null, msgs);
         case AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED:
            return basicSetElementNameOwned(null, msgs);
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
         case AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED:
            return getDataComponentReferenceOwned();
         case AadlBaPackage.VALUE_VARIABLE__INTERROGATION:
            return isInterrogation();
         case AadlBaPackage.VALUE_VARIABLE__COUNT:
            return isCount();
         case AadlBaPackage.VALUE_VARIABLE__FRESH:
            return isFresh();
         case AadlBaPackage.VALUE_VARIABLE__HAS_DATA_CPT_REF:
            return isHasDataCptRef();
         case AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED:
            return getElementNameOwned();
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
         case AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED:
            setDataComponentReferenceOwned((DataComponentReference)newValue);
            return;
         case AadlBaPackage.VALUE_VARIABLE__INTERROGATION:
            setInterrogation((Boolean)newValue);
            return;
         case AadlBaPackage.VALUE_VARIABLE__COUNT:
            setCount((Boolean)newValue);
            return;
         case AadlBaPackage.VALUE_VARIABLE__FRESH:
            setFresh((Boolean)newValue);
            return;
         case AadlBaPackage.VALUE_VARIABLE__HAS_DATA_CPT_REF:
            setHasDataCptRef((Boolean)newValue);
            return;
         case AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED:
            setElementNameOwned((Name)newValue);
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
         case AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED:
            setDataComponentReferenceOwned((DataComponentReference)null);
            return;
         case AadlBaPackage.VALUE_VARIABLE__INTERROGATION:
            setInterrogation(INTERROGATION_EDEFAULT);
            return;
         case AadlBaPackage.VALUE_VARIABLE__COUNT:
            setCount(COUNT_EDEFAULT);
            return;
         case AadlBaPackage.VALUE_VARIABLE__FRESH:
            setFresh(FRESH_EDEFAULT);
            return;
         case AadlBaPackage.VALUE_VARIABLE__HAS_DATA_CPT_REF:
            setHasDataCptRef(HAS_DATA_CPT_REF_EDEFAULT);
            return;
         case AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED:
            setElementNameOwned((Name)null);
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
         case AadlBaPackage.VALUE_VARIABLE__DATA_COMPONENT_REFERENCE_OWNED:
            return dataComponentReferenceOwned != null;
         case AadlBaPackage.VALUE_VARIABLE__INTERROGATION:
            return interrogation != INTERROGATION_EDEFAULT;
         case AadlBaPackage.VALUE_VARIABLE__COUNT:
            return count != COUNT_EDEFAULT;
         case AadlBaPackage.VALUE_VARIABLE__FRESH:
            return fresh != FRESH_EDEFAULT;
         case AadlBaPackage.VALUE_VARIABLE__HAS_DATA_CPT_REF:
            return hasDataCptRef != HAS_DATA_CPT_REF_EDEFAULT;
         case AadlBaPackage.VALUE_VARIABLE__ELEMENT_NAME_OWNED:
            return elementNameOwned != null;
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
      result.append(" (Interrogation: ");
      result.append(interrogation);
      result.append(", Count: ");
      result.append(count);
      result.append(", Fresh: ");
      result.append(fresh);
      result.append(", hasDataCptRef: ");
      result.append(hasDataCptRef);
      result.append(')');
      return result.toString();
   }

} //ValueVariableImpl
