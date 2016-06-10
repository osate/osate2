/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outgoing Propagation Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getTypeTokenConstraint <em>Type Token Constraint</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#isAllStates <em>All States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#isAllPropagations <em>All Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getTypeToken <em>Type Token</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition()
 * @model
 * @generated
 */
public interface OutgoingPropagationCondition extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_State()
   * @model
   * @generated
   */
  ErrorBehaviorState getState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(ErrorBehaviorState value);

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
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_TypeTokenConstraint()
   * @model containment="true"
   * @generated
   */
  TypeSet getTypeTokenConstraint();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getTypeTokenConstraint <em>Type Token Constraint</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Token Constraint</em>' containment reference.
   * @see #getTypeTokenConstraint()
   * @generated
   */
  void setTypeTokenConstraint(TypeSet value);

  /**
   * Returns the value of the '<em><b>All States</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All States</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>All States</em>' attribute.
   * @see #setAllStates(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_AllStates()
   * @model
   * @generated
   */
  boolean isAllStates();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#isAllStates <em>All States</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All States</em>' attribute.
   * @see #isAllStates()
   * @generated
   */
  void setAllStates(boolean value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ConditionExpression)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_Condition()
   * @model containment="true"
   * @generated
   */
  ConditionExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ConditionExpression value);

  /**
   * Returns the value of the '<em><b>Outgoing</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outgoing</em>' reference.
   * @see #setOutgoing(ErrorPropagation)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_Outgoing()
   * @model
   * @generated
   */
  ErrorPropagation getOutgoing();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getOutgoing <em>Outgoing</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outgoing</em>' reference.
   * @see #getOutgoing()
   * @generated
   */
  void setOutgoing(ErrorPropagation value);

  /**
   * Returns the value of the '<em><b>All Propagations</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>All Propagations</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>All Propagations</em>' attribute.
   * @see #setAllPropagations(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_AllPropagations()
   * @model
   * @generated
   */
  boolean isAllPropagations();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#isAllPropagations <em>All Propagations</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All Propagations</em>' attribute.
   * @see #isAllPropagations()
   * @generated
   */
  void setAllPropagations(boolean value);

  /**
   * Returns the value of the '<em><b>Type Token</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Token</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Token</em>' containment reference.
   * @see #setTypeToken(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOutgoingPropagationCondition_TypeToken()
   * @model containment="true"
   * @generated
   */
  TypeSet getTypeToken();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition#getTypeToken <em>Type Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Token</em>' containment reference.
   * @see #getTypeToken()
   * @generated
   */
  void setTypeToken(TypeSet value);

} // OutgoingPropagationCondition
