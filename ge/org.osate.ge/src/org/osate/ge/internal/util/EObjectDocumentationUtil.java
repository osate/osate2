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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;

public class EObjectDocumentationUtil {
	public static String getPlainTextDocumentation(final Object bo) {
		// Get the documentation provider for the business object. If the documentation provider cannot be retrieved, then assume that the business object does
		// not have any documentation.
		final IEObjectDocumentationProvider docProvider = EObjectDocumentationUtil.getDocumentationProvider(bo);
		if (docProvider == null) {
			return null;
		}

		// Get the documentation
		String doc = docProvider.getDocumentation((EObject) bo);
		if (doc == null) {
			return null;
		}

		// Trim whitespace
		doc = doc.trim();
		if (doc.isEmpty()) {
			return null;
		}

		// Remove whitespace
		return doc.replaceAll("\\s+", " ");
	}

	public static IEObjectDocumentationProvider getDocumentationProvider(final Object bo) {
		if (!(bo instanceof EObject)) {
			return null;
		}

		final EObject eobj = (EObject) bo;

		// Get the Xtext resource
		if (!(eobj.eResource() instanceof XtextResource)) {
			return null;
		}

		final XtextResource resource = (XtextResource) eobj.eResource();

		// Get the resource service provider
		final IResourceServiceProvider resourceServiceProvider = resource.getResourceServiceProvider();
		if (resourceServiceProvider == null) {
			return null;
		}

		// Get the documentation provider
		return resourceServiceProvider
				.get(IEObjectDocumentationProvider.class);
	}
}
