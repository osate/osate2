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
 * $Id: ConnectionImpl.java,v 1.35 2010-05-04 18:13:32 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentImplementation;
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
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.StructuralFeature;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getInModes <em>In Mode</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getInTransitions <em>In Transition</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getDestination <em>Destination</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getDestinationContext <em>Destination Context</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getSourceContext <em>Source Context</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#isBidirectional <em>Bidirectional</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ConnectionImpl#getRefined <em>Refined</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectionImpl extends StructuralFeatureImpl implements
		Connection {
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
	 * The cached value of the '{@link #getInTransitions() <em>In Transition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ModeTransition> inTransitions;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */

	protected static final ConnectionKind KIND_EDEFAULT = ConnectionKind.ACCESS;

	/**
	 * @author dionisio
	 *
	 * to save the connection kind.
	 */
	ConnectionKind connectionKind = null;

	/**
	 * The cached value of the '{@link #getDestination() <em>Destination</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestination()
	 * @generated
	 * @ordered
	 */
	protected ConnectionEnd destination;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ConnectionEnd source;

	/**
	 * The cached value of the '{@link #getDestinationContext() <em>Destination Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDestinationContext()
	 * @generated
	 * @ordered
	 */
	protected Context destinationContext;

	/**
	 * The cached value of the '{@link #getSourceContext() <em>Source Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceContext()
	 * @generated
	 * @ordered
	 */
	protected Context sourceContext;

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
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getConnection();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mode> getInModes() {
		if (inModes == null) {
			inModes = new EObjectResolvingEList<Mode>(Mode.class, this,
					Aadl2Package.CONNECTION__IN_MODE);
		}
		return inModes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModeTransition> getInTransitions() {
		if (inTransitions == null) {
			inTransitions = new EObjectResolvingEList<ModeTransition>(
					ModeTransition.class, this,
					Aadl2Package.CONNECTION__IN_TRANSITION);
		}
		return inTransitions;
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
	public EList<Classifier> getFeaturingClassifiers() {
		BasicEList<Classifier> list = new BasicEList<Classifier>();
		list.add(getContainingClassifier());
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
	public ConnectionEnd getDestination() {
		if (destination != null && ((EObject) destination).eIsProxy()) {
			InternalEObject oldDestination = (InternalEObject) destination;
			destination = (ConnectionEnd) eResolveProxy(oldDestination);
			if (destination != oldDestination) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONNECTION__DESTINATION,
							oldDestination, destination));
			}
		}
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd basicGetDestination() {
		return destination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestination(ConnectionEnd newDestination) {
		ConnectionEnd oldDestination = destination;
		destination = newDestination;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__DESTINATION, oldDestination,
					destination));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd getSource() {
		if (source != null && ((EObject) source).eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (ConnectionEnd) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONNECTION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionEnd basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ConnectionEnd newSource) {
		ConnectionEnd oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getDestinationContext() {
		if (destinationContext != null
				&& ((EObject) destinationContext).eIsProxy()) {
			InternalEObject oldDestinationContext = (InternalEObject) destinationContext;
			destinationContext = (Context) eResolveProxy(oldDestinationContext);
			if (destinationContext != oldDestinationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONNECTION__DESTINATION_CONTEXT,
							oldDestinationContext, destinationContext));
			}
		}
		return destinationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetDestinationContext() {
		return destinationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDestinationContext(Context newDestinationContext) {
		Context oldDestinationContext = destinationContext;
		destinationContext = newDestinationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__DESTINATION_CONTEXT,
					oldDestinationContext, destinationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context getSourceContext() {
		if (sourceContext != null && ((EObject) sourceContext).eIsProxy()) {
			InternalEObject oldSourceContext = (InternalEObject) sourceContext;
			sourceContext = (Context) eResolveProxy(oldSourceContext);
			if (sourceContext != oldSourceContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONNECTION__SOURCE_CONTEXT,
							oldSourceContext, sourceContext));
			}
		}
		return sourceContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context basicGetSourceContext() {
		return sourceContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceContext(Context newSourceContext) {
		Context oldSourceContext = sourceContext;
		sourceContext = newSourceContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__SOURCE_CONTEXT, oldSourceContext,
					sourceContext));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__BIDIRECTIONAL, oldBidirectional,
					bidirectional));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.CONNECTION__REFINED, oldRefined,
							refined));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.CONNECTION__REFINED, oldRefined, refined));
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.CONNECTION__IN_MODE:
			return getInModes();
		case Aadl2Package.CONNECTION__IN_TRANSITION:
			return getInTransitions();
		case Aadl2Package.CONNECTION__KIND:
			return getKind();
		case Aadl2Package.CONNECTION__DESTINATION:
			if (resolve)
				return getDestination();
			return basicGetDestination();
		case Aadl2Package.CONNECTION__SOURCE:
			if (resolve)
				return getSource();
			return basicGetSource();
		case Aadl2Package.CONNECTION__DESTINATION_CONTEXT:
			if (resolve)
				return getDestinationContext();
			return basicGetDestinationContext();
		case Aadl2Package.CONNECTION__SOURCE_CONTEXT:
			if (resolve)
				return getSourceContext();
			return basicGetSourceContext();
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.CONNECTION__IN_MODE:
			getInModes().clear();
			getInModes().addAll((Collection<? extends Mode>) newValue);
			return;
		case Aadl2Package.CONNECTION__IN_TRANSITION:
			getInTransitions().clear();
			getInTransitions().addAll(
					(Collection<? extends ModeTransition>) newValue);
			return;
		case Aadl2Package.CONNECTION__KIND:
			setKind((ConnectionKind) newValue);
			return;
		case Aadl2Package.CONNECTION__DESTINATION:
			setDestination((ConnectionEnd) newValue);
			return;
		case Aadl2Package.CONNECTION__SOURCE:
			setSource((ConnectionEnd) newValue);
			return;
		case Aadl2Package.CONNECTION__DESTINATION_CONTEXT:
			setDestinationContext((Context) newValue);
			return;
		case Aadl2Package.CONNECTION__SOURCE_CONTEXT:
			setSourceContext((Context) newValue);
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
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.CONNECTION__IN_MODE:
			getInModes().clear();
			return;
		case Aadl2Package.CONNECTION__IN_TRANSITION:
			getInTransitions().clear();
			return;
		case Aadl2Package.CONNECTION__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case Aadl2Package.CONNECTION__DESTINATION:
			setDestination((ConnectionEnd) null);
			return;
		case Aadl2Package.CONNECTION__SOURCE:
			setSource((ConnectionEnd) null);
			return;
		case Aadl2Package.CONNECTION__DESTINATION_CONTEXT:
			setDestinationContext((Context) null);
			return;
		case Aadl2Package.CONNECTION__SOURCE_CONTEXT:
			setSourceContext((Context) null);
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
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.CONNECTION__IN_MODE:
			return inModes != null && !inModes.isEmpty();
		case Aadl2Package.CONNECTION__IN_TRANSITION:
			return inTransitions != null && !inTransitions.isEmpty();
		case Aadl2Package.CONNECTION__KIND:
			return getKind() != KIND_EDEFAULT;
		case Aadl2Package.CONNECTION__DESTINATION:
			return destination != null;
		case Aadl2Package.CONNECTION__SOURCE:
			return source != null;
		case Aadl2Package.CONNECTION__DESTINATION_CONTEXT:
			return destinationContext != null;
		case Aadl2Package.CONNECTION__SOURCE_CONTEXT:
			return sourceContext != null;
		case Aadl2Package.CONNECTION__BIDIRECTIONAL:
			return bidirectional != BIDIRECTIONAL_EDEFAULT;
		case Aadl2Package.CONNECTION__REFINED:
			return isSetRefined();
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
			case Aadl2Package.CONNECTION__IN_MODE:
				return Aadl2Package.MODAL_ELEMENT__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (derivedFeatureID) {
			case Aadl2Package.CONNECTION__IN_TRANSITION:
				return Aadl2Package.MODAL_PATH__IN_TRANSITION;
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
				return Aadl2Package.CONNECTION__IN_MODE;
			default:
				return -1;
			}
		}
		if (baseClass == ModalPath.class) {
			switch (baseFeatureID) {
			case Aadl2Package.MODAL_PATH__IN_TRANSITION:
				return Aadl2Package.CONNECTION__IN_TRANSITION;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
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
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public ConnectionEnd getAllSource() {
		Connection conn = getRootConnection();
		return conn.getSource();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
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
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Context getAllDestinationContext() {
		Connection conn = getRootConnection();
		return conn.getDestinationContext();
	}

	/**
	 * get destination
	 * in case of a refined connection get it from the connection being refined
	 * @return ConnectionEnd the destination (feature, data/bus access end or parameter end)
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public ConnectionEnd getAllDestination() {
		Connection conn = getRootConnection();
		return conn.getDestination();
	}

	/**
	 * get source context
	 * in case of a refined connection get it from the connection being refined
	 * @return Context
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public Context getAllSourceContext() {
		Connection conn = getRootConnection();
		return conn.getSourceContext();
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	public final void getPropertyValueInternal(final Property pn,
			final PropertyAcc pas, final boolean fromInstanceSlaveCall)
			throws InvalidModelException {
		final ComponentImplementation partOf = (ComponentImplementation) getContainingClassifier();

		// First look in the container's contained property associations
		if (!fromInstanceSlaveCall && pas.addLocalContained(this, partOf)) {
			return;
		}

		/* Next see if the property is defined in connection's properties
		 * subclause (could merge this with the loop below, but I want to make
		 * the steps more explicit.)
		 */
		if (pas.addLocal(this)) {
			return;
		}

		// Next find the value by walking up the connection's refinement
		// sequence
		Connection refined = getRefined();
		while (refined != null) {
			if (pas.addLocal(refined)) {
				return;
			}
			refined = refined.getRefined();
		}

		/* if still not set, and the property is "inherit", try the containing
		 * component implementation.
		 */
		if (!fromInstanceSlaveCall && pn.isInherit()) {
			partOf.getPropertyValueInternal(pn, pas, fromInstanceSlaveCall);
		}
	}

	/* (non-Javadoc)
	 * @see org.osate.aadl2.Connection#getAllSrcContextComponent()
	 */
	public NamedElement getAllSrcContextComponent() {
		Connection conn = this.getRootConnection();
		Context scxt = conn.getAllSourceContext();
		if (scxt instanceof FeatureGroup) {
			return conn.getContainingComponentImpl();
		}
		return scxt;
	}

	/* (non-Javadoc)
	 * @see org.osate.aadl2.Connection#getAllDstContextComponent()
	 */
	public NamedElement getAllDstContextComponent() {
		Connection conn = this.getRootConnection();
		Context dcxt = conn.getAllDestinationContext();
		if (dcxt instanceof FeatureGroup) {
			return conn.getContainingComponentImpl();
		}
		return dcxt;
	}

	/**
	 * returns the list of modes the modal element belongs to.
	 * This may be kept with the modal element or an ancestor in the extends hierarchy.
	 * The in modes of the closest ancestor returned.
	 * @return EList of modes. This list may be empty of it is all modes.
	 */
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
	
	/* getName needs to get it from the refined pointer if it was refined
	 *(non-Javadoc)
	 * @see org.osate.aadl2.impl.NamedElementImpl#getName()
	 */
	@Override
	public String getName() {
		if (name != null)
			return name;
		return getRefined().getName();
	}


} //ConnectionImpl
