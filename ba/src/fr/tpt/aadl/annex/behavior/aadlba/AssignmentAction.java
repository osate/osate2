/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getTargetOwned <em>Target Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getValueExpressionOwned <em>Value Expression Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#isAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getAssignmentAction()
 * @model
 * @generated
 */
public interface AssignmentAction extends BasicAction
{
   /**
	 * Returns the value of the '<em><b>Target Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Target Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Owned</em>' containment reference.
	 * @see #setTargetOwned(Target)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getAssignmentAction_TargetOwned()
	 * @model containment="true"
	 * @generated
	 */
   Target getTargetOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getTargetOwned <em>Target Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Owned</em>' containment reference.
	 * @see #getTargetOwned()
	 * @generated
	 */
   void setTargetOwned(Target value);

   /**
	 * Returns the value of the '<em><b>Value Expression Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Expression Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression Owned</em>' containment reference.
	 * @see #setValueExpressionOwned(ValueExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getAssignmentAction_ValueExpressionOwned()
	 * @model containment="true"
	 * @generated
	 */
   ValueExpression getValueExpressionOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#getValueExpressionOwned <em>Value Expression Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression Owned</em>' containment reference.
	 * @see #getValueExpressionOwned()
	 * @generated
	 */
   void setValueExpressionOwned(ValueExpression value);

   /**
	 * Returns the value of the '<em><b>Any</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Any</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Any</em>' attribute.
	 * @see #setAny(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getAssignmentAction_Any()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isAny();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction#isAny <em>Any</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Any</em>' attribute.
	 * @see #isAny()
	 * @generated
	 */
   void setAny(boolean value);

} // AssignmentAction
