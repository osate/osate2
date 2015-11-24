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
package org.osate.categories.categories.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.categories.categories.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.categories.categories.CategoriesPackage
 * @generated
 */
public class CategoriesSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CategoriesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CategoriesSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = CategoriesPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case CategoriesPackage.CATEGORIES_DEFINITIONS:
      {
        CategoriesDefinitions categoriesDefinitions = (CategoriesDefinitions)theEObject;
        T result = caseCategoriesDefinitions(categoriesDefinitions);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.CATEGORIES:
      {
        Categories categories = (Categories)theEObject;
        T result = caseCategories(categories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.CATEGORY:
      {
        Category category = (Category)theEObject;
        T result = caseCategory(category);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.CATEGORY_FILTER:
      {
        CategoryFilter categoryFilter = (CategoryFilter)theEObject;
        T result = caseCategoryFilter(categoryFilter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.REQUIREMENT_TYPE_CATEGORIES:
      {
        RequirementTypeCategories requirementTypeCategories = (RequirementTypeCategories)theEObject;
        T result = caseRequirementTypeCategories(requirementTypeCategories);
        if (result == null) result = caseCategories(requirementTypeCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.METHOD_TYPE_CATEGORIES:
      {
        MethodTypeCategories methodTypeCategories = (MethodTypeCategories)theEObject;
        T result = caseMethodTypeCategories(methodTypeCategories);
        if (result == null) result = caseCategories(methodTypeCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.USER_SELECTION_CATEGORIES:
      {
        UserSelectionCategories userSelectionCategories = (UserSelectionCategories)theEObject;
        T result = caseUserSelectionCategories(userSelectionCategories);
        if (result == null) result = caseCategories(userSelectionCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.QUALITY_ATTRIBUTE_CATEGORIES:
      {
        QualityAttributeCategories qualityAttributeCategories = (QualityAttributeCategories)theEObject;
        T result = caseQualityAttributeCategories(qualityAttributeCategories);
        if (result == null) result = caseCategories(qualityAttributeCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.DEVELOPMENT_PHASE_CATEGORIES:
      {
        DevelopmentPhaseCategories developmentPhaseCategories = (DevelopmentPhaseCategories)theEObject;
        T result = caseDevelopmentPhaseCategories(developmentPhaseCategories);
        if (result == null) result = caseCategories(developmentPhaseCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.REQUIREMENT_TYPE:
      {
        RequirementType requirementType = (RequirementType)theEObject;
        T result = caseRequirementType(requirementType);
        if (result == null) result = caseCategory(requirementType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.METHOD_TYPE:
      {
        MethodType methodType = (MethodType)theEObject;
        T result = caseMethodType(methodType);
        if (result == null) result = caseCategory(methodType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.USER_SELECTION:
      {
        UserSelection userSelection = (UserSelection)theEObject;
        T result = caseUserSelection(userSelection);
        if (result == null) result = caseCategory(userSelection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.QUALITY_ATTRIBUTE:
      {
        QualityAttribute qualityAttribute = (QualityAttribute)theEObject;
        T result = caseQualityAttribute(qualityAttribute);
        if (result == null) result = caseCategory(qualityAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.DEVELOPMENT_PHASE:
      {
        DevelopmentPhase developmentPhase = (DevelopmentPhase)theEObject;
        T result = caseDevelopmentPhase(developmentPhase);
        if (result == null) result = caseCategory(developmentPhase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Definitions</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Definitions</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCategoriesDefinitions(CategoriesDefinitions object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCategories(Categories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCategory(Category object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Category Filter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Category Filter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCategoryFilter(CategoryFilter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement Type Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement Type Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirementTypeCategories(RequirementTypeCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Type Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Type Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodTypeCategories(MethodTypeCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User Selection Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User Selection Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUserSelectionCategories(UserSelectionCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quality Attribute Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quality Attribute Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualityAttributeCategories(QualityAttributeCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Development Phase Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Development Phase Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDevelopmentPhaseCategories(DevelopmentPhaseCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirementType(RequirementType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodType(MethodType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User Selection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User Selection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUserSelection(UserSelection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quality Attribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quality Attribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualityAttribute(QualityAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Development Phase</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Development Phase</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDevelopmentPhase(DevelopmentPhase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //CategoriesSwitch
