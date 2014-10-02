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
 * $Id: ComponentClassifierImpl.java,v 1.19 2011-04-11 13:35:51 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Classifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getOwnedModes <em>Owned Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#getOwnedModeTransitions <em>Owned Mode Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#isDerivedModes <em>Derived Modes</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#isNoFlows <em>No Flows</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentClassifierImpl#isNoModes <em>No Modes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentClassifierImpl extends ClassifierImpl implements ComponentClassifier {
	/**
	 * The cached value of the '{@link #getOwnedModes() <em>Owned Mode</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModes()
	 * @generated
	 * @ordered
	 */
	protected EList<Mode> ownedModes;
	/**
	 * The cached value of the '{@link #getOwnedModeTransitions() <em>Owned Mode Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedModeTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransition> ownedModeTransitions;

	/**
	 * The default value of the '{@link #isDerivedModes() <em>Derived Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedModes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DERIVED_MODES_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDerivedModes() <em>Derived Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDerivedModes()
	 * @generated
	 * @ordered
	 */
	protected boolean derivedModes = DERIVED_MODES_EDEFAULT;
	/**
	 * The default value of the '{@link #isNoFlows() <em>No Flows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoFlows()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_FLOWS_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNoFlows() <em>No Flows</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoFlows()
	 * @generated
	 * @ordered
	 */
	protected boolean noFlows = NO_FLOWS_EDEFAULT;
	/**
	 * The default value of the '{@link #isNoModes() <em>No Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoModes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_MODES_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNoModes() <em>No Modes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoModes()
	 * @generated
	 * @ordered
	 */
	protected boolean noModes = NO_MODES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getComponentClassifier();
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
								this, Aadl2Package.COMPONENT_CLASSIFIER__CLASSIFIER_FEATURE,
								CLASSIFIER_FEATURE_ESUBSETS));
			}
			return classifierFeatures;
		}
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.COMPONENT_CLASSIFIER__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getClassifierFeatures() <em>Classifier Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CLASSIFIER_FEATURE_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE, Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION };

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
								Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_PROTOTYPE, Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE,
			Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mode> getOwnedModes() {
		if (ownedModes == null) {
			ownedModes = new EObjectContainmentEList<Mode>(Mode.class, this,
					Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE);
		}
		return ownedModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode createOwnedMode() {
		Mode newOwnedMode = (Mode) create(Aadl2Package.eINSTANCE.getMode());
		getOwnedModes().add(newOwnedMode);
		return newOwnedMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransition> getOwnedModeTransitions() {
		if (ownedModeTransitions == null) {
			ownedModeTransitions = new EObjectContainmentEList<ModeTransition>(ModeTransition.class, this,
					Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION);
		}
		return ownedModeTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeTransition createOwnedModeTransition() {
		ModeTransition newOwnedModeTransition = (ModeTransition) create(Aadl2Package.eINSTANCE.getModeTransition());
		getOwnedModeTransitions().add(newOwnedModeTransition);
		return newOwnedModeTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDerivedModes() {
		return derivedModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDerivedModes(boolean newDerivedModes) {
		boolean oldDerivedModes = derivedModes;
		derivedModes = newDerivedModes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES,
					oldDerivedModes, derivedModes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoFlows() {
		return noFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoFlows(boolean newNoFlows) {
		boolean oldNoFlows = noFlows;
		noFlows = newNoFlows;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS,
					oldNoFlows, noFlows));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoModes() {
		return noModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoModes(boolean newNoModes) {
		boolean oldNoModes = noModes;
		noModes = newNoModes;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES,
					oldNoModes, noModes));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			return ((InternalEList<?>) getOwnedModes()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			return ((InternalEList<?>) getOwnedModeTransitions()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			return getOwnedModes();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			return getOwnedModeTransitions();
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			return isDerivedModes();
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			return isNoFlows();
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			return isNoModes();
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
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			getOwnedModes().clear();
			getOwnedModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			getOwnedModeTransitions().clear();
			getOwnedModeTransitions().addAll((Collection<? extends ModeTransition>) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			setDerivedModes((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			setNoFlows((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			setNoModes((Boolean) newValue);
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
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			getOwnedModes().clear();
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			getOwnedModeTransitions().clear();
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			setDerivedModes(DERIVED_MODES_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			setNoFlows(NO_FLOWS_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			setNoModes(NO_MODES_EDEFAULT);
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
		case Aadl2Package.COMPONENT_CLASSIFIER__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE:
			return ownedModes != null && !ownedModes.isEmpty();
		case Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION:
			return ownedModeTransitions != null && !ownedModeTransitions.isEmpty();
		case Aadl2Package.COMPONENT_CLASSIFIER__DERIVED_MODES:
			return derivedModes != DERIVED_MODES_EDEFAULT;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_FLOWS:
			return noFlows != NO_FLOWS_EDEFAULT;
		case Aadl2Package.COMPONENT_CLASSIFIER__NO_MODES:
			return noModes != NO_MODES_EDEFAULT;
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
		result.append(" (derivedModes: ");
		result.append(derivedModes);
		result.append(", noFlows: ");
		result.append(noFlows);
		result.append(", noModes: ");
		result.append(noModes);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures() || eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE)
				|| eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE)
				|| eIsSet(Aadl2Package.COMPONENT_CLASSIFIER__OWNED_MODE_TRANSITION);
	}
} // ComponentClassifierImpl
