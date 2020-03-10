/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Literal Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getK <em>K</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getMultiLiteralConstraint()
 * @model
 * @generated
 */
public interface MultiLiteralConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
	 * @see #setOperator(EOperation)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getMultiLiteralConstraint_Operator()
	 * @model
	 * @generated
	 */
	EOperation getOperator();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(EOperation value);

	/**
	 * Returns the value of the '<em><b>K</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>K</em>' attribute.
	 * @see #setK(int)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getMultiLiteralConstraint_K()
	 * @model
	 * @generated
	 */
	int getK();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint#getK <em>K</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>K</em>' attribute.
	 * @see #getK()
	 * @generated
	 */
	void setK(int value);

} // MultiLiteralConstraint
