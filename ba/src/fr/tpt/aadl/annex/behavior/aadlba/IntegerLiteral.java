/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getValue <em>Value</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getBase <em>Base</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIntegerLiteral()
 * @model
 * @generated
 */
public interface IntegerLiteral extends NumericLiteral {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(long)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIntegerLiteral_Value()
	 * @model default="-1" dataType="edu.cmu.sei.aadl.aadl2.Integer" required="true"
	 * @generated
	 */
	long getValue();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(long value);

	/**
	 * Returns the value of the '<em><b>Base</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' attribute.
	 * @see #setBase(int)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getIntegerLiteral_Base()
	 * @model default="-1" dataType="fr.tpt.aadl.annex.behavior.aadlba.Integer" required="true"
	 * @generated
	 */
	int getBase();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.IntegerLiteral#getBase <em>Base</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' attribute.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(int value);

} // IntegerLiteral
