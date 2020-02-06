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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Component Implementation</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::NoneSupport.</p>
 * <p>From package AADLConstructs::Components.</p>
 * <p>From package AADLDetails::Components::Abstract.</p>
 * <p>From package AADLDetails::Connections.</p>
 * <p>From package AADLDetails::Special Features.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getExtended <em>Extended</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedFlowImplementations <em>Owned Flow Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections <em>Owned Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedExtension <em>Owned Extension</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedRealization <em>Owned Realization</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedEndToEndFlows <em>Owned End To End Flow</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedAbstractSubcomponents <em>Owned Abstract Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedAccessConnections <em>Owned Access Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedParameterConnections <em>Owned Parameter Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedPortConnections <em>Owned Port Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedFeatureConnections <em>Owned Feature Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedFeatureGroupConnections <em>Owned Feature Group Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#isNoSubcomponents <em>No Subcomponents</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#isNoConnections <em>No Connections</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#isNoCalls <em>No Calls</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedProcessorFeatures <em>Owned Processor Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedInternalFeatures <em>Owned Internal Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedEventSources <em>Owned Event Source</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedEventDataSources <em>Owned Event Data Source</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedPortProxies <em>Owned Port Proxy</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentImplementation#getOwnedSubprogramProxies <em>Owned Subprogram Proxy</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation()
 * @model abstract="true"
 * @generated
 */
