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
 * $Id: ComponentType.java,v 1.25 2011-04-11 13:35:55 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedFeatures <em>Owned Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getExtended <em>Extended</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedFlowSpecifications <em>Owned Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedExtension <em>Owned Extension</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedFeatureGroups <em>Owned Feature Group</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#getOwnedAbstractFeatures <em>Owned Abstract Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentType#isNoFeatures <em>No Features</em>}</li>
 * </ul>
 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<Feature> getOwnedFeatures();

	/**
	 * Returns the value of the '<em><b>Extended</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGenerals() <em>General</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	@Override
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getGeneralizations() <em>Generalization</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.ComponentType#getOwnedFeatures() <em>Owned Feature</em>}'</li>
	 * </ul>
	 * </p>
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
