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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Flows.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getOwnedFlowSegments <em>Owned Flow Segment</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getInEnd <em>In End</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getOutEnd <em>Out End</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getFlowImplementation()
 * @model
 * @generated
 */
public interface FlowImplementation extends ModalPath, ClassifierFeature, Flow {
	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Specification</em>' reference.
	 * @see #setSpecification(FlowSpecification)
	 * @see org.osate.aadl2.Aadl2Package#getFlowImplementation_Specification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FlowSpecification getSpecification();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowImplementation#getSpecification <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(FlowSpecification value);

	/**
	 * Returns the value of the '<em><b>Owned Flow Segment</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FlowSegment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Flow Segment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Flow Segment</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getFlowImplementation_OwnedFlowSegment()
	 * @model containment="true"
	 * @generated
	 */
	EList<FlowSegment> getOwnedFlowSegments();

	/**
	 * Creates a new {@link org.osate.aadl2.FlowSegment} and appends it to the '<em><b>Owned Flow Segment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FlowSegment}.
	 * @see #getOwnedFlowSegments()
	 * @generated
	 */
	FlowSegment createOwnedFlowSegment();

	/**
	 * Returns the value of the '<em><b>In End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In End</em>' containment reference.
	 * @see #setInEnd(FlowEnd)
	 * @see org.osate.aadl2.Aadl2Package#getFlowImplementation_InEnd()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	FlowEnd getInEnd();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowImplementation#getInEnd <em>In End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In End</em>' containment reference.
	 * @see #getInEnd()
	 * @generated
	 */
	void setInEnd(FlowEnd value);

	/**
	 * Creates a new {@link org.osate.aadl2.FlowEnd} and sets the '<em><b>In End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FlowEnd}.
	 * @see #getInEnd()
	 * @generated
	 */
	FlowEnd createInEnd();

	/**
	 * Returns the value of the '<em><b>Out End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Out End</em>' containment reference.
	 * @see #setOutEnd(FlowEnd)
	 * @see org.osate.aadl2.Aadl2Package#getFlowImplementation_OutEnd()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	FlowEnd getOutEnd();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowImplementation#getOutEnd <em>Out End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out End</em>' containment reference.
	 * @see #getOutEnd()
	 * @generated
	 */
	void setOutEnd(FlowEnd value);

	/**
	 * Creates a new {@link org.osate.aadl2.FlowEnd} and sets the '<em><b>Out End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FlowEnd}.
	 * @see #getOutEnd()
	 * @generated
	 */
	FlowEnd createOutEnd();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.FlowKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.FlowKind
	 * @see #setKind(FlowKind)
	 * @see org.osate.aadl2.Aadl2Package#getFlowImplementation_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FlowKind getKind();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowImplementation#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.FlowKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FlowKind value);

} // FlowImplementation
