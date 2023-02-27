/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.slicer;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.BiconnectivityInspector;
import org.jgrapht.alg.shortestpath.BFSShortestPath;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.graph.GraphWalk;
import org.jgrapht.graph.MaskSubgraph;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.instance.util.EMV2InstanceSwitch;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.slicer.UnusedElementDetector.AssumptionCheckResult;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

// TODO: Find a way to mark this unstable / discourage use, look into marking "internal" so you get non-API warnings

/**
 *
 * This API provides functionality for building the graph needed for slicing AADL models, as well as performing the slices.
 *
 * @author sprocter
 *
 */
public class SlicerRepresentation {
	/**
	 * The primary graph. All other graphs are subgraphs of this one.
	 */
	private final Graph<OsateSlicerVertex, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

	/**
	 * A reversed-direction version of the main graph.
	 */
//	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new DefaultDirectedGraph<>(DefaultEdge.class);
	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new EdgeReversedGraph<>(g);

	/**
	 * Maps vertex names to their objects
	 */
	private final Map<String, OsateSlicerVertex> vertexMap = new HashMap<>();

	/**
	 * Maps a container name to the set of input features it has
	 */
	private Map<String, Set<String>> inFeats = new HashMap<>();

	/**
	 * Maps a container name to the set of output features it has
	 */
	private Map<String, Set<String>> outFeats = new HashMap<>();

	/**
	 * Stores container names which have explicit decompositions provided by the modeler
	 */
	private Set<String> hasExplicitDecomp = new HashSet<>();

	/**
	 * Stores propagation declarations which may or may not reflect actual propagations.
	 * Actual propagations will be calculated using this + explicit sources, sinks, and
	 * flow paths in the {@link #calculateFixpoint()} method
	 */
	private Map<String, Collection<PossiblePropagation>> possiblePropagations = new HashMap<>();

	/**
	 * Results of checking various assumptions about the graph
	 */
	private AssumptionCheckResult acr;

	public enum ErrorStateValidity {
		VALID, INVALID, ALL
	};

	public record IObjErrorPair(InstanceObject iobj, Optional<TypeTokenInstance> token) {
	};

	public void buildGraph(SystemInstance si) {
		// Add vertices and explicit edges from core AADL
		SlicerSwitch coreSwitch = new SlicerSwitch();
		EcoreUtil.getAllContents(si, true).forEachRemaining(elem -> {
			coreSwitch.doSwitch((Element) elem);
		});

		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
		// Add vertices and edges from EMV2 instance
		Emv2SlicerSwitch emv2Switch = new Emv2SlicerSwitch();
		var visitedElems = new HashSet<Element>();
		EcoreUtil.getAllContents(si, true).forEachRemaining(elem -> {
			visitedElems.add((Element) elem);
			emv2Switch.doSwitch((Element) elem);
		});

		// Propagate error tokens / connect explicit propagations
		calculateFixpoint();

		// Add implicit edges
		buildIntraConnections(hasExplicitDecomp);

		// Create a separate reversed graph, rather than a wrapper, saving CPU at the expense of memory
//		Graphs.addGraphReversed(rg, g);

		// Run checks on the generated graph to see if there are any obvious problems / assumption violations
		checkAssumptions();
//		System.out.println(this.toDot(g));
//		reachThrough(g, "WBS_inst_Instance.ctrl_sys.bscu.channel1.elec_pedal_pos_R",
//				"WBS_inst_Instance.ctrl_sys.bscu.channel1.monitor_sys.bscu_validity",
//				"WBS_inst_Instance.ctrl_sys.bscu.channel1.monitor_sys.elec_pedal_pos_R", true);
//		reachThrough(g, "WBS_inst_Instance.phys_sys.ground_speed",
//				"WBS_inst_Instance.phys_sys.wheel_brake3.normal_hyd_piston.force_out",
//				"WBS_inst_Instance.ctrl_sys.bscu.switch_gate_brake_as_cmd_pair_3_7.cmd_out", true);
//		reachThrough(g, "WBS_inst_Instance.phys_sys.ground_speed",
//				"WBS_inst_Instance.ctrl_sys.bscu.switch_gate_brake_as_cmd_pair_3_7.cmd_out",
//				"WBS_inst_Instance.phys_sys.wheel_brake3.normal_hyd_piston.force_out", true);
	}

