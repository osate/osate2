/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.EnumType#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getEnumType()
 * @model
 * @generated
 */
public interface EnumType extends EObject, Type
{
  /**
   * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.expr.expr.EnumLiteral}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Literals</em>' containment reference list.
   * @see org.osate.expr.expr.ExprPackage#getEnumType_Literals()
   * @model containment="true"
   * @generated
   */
  EList<EnumLiteral> getLiterals();

} // EnumType
