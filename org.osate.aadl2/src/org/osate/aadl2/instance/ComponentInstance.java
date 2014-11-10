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
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * $Id: ComponentInstance.java,v 1.16 2010-05-12 20:09:22 lwrage Exp $
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
 * </ul>
 * </p>
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

	ComponentClassifier getComponentClassifier();

} // ComponentInstance
