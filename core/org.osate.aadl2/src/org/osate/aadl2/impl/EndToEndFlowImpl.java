/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.operations.ModalElementOperations;
import org.osate.aadl2.operations.ModalPathOperations;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End To End Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getInModeOrTransitions <em>In Mode Or Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getRefinedElement <em>Refined Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getOwnedEndToEndFlowSegments <em>Owned End To End Flow Segment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EndToEndFlowImpl extends FlowFeatureImpl implements EndToEndFlow {

	/**
	 * The cached value of the '{@link #getInModeOrTransitions() <em>In Mode Or Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModeOrTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeFeature> inModeOrTransitions;

	/**
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefined()
	 * @generated
	 * @ordered
	 */
	protected EndToEndFlow refined;

	/**
	 * The cached value of the '{@link #getOwnedEndToEndFlowSegments() <em>Owned End To End Flow Segment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEndToEndFlowSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<EndToEndFlowSegment> ownedEndToEndFlowSegments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndToEndFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getEndToEndFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getInModes() {
		return ModalPathOperations.getInModes(this);
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getInModes() <em>In Mode</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModes()
	 * @generated
	 * @ordered
	 */
	protected static final int[] IN_MODE_ESUPERSETS = new int[] { Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInModes() {
		return !getInModes().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeFeature> getInModeOrTransitions() {
		if (inModeOrTransitions == null) {
			inModeOrTransitions = new EObjectResolvingEList<ModeFeature>(ModeFeature.class, this,
					Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION);
		}
		return inModeOrTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinableElement getRefinedElement() {
		RefinableElement refinedElement = basicGetRefinedElement();
		return refinedElement != null && ((EObject) refinedElement).eIsProxy()
				? (RefinableElement) eResolveProxy((InternalEObject) refinedElement)
				: refinedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefinableElement basicGetRefinedElement() {
		if (eIsSet(Aadl2Package.END_TO_END_FLOW__REFINED)) {
			return basicGetRefined();
		}
		return super.basicGetRefinedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefinedElement() {
		return super.isSetRefinedElement() || eIsSet(Aadl2Package.END_TO_END_FLOW__REFINED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlow getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (EndToEndFlow) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.END_TO_END_FLOW__REFINED,
							oldRefined, refined));
				}
			}
		}
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlow basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(EndToEndFlow newRefined) {
		EndToEndFlow oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.END_TO_END_FLOW__REFINED, oldRefined,
					refined));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndToEndFlowSegment> getOwnedEndToEndFlowSegments() {
		if (ownedEndToEndFlowSegments == null) {
			ownedEndToEndFlowSegments = new EObjectContainmentEList<EndToEndFlowSegment>(EndToEndFlowSegment.class,
					this, Aadl2Package.END_TO_END_FLOW__OWNED_END_TO_END_FLOW_SEGMENT);
		}
		return ownedEndToEndFlowSegments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndToEndFlowSegment createOwnedEndToEndFlowSegment() {
		EndToEndFlowSegment newOwnedEndToEndFlowSegment = (EndToEndFlowSegment) create(
				Aadl2Package.eINSTANCE.getEndToEndFlowSegment());
		getOwnedEndToEndFlowSegments().add(newOwnedEndToEndFlowSegment);
		return newOwnedEndToEndFlowSegment;
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
	public EList<ModeTransition> getInModeTransitions() {
		return ModalPathOperations.getInModeTransitions(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransition> getAllInModeTransitions() {
		return ModalPathOperations.getAllInModeTransitions(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.END_TO_END_FLOW__OWNED_END_TO_END_FLOW_SEGMENT:
			return ((InternalEList<?>) getOwnedEndToEndFlowSegments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			return getInModes();
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			return getInModeOrTransitions();
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			if (resolve) {
				return getRefined();
			}
			return basicGetRefined();
		case Aadl2Package.END_TO_END_FLOW__OWNED_END_TO_END_FLOW_SEGMENT:
			return getOwnedEndToEndFlowSegments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			getInModeOrTransitions().addAll((Collection<? extends ModeFeature>) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			setRefined((EndToEndFlow) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__OWNED_END_TO_END_FLOW_SEGMENT:
			getOwnedEndToEndFlowSegments().clear();
			getOwnedEndToEndFlowSegments().addAll((Collection<? extends EndToEndFlowSegment>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			return;
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			setRefined((EndToEndFlow) null);
			return;
		case Aadl2Package.END_TO_END_FLOW__OWNED_END_TO_END_FLOW_SEGMENT:
			getOwnedEndToEndFlowSegments().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			return isSetInModes();
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			return inModeOrTransitions != null && !inModeOrTransitions.isEmpty();
		case Aadl2Package.END_TO_END_FLOW__REFINED_ELEMENT:
			return isSetRefinedElement();
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			return refined != null;
		case Aadl2Package.END_TO_END_FLOW__OWNED_END_TO_END_FLOW_SEGMENT:
			return ownedEndToEndFlowSegments != null && !ownedEndToEndFlowSegments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.END_TO_END_FLOW__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
				return Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION;
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
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_ELEMENT__IN_MODE:
				return Aadl2Package.END_TO_END_FLOW__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION:
				return Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION;
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
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * get the EndToEndFlowElement sequence taking into account refines
	 * @return EList EndToEndFlowElement
	 */
	public EList<EndToEndFlowSegment> getAllFlowSegments() {
		EndToEndFlow fsq = this;
		while (fsq.getRefined() != null) {
			fsq = fsq.getRefined();
		}
		return fsq.getOwnedEndToEndFlowSegments();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final void getPropertyValueInternal(final Property pn, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		final ComponentImplementation partOf = (ComponentImplementation) getContainingClassifier();
		if (partOf == null) {
			throw new InvalidModelException(this, "End to End Flow is not part of a component");
		}

		// First check the container's contained property associations
		if (!fromInstanceSlaveCall && pas.addLocalContained(this, partOf)) {
			if (!all) {
				return;
			}
		}

		// Next check the flow sequence's properties subclause
		if (pas.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		// Next find the value by walking up the connection's refinement
		// sequence
		EndToEndFlow refined = getRefined();
		while (refined != null) {
			if (!fromInstanceSlaveCall && pas.addLocalContained(refined, refined.getContainingClassifier())) {
				if (!all) {
					return;
				}
			}
			if (pas.addLocal(refined)) {
				if (!all) {
					return;
				}
			}
			refined = refined.getRefined();
		}

		/*
		 * if still not set, and the property is "inherit", try the containing
		 * component implementation.
		 */
		if (!fromInstanceSlaveCall && pn.isInherit()) {
			partOf.getPropertyValueInternal(pn, pas, fromInstanceSlaveCall, all);
		}
	}

} // EndToEndFlowImpl