	/**
	 * Initiates assumption checks. All results are put into the AssumptionCheckResult field.
	 */
	private void checkAssumptions() {
		UnusedElementDetector ued = new UnusedElementDetector(g, rg);
		this.acr = ued.checkAssumptions();
	}

	/**
	 * Given a propagation and a token, this will get the associated vertex in the graph (creating it if it doesn't
	 * exist, retrieving it if it does) and return its name.
	 *
	 * @param prop The propagation
	 * @param tti The error token
	 * @return The vertex's name
	 */
	private String getVertex(ErrorPropagationInstance prop, TypeTokenInstance ttinstance) {
		OsateSlicerVertex v = null;
		Optional<TypeTokenInstance> tti = Optional.of(ttinstance);
		if (prop instanceof FeaturePropagation) {
			v = new OsateSlicerVertex(((FeaturePropagation) prop).getFeature(), tti);
		} else if (prop instanceof AccessPropagation) {
			var component = EcoreUtil2.getContainerOfType(prop, ComponentInstance.class);
			v = new OsateSlicerVertex(component, tti);
		} else if (prop instanceof BindingPropagation) {
			var component = EcoreUtil2.getContainerOfType(prop, ComponentInstance.class);
			var bindingType = ((BindingPropagation) prop).getBinding();
			v = new OsateSlicerVertex(component, bindingType, tti);
		} else if (prop instanceof PointPropagation) {
			var component = EcoreUtil2.getContainerOfType(prop, ComponentInstance.class);
			var propName = ((PointPropagation) prop).getName();
			v = new OsateSlicerVertex(component, propName, tti);
		}
		addVertex(v);
		return v.getName();
	}

	/**
	 * Adds the given vertex to the graph, unless it already exists.
	 *
	 * @param v The vertex to add
	 */
	private void addVertex(OsateSlicerVertex v) {
		var name = v.getName();
		if (!vertexMap.containsKey(name)) {
			g.addVertex(v);
			vertexMap.put(name, v);
		}
	}

	/**
	 * Adds a new edge from the source to the target
	 *
	 * @param src Source vertex
	 * @param tgt Target vertex
	 */
	private void addEdge(String src, String tgt) {
		if (!vertexMap.containsKey(tgt)) {
			System.err.println("Can't add edge, vertex " + tgt + " doesn't exist!");
		}
		g.addEdge(vertexMap.get(src), vertexMap.get(tgt));
	}

	/**
	 * Calculates reachable components from the supplied component
	 *
	 * @param component Where to start the forward slice from
	 * @return The set of reachable components
	 */
	public Collection<EObject> forwardReach(ComponentInstance component) {
		Set<EObject> retSet = new HashSet<>();
		for (FeatureInstance fi : component.getAllFeatureInstances()) {
			forwardReachability(fi.getInstanceObjectPath()).vertexSet().forEach(v -> {
				retSet.add(v.getContainer());
			});
		}
		return retSet;
	}

	/**
	 * Calculates reachable features from the supplied feature
	 *
	 * @param feature Where to start the forward slice from
	 * @return The set of reachable features
	 */
	public Collection<FeatureInstance> forwardReach(FeatureInstance feature) {
		Set<FeatureInstance> retSet = new HashSet<>();
		forwardReachability(feature.getInstanceObjectPath()).vertexSet().forEach(v -> {
			// Features without errors can't connect to error sinks (or sources) so this is safe
			retSet.add((FeatureInstance) v.getIObj());
		});
		return retSet;
	}

	/**
	 * Calculates reachable feature / error sinks or sources from the supplied feature / error type
	 *
	 * @param featOrEFI Where to start the forward slice from. Must be a feature, error sink, or error source instance
	 * @param ats The error type that is propagated into / out of the feature to start from
	 * @return The set of reachable features and errors
	 */
	public Collection<IObjErrorPair> forwardReach(InstanceObject featOrEFI, TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		String infix = ".";
		if (!(featOrEFI instanceof FeatureInstance || featOrEFI instanceof ErrorSourceInstance
				|| featOrEFI instanceof ErrorSinkInstance)) {
			infix = ".access.";
		}
		forwardReachability(featOrEFI.getInstanceObjectPath() + infix + token.getFullName()).vertexSet().forEach(v -> {
			retSet.add(new IObjErrorPair(v.getIObj(), v.getErrorToken()));
		});
		return retSet;
	}

