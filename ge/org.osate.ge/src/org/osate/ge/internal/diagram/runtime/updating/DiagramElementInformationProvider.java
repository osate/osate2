package org.osate.ge.internal.diagram.runtime.updating;

import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Provides values used to configure diagram elements during an update.
 * Only the business object, references, and container fields of the diagram element arguments are guaranteed to be initialized.
 *
 */
public interface DiagramElementInformationProvider extends BusinessObjectHandlerProvider {
	/**
	 * Returns the name for the business object's name label
	 * @param element
	 * @return
	 */
	String getLabelName(DiagramElement element);

	/**
	 * Returns the name to be displayed in the user interface for the business object
	 * @param element
	 * @return
	 */
	String getUserInterfaceName(DiagramElement element);

	/**
	 * Provides the graphic configuration should be used for a business object.
	 * The specified diagram element may not be fully initialized.
	 * @param element
	 * @return must not be null.
	 */
	AgeGraphicalConfiguration getGraphicalConfiguration(DiagramElement element);
}