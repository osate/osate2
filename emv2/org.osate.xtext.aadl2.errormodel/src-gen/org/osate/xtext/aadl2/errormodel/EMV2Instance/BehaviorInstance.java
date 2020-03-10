/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getActions <em>Actions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSink <em>Sink</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getBehaviorInstance()
 * @model
 * @generated
 */
public interface BehaviorInstance extends EMV2InstanceObject {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Literal)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getBehaviorInstance_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Literal getCondition();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Literal value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getBehaviorInstance_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstrainedInstanceObject> getActions();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(boolean)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getBehaviorInstance_Source()
	 * @model
	 * @generated
	 */
	boolean isSource();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #isSource()
	 * @generated
	 */
	void setSource(boolean value);

	/**
	 * Returns the value of the '<em><b>Sink</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sink</em>' attribute.
	 * @see #setSink(boolean)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getBehaviorInstance_Sink()
	 * @model
	 * @generated
	 */
	boolean isSink();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance#isSink <em>Sink</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sink</em>' attribute.
	 * @see #isSink()
	 * @generated
	 */
	void setSink(boolean value);

} // BehaviorInstance
