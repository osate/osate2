/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.eclipse.jface.resource.ImageDescriptor;
import org.osate.ge.internal.di.Description;
import org.osate.ge.internal.di.Icon;
import org.osate.ge.internal.di.Id;

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
