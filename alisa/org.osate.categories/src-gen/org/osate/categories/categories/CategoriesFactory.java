/**
 */
package org.osate.categories.categories;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.categories.categories.CategoriesPackage
 * @generated
 */
public interface CategoriesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CategoriesFactory eINSTANCE = org.osate.categories.categories.impl.CategoriesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Categories</em>'.
   * @generated
   */
  Categories createCategories();

  /**
   * Returns a new object of class '<em>Requirement Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement Categories</em>'.
   * @generated
   */
  RequirementCategories createRequirementCategories();

  /**
   * Returns a new object of class '<em>Hazard Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hazard Categories</em>'.
   * @generated
   */
  HazardCategories createHazardCategories();

  /**
   * Returns a new object of class '<em>Verification Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Categories</em>'.
   * @generated
   */
  VerificationCategories createVerificationCategories();

  /**
   * Returns a new object of class '<em>Selection Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection Categories</em>'.
   * @generated
   */
  SelectionCategories createSelectionCategories();

  /**
   * Returns a new object of class '<em>Assert Fail Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assert Fail Categories</em>'.
   * @generated
   */
  AssertFailCategories createAssertFailCategories();

  /**
   * Returns a new object of class '<em>Execution Fail Categories</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execution Fail Categories</em>'.
   * @generated
   */
  ExecutionFailCategories createExecutionFailCategories();

  /**
   * Returns a new object of class '<em>Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Category</em>'.
   * @generated
   */
  Category createCategory();

  /**
   * Returns a new object of class '<em>Requirement Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Requirement Category</em>'.
   * @generated
   */
  RequirementCategory createRequirementCategory();

  /**
   * Returns a new object of class '<em>Hazard Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hazard Category</em>'.
   * @generated
   */
  HazardCategory createHazardCategory();

  /**
   * Returns a new object of class '<em>Verification Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Verification Category</em>'.
   * @generated
   */
  VerificationCategory createVerificationCategory();

  /**
   * Returns a new object of class '<em>Selection Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection Category</em>'.
   * @generated
   */
  SelectionCategory createSelectionCategory();

  /**
   * Returns a new object of class '<em>Assert Fail Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assert Fail Category</em>'.
   * @generated
   */
  AssertFailCategory createAssertFailCategory();

  /**
   * Returns a new object of class '<em>Execution Fail Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execution Fail Category</em>'.
   * @generated
   */
  ExecutionFailCategory createExecutionFailCategory();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  CategoriesPackage getCategoriesPackage();

} //CategoriesFactory
