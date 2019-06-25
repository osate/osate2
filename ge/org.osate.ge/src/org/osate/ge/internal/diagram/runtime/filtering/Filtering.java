package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.model.PropertyValueGroup;

public class Filtering {
	// Determines which business objects should be configurable using Hide and Show actions.
	// Property value groups are special and created based on the diagram configuration.
	public static boolean isConfigurable(final ContentFilterProvider contentFilterProvider, final Object bo) {
		if (bo instanceof PropertyValueGroup || bo instanceof EmbeddedBusinessObject) {
			return false;
		}

		return !contentFilterProvider.isFundamental(bo);
	}
}
