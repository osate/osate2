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
 * $Id: FlowSpecification.java,v 1.22 2009-06-04 14:59:49 lwrage Exp $
 */
package org.osate.aadl2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getInFeature <em>In Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getInContext <em>In Context</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getOutFeature <em>Out Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.FlowSpecification#getOutContext <em>Out Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification()
 * @model
 * @generated
 */
public interface FlowSpecification extends Flow, ModalElement {
	/**
	 * Returns the value of the '<em><b>In Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Feature</em>' reference.
	 * @see #setInFeature(Feature)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_InFeature()
	 * @model ordered="false"
	 * @generated
	 */
	Feature getInFeature();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getInFeature <em>In Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Feature</em>' reference.
	 * @see #getInFeature()
	 * @generated
	 */
	void setInFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Out Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Feature</em>' reference.
	 * @see #setOutFeature(Feature)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_OutFeature()
	 * @model ordered="false"
	 * @generated
	 */
	Feature getOutFeature();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getOutFeature <em>Out Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Feature</em>' reference.
	 * @see #getOutFeature()
	 * @generated
	 */
	void setOutFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.FlowKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>Refined</b></em>' reference.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.RefinableElement#getRefinedElement() <em>Refined Element</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(FlowSpecification)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_Refined()
	 * @model ordered="false"
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

	/**
	 * Returns the value of the '<em><b>In Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Context</em>' reference.
	 * @see #setInContext(Context)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_InContext()
	 * @model ordered="false"
	 * @generated
	 */
	Context getInContext();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getInContext <em>In Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Context</em>' reference.
	 * @see #getInContext()
	 * @generated
	 */
	void setInContext(Context value);

	/**
	 * Returns the value of the '<em><b>Out Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Context</em>' reference.
	 * @see #setOutContext(Context)
	 * @see org.osate.aadl2.Aadl2Package#getFlowSpecification_OutContext()
	 * @model ordered="false"
	 * @generated
	 */
	Context getOutContext();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FlowSpecification#getOutContext <em>Out Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Context</em>' reference.
	 * @see #getOutContext()
	 * @generated
	 */
	void setOutContext(Context value);

	/**
	 * get in feature of a flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Feature or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	Feature getAllInFeature();

	/**
	 * get in flow context of a flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Context or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	Context getAllInContext();

	/**
	 * get out feature of a flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Feature or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	Feature getAllOutFeature();

	/**
	 * get out flow context of flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Context or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	Context getAllOutContext();

} // FlowSpecification
