/**
 */
package org.osate.categories.categories.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.categories.categories.AssertFailCategory;
import org.osate.categories.categories.CategoriesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assert Fail Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.AssertFailCategoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.AssertFailCategoryImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssertFailCategoryImpl extends MinimalEObjectImpl.Container implements AssertFailCategory
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected AssertFailCategory extends_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssertFailCategoryImpl()
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
    return CategoriesPackage.Literals.ASSERT_FAIL_CATEGORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.ASSERT_FAIL_CATEGORY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertFailCategory getExtends()
  {
    if (extends_ != null && extends_.eIsProxy())
    {
      InternalEObject oldExtends = (InternalEObject)extends_;
      extends_ = (AssertFailCategory)eResolveProxy(oldExtends);
      if (extends_ != oldExtends)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, CategoriesPackage.ASSERT_FAIL_CATEGORY__EXTENDS, oldExtends, extends_));
      }
    }
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertFailCategory basicGetExtends()
  {
    return extends_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtends(AssertFailCategory newExtends)
  {
    AssertFailCategory oldExtends = extends_;
    extends_ = newExtends;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.ASSERT_FAIL_CATEGORY__EXTENDS, oldExtends, extends_));
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
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__NAME:
        return getName();
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__EXTENDS:
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
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__NAME:
        setName((String)newValue);
        return;
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__EXTENDS:
        setExtends((AssertFailCategory)newValue);
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
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__EXTENDS:
        setExtends((AssertFailCategory)null);
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
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CategoriesPackage.ASSERT_FAIL_CATEGORY__EXTENDS:
        return extends_ != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AssertFailCategoryImpl
