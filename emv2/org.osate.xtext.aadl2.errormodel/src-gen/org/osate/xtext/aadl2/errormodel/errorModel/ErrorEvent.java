/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent#getTypeSet <em>Type Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent#getEventcondition <em>Eventcondition</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorEvent()
 * @model
 * @generated
 */
public interface ErrorEvent extends ErrorBehaviorEvent
{
  /**
   * Returns the value of the '<em><b>Type Set</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Set</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Set</em>' containment reference.
   * @see #setTypeSet(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorEvent_TypeSet()
   * @model containment="true"
   * @generated
   */
  TypeSet getTypeSet();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent#getTypeSet <em>Type Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Set</em>' containment reference.
   * @see #getTypeSet()
   * @generated
   */
  void setTypeSet(TypeSet value);

  /**
   * Returns the value of the '<em><b>Eventcondition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Eventcondition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Eventcondition</em>' attribute.
   * @see #setEventcondition(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorEvent_Eventcondition()
   * @model
   * @generated
   */
  String getEventcondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent#getEventcondition <em>Eventcondition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Eventcondition</em>' attribute.
   * @see #getEventcondition()
   * @generated
   */
  void setEventcondition(String value);

} // ErrorEvent
