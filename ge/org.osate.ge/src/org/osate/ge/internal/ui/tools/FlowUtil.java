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
