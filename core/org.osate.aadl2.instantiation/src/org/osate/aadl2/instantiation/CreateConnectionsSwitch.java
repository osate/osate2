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
package org.osate.aadl2.instantiation;

import static org.osate.aadl2.ComponentCategory.BUS;
import static org.osate.aadl2.ComponentCategory.DATA;
import static org.osate.aadl2.ComponentCategory.DEVICE;
import static org.osate.aadl2.ComponentCategory.PROCESSOR;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM_GROUP;
import static org.osate.aadl2.ComponentCategory.THREAD;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_BUS;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_PROCESSOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.impl.ParameterImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.aadl2.util.Aadl2InstanceUtil;

/**
 * This class adds all connection instances to an instance model.
 */
public class CreateConnectionsSwitch extends AadlProcessingSwitchWithProgress {

	/**
	 * A stack of indices into feature groups. If the connections goes into
	 * feature #n when going up the hierarchy, it must come out at feature #n
	 * when going down the hierarchy. This can happen at any level, so we need a
	 * stack.
	 */
	private Stack<FeatureInstance> upFeature = new Stack<FeatureInstance>();

	/**
	 * Keeps track of indices used when going down into feature groups after we
	 * run out of indices in the up stack.
	 */
	private Stack<FeatureInstance> downFeature = new Stack<FeatureInstance>();

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache = null;

