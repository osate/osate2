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

import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Defined Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getPath <em>Path</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePoint <em>Source Point</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPoint <em>Destination Point</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePropagation <em>Source Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPropagation <em>Destination Propagation</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getUserDefinedPath()
 * @model
 * @generated
 */
public interface UserDefinedPath extends PropagationPathInstance {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' reference.
	 * @see #setPath(PropagationPath)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getUserDefinedPath_Path()
	 * @model
	 * @generated
	 */
	PropagationPath getPath();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getPath <em>Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' reference.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(PropagationPath value);

	/**
	 * Returns the value of the '<em><b>Source Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Point</em>' reference.
	 * @see #setSourcePoint(PropagationPointInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getUserDefinedPath_SourcePoint()
	 * @model
	 * @generated
	 */
	PropagationPointInstance getSourcePoint();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePoint <em>Source Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Point</em>' reference.
	 * @see #getSourcePoint()
	 * @generated
	 */
	void setSourcePoint(PropagationPointInstance value);

	/**
	 * Returns the value of the '<em><b>Destination Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Point</em>' reference.
	 * @see #setDestinationPoint(PropagationPointInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getUserDefinedPath_DestinationPoint()
	 * @model
	 * @generated
	 */
	PropagationPointInstance getDestinationPoint();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPoint <em>Destination Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Point</em>' reference.
	 * @see #getDestinationPoint()
	 * @generated
	 */
	void setDestinationPoint(PropagationPointInstance value);

	/**
	 * Returns the value of the '<em><b>Source Propagation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.PointPropagation#getSourceUserDefinedPaths <em>Source User Defined Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Propagation</em>' reference.
	 * @see #setSourcePropagation(PointPropagation)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getUserDefinedPath_SourcePropagation()
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation#getSourceUserDefinedPaths
	 * @model opposite="sourceUserDefinedPaths" resolveProxies="false"
	 * @generated
	 */
	PointPropagation getSourcePropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getSourcePropagation <em>Source Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Propagation</em>' reference.
	 * @see #getSourcePropagation()
	 * @generated
	 */
	void setSourcePropagation(PointPropagation value);

	/**
	 * Returns the value of the '<em><b>Destination Propagation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.PointPropagation#getDestinationUserDefinedPaths <em>Destination User Defined Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Propagation</em>' reference.
	 * @see #setDestinationPropagation(PointPropagation)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getUserDefinedPath_DestinationPropagation()
	 * @see org.osate.aadl2.errormodel.instance.PointPropagation#getDestinationUserDefinedPaths
	 * @model opposite="destinationUserDefinedPaths" resolveProxies="false"
	 * @generated
	 */
	PointPropagation getDestinationPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.UserDefinedPath#getDestinationPropagation <em>Destination Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Propagation</em>' reference.
	 * @see #getDestinationPropagation()
	 * @generated
	 */
	void setDestinationPropagation(PointPropagation value);

} // UserDefinedPath
