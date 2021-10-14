package org.osate.slicer;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.AbstractGraph;
import org.jgrapht.graph.AsSubgraph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.EdgeReversedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;

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
	 * A reversed-direction version of the main graph. Not created until {@link #freeze() freeze} method has been run
	 */
	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new DefaultDirectedGraph<>(DefaultEdge.class);

	/**
	 * Maps vertex names to their objects
	 */
	private final Map<String, OsateSlicerVertex> vertexMap = new HashMap<>();

	/**
	 * Switch used to traverse instance model that gets passed in
	 */
	private SlicerSwitch mySwitch = new SlicerSwitch();

	public void buildGraph(SystemInstance si) {

		// Add vertices and explicit edges
		EcoreUtil.getAllContents(si.eResource(), true).forEachRemaining(elem -> {
			mySwitch.doSwitch((Element) elem);
		});

		// Add implicit edges
		buildIntraConnections();

		// Create a separate graph, rather than a wrapper, saving CPU at the expense of memory
		Graphs.addGraphReversed(rg, g);

		System.out.println(toString());
		System.out.println(forwardReachability("sys_impl_Instance.b.output"));
		System.out.println(backwardReachability("sys_impl_Instance.b.output"));
	}

	/**
	 * Adds a new vertex by the given name to the graph.
	 *
	 * @param name The name of the new vertex
	 */
	public void addVertex(String name) {
		if (vertexMap.containsKey(name)) {
			return; // No duplicates allowed
		}
		OsateSlicerVertex v = new OsateSlicerVertex(name);
		g.addVertex(v);
		vertexMap.put(name, v);
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

	private void buildIntraConnections() {
		Set<String> intraConnectedComponents = new HashSet<>(mySwitch.inFeats.keySet());
		intraConnectedComponents.retainAll(mySwitch.outFeats.keySet());
		intraConnectedComponents.forEach(container -> {
			mySwitch.inFeats.get(container).forEach(i -> {
				mySwitch.outFeats.get(container).forEach(o -> {
					if (!i.equals(o)) {
						addEdge(i, o);
					}
				});
			});
		});
	}

	@Override
	public String toString() {
		return g.toString();
	}

	/**
	 * This switch handles parsing AADL instance models
	 *
	 * @author sprocter
	 */
	private class SlicerSwitch extends InstanceSwitch<Void> {

		/**
		 * This maps a container name to the set of input features it has
		 */
		private Map<String, Set<String>> inFeats = new HashMap<>();

		/**
		 * This maps a container name to the set of output features it has
		 */
		private Map<String, Set<String>> outFeats = new HashMap<>();

		@Override
		public Void caseFeatureInstance(FeatureInstance fi) {
			String fullFeatureName = getCompleteFeatureName(fi);
			String fullContainerName = fullFeatureName.substring(0, fullFeatureName.lastIndexOf('.'));
			addVertex(fullFeatureName);
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
			addEdge(getCompleteFeatureName(ci.getSource()), getCompleteFeatureName(ci.getDestination()));
			return null;
		}

		/**
		 * Builds a dot-qualified full name from the given feature / connection end
		 * @param cie The connection end / feature
		 * @return The full name / path to the component
		 */
		private String getCompleteFeatureName(ConnectionInstanceEnd cie) {
			NamedElement ne = cie;
			StringBuilder sb = new StringBuilder(ne.getFullName());
			do {
				ne = (NamedElement) ne.eContainer();
				sb.insert(0, ne.getFullName() + ".");
			} while (ne.eContainer() != null);
			return sb.toString();
		}
	};
}
