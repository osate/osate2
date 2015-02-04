/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ConstantDecl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ConstantDecl#getConstantvalue <em>Constantvalue</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getConstantDecl()
 * @model
 * @generated
 */
public interface ConstantDecl extends EObject
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
   * @see org.osate.alisa.common.common.CommonPackage#getConstantDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ConstantDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Constantvalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constantvalue</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constantvalue</em>' containment reference.
   * @see #setConstantvalue(ConstantValue)
   * @see org.osate.alisa.common.common.CommonPackage#getConstantDecl_Constantvalue()
   * @model containment="true"
   * @generated
   */
  ConstantValue getConstantvalue();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ConstantDecl#getConstantvalue <em>Constantvalue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constantvalue</em>' containment reference.
   * @see #getConstantvalue()
   * @generated
   */
  void setConstantvalue(ConstantValue value);

} // ConstantDecl
