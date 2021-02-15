/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba.businessobjecthandlers;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Mode;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.AnnexHandler;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.GetNameForDiagramContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.StyleBuilder;

/**
 * Business object handler for {@link BehaviorAnnex}. This handler only exists to prevent the annex from being added by the AADL
 * business object provider. Since the object isn't contributed at this time, the other methods are not necessary.
 */
public class BehaviorSpecificationHandler implements BusinessObjectHandler {
	final AnnexHandler annexHandler = new AnnexHandler();
	private static final GraphicalConfiguration graphicalConfig = GraphicalConfigurationBuilder.create()
			.graphic(RectangleBuilder.create().build())
			.style(StyleBuilder.create().labelsHorizontalCenter().labelsTop().build()).build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorAnnex.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return annexHandler.getCanonicalReference(ctx);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return annexHandler.getRelativeReference(ctx);
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(graphicalConfig);
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return BehaviorAnnexReferenceUtil.ANNEX_NAME;
	}

	@Override
	public String getNameForDiagram(final GetNameForDiagramContext ctx) {
		final BusinessObjectContext boc = Objects.requireNonNull(ctx.getBusinessObjectContext(),
				"Context cannot be null");
		return boc.getBusinessObject(BehaviorAnnex.class).map(behaviorAnnex -> {
			final DefaultAnnexSubclause annexSubclause = (DefaultAnnexSubclause) behaviorAnnex.getOwner();
			final Classifier classifier = Objects.requireNonNull(annexSubclause.getContainingClassifier(),
					"Classifier cannot be null");

			final StringBuilder builder = new StringBuilder();
			final Object diagramRootBo = getDiagramRootBusinessObject(boc);
			if (diagramRootBo instanceof BehaviorAnnex) {
				builder.append(classifier.getName());
				builder.append("::");
				appendBehaviorAnnexName(builder);
				appendInModes(behaviorAnnex, builder);
			} else {
				appendBehaviorAnnexName(builder);
			}

			return builder.toString();
		}).orElse("");
	}

	private static void appendBehaviorAnnexName(final StringBuilder builder) {
		builder.append("<");
		builder.append(BehaviorAnnexReferenceUtil.ANNEX_NAME);
		builder.append(">");
	}

	private static void appendInModes(final BehaviorAnnex behaviorAnnex, final StringBuilder builder) {
		final Set<String> inModes = behaviorAnnex.getAllInModes().stream().map(Mode::getName)
				.collect(Collectors.toSet());
		if (!inModes.isEmpty()) {
			builder.append(" in modes (");
			builder.append(String.join(", ", inModes));
			builder.append(")");
		}
	}

	private static Object getDiagramRootBusinessObject(BusinessObjectContext tmp) {
		while (tmp.getParent() != null && tmp.getParent().getBusinessObject() != null) {
			tmp = tmp.getParent();
		}

		return Objects.requireNonNull(tmp.getBusinessObject(), "Diagram root object cannot be null");
	}
}
