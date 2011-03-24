/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getValueString <em>Value String</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNumericLiteral()
 * @model abstract="true"
 * @generated
 */
public interface NumericLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value String</em>' attribute.
	 * @see #setValueString(String)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNumericLiteral_ValueString()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.String" required="true"
	 * @generated
	 */
	String getValueString();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getValueString <em>Value String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value String</em>' attribute.
	 * @see #getValueString()
	 * @generated
	 */
	void setValueString(String value);

} // NumericLiteral
