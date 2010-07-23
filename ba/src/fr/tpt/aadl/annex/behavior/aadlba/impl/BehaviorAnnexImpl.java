/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import edu.cmu.sei.aadl.aadl2.impl.AnnexSubclauseImpl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.Element;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Annex</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getBaReferencedEntity <em>Ba Referenced Entity</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getAadlReferencedEntity <em>Aadl Referenced Entity</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getStates <em>States</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorAnnexImpl#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorAnnexImpl extends AnnexSubclauseImpl implements BehaviorAnnex
{
   /**
    * The cached value of the '{@link #getBaReferencedEntity() <em>Ba Referenced Entity</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBaReferencedEntity()
    * @generated
    * @ordered
    */
   protected Element baReferencedEntity;

   /**
    * The cached value of the '{@link #getAadlReferencedEntity() <em>Aadl Referenced Entity</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getAadlReferencedEntity()
    * @generated
    * @ordered
    */
   protected edu.cmu.sei.aadl.aadl2.Element aadlReferencedEntity;

   /**
    * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getVariables()
    * @generated
    * @ordered
    */
   protected EList<BehaviorVariable> variables;

   /**
    * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getStates()
    * @generated
    * @ordered
    */
   protected EList<BehaviorState> states;

   /**
    * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTransitions()
    * @generated
    * @ordered
    */
   protected EList<BehaviorTransition> transitions;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected BehaviorAnnexImpl()
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
      return AadlBaPackage.Literals.BEHAVIOR_ANNEX;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Element getBaReferencedEntity()
   {
      if (baReferencedEntity != null && ((EObject)baReferencedEntity).eIsProxy())
      {
         InternalEObject oldBaReferencedEntity = (InternalEObject)baReferencedEntity;
         baReferencedEntity = (Element)eResolveProxy(oldBaReferencedEntity);
         if (baReferencedEntity != oldBaReferencedEntity)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY, oldBaReferencedEntity, baReferencedEntity));
         }
      }
      return baReferencedEntity;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Element basicGetBaReferencedEntity()
   {
      return baReferencedEntity;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBaReferencedEntity(Element newBaReferencedEntity)
   {
      Element oldBaReferencedEntity = baReferencedEntity;
      baReferencedEntity = newBaReferencedEntity;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY, oldBaReferencedEntity, baReferencedEntity));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public edu.cmu.sei.aadl.aadl2.Element getAadlReferencedEntity()
   {
      if (aadlReferencedEntity != null && ((EObject)aadlReferencedEntity).eIsProxy())
      {
         InternalEObject oldAadlReferencedEntity = (InternalEObject)aadlReferencedEntity;
         aadlReferencedEntity = (edu.cmu.sei.aadl.aadl2.Element)eResolveProxy(oldAadlReferencedEntity);
         if (aadlReferencedEntity != oldAadlReferencedEntity)
         {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY, oldAadlReferencedEntity, aadlReferencedEntity));
         }
      }
      return aadlReferencedEntity;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public edu.cmu.sei.aadl.aadl2.Element basicGetAadlReferencedEntity()
   {
      return aadlReferencedEntity;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setAadlReferencedEntity(edu.cmu.sei.aadl.aadl2.Element newAadlReferencedEntity)
   {
      edu.cmu.sei.aadl.aadl2.Element oldAadlReferencedEntity = aadlReferencedEntity;
      aadlReferencedEntity = newAadlReferencedEntity;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY, oldAadlReferencedEntity, aadlReferencedEntity));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<BehaviorVariable> getVariables()
   {
      if (variables == null)
      {
         variables = new EObjectContainmentEList.Unsettable<BehaviorVariable>(BehaviorVariable.class, this, AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES);
      }
      return variables;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetVariables()
   {
      if (variables != null) ((InternalEList.Unsettable<?>)variables).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetVariables()
   {
      return variables != null && ((InternalEList.Unsettable<?>)variables).isSet();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<BehaviorState> getStates()
   {
      if (states == null)
      {
         states = new EObjectContainmentEList.Unsettable<BehaviorState>(BehaviorState.class, this, AadlBaPackage.BEHAVIOR_ANNEX__STATES);
      }
      return states;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetStates()
   {
      if (states != null) ((InternalEList.Unsettable<?>)states).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetStates()
   {
      return states != null && ((InternalEList.Unsettable<?>)states).isSet();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<BehaviorTransition> getTransitions()
   {
      if (transitions == null)
      {
         transitions = new EObjectContainmentEList.Unsettable<BehaviorTransition>(BehaviorTransition.class, this, AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS);
      }
      return transitions;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetTransitions()
   {
      if (transitions != null) ((InternalEList.Unsettable<?>)transitions).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetTransitions()
   {
      return transitions != null && ((InternalEList.Unsettable<?>)transitions).isSet();
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
         case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
            return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
         case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
            return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
         case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
            return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
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
         case AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY:
            if (resolve) return getBaReferencedEntity();
            return basicGetBaReferencedEntity();
         case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY:
            if (resolve) return getAadlReferencedEntity();
            return basicGetAadlReferencedEntity();
         case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
            return getVariables();
         case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
            return getStates();
         case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
            return getTransitions();
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
         case AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY:
            setBaReferencedEntity((Element)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY:
            setAadlReferencedEntity((edu.cmu.sei.aadl.aadl2.Element)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
            getVariables().clear();
            getVariables().addAll((Collection<? extends BehaviorVariable>)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
            getStates().clear();
            getStates().addAll((Collection<? extends BehaviorState>)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
            getTransitions().clear();
            getTransitions().addAll((Collection<? extends BehaviorTransition>)newValue);
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
         case AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY:
            setBaReferencedEntity((Element)null);
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY:
            setAadlReferencedEntity((edu.cmu.sei.aadl.aadl2.Element)null);
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
            unsetVariables();
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
            unsetStates();
            return;
         case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
            unsetTransitions();
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
         case AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY:
            return baReferencedEntity != null;
         case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY:
            return aadlReferencedEntity != null;
         case AadlBaPackage.BEHAVIOR_ANNEX__VARIABLES:
            return isSetVariables();
         case AadlBaPackage.BEHAVIOR_ANNEX__STATES:
            return isSetStates();
         case AadlBaPackage.BEHAVIOR_ANNEX__TRANSITIONS:
            return isSetTransitions();
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
   {
      if (baseClass == Element.class)
      {
         switch (derivedFeatureID)
         {
            case AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY: return AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY;
            case AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY: return AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY;
            default: return -1;
         }
      }
      return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
   {
      if (baseClass == Element.class)
      {
         switch (baseFeatureID)
         {
            case AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY: return AadlBaPackage.BEHAVIOR_ANNEX__BA_REFERENCED_ENTITY;
            case AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY: return AadlBaPackage.BEHAVIOR_ANNEX__AADL_REFERENCED_ENTITY;
            default: return -1;
         }
      }
      return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
   }

} //BehaviorAnnexImpl
