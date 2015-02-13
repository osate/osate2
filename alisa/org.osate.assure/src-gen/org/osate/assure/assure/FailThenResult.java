/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fail Then Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.FailThenResult#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.FailThenResult#getSecond <em>Second</em>}</li>
 *   <li>{@link org.osate.assure.assure.FailThenResult#isFailThen <em>Fail Then</em>}</li>
 *   <li>{@link org.osate.assure.assure.FailThenResult#isErrorThen <em>Error Then</em>}</li>
 *   <li>{@link org.osate.assure.assure.FailThenResult#isDidFail <em>Did Fail</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getFailThenResult()
 * @model
 * @generated
 */
public interface FailThenResult extends VerificationExpr
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getFailThenResult_First()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getFirst();

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference list.
   * @see org.osate.assure.assure.AssurePackage#getFailThenResult_Second()
   * @model containment="true"
   * @generated
   */
  EList<VerificationExpr> getSecond();

  /**
   * Returns the value of the '<em><b>Fail Then</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Then</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Then</em>' attribute.
   * @see #setFailThen(boolean)
   * @see org.osate.assure.assure.AssurePackage#getFailThenResult_FailThen()
   * @model
   * @generated
   */
  boolean isFailThen();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.FailThenResult#isFailThen <em>Fail Then</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Then</em>' attribute.
   * @see #isFailThen()
   * @generated
   */
  void setFailThen(boolean value);

  /**
   * Returns the value of the '<em><b>Error Then</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Then</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Then</em>' attribute.
   * @see #setErrorThen(boolean)
   * @see org.osate.assure.assure.AssurePackage#getFailThenResult_ErrorThen()
   * @model
   * @generated
   */
  boolean isErrorThen();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.FailThenResult#isErrorThen <em>Error Then</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Then</em>' attribute.
   * @see #isErrorThen()
   * @generated
   */
  void setErrorThen(boolean value);

  /**
   * Returns the value of the '<em><b>Did Fail</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Did Fail</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Did Fail</em>' attribute.
   * @see #setDidFail(boolean)
   * @see org.osate.assure.assure.AssurePackage#getFailThenResult_DidFail()
   * @model
   * @generated
   */
  boolean isDidFail();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.FailThenResult#isDidFail <em>Did Fail</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Did Fail</em>' attribute.
   * @see #isDidFail()
   * @generated
   */
  void setDidFail(boolean value);

} // FailThenResult
