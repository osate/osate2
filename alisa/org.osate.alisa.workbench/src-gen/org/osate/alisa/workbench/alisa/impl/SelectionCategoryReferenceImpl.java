/**
 */
package org.osate.alisa.workbench.alisa.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.SelectionCategoryReference;

import org.osate.categories.categories.VerificationCategory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Category Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.impl.SelectionCategoryReferenceImpl#getCat <em>Cat</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionCategoryReferenceImpl extends SelectionConditionExprImpl implements SelectionCategoryReference
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
    return AlisaPackage.Literals.SELECTION_CATEGORY_REFERENCE;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, AlisaPackage.SELECTION_CATEGORY_REFERENCE__CAT, oldCat, cat));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlisaPackage.SELECTION_CATEGORY_REFERENCE__CAT, oldCat, cat));
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
      case AlisaPackage.SELECTION_CATEGORY_REFERENCE__CAT:
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
      case AlisaPackage.SELECTION_CATEGORY_REFERENCE__CAT:
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
      case AlisaPackage.SELECTION_CATEGORY_REFERENCE__CAT:
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
      case AlisaPackage.SELECTION_CATEGORY_REFERENCE__CAT:
        return cat != null;
    }
    return super.eIsSet(featureID);
  }

} //SelectionCategoryReferenceImpl