public interface ComponentImplementation extends ComponentClassifier {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGenerals() <em>General</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ComponentType)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_Type()
	 * @model required="true" transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ComponentType getType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentImplementation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ComponentType value);

	/**
	 * Returns the value of the '<em><b>No Subcomponents</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Subcomponents</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Subcomponents</em>' attribute.
	 * @see #setNoSubcomponents(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_NoSubcomponents()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoSubcomponents();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentImplementation#isNoSubcomponents <em>No Subcomponents</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>No Subcomponents</em>' attribute.
	 * @see #isNoSubcomponents()
	 * @generated
	 */
	void setNoSubcomponents(boolean value);

	/**
	 * Returns the value of the '<em><b>No Calls</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Calls</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>No Calls</em>' attribute.
	 * @see #setNoCalls(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_NoCalls()
	 * @model dataType="org.osate.aadl2.Boolean" required="true"
	 *        ordered="false"
	 * @generated
	 */
	boolean isNoCalls();

	/**
	 * Sets the value of the '
	 * {@link org.osate.aadl2.ComponentImplementation#isNoCalls
	 * <em>No Calls</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value the new value of the '<em>No Calls</em>' attribute.
	 * @see #isNoCalls()
	 * @generated
	 */
	void setNoCalls(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Processor Feature</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.ProcessorFeature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 * </ul>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Processor Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Special Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Processor Feature</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedProcessorFeature()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ProcessorFeature> getOwnedProcessorFeatures();

	/**
	 * Returns the value of the '<em><b>Owned Internal Feature</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.InternalFeature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 * </ul>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Internal Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Special Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Internal Feature</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedInternalFeature()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<InternalFeature> getOwnedInternalFeatures();

	/**
	 * Returns the value of the '<em><b>Owned Event Source</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventSource}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedInternalFeatures() <em>Owned Internal Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Event Source</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Special Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Event Source</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedEventSource()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<EventSource> getOwnedEventSources();

	/**
	 * Creates a new {@link org.osate.aadl2.EventSource} and appends it to the '<em><b>Owned Event Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EventSource}.
	 * @see #getOwnedEventSources()
	 * @generated
	 */
	EventSource createOwnedEventSource();

	/**
	 * Returns the value of the '<em><b>Owned Event Data Source</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventDataSource}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedInternalFeatures() <em>Owned Internal Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Event Data Source</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Special Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Event Data Source</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedEventDataSource()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<EventDataSource> getOwnedEventDataSources();

	/**
	 * Creates a new {@link org.osate.aadl2.EventDataSource} and appends it to the '<em><b>Owned Event Data Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EventDataSource}.
	 * @see #getOwnedEventDataSources()
	 * @generated
	 */
	EventDataSource createOwnedEventDataSource();

	/**
	 * Returns the value of the '<em><b>Owned Port Proxy</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PortProxy}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedProcessorFeatures() <em>Owned Processor Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Port Proxy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Special Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Port Proxy</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedPortProxy()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<PortProxy> getOwnedPortProxies();

	/**
	 * Creates a new {@link org.osate.aadl2.PortProxy} and appends it to the '<em><b>Owned Port Proxy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PortProxy}.
	 * @see #getOwnedPortProxies()
	 * @generated
	 */
	PortProxy createOwnedPortProxy();

	/**
	 * Returns the value of the '<em><b>Owned Subprogram Proxy</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.SubprogramProxy}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedProcessorFeatures() <em>Owned Processor Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subprogram Proxy</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Special Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subprogram Proxy</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedSubprogramProxy()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<SubprogramProxy> getOwnedSubprogramProxies();

	/**
	 * Creates a new {@link org.osate.aadl2.SubprogramProxy} and appends it to the '<em><b>Owned Subprogram Proxy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.SubprogramProxy}.
	 * @see #getOwnedSubprogramProxies()
	 * @generated
	 */
	SubprogramProxy createOwnedSubprogramProxy();

	/**
	 * Returns the value of the '<em><b>No Connections</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Connections</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>No Connections</em>' attribute.
	 * @see #setNoConnections(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_NoConnections()
	 * @model dataType="org.osate.aadl2.Boolean" required="true"
	 *        ordered="false"
	 * @generated
	 */
	boolean isNoConnections();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentImplementation#isNoConnections <em>No Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>No Connections</em>' attribute.
	 * @see #isNoConnections()
	 * @generated
	 */
	void setNoConnections(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Subcomponent</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Subcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Subcomponent</em>' reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Subcomponent</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedSubcomponent()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Subcomponent> getOwnedSubcomponents();

	/**
	 * Returns the value of the '<em><b>Extended</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGenerals() <em>General</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extended</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended</em>' reference.
	 * @see #setExtended(ComponentImplementation)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_Extended()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ComponentImplementation getExtended();

	/**
	 * Sets the value of the '
	 * {@link org.osate.aadl2.ComponentImplementation#getExtended
	 * <em>Extended</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value the new value of the '<em>Extended</em>' reference.
	 * @see #getExtended()
	 * @generated
	 */
	void setExtended(ComponentImplementation value);

	/**
	 * Returns the value of the '<em><b>Owned Flow Implementation</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FlowImplementation}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Flow Implementation</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Flow Implementation</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedFlowImplementation()
	 * @model containment="true"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FlowImplementation> getOwnedFlowImplementations();

	/**
	 * Creates a new {@link org.osate.aadl2.FlowImplementation} and appends it to the '<em><b>Owned Flow Implementation</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FlowImplementation}.
	 * @see #getOwnedFlowImplementations()
	 * @generated
	 */
	FlowImplementation createOwnedFlowImplementation();

	/**
	 * Returns the value of the '<em><b>Owned Connection</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Connection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Connection</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Connection</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedConnection()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Connection> getOwnedConnections();

	/**
	 * Returns the value of the '<em><b>Owned Extension</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGeneralizations() <em>Generalization</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Extension</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Extension</em>' containment reference.
	 * @see #setOwnedExtension(ImplementationExtension)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedExtension()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ImplementationExtension getOwnedExtension();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentImplementation#getOwnedExtension <em>Owned Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Extension</em>' containment reference.
	 * @see #getOwnedExtension()
	 * @generated
	 */
	void setOwnedExtension(ImplementationExtension value);

	/**
	 * Creates a new {@link org.osate.aadl2.ImplementationExtension} and sets the '<em><b>Owned Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ImplementationExtension}.
	 * @see #getOwnedExtension()
	 * @generated
	 */
	ImplementationExtension createOwnedExtension();

	/**
	 * Returns the value of the '<em><b>Owned Realization</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGeneralizations() <em>Generalization</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Realization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Realization</em>' containment reference.
	 * @see #setOwnedRealization(Realization)
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedRealization()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Realization getOwnedRealization();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentImplementation#getOwnedRealization <em>Owned Realization</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Realization</em>' containment reference.
	 * @see #getOwnedRealization()
	 * @generated
	 */
	void setOwnedRealization(Realization value);

	/**
	 * Creates a new {@link org.osate.aadl2.Realization} and sets the '<em><b>Owned Realization</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.Realization}.
	 * @see #getOwnedRealization()
	 * @generated
	 */
	Realization createOwnedRealization();

	/**
	 * Returns the value of the '<em><b>Owned Abstract Subcomponent</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AbstractSubcomponent}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Abstract Subcomponent</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Components::Abstract.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Abstract Subcomponent</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedAbstractSubcomponent()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<AbstractSubcomponent> getOwnedAbstractSubcomponents();

	/**
	 * Creates a new {@link org.osate.aadl2.AbstractSubcomponent} and appends it to the '<em><b>Owned Abstract Subcomponent</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.AbstractSubcomponent}.
	 * @see #getOwnedAbstractSubcomponents()
	 * @generated
	 */
	AbstractSubcomponent createOwnedAbstractSubcomponent();

	/**
	 * Returns the value of the '<em><b>Owned Access Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AccessConnection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Access Connection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Access Connection</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedAccessConnection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<AccessConnection> getOwnedAccessConnections();

	/**
	 * Creates a new {@link org.osate.aadl2.AccessConnection} and appends it to the '<em><b>Owned Access Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.AccessConnection}.
	 * @see #getOwnedAccessConnections()
	 * @generated
	 */
	AccessConnection createOwnedAccessConnection();

	/**
	 * Returns the value of the '<em><b>Owned Parameter Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ParameterConnection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter Connection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parameter Connection</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedParameterConnection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ParameterConnection> getOwnedParameterConnections();

	/**
	 * Creates a new {@link org.osate.aadl2.ParameterConnection} and appends it to the '<em><b>Owned Parameter Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ParameterConnection}.
	 * @see #getOwnedParameterConnections()
	 * @generated
	 */
	ParameterConnection createOwnedParameterConnection();

	/**
	 * Returns the value of the '<em><b>Owned Port Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PortConnection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Port Connection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Port Connection</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedPortConnection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<PortConnection> getOwnedPortConnections();

	/**
	 * Creates a new {@link org.osate.aadl2.PortConnection} and appends it to the '<em><b>Owned Port Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.PortConnection}.
	 * @see #getOwnedPortConnections()
	 * @generated
	 */
	PortConnection createOwnedPortConnection();

	/**
	 * Returns the value of the '<em><b>Owned Feature Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FeatureConnection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Connection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature Connection</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedFeatureConnection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FeatureConnection> getOwnedFeatureConnections();

	/**
	 * Creates a new {@link org.osate.aadl2.FeatureConnection} and appends it to the '<em><b>Owned Feature Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FeatureConnection}.
	 * @see #getOwnedFeatureConnections()
	 * @generated
	 */
	FeatureConnection createOwnedFeatureConnection();

	/**
	 * Returns the value of the '<em><b>Owned Feature Group Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FeatureGroupConnection}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Group Connection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::Connections.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature Group Connection</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedFeatureGroupConnection()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FeatureGroupConnection> getOwnedFeatureGroupConnections();

	/**
	 * Creates a new {@link org.osate.aadl2.FeatureGroupConnection} and appends it to the '<em><b>Owned Feature Group Connection</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FeatureGroupConnection}.
	 * @see #getOwnedFeatureGroupConnections()
	 * @generated
	 */
	FeatureGroupConnection createOwnedFeatureGroupConnection();

	/**
	 * Returns the value of the '<em><b>Owned End To End Flow</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EndToEndFlow}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned End To End Flow</em>' containment
	 * reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned End To End Flow</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentImplementation_OwnedEndToEndFlow()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<EndToEndFlow> getOwnedEndToEndFlows();

	/**
	 * Creates a new {@link org.osate.aadl2.EndToEndFlow} and appends it to the '<em><b>Owned End To End Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.EndToEndFlow}.
	 * @see #getOwnedEndToEndFlows()
	 * @generated
	 */
	EndToEndFlow createOwnedEndToEndFlow();

	/**
	 * @author dionisio switch to add a connection to the proper list depending
	 *         on its type
	 */

	void addConnection(Connection c);

	/**
	 * Get type name from parsed name.
	 */
	String getTypeName();

	/**
	 * Get implementation name without type name.
	 */
	String getImplementationName();

	/**
	 * get list of all connection objects of a component implementation,
	 * including ancestor features In case of refined connections the refined
	 * connection is returned in the list.
	 *
	 * @return List of connection objects
	 */
	EList<Connection> getAllConnections();

	/**
	 * get ingoing connections to subcomponents from a specified feature of the
	 * component impl
	 *
	 * @param feature component impl feature that is the source of a connection
	 * @return EList connections with feature as source
	 */
	EList<Connection> getIngoingConnections(Feature feature);

	/**
	 * get list of all subcomponents of a component impl, including ancestor
	 * features In case of refined connections the refined connection is
	 * returned in the list.
	 *
	 * @return List of connections
	 */
	EList<Subcomponent> getAllSubcomponents();

	/**
	 * Get all end to end flows, including inherited. In case of refined
	 * end to end flows the refined end to end flow is returned in the list.
	 *
	 * @return the list of end to end flows
	 */
	EList<EndToEndFlow> getAllEndToEndFlows();

	/**
	 * Get all flow implementations, including inherited.
	 *
	 * @return List of end to end flows
	 */
	EList<FlowImplementation> getAllFlowImplementations();

	/**
	 * Returns the connection objects of a given implementation for a given mode.
	 *
	 * @param mode Mode for which connections are retrieved.
	 * @return EList of connection objects (possibly empty).
	 */
	EList<Connection> getOwnedConnections(Mode mode);

	/**
	 * Get list of all connections of a component implementation in a given mode, including ancestor
	 * implementations.  In case of refined connections the refined connection is returned in the list.
	 *
	 * @param mode Mode for which connections are to be retrieved.
	 * @return List of connections
	 */
	EList<Connection> getAllConnections(Mode mode);

	/**
	 * Get all internal features, including inherited.
	 *
	 * @return List of internal features in this component implementation
	 */
	EList<InternalFeature> getAllInternalFeatures();

	/**
	 * Get all event sources, including inherited.
	 *
	 * @return List of event sources in this component implementation
	 */
	EList<EventSource> getAllEventSources();

	/**
	 * Get all event data sources, including inherited.
	 *
	 * @return List of event data sources in this component implementation
	 */
	EList<EventDataSource> getAllEventDataSources();

	/**
	 * Get all processor features, including inherited.
	 *
	 * @return List of processor features in this component implementation
	 */
	EList<ProcessorFeature> getAllProcessorFeatures();

	/**
	 * Get all processor port proxies, including inherited.
	 *
	 * @return List of port proxies in this component implementation
	 */
	EList<PortProxy> getAllPortProxies();

	/**
	 * Get all processor subprogram proxies, including inherited.
	 *
	 * @return List of subprogram proxies in this component implementation
	 */
	EList<SubprogramProxy> getAllSubprogramProxies();

} // ComponentImplementation
