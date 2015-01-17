/**
 */
package org.osate.categories.categories;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Fail Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.categories.categories.ExecutionFailCategory#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.categories.categories.ExecutionFailCategory#getExtends <em>Extends</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.categories.categories.CategoriesPackage#getExecutionFailCategory()
 * @model
 * @generated
 */
public interface ExecutionFailCategory extends EObject
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
   * @see org.osate.categories.categories.CategoriesPackage#getExecutionFailCategory_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.ExecutionFailCategory#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Extends</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' reference.
   * @see #setExtends(ExecutionFailCategory)
   * @see org.osate.categories.categories.CategoriesPackage#getExecutionFailCategory_Extends()
   * @model
   * @generated
   */
  ExecutionFailCategory getExtends();

  /**
   * Sets the value of the '{@link org.osate.categories.categories.ExecutionFailCategory#getExtends <em>Extends</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(ExecutionFailCategory value);

} // ExecutionFailCategory
