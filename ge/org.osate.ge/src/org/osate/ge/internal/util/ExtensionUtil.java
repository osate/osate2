package org.osate.ge.internal.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.eclipse.jface.resource.ImageDescriptor;
import org.osate.ge.di.Description;
import org.osate.ge.di.Icon;
import org.osate.ge.di.Id;

public class ExtensionUtil {
	public static String getId(final Object ext) {
		return (String)getFieldValue(ext, Id.class);
	}
	
	public static ImageDescriptor getIcon(final Object ext) {
		return (ImageDescriptor)getFieldValue(ext, Icon.class);
	}
	
	public static String getDescription(final Object ext) {
		return (String)getFieldValue(ext, Description.class);
	}
	
	public static Object getFieldValue(final Object ext, final Class<? extends Annotation> annotationClass) {
		for(final Field field : ext.getClass().getDeclaredFields()) {
			if(field.isAnnotationPresent(annotationClass)) {
				try {
					return field.get(ext);
				} catch (final Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}
}
