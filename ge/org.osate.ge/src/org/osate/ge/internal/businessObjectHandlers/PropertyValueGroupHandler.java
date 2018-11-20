package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.aadlproperties.PropertyValueFormatter;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.util.BusinessObjectContextUtil;
import org.osate.ge.services.QueryService;

public class PropertyValueGroupHandler {
	private final Graphic labelGraphic = LabelBuilder.create().build();
	private static final Graphic graphic = ConnectionBuilder.create().
			destinationTerminator(ArrowBuilder.create().filled().small().build()).
			build();
	private static final Style referenceStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dashed().build();
	private static final Style abstractStyle = StyleBuilder.create().backgroundColor(Color.BLACK).dotted().build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg,
			final AgeDiagramProvider diagramProvider) {

		if(pvg.getReferenceId() == null) {
			return createTextGraphicalConfiguration();
		} else {
			// Try to get the referenced element
			final DiagramElement referencedElement = diagramProvider.getAgeDiagram().findElementById(pvg.getReferenceId());
			if(referencedElement == null) {
				return null;
			}

			// If the reference is from the child to an ancestor or from an ancestor to a child, show it as text if it is is based on a completely processed
			// property association. Otherwise, don't show it at all.
			final BusinessObjectContext parent = boc.getParent();
			if (BusinessObjectContextUtil.isAncestor(parent, referencedElement)
					|| BusinessObjectContextUtil.isAncestor(referencedElement, parent)) {
				if (pvg.getFirstValueBasedOnCompletelyProcessedAssociation() == null) {
					return null;
				} else {
					return createTextGraphicalConfiguration();
				}
			}

			return GraphicalConfigurationBuilder.create().
					graphic(graphic).style(pvg.isAbstract() ? abstractStyle : referenceStyle)
					.
					source(boc.getParent()).
					destination(referencedElement).
					build();
		}
	}

	private GraphicalConfiguration createTextGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(labelGraphic).
				decoration().
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) PropertyValueGroup pvg,
			final QueryService queryService) {

		final boolean includeOnlyValuesBasedOnCompletelyProcessedAssociations = pvg.getReferenceId() == null;
		final boolean includeValues = pvg.getReferenceId() == null;
		return PropertyValueFormatter.getUserString(boc, true, includeOnlyValuesBasedOnCompletelyProcessedAssociations,
				includeValues, false, false);
	}
}
