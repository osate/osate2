/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative ;

import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant ;

import org.osate.aadl2.ArrayDimension ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeArrayDimension#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeArrayDimension()
 * @model
 * @generated
 */
public interface DeclarativeArrayDimension extends ArrayDimension,
                                          DeclarativeBehaviorElement
{
  /**
   * Returns the value of the '<em><b>Dimension</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dimension</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dimension</em>' containment reference.
   * @see #setDimension(IntegerValueConstant)
   * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getDeclarativeArrayDimension_Dimension()
   * @model containment="true" required="true"
   * @generated
   */
  IntegerValueConstant getDimension() ;

  /**
   * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.DeclarativeArrayDimension#getDimension <em>Dimension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dimension</em>' containment reference.
   * @see #getDimension()
   * @generated
   */
  void setDimension(IntegerValueConstant value) ;

} // DeclarativeArrayDimension