	/**
	 * Create a new instance.
	 *
	 * @param pm
	 *            the progress monitor
	 * @param errMgr
	 *            the error manager
	 * @param classifierCache
	 *            cache of known instantiated classifiers, may be null
	 */
	public CreateConnectionsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
		this.classifierCache = classifierCache;
	}

	private boolean isOpposite(Feature feature, Subcomponent sub, Connection connection) {
		List<Feature> features = feature.getAllFeatureRefinements();
		EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
		if (features.contains(connection.getAllSource()) && subs.contains(connection.getAllSourceContext())) {
			return false;
		} else {
			if (connection.isAllBidirectional() && features.contains(connection.getAllDestination())
					&& subs.contains(connection.getAllDestinationContext())) {
				// we are going the other way on a bi-directional connection
				return true;
			}
		}
		return false;
	}

	private boolean isOpposite(Feature feature, Connection connection) {
		List<Feature> features = feature.getAllFeatureRefinements();
		if (features.contains(connection.getAllSource())) {
			return false;
		} else {
			if (connection.isAllBidirectional() && features.contains(connection.getAllDestination())) {
				// we are going the other way on a bi-directional connection
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch#initSwitches
	 * ()
	 */
	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {

			@Override
			public String caseComponentInstance(final ComponentInstance ci) throws UnsupportedOperationException {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				if (!(ci instanceof SystemInstance)) {
					if (isFirstArrayElement(ci)) {
						// process first component of innermost array only
						instantiateConnections(ci);
					}
				} else {
					instantiateExternalConnections((SystemInstance) ci);
				}
				return DONE;
			}
		};
	}

	private boolean isFirstArrayElement(ComponentInstance ci) {
		while (!(ci instanceof SystemInstance)) {
			for (Long index : ci.getIndices()) {
				if (index > 1) {
					return false;
				}
			}
			ci = ci.getContainingComponentInstance();
		}
		return true;
	}

	/**
	 * Create all connection instances that start at a component instance.
	 *
	 * @param ci
	 *            The component that is the ultimate source; this should be a
	 *            thread, processor or device
	 * @throws InstantiationException
	 */
	// TODO-LW: handle access to subprograms and subprogram groups
	// TODO-LW: connections inside threads (mode conn, access)
	// TODO-LW: warning if connection incomplete
	private void instantiateConnections(final ComponentInstance ci) throws UnsupportedOperationException {
		ComponentCategory cat = ci.getCategory();
		Subcomponent sub = ci.getSubcomponent();
		ComponentInstance parentci = ci.getContainingComponentInstance();
		List<Connection> parentConns = InstanceUtil.getComponentImplementation(parentci, 0, classifierCache)
				.getAllConnections();

		if (parentci instanceof SystemInstance) {
			monitor.subTask("Creating connections in  " + ci.getName());
		}

		if (cat == DATA || cat == BUS || cat == VIRTUAL_BUS || cat == SUBPROGRAM || cat == SUBPROGRAM_GROUP) {
			// connection instance may start at a shared component
			for (Connection conn : filterStartingConnections(parentConns, sub)) {
				boolean opposite = sub.getAllSubcomponentRefinements().contains(conn.getAllDestination());

				appendSegment(ConnectionInfo.newConnectionInfo(ci), conn, parentci, opposite);
				if (monitor.isCanceled()) {
					return;
				}
			}
		}
		// connection instance may start at a feature
		List<Connection> outsideSubConns = filterOutgoingConnections(parentConns, sub);
		ComponentImplementation cimpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
		@SuppressWarnings("unchecked")
		List<Connection> insideSubConns = cimpl != null ? cimpl.getAllConnections() : Collections.EMPTY_LIST;
		boolean hasOutgoingFeatureSubcomponents = AadlUtil.hasOutgoingFeatureSubcomponents(ci.getComponentInstances());
		// prevFi is used to skip all but the first element in a feature array
		// TODO inspect index, instead
		FeatureInstance prevFi = null;
		for (FeatureInstance featurei : ci.getFeatureInstances()) {
			if (prevFi == null || !prevFi.getName().equalsIgnoreCase(featurei.getName())) {
				Feature feature = featurei.getFeature();
				// TODO warning if subcomponents with outgoing features
				// exist
				if (AadlUtil.hasOutgoingFeatures(featurei)) {
					List<Connection> outgoingConns = filterOutgoingConnections(outsideSubConns, feature, sub);
					/*
					 * We only care about internal connections if (1) they exist and (2) the component is either not connection ending or it is connection
					 * ending but the feature has an access feature. (Here we are deliberately ignoring any connections between a port on thread
					 * and feature of a abstract subcomponent. Such connections are currently legal but seem wrong.)
					 */
					final FeatureInfo fInfo = FeatureInfo.init(featurei);
					final boolean isConnectionEndingCategory = isConnectionEndingCategory(cat);
					final boolean lookInside = hasOutgoingFeatureSubcomponents && (!isConnectionEndingCategory || fInfo.hasAccess());
					final boolean connectedInside = lookInside && isConnectionEnd(insideSubConns, feature);
					final boolean destinationFromInside = lookInside && isDestination(insideSubConns, feature);

					// first see if mode transitions are triggered by a
					// doModeTransitionConnections(ci, featurei);

					for (final Connection conn : outgoingConns) {
						// conn is first segment if it can't continue inside
						// the subcomponent

						/*
						 * We start from inside the component in the following cases
						 * - The feature is a destination from inside (we have already dealt with the connection ending component case above)
						 * - The outside connection is bidirectional and the the feature is connected inside (again, we have already filtered out the connection
						 * ending component case)
						 *
						 * So, we start AT THE Component in the following cases
						 * - The disjunction of the above is false
						 * - The component is connection ending and the feature has ports or feature groups.  (This case is only relevant when
						 *   the feature is a feature group.)
						 */
						if ((!destinationFromInside && !(conn.isAllBidirectional() && connectedInside))
								|| (isConnectionEndingCategory && (fInfo.hasFeatureGroup() || fInfo.hasPort()))) {
							prevFi = featurei;
							boolean opposite = isOpposite(feature, sub, conn);
							appendSegment(ConnectionInfo.newConnectionInfo(featurei), conn, parentci, opposite);
							if (monitor.isCanceled()) {
								return;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Create all connection instances that with an incoming port of the
	 * SystemInstance.
	 *
	 * @param si
	 *            The component that is the ultimate source;
	 */
	private void instantiateExternalConnections(final SystemInstance si) {
		List<Connection> sysConns = InstanceUtil.getComponentImplementation(si, 0, classifierCache).getAllConnections();

		for (FeatureInstance featurei : si.getFeatureInstances()) {
			processIncomingFeature(featurei, si, sysConns);
			for (FeatureInstance contained : featurei.getFeatureInstances()) {
				processIncomingFeature(contained, si, sysConns);
			}
		}
	}

	private void processIncomingFeature(FeatureInstance featurei, SystemInstance si, List<Connection> sysConns) {
		if (featurei.getFlowDirection().incoming()) {
			if (featurei.getIndex() <= 1) {
				List<Connection> inConns = filterIngoingConnections(si, sysConns, featurei);
				for (Connection conn : inConns) {
					boolean opposite = isOpposite(featurei.getFeature(), conn);

					appendSegment(ConnectionInfo.newConnectionInfo(featurei), conn, si, opposite);
					if (monitor.isCanceled()) {
						return;
					}
				}
			}
		}
	}

	/**
	 * appendSegment Append a segment to a connection instance.
	 *
	 * @param newSegment
	 *            the declarative connection to be added to the connection
	 *            instance
	 * @param ci
	 *            the component that contains the new segment
	 * @param goOpposite
	 *            the current declarative connection is bidirectional and we are
	 *            following it toward its source
	 * @param conni
	 *            the connection instance representing the semantic connection
	 */
	// TODO-LW: set 'complete' in conn info
	private void appendSegment(ConnectionInfo connInfo, final Connection newSegment, final ComponentInstance ci,
			final boolean goOpposite) {
		final boolean didModeTransitionConnection = doModeTransitionConnections(ci, connInfo, newSegment);
		final ConnectionEnd fromEnd = goOpposite ? newSegment.getAllDestination() : newSegment.getAllSource();
		final Context fromCtx = goOpposite ? newSegment.getAllDestinationContext() : newSegment.getAllSourceContext();
		ConnectionEnd toEnd = goOpposite ? newSegment.getAllSource() : newSegment.getAllDestination();
		final Context toCtx = goOpposite ? newSegment.getAllSourceContext() : newSegment.getAllDestinationContext();
		final ComponentInstance toCi = (toCtx instanceof Subcomponent)
				? ci.findSubcomponentInstance((Subcomponent) toCtx)
				: null;
		final boolean finalComponent = isConnectionEndingComponent(toCtx);
		final boolean dstEmpty = toCtx instanceof Subcomponent && toCi.getComponentInstances().isEmpty();
		ConnectionInstanceEnd fromFi = null;
		ConnectionInstanceEnd toFi = null;
		FeatureInstance pushedFeature = null;
		FeatureInstance poppedFeature = null;
		FeatureInstance downedFeature = null;

		/*
		 * FIX JD If we have a data component directly connected to a subprogram
		 * parameter, we do not handle it because we do not deal with parameter
		 * connection within the instance model. See bug #220
		 */
		if ((toEnd instanceof ParameterImpl)
				&& ((fromEnd instanceof DataSubcomponent) || (fromEnd instanceof DataAccess))) {
			return;
		}

		/*
		 * Fix JD bug #222.
		 * Tweaked again for Issue #2162: changed to check if the context is a subprogram call
		 * rather than just checking if the feature is contained in a subprogram.
		 */
		if ((toEnd instanceof DataAccess) && (toCtx instanceof SubprogramCall)) {
			return;
		}

		if (toCtx instanceof Subcomponent && toCi == null) {
			if (!(toCtx instanceof SubprogramSubcomponent)) {
				error(ci, "Instantiation error: no component instance for subcomponent " + toCtx.getName());
			}
			return;
		}

		if (!(fromEnd instanceof Subcomponent)) {
			// fromEnd is a feature
			final ComponentInstance fromCi = (fromCtx instanceof Subcomponent)
					? ci.findSubcomponentInstance((Subcomponent) fromCtx)
					: null;
			if (fromCtx instanceof Subcomponent && fromCi == null) {
				if (!(fromCtx instanceof SubprogramSubcomponent)) {
					error(ci, "Instantiation error: no component instance for subcomponent " + fromCtx.getName());
				}
				return;
			}
			List<FeatureInstance> fiList = null;

			if (fromCtx instanceof FeatureGroup) {
				// TODO phf: find index and compare with stack
				FeatureInstance fgi = (FeatureInstance) AadlUtil.findNamedElementInList(ci.getFeatureInstances(),
						fromCtx.getName());
				if (fgi != null) {
					fiList = fgi.getFeatureInstances();
					fromFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, fromEnd.getName());
				}
				if (fromFi != null) {
					if (!upFeature.empty()) {
						FeatureInstance popfi = upFeature.peek();
						// match against stack only if we don't reach deeper into feature group
						if (connInfo.dstToMatch == null && !Aadl2InstanceUtil.isSame(popfi, (FeatureInstance) fromFi)) {
							// did not match
							return;
						} else {
							poppedFeature = upFeature.pop();
						}
					} else {
						downFeature.push((FeatureInstance) fromFi);
						downedFeature = (FeatureInstance) fromFi;
					}
				}
			} else {
				fiList = (fromCi != null ? fromCi : ci).getFeatureInstances();
				fromFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, fromEnd.getName());
			}
		} else {
			fromFi = ci.findSubcomponentInstance((Subcomponent) fromEnd);
		}
		if (!(toEnd instanceof Subcomponent)) {
			List<FeatureInstance> fiList = null;

			if (toCtx instanceof FeatureGroup) {

				FeatureInstance fgi = (FeatureInstance) AadlUtil.findNamedElementInList(ci.getFeatureInstances(),
						toCtx.getName());
				if (fgi != null) {
					fiList = fgi.getFeatureInstances();
					toFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, toEnd.getName());
				}
				if (toFi != null) {
					upFeature.push((FeatureInstance) toFi);
					pushedFeature = (FeatureInstance) toFi;
				}
			} else {
				fiList = (toCi != null ? toCi : ci).getFeatureInstances();
				toFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, toEnd.getName());
			}
		} else {
			toFi = ci.findSubcomponentInstance((Subcomponent) toEnd);
		}

		/*
		 * Issue 2032: We do not want connections that go from abstract subcomponent to the ports of
		 * their containing components if the containing component is final. We specifically are
		 * checking that the connection starts at a port feature and ends at a feature that is a feature
		 * of the containing component and the containing component is a connection ending component. We don't
		 * have to check that the end feature is a port because AADL semantics guarantee that it will be.
		 */
		if (fromFi instanceof FeatureInstance && ((FeatureInstance) fromFi).getFeature() instanceof Port
				&& toFi.eContainer().equals(ci) && isConnectionEndingCategory(ci.getCategory())) {
			return;
		}

		try {
			boolean[] keep = { false };
			boolean valid = connInfo.addSegment(newSegment, fromFi, toFi, ci, goOpposite, keep);
			if (!keep[0]) {
				return;
			}
			if (!valid) {
				if (toFi == null) {
					error(ci,
							"Connection from " + connInfo.src.getInstanceObjectPath() + " via "
									+ newSegment.getQualifiedName()
									+ " has no valid direction. Connection instance not created.");
				} else {
					error(ci,
							"Connection from " + connInfo.src.getInstanceObjectPath() + " to "
									+ toFi.getInstanceObjectPath()
									+ " has no valid direction. Connection instance not created.");
				}
				return;
			}

			// first check if the connection must end with the new segment
			if (toEnd instanceof Subcomponent) {
				ComponentInstance toInstance = ci.findSubcomponentInstance((Subcomponent) toEnd);
				if (toInstance == null) {
					// happens if conn leaves system to aggregate data port
					warning(ci, "Connection to " + toEnd.getQualifiedName() + " could not be instantiated.");
				} else {
					// connection ends at a shared data, bus, or subprogram (group)
					connInfo.complete = true;
					finalizeConnectionInstance(ci.getSystemInstance(), connInfo, toInstance);
				}
			} else if (toEnd instanceof InternalFeature || toEnd instanceof ProcessorFeature) {
				// can't handle these
				// FIXME: What if a connection from outside goes to one of these?
				warning(ci, "Connection to " + toEnd.getQualifiedName() + " could not be instantiated.");
			} else {
				Feature toFeature = (Feature) toEnd;

				if (toEnd instanceof Parameter) {
					// connection ends at a parameter
					FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
					if (dstFi == null) {
						error(toCi,
								"Destination feature " + toFeature.getName() + " not found. No connection created.");
					} else {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, dstFi);
					}
				} else if (dstEmpty) {
					// connection ends because the destination component does not
					// contain any subcomponents
					FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
					if (dstFi == null) {
						error(toCi,
								"Destination feature " + toFeature.getName() + " not found. No connection created.");
					} else {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, dstFi);
					}
				} else if (!(toCtx instanceof Subcomponent)) {
					// the connection may have more segments
					// going up hierarchy, connection goes to a feature in the
					// component
					// implementation
					if (ci instanceof SystemInstance) {
						if (toCtx instanceof FeatureGroup) {
							// XXX: PHF: going up into an element of a feature group
							// should we go to the FG or to the feature?
							finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance((FeatureGroup) toCtx));
						} else {
							finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance(toFeature));
						}
					} else {
						if (toCtx instanceof FeatureGroup) {
							toFeature = (FeatureGroup) toCtx;
							// toFeature now points to the enclosing feature group
							// this should be the starting feature for the next
							// connection
						}

						ComponentInstance nextCi = ci.getContainingComponentInstance();
						List<Connection> parentConns = InstanceUtil
								.getComponentImplementation(nextCi, 0, classifierCache).getAllConnections();
						FeatureInstance dstFi = ci.findFeatureInstance(toFeature);
						List<Connection> conns = filterOutgoingConnections(parentConns, dstFi.getFeature(),
								ci.getSubcomponent());

						if (conns.isEmpty()) {
							if (!didModeTransitionConnection) {
								if (ci instanceof SystemInstance) {
									finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance(toFeature));
								} else {
									warning(toFi,
											"Could not continue connection from " + connInfo.src.getInstanceObjectPath()
													+ "  through " + toFi.getInstanceObjectPath()
													+ ". No connection instance created.");
								}
							}
						} else {
							for (Connection nextConn : conns) {
								// note: nextConn goes either up or across
								final ConnectionInfo clone = connInfo.cloneInfo();
								boolean opposite = false;

								if (nextConn.isAllBidirectional()) {
									ConnectionEnd nextDst = nextConn.getAllDestination();

									if (nextDst instanceof Feature) {
										Feature nextDstFeature = (Feature) nextDst;
										FeatureInstance nextDstFi = nextCi.findFeatureInstance(nextDstFeature);

										if (nextDstFi == null) {
											// next goes across
											Context nextDstCtx = nextConn.getAllDestinationContext();

											if (nextDstCtx instanceof Subcomponent) {
												ComponentInstance nextDstSubi = nextCi
														.findSubcomponentInstance((Subcomponent) nextDstCtx);
												nextDstFi = nextDstSubi.findFeatureInstance(nextDstFeature);
											}
										}
										if (nextDstFi != null) {
											opposite = ci.findFeatureInstance(toFeature) == nextDstFi;
										}
									}
								}
								appendSegment(clone, nextConn, nextCi, opposite);
							}
						}
					}
				} else {
					// going down hierarchy or across

					if (toCtx instanceof Subcomponent && toCi == null) {
						if (!(toCtx instanceof SubprogramSubcomponent)) {
							error(ci, "Instantiation error: no component instance for subcomponent " + toCtx.getName());
						}
						return;
					}

					toFi = toCi.findFeatureInstance(toFeature);

					if (toFi == null) {
						error(ci, "Could not find instance object for feature " + toEnd.getName() + " of subcomponent "
								+ ((Subcomponent) toCtx).getName() + ". No connection instance created.");
						return;
					}

					ComponentImplementation toImpl = InstanceUtil.getComponentImplementation(toCi, 0, classifierCache);
					if (toImpl == null) {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, toFi);
					} else {
						// there is a toImpl

						/*
						 * Issue 2032: Get the connections internal to the destination component that connect
						 * to the feature. Two cases here. (1) If the component is final (thread/device/processor),
						 * we only follow access features inside, (2) otherwise we follow all the internal connections
						 * except for the parameter connections. We keep track of whether any internal connections were
						 * ignored so we know if we should create a connection instance that stops at the component itself.
						 */
						final AtomicBoolean hasIgnoredConnection = new AtomicBoolean(false);
						List<Connection> conns = AadlUtil.getIngoingConnections(toImpl, toFeature,
								c -> {
									if (c instanceof AccessConnection) {
										return true; // never ignore access connections
									} else if (c instanceof ParameterConnection) {
										// always ignore parameter connections
										hasIgnoredConnection.set(true);
										return false;
									} else {
										// Ignore other connections only if the component is connection ending
										if (finalComponent) {
											hasIgnoredConnection.set(true);
											return false;
										} else {
											return true;
										}
									}
								});

						if (conns.isEmpty()) {
							// No internal connections, or they are all parameter connections, so we stop here
							List<Subcomponent> subs = toImpl.getAllSubcomponents();

							if (!subs.isEmpty()) {
								if (!finalComponent) {
									warning(ci,
											"No connection declaration from feature " + toEnd.getName()
													+ " of component " + ((Subcomponent) toCtx).getName()
													+ " to subcomponents. Connection instance ends at "
													+ ((Subcomponent) toCtx).getName());
								}
								connInfo.complete = true;
								finalizeConnectionInstance(ci, connInfo, toFi);
							}
						} else {
							// we may need to stop at the processor in addition to
							// going in

							/*
							 * Issue 2032: If we get here then destination component has internal connections,
							 * not all of which are parameter connections. We definitely are going to proceed
							 * inside the component with the connection. However, if there are internal
							 * connections that were ignored, we also need to create a connection instance that
							 * ends at the component.
							 *
							 * NB. Not possible to have an ignored parameter connection from a feature and have a
							 * another not ignored connection from that feature because the only place a
							 * parameter connection can exist is in a subprogram or a thread, and it's
							 * not possible to have a regular port connections internal to
							 * either one of those (with the exception of abstract components, but those
							 * should probably be illegal anyway and we ignore those too).
							 */
							if (hasIgnoredConnection.get()) {
								final ConnectionInfo clone = connInfo.cloneInfo();
								clone.complete = true;
								finalizeConnectionInstance(ci, clone, toFi);
							}

							// we have ingoing connections that start with toFeature
							// as End or as Cxt
							for (Connection nextConn : conns) {
								final ConnectionInfo clone = connInfo.cloneInfo();

								EList<Feature> toflist = toFeature.getAllFeatureRefinements();
								Context dstCtx = nextConn.getAllDestinationContext();
								// dstCtx is null if we're going down and in opposite direction
								final boolean opposite = toflist.contains(nextConn.getAllDestination())
										&& (dstCtx == null || toCtx == dstCtx) || toflist.contains(dstCtx);
								appendSegment(clone, nextConn, toCi, opposite);
							}
						}
					}
				}
			}
		} finally {
			if (pushedFeature != null) {
				if (!upFeature.empty()) {
					upFeature.pop();
				} else {
					warning(ci, "Popping from empty upindex");
				}
			}
			if (poppedFeature != null) {
				if (downFeature.empty()) {
					upFeature.push(poppedFeature);
				} else {
					// remove from downIndex
					warning(ci, "Trying to push back on while downIndex is not empty");
				}
			}
			if (downedFeature != null) {
				// remove from downIndex
				FeatureInstance popfeature = downFeature.pop();
				if (!Aadl2InstanceUtil.isSame(popfeature, downedFeature)) {
					// should be the same
					warning(ci, "Did not match popped downIndex");
				}
			}
		}
	}

	private static final class FeatureInfo {
		private final boolean isFeatureGroup;
		private final boolean hasAccess;
		private final boolean hasPort;
		private final boolean hasParameter;
		private final boolean hasFeatureGroup;

		private FeatureInfo(final boolean isFeatureGroup, final boolean hasAccess, final boolean hasPort,
				final boolean hasParameter, final boolean hasFeatureGroup) {
			this.isFeatureGroup = isFeatureGroup;
			this.hasAccess = hasAccess;
			this.hasPort = hasPort;
			this.hasParameter = hasParameter;
			this.hasFeatureGroup = hasFeatureGroup;
		}

		public static FeatureInfo init(final FeatureInstance fi) {
			Feature end = fi.getFeature();
			if (fi.getFeature() instanceof FeatureGroup) {
				return init(fi.getFeatureInstances().iterator(), false, false, false, false);
			} else if (end instanceof Access) {
				return new FeatureInfo(false, true, false, false, false);
			} else if (end instanceof Parameter) {
				return new FeatureInfo(false, false, false, true, false);
			} else if (end instanceof Port) {
				return new FeatureInfo(false, false, true, false, false);
			} else {
				return new FeatureInfo(false, false, false, false, false);
			}
		}

		private static FeatureInfo init(final Iterator<FeatureInstance> iter, final boolean hasAccess, final boolean hasPort, final boolean hasParameter, final boolean hasFeatureGroup) {
			if (iter.hasNext()) {
				final Feature f = iter.next().getFeature();
				return init(iter, hasAccess || f instanceof Access, hasPort || f instanceof Port,
						hasParameter || f instanceof Parameter, hasFeatureGroup || f instanceof FeatureGroup);
			} else {
				return new FeatureInfo(true, hasAccess, hasPort, hasParameter, hasFeatureGroup);
			}
		}

		public boolean isFeatureGroup() {
			return isFeatureGroup;
		}

		public boolean hasAccess() {
			return hasAccess;
		}

		public boolean hasPort() {
			return hasPort;
		}

		public boolean hasParameter() {
			return hasParameter;
		}

		public boolean hasFeatureGroup() {
			return hasFeatureGroup;
		}
	}

	// ------------------------------------------------------------------------
	// Post-process completed connection instance
	// ------------------------------------------------------------------------

	protected void finalizeConnectionInstance(ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd dstEnd) {

		FeatureInstance upFi = null;
		if (dstEnd instanceof FeatureInstance) {
			FeatureInstance dstFi = (FeatureInstance) dstEnd;
			EList<FeatureInstance> flist = dstFi.getFeatureInstances();

			if (dstFi.getCategory() == FeatureCategory.FEATURE_GROUP && !upFeature.isEmpty()) {
				upFi = upFeature.pop();
				if (upFi.eContainer() == dstFi) {
					dstFi = upFi;
				} else {
					FeatureGroup upfg = ((FeatureGroup) ((FeatureInstance) upFi.getOwner()).getFeature());
					FeatureGroup downfg = ((FeatureGroup) dstFi.getFeature());
					FeatureGroupType upfgt = upfg.getAllFeatureGroupType();
					FeatureGroupType downfgt = downfg.getAllFeatureGroupType();
					if (downfgt == null) {
						warning(dstFi.getContainingComponentInstance(),
								"In " + dstFi.getContainingComponentInstance().getName() + " (classifier "
										+ dstFi.getContainingComponentInstance().getComponentClassifier().getName()
										+ ") feature group " + dstFi.getName() + " has no type");
					}
					if (upfgt != null && downfgt != null && upfg.isInverseOf(downfg)
							&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
						dstFi = flist.get(Aadl2InstanceUtil.getFeatureIndex(upFi));
					}
				}
			}
			if (connInfo.src instanceof FeatureInstance) {
				FeatureInstance srcFi = (FeatureInstance) connInfo.src;

				if (srcFi.getFeatureInstances().isEmpty() && dstFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
				} else {
					// src and/or dst is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcFi, dstFi);
				}
			} else if (connInfo.src instanceof ComponentInstance) {
				ComponentInstance srcCi = (ComponentInstance) connInfo.src;

				if (dstFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
				} else {
					// dst is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcCi, dstFi);
				}
			} else {
				error(parentci.getSystemInstance(), "Connection source is neither a feature nor a component: "
						+ connInfo.src.getInstanceObjectPath() + " => " + connInfo.src.getInstanceObjectPath());
			}
			if (upFi != null) {
				upFeature.push(upFi);
			}
		} else {
			// Component Instance
			ComponentInstance dstCi = (ComponentInstance) dstEnd;

			if (connInfo.src instanceof FeatureInstance) {
				FeatureInstance srcFi = (FeatureInstance) connInfo.src;

				if (srcFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstCi);
				} else {
					// src is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcFi, dstCi);
				}
			} else if (connInfo.src instanceof ComponentInstance) {
				error(parentci.getSystemInstance(), "Connection source and destination are components: "
						+ connInfo.src.getInstanceObjectPath() + " => " + dstCi.getInstanceObjectPath());
			} else {
				error(parentci.getSystemInstance(), "Connection source is neither a feature nor a component: "
						+ connInfo.src.getInstanceObjectPath() + " => " + dstCi.getInstanceObjectPath());
			}
		}
	}

	protected ConnectionInstance addConnectionInstance(final SystemInstance systemInstance,
			final ConnectionInfo connInfo, final ConnectionInstanceEnd dstI) {
		// with aggregate data ports will be sources/destinations missing
		int numConns = connInfo.connections.size();
		if (connInfo.sources.size() != numConns || connInfo.destinations.size() != numConns) {
			// happens if conn leaves system to aggregate data port
			warning(connInfo.container, "Connection from " + connInfo.sources.get(0).getInstanceObjectPath() + " to "
					+ dstI.getInstanceObjectPath() + " could not be instantiated.");
			return null;
		}

		// check for duplicate connection instance
		// with arrays we can get duplicates that we don't need
		ComponentInstance container = connInfo.container;
		List<Connection> conns = connInfo.connections;

		if (container == null) {
			container = systemInstance;
		}
		for (ConnectionInstance test : container.getConnectionInstances()) {
			// check for duplicates and do not create
			if (connInfo.src == test.getSource() && dstI == test.getDestination()
					&& conns.size() == test.getConnectionReferences().size()) {
				ListIterator<Connection> i = conns.listIterator();
				boolean isDuplicate = true;
				for (ConnectionReference ref : test.getConnectionReferences()) {
					if (ref.getConnection() != i.next()) {
						isDuplicate = false;
						break;
					}
				}
				if (!isDuplicate) {
					// also test reverse direction
					isDuplicate = true;
					i = conns.listIterator(conns.size());
					for (ConnectionReference ref : test.getConnectionReferences()) {
						if (ref.getConnection() != i.previous()) {
							isDuplicate = false;
							break;
						}
					}
				}
				if (isDuplicate) {
					return null;
				}
			}
		}
		boolean duplicate = false;

		// Generate a name for the connection
		String containerPath = (connInfo.container != null) ? container.getInstanceObjectPath()
				: systemInstance.getName();
		int len = containerPath.length() + 1;
		String srcPath = connInfo.src.getInstanceObjectPath();
		StringBuffer sb = new StringBuffer();
		String dstPath = "xxx";
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		srcPath = srcPath.substring(i);
		sb.append(srcPath);
		sb.append(" -> ");
		if (dstI != null) {
			dstPath = dstI.getInstanceObjectPath();
			i = (dstPath.startsWith(containerPath)) ? len : 0;
			dstPath = dstPath.substring(i);
			sb.append(dstPath);
		}

		ConnectionInstance conni = null;
		if (!duplicate) {
			conni = connInfo.createConnectionInstance(sb.toString(), dstI);

			if (conni == null) {
				warning(container, "Connection sequence from " + srcPath + " to " + dstPath
						+ " is only outgoing. No connection instance created.");
				return null;
			} else {
				container.getConnectionInstances().add(conni);
			}

			fillInModes(conni);
			fillInModeTransitions(conni);
		}
		return conni;
	}

	private FeatureInstance getTopFeatureInstance(FeatureInstance fi) {
		FeatureInstance topfi = fi;
		while (topfi.getOwner() instanceof FeatureInstance) {
			topfi = (FeatureInstance) topfi.getOwner();
		}
		return topfi;
	}

	/**
	 * Handle the case where one of the ends (or both) is a feature group.
	 * Create multiple connection instances.
	 *
	 * @param parentci
	 * @param connInfo
	 * @param srcEnd
	 * @param dstEnd
	 */
	private void balanceFeatureGroupEnds(final ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd srcEnd, ConnectionInstanceEnd dstEnd) {

		if (!upFeature.isEmpty()) {
			// dstEnd is higher up in the hierarchy than srcEnd:
			// we need to match from latest to the oldest in stack going down into the FG nesting hierarchy
			for (int count = upFeature.size() - 1; count >= 0; count--) {
				FeatureInstance upFi = upFeature.get(count);
				EList<FeatureInstance> flist = ((FeatureInstance) dstEnd).getFeatureInstances();
				if (connInfo.dstToMatch != null) {
					String name = connInfo.dstToMatch.getConnectionEnd().getName();
					dstEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					connInfo.dstToMatch = connInfo.dstToMatch.getNext();
				} else {
					FeatureGroup upfg = (FeatureGroup) ((FeatureInstance) upFi.getOwner()).getFeature();
					FeatureGroup downfg = (FeatureGroup) ((FeatureInstance) dstEnd).getFeature();
					FeatureGroupType upfgt = upfg.getAllFeatureGroupType();
					FeatureGroupType downfgt = downfg.getAllFeatureGroupType();
					if (upfgt != null && downfgt != null && upfg.isInverseOf(downfg)
							&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
						dstEnd = flist.get(Aadl2InstanceUtil.getFeatureIndex(upFi));
					} else {
						String name = upFi.getName();
						srcEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					}
				}
			}
		} else if (!downFeature.isEmpty()) {
			// dstEnd is further down in the hierarchy than srcEnd: find feature corresponding to dstEnd
			// We need to match from the oldest to the latest in stack.
			// This is a down stack, i.e., the highest element got pushed first and is the oldest.
			for (int count = 0; count < downFeature.size(); count++) {
				FeatureInstance downFi = downFeature.get(count);
				EList<FeatureInstance> flist = ((FeatureInstance) srcEnd).getFeatureInstances();
				if (connInfo.srcToMatch != null) {
					String name = connInfo.srcToMatch.getConnectionEnd().getName();
					srcEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					connInfo.srcToMatch = connInfo.srcToMatch.getNext();
				} else {
					FeatureGroup downfg = ((FeatureGroup) ((FeatureInstance) downFi.getOwner()).getFeature());
					FeatureGroupType downfgt = downfg.getFeatureGroupType();
					FeatureGroup upfg = ((FeatureGroup) ((FeatureInstance) srcEnd).getFeature());
					FeatureGroupType upfgt = upfg.getFeatureGroupType();
					if (upfgt != null && downfgt != null && upfg.isInverseOf(downfg)
							&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
						srcEnd = flist.get(Aadl2InstanceUtil.getFeatureIndex(downFi));
					} else {
						String name = downFi.getName();
						srcEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					}
				}
			}
			connInfo.src = srcEnd;
		}

		if (srcEnd instanceof ComponentInstance && dstEnd instanceof ComponentInstance) {
			// TODO-LW: error
		} else if (srcEnd instanceof ComponentInstance || dstEnd instanceof ComponentInstance) {
			addConnectionInstance(parentci.getSystemInstance(), connInfo, dstEnd);
		} else {
			expandFeatureGroupConnection(parentci, connInfo, srcEnd, dstEnd, connInfo.srcToMatch, connInfo.dstToMatch);
		}
	}

	/**
	 * Expand feature groups as much as possible
	 *
	 * @param parentci
	 * @param connInfo
	 * @param srcEnd
	 * @param dstEnd
	 */
	private void expandFeatureGroupConnection(final ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd srcEnd, ConnectionInstanceEnd dstEnd, ConnectedElement srcToMatch,
			ConnectedElement dstToMatch) {
		ConnectionInstanceEnd oldSrc = connInfo.src;

		if (srcEnd instanceof FeatureInstance && dstEnd instanceof FeatureInstance) {
			FeatureInstance srcFi = (FeatureInstance) srcEnd;
			FeatureInstance dstFi = (FeatureInstance) dstEnd;

			if (srcToMatch != null) {
				for (FeatureInstance fi : srcFi.getFeatureInstances()) {
					if (srcToMatch.getConnectionEnd() == fi.getFeature()) {
						expandFeatureGroupConnection(parentci, connInfo, fi, dstFi, srcToMatch.getNext(), dstToMatch);
						break;
					}
				}
			} else if (dstToMatch != null) {
				for (FeatureInstance fi : dstFi.getFeatureInstances()) {
					if (dstToMatch.getConnectionEnd() == fi.getFeature()) {
						expandFeatureGroupConnection(parentci, connInfo, srcFi, fi, srcToMatch, dstToMatch.getNext());
						break;
					}
				}
			} else {
				/*
				 * One of three possible situations
				 * - both ends are feature groups without or with an empty type
				 * - one end is empty and the other is not
				 * - both ends are not empty, in this case they have the same internal structure
				 */
				if (isLeafFeature(srcFi) && isLeafFeature(dstFi)) {
					// both ends are empty
					if (connInfo.isAcross()) {
						if (srcFi.getFlowDirection().outgoing() && dstFi.getFlowDirection().incoming()) {
							connInfo.src = srcFi;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
						}
					} else {
						boolean upOnly = isUpOnly(connInfo, srcFi, dstFi);
						if (upOnly && srcFi.getFlowDirection().outgoing() && dstFi.getFlowDirection().outgoing()
								|| !upOnly && srcFi.getFlowDirection().incoming()
										&& dstFi.getFlowDirection().incoming()) {
							connInfo.src = srcFi;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
						}
					}
				} else if (isLeafFeature(srcFi)) {
					// first find the feature instance as an element of the other end
					FeatureInstance dst = findDestinationFeatureInstance(connInfo, dstFi);
					// we need to deal with outgoing/incoming only and check the direction correctly
					if (dst != null && ((connInfo.isAcross() && dst.getFlowDirection().incoming())
							|| dst.getFlowDirection().outgoing())) {
						expandFeatureGroupConnection(parentci, connInfo, srcFi, dst, srcToMatch, dstToMatch);
					} else if (srcFi.getCategory() == FeatureCategory.FEATURE_GROUP) {
						// we may have a feature group with no FGT or an empty FGT
						boolean upOnly = isUpOnly(connInfo, srcFi, dstFi);
						for (FeatureInstance dstelem : dstFi.getFeatureInstances()) {
							if (upOnly) {
								if (dstelem.getFlowDirection().outgoing()) {
									expandFeatureGroupConnection(parentci, connInfo, srcFi, dstelem, srcToMatch,
											dstToMatch);
								}
							} else if (dstelem.getFlowDirection().incoming()) {
								expandFeatureGroupConnection(parentci, connInfo, srcFi, dstelem, srcToMatch,
										dstToMatch);
							}
						}
					} else {
						// create the unexpanded connection instance
						connInfo.src = srcFi;
						addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
					}
				} else if (isLeafFeature(dstFi)) {
					FeatureInstance target = findSourceFeatureInstance(connInfo, srcFi);
					// we need to deal with outgoing/incoming only and check the direction correctly
					if (target != null && ((connInfo.isAcross() && target.getFlowDirection().outgoing())
							|| target.getFlowDirection().incoming())) {
						expandFeatureGroupConnection(parentci, connInfo, target, dstFi, srcToMatch, dstToMatch);
					} else if (dstFi.getCategory() == FeatureCategory.FEATURE_GROUP || connInfo.srcToMatch != null) {
						// we may have a feature group with no FGT or an empty FGT
						boolean downOnly = !connInfo.isAcross() && !isUpOnly(connInfo, srcFi, dstFi);
						for (FeatureInstance srcelem : srcFi.getFeatureInstances()) {
							if (downOnly) {
								if (srcelem.getFlowDirection().incoming()) {
									expandFeatureGroupConnection(parentci, connInfo, srcelem, dstFi, srcToMatch,
											dstToMatch);
								}
							} else if (srcelem.getFlowDirection().outgoing()) {
								expandFeatureGroupConnection(parentci, connInfo, srcelem, dstFi, srcToMatch,
										dstToMatch);
							}
						}
					} else {
						// create the unexpanded connection instance
						connInfo.src = srcFi;
						addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
					}
				} else {
					boolean isSubset = subsetMatch(connInfo.connections);
					if (!isSubset) {
						Iterator<FeatureInstance> srcIter = srcFi.getFeatureInstances().iterator();
						Iterator<FeatureInstance> dstIter = dstFi.getFeatureInstances().iterator();
						while (srcIter.hasNext() && dstIter.hasNext()) {
							FeatureInstance src = srcIter.next();
							FeatureInstance dst = dstIter.next();
							expandFeatureGroupConnection(parentci, connInfo, src, dst, srcToMatch, dstToMatch);
						}
						Assert.isTrue(!srcIter.hasNext() && !dstIter.hasNext(),
								"Connected feature groups do not have the same number of features");
					} else {
						// subset matching features by name
						for (FeatureInstance dst : dstFi.getFeatureInstances()) {
							if ((connInfo.isAcross() && dst.getFlowDirection().incoming())
									|| dst.getFlowDirection().outgoing()) {
								FeatureInstance src = findFeatureInstance(srcFi, dst.getName());
								if (src != null) {
									expandFeatureGroupConnection(parentci, connInfo, src, dst, srcToMatch, dstToMatch);
								}
							}
						}
					}
				}
			}
		}
		connInfo.src = oldSrc;

	}

	/**
	 * Does the connection go only up in the hierarchy?
	 * @param connInfo
	 * @param srcFi
	 * @param dstFi
	 * @param upOnly
	 * @return
	 */
	private boolean isUpOnly(ConnectionInfo connInfo, FeatureInstance srcFi, FeatureInstance dstFi) {
		if (!connInfo.isAcross()) {
			// if src contained in dst we're going up only
			ComponentInstance dstComponent = dstFi.getContainingComponentInstance();
			Element srcComponent = srcFi.getContainingComponentInstance();

			while (srcComponent != null) {
				if (srcComponent == dstComponent) {
					return true;
				}
				srcComponent = srcComponent.getOwner();
			}
		}
		return false;
	}

	/**
	 * find feature instance with matching name that is a leaf under fgfi
	 * @param fgfi
	 * @param name
	 * @return FeatureInstance
	 */
	FeatureInstance findFeatureInstance(FeatureInstance fgfi, String name) {
		TreeIterator<EObject> fiall = fgfi.eAllContents();
		while (fiall.hasNext()) {
			FeatureInstance fi = (FeatureInstance) fiall.next();
			if (isLeafFeature(fi) && fi.getName().equalsIgnoreCase(name)) {
				return fi;
			}
		}
		return null;

	}

	private boolean isLeafFeature(FeatureInstance fi) {
		return fi.getFeatureInstances().isEmpty();
	}

	/**
	 * Find the feature instance under FGI, whose name matches the the Feature at the other end
	 * We do this by finding the connection declaration that goes down at the other end
	 * It is found by matching the FGT name and then retrieving the feature instance matching the name
	 * @param connInfo
	 * @param fgi
	 * @return FeatureInstance
	 */

	FeatureInstance findSourceFeatureInstance(ConnectionInfo connInfo, FeatureInstance fgi) {
		List<ConnectionInstanceEnd> srclist = connInfo.sources;
		List<ConnectionInstanceEnd> dstlist = connInfo.destinations;
		ConnectionInstanceEnd target = null;
		for (int i = srclist.size() - 1; i >= 0; i--) {
			ConnectionInstanceEnd src = srclist.get(i);
			ConnectionInstanceEnd dst = dstlist.get(i);
			if (target != null && target != dst) {
				if (dst == target.eContainer()) {
					// we have a feature in a FG
					FeatureInstance targetFI = findFeatureInstance(fgi, target.getName());
					if (targetFI == null) {
						// name does not match. We may have an inverse of feature group type with its own set of feature names
						// In this case it is an index based match
						int idx = dst.eContents().indexOf(target);
						if (idx >= 0) {
							targetFI = fgi.getFeatureInstances().get(idx);
						}
					}
					return targetFI;
				} else {
					target = src;
				}
			} else {
				target = src;
			}
		}
		return null;

	}

	/**
	 * Find the feature instance under FGI, whose name matches the the Feature at the other end
	 * We do this by finding the connection declaration that goes down at the other end
	 * It is found by matching the FGT name and then retrieving the feature instance matching the name
	 * @param connInfo
	 * @param fgi
	 * @return FeatureInstance
	 */
	FeatureInstance findDestinationFeatureInstance(ConnectionInfo connInfo, FeatureInstance fgi) {
		List<ConnectionInstanceEnd> srclist = connInfo.sources;
		List<ConnectionInstanceEnd> dstlist = connInfo.destinations;
		ConnectionInstanceEnd target = null;
		for (int i = 0; i < srclist.size(); i++) {
			ConnectionInstanceEnd src = srclist.get(i);
			ConnectionInstanceEnd dst = dstlist.get(i);
			if (target != null && target != src) {
				if (src == target.eContainer()) {
					// we have a feature in a FG
					FeatureInstance targetFI = findFeatureInstance(fgi, target.getName());
					if (targetFI == null) {
						// name does not match. We may have an inverse of feature group type with its own set of feature names
						// In this case it is an index based match
						int idx = dst.eContents().indexOf(target);
						if (idx >= 0) {
							targetFI = fgi.getFeatureInstances().get(idx);
						}
					}
					return targetFI;
				} else {
					target = dst;
				}
			} else {
				target = dst;
			}
		}
		return null;

	}

	// ------------------------------------------------------------------------
	// Methods related to mode transition connections
	// ------------------------------------------------------------------------

	/**
	 * handles the situation that a mode transition may name an event port in a
	 * thread (or other leaf component instance) and that port is not the
	 * destination of a connection instance - it is the start of a connection
	 * instance
	 *
	 * @param ci
	 *            ComponentInstance
	 * @param fi
	 *            FeatureInstance
	 * @return true if we created a ModetransitionInstance
	 */
	private boolean doModeTransitionConnections(ComponentInstance ci, FeatureInstance fi) {
		boolean didTransition = false;
		if (fi.getCategory() == FeatureCategory.EVENT_PORT) {
			Subcomponent sub = ci.getSubcomponent();
			Feature f = fi.getFeature();

			for (ModeTransitionInstance mti : ci.getContainingComponentInstance().getModeTransitionInstances()) {
				for (ModeTransitionTrigger trigger : mti.getModeTransition().getOwnedTriggers()) {
					TriggerPort tp = trigger.getTriggerPort();
					if (tp instanceof Port) {
						Port p = (Port) tp;
						Context c = trigger.getContext();

						if (f == p && c == sub) {
							addConnectionInstance(ci.getSystemInstance(), ConnectionInfo.newModeTransition(fi), mti);
							didTransition = true;
						}
					} else {
						// TODO-LW: what if it's a processor port or internal
						// event?
					}
				}
			}
		}
		return didTransition;
	}

	/**
	 * As we are following connection declarations we need to check whether the
	 * destination of the connection is named in one of the mode transitions of
	 * the component instance that is the destination of the connection being
	 * added
	 *
	 * @param parentci
	 *            The component that is the context in which the connections are
	 *            declared
	 * @param pci
	 *            PortConnectionInstance that is being created
	 * @param conn
	 *            connection being added to the ConnectionInstance
	 * @return true if we created a ModetransitionInstance
	 */
	private boolean doModeTransitionConnections(final ComponentInstance parentci, ConnectionInfo connInfo,
			Connection conn) {
		boolean didTransition = false;
		if (!(conn instanceof PortConnection || conn instanceof FeatureGroupConnection)) {
			return false;
		}
		ComponentInstance parent = null;
		Context fc = conn.getAllDestinationContext();
		Element connContext = null;
		if (fc instanceof ComponentImplementation || fc instanceof FeatureGroup) { // we
			// have
			// an
			// outgoing
			// connection
			parent = (ComponentInstance) parentci.eContainer();
			connContext = parentci.getSubcomponent();
		} else if (fc instanceof Subcomponent) {
			parent = parentci.findSubcomponentInstance((Subcomponent) fc);
			connContext = ((Subcomponent) fc).getAllClassifier();
		}
		if (parent == null) {
			return false;
		}
		EList<ModeTransitionInstance> mtl = parent.getModeTransitionInstances();
		Feature f = (Feature) conn.getAllDestination();
		for (ModeTransitionInstance mti : mtl) {
			ModeTransition mt = mti.getModeTransition();
			Context co = null;
			for (ModeTransitionTrigger trigger : mt.getOwnedTriggers()) {
				TriggerPort tp = trigger.getTriggerPort();
				if (tp instanceof Port) {
					Port o = (Port) tp;
					co = trigger.getContext();
					NamedElement context = co;
					if (context instanceof FeatureGroup) {
						context = parent.getSubcomponent().getAllClassifier();
					}
					if (f == o && context == connContext) {
						final ConnectionInstance mtci = addConnectionInstance(parentci.getSystemInstance(),
								connInfo.convertToModeTransition(), mti);
						fillInModes(mtci);
						fillInModeTransitions(mtci);
						didTransition = true;
					}
				} else {
					// TODO-LW: what if it's a processor port or internal event?
				}
			}
		}
		return didTransition;
	}

	// ------------------------------------------------------------------------
	// Helper methods related to modes
	// ------------------------------------------------------------------------

	private void fillInModeTransitions(ConnectionInstance conni) {
		ComponentInstance ci = conni.getContainingComponentInstance();

		for (ConnectionReference connRef : conni.getConnectionReferences()) {
			Connection conn = connRef.getConnection();

			for (ModeTransition mt : conn.getAllInModeTransitions()) {
				ModeTransitionInstance mti = ci.findModeTransitionInstance(mt);

				if (mti != null) {
					conni.getInModeTransitions().add(mti);
				}
			}
		}
	}

	/**
	 * For the given connection instance, identify all connection declarations
	 * with "in modes." For all possible mode combinations of those "in modes,"
	 * add those SOMs that contain the mode instance combinations.
	 *
	 * @param conni
	 *            the connection instance
	 */
	private void fillInModes(ConnectionInstance conni) {
		ListIterator<ConnectionReference> refIter = conni.getConnectionReferences().listIterator();

		while (refIter.hasNext()) {
			ConnectionReference connRef = refIter.next();
			Connection conn = connRef.getConnection();
			ComponentInstance ci = connRef.getContext();
			EList<Mode> connModes = conn.getAllInModes();
			EList<ModeInstance> mis = null;

			if (connModes.isEmpty()) {
				while (!(ci instanceof SystemInstance)) {
					if (ci.getInModes().isEmpty()) {
						ci = ci.getContainingComponentInstance();
					} else {
						mis = ci.getInModes();
						break;
					}
				}
			} else {
				mis = new BasicEList<ModeInstance>();
				for (Mode m : connModes) {
					mis.add(ci.findModeInstance(m));
				}
			}
			if (mis != null) {
				for (ModeInstance mi : mis) {
					generateModeCombinations(conni, refIter,
							new BasicEList<ModeInstance>(Collections.singletonList(mi)));
				}
				if (conni.getInSystemOperationModes().isEmpty()) {
					warning(conni.getContainingComponentInstance(), "Connection " + conni.getName()
							+ " was removed because it is not active in any system operation mode");
					EcoreUtil.delete(conni);
				}
				break;
			}
		}
	}

	/*
	 *
	 * @param conni Connection Instance
	 *
	 * @param mis the set of mode instances of modal connection declarations in
	 * the connection instance that make up a mode configuration; the complete
	 * set must be contained in the SOMs to be added to the connection instance
	 *
	 * @param cmodes the set of modes in the inmodes declaration of the
	 * conenction declaration with index idx in the list of connection
	 * declarations that make up the connection instance
	 *
	 * @param idx the index of the connection declaration in the connection
	 * instance whose mode set is being processed
	 */
	private void generateModeCombinations(ConnectionInstance conni, ListIterator<ConnectionReference> refIter,
			List<ModeInstance> mis) {
		if (!refIter.hasNext()) {
			// add SOMs based on mis
			SystemInstance si = (SystemInstance) conni.getElementRoot();
			List<SystemOperationMode> somList = si.getSystemOperationModesFor(mis);

			// check if all parts of the connection exist
			outer: for (SystemOperationMode som : somList) {
				if (conni.getSource().isActive(som) && conni.getDestination().isActive(som)) {
					for (ConnectionReference cr : conni.getConnectionReferences()) {
						if (!cr.getContext().isActive(som)) {
							continue outer;
						}
					}
					conni.getInSystemOperationModes().add(som);
				}
			}
		} else {
			ConnectionReference connRef = refIter.next();
			Connection conn = connRef.getConnection();
			ComponentInstance ci = connRef.getContext();
			EList<Mode> connModes = conn.getAllInModes();
			List<ModeInstance> nextMis = null;

			if (connModes.isEmpty()) {
				while (!(ci instanceof SystemInstance)) {
					if (ci.getInModes().isEmpty()) {
						ci = ci.getContainingComponentInstance();
					} else {
						nextMis = ci.getInModes();
						break;
					}
				}
			} else {
				nextMis = new BasicEList<ModeInstance>();
				for (Mode m : connModes) {
					nextMis.add(ci.findModeInstance(m));
				}
			}
			if (nextMis != null) {
				for (ModeInstance mi : nextMis) {
					mis.add(mi);
					generateModeCombinations(conni, refIter, mis);
					mis.remove(mi);
				}
			} else {
				generateModeCombinations(conni, refIter, mis);
			}
			refIter.previous();
		}
	}

	// ------------------------------------------------------------------------
	// Helper methods for filtering connection lists
	// ------------------------------------------------------------------------

	/**
	 * Filter all (port or access) connections that start with a subcomponent.
	 *
	 * @param connlist
	 *            all connections in the component instance that contains the
	 *            subcomponent
	 * @param sub
	 *            a subcomponent
	 * @return the connections from connlist that start with the subcomponent
	 */
	protected List<Connection> filterStartingConnections(List<Connection> connlist, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>(connlist.size());
		EList<Subcomponent> sublist = sub.getAllSubcomponentRefinements();
		for (Connection conn : connlist) {
			if (sublist.contains(conn.getAllSource())
					|| (conn.isAllBidirectional() && sublist.contains(conn.getAllDestination()))) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Filter connections that leave a subcomponent through one of its features.
	 *
	 * @param connlist
	 *            all connections in the component instance that contains the
	 *            subcomponent
	 * @param sub
	 *            a subcomponent
	 * @return those connections from connlist that go out of the subcomponent
	 */
	private List<Connection> filterOutgoingConnections(List<Connection> connlist, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>();
		List<Subcomponent> subs = sub.getAllSubcomponentRefinements();

		for (Connection conn : connlist) {
			if (subs.contains(conn.getAllSourceContext())
					|| conn.isAllBidirectional() && subs.contains(conn.getAllDestinationContext())) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * get ingoing connections for specified feature
	 *
	 * @param incomingconnlist
	 * @param feature
	 *            subcomponent feature that is the source of a connection
	 * @return connections with feature as destination
	 */
	public List<Connection> filterIngoingConnections(SystemInstance si, List<Connection> incomingconnlist,
			FeatureInstance fi) {
		List<Connection> result = new ArrayList<Connection>(incomingconnlist.size());
		List<Feature> features = fi.getFeature().getAllFeatureRefinements();
		List<Feature> parents;

		for (Connection conn : incomingconnlist) {
			ConnectionEnd srcEnd = conn.getAllSource();

			// a candidate end is a feature of the component or in a feature group
			// then the feature must match the passed-in feature instance
			if (srcEnd instanceof Feature) {
				Context srcCtx = conn.getAllSourceContext();
				if (srcCtx == null && features.contains(srcEnd)) {
					result.add(conn);
				} else if (srcCtx instanceof FeatureGroup && features.contains(srcEnd)) {
					parents = ((FeatureInstance) fi.getOwner()).getFeature().getAllFeatureRefinements();
					if (parents.contains(srcCtx)) {
						result.add(conn);
					}
				}
			}
			if (conn.isAllBidirectional()) {
				ConnectionEnd dstEnd = conn.getAllDestination();
				// check other end
				if (dstEnd instanceof Feature) {
					Context dstCtx = conn.getAllDestinationContext();
					if (dstCtx == null && features.contains(dstEnd)) {
						result.add(conn);
					} else if (dstCtx instanceof FeatureGroup && features.contains(dstEnd)) {
						parents = ((FeatureInstance) fi.getOwner()).getFeature().getAllFeatureRefinements();
						if (parents.contains(dstCtx)) {
							result.add(conn);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Get outgoing connections for specified feature port group connections are
	 * non-directional, i.e., they are always added
	 *
	 * @param conns
	 *            a list of connections that go away from a subcomponent
	 * @param feature
	 *            subcomponent feature that can be the source of a connection
	 * @return connections with feature as source for ConnectionInstances
	 */
	public List<Connection> filterOutgoingConnections(List<Connection> conns, Feature feature) {
		List<Connection> result = new ArrayList<Connection>(conns.size());
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			if (features.contains(conn.getAllSource())
					|| conn.isAllBidirectional() && features.contains(conn.getAllDestination())) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Get outgoing connections for specified feature port group connections are
	 * non-directional, i.e., they are always added
	 *
	 * @param conns
	 *            a list of connections that go away from a subcomponent
	 * @param feature
	 *            subcomponent feature that can be the source of a connection
	 * @return connections with feature as source for ConnectionInstances
	 */
	public List<Connection> filterOutgoingConnections(List<Connection> conns, Feature feature, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>(conns.size());
		List<Feature> features = feature.getAllFeatureRefinements();
		EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
		for (Connection conn : conns) {
			if ((features.contains(conn.getAllSource()) && subs.contains(conn.getAllSourceContext()))
					|| (conn.isAllBidirectional() && features.contains(conn.getAllDestination())
							&& subs.contains(conn.getAllDestinationContext()))) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Check if one of the connections in a list points to a feature.
	 *
	 * @param conns
	 *            a list of connections owned by a subcomponent
	 * @param feature
	 *            a subcomponent feature
	 * @return whether one of the connections points to the feature
	 */
	public boolean isDestination(List<Connection> conns, Feature feature) {
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			// ignore parameter connections
			if (!(conn instanceof ParameterConnection)) {
				if (features.contains(conn.getAllDestination())
						|| conn.isAllBidirectional() && features.contains(conn.getAllSource())) {
					return true;
				}
				if ((features.contains(conn.getAllDestinationContext())
						|| conn.isAllBidirectional() && features.contains(conn.getAllSourceContext()))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check if one of the connections in a list has a feature as its end.
	 *
	 * @param conns
	 *            a list of connections owned by a subcomponent
	 * @param feature
	 *            a subcomponent feature
	 * @return whether the feature is an end of one of the connections
	 */
	public boolean isConnectionEnd(List<Connection> conns, Feature feature) {
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			// ignore parameter connections
			if (!(conn instanceof ParameterConnection)) {
				if (features.contains(conn.getAllDestination()) || features.contains(conn.getAllSource())) {
					return true;
				}
				if ((features.contains(conn.getAllDestinationContext())
						|| features.contains(conn.getAllSourceContext()))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean isConnectionEndingComponent(final Context ctx) {
		if (ctx instanceof Subcomponent) {
			return isConnectionEndingCategory(((Subcomponent) ctx).getCategory());
		} else {
			return false;
		}
	}

	private boolean isConnectionEndingCategory(final ComponentCategory cat) {
		return cat == THREAD || cat == DEVICE || cat == PROCESSOR || cat == VIRTUAL_PROCESSOR;
	}

	private boolean isSubsetMatch(Connection conn) {
		Property property = Aadl2GlobalScopeUtil.get(conn, Aadl2Package.eINSTANCE.getProperty(),
				"Modeling_Properties::Classifier_Matching_Rule");
		try {
			PropertyExpression value = conn.getSimplePropertyValue(property);
			EnumerationLiteral enumLit = (EnumerationLiteral) ((NamedValue) value).getNamedValue();
			return enumLit.getName().equalsIgnoreCase("subset");
		} catch (PropertyNotPresentException e) {
			return false;
		}
	}

	boolean subsetMatch(List<Connection> conns) {
		boolean isSubset = false; // find it in connection declaration
		for (Connection connection : conns) {
			isSubset = isSubset || isSubsetMatch(connection);
		}
		return isSubset;
	}

}
