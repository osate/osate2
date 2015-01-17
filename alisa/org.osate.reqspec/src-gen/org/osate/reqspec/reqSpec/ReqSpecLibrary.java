/**
 */
package org.osate.reqspec.reqSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecLibrary#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecLibrary#getImportedNamespace <em>Imported Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecLibrary()
 * @model
 * @generated
 */
public interface ReqSpecLibrary extends ReqSpecContainer
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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecLibrary_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecLibrary#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imported Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imported Namespace</em>' attribute.
   * @see #setImportedNamespace(String)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecLibrary_ImportedNamespace()
   * @model
   * @generated
   */
  String getImportedNamespace();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecLibrary#getImportedNamespace <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imported Namespace</em>' attribute.
   * @see #getImportedNamespace()
   * @generated
   */
  void setImportedNamespace(String value);

} // ReqSpecLibrary
