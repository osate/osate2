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

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.osate.aadl2.contrib.thread.ResumptionPolicy;
import org.osate.aadl2.contrib.thread.ThreadProperties;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.analysis.modes.modemodel.ActiveNode;
import org.osate.analysis.modes.modemodel.FeatureKey;
import org.osate.analysis.modes.modemodel.FeatureTrigger;
import org.osate.analysis.modes.modemodel.InactiveNode;
import org.osate.analysis.modes.modemodel.SOMGraph;
import org.osate.analysis.modes.modemodel.SOMLevel;
import org.osate.analysis.modes.modemodel.SOMNode;
import org.osate.analysis.modes.modemodel.Transition;
import org.osate.analysis.modes.modemodel.Trigger;
import org.osate.analysis.modes.modemodel.TriggerKey;
import org.osate.pluginsupport.properties.CodeGenUtil;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;

//TODO: internal feature as trigger
//TODO: processor feature as trigger
//TODO: ??? subprogram as trigger

public final class ModeDomainAnalyzer {

	private static final boolean DEBUG = true;

	private ReachabilityConfiguration config = ReachabilityConfiguration.DEFAULT;

	private ModeDomain md;

	private SOMGraph graph;

	private SOMLevel lastLevel;

	/** Map component instances to the corresponding level in the SOM graph */
	private Map<ComponentInstance, SOMLevel> ci2sl = new HashMap<>();

	private Result result;

	private SubMonitor progress;

	/**
	 * Create a reachability analyzer with default configuration
	 */
	public ModeDomainAnalyzer(ModeDomain md) {
		this.md = md;
	}

	/**
	 * Create a reachability analyzer.
	 * @param config - the reporting configuration
	 */
	public ModeDomainAnalyzer(ModeDomain md, ReachabilityConfiguration config) {
		this(md);
		this.config = config;
	}

	public Result analyze() {
		return analyze(new NullProgressMonitor());
	}

