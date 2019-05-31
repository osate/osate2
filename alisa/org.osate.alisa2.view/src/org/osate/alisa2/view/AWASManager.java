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
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.sireum.aadl.ir.Aadl;
import org.sireum.aadl.osate.util.Util;
import org.sireum.awas.AADLBridge.AadlHandler;
import org.sireum.awas.ast.Model;
import org.sireum.awas.awasfacade.AwasGraphImpl;
import org.sireum.awas.fptc.FlowEdge;
import org.sireum.awas.fptc.FlowGraph;
import org.sireum.awas.fptc.FlowNode;
import org.sireum.awas.symbol.SymbolTable;
import org.sireum.awas.symbol.SymbolTableHelper;
import org.sireum.awas.util.JavaConverters;
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
public class AWASManager {

	private Map<ComponentInstance, AWASCacheTriple> graphTableCache;

	private AWASManager() {
		graphTableCache = new HashMap<>();
	}

	private static class LazyHolder {
		static final AWASManager INSTANCE = new AWASManager();
	}

	public static AWASManager getInstance() {
		return LazyHolder.INSTANCE;
	}

	public Collection<EObject> getNeighbors(ComponentInstance component) throws NoSuchElementException {
		ComponentInstance parent = component.getContainingComponentInstance();
		initTableAndGraph(parent);
		FlowNode flowNode = JavaConverters.toJavaOptional(FlowNode.getNode(
				SymbolTableHelper.getUriFromString(graphTableCache.get(parent).table, component.getName()).get()))
				.get();
		FlowGraph<FlowNode, FlowEdge<FlowNode>> nodeGraph = flowNode.getOwner();
		Set<FlowNode> neighbors = new HashSet<>();
		neighbors.addAll(JavaConverters.toJavaSet(nodeGraph.getPredecessorNodes(flowNode)));
		neighbors.addAll(JavaConverters.toJavaSet(nodeGraph.getSuccessorNodes(flowNode)));
		Set<String> uris = neighbors.stream().map(n -> n.getUri()).collect(Collectors.toSet());
		return urisToInstEObjs(parent, uris);
	}

	private void initTableAndGraph(ComponentInstance component) {
		if (graphTableCache.containsKey(component)) {
			return;
		}
		Aadl airModel = Util.getAir(component, false);
		Model awasModel = AadlHandler.buildAwasModel(airModel);
		SymbolTable st = SymbolTable.apply(awasModel, new ConsoleTagReporter());
		FlowGraph<FlowNode, FlowEdge<FlowNode>> graph = FlowGraph.apply(awasModel, st);
		graphTableCache.put(component, new AWASCacheTriple(graph, st));
	}

	public Collection<EObject> backwardReach(ErrorType et, FeatureInstance feature) {
		ComponentInstance parent = feature.getContainingComponentInstance().getContainingComponentInstance();
		initTableAndGraph(parent);
		AWASCacheTriple gtc = graphTableCache.get(parent);

		String port = feature.getComponentInstancePath();
		String error = EcoreUtil2.getContainerOfType(et, AadlPackageImpl.class).getName() + "." + et.getName();

		SymbolTableHelper.getUriFromString(gtc.table, port);
		SymbolTableHelper.getErrorUri(gtc.table, error);

//		gtc.agi.forwardErrorReachUsingNames(port, error);
		gtc.agi.backwardErrorReachUsingNames(port, error);

		return urisToInstEObjs(parent,
				gtc.agi.backwardErrorReachUsingNames(port, error)
						.get(SymbolTableHelper.getUriFromString(gtc.table, feature.getComponentInstancePath()).get()));
	}

	public Collection<EObject> backwardReach(ComponentInstance component) {
		ComponentInstance parent = component.getContainingComponentInstance();
		initTableAndGraph(parent);
		return urisToInstEObjs(parent, graphTableCache.get(parent).agi.backwardReachUsingNames(component.getName()));
	}


	public Collection<EObject> forwardReach(ComponentInstance component) {
		ComponentInstance parent = component.getContainingComponentInstance();
		initTableAndGraph(parent);
		return urisToInstEObjs(parent, graphTableCache.get(parent).agi.forwardReachUsingNames(component.getName()));
	}

	private Collection<EObject> urisToInstEObjs(ComponentInstance parent, Collection<String> uris) {
		// Rather than iterate through the list of children each time, we cache them temporarily
		Map<String, EObject> children = parent.getChildren().stream().filter(e -> e instanceof NamedElement)
				.collect(Collectors.toMap(e -> ((NamedElement) e).getName(), Function.identity()));
		// The null filter shouldn't be necessary here -- it hides problems in the uriToInstEObj method
		return uris.stream().map(u -> uriToInstEObj(children, u)).filter(Objects::nonNull).collect(Collectors.toSet());
	}

	private EObject uriToInstEObj(Map<String, EObject> children, String uri) {
		String canonicalName = SymbolTableHelper.uri2CanonicalName(uri);
		String componentName = canonicalName;
		if (canonicalName.contains(".")) {
			componentName = canonicalName.substring(0, canonicalName.indexOf('.'));
		}

		if (!children.containsKey(componentName)) {
			// I feel like this shouldn't happen... talk to Hari about this
			System.err.println("AWASManager.java: unknown component name derived from: " + canonicalName);
		}
		return children.get(componentName);
	}

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
