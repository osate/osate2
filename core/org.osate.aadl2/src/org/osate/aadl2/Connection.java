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
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Connections.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Connection#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.Connection#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.Connection#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.osate.aadl2.Connection#getRefined <em>Refined</em>}</li>
 * </ul>
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
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(Connection)
	 * @see org.osate.aadl2.Aadl2Package#getConnection_Refined()
	 * @model ordered="false"
	 *        annotation="subsets"
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
	 * For a refined connection, returns the original connection.  For non-refined connections, returns "this".
	 */
	Connection getRootConnection();

	/**
	 * get source
	 * in case of a refined connection get it from the connection being refine
	 * @return ConnectionEnd the source (feature, data/bus access end or parameter end)
	 */
	ConnectionEnd getAllSource();

	/**
	 * Gets the last element in the source chain.
	 */
	ConnectionEnd getAllLastSource();

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
	 * Gets the last element in the destination chain.
	 * @return
	 */
	ConnectionEnd getAllLastDestination();

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

	/**
	 * Return if the connection is bidirectional. If the connection is refined this information must be
	 * retrieved from the refined connection.
	 */
	public boolean isAllBidirectional();

	/**
	 * Return whether this connection is between two subcomponents and not up/down the hierarchy.
	 */
	public boolean isAcross();

} // Connection
