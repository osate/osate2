/**
 */
package org.osate.categories.categories.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.VerificationCategory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Verification Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.VerificationCategoryImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VerificationCategoryImpl extends CategoryImpl implements VerificationCategory
{
  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected VerificationCategory extends_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VerificationCategoryImpl()
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
    return CategoriesPackage.Literals.VERIFICATION_CATEGORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (VerificationCategory)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CategoriesPackage.VERIFICATION_CATEGORY__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VerificationCategory basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(VerificationCategory newExtends)
  {
    VerificationCategory oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.VERIFICATION_CATEGORY__EXTENDS, oldExtends, extends_));
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
      case CategoriesPackage.VERIFICATION_CATEGORY__EXTENDS:
        if (resolve) return getExtends();
        return basicGetExtends();
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
      case CategoriesPackage.VERIFICATION_CATEGORY__EXTENDS:
        setExtends((VerificationCategory)newValue);
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
      case CategoriesPackage.VERIFICATION_CATEGORY__EXTENDS:
        setExtends((VerificationCategory)null);
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
      case CategoriesPackage.VERIFICATION_CATEGORY__EXTENDS:
        return extends_ != null;
    }
    return super.eIsSet(featureID);
  }

} //VerificationCategoryImpl