	public Result analyze(IProgressMonitor monitor) {
		ComponentInstance root = md.root;
		graph = md.graph;
		int[] ciCount = { 0 };

		if (!(IProgressMonitor.nullSafe(monitor) instanceof NullProgressMonitor)) {
			root.eAllContents().forEachRemaining((eo) -> {
				if (eo instanceof ComponentInstance) {
					ciCount[0]++;
				}
			});
		}

		this.progress = SubMonitor.convert(monitor, ciCount[0] + 1);

		try {
			result = ResultUtil.createResult("SOM Reachability Analysis", root);
			createSOMGraph(root);
			result.setResultType(ResultType.SUCCESS);
		} catch (OperationCanceledException oce) {
			var r = ResultUtil.createInfoDiagnostic("canceled", root);
			result.getDiagnostics().add(r);
			result.setResultType(ResultType.TBD);
		} catch (Exception e) {
			result.setResultType(ResultType.FAILURE);
			throw e;
		}

		return result;
	}

//	public IStatus writeReports(ComponentInstance root) {
//		List<IStatus> sts = new ArrayList<>();
//
//		Assert.isNotNull(graph, "SOM graph is null");
//
//		try {
//			if (config.saveModel()) {
//				try {
//					graph.eResource().save(null);
//				} catch (IOException e) {
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write model file: " + e.getMessage(), e));
//				}
//			}
//			if (config.generateDot()) {
//				try {
//					var uri = new DotExporter(graph).writeFile();
//					var r = ResultUtil.createSuccessResult("DOT file URI", root);
//					ResultUtil.addStringValue(r, uri.toString());
//					result.getSubResults().add(r);
//				} catch (IOException e) {
//					var r = ResultUtil.createErrorDiagnostic("Could not write DOT file: " + e.getMessage(), root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write DOT file: " + e.getMessage(), e));
//				}
//			} else {
//				try {
//					new DotExporter(graph).delete();
//				} catch (IOException e) {
//					var r = ResultUtil.createWarningDiagnostic("Could not delete existing DOT file: " + e.getMessage(),
//							root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not delete existing DOT file: " + e.getMessage(), e));
//				}
//			}
//			if (config.generateHTML()) {
//				try {
//					var uri = new HtmlExporter(graph).writeFile();
//					var r = ResultUtil.createSuccessResult("HTML file URI", root);
//					ResultUtil.addStringValue(r, uri.toString());
//					result.getSubResults().add(r);
//				} catch (IOException e) {
//					var r = ResultUtil.createErrorDiagnostic("Could not write HTML file: " + e.getMessage(), root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write HTML file: " + e.getMessage(), e));
//				}
//			} else {
//				try {
//					new HtmlExporter(graph).delete();
//				} catch (IOException e) {
//					var r = ResultUtil.createWarningDiagnostic("Could not delete existing HTML file: " + e.getMessage(),
//							root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not delete existing HTML file: " + e.getMessage(), e));
//				}
//			}
//			if (config.generateSMV()) {
//				try {
//					var uri = new SmvExporter(graph).writeFile();
//					var r = ResultUtil.createSuccessResult("SMV file URI", root);
//					ResultUtil.addStringValue(r, uri.toString());
//					result.getSubResults().add(r);
//				} catch (IOException e) {
//					var r = ResultUtil.createErrorDiagnostic("Could not write SMV file: " + e.getMessage(), root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not write SMV file: " + e.getMessage(), e));
//				}
//			} else {
//				try {
//					new SmvExporter(graph).delete();
//				} catch (IOException e) {
//					var r = ResultUtil.createWarningDiagnostic("Could not delete existing SMV file: " + e.getMessage(),
//							root);
//					result.getDiagnostics().add(r);
//					sts.add(new Status(IStatus.ERROR, ModeAnalysisPlugin.ID, IStatus.ERROR,
//							"Could not delete existing SMV file: " + e.getMessage(), e));
//				}
//			}
//
//			if (sts.isEmpty()) {
//				return new Status(IStatus.OK, ModeAnalysisPlugin.ID, "");
//			} else {
//				var status = new MultiStatus(ModeAnalysisPlugin.ID, IStatus.ERROR, sts.toArray(new IStatus[] {}), null,
//						null);
//				return status;
//			}
//		} catch (OperationCanceledException oce) {
//			var r = ResultUtil.createInfoDiagnostic("Cancelled by user", root);
//			result.getDiagnostics().add(r);
//			return new Status(IStatus.CANCEL, ModeAnalysisPlugin.ID,
//					"The SOM reachability analysis was cancelled by the user");
//		}
//	}

	/**
	 * Fill the SOM graph data for an instance model
	 * @param root - the system instance
	 */
	private void createSOMGraph(ComponentInstance root) {
		progress.split(1);

		// fill first level
		populateRootLevel(root);

		// process remaining components
		root.getComponentInstances().stream().forEach(this::processComponent);

		removeDominatedTransitions();
	}

	/**
	 * Process component instances depth-first, pre-order
	 * @param c - the current component instance
	 */
	private void processComponent(ComponentInstance c) {
		populateNextLevel(c);
		progress.split(1);

		c.getComponentInstances().stream().forEach(this::processComponent);
	}

	/**
	 * Add modes and transitions for the root component
	 * @param root
	 */
	private void populateRootLevel(ComponentInstance root) {
		var newLevel = createSOMLevel(root);
		var nodes = newLevel.getNodes();
		var transitions = newLevel.getTransitions();
		SOMNode initial = null;

		if (root.getModeInstances().isEmpty()) {
			// system instance has no modes
			var n = new ActiveNode();
			initial = n;
			nodes.add(n);
		} else {
			// system instance has modes
			var somNodes = new HashMap<ModeInstance, SOMNode>();
			for (var m : root.getModeInstances()) {
				var n = createActiveNode(m);
				nodes.add(n);
				if (m.isInitial()) {
					Assert.isTrue(isNull(initial), "initial already set");
					initial = n;
				}
				somNodes.put(m, n);
			}
			for (var mt : root.getModeTransitionInstances()) {
				for (var tc : mt.getDstConnectionInstances()) {
					if (md.isEnabledIfExternal(tc)) {
						var s = somNodes.get(mt.getSource());
						var d = somNodes.get(mt.getDestination());
						var end = tc.getSource();
						var tk = new FeatureKey((FeatureInstance) end);
						var tg = graph.getTriggers().get(tk);
						var t = createTransition(s, d, tg, tc);
						transitions.add(t);
					}
				}
			}
		}

		// mark reachable som nodes in new level
		Objects.requireNonNull(initial);
		newLevel.setInitialNode(initial);
		checkReachability(initial);
		cleanUp(newLevel);

		if (DEBUG) {
			validate(newLevel);
		}
		lastLevel = newLevel;
	}

