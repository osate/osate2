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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Specification</b></em>'.
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
 *   <li>{@link org.osate.aadl2.FlowSpecification#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getOutEnd <em>Out End</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getInEnd <em>In End</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification()
 * @model
 * @generated
 */
public interface FlowSpecification extends FlowFeature, ModalPath, FlowElement {
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
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FlowKind getKind();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.FlowKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FlowKind value);

	/**
	 * Returns the value of the '<em><b>Out End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out End</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Out End</em>' containment reference.
	 * @see #setOutEnd(FlowEnd)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_OutEnd()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	FlowEnd getOutEnd();

	FlowEnd getAllOutEnd();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getOutEnd <em>Out End</em>}' containment reference.
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
	 * Returns the value of the '<em><b>In End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In End</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In End</em>' containment reference.
	 * @see #setInEnd(FlowEnd)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_InEnd()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	FlowEnd getInEnd();

	FlowEnd getAllInEnd();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getInEnd <em>In End</em>}' containment reference.
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
	 * Returns the value of the '<em><b>Refined</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.RefinableElement#getRefinedElement() <em>Refined Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Flows.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(FlowSpecification)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_Refined()
	 * @model ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	FlowSpecification getRefined();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getRefined <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined</em>' reference.
	 * @see #getRefined()
	 * @generated
	 */
	void setRefined(FlowSpecification value);

	// FIXME-LW: instantiation
	// /**
	// * get in feature of a flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Feature or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// Feature getAllInFeature();
	//
	// /**
	// * get in flow context of a flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Context or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// Context getAllInContext();
	//
	// /**
	// * get out feature of a flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Feature or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// Feature getAllOutFeature();
	//
	// /**
	// * get out flow context of flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Context or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// Context getAllOutContext();

} // FlowSpecification
