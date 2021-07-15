/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power;

import org.osate.aadl2.instance.FeatureInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier#getFeatureInstance <em>Feature Instance</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerSupplier()
 * @model
 * @generated
 * @since 4.1
 */
public interface PowerSupplier extends PowerElement {
	/**
	 * Returns the value of the '<em><b>Feature Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Instance</em>' reference.
	 * @see #setFeatureInstance(FeatureInstance)
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerSupplier_FeatureInstance()
	 * @model
	 * @generated
	 */
	FeatureInstance getFeatureInstance();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier#getFeatureInstance <em>Feature Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Instance</em>' reference.
	 * @see #getFeatureInstance()
	 * @generated
	 */
	void setFeatureInstance(FeatureInstance value);

} // PowerSupplier
