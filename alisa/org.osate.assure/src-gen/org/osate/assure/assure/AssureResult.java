/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AssureResult#getSuccessCount <em>Success Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getErrorCount <em>Error Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getFailthenCount <em>Failthen Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getSkippedCount <em>Skipped Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getTotalCount <em>Total Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAssureResult()
 * @model
 * @generated
 */
public interface AssureResult extends EObject
{
  /**
   * Returns the value of the '<em><b>Success Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Success Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Success Count</em>' attribute.
   * @see #setSuccessCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_SuccessCount()
   * @model
   * @generated
   */
  int getSuccessCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getSuccessCount <em>Success Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Success Count</em>' attribute.
   * @see #getSuccessCount()
   * @generated
   */
  void setSuccessCount(int value);

  /**
   * Returns the value of the '<em><b>Fail Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fail Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fail Count</em>' attribute.
   * @see #setFailCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_FailCount()
   * @model
   * @generated
   */
  int getFailCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getFailCount <em>Fail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Count</em>' attribute.
   * @see #getFailCount()
   * @generated
   */
  void setFailCount(int value);

  /**
   * Returns the value of the '<em><b>Error Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Count</em>' attribute.
   * @see #setErrorCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_ErrorCount()
   * @model
   * @generated
   */
  int getErrorCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getErrorCount <em>Error Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Count</em>' attribute.
   * @see #getErrorCount()
   * @generated
   */
  void setErrorCount(int value);

  /**
   * Returns the value of the '<em><b>Failthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Failthen Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Failthen Count</em>' attribute.
   * @see #setFailthenCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_FailthenCount()
   * @model
   * @generated
   */
  int getFailthenCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getFailthenCount <em>Failthen Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Failthen Count</em>' attribute.
   * @see #getFailthenCount()
   * @generated
   */
  void setFailthenCount(int value);

  /**
   * Returns the value of the '<em><b>Skipped Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skipped Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Skipped Count</em>' attribute.
   * @see #setSkippedCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_SkippedCount()
   * @model
   * @generated
   */
  int getSkippedCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getSkippedCount <em>Skipped Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Skipped Count</em>' attribute.
   * @see #getSkippedCount()
   * @generated
   */
  void setSkippedCount(int value);

  /**
   * Returns the value of the '<em><b>Total Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Total Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Total Count</em>' attribute.
   * @see #setTotalCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_TotalCount()
   * @model
   * @generated
   */
  int getTotalCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getTotalCount <em>Total Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Total Count</em>' attribute.
   * @see #getTotalCount()
   * @generated
   */
  void setTotalCount(int value);

  /**
   * Returns the value of the '<em><b>Weight</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Weight</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Weight</em>' attribute.
   * @see #setWeight(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_Weight()
   * @model
   * @generated
   */
  int getWeight();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getWeight <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' attribute.
   * @see #getWeight()
   * @generated
   */
  void setWeight(int value);

} // AssureResult
