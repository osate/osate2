package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.ge.internal.query.Queryable;

/**
 * Utility functions for working with flow specifications and end to end flow specifications.
 *
 */
public class AadlFlowSpecificationUtil {
	/**
	 * Simple type for referencing a flow segment. This is more specific than a flow segment in the declarative model because the context or parent of such flow segments cannot be
	 * tied to a unique element in a queryable tree such as a diagram.
	 *
	 */
	public static class FlowSegmentReference {
		public final NamedElement flowSegmentElement; // The element portion of the flow segment being referenced.
		public final Queryable container;

		private FlowSegmentReference(final NamedElement flowSegmentElement, final Queryable container) {
			this.flowSegmentElement = Objects.requireNonNull(flowSegmentElement, "flowSegmentElement must not be null");
			this.container = Objects.requireNonNull(container, "container must not be null");
		}
	}

	public static Queryable findQueryable(final FlowSegmentReference flowElementRef) {
		return flowElementRef.container.getChildren().stream()
				.filter(child -> flowElementRef.flowSegmentElement == child.getBusinessObject()).findAny().orElse(null);
	}

	/**
	 * Returns a stream of flow elements that are referred to by a specified flow element.
	 * Returns an empty stream for all flow element references which are not a flow specification or end to end flow.
	 * @param flowElementRef
	 * @return
	 */
	public static Stream<FlowSegmentReference> findChildren(final FlowSegmentReference flowElementRef) {
		if (flowElementRef.flowSegmentElement instanceof FlowSpecification) {
			// Check if flow specification has flow implementation(s)
			return AadlClassifierUtil.getComponentImplementation(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllFlowImplementations().stream()
							.filter(cfi -> flowElementRef.flowSegmentElement == cfi.getSpecification())
							.flatMap(cfi -> cfi.getOwnedFlowSegments().stream())
							.map(flowSegment -> createFlowSegmentReference(flowSegment, flowElementRef.container)))
					.orElse(Stream.empty());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlow) {
			return AadlClassifierUtil.getComponentImplementation(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> ete.getAllFlowSegments().stream())
							.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
									flowElementRef.container)))
					.orElse(Stream.empty());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlowInstance) {
			return AadlClassifierUtil.getComponentInstance(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> {
								return ete.getFlowElements().stream()
										.map(fei -> {
											final List<Connection> referencedConnections = new ArrayList<>();
											ete.getEndToEndFlow().getAllFlowSegments().forEach(flowSeg -> {
												if (flowSeg.getFlowElement() instanceof Connection) {
													referencedConnections.add((Connection) flowSeg.getFlowElement());
												}
											});

											if (fei instanceof ConnectionInstance) {
												final ConnectionInstance conInst = (ConnectionInstance) fei;
												for (final ConnectionReference cr : conInst.getConnectionReferences()) {
													Object src = cr.getSource();
													Object dst = cr.getDestination();

													if (cr.getSource() instanceof FeatureInstance) {
														src = ((FeatureInstance) cr.getSource()).getFeature();
													}

													if (cr.getDestination() instanceof FeatureInstance) {
														dst = ((FeatureInstance) cr.getDestination()).getFeature();
													}

													for (final Connection con : referencedConnections) {
														if (con.getSource().getConnectionEnd() == src
																&& con.getDestination().getConnectionEnd() == dst) {
															return createFlowSegmentReference(cr,
																	flowElementRef.container);
														}
													}

												}

												return createFlowSegmentReference(fei, flowElementRef.container);
											}

											return createFlowSegmentReference(fei, flowElementRef.container);
										});
							}))
					.orElse(Stream.empty());
		} else {
			return Stream.empty();
		}
	}

	public static FlowSegmentReference createFlowSegmentReference(final Object bo, final Queryable container) {
		if (bo instanceof FlowSegment) {
			final FlowSegment flowSegment = (FlowSegment) bo;
			final FlowElement flowElement = flowSegment.getFlowElement();
			if (flowSegment.getContext() == null) {
				return createFlowSegmentReference(flowElement, container);
			} else {
				return container.getChildren().stream()
						.filter(child -> child.getBusinessObject() == flowSegment.getContext()).findAny()
						.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
						.orElse(null);
			}
		} else if (bo instanceof EndToEndFlowSegment) {
			final EndToEndFlowSegment flowSegment = (EndToEndFlowSegment) bo;
			final FlowElement flowElement = (FlowElement) flowSegment.getFlowElement();
			if (flowSegment.getContext() == null) {
				return createFlowSegmentReference(flowElement, container);
			} else {
				return container.getChildren().stream()
						.filter(child -> child.getBusinessObject() == flowSegment.getContext()).findAny()
						.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
						.orElse(null);
			}
		} else if (bo instanceof FlowElementInstance) {
			if (bo instanceof EndToEndFlowInstance) {
				return new FlowSegmentReference((NamedElement) bo, container);
			} else {
				final FlowElementInstance fei = (FlowElementInstance) bo;
				return container.getChildren().stream().filter(child -> {
					return child.getBusinessObject() == fei.getComponentInstance();
				}).findAny().map(contextQueryable -> {
					return new FlowSegmentReference(fei, contextQueryable);
				}).orElse(null);
			}
		} else if (bo instanceof NamedElement) {
			return new FlowSegmentReference((NamedElement) bo, container);
		} else {
			throw new RuntimeException("Unexpected business object: " + bo);
		}
	}
}
