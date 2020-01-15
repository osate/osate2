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
import org.osate.aadl2.ModeTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mode Transition Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getModeTransition <em>Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getTriggers <em>Trigger</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance()
 * @model
 * @generated
 */
public interface ModeTransitionInstance extends ConnectionInstanceEnd, InstanceObject {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeInstance#getDstModeTransitions <em>Dst Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(ModeInstance)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_Destination()
	 * @see org.osate.aadl2.instance.ModeInstance#getDstModeTransitions
	 * @model opposite="dstModeTransition" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	ModeInstance getDestination();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ModeInstance value);

	/**
	 * Returns the value of the '<em><b>Mode Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Transition</em>' reference.
	 * @see #setModeTransition(ModeTransition)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_ModeTransition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ModeTransition getModeTransition();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeTransitionInstance#getModeTransition <em>Mode Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode Transition</em>' reference.
	 * @see #getModeTransition()
	 * @generated
	 */
	void setModeTransition(ModeTransition value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.FeatureInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_Trigger()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FeatureInstance> getTriggers();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions <em>Src Mode Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ModeInstance)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeTransitionInstance_Source()
	 * @see org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions
	 * @model opposite="srcModeTransition" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	ModeInstance getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ModeInstance value);

} // ModeTransitionInstance
