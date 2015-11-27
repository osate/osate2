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
package org.osate.results.results;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.results.results.ResultsFactory
 * @model kind="package"
 * @generated
 */
public interface ResultsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "results";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/results/Results";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "results";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ResultsPackage eINSTANCE = org.osate.results.results.impl.ResultsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultReportsImpl <em>Result Reports</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultReportsImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReports()
   * @generated
   */
  int RESULT_REPORTS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__TARGET = 1;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__ISSUES = 2;

  /**
   * The number of structural features of the '<em>Result Reports</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultReportCollectionImpl <em>Result Report Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultReportCollectionImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReportCollection()
   * @generated
   */
  int RESULT_REPORT_COLLECTION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__NAME = RESULT_REPORTS__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__TARGET = RESULT_REPORTS__TARGET;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__ISSUES = RESULT_REPORTS__ISSUES;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__TITLE = RESULT_REPORTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__DECRIPTION = RESULT_REPORTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__CONTENT = RESULT_REPORTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Result Report Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION_FEATURE_COUNT = RESULT_REPORTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultReportImpl <em>Result Report</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultReportImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReport()
   * @generated
   */
  int RESULT_REPORT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__NAME = RESULT_REPORTS__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__TARGET = RESULT_REPORTS__TARGET;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__ISSUES = RESULT_REPORTS__ISSUES;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__TITLE = RESULT_REPORTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__DECRIPTION = RESULT_REPORTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Heading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__HEADING = RESULT_REPORTS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__CONTENT = RESULT_REPORTS_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Result Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__RESULT_DATA = RESULT_REPORTS_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Result Report</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_FEATURE_COUNT = RESULT_REPORTS_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultContributorImpl <em>Result Contributor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultContributorImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultContributor()
   * @generated
   */
  int RESULT_CONTRIBUTOR = 3;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__TARGET = 0;

  /**
   * The feature id for the '<em><b>Result Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__RESULT_DATA = 1;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__ISSUES = 2;

  /**
   * The feature id for the '<em><b>Subcontributor</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__SUBCONTRIBUTOR = 3;

  /**
   * The number of structural features of the '<em>Result Contributor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.IssuesReportImpl <em>Issues Report</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.IssuesReportImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getIssuesReport()
   * @generated
   */
  int ISSUES_REPORT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__NAME = RESULT_REPORTS__NAME;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__TARGET = RESULT_REPORTS__TARGET;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__ISSUES = RESULT_REPORTS__ISSUES;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__DESCRIPTION = RESULT_REPORTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Issues Report</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT_FEATURE_COUNT = RESULT_REPORTS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultIssueImpl <em>Result Issue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultIssueImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultIssue()
   * @generated
   */
  int RESULT_ISSUE = 5;

  /**
   * The feature id for the '<em><b>Issue Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__ISSUE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__MESSAGE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__TARGET = 2;

  /**
   * The feature id for the '<em><b>Exception Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__EXCEPTION_TYPE = 3;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__ISSUES = 4;

  /**
   * The number of structural features of the '<em>Result Issue</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultDataImpl <em>Result Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultDataImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultData()
   * @generated
   */
  int RESULT_DATA = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_DATA__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_DATA__VALUE = 1;

  /**
   * The number of structural features of the '<em>Result Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_DATA_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.results.results.ResultIssueType <em>Result Issue Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.ResultIssueType
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultIssueType()
   * @generated
   */
  int RESULT_ISSUE_TYPE = 7;


  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultReports <em>Result Reports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Reports</em>'.
   * @see org.osate.results.results.ResultReports
   * @generated
   */
  EClass getResultReports();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReports#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.results.results.ResultReports#getName()
   * @see #getResultReports()
   * @generated
   */
  EAttribute getResultReports_Name();

  /**
   * Returns the meta object for the reference '{@link org.osate.results.results.ResultReports#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.results.results.ResultReports#getTarget()
   * @see #getResultReports()
   * @generated
   */
  EReference getResultReports_Target();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultReports#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.results.results.ResultReports#getIssues()
   * @see #getResultReports()
   * @generated
   */
  EReference getResultReports_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultReportCollection <em>Result Report Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Report Collection</em>'.
   * @see org.osate.results.results.ResultReportCollection
   * @generated
   */
  EClass getResultReportCollection();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReportCollection#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.results.results.ResultReportCollection#getTitle()
   * @see #getResultReportCollection()
   * @generated
   */
  EAttribute getResultReportCollection_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReportCollection#getDecription <em>Decription</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decription</em>'.
   * @see org.osate.results.results.ResultReportCollection#getDecription()
   * @see #getResultReportCollection()
   * @generated
   */
  EAttribute getResultReportCollection_Decription();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultReportCollection#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.results.results.ResultReportCollection#getContent()
   * @see #getResultReportCollection()
   * @generated
   */
  EReference getResultReportCollection_Content();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultReport <em>Result Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Report</em>'.
   * @see org.osate.results.results.ResultReport
   * @generated
   */
  EClass getResultReport();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReport#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.results.results.ResultReport#getTitle()
   * @see #getResultReport()
   * @generated
   */
  EAttribute getResultReport_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReport#getDecription <em>Decription</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decription</em>'.
   * @see org.osate.results.results.ResultReport#getDecription()
   * @see #getResultReport()
   * @generated
   */
  EAttribute getResultReport_Decription();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReport#getHeading <em>Heading</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Heading</em>'.
   * @see org.osate.results.results.ResultReport#getHeading()
   * @see #getResultReport()
   * @generated
   */
  EAttribute getResultReport_Heading();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultReport#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.results.results.ResultReport#getContent()
   * @see #getResultReport()
   * @generated
   */
  EReference getResultReport_Content();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultReport#getResultData <em>Result Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Result Data</em>'.
   * @see org.osate.results.results.ResultReport#getResultData()
   * @see #getResultReport()
   * @generated
   */
  EReference getResultReport_ResultData();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultContributor <em>Result Contributor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Contributor</em>'.
   * @see org.osate.results.results.ResultContributor
   * @generated
   */
  EClass getResultContributor();

  /**
   * Returns the meta object for the reference '{@link org.osate.results.results.ResultContributor#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.results.results.ResultContributor#getTarget()
   * @see #getResultContributor()
   * @generated
   */
  EReference getResultContributor_Target();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultContributor#getResultData <em>Result Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Result Data</em>'.
   * @see org.osate.results.results.ResultContributor#getResultData()
   * @see #getResultContributor()
   * @generated
   */
  EReference getResultContributor_ResultData();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultContributor#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.results.results.ResultContributor#getIssues()
   * @see #getResultContributor()
   * @generated
   */
  EReference getResultContributor_Issues();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultContributor#getSubcontributor <em>Subcontributor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subcontributor</em>'.
   * @see org.osate.results.results.ResultContributor#getSubcontributor()
   * @see #getResultContributor()
   * @generated
   */
  EReference getResultContributor_Subcontributor();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.IssuesReport <em>Issues Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Issues Report</em>'.
   * @see org.osate.results.results.IssuesReport
   * @generated
   */
  EClass getIssuesReport();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.IssuesReport#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.osate.results.results.IssuesReport#getDescription()
   * @see #getIssuesReport()
   * @generated
   */
  EAttribute getIssuesReport_Description();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultIssue <em>Result Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Issue</em>'.
   * @see org.osate.results.results.ResultIssue
   * @generated
   */
  EClass getResultIssue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultIssue#getIssueType <em>Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Issue Type</em>'.
   * @see org.osate.results.results.ResultIssue#getIssueType()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_IssueType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultIssue#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.results.results.ResultIssue#getMessage()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_Message();

  /**
   * Returns the meta object for the reference '{@link org.osate.results.results.ResultIssue#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.results.results.ResultIssue#getTarget()
   * @see #getResultIssue()
   * @generated
   */
  EReference getResultIssue_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultIssue#getExceptionType <em>Exception Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exception Type</em>'.
   * @see org.osate.results.results.ResultIssue#getExceptionType()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_ExceptionType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultIssue#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.results.results.ResultIssue#getIssues()
   * @see #getResultIssue()
   * @generated
   */
  EReference getResultIssue_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultData <em>Result Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Data</em>'.
   * @see org.osate.results.results.ResultData
   * @generated
   */
  EClass getResultData();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultData#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.results.results.ResultData#getName()
   * @see #getResultData()
   * @generated
   */
  EAttribute getResultData_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultData#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.results.results.ResultData#getValue()
   * @see #getResultData()
   * @generated
   */
  EAttribute getResultData_Value();

  /**
   * Returns the meta object for enum '{@link org.osate.results.results.ResultIssueType <em>Result Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Result Issue Type</em>'.
   * @see org.osate.results.results.ResultIssueType
   * @generated
   */
  EEnum getResultIssueType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ResultsFactory getResultsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultReportsImpl <em>Result Reports</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultReportsImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReports()
     * @generated
     */
    EClass RESULT_REPORTS = eINSTANCE.getResultReports();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORTS__NAME = eINSTANCE.getResultReports_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORTS__TARGET = eINSTANCE.getResultReports_Target();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORTS__ISSUES = eINSTANCE.getResultReports_Issues();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultReportCollectionImpl <em>Result Report Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultReportCollectionImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReportCollection()
     * @generated
     */
    EClass RESULT_REPORT_COLLECTION = eINSTANCE.getResultReportCollection();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT_COLLECTION__TITLE = eINSTANCE.getResultReportCollection_Title();

    /**
     * The meta object literal for the '<em><b>Decription</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT_COLLECTION__DECRIPTION = eINSTANCE.getResultReportCollection_Decription();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT_COLLECTION__CONTENT = eINSTANCE.getResultReportCollection_Content();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultReportImpl <em>Result Report</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultReportImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReport()
     * @generated
     */
    EClass RESULT_REPORT = eINSTANCE.getResultReport();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT__TITLE = eINSTANCE.getResultReport_Title();

    /**
     * The meta object literal for the '<em><b>Decription</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT__DECRIPTION = eINSTANCE.getResultReport_Decription();

    /**
     * The meta object literal for the '<em><b>Heading</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT__HEADING = eINSTANCE.getResultReport_Heading();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT__CONTENT = eINSTANCE.getResultReport_Content();

    /**
     * The meta object literal for the '<em><b>Result Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT__RESULT_DATA = eINSTANCE.getResultReport_ResultData();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultContributorImpl <em>Result Contributor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultContributorImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultContributor()
     * @generated
     */
    EClass RESULT_CONTRIBUTOR = eINSTANCE.getResultContributor();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__TARGET = eINSTANCE.getResultContributor_Target();

    /**
     * The meta object literal for the '<em><b>Result Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__RESULT_DATA = eINSTANCE.getResultContributor_ResultData();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__ISSUES = eINSTANCE.getResultContributor_Issues();

    /**
     * The meta object literal for the '<em><b>Subcontributor</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__SUBCONTRIBUTOR = eINSTANCE.getResultContributor_Subcontributor();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.IssuesReportImpl <em>Issues Report</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.IssuesReportImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getIssuesReport()
     * @generated
     */
    EClass ISSUES_REPORT = eINSTANCE.getIssuesReport();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ISSUES_REPORT__DESCRIPTION = eINSTANCE.getIssuesReport_Description();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultIssueImpl <em>Result Issue</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultIssueImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultIssue()
     * @generated
     */
    EClass RESULT_ISSUE = eINSTANCE.getResultIssue();

    /**
     * The meta object literal for the '<em><b>Issue Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__ISSUE_TYPE = eINSTANCE.getResultIssue_IssueType();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__MESSAGE = eINSTANCE.getResultIssue_Message();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE__TARGET = eINSTANCE.getResultIssue_Target();

    /**
     * The meta object literal for the '<em><b>Exception Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__EXCEPTION_TYPE = eINSTANCE.getResultIssue_ExceptionType();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE__ISSUES = eINSTANCE.getResultIssue_Issues();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultDataImpl <em>Result Data</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultDataImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultData()
     * @generated
     */
    EClass RESULT_DATA = eINSTANCE.getResultData();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_DATA__NAME = eINSTANCE.getResultData_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_DATA__VALUE = eINSTANCE.getResultData_Value();

    /**
     * The meta object literal for the '{@link org.osate.results.results.ResultIssueType <em>Result Issue Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.ResultIssueType
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultIssueType()
     * @generated
     */
    EEnum RESULT_ISSUE_TYPE = eINSTANCE.getResultIssueType();

  }

} //ResultsPackage
