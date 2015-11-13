/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ACollection Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ACollectionLiteral#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getACollectionLiteral()
 * @model
 * @generated
 */
public interface ACollectionLiteral extends AExpression
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.AExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.osate.alisa.common.common.CommonPackage#getACollectionLiteral_Elements()
   * @model containment="true"
   * @generated
   */
  EList<AExpression> getElements();

} // ACollectionLiteral
