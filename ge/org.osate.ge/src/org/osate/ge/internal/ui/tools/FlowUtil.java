package org.osate.ge.internal.ui.tools;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.util.AadlHelper;

public class FlowUtil {
	private FlowUtil() {
	}

	static Queue<Element> getAncestors(Queryable container, final Optional<BusinessObjectContext> ancestorBoc) {
		final Queue<Element> ancestors = Collections.asLifoQueue(new LinkedList<>());
		for (; container.getBusinessObject() != ancestorBoc.map(BusinessObjectContext::getBusinessObject)
				.orElse(null); container = container.getParent()) {
			ancestors.add((Element) container.getBusinessObject());
		}

		return ancestors;
	}

	static BusinessObjectContext getBusinessObjectContext(final BusinessObjectContext boc,
			final BusinessObjectContext ancestor, final BusinessObjectContext defaultValue) {
		final Queue<Element> localAncestors = getAncestors(boc, Optional.of(ancestor));
		return getAncestorDiagramElement(ancestor, localAncestors).orElse(defaultValue);
	}

	static Map<NamedElement, BusinessObjectContext> getSegmentToBocMap(
			final Set<BusinessObjectNode> nodes,
			final BusinessObjectContext ancestor) {
		return nodes.stream()
				.collect(Collectors.toMap(
						boc -> AadlHelper.getRootRefinedElement((NamedElement) boc.getBusinessObject()),
						boc -> getBusinessObjectContext(boc, ancestor, boc)));
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

	static String getRefinedName(final NamedElement ne) {
		return AadlHelper.getRootRefinedElement(ne).getName();
	}
}
