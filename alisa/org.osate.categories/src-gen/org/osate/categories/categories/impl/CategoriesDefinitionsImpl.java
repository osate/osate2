/**
 */
package org.osate.categories.categories.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesDefinitions;
import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilters;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getRequirementcategories <em>Requirementcategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getComponentcategories <em>Componentcategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getMethodcategories <em>Methodcategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getSelectioncategories <em>Selectioncategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getPhasecategories <em>Phasecategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getQualitycategories <em>Qualitycategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getCategoryfilter <em>Categoryfilter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoriesDefinitionsImpl extends MinimalEObjectImpl.Container implements CategoriesDefinitions
{
  /**
   * The cached value of the '{@link #getRequirementcategories() <em>Requirementcategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementcategories()
   * @generated
   * @ordered
   */
  protected Categories requirementcategories;

  /**
   * The cached value of the '{@link #getComponentcategories() <em>Componentcategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getComponentcategories()
   * @generated
   * @ordered
   */
  protected Categories componentcategories;

  /**
   * The cached value of the '{@link #getMethodcategories() <em>Methodcategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodcategories()
   * @generated
   * @ordered
   */
  protected Categories methodcategories;

  /**
   * The cached value of the '{@link #getSelectioncategories() <em>Selectioncategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelectioncategories()
   * @generated
   * @ordered
   */
  protected Categories selectioncategories;

  /**
   * The cached value of the '{@link #getPhasecategories() <em>Phasecategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhasecategories()
   * @generated
   * @ordered
   */
  protected Categories phasecategories;

  /**
   * The cached value of the '{@link #getQualitycategories() <em>Qualitycategories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualitycategories()
   * @generated
   * @ordered
   */
  protected Categories qualitycategories;

  /**
   * The cached value of the '{@link #getCategoryfilter() <em>Categoryfilter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCategoryfilter()
   * @generated
   * @ordered
   */
  protected CategoryFilters categoryfilter;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CategoriesDefinitionsImpl()
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
    return CategoriesPackage.Literals.CATEGORIES_DEFINITIONS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getRequirementcategories()
  {
    return requirementcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRequirementcategories(Categories newRequirementcategories, NotificationChain msgs)
  {
    Categories oldRequirementcategories = requirementcategories;
    requirementcategories = newRequirementcategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES, oldRequirementcategories, newRequirementcategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirementcategories(Categories newRequirementcategories)
  {
    if (newRequirementcategories != requirementcategories)
    {
      NotificationChain msgs = null;
      if (requirementcategories != null)
        msgs = ((InternalEObject)requirementcategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES, null, msgs);
      if (newRequirementcategories != null)
        msgs = ((InternalEObject)newRequirementcategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES, null, msgs);
      msgs = basicSetRequirementcategories(newRequirementcategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES, newRequirementcategories, newRequirementcategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getComponentcategories()
  {
    return componentcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetComponentcategories(Categories newComponentcategories, NotificationChain msgs)
  {
    Categories oldComponentcategories = componentcategories;
    componentcategories = newComponentcategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES, oldComponentcategories, newComponentcategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setComponentcategories(Categories newComponentcategories)
  {
    if (newComponentcategories != componentcategories)
    {
      NotificationChain msgs = null;
      if (componentcategories != null)
        msgs = ((InternalEObject)componentcategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES, null, msgs);
      if (newComponentcategories != null)
        msgs = ((InternalEObject)newComponentcategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES, null, msgs);
      msgs = basicSetComponentcategories(newComponentcategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES, newComponentcategories, newComponentcategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getMethodcategories()
  {
    return methodcategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethodcategories(Categories newMethodcategories, NotificationChain msgs)
  {
    Categories oldMethodcategories = methodcategories;
    methodcategories = newMethodcategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES, oldMethodcategories, newMethodcategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodcategories(Categories newMethodcategories)
  {
    if (newMethodcategories != methodcategories)
    {
      NotificationChain msgs = null;
      if (methodcategories != null)
        msgs = ((InternalEObject)methodcategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES, null, msgs);
      if (newMethodcategories != null)
        msgs = ((InternalEObject)newMethodcategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES, null, msgs);
      msgs = basicSetMethodcategories(newMethodcategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES, newMethodcategories, newMethodcategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getSelectioncategories()
  {
    return selectioncategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSelectioncategories(Categories newSelectioncategories, NotificationChain msgs)
  {
    Categories oldSelectioncategories = selectioncategories;
    selectioncategories = newSelectioncategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES, oldSelectioncategories, newSelectioncategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelectioncategories(Categories newSelectioncategories)
  {
    if (newSelectioncategories != selectioncategories)
    {
      NotificationChain msgs = null;
      if (selectioncategories != null)
        msgs = ((InternalEObject)selectioncategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES, null, msgs);
      if (newSelectioncategories != null)
        msgs = ((InternalEObject)newSelectioncategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES, null, msgs);
      msgs = basicSetSelectioncategories(newSelectioncategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES, newSelectioncategories, newSelectioncategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getPhasecategories()
  {
    return phasecategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPhasecategories(Categories newPhasecategories, NotificationChain msgs)
  {
    Categories oldPhasecategories = phasecategories;
    phasecategories = newPhasecategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES, oldPhasecategories, newPhasecategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhasecategories(Categories newPhasecategories)
  {
    if (newPhasecategories != phasecategories)
    {
      NotificationChain msgs = null;
      if (phasecategories != null)
        msgs = ((InternalEObject)phasecategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES, null, msgs);
      if (newPhasecategories != null)
        msgs = ((InternalEObject)newPhasecategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES, null, msgs);
      msgs = basicSetPhasecategories(newPhasecategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES, newPhasecategories, newPhasecategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getQualitycategories()
  {
    return qualitycategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualitycategories(Categories newQualitycategories, NotificationChain msgs)
  {
    Categories oldQualitycategories = qualitycategories;
    qualitycategories = newQualitycategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES, oldQualitycategories, newQualitycategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualitycategories(Categories newQualitycategories)
  {
    if (newQualitycategories != qualitycategories)
    {
      NotificationChain msgs = null;
      if (qualitycategories != null)
        msgs = ((InternalEObject)qualitycategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES, null, msgs);
      if (newQualitycategories != null)
        msgs = ((InternalEObject)newQualitycategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES, null, msgs);
      msgs = basicSetQualitycategories(newQualitycategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES, newQualitycategories, newQualitycategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategoryFilters getCategoryfilter()
  {
    return categoryfilter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCategoryfilter(CategoryFilters newCategoryfilter, NotificationChain msgs)
  {
    CategoryFilters oldCategoryfilter = categoryfilter;
    categoryfilter = newCategoryfilter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER, oldCategoryfilter, newCategoryfilter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCategoryfilter(CategoryFilters newCategoryfilter)
  {
    if (newCategoryfilter != categoryfilter)
    {
      NotificationChain msgs = null;
      if (categoryfilter != null)
        msgs = ((InternalEObject)categoryfilter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER, null, msgs);
      if (newCategoryfilter != null)
        msgs = ((InternalEObject)newCategoryfilter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER, null, msgs);
      msgs = basicSetCategoryfilter(newCategoryfilter, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER, newCategoryfilter, newCategoryfilter));
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES:
        return basicSetRequirementcategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES:
        return basicSetComponentcategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES:
        return basicSetMethodcategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        return basicSetSelectioncategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES:
        return basicSetPhasecategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES:
        return basicSetQualitycategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER:
        return basicSetCategoryfilter(null, msgs);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES:
        return getRequirementcategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES:
        return getComponentcategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES:
        return getMethodcategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        return getSelectioncategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES:
        return getPhasecategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES:
        return getQualitycategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER:
        return getCategoryfilter();
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES:
        setRequirementcategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES:
        setComponentcategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES:
        setMethodcategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        setSelectioncategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES:
        setPhasecategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES:
        setQualitycategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER:
        setCategoryfilter((CategoryFilters)newValue);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES:
        setRequirementcategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES:
        setComponentcategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES:
        setMethodcategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        setSelectioncategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES:
        setPhasecategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES:
        setQualitycategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER:
        setCategoryfilter((CategoryFilters)null);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENTCATEGORIES:
        return requirementcategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__COMPONENTCATEGORIES:
        return componentcategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHODCATEGORIES:
        return methodcategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        return selectioncategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASECATEGORIES:
        return phasecategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITYCATEGORIES:
        return qualitycategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__CATEGORYFILTER:
        return categoryfilter != null;
    }
    return super.eIsSet(featureID);
  }

} //CategoriesDefinitionsImpl
