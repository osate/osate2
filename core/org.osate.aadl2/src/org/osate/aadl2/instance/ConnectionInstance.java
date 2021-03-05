/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#getInSystemOperationModes <em>In System Operation Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#getInModeTransitions <em>In Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#isComplete <em>Complete</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#getConnectionReferences <em>Connection Reference</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ConnectionInstance#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance()
 * @model
 * @generated
 */
public interface ConnectionInstance extends FlowElementInstance {
	/**
	 * Returns the value of the '<em><b>In System Operation Mode</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.SystemOperationMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In System Operation Mode</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In System Operation Mode</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_InSystemOperationMode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SystemOperationMode> getInSystemOperationModes();

	/**
	 * Returns the value of the '<em><b>In Mode Transition</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Mode Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mode Transition</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_InModeTransition()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getInModeTransitions();

	/**
	 * Returns the value of the '<em><b>Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complete</em>' attribute.
	 * @see #setComplete(boolean)
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_Complete()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isComplete();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ConnectionInstance#isComplete <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complete</em>' attribute.
	 * @see #isComplete()
	 * @generated
	 */
	void setComplete(boolean value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.instance.ConnectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.instance.ConnectionKind
	 * @see #setKind(ConnectionKind)
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConnectionKind getKind();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ConnectionInstance#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.osate.aadl2.instance.ConnectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ConnectionKind value);

	/**
	 * Returns the value of the '<em><b>Destination</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ConnectionInstanceEnd#getDstConnectionInstances <em>Dst Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destination</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destination</em>' reference.
	 * @see #setDestination(ConnectionInstanceEnd)
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_Destination()
	 * @see org.osate.aadl2.instance.ConnectionInstanceEnd#getDstConnectionInstances
	 * @model opposite="dstConnectionInstance" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	ConnectionInstanceEnd getDestination();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ConnectionInstance#getDestination <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destination</em>' reference.
	 * @see #getDestination()
	 * @generated
	 */
	void setDestination(ConnectionInstanceEnd value);

	/**
	 * Returns the value of the '<em><b>Connection Reference</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Reference</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_ConnectionReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConnectionReference> getConnectionReferences();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.ConnectionReference} and appends it to the '<em><b>Connection Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.ConnectionReference}.
	 * @see #getConnectionReferences()
	 * @generated
	 */
	ConnectionReference createConnectionReference();

	/**
	 * Returns the value of the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bidirectional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bidirectional</em>' attribute.
	 * @see #setBidirectional(boolean)
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_Bidirectional()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isBidirectional();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ConnectionInstance#isBidirectional <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bidirectional</em>' attribute.
	 * @see #isBidirectional()
	 * @generated
	 */
	void setBidirectional(boolean value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.ConnectionInstanceEnd#getSrcConnectionInstances <em>Src Connection Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ConnectionInstanceEnd)
	 * @see org.osate.aadl2.instance.InstancePackage#getConnectionInstance_Source()
	 * @see org.osate.aadl2.instance.ConnectionInstanceEnd#getSrcConnectionInstances
	 * @model opposite="srcConnectionInstance" resolveProxies="false" required="true" ordered="false"
	 * @generated
	 */
	ConnectionInstanceEnd getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ConnectionInstance#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ConnectionInstanceEnd value);

	/**
	 * Get the values associated with the given property for each connection
	 * declaration that defines this semantic connection.
	 *
	 * @param property
	 * 			  The property to look up
	 * @return A list of
	 * 		   {@link AadlModalPropertyValue}
	 * 		   objects, one for each connection declaration. The objects are in
	 * 		   the same order as the connection declaration objects returned by
	 * 		   {@link #getConnections()}. Furthermore, the values are in terms
	 * 		   of the connection instance object, that is, modal dependencies
	 * 		   are given in terms of system operation modes, and reference
	 * 		   values have been resolved to point to instance objects.
	 * @throws InvalidModelException Thrown if the property values cannot be
	 * retrieved because the model is incomplete.
	 * @exception IllegalArgumentException
	 * 				  Thrown if one of the underlying connection declarations
	 * 				  does not accept the property.
	 */
	List<ModalPropertyValue> getConnectionPropertyValues(Property property) throws InvalidModelException;

	/**
	 * Get the feature instances that this semantic connection passes through
	 * including the ultimate start and end points.  The features are returned in
	 * the order in which they are passed through.
	 *
	 * @return A list of <code>InstanceObject</code>s.  The first item in the
	 * 		   list will be a {@link ComponentInstance} if the connection is an
	 * 		   access connection.  In this case, the component is the data or bus
	 * 		   component that is being accessed through the connection.  In all
	 * 		   other cases the first element will be a {@link FeatureInstance}.
	 * 		   All subsequent elements in the list are always {@link FeatureInstance}
	 * 		   objects.
	 */
	List<InstanceObject> getThroughFeatureInstances();

	ConnectionInstanceEnd getInstantiatedEndPoint(final ComponentInstance ctxt, final ConnectionEnd connEndPoint,
			final Context connCtxt);

} // ConnectionInstance
