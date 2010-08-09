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
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelationsOwned <em>Relations Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperatorsOwned <em>Logical Operators Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#isHasLogicalOperator <em>Has Logical Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression()
 * @model
 * @generated
 */
public interface ValueExpression extends Value, ParameterLabel
{
   /**
	 * Returns the value of the '<em><b>Relations Owned</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Relation}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Relations Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations Owned</em>' containment reference list.
	 * @see #isSetRelationsOwned()
	 * @see #unsetRelationsOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression_RelationsOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<Relation> getRelationsOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelationsOwned <em>Relations Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetRelationsOwned()
	 * @see #getRelationsOwned()
	 * @generated
	 */
   void unsetRelationsOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getRelationsOwned <em>Relations Owned</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Relations Owned</em>' containment reference list is set.
	 * @see #unsetRelationsOwned()
	 * @see #getRelationsOwned()
	 * @generated
	 */
   boolean isSetRelationsOwned();

   /**
	 * Returns the value of the '<em><b>Logical Operators Owned</b></em>' attribute list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator}.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Logical Operators Owned</em>' attribute list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Logical Operators Owned</em>' attribute list.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator
	 * @see #isSetLogicalOperatorsOwned()
	 * @see #unsetLogicalOperatorsOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression_LogicalOperatorsOwned()
	 * @model unsettable="true"
	 * @generated
	 */
   EList<LogicalOperator> getLogicalOperatorsOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperatorsOwned <em>Logical Operators Owned</em>}' attribute list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetLogicalOperatorsOwned()
	 * @see #getLogicalOperatorsOwned()
	 * @generated
	 */
   void unsetLogicalOperatorsOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#getLogicalOperatorsOwned <em>Logical Operators Owned</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Logical Operators Owned</em>' attribute list is set.
	 * @see #unsetLogicalOperatorsOwned()
	 * @see #getLogicalOperatorsOwned()
	 * @generated
	 */
   boolean isSetLogicalOperatorsOwned();

   /**
	 * Returns the value of the '<em><b>Has Logical Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Logical Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Logical Operator</em>' attribute.
	 * @see #setHasLogicalOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueExpression_HasLogicalOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasLogicalOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueExpression#isHasLogicalOperator <em>Has Logical Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Logical Operator</em>' attribute.
	 * @see #isHasLogicalOperator()
	 * @generated
	 */
   void setHasLogicalOperator(boolean value);

} // ValueExpression
