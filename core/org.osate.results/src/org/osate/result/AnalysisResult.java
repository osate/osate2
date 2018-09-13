/**
 */
package org.osate.result;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AnalysisResult</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.AnalysisResult#getAnalysis <em>Analysis</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getDiagnostics <em>Diagnostics</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getResultType <em>Result Type</em>}</li>
 * </ul>
 *
 * @see org.osate.result.ResultPackage#getAnalysisResult()
 * @model
 * @generated
 */
public interface AnalysisResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Analysis</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis</em>' attribute.
	 * @see #setAnalysis(String)
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Analysis()
	 * @model
	 * @generated
	 */
	String getAnalysis();

	/**
	 * Sets the value of the '{@link org.osate.result.AnalysisResult#getAnalysis <em>Analysis</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis</em>' attribute.
	 * @see #getAnalysis()
	 * @generated
	 */
	void setAnalysis(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.result.AnalysisResult#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' reference.
	 * @see #setModelElement(EObject)
	 * @see org.osate.result.ResultPackage#getAnalysisResult_ModelElement()
	 * @model
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link org.osate.result.AnalysisResult#getModelElement <em>Model Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.ObjectValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectValue> getParameters();

	/**
	 * Returns the value of the '<em><b>Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Result}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Results</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Results()
	 * @model containment="true"
	 * @generated
	 */
	EList<Result> getResults();

	/**
	 * Returns the value of the '<em><b>Diagnostics</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Diagnostic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagnostics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagnostics</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Diagnostics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Diagnostic> getDiagnostics();

	/**
	 * Returns the value of the '<em><b>Result Type</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.osate.result.ResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Type</em>' attribute.
	 * @see org.osate.result.ResultType
	 * @see #setResultType(ResultType)
	 * @see org.osate.result.ResultPackage#getAnalysisResult_ResultType()
	 * @model default="NONE"
	 * @generated
	 */
	ResultType getResultType();

	/**
	 * Sets the value of the '{@link org.osate.result.AnalysisResult#getResultType <em>Result Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Type</em>' attribute.
	 * @see org.osate.result.ResultType
	 * @see #getResultType()
	 * @generated
	 */
	void setResultType(ResultType value);

} // AnalysisResult
