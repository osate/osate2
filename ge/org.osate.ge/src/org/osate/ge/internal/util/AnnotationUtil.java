package org.osate.ge.internal.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationUtil {
	public static boolean hasMethodWithAnnotation(final Class<? extends Annotation> annotation, final Object obj) {
		if(obj == null) {
			return false;
		}
		
		return classHasMethodWithAnnotation(annotation, obj.getClass());
	}
	
	private static boolean classHasMethodWithAnnotation(final Class<? extends Annotation> annotation, final Class<?> c) {
		for(final Method m : c.getDeclaredMethods()) {
			if(m.isAnnotationPresent(annotation)) {
				return true;
			}
		}
		
		final Class<?> superClass = c.getSuperclass();
		if(superClass != null) {
			return classHasMethodWithAnnotation(annotation, superClass);
		}
		return false;
	}
}
