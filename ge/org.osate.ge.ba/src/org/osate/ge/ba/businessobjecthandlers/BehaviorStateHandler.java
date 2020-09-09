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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Subprogram;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.ba.util.BehaviorAnnexHandlerUtil;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CanRenameContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.CustomRenamer;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.PasteContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.StyleBuilder;

/**
 * Business Object Handler for {@link BehaviorState}
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
		return ctx.getBusinessObject(BehaviorState.class).map(bs -> {
			final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) bs.getOwner();

			// Cannot delete a source or destination of transition
			if (behaviorAnnex.getTransitions().stream()
					.anyMatch(bt -> bt.getSourceState() == bs || bt.getDestinationState() == bs)) {
				return false;
			}

			final Classifier classifier = behaviorAnnex.getContainingClassifier();
			if (bs.isInitial() && BehaviorAnnexHandlerUtil.requireSingleInitialState(classifier)) {
				return false;
			}

			if (bs.isComplete() && BehaviorAnnexHandlerUtil.requiresCompleteState(classifier)) {
				// Can delete if there are more than 1 complete states
				final long completeStates = behaviorAnnex.getStates().stream().filter(BehaviorState::isComplete)
						.count();
				return completeStates > 1;
			}

			// Subprogram requires single final state
			if (bs.isFinal() && classifier instanceof Subprogram) {
				return false;
			}

			return true;
		}).orElse(false);
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		return new CanonicalBusinessObjectReference(BehaviorAnnexReferenceUtil.STATE_TYPE,
				ctx.getBusinessObject(BehaviorState.class).get().getName());
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		return new RelativeBusinessObjectReference(BehaviorAnnexReferenceUtil.STATE_TYPE,
				ctx.getBusinessObject(BehaviorState.class).get().getName());
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
		final BehaviorState behaviorStateToModify = ctx.getContainerBusinessObject(BehaviorState.class).get();
		final BehaviorAnnex behaviorAnnexToModify = (BehaviorAnnex) behaviorStateToModify.eContainer();
		EcoreUtil.remove(behaviorStateToModify);
		if (behaviorAnnexToModify.getStates().isEmpty()) {
			behaviorAnnexToModify.unsetStates();
		}
	}

	@Override
	public void rename(final RenameContext ctx) {
		final BehaviorState behaviorState = ctx.getBusinessObject(BehaviorState.class).get();
		behaviorState.setName(ctx.getNewName());
	}

	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return BehaviorAnnexNamingUtil.checkNameValidity(ctx);
	}

	@Override
	public void afterPaste(final PasteContext ctx) {
		ctx.getBusinessObject(BehaviorState.class).ifPresent(behaviorState -> {
			final BehaviorAnnex behaviorAnnex = Objects.requireNonNull((BehaviorAnnex) behaviorState.getOwner(),
					"behavior annex cannot be null");
			final Classifier containingClassifier = Objects.requireNonNull(behaviorAnnex.getContainingClassifier(),
					"containing classifier cannot be null");

			// Abstract and system can have multiple initials and finals
			// Always will have an initial, determine if multiple are allowed
			if (containingClassifier instanceof Subprogram) {
				// Make sure there is only one final and one initial state
				behaviorState.setInitial(false);
				behaviorState.setFinal(false);
			}
		});
	}
}