	/**
	 * Calculates reachable feature / error sinks or sources from the supplied user-defined propagation point
	 *
	 * @param comp The component which contains the propagation point we want to slice from
	 * @param propPointName The name of the propagation point
	 * @param token The error token that is propagated into / out of the propagation point
	 * @return The set of reachable features and errors
	 */
	public Collection<IObjErrorPair> forwardReach(InstanceObject comp, String propPointName, TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		forwardReachability(comp.getInstanceObjectPath() + "." + propPointName + "." + token.getFullName()).vertexSet()
				.forEach(v -> {
					retSet.add(new IObjErrorPair(v.getIObj(), v.getErrorToken()));
				});
		return retSet;
	}

	/**
	 * Calculates reachable instance objects + error tokens from the supplied component, binding, and error token triple.
	 *
	 * @param component Where to start the slice from, must be a component with some sort of binding relationship.
	 * @param binding The specific binding relationship
	 * @param token The error type that is propagated into / out of the component along the binding to start the slice from
	 * @return The set of reachable instance model elements and errors
	 */
	public Collection<IObjErrorPair> forwardReach(ComponentInstance component, BindingType binding,
			TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		forwardReachability(component.getInstanceObjectPath() + "." + binding + "." + token.getFullName()).vertexSet()
				.forEach(v -> {
					retSet.add(new IObjErrorPair(v.getIObj(), v.getErrorToken()));
				});
		return retSet;
	}

	/**
	 * Calculates components which can reach the supplied component
	 *
	 * @param component Where to start the backward slice from
	 * @return The set of components which can reach the one supplied as a parameter
	 */
	public Collection<EObject> backwardReach(ComponentInstance component) {
		Set<EObject> retSet = new HashSet<>();
		for (FeatureInstance fi : component.getAllFeatureInstances()) {
			backwardReachability(fi.getInstanceObjectPath()).vertexSet().forEach(v -> {
				retSet.add(v.getContainer());
			});
		}
		return retSet;
	}

	/**
	 * Calculates reachable features from the supplied feature
	 *
	 * @param feature Where to start the backward slice from
	 * @return The set of reachable features
	 */
	public Collection<FeatureInstance> backwardReach(FeatureInstance feature) {
		Set<FeatureInstance> retSet = new HashSet<>();
		backwardReachability(feature.getInstanceObjectPath()).vertexSet().forEach(v -> {
			// Features without errors can't connect to error sinks (or sources) so this is safe
			retSet.add((FeatureInstance) v.getIObj());
		});
		return retSet;
	}

	/**
	 * Calculates reachable feature / error sinks or sources from the supplied feature / error type
	 *
	 * @param feature Where to start the forward slice from. Must be a feature, error sink, or error source instance
	 * @param ats The error type that is propagated into / out of the feature to start from
	 * @return The set of reachable features and errors
	 */
	public Collection<IObjErrorPair> backwardReach(InstanceObject featOrEFI, TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		String infix = ".";
		if (!(featOrEFI instanceof FeatureInstance || featOrEFI instanceof ErrorSourceInstance
				|| featOrEFI instanceof ErrorSinkInstance)) {
			infix = ".access.";
		}
		backwardReachability(featOrEFI.getInstanceObjectPath() + infix + token.getFullName()).vertexSet().forEach(v -> {
			retSet.add(new IObjErrorPair(v.getIObj(), v.getErrorToken()));
		});
		return retSet;
	}

	/**
	 * Calculates reachable feature / error sinks or sources from the supplied user-defined propagation point
	 *
	 * @param comp The component which contains the propagation point we want to slice from
	 * @param propPointName The name of the propagation point
	 * @param token The error token that is propagated into / out of the propagation point
	 * @return The set of reachable features and errors
	 */
	public Collection<IObjErrorPair> backwardReach(ComponentInstance comp, String propPointName,
			TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		backwardReachability(comp.getInstanceObjectPath() + "." + propPointName + "." + token.getFullName()).vertexSet()
				.forEach(v -> {
					retSet.add(new IObjErrorPair(v.getIObj(), v.getErrorToken()));
				});
		return retSet;
	}

	/**
	 * Calculates reachable instance objects + error tokens from the supplied component, binding, and error token triple.
	 *
	 * @param comp Where to start the slice from, must be a component with some sort of binding relationship.
	 * @param binding The specific binding relationship
	 * @param token The error type that is propagated into / out of the component along the binding to start the slice from
	 * @return The set of reachable instance model elements and errors
	 */
	public Collection<IObjErrorPair> backwardReach(ComponentInstance comp, BindingType binding,
			TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		backwardReachability(comp.getInstanceObjectPath() + "." + binding + "." + token.getFullName()).vertexSet()
				.forEach(v -> {
					retSet.add(new IObjErrorPair(v.getIObj(), v.getErrorToken()));
				});
		return retSet;
	}

