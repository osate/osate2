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
 *   <li>{@link org.osate.result.AnalysisResult#getInfo <em>Info</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getSourceReference <em>Source Reference</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.result.AnalysisResult#getDiagnostics <em>Diagnostics</em>}</li>
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
	 * Returns the value of the '<em><b>Info</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Info</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Info</em>' attribute.
	 * @see #setInfo(String)
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Info()
	 * @model
	 * @generated
	 */
	String getInfo();

	/**
	 * Sets the value of the '{@link org.osate.result.AnalysisResult#getInfo <em>Info</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Info</em>' attribute.
	 * @see #getInfo()
	 * @generated
	 */
	void setInfo(String value);

	/**
	 * Returns the value of the '<em><b>Source Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Reference</em>' reference.
	 * @see #setSourceReference(EObject)
	 * @see org.osate.result.ResultPackage#getAnalysisResult_SourceReference()
	 * @model
	 * @generated
	 */
	EObject getSourceReference();

	/**
	 * Sets the value of the '{@link org.osate.result.AnalysisResult#getSourceReference <em>Source Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Reference</em>' reference.
	 * @see #getSourceReference()
	 * @generated
	 */
	void setSourceReference(EObject value);

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
	 * Returns the value of the '<em><b>Diagnostics</b></em>' reference list.
	 * The list contents are of type {@link org.osate.result.Diagnostic}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @deprecated
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagnostics</em>' reference list.
	 * @see org.osate.result.ResultPackage#getAnalysisResult_Diagnostics()
	 * @model
	 * @generated
	 */
	EList<Diagnostic> getDiagnostics();

} // AnalysisResult