	/**
	 * Add modes of current component to the SOMGraph.
	 *
	 * @param c
	 */
	private void populateNextLevel(ComponentInstance c) {
		var newLevel = createSOMLevel(c);

		populateNodes(newLevel, c);
		populateTransitions(newLevel, c);

		checkReachability(newLevel.getInitialNode());
		cleanUp(newLevel);

		lastLevel = newLevel;
	}

	/**
	 * Extend the SOMs with modes of the next component.
	 * @param level - the new level
	 * @param c - the component to process
	 */
	private void populateNodes(SOMLevel level, ComponentInstance c) {
		var nodes = level.getNodes();
		SOMNode initial = null;

		for (var pn : lastLevel.getNodes()) {
			if (!pn.isReachable()) {
				continue;
			}
			// ci active in current partial SOM?
			var active = isActive(c, pn);
			var modes = c.getModeInstances();
			if (modes.isEmpty()) {
				// component has no modes
				// create one node for c
				var n = active ? createActiveNode(pn) : createInactiveNode(c, pn);
				nodes.add(n);
				if (pn == lastLevel.getInitialNode()) {
					Assert.isTrue(isNull(initial), "initial already set");
					initial = n;
				}
			} else if (modes.get(0).isDerived()) {
				// component has derived modes
				if (active) {
					// find the derived mode for the current SOM (if any)
					// create at most one active node for c
					for (var m : modes) {
						Assert.isTrue(active);
						var pm = getContainerMode(c, pn);
						if (m.getParents().contains(pm)) {
							var n = createActiveNode(m, pn);
							n.setDerived(true);
							level.getNodes().add(n);
							if (pn == lastLevel.getInitialNode() && pm.isInitial()) {
								Assert.isTrue(isNull(initial), "initial already set");
								initial = n;
							}
							break;
						}
					}
				} else {
					// create one inactive node for c
					var n = createInactiveNode(c, pn);
					n.setDerived(true);
					nodes.add(n);
					var pm = getContainerMode(c, pn);
					if (pn == lastLevel.getInitialNode() && pm.isInitial()) {
						Assert.isTrue(isNull(initial), "initial already set");
						initial = n;
					}
				}
			} else {
				// component has regular modes
				// create one node per mode
				for (var m : modes) {
					var n = active ? createActiveNode(m, pn) : createInactiveNode(m, pn);
					nodes.add(n);
					if (pn == lastLevel.getInitialNode() && m.isInitial()) {
						Assert.isTrue(isNull(initial), "initial already set");
						initial = n;
					}
				}
			}
		}
		Objects.requireNonNull(initial);
		level.setInitialNode(initial);
	}

