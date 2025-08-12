/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.reachability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.analysis.modes.modemodel.FeatureKey;
import org.osate.analysis.modes.modemodel.SOMGraph;
import org.osate.analysis.modes.modemodel.SOMNode;
import org.osate.analysis.modes.modemodel.Trigger;
import org.osate.analysis.modes.modemodel.TriggerKey;
import org.osate.result.Result;

public class ModeDomain {

	static List<ModeDomain> domains = new ArrayList<>();

	static Set<ModeDomain> toAnalyze = new HashSet<>();

	// Cross domain connections to trigger connection in analysis
	// initialized in first run of analyzer
	private static Map<ConnectionInstance, ConnectionInstance> conn2tc = new HashMap<>();

	private static Map<ConnectionInstance, ModeDomain> tc2d = new HashMap<>();

	ComponentInstance root;

	// Cross domain connections originating in this mode domain
	Set<ConnectionInstance> originatingConnections = new HashSet<>();

	SOMGraph graph;

	Map<TriggerKey, Trigger> triggers = new HashMap<>();

	/** Container for trigger connections */
	private ComponentInstance tcHolder;

	private Resource graphs;

	private Set<ConnectionInstance> enabledTCs = new HashSet<>();

	private ModeDomainAnalyzer analyzer;

	boolean needsAnalysis = true;

	static void clearData() {
		domains.clear();
		toAnalyze.clear();
		conn2tc.clear();
		tc2d.clear();
	}

	static void cleanResource() {
		for (var d : domains) {
			if (d.tcHolder != null) {
				d.root.eResource().getContents().remove(d.tcHolder);
			}
		}
	}

	public ModeDomain(ComponentInstance root, Resource graphs) {
		this.root = root;
		this.graphs = graphs;
		domains.add(this);
		toAnalyze.add(this);

		// create dummy component to hold trigger connections
		tcHolder = InstanceFactory.eINSTANCE.createComponentInstance();
		root.eResource().getContents().add(tcHolder);

		// populate triggers and create trigger connections
		populateTriggers(root);
	}

	ComponentInstance getRoot() {
		return root;
	}

	public ModeDomainAnalyzer getAnalyzer() {
		return analyzer;
	}

	public Result analyze(ReachabilityConfiguration config, SubMonitor split) {
		if (Objects.nonNull(graph)) {
			EcoreUtil.remove(graph);
		}
		graph = new SOMGraph();
		graph.getTriggers().putAll(triggers);
		graphs.getContents().add(graph);
		analyzer = new ModeDomainAnalyzer(this, config);
		var result = analyzer.analyze(split);
		updateEnabled();
		return result;
	}

	void recordConnection(ConnectionInstance conn) {
		conn2tc.put(conn, null);
	}

	void updateMapping(ConnectionInstance conn, ConnectionInstance tc) {
		conn2tc.replace(conn, tc);
		tc2d.put(tc, this);
		if (!isCrossDomain(conn)) {
			enabledTCs.add(tc);
		}
	}

	boolean isEnabledIfExternal(ConnectionInstance tc) {
		return !conn2tc.containsValue(tc) || enabledTCs.contains(tc);
	}

	private void updateEnabled() {
		for (var conn : originatingConnections) {
			var tc = conn2tc.get(conn);
			var d = tc2d.get(tc);
			if (!d.enabledTCs.contains(tc) && canBeEnabled(conn)) {
				d.enabledTCs.add(tc);
				toAnalyze.add(d);
			}
		}
	}

	private boolean canBeEnabled(ConnectionInstance conn) {
		// Is there a SOM in d where the ultimate source and all segments (in d) are active?
		var crs = conn.getConnectionReferences();

		for (var n : analyzer.getLastLevel().getNodes()) {
			var crIter = crs.listIterator(crs.size());
			var cr = crIter.previous();
			while (cr.getContext() != root) {
				cr = crIter.previous();
			}
			crIter.next();
			// crIter.previous() is topmost segment in mode domain
			if (checkSOM(n, crIter, conn.getSource().getContainingComponentInstance())) {
				return true;
			}
		}
		return false;
	}

	// return true iff trigger is enabled in som identified by node
	private boolean checkSOM(SOMNode n, ListIterator<ConnectionReference> crIter, ComponentInstance ci) {
		if (Objects.isNull(n)) {
			return true;
		}
		if (!checkSOM(n.getParent(), crIter, ci)) {
			return false;
		}
		if (crIter.hasPrevious()) {
			var cr = crIter.previous();
			if (cr.getContext() == n.getLevel().getComponent()) {
				if (!isActive(n, cr.getConnection())) {
					return false;
				}
			} else {
				crIter.next();
			}
		} else {
			if (ci == n.getLevel().getComponent()) {
				return n.isActive();
			}
		}
		return true;
	}

	// check if a connection segment is active
	private boolean isActive(SOMNode n, Connection conn) {
		if (!n.isActive()) {
			return false;
		}
		if (conn.getInModes().isEmpty()) {
			return true;
		}
		var mode = n.getMode().getMode();
		if (!conn.getInModes().contains(mode)) {
			return false;
		}
		return true;
	}

	private boolean isCrossDomain(ConnectionInstance conn) {
		for (var d : domains) {
			if (d == this) {
				continue;
			}
			if (d.root != conn.getSource().getContainingComponentInstance()
					&& EcoreUtil.isAncestor(d.root, conn.getSource())) {
				d.originatingConnections.add(conn);
				return true;
			}
		}
		return false;
	}