	/**
	 * Builds a subgraph of vertices reachable from the source
	 *
	 * @param srcVert The vertex to start from
	 * @return The reachable subgraph
	 */
	public AbstractGraph<OsateSlicerVertex, DefaultEdge> forwardReachability(String srcVert) {
		return reach(g, srcVert);
	}

	/**
	 * Builds a subgraph of vertices which can reach the target.
	 *
	 * @param tgtVert The vertex to end at
	 * @return The subgraph of nodes which can reach this one.
	 */
	public AbstractGraph<OsateSlicerVertex, DefaultEdge> backwardReachability(String tgtVert) {
		return new EdgeReversedGraph<OsateSlicerVertex, DefaultEdge>(reach(rg, tgtVert));
	}

	/**
	 * Gets error sources from the model. Depending on the parameter value, different subsets of the
	 * complete set of error sources are returned:
	 * <ul>
	 *   <li>VALID -- Only error sources which can possibly terminate in a sink</li>
	 *   <li>INVALID -- Only error sources which cannot possibly terminate in a sink</li>
	 *   <li>ALL -- All error sinks</li>
	 * </ul>
	 * @param validity Valid for terminating error sinks, invalid for nonterminating, all for all.
	 * @return Error sources from the model
	 */
	public Collection<ErrorSourceInstance> getErrorSources(ErrorStateValidity validity) {
		Collection<OsateSlicerVertex> startVertexSet = null;
		if (validity == ErrorStateValidity.VALID) {
			Collection<ErrorSourceInstance> ret = getErrorSources(ErrorStateValidity.ALL);
			ret.removeAll(getErrorSources(ErrorStateValidity.INVALID));
			return ret;
		} else if (validity == ErrorStateValidity.ALL) {
			startVertexSet = g.vertexSet();
		} else if (validity == ErrorStateValidity.INVALID) {
			startVertexSet = acr.nonTerminatingSourceVertices();
		}
		var sourceVertices = startVertexSet.stream()
				.filter(v -> v.getIObj() instanceof ErrorSourceInstance)
				.map(v -> (ErrorSourceInstance) v.getIObj())
				.collect(Collectors.toSet());
		return sourceVertices;
	}

	/**
	 * Gets error sinks from the model. Depending on the parameter value, different subsets of the
	 * complete set of error sinks are returned:
	 * <ul>
	 *   <li>VALID -- Only error sinks which are reachable from any error source</li>
	 *   <li>INVALID -- Only error sinks which are not reachable from any error source</li>
	 *   <li>ALL -- All error sinks (reachable and unreachable) are returned</li>
	 * </ul>
	 * @param validity Valid for reachable error sinks, invalid for unreachable, all for all.
	 * @return Error sinks from the model
	 */
	public Collection<ErrorSinkInstance> getErrorSinks(ErrorStateValidity validity) {
		Collection<OsateSlicerVertex> startVertexSet = null;
		if (validity == ErrorStateValidity.VALID) {
			Collection<ErrorSinkInstance> ret = getErrorSinks(ErrorStateValidity.ALL);
			ret.removeAll(getErrorSinks(ErrorStateValidity.INVALID));
			return ret;
		} else if (validity == ErrorStateValidity.ALL) {
			startVertexSet = g.vertexSet();
		} else if (validity == ErrorStateValidity.INVALID) {
			startVertexSet = acr.unreachableSinkVertices();
		}
		var sinkVertices = startVertexSet.stream()
				.filter(v -> v.getIObj() instanceof ErrorSinkInstance)
				.map(v -> (ErrorSinkInstance) v.getIObj())
				.collect(Collectors.toSet());
		return sinkVertices;
	}

