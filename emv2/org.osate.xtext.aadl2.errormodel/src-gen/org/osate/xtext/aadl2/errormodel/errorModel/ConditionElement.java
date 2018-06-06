/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getQualifiedErrorPropagationReference <em>Qualified Error Propagation Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getConstraint <em>Constraint</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConditionElement()
 * @model
 * @generated
 */
public interface ConditionElement extends Element, ConditionExpression
{
  /**
   * Returns the value of the '<em><b>Qualified Error Propagation Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Error Propagation Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Error Propagation Reference</em>' containment reference.
   * @see #setQualifiedErrorPropagationReference(EMV2Path)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConditionElement_QualifiedErrorPropagationReference()
   * @model containment="true"
   * @generated
   */
  EMV2Path getQualifiedErrorPropagationReference();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getQualifiedErrorPropagationReference <em>Qualified Error Propagation Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Error Propagation Reference</em>' containment reference.
   * @see #getQualifiedErrorPropagationReference()
   * @generated
   */
  void setQualifiedErrorPropagationReference(EMV2Path value);

  /**
   * Returns the value of the '<em><b>Constraint</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constraint</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constraint</em>' containment reference.
   * @see #setConstraint(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConditionElement_Constraint()
   * @model containment="true"
   * @generated
   */
  TypeSet getConstraint();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getConstraint <em>Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constraint</em>' containment reference.
   * @see #getConstraint()
   * @generated
   */
  void setConstraint(TypeSet value);

} // ConditionElement
