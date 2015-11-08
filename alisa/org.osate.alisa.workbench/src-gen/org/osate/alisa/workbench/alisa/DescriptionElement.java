/**
 */
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.workbench.alisa.DescriptionElement#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.workbench.alisa.DescriptionElement#isThisTarget <em>This Target</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.workbench.alisa.AlisaPackage#getDescriptionElement()
 * @model
 * @generated
 */
public interface DescriptionElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getDescriptionElement_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.DescriptionElement#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>This Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>This Target</em>' attribute.
   * @see #setThisTarget(boolean)
   * @see org.osate.alisa.workbench.alisa.AlisaPackage#getDescriptionElement_ThisTarget()
   * @model
   * @generated
   */
  boolean isThisTarget();

  /**
   * Sets the value of the '{@link org.osate.alisa.workbench.alisa.DescriptionElement#isThisTarget <em>This Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>This Target</em>' attribute.
   * @see #isThisTarget()
   * @generated
   */
  void setThisTarget(boolean value);

} // DescriptionElement
