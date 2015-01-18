/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.categories.categories.VerificationCategory;

import org.osate.verify.verify.SelectionCategoryReference;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Category Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.verify.verify.impl.SelectionCategoryReferenceImpl#getCat <em>Cat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionCategoryReferenceImpl extends MinimalEObjectImpl.Container implements SelectionCategoryReference
{
  /**
   * The cached value of the '{@link #getCat() <em>Cat</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCat()
   * @generated
   * @ordered
   */
  protected VerificationCategory cat;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectionCategoryReferenceImpl()
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
    return VerifyPackage.Literals.SELECTION_CATEGORY_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory getCat()
  {
    if (cat != null && cat.eIsProxy())
    {
      InternalEObject oldCat = (InternalEObject)cat;
      cat = (VerificationCategory)eResolveProxy(oldCat);
      if (cat != oldCat)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, VerifyPackage.SELECTION_CATEGORY_REFERENCE__CAT, oldCat, cat));
      }
    }
    return cat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory basicGetCat()
  {
    return cat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCat(VerificationCategory newCat)
  {
    VerificationCategory oldCat = cat;
    cat = newCat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VerifyPackage.SELECTION_CATEGORY_REFERENCE__CAT, oldCat, cat));
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
      case VerifyPackage.SELECTION_CATEGORY_REFERENCE__CAT:
        if (resolve) return getCat();
        return basicGetCat();
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
      case VerifyPackage.SELECTION_CATEGORY_REFERENCE__CAT:
        setCat((VerificationCategory)newValue);
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
      case VerifyPackage.SELECTION_CATEGORY_REFERENCE__CAT:
        setCat((VerificationCategory)null);
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
      case VerifyPackage.SELECTION_CATEGORY_REFERENCE__CAT:
        return cat != null;
    }
    return super.eIsSet(featureID);
  }

} //SelectionCategoryReferenceImpl
