/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power;

import org.osate.analysis.model.AnalysisElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getBudget <em>Budget</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getSupply <em>Supply</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerElement()
 * @model abstract="true"
 * @generated
 * @since 4.1
 */
public interface PowerElement extends AnalysisElement {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(double)
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerElement_Capacity()
	 * @model
	 * @generated
	 */
	double getCapacity();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(double value);

	/**
	 * Returns the value of the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Budget</em>' attribute.
	 * @see #setBudget(double)
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerElement_Budget()
	 * @model
	 * @generated
	 */
	double getBudget();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(double value);

	/**
	 * Returns the value of the '<em><b>Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supply</em>' attribute.
	 * @see #setSupply(double)
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#getPowerElement_Supply()
	 * @model
	 * @generated
	 */
	double getSupply();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getSupply <em>Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supply</em>' attribute.
	 * @see #getSupply()
	 * @generated
	 */
	void setSupply(double value);

} // PowerElement
