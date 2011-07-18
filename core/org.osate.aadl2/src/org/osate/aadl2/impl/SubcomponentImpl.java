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
 * $Id: SubcomponentImpl.java,v 1.50 2010-05-04 18:13:31 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractSubcomponentType;
import org.osate.aadl2.ArraySpecification;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.Property;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.operations.ModalElementOperations;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subcomponent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getArraySpecification <em>Array Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getSubcomponentType <em>Subcomponent Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getOwnedPrototypeBindings <em>Owned Prototype Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getPrototype <em>Prototype</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getModeBindings <em>Mode Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#isAllModes <em>All Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getImplementationReferences <em>Implementation Reference</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentImpl#getAbstractSubcomponentType <em>Abstract Subcomponent Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SubcomponentImpl extends StructuralFeatureImpl implements Subcomponent {
	/**
	 * The cached value of the '{@link #getInModes() <em>In Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModes()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> inModes;

	/**
	 * The cached value of the '{@link #getArraySpecification() <em>Array Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArraySpecification()
	 * @generated
	 * @ordered
	 */
	protected ArraySpecification arraySpecification;

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
	 * The cached value of the '{@link #getModeBindings() <em>Mode Binding</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModeBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeBinding> modeBindings;

	/**
	 * The default value of the '{@link #isAllModes() <em>All Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllModes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALL_MODES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAllModes() <em>All Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllModes()
	 * @generated
	 * @ordered
	 */
	protected boolean allModes = ALL_MODES_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplementationReferences() <em>Implementation Reference</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentImplementationReference> implementationReferences;

	/**
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefined()
	 * @generated
	 * @ordered
	 */
	protected Subcomponent refined;

	/**
	 * The cached value of the '{@link #getAbstractSubcomponentType() <em>Abstract Subcomponent Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractSubcomponentType()
	 * @generated
	 * @ordered
	 */
	protected AbstractSubcomponentType abstractSubcomponentType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubcomponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubcomponent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<Mode>(Mode.class, this, Aadl2Package.SUBCOMPONENT__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArraySpecification getArraySpecification() {
		return arraySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArraySpecification(ArraySpecification newArraySpecification, NotificationChain msgs) {
		ArraySpecification oldArraySpecification = arraySpecification;
		arraySpecification = newArraySpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION, oldArraySpecification, newArraySpecification);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArraySpecification(ArraySpecification newArraySpecification) {
		if (newArraySpecification != arraySpecification) {
			NotificationChain msgs = null;
			if (arraySpecification != null)
				msgs = ((InternalEObject) arraySpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION, null, msgs);
			if (newArraySpecification != null)
				msgs = ((InternalEObject) newArraySpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION, null, msgs);
			msgs = basicSetArraySpecification(newArraySpecification, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION,
					newArraySpecification, newArraySpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArraySpecification createArraySpecification() {
		ArraySpecification newArraySpecification = (ArraySpecification) create(Aadl2Package.eINSTANCE
				.getArraySpecification());
		setArraySpecification(newArraySpecification);
		return newArraySpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentType getSubcomponentType() {
		SubcomponentType subcomponentType = basicGetSubcomponentType();
		return subcomponentType != null && ((EObject) subcomponentType).eIsProxy() ? (SubcomponentType) eResolveProxy((InternalEObject) subcomponentType)
				: subcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SubcomponentType basicGetSubcomponentType() {
//		ComponentPrototype prototype = basicGetPrototype();
//		if (prototype != null) {
//			return prototype;
//		}
//		ComponentClassifier classifier = basicGetClassifier();
//		if (classifier != null) {
//			return classifier;
//		}
		if (eIsSet(Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE)) {
			return basicGetAbstractSubcomponentType();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentClassifier getClassifier() {
		ComponentClassifier classifier = basicGetClassifier();
		return classifier != null && ((EObject) classifier).eIsProxy() ? (ComponentClassifier) eResolveProxy((InternalEObject) classifier)
				: classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentClassifier basicGetClassifier() {
		// DONE: implement this method to return the 'Classifier' reference
		SubcomponentType st = getSubcomponentType();

		return st instanceof ComponentClassifier ? (ComponentClassifier) st : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSubcomponentType getAbstractSubcomponentType() {
		if (abstractSubcomponentType != null && ((EObject) abstractSubcomponentType).eIsProxy()) {
			InternalEObject oldAbstractSubcomponentType = (InternalEObject) abstractSubcomponentType;
			abstractSubcomponentType = (AbstractSubcomponentType) eResolveProxy(oldAbstractSubcomponentType);
			if (abstractSubcomponentType != oldAbstractSubcomponentType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE, oldAbstractSubcomponentType,
							abstractSubcomponentType));
			}
		}
		return abstractSubcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSubcomponentType basicGetAbstractSubcomponentType() {
		return abstractSubcomponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractSubcomponentType(AbstractSubcomponentType newAbstractSubcomponentType) {
		AbstractSubcomponentType oldAbstractSubcomponentType = abstractSubcomponentType;
		abstractSubcomponentType = newAbstractSubcomponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE, oldAbstractSubcomponentType,
					abstractSubcomponentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrototypeBinding> getOwnedPrototypeBindings() {
		if (ownedPrototypeBindings == null) {
			ownedPrototypeBindings = new EObjectContainmentEList<PrototypeBinding>(PrototypeBinding.class, this,
					Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING);
		}
		return ownedPrototypeBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public ComponentPrototype getPrototype() {
		ComponentPrototype prototype = basicGetPrototype();
		return prototype != null && ((EObject) prototype).eIsProxy() ? (ComponentPrototype) eResolveProxy((InternalEObject) prototype)
				: prototype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComponentPrototype basicGetPrototype() {
		// DONE: implement this method to return the 'Prototype' reference
		// phf: changed it to get from basic to have the proxy resolved.
		SubcomponentType st = getSubcomponentType();

		return st instanceof ComponentPrototype ? (ComponentPrototype) st : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeBinding> getModeBindings() {
		if (modeBindings == null) {
			modeBindings = new EObjectContainmentEList<ModeBinding>(ModeBinding.class, this,
					Aadl2Package.SUBCOMPONENT__MODE_BINDING);
		}
		return modeBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeBinding createModeBinding() {
		ModeBinding newModeBinding = (ModeBinding) create(Aadl2Package.eINSTANCE.getModeBinding());
		getModeBindings().add(newModeBinding);
		return newModeBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllModes() {
		return allModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllModes(boolean newAllModes) {
		boolean oldAllModes = allModes;
		allModes = newAllModes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT__ALL_MODES, oldAllModes,
					allModes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentImplementationReference> getImplementationReferences() {
		if (implementationReferences == null) {
			implementationReferences = new EObjectContainmentEList<ComponentImplementationReference>(
					ComponentImplementationReference.class, this, Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE);
		}
		return implementationReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentImplementationReference createImplementationReference() {
		ComponentImplementationReference newImplementationReference = (ComponentImplementationReference) create(Aadl2Package.eINSTANCE
				.getComponentImplementationReference());
		getImplementationReferences().add(newImplementationReference);
		return newImplementationReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (Subcomponent) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.SUBCOMPONENT__REFINED,
							oldRefined, refined));
			}
		}
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(Subcomponent newRefined) {
		Subcomponent oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT__REFINED, oldRefined,
					refined));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefined() {
		return refined != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getAllInModes() {
		return ModalElementOperations.getAllInModes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION:
			return basicSetArraySpecification(null, msgs);
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			return ((InternalEList<?>) getOwnedPrototypeBindings()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBCOMPONENT__MODE_BINDING:
			return ((InternalEList<?>) getModeBindings()).basicRemove(otherEnd, msgs);
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			return ((InternalEList<?>) getImplementationReferences()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			return getInModes();
		case Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION:
			return getArraySpecification();
		case Aadl2Package.SUBCOMPONENT__SUBCOMPONENT_TYPE:
			if (resolve)
				return getSubcomponentType();
			return basicGetSubcomponentType();
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			return getOwnedPrototypeBindings();
		case Aadl2Package.SUBCOMPONENT__PROTOTYPE:
			if (resolve)
				return getPrototype();
			return basicGetPrototype();
		case Aadl2Package.SUBCOMPONENT__MODE_BINDING:
			return getModeBindings();
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			return isAllModes();
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			return getImplementationReferences();
		case Aadl2Package.SUBCOMPONENT__REFINED:
			if (resolve)
				return getRefined();
			return basicGetRefined();
		case Aadl2Package.SUBCOMPONENT__CLASSIFIER:
			if (resolve)
				return getClassifier();
			return basicGetClassifier();
		case Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE:
			if (resolve)
				return getAbstractSubcomponentType();
			return basicGetAbstractSubcomponentType();
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION:
			setArraySpecification((ArraySpecification) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			getOwnedPrototypeBindings().addAll((Collection<? extends PrototypeBinding>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__MODE_BINDING:
			getModeBindings().clear();
			getModeBindings().addAll((Collection<? extends ModeBinding>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			setAllModes((Boolean) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			getImplementationReferences().clear();
			getImplementationReferences().addAll((Collection<? extends ComponentImplementationReference>) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__REFINED:
			setRefined((Subcomponent) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE:
			setAbstractSubcomponentType((AbstractSubcomponentType) newValue);
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION:
			setArraySpecification((ArraySpecification) null);
			return;
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			getOwnedPrototypeBindings().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__MODE_BINDING:
			getModeBindings().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			setAllModes(ALL_MODES_EDEFAULT);
			return;
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			getImplementationReferences().clear();
			return;
		case Aadl2Package.SUBCOMPONENT__REFINED:
			setRefined((Subcomponent) null);
			return;
		case Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE:
			setAbstractSubcomponentType((AbstractSubcomponentType) null);
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
		case Aadl2Package.SUBCOMPONENT__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION:
			return arraySpecification != null;
		case Aadl2Package.SUBCOMPONENT__SUBCOMPONENT_TYPE:
			return isSetSubcomponentType();
		case Aadl2Package.SUBCOMPONENT__OWNED_PROTOTYPE_BINDING:
			return ownedPrototypeBindings != null && !ownedPrototypeBindings.isEmpty();
		case Aadl2Package.SUBCOMPONENT__PROTOTYPE:
			return basicGetPrototype() != null;
		case Aadl2Package.SUBCOMPONENT__MODE_BINDING:
			return modeBindings != null && !modeBindings.isEmpty();
		case Aadl2Package.SUBCOMPONENT__ALL_MODES:
			return allModes != ALL_MODES_EDEFAULT;
		case Aadl2Package.SUBCOMPONENT__IMPLEMENTATION_REFERENCE:
			return implementationReferences != null && !implementationReferences.isEmpty();
		case Aadl2Package.SUBCOMPONENT__REFINED:
			return isSetRefined();
		case Aadl2Package.SUBCOMPONENT__CLASSIFIER:
			return basicGetClassifier() != null;
		case Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE:
			return abstractSubcomponentType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.SUBCOMPONENT__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == Context.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == EndToEndFlowElement.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == FlowElement.class) {
			switch (derivedFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ArrayableElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION:
				return Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_SPECIFICATION;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_ELEMENT__IN_MODE:
				return Aadl2Package.SUBCOMPONENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == Context.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == EndToEndFlowElement.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == FlowElement.class) {
			switch (baseFeatureID) {
			default:
				return -1;
			}
		}
		if (baseClass == ArrayableElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.ARRAYABLE_ELEMENT__ARRAY_SPECIFICATION:
				return Aadl2Package.SUBCOMPONENT__ARRAY_SPECIFICATION;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (allModes: ");
		result.append(allModes);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSubcomponentType() {
		return eIsSet(Aadl2Package.SUBCOMPONENT__PROTOTYPE) || eIsSet(Aadl2Package.SUBCOMPONENT__CLASSIFIER)
				|| eIsSet(Aadl2Package.SUBCOMPONENT__ABSTRACT_SUBCOMPONENT_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RefinableElement getRefinedElement() {
		return getRefined();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RefinableElement basicGetRefinedElement() {
		return basicGetRefined();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefinedElement() {
		return false;
	}

	/**
	 * returns the component implementation object of a given subcomponent
	 * @return Component implementation
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	public ComponentImplementation getComponentImplementation() {
		ComponentClassifier cc = getClassifier();
		if (cc == null)
			return null;
		if (cc instanceof ComponentImplementation)
			return (ComponentImplementation) cc;
		return null;
	}

	/**
	 * returns the component type object of a given subcomponent
	 * @return Component type
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public ComponentType getComponentType() {
		ComponentClassifier cc = getClassifier();
		if (cc == null)
			return null;
		if (cc instanceof ComponentImplementation)
			return ((ComponentImplementation) cc).getType();
		if (cc instanceof ComponentType)
			return (ComponentType) cc;
		return null;
	}

	/**
	 * Return the subcomponent and any of the subcomponents it refines
	 * @return EList of subcomponent
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	public EList<Subcomponent> getAllSubcomponentRefinements() {
		BasicEList<Subcomponent> returnlist = new BasicEList<Subcomponent>();
		Subcomponent more = this;
		while (more != null) {
			returnlist.add(more);
			more = more.getRefined();
		}
		return returnlist;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public ComponentClassifier getAllClassifier() {
		ComponentClassifier cc = getClassifier();
		Subcomponent sub = this;
		while (cc == null && sub.getRefined() != null) {
			sub = sub.getRefined();
			cc = sub.getClassifier();
		}
		return cc;
	}

	@Override
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public boolean acceptsProperty(Property property) {
		if (super.acceptsProperty(property))
			return true;
		else if (getClassifier() != null)
			return getClassifier().checkAppliesToClassifier(property);
		else
			return false;
	}

	public final void getPropertyValueInternal(final Property prop, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		final ComponentImplementation owner = (ComponentImplementation) getContainingClassifier();

		// local contained value
		if (!fromInstanceSlaveCall) {
			pas.addLocalContained(this, owner);
		}

		// get local value
		pas.addLocal(this);

		// collect values from refined subcomponents
		Subcomponent refined = getRefined();
		while (refined != null) {
			pas.addLocal(refined);
			refined = refined.getRefined();
		}

		// get values from classifier
		final ComponentClassifier cc = getClassifier();
		if (cc != null) {
			cc.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
		}

		// get values from container
		if (!fromInstanceSlaveCall && prop.isInherit()) {
			owner.getPropertyValueInternal(prop, pas, fromInstanceSlaveCall);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osate.aadl2.Subcomponent#getPrototypeActual(org.osate.aadl2.Prototype
	 * )
	 */
	public PrototypeBinding lookupPrototypeBinding(Prototype proto) {
		for (PrototypeBinding pb : getOwnedPrototypeBindings()) {
			if (pb.getFormal() == proto) {
				return pb;
			}
		}
		return null;
	}


	public void getPropertyValueTest(Property prop, PropertyAcc pas, Classifier cl) {
		final ComponentImplementation owner = (ComponentImplementation) getContainingClassifier();

		if (pas.addLocalContained(this, owner)) {
			return;
		}

		// get local value
		if (pas.addLocal(this)) {
			return;
		}

		// collect values from refined subcomponents
		Subcomponent refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		// get values from classifier
		final ComponentClassifier cc = getClassifier();
		if (cc != null) {
			cc.getPropertyValueInternal(prop, pas, true);
		} else if (cl != null) {
			cl.getPropertyValueInternal(prop, pas, true);
		}
	}

	/**
	 * Get list of all features of a subcomponent, including ancestor features
	 * These are the features of its classifier
	 * In case of refined features the refined feature is returned in the list.
	 * @return List of features
	 */
	public EList<Feature> getAllFeatures() {
		ComponentImplementation ci = getComponentImplementation();
		if (ci != null)
			return ci.getAllFeatures();
		ComponentType ct = getComponentType();
		if (ct != null)
			return ct.getAllFeatures();
		return ECollections.emptyEList();
	}

	/*
	 * getName needs to get it from the refined pointer if it was refined
	 * (non-Javadoc)
	 * 
	 * @see org.osate.aadl2.impl.NamedElementImpl#getName()
	 */
	@Override
	public String getName() {
		if (name != null)
			return name;
		return getRefined().getName();
	}

} //SubcomponentImpl