	/**
	 * Add transitions on the level for the new component.
	 * @param level - the new level
	 * @param c - the component instance to process
	 */
	void populateTransitions(SOMLevel level, ComponentInstance c) {
		var transitions = level.getTransitions();

		for (var pn : lastLevel.getNodes()) {
			// source nodes to which the transition may not be propagated
			Map<Transition, Set<SOMNode>> skip = new HashMap<>();
			Set<TriggerKey> ptks = pn.getOutTransitions()
					.stream()
					.map(tn -> tn.getTrigger().getKey())
					.collect(Collectors.toCollection(HashSet::new));

			for (var ptn : pn.getOutTransitions()) {
				skip.put(ptn, new HashSet<SOMNode>());
			}
			if (pn.getChildren().get(0).isActive()) {
				// new component is active before transition
				for (var mt : c.getModeTransitionInstances()) {
					for (var tc : mt.getDstConnectionInstances()) {
						var tk = new FeatureKey((FeatureInstance) tc.getSource());
						var tg = graph.getTriggers().get(tk);

						if (ptks.contains(tk)) {
							for (var ptn : pn.getOutTransitions()) {
								var d = ptn.getDst().getChildren().get(0);

								if (d.isActive() && ptn.getTrigger().equals(tg)) {
									// c is active before and after transition
									// => merge old and new transitions
									mergeTransition(ptn, mt, tg, tc, transitions);

									if (!isModal(tc)) {
										// ptn is dominated by the merged transition
										skip.get(ptn).add(findChildNode(pn, mt.getSource()));
									}
								}
							}
						} else {
							// add transitions for trigger that occurs on the new level
							// but not on the previous level
							addTransition(pn, mt, tg, tc, transitions);
						}
					}
				}
			}

			// propagate transitions for triggers from the previous level
			for (var ptn : pn.getOutTransitions()) {
				propagateTransition(ptn, c, transitions, skip);
			}
		}
	}

	/**
	 * Remove all outgoing transitions on the last level that are dominated by another transition
	 *
	 * A transition tn is dominated by another transition otn if they have the same trigger
	 * and otn requires more active connections than tn.
	 */
	private void removeDominatedTransitions() {
		var toRemove = new ArrayList<Transition>();

		for (var n : lastLevel.getNodes()) {
			var byTrigger = n.getOutTransitions().stream().collect(Collectors.groupingBy(Transition::getTrigger));

			for (var tns : byTrigger.values()) {
				if (tns.size() > 1) {
					tns.stream()
							.filter(tn -> tns.stream()
									.anyMatch(
											otn -> otn != tn && otn.getConnections().containsAll(tn.getConnections())))
							.forEach(tn -> toRemove.add(tn));
				}
			}
		}
		for (var tn : toRemove) {
			tn.getSrc().getOutTransitions().remove(tn);
			tn.getDst().getInTransitions().remove(tn);
			tn.getTrigger().getTransitions().remove(tn);
			lastLevel.getTransitions().remove(tn);
		}

		// maybe an SOM is now unreachable
		lastLevel.getNodes().stream().forEach(n -> n.setReachable(false));
		checkReachability(lastLevel.getInitialNode());
		cleanUp(lastLevel);
	}

	/**
	 * Propagate old transition to new level except for nodes where the propagated transition
	 * is known to be dominated by an existing transition.
	 * @param ptn - the transition to propagate
	 * @param c - the current component
	 * @param transitions - the list of transitions on the new level
	 * @param skip - child nodes for which to skip the propagation
	 */
	private void propagateTransition(Transition ptn, ComponentInstance c, List<Transition> transitions,
			Map<Transition, Set<SOMNode>> skip) {
		var psn = ptn.getSrc();
		var pdn = ptn.getDst();
		var sn = psn.getChildren().get(0);
		var dn = pdn.getChildren().get(0);

		Assert.isTrue(psn.getChildren().size() == pdn.getChildren().size());
		if (sn.isActive() && !dn.isActive()) {
			// deactivating, need to interpret policy
			var policy = getResumptionPolicy(c);
			for (int i = 0; i < psn.getChildren().size(); i++) {
				var s = psn.getChildren().get(i);
				if (!skip.get(ptn).contains(s) && isTransitionActive(s, ptn)) {
					SOMNode d;
					if (s.hasMode() && policy.get(s.getMode()) == ResumptionPolicy.RESTART) {
						d = findChildNode(pdn, getInitialMode(c));
					} else {
						d = pdn.getChildren().get(i);
					}
					var tn = createTransition(s, d, ptn);
					transitions.add(tn);
				}
			}
		} else {
			for (int i = 0; i < psn.getChildren().size(); i++) {
				var s = psn.getChildren().get(i);
				if (!skip.get(ptn).contains(s) && isTransitionActive(s, ptn)) {
					var d = pdn.getChildren().get(i);
					var tn = createTransition(s, d, ptn);
					transitions.add(tn);
				}
			}
		}
	}

