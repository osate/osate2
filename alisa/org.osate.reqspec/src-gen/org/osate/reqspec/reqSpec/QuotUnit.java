/**
 */
package org.osate.reqspec.reqSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quot Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.QuotUnit#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.QuotUnit#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuotUnit()
 * @model
 * @generated
 */
public interface QuotUnit extends Unit
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Unit)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuotUnit_Left()
   * @model containment="true"
   * @generated
   */
  Unit getLeft();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.QuotUnit#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Unit value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Unit)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getQuotUnit_Right()
   * @model containment="true"
   * @generated
   */
  Unit getRight();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.QuotUnit#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Unit value);

} // QuotUnit
