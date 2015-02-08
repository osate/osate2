/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.RecordExpr#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.RecordExpr#getRecordFields <em>Record Fields</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRecordExpr()
 * @model
 * @generated
 */
public interface RecordExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(TypeDef)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRecordExpr_Type()
   * @model
   * @generated
   */
  TypeDef getType();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.RecordExpr#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeDef value);

  /**
   * Returns the value of the '<em><b>Record Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.reqspec.reqSpec.RecordFieldExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Fields</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getRecordExpr_RecordFields()
   * @model containment="true"
   * @generated
   */
  EList<RecordFieldExpr> getRecordFields();

} // RecordExpr
