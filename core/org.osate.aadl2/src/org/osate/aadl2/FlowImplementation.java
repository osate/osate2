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
 * $Id: FlowImplementation.java,v 1.16 2009-04-02 17:06:16 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowImplementation#getOwnedFlowSegments <em>Owned Flow Segment</em>}</li>
 * </ul>
 * </p>
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
