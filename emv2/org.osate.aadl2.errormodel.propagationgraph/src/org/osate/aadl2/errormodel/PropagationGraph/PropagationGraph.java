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
package org.osate.aadl2.errormodel.PropagationGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getComponents <em>Components</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getPropagationGraphPaths <em>Propagation Graph Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph()
 * @model
 * @generated
 */
public interface PropagationGraph extends EObject {
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
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Components()
	 * @model
	 * @generated
	 */
	EList<ComponentInstance> getComponents();

	/**
	 * Returns the value of the '<em><b>Propagation Graph Paths</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagation Graph Paths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Graph Paths</em>' containment reference list.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_PropagationGraphPaths()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropagationGraphPath> getPropagationGraphPaths();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Connections()
	 * @model
	 * @generated
	 */
	EList<ConnectionInstance> getConnections();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(ComponentInstance)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Root()
	 * @model
	 * @generated
	 */
	ComponentInstance getRoot();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(ComponentInstance value);

} // PropagationGraph
