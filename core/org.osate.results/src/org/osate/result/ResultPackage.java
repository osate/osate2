/**
 */
package org.osate.result;

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
 * @see org.osate.result.ResultFactory
 * @model kind="package"
 * @generated
 */
public interface ResultPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "result";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.osate.org/result/Result";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "result";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultPackage eINSTANCE = org.osate.result.impl.ResultPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.result.impl.ResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.ResultImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getResult()
	 * @generated
	 */
	int RESULT = 0;

	/**
	 * The feature id for the '<em><b>Analysis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__ANALYSIS = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SOURCE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__VALUES = 3;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__ISSUES = 4;

	/**
	 * The feature id for the '<em><b>Contributors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__CONTRIBUTORS = 5;

	/**
	 * The feature id for the '<em><b>Sub Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT__SUB_RESULTS = 6;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.ContributorImpl <em>Contributor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.ContributorImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getContributor()
	 * @generated
	 */
	int CONTRIBUTOR = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__SOURCE_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__VALUES = 2;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__ISSUES = 3;

	/**
	 * The feature id for the '<em><b>Sub Contributors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR__SUB_CONTRIBUTORS = 4;

	/**
	 * The number of structural features of the '<em>Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Contributor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.IssueImpl <em>Issue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.IssueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getIssue()
	 * @generated
	 */
	int ISSUE = 2;

	/**
	 * The feature id for the '<em><b>Issue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__ISSUE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Source Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__SOURCE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Exception Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__EXCEPTION_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Diagnostic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__DIAGNOSTIC = 4;

	/**
	 * The feature id for the '<em><b>Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__ISSUES = 5;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE__SOURCE = 6;

	/**
	 * The number of structural features of the '<em>Issue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Issue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ISSUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.ValueImpl <em>Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.ValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getValue()
	 * @generated
	 */
	int VALUE = 3;

	/**
	 * The number of structural features of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.IntegerValueImpl <em>Integer Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.IntegerValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getIntegerValue()
	 * @generated
	 */
	int INTEGER_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.RealValueImpl <em>Real Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.RealValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getRealValue()
	 * @generated
	 */
	int REAL_VALUE = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Real Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.StringValueImpl <em>String Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.StringValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getStringValue()
	 * @generated
	 */
	int STRING_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.impl.BooleanValueImpl
	 * @see org.osate.result.impl.ResultPackageImpl#getBooleanValue()
	 * @generated
	 */
	int BOOLEAN_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE__VALUE = VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.result.IssueType <em>Issue Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.result.IssueType
	 * @see org.osate.result.impl.ResultPackageImpl#getIssueType()
	 * @generated
	 */
	int ISSUE_TYPE = 8;


	/**
	 * Returns the meta object for class '{@link org.osate.result.Result <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see org.osate.result.Result
	 * @generated
	 */
	EClass getResult();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Result#getAnalysis <em>Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analysis</em>'.
	 * @see org.osate.result.Result#getAnalysis()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Analysis();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Result#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.result.Result#getSource()
	 * @see #getResult()
	 * @generated
	 */
	EAttribute getResult_Source();

	/**
	 * Returns the meta object for the reference '{@link org.osate.result.Result#getSourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Reference</em>'.
	 * @see org.osate.result.Result#getSourceReference()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_SourceReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.osate.result.Result#getValues()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getIssues <em>Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Issues</em>'.
	 * @see org.osate.result.Result#getIssues()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Issues();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getContributors <em>Contributors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributors</em>'.
	 * @see org.osate.result.Result#getContributors()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_Contributors();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Result#getSubResults <em>Sub Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Results</em>'.
	 * @see org.osate.result.Result#getSubResults()
	 * @see #getResult()
	 * @generated
	 */
	EReference getResult_SubResults();

	/**
	 * Returns the meta object for class '{@link org.osate.result.Contributor <em>Contributor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contributor</em>'.
	 * @see org.osate.result.Contributor
	 * @generated
	 */
	EClass getContributor();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Contributor#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.result.Contributor#getSource()
	 * @see #getContributor()
	 * @generated
	 */
	EAttribute getContributor_Source();

	/**
	 * Returns the meta object for the reference '{@link org.osate.result.Contributor#getSourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Reference</em>'.
	 * @see org.osate.result.Contributor#getSourceReference()
	 * @see #getContributor()
	 * @generated
	 */
	EReference getContributor_SourceReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Contributor#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see org.osate.result.Contributor#getValues()
	 * @see #getContributor()
	 * @generated
	 */
	EReference getContributor_Values();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Contributor#getIssues <em>Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Issues</em>'.
	 * @see org.osate.result.Contributor#getIssues()
	 * @see #getContributor()
	 * @generated
	 */
	EReference getContributor_Issues();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Contributor#getSubContributors <em>Sub Contributors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Contributors</em>'.
	 * @see org.osate.result.Contributor#getSubContributors()
	 * @see #getContributor()
	 * @generated
	 */
	EReference getContributor_SubContributors();

	/**
	 * Returns the meta object for class '{@link org.osate.result.Issue <em>Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Issue</em>'.
	 * @see org.osate.result.Issue
	 * @generated
	 */
	EClass getIssue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Issue#getIssueType <em>Issue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Issue Type</em>'.
	 * @see org.osate.result.Issue#getIssueType()
	 * @see #getIssue()
	 * @generated
	 */
	EAttribute getIssue_IssueType();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Issue#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.osate.result.Issue#getMessage()
	 * @see #getIssue()
	 * @generated
	 */
	EAttribute getIssue_Message();

	/**
	 * Returns the meta object for the reference '{@link org.osate.result.Issue#getSourceReference <em>Source Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Reference</em>'.
	 * @see org.osate.result.Issue#getSourceReference()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_SourceReference();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Issue#getExceptionType <em>Exception Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Type</em>'.
	 * @see org.osate.result.Issue#getExceptionType()
	 * @see #getIssue()
	 * @generated
	 */
	EAttribute getIssue_ExceptionType();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Issue#getDiagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diagnostic</em>'.
	 * @see org.osate.result.Issue#getDiagnostic()
	 * @see #getIssue()
	 * @generated
	 */
	EAttribute getIssue_Diagnostic();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.result.Issue#getIssues <em>Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Issues</em>'.
	 * @see org.osate.result.Issue#getIssues()
	 * @see #getIssue()
	 * @generated
	 */
	EReference getIssue_Issues();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.Issue#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.osate.result.Issue#getSource()
	 * @see #getIssue()
	 * @generated
	 */
	EAttribute getIssue_Source();

	/**
	 * Returns the meta object for class '{@link org.osate.result.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value</em>'.
	 * @see org.osate.result.Value
	 * @generated
	 */
	EClass getValue();

	/**
	 * Returns the meta object for class '{@link org.osate.result.IntegerValue <em>Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Value</em>'.
	 * @see org.osate.result.IntegerValue
	 * @generated
	 */
	EClass getIntegerValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.IntegerValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.IntegerValue#getValue()
	 * @see #getIntegerValue()
	 * @generated
	 */
	EAttribute getIntegerValue_Value();

	/**
	 * Returns the meta object for class '{@link org.osate.result.RealValue <em>Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Value</em>'.
	 * @see org.osate.result.RealValue
	 * @generated
	 */
	EClass getRealValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.RealValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.RealValue#getValue()
	 * @see #getRealValue()
	 * @generated
	 */
	EAttribute getRealValue_Value();

	/**
	 * Returns the meta object for class '{@link org.osate.result.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Value</em>'.
	 * @see org.osate.result.StringValue
	 * @generated
	 */
	EClass getStringValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.StringValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.StringValue#getValue()
	 * @see #getStringValue()
	 * @generated
	 */
	EAttribute getStringValue_Value();

	/**
	 * Returns the meta object for class '{@link org.osate.result.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Value</em>'.
	 * @see org.osate.result.BooleanValue
	 * @generated
	 */
	EClass getBooleanValue();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.result.BooleanValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.osate.result.BooleanValue#isValue()
	 * @see #getBooleanValue()
	 * @generated
	 */
	EAttribute getBooleanValue_Value();

	/**
	 * Returns the meta object for enum '{@link org.osate.result.IssueType <em>Issue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Issue Type</em>'.
	 * @see org.osate.result.IssueType
	 * @generated
	 */
	EEnum getIssueType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResultFactory getResultFactory();

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
		 * The meta object literal for the '{@link org.osate.result.impl.ResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.ResultImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getResult()
		 * @generated
		 */
		EClass RESULT = eINSTANCE.getResult();

		/**
		 * The meta object literal for the '<em><b>Analysis</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__ANALYSIS = eINSTANCE.getResult_Analysis();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESULT__SOURCE = eINSTANCE.getResult_Source();

		/**
		 * The meta object literal for the '<em><b>Source Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__SOURCE_REFERENCE = eINSTANCE.getResult_SourceReference();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__VALUES = eINSTANCE.getResult_Values();

		/**
		 * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__ISSUES = eINSTANCE.getResult_Issues();

		/**
		 * The meta object literal for the '<em><b>Contributors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__CONTRIBUTORS = eINSTANCE.getResult_Contributors();

		/**
		 * The meta object literal for the '<em><b>Sub Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESULT__SUB_RESULTS = eINSTANCE.getResult_SubResults();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.ContributorImpl <em>Contributor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.ContributorImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getContributor()
		 * @generated
		 */
		EClass CONTRIBUTOR = eINSTANCE.getContributor();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTOR__SOURCE = eINSTANCE.getContributor_Source();

		/**
		 * The meta object literal for the '<em><b>Source Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTOR__SOURCE_REFERENCE = eINSTANCE.getContributor_SourceReference();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTOR__VALUES = eINSTANCE.getContributor_Values();

		/**
		 * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTOR__ISSUES = eINSTANCE.getContributor_Issues();

		/**
		 * The meta object literal for the '<em><b>Sub Contributors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTOR__SUB_CONTRIBUTORS = eINSTANCE.getContributor_SubContributors();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.IssueImpl <em>Issue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.IssueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getIssue()
		 * @generated
		 */
		EClass ISSUE = eINSTANCE.getIssue();

		/**
		 * The meta object literal for the '<em><b>Issue Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISSUE__ISSUE_TYPE = eINSTANCE.getIssue_IssueType();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISSUE__MESSAGE = eINSTANCE.getIssue_Message();

		/**
		 * The meta object literal for the '<em><b>Source Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISSUE__SOURCE_REFERENCE = eINSTANCE.getIssue_SourceReference();

		/**
		 * The meta object literal for the '<em><b>Exception Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISSUE__EXCEPTION_TYPE = eINSTANCE.getIssue_ExceptionType();

		/**
		 * The meta object literal for the '<em><b>Diagnostic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISSUE__DIAGNOSTIC = eINSTANCE.getIssue_Diagnostic();

		/**
		 * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ISSUE__ISSUES = eINSTANCE.getIssue_Issues();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ISSUE__SOURCE = eINSTANCE.getIssue_Source();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.ValueImpl <em>Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.ValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getValue()
		 * @generated
		 */
		EClass VALUE = eINSTANCE.getValue();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.IntegerValueImpl <em>Integer Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.IntegerValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getIntegerValue()
		 * @generated
		 */
		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_VALUE__VALUE = eINSTANCE.getIntegerValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.RealValueImpl <em>Real Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.RealValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getRealValue()
		 * @generated
		 */
		EClass REAL_VALUE = eINSTANCE.getRealValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_VALUE__VALUE = eINSTANCE.getRealValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.StringValueImpl <em>String Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.StringValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getStringValue()
		 * @generated
		 */
		EClass STRING_VALUE = eINSTANCE.getStringValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.impl.BooleanValueImpl
		 * @see org.osate.result.impl.ResultPackageImpl#getBooleanValue()
		 * @generated
		 */
		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

		/**
		 * The meta object literal for the '{@link org.osate.result.IssueType <em>Issue Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.result.IssueType
		 * @see org.osate.result.impl.ResultPackageImpl#getIssueType()
		 * @generated
		 */
		EEnum ISSUE_TYPE = eINSTANCE.getIssueType();

	}

} //ResultPackage
