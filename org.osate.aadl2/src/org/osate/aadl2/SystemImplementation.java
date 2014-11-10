/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: SystemImplementation.java,v 1.17 2009-06-05 16:43:24 lwrage Exp $
 */
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::Components::System.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedBusSubcomponents <em>Owned Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedDeviceSubcomponents <em>Owned Device Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedMemorySubcomponents <em>Owned Memory Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedProcessSubcomponents <em>Owned Process Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedProcessorSubcomponents <em>Owned Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedSubprogramGroupSubcomponents <em>Owned Subprogram Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedSystemSubcomponents <em>Owned System Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedVirtualBusSubcomponents <em>Owned Virtual Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.SystemImplementation#getOwnedVirtualProcessorSubcomponents <em>Owned Virtual Processor Subcomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation()
 * @model
 * @generated
 */
public interface SystemImplementation extends ComponentImplementation, SystemClassifier {
	/**
	 * Returns the value of the '<em><b>Owned Bus Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.BusSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bus Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Bus Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedBusSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BusSubcomponent> getOwnedBusSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.BusSubcomponent} and appends it to the '<em><b>Owned Bus Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.BusSubcomponent}.
	 * @see #getOwnedBusSubcomponents()
	 * @generated
	 */
	BusSubcomponent createOwnedBusSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Data Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DataSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Data Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedDataSubcomponent()
	 * @model containment="true" ordered="false"
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
	 * Returns the value of the '<em><b>Owned Device Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DeviceSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Device Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Device Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedDeviceSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DeviceSubcomponent> getOwnedDeviceSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.DeviceSubcomponent} and appends it to the '<em><b>Owned Device Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DeviceSubcomponent}.
	 * @see #getOwnedDeviceSubcomponents()
	 * @generated
	 */
	DeviceSubcomponent createOwnedDeviceSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Memory Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.MemorySubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Memory Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Memory Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedMemorySubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MemorySubcomponent> getOwnedMemorySubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.MemorySubcomponent} and appends it to the '<em><b>Owned Memory Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.MemorySubcomponent}.
	 * @see #getOwnedMemorySubcomponents()
	 * @generated
	 */
	MemorySubcomponent createOwnedMemorySubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Process Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Process Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Process Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedProcessSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessSubcomponent> getOwnedProcessSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.ProcessSubcomponent} and appends it to the '<em><b>Owned Process Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ProcessSubcomponent}.
	 * @see #getOwnedProcessSubcomponents()
	 * @generated
	 */
	ProcessSubcomponent createOwnedProcessSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Processor Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessorSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Processor Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Processor Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedProcessorSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessorSubcomponent> getOwnedProcessorSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.ProcessorSubcomponent} and appends it to the '<em><b>Owned Processor Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ProcessorSubcomponent}.
	 * @see #getOwnedProcessorSubcomponents()
	 * @generated
	 */
	ProcessorSubcomponent createOwnedProcessorSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedSubprogramSubcomponent()
	 * @model containment="true" ordered="false"
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Group Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Group Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedSubprogramGroupSubcomponent()
	 * @model containment="true" ordered="false"
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
	 * Returns the value of the '<em><b>Owned System Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SystemSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned System Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned System Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedSystemSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SystemSubcomponent> getOwnedSystemSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.SystemSubcomponent} and appends it to the '<em><b>Owned System Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SystemSubcomponent}.
	 * @see #getOwnedSystemSubcomponents()
	 * @generated
	 */
	SystemSubcomponent createOwnedSystemSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Virtual Bus Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.VirtualBusSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Virtual Bus Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Virtual Bus Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedVirtualBusSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VirtualBusSubcomponent> getOwnedVirtualBusSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.VirtualBusSubcomponent} and appends it to the '<em><b>Owned Virtual Bus Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.VirtualBusSubcomponent}.
	 * @see #getOwnedVirtualBusSubcomponents()
	 * @generated
	 */
	VirtualBusSubcomponent createOwnedVirtualBusSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Virtual Processor Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.VirtualProcessorSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Virtual Processor Subcomponent</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::System.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Virtual Processor Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSystemImplementation_OwnedVirtualProcessorSubcomponent()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VirtualProcessorSubcomponent> getOwnedVirtualProcessorSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.VirtualProcessorSubcomponent} and appends it to the '<em><b>Owned Virtual Processor Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.VirtualProcessorSubcomponent}.
	 * @see #getOwnedVirtualProcessorSubcomponents()
	 * @generated
	 */
	VirtualProcessorSubcomponent createOwnedVirtualProcessorSubcomponent();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * Not generated because thae code generator doesn't know about covariant return types.
	 */
	@Override
	SystemType getType();

} // SystemImplementation
