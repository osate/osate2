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
 * A representation of the model object '<em><b>Component Type</b></em>'.
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
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedFeatures <em>Owned Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getExtended <em>Extended</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedFlowSpecifications <em>Owned Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedExtension <em>Owned Extension</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedFeatureGroups <em>Owned Feature Group</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedAbstractFeatures <em>Owned Abstract Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#isNoFeatures <em>No Features</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getComponentType()
 * @model abstract="true"
 * @generated
 */
public interface ComponentType extends ComponentClassifier {
	/**
	 * Returns the value of the '<em><b>No Features</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Features</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Features</em>' attribute.
	 * @see #setNoFeatures(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_NoFeatures()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoFeatures();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentType#isNoFeatures <em>No Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Features</em>' attribute.
	 * @see #isNoFeatures()
	 * @generated
	 */
	void setNoFeatures(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Feature</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Feature}.
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
	 * If the meaning of the '<em>Owned Feature</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_OwnedFeature()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Feature> getOwnedFeatures();

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
	 * If the meaning of the '<em>Extended</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended</em>' reference.
	 * @see #setExtended(ComponentType)
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_Extended()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ComponentType getExtended();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentType#getExtended <em>Extended</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended</em>' reference.
	 * @see #getExtended()
	 * @generated
	 */
	void setExtended(ComponentType value);

	/**
	 * Returns the value of the '<em><b>Owned Flow Specification</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FlowSpecification}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Flow Specification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Flow Specification</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_OwnedFlowSpecification()
	 * @model containment="true"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FlowSpecification> getOwnedFlowSpecifications();

	/**
	 * Creates a new {@link org.osate.aadl2.FlowSpecification} and appends it to the '<em><b>Owned Flow Specification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FlowSpecification}.
	 * @see #getOwnedFlowSpecifications()
	 * @generated
	 */
	FlowSpecification createOwnedFlowSpecification();

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
	 * @see #setOwnedExtension(TypeExtension)
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_OwnedExtension()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	TypeExtension getOwnedExtension();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.ComponentType#getOwnedExtension <em>Owned Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Extension</em>' containment reference.
	 * @see #getOwnedExtension()
	 * @generated
	 */
	void setOwnedExtension(TypeExtension value);

	/**
	 * Creates a new {@link org.osate.aadl2.TypeExtension} and sets the '<em><b>Owned Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.TypeExtension}.
	 * @see #getOwnedExtension()
	 * @generated
	 */
	TypeExtension createOwnedExtension();

	/**
	 * Returns the value of the '<em><b>Owned Feature Group</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.FeatureGroup}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Feature Group</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Feature Group</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_OwnedFeatureGroup()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<FeatureGroup> getOwnedFeatureGroups();

	/**
	 * Creates a new {@link org.osate.aadl2.FeatureGroup} and appends it to the '<em><b>Owned Feature Group</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.FeatureGroup}.
	 * @see #getOwnedFeatureGroups()
	 * @generated
	 */
	FeatureGroup createOwnedFeatureGroup();

	/**
	 * Returns the value of the '<em><b>Owned Abstract Feature</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AbstractFeature}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Abstract Feature</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Components.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Abstract Feature</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getComponentType_OwnedAbstractFeature()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<AbstractFeature> getOwnedAbstractFeatures();

	/**
	 * Creates a new {@link org.osate.aadl2.AbstractFeature} and appends it to the '<em><b>Owned Abstract Feature</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.AbstractFeature}.
	 * @see #getOwnedAbstractFeatures()
	 * @generated
	 */
	AbstractFeature createOwnedAbstractFeature();

	/**
	 * get list of all flow specs of a component type, including ancestor
	 * features In case of refined flow specs the refined flow spec is returned
	 * in the list.
	 *
	 * @return List of flow specs
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	EList<FlowSpecification> getAllFlowSpecifications();

} // ComponentType
