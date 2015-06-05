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
 * $Id: ClassifierImpl.java,v 1.36 2011-04-11 13:35:54 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Type;
import org.osate.aadl2.operations.ClassifierOperations;
import org.osate.aadl2.operations.TypeOperations;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getMembers <em>Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getGenerals <em>General</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getInheritedMembers <em>Inherited Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedAnnexSubclauses <em>Owned Annex Subclause</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedPrototypes <em>Owned Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#isNoPrototypes <em>No Prototypes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#isNoAnnexes <em>No Annexes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ClassifierImpl#isNoProperties <em>No Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassifierImpl extends NamespaceImpl implements Classifier {
	/**
	 * The cached value of the '{@link #getOwnedAnnexSubclauses() <em>Owned Annex Subclause</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAnnexSubclauses()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnexSubclause> ownedAnnexSubclauses;

	/**
	 * The cached value of the '{@link #getOwnedPrototypes() <em>Owned Prototype</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrototypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Prototype> ownedPrototypes;

	/**
	 * The cached value of the '{@link #getOwnedPrototypeBindings() <em>Owned Prototype Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPrototypeBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<PrototypeBinding> ownedPrototypeBindings;

	/**
	 * The default value of the '{@link #isNoPrototypes() <em>No Prototypes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoPrototypes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_PROTOTYPES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoPrototypes() <em>No Prototypes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoPrototypes()
	 * @generated
	 * @ordered
	 */
	protected boolean noPrototypes = NO_PROTOTYPES_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoAnnexes() <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoAnnexes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_ANNEXES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoAnnexes() <em>No Annexes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoAnnexes()
	 * @generated
	 * @ordered
	 */
	protected boolean noAnnexes = NO_ANNEXES_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoProperties() <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoProperties()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_PROPERTIES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoProperties() <em>No Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoProperties()
	 * @generated
	 * @ordered
	 */
	protected boolean noProperties = NO_PROPERTIES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getClassifier();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassifierFeature> getClassifierFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<ClassifierFeature> classifierFeatures = (EList<ClassifierFeature>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			if (classifierFeatures == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature(),
						classifierFeatures = new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class,
								this, Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE, null));
			}
			return classifierFeatures;
		}
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getMembersGen() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> members = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_Member());
			if (members == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_Member(),
						members = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.CLASSIFIER__MEMBER, MEMBER_ESUBSETS));
			}
			return members;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this, Aadl2Package.CLASSIFIER__MEMBER,
				MEMBER_ESUBSETS);
	}

	@Override
	public EList<NamedElement> getMembers() {
		// DB This should be an EStructuralFeature.Setting
		// BasicEList<NamedElement> results = new BasicEList<NamedElement>(
		// getMembersGen());
		final EList<NamedElement> results = new NonNotifyingEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.CLASSIFIER__MEMBER);
		results.addAll(getMembersGen());
		results.addAll(getInheritedMembers());

		return results;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getMembers() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MEMBER_ESUBSETS = new int[] { Aadl2Package.CLASSIFIER__OWNED_MEMBER,
			Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE, Aadl2Package.CLASSIFIER__INHERITED_MEMBER };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getOwnedElements() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Element> ownedElements = (EList<Element>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getElement_OwnedElement());
			if (ownedElements == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getElement_OwnedElement(),
						ownedElements = new DerivedUnionEObjectEList<Element>(Element.class, this,
								Aadl2Package.CLASSIFIER__OWNED_ELEMENT, OWNED_ELEMENT_ESUBSETS));
			}
			return ownedElements;
		}
		return new DerivedUnionEObjectEList<Element>(Element.class, this, Aadl2Package.CLASSIFIER__OWNED_ELEMENT,
				OWNED_ELEMENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedElements() <em>Owned Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_ELEMENT_ESUBSETS = new int[] { Aadl2Package.CLASSIFIER__OWNED_COMMENT,
			Aadl2Package.CLASSIFIER__OWNED_MEMBER, Aadl2Package.CLASSIFIER__GENERALIZATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> ownedMembers = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			if (ownedMembers == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_OwnedMember(),
						ownedMembers = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.CLASSIFIER__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.CLASSIFIER__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] { Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE };

	/**
	 * @author dionisio
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<NamedElement> getInheritedMembers() {
		// DONE: implemented get inherited members
		// list to track for cycles
		EList<NamedElement> cls = new BasicInternalEList<NamedElement>(NamedElement.class);
		// members to be returned
		// DB The returned list must be an EStructuralFeature.Setting
		// EList<NamedElement> tmp = new BasicInternalEList<NamedElement>(
		// NamedElement.class);
		// final EList<Classifier> list = new BasicEList<Classifier>();
		final EList<NamedElement> tmp = new NonNotifyingEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.CLASSIFIER__INHERITED_MEMBER);
		cls.add(this);
		for (Generalization g : getGeneralizations()) {
			Classifier cl = g.getGeneral();
			if (!Aadl2Util.isNull(cl) && cl != this) {
				tmp.addAll(cl.getOwnedMembers());
				// add both to look for cycles
				cls.add(cl);
				((ClassifierImpl) cl).getInheritedMembers(tmp, cls);
				cls.remove(cl);
			}
		}
		return tmp;
	}

	protected EList<NamedElement> getInheritedMembers(EList<NamedElement> tmp, EList<NamedElement> cls) {
		// DONE: implemented get inherited members
		for (Generalization g : getGeneralizations()) {
			Classifier cl = g.getGeneral();
			if (!Aadl2Util.isNull(cl) && !cls.contains(cl)) {
				tmp.addAll(cl.getOwnedMembers());
				cls.add(cl);
				((ClassifierImpl) cl).getInheritedMembers(tmp, cls);
				cls.remove(cl);
			}
		}
		return tmp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Prototype> getOwnedPrototypes() {
		if (ownedPrototypes == null) {
			ownedPrototypes = new EObjectContainmentEList<Prototype>(Prototype.class, this,
					Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE);
		}
		return ownedPrototypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Prototype createOwnedPrototype(EClass eClass) {
		Prototype newOwnedPrototype = (Prototype) create(eClass);
		getOwnedPrototypes().add(newOwnedPrototype);
		return newOwnedPrototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PrototypeBinding> getOwnedPrototypeBindings() {
		if (ownedPrototypeBindings == null) {
			ownedPrototypeBindings = new EObjectContainmentEList<PrototypeBinding>(PrototypeBinding.class, this,
					Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING);
		}
		return ownedPrototypeBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrototypeBinding createOwnedPrototypeBinding(EClass eClass) {
		PrototypeBinding newOwnedPrototypeBinding = (PrototypeBinding) create(eClass);
		getOwnedPrototypeBindings().add(newOwnedPrototypeBinding);
		return newOwnedPrototypeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Generalization> getGeneralizations() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Generalization> generalizations = (EList<Generalization>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getClassifier_Generalization());
			if (generalizations == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getClassifier_Generalization(),
						generalizations = new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
								Aadl2Package.CLASSIFIER__GENERALIZATION, null));
			}
			return generalizations;
		}
		return new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
				Aadl2Package.CLASSIFIER__GENERALIZATION, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> getGenerals() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Classifier> generals = (EList<Classifier>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getClassifier_General());
			if (generals == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getClassifier_General(),
						generals = new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
								Aadl2Package.CLASSIFIER__GENERAL, null));
			}
			return generals;
		}
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this, Aadl2Package.CLASSIFIER__GENERAL, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AnnexSubclause> getOwnedAnnexSubclauses() {
		if (ownedAnnexSubclauses == null) {
			ownedAnnexSubclauses = new EObjectContainmentEList<AnnexSubclause>(AnnexSubclause.class, this,
					Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE);
		}
		return ownedAnnexSubclauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnexSubclause createOwnedAnnexSubclause(EClass eClass) {
		AnnexSubclause newOwnedAnnexSubclause = (AnnexSubclause) create(eClass);
		getOwnedAnnexSubclauses().add(newOwnedAnnexSubclause);
		return newOwnedAnnexSubclause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public DefaultAnnexSubclause createOwnedAnnexSubclause() {
		return (DefaultAnnexSubclause)createOwnedAnnexSubclause(Aadl2Package.eINSTANCE.getDefaultAnnexSubclause());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoProperties() {
		return noProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoProperties(boolean newNoProperties) {
		boolean oldNoProperties = noProperties;
		noProperties = newNoProperties;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CLASSIFIER__NO_PROPERTIES,
					oldNoProperties, noProperties));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoPrototypes() {
		return noPrototypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoPrototypes(boolean newNoPrototypes) {
		boolean oldNoPrototypes = noPrototypes;
		noPrototypes = newNoPrototypes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CLASSIFIER__NO_PROTOTYPES,
					oldNoPrototypes, noPrototypes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoAnnexes() {
		return noAnnexes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoAnnexes(boolean newNoAnnexes) {
		boolean oldNoAnnexes = noAnnexes;
		noAnnexes = newNoAnnexes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CLASSIFIER__NO_ANNEXES, oldNoAnnexes,
					noAnnexes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean conformsTo(Type other) {
		return TypeOperations.conformsTo(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean no_cycles_in_generalization(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ClassifierOperations.no_cycles_in_generalization(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean specialize_type(DiagnosticChain diagnostics, Map<Object, Object> context) {
		return ClassifierOperations.specialize_type(this, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassifierFeature> allFeatures() {
		return ClassifierOperations.allFeatures(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> inheritedMember() {
		return ClassifierOperations.inheritedMember(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> parents() {
		return ClassifierOperations.parents(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> allParents() {
		return ClassifierOperations.allParents(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> inheritableMembers(Classifier c) {
		return ClassifierOperations.inheritableMembers(this, c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean hasVisibilityOf(NamedElement n) {
		return ClassifierOperations.hasVisibilityOf(this, n);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> inherit(EList<NamedElement> inhs) {
		return ClassifierOperations.inherit(this, inhs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean maySpecializeType(Classifier c) {
		return ClassifierOperations.maySpecializeType(this, c);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			return ((InternalEList<?>) getOwnedAnnexSubclauses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			return ((InternalEList<?>) getOwnedPrototypes()).basicRemove(otherEnd, msgs);
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			return ((InternalEList<?>) getOwnedPrototypeBindings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE:
			return getClassifierFeatures();
		case Aadl2Package.CLASSIFIER__GENERALIZATION:
			return getGeneralizations();
		case Aadl2Package.CLASSIFIER__GENERAL:
			return getGenerals();
		case Aadl2Package.CLASSIFIER__INHERITED_MEMBER:
			return getInheritedMembers();
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			return getOwnedAnnexSubclauses();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			return getOwnedPrototypes();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			return getOwnedPrototypeBindings();
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			return isNoPrototypes();
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			return isNoAnnexes();
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			return isNoProperties();
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
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			getOwnedAnnexSubclauses().clear();
			getOwnedAnnexSubclauses().addAll((Collection<? extends AnnexSubclause>) newValue);
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			getOwnedPrototypes().clear();
			getOwnedPrototypes().addAll((Collection<? extends Prototype>) newValue);
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			getOwnedPrototypeBindings().addAll((Collection<? extends PrototypeBinding>) newValue);
			return;
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			setNoPrototypes((Boolean) newValue);
			return;
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			setNoAnnexes((Boolean) newValue);
			return;
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			setNoProperties((Boolean) newValue);
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
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			getOwnedAnnexSubclauses().clear();
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			getOwnedPrototypes().clear();
			return;
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			return;
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			setNoPrototypes(NO_PROTOTYPES_EDEFAULT);
			return;
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			setNoAnnexes(NO_ANNEXES_EDEFAULT);
			return;
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			setNoProperties(NO_PROPERTIES_EDEFAULT);
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
		case Aadl2Package.CLASSIFIER__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.CLASSIFIER__MEMBER:
			return isSetMembers();
		case Aadl2Package.CLASSIFIER__GENERALIZATION:
			return isSetGeneralizations();
		case Aadl2Package.CLASSIFIER__OWNED_ELEMENT:
			return isSetOwnedElements();
		case Aadl2Package.CLASSIFIER__GENERAL:
			return isSetGenerals();
		case Aadl2Package.CLASSIFIER__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.CLASSIFIER__INHERITED_MEMBER:
			return !getInheritedMembers().isEmpty();
		case Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE:
			return ownedAnnexSubclauses != null && !ownedAnnexSubclauses.isEmpty();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE:
			return ownedPrototypes != null && !ownedPrototypes.isEmpty();
		case Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE_BINDING:
			return ownedPrototypeBindings != null && !ownedPrototypeBindings.isEmpty();
		case Aadl2Package.CLASSIFIER__NO_PROTOTYPES:
			return noPrototypes != NO_PROTOTYPES_EDEFAULT;
		case Aadl2Package.CLASSIFIER__NO_ANNEXES:
			return noAnnexes != NO_ANNEXES_EDEFAULT;
		case Aadl2Package.CLASSIFIER__NO_PROPERTIES:
			return noProperties != NO_PROPERTIES_EDEFAULT;
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
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (noPrototypes: ");
		result.append(noPrototypes);
		result.append(", noAnnexes: ");
		result.append(noAnnexes);
		result.append(", noProperties: ");
		result.append(noProperties);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetClassifierFeatures() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMembers() {
		return super.isSetMembers() || isSetClassifierFeatures() || eIsSet(Aadl2Package.CLASSIFIER__INHERITED_MEMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGeneralizations() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedElements() {
		return super.isSetOwnedElements() || isSetGeneralizations();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGenerals() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.CLASSIFIER__OWNED_ANNEX_SUBCLAUSE)
				|| eIsSet(Aadl2Package.CLASSIFIER__OWNED_PROTOTYPE);
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	@Override
	public EList<Classifier> getSelfPlusAllExtended() {
		final EList<Classifier> result = new BasicEList<Classifier>();
		Classifier current = this;
		do {
			result.add(current);
			current = current.getExtended();
		} while (current != null && current != this && !result.contains(current));
		return result;
	}

	@Override
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public boolean acceptsProperty(Property property) {
		if (super.acceptsProperty(property)) {
			return true;
		} else {
			return checkAppliesToClassifier(property);
		}
	}

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
	@Override
	public boolean checkAppliesToClassifier(Property property) {
		for (Classifier appliesToClassifier : property.getAppliesToClassifiers()) {
			if (isDescendentOf(appliesToClassifier)) {
				return true;
			}
		}
		return false;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<PropertyAssociation> getAllPropertyAssociations() {
		final EList<PropertyAssociation> result = new BasicEList<PropertyAssociation>();
		final EList<Classifier> classifiers = getSelfPlusAllExtended();
		for (final ListIterator<Classifier> i = classifiers.listIterator(classifiers.size()); i.hasPrevious();) {
			final Classifier current = i.previous();
			result.addAll(current.getOwnedPropertyAssociations());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.ComponentClassifier#lookupPrototypeBinding(org.osate.aadl2.Prototype)
	 */
	@Override
	public PrototypeBinding lookupPrototypeBinding(Prototype proto) {
		PrototypeBinding result = null;

		for (PrototypeBinding pb : getOwnedPrototypeBindings()) {
			if (pb.getFormal() == proto) {
				result = pb;
				break;
			}
		}
		if (result == null) {
			for (Classifier general : getGenerals()) {
				result = general.lookupPrototypeBinding(proto);
				if (result != null) {
					break;
				}
			}
		}
		return result;
	}

	@Override
	/**
	 * find in owned members of classifier and then in extends
	 */
	public NamedElement findNamedElement(String name) {
		Classifier cl = this;
		while (!Aadl2Util.isNull(cl)) {
			NamedElement res = Aadl2Util.findOwnedNamedElement(cl, name);
			if (res != null) {
				return res;
			}
			cl = cl.getExtended();
		}
		return null;
	}

} // ClassifierImpl
