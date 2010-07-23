/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.StringLiteral#getStringValue <em>String Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getStringLiteral()
 * @model
 * @generated
 */
public interface StringLiteral extends ValueConstant
{
   /**
    * Returns the value of the '<em><b>String Value</b></em>' attribute.
    * The default value is <code>""</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>String Value</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>String Value</em>' attribute.
    * @see #setStringValue(String)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getStringLiteral_StringValue()
    * @model default="" dataType="fr.tpt.aadl.annex.behavior.aadlba.String"
    * @generated
    */
   String getStringValue();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.StringLiteral#getStringValue <em>String Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>String Value</em>' attribute.
    * @see #getStringValue()
    * @generated
    */
   void setStringValue(String value);

} // StringLiteral
