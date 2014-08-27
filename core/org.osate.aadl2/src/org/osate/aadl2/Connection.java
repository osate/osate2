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
 * $Id: Connection.java,v 1.27 2009-10-05 19:57:58 lwrage Exp $
 */
package org.osate.aadl2;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Connections.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.Connection#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.Connection#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.Connection#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.osate.aadl2.Connection#getRefined <em>Refined</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends StructuralFeature, ModalPath, FlowElement {
	/**
	 * Returns the value of the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Destination</em>' containment reference.
	 * @see #setDestination(ConnectedElement)
	 * @see org.osate.aadl2.Aadl2Package#getConnection_Destination()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ConnectedElement getDestination();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Connection#getDestination <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' containment reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ConnectedElement value);

	/**
	 * Creates a new {@link org.osate.aadl2.ConnectedElement} and sets the '<em><b>Destination</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ConnectedElement}.
	 * @see #getDestination()
	 * @generated
	 */
	ConnectedElement createDestination();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(ConnectedElement)
	 * @see org.osate.aadl2.Aadl2Package#getConnection_Source()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ConnectedElement getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Connection#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ConnectedElement value);

	/**
	 * Creates a new {@link org.osate.aadl2.ConnectedElement} and sets the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ConnectedElement}.
	 * @see #getSource()
	 * @generated
	 */
	ConnectedElement createSource();

	/**
	 * Returns the value of the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bidirectional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bidirectional</em>' attribute.
	 * @see #setBidirectional(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getConnection_Bidirectional()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isBidirectional();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Connection#isBidirectional <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bidirectional</em>' attribute.
	 * @see #isBidirectional()
	 * @generated
	 */
	void setBidirectional(boolean value);

	/**
	 * Returns the value of the '<em><b>Refined</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
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
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(Connection)
	 * @see org.osate.aadl2.Aadl2Package#getConnection_Refined()
	 * @model ordered="false"
	 * @generated
	 */
	Connection getRefined();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Connection#getRefined <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined</em>' reference.
	 * @see #getRefined()
	 * @generated
	 */
	void setRefined(Connection value);

	/**
	 * get source
	 * in case of a refined connection get it from the connection being refine
	 * @return ConnectionEnd the source (feature, data/bus access end or parameter end)
	 */
	ConnectionEnd getAllSource();

	/**
	 * get destination context
	 * in case of a refined connection get it from the connection being refined
	 * @return Context
	 */
	Context getAllDestinationContext();

	/**
	 * get destination
	 * in case of a refined connection get it from the connection being refined
	 * @return ConnectionEnd the destination (feature, data/bus access end or parameter end)
	 */
	ConnectionEnd getAllDestination();

	/**
	 * get source context
	 * in case of a refined connection get it from the connection being refined
	 * @return Context
	 */
	Context getAllSourceContext();

	/**
	 * get source context component, i.e., the subcomponent or component implementation.
	 * If the context is a port group get its enclosing component impl.
	 * in case of a refined connection get it from the connection being refined
	 * @return PropertyHolder context subcomponent or component implementation
	 */
	public NamedElement getAllSrcContextComponent();

	/**
	 * get destination context component, i.e., the subcomponent or component implementation.
	 * If the context is a port group get its enclosing component impl.
	 * in case of a refined connection get it from the connection being refined
	 * @return PropertyHolder context subcomponent or component implementation
	 */
	public NamedElement getAllDstContextComponent();

} // Connection
