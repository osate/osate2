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
 * $Id: ProcessorType.java,v 1.12 2008-12-22 18:15:08 lwrage Exp $
 */
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::Components::Processor.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.ProcessorType#getOwnedDataPorts <em>Owned Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.ProcessorType#getOwnedEventDataPorts <em>Owned Event Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.ProcessorType#getOwnedEventPorts <em>Owned Event Port</em>}</li>
 *   <li>{@link org.osate.aadl2.ProcessorType#getOwnedBusAccesses <em>Owned Bus Access</em>}</li>
 *   <li>{@link org.osate.aadl2.ProcessorType#getOwnedSubprogramAccesses <em>Owned Subprogram Access</em>}</li>
 *   <li>{@link org.osate.aadl2.ProcessorType#getOwnedSubprogramGroupAccesses <em>Owned Subprogram Group Access</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getProcessorType()
 * @model
 * @generated
 */
public interface ProcessorType extends ComponentType, ProcessorClassifier {
	/**
	 * Returns the value of the '<em><b>Owned Data Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.DataPort}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Processor.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Data Port</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProcessorType_OwnedDataPort()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DataPort> getOwnedDataPorts();

	/**
	 * Creates a new {@link org.osate.aadl2.DataPort} and appends it to the '<em><b>Owned Data Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DataPort}.
	 * @see #getOwnedDataPorts()
	 * @generated
	 */
	DataPort createOwnedDataPort();

	/**
	 * Returns the value of the '<em><b>Owned Event Data Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventDataPort}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Event Data Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Processor.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Event Data Port</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProcessorType_OwnedEventDataPort()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EventDataPort> getOwnedEventDataPorts();

	/**
	 * Creates a new {@link org.osate.aadl2.EventDataPort} and appends it to the '<em><b>Owned Event Data Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EventDataPort}.
	 * @see #getOwnedEventDataPorts()
	 * @generated
	 */
	EventDataPort createOwnedEventDataPort();

	/**
	 * Returns the value of the '<em><b>Owned Event Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventPort}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Event Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Processor.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Event Port</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProcessorType_OwnedEventPort()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EventPort> getOwnedEventPorts();

	/**
	 * Creates a new {@link org.osate.aadl2.EventPort} and appends it to the '<em><b>Owned Event Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EventPort}.
	 * @see #getOwnedEventPorts()
	 * @generated
	 */
	EventPort createOwnedEventPort();

	/**
	 * Returns the value of the '<em><b>Owned Bus Access</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.BusAccess}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Bus Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Processor.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Bus Access</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProcessorType_OwnedBusAccess()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BusAccess> getOwnedBusAccesses();

	/**
	 * Creates a new {@link org.osate.aadl2.BusAccess} and appends it to the '<em><b>Owned Bus Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.BusAccess}.
	 * @see #getOwnedBusAccesses()
	 * @generated
	 */
	BusAccess createOwnedBusAccess();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Access</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramAccess}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Processor.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Access</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProcessorType_OwnedSubprogramAccess()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubprogramAccess> getOwnedSubprogramAccesses();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramAccess} and appends it to the '<em><b>Owned Subprogram Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramAccess}.
	 * @see #getOwnedSubprogramAccesses()
	 * @generated
	 */
	SubprogramAccess createOwnedSubprogramAccess();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Group Access</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramGroupAccess}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Group Access</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Processor.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Group Access</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getProcessorType_OwnedSubprogramGroupAccess()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SubprogramGroupAccess> getOwnedSubprogramGroupAccesses();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramGroupAccess} and appends it to the '<em><b>Owned Subprogram Group Access</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramGroupAccess}.
	 * @see #getOwnedSubprogramGroupAccesses()
	 * @generated
	 */
	SubprogramGroupAccess createOwnedSubprogramGroupAccess();

} // ProcessorType
