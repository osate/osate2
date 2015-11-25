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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.categories.categories.CategoriesPackage;
import org.osate.categories.categories.CategoryFilter;
import org.osate.categories.categories.PhaseCategory;
import org.osate.categories.categories.QualityCategory;
import org.osate.categories.categories.UserCategory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getUserCategory <em>User Category</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyUserSelection <em>Any User Selection</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getQualityCategory <em>Quality Category</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyQualityAttribute <em>Any Quality Attribute</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getPhaseCategory <em>Phase Category</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyDevelopmentPhase <em>Any Development Phase</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CategoryFilterImpl extends MinimalEObjectImpl.Container implements CategoryFilter
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
   * The cached value of the '{@link #getUserCategory() <em>User Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserCategory()
   * @generated
   * @ordered
   */
  protected EList<UserCategory> userCategory;

  /**
   * The default value of the '{@link #isAnyUserSelection() <em>Any User Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyUserSelection()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_USER_SELECTION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyUserSelection() <em>Any User Selection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyUserSelection()
   * @generated
   * @ordered
   */
  protected boolean anyUserSelection = ANY_USER_SELECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getQualityCategory() <em>Quality Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityCategory()
   * @generated
   * @ordered
   */
  protected EList<QualityCategory> qualityCategory;

  /**
   * The default value of the '{@link #isAnyQualityAttribute() <em>Any Quality Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyQualityAttribute()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_QUALITY_ATTRIBUTE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyQualityAttribute() <em>Any Quality Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyQualityAttribute()
   * @generated
   * @ordered
   */
  protected boolean anyQualityAttribute = ANY_QUALITY_ATTRIBUTE_EDEFAULT;

  /**
   * The cached value of the '{@link #getPhaseCategory() <em>Phase Category</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhaseCategory()
   * @generated
   * @ordered
   */
  protected EList<PhaseCategory> phaseCategory;

  /**
   * The default value of the '{@link #isAnyDevelopmentPhase() <em>Any Development Phase</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyDevelopmentPhase()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_DEVELOPMENT_PHASE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyDevelopmentPhase() <em>Any Development Phase</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyDevelopmentPhase()
   * @generated
   * @ordered
   */
  protected boolean anyDevelopmentPhase = ANY_DEVELOPMENT_PHASE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CategoryFilterImpl()
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
    return CategoriesPackage.Literals.CATEGORY_FILTER;
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
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORY_FILTER__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UserCategory> getUserCategory()
  {
    if (userCategory == null)
    {
      userCategory = new EObjectResolvingEList<UserCategory>(UserCategory.class, this, CategoriesPackage.CATEGORY_FILTER__USER_CATEGORY);
    }
    return userCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyUserSelection()
  {
    return anyUserSelection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyUserSelection(boolean newAnyUserSelection)
  {
    boolean oldAnyUserSelection = anyUserSelection;
    anyUserSelection = newAnyUserSelection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION, oldAnyUserSelection, anyUserSelection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<QualityCategory> getQualityCategory()
  {
    if (qualityCategory == null)
    {
      qualityCategory = new EObjectResolvingEList<QualityCategory>(QualityCategory.class, this, CategoriesPackage.CATEGORY_FILTER__QUALITY_CATEGORY);
    }
    return qualityCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyQualityAttribute()
  {
    return anyQualityAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyQualityAttribute(boolean newAnyQualityAttribute)
  {
    boolean oldAnyQualityAttribute = anyQualityAttribute;
    anyQualityAttribute = newAnyQualityAttribute;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE, oldAnyQualityAttribute, anyQualityAttribute));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PhaseCategory> getPhaseCategory()
  {
    if (phaseCategory == null)
    {
      phaseCategory = new EObjectResolvingEList<PhaseCategory>(PhaseCategory.class, this, CategoriesPackage.CATEGORY_FILTER__PHASE_CATEGORY);
    }
    return phaseCategory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyDevelopmentPhase()
  {
    return anyDevelopmentPhase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyDevelopmentPhase(boolean newAnyDevelopmentPhase)
  {
    boolean oldAnyDevelopmentPhase = anyDevelopmentPhase;
    anyDevelopmentPhase = newAnyDevelopmentPhase;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE, oldAnyDevelopmentPhase, anyDevelopmentPhase));
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
      case CategoriesPackage.CATEGORY_FILTER__NAME:
        return getName();
      case CategoriesPackage.CATEGORY_FILTER__USER_CATEGORY:
        return getUserCategory();
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        return isAnyUserSelection();
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_CATEGORY:
        return getQualityCategory();
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        return isAnyQualityAttribute();
      case CategoriesPackage.CATEGORY_FILTER__PHASE_CATEGORY:
        return getPhaseCategory();
      case CategoriesPackage.CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE:
        return isAnyDevelopmentPhase();
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
      case CategoriesPackage.CATEGORY_FILTER__NAME:
        setName((String)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__USER_CATEGORY:
        getUserCategory().clear();
        getUserCategory().addAll((Collection<? extends UserCategory>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        setAnyUserSelection((Boolean)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_CATEGORY:
        getQualityCategory().clear();
        getQualityCategory().addAll((Collection<? extends QualityCategory>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        setAnyQualityAttribute((Boolean)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__PHASE_CATEGORY:
        getPhaseCategory().clear();
        getPhaseCategory().addAll((Collection<? extends PhaseCategory>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE:
        setAnyDevelopmentPhase((Boolean)newValue);
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
      case CategoriesPackage.CATEGORY_FILTER__NAME:
        setName(NAME_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__USER_CATEGORY:
        getUserCategory().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        setAnyUserSelection(ANY_USER_SELECTION_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_CATEGORY:
        getQualityCategory().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        setAnyQualityAttribute(ANY_QUALITY_ATTRIBUTE_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__PHASE_CATEGORY:
        getPhaseCategory().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE:
        setAnyDevelopmentPhase(ANY_DEVELOPMENT_PHASE_EDEFAULT);
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
      case CategoriesPackage.CATEGORY_FILTER__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case CategoriesPackage.CATEGORY_FILTER__USER_CATEGORY:
        return userCategory != null && !userCategory.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        return anyUserSelection != ANY_USER_SELECTION_EDEFAULT;
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_CATEGORY:
        return qualityCategory != null && !qualityCategory.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        return anyQualityAttribute != ANY_QUALITY_ATTRIBUTE_EDEFAULT;
      case CategoriesPackage.CATEGORY_FILTER__PHASE_CATEGORY:
        return phaseCategory != null && !phaseCategory.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE:
        return anyDevelopmentPhase != ANY_DEVELOPMENT_PHASE_EDEFAULT;
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
    result.append(", anyUserSelection: ");
    result.append(anyUserSelection);
    result.append(", anyQualityAttribute: ");
    result.append(anyQualityAttribute);
    result.append(", anyDevelopmentPhase: ");
    result.append(anyDevelopmentPhase);
    result.append(')');
    return result.toString();
  }

} //CategoryFilterImpl
