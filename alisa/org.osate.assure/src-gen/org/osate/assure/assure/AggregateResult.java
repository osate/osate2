/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregate Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AggregateResult#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResult#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResult#getUnknownCount <em>Unknown Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResult#getTbdCount <em>Tbd Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResult#getWeight <em>Weight</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResult#getSucessMsg <em>Sucess Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAggregateResult()
 * @model
 * @generated
 */
public interface AggregateResult extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.assure.assure.AssurePackage#getAggregateResult_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResult#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see org.osate.assure.assure.AssurePackage#getAggregateResult_FailCount()
   * @model
   * @generated
   */
  int getFailCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResult#getFailCount <em>Fail Count</em>}' attribute.
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
   * @see org.osate.assure.assure.AssurePackage#getAggregateResult_UnknownCount()
   * @model
   * @generated
   */
  int getUnknownCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResult#getUnknownCount <em>Unknown Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unknown Count</em>' attribute.
   * @see #getUnknownCount()
   * @generated
   */
  void setUnknownCount(int value);

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
   * @see org.osate.assure.assure.AssurePackage#getAggregateResult_TbdCount()
   * @model
   * @generated
   */
  int getTbdCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResult#getTbdCount <em>Tbd Count</em>}' attribute.
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
   * @see org.osate.assure.assure.AssurePackage#getAggregateResult_Weight()
   * @model
   * @generated
   */
  int getWeight();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResult#getWeight <em>Weight</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Weight</em>' attribute.
   * @see #getWeight()
   * @generated
   */
  void setWeight(int value);

  /**
   * Returns the value of the '<em><b>Sucess Msg</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sucess Msg</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sucess Msg</em>' attribute.
   * @see #setSucessMsg(String)
   * @see org.osate.assure.assure.AssurePackage#getAggregateResult_SucessMsg()
   * @model
   * @generated
   */
  String getSucessMsg();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResult#getSucessMsg <em>Sucess Msg</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sucess Msg</em>' attribute.
   * @see #getSucessMsg()
   * @generated
   */
  void setSucessMsg(String value);

} // AggregateResult