	/**
	 * Add a transition to the new level based on a triggered a mode transition.
	 * @param pn - the parent SOM node
	 * @param mt - the mode transition
	 * @param tg - the trigger
	 * @param tc - the trigger connection
	 * @param transitions - the list of transitions on the current lager
	 */
	private void addTransition(SOMNode pn, ModeTransitionInstance mt, Trigger tg, ConnectionInstance tc,
			List<Transition> transitions) {
		if (!(tg instanceof FeatureTrigger)) {
			return;
		}
		SOMNode sn = findChildNode(pn, mt.getSource());
		Assert.isNotNull(sn, "no node for source");
		if (sn.isActive() && isTriggerActive(sn, tg, tc)) {
			SOMNode dn = findChildNode(pn, mt.getDestination());
			Assert.isNotNull(dn, "no node for destination");
			Assert.isTrue(dn.isActive(), "dst not active");
			var tn = createTransition(sn, dn, tg, tc);
			transitions.add(tn);
		}
	}

	/**
	 * Merge a new transition and a parent transition if they are triggered by the same event.
	 * @param ptn - the parent transition
	 * @param mt - the mode transition
	 * @param tg - the trigger
	 * @param tc - the trigger connections
	 * @param transitions - the list of transitions on the current lager
	 */
	private void mergeTransition(Transition ptn, ModeTransitionInstance mt, Trigger tg, ConnectionInstance tc,
			List<Transition> transitions) {
		if (!(tg instanceof FeatureTrigger)) {
			return;
		}
		SOMNode psn = ptn.getSrc();
		SOMNode pdn = ptn.getDst();
		SOMNode sn = findChildNode(psn, mt.getSource());
		Assert.isNotNull(sn, "no node for source");
		Assert.isTrue(sn.isActive(), "trying to merge with inactive source");
		if (isTriggerActive(sn, tg, tc)) {
			SOMNode dn = findChildNode(pdn, mt.getDestination());
			Assert.isNotNull(dn, "no node for destination");
			Assert.isTrue(dn.isActive(), "trying to merge with inactive destination");
			var tn = createTransition(sn, dn, tg, tc);
			tn.getConnections().addAll(ptn.getConnections());
			transitions.add(tn);
		}
	}

	/**
	 * Check if a trigger is active.
	 *
	 * A trigger is active if the originating component is active and
	 * the connection that transports the trigger is active.
	 * @param n - the current SOM, tg is assumed to be active in parent SOM
	 * @param tg - the trigger to check
	 * @param tc - the connection via which the trigger enters the component, may be null
	 * @return whether the trigger is active in the current SOM
	 */
	private boolean isTriggerActive(SOMNode n, Trigger tg, ConnectionInstance tc) {
		if (n.getInactiveComponents().contains(tg.getComponent())) {
			return false;
		}
		return isNull(tc) || (!n.getInactiveConnections().contains(tc) && md.isEnabledIfExternal(tc));
	}

	/**
	 * Check if a transition is active.
	 *
	 * A transition is active if the originating component is active and
	 * all connections that transport triggers needed for this transition are active.
	 *
	 * @param n - the current SOM
	 * @param tn - the transition to check
	 * @return whether the transition is active in the current SOM
	 */
	private boolean isTransitionActive(SOMNode n, Transition tn) {
		Trigger tg = tn.getTrigger();
		if (n.getInactiveComponents().contains(tg.getComponent())) {
			return false;
		}
		var inactiveConns = n.getInactiveConnections();
		return tn.getConnections().stream().noneMatch(tc -> inactiveConns.contains(tc) || !md.isEnabledIfExternal(tc));
	}

	/**
	 * Check which nodes in the current level are reachable.
	 * @param from
	 */
	private void checkReachability(SOMNode from) {
		from.setReachable(true);
		for (var t : from.getOutTransitions()) {
			var d = t.getDst();
			if (!d.isReachable()) {
				checkReachability(d);
			}
		}
	}

