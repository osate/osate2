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
 * $Id: ElementImpl.java,v 1.24 2011-04-11 13:35:54 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Comment;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.parsesupport.AObjectImpl;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ElementImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ElementImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ElementImpl#getOwnedComments <em>Owned Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ElementImpl extends AObjectImpl implements Element {
	/**
	 * The cached value of the '{@link #getOwnedComments() <em>Owned Comment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> ownedComments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> getOwnedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Element> ownedElements = (EList<Element>) cache.get(
					eResource, this,
					Aadl2Package.eINSTANCE.getElement_OwnedElement());
			if (ownedElements == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE
						.getElement_OwnedElement(),
						ownedElements = new DerivedUnionEObjectEList<Element>(
								Element.class, this,
								Aadl2Package.ELEMENT__OWNED_ELEMENT,
								OWNED_ELEMENT_ESUBSETS));
			}
			return ownedElements;
		}
		return new DerivedUnionEObjectEList<Element>(Element.class, this,
				Aadl2Package.ELEMENT__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedElements() <em>Owned Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_ELEMENT_ESUBSETS = new int[] { Aadl2Package.ELEMENT__OWNED_COMMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Element getOwner() {
		return (Element) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getOwnedComments() {
		if (ownedComments == null) {
			ownedComments = new EObjectContainmentEList<Comment>(Comment.class,
					this, Aadl2Package.ELEMENT__OWNED_COMMENT);
		}
		return ownedComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createOwnedComment() {
		Comment newOwnedComment = (Comment) create(Aadl2Package.eINSTANCE
				.getComment());
		getOwnedComments().add(newOwnedComment);
		return newOwnedComment;
	}

	/**
	 * The cached OCL expression body for the '{@link #not_own_self(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Not own self</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #not_own_self(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.allOwnedElements()->includes(self)";
	/**
	 * The cached OCL invariant for the '{@link #not_own_self(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Not own self</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #not_own_self(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean not_own_self(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getElement());
			try {
				NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NOT_OWN_SELF__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.ELEMENT__NOT_OWN_SELF,
						EcorePlugin.INSTANCE.getString(
								"_UI_GenericInvariant_diagnostic",
								new Object[] {
										"not_own_self",
										EObjectValidator.getObjectLabel(this,
												context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #has_owner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has owner</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_owner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.mustBeOwned() implies owner->notEmpty()";
	/**
	 * The cached OCL invariant for the '{@link #has_owner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has owner</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_owner(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean has_owner(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(Aadl2Package.eINSTANCE.getElement());
			try {
				HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(HAS_OWNER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.ELEMENT__HAS_OWNER, EcorePlugin.INSTANCE
								.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"has_owner",
												EObjectValidator
														.getObjectLabel(this,
																context) }),
						new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #allOwnedElements() <em>All Owned Elements</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_OWNED_ELEMENTS__EOCL_EXP = "ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))";
	/**
	 * The cached OCL query for the '{@link #allOwnedElements() <em>All Owned Elements</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> ALL_OWNED_ELEMENTS__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Element> allOwnedElements() {
		if (ALL_OWNED_ELEMENTS__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getElement(),
					Aadl2Package.eINSTANCE.getElement().getEAllOperations()
							.get(2));
			try {
				ALL_OWNED_ELEMENTS__EOCL_QRY = helper
						.createQuery(ALL_OWNED_ELEMENTS__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(ALL_OWNED_ELEMENTS__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<Element> result = (Collection<Element>) query.evaluate(this);
		return new BasicEList.UnmodifiableEList<Element>(result.size(),
				result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #mustBeOwned() <em>Must Be Owned</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #mustBeOwned()
	 * @generated
	 * @ordered
	 */
	protected static final String MUST_BE_OWNED__EOCL_EXP = "true";
	/**
	 * The cached OCL query for the '{@link #mustBeOwned() <em>Must Be Owned</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #mustBeOwned()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> MUST_BE_OWNED__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean mustBeOwned() {
		if (MUST_BE_OWNED__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getElement(),
					Aadl2Package.eINSTANCE.getElement().getEAllOperations()
							.get(3));
			try {
				MUST_BE_OWNED__EOCL_QRY = helper
						.createQuery(MUST_BE_OWNED__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(MUST_BE_OWNED__EOCL_QRY);
		return ((Boolean) query.evaluate(this)).booleanValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.ELEMENT__OWNED_COMMENT:
			return ((InternalEList<?>) getOwnedComments()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case Aadl2Package.ELEMENT__OWNER:
			return eInternalContainer().eInverseRemove(this,
					Aadl2Package.ELEMENT__OWNED_ELEMENT, Element.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.ELEMENT__OWNED_ELEMENT:
			return getOwnedElements();
		case Aadl2Package.ELEMENT__OWNER:
			return getOwner();
		case Aadl2Package.ELEMENT__OWNED_COMMENT:
			return getOwnedComments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.ELEMENT__OWNED_COMMENT:
			getOwnedComments().clear();
			getOwnedComments().addAll((Collection<? extends Comment>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.ELEMENT__OWNED_COMMENT:
			getOwnedComments().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.ELEMENT__OWNED_ELEMENT:
			return isSetOwnedElements();
		case Aadl2Package.ELEMENT__OWNER:
			return isSetOwner();
		case Aadl2Package.ELEMENT__OWNED_COMMENT:
			return ownedComments != null && !ownedComments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

	/**
	 * Creates a new instance of the specified Ecore class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the instance to create.
	 * @return The new instance.
	 * @generated
	 */
	protected EObject create(EClass eClass) {
		return EcoreUtil.create(eClass);
	}

	/**
	 * Retrieves the cache adapter for this '<em><b>Element</b></em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The cache adapter for this '<em><b>Element</b></em>'.
	 * @generated
	 */
	protected CacheAdapter getCacheAdapter() {
		return CacheAdapter.getCacheAdapter(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedElements() {
		return eIsSet(Aadl2Package.ELEMENT__OWNED_COMMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwner() {
		return false;
	}

	/**
	 * find the enclosing root object (aadlspec, package, propertyset, or system instance
	 * @return the root object
	 */
	public Element getElementRoot() {
		Element obj = this;
		while (obj.eContainer() != null) {
			obj = (Element) obj.eContainer();
		}
		return obj;
	}

	/**
	 * get the children of an Element
	 * This will be the content.
	 * In case of modal ComponentInstance this method is overwritten
	 * to provide mode-specific children, i.e.,
	 * the subset that is active in a given mode
	 * @return EList Element
	 */
	public EList<Element> getChildren() {
		EList<Element> list = new BasicEList<Element>();
		for (EObject eo : eContents())
			list.add((Element) eo);
		return list;
	}

	/* (non-Javadoc)
	 * @see org.osate.aadl2.Element#getContainingClassifier()
	 */
	public Classifier getContainingClassifier() {
		Element obj = this;
		while (obj != null && !(obj instanceof Classifier))
			obj = obj.getOwner();
		return (Classifier) obj;
	}

	/* (non-Javadoc)
	 * @see org.osate.aadl2.Element#getContainingComponentImpl()
	 */
	public ComponentImplementation getContainingComponentImpl() {
		Element obj = this;
		while (obj != null && !(obj instanceof ComponentImplementation)) {
			obj = (Element) obj.eContainer();
		}
		return (ComponentImplementation) obj;
	}

} //ElementImpl
