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
 * $Id: NamedElementImpl.java,v 1.40 2011-04-11 13:35:53 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyOwner;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2Validator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NamedElementImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NamedElementImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.NamedElementImpl#getOwnedPropertyAssociations <em>Owned Property Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedElementImpl extends ElementImpl implements NamedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwnedPropertyAssociations() <em>Owned Property Association</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPropertyAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyAssociation> ownedPropertyAssociations;

	/**
	 * Stack of property definitions that are in the process of being looked
	 * up by the current thread.  This is used to check for circular
	 * dependencies in the values of properties.  The value of this
	 * thread local is a {@link LinkedList} whose items are
	 * {@link Property} objects.
	 */
	private static ThreadLocal<LinkedList<Property>> lookupStack = new ThreadLocal<LinkedList<Property>>() {
		protected LinkedList<Property> initialValue() {
			return new LinkedList<Property>();
		}
	};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getNamedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		// DONE: implement this method to return the 'Qualified Name' attribute
		return qualifiedName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Namespace getNamespace() {
		return (Namespace) eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyAssociation> getOwnedPropertyAssociations() {
		if (ownedPropertyAssociations == null) {
			ownedPropertyAssociations = new EObjectContainmentEList<PropertyAssociation>(PropertyAssociation.class,
					this, Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION);
		}
		return ownedPropertyAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssociation createOwnedPropertyAssociation() {
		PropertyAssociation newOwnedPropertyAssociation = (PropertyAssociation) create(Aadl2Package.eINSTANCE
				.getPropertyAssociation());
		getOwnedPropertyAssociations().add(newOwnedPropertyAssociation);
		return newOwnedPropertyAssociation;
	}

	/**
	 * The cached OCL expression body for the '{@link #has_no_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has no qualified name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_no_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.name->isEmpty() or self.allNamespaces()->select(ns | ns.name->isEmpty())->notEmpty()) implies self.qualifiedName->isEmpty()";

	/**
	 * The cached OCL invariant for the '{@link #has_no_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has no qualified name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_no_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean has_no_qualified_name(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		if (!EOCL_ENV.createQuery(HAS_NO_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.NAMED_ELEMENT__HAS_NO_QUALIFIED_NAME, EcorePlugin.INSTANCE.getString(
								"_UI_GenericInvariant_diagnostic", new Object[] { "has_no_qualified_name",
										EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #has_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has qualified name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty()) "
			+ "implies "
			+ "self.qualifiedName = self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))";

	/**
	 * The cached OCL invariant for the '{@link #has_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has qualified name</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #has_qualified_name(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean has_qualified_name(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
		if (!EOCL_ENV.createQuery(HAS_QUALIFIED_NAME__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Aadl2Validator.DIAGNOSTIC_SOURCE,
						Aadl2Validator.NAMED_ELEMENT__HAS_QUALIFIED_NAME, EcorePlugin.INSTANCE.getString(
								"_UI_GenericInvariant_diagnostic", new Object[] { "has_qualified_name",
										EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #allNamespaces() <em>All Namespaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allNamespaces()
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_NAMESPACES__EOCL_EXP = "if self.namespace->isEmpty() then " + "  Sequence{}"
			+ "else" + "  self.namespace.allNamespaces()->prepend(self.namespace)" + "endif";

	/**
	 * The cached OCL query for the '{@link #allNamespaces() <em>All Namespaces</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #allNamespaces()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> ALL_NAMESPACES__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Namespace> allNamespaces() {
		if (ALL_NAMESPACES__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(), Aadl2Package.eINSTANCE
					.getNamedElement().getEAllOperations().get(6));
			try {
				ALL_NAMESPACES__EOCL_QRY = helper.createQuery(ALL_NAMESPACES__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(ALL_NAMESPACES__EOCL_QRY);
		@SuppressWarnings("unchecked")
		Collection<Namespace> result = (Collection<Namespace>) query.evaluate(this);
		return new BasicEList.UnmodifiableEList<Namespace>(result.size(), result.toArray());
	}

	/**
	 * The cached OCL expression body for the '{@link #isDistinguishableFrom(org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace) <em>Is Distinguishable From</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinguishableFrom(org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace)
	 * @generated
	 * @ordered
	 */
	protected static final String IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_EXP = "if self.oclIsKindOf(n.oclType) or n.oclIsKindOf(self.oclType) then"
			+ "  ns.getNamesOfMember(self)->intersection(ns.getNamesOfMember(n))->isEmpty()"
			+ "else"
			+ "  true"
			+ "endif";

	/**
	 * The cached OCL query for the '{@link #isDistinguishableFrom(org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace) <em>Is Distinguishable From</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistinguishableFrom(org.osate.aadl2.NamedElement, org.osate.aadl2.Namespace)
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistinguishableFrom(NamedElement n, Namespace ns) {
		if (IS_DISTINGUISHABLE_FROM__NAMED_ELEMENT_NAMESPACE__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(), Aadl2Package.eINSTANCE
					.getNamedElement().getEAllOperations().get(7));
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
		return ((Boolean) query.evaluate(this)).booleanValue();
	}

	/**
	 * The cached OCL expression body for the '{@link #separator() <em>Separator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #separator()
	 * @generated
	 * @ordered
	 */
	protected static final String SEPARATOR__EOCL_EXP = "'.'";

	/**
	 * The cached OCL query for the '{@link #separator() <em>Separator</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #separator()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> SEPARATOR__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String separator() {
		if (SEPARATOR__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(), Aadl2Package.eINSTANCE
					.getNamedElement().getEAllOperations().get(8));
			try {
				SEPARATOR__EOCL_QRY = helper.createQuery(SEPARATOR__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(SEPARATOR__EOCL_QRY);
		return (String) query.evaluate(this);
	}

	/**
	 * The cached OCL expression body for the '{@link #qualifiedName() <em>Qualified Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME__EOCL_EXP = "if self.name->notEmpty() and self.allNamespaces()->select(ns | ns.name->isEmpty())->isEmpty() then"
			+ "  self.allNamespaces()->iterate(ns: Namespace; result: String = self.name | ns.name.concat(self.separator()).concat(result))"
			+ "else " + "  '' " + "endif";

	/**
	 * The cached OCL query for the '{@link #qualifiedName() <em>Qualified Name</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #qualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> QUALIFIED_NAME__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String qualifiedName() {
		if (QUALIFIED_NAME__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(Aadl2Package.eINSTANCE.getNamedElement(), Aadl2Package.eINSTANCE
					.getNamedElement().getEAllOperations().get(9));
			try {
				QUALIFIED_NAME__EOCL_QRY = helper.createQuery(QUALIFIED_NAME__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(QUALIFIED_NAME__EOCL_QRY);
		return (String) query.evaluate(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION:
			return ((InternalEList<?>) getOwnedPropertyAssociations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case Aadl2Package.NAMED_ELEMENT__NAMESPACE:
			return eInternalContainer().eInverseRemove(this, Aadl2Package.NAMESPACE__OWNED_MEMBER, Namespace.class,
					msgs);
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
		case Aadl2Package.NAMED_ELEMENT__NAME:
			return getName();
		case Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME:
			return getQualifiedName();
		case Aadl2Package.NAMED_ELEMENT__NAMESPACE:
			return getNamespace();
		case Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION:
			return getOwnedPropertyAssociations();
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
		case Aadl2Package.NAMED_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION:
			getOwnedPropertyAssociations().clear();
			getOwnedPropertyAssociations().addAll((Collection<? extends PropertyAssociation>) newValue);
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
		case Aadl2Package.NAMED_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION:
			getOwnedPropertyAssociations().clear();
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
		case Aadl2Package.NAMED_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME:
			return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT
					.equals(getQualifiedName());
		case Aadl2Package.NAMED_ELEMENT__NAMESPACE:
			return getNamespace() != null;
		case Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION:
			return ownedPropertyAssociations != null && !ownedPropertyAssociations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	public boolean hasName() {
		String name = getName();
		return name != null && name.length() > 0;
	}

	/**
	 * Retrieves the property value of a non-modal, single-valued property. Use
	 * this method if you know the property can only have a single value and is
	 * not modal
	 * 
	 * @param property
	 * 			  Property
	 * @return PropertyValue, does not return null.
	 * @exception InvalidModelException Thrown if the property value cannot
	 * be retrieved because the model is incomplete or otherwise invalid.
	 * @throws PropertyNotPresentException 
	 * @throws PropertyIsModalException 
	 * @throws IllegalStateException 
	 * @throws IllegalArgumentException 
	 * @throws PropertyDoesNotApplyToHolderException 
	 * @throws PropertyIsListException 
	 */
	public PropertyExpression getSimplePropertyValue(Property property) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException, PropertyIsListException {
		if (!property.isList()) {
			return getNonModalPropertyValue(property);
		} else {
			throw new PropertyIsListException(this, property,
					"A simple property lookup method was called for a list property."
							+ "  This occurred when looking up Property " + property.getName() + " on NamedElement "
							+ getName() + ".");
		}
	}

	/**
	 * Retrieves the property value (single or list) of a non-modal property.  Throws an exception
	 * if its a modal value or undefined.
	 * @param property Property
	 * @return The property expression or null if the property has no value. 
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	private PropertyExpression getNonModalPropertyValue(final Property property) throws InvalidModelException,
			PropertyNotPresentException, PropertyIsModalException, IllegalStateException, IllegalArgumentException,
			PropertyDoesNotApplyToHolderException {
		PropertyAssociation pa = getPropertyValue(property).first();

		if (pa == null) {
			return property.getDefaultValue();
		} else {
			if (!pa.isModal()) {
				// should always exist because it's not modal
				return pa.getOwnedValues().get(0).getOwnedValue();
			} else {
				// If we are an InstanceObject, get the value in the current SOM
				if (this instanceof InstanceObject) {
					final SystemInstance si = ((InstanceObject) this).getSystemInstance();
					final SystemOperationMode som = si.getCurrentSystemOperationMode();

					if (som != null) {
						PropertyExpression defaultPE = null;
						// find value in SOM
						for (ModalPropertyValue mpv : pa.getOwnedValues()) {
							if (mpv.getInModes() == null || mpv.getInModes().size() == 0) {
								defaultPE = mpv.getOwnedValue();
							} else if (mpv.getInModes().contains(som)) {
								return mpv.getOwnedValue();
							}
						}
						// default
						if (defaultPE != null) {
							return defaultPE;
						}
						// use global default
						return property.getDefaultValue();
					} else {
						throw new PropertyIsModalException(this, property,
								"Cannot use simple property lookup because the instance model has not been projected into a System Operation Mode."
										+ "  This occurred when looking up Property " + property.getName()
										+ " on NamedElement " + getName() + ".");
					}
				} else {
					throw new PropertyIsModalException(this, property,
							"A non-modal property lookup method was called for a modal property."
									+ "  This occurred when looking up Property " + property.getName()
									+ " on NamedElement " + getName() + ".");
				}
			}
		}
	}

	/**
	 * Returns the property value for the property specified by property
	 * 
	 * @param property
	 * 			  The property to lookup
	 * @return AadlModalPropertyValue
	 * @exception IllegalStateException
	 * 				  Thrown if the lookup encounters a cycle of property
	 * 				  reference dependencies.
	 */
	public PropertyAcc getPropertyValue(final Property property) throws IllegalStateException, InvalidModelException,
			PropertyDoesNotApplyToHolderException, IllegalArgumentException {
		// Error if the property is not acceptable
		if (property == null) {
			throw new IllegalArgumentException("Property property cannot be null.");
		}
		if (!acceptsProperty(property)) {
			throw new PropertyDoesNotApplyToHolderException(this, property, "Property " + property.getName()
					+ " does not apply to " + getClass().getName());
		}
		// Check that we aren't already looking up this property
		final LinkedList<Property> stack = lookupStack.get();
		if (stack.contains(property)) {
			throw new IllegalStateException("Encountered circular dependency on property \"" + property.getName()
					+ "\"");
		}
		try {
			stack.addFirst(property);
			PropertyAcc pas = new PropertyAcc(property);
			getPropertyValueInternal(property, pas, false);
			return pas;
		} finally {
			stack.removeFirst();
		}
	}

	public boolean acceptsProperty(Property property) {
		for (PropertyOwner appliesTo : property.getAppliesTos()) {
			//		for (MetaclassReference metaclassReference : property.getAppliesToMetaclasses())
			if (appliesTo instanceof MetaclassReference
					&& ((MetaclassReference) appliesTo).getMetaclass().isSuperTypeOf(eClass())) {
				return true;
			}
		}
		return false;
	}

	public void getPropertyValueInternal(final Property pn, final PropertyAcc pas, final boolean fromInstanceSlaveCall)
			throws InvalidModelException {
		pas.addLocal(this);
	}

	public final PropertyAssociation setPropertyValue(final Property pd, final List<? extends PropertyExpression> pes) {
		checkPropertyAssociation(pd, pes);
		PropertyAssociation pa = Aadl2Factory.eINSTANCE.createPropertyAssociation();
		pa.setProperty(pd);
		ModalPropertyValue mpv = pa.createOwnedValue();
		ListValue lv = (ListValue) mpv.createOwnedValue(Aadl2Package.eINSTANCE.getListValue());
		lv.getOwnedListElements().addAll(pes);

		if (this instanceof InstanceObject) {
			final SystemInstance si = ((InstanceObject) this).getSystemInstance();
			final SystemOperationMode som = si.getCurrentSystemOperationMode();
			if (som == null) {
				// non-modal instance model
				removePropertyAssociations(pd);
			} else {
				mpv.getInModes().add(som);
				removePropertyAssociations(pd, Collections.singletonList(som));
			}
		} else {
			removePropertyAssociations(pd);
		}

		getOwnedPropertyAssociations().add(pa);
		return pa;
	}

	/**
	 * Check that the proposed association is legal.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public void checkPropertyAssociation(final Property pd, final Collection<? extends PropertyExpression> vals) {
		// Check that the property applies to this element
		if (!acceptsProperty(pd)) {
			throw new IllegalArgumentException("Property " + pd.getName() + " does not apply to " + getName());
		}

		final boolean isList = pd.isList();
		if (!isList) {
			if (vals.size() == 0) {
				throw new IllegalArgumentException("Cannot assign an empty list to the non-list property "
						+ pd.getName());
			} else if (vals.size() > 1) {
				throw new IllegalArgumentException("Cannot assign a list of values to the non-list property "
						+ pd.getName());
			}
		}

		final PropertyType pt = (PropertyType) pd.getType();
		if (pt == null)
			return;
		//		for (final Iterator<? extends PropertyExpression> i = vals.iterator(); i.hasNext();) {
		//			final PropertyExpression pv = i.next();
		//			final String msg = pt.containsValue(isList, pv);
		//			if (msg != PropertyType.VALUE_OKAY) {
		//				throw new IllegalArgumentException("Type mismatch: " + msg);
		//			}
		//		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final void removePropertyAssociations(final Property pd) {
		final EList<PropertyAssociation> pal = getOwnedPropertyAssociations();
		for (final Iterator<PropertyAssociation> it = pal.iterator(); it.hasNext();) {
			final PropertyAssociation pa = it.next();
			if (pa.getProperty() == pd) {
				final EList<ContainedNamedElement> appliesTo = pa.getAppliesTos();
				// ignore contained property associations
				if (appliesTo == null || appliesTo.isEmpty()) {
					it.remove();
				}
			}
		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final void removePropertyAssociations(final Property pd, final List<? extends Mode> modes) {
		final EList<PropertyAssociation> pal = getOwnedPropertyAssociations();
		for (final Iterator<PropertyAssociation> it = pal.iterator(); it.hasNext();) {
			final PropertyAssociation pa = it.next();
			if (pa.getProperty() == pd) {
				final EList<ContainedNamedElement> appliesTo = pa.getAppliesTos();
				// ignore contained property associations
				if (appliesTo == null || appliesTo.isEmpty()) {
					for (Iterator<ModalPropertyValue> mpvi = pa.getOwnedValues().iterator(); mpvi.hasNext();) {
						final ModalPropertyValue mpv = mpvi.next();
						final EList<Mode> inModes = mpv.getInModes();
						if (inModes != null && !inModes.isEmpty()) {
							// Remove the given modes from the in modes clause
							for (final Iterator<Mode> mi = inModes.iterator(); mi.hasNext();) {
								final Mode mode = mi.next();
								if (modes.contains(mode))
									mi.remove();
							}
							// Remove the whole pa if we wiped out its in modes clause
							if (inModes.isEmpty())
								mpvi.remove();
						}
					}
					if (pa.getOwnedValues().isEmpty())
						it.remove();
				}
			}
		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final PropertyAssociation setPropertyValue(final Property pd, final List<? extends PropertyExpression> pvl,
			final List<? extends Mode> modes) {
		checkPropertyAssociation(pd, pvl);
		removePropertyAssociations(pd, modes);
		final PropertyAssociation pa = Aadl2Factory.eINSTANCE.createPropertyAssociation();
		pa.setProperty(pd);
		final ModalPropertyValue mpv = pa.createOwnedValue();
		//mpv.setOwnedValue(pvl);
		mpv.getInModes().addAll(modes);
		getOwnedPropertyAssociations().add(pa);
		return pa;
	}

	/**
	 * Retrieves a non-modal property value as a list.  Use this method if you
	 * know that the property is defined as a LIST OF.  While this method can be used
	 * on scalar properties, getSimplePropertyValue should be used if you know that it is
	 * scalar.  If the property is scalar, a list of length 1 is returned.
	 * 
	 * @param property PropertyDefinition
	 * @return A list of PropertyValues.  This does not return null.
	 */
	public final List<PropertyExpression> getPropertyValueList(final Property property) throws InvalidModelException,
			IllegalArgumentException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
			PropertyDoesNotApplyToHolderException {
		PropertyExpression pe = this.getNonModalPropertyValue(property);
		if (pe instanceof ListValue) {
			return ((ListValue) pe).getOwnedListElements();
		} else {
			List<PropertyExpression> pes = new BasicEList<PropertyExpression>();

			pes.add(pe);
			return pes;
		}
	}

	public final PropertyAssociation setPropertyValue(final Property pd, final PropertyValue pv) {
		this.checkPropertyAssociation(pd, Collections.singletonList(pv));
		PropertyAssociation pa = Aadl2Factory.eINSTANCE.createPropertyAssociation();
		ModalPropertyValue mpv = Aadl2Factory.eINSTANCE.createModalPropertyValue();
		mpv.setOwnedValue(pv);
		pa.setProperty(pd);
		pa.getOwnedValues().add(mpv);

		if (this instanceof InstanceObject) {
			final SystemInstance si = ((InstanceObject) this).getSystemInstance();
			final SystemOperationMode som = si.getCurrentSystemOperationMode();
			if (som != null)
				mpv.getInModes().add(som);
			this.removePropertyAssociations(pd, Collections.singletonList(som));
		} else {
			this.removePropertyAssociations(pd);
		}

		this.getOwnedPropertyAssociations().add(pa);
		return pa;
	}

} //NamedElementImpl
