/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral#getNumeralValue <em>Numeral Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNumeral()
 * @model
 * @generated
 */
public interface Numeral extends Element
{
   /**
	 * Returns the value of the '<em><b>Numeral Value</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Numeral Value</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Numeral Value</em>' attribute.
	 * @see #setNumeralValue(int)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNumeral_NumeralValue()
	 * @model default="-1" dataType="fr.tpt.aadl.annex.behavior.aadlba.Integer"
	 * @generated
	 */
   int getNumeralValue();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Numeral#getNumeralValue <em>Numeral Value</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numeral Value</em>' attribute.
	 * @see #getNumeralValue()
	 * @generated
	 */
   void setNumeralValue(int value);

} // Numeral
