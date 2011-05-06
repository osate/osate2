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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Context;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
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
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getRefined <em>Refined</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getInFeature <em>In Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getInContext <em>In Context</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getOutFeature <em>Out Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FlowSpecificationImpl#getOutContext <em>Out Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlowSpecificationImpl extends FlowImpl implements FlowSpecification {
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
	 * The cached value of the '{@link #getInFeature() <em>In Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature inFeature;

	/**
	 * The cached value of the '{@link #getInContext() <em>In Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInContext()
	 * @generated
	 * @ordered
	 */
	protected Context inContext;

	/**
	 * The cached value of the '{@link #getOutFeature() <em>Out Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature outFeature;

	/**
	 * The cached value of the '{@link #getOutContext() <em>Out Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutContext()
	 * @generated
	 * @ordered
	 */
	protected Context outContext;

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
	public EList<Mode> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<Mode>(Mode.class, this, Aadl2Package.FLOW_SPECIFICATION__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getInFeature() {
		if (inFeature != null && ((EObject) inFeature).eIsProxy()) {
			InternalEObject oldInFeature = (InternalEObject) inFeature;
			inFeature = (Feature) eResolveProxy(oldInFeature);
			if (inFeature != oldInFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FLOW_SPECIFICATION__IN_FEATURE, oldInFeature, inFeature));
			}
		}
		return inFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetInFeature() {
		return inFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInFeature(Feature newInFeature) {
		Feature oldInFeature = inFeature;
		inFeature = newInFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__IN_FEATURE,
					oldInFeature, inFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getOutFeature() {
		if (outFeature != null && ((EObject) outFeature).eIsProxy()) {
			InternalEObject oldOutFeature = (InternalEObject) outFeature;
			outFeature = (Feature) eResolveProxy(oldOutFeature);
			if (outFeature != oldOutFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FLOW_SPECIFICATION__OUT_FEATURE, oldOutFeature, outFeature));
			}
		}
		return outFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetOutFeature() {
		return outFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutFeature(Feature newOutFeature) {
		Feature oldOutFeature = outFeature;
		outFeature = newOutFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__OUT_FEATURE,
					oldOutFeature, outFeature));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (FlowSpecification) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.FLOW_SPECIFICATION__REFINED,
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
	public FlowSpecification basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(FlowSpecification newRefined) {
		FlowSpecification oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__REFINED, oldRefined,
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
	public Context getInContext() {
		if (inContext != null && ((EObject) inContext).eIsProxy()) {
			InternalEObject oldInContext = (InternalEObject) inContext;
			inContext = (Context) eResolveProxy(oldInContext);
			if (inContext != oldInContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FLOW_SPECIFICATION__IN_CONTEXT, oldInContext, inContext));
			}
		}
		return inContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetInContext() {
		return inContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInContext(Context newInContext) {
		Context oldInContext = inContext;
		inContext = newInContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__IN_CONTEXT,
					oldInContext, inContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getOutContext() {
		if (outContext != null && ((EObject) outContext).eIsProxy()) {
			InternalEObject oldOutContext = (InternalEObject) outContext;
			outContext = (Context) eResolveProxy(oldOutContext);
			if (outContext != oldOutContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.FLOW_SPECIFICATION__OUT_CONTEXT, oldOutContext, outContext));
			}
		}
		return outContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetOutContext() {
		return outContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutContext(Context newOutContext) {
		Context oldOutContext = outContext;
		outContext = newOutContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FLOW_SPECIFICATION__OUT_CONTEXT,
					oldOutContext, outContext));
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
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			if (resolve)
				return getRefined();
			return basicGetRefined();
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			return getKind();
		case Aadl2Package.FLOW_SPECIFICATION__IN_FEATURE:
			if (resolve)
				return getInFeature();
			return basicGetInFeature();
		case Aadl2Package.FLOW_SPECIFICATION__IN_CONTEXT:
			if (resolve)
				return getInContext();
			return basicGetInContext();
		case Aadl2Package.FLOW_SPECIFICATION__OUT_FEATURE:
			if (resolve)
				return getOutFeature();
			return basicGetOutFeature();
		case Aadl2Package.FLOW_SPECIFICATION__OUT_CONTEXT:
			if (resolve)
				return getOutContext();
			return basicGetOutContext();
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
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			setRefined((FlowSpecification) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			setKind((FlowKind) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_FEATURE:
			setInFeature((Feature) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_CONTEXT:
			setInContext((Context) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_FEATURE:
			setOutFeature((Feature) newValue);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_CONTEXT:
			setOutContext((Context) newValue);
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
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			setRefined((FlowSpecification) null);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_FEATURE:
			setInFeature((Feature) null);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__IN_CONTEXT:
			setInContext((Context) null);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_FEATURE:
			setOutFeature((Feature) null);
			return;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_CONTEXT:
			setOutContext((Context) null);
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
			return inModes != null && !inModes.isEmpty();
		case Aadl2Package.FLOW_SPECIFICATION__REFINED:
			return isSetRefined();
		case Aadl2Package.FLOW_SPECIFICATION__KIND:
			return kind != KIND_EDEFAULT;
		case Aadl2Package.FLOW_SPECIFICATION__IN_FEATURE:
			return inFeature != null;
		case Aadl2Package.FLOW_SPECIFICATION__IN_CONTEXT:
			return inContext != null;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_FEATURE:
			return outFeature != null;
		case Aadl2Package.FLOW_SPECIFICATION__OUT_CONTEXT:
			return outContext != null;
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
	 * returns the list of modes the modal element belongs to.
	 * This may be kept with the modal element or an ancestor in the extends hierarchy.
	 * The in modes of the closest ancestor returned.
	 * @return EList of modes. This list may be empty of it is all modes.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup work.
	public EList<Mode> getAllInModes() {
		ModalElement mm = this;
		EList<Mode> inmodes = null;
		// inmodes will be an empty list (all modes) if we do not find a non-empty list
		while (mm != null) {
			inmodes = mm.getInModes();
			// we stop when we find the first occurrence of a non-empty inmodes list
			if (inmodes != null && !inmodes.isEmpty())
				return inmodes;
			if (mm instanceof RefinableElement)
				mm = (ModalElement) ((RefinableElement) mm).getRefinedElement();
			else
				mm = null;
		}
		return inmodes;
	}

	/**
	 * get in feature of a flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Feature or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Feature getAllInFeature() {
		FlowSpecification fs = this;
		while (fs.getInFeature() == null && fs.getRefined() != null)
			fs = fs.getRefined();
		return fs.getInFeature();
	}

	/**
	 * get in flow context of a flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Context or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Context getAllInContext() {
		FlowSpecification fs = this;
		while (fs.getInContext() == null && fs.getRefined() != null)
			fs = fs.getRefined();
		return fs.getInContext();
	}

	/**
	 * get out feature of a flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Feature or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Feature getAllOutFeature() {
		FlowSpecification fs = this;
		while (fs.getOutFeature() == null && fs.getRefined() != null)
			fs = fs.getRefined();
		return fs.getOutFeature();
	}

	/**
	 * get out flow context of flow source, sink, or path spec.
	 * In case of a refined flowspec get it from the flowspec being refined
	 * @return Context or null
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Context getAllOutContext() {
		FlowSpecification fs = this;
		while (fs.getOutContext() == null && fs.getRefined() != null)
			fs = fs.getRefined();
		return fs.getOutContext();
	}

	public final void getPropertyValueInternal(final Property prop, final PropertyAcc paa,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		final Classifier owner = getContainingClassifier();

		if (paa.addLocalContained(this, owner) || paa.addLocal(this)) {
			return;
		}

		// values from refined flow specifications
		FlowSpecification refined = getRefined();
		while (refined != null) {
			if (paa.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		// values from container
		// Ignore fromInstanceSlaveCall because the classifier is a component TYPE, not an implementation.
		if (!fromInstanceSlaveCall && prop.isInherit()) {
			if (owner != null) {
				owner.getPropertyValueInternal(prop, paa, fromInstanceSlaveCall);
			} else {
				throw new InvalidModelException(this, "Flow specification is not part of a component");
			}
		}
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

} //FlowSpecificationImpl
