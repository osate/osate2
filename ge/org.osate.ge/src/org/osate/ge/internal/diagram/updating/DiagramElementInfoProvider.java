package org.osate.ge.internal.diagram.updating;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.AgeDiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;

/**
 * Provides values used to configure diagram elements during an update.
 *
 */
public interface DiagramElementInfoProvider {
	/**
	 * Provides the graphic that should be used for a business object. 
	 * The specified diagram element may not be fully initialized. Only the business object and container fields are guaranteed to be initialized.
	 * @param element
	 * @return
	 */
	Graphic getGraphic(AgeDiagramElement element);
	
	/**
	 * The specified diagram element may not be fully initialized. Only the business object and container fields are guaranteed to be initialized.
	 * @param element
	 * @return the default docking position. Must not be null.
	 */
	DockingPosition getDefaultDockingPosition(AgeDiagramElement element);
	
	/**
	 * 
	 * @param element
	 * @return may return null.
	 */
	AgeLabelConfiguration getDefaultLabelConfiguration(AgeDiagramElement element);
	
	AgeDiagramElement getConnectionStart(final AgeDiagramElement e);
	AgeDiagramElement getConnectionEnd(final AgeDiagramElement e);
}