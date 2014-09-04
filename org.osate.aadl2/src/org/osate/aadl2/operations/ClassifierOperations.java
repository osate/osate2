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
 * $Id: ClassifierOperations.java,v 1.5 2008-07-31 18:24:28 lwrage Exp $
 */
package org.osate.aadl2.operations;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Classifier</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.Classifier#no_cycles_in_generalization(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No cycles in generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#specialize_type(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specialize type</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#allFeatures() <em>All Features</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#inheritedMember() <em>Inherited Member</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#parents() <em>Parents</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#allParents() <em>All Parents</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#inheritableMembers(org.osate.aadl2.Classifier) <em>Inheritable Members</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#hasVisibilityOf(org.osate.aadl2.NamedElement) <em>Has Visibility Of</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#inherit(org.eclipse.emf.common.util.EList) <em>Inherit</em>}</li>
 *   <li>{@link org.osate.aadl2.Classifier#maySpecializeType(org.osate.aadl2.Classifier) <em>May Specialize Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassifierOperations extends NamespaceOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierOperations() {
		super();
	}

	/**
	 * The cached OCL expression body for the '{@link #no_cycles_in_generalization(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No cycles in generalization</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #no_cycles_in_generalization(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NO_CYCLES_IN_GENERALIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.allParents()->includes(self)";

	/**
	 * The cached OCL invariant for the '{@link #no_cycles_in_generalization(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No cycles in generalization</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #no_cycles_in_generalization(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NO_CYCLES_IN_GENERALIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Generalization hierarchies must be directed and acyclical. A classifier can not be both a transitively general and transitively specific classifier of the same classifier.
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean no_cycles_in_generalization(Classifier classifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (NO_CYCLES_IN_GENERALIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getClassifier());
			try {
				NO_CYCLES_IN_GENERALIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(NO_CYCLES_IN_GENERALIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NO_CYCLES_IN_GENERALIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(classifier)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.CLASSIFIER__NO_CYCLES_IN_GENERALIZATION,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
								.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"no_cycles_in_generalization",
												org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(classifier,
														context) }), new Object[] { classifier }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #specialize_type(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specialize type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #specialize_type(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIALIZE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parents()->forAll(c | self.maySpecializeType(c))";

	/**
	 * The cached OCL invariant for the '{@link #specialize_type(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Specialize type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #specialize_type(Classifier, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint SPECIALIZE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A classifier may only specialize classifiers of a valid type.
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean specialize_type(Classifier classifier, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (SPECIALIZE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getClassifier());
			try {
				SPECIALIZE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(SPECIALIZE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(SPECIALIZE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(classifier)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.CLASSIFIER__SPECIALIZE_TYPE, org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
								.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"specialize_type",
												org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(classifier,
														context) }), new Object[] { classifier }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #allFeatures(Classifier) <em>All Features</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allFeatures(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_FEATURES__EOCL_EXP = "member->select(oclIsKindOf(Feature))";

	/**
	 * The cached OCL query for the '{@link #allFeatures(Classifier) <em>All Features</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allFeatures(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> ALL_FEATURES__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allFeatures() gives all of the features in the namespace of the classifier. In general, through mechanisms such as inheritance, this will be a larger set than feature.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<ClassifierFeature> allFeatures(Classifier classifier) {
		if (ALL_FEATURES__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(19));
			try {
				ALL_FEATURES__EOCL_QRY = helper.createQuery(ALL_FEATURES__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(ALL_FEATURES__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<ClassifierFeature> result = (Collection<ClassifierFeature>) query.evaluate(classifier);
		return new BasicEList.UnmodifiableEList<ClassifierFeature>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #inheritedMember(Classifier) <em>Inherited Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inheritedMember(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static final String INHERITED_MEMBER__EOCL_EXP = "self.inherit(self.parents()->collect(p | p.inheritableMembers(self))";

	/**
	 * The cached OCL query for the '{@link #inheritedMember(Classifier) <em>Inherited Member</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inheritedMember(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> INHERITED_MEMBER__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The inheritedMember association is derived by inheriting the inheritable members of the parents.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<NamedElement> inheritedMember(Classifier classifier) {
		if (INHERITED_MEMBER__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(20));
			try {
				INHERITED_MEMBER__EOCL_QRY = helper.createQuery(INHERITED_MEMBER__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(INHERITED_MEMBER__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<NamedElement> result = (Collection<NamedElement>) query.evaluate(classifier);
		return new BasicEList.UnmodifiableEList<NamedElement>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #parents(Classifier) <em>Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parents(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static final String PARENTS__EOCL_EXP = "general";

	/**
	 * The cached OCL query for the '{@link #parents(Classifier) <em>Parents</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #parents(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> PARENTS__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query parents() gives all of the immediate ancestors of a generalized Classifier.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<Classifier> parents(Classifier classifier) {
		if (PARENTS__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(21));
			try {
				PARENTS__EOCL_QRY = helper.createQuery(PARENTS__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(PARENTS__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<Classifier> result = (Collection<Classifier>) query.evaluate(classifier);
		return new BasicEList.UnmodifiableEList<Classifier>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #allParents(Classifier) <em>All Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allParents(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_PARENTS__EOCL_EXP = "self.parents()->union(self.parents()->collect(p | p.allParents())";

	/**
	 * The cached OCL query for the '{@link #allParents(Classifier) <em>All Parents</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allParents(Classifier)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> ALL_PARENTS__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allParents() gives all of the direct and indirect ancestors of a generalized Classifier.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<Classifier> allParents(Classifier classifier) {
		if (ALL_PARENTS__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(22));
			try {
				ALL_PARENTS__EOCL_QRY = helper.createQuery(ALL_PARENTS__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(ALL_PARENTS__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<Classifier> result = (Collection<Classifier>) query.evaluate(classifier);
		return new BasicEList.UnmodifiableEList<Classifier>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #inheritableMembers(Classifier, org.osate.aadl2.Classifier) <em>Inheritable Members</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inheritableMembers(Classifier, org.osate.aadl2.Classifier)
	 * @generated
	 * @ordered
	 */
	protected static final String INHERITABLE_MEMBERS__CLASSIFIER__EOCL_EXP = "member->select(m | c.hasVisibilityOf(m))";

	/**
	 * The cached OCL query for the '{@link #inheritableMembers(Classifier, org.osate.aadl2.Classifier) <em>Inheritable Members</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inheritableMembers(Classifier, org.osate.aadl2.Classifier)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> INHERITABLE_MEMBERS__CLASSIFIER__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query inheritableMembers() gives all of the members of a classifier that may be inherited in one of its descendants, subject to whatever visibility restrictions apply.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<NamedElement> inheritableMembers(Classifier classifier, Classifier c) {
		if (INHERITABLE_MEMBERS__CLASSIFIER__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(23));
			try {
				INHERITABLE_MEMBERS__CLASSIFIER__EOCL_QRY = helper
						.createQuery(INHERITABLE_MEMBERS__CLASSIFIER__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(INHERITABLE_MEMBERS__CLASSIFIER__EOCL_QRY);
		EvaluationEnvironment<?, ?, ?, ?, ?> environment = query.getEvaluationEnvironment();
		environment.add("c", c);
		@SuppressWarnings("unchecked")
		Collection<NamedElement> result = (Collection<NamedElement>) query.evaluate(classifier);
		return new BasicEList.UnmodifiableEList<NamedElement>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #hasVisibilityOf(Classifier, org.osate.aadl2.NamedElement) <em>Has Visibility Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #hasVisibilityOf(Classifier, org.osate.aadl2.NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_VISIBILITY_OF__NAMED_ELEMENT__EOCL_EXP = "if (self.inheritedMember->includes (n)) then (n.visibility <> #private) else true";

	/**
	 * The cached OCL query for the '{@link #hasVisibilityOf(Classifier, org.osate.aadl2.NamedElement) <em>Has Visibility Of</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #hasVisibilityOf(Classifier, org.osate.aadl2.NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> HAS_VISIBILITY_OF__NAMED_ELEMENT__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query hasVisibilityOf() determines whether a named element is visible in the classifier. By default all are visible. It is only called when the argument is something owned by a parent.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean hasVisibilityOf(Classifier classifier, NamedElement n) {
		if (HAS_VISIBILITY_OF__NAMED_ELEMENT__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(24));
			try {
				HAS_VISIBILITY_OF__NAMED_ELEMENT__EOCL_QRY = helper
						.createQuery(HAS_VISIBILITY_OF__NAMED_ELEMENT__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(HAS_VISIBILITY_OF__NAMED_ELEMENT__EOCL_QRY);
		EvaluationEnvironment<?, ?, ?, ?, ?> environment = query.getEvaluationEnvironment();
		environment.add("n", n);
		return ((Boolean) query.evaluate(classifier)).booleanValue();
	}

	/**
	 * The cached OCL expression body for the '{@link #inherit(Classifier, org.eclipse.emf.common.util.EList) <em>Inherit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inherit(Classifier, org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static final String INHERIT__ELIST__EOCL_EXP = "inhs";

	/**
	 * The cached OCL query for the '{@link #inherit(Classifier, org.eclipse.emf.common.util.EList) <em>Inherit</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #inherit(Classifier, org.eclipse.emf.common.util.EList)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> INHERIT__ELIST__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query inherit() defines how to inherit a set of elements. Here the operation is defined to inherit them all. It is intended to be redefined in circumstances where inheritance is affected by redefinition.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<NamedElement> inherit(Classifier classifier, EList<NamedElement> inhs) {
		if (INHERIT__ELIST__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(25));
			try {
				INHERIT__ELIST__EOCL_QRY = helper.createQuery(INHERIT__ELIST__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(INHERIT__ELIST__EOCL_QRY);
		EvaluationEnvironment<?, ?, ?, ?, ?> environment = query.getEvaluationEnvironment();
		environment.add("inhs", inhs);
		@SuppressWarnings("unchecked")
		Collection<NamedElement> result = (Collection<NamedElement>) query.evaluate(classifier);
		return new BasicEList.UnmodifiableEList<NamedElement>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #maySpecializeType(Classifier, org.osate.aadl2.Classifier) <em>May Specialize Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #maySpecializeType(Classifier, org.osate.aadl2.Classifier)
	 * @generated
	 * @ordered
	 */
	protected static final String MAY_SPECIALIZE_TYPE__CLASSIFIER__EOCL_EXP = "self.oclIsKindOf(c.oclType)";

	/**
	 * The cached OCL query for the '{@link #maySpecializeType(Classifier, org.osate.aadl2.Classifier) <em>May Specialize Type</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #maySpecializeType(Classifier, org.osate.aadl2.Classifier)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> MAY_SPECIALIZE_TYPE__CLASSIFIER__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query maySpecializeType() determines whether this classifier may have a generalization relationship to classifiers of the specified type. By default a classifier may specialize classifiers of the same or a more general type. It is intended to be redefined by classifiers that have different specialization constraints.
	 * <p>From package AADLInfrastructure.</p>
	 * @param classifier The receiving '<em><b>Classifier</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean maySpecializeType(Classifier classifier, Classifier c) {
		if (MAY_SPECIALIZE_TYPE__CLASSIFIER__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getClassifier(), Aadl2Package.eINSTANCE.getClassifier()
					.getEAllOperations().get(26));
			try {
				MAY_SPECIALIZE_TYPE__CLASSIFIER__EOCL_QRY = helper
						.createQuery(MAY_SPECIALIZE_TYPE__CLASSIFIER__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(MAY_SPECIALIZE_TYPE__CLASSIFIER__EOCL_QRY);
		EvaluationEnvironment<?, ?, ?, ?, ?> environment = query.getEvaluationEnvironment();
		environment.add("c", c);
		return ((Boolean) query.evaluate(classifier)).booleanValue();
	}

} // ClassifierOperations