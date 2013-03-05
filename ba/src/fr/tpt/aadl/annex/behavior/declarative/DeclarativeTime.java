/**
 */
package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeout ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeTime#getUnitId <em>Unit Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeTime()
 * @model
 * @generated
 */
public interface DeclarativeTime extends BehaviorTime,
                                CompletionRelativeTimeout,
                                DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Unit Id</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unit Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unit Id</em>' containment reference.
   * @see #setUnitId(Identifier)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeTime_UnitId()
   * @model containment="true" required="true"
   * @generated
   */
  Identifier getUnitId() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeTime#getUnitId <em>Unit Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unit Id</em>' containment reference.
   * @see #getUnitId()
   * @generated
   */
  void setUnitId(Identifier value) ;

} // DeclarativeTime
