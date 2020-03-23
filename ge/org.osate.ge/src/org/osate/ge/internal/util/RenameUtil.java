/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
