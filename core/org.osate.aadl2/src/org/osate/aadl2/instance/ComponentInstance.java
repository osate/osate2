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
import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Subcomponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getFeatureInstances <em>Feature Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getComponentInstances <em>Component Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getModeInstances <em>Mode Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getModeTransitionInstances <em>Mode Transition Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getFlowSpecifications <em>Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getEndToEndFlows <em>End To End Flow</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getConnectionInstances <em>Connection Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getSubcomponent <em>Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getIndices <em>Index</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.ComponentInstance#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance()
 * @model
 * @generated
 */
public interface ComponentInstance extends ConnectionInstanceEnd, FlowElementInstance {
	/**
	 * Returns the value of the '<em><b>Feature Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.FeatureInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Instance</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_FeatureInstance()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FeatureInstance> getFeatureInstances();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.FeatureInstance} and appends it to the '<em><b>Feature Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.FeatureInstance}.
	 * @see #getFeatureInstances()
	 * @generated
	 */
	FeatureInstance createFeatureInstance();

	/**
	 * Returns the value of the '<em><b>Component Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instance</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_ComponentInstance()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentInstance> getComponentInstances();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.ComponentInstance} and appends it to the '<em><b>Component Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.instance.ComponentInstance} to create.
	 * @return The new {@link org.osate.aadl2.instance.ComponentInstance}.
	 * @see #getComponentInstances()
	 * @generated
	 */
	ComponentInstance createComponentInstance(EClass eClass);

	/**
	 * Creates a new {@link org.osate.aadl2.instance.ComponentInstance} and appends it to the '<em><b>Component Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.ComponentInstance}.
	 * @see #getComponentInstances()
	 * @generated
	 */
	ComponentInstance createComponentInstance();

	/**
	 * Returns the value of the '<em><b>Subcomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subcomponent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subcomponent</em>' reference.
	 * @see #setSubcomponent(Subcomponent)
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_Subcomponent()
	 * @model ordered="false"
	 * @generated
	 */
	Subcomponent getSubcomponent();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ComponentInstance#getSubcomponent <em>Subcomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subcomponent</em>' reference.
	 * @see #getSubcomponent()
	 * @generated
	 */
	void setSubcomponent(Subcomponent value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Long}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_Index()
	 * @model unique="false" dataType="org.osate.aadl2.Integer" ordered="false"
	 * @generated
	 */
	EList<Long> getIndices();

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see #setClassifier(ComponentClassifier)
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_Classifier()
	 * @model ordered="false"
	 * @generated
	 */
	ComponentClassifier getClassifier();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ComponentInstance#getClassifier <em>Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' reference.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(ComponentClassifier value);

	/**
	 * Returns the value of the '<em><b>Mode Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Instance</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_ModeInstance()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ModeInstance> getModeInstances();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.ModeInstance} and appends it to the '<em><b>Mode Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.ModeInstance}.
	 * @see #getModeInstances()
	 * @generated
	 */
	ModeInstance createModeInstance();

	/**
	 * Returns the value of the '<em><b>Mode Transition Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode Transition Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode Transition Instance</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_ModeTransitionInstance()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ModeTransitionInstance> getModeTransitionInstances();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.ModeTransitionInstance} and appends it to the '<em><b>Mode Transition Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.ModeTransitionInstance}.
	 * @see #getModeTransitionInstances()
	 * @generated
	 */
	ModeTransitionInstance createModeTransitionInstance();

	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.ComponentCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see org.osate.aadl2.ComponentCategory
	 * @see #setCategory(ComponentCategory)
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_Category()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ComponentCategory getCategory();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.ComponentInstance#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.osate.aadl2.ComponentCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(ComponentCategory value);

	/**
	 * Returns the value of the '<em><b>In Mode</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ModeInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Modes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Mode</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_InMode()
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModeInstance> getInModes();

	/**
	 * Returns the value of the '<em><b>Flow Specification</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.FlowSpecificationInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flow Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flow Specification</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_FlowSpecification()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FlowSpecificationInstance> getFlowSpecifications();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.FlowSpecificationInstance} and appends it to the '<em><b>Flow Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.FlowSpecificationInstance}.
	 * @see #getFlowSpecifications()
	 * @generated
	 */
	FlowSpecificationInstance createFlowSpecification();

	/**
	 * Returns the value of the '<em><b>End To End Flow</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.EndToEndFlowInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End To End Flow</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End To End Flow</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_EndToEndFlow()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<EndToEndFlowInstance> getEndToEndFlows();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.EndToEndFlowInstance} and appends it to the '<em><b>End To End Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.EndToEndFlowInstance}.
	 * @see #getEndToEndFlows()
	 * @generated
	 */
	EndToEndFlowInstance createEndToEndFlow();

	/**
	 * Returns the value of the '<em><b>Connection Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Instance</em>' containment reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getComponentInstance_ConnectionInstance()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ConnectionInstance> getConnectionInstances();

	/**
	 * Creates a new {@link org.osate.aadl2.instance.ConnectionInstance} and appends it to the '<em><b>Connection Instance</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.instance.ConnectionInstance}.
	 * @see #getConnectionInstances()
	 * @generated
	 */
	ConnectionInstance createConnectionInstance();

