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
package org.osate.aadl2.errormodel.instance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.BindingPath#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.BindingPath#getSourcePropagations <em>Source Propagations</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.BindingPath#getDestinationPropagations <em>Destination Propagations</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getBindingPath()
 * @model
 * @generated
 */
public interface BindingPath extends PropagationPathInstance {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.errormodel.instance.BindingType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.instance.BindingType
	 * @see #setType(BindingType)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getBindingPath_Type()
	 * @model
	 * @generated
	 */
	BindingType getType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.BindingPath#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.osate.aadl2.errormodel.instance.BindingType
	 * @see #getType()
	 * @generated
	 */
	void setType(BindingType value);

	/**
	 * Returns the value of the '<em><b>Source Propagations</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.instance.BindingPropagation}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.BindingPropagation#getSourceBindingPaths <em>Source Binding Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Propagations</em>' reference list.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getBindingPath_SourcePropagations()
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation#getSourceBindingPaths
	 * @model opposite="sourceBindingPaths" resolveProxies="false"
	 * @generated
	 */
	EList<BindingPropagation> getSourcePropagations();

	/**
	 * Returns the value of the '<em><b>Destination Propagations</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.instance.BindingPropagation}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.BindingPropagation#getDestinationBindingPaths <em>Destination Binding Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Propagations</em>' reference list.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getBindingPath_DestinationPropagations()
	 * @see org.osate.aadl2.errormodel.instance.BindingPropagation#getDestinationBindingPaths
	 * @model opposite="destinationBindingPaths" resolveProxies="false"
	 * @generated
	 */
	EList<BindingPropagation> getDestinationPropagations();

} // BindingPath
