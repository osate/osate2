/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A classifier is a classification of instances - it describes a set of instances that have features in common.
 * A classifier can specify a generalization hierarchy by referencing its general classifiers.
 * <p>From package AADLInfrastructure.</p>
 * <p>From package AADLProperties::Associations.</p>
 * <p>From package AADLConstructs::Extensibility.</p>
 * <p>From package AADLConstructs::Templates.</p>
 * <p>From package AADLDetails::NoneSupport.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Classifier#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#getInheritedMembers <em>Inherited Member</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#getGenerals <em>General</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#getOwnedPrototypes <em>Owned Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#isNoPrototypes <em>No Prototypes</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#isNoAnnexes <em>No Annexes</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#isNoProperties <em>No Properties</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends Namespace, Type {
	/**
	 * Returns the value of the '<em><b>Classifier Feature</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.ClassifierFeature}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.ClassifierFeature#getFeaturingClassifiers <em>Featuring Classifier</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getMembers() <em>Member</em>}'</li>
	 * </ul>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies each feature defined in the classifier.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Classifier Feature</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_ClassifierFeature()
	 * @see org.osate.aadl2.ClassifierFeature#getFeaturingClassifiers
	 * @model opposite="featuringClassifier" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<ClassifierFeature> getClassifierFeatures();

	/**
	 * Returns the value of the '<em><b>Inherited Member</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.NamedElement}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getMembers() <em>Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies all elements inherited by this classifier from the general classifiers.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inherited Member</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_InheritedMember()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<NamedElement> getInheritedMembers();

	/**
	 * Returns the value of the '<em><b>Generalization</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Generalization}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.Generalization#getSpecific <em>Specific</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the Generalization relationships for this Classifier. These Generalizations navigate to more general classifiers in the generalization hierarchy.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Generalization</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_Generalization()
	 * @see org.osate.aadl2.Generalization#getSpecific
	 * @model opposite="specific" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Generalization> getGeneralizations();

	/**
	 * Returns the value of the '<em><b>General</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Classifier}.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies the more general classifiers in the generalization hierarchy for this Classifier.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>General</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_General()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 *        annotation="union"
	 * @generated
	 */
	EList<Classifier> getGenerals();

	/**
	 * Returns the value of the '<em><b>Owned Prototype</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Prototype}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Prototype</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Templates.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Prototype</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_OwnedPrototype()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<Prototype> getOwnedPrototypes();

	/**
	 * Creates a new {@link org.osate.aadl2.Prototype} and appends it to the '<em><b>Owned Prototype</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.Prototype} to create.
	 * @return The new {@link org.osate.aadl2.Prototype}.
	 * @see #getOwnedPrototypes()
	 * @generated
	 */
	Prototype createOwnedPrototype(EClass eClass);

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
	 * <p>From package AADLConstructs::Templates.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Prototype Binding</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_OwnedPrototypeBinding()
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
	 * Returns the value of the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.AnnexSubclause}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Annex Subclause</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLConstructs::Extensibility.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Annex Subclause</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_OwnedAnnexSubclause()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	EList<AnnexSubclause> getOwnedAnnexSubclauses();

	/**
	 * Creates a new {@link org.osate.aadl2.AnnexSubclause} and appends it to the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.AnnexSubclause} to create.
	 * @return The new {@link org.osate.aadl2.AnnexSubclause}.
	 * @see #getOwnedAnnexSubclauses()
	 * @generated
	 */
	AnnexSubclause createOwnedAnnexSubclause(EClass eClass);

	/**
	 * Creates a new {@link org.osate.aadl2.DefaultAnnexSubclause} and appends it to the '<em><b>Owned Annex Subclause</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.DefaultAnnexSubclause}.
	 * @see #getOwnedAnnexSubclauses()
	 * @generated NOT
	 */
	DefaultAnnexSubclause createOwnedAnnexSubclause();

	/**
	 * Returns the value of the '<em><b>No Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Properties</em>' attribute.
	 * @see #setNoProperties(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_NoProperties()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoProperties();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Classifier#isNoProperties <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Properties</em>' attribute.
	 * @see #isNoProperties()
	 * @generated
	 */
	void setNoProperties(boolean value);

	/**
	 * Returns the value of the '<em><b>No Prototypes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Prototypes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Prototypes</em>' attribute.
	 * @see #setNoPrototypes(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_NoPrototypes()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoPrototypes();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Classifier#isNoPrototypes <em>No Prototypes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Prototypes</em>' attribute.
	 * @see #isNoPrototypes()
	 * @generated
	 */
	void setNoPrototypes(boolean value);

	/**
	 * Returns the value of the '<em><b>No Annexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Annexes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLDetails::NoneSupport.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>No Annexes</em>' attribute.
	 * @see #setNoAnnexes(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_NoAnnexes()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isNoAnnexes();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Classifier#isNoAnnexes <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Annexes</em>' attribute.
	 * @see #isNoAnnexes()
	 * @generated
	 */
	void setNoAnnexes(boolean value);

	/**
	 * Return a list of classifiers extended by this classifier including itself.
	 * That is, if classifier <code>C</code> extends
	 * classifier <code>B</code> that extends classifier <code>A</code>,
	 * then the list will contain classifiers <code>C</code>, <code>B</code>, and <code>A</code>
	 * in that order.
	 *
	 * <p>Although a well-formed model should not contain loops in the extension
	 * hierarchy, they may arise from erroneous editors or through badly formed
	 * AAXL files.  This method is safe to use even if a cycle exists.  In such
	 * a case, the returned list will contain all the classifiers up to but not
	 * including the cyclic reference.  So if the cycle is
	 * A extends B extends C extends D extends A, and the method is invoked
	 * on classifier C, then the returned list will be [C, D, A, B].
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	EList<Classifier> getSelfPlusAllExtended();

	/**
	 * returns the reference to the classifier being extended
	 * @return classifier
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	Classifier getExtended();

	/**
	 * get all features including inherited features
	 * @return EList of features
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	EList<Feature> getAllFeatures();

	/**
	 * Does this component classifier descend from the given classifier? A
	 * component type descends from another component type if they are the same
	 * type, it extends the other type, or it extends a descendant of the other
	 * type. A component type never descends from a component implementation or
	 * a feature group type. A component implementation descends from another
	 * component implementation if they are the same implementation, it extends
	 * the other implementation, or it extends a desendant of the other
	 * implementation. A component implementation descends from a component type
	 * if the implementation's component type descends from the type. A
	 * component implementation never descends from a feature group type. A feature
	 * group type descends from another feature group type if they are the same, it
	 * extends the other feature group type, or it extends a descendant of the
	 * other feature group type. A feature group type type never descends from another
	 * component type or implementation.
	 *
	 * @return Whether this classifier descends from the given classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	boolean isDescendentOf(Classifier c);

	/**
	 * Check whether the applies to classifiers in a property definition
	 * describe this classifier.
	 *
	 * @param property
	 * 			  The property definition
	 * @return Whether this classifier is a descendant of one of
	 * 		   the classifiers named in the property definition.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	boolean checkAppliesToClassifier(Property property);

	/**
	 * Get all the property associations, including those from any ancestor
	 * classifiers.
	 *
	 * @return A list of the property associations. Property associations from
	 * 		   an ancestor component classifier will appear before those of any
	 * 		   descendents.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	EList<PropertyAssociation> getAllPropertyAssociations();

	PrototypeBinding lookupPrototypeBinding(Prototype proto);

} // Classifier
