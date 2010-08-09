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
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactorsOwned <em>Factors Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Term#isHasMultiplyingOperator <em>Has Multiplying Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperatorsOwned <em>Multiplying Operators Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm()
 * @model
 * @generated
 */
public interface Term extends Element
{
   /**
	 * Returns the value of the '<em><b>Factors Owned</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Factor}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Factors Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Factors Owned</em>' containment reference list.
	 * @see #isSetFactorsOwned()
	 * @see #unsetFactorsOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm_FactorsOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<Factor> getFactorsOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactorsOwned <em>Factors Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetFactorsOwned()
	 * @see #getFactorsOwned()
	 * @generated
	 */
   void unsetFactorsOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getFactorsOwned <em>Factors Owned</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Factors Owned</em>' containment reference list is set.
	 * @see #unsetFactorsOwned()
	 * @see #getFactorsOwned()
	 * @generated
	 */
   boolean isSetFactorsOwned();

   /**
	 * Returns the value of the '<em><b>Has Multiplying Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Multiplying Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Multiplying Operator</em>' attribute.
	 * @see #setHasMultiplyingOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm_HasMultiplyingOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasMultiplyingOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#isHasMultiplyingOperator <em>Has Multiplying Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Multiplying Operator</em>' attribute.
	 * @see #isHasMultiplyingOperator()
	 * @generated
	 */
   void setHasMultiplyingOperator(boolean value);

   /**
	 * Returns the value of the '<em><b>Multiplying Operators Owned</b></em>' attribute list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator}.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Multiplying Operators Owned</em>' attribute list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplying Operators Owned</em>' attribute list.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator
	 * @see #isSetMultiplyingOperatorsOwned()
	 * @see #unsetMultiplyingOperatorsOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTerm_MultiplyingOperatorsOwned()
	 * @model unsettable="true"
	 * @generated
	 */
   EList<MultiplyingOperator> getMultiplyingOperatorsOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperatorsOwned <em>Multiplying Operators Owned</em>}' attribute list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetMultiplyingOperatorsOwned()
	 * @see #getMultiplyingOperatorsOwned()
	 * @generated
	 */
   void unsetMultiplyingOperatorsOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Term#getMultiplyingOperatorsOwned <em>Multiplying Operators Owned</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multiplying Operators Owned</em>' attribute list is set.
	 * @see #unsetMultiplyingOperatorsOwned()
	 * @see #getMultiplyingOperatorsOwned()
	 * @generated
	 */
   boolean isSetMultiplyingOperatorsOwned();

} // Term
