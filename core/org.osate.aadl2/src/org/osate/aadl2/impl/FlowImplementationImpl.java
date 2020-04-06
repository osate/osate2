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
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getFeaturingClassifiers <em>Featuring Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getOwnedFlowSegments <em>Owned Flow Segment</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getInEnd <em>In End</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowImplementationImpl#getOutEnd <em>Out End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FlowImplementationImpl extends ModalPathImpl implements FlowImplementation {

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
	 * The cached value of the '{@link #getOwnedFlowSegments() <em>Owned Flow Segment</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFlowSegments()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowSegment> ownedFlowSegments;

	/**
	 * The cached value of the '{@link #getInEnd() <em>In End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInEnd()
	 * @generated
	 * @ordered
	 */
	protected FlowEnd inEnd;

	/**
	 * The cached value of the '{@link #getOutEnd() <em>Out End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutEnd()
	 * @generated
	 * @ordered
	 */
	protected FlowEnd outEnd;

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
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFlowImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Classifier> getFeaturingClassifiers() {
		// BasicEList<Classifier> list = new BasicEList<Classifier>();
		final EList<Classifier> list = new NonNotifyingEObjectEList<Classifier>(Classifier.class, this,
				Aadl2Package.FLOW_IMPLEMENTATION__FEATURING_CLASSIFIER);
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
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION, oldSpecification, specification));
				}
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
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION,
					oldSpecification, specification));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowSegment> getOwnedFlowSegments() {
		if (ownedFlowSegments == null) {
			ownedFlowSegments = new EObjectContainmentEList<FlowSegment>(FlowSegment.class, this,
					Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT);
		}
		return ownedFlowSegments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSegment createOwnedFlowSegment() {
		FlowSegment newOwnedFlowSegment = (FlowSegment) create(Aadl2Package.eINSTANCE.getFlowSegment());
		getOwnedFlowSegments().add(newOwnedFlowSegment);
		return newOwnedFlowSegment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd getInEnd() {
		return inEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInEnd(FlowEnd newInEnd, NotificationChain msgs) {
		FlowEnd oldInEnd = inEnd;
		inEnd = newInEnd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FLOW_IMPLEMENTATION__IN_END, oldInEnd, newInEnd);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInEnd(FlowEnd newInEnd) {
		if (newInEnd != inEnd) {
			NotificationChain msgs = null;
			if (inEnd != null) {
				msgs = ((InternalEObject) inEnd).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_IMPLEMENTATION__IN_END, null, msgs);
			}
			if (newInEnd != null) {
				msgs = ((InternalEObject) newInEnd).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_IMPLEMENTATION__IN_END, null, msgs);
			}
			msgs = basicSetInEnd(newInEnd, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_IMPLEMENTATION__IN_END, newInEnd,
					newInEnd));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd createInEnd() {
		FlowEnd newInEnd = (FlowEnd) create(Aadl2Package.eINSTANCE.getFlowEnd());
		setInEnd(newInEnd);
		return newInEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd getOutEnd() {
		return outEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutEnd(FlowEnd newOutEnd, NotificationChain msgs) {
		FlowEnd oldOutEnd = outEnd;
		outEnd = newOutEnd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FLOW_IMPLEMENTATION__OUT_END, oldOutEnd, newOutEnd);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutEnd(FlowEnd newOutEnd) {
		if (newOutEnd != outEnd) {
			NotificationChain msgs = null;
			if (outEnd != null) {
				msgs = ((InternalEObject) outEnd).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_IMPLEMENTATION__OUT_END, null, msgs);
			}
			if (newOutEnd != null) {
				msgs = ((InternalEObject) newOutEnd).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.FLOW_IMPLEMENTATION__OUT_END, null, msgs);
			}
			msgs = basicSetOutEnd(newOutEnd, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_IMPLEMENTATION__OUT_END, newOutEnd,
					newOutEnd));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowEnd createOutEnd() {
		FlowEnd newOutEnd = (FlowEnd) create(Aadl2Package.eINSTANCE.getFlowEnd());
		setOutEnd(newOutEnd);
		return newOutEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT:
			return ((InternalEList<?>) getOwnedFlowSegments()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_END:
			return basicSetInEnd(null, msgs);
		case Aadl2Package.FLOW_IMPLEMENTATION__OUT_END:
			return basicSetOutEnd(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

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
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_IMPLEMENTATION__KIND, oldKind,
					kind));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.FLOW_IMPLEMENTATION__FEATURING_CLASSIFIER:
			return getFeaturingClassifiers();
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			return getKind();
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			if (resolve) {
				return getSpecification();
			}
			return basicGetSpecification();
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT:
			return getOwnedFlowSegments();
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_END:
			return getInEnd();
		case Aadl2Package.FLOW_IMPLEMENTATION__OUT_END:
			return getOutEnd();
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
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			setKind((FlowKind) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			setSpecification((FlowSpecification) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT:
			getOwnedFlowSegments().clear();
			getOwnedFlowSegments().addAll((Collection<? extends FlowSegment>) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_END:
			setInEnd((FlowEnd) newValue);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OUT_END:
			setOutEnd((FlowEnd) newValue);
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
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			setSpecification((FlowSpecification) null);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT:
			getOwnedFlowSegments().clear();
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_END:
			setInEnd((FlowEnd) null);
			return;
		case Aadl2Package.FLOW_IMPLEMENTATION__OUT_END:
			setOutEnd((FlowEnd) null);
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
		case Aadl2Package.FLOW_IMPLEMENTATION__FEATURING_CLASSIFIER:
			return !getFeaturingClassifiers().isEmpty();
		case Aadl2Package.FLOW_IMPLEMENTATION__KIND:
			return kind != KIND_EDEFAULT;
		case Aadl2Package.FLOW_IMPLEMENTATION__SPECIFICATION:
			return specification != null;
		case Aadl2Package.FLOW_IMPLEMENTATION__OWNED_FLOW_SEGMENT:
			return ownedFlowSegments != null && !ownedFlowSegments.isEmpty();
		case Aadl2Package.FLOW_IMPLEMENTATION__IN_END:
			return inEnd != null;
		case Aadl2Package.FLOW_IMPLEMENTATION__OUT_END:
			return outEnd != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ClassifierFeature.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.FLOW_IMPLEMENTATION__FEATURING_CLASSIFIER:
				return Aadl2Package.CLASSIFIER_FEATURE__FEATURING_CLASSIFIER;
			default:
				return -1;
			}
		}
		if (baseClass == Flow.class) {
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
		if (baseClass == ClassifierFeature.class) {
			switch (baseFeatureID) {
			case Aadl2Package.CLASSIFIER_FEATURE__FEATURING_CLASSIFIER:
				return Aadl2Package.FLOW_IMPLEMENTATION__FEATURING_CLASSIFIER;
			default:
				return -1;
			}
		}
		if (baseClass == Flow.class) {
			switch (baseFeatureID) {
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
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}
} // FlowImplementationImpl
