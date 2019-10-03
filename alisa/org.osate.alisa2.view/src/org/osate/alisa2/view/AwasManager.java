package org.osate.alisa2.view;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.impl.AadlPackageImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.sireum.aadl.osate.util.Util;
import org.sireum.awas.AADLBridge.AadlHandler;
import org.sireum.awas.ast.Model;
import org.sireum.awas.awasfacade.AwasGraphImpl;
import org.sireum.awas.fptc.FlowEdge;
import org.sireum.awas.fptc.FlowGraph;
import org.sireum.awas.fptc.FlowNode;
import org.sireum.awas.symbol.Resource;
import org.sireum.awas.symbol.SymbolTable;
import org.sireum.awas.symbol.SymbolTableHelper;
import org.sireum.awas.util.JavaConverters;
import org.sireum.hamr.ir.Aadl;
import org.sireum.util.ConsoleTagReporter;

/**
 * Singleton that provides access to AWAS related functionality. We use a
 * singleton because a) Sirius's java services can't hold state, and b) the
 * initialization costs of AWAS / AIR / Sireum is significant
 *
 * See Wikipedia for the code the lazy initialization is adapted from:
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 * @author Sam Procter
 *
 */
public class AwasManager {

	/**
	 * Some of AWAS's work is time intensive, so we maintain a cache here
	 */
	private Map<ComponentInstance, AWASCacheTriple> graphTableCache;

	/**
	 * Private constructor to enforce usage of singleton pattern
	 */
	private AwasManager() {
		graphTableCache = new HashMap<>();
	}

	/**
	 * Holder class for instance -- see class level comments about why we use
	 * a singleton
	 */
	private static class LazyHolder {
		static final AwasManager INSTANCE = new AwasManager();
	}

	public static AwasManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * Get all the "Successors" of the specified component, where successor is defined as another
	 * component that receives messages directly (ie, without any intermediaries) from this one.
	 *
	 * @param self The component to get the neighbors of
	 * @return The set of successors to the given component.
	 */
	public Collection<EObject> getSuccessorNeighbors(ComponentInstance component) {
		return getNeighbors(component, true);
	}

	/**
	 * Get all the "Predecessors" of the specified component, where predecessor is defined as another
	 * component that sends messages directly (ie, without any intermediaries) to this one.
	 *
	 * @param self The component to get the neighbors of
	 * @return The set of predecessors to the given component.
	 */
	public Collection<EObject> getPredecessorNeighbors(ComponentInstance component) {
		return getNeighbors(component, false);
	}

	/**
	 * This method wraps / calls the AWAS methods for calculating the neighbors of a component
	 *
	 * @param component The component to get the neighbors of
	 * @param getSuccessors True if we're calculating successor neighbors, false otherwise
	 * @return The set of neighbors of the given component
	 * @throws NoSuchElementException Thrown if AWAS can't find the given component
	 */
	private Collection<EObject> getNeighbors(ComponentInstance component, boolean getSuccessors)
			throws NoSuchElementException {
		// We use the parent since we're interested in the graph that contains the given component
		// rather than its subgraph
		ComponentInstance parent = component.getContainingComponentInstance();
		initTableAndGraph(parent);
		FlowNode flowNode = JavaConverters.toJavaOptional(FlowNode.getNode(
				SymbolTableHelper.getUriFromString(graphTableCache.get(parent).table, component.getName()).get()))
				.get();
		FlowGraph<FlowNode, FlowEdge<FlowNode>> nodeGraph = flowNode.getOwner();

		Set<FlowNode> neighborConns = new HashSet<>();
		Set<FlowNode> neighbors = new HashSet<>();

		if (getSuccessors) {
			neighborConns.addAll(JavaConverters.toJavaSet(nodeGraph.getSuccessorNodes(flowNode)));
			neighborConns.stream().map(nodeGraph::getSuccessorNodes).map(JavaConverters::toJavaSet)
					.forEach(neighbors::addAll);
		} else {
			neighborConns.addAll(JavaConverters.toJavaSet(nodeGraph.getPredecessorNodes(flowNode)));
			neighborConns.stream().map(nodeGraph::getPredecessorNodes).map(JavaConverters::toJavaSet)
					.forEach(neighbors::addAll);
		}

		Set<String> uris = neighbors.stream().map(n -> n.getUri()).collect(Collectors.toSet());
		return urisToInstEObjs(parent, uris);
	}

