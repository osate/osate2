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
package org.osate.aadl2.instance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Instance End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstanceEnd#getSrcConnectionInstances <em>Src Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstanceEnd#getDstConnectionInstances <em>Dst Connection Instance</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstanceEnd()
 * @model abstract="true"
 * @generated
 */
public interface ConnectionInstanceEnd extends InstanceObject {
	/**
	 * Returns the value of the '<em><b>Src Connection Instance</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ConnectionInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Connection Instace</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Connection Instance</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstanceEnd_SrcConnectionInstance()
	 * @see org.osate.aadl2.instance.ConnectionInstance#getSource
	 * @model opposite="source" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<ConnectionInstance> getSrcConnectionInstances();

	/**
	 * Returns the value of the '<em><b>Dst Connection Instance</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ConnectionInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Connection Instance</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Connection Instance</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstanceEnd_DstConnectionInstance()
	 * @see org.osate.aadl2.instance.ConnectionInstance#getDestination
	 * @model opposite="destination" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<ConnectionInstance> getDstConnectionInstances();

} // ConnectionInstanceEnd
