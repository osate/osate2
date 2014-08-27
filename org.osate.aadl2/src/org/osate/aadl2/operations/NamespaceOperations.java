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
 * $Id: NamespaceOperations.java,v 1.6 2008-08-17 00:43:11 lwrage Exp $
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
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Namespace</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.Namespace#members_distinguishable(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Members distinguishable</em>}</li>
 *   <li>{@link org.osate.aadl2.Namespace#getNamesOfMember(org.osate.aadl2.NamedElement) <em>Get Names Of Member</em>}</li>
 *   <li>{@link org.osate.aadl2.Namespace#membersAreDistinguishable() <em>Members Are Distinguishable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamespaceOperations extends NamedElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamespaceOperations() {
		super();
	}

	/**
	 * The cached OCL expression body for the '{@link #members_distinguishable(Namespace, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Members distinguishable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #members_distinguishable(Namespace, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBERS_DISTINGUISHABLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "membersAreDistinguishable()";

	/**
	 * The cached OCL invariant for the '{@link #members_distinguishable(Namespace, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Members distinguishable</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #members_distinguishable(Namespace, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint MEMBERS_DISTINGUISHABLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * All the members of a Namespace are distinguishable within it.
	 * @param namespace The receiving '<em><b>Namespace</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean members_distinguishable(Namespace namespace, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (MEMBERS_DISTINGUISHABLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getNamespace());
			try {
				MEMBERS_DISTINGUISHABLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(MEMBERS_DISTINGUISHABLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(MEMBERS_DISTINGUISHABLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(namespace)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.NAMESPACE__MEMBERS_DISTINGUISHABLE,
						org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
								.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"members_distinguishable",
												org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(namespace,
														context) }), new Object[] { namespace }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #getNamesOfMember(Namespace, org.osate.aadl2.NamedElement) <em>Get Names Of Member</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamesOfMember(Namespace, org.osate.aadl2.NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static final String GET_NAMES_OF_MEMBER__NAMED_ELEMENT__EOCL_EXP = "if member->includes(element) then"
			+ "  Set{}->including(element.name)" + "else" + "  Set{}" + "endif";

	/**
	 * The cached OCL query for the '{@link #getNamesOfMember(Namespace, org.osate.aadl2.NamedElement) <em>Get Names Of Member</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamesOfMember(Namespace, org.osate.aadl2.NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> GET_NAMES_OF_MEMBER__NAMED_ELEMENT__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query getNamesOfMember() gives a set of all of the names that a member would have in a Namespace. In general a member can have multiple names in a Namespace if it is imported more than once with different aliases. Those semantics are specified by overriding the getNamesOfMember operation. The specification here simply returns a set containing a single name, or the empty set if no name.
	 * <p>From package AADLInfrastructure.</p>
	 * @param namespace The receiving '<em><b>Namespace</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<String> getNamesOfMember(Namespace namespace, NamedElement element) {
		if (GET_NAMES_OF_MEMBER__NAMED_ELEMENT__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamespace(), Aadl2Package.eINSTANCE.getNamespace()
					.getEAllOperations().get(14));
			try {
				GET_NAMES_OF_MEMBER__NAMED_ELEMENT__EOCL_QRY = helper
						.createQuery(GET_NAMES_OF_MEMBER__NAMED_ELEMENT__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(GET_NAMES_OF_MEMBER__NAMED_ELEMENT__EOCL_QRY);
		EvaluationEnvironment<?, ?, ?, ?, ?> environment = query.getEvaluationEnvironment();
		environment.add("element", element);
		@SuppressWarnings("unchecked")
		Collection<String> result = (Collection<String>) query.evaluate(namespace);
		return new BasicEList.UnmodifiableEList<String>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #membersAreDistinguishable(Namespace) <em>Members Are Distinguishable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #membersAreDistinguishable(Namespace)
	 * @generated
	 * @ordered
	 */
	protected static final String MEMBERS_ARE_DISTINGUISHABLE__EOCL_EXP = "self.member->forAll( memb | self.member->excluding(memb)->forAll(other | memb.isDistinguishableFrom(other, self)))";

	/**
	 * The cached OCL query for the '{@link #membersAreDistinguishable(Namespace) <em>Members Are Distinguishable</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #membersAreDistinguishable(Namespace)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> MEMBERS_ARE_DISTINGUISHABLE__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Boolean query membersAreDistinguishable() determines whether all of the namespaces members are distinguishable within it.
	 * <p>From package AADLInfrastructure.</p>
	 * @param namespace The receiving '<em><b>Namespace</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean membersAreDistinguishable(Namespace namespace) {
		if (MEMBERS_ARE_DISTINGUISHABLE__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamespace(), Aadl2Package.eINSTANCE.getNamespace()
					.getEAllOperations().get(15));
			try {
				MEMBERS_ARE_DISTINGUISHABLE__EOCL_QRY = helper.createQuery(MEMBERS_ARE_DISTINGUISHABLE__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(MEMBERS_ARE_DISTINGUISHABLE__EOCL_QRY);
		return ((Boolean) query.evaluate(namespace)).booleanValue();
	}

} // NamespaceOperations