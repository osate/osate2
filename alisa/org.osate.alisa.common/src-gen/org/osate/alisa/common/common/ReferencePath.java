/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ReferencePath#getRef <em>Ref</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ReferencePath#getSubpath <em>Subpath</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getReferencePath()
 * @model
 * @generated
 */
public interface ReferencePath extends EObject
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
   * @see #setRef(EObject)
   * @see org.osate.alisa.common.common.CommonPackage#getReferencePath_Ref()
   * @model
   * @generated
   */
  EObject getRef();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ReferencePath#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(EObject value);

  /**
   * Returns the value of the '<em><b>Subpath</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subpath</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subpath</em>' containment reference.
   * @see #setSubpath(ReferencePath)
   * @see org.osate.alisa.common.common.CommonPackage#getReferencePath_Subpath()
   * @model containment="true"
   * @generated
   */
  ReferencePath getSubpath();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ReferencePath#getSubpath <em>Subpath</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subpath</em>' containment reference.
   * @see #getSubpath()
   * @generated
   */
  void setSubpath(ReferencePath value);

} // ReferencePath