	/**
	 * Validate level invariants
	 * <li>
	 * <ul>no two transitions between som nodes refer to the same trigger and the same connection reference</ul>
	 * </li>
	 *
	 * @param level
	 * @return
	 */
	private void validate(SOMLevel level) {
		for (var s : level.getNodes()) {
			var d2tns = new HashMap<SOMNode, List<Transition>>();
			for (var tn : s.getOutTransitions()) {
				var tns = d2tns.putIfAbsent(tn.getDst(), new ArrayList<>());
				if (tns != null) {
					tns.add(tn);
				}
			}
//			var tg2cr = new HashMap<Trigger, ConnectionReference>();
//			for (var tns : d2tns.values()) {
//				for (var t : tns) {
//					// FIXME:
//					var cr = tg2cr.putIfAbsent(t.getTrigger(), t.getConnRef());
//					Assert.isTrue(isNull(cr));
//				}
//			}
		}
	}

	/**
	 * Delete unreachable nodes and transitions between unreachable nodes.
	 * @param level - the level to clean up
	 */
	private void cleanUp(SOMLevel level) {
		var tns = (level.getTransitions()).stream()//
				.filter(tr -> !tr.getSrc().isReachable())
				.map(tr -> {
					// clean up bidi cross references
					tr.setSrc(null);
					tr.setDst(null);
					tr.setTrigger(null);
					return tr;
				})
				.toList();
		level.getTransitions().removeAll(tns);

		var ns = (level.getNodes()).stream().filter(n -> !n.isReachable()).toList();
		level.getNodes().removeAll(ns);
	}

	/**
	 * Check if a component is active in the current SOM.
	 *
	 * This requires that the modes for the containing component have already
	 * been entered into the graph.
	 *
	 * @param ci - the component instance to check
	 * @param n - the current leaf SOM node
	 * @return whether the component is active in the current SOM
	 */
	private boolean isActive(ComponentInstance ci, SOMNode n) {
		var pci = (ComponentInstance) ci.eContainer();
		var pl = getSOMLevel(pci);
		var pn = n;
		while (pn.eContainer() != pl) {
			pn = pn.getParent();
		}
		// pn is the som node for the containing component in the current som ending with n
		Assert.isNotNull(pn);
		// ci is active if the container is active and if ci is active in the current mode of the container
		return pn.isActive() && (ci.getInModes().isEmpty() || ci.getInModes().contains(pn.getMode()));
	}

	/**
	 * Get the containing component's mode in the current SOM.
	 *
	 * This requires that the modes for the containing component have already
	 * been entered into the graph.
	 *
	 * @param ci - the component instance to check
	 * @param n - the current leaf som node
	 * @return the mode of the component containing ci, null if no mode
	 */
	private ModeInstance getContainerMode(ComponentInstance ci, SOMNode n) {
		var pci = (ComponentInstance) ci.eContainer();
		var pl = getSOMLevel(pci);
		var pn = n;
		while (pn.eContainer() != pl) {
			pn = pn.getParent();
		}
		// pn is the som node for the containing component in the current som ending with n
		Assert.isNotNull(pn);
		return pn.getMode();
	}

	/**
	 * Create a new SOM level for a given component and add it to the SOM graph.
	 *
	 * @param c - the component associated with the new level
	 * @return the new SOM level
	 */
	private SOMLevel createSOMLevel(ComponentInstance c) {
		var newLevel = new SOMLevel();

		newLevel.setComponent(c);
		ci2sl.put(c, newLevel);
		graph.getLevels().add(newLevel);
		return newLevel;
	}

	/**
	 * Get the SOM level for a component
	 * @param c - the component
	 * @return the level for the given component
	 */
	private SOMLevel getSOMLevel(ComponentInstance c) {
		return ci2sl.get(c);
	}

	/**
	 * Create an active SOM node.
	 * @param m - the mode for which to create the node
	 * @return the new node
	 */
	private ActiveNode createActiveNode(ModeInstance m) {
		return createActiveNode(m, null);
	}

	/**
	 * Create a node for an active component without modes
	 *
	 * Inactive components and connections are the same as for the parent
	 * @param pn - the parent node
	 * @return the new node
	 */
	private ActiveNode createActiveNode(SOMNode pn) {
		var n = new ActiveNode(pn);
		var iconns = n.getInactiveConnections();

		iconns.addAll(pn.getInactiveConnections());
		return n;
	}

