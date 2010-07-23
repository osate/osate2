/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral#isBoolValue <em>Bool Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends ValueConstant
{
   /**
    * Returns the value of the '<em><b>Bool Value</b></em>' attribute.
    * The default value is <code>"false"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Bool Value</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Bool Value</em>' attribute.
    * @see #setBoolValue(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBooleanLiteral_BoolValue()
    * @model default="false" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isBoolValue();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BooleanLiteral#isBoolValue <em>Bool Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Bool Value</em>' attribute.
    * @see #isBoolValue()
    * @generated
    */
   void setBoolValue(boolean value);

} // BooleanLiteral
