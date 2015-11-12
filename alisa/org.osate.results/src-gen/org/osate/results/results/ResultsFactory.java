/**
 */
package org.osate.results.results;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.results.results.ResultsPackage
 * @generated
 */
public interface ResultsFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ResultsFactory eINSTANCE = org.osate.results.results.impl.ResultsFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Result Reports</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Reports</em>'.
   * @generated
   */
  ResultReports createResultReports();

  /**
   * Returns a new object of class '<em>Result Report Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Report Collection</em>'.
   * @generated
   */
  ResultReportCollection createResultReportCollection();

  /**
   * Returns a new object of class '<em>Result Report</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Report</em>'.
   * @generated
   */
  ResultReport createResultReport();

  /**
   * Returns a new object of class '<em>Issues Report</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Issues Report</em>'.
   * @generated
   */
  IssuesReport createIssuesReport();

  /**
   * Returns a new object of class '<em>Result Issue Holder</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Issue Holder</em>'.
   * @generated
   */
  ResultIssueHolder createResultIssueHolder();

  /**
   * Returns a new object of class '<em>Result Contributor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Contributor</em>'.
   * @generated
   */
  ResultContributor createResultContributor();

  /**
   * Returns a new object of class '<em>Report Issue</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Report Issue</em>'.
   * @generated
   */
  ReportIssue createReportIssue();

  /**
   * Returns a new object of class '<em>Result Data</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Data</em>'.
   * @generated
   */
  ResultData createResultData();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ResultsPackage getResultsPackage();

} //ResultsFactory
