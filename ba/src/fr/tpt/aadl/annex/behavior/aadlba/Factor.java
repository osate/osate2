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
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor()
 * @model
 * @generated
 */
public interface Factor extends BehaviorElement {
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
	 * @see #isSetBinaryNumericOperatorOwned()
	 * @see #unsetBinaryNumericOperatorOwned()
	 * @see #setBinaryNumericOperatorOwned(BinaryNumericOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_BinaryNumericOperatorOwned()
	 * @model unsettable="true"
	 * @generated
	 */
	BinaryNumericOperator getBinaryNumericOperatorOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binary Numeric Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator
	 * @see #isSetBinaryNumericOperatorOwned()
	 * @see #unsetBinaryNumericOperatorOwned()
	 * @see #getBinaryNumericOperatorOwned()
	 * @generated
	 */
	void setBinaryNumericOperatorOwned(BinaryNumericOperator value);

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBinaryNumericOperatorOwned()
	 * @see #getBinaryNumericOperatorOwned()
	 * @see #setBinaryNumericOperatorOwned(BinaryNumericOperator)
	 * @generated
	 */
	void unsetBinaryNumericOperatorOwned();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getBinaryNumericOperatorOwned <em>Binary Numeric Operator Owned</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Binary Numeric Operator Owned</em>' attribute is set.
	 * @see #unsetBinaryNumericOperatorOwned()
	 * @see #getBinaryNumericOperatorOwned()
	 * @see #setBinaryNumericOperatorOwned(BinaryNumericOperator)
	 * @generated
	 */
	boolean isSetBinaryNumericOperatorOwned();

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
	 * @see #isSetUnaryNumericOperatorOwned()
	 * @see #unsetUnaryNumericOperatorOwned()
	 * @see #setUnaryNumericOperatorOwned(UnaryNumericOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_UnaryNumericOperatorOwned()
	 * @model unsettable="true"
	 * @generated
	 */
	UnaryNumericOperator getUnaryNumericOperatorOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Numeric Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator
	 * @see #isSetUnaryNumericOperatorOwned()
	 * @see #unsetUnaryNumericOperatorOwned()
	 * @see #getUnaryNumericOperatorOwned()
	 * @generated
	 */
	void setUnaryNumericOperatorOwned(UnaryNumericOperator value);

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnaryNumericOperatorOwned()
	 * @see #getUnaryNumericOperatorOwned()
	 * @see #setUnaryNumericOperatorOwned(UnaryNumericOperator)
	 * @generated
	 */
	void unsetUnaryNumericOperatorOwned();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryNumericOperatorOwned <em>Unary Numeric Operator Owned</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unary Numeric Operator Owned</em>' attribute is set.
	 * @see #unsetUnaryNumericOperatorOwned()
	 * @see #getUnaryNumericOperatorOwned()
	 * @see #setUnaryNumericOperatorOwned(UnaryNumericOperator)
	 * @generated
	 */
	boolean isSetUnaryNumericOperatorOwned();

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
	 * @see #isSetUnaryBooleanOperatorOwned()
	 * @see #unsetUnaryBooleanOperatorOwned()
	 * @see #setUnaryBooleanOperatorOwned(UnaryBooleanOperator)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getFactor_UnaryBooleanOperatorOwned()
	 * @model unsettable="true"
	 * @generated
	 */
	UnaryBooleanOperator getUnaryBooleanOperatorOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unary Boolean Operator Owned</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator
	 * @see #isSetUnaryBooleanOperatorOwned()
	 * @see #unsetUnaryBooleanOperatorOwned()
	 * @see #getUnaryBooleanOperatorOwned()
	 * @generated
	 */
	void setUnaryBooleanOperatorOwned(UnaryBooleanOperator value);

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnaryBooleanOperatorOwned()
	 * @see #getUnaryBooleanOperatorOwned()
	 * @see #setUnaryBooleanOperatorOwned(UnaryBooleanOperator)
	 * @generated
	 */
	void unsetUnaryBooleanOperatorOwned();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Factor#getUnaryBooleanOperatorOwned <em>Unary Boolean Operator Owned</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Unary Boolean Operator Owned</em>' attribute is set.
	 * @see #unsetUnaryBooleanOperatorOwned()
	 * @see #getUnaryBooleanOperatorOwned()
	 * @see #setUnaryBooleanOperatorOwned(UnaryBooleanOperator)
	 * @generated
	 */
	boolean isSetUnaryBooleanOperatorOwned();

} // Factor
