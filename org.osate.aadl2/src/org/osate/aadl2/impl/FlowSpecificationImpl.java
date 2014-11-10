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
 * $Id: FlowSpecificationImpl.java,v 1.26 2010-05-04 18:13:32 lwrage Exp $
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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
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
 * An implementation of the model object '<em><b>Flow Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getInModeOrTransitions <em>In Mode Or Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getRefinedElement <em>Refined Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getOutEnd <em>Out End</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getInEnd <em>In End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowSpecificationImpl extends FlowFeatureImpl implements FlowSpecification {
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
	protected FlowSpecification refined;

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
	 * The cached value of the '{@link #getOutEnd() <em>Out End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutEnd()
	 * @generated
	 * @ordered
	 */
	protected FlowEnd outEnd;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFlowSpecification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	protected static final int[] IN_MODE_ESUPERSETS = new int[] { Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION };

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
	@Override
	public EList<ModeFeature> getInModeOrTransitions() {
		if (inModeOrTransitions == null) {
			inModeOrTransitions = new EObjectResolvingEList<ModeFeature>(ModeFeature.class, this,
					Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION);
		}
		return inModeOrTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FlowKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKind(FlowKind newKind) {
		FlowKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__KIND, oldKind, kind));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FlowEnd getOutEnd() {
		return outEnd;
	}

	@Override
	public FlowEnd getAllOutEnd() {
		FlowEnd res = getOutEnd();
		FlowSpecification fs = this;
		while (res == null && fs.getRefined() != null) {
			fs = fs.getRefined();
			res = fs.getOutEnd();
		}
		return res;
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
					Aadl2Package.FLOW_SPECIFICATION__OUT_END, oldOutEnd, newOutEnd);
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
	@Override
	public void setOutEnd(FlowEnd newOutEnd) {
		if (newOutEnd != outEnd) {
			NotificationChain msgs = null;
			if (outEnd != null) {
				msgs = ((InternalEObject) outEnd).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.FLOW_SPECIFICATION__OUT_END, null, msgs);
			}
			if (newOutEnd != null) {
				msgs = ((InternalEObject) newOutEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.FLOW_SPECIFICATION__OUT_END, null, msgs);
			}
			msgs = basicSetOutEnd(newOutEnd, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__OUT_END, newOutEnd,
					newOutEnd));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public FlowEnd getInEnd() {
		return inEnd;
	}

	@Override
	public FlowEnd getAllInEnd() {
		FlowEnd res = getInEnd();
		FlowSpecification fs = this;
		while (res == null && fs.getRefined() != null) {
			fs = fs.getRefined();
			res = fs.getInEnd();
		}
		return res;
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
					Aadl2Package.FLOW_SPECIFICATION__IN_END, oldInEnd, newInEnd);
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
	@Override
	public void setInEnd(FlowEnd newInEnd) {
		if (newInEnd != inEnd) {
			NotificationChain msgs = null;
			if (inEnd != null) {
				msgs = ((InternalEObject) inEnd).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.FLOW_SPECIFICATION__IN_END, null, msgs);
			}
			if (newInEnd != null) {
				msgs = ((InternalEObject) newInEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.FLOW_SPECIFICATION__IN_END, null, msgs);
			}
			msgs = basicSetInEnd(newInEnd, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__IN_END, newInEnd,
					newInEnd));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public FlowSpecification getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (FlowSpecification) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.FLOW_SPECIFICATION__REFINED,
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
	public FlowSpecification basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRefined(FlowSpecification newRefined) {
		FlowSpecification oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__REFINED, oldRefined,
					refined));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mode> getAllInModes() {
		return ModalElementOperations.getAllInModes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransition> getInModeTransitions() {
		return ModalPathOperations.getInModeTransitions(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ModeTransition> getAllInModeTransitions() {
		return ModalPathOperations.getAllInModeTransitions(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FLOW_SPECIFICATION__OUT_END:
			return basicSetOutEnd(null, msgs);
		case Aadl2Package.FLOW_SPECIFICATION__IN_END:
			return basicSetInEnd(null, msgs);
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
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE:
			return getInModes();
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION:
			return getInModeOrTransitions();
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			if (resolve) {
				return getRefined();
			}
			return basicGetRefined();
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			return getKind();
		case Aadl2Package.FLOW_SPECIFICATION__OUT_END:
			return getOutEnd();
		case Aadl2Package.FLOW_SPECIFICATION__IN_END:
			return getInEnd();
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
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			getInModeOrTransitions().addAll((Collection<? extends ModeFeature>) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			setRefined((FlowSpecification) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			setKind((FlowKind) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_END:
			setOutEnd((FlowEnd) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_END:
			setInEnd((FlowEnd) newValue);
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
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			return;
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			setRefined((FlowSpecification) null);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_END:
			setOutEnd((FlowEnd) null);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_END:
			setInEnd((FlowEnd) null);
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
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE:
			return isSetInModes();
		case Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION:
			return inModeOrTransitions != null && !inModeOrTransitions.isEmpty();
		case Aadl2Package.FLOW_SPECIFICATION__REFINED_ELEMENT:
			return isSetRefinedElement();
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			return refined != null;
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			return kind != KIND_EDEFAULT;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_END:
			return outEnd != null;
		case Aadl2Package.FLOW_SPECIFICATION__IN_END:
			return inEnd != null;
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
			case Aadl2Package.FLOW_SPECIFICATION__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION:
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
		if (baseClass == FlowElement.class) {
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
				return Aadl2Package.FLOW_SPECIFICATION__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION:
				return Aadl2Package.FLOW_SPECIFICATION__IN_MODE_OR_TRANSITION;
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
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RefinableElement getRefinedElement() {
		RefinableElement refinedElement = basicGetRefinedElement();
		return refinedElement != null && ((EObject) refinedElement).eIsProxy() ? (RefinableElement) eResolveProxy((InternalEObject) refinedElement)
				: refinedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RefinableElement basicGetRefinedElement() {
		if (eIsSet(Aadl2Package.FLOW_SPECIFICATION__REFINED)) {
			return basicGetRefined();
		}
		return super.basicGetRefinedElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRefinedElement() {
		return super.isSetRefinedElement() || eIsSet(Aadl2Package.FLOW_SPECIFICATION__REFINED);
	}

	// FIXME-LW: instantiation
	// /**
	// * get in feature of a flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Feature or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// public Feature getAllInFeature() {
	// FlowSpecification fs = this;
	// while (fs.getInFeature() == null && fs.getRefined() != null)
	// fs = fs.getRefined();
	// return fs.getInFeature();
	// }
	//
	// /**
	// * get in flow context of a flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Context or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// public Context getAllInContext() {
	// FlowSpecification fs = this;
	// while (fs.getInContext() == null && fs.getRefined() != null)
	// fs = fs.getRefined();
	// return fs.getInContext();
	// }
	//
	// /**
	// * get out feature of a flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Feature or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// public Feature getAllOutFeature() {
	// FlowSpecification fs = this;
	// while (fs.getOutFeature() == null && fs.getRefined() != null)
	// fs = fs.getRefined();
	// return fs.getOutFeature();
	// }
	//
	// /**
	// * get out flow context of flow source, sink, or path spec.
	// * In case of a refined flowspec get it from the flowspec being refined
	// * @return Context or null
	// */
	// // XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	// public Context getAllOutContext() {
	// FlowSpecification fs = this;
	// while (fs.getOutContext() == null && fs.getRefined() != null)
	// fs = fs.getRefined();
	// return fs.getOutContext();
	// }

	@Override
	public final void getPropertyValueInternal(final Property prop, final PropertyAcc paa,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		final Classifier owner = getContainingClassifier();

		if (!fromInstanceSlaveCall && paa.addLocalContained(this, owner)) {
			return;
		}
		if (paa.addLocal(this)) {
			return;
		}

		// values from refined flow specifications
		FlowSpecification refined = getRefined();
		while (refined != null) {
			if (!fromInstanceSlaveCall && paa.addLocalContained(refined, refined.getContainingClassifier())) {
				return;
			}
			if (paa.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		// values from container
		// Ignore fromInstanceSlaveCall because the classifier is a component
		// TYPE, not an implementation.
		if (!fromInstanceSlaveCall && prop.isInherit()) {
			if (owner != null) {
				owner.getPropertyValueInternal(prop, paa, fromInstanceSlaveCall);
			} else {
				throw new InvalidModelException(this, "Flow specification is not part of a component");
			}
		}
	}
} // FlowSpecificationImpl