	/**
	 * Create a node for an active component in a mode.
	 *
	 * Inactive components are the same as for the parent, but
	 * there may be additional inactive connections.
	 * @param m - the mode for the new node
	 * @param pn - the parent node
	 * @return the new active node
	 */
	private ActiveNode createActiveNode(ModeInstance m, SOMNode pn) {
		var n = new ActiveNode(m, pn);
		var iconns = n.getInactiveConnections();

		if (pn != null) {
			iconns.addAll(pn.getInactiveConnections());
		}

		var c = m.getComponentInstance();
		var crIter = CrossReferenceUtil.getInverse(InstancePackage.eINSTANCE.getConnectionReference_Context(), c,
				c.eResource());
		while (crIter.hasNext()) {
			var cr = (ConnectionReference) crIter.next();
			var conn = (ConnectionInstance) cr.getOwner();
			if (conn.getKind() == ConnectionKind.MODE_TRANSITION_CONNECTION) {
				var ims = cr.getConnection().getAllInModes();
				if (!ims.isEmpty() && !ims.contains(m.getMode())) {
					iconns.add(conn);
				}
			}
		}
		return n;
	}

	/**
	 * Create a node for an inactive component without modes.
	 * @param c - the component
	 * @param pn - the parent node
	 * @return the new inactive node
	 */
	private InactiveNode createInactiveNode(ComponentInstance c, SOMNode pn) {
		var n = new InactiveNode(pn);

		fillInactiveNode(n, c, pn);
		return n;
	}

	/**
	 * Create a node for an inactive component.
	 * @param m - the mode after resumption
	 * @param pn - the parent node
	 * @return the new inactive node
	 */
	private InactiveNode createInactiveNode(ModeInstance m, SOMNode pn) {
		var c = m.getComponentInstance();
		var n = new InactiveNode(m, pn);

		fillInactiveNode(n, c, pn);
		return n;
	}

	/**
	 * Store the inactive components and connections for a new inactive node.
	 * @param n - the new node
	 * @param c - the component
	 * @param pn - the parent node
	 */
	private void fillInactiveNode(InactiveNode n, ComponentInstance c, SOMNode pn) {
		var ics = n.getInactiveComponents();

		ics.addAll(pn.getInactiveComponents());
		ics.add(c);

		var iconns = n.getInactiveConnections();
		iconns.addAll(pn.getInactiveConnections());

		var crIter = CrossReferenceUtil.getInverse(InstancePackage.eINSTANCE.getConnectionReference_Context(), c,
				c.eResource());
		while (crIter.hasNext()) {
			var cr = (ConnectionReference) crIter.next();
			var conn = (ConnectionInstance) cr.getOwner();
			if (conn.getKind() == ConnectionKind.MODE_TRANSITION_CONNECTION) {
				iconns.add(conn);
			}
		}
	}

	/**
	 * Create a transition.
	 * @param sn - the source SOM node of the new transition
	 * @param dn - the destination SOM node of the new transition
	 * @param tg - the trigger of the new transition
	 * @param tc - the trigger connection
	 * @return the new transition
	 */
	private Transition createTransition(SOMNode sn, SOMNode dn, Trigger tg, ConnectionInstance tc) {
		var tn = new Transition();

		tn.setSrc(sn);
		tn.setDst(dn);
		tn.setTrigger(tg);
		if (tc != null) {
			tn.getConnections().add(tc);
		}
		return tn;
	}

	/**
	 * Create a transition based on a parent transition.
	 * @param src - the source SOM node of the new transition
	 * @param dst - the destination SOM node of the new transition
	 * @param ptn - the parent transition
	 * @return the new transition
	 */
	private Transition createTransition(SOMNode src, SOMNode dst, Transition ptn) {
		var t = new Transition();

		t.setSrc(src);
		t.setDst(dst);
		t.setTrigger(ptn.getTrigger());
		t.getConnections().addAll(ptn.getConnections());
		return t;
	}

	/**
	 * Get the initial mode of a component.
	 * @param c - the component
	 * @return the initial mode of this component; null if the component has no modes.
	 */
	private ModeInstance getInitialMode(ComponentInstance c) {
		for (var m : c.getModeInstances()) {
			if (m.isInitial()) {
				return m;
			}
		}
		return null;
	}

