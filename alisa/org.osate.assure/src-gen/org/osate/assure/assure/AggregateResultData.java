/**
 */
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregate Result Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.assure.assure.AggregateResultData#getPassCount <em>Pass Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResultData#getFailCount <em>Fail Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResultData#getNeutralCount <em>Neutral Count</em>}</li>
 *   <li>{@link org.osate.assure.assure.AggregateResultData#getUnknownCount <em>Unknown Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.assure.assure.AssurePackage#getAggregateResultData()
 * @model
 * @generated
 */
public interface AggregateResultData extends EObject
{
  /**
   * Returns the value of the '<em><b>Pass Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pass Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pass Count</em>' attribute.
   * @see #setPassCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAggregateResultData_PassCount()
   * @model
   * @generated
   */
  int getPassCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResultData#getPassCount <em>Pass Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pass Count</em>' attribute.
   * @see #getPassCount()
   * @generated
   */
  void setPassCount(int value);

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
   * @see org.osate.assure.assure.AssurePackage#getAggregateResultData_FailCount()
   * @model
   * @generated
   */
  int getFailCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResultData#getFailCount <em>Fail Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fail Count</em>' attribute.
   * @see #getFailCount()
   * @generated
   */
  void setFailCount(int value);

  /**
   * Returns the value of the '<em><b>Neutral Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Neutral Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Neutral Count</em>' attribute.
   * @see #setNeutralCount(int)
   * @see org.osate.assure.assure.AssurePackage#getAggregateResultData_NeutralCount()
   * @model
   * @generated
   */
  int getNeutralCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResultData#getNeutralCount <em>Neutral Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Neutral Count</em>' attribute.
   * @see #getNeutralCount()
   * @generated
   */
  void setNeutralCount(int value);

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
   * @see org.osate.assure.assure.AssurePackage#getAggregateResultData_UnknownCount()
   * @model
   * @generated
   */
  int getUnknownCount();

  /**
   * Sets the value of the '{@link org.osate.assure.assure.AggregateResultData#getUnknownCount <em>Unknown Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unknown Count</em>' attribute.
   * @see #getUnknownCount()
   * @generated
   */
  void setUnknownCount(int value);

} // AggregateResultData
