package org.osate.ge.internal.diagram.runtime.filtering;

import org.osate.aadl2.Generalization;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.model.SubprogramCallOrder;
import org.osate.ge.internal.model.Tag;

public class Filtering {
	public static boolean isFundamental(final Object bo) {
		if(bo instanceof Tag) {
			final Tag tag = (Tag) bo;
			if (tag.key.equals(Tag.KEY_UNIDIRECTIONAL)) {
				return true;
			}
		}

		return false;
	}

	// Determines which business objects should be available to set as manual from the configure diagram dialog.
	// Subprogram call order and generalizations don't have appropriate labels.
	// Property value groups are special and created based on the diagram configuration.
	public static boolean isConfigurable(final Object bo) {
		if (bo instanceof SubprogramCallOrder || bo instanceof Generalization || bo instanceof PropertyValueGroup) {
			return false;
		}

		return !isFundamental(bo);
	}
}
