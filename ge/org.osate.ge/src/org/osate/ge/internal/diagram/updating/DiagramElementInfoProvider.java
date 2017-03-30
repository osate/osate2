package org.osate.ge.internal.diagram.updating;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.labels.AgeLabelConfiguration;

/**
 * Provides values used to configure diagram elements during an update.
 * Only the business object, references, and container fields are guaranteed to be initialized.
 *
 */
public interface DiagramElementInfoProvider {
	/**
	 * Provides the graphic that should be used for a business object. 
	 * The specified diagram element may not be fully initialized.
	 * @param element
	 * @return must not be null.
	 */
	Graphic getGraphic(DiagramElement element);
	
	/**
	 * The specified diagram element may not be fully initialized.
	 * @param element
	 * @return the default docking position. Must not be null.
	 */
	DockingPosition getDefaultDockingPosition(DiagramElement element);
	
	/**
	 * 
	 * @param element
	 * @return must not return null.
	 */
	AgeLabelConfiguration getDefaultLabelConfiguration(DiagramElement element);
	
	DiagramElement getConnectionStart(DiagramElement element);
	DiagramElement getConnectionEnd(DiagramElement element);
}