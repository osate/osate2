package org.osate.ge.ba.businessobjecthandlers;

import java.util.Optional;

import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
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

public class BaTransitionHandler implements BusinessObjectHandler {
	private final static String TYPE_TRANSITION = "ba_transition";

	private static final Graphic transitionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().build()).build();

	private static StandaloneQuery srcQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference((BehaviorTransition bt) -> bt.getSourceState()));
	private static StandaloneQuery dstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent().children()
			.filterByBusinessObjectRelativeReference((BehaviorTransition bt) -> bt.getDestinationState()));


	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(BehaviorTransition.class).isPresent();
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).get();
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorTransition.getOwner();
		final int index = behaviorAnnex.getTransitions().indexOf(behaviorTransition);
		return new CanonicalBusinessObjectReference(TYPE_TRANSITION, behaviorAnnex.getQualifiedName(),
				Integer.toString(index));
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final BehaviorTransition behaviorTransition = ctx.getBusinessObject(BehaviorTransition.class).get();
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
		return ctx.getBusinessObject(BehaviorTransition.class).map(transition -> "").orElse("");
	}
}
