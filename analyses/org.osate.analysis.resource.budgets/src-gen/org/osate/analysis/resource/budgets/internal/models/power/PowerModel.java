/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power;

import org.eclipse.emf.common.util.EList;
import org.osate.analysis.model.AnalysisElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerModel#getRootPowerTransmissionSystem <em>Root Power Transmission System</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerModel()
 * @model
 * @generated
 * @since 4.1
 */
public interface PowerModel extends AnalysisElement {
	/**
	 * Returns the value of the '<em><b>Root Power Transmission System</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Power Transmission System</em>' containment reference list.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerModel_RootPowerTransmissionSystem()
	 * @model containment="true"
	 * @generated
	 */
	EList<PowerTransmissionSystem> getRootPowerTransmissionSystem();

} // PowerModel