	/**
	 * Gets "neighbor" components, which are those components that have features which are connected
	 * by a single edge to features in the supplied components.
	 *
	 * @param component The component to get the neighbors of
	 * @param successors True to retrieve "successors" (ie, components which consume output from the
	 * supplied component), false to retrieve "predecessors"
	 * @return Neighboring components. Does not include original component.
	 */
	public Collection<EObject> getNeighbors(ComponentInstance component, boolean successors) {
		Set<EObject> retSet = new HashSet<>();
		Collection<OsateSlicerVertex> tempSet = new HashSet<>();
		int myDepth = -1;
		for (FeatureInstance fi : component.getAllFeatureInstances()) {
			if (myDepth < 0) {
				myDepth = vertexMap.get(fi.getInstanceObjectPath()).getDepth();
			}
			tempSet.addAll(getNeighbors(fi.getInstanceObjectPath(), successors));
		}
		EObject temp;
		for (OsateSlicerVertex v : tempSet) {
			temp = v.getContainer();
			for (int i = myDepth - v.getDepth(); i < 0; i++) {
				temp = temp.eContainer();
			}
			if (temp != component) {
				retSet.add(temp);
			}
		}
		return retSet;
	}

	/**
	 * Implementation of neighbor-finding
	 *
	 * @param srcVert The path to the vertex the caller wants the neighbors of
	 * @param successors True if the caller wants vertices pointed at by edges from the srcVert,
	 * false if the caller wants vertices which point at the srcVert
	 * @return Vertices representing features which are connected by a single edge to the supplied vertex
	 */
	private Collection<OsateSlicerVertex> getNeighbors(String srcVert, boolean successors) {
		Set<OsateSlicerVertex> retSet;
		if (successors) {
			retSet = g.outgoingEdgesOf(vertexMap.get(srcVert))
					.stream()
					.map(e -> g.getEdgeTarget(e))
					.collect(Collectors.toSet());
		} else {
			retSet = g.incomingEdgesOf(vertexMap.get(srcVert))
					.stream()
					.map(e -> g.getEdgeSource(e))
					.collect(Collectors.toSet());
		}
		return retSet;
	}

	/**
	 * Private method to actually do the slicing / reachability
	 *
	 * @param graph The graph to operate on
	 * @param origin The vertex to begin slicing from
	 * @return The subgraph reachable from the origin
	 */
	public AsSubgraph<OsateSlicerVertex, DefaultEdge> reach(Graph<OsateSlicerVertex, DefaultEdge> graph,
			String origin) {

		// You might reasonably wonder why this is handwritten, instead of using some JGraphT built-in method.
		// There are three reasons.
		//
		// 1. The JGraphT method to use would be org.jgrapht.graph.DirectedAcyclicGraph.getDescendants(OsateSlicerVertex)
		// It requires that graphs be acyclic, but this doesn't apply to EMV2 propagation graphs, which can have
		// cycles
		// 2. That method returns a set of vertices, which is less information than a subgraph. Not a huge deal, but
		// kind of annoying.
		// 3. The implementation in the library is virtually identical -- no memoization or other optimizations. They
		// use DFS instead of BFS, but that's... about it.

		origin = origin.replace(".EMV2", "");
		BreadthFirstIterator<OsateSlicerVertex, DefaultEdge> bfi = new BreadthFirstIterator<>(graph,
				vertexMap.get(origin));

		AsSubgraph<OsateSlicerVertex, DefaultEdge> reachableSubgraph = new AsSubgraph<>(graph,
				Collections.singleton(vertexMap.get(origin)));

		bfi.next(); // Disregard root node since we already added it
		bfi.forEachRemaining(v -> {
			reachableSubgraph.addVertex(v);
			reachableSubgraph.addEdge(bfi.getParent(v), v, bfi.getSpanningTreeEdge(v));
		});
		return reachableSubgraph;
	}

	/**
	 * Checks to see if the target is reachable from the source
	 * @param graph The graph to check
	 * @param sourceName Name of source node
	 * @param targetName Name of target node
	 * @return True if the target can be reached from the source, false otherwise
	 */
	public boolean reachFrom(Graph<OsateSlicerVertex, DefaultEdge> graph, String sourceName, String targetName) {
		if (graph == null) {
			graph = g; // XXX DEBUG CODE REMOVE
		}
		return reach(graph, sourceName).vertexSet().contains(vertexMap.get(targetName));
	}

