/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.alisa.workbench.alisa.AlisaPackage
 * @generated
 */
public interface AlisaFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlisaFactory eINSTANCE = org.osate.alisa.workbench.alisa.impl.AlisaFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Work Area</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Work Area</em>'.
   * @generated
   */
  AlisaWorkArea createAlisaWorkArea();

  /**
   * Returns a new object of class '<em>Assurance Case Plan</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assurance Case Plan</em>'.
   * @generated
   */
  AssuranceCasePlan createAssuranceCasePlan();

  /**
   * Returns a new object of class '<em>Selection Condition Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection Condition Expr</em>'.
   * @generated
   */
  SelectionConditionExpr createSelectionConditionExpr();

  /**
   * Returns a new object of class '<em>Selection Category Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection Category Reference</em>'.
   * @generated
   */
  SelectionCategoryReference createSelectionCategoryReference();

  /**
   * Returns a new object of class '<em>And Selection Condition Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>And Selection Condition Expr</em>'.
   * @generated
   */
  AndSelectionConditionExpr createAndSelectionConditionExpr();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AlisaPackage getAlisaPackage();

} //AlisaFactory
