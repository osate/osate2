/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.MapType#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.osate.expr.expr.MapType#getImage <em>Image</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getMapType()
 * @model
 * @generated
 */
public interface MapType extends EObject, Type
{
  /**
   * Returns the value of the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain</em>' containment reference.
   * @see #setDomain(Type)
   * @see org.osate.expr.expr.ExprPackage#getMapType_Domain()
   * @model containment="true"
   * @generated
   */
  Type getDomain();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.MapType#getDomain <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain</em>' containment reference.
   * @see #getDomain()
   * @generated
   */
  void setDomain(Type value);

  /**
   * Returns the value of the '<em><b>Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Image</em>' containment reference.
   * @see #setImage(Type)
   * @see org.osate.expr.expr.ExprPackage#getMapType_Image()
   * @model containment="true"
   * @generated
   */
  Type getImage();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.MapType#getImage <em>Image</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Image</em>' containment reference.
   * @see #getImage()
   * @generated
   */
  void setImage(Type value);

} // MapType
