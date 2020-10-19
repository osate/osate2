package org.osate.asap.view;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.impl.AadlPackageImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.sireum.aadl.osate.awas.util.AwasUtil;
import org.sireum.aadl.osate.util.Util;
import org.sireum.awas.AADLBridge.AadlHandler;
import org.sireum.awas.ast.Model;
import org.sireum.awas.awasfacade.AwasGraphImpl;
import org.sireum.awas.flow.FlowEdge;
import org.sireum.awas.flow.FlowGraph;
import org.sireum.awas.flow.FlowNode;
import org.sireum.awas.flow.NodeType;
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

		neighbors.removeIf(n -> n.getResourceType() != NodeType.COMPONENT());

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
		// TODO: Add null check since features without parents can be passed in if, eg, the aaxl model is updated but the safe2 model isn't
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
		FlowNode flowNode = FlowNode.getNode(org.sireum.awas.symbol.Resource.getParentUri(portURI).get()).get();
		Set<String> propSet = JavaConverters.toJavaSet(flowNode.getPropagation(portURI));
		// Check the symbol table -- first entry (compSymbolTableMap) should have everything in the component
		Collection<EObject> ret = urisToInstEObjs(parent, propSet);

		return ret;
	}

	/**
	 * Convert the given AWAS URIs to their instance model representations, assuming they exist as children
	 * of the given component
	 *
	 * @param parent The component that should contain the components pointed to by the given URIs.
	 * @param uriSet URIs to components or ports (both will resolve to components)
	 * @return The instance model objects corresponding to the given URIs
	 */
	private Set<EObject> urisToInstEObjs(ComponentInstance parent, Set<String> uriSet) {

		Set<String> uris = Collections.unmodifiableSet(uriSet);
		SymbolTable st = graphTableCache.get(parent).table;
		Resource resource = parent.eResource();
		Set<EObject> haris = AwasUtil.awasUri2EObject(uris, st, resource);

		haris = haris.stream().map(e -> (e instanceof ConnectionReference ? e.eContainer() : e))
				.collect(Collectors.toSet());

		return haris;
	}

	public Collection<EObject> getAllConnections(ComponentInstance self) {
		initTableAndGraph(self);
		SymbolTable st = graphTableCache.get(self).table;
		String componentUri = SymbolTableHelper.getUriFromString(st, self.getInstanceObjectPath()).get();
		Set<String> connectionUris = JavaConverters
				.toJavaSet(st.componentTable(componentUri).connections().toSet());
		Collection<EObject> ret = urisToInstEObjs(self, connectionUris);
		return ret;
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
