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
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::NoneSupport.</p>
 * <p>From package AADLConstructs::Components.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#getOwnedModes <em>Owned Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#getOwnedModeTransitions <em>Owned Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#isDerivedModes <em>Derived Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#isNoFlows <em>No Flows</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#isNoModes <em>No Modes</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getComponentClassifier()
 * @model abstract="true"
 * @generated
 */
public interface ComponentClassifier extends Classifier, SubcomponentType, FeatureClassifier {
	/**
	 * Returns the value of the '<em><b>Owned Mode</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Mode}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mode</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Mode</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentClassifier_OwnedMode()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Mode> getOwnedModes();

	/**
	 * Creates a new {@link org.osate.aadl2.Mode} and appends it to the '<em><b>Owned Mode</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.Mode}.
	 * @see #getOwnedModes()
	 * @generated
	 */
	Mode createOwnedMode();

	/**
	 * Returns the value of the '<em><b>Owned Mode Transition</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ModeTransition}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Mode Transition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Mode Transition</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentClassifier_OwnedModeTransition()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ModeTransition> getOwnedModeTransitions();

	/**
	 * Creates a new {@link org.osate.aadl2.ModeTransition} and appends it to the '<em><b>Owned Mode Transition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ModeTransition}.
	 * @see #getOwnedModeTransitions()
	 * @generated
	 */
	ModeTransition createOwnedModeTransition();

	/**
	 * Returns the value of the '<em><b>Derived Modes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Modes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Derived Modes</em>' attribute.
	 * @see #setDerivedModes(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentClassifier_DerivedModes()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDerivedModes();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentClassifier#isDerivedModes <em>Derived Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived Modes</em>' attribute.
	 * @see #isDerivedModes()
	 * @generated
	 */
	void setDerivedModes(boolean value);

	/**
	 * Returns the value of the '<em><b>No Flows</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Flows</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Flows</em>' attribute.
	 * @see #setNoFlows(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentClassifier_NoFlows()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoFlows();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentClassifier#isNoFlows <em>No Flows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Flows</em>' attribute.
	 * @see #isNoFlows()
	 * @generated
	 */
	void setNoFlows(boolean value);

	/**
	 * Returns the value of the '<em><b>No Modes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Modes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Modes</em>' attribute.
	 * @see #setNoModes(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentClassifier_NoModes()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoModes();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentClassifier#isNoModes <em>No Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Modes</em>' attribute.
	 * @see #isNoModes()
	 * @generated
	 */
	void setNoModes(boolean value);

	/**
	 * Returns the category ("abstract", "bus", "data", "device", etc.) for the classifier.
	 */
	ComponentCategory getCategory();

	/**
	 * Returns all the mode objects of a given classifier, including
	 * ancestor.
	 *
	 * @return EList of all mode objects
	 */
	EList<Mode> getAllModes();

	/**
	 * Returns all the mode transition objects of a given classifier,
	 * including ancestor.
	 *
	 * @return EList of all mode transition objects
	 */
	EList<ModeTransition> getAllModeTransitions();

	/**
	 * Returns all the prototypes, including  ancestor.
	 *
	 * @return EList of all mode objects
	 */
	EList<Prototype> getAllPrototypes();

} // ComponentClassifier
