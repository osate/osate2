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
 * $Id: BehavioredImplementationImpl.java,v 1.11 2011-04-11 13:35:52 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.operations.BehavioredImplementationOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behaviored Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getMembers <em>Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getSubprogramCalls <em>Subprogram Call</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.BehavioredImplementationImpl#getOwnedSubprogramCallSequences <em>Owned Subprogram Call Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BehavioredImplementationImpl extends ComponentImplementationImpl implements
		BehavioredImplementation {
	/**
	 * The cached value of the '{@link #getOwnedSubprogramCallSequences() <em>Owned Subprogram Call Sequence</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramCallSequences()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramCallSequence> ownedSubprogramCallSequences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BehavioredImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getBehavioredImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getMembers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> members = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_Member());
			if (members == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_Member(),
						members = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.BEHAVIORED_IMPLEMENTATION__MEMBER, MEMBER_ESUBSETS));
			}
			return members;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.BEHAVIORED_IMPLEMENTATION__MEMBER, MEMBER_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getMembers() <em>Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] MEMBER_ESUBSETS = new int[] { Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__INHERITED_MEMBER,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL };

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
								this, Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE,
								CLASSIFIER_FEATURE_ESUBSETS));
			}
			return classifierFeatures;
		}
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
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
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE_TRANSITION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBCOMPONENT,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_CONNECTION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_END_TO_END_FLOW,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_INTERNAL_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE };

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
								Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
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
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_PROTOTYPE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MODE_TRANSITION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBCOMPONENT,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_CONNECTION,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_END_TO_END_FLOW,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_INTERNAL_FEATURE,
			Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public EList<SubprogramCall> getSubprogramCalls() {
		// TODO: implement this method to return the 'Subprogram Call' reference list
		return BehavioredImplementationOperations.subprogramCalls(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramCallSequence> getOwnedSubprogramCallSequences() {
		if (ownedSubprogramCallSequences == null) {
			ownedSubprogramCallSequences = new EObjectContainmentEList<SubprogramCallSequence>(
					SubprogramCallSequence.class, this,
					Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE);
		}
		return ownedSubprogramCallSequences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramCallSequence createOwnedSubprogramCallSequence() {
		SubprogramCallSequence newOwnedSubprogramCallSequence = (SubprogramCallSequence) create(Aadl2Package.eINSTANCE
				.getSubprogramCallSequence());
		getOwnedSubprogramCallSequences().add(newOwnedSubprogramCallSequence);
		return newOwnedSubprogramCallSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramCall> subprogramCalls() {
		return BehavioredImplementationOperations.subprogramCalls(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			return ((InternalEList<?>) getOwnedSubprogramCallSequences()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			return getSubprogramCalls();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			return getOwnedSubprogramCallSequences();
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			getSubprogramCalls().clear();
			getSubprogramCalls().addAll((Collection<? extends SubprogramCall>) newValue);
			return;
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			getOwnedSubprogramCallSequences().clear();
			getOwnedSubprogramCallSequences().addAll((Collection<? extends SubprogramCallSequence>) newValue);
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			getSubprogramCalls().clear();
			return;
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			getOwnedSubprogramCallSequences().clear();
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
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__MEMBER:
			return isSetMembers();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL:
			return !getSubprogramCalls().isEmpty();
		case Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE:
			return ownedSubprogramCallSequences != null && !ownedSubprogramCallSequences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetMembers() {
		return super.isSetMembers() || eIsSet(Aadl2Package.BEHAVIORED_IMPLEMENTATION__SUBPROGRAM_CALL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures()
				|| eIsSet(Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers()
				|| eIsSet(Aadl2Package.BEHAVIORED_IMPLEMENTATION__OWNED_SUBPROGRAM_CALL_SEQUENCE);
	}

} // BehavioredImplementationImpl
