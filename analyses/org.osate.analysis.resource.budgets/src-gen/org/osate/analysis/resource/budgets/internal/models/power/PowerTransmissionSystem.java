/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transmission System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getComponentInstance <em>Component Instance</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getSuppliers <em>Suppliers</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getConsumers <em>Consumers</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerTransmissionSystem()
 * @model
 * @generated
 * @since 4.1
 */
public interface PowerTransmissionSystem extends PowerElement {
	/**
	 * Returns the value of the '<em><b>Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instance</em>' reference.
	 * @see #setComponentInstance(ComponentInstance)
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerTransmissionSystem_ComponentInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getComponentInstance();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getComponentInstance <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Instance</em>' reference.
	 * @see #getComponentInstance()
	 * @generated
	 */
	void setComponentInstance(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>Suppliers</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppliers</em>' containment reference list.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerTransmissionSystem_Suppliers()
	 * @model containment="true"
	 * @generated
	 */
	EList<PowerSupplier> getSuppliers();

	/**
	 * Returns the value of the '<em><b>Consumers</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consumers</em>' containment reference list.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerTransmissionSystem_Consumers()
	 * @model containment="true"
	 * @generated
	 */
	EList<PowerConsumer> getConsumers();

} // PowerTransmissionSystem
