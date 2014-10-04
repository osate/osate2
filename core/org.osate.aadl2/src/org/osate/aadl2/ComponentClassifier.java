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
 * $Id: ComponentClassifier.java,v 1.15 2009-07-21 19:36:34 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#getOwnedModes <em>Owned Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#getOwnedModeTransitions <em>Owned Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#isDerivedModes <em>Derived Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#isNoFlows <em>No Flows</em>}</li>
 *   <li>{@link org.osate.aadl2.ComponentClassifier#isNoModes <em>No Modes</em>}</li>
 * </ul>
 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Classifier#getClassifierFeatures() <em>Classifier Feature</em>}'</li>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
