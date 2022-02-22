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

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Path Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getErrorPath <em>Error Path</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourcePropagation <em>Source Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationPropagation <em>Destination Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourceTypeSet <em>Source Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationTypeToken <em>Destination Type Token</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance()
 * @model
 * @generated
 */
public interface ErrorPathInstance extends ErrorFlowInstance {

	/**
	 * Returns the value of the '<em><b>Error Path</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Path</em>' reference.
	 * @see #setErrorPath(ErrorPath)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_ErrorPath()
	 * @model
	 * @generated
	 */
	ErrorPath getErrorPath();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getErrorPath <em>Error Path</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Path</em>' reference.
	 * @see #getErrorPath()
	 * @generated
	 */
	void setErrorPath(ErrorPath value);

	/**
	 * Returns the value of the '<em><b>Source Propagation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getSourceErrorPaths <em>Source Error Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Propagation</em>' reference.
	 * @see #setSourcePropagation(ErrorPropagationInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_SourcePropagation()
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getSourceErrorPaths
	 * @model opposite="sourceErrorPaths" resolveProxies="false"
	 * @generated
	 */
	ErrorPropagationInstance getSourcePropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourcePropagation <em>Source Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Propagation</em>' reference.
	 * @see #getSourcePropagation()
	 * @generated
	 */
	void setSourcePropagation(ErrorPropagationInstance value);

	/**
	 * Returns the value of the '<em><b>Destination Propagation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getDestinationErrorPaths <em>Destination Error Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Propagation</em>' reference.
	 * @see #setDestinationPropagation(ErrorPropagationInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_DestinationPropagation()
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getDestinationErrorPaths
	 * @model opposite="destinationErrorPaths" resolveProxies="false"
	 * @generated
	 */
	ErrorPropagationInstance getDestinationPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationPropagation <em>Destination Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Propagation</em>' reference.
	 * @see #getDestinationPropagation()
	 * @generated
	 */
	void setDestinationPropagation(ErrorPropagationInstance value);

	/**
	 * Returns the value of the '<em><b>Source Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type Set</em>' containment reference.
	 * @see #setSourceTypeSet(AnonymousTypeSet)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_SourceTypeSet()
	 * @model containment="true"
	 * @generated
	 */
	AnonymousTypeSet getSourceTypeSet();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getSourceTypeSet <em>Source Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type Set</em>' containment reference.
	 * @see #getSourceTypeSet()
	 * @generated
	 */
	void setSourceTypeSet(AnonymousTypeSet value);

	/**
	 * Returns the value of the '<em><b>Destination Type Token</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination Type Token</em>' containment reference.
	 * @see #setDestinationTypeToken(TypeTokenInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_DestinationTypeToken()
	 * @model containment="true"
	 * @generated
	 */
	TypeTokenInstance getDestinationTypeToken();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getDestinationTypeToken <em>Destination Type Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination Type Token</em>' containment reference.
	 * @see #getDestinationTypeToken()
	 * @generated
	 */
	void setDestinationTypeToken(TypeTokenInstance value);
} // ErrorPathInstance
