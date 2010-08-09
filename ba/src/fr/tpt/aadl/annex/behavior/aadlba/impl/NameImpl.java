/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.Name;

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
 * An implementation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl#getArrayIndexListOwned <em>Array Index List Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NameImpl#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameImpl extends NamedElementImpl implements Name
{
   /**
	 * The cached value of the '{@link #getArrayIndexListOwned() <em>Array Index List Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getArrayIndexListOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<ArrayIndex> arrayIndexListOwned;

   /**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
   protected Identifier identifier;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected NameImpl()
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
		return AadlBaPackage.Literals.NAME;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<ArrayIndex> getArrayIndexListOwned()
   {
		if (arrayIndexListOwned == null) {
			arrayIndexListOwned = new EObjectContainmentEList.Unsettable<ArrayIndex>(ArrayIndex.class, this, AadlBaPackage.NAME__ARRAY_INDEX_LIST_OWNED);
		}
		return arrayIndexListOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetArrayIndexListOwned()
   {
		if (arrayIndexListOwned != null) ((InternalEList.Unsettable<?>)arrayIndexListOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetArrayIndexListOwned()
   {
		return arrayIndexListOwned != null && ((InternalEList.Unsettable<?>)arrayIndexListOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Identifier getIdentifier()
   {
		return identifier;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetIdentifier(Identifier newIdentifier, NotificationChain msgs)
   {
		Identifier oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.NAME__IDENTIFIER, oldIdentifier, newIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setIdentifier(Identifier newIdentifier)
   {
		if (newIdentifier != identifier) {
			NotificationChain msgs = null;
			if (identifier != null)
				msgs = ((InternalEObject)identifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.NAME__IDENTIFIER, null, msgs);
			if (newIdentifier != null)
				msgs = ((InternalEObject)newIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.NAME__IDENTIFIER, null, msgs);
			msgs = basicSetIdentifier(newIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.NAME__IDENTIFIER, newIdentifier, newIdentifier));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
		switch (featureID) {
			case AadlBaPackage.NAME__ARRAY_INDEX_LIST_OWNED:
				return ((InternalEList<?>)getArrayIndexListOwned()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.NAME__IDENTIFIER:
				return basicSetIdentifier(null, msgs);
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
		switch (featureID) {
			case AadlBaPackage.NAME__ARRAY_INDEX_LIST_OWNED:
				return getArrayIndexListOwned();
			case AadlBaPackage.NAME__IDENTIFIER:
				return getIdentifier();
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
		switch (featureID) {
			case AadlBaPackage.NAME__ARRAY_INDEX_LIST_OWNED:
				getArrayIndexListOwned().clear();
				getArrayIndexListOwned().addAll((Collection<? extends ArrayIndex>)newValue);
				return;
			case AadlBaPackage.NAME__IDENTIFIER:
				setIdentifier((Identifier)newValue);
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
			case AadlBaPackage.NAME__ARRAY_INDEX_LIST_OWNED:
				unsetArrayIndexListOwned();
				return;
			case AadlBaPackage.NAME__IDENTIFIER:
				setIdentifier((Identifier)null);
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
			case AadlBaPackage.NAME__ARRAY_INDEX_LIST_OWNED:
				return isSetArrayIndexListOwned();
			case AadlBaPackage.NAME__IDENTIFIER:
				return identifier != null;
		}
		return super.eIsSet(featureID);
	}

} //NameImpl
