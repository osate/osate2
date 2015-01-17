/**
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
   * @parameter ePackage the package in question.
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
      case CategoriesPackage.CATEGORIES:
      {
        Categories categories = (Categories)theEObject;
        T result = caseCategories(categories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.REQUIREMENT_CATEGORIES:
      {
        RequirementCategories requirementCategories = (RequirementCategories)theEObject;
        T result = caseRequirementCategories(requirementCategories);
        if (result == null) result = caseCategories(requirementCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.HAZARD_CATEGORIES:
      {
        HazardCategories hazardCategories = (HazardCategories)theEObject;
        T result = caseHazardCategories(hazardCategories);
        if (result == null) result = caseCategories(hazardCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.VERIFICATION_CATEGORIES:
      {
        VerificationCategories verificationCategories = (VerificationCategories)theEObject;
        T result = caseVerificationCategories(verificationCategories);
        if (result == null) result = caseCategories(verificationCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.SELECTION_CATEGORIES:
      {
        SelectionCategories selectionCategories = (SelectionCategories)theEObject;
        T result = caseSelectionCategories(selectionCategories);
        if (result == null) result = caseCategories(selectionCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.ASSERT_FAIL_CATEGORIES:
      {
        AssertFailCategories assertFailCategories = (AssertFailCategories)theEObject;
        T result = caseAssertFailCategories(assertFailCategories);
        if (result == null) result = caseCategories(assertFailCategories);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.EXECUTION_FAIL_CATEGORIES:
      {
        ExecutionFailCategories executionFailCategories = (ExecutionFailCategories)theEObject;
        T result = caseExecutionFailCategories(executionFailCategories);
        if (result == null) result = caseCategories(executionFailCategories);
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
      case CategoriesPackage.REQUIREMENT_CATEGORY:
      {
        RequirementCategory requirementCategory = (RequirementCategory)theEObject;
        T result = caseRequirementCategory(requirementCategory);
        if (result == null) result = caseCategory(requirementCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.HAZARD_CATEGORY:
      {
        HazardCategory hazardCategory = (HazardCategory)theEObject;
        T result = caseHazardCategory(hazardCategory);
        if (result == null) result = caseCategory(hazardCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.VERIFICATION_CATEGORY:
      {
        VerificationCategory verificationCategory = (VerificationCategory)theEObject;
        T result = caseVerificationCategory(verificationCategory);
        if (result == null) result = caseCategory(verificationCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.SELECTION_CATEGORY:
      {
        SelectionCategory selectionCategory = (SelectionCategory)theEObject;
        T result = caseSelectionCategory(selectionCategory);
        if (result == null) result = caseCategory(selectionCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.ASSERT_FAIL_CATEGORY:
      {
        AssertFailCategory assertFailCategory = (AssertFailCategory)theEObject;
        T result = caseAssertFailCategory(assertFailCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case CategoriesPackage.EXECUTION_FAIL_CATEGORY:
      {
        ExecutionFailCategory executionFailCategory = (ExecutionFailCategory)theEObject;
        T result = caseExecutionFailCategory(executionFailCategory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>Requirement Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirementCategories(RequirementCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hazard Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hazard Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHazardCategories(HazardCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationCategories(VerificationCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selection Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selection Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectionCategories(SelectionCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assert Fail Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assert Fail Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssertFailCategories(AssertFailCategories object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Execution Fail Categories</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execution Fail Categories</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutionFailCategories(ExecutionFailCategories object)
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
   * Returns the result of interpreting the object as an instance of '<em>Requirement Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirementCategory(RequirementCategory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Hazard Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Hazard Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseHazardCategory(HazardCategory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Verification Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Verification Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVerificationCategory(VerificationCategory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Selection Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Selection Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectionCategory(SelectionCategory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Assert Fail Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Assert Fail Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssertFailCategory(AssertFailCategory object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Execution Fail Category</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execution Fail Category</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutionFailCategory(ExecutionFailCategory object)
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
