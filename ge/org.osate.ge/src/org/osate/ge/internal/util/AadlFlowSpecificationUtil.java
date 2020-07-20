/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.util;

import java.util.Objects;
import java.util.stream.Stream;

import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
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

		public FlowSegmentReference(final NamedElement flowSegmentElement, final Queryable container) {
			this.flowSegmentElement = Objects.requireNonNull(flowSegmentElement, "flowSegmentElement must not be null");
			this.container = Objects.requireNonNull(container, "container must not be null");
		}
	}

	public static Queryable findQueryable(final FlowSegmentReference flowElementRef) {
		return flowElementRef.container.getChildren().stream()
				.filter(q -> {
					if (q.getBusinessObject() instanceof NamedElement) {
						final NamedElement ne = (NamedElement) q.getBusinessObject();
						return AadlHelper.getRootRefinedElement(ne) == AadlHelper
								.getRootRefinedElement(flowElementRef.flowSegmentElement);
					}
					return false;
				}).findAny().orElse(null);
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
							.filter(cfi -> AadlHelper.getRootRefinedElement(
									flowElementRef.flowSegmentElement) == AadlHelper.getRootRefinedElement(
											cfi.getSpecification()))
							.flatMap(cfi -> cfi.getOwnedFlowSegments().stream().filter(flowSegment -> flowSegment
									.getFlowElement() != cfi
									.getSpecification()))
							.map(flowSegment -> createFlowSegmentReference(flowSegment, flowElementRef.container)))
					.orElse(Stream.empty());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlow) {
			return AadlClassifierUtil.getComponentImplementation(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getAllEndToEndFlows().stream()
							.filter(ete -> AadlHelper.getRootRefinedElement(ete) == AadlHelper
							.getRootRefinedElement(flowElementRef.flowSegmentElement))
							.flatMap(ete -> getAllEteFlowSegments(
									ete))
							.map(eteFlowSegment -> createFlowSegmentReference(eteFlowSegment,
									flowElementRef.container)))
					.orElse(Stream.empty());
		} else if (flowElementRef.flowSegmentElement instanceof EndToEndFlowInstance) {
			return AadlInstanceObjectUtil.getComponentInstance(flowElementRef.container.getBusinessObject())
					.map(ci -> ci.getEndToEndFlows().stream().filter(ete -> ete == flowElementRef.flowSegmentElement)
							.flatMap(ete -> {
								return ete.getFlowElements().stream()
										.flatMap(fei -> {
											if (fei instanceof ConnectionInstance) {
												return ((ConnectionInstance) fei).getConnectionReferences().stream()
														.map(cr -> createFlowSegmentReference(cr,
																flowElementRef.container));
											} else {
												return Stream
														.of(createFlowSegmentReference(fei, flowElementRef.container));
											}
										});
							}))
					.orElse(Stream.empty());
		} else if (flowElementRef.flowSegmentElement instanceof FlowImplementation) {
			final FlowImplementation fi = (FlowImplementation) flowElementRef.flowSegmentElement;
			return fi.getOwnedFlowSegments().stream().map(
					flowSegment -> createFlowSegmentReference(flowSegment, flowElementRef.container));
		} else {
			return Stream.empty();
		}
	}

	// Flatten end to end flow segments that are end to end flows and remove cyclic end to end flow segments
	private static Stream<EndToEndFlowSegment> getAllEteFlowSegments(final EndToEndFlow eTEFlow) {
		return eTEFlow.getAllFlowSegments().stream()
				.filter(eTEFlowSegment -> eTEFlowSegment.getFlowElement() != eTEFlow)
				.flatMap(eTEFlowSegment -> {
					final EndToEndFlowElement eTEFlowElement = eTEFlowSegment.getFlowElement();
					if (eTEFlowElement instanceof EndToEndFlow) {
						return getAllEteFlowSegments((EndToEndFlow) eTEFlowElement);
					}

					return Stream.of(eTEFlowSegment);
				});
	}

	public static FlowSegmentReference createFlowSegmentReference(final Object bo, final Queryable container) {
		if (bo instanceof FlowSegment) {
			final FlowSegment flowSegment = (FlowSegment) bo;
			final FlowElement flowElement = flowSegment.getFlowElement();
			if (flowSegment.getContext() == null) {
				return createFlowSegmentReference(flowElement, container);
			} else {
				return container.getChildren().stream()
						.filter(child -> {
							if (child.getBusinessObject() instanceof NamedElement) {
								final NamedElement ne = (NamedElement) child.getBusinessObject();
								return AadlHelper.getRootRefinedElement(ne) == AadlHelper
										.getRootRefinedElement(flowSegment.getContext());
							}
							return false;
						}).findAny()
						.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable)).orElse(null);
			}
		} else if (bo instanceof EndToEndFlowSegment) {
			final EndToEndFlowSegment flowSegment = (EndToEndFlowSegment) bo;
			final FlowElement flowElement = (FlowElement) flowSegment.getFlowElement();
			if (flowSegment.getContext() == null) {
				return createFlowSegmentReference(flowElement, container);
			} else {
				return container.getChildren().stream()
						.filter(child -> {
							if (child.getBusinessObject() instanceof NamedElement) {
								final NamedElement ne = (NamedElement) child.getBusinessObject();
								return AadlHelper.getRootRefinedElement(ne) == AadlHelper
										.getRootRefinedElement(flowSegment.getContext());
							}
							return false;
						}).findAny()
						.map(contextQueryable -> createFlowSegmentReference(flowElement, contextQueryable)).orElse(null);
			}
		} else if (bo instanceof InstanceObject) {
			final InstanceObject io = (InstanceObject) bo;
			if (bo instanceof EndToEndFlowInstance) {
				return new FlowSegmentReference(io, container);
			} else {
				return container.getAllDescendants().filter(q -> q.getBusinessObject() == io)
						.findAny().map(q -> new FlowSegmentReference(io, q.getParent()))
						.orElse(null);
			}
		} else if (bo instanceof FlowImplementation) {
			final FlowImplementation fi = (FlowImplementation) bo;
			return new FlowSegmentReference(fi, container);
		} else if (bo instanceof NamedElement) {
			return new FlowSegmentReference((NamedElement) bo, container);
		} else {
			throw new RuntimeException("Unexpected business object: " + bo);
		}
	}
}
