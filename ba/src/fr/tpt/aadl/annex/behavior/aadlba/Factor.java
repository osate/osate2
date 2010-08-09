/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueOwned <em>Value Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueSdOwned <em>Value Sd Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasBinaryNumericOperator <em>Has Binary Numeric Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryNumericOperator <em>Has Unary Numeric Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryBooleanOperator <em>Has Unary Boolean Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor()
 * @model
 * @generated
 */
public interface Factor extends Element
{
   /**
	 * Returns the value of the '<em><b>Value Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Owned</em>' containment reference.
	 * @see #setValueOwned(Value)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_ValueOwned()
	 * @model containment="true"
	 * @generated
	 */
   Value getValueOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueOwned <em>Value Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Owned</em>' containment reference.
	 * @see #getValueOwned()
	 * @generated
	 */
   void setValueOwned(Value value);

   /**
	 * Returns the value of the '<em><b>Value Sd Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Sd Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Sd Owned</em>' containment reference.
	 * @see #setValueSdOwned(Value)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_ValueSdOwned()
	 * @model containment="true"
	 * @generated
	 */
   Value getValueSdOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getValueSdOwned <em>Value Sd Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Sd Owned</em>' containment reference.
	 * @see #getValueSdOwned()
	 * @generated
	 */
   void setValueSdOwned(Value value);

   /**
	 * Returns the value of the '<em><b>Binary Numeric Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Binary Numeric Operator Owned</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary Numeric Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
	 * @see #setBinaryNumericOperatorOwned(BinaryNumericOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_BinaryNumericOperatorOwned()
	 * @model
	 * @generated
	 */
   BinaryNumericOperator getBinaryNumericOperatorOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binary Numeric Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
	 * @see #getBinaryNumericOperatorOwned()
	 * @generated
	 */
   void setBinaryNumericOperatorOwned(BinaryNumericOperator value);

   /**
	 * Returns the value of the '<em><b>Unary Numeric Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Unary Numeric Operator Owned</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Unary Numeric Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
	 * @see #setUnaryNumericOperatorOwned(UnaryNumericOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_UnaryNumericOperatorOwned()
	 * @model
	 * @generated
	 */
   UnaryNumericOperator getUnaryNumericOperatorOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Numeric Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
	 * @see #getUnaryNumericOperatorOwned()
	 * @generated
	 */
   void setUnaryNumericOperatorOwned(UnaryNumericOperator value);

   /**
	 * Returns the value of the '<em><b>Unary Boolean Operator Owned</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Unary Boolean Operator Owned</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Unary Boolean Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
	 * @see #setUnaryBooleanOperatorOwned(UnaryBooleanOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_UnaryBooleanOperatorOwned()
	 * @model
	 * @generated
	 */
   UnaryBooleanOperator getUnaryBooleanOperatorOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Boolean Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
	 * @see #getUnaryBooleanOperatorOwned()
	 * @generated
	 */
   void setUnaryBooleanOperatorOwned(UnaryBooleanOperator value);

   /**
	 * Returns the value of the '<em><b>Has Binary Numeric Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Binary Numeric Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Binary Numeric Operator</em>' attribute.
	 * @see #setHasBinaryNumericOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_HasBinaryNumericOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasBinaryNumericOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasBinaryNumericOperator <em>Has Binary Numeric Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Binary Numeric Operator</em>' attribute.
	 * @see #isHasBinaryNumericOperator()
	 * @generated
	 */
   void setHasBinaryNumericOperator(boolean value);

   /**
	 * Returns the value of the '<em><b>Has Unary Numeric Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Unary Numeric Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Unary Numeric Operator</em>' attribute.
	 * @see #setHasUnaryNumericOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_HasUnaryNumericOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasUnaryNumericOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryNumericOperator <em>Has Unary Numeric Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Unary Numeric Operator</em>' attribute.
	 * @see #isHasUnaryNumericOperator()
	 * @generated
	 */
   void setHasUnaryNumericOperator(boolean value);

   /**
	 * Returns the value of the '<em><b>Has Unary Boolean Operator</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Unary Boolean Operator</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Unary Boolean Operator</em>' attribute.
	 * @see #setHasUnaryBooleanOperator(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_HasUnaryBooleanOperator()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasUnaryBooleanOperator();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#isHasUnaryBooleanOperator <em>Has Unary Boolean Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Unary Boolean Operator</em>' attribute.
	 * @see #isHasUnaryBooleanOperator()
	 * @generated
	 */
   void setHasUnaryBooleanOperator(boolean value);

} // Factor
