/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant ;

import org.osate.aadl2.DataClassifier ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement#getBaNamespace <em>Ba Namespace</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement#getBaName <em>Ba Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getQualifiedNamedElement()
 * @model
 * @generated
 */
public interface QualifiedNamedElement extends DataClassifier,
                                      DeclarativeBehaviorElement,
                                      ValueConstant, IntegerValueConstant
{
  /**
   * Returns the value of the '<em><b>Ba Namespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ba Namespace</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ba Namespace</em>' containment reference.
   * @see #setBaNamespace(Identifier)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getQualifiedNamedElement_BaNamespace()
   * @model containment="true"
   * @generated
   */
  Identifier getBaNamespace() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement#getBaNamespace <em>Ba Namespace</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ba Namespace</em>' containment reference.
   * @see #getBaNamespace()
   * @generated
   */
  void setBaNamespace(Identifier value) ;

  /**
   * Returns the value of the '<em><b>Ba Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ba Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ba Name</em>' containment reference.
   * @see #setBaName(Identifier)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getQualifiedNamedElement_BaName()
   * @model containment="true" required="true"
   * @generated
   */
  Identifier getBaName() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.QualifiedNamedElement#getBaName <em>Ba Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ba Name</em>' containment reference.
   * @see #getBaName()
   * @generated
   */
  void setBaName(Identifier value) ;

} // QualifiedNamedElement
