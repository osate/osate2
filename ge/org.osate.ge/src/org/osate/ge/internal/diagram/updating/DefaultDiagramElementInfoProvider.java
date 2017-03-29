package org.osate.ge.internal.diagram.updating;

import java.util.Objects;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;
import org.osate.ge.internal.labels.LabelConfigurationBuilder;

// TODO: Document
// TODO: Rename
public class DefaultDiagramElementInfoProvider implements DiagramElementInfoProvider {
	private final BusinessObjectHandlerProvider bohProvider;
	
	public DefaultDiagramElementInfoProvider(final BusinessObjectHandlerProvider bohProvider) {
		this.bohProvider = Objects.requireNonNull(bohProvider, "bohProvider must not be null");
	}
	
	@Override
	public Graphic getGraphic(final AgeDiagramElement element) {
		final Object bo = element.getBusinessObject();
		final Object boh = bohProvider.getApplicableBusinessObjectHandler(bo);
		if(boh == null) {
			// TODO: Throw exception?
			return null;
		}
		
		// TODO: Implement
		return RectangleBuilder.create().build();
	}

	@Override
	public DockingPosition getDefaultDockingPosition(AgeDiagramElement element) {
		// TODO: Implement
		return DockingPosition.NOT_DOCKABLE;
	}

	@Override
	public AgeLabelConfiguration getDefaultLabelConfiguration(AgeDiagramElement element) {
		// TODO: Implement
		return (AgeLabelConfiguration)LabelConfigurationBuilder.create().center().build();
	}

	@Override
	public AgeDiagramElement getConnectionStart(AgeDiagramElement e) {
		// TODO: Implement
		return null;
	}

	@Override
	public AgeDiagramElement getConnectionEnd(AgeDiagramElement e) {
		// TODO: Implement
		return null;
	}
}
