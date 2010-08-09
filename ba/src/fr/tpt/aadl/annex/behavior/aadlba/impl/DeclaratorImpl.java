/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.ArraySize;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Declarator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DeclaratorImpl#getArraySizes <em>Array Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeclaratorImpl extends NamedElementImpl implements Declarator
{
   /**
	 * The cached value of the '{@link #getArraySizes() <em>Array Sizes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getArraySizes()
	 * @generated
	 * @ordered
	 */
   protected EList<ArraySize> arraySizes;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected DeclaratorImpl()
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
		return AadlBaPackage.Literals.DECLARATOR;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<ArraySize> getArraySizes()
   {
		if (arraySizes == null) {
			arraySizes = new EObjectContainmentEList.Unsettable<ArraySize>(ArraySize.class, this, AadlBaPackage.DECLARATOR__ARRAY_SIZES);
		}
		return arraySizes;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetArraySizes()
   {
		if (arraySizes != null) ((InternalEList.Unsettable<?>)arraySizes).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetArraySizes()
   {
		return arraySizes != null && ((InternalEList.Unsettable<?>)arraySizes).isSet();
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
			case AadlBaPackage.DECLARATOR__ARRAY_SIZES:
				return ((InternalEList<?>)getArraySizes()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.DECLARATOR__ARRAY_SIZES:
				return getArraySizes();
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
			case AadlBaPackage.DECLARATOR__ARRAY_SIZES:
				getArraySizes().clear();
				getArraySizes().addAll((Collection<? extends ArraySize>)newValue);
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
			case AadlBaPackage.DECLARATOR__ARRAY_SIZES:
				unsetArraySizes();
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
			case AadlBaPackage.DECLARATOR__ARRAY_SIZES:
				return isSetArraySizes();
		}
		return super.eIsSet(featureID);
	}

} //DeclaratorImpl
