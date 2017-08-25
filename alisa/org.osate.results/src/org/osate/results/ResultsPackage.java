/**
 */
package org.osate.results;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.results.ResultsFactory
 * @model kind="package"
 * @generated
 */
public interface ResultsPackage extends EPackage {
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
	ResultsPackage eINSTANCE = org.osate.results.impl.ResultsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.results.impl.ResultsImpl <em>Results</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.results.impl.ResultsImpl
	 * @see org.osate.results.impl.ResultsPackageImpl#getResults()
	 * @generated
	 */
	int RESULTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__TITLE = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__VALUES = 4;

	/**
	 * The feature id for the '<em><b>Data Spec</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__DATA_SPEC = 5;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__ISSUES = 6;

	/**
	 * The feature id for the '<em><b>Contributors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__CONTRIBUTORS = 7;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS__RESULTS = 8;

	/**
	 * The number of structural features of the '<em>Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Results</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.results.impl.ResultContributorImpl <em>Result Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.results.impl.ResultContributorImpl
	 * @see org.osate.results.impl.ResultsPackageImpl#getResultContributor()
	 * @generated
	 */
	int RESULT_CONTRIBUTOR = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_CONTRIBUTOR__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_CONTRIBUTOR__ISSUES = 1;

	/**
	 * The feature id for the '<em><b>Subcontributor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_CONTRIBUTOR__SUBCONTRIBUTOR = 2;

	/**
	 * The number of structural features of the '<em>Result Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_CONTRIBUTOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Result Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_CONTRIBUTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.results.impl.ResultIssueImpl <em>Result Issue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.results.impl.ResultIssueImpl
	 * @see org.osate.results.impl.ResultsPackageImpl#getResultIssue()
	 * @generated
	 */
	int RESULT_ISSUE = 2;

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
	 * The feature id for the '<em><b>Diagnostic Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_ISSUE__DIAGNOSTIC_ID = 4;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_ISSUE__ISSUES = 5;

	/**
	 * The number of structural features of the '<em>Result Issue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_ISSUE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Result Issue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_ISSUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.results.impl.ResultDataSpecImpl <em>Result Data Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.results.impl.ResultDataSpecImpl
	 * @see org.osate.results.impl.ResultsPackageImpl#getResultDataSpec()
	 * @generated
	 */
	int RESULT_DATA_SPEC = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DATA_SPEC__NAME = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DATA_SPEC__UNIT = 1;

	/**
	 * The number of structural features of the '<em>Result Data Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DATA_SPEC_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Result Data Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_DATA_SPEC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.results.ResultIssueType <em>Result Issue Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.results.ResultIssueType
	 * @see org.osate.results.impl.ResultsPackageImpl#getResultIssueType()
	 * @generated
	 */
	int RESULT_ISSUE_TYPE = 4;


	/**
	 * Returns the meta object for class '{@link org.osate.results.Results <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Results</em>'.
	 * @see org.osate.results.Results
	 * @generated
	 */
	EClass getResults();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.Results#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.results.Results#getName()
	 * @see #getResults()
	 * @generated
	 */
	EAttribute getResults_Name();

	/**
	 * Returns the meta object for the reference '{@link org.osate.results.Results#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.osate.results.Results#getTarget()
	 * @see #getResults()
	 * @generated
	 */
	EReference getResults_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.Results#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.osate.results.Results#getTitle()
	 * @see #getResults()
	 * @generated
	 */
	EAttribute getResults_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.Results#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.osate.results.Results#getDescription()
	 * @see #getResults()
	 * @generated
	 */
	EAttribute getResults_Description();

	/**
	 * Returns the meta object for the attribute list '{@link org.osate.results.Results#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.osate.results.Results#getValues()
	 * @see #getResults()
	 * @generated
	 */
	EAttribute getResults_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.Results#getDataSpec <em>Data Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Spec</em>'.
	 * @see org.osate.results.Results#getDataSpec()
	 * @see #getResults()
	 * @generated
	 */
	EReference getResults_DataSpec();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.Results#getIssues <em>Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Issues</em>'.
	 * @see org.osate.results.Results#getIssues()
	 * @see #getResults()
	 * @generated
	 */
	EReference getResults_Issues();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.Results#getContributors <em>Contributors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributors</em>'.
	 * @see org.osate.results.Results#getContributors()
	 * @see #getResults()
	 * @generated
	 */
	EReference getResults_Contributors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.Results#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.osate.results.Results#getResults()
	 * @see #getResults()
	 * @generated
	 */
	EReference getResults_Results();

	/**
	 * Returns the meta object for class '{@link org.osate.results.ResultContributor <em>Result Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Contributor</em>'.
	 * @see org.osate.results.ResultContributor
	 * @generated
	 */
	EClass getResultContributor();

	/**
	 * Returns the meta object for the reference '{@link org.osate.results.ResultContributor#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.osate.results.ResultContributor#getTarget()
	 * @see #getResultContributor()
	 * @generated
	 */
	EReference getResultContributor_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.ResultContributor#getIssues <em>Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Issues</em>'.
	 * @see org.osate.results.ResultContributor#getIssues()
	 * @see #getResultContributor()
	 * @generated
	 */
	EReference getResultContributor_Issues();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.ResultContributor#getSubcontributor <em>Subcontributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subcontributor</em>'.
	 * @see org.osate.results.ResultContributor#getSubcontributor()
	 * @see #getResultContributor()
	 * @generated
	 */
	EReference getResultContributor_Subcontributor();

