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
 * $Id: Subcomponent.java,v 1.45 2010-04-13 17:52:32 lwrage Exp $
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
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getSubcomponent()
 * @model abstract="true"
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
	 * @generated
	 */
	SubcomponentType getSubcomponentType();

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Subcomponent#getSubcomponentType() <em>Subcomponent Type</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Subcomponent#getSubcomponentType() <em>Subcomponent Type</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.RefinableElement#getRefinedElement() <em>Refined Element</em>}'</li>
	 * </ul>
	 * </p>
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
