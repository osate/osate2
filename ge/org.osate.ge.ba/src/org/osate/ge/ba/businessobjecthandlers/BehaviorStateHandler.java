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
package org.osate.ge.ba.businessobjecthandlers;

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.declarative.DeclarativeBehaviorTransition;
import org.osate.ba.declarative.Identifier;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.ba.util.BehaviorAnnexNamingUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.CustomRenamer;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.StyleBuilder;

/**
 * Business Object Handler for {@link BehaviorState}.
 */
public class BehaviorStateHandler implements BusinessObjectHandler, CustomDeleter, CustomRenamer {
	private static final GraphicalConfiguration graphicalConfig = GraphicalConfigurationBuilder.create()
			.graphic(EllipseBuilder.create().build()).style(StyleBuilder.create().labelsCenter().build()).build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorState.class).isPresent();
	}

	@Override
	public boolean canRename(final CanRenameContext ctx) {
		return true;
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorState behaviorState = ctx.getBusinessObject(BehaviorState.class).get();
		return new CanonicalBusinessObjectReference(BehaviorAnnexReferenceUtil.STATE_TYPE,
				behaviorState.getName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final BehaviorState behaviorState = ctx.getBusinessObject(BehaviorState.class).get();
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.STATE_TYPE, behaviorState.getName());
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(graphicalConfig);
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(BehaviorState.class).map(BehaviorState::getName).orElse("");
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		final BehaviorAnnex behaviorAnnex = ctx.getContainerBusinessObject(BehaviorAnnex.class).get();
		// Find state by URI.
		final BehaviorState behaviorState = (BehaviorState) behaviorAnnex.eResource().getResourceSet()
				.getEObject(EcoreUtil.getURI(ctx.getReadonlyBoToDelete(BehaviorState.class).get()), true);
		EcoreUtil.remove(behaviorState);
		if (behaviorAnnex.getStates().isEmpty()) {
			behaviorAnnex.unsetStates();
		}
	}

	@Override
	public void rename(final RenameContext ctx) {
		final BehaviorState behaviorState = ctx.getBusinessObject(BehaviorState.class).get();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorState.getOwner();
		final String originalName = behaviorState.getName();
		final String newName = ctx.getNewName();

		// Handle DeclarativeBehaviorTransistions
		// Set the ID for source and destination states because they do not update if an invalid state name change occurs
		behaviorAnnex.getTransitions().stream().filter(DeclarativeBehaviorTransition.class::isInstance)
				.forEach(transition -> {
					final DeclarativeBehaviorTransition dt = (DeclarativeBehaviorTransition) transition;
					final EList<Identifier> srcStates = dt.getSrcStates();
					if (!srcStates.isEmpty()) {
						// Set id for source and destination
						setId(srcStates.get(0), originalName, newName);
						setId(dt.getDestState(), originalName, newName);
					}
		});

		behaviorState.setName(newName);
	}

	private static void setId(final Identifier identifier, final String originalName, final String newName) {
		final String id = identifier.getId();
		if (originalName.equalsIgnoreCase(id)) {
			identifier.setId(newName);
		}
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return BehaviorAnnexNamingUtil.checkNameValidity(ctx);
	}
}