	/**
	 * Returns the meta object for class '{@link org.osate.results.ResultIssue <em>Result Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Issue</em>'.
	 * @see org.osate.results.ResultIssue
	 * @generated
	 */
	EClass getResultIssue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.ResultIssue#getIssueType <em>Issue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issue Type</em>'.
	 * @see org.osate.results.ResultIssue#getIssueType()
	 * @see #getResultIssue()
	 * @generated
	 */
	EAttribute getResultIssue_IssueType();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.ResultIssue#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.results.ResultIssue#getMessage()
	 * @see #getResultIssue()
	 * @generated
	 */
	EAttribute getResultIssue_Message();

	/**
	 * Returns the meta object for the reference '{@link org.osate.results.ResultIssue#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.osate.results.ResultIssue#getTarget()
	 * @see #getResultIssue()
	 * @generated
	 */
	EReference getResultIssue_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.ResultIssue#getExceptionType <em>Exception Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Type</em>'.
	 * @see org.osate.results.ResultIssue#getExceptionType()
	 * @see #getResultIssue()
	 * @generated
	 */
	EAttribute getResultIssue_ExceptionType();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.ResultIssue#getDiagnosticId <em>Diagnostic Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic Id</em>'.
	 * @see org.osate.results.ResultIssue#getDiagnosticId()
	 * @see #getResultIssue()
	 * @generated
	 */
	EAttribute getResultIssue_DiagnosticId();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.results.ResultIssue#getIssues <em>Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Issues</em>'.
	 * @see org.osate.results.ResultIssue#getIssues()
	 * @see #getResultIssue()
	 * @generated
	 */
	EReference getResultIssue_Issues();

	/**
	 * Returns the meta object for class '{@link org.osate.results.ResultDataSpec <em>Result Data Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Data Spec</em>'.
	 * @see org.osate.results.ResultDataSpec
	 * @generated
	 */
	EClass getResultDataSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.results.ResultDataSpec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.osate.results.ResultDataSpec#getName()
	 * @see #getResultDataSpec()
	 * @generated
	 */
	EAttribute getResultDataSpec_Name();

	/**
	 * Returns the meta object for the reference '{@link org.osate.results.ResultDataSpec#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit</em>'.
	 * @see org.osate.results.ResultDataSpec#getUnit()
	 * @see #getResultDataSpec()
	 * @generated
	 */
	EReference getResultDataSpec_Unit();

	/**
	 * Returns the meta object for enum '{@link org.osate.results.ResultIssueType <em>Result Issue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Result Issue Type</em>'.
	 * @see org.osate.results.ResultIssueType
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
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.results.impl.ResultsImpl <em>Results</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.results.impl.ResultsImpl
		 * @see org.osate.results.impl.ResultsPackageImpl#getResults()
		 * @generated
		 */
		EClass RESULTS = eINSTANCE.getResults();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULTS__NAME = eINSTANCE.getResults_Name();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULTS__TARGET = eINSTANCE.getResults_Target();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULTS__TITLE = eINSTANCE.getResults_Title();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULTS__DESCRIPTION = eINSTANCE.getResults_Description();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULTS__VALUES = eINSTANCE.getResults_Values();

		/**
		 * The meta object literal for the '<em><b>Data Spec</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULTS__DATA_SPEC = eINSTANCE.getResults_DataSpec();

		/**
		 * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULTS__ISSUES = eINSTANCE.getResults_Issues();

		/**
		 * The meta object literal for the '<em><b>Contributors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULTS__CONTRIBUTORS = eINSTANCE.getResults_Contributors();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULTS__RESULTS = eINSTANCE.getResults_Results();

		/**
		 * The meta object literal for the '{@link org.osate.results.impl.ResultContributorImpl <em>Result Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.results.impl.ResultContributorImpl
		 * @see org.osate.results.impl.ResultsPackageImpl#getResultContributor()
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
		 * The meta object literal for the '{@link org.osate.results.impl.ResultIssueImpl <em>Result Issue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.results.impl.ResultIssueImpl
		 * @see org.osate.results.impl.ResultsPackageImpl#getResultIssue()
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
		 * The meta object literal for the '<em><b>Diagnostic Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_ISSUE__DIAGNOSTIC_ID = eINSTANCE.getResultIssue_DiagnosticId();

		/**
		 * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_ISSUE__ISSUES = eINSTANCE.getResultIssue_Issues();

		/**
		 * The meta object literal for the '{@link org.osate.results.impl.ResultDataSpecImpl <em>Result Data Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.results.impl.ResultDataSpecImpl
		 * @see org.osate.results.impl.ResultsPackageImpl#getResultDataSpec()
		 * @generated
		 */
		EClass RESULT_DATA_SPEC = eINSTANCE.getResultDataSpec();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT_DATA_SPEC__NAME = eINSTANCE.getResultDataSpec_Name();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT_DATA_SPEC__UNIT = eINSTANCE.getResultDataSpec_Unit();

		/**
		 * The meta object literal for the '{@link org.osate.results.ResultIssueType <em>Result Issue Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.results.ResultIssueType
		 * @see org.osate.results.impl.ResultsPackageImpl#getResultIssueType()
		 * @generated
		 */
		EEnum RESULT_ISSUE_TYPE = eINSTANCE.getResultIssueType();

	}

} //ResultsPackage
