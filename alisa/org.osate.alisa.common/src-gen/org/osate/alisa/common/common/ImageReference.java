/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ImageReference#getImgfile <em>Imgfile</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getImageReference()
 * @model
 * @generated
 */
public interface ImageReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Imgfile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imgfile</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imgfile</em>' attribute.
   * @see #setImgfile(String)
   * @see org.osate.alisa.common.common.CommonPackage#getImageReference_Imgfile()
   * @model
   * @generated
   */
  String getImgfile();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ImageReference#getImgfile <em>Imgfile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imgfile</em>' attribute.
   * @see #getImgfile()
   * @generated
   */
  void setImgfile(String value);

} // ImageReference