	/**
	 * Get the child of a given SOM node for a specific mode.
	 * @param pn - the parent node
	 * @param m - the mode
	 * @return the child node for the mode
	 */
	private SOMNode findChildNode(SOMNode pn, ModeInstance m) {
		if (pn.getChildren().size() == 1) {
			return pn.getChildren().get(0);
		}
		for (var n : pn.getChildren()) {
			if (n.getMode() == m) {
				return n;
			}
		}
		return null;
	}

	/**
	 * Get the resumption policy of a component.
	 * @param c - the component
	 * @return a map containing the resumption policy value for each component mode
	 */
	private Map<ModeInstance, ResumptionPolicy> getResumptionPolicy(ComponentInstance c) {
		if (c.getModeInstances().isEmpty()) {
			return Collections.emptyMap();
		}

		Map<ModeInstance, ResumptionPolicy> m2policy = new HashMap<>();
		ResumptionPolicy policy = ResumptionPolicy.RESTART;
		try {
			// try to get non modal value
			var nmv = ThreadProperties.getResumptionPolicy(c);
			if (nmv.isPresent()) {
				policy = nmv.get();
			}
			m2policy = new HashMap<>();
			for (var m : c.getModeInstances()) {
				m2policy.put(m, policy);
			}
		} catch (PropertyIsModalException e) {
			// get modal property value
			var p = ThreadProperties.getResumptionPolicy_Property(c);
			var ipa = c.getOwnedPropertyAssociations().stream().filter(pa -> pa.getProperty() == p).findFirst();
			Assert.isTrue(ipa.isPresent());
			var dpa = ((PropertyAssociationInstance) ipa.get()).getPropertyAssociation();
			int i;
			for (i = 0; i < dpa.getOwnedValues().size(); i++) {
				var mpv = dpa.getOwnedValues().get(i);
				for (var m : mpv.getInModes()) {
					for (var mi : c.getModeInstances()) {
						if (mi.getMode() == m) {
							var pe = mpv.getOwnedValue();
							pe = CodeGenUtil.resolveNamedValue(pe);
							m2policy.put(mi, ResumptionPolicy.valueOf(pe));
							break;
						}
					}
				}
			}
			var mpv = dpa.getOwnedValues().get(i - 1);
			if (mpv.getInModes().isEmpty()) {
				var pe = mpv.getOwnedValue();
				pe = CodeGenUtil.resolveNamedValue(pe);
				policy = ResumptionPolicy.valueOf(pe);
				m2policy = new DefaultedHashMap<ModeInstance, ResumptionPolicy>(policy, m2policy);
			}
		}
		return m2policy;
	}

	public void setConfiguration(ReachabilityConfiguration config) {
		this.config = config;
	}

	public ReachabilityConfiguration getConfiguration() {
		return config;
	}

	/**
	 * @return the config
	 */
	public ReachabilityConfiguration getConfig() {
		return config;
	}

	/**
	 * @param config the config to set
	 */
	public void setConfig(ReachabilityConfiguration config) {
		this.config = config;
	}

	/**
	 * @return the graph
	 */
	public SOMGraph getGraph() {
		return graph;
	}

	/**
	 * @return the lastLevel
	 */
	public SOMLevel getLastLevel() {
		return lastLevel;
	}

	/** Cache if a trigger connection is modal */
	private Map<ConnectionInstance, Boolean> _tcModal = new HashMap<>();

	/**
	 * Determine if a trigger connection is modal, i.e., a segment has an in modes clause.
	 *
	 * The result is cached.
	 *
	 * @param tc
	 * @return
	 */
	private boolean isModal(ConnectionInstance tc) {
		if (_tcModal.containsKey(tc)) {
			return _tcModal.get(tc);
		}
		boolean modal = false;
		for (var cr : tc.getConnectionReferences()) {
			if (!cr.getConnection().getAllInModes().isEmpty()) {
				modal = true;
				break;
			}
		}
		_tcModal.put(tc, modal);
		return modal;
	}
}