	/**
	 * Checks to see if all paths from source to target go through mid.
	 *
	 * @param graph The graph to check
	 * @param sourceName Name of source node
	 * @param targetName Name of target node
	 * @param midName Name of midpoint node, through which all paths must pass
	 * @param counterexample True if the user wants a counterexample generated if the target is reachable from the
	 * source without going through mid
	 * @return Empty if all paths from source to target go through mid. Otherwise, contains a counterexample if
	 * requested by the caller, if not, contains an empty path.
	 */
	public Optional<GraphPath<OsateSlicerVertex, DefaultEdge>> reachThrough(Graph<OsateSlicerVertex, DefaultEdge> graph,
			String sourceName, String targetName, String midName, boolean counterexample) {
		if (graph == null) {
			graph = g; // XXX DEBUG CODE REMOVE
		}

		// TODO: This... should be inspected to make sure it's correct.

		var gForward = reach(graph, sourceName);
		if (!gForward.vertexSet().contains(vertexMap.get(targetName))) {
			// Short circuit, we can't get to the target from the source so there's no point in continuing.
			return Optional.of(GraphWalk.emptyWalk(graph));
		}
		var gBackward = reach(new EdgeReversedGraph<>(gForward), targetName);
		// TODO: Instead of getting cutpoints, consider building masked subgraph and then just re-running reachability from src to tgt
		if (!new BiconnectivityInspector<>(gBackward).getCutpoints().contains(vertexMap.get(midName))) {
			// midpoint not required for path construction
			if (counterexample) {
				// Remove mid vertex and edges, can't use g2 because its reversed
				var gMasked = new MaskSubgraph<>(new EdgeReversedGraph<>(gBackward), (v -> v.getName().equals(midName)),
						(e -> false));
				return Optional.of(
						BFSShortestPath.findPathBetween(gMasked, vertexMap.get(sourceName), vertexMap.get(targetName)));
			} else {
				return Optional.of(GraphWalk.emptyWalk(graph));
			}
		}
		return Optional.empty();
	}

	/**
	 * This method connect component inports to component outports.
	 * @param noInternalConnections Set of components which don't need inports connected to outports
	 */
	private void buildIntraConnections(Set<String> noInternalConnections) {
		Set<String> intraConnectedComponents = new HashSet<>(inFeats.keySet());
		intraConnectedComponents.retainAll(outFeats.keySet());
		intraConnectedComponents.forEach(container -> {
			inFeats.get(container).forEach(i -> {
				outFeats.get(container).forEach(o -> {
					if (!i.equals(o) && !noInternalConnections.contains(container)) {
						addEdge(i, o);
					}
				});
			});
		});
	}

	/**
	 * This propagates error tokens from each source, discovering intercomponent propagations.
	 */
	private void calculateFixpoint() {
		// For each source vertex, we walk it forward, adding connections from possible propagations where necessary
		boolean edgesModified;
		Set<OsateSlicerVertex> sourcePropagations = g.vertexSet()
				.stream()
				.filter(v -> v.getIObj() instanceof ErrorSourceInstance)
				.collect(Collectors.toSet());
		do {
			edgesModified = false;
			for (OsateSlicerVertex srcVrt : sourcePropagations) {
				LinkedList<DefaultEdge> edges = new LinkedList<>();
				g.outgoingEdgesOf(srcVrt).forEach(outgoingEdge -> edges.push(outgoingEdge));
				while (edges.size() > 0) {
					DefaultEdge e = edges.pop();
					OsateSlicerVertex dstVrt = g.getEdgeTarget(e);
					g.outgoingEdgesOf(dstVrt).forEach(outgoingEdge -> edges.push(outgoingEdge));
					String componentName = dstVrt.getName().substring(0, dstVrt.getName().lastIndexOf('.'));
					if (possiblePropagations.containsKey(componentName)) {
						for (var propagation : possiblePropagations.get(componentName)) {
							Optional<String> tgt = propagation.getTarget(dstVrt);
							if (tgt.isPresent() && !g.containsEdge(dstVrt, vertexMap.get(tgt.get()))) {
								edgesModified = true;
								addEdge(dstVrt.getName(), tgt.get());
								edges.push(g.getEdge(dstVrt, vertexMap.get(tgt.get())));
							}
						}
					}
				}
			}
			// We keep redoing this until we walked over each source vertex without adding anything new
		} while (edgesModified);
	}

	/**
	 * Debug function which dumps the internal graph to dot so it can be fed into graphviz
	 * @return A string which can be input to graphviz
	 */
	public String toDot(Graph<OsateSlicerVertex, DefaultEdge> g) {
		DOTExporter<OsateSlicerVertex, DefaultEdge> exporter = new DOTExporter<>(v -> "\"" + v.getName() + "\"");
		Writer writer = new StringWriter();
		exporter.exportGraph(g, writer);
		return writer.toString();
	}

