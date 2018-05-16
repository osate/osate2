package org.osate.ge.internal.services.impl;

import java.util.List;

import javax.inject.Named;

import org.osate.ge.internal.di.GetCanonicalReferenceLabel;
import org.osate.ge.internal.di.GetRelativeReferenceLabel;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

/**
 * Provides labels for references to the instance models.
 * NOTE: Only supports system instance keys at this time.
 *
 */
public class InstanceReferenceLabelProvider {
	@GetCanonicalReferenceLabel
	public String getLabel(final @Named(InternalNames.REFERENCE) CanonicalBusinessObjectReference ref) {
		return getLabel(ref.getSegments());
	}

	@GetRelativeReferenceLabel
	public String getLabel(final @Named(InternalNames.REFERENCE) RelativeBusinessObjectReference ref) {
		return getLabel(ref.getSegments());
	}

	private static String getLabel(final List<String> segs) {
		if (segs.size() != 3) {
			return null;
		}

		final String id = segs.get(0);
		final String typeId = segs.get(1);
		if (!InstanceReferenceBuilder.ID.equals(id) || !InstanceReferenceBuilder.SYSTEM_INSTANCE_KEY.equals(typeId)) {
			return null;
		}

		return "System Instance " + segs.get(2);
	}
}
