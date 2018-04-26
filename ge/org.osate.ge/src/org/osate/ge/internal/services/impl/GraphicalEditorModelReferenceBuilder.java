package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.model.Tag;
import org.osate.ge.services.ReferenceBuilderService;

/**
 * Reference builder which builds references to graphical editor specific model objects.
 *
 */
public class GraphicalEditorModelReferenceBuilder {
	public final static String TYPE_TAG = "tag";
	public final static String TYPE_PROPERTY_VALUE_GROUP = "pvg";

	@BuildRelativeReference
	public String[] getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if (bo instanceof BusinessObjectProxy) {
			return ((BusinessObjectProxy) bo).getRelativeReference().toSegmentArray();
		} else if (bo instanceof Tag) {
			final Tag uv = (Tag) bo;
			return new String[] { TYPE_TAG, uv.key };
		} else if (bo instanceof PropertyValueGroup) {
			final PropertyValueGroup pvg = (PropertyValueGroup) bo;
			final String propertyName = pvg.getProperty().getQualifiedName();
			if (propertyName == null) {
				return null;
			}

			// Build reference segments
			final List<String> segments = new ArrayList<>(3);
			segments.add(TYPE_PROPERTY_VALUE_GROUP);
			segments.add(propertyName.toLowerCase());

			if (pvg.getReferenceId() != null) {
				segments.add(pvg.getReferenceId().toString());
			}

			return segments.toArray(new String[segments.size()]);
		} else {
			return null;
		}
	}

	@BuildCanonicalReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo,
			final ReferenceBuilderService refBuilder) {
		if (bo instanceof BusinessObjectProxy) {
			return ((BusinessObjectProxy) bo).getCanonicalReference().toSegmentArray();
		}
		return null;
	}
}
