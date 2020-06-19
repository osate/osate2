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
import org.osate.aadl2.Mode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mode Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getSrcModeTransitions <em>Src Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getDstModeTransitions <em>Dst Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getMode <em>Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#isDerived <em>Derived</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ModeInstance#getParents <em>Parent</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance()
 * @model
 * @generated
 */
public interface ModeInstance extends InstanceObject {
	/**
	 * Returns the value of the '<em><b>Src Mode Transition</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeTransitionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Mode Transition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Mode Transition</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_SrcModeTransition()
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getSource
	 * @model opposite="source" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getSrcModeTransitions();

	/**
	 * Returns the value of the '<em><b>Dst Mode Transition</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ModeTransitionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Mode Transition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Mode Transition</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_DstModeTransition()
	 * @see org.osate.aadl2.instance.ModeTransitionInstance#getDestination
	 * @model opposite="destination" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getDstModeTransitions();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' reference.
	 * @see #setMode(Mode)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Mode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeInstance#getMode <em>Mode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' reference.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' attribute.
	 * @see #setDerived(boolean)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Derived()
	 * @model default="false" dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeInstance#isDerived <em>Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived</em>' attribute.
	 * @see #isDerived()
	 * @generated
	 */
	void setDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Parent()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeInstance> getParents();

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(boolean)
	 * @see org.osate.aadl2.instance.InstancePackage#getModeInstance_Initial()
	 * @model default="false" dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInitial();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ModeInstance#isInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #isInitial()
	 * @generated
	 */
	void setInitial(boolean value);

} // ModeInstance
