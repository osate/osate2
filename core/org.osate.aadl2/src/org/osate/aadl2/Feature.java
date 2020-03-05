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
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLDetails::Connections.</p>
 * <p>From package AADLConstructs::Features.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Feature#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.Feature#getFeatureClassifier <em>Feature Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.Feature#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.Feature#getClassifier <em>Classifier</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getFeature()
 * @model abstract="true"
 * @generated
 */
public interface Feature extends StructuralFeature, FeatureConnectionEnd, ArrayableElement {
	/**
	 * Returns the value of the '<em><b>Prototype</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Feature#getFeatureClassifier() <em>Feature Classifier</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prototype</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getFeature_Prototype()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	ComponentPrototype getPrototype();

	/**
	 * Returns the value of the '<em><b>Feature Classifier</b></em>' reference.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Classifier</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getFeature_FeatureClassifier()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 * @generated
	 */
	FeatureClassifier getFeatureClassifier();

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Feature#getFeatureClassifier() <em>Feature Classifier</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classifier</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getFeature_Classifier()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Classifier getClassifier();

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
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Refined</em>' reference.
	 * @see #setRefined(Feature)
	 * @see org.osate.aadl2.Aadl2Package#getFeature_Refined()
	 * @model ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	Feature getRefined();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Feature#getRefined <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined</em>' reference.
	 * @see #getRefined()
	 * @generated
	 */
	void setRefined(Feature value);

	/**
	 * Return the feature and any of the features it refines
	 * @return EList of feature
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	EList<Feature> getAllFeatureRefinements();

	/**
	 * Get the classifier of given feature or its refinement ancestor, if it has one, otherwise null.
	 * @return The classifier, or <code>null</code> if no classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	Classifier getAllClassifier();

} // Feature
