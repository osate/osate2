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
 * $Id: ElementOperations.java,v 1.6 2008-08-17 00:43:11 lwrage Exp $
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
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Element;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Element</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.Element#not_own_self(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Not own self</em>}</li>
 *   <li>{@link org.osate.aadl2.Element#has_owner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has owner</em>}</li>
 *   <li>{@link org.osate.aadl2.Element#getOwner() <em>Get Owner</em>}</li>
 *   <li>{@link org.osate.aadl2.Element#allOwnedElements() <em>All Owned Elements</em>}</li>
 *   <li>{@link org.osate.aadl2.Element#mustBeOwned() <em>Must Be Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementOperations {
	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementOperations() {
		super();
	}

	/**
	 * The cached OCL expression body for the '{@link #not_own_self(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Not own self</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #not_own_self(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.allOwnedElements()->includes(self)";

	/**
	 * The cached OCL invariant for the '{@link #not_own_self(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Not own self</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #not_own_self(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An element may not directly or indirectly own itself.
	 * @param element The receiving '<em><b>Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean not_own_self(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getElement());
			try {
				NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(element)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
								Aadl2Validator.ELEMENT__NOT_OWN_SELF, org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
										.getString(
												"_UI_GenericInvariant_diagnostic",
												new Object[] {
														"not_own_self",
														org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(
																element, context) }), new Object[] { element }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #has_owner(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has owner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_owner(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.mustBeOwned() implies owner->notEmpty()";

	/**
	 * The cached OCL invariant for the '{@link #has_owner(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has owner</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_owner(Element, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Elements that must be owned must have an owner.
	 * @param element The receiving '<em><b>Element</b></em>' model object.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean has_owner(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getElement());
			try {
				HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(element)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
								Aadl2Validator.ELEMENT__HAS_OWNER, org.eclipse.emf.ecore.plugin.EcorePlugin.INSTANCE
										.getString(
												"_UI_GenericInvariant_diagnostic",
												new Object[] {
														"has_owner",
														org.eclipse.emf.ecore.util.EObjectValidator.getObjectLabel(
																element, context) }), new Object[] { element }));
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
	public static Element getOwner(Element element) {
		return (Element) element.eContainer();
	}

	/**
	 * The cached OCL expression body for the '{@link #allOwnedElements(Element) <em>All Owned Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allOwnedElements(Element)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_OWNED_ELEMENTS__EOCL_EXP = "ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))";

	/**
	 * The cached OCL query for the '{@link #allOwnedElements(Element) <em>All Owned Elements</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allOwnedElements(Element)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> ALL_OWNED_ELEMENTS__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allOwnedElements() gives all of the direct and indirect owned elements of an element.
	 * <p>From package AADLInfrastructure.</p>
	 * @param element The receiving '<em><b>Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static EList<Element> allOwnedElements(Element element) {
		if (ALL_OWNED_ELEMENTS__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getElement(), Aadl2Package.eINSTANCE.getElement()
					.getEAllOperations().get(3));
			try {
				ALL_OWNED_ELEMENTS__EOCL_QRY = helper.createQuery(ALL_OWNED_ELEMENTS__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(ALL_OWNED_ELEMENTS__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<Element> result = (Collection<Element>) query.evaluate(element);
		return new BasicEList.UnmodifiableEList<Element>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #mustBeOwned(Element) <em>Must Be Owned</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #mustBeOwned(Element)
	 * @generated
	 * @ordered
	 */
	protected static final String MUST_BE_OWNED__EOCL_EXP = "true";

	/**
	 * The cached OCL query for the '{@link #mustBeOwned(Element) <em>Must Be Owned</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #mustBeOwned(Element)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> MUST_BE_OWNED__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query mustBeOwned() indicates whether elements of this type must have an owner. Subclasses of Element that do not require an owner must override this operation.
	 * <p>From package AADLInfrastructure.</p>
	 * @param element The receiving '<em><b>Element</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated
	 */
	public static boolean mustBeOwned(Element element) {
		if (MUST_BE_OWNED__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getElement(), Aadl2Package.eINSTANCE.getElement()
					.getEAllOperations().get(4));
			try {
				MUST_BE_OWNED__EOCL_QRY = helper.createQuery(MUST_BE_OWNED__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(MUST_BE_OWNED__EOCL_QRY);
		return ((Boolean) query.evaluate(element)).booleanValue();
	}

} // ElementOperations