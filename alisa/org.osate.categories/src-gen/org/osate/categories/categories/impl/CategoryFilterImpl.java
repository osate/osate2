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
import org.osate.categories.categories.DevelopmentPhase;
import org.osate.categories.categories.MethodType;
import org.osate.categories.categories.QualityAttribute;
import org.osate.categories.categories.RequirementType;
import org.osate.categories.categories.UserSelection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Category Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getRequirementType <em>Requirement Type</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyRequirementType <em>Any Requirement Type</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getMethodType <em>Method Type</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyMethodType <em>Any Method Type</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getUserSelection <em>User Selection</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyUserSelection <em>Any User Selection</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getQualityAttribute <em>Quality Attribute</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#isAnyQualityAttribute <em>Any Quality Attribute</em>}</li>
 *   <li>{@link org.osate.categories.categories.impl.CategoryFilterImpl#getDevelopmentPhase <em>Development Phase</em>}</li>
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
   * The cached value of the '{@link #getRequirementType() <em>Requirement Type</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequirementType()
   * @generated
   * @ordered
   */
  protected EList<RequirementType> requirementType;

  /**
   * The default value of the '{@link #isAnyRequirementType() <em>Any Requirement Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyRequirementType()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_REQUIREMENT_TYPE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyRequirementType() <em>Any Requirement Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyRequirementType()
   * @generated
   * @ordered
   */
  protected boolean anyRequirementType = ANY_REQUIREMENT_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getMethodType() <em>Method Type</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMethodType()
   * @generated
   * @ordered
   */
  protected EList<MethodType> methodType;

  /**
   * The default value of the '{@link #isAnyMethodType() <em>Any Method Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyMethodType()
   * @generated
   * @ordered
   */
  protected static final boolean ANY_METHOD_TYPE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnyMethodType() <em>Any Method Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnyMethodType()
   * @generated
   * @ordered
   */
  protected boolean anyMethodType = ANY_METHOD_TYPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getUserSelection() <em>User Selection</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUserSelection()
   * @generated
   * @ordered
   */
  protected EList<UserSelection> userSelection;

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
   * The cached value of the '{@link #getQualityAttribute() <em>Quality Attribute</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityAttribute()
   * @generated
   * @ordered
   */
  protected EList<QualityAttribute> qualityAttribute;

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
   * The cached value of the '{@link #getDevelopmentPhase() <em>Development Phase</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDevelopmentPhase()
   * @generated
   * @ordered
   */
  protected EList<DevelopmentPhase> developmentPhase;

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
  public EList<RequirementType> getRequirementType()
  {
    if (requirementType == null)
    {
      requirementType = new EObjectResolvingEList<RequirementType>(RequirementType.class, this, CategoriesPackage.CATEGORY_FILTER__REQUIREMENT_TYPE);
    }
    return requirementType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyRequirementType()
  {
    return anyRequirementType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyRequirementType(boolean newAnyRequirementType)
  {
    boolean oldAnyRequirementType = anyRequirementType;
    anyRequirementType = newAnyRequirementType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORY_FILTER__ANY_REQUIREMENT_TYPE, oldAnyRequirementType, anyRequirementType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MethodType> getMethodType()
  {
    if (methodType == null)
    {
      methodType = new EObjectResolvingEList<MethodType>(MethodType.class, this, CategoriesPackage.CATEGORY_FILTER__METHOD_TYPE);
    }
    return methodType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnyMethodType()
  {
    return anyMethodType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnyMethodType(boolean newAnyMethodType)
  {
    boolean oldAnyMethodType = anyMethodType;
    anyMethodType = newAnyMethodType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CategoriesPackage.CATEGORY_FILTER__ANY_METHOD_TYPE, oldAnyMethodType, anyMethodType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UserSelection> getUserSelection()
  {
    if (userSelection == null)
    {
      userSelection = new EObjectResolvingEList<UserSelection>(UserSelection.class, this, CategoriesPackage.CATEGORY_FILTER__USER_SELECTION);
    }
    return userSelection;
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
  public EList<QualityAttribute> getQualityAttribute()
  {
    if (qualityAttribute == null)
    {
      qualityAttribute = new EObjectResolvingEList<QualityAttribute>(QualityAttribute.class, this, CategoriesPackage.CATEGORY_FILTER__QUALITY_ATTRIBUTE);
    }
    return qualityAttribute;
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
  public EList<DevelopmentPhase> getDevelopmentPhase()
  {
    if (developmentPhase == null)
    {
      developmentPhase = new EObjectResolvingEList<DevelopmentPhase>(DevelopmentPhase.class, this, CategoriesPackage.CATEGORY_FILTER__DEVELOPMENT_PHASE);
    }
    return developmentPhase;
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
      case CategoriesPackage.CATEGORY_FILTER__REQUIREMENT_TYPE:
        return getRequirementType();
      case CategoriesPackage.CATEGORY_FILTER__ANY_REQUIREMENT_TYPE:
        return isAnyRequirementType();
      case CategoriesPackage.CATEGORY_FILTER__METHOD_TYPE:
        return getMethodType();
      case CategoriesPackage.CATEGORY_FILTER__ANY_METHOD_TYPE:
        return isAnyMethodType();
      case CategoriesPackage.CATEGORY_FILTER__USER_SELECTION:
        return getUserSelection();
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        return isAnyUserSelection();
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_ATTRIBUTE:
        return getQualityAttribute();
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        return isAnyQualityAttribute();
      case CategoriesPackage.CATEGORY_FILTER__DEVELOPMENT_PHASE:
        return getDevelopmentPhase();
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
      case CategoriesPackage.CATEGORY_FILTER__REQUIREMENT_TYPE:
        getRequirementType().clear();
        getRequirementType().addAll((Collection<? extends RequirementType>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_REQUIREMENT_TYPE:
        setAnyRequirementType((Boolean)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__METHOD_TYPE:
        getMethodType().clear();
        getMethodType().addAll((Collection<? extends MethodType>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_METHOD_TYPE:
        setAnyMethodType((Boolean)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__USER_SELECTION:
        getUserSelection().clear();
        getUserSelection().addAll((Collection<? extends UserSelection>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        setAnyUserSelection((Boolean)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_ATTRIBUTE:
        getQualityAttribute().clear();
        getQualityAttribute().addAll((Collection<? extends QualityAttribute>)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        setAnyQualityAttribute((Boolean)newValue);
        return;
      case CategoriesPackage.CATEGORY_FILTER__DEVELOPMENT_PHASE:
        getDevelopmentPhase().clear();
        getDevelopmentPhase().addAll((Collection<? extends DevelopmentPhase>)newValue);
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
      case CategoriesPackage.CATEGORY_FILTER__REQUIREMENT_TYPE:
        getRequirementType().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_REQUIREMENT_TYPE:
        setAnyRequirementType(ANY_REQUIREMENT_TYPE_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__METHOD_TYPE:
        getMethodType().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_METHOD_TYPE:
        setAnyMethodType(ANY_METHOD_TYPE_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__USER_SELECTION:
        getUserSelection().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        setAnyUserSelection(ANY_USER_SELECTION_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_ATTRIBUTE:
        getQualityAttribute().clear();
        return;
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        setAnyQualityAttribute(ANY_QUALITY_ATTRIBUTE_EDEFAULT);
        return;
      case CategoriesPackage.CATEGORY_FILTER__DEVELOPMENT_PHASE:
        getDevelopmentPhase().clear();
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
      case CategoriesPackage.CATEGORY_FILTER__REQUIREMENT_TYPE:
        return requirementType != null && !requirementType.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_REQUIREMENT_TYPE:
        return anyRequirementType != ANY_REQUIREMENT_TYPE_EDEFAULT;
      case CategoriesPackage.CATEGORY_FILTER__METHOD_TYPE:
        return methodType != null && !methodType.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_METHOD_TYPE:
        return anyMethodType != ANY_METHOD_TYPE_EDEFAULT;
      case CategoriesPackage.CATEGORY_FILTER__USER_SELECTION:
        return userSelection != null && !userSelection.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION:
        return anyUserSelection != ANY_USER_SELECTION_EDEFAULT;
      case CategoriesPackage.CATEGORY_FILTER__QUALITY_ATTRIBUTE:
        return qualityAttribute != null && !qualityAttribute.isEmpty();
      case CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE:
        return anyQualityAttribute != ANY_QUALITY_ATTRIBUTE_EDEFAULT;
      case CategoriesPackage.CATEGORY_FILTER__DEVELOPMENT_PHASE:
        return developmentPhase != null && !developmentPhase.isEmpty();
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
    result.append(", anyRequirementType: ");
    result.append(anyRequirementType);
    result.append(", anyMethodType: ");
    result.append(anyMethodType);
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
