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
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getNumValue <em>Num Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNumericLiteral()
 * @model
 * @generated
 */
public interface NumericLiteral extends ValueConstant
{
   /**
    * Returns the value of the '<em><b>Num Value</b></em>' attribute.
    * The default value is <code>""</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Num Value</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Num Value</em>' attribute.
    * @see #setNumValue(String)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getNumericLiteral_NumValue()
    * @model default="" dataType="fr.tpt.aadl.annex.behavior.aadlba.String"
    * @generated
    */
   String getNumValue();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral#getNumValue <em>Num Value</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Num Value</em>' attribute.
    * @see #getNumValue()
    * @generated
    */
   void setNumValue(String value);

} // NumericLiteral
