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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ConnectionKind;
import org.osate.aadl2.Context;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.operations.ModalElementOperations;
import org.osate.aadl2.operations.ModalPathOperations;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getInModeOrTransitions <em>In Mode Or Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getRefinedElement <em>Refined Element</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getRefined <em>Refined</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConnectionImpl extends StructuralFeatureImpl implements Connection {
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
	 * @author dionisio
	 *
	 * to save the connection kind.
	 */
	ConnectionKind connectionKind = null;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ConnectedElement destination;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ConnectedElement source;

	/**
	 * The default value of the '{@link #isBidirectional() <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBidirectional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIDIRECTIONAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isBidirectional() <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBidirectional()
	 * @generated
	 * @ordered
	 */
	protected boolean bidirectional = BIDIRECTIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRefined() <em>Refined</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefined()
	 * @generated
	 * @ordered
	 */
	protected Connection refined;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getConnection();
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
	protected static final int[] IN_MODE_ESUPERSETS = new int[] { Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION };

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
					Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION);
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
		if (eIsSet(Aadl2Package.CONNECTION__REFINED)) {
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
		return super.isSetRefinedElement() || eIsSet(Aadl2Package.CONNECTION__REFINED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Classifier> getFeaturingClassifiers() {
		// DB This should be an EStructuralFeature.Setting
		final EList<Classifier> list = new NonNotifyingEObjectEList<Classifier>(Classifier.class, this,
				Aadl2Package.CONNECTION__FEATURING_CLASSIFIER);
		// BasicEList<Classifier> list = new BasicEList<Classifier>();

		final Classifier classifier = getContainingClassifier();
		// DB the list does not allow null values.
		if (classifier != null) {
			list.add(classifier);
		}

		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionKind getKind() {
		return connectionKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setKind(ConnectionKind newKind) {
		connectionKind = newKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement getDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDestination(ConnectedElement newDestination, NotificationChain msgs) {
		ConnectedElement oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__DESTINATION, oldDestination, newDestination);
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
	public void setDestination(ConnectedElement newDestination) {
		if (newDestination != destination) {
			NotificationChain msgs = null;
			if (destination != null)
				msgs = ((InternalEObject) destination).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONNECTION__DESTINATION, null, msgs);
			if (newDestination != null)
				msgs = ((InternalEObject) newDestination).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONNECTION__DESTINATION, null, msgs);
			msgs = basicSetDestination(newDestination, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTION__DESTINATION, newDestination,
					newDestination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement createDestination() {
		ConnectedElement newDestination = (ConnectedElement) create(Aadl2Package.eINSTANCE.getConnectedElement());
		setDestination(newDestination);
		return newDestination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ConnectedElement newSource, NotificationChain msgs) {
		ConnectedElement oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__SOURCE, oldSource, newSource);
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
	public void setSource(ConnectedElement newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONNECTION__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.CONNECTION__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTION__SOURCE, newSource,
					newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectedElement createSource() {
		ConnectedElement newSource = (ConnectedElement) create(Aadl2Package.eINSTANCE.getConnectedElement());
		setSource(newSource);
		return newSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBidirectional() {
		return bidirectional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBidirectional(boolean newBidirectional) {
		boolean oldBidirectional = bidirectional;
		bidirectional = newBidirectional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTION__BIDIRECTIONAL,
					oldBidirectional, bidirectional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection getRefined() {
		if (refined != null && ((EObject) refined).eIsProxy()) {
			InternalEObject oldRefined = (InternalEObject) refined;
			refined = (Connection) eResolveProxy(oldRefined);
			if (refined != oldRefined) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.CONNECTION__REFINED,
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
	public Connection basicGetRefined() {
		return refined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefined(Connection newRefined) {
		Connection oldRefined = refined;
		refined = newRefined;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.CONNECTION__REFINED, oldRefined,
					refined));
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
		case Aadl2Package.CONNECTION__DESTINATION:
			return basicSetDestination(null, msgs);
		case Aadl2Package.CONNECTION__SOURCE:
			return basicSetSource(null, msgs);
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
		case Aadl2Package.CONNECTION__IN_MODE:
			return getInModes();
		case Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION:
			return getInModeOrTransitions();
		case Aadl2Package.CONNECTION__DESTINATION:
			return getDestination();
		case Aadl2Package.CONNECTION__SOURCE:
			return getSource();
		case Aadl2Package.CONNECTION__BIDIRECTIONAL:
			return isBidirectional();
		case Aadl2Package.CONNECTION__REFINED:
			if (resolve)
				return getRefined();
			return basicGetRefined();
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
		case Aadl2Package.CONNECTION__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			getInModeOrTransitions().addAll((Collection<? extends ModeFeature>) newValue);
			return;
		case Aadl2Package.CONNECTION__DESTINATION:
			setDestination((ConnectedElement) newValue);
			return;
		case Aadl2Package.CONNECTION__SOURCE:
			setSource((ConnectedElement) newValue);
			return;
		case Aadl2Package.CONNECTION__BIDIRECTIONAL:
			setBidirectional((Boolean) newValue);
			return;
		case Aadl2Package.CONNECTION__REFINED:
			setRefined((Connection) newValue);
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
		case Aadl2Package.CONNECTION__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION:
			getInModeOrTransitions().clear();
			return;
		case Aadl2Package.CONNECTION__DESTINATION:
			setDestination((ConnectedElement) null);
			return;
		case Aadl2Package.CONNECTION__SOURCE:
			setSource((ConnectedElement) null);
			return;
		case Aadl2Package.CONNECTION__BIDIRECTIONAL:
			setBidirectional(BIDIRECTIONAL_EDEFAULT);
			return;
		case Aadl2Package.CONNECTION__REFINED:
			setRefined((Connection) null);
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
		case Aadl2Package.CONNECTION__IN_MODE:
			return isSetInModes();
		case Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION:
			return inModeOrTransitions != null && !inModeOrTransitions.isEmpty();
		case Aadl2Package.CONNECTION__REFINED_ELEMENT:
			return isSetRefinedElement();
		case Aadl2Package.CONNECTION__DESTINATION:
			return destination != null;
		case Aadl2Package.CONNECTION__SOURCE:
			return source != null;
		case Aadl2Package.CONNECTION__BIDIRECTIONAL:
			return bidirectional != BIDIRECTIONAL_EDEFAULT;
		case Aadl2Package.CONNECTION__REFINED:
			return refined != null;
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
			case Aadl2Package.CONNECTION__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION:
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ModalElement.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_ELEMENT__IN_MODE:
				return Aadl2Package.CONNECTION__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_PATH__IN_MODE_OR_TRANSITION:
				return Aadl2Package.CONNECTION__IN_MODE_OR_TRANSITION;
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
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (bidirectional: ");
		result.append(bidirectional);
		result.append(')');
		return result.toString();
	}

	/**
	 * get source
	 * in case of a refined connection get it from the connection being refine
	 * @return ConnectionEnd the source (feature, data/bus access end or parameter end)
	 */
	public ConnectionEnd getAllSource() {
		ConnectedElement end = getRootConnection().getSource();
		return (end instanceof ConnectedElement) ? end.getConnectionEnd() : null;
	}

	public ConnectionEnd getAllLastSource() {
		return getRootConnection().getSource().getLastConnectionEnd();
	}

	public Connection getRootConnection() {
		Connection conn = this;
		Connection refined = getRefined();
		while (refined != null) {
			conn = refined;
			refined = conn.getRefined();
		}
		return conn;
	}

	/**
	 * get destination context
	 * in case of a refined connection get it from the connection being refined
	 * @return Context
	 */
	public Context getAllDestinationContext() {
		ConnectedElement end = getRootConnection().getDestination();
		return end.getContext();
	}

	/**
	 * get destination
	 * in case of a refined connection get it from the connection being refined
	 * @return ConnectionEnd the destination (feature, data/bus access end or parameter end)
	 */
	public ConnectionEnd getAllDestination() {
		ConnectedElement end = getRootConnection().getDestination();
		return end.getConnectionEnd();
	}

	public ConnectionEnd getAllLastDestination() {
		return getRootConnection().getDestination().getLastConnectionEnd();
	}

	/**
	 * get source context
	 * in case of a refined connection get it from the connection being refined
	 * @return Context
	 */
	public Context getAllSourceContext() {
		ConnectedElement end = getRootConnection().getSource();
		return end.getContext();
	}

	public final void getPropertyValueInternal(final Property pn, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		final ComponentImplementation partOf = (ComponentImplementation) getContainingClassifier();

		// First look in the container's contained property associations
		if (!fromInstanceSlaveCall && pas.addLocalContained(this, partOf)) {
			if (!all) {
				return;
			}
		}

		/*
		 * Next see if the property is defined in connection's properties
		 * subclause (could merge this with the loop below, but I want to make
		 * the steps more explicit.)
		 */
		if (pas.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		// Next find the value by walking up the connection's refinement
		// sequence
		Connection refined = getRefined();
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

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.Connection#getAllSrcContextComponent()
	 */
	public NamedElement getAllSrcContextComponent() {
		Connection conn = getRootConnection();
		Context scxt = conn.getAllSourceContext();
		if (scxt instanceof FeatureGroup) {
			return conn.getContainingComponentImpl();
		}
		return scxt;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.Connection#getAllDstContextComponent()
	 */
	public NamedElement getAllDstContextComponent() {
		Connection conn = getRootConnection();
		Context dcxt = conn.getAllDestinationContext();
		if (dcxt instanceof FeatureGroup) {
			return conn.getContainingComponentImpl();
		}
		return dcxt;
	}

	public boolean isAllBidirectional() {
		return getRootConnection().isBidirectional();
	}

	public boolean isAcross() {
		Connection conn = getRootConnection();
		ConnectionEnd src = conn.getAllSource();
		ConnectionEnd dst = conn.getAllDestination();
		Context srcCtx = conn.getAllSourceContext();
		Context dstCtx = conn.getAllDestinationContext();
		return (srcCtx instanceof Subcomponent) && (dstCtx instanceof Subcomponent)
				|| (src instanceof Subcomponent) && (dstCtx instanceof Subcomponent)
				|| (srcCtx instanceof Subcomponent) && (dst instanceof Subcomponent);
	}

} // ConnectionImpl
