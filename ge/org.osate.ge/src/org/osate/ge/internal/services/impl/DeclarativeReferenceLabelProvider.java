package org.osate.ge.internal.services.impl;

import java.util.List;

import javax.inject.Named;

import org.osate.ge.internal.di.GetCanonicalReferenceLabel;
import org.osate.ge.internal.di.GetRelativeReferenceLabel;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.util.StringUtil;

import com.google.common.base.CaseFormat;

public class DeclarativeReferenceLabelProvider {
	@GetCanonicalReferenceLabel
	public String getLabel(final @Named(InternalNames.REFERENCE) CanonicalBusinessObjectReference ref) {
		return getLabel(ref.getSegments());
	}

	@GetRelativeReferenceLabel
	public String getLabel(final @Named(InternalNames.REFERENCE) RelativeBusinessObjectReference ref) {
		return getLabel(ref.getSegments());
	}

	private static String getLabel(final List<String> segs) {
		if (segs.size() != 1 && segs.size() != 2) {
			return null;
		}

		final String tag = segs.get(0);
		if (!DeclarativeReferenceType.isId(tag)) {
			return null;
		}

		final String formattedTag = StringUtil
				.camelCaseToUser(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tag));
		return segs.size() == 1 ? formattedTag : formattedTag + " " + segs.get(1);
	}
}
