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
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getUserCategories <em>User Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getPhaseCategories <em>Phase Categories</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoriesDefinitionsImpl#getQualityCategories <em>Quality Categories</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoriesDefinitionsImpl extends MinimalEObjectImpl.Container implements CategoriesDefinitions
{
  /**
   * The cached value of the '{@link #getUserCategories() <em>User Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCategories()
   * @generated
   * @ordered
   */
  protected Categories userCategories;

  /**
   * The cached value of the '{@link #getPhaseCategories() <em>Phase Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhaseCategories()
   * @generated
   * @ordered
   */
  protected Categories phaseCategories;

  /**
   * The cached value of the '{@link #getQualityCategories() <em>Quality Categories</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityCategories()
   * @generated
   * @ordered
   */
  protected Categories qualityCategories;

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
  public Categories getUserCategories()
  {
    return userCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUserCategories(Categories newUserCategories, NotificationChain msgs)
  {
    Categories oldUserCategories = userCategories;
    userCategories = newUserCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES, oldUserCategories, newUserCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUserCategories(Categories newUserCategories)
  {
    if (newUserCategories != userCategories)
    {
      NotificationChain msgs = null;
      if (userCategories != null)
        msgs = ((InternalEObject)userCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES, null, msgs);
      if (newUserCategories != null)
        msgs = ((InternalEObject)newUserCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES, null, msgs);
      msgs = basicSetUserCategories(newUserCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES, newUserCategories, newUserCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getPhaseCategories()
  {
    return phaseCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPhaseCategories(Categories newPhaseCategories, NotificationChain msgs)
  {
    Categories oldPhaseCategories = phaseCategories;
    phaseCategories = newPhaseCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES, oldPhaseCategories, newPhaseCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhaseCategories(Categories newPhaseCategories)
  {
    if (newPhaseCategories != phaseCategories)
    {
      NotificationChain msgs = null;
      if (phaseCategories != null)
        msgs = ((InternalEObject)phaseCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES, null, msgs);
      if (newPhaseCategories != null)
        msgs = ((InternalEObject)newPhaseCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES, null, msgs);
      msgs = basicSetPhaseCategories(newPhaseCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES, newPhaseCategories, newPhaseCategories));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Categories getQualityCategories()
  {
    return qualityCategories;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQualityCategories(Categories newQualityCategories, NotificationChain msgs)
  {
    Categories oldQualityCategories = qualityCategories;
    qualityCategories = newQualityCategories;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES, oldQualityCategories, newQualityCategories);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualityCategories(Categories newQualityCategories)
  {
    if (newQualityCategories != qualityCategories)
    {
      NotificationChain msgs = null;
      if (qualityCategories != null)
        msgs = ((InternalEObject)qualityCategories).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES, null, msgs);
      if (newQualityCategories != null)
        msgs = ((InternalEObject)newQualityCategories).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES, null, msgs);
      msgs = basicSetQualityCategories(newQualityCategories, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES, newQualityCategories, newQualityCategories));
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES:
        return basicSetUserCategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES:
        return basicSetPhaseCategories(null, msgs);
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES:
        return basicSetQualityCategories(null, msgs);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES:
        return getUserCategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES:
        return getPhaseCategories();
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES:
        return getQualityCategories();
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES:
        setUserCategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES:
        setPhaseCategories((Categories)newValue);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES:
        setQualityCategories((Categories)newValue);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES:
        setUserCategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES:
        setPhaseCategories((Categories)null);
        return;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES:
        setQualityCategories((Categories)null);
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
      case CategoriesPackage.CATEGORIES_DEFINITIONS__USER_CATEGORIES:
        return userCategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__PHASE_CATEGORIES:
        return phaseCategories != null;
      case CategoriesPackage.CATEGORIES_DEFINITIONS__QUALITY_CATEGORIES:
        return qualityCategories != null;
    }
    return super.eIsSet(featureID);
  }

} //CategoriesDefinitionsImpl
