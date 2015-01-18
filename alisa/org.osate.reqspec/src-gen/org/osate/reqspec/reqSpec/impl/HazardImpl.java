/**
 */
package org.osate.reqspec.reqSpec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.categories.categories.HazardCategory;

import org.osate.reqspec.reqSpec.Hazard;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hazard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.HazardImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.impl.HazardImpl#getHazardReference <em>Hazard Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HazardImpl extends ContractualElementImpl implements Hazard
{
  /**
   * The cached value of the '{@link #getCategory() <em>Category</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategory()
   * @generated
   * @ordered
   */
  protected HazardCategory category;

  /**
   * The cached value of the '{@link #getHazardReference() <em>Hazard Reference</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHazardReference()
   * @generated
   * @ordered
   */
  protected EList<Requirement> hazardReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HazardImpl()
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
    return ReqSpecPackage.Literals.HAZARD;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HazardCategory getCategory()
  {
    if (category != null && category.eIsProxy())
    {
      InternalEObject oldCategory = (InternalEObject)category;
      category = (HazardCategory)eResolveProxy(oldCategory);
      if (category != oldCategory)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReqSpecPackage.HAZARD__CATEGORY, oldCategory, category));
      }
    }
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HazardCategory basicGetCategory()
  {
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategory(HazardCategory newCategory)
  {
    HazardCategory oldCategory = category;
    category = newCategory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReqSpecPackage.HAZARD__CATEGORY, oldCategory, category));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Requirement> getHazardReference()
  {
    if (hazardReference == null)
    {
      hazardReference = new EObjectResolvingEList<Requirement>(Requirement.class, this, ReqSpecPackage.HAZARD__HAZARD_REFERENCE);
    }
    return hazardReference;
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
      case ReqSpecPackage.HAZARD__CATEGORY:
        if (resolve) return getCategory();
        return basicGetCategory();
      case ReqSpecPackage.HAZARD__HAZARD_REFERENCE:
        return getHazardReference();
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
      case ReqSpecPackage.HAZARD__CATEGORY:
        setCategory((HazardCategory)newValue);
        return;
      case ReqSpecPackage.HAZARD__HAZARD_REFERENCE:
        getHazardReference().clear();
        getHazardReference().addAll((Collection<? extends Requirement>)newValue);
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
      case ReqSpecPackage.HAZARD__CATEGORY:
        setCategory((HazardCategory)null);
        return;
      case ReqSpecPackage.HAZARD__HAZARD_REFERENCE:
        getHazardReference().clear();
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
      case ReqSpecPackage.HAZARD__CATEGORY:
        return category != null;
      case ReqSpecPackage.HAZARD__HAZARD_REFERENCE:
        return hazardReference != null && !hazardReference.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //HazardImpl
