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
 * $Id: FeatureInstance.java,v 1.11 2010-05-12 20:09:22 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getSrcFlowSpecs <em>Src Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getDstFlowSpecs <em>Dst Flow Spec</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getFeatureInstances <em>Feature Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getCategory <em>Category</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.FeatureInstance#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
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
	 * @model opposite="source" ordered="false"
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
	 * @model opposite="destination" ordered="false"
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
} // FeatureInstance
