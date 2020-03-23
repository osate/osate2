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
package org.osate.ge.internal.services.impl;

import java.util.List;

import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.ge.internal.di.GetCanonicalReferenceLabel;
import org.osate.ge.internal.di.GetRelativeReferenceLabel;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;
import org.osate.ge.internal.util.StringUtil;

import com.google.common.base.CaseFormat;

public class DeclarativeReferenceLabelProvider {
	@GetCanonicalReferenceLabel
	public String getLabel(final @Named(InternalNames.REFERENCE) CanonicalBusinessObjectReference ref,
			final @Named(InternalNames.PROJECT) IProject project) {
		return getLabel(ref.getSegments(), project);
	}

	@GetRelativeReferenceLabel
	public String getLabel(final @Named(InternalNames.REFERENCE) RelativeBusinessObjectReference ref) {
		return getLabel(ref.getSegments(), null);
	}

	private static String getLabel(final List<String> segs, final IProject project) {
		if (segs.size() != 1 && segs.size() != 2) {
			return null;
		}

		final String tag = segs.get(0);

		// Try to determine the proper case fore the label.
		// Project should only be non-null for canonical references
		if (project != null && segs.size() == 2) {
			final String name = segs.get(1);
			final String actualName;
			if (DeclarativeReferenceType.CLASSIFIER.getId().equals(tag)) {
				actualName = getActualName(name, project,
						Aadl2Factory.eINSTANCE.getAadl2Package().getComponentClassifier());
			} else if (DeclarativeReferenceType.PACKAGE.getId().equals(tag)) {
				actualName = getActualName(name, project, Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage());
			} else {
				actualName = null;
			}

			if (actualName != null) {
				return getFormattedTag(tag) + " " + actualName;
			}
		}

		if (!DeclarativeReferenceType.isId(tag)) {
			return null;
		}

		final String formattedTag = getFormattedTag(tag);
		if(segs.size() == 1) {
			return formattedTag;
		}

		return formattedTag + " " + segs.get(1);
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
