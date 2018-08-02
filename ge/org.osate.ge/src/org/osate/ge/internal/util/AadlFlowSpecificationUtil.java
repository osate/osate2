package org.osate.ge.internal.util;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
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
				.filter(child -> flowElementRef.flowSegmentElement == child.getBusinessObject()).findAny()
				.orElse(null);
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
			if (flowElementRef.container.getBusinessObject() instanceof ComponentInstance) {
				final ComponentInstance ci = (ComponentInstance) flowElementRef.container.getBusinessObject();
				System.err.println(flowElementRef.flowSegmentElement + " flowSegmentele");
				System.err
				.println(ci.getEndToEndFlows().stream()
						.filter(ete -> ete.getEndToEndFlow() == flowElementRef.flowSegmentElement)
						.collect(Collectors.toList()).size() + " SIZE");

				System.err.println(ci.getEndToEndFlows().stream()
						.filter(ete -> ete.getEndToEndFlow() == flowElementRef.flowSegmentElement).flatMap(ete -> ete.getEndToEndFlow().getAllFlowSegments().stream()).collect(Collectors.toList()) + " SIZE@");


				ci.getEndToEndFlows().stream().filter(ete -> ete.getEndToEndFlow() == flowElementRef.flowSegmentElement)
				.flatMap(ete -> ete.getEndToEndFlow().getAllFlowSegments().stream())
				.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment, flowElementRef.container));
			}

			return AadlClassifierUtil.getComponentImplementation(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> ete.getAllFlowSegments().stream())
							.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
									flowElementRef.container)))
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
						.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable)).orElse(null);
			}
		} else if (bo instanceof EndToEndFlowSegment) {
			System.err.println(bo + " BOAA");

			final EndToEndFlowSegment flowSegment = (EndToEndFlowSegment) bo;
			final FlowElement flowElement = (FlowElement) flowSegment.getFlowElement();
			if (flowSegment.getContext() == null) {
				System.err.println("BBB");
				return createFlowSegmentReference(flowElement, container);
			} else {
				System.err.println("CCCC");
				// System.err.println(container.getBusinessObject() + " container");

				if (container.getBusinessObject() instanceof ComponentInstance) {
					container.getChildren().stream().filter(child -> {
						// System.err.println(child.getBusinessObject() + " child");
						// System.err.println(flowSegment.getContext() + " getContext");
						return child.getBusinessObject() == flowSegment.getContext();
					}).collect(Collectors.toList());

					container.getChildren().stream()
					.filter(child -> child.getBusinessObject() instanceof ComponentInstance)
					.map(child -> (ComponentInstance) child.getBusinessObject()).filter(ci -> {
						System.err.println(ci.getSubcomponent() + " subcom");
						System.err.println(flowSegment.getContext() + " getContext");
						return ci.getClassifier() == flowSegment.getContext();
					}).collect(Collectors.toList());

					return container.getChildren().stream()
							.filter(child -> child.getBusinessObject() == flowSegment.getContext()).findAny()
							.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable))
							.orElse(null);
				} else {

					return container.getChildren().stream()
							.filter(child -> child.getBusinessObject() == flowSegment.getContext()).findAny()
							.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable)).orElse(null);
				}
			}
		} else if (bo instanceof NamedElement) {
			return new FlowSegmentReference((NamedElement) bo, container);
		} else {
			throw new RuntimeException("Unexpected business object: " + bo);
		}
	}
}
