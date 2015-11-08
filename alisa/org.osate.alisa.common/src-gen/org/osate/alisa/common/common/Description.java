/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.Description#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getDescription()
 * @model
 * @generated
 */
public interface Description extends EObject
{
  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.alisa.common.common.DescriptionElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference list.
   * @see org.osate.alisa.common.common.CommonPackage#getDescription_Description()
   * @model containment="true"
   * @generated
   */
  EList<DescriptionElement> getDescription();

} // Description
