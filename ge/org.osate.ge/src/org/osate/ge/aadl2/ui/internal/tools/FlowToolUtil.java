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
package org.osate.ge.aadl2.ui.internal.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowSegment;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.util.AgeAadlUtil;
import org.osate.ge.aadl2.ui.internal.tools.FlowDialogUtil.SegmentData;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.services.ReferenceBuilderService;

public class FlowToolUtil {
	private FlowToolUtil() {
	}

	static Queue<Element> getAncestors(BusinessObjectContext container,
			final Optional<BusinessObjectContext> ancestorBoc) {
		final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<>());
		for (; container.getBusinessObject() != ancestorBoc.map(BusinessObjectContext::getBusinessObject)
				.orElse(null); container = container.getParent()) {
			ancestors.add((Element) container.getBusinessObject());
		}

		return ancestors;
	}

	static Optional<BusinessObjectContext> getAncestorDiagramElement(
			BusinessObjectContext ancestorBoc,
			final Queue<Element> ancestors) {
		Optional<DiagramElement> boc = null;
		for (; !ancestors.isEmpty(); ancestorBoc = boc.get()) {
			final Element ancestorElement = ancestors.poll();
			boc = ancestorBoc.getChildren().stream()
					.filter(child -> child instanceof DiagramElement && child.getBusinessObject() == ancestorElement)
					.findAny().map(DiagramElement.class::cast);
			if (!boc.isPresent()) {
				return Optional.empty();
			}
		}

		return Optional.of(ancestorBoc);
	}

	/**
	 * Creates a {@link SegmentData} instance for an end to end flow segment. The referenced {@link BusinessObjectContext} will be a {@link DiagramElement} if the flow segment is in the diagram.
	 * Otherwise, it will be an instance of a private implementation.
	 * @return the new {@link SegmentData} instance. Will not return null.
	 */
	public static SegmentData createSegmentData(final ReferenceBuilderService referenceBuilder,
			final DiagramElement container, final EndToEndFlowSegment seg) {
		final DiagramElement tmp;
		if (seg.getContext() == null) {
			tmp = container;
		} else {
			tmp = container.getByRelativeReference(referenceBuilder.getRelativeReference(seg.getContext()));
			if (tmp == null) {
				return new SegmentData(new ChildlessBusinessObjectContext(
						new ChildlessBusinessObjectContext(container, seg.getContext()), seg.getFlowElement()));
			}
		}

		if (seg.getFlowElement() instanceof EndToEndFlow) {
			final List<DiagramElement> highlightableSegments = new ArrayList<>();
			findSegmentDiagramElements((EndToEndFlow) AgeAadlUtil.getRootRefinedElement(seg.getFlowElement()), tmp,
					highlightableSegments);
			return new SegmentData(new ChildlessBusinessObjectContext(tmp, seg.getFlowElement()),
					highlightableSegments);
		} else {
			final DiagramElement flowElementDiagramElement = tmp
					.getByRelativeReference(referenceBuilder.getRelativeReference(seg.getFlowElement()));
			if (flowElementDiagramElement == null) {
				return new SegmentData(new ChildlessBusinessObjectContext(tmp, seg.getFlowElement()));
			}

			return new SegmentData(flowElementDiagramElement);
		}
	}

	/**
	 * Creates a {@link SegmentData} instance for a flow end. The referenced {@link BusinessObjectContext} will be a {@link DiagramElement} if the flow end is in the diagram.
	 * Otherwise, it will be an instance of a private implementation.
	 * @return the new {@link SegmentData} instance. Will not return null.
	 */
	public static SegmentData createSegmentData(final ReferenceBuilderService referenceBuilder,
			final DiagramElement container, final FlowEnd flowEnd) {
		final DiagramElement tmp;
		if (flowEnd.getContext() == null) {
			tmp = container;
		} else {
			tmp = container.getByRelativeReference(referenceBuilder.getRelativeReference(flowEnd.getContext()));
			if (tmp == null) {
				return new SegmentData(new ChildlessBusinessObjectContext(
						new ChildlessBusinessObjectContext(container, flowEnd.getContext()), flowEnd.getFeature()));
			}
		}

		final DiagramElement flowEndDiagramElement = tmp
				.getByRelativeReference(referenceBuilder.getRelativeReference(flowEnd.getFeature()));
		if (flowEndDiagramElement == null) {
			return new SegmentData(new ChildlessBusinessObjectContext(tmp, flowEnd.getFeature()));
		}

		return new SegmentData(flowEndDiagramElement);
	}

	/**
	 * Creates a {@link SegmentData} instance for a flow segment. The referenced {@link BusinessObjectContext} will be a {@link DiagramElement} if the flow segment is in the diagram.
	 * Otherwise, it will be an instance of a private implementation.
	 * @return the new {@link SegmentData} instance. Will not return null.
	 */
	public static SegmentData createSegmentData(final ReferenceBuilderService referenceBuilder,
			final DiagramElement container, final FlowSegment seg) {
		final DiagramElement tmp;
		if (seg.getContext() == null) {
			tmp = container;
		} else {
			tmp = container.getByRelativeReference(referenceBuilder.getRelativeReference(seg.getContext()));
			if (tmp == null) {
				return new SegmentData(new ChildlessBusinessObjectContext(
						new ChildlessBusinessObjectContext(container, seg.getContext()), seg.getFlowElement()));
			}
		}

		final DiagramElement flowElementDiagramElement = tmp
				.getByRelativeReference(referenceBuilder.getRelativeReference(seg.getFlowElement()));
		if (flowElementDiagramElement == null) {
			return new SegmentData(new ChildlessBusinessObjectContext(tmp, seg.getFlowElement()));
		}

		return new SegmentData(flowElementDiagramElement);
	}

	/**
	 * Finds the business object context for a specified element. If a child exists in the specified diagram element, then it will be returned. Otherwise, an instance of a private
	 * implementation will be returned.
	 * @return the {@link BusinessObjectContext}. Will not return null.
	 */
	public static BusinessObjectContext findOrCreateBusinessObjectContext(
			final ReferenceBuilderService referenceBuilder, final DiagramElement container, final Element e) {
		final BusinessObjectContext childBoc = container
				.getByRelativeReference(referenceBuilder.getRelativeReference(e));
		if (childBoc == null) {
			return new ChildlessBusinessObjectContext(container, e);
		}

		return childBoc;
	}

	/**
	 * Finds diagram elements for the segments of an end to end flow.
	 * @param eTEFlow is the flow for which to add the segments.
	 * @param eteFlowContainer container of the end to end flow.
	 * @param highlightableSegments is the list to which to add the segments.
	 */
	public static void findSegmentDiagramElements(final EndToEndFlow eTEFlow,
			final BusinessObjectContext eteFlowContainer, final List<DiagramElement> highlightableSegments) {
		final DiagramElement parentDe = (DiagramElement) eteFlowContainer;
		for (final EndToEndFlowSegment segment : eTEFlow.getOwnedEndToEndFlowSegments().stream()
				.filter(eTEFlowSegment -> eTEFlowSegment.getFlowElement() != eTEFlow).collect(Collectors.toList())) {
			BusinessObjectContext context = parentDe;
			if (segment.getContext() != null) {
				context = parentDe.getChildren().stream()
						.filter(child -> child.getBusinessObject() == segment.getContext()).findAny().orElse(null);
				if (context == null) {
					continue;
				}
			}

			if (segment.getFlowElement() instanceof EndToEndFlow) {
				findSegmentDiagramElements((EndToEndFlow) AgeAadlUtil.getRootRefinedElement(segment.getFlowElement()),
						context, highlightableSegments);
			} else if (segment.getFlowElement() instanceof FlowElement) {
				context.getChildren().stream().filter(child -> child.getBusinessObject() == segment.getFlowElement())
				.map(DiagramElement.class::cast).findAny().ifPresent(highlightableSegments::add);
			}
		}
	}

	/**
	 * Implementation of {@link BusinessObjectContext} which is intended for internal use by flow contribution items. Does not support listing children. Intended for use in cases
	 * where a {@link DiagramElement} does not exist for the element being referenced.
	 *
	 */
	public static class ChildlessBusinessObjectContext implements BusinessObjectContext {
		private final BusinessObjectContext parent;
		private final Object bo;

		public ChildlessBusinessObjectContext(final BusinessObjectContext parent, final Object bo) {
			this.parent = parent;
			this.bo = bo;
		}

		@Override
		public BusinessObjectContext getParent() {
			return parent;
		}

		@Override
		public Collection<? extends BusinessObjectContext> getChildren() {
			return Collections.emptyList();
		}

		@Override
		public Object getBusinessObject() {
			return bo;
		}
	}
}
