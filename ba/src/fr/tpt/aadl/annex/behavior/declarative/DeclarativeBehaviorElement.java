/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement ;

import org.eclipse.emf.ecore.EObject ;

import org.osate.aadl2.Element ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement#getOsateRef <em>Osate Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement#getBaRef <em>Ba Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeBehaviorElement()
 * @model abstract="true"
 * @generated
 */
public interface DeclarativeBehaviorElement extends EObject, BehaviorElement
{
  /**
   * Returns the value of the '<em><b>Osate Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Osate Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Osate Ref</em>' reference.
   * @see #setOsateRef(Element)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeBehaviorElement_OsateRef()
   * @model
   * @generated
   */
  Element getOsateRef() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement#getOsateRef <em>Osate Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Osate Ref</em>' reference.
   * @see #getOsateRef()
   * @generated
   */
  void setOsateRef(Element value) ;

  /**
   * Returns the value of the '<em><b>Ba Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ba Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ba Ref</em>' reference.
   * @see #setBaRef(BehaviorElement)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeBehaviorElement_BaRef()
   * @model
   * @generated
   */
  BehaviorElement getBaRef() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeBehaviorElement#getBaRef <em>Ba Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ba Ref</em>' reference.
   * @see #getBaRef()
   * @generated
   */
  void setBaRef(BehaviorElement value) ;

} // DeclarativeBehaviorElement
