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
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subcomponent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLConstructs::Components.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Subcomponent#getSubcomponentType <em>Subcomponent Type</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#getOwnedModeBindings <em>Owned Mode Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#isAllModes <em>All Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#getImplementationReferences <em>Implementation Reference</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.Subcomponent#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getSubcomponent()
 * @model abstract="true"
 *        annotation="duplicates"
 * @generated
 */
public interface Subcomponent extends StructuralFeature, ModalElement, Context, FlowElement, ArrayableElement {
	/**
	 * Returns the value of the '<em><b>Subcomponent Type</b></em>' reference.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subcomponent Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Subcomponent Type</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_SubcomponentType()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 * @generated
	 */
	SubcomponentType getSubcomponentType();

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Subcomponent#getSubcomponentType() <em>Subcomponent Type</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_Classifier()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ComponentClassifier getClassifier();

	/**
	 * Returns the value of the '<em><b>Owned Prototype Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PrototypeBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Prototype Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Prototype Binding</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_OwnedPrototypeBinding()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PrototypeBinding> getOwnedPrototypeBindings();

	/**
	 * Creates a new {@link org.osate.aadl2.PrototypeBinding} and appends it to the '<em><b>Owned Prototype Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PrototypeBinding} to create.
	 * @return The new {@link org.osate.aadl2.PrototypeBinding}.
	 * @see #getOwnedPrototypeBindings()
	 * @generated
	 */
	PrototypeBinding createOwnedPrototypeBinding(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Subcomponent#getSubcomponentType() <em>Subcomponent Type</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_Prototype()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ComponentPrototype getPrototype();

	/**
	 * Returns the value of the '<em><b>Owned Mode Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ModeBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mode Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Mode Binding</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_OwnedModeBinding()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ModeBinding> getOwnedModeBindings();

	/**
	 * Creates a new {@link org.osate.aadl2.ModeBinding} and appends it to the '<em><b>Owned Mode Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ModeBinding}.
	 * @see #getOwnedModeBindings()
	 * @generated
	 */
	ModeBinding createOwnedModeBinding();

	/**
	 * Returns the value of the '<em><b>All Modes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>All Modes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>All Modes</em>' attribute.
	 * @see #setAllModes(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_AllModes()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAllModes();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Subcomponent#isAllModes <em>All Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All Modes</em>' attribute.
	 * @see #isAllModes()
	 * @generated
	 */
	void setAllModes(boolean value);

	/**
	 * Returns the value of the '<em><b>Implementation Reference</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ComponentImplementationReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Reference</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Implementation Reference</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_ImplementationReference()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentImplementationReference> getImplementationReferences();

	/**
	 * Creates a new {@link org.osate.aadl2.ComponentImplementationReference} and appends it to the '<em><b>Implementation Reference</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ComponentImplementationReference}.
	 * @see #getImplementationReferences()
	 * @generated
	 */
	ComponentImplementationReference createImplementationReference();

	/**
	 * Returns the value of the '<em><b>Refined</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.RefinableElement#getRefinedElement() <em>Refined Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(Subcomponent)
	 * @see org.osate.aadl2.Aadl2Package#getSubcomponent_Refined()
	 * @model ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Subcomponent getRefined();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Subcomponent#getRefined <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined</em>' reference.
	 * @see #getRefined()
	 * @generated
	 */
	void setRefined(Subcomponent value);

	/**
	 * Returns the category ("abstract", "bus", "data", "device", etc.) for the subcomponent.
	 * Returns the ComponentCategory literal for the given subcomponent
	 */
	ComponentCategory getCategory();

	/**
	 * returns the component implementation object of a given subcomponent
	 *
	 * @return Component implementation
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	ComponentImplementation getComponentImplementation();

	/**
	 * returns the component type object of a given subcomponent
	 * It is retrieved by direct link.
	 * This link is looked up only if the classifier link to the implementation is not set.
	 * This link may not be filled in if the classifier is complete
	 * @return Component type
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	ComponentType getComponentType();

	/**
	 * Return the subcomponent and any of the subcomponents it refines
	 * @return EList of subcomponent
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	EList<Subcomponent> getAllSubcomponentRefinements();

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	ComponentClassifier getAllClassifier();

	/**
	 * @param cp
	 */
	PrototypeBinding lookupPrototypeBinding(Prototype proto);

	/**
	 * Get list of all features of a subcomponent, including ancestor features
	 * These are the features of its classifier
	 * In case of refined features the refined feature is returned in the list.
	 * @return List of features
	 */
	EList<Feature> getAllFeatures();
} // Subcomponent
