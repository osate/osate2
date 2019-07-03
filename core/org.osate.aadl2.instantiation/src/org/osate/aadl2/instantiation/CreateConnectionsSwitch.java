/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * $Id: CreateConnectionsSwitch.java,v 1.21 2010-06-14 01:21:51 lwrage Exp $
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ParameterImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
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
import org.osate.aadl2.modelsupport.util.AadlUtil;
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
		FeatureInstance prevFi = null;
		for (FeatureInstance featurei : ci.getFeatureInstances()) {
			if (prevFi == null || !prevFi.getName().equalsIgnoreCase(featurei.getName())) {
				Feature feature = featurei.getFeature();
				// TODO warning if subcomponents with outgoing features
				// exist
				if (AadlUtil.hasOutgoingFeatures(featurei)) {
					List<Connection> outgoingConns = filterOutgoingConnections(outsideSubConns, feature, sub);
					boolean connectedInside = false;
					boolean destinationFromInside = false;

					// warn if there's an incomplete connection
					if (hasOutgoingFeatureSubcomponents
							&& ((cat != THREAD && cat != PROCESSOR && cat != DEVICE && cat != VIRTUAL_PROCESSOR)
									// in case of a provides bus access we want to
									// start from the bus.
									|| ((cat == PROCESSOR || cat == DEVICE || cat == ComponentCategory.MEMORY)
											&& feature instanceof BusAccess
											&& ((BusAccess) feature).getKind() == AccessType.PROVIDES))) {
						connectedInside = isConnectionEnd(insideSubConns, feature);
						destinationFromInside = isDestination(insideSubConns, feature);
					}

					// first see if mode transitions are triggered by a
					// doModeTransitionConnections(ci, featurei);

					for (Connection conn : outgoingConns) {
						// conn is first segment if it can't continue inside
						// the subcomponent
						if (!(destinationFromInside || conn.isAllBidirectional() && connectedInside)) {
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
		if (featurei.getDirection().incoming()) {
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
				? ci.findSubcomponentInstance((Subcomponent) toCtx) : null;
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
		 * Fix JD bug #222
		 */
		if ((toEnd instanceof DataAccess) && (toEnd.getContainingClassifier() != null)
				&& (toEnd.getContainingClassifier() instanceof SubprogramType)) {
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
					? ci.findSubcomponentInstance((Subcomponent) fromCtx) : null;
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

				if (toEnd instanceof Parameter || finalComponent && !(toEnd instanceof FeatureGroup)) {
					// connection ends at a parameter or at a simple feature of a
					// thread, device, or (virtual) processor
					FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
					if (dstFi == null) {
						error(toCi,
								"Destination feature " + toFeature.getName() + " not found. No connection created.");
					} else {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, dstFi);
					}
				} else if (finalComponent && toEnd instanceof FeatureGroup) {
					// connection ends at a feature that is contained in a feature
					// group
					// of a thread, device, or (virtual) processor
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
						List<Connection> conns = filterOutgoingConnections(parentConns, toFeature,
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
						List<Connection> conns = AadlUtil.getIngoingConnections(toImpl, toFeature);

						if (conns.isEmpty()) {
							List<Subcomponent> subs = toImpl.getAllSubcomponents();

							if (!subs.isEmpty()) {
								if (!isValidFinalComponent(toCtx)) {
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
							if ((toImpl instanceof ProcessorImplementation || toImpl instanceof DeviceImplementation
									|| toImpl instanceof MemoryImplementation)
									&& !(toEnd instanceof BusAccess
											&& ((BusAccess) toEnd).getKind() == AccessType.PROVIDES)) {
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
			// the next lines determine whether a connection is bi-directional
			// and set a flag rather than creating a second connection instance
			if (connInfo.src == test.getDestination() && dstI == test.getSource()
					&& test.getKind() == ConnectionKind.ACCESS_CONNECTION) {
				test.setBidirectional(true);
				test.setName(test.getName().replace("->", "<->"));
				return test;
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
						if (srcFi.getDirection().outgoing() && dstFi.getDirection().incoming()) {
							connInfo.src = srcFi;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
						}
					} else {
						boolean upOnly = isUpOnly(connInfo, srcFi, dstFi);
						if (upOnly && srcFi.getDirection().outgoing() && dstFi.getDirection().outgoing()
								|| !upOnly && srcFi.getDirection().incoming() && dstFi.getDirection().incoming()) {
							connInfo.src = srcFi;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
						}
					}
				} else if (isLeafFeature(srcFi)) {
					// first find the feature instance as an element of the other end
					FeatureInstance dst = findDestinationFeatureInstance(connInfo, dstFi);
					// we need to deal with outgoing/incoming only and check the direction correctly
					if (dst != null && ((connInfo.isAcross() && dst.getDirection().incoming())
							|| dst.getDirection().outgoing())) {
						expandFeatureGroupConnection(parentci, connInfo, srcFi, dst, srcToMatch, dstToMatch);
					} else if (srcFi.getCategory() == FeatureCategory.FEATURE_GROUP) {
						// we may have a feature group with no FGT or an empty FGT
						boolean upOnly = isUpOnly(connInfo, srcFi, dstFi);
						for (FeatureInstance dstelem : dstFi.getFeatureInstances()) {
							if (upOnly) {
								if (dstelem.getDirection().outgoing()) {
									expandFeatureGroupConnection(parentci, connInfo, srcFi, dstelem, srcToMatch,
											dstToMatch);
								}
							} else if (dstelem.getDirection().incoming()) {
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
					if (target != null && ((connInfo.isAcross() && target.getDirection().outgoing())
							|| target.getDirection().incoming())) {
						expandFeatureGroupConnection(parentci, connInfo, target, dstFi, srcToMatch, dstToMatch);
					} else if (dstFi.getCategory() == FeatureCategory.FEATURE_GROUP || connInfo.srcToMatch != null) {
						// we may have a feature group with no FGT or an empty FGT
						boolean downOnly = !connInfo.isAcross() && !isUpOnly(connInfo, srcFi, dstFi);
						for (FeatureInstance srcelem : srcFi.getFeatureInstances()) {
							if (downOnly) {
								if (srcelem.getDirection().incoming()) {
									expandFeatureGroupConnection(parentci, connInfo, srcelem, dstFi, srcToMatch,
											dstToMatch);
								}
							} else if (srcelem.getDirection().outgoing()) {
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
							if ((connInfo.isAcross() && dst.getDirection().incoming())
									|| dst.getDirection().outgoing()) {
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
			// DB: We also need to consider refined features
			final Set<ConnectionEnd> refinedFeatures = new HashSet<ConnectionEnd>();
			final ConnectionEnd conEnd = conn.getAllSource();

			if (conEnd instanceof Feature) {
				refinedFeatures.addAll(((Feature) conEnd).getAllFeatureRefinements());
			}

			for (final ConnectionEnd refFeat : refinedFeatures) {
				if ((features.contains(refFeat) && subs.contains(conn.getAllSourceContext()))
						|| (conn.isAllBidirectional() && features.contains(conn.getAllDestination())
								&& subs.contains(conn.getAllDestinationContext()))) {
					result.add(conn);

					break; // DB
				}
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
			if (features.contains(conn.getAllDestination())
					|| conn.isAllBidirectional() && features.contains(conn.getAllSource())) {
				return true;
			}
			if ((features.contains(conn.getAllDestinationContext())
					|| conn.isAllBidirectional() && features.contains(conn.getAllSourceContext()))) {
				return true;
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
			if (features.contains(conn.getAllDestination()) || features.contains(conn.getAllSource())) {
				return true;
			}
			if ((features.contains(conn.getAllDestinationContext()) || features.contains(conn.getAllSourceContext()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean isConnectionEndingComponent(final Context ctx) {
		return ctx instanceof ThreadSubcomponent || ctx instanceof DeviceSubcomponent;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean isValidFinalComponent(final Context ctx) {
		return ctx instanceof ThreadSubcomponent || ctx instanceof DeviceSubcomponent
				|| ctx instanceof ProcessorSubcomponent || ctx instanceof VirtualProcessorSubcomponent;
	}

	private boolean isSubsetMatch(Connection conn) {
		EList<PropertyExpression> vals = conn.getPropertyValues("Modeling_Properties", "Classifier_Matching_Rule");
		for (PropertyExpression val : vals) {
			EnumerationLiteral enumLit = (EnumerationLiteral) ((NamedValue) val).getNamedValue();
			if (enumLit.getName().equalsIgnoreCase("subset")) {
				return true;
			}
		}
		return false;
	}

	boolean subsetMatch(List<Connection> conns) {
		boolean isSubset = false; // find it in connection declaration
		for (Connection connection : conns) {
			isSubset = isSubset || isSubsetMatch(connection);
		}
		return isSubset;
	}

}
