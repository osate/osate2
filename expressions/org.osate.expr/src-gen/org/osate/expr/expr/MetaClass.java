/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.MetaClass#getClass_ <em>Class</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getMetaClass()
 * @model
 * @generated
 */
public interface MetaClass extends EObject, Type
{
  /**
   * Returns the value of the '<em><b>Class</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.expr.expr.MetaClassEnum}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' attribute.
   * @see org.osate.expr.expr.MetaClassEnum
   * @see #setClass(MetaClassEnum)
   * @see org.osate.expr.expr.ExprPackage#getMetaClass_Class()
   * @model
   * @generated
   */
  MetaClassEnum getClass_();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.MetaClass#getClass_ <em>Class</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' attribute.
   * @see org.osate.expr.expr.MetaClassEnum
   * @see #getClass_()
   * @generated
   */
  void setClass(MetaClassEnum value);

} // MetaClass