	/**
	 * This is used to initialize the cached AWAS objects for the given component.
	 * It will check to see if they've already been created, so it's safe to call multiple
	 * times without a performance hit.
	 *
	 * @param component The component to create the AWAS objects for
	 */
	private void initTableAndGraph(ComponentInstance component) {
		if (graphTableCache.containsKey(component)) {
			return;
		}
		Aadl airModel = Util.getAir(component, false);
		Model awasModel = AadlHandler.buildAwasModel(airModel);
		SymbolTable st = SymbolTable.apply(awasModel, new ConsoleTagReporter());
		FlowGraph<FlowNode, FlowEdge<FlowNode>> graph = FlowGraph.apply(awasModel, st, false);
		graphTableCache.put(component, new AWASCacheTriple(graph, st));
	}

	/**
	 * Calculates the forward reachability of the given error type from the given port.
	 *
	 * @param et The error type to propagate forward
	 * @param feature The feature to propagate from
	 * @return Reachable components from the given parameters
	 */
	public Collection<EObject> forwardReach(ErrorType et, FeatureInstance feature) {
		return reach(et, feature, true);
	}

	/**
	 * Calculates the backward reachability of the given error type from the given port.
	 *
	 * @param et The error type to propagate backward
	 * @param feature The feature to propagate from
	 * @return Reachable components from the given parameters
	 */
	public Collection<EObject> backwardReach(ErrorType et, FeatureInstance feature) {
		return reach(et, feature, false);
	}

	/**
	 * This actually wraps the AWAS reachability methods.
	 *
	 * @param et The error type to propagate backward
	 * @param feature The feature to propagate from
	 * @param isForward True if we're doing a forward propagation, false otherwise
	 * @return Reachable components from the given parameters
	 */
	private Collection<EObject> reach(ErrorType et, FeatureInstance feature, boolean isForward) {
		// Get the parent since the supplied parameters are elements of the graph we want to analyze
		ComponentInstance parent = feature.getContainingComponentInstance().getContainingComponentInstance();
		initTableAndGraph(parent);
		AWASCacheTriple gtc = graphTableCache.get(parent);

		String port = feature.getComponentInstancePath();
		String error = EcoreUtil2.getContainerOfType(et, AadlPackageImpl.class).getName() + "." + et.getName();

		if (isForward) {
			return urisToInstEObjs(parent, gtc.agi.forwardErrorReachUsingNames(port, error)
					.get(SymbolTableHelper.getUriFromString(gtc.table, feature.getComponentInstancePath()).get()));
		} else {
			return urisToInstEObjs(parent, gtc.agi.backwardErrorReachUsingNames(port, error)
					.get(SymbolTableHelper.getUriFromString(gtc.table, feature.getComponentInstancePath()).get()));
		}
	}

	/**
	 * Perform a simple backward reachability analysis from the given component
	 *
	 * @param component The component to start the analysis at
	 * @return Reachable components from the given parameter
	 */
	public Collection<EObject> backwardReach(ComponentInstance component) {
		ComponentInstance parent = component.getContainingComponentInstance();
		initTableAndGraph(parent);
		return urisToInstEObjs(parent, graphTableCache.get(parent).agi.backwardReachUsingNames(component.getName()));
	}


	/**
	 * Perform a simple forward reachability analysis from the given component
	 *
	 * @param component The component to start the analysis at
	 * @return Reachable components from the given parameter
	 */
	public Collection<EObject> forwardReach(ComponentInstance component) {
		ComponentInstance parent = component.getContainingComponentInstance();
		initTableAndGraph(parent);
		return urisToInstEObjs(parent, graphTableCache.get(parent).agi.forwardReachUsingNames(component.getName()));
	}

