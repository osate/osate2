/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: ComponentImplementation.java,v 1.49 2011-04-11 13:35:55 lwrage Exp $
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
 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGenerals() <em>General</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<ProcessorFeature> getOwnedProcessorFeatures();

	/**
	 * Returns the value of the '<em><b>Owned Internal Feature</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.InternalFeature}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<InternalFeature> getOwnedInternalFeatures();

	/**
	 * Returns the value of the '<em><b>Owned Event Source</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.EventSource}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedInternalFeatures() <em>Owned Internal Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedInternalFeatures() <em>Owned Internal Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedProcessorFeatures() <em>Owned Processor Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedProcessorFeatures() <em>Owned Processor Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<Subcomponent> getOwnedSubcomponents();

	/**
	 * Returns the value of the '<em><b>Extended</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGenerals() <em>General</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	@Override
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<Connection> getOwnedConnections();

	/**
	 * Returns the value of the '<em><b>Owned Extension</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGeneralizations() <em>Generalization</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGeneralizations() <em>Generalization</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedSubcomponents() <em>Owned Subcomponent</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentImplementation#getOwnedConnections() <em>Owned Connection</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @return Lis of end to end flows
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

} // ComponentImplementation
