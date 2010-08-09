/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Index</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex#getIntegerValueVariableOwned <em>Integer Value Variable Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getArrayIndex()
 * @model
 * @generated
 */
public interface ArrayIndex extends Element
{
   /**
	 * Returns the value of the '<em><b>Integer Value Variable Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Integer Value Variable Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Value Variable Owned</em>' containment reference.
	 * @see #setIntegerValueVariableOwned(ValueVariable)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getArrayIndex_IntegerValueVariableOwned()
	 * @model containment="true"
	 * @generated
	 */
   ValueVariable getIntegerValueVariableOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex#getIntegerValueVariableOwned <em>Integer Value Variable Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Value Variable Owned</em>' containment reference.
	 * @see #getIntegerValueVariableOwned()
	 * @generated
	 */
   void setIntegerValueVariableOwned(ValueVariable value);

} // ArrayIndex
