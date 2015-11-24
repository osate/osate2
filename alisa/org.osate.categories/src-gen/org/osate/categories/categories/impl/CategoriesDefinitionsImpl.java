/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getRequirementTypeCategories <em>Requirement Type Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getMethodTypeCategories <em>Method Type Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getSelectioncategories <em>Selectioncategories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getDevelopmentPhaseCategories <em>Development Phase Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getQualityAttributeCategories <em>Quality Attribute Categories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoriesDefinitionsImpl extends MinimalEObjectImpl.Container implements CategoriesDefinitions
{
  /**
   * The cached value of the '{@link #getRequirementTypeCategories() <em>Requirement Type Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementTypeCategories()
   * @generated
   * @ordered
   */
  protected Categories requirementTypeCategories;

  /**
   * The cached value of the '{@link #getMethodTypeCategories() <em>Method Type Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodTypeCategories()
   * @generated
   * @ordered
   */
  protected Categories methodTypeCategories;

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
   * The cached value of the '{@link #getDevelopmentPhaseCategories() <em>Development Phase Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDevelopmentPhaseCategories()
   * @generated
   * @ordered
   */
  protected Categories developmentPhaseCategories;

  /**
   * The cached value of the '{@link #getQualityAttributeCategories() <em>Quality Attribute Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityAttributeCategories()
   * @generated
   * @ordered
   */
  protected Categories qualityAttributeCategories;

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
  public Categories getRequirementTypeCategories()
  {
    return requirementTypeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRequirementTypeCategories(Categories newRequirementTypeCategories, NotificationChain msgs)
  {
    Categories oldRequirementTypeCategories = requirementTypeCategories;
    requirementTypeCategories = newRequirementTypeCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES, oldRequirementTypeCategories, newRequirementTypeCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequirementTypeCategories(Categories newRequirementTypeCategories)
  {
    if (newRequirementTypeCategories != requirementTypeCategories)
    {
      NotificationChain msgs = null;
      if (requirementTypeCategories != null)
        msgs = ((InternalEObject)requirementTypeCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES, null, msgs);
      if (newRequirementTypeCategories != null)
        msgs = ((InternalEObject)newRequirementTypeCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES, null, msgs);
      msgs = basicSetRequirementTypeCategories(newRequirementTypeCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES, newRequirementTypeCategories, newRequirementTypeCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getMethodTypeCategories()
  {
    return methodTypeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMethodTypeCategories(Categories newMethodTypeCategories, NotificationChain msgs)
  {
    Categories oldMethodTypeCategories = methodTypeCategories;
    methodTypeCategories = newMethodTypeCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES, oldMethodTypeCategories, newMethodTypeCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMethodTypeCategories(Categories newMethodTypeCategories)
  {
    if (newMethodTypeCategories != methodTypeCategories)
    {
      NotificationChain msgs = null;
      if (methodTypeCategories != null)
        msgs = ((InternalEObject)methodTypeCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES, null, msgs);
      if (newMethodTypeCategories != null)
        msgs = ((InternalEObject)newMethodTypeCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES, null, msgs);
      msgs = basicSetMethodTypeCategories(newMethodTypeCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES, newMethodTypeCategories, newMethodTypeCategories));
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
  public Categories getDevelopmentPhaseCategories()
  {
    return developmentPhaseCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDevelopmentPhaseCategories(Categories newDevelopmentPhaseCategories, NotificationChain msgs)
  {
    Categories oldDevelopmentPhaseCategories = developmentPhaseCategories;
    developmentPhaseCategories = newDevelopmentPhaseCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES, oldDevelopmentPhaseCategories, newDevelopmentPhaseCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDevelopmentPhaseCategories(Categories newDevelopmentPhaseCategories)
  {
    if (newDevelopmentPhaseCategories != developmentPhaseCategories)
    {
      NotificationChain msgs = null;
      if (developmentPhaseCategories != null)
        msgs = ((InternalEObject)developmentPhaseCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES, null, msgs);
      if (newDevelopmentPhaseCategories != null)
        msgs = ((InternalEObject)newDevelopmentPhaseCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES, null, msgs);
      msgs = basicSetDevelopmentPhaseCategories(newDevelopmentPhaseCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES, newDevelopmentPhaseCategories, newDevelopmentPhaseCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getQualityAttributeCategories()
  {
    return qualityAttributeCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualityAttributeCategories(Categories newQualityAttributeCategories, NotificationChain msgs)
  {
    Categories oldQualityAttributeCategories = qualityAttributeCategories;
    qualityAttributeCategories = newQualityAttributeCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES, oldQualityAttributeCategories, newQualityAttributeCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualityAttributeCategories(Categories newQualityAttributeCategories)
  {
    if (newQualityAttributeCategories != qualityAttributeCategories)
    {
      NotificationChain msgs = null;
      if (qualityAttributeCategories != null)
        msgs = ((InternalEObject)qualityAttributeCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES, null, msgs);
      if (newQualityAttributeCategories != null)
        msgs = ((InternalEObject)newQualityAttributeCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES, null, msgs);
      msgs = basicSetQualityAttributeCategories(newQualityAttributeCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES, newQualityAttributeCategories, newQualityAttributeCategories));
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES:
        return basicSetRequirementTypeCategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES:
        return basicSetMethodTypeCategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        return basicSetSelectioncategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES:
        return basicSetDevelopmentPhaseCategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES:
        return basicSetQualityAttributeCategories(null, msgs);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES:
        return getRequirementTypeCategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES:
        return getMethodTypeCategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        return getSelectioncategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES:
        return getDevelopmentPhaseCategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES:
        return getQualityAttributeCategories();
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES:
        setRequirementTypeCategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES:
        setMethodTypeCategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        setSelectioncategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES:
        setDevelopmentPhaseCategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES:
        setQualityAttributeCategories((Categories)newValue);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES:
        setRequirementTypeCategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES:
        setMethodTypeCategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        setSelectioncategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES:
        setDevelopmentPhaseCategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES:
        setQualityAttributeCategories((Categories)null);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__REQUIREMENT_TYPE_CATEGORIES:
        return requirementTypeCategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__METHOD_TYPE_CATEGORIES:
        return methodTypeCategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__SELECTIONCATEGORIES:
        return selectioncategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__DEVELOPMENT_PHASE_CATEGORIES:
        return developmentPhaseCategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_ATTRIBUTE_CATEGORIES:
        return qualityAttributeCategories != null;
    }
    return super.eIsSet(featureID);
  }

} //CategoriesDefinitionsImpl