	public Graph<OsateSlicerVertex, DefaultEdge> getGraph() {
		return g;
	}

	public Graph<OsateSlicerVertex, DefaultEdge> getReversedGraph() {
		return rg;
	}

	@Override
	public String toString() {
		return g.toString();
	}

	private class PossiblePropagation {

		private final String dstName;
		private final AnonymousTypeSet srcTypes;
		private final AnonymousTypeSet dstTypes;

		public PossiblePropagation(PropagationPathInstance ppi) {
			ErrorPropagationInstance src = null, dst = null;
			if (ppi instanceof ConnectionPath) {
				src = ((ConnectionPath) ppi).getSourcePropagation();
				dst = ((ConnectionPath) ppi).getDestinationPropagation();
			} else if (ppi instanceof BindingPath) {
				src = ((BindingPath) ppi).getSourcePropagations().get(0);
				dst = ((BindingPath) ppi).getDestinationPropagations().get(0);
			} else if (ppi instanceof UserDefinedPath) {
				src = ((UserDefinedPath) ppi).getSourcePropagation();
				dst = ((UserDefinedPath) ppi).getDestinationPropagation();
			}
			// We don't need the srcName, so we don't calculate / store it
			srcTypes = src.getOutTypeSet();
			dstName = dst.getInstanceObjectPath().replace(".EMV2", "");
			dstTypes = dst.getInTypeSet();
		}

		public Optional<String> getTarget(OsateSlicerVertex v) {
			String typeSetName = v.getName()
					.substring(v.getName().lastIndexOf('.') + 1)
					.replace("{", "")
					.replace("}", "");
			if (Sets.powerSet(srcTypes.getElements().stream().map(TypeSetElement::getName).collect(Collectors.toSet()))
					.contains(ImmutableSet.of(typeSetName))
					&& Sets.powerSet(
							dstTypes.getElements().stream().map(TypeSetElement::getName).collect(Collectors.toSet()))
							.contains(ImmutableSet.of(typeSetName))) {
				return Optional.of(dstName + "." + typeSetName);
			}
			return Optional.empty();
		}
	}

	private class Emv2SlicerSwitch extends EMV2InstanceSwitch<Void> {
		@Override
		public Void caseErrorSourceInstance(ErrorSourceInstance esi) {
			var srcTypes = esi.getTypeSet().getElements();
			var prop = esi.getPropagation();
			srcTypes.stream().filter(tse -> tse instanceof TypeTokenInstance).forEach(tse -> {
				var tti = (TypeTokenInstance) tse;
				var srcVertex = new OsateSlicerVertex(esi, Optional.of(tti));
				var srcVertexName = srcVertex.getName();
				addVertex(srcVertex);
				var tgtVertexName = getVertex(prop, tti);
				addEdge(srcVertexName, tgtVertexName);
			});
			return null;
		}

		@Override
		public Void caseErrorSinkInstance(ErrorSinkInstance esi) {
			var dstTypes = esi.getTypeSet().getElements();
			var prop = esi.getPropagation();
			dstTypes.stream().filter(tse -> tse instanceof TypeTokenInstance).forEach(tse -> {
				var tti = (TypeTokenInstance) tse;
				var tgtVertex = new OsateSlicerVertex(esi, Optional.of(tti));
				var tgtVertexName = tgtVertex.getName();
				addVertex(tgtVertex);
				var srcVertexName = getVertex(prop, tti);
				addEdge(srcVertexName, tgtVertexName);
			});
			return null;
		}

		@Override
		public Void caseErrorPathInstance(ErrorPathInstance epi) {
			var destProp = epi.getDestinationPropagation();
			var destTTI = epi.getDestinationTypeToken();
			String tgtVertexName = getVertex(destProp, destTTI);
			if (epi.getSourcePropagation().equals(epi.getDestinationPropagation())) {
				// Because the EMV2 instantiator does not create new propagations for different directions, we skip
				// re-creating the vertex and then giving it an edge to itself by just bailing out here.
				// see, in the EMV2 instantiator documentation, the section on Propagations#Propagations-Direction
				return null;
			}
			var srcTypes = epi.getSourceTypeSet().getElements();
			var srcProp = epi.getSourcePropagation();
			final String tgtVertexNameFinal = new String(tgtVertexName);
			srcTypes.stream().filter(tse -> tse instanceof TypeTokenInstance).forEach(tse -> {
				TypeTokenInstance srcTTI = (TypeTokenInstance) tse;
				String srcVertexName = getVertex(srcProp, srcTTI);
				addEdge(srcVertexName, tgtVertexNameFinal);
			});
			return null;
		}

