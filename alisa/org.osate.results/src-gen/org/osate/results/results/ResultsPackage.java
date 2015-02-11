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
   * The meta object id for the '{@link org.osate.results.results.impl.ResultReportImpl <em>Result Report</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultReportImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReport()
   * @generated
   */
  int RESULT_REPORT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__TITLE = 1;

  /**
   * The feature id for the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__ROOT = 2;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__DECRIPTION = 3;

  /**
   * The feature id for the '<em><b>Heading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__HEADING = 4;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__CONTENT = 5;

  /**
   * The feature id for the '<em><b>Result Data</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT__RESULT_DATA = 6;

  /**
   * The number of structural features of the '<em>Result Report</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultReportEntryImpl <em>Result Report Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultReportEntryImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReportEntry()
   * @generated
   */
  int RESULT_REPORT_ENTRY = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__TITLE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__TARGET = 2;

  /**
   * The feature id for the '<em><b>Decription</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__DECRIPTION = 3;

  /**
   * The feature id for the '<em><b>Heading</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__HEADING = 4;

  /**
   * The feature id for the '<em><b>Result Data</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__RESULT_DATA = 5;

  /**
   * The feature id for the '<em><b>Issue</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__ISSUE = 6;

  /**
   * The feature id for the '<em><b>Row</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY__ROW = 7;

  /**
   * The number of structural features of the '<em>Result Report Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_REPORT_ENTRY_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.ResultContributorImpl <em>Result Contributor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ResultContributorImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getResultContributor()
   * @generated
   */
  int RESULT_CONTRIBUTOR = 2;

  /**
   * The feature id for the '<em><b>Contributor</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__CONTRIBUTOR = 0;

  /**
   * The feature id for the '<em><b>Cell</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__CELL = 1;

  /**
   * The feature id for the '<em><b>Issue</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_CONTRIBUTOR__ISSUE = 2;

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
   * The meta object id for the '{@link org.osate.results.results.impl.ReportIssueImpl <em>Report Issue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.ReportIssueImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getReportIssue()
   * @generated
   */
  int REPORT_ISSUE = 3;

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
  int RESULT_DATA = 4;

  /**
   * The feature id for the '<em><b>Data</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_DATA__DATA = 0;

  /**
   * The number of structural features of the '<em>Result Data</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_DATA_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.results.results.impl.NameValuePairImpl <em>Name Value Pair</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.impl.NameValuePairImpl
   * @see org.osate.results.results.impl.ResultsPackageImpl#getNameValuePair()
   * @generated
   */
  int NAME_VALUE_PAIR = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_VALUE_PAIR__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_VALUE_PAIR__VALUE = 1;

  /**
   * The number of structural features of the '<em>Name Value Pair</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_VALUE_PAIR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.results.results.ReportIssueType <em>Report Issue Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.results.results.ReportIssueType
   * @see org.osate.results.results.impl.ResultsPackageImpl#getReportIssueType()
   * @generated
   */
  int REPORT_ISSUE_TYPE = 6;


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
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReport#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.results.results.ResultReport#getName()
   * @see #getResultReport()
   * @generated
   */
  EAttribute getResultReport_Name();

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
   * Returns the meta object for the reference '{@link org.osate.results.results.ResultReport#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Root</em>'.
   * @see org.osate.results.results.ResultReport#getRoot()
   * @see #getResultReport()
   * @generated
   */
  EReference getResultReport_Root();

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
   * Returns the meta object for the containment reference '{@link org.osate.results.results.ResultReport#getResultData <em>Result Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result Data</em>'.
   * @see org.osate.results.results.ResultReport#getResultData()
   * @see #getResultReport()
   * @generated
   */
  EReference getResultReport_ResultData();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.ResultReportEntry <em>Result Report Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Report Entry</em>'.
   * @see org.osate.results.results.ResultReportEntry
   * @generated
   */
  EClass getResultReportEntry();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReportEntry#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.results.results.ResultReportEntry#getName()
   * @see #getResultReportEntry()
   * @generated
   */
  EAttribute getResultReportEntry_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReportEntry#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.results.results.ResultReportEntry#getTitle()
   * @see #getResultReportEntry()
   * @generated
   */
  EAttribute getResultReportEntry_Title();

  /**
   * Returns the meta object for the reference '{@link org.osate.results.results.ResultReportEntry#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.results.results.ResultReportEntry#getTarget()
   * @see #getResultReportEntry()
   * @generated
   */
  EReference getResultReportEntry_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReportEntry#getDecription <em>Decription</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decription</em>'.
   * @see org.osate.results.results.ResultReportEntry#getDecription()
   * @see #getResultReportEntry()
   * @generated
   */
  EAttribute getResultReportEntry_Decription();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.ResultReportEntry#getHeading <em>Heading</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Heading</em>'.
   * @see org.osate.results.results.ResultReportEntry#getHeading()
   * @see #getResultReportEntry()
   * @generated
   */
  EAttribute getResultReportEntry_Heading();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.results.results.ResultReportEntry#getResultData <em>Result Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result Data</em>'.
   * @see org.osate.results.results.ResultReportEntry#getResultData()
   * @see #getResultReportEntry()
   * @generated
   */
  EReference getResultReportEntry_ResultData();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultReportEntry#getIssue <em>Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issue</em>'.
   * @see org.osate.results.results.ResultReportEntry#getIssue()
   * @see #getResultReportEntry()
   * @generated
   */
  EReference getResultReportEntry_Issue();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultReportEntry#getRow <em>Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Row</em>'.
   * @see org.osate.results.results.ResultReportEntry#getRow()
   * @see #getResultReportEntry()
   * @generated
   */
  EReference getResultReportEntry_Row();

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
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultContributor#getIssue <em>Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issue</em>'.
   * @see org.osate.results.results.ResultContributor#getIssue()
   * @see #getResultContributor()
   * @generated
   */
  EReference getResultContributor_Issue();

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
   * Returns the meta object for the containment reference list '{@link org.osate.results.results.ResultData#getData <em>Data</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Data</em>'.
   * @see org.osate.results.results.ResultData#getData()
   * @see #getResultData()
   * @generated
   */
  EReference getResultData_Data();

  /**
   * Returns the meta object for class '{@link org.osate.results.results.NameValuePair <em>Name Value Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Value Pair</em>'.
   * @see org.osate.results.results.NameValuePair
   * @generated
   */
  EClass getNameValuePair();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.NameValuePair#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.results.results.NameValuePair#getName()
   * @see #getNameValuePair()
   * @generated
   */
  EAttribute getNameValuePair_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.results.results.NameValuePair#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.results.results.NameValuePair#getValue()
   * @see #getNameValuePair()
   * @generated
   */
  EAttribute getNameValuePair_Value();

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
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultReportImpl <em>Result Report</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultReportImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReport()
     * @generated
     */
    EClass RESULT_REPORT = eINSTANCE.getResultReport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT__NAME = eINSTANCE.getResultReport_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT__TITLE = eINSTANCE.getResultReport_Title();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT__ROOT = eINSTANCE.getResultReport_Root();

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
     * The meta object literal for the '<em><b>Result Data</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT__RESULT_DATA = eINSTANCE.getResultReport_ResultData();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.ResultReportEntryImpl <em>Result Report Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.ResultReportEntryImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getResultReportEntry()
     * @generated
     */
    EClass RESULT_REPORT_ENTRY = eINSTANCE.getResultReportEntry();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT_ENTRY__NAME = eINSTANCE.getResultReportEntry_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT_ENTRY__TITLE = eINSTANCE.getResultReportEntry_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT_ENTRY__TARGET = eINSTANCE.getResultReportEntry_Target();

    /**
     * The meta object literal for the '<em><b>Decription</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT_ENTRY__DECRIPTION = eINSTANCE.getResultReportEntry_Decription();

    /**
     * The meta object literal for the '<em><b>Heading</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_REPORT_ENTRY__HEADING = eINSTANCE.getResultReportEntry_Heading();

    /**
     * The meta object literal for the '<em><b>Result Data</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT_ENTRY__RESULT_DATA = eINSTANCE.getResultReportEntry_ResultData();

    /**
     * The meta object literal for the '<em><b>Issue</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT_ENTRY__ISSUE = eINSTANCE.getResultReportEntry_Issue();

    /**
     * The meta object literal for the '<em><b>Row</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_REPORT_ENTRY__ROW = eINSTANCE.getResultReportEntry_Row();

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
     * The meta object literal for the '<em><b>Issue</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_CONTRIBUTOR__ISSUE = eINSTANCE.getResultContributor_Issue();

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
     * The meta object literal for the '<em><b>Data</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_DATA__DATA = eINSTANCE.getResultData_Data();

    /**
     * The meta object literal for the '{@link org.osate.results.results.impl.NameValuePairImpl <em>Name Value Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.results.results.impl.NameValuePairImpl
     * @see org.osate.results.results.impl.ResultsPackageImpl#getNameValuePair()
     * @generated
     */
    EClass NAME_VALUE_PAIR = eINSTANCE.getNameValuePair();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME_VALUE_PAIR__NAME = eINSTANCE.getNameValuePair_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME_VALUE_PAIR__VALUE = eINSTANCE.getNameValuePair_Value();

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
