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
	private final Graph<OsateSlicerVertex, DefaultEdge> rg = new DefaultDirectedGraph<>(DefaultEdge.class);

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
	private Map<String, PossiblePropagation> possiblePropagations = new HashMap<>();

	public void buildGraph(SystemInstance si) {
		// Add vertices and explicit edges from core AADL
		SlicerSwitch coreSwitch = new SlicerSwitch();
		EcoreUtil.getAllContents(si.eResource(), true).forEachRemaining(elem -> {
			coreSwitch.doSwitch((Element) elem);
		});

		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
		// Add vertices and edges from EMV2 instance
		Emv2SlicerSwitch emv2Switch = new Emv2SlicerSwitch();
		EcoreUtil.getAllContents(si.eResource(), true).forEachRemaining(elem -> {
			emv2Switch.doSwitch((Element) elem);
		});

		// Propagate error tokens / connect explicit propagations
		calculateFixpoint();

		// Add implicit edges
		buildIntraConnections(hasExplicitDecomp);

		// Create a separate reversed graph, rather than a wrapper, saving CPU at the expense of memory
		Graphs.addGraphReversed(rg, g);

		// Debugging info, remove at-will
		System.out.println(this.toDot());
	}

	private String addVertex(ErrorPropagationInstance prop, TypeTokenInstance tti) {
		if (prop instanceof FeaturePropagation) {
			var v = new OsateSlicerVertex(((FeaturePropagation) prop).getFeature(), tti);
			return addVertex(v);
		} else if (prop instanceof AccessPropagation) {
			var component = EcoreUtil2.getContainerOfType(prop, ComponentInstance.class);
			var v = new OsateSlicerVertex(component, tti);
			return addVertex(v);
		} else if (prop instanceof BindingPropagation) {
			var component = EcoreUtil2.getContainerOfType(prop, ComponentInstance.class);
			var bindingType = ((BindingPropagation) prop).getBinding();
			var v = new OsateSlicerVertex(component, bindingType, tti);
			return addVertex(v);
		} else if (prop instanceof PointPropagation) {
			var component = EcoreUtil2.getContainerOfType(prop, ComponentInstance.class);
			var propName = ((PointPropagation) prop).getName();
			var v = new OsateSlicerVertex(component, propName, tti);
			return addVertex(v);
		}
		return null;
	}

	private String addVertex(OsateSlicerVertex v) {
		var name = v.getName();
		if (!vertexMap.containsKey(name)) {
			g.addVertex(v);
			vertexMap.put(name, v);
		}
		return name;
	}

	/**
	 * Adds a new edge from the source to the target
	 *
	 * @param src Source vertex
	 * @param tgt Target vertex
	 */
	private void addEdge(String src, String tgt) {
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
	public Collection<IObjErrorPair> backwardReach(InstanceObject comp, String propPointName, TypeTokenInstance token) {
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
	 * @param component Where to start the slice from, must be a component with some sort of binding relationship.
	 * @param binding The specific binding relationship
	 * @param token The error type that is propagated into / out of the component along the binding to start the slice from
	 * @return The set of reachable instance model elements and errors
	 */
	public Collection<IObjErrorPair> backwardReach(ComponentInstance component, BindingType binding,
			TypeTokenInstance token) {
		Set<IObjErrorPair> retSet = new HashSet<>();
		backwardReachability(component.getInstanceObjectPath() + "." + binding + "." + token.getFullName()).vertexSet()
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
	 * false if s/he wants vertices which point at the srcVert
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
				edges.addAll(g.outgoingEdgesOf(srcVrt));
				while (edges.size() > 0) {
					DefaultEdge e = edges.pop();
					OsateSlicerVertex dstVrt = g.getEdgeTarget(e);
					edges.addAll(0, g.outgoingEdgesOf(dstVrt));
					String componentName = dstVrt.getName().substring(0, dstVrt.getName().lastIndexOf('.'));
					if (possiblePropagations.containsKey(componentName)) {
						Optional<String> tgt = possiblePropagations.get(componentName).getTarget(dstVrt);
						if (tgt.isPresent() && !g.containsEdge(dstVrt, vertexMap.get(tgt.get()))) {
							edgesModified = true;
							addEdge(dstVrt.getName(), tgt.get());
							edges.push(g.getEdge(dstVrt, vertexMap.get(tgt.get())));
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
	private String toDot() {
		DOTExporter<OsateSlicerVertex, DefaultEdge> exporter = new DOTExporter<>(v -> "\"" + v.getName() + "\"");
		Writer writer = new StringWriter();
		exporter.exportGraph(g, writer);
		return writer.toString();
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
				TypeTokenInstance tti = (TypeTokenInstance) tse;
				String srcVertexName = addVertex(new OsateSlicerVertex(esi, tti));
				String tgtVertexName = addVertex(prop, tti);
				addEdge(srcVertexName, tgtVertexName);
			});
			return null;
		}

		@Override
		public Void caseErrorSinkInstance(ErrorSinkInstance esi) {
			var dstTypes = esi.getTypeSet().getElements();
			var prop = esi.getPropagation();
			dstTypes.stream().filter(tse -> tse instanceof TypeTokenInstance).forEach(tse -> {
				TypeTokenInstance tti = (TypeTokenInstance) tse;
				String tgtVertexName = addVertex(new OsateSlicerVertex(esi, tti));
				String srcVertexName = addVertex(prop, tti);
				addEdge(srcVertexName, tgtVertexName);
			});
			return null;
		}

		@Override
		public Void caseElement(Element e) {
			// for debugging
			return null;
		}

		@Override
		public Void caseErrorPathInstance(ErrorPathInstance epi) {
			var destProp = epi.getDestinationPropagation();
			var destTTI = epi.getDestinationTypeToken();
			String tgtVertexName = addVertex(destProp, destTTI);
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
				String srcVertexName = addVertex(srcProp, srcTTI);
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
			possiblePropagations.put(srcName, new PossiblePropagation(ppi));
			return null;
		}

		@Override
		public Void caseAccessPropagation(AccessPropagation object) {
			// TODO Auto-generated method stub
			return super.caseAccessPropagation(object);
		}

		@Override
		public Void caseConnectionPath(ConnectionPath cp) {
			return super.caseConnectionPath(cp);
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
			addVertex(new OsateSlicerVertex(fi));
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
				String srcName = addVertex(new OsateSlicerVertex(cr.getSource()));
				String dstName = addVertex(new OsateSlicerVertex(cr.getDestination()));
				addEdge(srcName, dstName);
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
