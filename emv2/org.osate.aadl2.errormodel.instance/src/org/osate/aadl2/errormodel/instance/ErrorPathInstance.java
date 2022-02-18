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
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getIncomingPropagation <em>Incoming Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getOutgoingPropagation <em>Outgoing Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getIncomingTypeSet <em>Incoming Type Set</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getOutgoingTypeToken <em>Outgoing Type Token</em>}</li>
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
	 * Returns the value of the '<em><b>Incoming Propagation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getIncomingErrorPaths <em>Incoming Error Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Propagation</em>' reference.
	 * @see #setIncomingPropagation(ErrorPropagationInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_IncomingPropagation()
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getIncomingErrorPaths
	 * @model opposite="incomingErrorPaths" resolveProxies="false"
	 * @generated
	 */
	ErrorPropagationInstance getIncomingPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getIncomingPropagation <em>Incoming Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Propagation</em>' reference.
	 * @see #getIncomingPropagation()
	 * @generated
	 */
	void setIncomingPropagation(ErrorPropagationInstance value);

	/**
	 * Returns the value of the '<em><b>Outgoing Propagation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutgoingErrorPaths <em>Outgoing Error Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Propagation</em>' reference.
	 * @see #setOutgoingPropagation(ErrorPropagationInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_OutgoingPropagation()
	 * @see org.osate.aadl2.errormodel.instance.ErrorPropagationInstance#getOutgoingErrorPaths
	 * @model opposite="outgoingErrorPaths" resolveProxies="false"
	 * @generated
	 */
	ErrorPropagationInstance getOutgoingPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getOutgoingPropagation <em>Outgoing Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Propagation</em>' reference.
	 * @see #getOutgoingPropagation()
	 * @generated
	 */
	void setOutgoingPropagation(ErrorPropagationInstance value);

	/**
	 * Returns the value of the '<em><b>Incoming Type Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Type Set</em>' containment reference.
	 * @see #setIncomingTypeSet(AnonymousTypeSet)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_IncomingTypeSet()
	 * @model containment="true"
	 * @generated
	 */
	AnonymousTypeSet getIncomingTypeSet();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getIncomingTypeSet <em>Incoming Type Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Type Set</em>' containment reference.
	 * @see #getIncomingTypeSet()
	 * @generated
	 */
	void setIncomingTypeSet(AnonymousTypeSet value);

	/**
	 * Returns the value of the '<em><b>Outgoing Type Token</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Type Token</em>' containment reference.
	 * @see #setOutgoingTypeToken(TypeTokenInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getErrorPathInstance_OutgoingTypeToken()
	 * @model containment="true"
	 * @generated
	 */
	TypeTokenInstance getOutgoingTypeToken();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.ErrorPathInstance#getOutgoingTypeToken <em>Outgoing Type Token</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Type Token</em>' containment reference.
	 * @see #getOutgoingTypeToken()
	 * @generated
	 */
	void setOutgoingTypeToken(TypeTokenInstance value);
} // ErrorPathInstance
