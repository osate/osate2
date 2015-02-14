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
 *   <li>{@link org.osate.assure.assure.AssureResult#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getFailthenCount <em>Failthen Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getAndthenCount <em>Andthen Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AssureResult#getTbdCount <em>Tbd Count</em>}</li>
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
   * Returns the value of the '<em><b>Unknown Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unknown Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unknown Count</em>' attribute.
   * @see #setUnknownCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_UnknownCount()
   * @model
   * @generated
   */
  int getUnknownCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getUnknownCount <em>Unknown Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unknown Count</em>' attribute.
   * @see #getUnknownCount()
   * @generated
   */
  void setUnknownCount(int value);

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
   * Returns the value of the '<em><b>Andthen Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Andthen Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Andthen Count</em>' attribute.
   * @see #setAndthenCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_AndthenCount()
   * @model
   * @generated
   */
  int getAndthenCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getAndthenCount <em>Andthen Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Andthen Count</em>' attribute.
   * @see #getAndthenCount()
   * @generated
   */
  void setAndthenCount(int value);

  /**
   * Returns the value of the '<em><b>Tbd Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tbd Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tbd Count</em>' attribute.
   * @see #setTbdCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAssureResult_TbdCount()
   * @model
   * @generated
   */
  int getTbdCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AssureResult#getTbdCount <em>Tbd Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tbd Count</em>' attribute.
   * @see #getTbdCount()
   * @generated
   */
  void setTbdCount(int value);

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
