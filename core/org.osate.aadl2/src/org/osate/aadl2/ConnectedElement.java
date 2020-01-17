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
 * A representation of the model object '<em><b>Connected Element</b></em>'.
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
 *   <li>{@link org.osate.aadl2.ConnectedElement#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.aadl2.ConnectedElement#getConnectionEnd <em>Connection End</em>}</li>
 *   <li>{@link org.osate.aadl2.ConnectedElement#getNext <em>Next</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getConnectedElement()
 * @model
 * @generated
 */
public interface ConnectedElement extends Element {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Context</em>' reference.
	 * @see #setContext(Context)
	 * @see org.osate.aadl2.Aadl2Package#getConnectedElement_Context()
	 * @model ordered="false"
	 * @generated
	 */
	Context getContext();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ConnectedElement#getContext <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Context value);

	/**
	 * Returns the value of the '<em><b>Connection End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection End</em>' reference.
	 * @see #setConnectionEnd(ConnectionEnd)
	 * @see org.osate.aadl2.Aadl2Package#getConnectedElement_ConnectionEnd()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConnectionEnd getConnectionEnd();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ConnectedElement#getConnectionEnd <em>Connection End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection End</em>' reference.
	 * @see #getConnectionEnd()
	 * @generated
	 */
	void setConnectionEnd(ConnectionEnd value);

	/**
	 * Returns the value of the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Next</em>' containment reference.
	 * @see #setNext(ConnectedElement)
	 * @see org.osate.aadl2.Aadl2Package#getConnectedElement_Next()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ConnectedElement getNext();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ConnectedElement#getNext <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' containment reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(ConnectedElement value);

	/**
	 * Creates a new {@link org.osate.aadl2.ConnectedElement} and sets the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ConnectedElement}.
	 * @see #getNext()
	 * @generated
	 */
	ConnectedElement createNext();

	/**
	 * In a ConnectedElement chain, gets the last element in the chain. For example, if the chain is "a.b.c.d", this
	 * method returns "d".
	 */
	ConnectionEnd getLastConnectionEnd();

} // ConnectedElement
