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
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

import org.osate.result.Diagnostic;
import org.osate.result.Result;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Verification Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getIssues <em>Issues</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getResults <em>Results</em>}</li>
 *   <li>{@link org.osate.assure.assure.VerificationResult#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getVerificationResult()
 * @model
 * @generated
 */
public interface VerificationResult extends AssureResult, VerificationExpr
{
  /**
   * Returns the value of the '<em><b>Execution State</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationExecutionState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Execution State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Execution State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #setExecutionState(VerificationExecutionState)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_ExecutionState()
   * @model
   * @generated
   */
  VerificationExecutionState getExecutionState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getExecutionState <em>Execution State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Execution State</em>' attribute.
   * @see org.osate.assure.assure.VerificationExecutionState
   * @see #getExecutionState()
   * @generated
   */
  void setExecutionState(VerificationExecutionState value);

  /**
   * Returns the value of the '<em><b>Result State</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.assure.assure.VerificationResultState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #setResultState(VerificationResultState)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_ResultState()
   * @model
   * @generated
   */
  VerificationResultState getResultState();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getResultState <em>Result State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result State</em>' attribute.
   * @see org.osate.assure.assure.VerificationResultState
   * @see #getResultState()
   * @generated
   */
  void setResultState(VerificationResultState value);

  /**
   * Returns the value of the '<em><b>Issues</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.result.Diagnostic}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Issues</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Issues</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Issues()
   * @model containment="true"
   * @generated
   */
  EList<Diagnostic> getIssues();

  /**
   * Returns the value of the '<em><b>Results</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Results</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Results</em>' reference.
   * @see #setResults(Result)
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Results()
   * @model
   * @generated
   */
  Result getResults();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getResults <em>Results</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Results</em>' reference.
   * @see #getResults()
   * @generated
   */
  void setResults(Result value);

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
   * @see org.osate.assure.assure.AssurePackage#getVerificationResult_Message()
   * @model
   * @generated
   */
  String getMessage();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.VerificationResult#getMessage <em>Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' attribute.
   * @see #getMessage()
   * @generated
   */
  void setMessage(String value);

} // VerificationResult
