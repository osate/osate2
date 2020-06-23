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
package org.osate.ge.aadl2.internal;

import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.internal.util.AgeAadlUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.referencehandling.GetCanonicalReferenceLabelContext;
import org.osate.ge.referencehandling.GetRelativeReferenceLabelContext;
import org.osate.ge.referencehandling.ReferenceLabelProvider;
import org.osate.ge.util.StringUtil;

import com.google.common.base.CaseFormat;

public class DeclarativeReferenceLabelProvider implements ReferenceLabelProvider {
	@Override
	public Optional<String> getCanonicalReferenceLabel(final GetCanonicalReferenceLabelContext ctx) {
		return getLabel(ctx.getReference().getSegments(), ctx.getProject());
	}

	@Override
	public Optional<String> getRelativeReferenceLabel(final GetRelativeReferenceLabelContext ctx) {
		return getLabel(ctx.getReference().getSegments(), null);
	}

	private static Optional<String> getLabel(final List<String> segs, final IProject project) {
		if (segs.size() != 1 && segs.size() != 2) {
			return Optional.empty();
		}

		final String tag = segs.get(0);

		// Try to determine the proper case fore the label.
		// Project should only be non-null for canonical references
		if (project != null && segs.size() == 2) {
			final String name = segs.get(1);
			final String actualName;
			if (DeclarativeReferenceType.CLASSIFIER.getId().equals(tag)) {
				actualName = getActualName(name, project,
						AgeAadlUtil.getAadl2Factory().getAadl2Package().getComponentClassifier());
			} else if (DeclarativeReferenceType.PACKAGE.getId().equals(tag)) {
				actualName = getActualName(name, project,
						AgeAadlUtil.getAadl2Factory().getAadl2Package().getAadlPackage());
			} else {
				actualName = null;
			}

			if (actualName != null) {
				return Optional.of(getFormattedTag(tag) + " " + actualName);
			}
		}

		if (!DeclarativeReferenceType.isId(tag)) {
			return Optional.empty();
		}

		final String formattedTag = getFormattedTag(tag);
		if(segs.size() == 1) {
			return Optional.of(formattedTag);
		}

		return Optional.of(formattedTag + " " + segs.get(1));
	}

	private static final String getFormattedTag(final String tag) {
		return StringUtil.camelCaseToUser(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tag));
	}

	/**
	 * Returns the name of of the specified element with the appropriate case if it could be found. Otherwise, returns the specified name.
	 * @param name
	 * @param project
	 * @param eClass
	 * @return
	 */
	private static final String getActualName(final String name, final IProject project, final EClass eClass) {
		for (final IEObjectDescription desc : ScopedEMFIndexRetrieval.getAllEObjectsByType(project, eClass)) {
			final String tmpName = desc.getQualifiedName().toString("::");
			if (name.equalsIgnoreCase(tmpName)) {
				return tmpName;
			}
		}

		return name;
	}
}
