/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.properties.properties;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends EObject
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
   * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage#getPropertyDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(PropertyType)
   * @see org.osate.xtext.aadl2.properties.properties.PropertiesPackage#getPropertyDefinition_Type()
   * @model
   * @generated
   */
  PropertyType getType();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.properties.properties.PropertyDefinition#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(PropertyType value);

} // PropertyDefinition
