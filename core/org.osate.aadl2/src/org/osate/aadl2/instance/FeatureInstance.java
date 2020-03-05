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

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroupType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getSrcFlowSpecs <em>Src Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getDstFlowSpecs <em>Dst Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getFeatureInstances <em>Feature Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance()
 * @model
 * @generated
 */
public interface FeatureInstance extends ConnectionInstanceEnd, InstanceObject {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(Feature)
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_Feature()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Feature getFeature();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FeatureInstance#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(Feature value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(long)
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_Index()
	 * @model unique="false" dataType="org.osate.aadl2.Integer" ordered="false"
	 * @generated
	 */
	long getIndex();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FeatureInstance#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(long value);

	/**
	 * Returns the value of the '<em><b>Src Flow Spec</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.FlowSpecificationInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src Flow Spec</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Flow Spec</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_SrcFlowSpec()
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getSource
	 * @model opposite="source" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<FlowSpecificationInstance> getSrcFlowSpecs();

	/**
	 * Returns the value of the '<em><b>Dst Flow Spec</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.FlowSpecificationInstance}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.instance.FlowSpecificationInstance#getDestination <em>Destination</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dst Flow Spec</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dst Flow Spec</em>' reference list.
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_DstFlowSpec()
	 * @see org.osate.aadl2.instance.FlowSpecificationInstance#getDestination
	 * @model opposite="destination" resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	EList<FlowSpecificationInstance> getDstFlowSpecs();

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
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_FeatureInstance()
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
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.instance.FeatureCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see org.osate.aadl2.instance.FeatureCategory
	 * @see #setCategory(FeatureCategory)
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_Category()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FeatureCategory getCategory();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FeatureInstance#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see org.osate.aadl2.instance.FeatureCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(FeatureCategory value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.DirectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.osate.aadl2.DirectionType
	 * @see #setDirection(DirectionType)
	 * @see org.osate.aadl2.instance.InstancePackage#getFeatureInstance_Direction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DirectionType getDirection();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.instance.FeatureInstance#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.osate.aadl2.DirectionType
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionType value);

	/**
	 * find the matching inverse feature group instance in this feature group instance
	 * the contained feature group instance must have the inverse feature group type
	 * @param targetpgt feature group instance with feature group type to be found
	 * @return feature instance with the specified feature, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	FeatureInstance findInverseFeatureGroup(FeatureGroupType targetpgt);

	/**
	 * set the featureinstance category to that of the supplied feature
	 * @param f Feature
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	void setCategory(Feature f);

	/**
	 * find the feature instance of this feature instance
	 * @param feature feature whose instance is to be found
	 * @return feature instance with the specified feature, or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	FeatureInstance findFeatureInstance(Feature feature);

	Collection<FeatureInstance> findFeatureInstances(final EList<ContainmentPathElement> referencePath);

	/**
	 * @since 2.0
	 */
	boolean isAccess();

	/**
	 * Get direction of allowed data flow
	 *
	 * @return in/out for access features, result of getDirection() otherwise
	 * @since 2.0
	 */
	DirectionType getFlowDirection();
} // FeatureInstance
