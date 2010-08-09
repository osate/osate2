/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.Element;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl#getBaReferencedEntity <em>Ba Referenced Entity</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.ElementImpl#getAadlReferencedEntity <em>Aadl Referenced Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementImpl extends edu.cmu.sei.aadl.aadl2.impl.ElementImpl implements Element
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
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ElementImpl()
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
		return AadlBaPackage.Literals.ELEMENT;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Element getBaReferencedEntity()
   {
		if (baReferencedEntity != null && ((EObject)baReferencedEntity).eIsProxy()) {
			InternalEObject oldBaReferencedEntity = (InternalEObject)baReferencedEntity;
			baReferencedEntity = (Element)eResolveProxy(oldBaReferencedEntity);
			if (baReferencedEntity != oldBaReferencedEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY, oldBaReferencedEntity, baReferencedEntity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY, oldBaReferencedEntity, baReferencedEntity));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public edu.cmu.sei.aadl.aadl2.Element getAadlReferencedEntity()
   {
		if (aadlReferencedEntity != null && ((EObject)aadlReferencedEntity).eIsProxy()) {
			InternalEObject oldAadlReferencedEntity = (InternalEObject)aadlReferencedEntity;
			aadlReferencedEntity = (edu.cmu.sei.aadl.aadl2.Element)eResolveProxy(oldAadlReferencedEntity);
			if (aadlReferencedEntity != oldAadlReferencedEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY, oldAadlReferencedEntity, aadlReferencedEntity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY, oldAadlReferencedEntity, aadlReferencedEntity));
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
			case AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY:
				if (resolve) return getBaReferencedEntity();
				return basicGetBaReferencedEntity();
			case AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY:
				if (resolve) return getAadlReferencedEntity();
				return basicGetAadlReferencedEntity();
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
			case AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY:
				setBaReferencedEntity((Element)newValue);
				return;
			case AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY:
				setAadlReferencedEntity((edu.cmu.sei.aadl.aadl2.Element)newValue);
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
			case AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY:
				setBaReferencedEntity((Element)null);
				return;
			case AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY:
				setAadlReferencedEntity((edu.cmu.sei.aadl.aadl2.Element)null);
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
			case AadlBaPackage.ELEMENT__BA_REFERENCED_ENTITY:
				return baReferencedEntity != null;
			case AadlBaPackage.ELEMENT__AADL_REFERENCED_ENTITY:
				return aadlReferencedEntity != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementImpl
