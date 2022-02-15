/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.instance;

import org.osate.aadl2.DirectionType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Propagation Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInErrorPropagation <em>In Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutErrorPropagation <em>Out Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInTypeSet <em>In Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutTypeSet <em>Out Type Set</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPropagationInstance()
 * @model abstract="true"
 * @generated
 */
public interface ErrorPropagationInstance extends ConstrainedInstanceObject {
	/**
	 * Returns the value of the '<em><b>In Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Error Propagation</em>' reference.
	 * @see #setInErrorPropagation(ErrorPropagation)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPropagationInstance_InErrorPropagation()
	 * @model
	 * @generated
	 */
	ErrorPropagation getInErrorPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInErrorPropagation <em>In Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Error Propagation</em>' reference.
	 * @see #getInErrorPropagation()
	 * @generated
	 */
	void setInErrorPropagation(ErrorPropagation value);

	/**
	 * Returns the value of the '<em><b>Out Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Error Propagation</em>' reference.
	 * @see #setOutErrorPropagation(ErrorPropagation)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPropagationInstance_OutErrorPropagation()
	 * @model
	 * @generated
	 */
	ErrorPropagation getOutErrorPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutErrorPropagation <em>Out Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Error Propagation</em>' reference.
	 * @see #getOutErrorPropagation()
	 * @generated
	 */
	void setOutErrorPropagation(ErrorPropagation value);

	/**
	 * Returns the value of the '<em><b>In Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Type Set</em>' containment reference.
	 * @see #setInTypeSet(AnonymousTypeSet)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPropagationInstance_InTypeSet()
	 * @model containment="true"
	 * @generated
	 */
	AnonymousTypeSet getInTypeSet();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getInTypeSet <em>In Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Type Set</em>' containment reference.
	 * @see #getInTypeSet()
	 * @generated
	 */
	void setInTypeSet(AnonymousTypeSet value);

	/**
	 * Returns the value of the '<em><b>Out Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Type Set</em>' containment reference.
	 * @see #setOutTypeSet(AnonymousTypeSet)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPropagationInstance_OutTypeSet()
	 * @model containment="true"
	 * @generated
	 */
	AnonymousTypeSet getOutTypeSet();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutTypeSet <em>Out Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Type Set</em>' containment reference.
	 * @see #getOutTypeSet()
	 * @generated
	 */
	void setOutTypeSet(AnonymousTypeSet value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	DirectionType getDirection();

} // ErrorPropagationInstance
