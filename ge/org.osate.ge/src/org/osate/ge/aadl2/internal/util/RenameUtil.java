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
package org.osate.ge.aadl2.internal.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.NamedElement;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.CustomRenamer;
import org.osate.ge.businessobjecthandling.RenameContext;

/**
 * Helper functions related to the renaming aspect of Business Object Handlers.
 *
 */
@SuppressWarnings("restriction")
public class RenameUtil {
	/**
	 * @param bo
	 * @param boHandler
	 * @param name
	 * @return null if the name is valid. Otherwise, returns a descriptions of the validation error.
	 */
	public static String checkNewNameValidity(final Object bo,
			final BusinessObjectHandler boHandler,
			final String name) {
		return boHandler.validateName(new RenameContext(bo, name)).orElse(null);
	}

	/**
	 * Returns true if the business object handlers supports renaming without using LTK-based refactoring.
	 * @param handler
	 */
	public static boolean supportsNonLtkRename(final BusinessObjectHandler handler) {
		return handler instanceof CustomRenamer;
	}

	/**
	 * Renames using the {@link CustomRenamer} implementation. Throws exception if the specified business object handler
	 * does not implement {@link CustomRenamer}.
	 */
	public static void performNonLtkRename(final Object bo, final BusinessObjectHandler boHandler,
			final String name) {
		final CustomRenamer renamer = (CustomRenamer) boHandler;
		renamer.rename(new RenameContext(bo, name));
	}

	public static ProcessorBasedRefactoring getRenameRefactoring(final Object bo) {
		if (!(bo instanceof NamedElement)) {
			return null;
		}

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
				.getRenameRefactoring(new IRenameElementContext.Impl(boUri, Aadl2Package.eINSTANCE.getNamedElement()));
	}

}
