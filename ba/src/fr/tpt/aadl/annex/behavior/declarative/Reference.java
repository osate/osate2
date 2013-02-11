/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.Target ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;

import org.eclipse.emf.common.util.EList ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.Reference#getIds <em>Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends ActualPortHolder,
                          DeclarativeBehaviorElement, IntegerValueVariable,
                          ValueVariable, ElementValues, Target,
                          DispatchTriggerCondition, DispatchTrigger
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' containment reference list.
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getReference_Ids()
   * @model containment="true" required="true"
   * @generated
   */
  EList<ArrayableIdentifier> getIds() ;

} // Reference
