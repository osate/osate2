/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Size</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ArraySize#getIntegerValueConstant <em>Integer Value Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getArraySize()
 * @model
 * @generated
 */
public interface ArraySize extends Element
{
   /**
	 * Returns the value of the '<em><b>Integer Value Constant</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Integer Value Constant</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Value Constant</em>' containment reference.
	 * @see #setIntegerValueConstant(ValueConstant)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getArraySize_IntegerValueConstant()
	 * @model containment="true"
	 * @generated
	 */
   ValueConstant getIntegerValueConstant();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ArraySize#getIntegerValueConstant <em>Integer Value Constant</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Value Constant</em>' containment reference.
	 * @see #getIntegerValueConstant()
	 * @generated
	 */
   void setIntegerValueConstant(ValueConstant value);

} // ArraySize
