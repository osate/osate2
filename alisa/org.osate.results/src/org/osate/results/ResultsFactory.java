/**
 */
package org.osate.results;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.results.ResultsPackage
 * @generated
 */
public interface ResultsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultsFactory eINSTANCE = org.osate.results.impl.ResultsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Results</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Results</em>'.
	 * @generated
	 */
	Results createResults();

	/**
	 * Returns a new object of class '<em>Result Contributor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Contributor</em>'.
	 * @generated
	 */
	ResultContributor createResultContributor();

	/**
	 * Returns a new object of class '<em>Result Issue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Issue</em>'.
	 * @generated
	 */
	ResultIssue createResultIssue();

	/**
	 * Returns a new object of class '<em>Result Data Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Data Spec</em>'.
	 * @generated
	 */
	ResultDataSpec createResultDataSpec();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResultsPackage getResultsPackage();

} //ResultsFactory
