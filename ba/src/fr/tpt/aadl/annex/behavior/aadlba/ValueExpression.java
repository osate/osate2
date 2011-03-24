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
 * A representation of the model object '<em><b>Value Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations <em>Relations</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression()
 * @model
 * @generated
 */
public interface ValueExpression extends Value, ParameterLabel, ExecuteCondition {
	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see #isSetRelations()
	 * @see #unsetRelations()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression_Relations()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Relation> getRelations();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations <em>Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelations()
	 * @see #getRelations()
	 * @generated
	 */
	void unsetRelations();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelations <em>Relations</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relations</em>' containment reference list is set.
	 * @see #unsetRelations()
	 * @see #getRelations()
	 * @generated
	 */
	boolean isSetRelations();

	/**
	 * Returns the value of the '<em><b>Logical Operators</b></em>' attribute list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator}.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logical Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical Operators</em>' attribute list.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
	 * @see #isSetLogicalOperators()
	 * @see #unsetLogicalOperators()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression_LogicalOperators()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<LogicalOperator> getLogicalOperators();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLogicalOperators()
	 * @see #getLogicalOperators()
	 * @generated
	 */
	void unsetLogicalOperators();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperators <em>Logical Operators</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Logical Operators</em>' attribute list is set.
	 * @see #unsetLogicalOperators()
	 * @see #getLogicalOperators()
	 * @generated
	 */
	boolean isSetLogicalOperators();

} // ValueExpression
