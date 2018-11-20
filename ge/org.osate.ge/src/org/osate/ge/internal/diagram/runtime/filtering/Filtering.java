package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.Generalization;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.model.SubprogramCallOrder;

public class Filtering {
	// Determines which business objects should be available to set as manual from the configure diagram dialog.
	// Subprogram call order and generalizations don't have appropriate labels.
	// Property value groups are special and created based on the diagram configuration.
	public static boolean isConfigurable(final ContentFilterProvider contentFilterProvider, final Object bo) {
		if (bo instanceof SubprogramCallOrder || bo instanceof Generalization || bo instanceof PropertyValueGroup
				|| bo instanceof EmbeddedBusinessObject) {
			return false;
		}

		return !contentFilterProvider.isFundamental(bo);
	}
}
