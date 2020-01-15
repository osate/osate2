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

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Path End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getConnectionInstance <em>Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getErrorPropagation <em>Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getComponentInstance <em>Component Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#isHighlight <em>Highlight</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd()
 * @model
 * @generated
 */
public interface PropagationPathEnd extends EObject {
	/**
	 * Returns the value of the '<em><b>Connection Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Instance</em>' reference.
	 * @see #setConnectionInstance(ConnectionInstance)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_ConnectionInstance()
	 * @model
	 * @generated
	 */
	ConnectionInstance getConnectionInstance();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getConnectionInstance <em>Connection Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Instance</em>' reference.
	 * @see #getConnectionInstance()
	 * @generated
	 */
	void setConnectionInstance(ConnectionInstance value);

	/**
	 * Returns the value of the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Propagation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Propagation</em>' reference.
	 * @see #setErrorPropagation(ErrorPropagation)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_ErrorPropagation()
	 * @model
	 * @generated
	 */
	ErrorPropagation getErrorPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getErrorPropagation <em>Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Propagation</em>' reference.
	 * @see #getErrorPropagation()
	 * @generated
	 */
	void setErrorPropagation(ErrorPropagation value);

	/**
	 * Returns the value of the '<em><b>Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instance</em>' reference.
	 * @see #setComponentInstance(ComponentInstance)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_ComponentInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getComponentInstance();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getComponentInstance <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Instance</em>' reference.
	 * @see #getComponentInstance()
	 * @generated
	 */
	void setComponentInstance(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highlight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlight</em>' attribute.
	 * @see #setHighlight(boolean)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_Highlight()
	 * @model transient="true"
	 * @generated
	 */
	boolean isHighlight();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#isHighlight <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highlight</em>' attribute.
	 * @see #isHighlight()
	 * @generated
	 */
	void setHighlight(boolean value);

} // PropagationPathEnd
