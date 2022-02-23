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
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
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
	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new DefaultDirectedGraph<>(DefaultEdge.class);

	/**
	 * Maps vertex names to their objects
	 */
	private final Map<String, OsateSlicerVertex> vertexMap = new HashMap<>();

	/**
	 * This maps a container name to the set of input features it has
	 */
	private Map<String, Set<String>> inFeats = new HashMap<>();

	/**
	 * This maps a container name to the set of output features it has
	 */
	private Map<String, Set<String>> outFeats = new HashMap<>();

	/**
	 * This stores container names which have explicit decompositions provided by the modeler
	 */
	private Set<String> hasExplicitDecomp = new HashSet<>();

	/**
	 * Switch used to traverse instance model that gets passed in
	 */
	private SlicerSwitch coreSwitch = new SlicerSwitch();
	private Emv2SlicerSwitch emv2Switch = new Emv2SlicerSwitch();

	// XXX Delete this when the EMV2 / Core instantiator stuff gets figured out
	private Map<String, String> laggingEdges = new HashMap<>();

	public void buildGraph(SystemInstance si) {
		// Add vertices and explicit edges
		EcoreUtil.getAllContents(si.eResource(), true).forEachRemaining(elem -> {
			coreSwitch.doSwitch((Element) elem);
		});

		EcoreUtil.getAllContents(si.eResource(), true).forEachRemaining(elem -> {
			emv2Switch.doSwitch((Element) elem);
		});

		laggingEdges.entrySet().forEach(e -> addEdge(e.getKey(), e.getValue()));

		// Add implicit edges
		buildIntraConnections(hasExplicitDecomp);

		// Create a separate reversed graph, rather than a wrapper, saving CPU at the expense of memory
		Graphs.addGraphReversed(rg, g);

		// Debugging info, remove at-will
		System.out.println(this.toDot());
	}

	/**
	 * Adds a new vertex by the given name to the graph.
	 *
	 * @param name The name of the new vertex
	 * @param eObject
	 */
	public void addVertex(String name, EObject eObject) {
		if (vertexMap.containsKey(name)) {
			return; // No duplicates allowed
		}
		OsateSlicerVertex v = new OsateSlicerVertex(name, eObject);
		g.addVertex(v);
		vertexMap.put(name, v);
	}

	/**
	 * Adds a new vertex by the given name to the graph.
	 *
	 * @param name The name of the new vertex
	 * @param tse The error type associated with the vertex, or null if none
	 * @param eObject The container of the vertex
	 */
	public void addVertex(String name, TypeSetElement tse, EObject eObject) {
		if ((tse == null && vertexMap.containsKey(name))
				|| (tse != null && vertexMap.containsKey(name + "." + tse.getFullName()))) {
			return; // No duplicates allowed
		}
		OsateSlicerVertex v = new OsateSlicerVertex(name, tse, eObject);
		g.addVertex(v);
		vertexMap.put(v.getName(), v);
	}

	/**
	 * Adds a new edge from the source to the target
	 *
	 * @param src Source vertex
	 * @param tgt Target vertex
	 */
	public void addEdge(String src, String tgt) {
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
	 * Private method to actually do the slicing / reachability
	 *
	 * @param graph The graph to operate on
	 * @param origin The vertex to begin slicing from
	 * @return The subgraph reachable from the origin
	 */
	private AsSubgraph<OsateSlicerVertex, DefaultEdge> reach(Graph<OsateSlicerVertex, DefaultEdge> graph,
			String origin) {
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
	 * Debug function which dumps the internal graph to dot so it can be fed into graphviz
	 * @return A string which can be input to graphviz
	 */
	public String toDot() {
		DOTExporter<OsateSlicerVertex, DefaultEdge> exporter = new DOTExporter<>(v -> v.getName().replace('.', '_'));
		Writer writer = new StringWriter();
		exporter.exportGraph(g, writer);
		return writer.toString();
	}

	@Override
	public String toString() {
		return g.toString();
	}

	private class Emv2SlicerSwitch extends EMV2InstanceSwitch<Void> {

		@Override
		public Void caseFeaturePropagation(FeaturePropagation fp) {
			var fi = fp.getFeature();
			var fullFeatureName = fi.getInstanceObjectPath();
			var fullContainerName = fullFeatureName.substring(0, fullFeatureName.lastIndexOf('.'));
			Collection<TypeSetElement> tses = Collections.emptySet();
			if (fi.getDirection() == DirectionType.IN || fi.getDirection() == DirectionType.IN_OUT) {
				if (!inFeats.containsKey(fullContainerName)) {
					inFeats.put(fullContainerName, new HashSet<String>());
				}
				inFeats.get(fullContainerName).add(fullFeatureName);
				tses = fp.getInTypeSet().getElements();
			}
			if (fi.getDirection() == DirectionType.OUT || fi.getDirection() == DirectionType.IN_OUT) {
				if (!outFeats.containsKey(fullContainerName)) {
					outFeats.put(fullContainerName, new HashSet<String>());
				}
				outFeats.get(fullContainerName).add(fullFeatureName);
				tses = fp.getOutTypeSet().getElements();
			}
			tses.forEach(t -> addVertex(fullFeatureName, t, fi.eContainer()));
			return null;
		}

		@Override
		public Void caseErrorSourceInstance(ErrorSourceInstance esi) {
			var srcName = esi.getInstanceObjectPath().replace(".EMV2", "");
			var srcTypes = esi.getTypeSet();
			var eContainer = esi.eContainer().eContainer();
			var propName = esi.getPropagation().getInstanceObjectPath().replace(".EMV2", "");
			srcTypes.getElements().forEach(t -> addVertex(srcName, t, eContainer));
			srcTypes.getElements()
					.forEach(t -> laggingEdges.put(srcName + "." + t.getFullName(), propName + "." + t.getFullName()));
			return null;
		}

		@Override
		public Void caseErrorSinkInstance(ErrorSinkInstance esi) {
			var dstName = esi.getInstanceObjectPath().replace(".EMV2", "");
			var dstTypes = esi.getTypeSet();
			var eContainer = esi.eContainer().eContainer();
			var propName = esi.getPropagation().getInstanceObjectPath().replace(".EMV2", "");
			dstTypes.getElements().forEach(t -> addVertex(dstName, t, eContainer));
			dstTypes.getElements()
					.forEach(t -> laggingEdges.put(propName + "." + t.getFullName(), dstName + "." + t.getFullName()));
			return null;
		}

		@Override
		public Void caseErrorPathInstance(ErrorPathInstance epi) {
			var srcVrt = epi.getSourcePropagation().getInstanceObjectPath().replace(".EMV2", "");
			Set<String> srcVrts = new HashSet<>();
			epi.getSourceTypeSet().getElements().forEach(e -> srcVrts.add(srcVrt + "." + e.getFullName()));
			var dstVrt = epi.getDestinationPropagation().getInstanceObjectPath().replace(".EMV2", "") + "."
					+ epi.getDestinationTypeToken().getFullName();
			laggingEdges.put(srcVrts.iterator().next(), dstVrt);
			return null;
		}

		@Override
		public Void casePropagationPathInstance(PropagationPathInstance ppi) {
			var src = (ConstrainedInstanceObject) ppi.getSource();
			var dst = ppi.getTarget();
			if (src instanceof ErrorPropagationInstance && dst instanceof ErrorPropagationInstance) {
				var srcVrt = src.getInstanceObjectPath().replace(".EMV2", "");
				Set<String> srcVrts = new HashSet<>();
				((ErrorPropagationInstance) src).getOutTypeSet()
						.getElements()
						.forEach(e -> srcVrts.add(srcVrt + "." + e.getFullName()));

				var dstVrt = dst.getInstanceObjectPath().replace(".EMV2", "");
				Set<String> dstVrts = new HashSet<>();
				((ErrorPropagationInstance) dst).getInTypeSet()
						.getElements()
						.forEach(e -> dstVrts.add(dstVrt + "." + e.getFullName()));
				laggingEdges.put(srcVrts.iterator().next(), dstVrts.iterator().next());
			}
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
			addVertex(fullFeatureName, fi.eContainer());
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
				addEdge(cr.getSource().getInstanceObjectPath(), cr.getDestination().getInstanceObjectPath());
			}

			// If the component has a decomposition specified, we need to record that
			if (ci.getConnectionReferences().size() > 1) {
				addExplicitDecomp(ci.getConnectionReferences().get(0).getDestination());
			}
			return null;
		}

		@Override
		public Void caseEndToEndFlowInstance(EndToEndFlowInstance fi) {
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
