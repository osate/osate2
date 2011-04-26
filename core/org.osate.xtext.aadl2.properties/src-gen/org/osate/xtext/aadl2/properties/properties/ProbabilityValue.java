/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.properties.properties;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Probability Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getNumber <em>Number</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getDistribution <em>Distribution</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage#getProbabilityValue()
 * @model
 * @generated
 */
public interface ProbabilityValue extends PropertyExpression
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(String)
   * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage#getProbabilityValue_Number()
   * @model
   * @generated
   */
  String getNumber();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(String value);

  /**
   * Returns the value of the '<em><b>Distribution</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Distribution</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Distribution</em>' attribute.
   * @see #setDistribution(String)
   * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage#getProbabilityValue_Distribution()
   * @model
   * @generated
   */
  String getDistribution();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.properties.properties.ProbabilityValue#getDistribution <em>Distribution</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Distribution</em>' attribute.
   * @see #getDistribution()
   * @generated
   */
  void setDistribution(String value);

} // ProbabilityValue
