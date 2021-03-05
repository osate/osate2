/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread Group Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::Components::ThreadGroup.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.ThreadGroupImplementation#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.ThreadGroupImplementation#getOwnedThreadSubcomponents <em>Owned Thread Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.ThreadGroupImplementation#getOwnedThreadGroupSubcomponents <em>Owned Thread Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.ThreadGroupImplementation#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.ThreadGroupImplementation#getOwnedSubprogramGroupSubcomponents <em>Owned Subprogram Group Subcomponent</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getThreadGroupImplementation()
 * @model annotation="duplicates"
 * @generated
 */
public interface ThreadGroupImplementation extends ComponentImplementation, ThreadGroupClassifier {
	/**
	 * Returns the value of the '<em><b>Owned Data Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DataSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::ThreadGroup.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Data Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getThreadGroupImplementation_OwnedDataSubcomponent()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<DataSubcomponent> getOwnedDataSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.DataSubcomponent} and appends it to the '<em><b>Owned Data Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DataSubcomponent}.
	 * @see #getOwnedDataSubcomponents()
	 * @generated
	 */
	DataSubcomponent createOwnedDataSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Thread Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ThreadSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Thread Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::ThreadGroup.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Thread Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getThreadGroupImplementation_OwnedThreadSubcomponent()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ThreadSubcomponent> getOwnedThreadSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.ThreadSubcomponent} and appends it to the '<em><b>Owned Thread Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ThreadSubcomponent}.
	 * @see #getOwnedThreadSubcomponents()
	 * @generated
	 */
	ThreadSubcomponent createOwnedThreadSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Thread Group Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ThreadGroupSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Thread Group Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::ThreadGroup.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Thread Group Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getThreadGroupImplementation_OwnedThreadGroupSubcomponent()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ThreadGroupSubcomponent> getOwnedThreadGroupSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.ThreadGroupSubcomponent} and appends it to the '<em><b>Owned Thread Group Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ThreadGroupSubcomponent}.
	 * @see #getOwnedThreadGroupSubcomponents()
	 * @generated
	 */
	ThreadGroupSubcomponent createOwnedThreadGroupSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::ThreadGroup.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getThreadGroupImplementation_OwnedSubprogramSubcomponent()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<SubprogramSubcomponent> getOwnedSubprogramSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramSubcomponent} and appends it to the '<em><b>Owned Subprogram Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramSubcomponent}.
	 * @see #getOwnedSubprogramSubcomponents()
	 * @generated
	 */
	SubprogramSubcomponent createOwnedSubprogramSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Group Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramGroupSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Group Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::ThreadGroup.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Group Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getThreadGroupImplementation_OwnedSubprogramGroupSubcomponent()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<SubprogramGroupSubcomponent> getOwnedSubprogramGroupSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramGroupSubcomponent} and appends it to the '<em><b>Owned Subprogram Group Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramGroupSubcomponent}.
	 * @see #getOwnedSubprogramGroupSubcomponents()
	 * @generated
	 */
	SubprogramGroupSubcomponent createOwnedSubprogramGroupSubcomponent();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * Not generated because thae code generator doesn't know about covariant return types.
	 */
	ThreadGroupType getType();

} // ThreadGroupImplementation
