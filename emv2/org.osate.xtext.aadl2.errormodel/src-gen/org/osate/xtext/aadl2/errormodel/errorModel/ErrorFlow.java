/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow#getFlowcondition <em>Flowcondition</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorFlow()
 * @model
 * @generated
 */
public interface ErrorFlow extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>Type Token Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Token Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Token Constraint</em>' containment reference.
   * @see #setTypeTokenConstraint(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorFlow_TypeTokenConstraint()
   * @model containment="true"
   * @generated
   */
  TypeSet getTypeTokenConstraint();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow#getTypeTokenConstraint <em>Type Token Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Token Constraint</em>' containment reference.
   * @see #getTypeTokenConstraint()
   * @generated
   */
  void setTypeTokenConstraint(TypeSet value);

  /**
   * Returns the value of the '<em><b>Flowcondition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flowcondition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Flowcondition</em>' attribute.
   * @see #setFlowcondition(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorFlow_Flowcondition()
   * @model
   * @generated
   */
  String getFlowcondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow#getFlowcondition <em>Flowcondition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Flowcondition</em>' attribute.
   * @see #getFlowcondition()
   * @generated
   */
  void setFlowcondition(String value);

} // ErrorFlow
