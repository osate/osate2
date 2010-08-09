/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTermsOwned <em>Terms Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasUnaryAddingOperator <em>Has Unary Adding Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperatorOwned <em>Binary Adding Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasBinaryAddingOperator <em>Has Binary Adding Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression()
 * @model
 * @generated
 */
public interface SimpleExpression extends Element
{
   /**
	 * Returns the value of the '<em><b>Terms Owned</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Term}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Terms Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Terms Owned</em>' containment reference list.
	 * @see #isSetTermsOwned()
	 * @see #unsetTermsOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_TermsOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<Term> getTermsOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTermsOwned <em>Terms Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetTermsOwned()
	 * @see #getTermsOwned()
	 * @generated
	 */
   void unsetTermsOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getTermsOwned <em>Terms Owned</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Terms Owned</em>' containment reference list is set.
	 * @see #unsetTermsOwned()
	 * @see #getTermsOwned()
	 * @generated
	 */
   boolean isSetTermsOwned();

   /**
	 * Returns the value of the '<em><b>Unary Adding Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Unary Adding Operator Owned</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Unary Adding Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
	 * @see #setUnaryAddingOperatorOwned(UnaryAddingOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_UnaryAddingOperatorOwned()
	 * @model
	 * @generated
	 */
   UnaryAddingOperator getUnaryAddingOperatorOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getUnaryAddingOperatorOwned <em>Unary Adding Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Adding Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator
	 * @see #getUnaryAddingOperatorOwned()
	 * @generated
	 */
   void setUnaryAddingOperatorOwned(UnaryAddingOperator value);

   /**
	 * Returns the value of the '<em><b>Has Unary Adding Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Unary Adding Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Unary Adding Operator</em>' attribute.
	 * @see #setHasUnaryAddingOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_HasUnaryAddingOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasUnaryAddingOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasUnaryAddingOperator <em>Has Unary Adding Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Unary Adding Operator</em>' attribute.
	 * @see #isHasUnaryAddingOperator()
	 * @generated
	 */
   void setHasUnaryAddingOperator(boolean value);

   /**
	 * Returns the value of the '<em><b>Binary Adding Operator Owned</b></em>' attribute list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator}.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Binary Adding Operator Owned</em>' attribute list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary Adding Operator Owned</em>' attribute list.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator
	 * @see #isSetBinaryAddingOperatorOwned()
	 * @see #unsetBinaryAddingOperatorOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_BinaryAddingOperatorOwned()
	 * @model unsettable="true"
	 * @generated
	 */
   EList<BinaryAddingOperator> getBinaryAddingOperatorOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperatorOwned <em>Binary Adding Operator Owned</em>}' attribute list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetBinaryAddingOperatorOwned()
	 * @see #getBinaryAddingOperatorOwned()
	 * @generated
	 */
   void unsetBinaryAddingOperatorOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#getBinaryAddingOperatorOwned <em>Binary Adding Operator Owned</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Binary Adding Operator Owned</em>' attribute list is set.
	 * @see #unsetBinaryAddingOperatorOwned()
	 * @see #getBinaryAddingOperatorOwned()
	 * @generated
	 */
   boolean isSetBinaryAddingOperatorOwned();

   /**
	 * Returns the value of the '<em><b>Has Binary Adding Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Binary Adding Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Binary Adding Operator</em>' attribute.
	 * @see #setHasBinaryAddingOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSimpleExpression_HasBinaryAddingOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasBinaryAddingOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression#isHasBinaryAddingOperator <em>Has Binary Adding Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Binary Adding Operator</em>' attribute.
	 * @see #isHasBinaryAddingOperator()
	 * @generated
	 */
   void setHasBinaryAddingOperator(boolean value);

} // SimpleExpression
