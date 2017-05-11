package org.osate.ge.internal.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;
import org.osate.ge.internal.model.PropertyResultValue;
import org.osate.ge.internal.model.Tag;

/**
 * Reference builder which builds references to graphical editor specific model objects.
 *
 */
public class GraphicalEditorModelReferenceBuilder {
	public final static String TYPE_TAG = "tag";
	public final static String TYPE_PROPERTY_VALUE = "property_value";
	
	@BuildRelativeReference 
	public String[] getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {	
		if(bo instanceof Tag) {
			final Tag uv = (Tag)bo;	
			return new String[] {TYPE_TAG, uv.key};
		} else if(bo instanceof PropertyResultValue) {
			final PropertyResultValue value = (PropertyResultValue)bo;
			final String propertyName = value.getProperty().getQualifiedName();
			if(propertyName == null) {
				return null;
			}
			
			// Build reference segments
			final List<String> segments = new ArrayList<>(2 + value.getArrayIndices().size());
			segments.add(TYPE_PROPERTY_VALUE);
			segments.add(propertyName.toLowerCase());
			for(final Integer idx : value.getArrayIndices()) {
				segments.add(idx.toString());
			}
			
			return segments.toArray(new String[segments.size()]);
		} else {
			return null;
		}
	}
}
