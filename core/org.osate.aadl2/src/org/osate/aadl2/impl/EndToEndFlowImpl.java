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
 * $Id: EndToEndFlowImpl.java,v 1.27 2010-05-04 18:13:31 lwrage Exp $
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectContainmentEList;
import org.eclipse.uml2.common.util.SubsetSupersetEObjectResolvingEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.SubcomponentFlow;
import org.osate.aadl2.operations.ModalElementOperations;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End To End Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getInModeOrTransitions <em>In Mode Or Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getFlowElements <em>Flow Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.EndToEndFlowImpl#getOwnedSubcomponentFlows <em>Owned Subcomponent Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndToEndFlowImpl extends FlowImpl implements EndToEndFlow {

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
	 * The cached value of the '{@link #getInModeOrTransitions() <em>In Mode Or Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInModeOrTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeFeature> inModeOrTransitions;

	/**
	 * The cached value of the '{@link #getFlowElements() <em>Flow Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EndToEndFlowElement> flowElements;

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
	 * The cached value of the '{@link #getOwnedSubcomponentFlows() <em>Owned Subcomponent Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponentFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<SubcomponentFlow> ownedSubcomponentFlows;

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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getEndToEndFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<Mode>(Mode.class, this, Aadl2Package.END_TO_END_FLOW__IN_MODE);
		}
		return inModes;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<EndToEndFlowElement> getFlowElements() {
		if (flowElements == null) {
			flowElements = new SubsetSupersetEObjectResolvingEList<EndToEndFlowElement>(EndToEndFlowElement.class,
					this, Aadl2Package.END_TO_END_FLOW__FLOW_ELEMENT, null, FLOW_ELEMENT_ESUBSETS) {
				private static final long serialVersionUID = 1L;

				/* (non-Javadoc)
				 * @see org.eclipse.emf.ecore.util.EObjectEList#isUnique()
				 */
				@Override
				protected boolean isUnique() {
					return false;
				}
			};
		}
		return flowElements;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getFlowElements() <em>Flow Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowElements()
	 * @generated
	 * @ordered
	 */
	protected static final int[] FLOW_ELEMENT_ESUBSETS = new int[] { Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW };

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
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.END_TO_END_FLOW__REFINED,
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.END_TO_END_FLOW__REFINED, oldRefined,
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
	public EList<SubcomponentFlow> getOwnedSubcomponentFlows() {
		if (ownedSubcomponentFlows == null) {
			ownedSubcomponentFlows = new SubsetSupersetEObjectContainmentEList<SubcomponentFlow>(
					SubcomponentFlow.class, this, Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW,
					OWNED_SUBCOMPONENT_FLOW_ESUPERSETS, null);
		}
		return ownedSubcomponentFlows;
	}

	/**
	 * The array of superset feature identifiers for the '{@link #getOwnedSubcomponentFlows() <em>Owned Subcomponent Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponentFlows()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_SUBCOMPONENT_FLOW_ESUPERSETS = new int[] { Aadl2Package.END_TO_END_FLOW__FLOW_ELEMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubcomponentFlow createOwnedSubcomponentFlow() {
		SubcomponentFlow newOwnedSubcomponentFlow = (SubcomponentFlow) create(Aadl2Package.eINSTANCE
				.getSubcomponentFlow());
		getOwnedSubcomponentFlows().add(newOwnedSubcomponentFlow);
		return newOwnedSubcomponentFlow;
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
		case Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW:
			return ((InternalEList<?>) getOwnedSubcomponentFlows()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			return getInModes();
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			return getInModeOrTransitions();
		case Aadl2Package.END_TO_END_FLOW__FLOW_ELEMENT:
			return getFlowElements();
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			if (resolve)
				return getRefined();
			return basicGetRefined();
		case Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW:
			return getOwnedSubcomponentFlows();
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
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			getInModeOrTransitions().addAll((Collection<? extends ModeFeature>) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__FLOW_ELEMENT:
			getFlowElements().clear();
			getFlowElements().addAll((Collection<? extends EndToEndFlowElement>) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			setRefined((EndToEndFlow) newValue);
			return;
		case Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW:
			getOwnedSubcomponentFlows().clear();
			getOwnedSubcomponentFlows().addAll((Collection<? extends SubcomponentFlow>) newValue);
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
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			return;
		case Aadl2Package.END_TO_END_FLOW__FLOW_ELEMENT:
			getFlowElements().clear();
			return;
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			setRefined((EndToEndFlow) null);
			return;
		case Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW:
			getOwnedSubcomponentFlows().clear();
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
		case Aadl2Package.END_TO_END_FLOW__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case Aadl2Package.END_TO_END_FLOW__IN_MODE_OR_TRANSITION:
			return inModeOrTransitions != null && !inModeOrTransitions.isEmpty();
		case Aadl2Package.END_TO_END_FLOW__FLOW_ELEMENT:
			return flowElements != null && !flowElements.isEmpty();
		case Aadl2Package.END_TO_END_FLOW__REFINED:
			return isSetRefined();
		case Aadl2Package.END_TO_END_FLOW__OWNED_SUBCOMPONENT_FLOW:
			return ownedSubcomponentFlows != null && !ownedSubcomponentFlows.isEmpty();
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
	@Override
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
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public EList<EndToEndFlowElement> getAllFlowElements() {
		EndToEndFlow fsq = this;
		while (fsq.getRefined() != null)
			fsq = fsq.getRefined();
		return fsq.getFlowElements();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final void getPropertyValueInternal(final Property pn, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		final ComponentImplementation partOf = (ComponentImplementation) getContainingClassifier();
		if (partOf == null) {
			throw new InvalidModelException(this, "End to End Flow is not part of a component");
		}

		// First check the container's contained property associations
		if (!fromInstanceSlaveCall && pas.addLocalContained(this, partOf)) {
			return;
		}

		// Next check the flow sequence's properties subclause
		if (pas.addLocal(this)) {
			return;
		}

		// Next find the value by walking up the connection's refinement
		// sequence
		EndToEndFlow refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		/*
		 * if still not set, and the property is "inherit", try the containing
		 * component implementation.
		 */
		if (!fromInstanceSlaveCall && pn.isInherit()) {
			partOf.getPropertyValueInternal(pn, pas, fromInstanceSlaveCall);
		}
	}

} //EndToEndFlowImpl
