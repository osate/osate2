/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.TypeDecl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.expr.expr.TypeDecl#getOwnedPropertyAssociations <em>Owned Property Associations</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getTypeDecl()
 * @model
 * @generated
 */
public interface TypeDecl extends EDeclaration
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see org.osate.expr.expr.ExprPackage#getTypeDecl_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.TypeDecl#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Owned Property Associations</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.aadl2.PropertyAssociation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Property Associations</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getTypeDecl_OwnedPropertyAssociations()
   * @model containment="true"
   * @generated
   */
  EList<PropertyAssociation> getOwnedPropertyAssociations();

} // TypeDecl
