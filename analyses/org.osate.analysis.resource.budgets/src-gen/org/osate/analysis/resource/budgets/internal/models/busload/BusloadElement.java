/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 * 
 */
package org.osate.analysis.resource.budgets.internal.models.busload;

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
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.busload.BusloadElement#getLabel <em>Label</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.busload.BusloadElement#getActual <em>Actual</em>}</li>
 *   <li>{@link org.osate.analysis.resource.budgets.internal.models.busload.BusloadElement#getBudget <em>Budget</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resource.budgets.internal.models.busload.BusloadPackage#getBusloadElement()
 * @model abstract="true"
 * @generated
 */
public interface BusloadElement extends AnalysisElement {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.osate.analysis.resource.budgets.internal.models.busload.BusloadPackage#getBusloadElement_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.busload.BusloadElement#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Actual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual</em>' attribute.
	 * @see #setActual(double)
	 * @see org.osate.analysis.resource.budgets.internal.models.busload.BusloadPackage#getBusloadElement_Actual()
	 * @model
	 * @generated
	 */
	double getActual();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.busload.BusloadElement#getActual <em>Actual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actual</em>' attribute.
	 * @see #getActual()
	 * @generated
	 */
	void setActual(double value);

	/**
	 * Returns the value of the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Budget</em>' attribute.
	 * @see #setBudget(double)
	 * @see org.osate.analysis.resource.budgets.internal.models.busload.BusloadPackage#getBusloadElement_Budget()
	 * @model
	 * @generated
	 */
	double getBudget();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resource.budgets.internal.models.busload.BusloadElement#getBudget <em>Budget</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Budget</em>' attribute.
	 * @see #getBudget()
	 * @generated
	 */
	void setBudget(double value);

} // BusloadElement
