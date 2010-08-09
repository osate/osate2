/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionOwned <em>Simple Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionSdOwned <em>Simple Expression Sd Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#isHasRelationalOperator <em>Has Relational Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends Element
{
   /**
	 * Returns the value of the '<em><b>Simple Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Simple Expression Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Expression Owned</em>' containment reference.
	 * @see #setSimpleExpressionOwned(SimpleExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_SimpleExpressionOwned()
	 * @model containment="true"
	 * @generated
	 */
   SimpleExpression getSimpleExpressionOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionOwned <em>Simple Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Expression Owned</em>' containment reference.
	 * @see #getSimpleExpressionOwned()
	 * @generated
	 */
   void setSimpleExpressionOwned(SimpleExpression value);

   /**
	 * Returns the value of the '<em><b>Simple Expression Sd Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Simple Expression Sd Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Expression Sd Owned</em>' containment reference.
	 * @see #setSimpleExpressionSdOwned(SimpleExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_SimpleExpressionSdOwned()
	 * @model containment="true"
	 * @generated
	 */
   SimpleExpression getSimpleExpressionSdOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getSimpleExpressionSdOwned <em>Simple Expression Sd Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Expression Sd Owned</em>' containment reference.
	 * @see #getSimpleExpressionSdOwned()
	 * @generated
	 */
   void setSimpleExpressionSdOwned(SimpleExpression value);

   /**
	 * Returns the value of the '<em><b>Relational Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Relational Operator Owned</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Relational Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
	 * @see #setRelationalOperatorOwned(RelationalOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_RelationalOperatorOwned()
	 * @model
	 * @generated
	 */
   RelationalOperator getRelationalOperatorOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#getRelationalOperatorOwned <em>Relational Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relational Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator
	 * @see #getRelationalOperatorOwned()
	 * @generated
	 */
   void setRelationalOperatorOwned(RelationalOperator value);

   /**
	 * Returns the value of the '<em><b>Has Relational Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Relational Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Relational Operator</em>' attribute.
	 * @see #setHasRelationalOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getRelation_HasRelationalOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasRelationalOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Relation#isHasRelationalOperator <em>Has Relational Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Relational Operator</em>' attribute.
	 * @see #isHasRelationalOperator()
	 * @generated
	 */
   void setHasRelationalOperator(boolean value);

} // Relation
