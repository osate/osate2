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
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphics.LabelBuilder;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.services.QueryService;
import org.osate.ge.internal.util.PropertyValueFormatter;

public class PropertyValueGroupHandler {
	private final Graphic labelGraphic = LabelBuilder.create().build();
	private static final Graphic referenceGraphic = ConnectionBuilder.create().
			dashed().
			destinationTerminator(ArrowBuilder.create().filled().small().build()).
			build();
	private static final Graphic abstractGraphic = ConnectionBuilder.create().
			dotted().
			destinationTerminator(ArrowBuilder.create().filled().small().build()).
			build();
	
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
			
			return GraphicalConfigurationBuilder.create().
					graphic(pvg.isAbstract() ? abstractGraphic : referenceGraphic).
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
		return PropertyValueFormatter.getUserString(boc, true, includeOnlyValuesBasedOnCompletelyProcessedAssociations, includeValues, false, false);
	}
}
