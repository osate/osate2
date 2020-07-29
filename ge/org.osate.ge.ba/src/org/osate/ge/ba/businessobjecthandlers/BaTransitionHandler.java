package org.osate.ge.ba.businessobjecthandlers;

import java.util.Optional;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.ba.model.BehaviorAnnexTransition;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleteContext;
import org.osate.ge.businessobjecthandling.CustomDeleter;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class BaTransitionHandler implements BusinessObjectHandler, CustomDeleter {
	private final static String TYPE_TRANSITION = "ba_transition";

	private static final Graphic transitionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().build()).build();

	private static final StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference(
					(BehaviorAnnexTransition bt) -> bt.getSource()));
	private static final StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference(
					(BehaviorAnnexTransition bt) -> bt.getDestination()));

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorAnnexTransition.class).isPresent();
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorAnnexTransition.class)
				.map(BehaviorAnnexTransition::getTransition).get();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.getOwner();
		final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
		return new CanonicalBusinessObjectReference(TYPE_TRANSITION, behaviorAnnex.getQualifiedName(),
				Integer.toString(index));
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorAnnexTransition.class)
				.map(BehaviorAnnexTransition::getTransition).get();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.getOwner();
		final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
		return new RelativeBusinessObjectReference(TYPE_TRANSITION, behaviorAnnex.getName(), Integer.toString(index));
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		final BusinessObjectContext boc = ctx.getBusinessObjectContext();
		final QueryService queryService = ctx.getQueryService();
		return Optional.of(GraphicalConfigurationBuilder.create().graphic(transitionGraphic)
				.source(getSource(boc, queryService)).destination(getDestination(boc, queryService))
				.style(StyleBuilder.create().backgroundColor(Color.BLACK).build()).build());
	}

	private BusinessObjectContext getSource(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(srcQuery, boc);
	}

	private BusinessObjectContext getDestination(final BusinessObjectContext boc, final QueryService queryService) {
		return queryService.getFirstResult(dstQuery, boc);
	}

	@Override
	public String getName(final GetNameContext ctx) {
		// TODO fix naming
		return "Behavior Transition";
//		return ctx.getBusinessObject(BehaviorAnnexTransition.class).map(BehaviorAnnexTransition::getTransition)
//				.map(transition -> "").orElse("");
	}

	@Override
	public void delete(final CustomDeleteContext ctx) {
		final BehaviorTransition behaviorTransitionToModify = ctx.getContainerBusinessObject(BehaviorTransition.class)
				.get();
		final BehaviorAnnex behaviorAnnexToModify = (BehaviorAnnex) behaviorTransitionToModify.getOwner();
		EcoreUtil.remove(behaviorTransitionToModify);
		if (behaviorAnnexToModify.getTransitions().size() == 0) {
			behaviorAnnexToModify.unsetTransitions();
		}
	}
}
