/**
 */
package org.osate.alisa.common.common;

import org.eclipse.xtext.xbase.XVariableDeclaration;

import org.osate.aadl2.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Consistent Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.PropertyConsistentVariableDeclaration#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getPropertyConsistentVariableDeclaration()
 * @model
 * @generated
 */
public interface PropertyConsistentVariableDeclaration extends XVariableDeclaration
{
  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(Property)
   * @see org.osate.alisa.common.common.CommonPackage#getPropertyConsistentVariableDeclaration_Property()
   * @model
   * @generated
   */
  Property getProperty();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.PropertyConsistentVariableDeclaration#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(Property value);

} // PropertyConsistentVariableDeclaration
