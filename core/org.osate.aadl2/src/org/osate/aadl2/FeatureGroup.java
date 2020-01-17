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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Group</b></em>'.
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
 *   <li>{@link org.osate.aadl2.FeatureGroup#isInverse <em>Inverse</em>}</li>
 *   <li>{@link org.osate.aadl2.FeatureGroup#getFeatureType <em>Feature Type</em>}</li>
 *   <li>{@link org.osate.aadl2.FeatureGroup#getFeatureGroupType <em>Feature Group Type</em>}</li>
 *   <li>{@link org.osate.aadl2.FeatureGroup#getFeatureGroupPrototype <em>Feature Group Prototype</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getFeatureGroup()
 * @model
 * @generated
 */
public interface FeatureGroup extends DirectedFeature, Context, FeatureGroupConnectionEnd, CallContext {
	/**
	 * Returns the value of the '<em><b>Inverse</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inverse</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inverse</em>' attribute.
	 * @see #setInverse(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getFeatureGroup_Inverse()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isInverse();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FeatureGroup#isInverse <em>Inverse</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inverse</em>' attribute.
	 * @see #isInverse()
	 * @generated
	 */
	void setInverse(boolean value);

	/**
	 * Returns the value of the '<em><b>Feature Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Type</em>' reference.
	 * @see #setFeatureType(FeatureType)
	 * @see org.osate.aadl2.Aadl2Package#getFeatureGroup_FeatureType()
	 * @model ordered="false"
	 * @generated
	 */
	FeatureType getFeatureType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.FeatureGroup#getFeatureType <em>Feature Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Type</em>' reference.
	 * @see #getFeatureType()
	 * @generated
	 */
	void setFeatureType(FeatureType value);

	/**
	 * Returns the value of the '<em><b>Feature Group Type</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.FeatureGroup#getFeatureType() <em>Feature Type</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Group Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Group Type</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getFeatureGroup_FeatureGroupType()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	FeatureGroupType getFeatureGroupType();

	/**
	 * Get the classifier of given feature or its refinement ancestor, if it has one, otherwise null.
	 * @return The classifier, or <code>null</code> if no classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	Classifier getAllClassifier();

	/**
	 * Get the classifier of given feature, if it has one, otherwise null.
	 * @return The classifier, or <code>null</code> if no classifier.
	 */
	Classifier getClassifier();

	/*
	 * Get the feature group type of given feature group or its refinement ancestor, if it has
	 * one, otherwise null.
	 *
	 * @return The FeatureGroupType, or <code>null</code> if none.
	 */
	FeatureGroupType getAllFeatureGroupType();

	/**
	 * Returns the value of the '<em><b>Feature Group Prototype</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.FeatureGroup#getFeatureType() <em>Feature Type</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Group Prototype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Features.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Feature Group Prototype</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getFeatureGroup_FeatureGroupPrototype()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	FeatureGroupPrototype getFeatureGroupPrototype();

	/**
	 * return the index of the feature in the feature group type
	 * @param feature Feature
	 * @return int index of feature or -1 if not found
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	int getIndexOf(Feature feature);

	/**
	 * check for inverseof between two features.
	 * If they are feature groups then we check both the inverse of on the feature group and whether the feature group type is inverseof.
	 * @param f1
	 * @param f2
	 * @return boolean
	 */
	boolean isInverseOf(FeatureGroup fg2);

} // FeatureGroup
