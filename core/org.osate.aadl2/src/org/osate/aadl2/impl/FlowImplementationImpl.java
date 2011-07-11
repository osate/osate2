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
 * $Id: FlowImplementationImpl.java,v 1.21 2009-08-27 13:45:13 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.SubcomponentFlow;
import org.osate.aadl2.operations.ModalElementOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getInModeOrTransitions <em>In Mode Or Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getFlowElements <em>Flow Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getOwnedSubcomponentFlows <em>Owned Subcomponent Flow</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowImplementationImpl extends StructuralFeatureImpl implements FlowImplementation {

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
	protected EList<FlowElement> flowElements;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final FlowKind KIND_EDEFAULT = FlowKind.SOURCE;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected FlowKind kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecification() <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecification()
	 * @generated
	 * @ordered
	 */
	protected FlowSpecification specification;

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
	protected FlowImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFlowImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<Mode>(Mode.class, this, Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE);
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
					Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION);
		}
		return inModeOrTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Classifier> getFeaturingClassifiers() {
		BasicEList<Classifier> list = new BasicEList<Classifier>();
		list.add(getContainingClassifier());
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification getSpecification() {
		if (specification != null && ((EObject) specification).eIsProxy()) {
			InternalEObject oldSpecification = (InternalEObject) specification;
			specification = (FlowSpecification) eResolveProxy(oldSpecification);
			if (specification != oldSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION, oldSpecification, specification));
			}
		}
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification basicGetSpecification() {
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecification(FlowSpecification newSpecification) {
		FlowSpecification oldSpecification = specification;
		specification = newSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION,
					oldSpecification, specification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubcomponentFlow> getOwnedSubcomponentFlows() {
		if (ownedSubcomponentFlows == null) {
			ownedSubcomponentFlows = new SubsetSupersetEObjectContainmentEList<SubcomponentFlow>(
					SubcomponentFlow.class, this, Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW,
					OWNED_SUBCOMPONENT_FLOW_ESUPERSETS, null);
		}
		return ownedSubcomponentFlows;
	}

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
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW:
			return ((InternalEList<?>) getOwnedSubcomponentFlows()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FlowElement> getFlowElements() {
		if (flowElements == null) {
			flowElements = new SubsetSupersetEObjectResolvingEList<FlowElement>(FlowElement.class, this,
					Aadl2Package.FLOW_IMPLEMENTATION__FLOW_ELEMENT, null, FLOW_ELEMENT_ESUBSETS) {
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
	protected static final int[] FLOW_ELEMENT_ESUBSETS = new int[] { Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW };

	/**
	 * The array of superset feature identifiers for the '{@link #getOwnedSubcomponentFlows() <em>Owned Subcomponent Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponentFlows()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_SUBCOMPONENT_FLOW_ESUPERSETS = new int[] { Aadl2Package.FLOW_IMPLEMENTATION__FLOW_ELEMENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(FlowKind newKind) {
		FlowKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_IMPLEMENTATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE:
			return getInModes();
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION:
			return getInModeOrTransitions();
		case Aadl2Package.FLOW_IMPLEMENTATION__FLOW_ELEMENT:
			return getFlowElements();
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			return getKind();
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			if (resolve)
				return getSpecification();
			return basicGetSpecification();
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW:
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
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			getInModeOrTransitions().addAll((Collection<? extends ModeFeature>) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__FLOW_ELEMENT:
			getFlowElements().clear();
			getFlowElements().addAll((Collection<? extends FlowElement>) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			setKind((FlowKind) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			setSpecification((FlowSpecification) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW:
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
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__FLOW_ELEMENT:
			getFlowElements().clear();
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			setSpecification((FlowSpecification) null);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW:
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
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION:
			return inModeOrTransitions != null && !inModeOrTransitions.isEmpty();
		case Aadl2Package.FLOW_IMPLEMENTATION__FLOW_ELEMENT:
			return flowElements != null && !flowElements.isEmpty();
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			return kind != KIND_EDEFAULT;
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			return specification != null;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_SUBCOMPONENT_FLOW:
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
			case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION:
				return Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION;
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
				return Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION:
				return Aadl2Package.FLOW_IMPLEMENTATION__IN_MODE_OR_TRANSITION;
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}
} //FlowImplementationImpl
