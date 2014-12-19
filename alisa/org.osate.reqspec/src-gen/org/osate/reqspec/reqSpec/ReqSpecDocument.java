/**
 */
package org.osate.reqspec.reqSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.ReqSpecDocument#getDocref <em>Docref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecDocument()
 * @model
 * @generated
 */
public interface ReqSpecDocument extends ReqSpec
{
  /**
   * Returns the value of the '<em><b>Docref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Docref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Docref</em>' containment reference.
   * @see #setDocref(ExternalDocument)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getReqSpecDocument_Docref()
   * @model containment="true"
   * @generated
   */
  ExternalDocument getDocref();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.ReqSpecDocument#getDocref <em>Docref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Docref</em>' containment reference.
   * @see #getDocref()
   * @generated
   */
  void setDocref(ExternalDocument value);

} // ReqSpecDocument
