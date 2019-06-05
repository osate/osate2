/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Union Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.UnionType#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getUnionType()
 * @model
 * @generated
 */
public interface UnionType extends EObject, Type
{
  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.Field}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getUnionType_Fields()
   * @model containment="true"
   * @generated
   */
  EList<Field> getFields();

} // UnionType
