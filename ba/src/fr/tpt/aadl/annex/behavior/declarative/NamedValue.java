/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#getReference <em>Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#isFresh <em>Fresh</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#isCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getNamedValue()
 * @model
 * @generated
 */
public interface NamedValue extends IntegerValueVariable, ValueVariable,
                           DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' containment reference.
   * @see #setReference(Reference)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getNamedValue_Reference()
   * @model containment="true" required="true"
   * @generated
   */
  Reference getReference() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Reference value) ;

  /**
   * Returns the value of the '<em><b>Dequeue</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dequeue</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dequeue</em>' attribute.
   * @see #setDequeue(boolean)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getNamedValue_Dequeue()
   * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
   * @generated
   */
  boolean isDequeue() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#isDequeue <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dequeue</em>' attribute.
   * @see #isDequeue()
   * @generated
   */
  void setDequeue(boolean value) ;

  /**
   * Returns the value of the '<em><b>Fresh</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fresh</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fresh</em>' attribute.
   * @see #setFresh(boolean)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getNamedValue_Fresh()
   * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
   * @generated
   */
  boolean isFresh() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#isFresh <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fresh</em>' attribute.
   * @see #isFresh()
   * @generated
   */
  void setFresh(boolean value) ;

  /**
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * The default value is <code>"false"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(boolean)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getNamedValue_Count()
   * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
   * @generated
   */
  boolean isCount() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.NamedValue#isCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #isCount()
   * @generated
   */
  void setCount(boolean value) ;

} // NamedValue