		@Override
		public Void casePropagationPathInstance(PropagationPathInstance ppi) {
			String srcName = "unknown";
			if (ppi instanceof ConnectionPath) {
				srcName = ((ConnectionPath) ppi).getSourcePropagation().getInstanceObjectPath().replace(".EMV2", "");
			} else if (ppi instanceof BindingPath) {
				srcName = ((BindingPath) ppi).getSourcePropagations()
						.get(0)
						.getInstanceObjectPath()
						.replace(".EMV2", "");
			} else if (ppi instanceof UserDefinedPath) {
				srcName = ((UserDefinedPath) ppi).getSourcePropagation().getInstanceObjectPath().replace(".EMV2", "");
			}
			if (!possiblePropagations.containsKey(srcName)) {
				possiblePropagations.put(srcName, new HashSet<>());
			}
			possiblePropagations.get(srcName).add(new PossiblePropagation(ppi));
			return null;
		}
	}

	/**
	 * This switch handles parsing AADL instance models
	 *
	 * @author sprocter
	 */
	private class SlicerSwitch extends InstanceSwitch<Void> {
		@Override
		public Void caseFeatureInstance(FeatureInstance fi) {
			var fullFeatureName = fi.getInstanceObjectPath();
			String fullContainerName = fullFeatureName.substring(0, fullFeatureName.lastIndexOf('.'));
			addVertex(new OsateSlicerVertex(fi, Optional.empty()));
			if (fi.getDirection() == DirectionType.IN || fi.getDirection() == DirectionType.IN_OUT) {
				if (!inFeats.containsKey(fullContainerName)) {
					inFeats.put(fullContainerName, new HashSet<String>());
				}
				inFeats.get(fullContainerName).add(fullFeatureName);
			}
			if (fi.getDirection() == DirectionType.OUT || fi.getDirection() == DirectionType.IN_OUT) {
				if (!outFeats.containsKey(fullContainerName)) {
					outFeats.put(fullContainerName, new HashSet<String>());
				}
				outFeats.get(fullContainerName).add(fullFeatureName);
			}
			return null;
		}

		@Override
		public Void caseConnectionInstance(ConnectionInstance ci) {
			for (ConnectionReference cr : ci.getConnectionReferences()) {
				var srcVertex = new OsateSlicerVertex(cr.getSource(), Optional.empty());
				var srcName = srcVertex.getName();
				addVertex(srcVertex);
				var dstVertex = new OsateSlicerVertex(cr.getDestination(), Optional.empty());
				var dstName = dstVertex.getName();
				addVertex(dstVertex);
				addEdge(srcName, dstName);
			}

			// If the component has a decomposition specified, we need to record that
			// TODO: Chat with Lutz about how to make this more robust, it may not always work
			if (ci.getConnectionReferences().size() > 1) {
				addExplicitDecomp(ci.getConnectionReferences().get(0).getDestination());
			}
			return null;
		}

		@Override
		public Void caseEndToEndFlowInstance(EndToEndFlowInstance fi) {
			// TODO: Switch to caseFlowSpecificationInstance so that flow fragments get handled
			// and, if two flows share a piece of a flow, it will get double-added
			for (FlowElementInstance fei : fi.getFlowElements()) {
				if (fei instanceof FlowSpecificationInstance) {
					FlowSpecificationInstance fsi = (FlowSpecificationInstance) fei;
					if (fsi.getSource() != null && fsi.getDestination() != null) {
						addEdge(fsi.getSource().getInstanceObjectPath(), fsi.getDestination().getInstanceObjectPath());
						addExplicitDecomp(fsi.getSource());
						addExplicitDecomp(fsi.getDestination());
					}
				}
			}
			return null;
		}

		/**
		 * Marks that this component has an explicit specification of its intracomponent connections,
		 * so it will be skipped when we calculate worst case intra-component connections
		 *
		 * @param ne The component which has an explicit specification of how its inputs map to its outputs
		 */
		private void addExplicitDecomp(InstanceObject iObj) {
			String fullFeatureName = iObj.getInstanceObjectPath();
			String fullContainerName = fullFeatureName.substring(0, fullFeatureName.lastIndexOf('.'));
			hasExplicitDecomp.add(fullContainerName);
		}
	};
}
