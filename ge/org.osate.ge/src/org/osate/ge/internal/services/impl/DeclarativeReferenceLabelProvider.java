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
