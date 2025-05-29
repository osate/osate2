/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
 * A representation of the model object '<em><b>Point Propagation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.PointPropagation#getPoint <em>Point</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.PointPropagation#getSourceUserDefinedPaths <em>Source User Defined Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.PointPropagation#getDestinationUserDefinedPaths <em>Destination User Defined Paths</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getPointPropagation()
 * @model
 * @generated
 */
public interface PointPropagation extends ErrorPropagationInstance {
	/**
	 * Returns the value of the '<em><b>Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point</em>' reference.
	 * @see #setPoint(PropagationPointInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getPointPropagation_Point()
	 * @model
	 * @generated
	 */
	PropagationPointInstance getPoint();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.PointPropagation#getPoint <em>Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Point</em>' reference.
	 * @see #getPoint()
	 * @generated
	 */
	void setPoint(PropagationPointInstance value);

	/**
	 * Returns the value of the '<em><b>Source User Defined Paths</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.instance.UserDefinedPath}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePropagation <em>Source Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source User Defined Paths</em>' reference list.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getPointPropagation_SourceUserDefinedPaths()
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePropagation
	 * @model opposite="sourcePropagation" transient="true"
	 * @generated
	 */
	EList<UserDefinedPath> getSourceUserDefinedPaths();

	/**
	 * Returns the value of the '<em><b>Destination User Defined Paths</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.instance.UserDefinedPath}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPropagation <em>Destination Propagation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination User Defined Paths</em>' reference list.
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getPointPropagation_DestinationUserDefinedPaths()
	 * @see org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPropagation
	 * @model opposite="destinationPropagation" transient="true"
	 * @generated
	 */
	EList<UserDefinedPath> getDestinationUserDefinedPaths();

} // PointPropagation
