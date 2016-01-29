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
 * $Id: NamedElementOperations.java,v 1.9 2009-02-26 21:21:13 lwrage Exp $
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
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Named Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.NamedElement#has_no_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has no qualified name</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#has_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has qualified name</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#getNamespace() <em>Get Namespace</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#allNamespaces() <em>All Namespaces</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#isDistinguishableFrom(org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace) <em>Is Distinguishable From</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#separator() <em>Separator</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#qualifiedName() <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.aadl2.NamedElement#getPropertyValues(java.lang.String, java.lang.String) <em>Get Property Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NamedElementOperations extends ElementOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementOperations() {
		super();
	}

	/**
	 * The cached OCL expression body for the '{@link #has_no_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has no qualified name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_no_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty()) implies self.qualifiedName->isEmpty()";

	/**
	 * The cached OCL invariant for the '{@link #has_no_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has no qualified name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_no_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If there is no name, or one of the containing namespaces has no name, there is no qualified name.
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean has_no_qualified_name(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getNamedElement());
			try {
				HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(namedElement)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
								Aadl2Validator.NAMED_ELEMENT__HAS_NO_QUALIFIED_NAME,
								org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
										.getString("_UI_GenericInvariant_diagnostic",
												new Object[] { "has_no_qualified_name",
														org.eclipse.emf.ecore.util.EObjectValidator
																.getObjectLabel(namedElement, context) }),
								new Object[] { namedElement }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #has_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has qualified name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) "
			+ "implies "
			+ "self.qualifiedName = self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))";

	/**
	 * The cached OCL invariant for the '{@link #has_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has qualified name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_qualified_name(NamedElement, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name, the qualified name is constructed from the names of the containing namespaces.
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean has_qualified_name(NamedElement namedElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getNamedElement());
			try {
				HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(namedElement)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
								Aadl2Validator.NAMED_ELEMENT__HAS_QUALIFIED_NAME,
								org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
										.getString("_UI_GenericInvariant_diagnostic",
												new Object[] { "has_qualified_name",
														org.eclipse.emf.ecore.util.EObjectValidator
																.getObjectLabel(namedElement, context) }),
								new Object[] { namedElement }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Namespace getNamespace(NamedElement namedElement) {
		// DONE: implement this method
		return namedElement.getOwner() instanceof Namespace ? (Namespace) namedElement.getOwner() : null;
	}

	/**
	 * The cached OCL expression body for the '{@link #allNamespaces(NamedElement) <em>All Namespaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allNamespaces(NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_NAMESPACES__EOCL_EXP = "if self.namespace->isEmpty() then " + "  Sequence{}"
			+ "else" + "  self.namespace.allNamespaces()->prepend(self.namespace)" + "endif";

	/**
	 * The cached OCL query for the '{@link #allNamespaces(NamedElement) <em>All Namespaces</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allNamespaces(NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> ALL_NAMESPACES__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allNamespaces() gives the sequence of namespaces in which the NamedElement is nested, working outwards.
	 * <p>From package AADLInfrastructure.</p>
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<Namespace> allNamespaces(NamedElement namedElement) {
		if (ALL_NAMESPACES__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(),
					Aadl2Package.eINSTANCE.getNamedElement().getEAllOperations().get(8));
			try {
				ALL_NAMESPACES__EOCL_QRY = helper.createQuery(ALL_NAMESPACES__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(ALL_NAMESPACES__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<Namespace> result = (Collection<Namespace>) query.evaluate(namedElement);
		return new BasicEList.UnmodifiableEList<Namespace>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #isDistinguishableFrom(NamedElement, org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace) <em>Is Distinguishable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinguishableFrom(NamedElement, org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace)
	 * @generated
	 * @ordered
	 */
	protected static final String IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_EXP = "if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType) then"
			+ "  ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()" + "else" + "  true"
			+ "endif";

	/**
	 * The cached OCL query for the '{@link #isDistinguishableFrom(NamedElement, org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace) <em>Is Distinguishable From</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinguishableFrom(NamedElement, org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isDistinguishableFrom() determines whether two NamedElements may logically co-exist within a Namespace. By default, two named elements are distinguishable if (a) they have unrelated types or (b) they have related types but different names.
	 * <p>From package AADLInfrastructure.</p>
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean isDistinguishableFrom(NamedElement namedElement, NamedElement n, Namespace ns) {
		if (IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(),
					Aadl2Package.eINSTANCE.getNamedElement().getEAllOperations().get(9));
			try {
				IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_QRY = helper
						.createQuery(IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_QRY);
		EvaluationEnvironment<?, ?, ?, ?, ?> environment = query.getEvaluationEnvironment();
		environment.add("n", n);
		environment.add("ns", ns);
		return ((Boolean) query.evaluate(namedElement)).booleanValue();
	}

	/**
	 * The cached OCL expression body for the '{@link #separator(NamedElement) <em>Separator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #separator(NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static final String SEPARATOR__EOCL_EXP = "'.'";

	/**
	 * The cached OCL query for the '{@link #separator(NamedElement) <em>Separator</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #separator(NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> SEPARATOR__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query separator() gives the string that is used to separate names when constructing a qualified name.
	 * <p>From package AADLInfrastructure.</p>
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static String separator(NamedElement namedElement) {
		if (SEPARATOR__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(),
					Aadl2Package.eINSTANCE.getNamedElement().getEAllOperations().get(10));
			try {
				SEPARATOR__EOCL_QRY = helper.createQuery(SEPARATOR__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(SEPARATOR__EOCL_QRY);
		return (String) query.evaluate(namedElement);
	}

	/**
	 * The cached OCL expression body for the '{@link #qualifiedName(NamedElement) <em>Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedName(NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME__EOCL_EXP = "if self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty() then"
			+ "  self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))"
			+ "else " + "  '' " + "endif";

	/**
	 * The cached OCL query for the '{@link #qualifiedName(NamedElement) <em>Qualified Name</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedName(NamedElement)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> QUALIFIED_NAME__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * When there is a name, and all of the containing namespaces have a name, the qualified name is constructed from the names of the containing namespaces.
	 * if self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty() then
	 *   self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))
	 * else
	 *   ''
	 * endif
	 * @param namedElement The receiving '<em><b>Named Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static String qualifiedName(NamedElement namedElement) {
		if (namedElement.hasName()) {
			Namespace namespace = namedElement.getNamespace();
			if (namespace != null) {
				if (namespace instanceof PropertySet && namespace.hasName()) {
					return namespace.getName() + "::" + namedElement.getName();
				} else if (namespace instanceof PackageSection && ((AadlPackage) namespace.getOwner()).hasName()) {
					return ((AadlPackage) namespace.getOwner()).getName() + "::" + namedElement.getName();
				} else {
					return qualifiedName(namespace) + '.' + namedElement.getName();
				}
			} else {
				return namedElement.getName();
			}
		} else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public static EList<PropertyExpression> getPropertyValues(NamedElement namedElement, String propertySetName,
			String propertyName) {
		final EList<PropertyExpression> result = new BasicEList<PropertyExpression>();
		final Property property = Aadl2Util.lookupPropertyDefinition(namedElement, propertySetName, propertyName);

		try {
			if (property.isList()) {
				result.addAll(namedElement.getPropertyValueList(property));
			} else {
				result.add(namedElement.getSimplePropertyValue(property));
			}
		} catch (final PropertyNotPresentException p_ex) {
			// We simply return an empty list when there is no property associations
		}

		return result;
	}

} // NamedElementOperations