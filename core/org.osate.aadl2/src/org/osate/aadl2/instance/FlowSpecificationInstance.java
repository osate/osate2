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
package org.osate.aadl2.instance;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.FlowSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Specification Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.FlowSpecificationInstance#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FlowSpecificationInstance#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FlowSpecificationInstance#getFlowSpecification <em>Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FlowSpecificationInstance#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FlowSpecificationInstance#getInModeTransitions <em>In Mode Transition</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getFlowSpecificationInstance()
 * @model
 * @generated
 */
public interface FlowSpecificationInstance extends FlowElementInstance {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.FeatureInstance#getSrcFlowSpecs <em>Src Flow Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(FeatureInstance)
	 * @see org.osate.aadl2.instance.InstancePackage#getFlowSpecificationInstance_Source()
	 * @see org.osate.aadl2.instance.FeatureInstance#getSrcFlowSpecs
	 * @model opposite="srcFlowSpec" resolveProxies="false" ordered="false"
	 * @generated
	 */
	FeatureInstance getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(FeatureInstance value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.FeatureInstance#getDstFlowSpecs <em>Dst Flow Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(FeatureInstance)
	 * @see org.osate.aadl2.instance.InstancePackage#getFlowSpecificationInstance_Destination()
	 * @see org.osate.aadl2.instance.FeatureInstance#getDstFlowSpecs
	 * @model opposite="dstFlowSpec" resolveProxies="false" ordered="false"
	 * @generated
	 */
	FeatureInstance getDestination();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(FeatureInstance value);

	/**
	 * Returns the value of the '<em><b>Flow Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Specification</em>' reference.
	 * @see #setFlowSpecification(FlowSpecification)
	 * @see org.osate.aadl2.instance.InstancePackage#getFlowSpecificationInstance_FlowSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FlowSpecification getFlowSpecification();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getFlowSpecification <em>Flow Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flow Specification</em>' reference.
	 * @see #getFlowSpecification()
	 * @generated
	 */
	void setFlowSpecification(FlowSpecification value);

	/**
	 * Returns the value of the '<em><b>In Mode</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Modes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mode</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getFlowSpecificationInstance_InMode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeInstance> getInModes();

	/**
	 * Returns the value of the '<em><b>In Mode Transition</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Mode Transition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mode Transition</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getFlowSpecificationInstance_InModeTransition()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getInModeTransitions();

} // FlowSpecificationInstance