	public Collection<EObject> getRootErrorTypesByConnection(ConnectionInstance self) {
		ComponentInstance parent = self.getContainingComponentInstance();
		initTableAndGraph(parent);
//		String parentURI = SymbolTableHelper
//				.getUriFromString(graphTableCache.get(parent).table, parent.getInstanceObjectPath()).get();
		String portURI = SymbolTableHelper.getPortUri(graphTableCache.get(parent).table, self.getSource().getComponentInstancePath()).get();
		FlowNode flowNode = FlowNode.getNode(Resource.getParentUri(portURI).get()).get();
		Set<String> propSet = JavaConverters.toJavaSet(flowNode.getFptcPropagation(portURI));
		// Check the symbol table -- first entry (compSymbolTableMap) should have everything in the component
		Collection<EObject> ret = urisToInstEObjs(parent, propSet);

		return ret;
	}

	/**
	 * Convert the given AWAS URIs to their instance model representations, assuming they exist as children
	 * of the given component
	 *
	 * @param parent The component that should contain the components pointed to by the given URIs.
	 * @param uris URIs to components or ports (both will resolve to components)
	 * @return The instance model objects corresponding to the given URIs
	 */
	private Collection<EObject> urisToInstEObjs(ComponentInstance parent, Collection<String> uris) {
		// Rather than iterate through the list of children each time, we cache them temporarily
		Map<String, EObject> children = parent.getChildren().stream().filter(e -> e instanceof NamedElement)
				.collect(Collectors.toMap(e -> ((NamedElement) e).getName(), Function.identity()));

		return uris.stream().map(u -> uriToInstEObj(children, u, graphTableCache.get(parent).table))
				.filter(Objects::nonNull).collect(Collectors.toSet());
	}

	/**
	 * Convert a single AWAS URI to its instance model representation, assuming that representation
	 * is in the supplied list.
	 *
	 * @param children The set of instance objects that may contain the objects the URI identifies
	 * @param uri The URI of the instance object we want
	 * @param st The symboltable associated with the containing component. Used to map ports to their
	 * containing components
	 * @return The instance object associated with the given URI, or null if it can't be found
	 */
	private EObject uriToInstEObj(Map<String, EObject> children, String uri, SymbolTable st) {
		// If we're given the URI of a port (virtual or not) we grab the associated component
		if(SymbolTableHelper.uri2TypeString(uri).equals(SymbolTableHelper.PORT_OUT_VIRTUAL_TYPE()) ||
				SymbolTableHelper.uri2TypeString(uri).equals(SymbolTableHelper.PORT_IN_VIRTUAL_TYPE())
				|| SymbolTableHelper.uri2TypeString(uri).equals(SymbolTableHelper.PORT_OUT_TYPE())
				|| SymbolTableHelper.uri2TypeString(uri).equals(SymbolTableHelper.PORT_IN_TYPE())) {
			uri = JavaConverters.toJavaList(SymbolTableHelper.getAllAncestors(uri, st)).get(1);
		}
		String componentName = SymbolTableHelper.uri2IdString(uri);

		if (!children.containsKey(componentName)) {
			// Right now this only is hit when we're given an error uri -- I don't think we can
			// get an EObject for an error type / token
			System.err.println("AWASManager.java: unknown component name derived from: " + uri);
		}
		return children.get(componentName);
	}

	/**
	 * Class used for caching AWAS objects.
	 */
	private class AWASCacheTriple {
		private FlowGraph<FlowNode, FlowEdge<FlowNode>> graph;
		private SymbolTable table;
		private AwasGraphImpl agi;

		public AWASCacheTriple(FlowGraph<FlowNode, FlowEdge<FlowNode>> graph, SymbolTable table) {
			this.graph = graph;
			this.table = table;
			this.agi = new AwasGraphImpl(graph, table);
		}
	}
}
