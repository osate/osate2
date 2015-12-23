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
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getQualifiedState <em>Qualified State</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConditionElement()
 * @model
 * @generated
 */
public interface ConditionElement extends Element, ConditionExpression
{
  /**
   * Returns the value of the '<em><b>Incoming</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Incoming</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Incoming</em>' reference.
   * @see #setIncoming(EventOrPropagation)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConditionElement_Incoming()
   * @model
   * @generated
   */
  EventOrPropagation getIncoming();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getIncoming <em>Incoming</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Incoming</em>' reference.
   * @see #getIncoming()
   * @generated
   */
  void setIncoming(EventOrPropagation value);

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

  /**
   * Returns the value of the '<em><b>Qualified State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified State</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified State</em>' containment reference.
   * @see #setQualifiedState(QualifiedErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getConditionElement_QualifiedState()
   * @model containment="true"
   * @generated
   */
  QualifiedErrorBehaviorState getQualifiedState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement#getQualifiedState <em>Qualified State</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified State</em>' containment reference.
   * @see #getQualifiedState()
   * @generated
   */
  void setQualifiedState(QualifiedErrorBehaviorState value);

} // ConditionElement
