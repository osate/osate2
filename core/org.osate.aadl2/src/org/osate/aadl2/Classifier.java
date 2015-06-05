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
 * $Id: Classifier.java,v 1.30 2009-07-24 15:53:21 lwrage Exp $
 */
package org.osate.aadl2;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
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
 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getMembers() <em>Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<ClassifierFeature> getClassifierFeatures();

	/**
	 * Returns the value of the '<em><b>Inherited Member</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.NamedElement}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getMembers() <em>Member</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Specifies all elements inherited by this classifier from the general classifiers.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inherited Member</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getClassifier_InheritedMember()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getInheritedMembers();

	/**
	 * Returns the value of the '<em><b>Generalization</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Generalization}.
	 * It is bidirectional and its opposite is '{@link org.osate.aadl2.Generalization#getSpecific <em>Specific</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * </p>
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
	 * @generated
	 */
	EList<Classifier> getGenerals();

	/**
	 * Returns the value of the '<em><b>Owned Prototype</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.Prototype}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.Namespace#getOwnedMembers() <em>Owned Member</em>}'</li>
	 * </ul>
	 * </p>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generalization hierarchies must be directed and acyclical. A classifier can not be both a transitively general and transitively specific classifier of the same classifier.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='not self.allParents()->includes(self)'"
	 * @generated
	 */
	boolean no_cycles_in_generalization(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A classifier may only specialize classifiers of a valid type.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parents()->forAll(c | self.maySpecializeType(c))'"
	 * @generated
	 */
	boolean specialize_type(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allFeatures() gives all of the features in the namespace of the classifier. In general, through mechanisms such as inheritance, this will be a larger set than feature.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='member->select(oclIsKindOf(Feature))'"
	 * @generated
	 */
	EList<ClassifierFeature> allFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inheritedMember association is derived by inheriting the inheritable members of the parents.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.inherit(self.parents()->collect(p | p.inheritableMembers(self))'"
	 * @generated
	 */
	EList<NamedElement> inheritedMember();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query parents() gives all of the immediate ancestors of a generalized Classifier.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='general'"
	 * @generated
	 */
	EList<Classifier> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allParents() gives all of the direct and indirect ancestors of a generalized Classifier.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parents()->union(self.parents()->collect(p | p.allParents())'"
	 * @generated
	 */
	EList<Classifier> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query inheritableMembers() gives all of the members of a classifier that may be inherited in one of its descendants, subject to whatever visibility restrictions apply.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false" cRequired="true" cOrdered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='member->select(m | c.hasVisibilityOf(m))'"
	 * @generated
	 */
	EList<NamedElement> inheritableMembers(Classifier c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query hasVisibilityOf() determines whether a named element is visible in the classifier. By default all are visible. It is only called when the argument is something owned by a parent.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false" nRequired="true" nOrdered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if (self.inheritedMember->includes (n)) then (n.visibility <> #private) else true'"
	 * @generated
	 */
	boolean hasVisibilityOf(NamedElement n);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query inherit() defines how to inherit a set of elements. Here the operation is defined to inherit them all. It is intended to be redefined in circumstances where inheritance is affected by redefinition.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false" inhsMany="true" inhsOrdered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='inhs'"
	 * @generated
	 */
	EList<NamedElement> inherit(EList<NamedElement> inhs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query maySpecializeType() determines whether this classifier may have a generalization relationship to classifiers of the specified type. By default a classifier may specialize classifiers of the same or a more general type. It is intended to be redefined by classifiers that have different specialization constraints.
	 * <p>From package AADLInfrastructure.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false" cRequired="true" cOrdered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.oclIsKindOf(c.oclType)'"
	 * @generated
	 */
	boolean maySpecializeType(Classifier c);

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
