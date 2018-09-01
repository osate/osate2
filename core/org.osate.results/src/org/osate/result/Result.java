/**
 */
package org.osate.result;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.result.Result#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.result.Result#getDiagnostics <em>Diagnostics</em>}</li>
 *   <li>{@link org.osate.result.Result#getSubResults <em>Sub Results</em>}</li>
 * </ul>
 *
 * @see org.osate.result.ResultPackage#getResult()
 * @model
 * @generated
 */
public interface Result extends Diagnostic {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Value}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getResult_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<Value> getValues();

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
	 * @see org.osate.result.ResultPackage#getResult_Diagnostics()
	 * @model containment="true"
	 * @generated
	 */
	EList<Diagnostic> getDiagnostics();

	/**
	 * Returns the value of the '<em><b>Sub Results</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.result.Result}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Contributors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Results</em>' containment reference list.
	 * @see org.osate.result.ResultPackage#getResult_SubResults()
	 * @model containment="true"
	 * @generated
	 */
	EList<Result> getSubResults();

} // Result