	/**
	 * Add mode transition triggers to the SOM graph and create trigger connections
	 * that connect the triggers to the transitions. The connections are added to a
	 * synthetic component at the root level of the instance model.
	 * @param root - the system instance
	 */
	private void populateTriggers(ComponentInstance root) {

		var visitor = new InstanceSwitch<Boolean>() {

			@Override
			public Boolean caseComponentInstance(ComponentInstance ci) {
				return false;
			}

			@Override
			public Boolean caseModeTransitionInstance(ModeTransitionInstance mt) {
				for (var f : mt.getTriggers()) {
					Iterator<ConnectionReference> crIter = CrossReferenceUtil.getInverse(
							InstancePackage.eINSTANCE.getConnectionReference_Destination(), f, f.eResource());
					if (f.getContainingComponentInstance() == mt.getContainingComponentInstance()) {
						// triggered from outside
						if (f.getContainingComponentInstance() instanceof SystemInstance) {
							// f is a feature of the system instance that triggers a
							// mode transition in the system instance itself
							addTrigger(f);
							addTriggerConnection(f, mt);
						}
					} else {
						// triggered from inside
						if (!crIter.hasNext()) {
							// f is subcomponent feature that is not connected inside the subcomponent
							addTrigger(f);
							addTriggerConnection(f, mt);
						}
					}
					while (crIter.hasNext()) {
						// trigger comes via a connection
						var cr = crIter.next();
						var conn = (ConnectionInstance) cr.getOwner();
						addTrigger(conn.getSource());
						addTriggerConnection(conn, cr, mt);
					}
				}
				return true;
			}

			@Override
			public Boolean defaultCase(EObject object) {
				return true;
			}

			/**
			 * Create a trigger in the SOM graph
			 * @param f - the trigger in the instance model
			 */
			private void addTrigger(ConnectionInstanceEnd f) {
				Assert.isTrue(f instanceof FeatureInstance, "connection doesn't start with feature");
				var tk = new FeatureKey((FeatureInstance) f);
				triggers.putIfAbsent(tk, tk.getTrigger());
			}

			/**
			 * Create a trigger connection from a connection instance.
			 * Record if conn comes from another mode domain.
			 * @param conn - the connection in the instance model
			 * @param last - the last segment in the trigger connection
			 * @param mt - the triggered mode transition
			 */
			private void addTriggerConnection(ConnectionInstance conn, ConnectionReference last,
					ModeTransitionInstance mt) {
				var crs = new ArrayList<ConnectionReference>();
				int tcLen = 0;
				boolean external = false;

				if (!EcoreUtil.isAncestor(root, conn)) {
					recordConnection(conn);
					external = true;
				}
				for (var cr : conn.getConnectionReferences()) {
					if (external) {
						if (cr.getContext() == root) {
							external = false;
						} else {
							// skip connection references outside the current mode domain
							continue;
						}
					}
					crs.add(cr);
					tcLen += 1;
					if (cr == last) {
						break;
					}
				}
				// check for duplicate of existing trigger connection
				// XXX: when could this happen?
				for (var tc : tcHolder.getConnectionInstances()) {
					if (tc.getSource() == conn.getSource() && tc.getDestination() == mt
							&& tc.getConnectionReferences().size() == tcLen) {
						int i = 0;
						while (i < tcLen) {
							var cr0 = tc.getConnectionReferences().get(i);
							var cr1 = crs.get(i);

							if (cr0.getContext() == cr1.getContext() && cr0.getConnection() == cr1.getConnection()) {
								i++;
							}
						}
						if (i >= tcLen) {
							// duplicate, don't create again
							updateMapping(conn, tc);
							return;
						}
					}
				}
				var tc = InstanceFactory.eINSTANCE.createConnectionInstance();
				tc.setKind(ConnectionKind.MODE_TRANSITION_CONNECTION);
				tc.setSource(conn.getSource());
				tc.setDestination(mt);
				boolean modal = false;
				for (var cr : crs) {
					var r = InstanceFactory.eINSTANCE.createConnectionReference();
					r.setContext(cr.getContext());
					r.setConnection(cr.getConnection());
					tc.getConnectionReferences().add(r);
					modal = modal || !cr.getConnection().getAllInModes().isEmpty();
				}
				tcHolder.getConnectionInstances().add(tc);
				updateMapping(conn, tc);
			}

			/**
			 * Create a trigger connection without connection instance.
			 * @param f - the triggering feature
			 * @param mt - the triggered mode transition
			 */
			private void addTriggerConnection(FeatureInstance f, ModeTransitionInstance mt) {
				for (var c : tcHolder.getConnectionInstances()) {
					if (c.getSource() == f && c.getDestination() == mt && c.getConnectionReferences().isEmpty()) {
						return;
					}
				}
				var tc = InstanceFactory.eINSTANCE.createConnectionInstance();
				tc.setSource(f);
				tc.setDestination(mt);
				tcHolder.getConnectionInstances().add(tc);
			}

		};

		for (var iter = EcoreUtil.<EObject> getAllContents(root, true); iter.hasNext();) {
			var eo = iter.next();
			if (visitor.doSwitch(eo)) {
				iter.prune();
			}
		}
	}

}
