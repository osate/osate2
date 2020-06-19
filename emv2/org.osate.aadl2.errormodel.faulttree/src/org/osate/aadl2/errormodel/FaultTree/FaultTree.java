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
package org.osate.aadl2.errormodel.FaultTree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fault Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getMessage <em>Message</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getFaultTreeType <em>Fault Tree Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getRoot <em>Root</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getInstanceRoot <em>Instance Root</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getEvents <em>Events</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree()
 * @model
 * @generated
 */
public interface FaultTree extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Fault Tree Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.errormodel.FaultTree.FaultTreeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault Tree Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault Tree Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
	 * @see #setFaultTreeType(FaultTreeType)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_FaultTreeType()
	 * @model
	 * @generated
	 */
	FaultTreeType getFaultTreeType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getFaultTreeType <em>Fault Tree Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fault Tree Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreeType
	 * @see #getFaultTreeType()
	 * @generated
	 */
	void setFaultTreeType(FaultTreeType value);

	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.FaultTree.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Events()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Event)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_Root()
	 * @model
	 * @generated
	 */
	Event getRoot();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Event value);

	/**
	 * Returns the value of the '<em><b>Instance Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Root</em>' reference.
	 * @see #setInstanceRoot(EObject)
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#getFaultTree_InstanceRoot()
	 * @model
	 * @generated
	 */
	EObject getInstanceRoot();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.FaultTree.FaultTree#getInstanceRoot <em>Instance Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Root</em>' reference.
	 * @see #getInstanceRoot()
	 * @generated
	 */
	void setInstanceRoot(EObject value);

} // FaultTree
