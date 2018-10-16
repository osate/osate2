package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.instance.ConnectionReference;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class ConnectionReferenceHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static final Style style = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	private static final Style partialStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dotted().build();
	private static StandaloneQuery srcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference((ConnectionReference cr) -> AadlHelper
							.getPathToBusinessObject(cr.getComponentInstance(), cr.getSource()))
					.first());
	private static StandaloneQuery partialSrcQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference(
							(ConnectionReference cr) -> AadlHelper
									.getPathToBusinessObject(cr.getComponentInstance(), cr.getSource()),
							1)
					.first());
	private static StandaloneQuery dstQuery = StandaloneQuery
			.create((rootQuery) -> rootQuery.parent()
					.descendantsByBusinessObjectsRelativeReference((ConnectionReference cr) -> AadlHelper
							.getPathToBusinessObject(cr.getComponentInstance(), cr.getDestination()))
					.first());
	private static StandaloneQuery partialDstQuery = StandaloneQuery.create((rootQuery) -> rootQuery.parent()
			.descendantsByBusinessObjectsRelativeReference((ConnectionReference cr) -> AadlHelper
					.getPathToBusinessObject(cr.getComponentInstance(), cr.getDestination()), 1)
			.first());

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalRepresentation(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final QueryService queryService) {
		BusinessObjectContext src = queryService.getFirstResult(srcQuery, boc);
		BusinessObjectContext dst = queryService.getFirstResult(dstQuery, boc);
		boolean partial = false;

		if(src == null) {
			src = queryService.getFirstResult(partialSrcQuery, boc);
			partial = true;
		}

		if(dst == null) {
			dst = queryService.getFirstResult(partialDstQuery, boc);
			partial = true;
		}

		if (src == dst) {
			return null;
		}

		// Don't display connection references when one endpoint is an ancestor of the other. This can happen for a subset of partial connections.
		if (src != null && dst != null) {
			for(BusinessObjectContext srcAncestor = src.getParent(); srcAncestor != null; srcAncestor = srcAncestor.getParent()) {
				if(srcAncestor == dst) {
					return null;
				}
			}

			for(BusinessObjectContext dstAncestor = dst.getParent(); dstAncestor != null; dstAncestor = dstAncestor.getParent()) {
				if(dstAncestor == src) {
					return null;
				}
			}
		}

		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				style(partial ? partialStyle : style).
				source(src).
				destination(dst).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ConnectionReference cr) {
		return cr.getFullName();
	}
}
