/**
 */
package org.osate.alisa.common.common;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AVariable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.AVariableReference#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getAVariableReference()
 * @model
 * @generated
 */
public interface AVariableReference extends AExpression
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' reference.
   * @see #setVariable(AVariableDeclaration)
   * @see org.osate.alisa.common.common.CommonPackage#getAVariableReference_Variable()
   * @model
   * @generated
   */
  AVariableDeclaration getVariable();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AVariableReference#getVariable <em>Variable</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(AVariableDeclaration value);

} // AVariableReference
