/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.common.util.EList;

import org.osate.alisa.common.common.Import;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecModel#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecModel#getImport <em>Import</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecModel()
 * @model
 * @generated
 */
public interface ReqSpecModel extends ReqSpec, ReqSpecContainer
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecModel#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Import</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import</em>' containment reference list.
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecModel_Import()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImport();

} // ReqSpecModel