	/**
	 * find the mode transition instance of this component instance
	 * @param mt mode transition whose instance is to be found
	 * @return mode transition with the specified mode transition, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	ModeTransitionInstance findModeTransitionInstance(ModeTransition mt);

	/**
	 * find the mode instance of this component instance
	 * @param mode mode whose instance is to be found
	 * @return mode instance with the specified mode, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	ModeInstance findModeInstance(Mode mode);

	/**
	 * find the subcomponent instance of this component instance
	 *
	 * <p>This method is sensitive to the current system operation mode of the
	 * containing system instance.  The component instance corresponding to the
	 * subcomponent is only returned if it exists in the current som.
	 *
	 * @param sc subcomponent
	 * @return component instance with the specified subcomponent, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	ComponentInstance findSubcomponentInstance(Subcomponent sc);

	/**
	 * find the feature instance of this component instance
	 * @param feature feature whose instance is to be found
	 * @return feature instance with the specified feature, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	FeatureInstance findFeatureInstance(Feature feature);

	/**
	 * Project this component into the given mode.  The mode must be
	 * an element of {@link #getModeInstances()}.  This method is only intended
	 * to be used internally.  There is an invariant over the instance model
	 * that if the current system operation mode of the root system instance is
	 * non-<code>null</code>, then the "current mode" state of the component
	 * instances in the model match that state.
	 * @param mode The mode to project this component into, or <code>null</code>
	 * if it is not projected into any mode.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	void setCurrentMode(ModeInstance mode);

	/**
	 * find the flowspec instance of this component instance
	 * @param flowspec flowspec whose instance is to be found
	 * @return flowspec instance with the specified flowspec, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	FlowSpecificationInstance findFlowSpecInstance(FlowSpecification flowspec);

	/**
	 * Find the semantic connection instances that pass through this component instance
	 * that utilize the given connection.  Returns a list
	 * because a connection can be in multiple semantic connections if there are
	 * multiple connections coming in or going out of a port.
	 *
	 * <p>This method is sensitive to the {@link SystemInstance#getCurrentSystemOperationMode()
	 * current system operation mode}.  It only return those connection
	 * instances that exist in the current SOM.
	 *
	 * @param conn Connection whose instance is to be found
	 * @return Connection instance list with the specified Connection
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	EList<ConnectionInstance> findConnectionInstance(Connection conn);

	/**
	 * Find the end to end flow instance of this component that corresponds
	 * to the given end to end flow.
	 *
	 * <p>This method is sensitive to the {@link SystemInstance#getCurrentSystemOperationMode()
	 * current system operation mode}.  It only returns the end to end flow
	 * instance if it exists in the current mode.
	 *
	 * @param ete endtoendflow whose instance is to be found
	 * @return endtoendflow instance with the specified endtoendflow, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	EndToEndFlowInstance findEndToEndFlowInstance(EndToEndFlow ete);

	/**
	 * Return all component instances in the containment structure rooted at
	 * this component, including this component.  This method is sensitive to the
	 * {@link SystemInstance#setCurrentSystemOperationMode(SystemOperationMode) current system
	 * operation mode}. The assumption is that this component instance
	 * {{@link #exists() exists in the current system operation mode} if it is being queried.
	 * If this object is not part of a system instance, then
	 * all the component instances are returned.  If this object is part of a system
	 * instance and the current SOM is set, then this method only returns those
	 * component instances that exist in the current SOM.  If the current SOM
	 * is not set, then it returns all the component instances.
	 * @return
	 */
	EList<ComponentInstance> getAllComponentInstances();

	/**
	 * Return all component instances of the specified category in the containment structure rooted at
	 * this component, including this component.  This method is sensitive to the
	 * {@link SystemInstance#setCurrentSystemOperationMode(SystemOperationMode) current system
	 * operation mode}. The assumption is that this component instance
	 * {{@link #exists() exists in the current system operation mode} if it is being queried.
	 * If this object is not part of a system instance, then
	 * all the component instances are returned.  If this object is part of a system
	 * instance and the current SOM is set, then this method only returns those
	 * component instances that exist in the current SOM.  If the current SOM
	 * is not set, then it returns all the component instances.
	 * @return
	 */
	EList<ComponentInstance> getAllComponentInstances(ComponentCategory category);

	ComponentClassifier getComponentClassifier();

	/**
	 * return all leaf feature instances in the component instance.
	 * For feature groups recursively traverse all elements of the feature group
	 */
	EList<FeatureInstance> getAllFeatureInstances();

	/**
	 * return all feature instances in the component instance
	 * if it is of the specified category. For feature groups recursively traverse all elements of the feature group
	 */
	EList<FeatureInstance> getAllFeatureInstances(FeatureCategory category);

} // ComponentInstance
