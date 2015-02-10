/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XVariableDeclaration;

import org.osate.aadl2.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Val To Property Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ValToPropertyMapping#getConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ValToPropertyMapping#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValToPropertyMapping()
 * @model
 * @generated
 */
public interface ValToPropertyMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' reference.
   * @see #setConstant(XVariableDeclaration)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValToPropertyMapping_Constant()
   * @model
   * @generated
   */
  XVariableDeclaration getConstant();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ValToPropertyMapping#getConstant <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constant</em>' reference.
   * @see #getConstant()
   * @generated
   */
  void setConstant(XVariableDeclaration value);

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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getValToPropertyMapping_Property()
   * @model
   * @generated
   */
  Property getProperty();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ValToPropertyMapping#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(Property value);

} // ValToPropertyMapping
