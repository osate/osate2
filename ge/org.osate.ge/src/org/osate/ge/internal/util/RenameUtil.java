package org.osate.ge.internal.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.ge.di.GetNameForEditing;
import org.osate.ge.di.Names;
import org.osate.ge.di.Rename;
import org.osate.ge.di.ValidateName;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.services.ExtensionService;

/**
 * Helper functions related to the renaming aspect of Business Object Handlers.
 *
 */
public class RenameUtil {
	public static boolean hasValidateNameMethod(final Object handler) {
		return AnnotationUtil.hasMethodWithAnnotation(ValidateName.class, handler);
	}

	/**
	 * @param bo
	 * @param boHandler
	 * @param name
	 * @param project
	 * @param extService
	 * @return null if the name is valid. Otherwise, returns a descriptions of the validation error.
	 */
	public static String checkNewNameValidity(final Object bo, final Object boHandler,
			final String name,
			final IProject project, final ExtensionService extService) {
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.NAME, name);
			childCtx.set(InternalNames.PROJECT, project);
			return (String) ContextInjectionFactory.invoke(boHandler, ValidateName.class, childCtx, null);
		} finally {
			childCtx.dispose();
		}
	}

	/**
	 * Returns the name provided by the business object handler's GetNameForEditing method. Otherwise, returns the specified default value.
	 * @param bo
	 * @param boHandler
	 * @param extService
	 * @param defaultValue
	 * @return
	 */
	public static String getCurrentEditingName(final Object bo, final Object boHandler,
			final ExtensionService extService, final String defaultValue) {
		// Attempt to use the value provided by the method annotated with GetNameForEditing first
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			final String value = (String) ContextInjectionFactory.invoke(boHandler, GetNameForEditing.class, childCtx,
					null);
			return value == null ? defaultValue : value;
		} finally {
			childCtx.dispose();
		}
	}

	/**
	 * Returns true if the business object handlers supports renaming without using LTK-based refactoring.
	 * @param handler
	 */
	public static boolean supportsNonLtkRename(final Object handler) {
		return AnnotationUtil.hasMethodWithAnnotation(Rename.class, handler);
	}

	public static void performNonLtkRename(final Object bo, final Object boHandler, final String name,
			final ExtensionService extService) {
		final IEclipseContext childCtx = extService.createChildContext();
		try {
			childCtx.set(Names.BUSINESS_OBJECT, bo);
			childCtx.set(Names.NAME, name);
			ContextInjectionFactory.invoke(boHandler, Rename.class, childCtx);
		} finally {
			childCtx.dispose();
		}
	}

}
