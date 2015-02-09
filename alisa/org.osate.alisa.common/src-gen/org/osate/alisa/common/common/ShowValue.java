/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xbase.XVariableDeclaration;

import org.osate.aadl2.UnitLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Show Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ShowValue#getRef <em>Ref</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ShowValue#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getShowValue()
 * @model
 * @generated
 */
public interface ShowValue extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(XVariableDeclaration)
   * @see org.osate.alisa.common.common.CommonPackage#getShowValue_Ref()
   * @model
   * @generated
   */
  XVariableDeclaration getRef();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ShowValue#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(XVariableDeclaration value);

  /**
   * Returns the value of the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit</em>' reference.
   * @see #setUnit(UnitLiteral)
   * @see org.osate.alisa.common.common.CommonPackage#getShowValue_Unit()
   * @model
   * @generated
   */
  UnitLiteral getUnit();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ShowValue#getUnit <em>Unit</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit</em>' reference.
   * @see #getUnit()
   * @generated
   */
  void setUnit(UnitLiteral value);

} // ShowValue
