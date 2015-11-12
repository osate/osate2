/**
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
   * The meta object id for the '{@link org.osate.results.results.impl.ResultIssueHolderImpl <em>Result Issue Holder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultIssueHolderImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultIssueHolder()
   * @generated
   */
  int RESULT_ISSUE_HOLDER = 4;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE_HOLDER__ISSUES = 0;

  /**
   * The number of structural features of the '<em>Result Issue Holder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE_HOLDER_FEATURE_COUNT = 1;

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
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__ISSUES = RESULT_ISSUE_HOLDER__ISSUES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__NAME = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__TITLE = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__TARGET = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS__DECRIPTION = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Result Reports</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORTS_FEATURE_COUNT = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 4;

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
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__ISSUES = RESULT_REPORTS__ISSUES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__NAME = RESULT_REPORTS__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__TITLE = RESULT_REPORTS__TITLE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__TARGET = RESULT_REPORTS__TARGET;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__DECRIPTION = RESULT_REPORTS__DECRIPTION;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION__CONTENT = RESULT_REPORTS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Result Report Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_COLLECTION_FEATURE_COUNT = RESULT_REPORTS_FEATURE_COUNT + 1;

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
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__ISSUES = RESULT_REPORTS__ISSUES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__NAME = RESULT_REPORTS__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__TITLE = RESULT_REPORTS__TITLE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__TARGET = RESULT_REPORTS__TARGET;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__DECRIPTION = RESULT_REPORTS__DECRIPTION;

  /**
   * The feature id for the '<em><b>Heading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__HEADING = RESULT_REPORTS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__CONTENT = RESULT_REPORTS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Result Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__RESULT_DATA = RESULT_REPORTS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Result Report</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_FEATURE_COUNT = RESULT_REPORTS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.IssuesReportImpl <em>Issues Report</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.IssuesReportImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getIssuesReport()
   * @generated
   */
  int ISSUES_REPORT = 3;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__ISSUES = RESULT_REPORTS__ISSUES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__NAME = RESULT_REPORTS__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__TITLE = RESULT_REPORTS__TITLE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__TARGET = RESULT_REPORTS__TARGET;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT__DECRIPTION = RESULT_REPORTS__DECRIPTION;

  /**
   * The number of structural features of the '<em>Issues Report</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISSUES_REPORT_FEATURE_COUNT = RESULT_REPORTS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultContributorImpl <em>Result Contributor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultContributorImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultContributor()
   * @generated
   */
  int RESULT_CONTRIBUTOR = 5;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__ISSUES = RESULT_ISSUE_HOLDER__ISSUES;

  /**
   * The feature id for the '<em><b>Contributor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__CONTRIBUTOR = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cell</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__CELL = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Subcontributor</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__SUBCONTRIBUTOR = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Result Contributor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR_FEATURE_COUNT = RESULT_ISSUE_HOLDER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ReportIssueImpl <em>Report Issue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ReportIssueImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getReportIssue()
   * @generated
   */
  int REPORT_ISSUE = 6;

  /**
   * The feature id for the '<em><b>Issue Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT_ISSUE__ISSUE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT_ISSUE__TITLE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT_ISSUE__TARGET = 2;

  /**
   * The number of structural features of the '<em>Report Issue</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REPORT_ISSUE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultDataImpl <em>Result Data</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultDataImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultData()
   * @generated
   */
  int RESULT_DATA = 7;

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
   * The meta object id for the '{@link org.osate.results.results.ReportIssueType <em>Report Issue Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.ReportIssueType
   * @see org.osate.results.results.impl.ResultsPackageImpl#getReportIssueType()
   * @generated
   */
  int REPORT_ISSUE_TYPE = 8;


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
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReports#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.results.results.ResultReports#getTitle()
   * @see #getResultReports()
   * @generated
   */
  EAttribute getResultReports_Title();

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
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReports#getDecription <em>Decription</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decription</em>'.
   * @see org.osate.results.results.ResultReports#getDecription()
   * @see #getResultReports()
   * @generated
   */
  EAttribute getResultReports_Decription();

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
   * Returns the meta object for class '{@link org.osate.results.results.IssuesReport <em>Issues Report</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Issues Report</em>'.
   * @see org.osate.results.results.IssuesReport
   * @generated
   */
  EClass getIssuesReport();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultIssueHolder <em>Result Issue Holder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Issue Holder</em>'.
   * @see org.osate.results.results.ResultIssueHolder
   * @generated
   */
  EClass getResultIssueHolder();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultIssueHolder#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.results.results.ResultIssueHolder#getIssues()
   * @see #getResultIssueHolder()
   * @generated
   */
  EReference getResultIssueHolder_Issues();

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
   * Returns the meta object for the reference '{@link org.osate.results.results.ResultContributor#getContributor <em>Contributor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Contributor</em>'.
   * @see org.osate.results.results.ResultContributor#getContributor()
   * @see #getResultContributor()
   * @generated
   */
  EReference getResultContributor_Contributor();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.results.results.ResultContributor#getCell <em>Cell</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Cell</em>'.
   * @see org.osate.results.results.ResultContributor#getCell()
   * @see #getResultContributor()
   * @generated
   */
  EAttribute getResultContributor_Cell();

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
   * Returns the meta object for class '{@link org.osate.results.results.ReportIssue <em>Report Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Report Issue</em>'.
   * @see org.osate.results.results.ReportIssue
   * @generated
   */
  EClass getReportIssue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ReportIssue#getIssueType <em>Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Issue Type</em>'.
   * @see org.osate.results.results.ReportIssue#getIssueType()
   * @see #getReportIssue()
   * @generated
   */
  EAttribute getReportIssue_IssueType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ReportIssue#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.results.results.ReportIssue#getTitle()
   * @see #getReportIssue()
   * @generated
   */
  EAttribute getReportIssue_Title();

  /**
   * Returns the meta object for the reference '{@link org.osate.results.results.ReportIssue#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.results.results.ReportIssue#getTarget()
   * @see #getReportIssue()
   * @generated
   */
  EReference getReportIssue_Target();

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
   * Returns the meta object for enum '{@link org.osate.results.results.ReportIssueType <em>Report Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Report Issue Type</em>'.
   * @see org.osate.results.results.ReportIssueType
   * @generated
   */
  EEnum getReportIssueType();

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
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORTS__TITLE = eINSTANCE.getResultReports_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORTS__TARGET = eINSTANCE.getResultReports_Target();

    /**
     * The meta object literal for the '<em><b>Decription</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORTS__DECRIPTION = eINSTANCE.getResultReports_Decription();

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
     * The meta object literal for the '{@link org.osate.results.results.impl.IssuesReportImpl <em>Issues Report</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.IssuesReportImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getIssuesReport()
     * @generated
     */
    EClass ISSUES_REPORT = eINSTANCE.getIssuesReport();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultIssueHolderImpl <em>Result Issue Holder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultIssueHolderImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultIssueHolder()
     * @generated
     */
    EClass RESULT_ISSUE_HOLDER = eINSTANCE.getResultIssueHolder();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE_HOLDER__ISSUES = eINSTANCE.getResultIssueHolder_Issues();

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
     * The meta object literal for the '<em><b>Contributor</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__CONTRIBUTOR = eINSTANCE.getResultContributor_Contributor();

    /**
     * The meta object literal for the '<em><b>Cell</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_CONTRIBUTOR__CELL = eINSTANCE.getResultContributor_Cell();

    /**
     * The meta object literal for the '<em><b>Subcontributor</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__SUBCONTRIBUTOR = eINSTANCE.getResultContributor_Subcontributor();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ReportIssueImpl <em>Report Issue</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ReportIssueImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getReportIssue()
     * @generated
     */
    EClass REPORT_ISSUE = eINSTANCE.getReportIssue();

    /**
     * The meta object literal for the '<em><b>Issue Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPORT_ISSUE__ISSUE_TYPE = eINSTANCE.getReportIssue_IssueType();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REPORT_ISSUE__TITLE = eINSTANCE.getReportIssue_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REPORT_ISSUE__TARGET = eINSTANCE.getReportIssue_Target();

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
     * The meta object literal for the '{@link org.osate.results.results.ReportIssueType <em>Report Issue Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.ReportIssueType
     * @see org.osate.results.results.impl.ResultsPackageImpl#getReportIssueType()
     * @generated
     */
    EEnum REPORT_ISSUE_TYPE = eINSTANCE.getReportIssueType();

  }

} //ResultsPackage
