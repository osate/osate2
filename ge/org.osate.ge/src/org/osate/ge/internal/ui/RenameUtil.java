/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CustomRenamer;
import org.osate.ge.businessobjecthandling.RenameContext;

/**
 * Utility functions related to the renaming business objects.
 *
 */
@SuppressWarnings("restriction")
public final class RenameUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private RenameUtil() {
	}

	/**
	 * Checks a proposed name for validity
	 * @param bo the business object for which to check validity
	 * @param boHandler the handler for the business object
	 * @param name the proposed name
	 * @return null if the name is valid. Otherwise, returns a descriptions of the validation error.
	 */
	public static String checkNewNameValidity(final Object bo,
			final BusinessObjectHandler boHandler,
			final String name) {
		return boHandler.validateName(new RenameContext(bo, name)).orElse(null);
	}

	/**
	 * Returns true if the business object handlers supports renaming without using an LTK-based refactoring.
	 * @param handler the business object handler
	 * @return true if the business object handlers supports renaming without using an LTK-based refactoring.
	 */
	public static boolean supportsNonLtkRename(final BusinessObjectHandler handler) {
		return handler instanceof CustomRenamer;
	}

	/**
	 * Renames a business object using the business object handler.
	 * @param bo the business object to rename
	 * @param boHandler the business object handler to use to rename.
	 * @param name the new name for the business object
	 * @throws ClassCastException if the specified business object handler does not support non-LTK renaming.
	 * @see #supportsNonLtkRename(BusinessObjectHandler)
	 */
	public static void performNonLtkRename(final Object bo, final BusinessObjectHandler boHandler,
			final String name) {
		final CustomRenamer renamer = (CustomRenamer) boHandler;
		renamer.rename(new RenameContext(bo, name));
	}

	/**
	 * Returns true if the business object can be renamed using an LTK refactoring
	 * @param bo the business object rename
	 * @return true if the business object can be renamed using an LTK refactoring
	 */
	public static boolean supportsLtkRename(final Object bo) {
		return RenameUtil.getRenameRefactoring(bo) != null;
	}

	/**
	 * Returns a refactoring which will rename the specified business object
	 * @param bo the business object to be refactored
	 * @return a refactoring which will rename the specified business object
	 */
	public static ProcessorBasedRefactoring getRenameRefactoring(final Object bo) {
		final EObject eObjBo = (EObject) bo;
		if (!(eObjBo.eResource() instanceof XtextResource)) {
			return null;
		}

		final XtextResource res = (XtextResource) eObjBo.eResource();
		final IResourceServiceProvider resourceServiceProvider = res.getResourceServiceProvider();
		if (resourceServiceProvider == null) {
			return null;
		}

		final IRenameRefactoringProvider renameRefactoringProvider = resourceServiceProvider
				.get(IRenameRefactoringProvider.class);
		if (renameRefactoringProvider == null) {
			return null;
		}

		final URI boUri = EcoreUtil.getURI(eObjBo);
		if (boUri == null) {
			return null;
		}

		return renameRefactoringProvider
				.getRenameRefactoring(new IRenameElementContext.Impl(boUri, eObjBo.eClass()));
	}
}
