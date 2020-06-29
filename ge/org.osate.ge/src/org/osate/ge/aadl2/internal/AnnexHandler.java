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

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.CanDeleteContext;
import org.osate.ge.businessobjecthandling.GetGraphicalConfigurationContext;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.businessobjecthandling.IsApplicableContext;
import org.osate.ge.businessobjecthandling.ReferenceContext;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;

import com.google.common.collect.Lists;

public class AnnexHandler extends AadlBusinessObjectHandler {
	private static final GraphicalConfiguration graphicalConfig = GraphicalConfigurationBuilder.create()
			.graphic(FolderGraphicBuilder.create().build()).style(StyleBuilder.create().labelsCenter().build()).build();

	@Override
	public boolean isApplicable(final IsApplicableContext ctx) {
		return ctx.getBusinessObject(DefaultAnnexLibrary.class).isPresent()
				|| ctx.getBusinessObject(DefaultAnnexSubclause.class).isPresent();
	}

	@Override
	public CanonicalBusinessObjectReference getCanonicalReference(final ReferenceContext ctx) {
		final Object bo = ctx.getBusinessObject();

		if (bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary) bo;
			final AadlPackage annexPkg = getAnnexLibraryPackage(annexLibrary);
			if (annexPkg == null) {
				throw new RuntimeException("Unable to retrieve package.");
			}

			final int index = getAnnexLibraryIndex(annexLibrary);
			return new CanonicalBusinessObjectReference(DeclarativeReferenceType.ANNEX_LIBRARY.getId(),
					annexPkg.getQualifiedName(), annexLibrary.getName(), Integer.toString(index));
		} else if (bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause) bo;
			if (annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}

			final Classifier annexSubclauseClassifier = annexSubclause.getContainingClassifier();
			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new CanonicalBusinessObjectReference(DeclarativeReferenceType.ANNEX_SUBCLAUSE.getId(),
					annexSubclauseClassifier.getQualifiedName(), annexSubclause.getName(), Integer.toString(index));
		}

		throw new RuntimeException("Unexpected business object " + bo);
	}

	@Override
	public RelativeBusinessObjectReference getRelativeReference(final ReferenceContext ctx) {
		final Object bo = ctx.getBusinessObject();

		if (bo instanceof AnnexLibrary) {
			final AnnexLibrary annexLibrary = (AnnexLibrary) bo;
			final int index = getAnnexLibraryIndex(annexLibrary);
			return new RelativeBusinessObjectReference(DeclarativeReferenceType.ANNEX_LIBRARY.getId(),
					annexLibrary.getName(), Integer.toString(index));

		} else if (bo instanceof AnnexSubclause) {
			final AnnexSubclause annexSubclause = (AnnexSubclause) bo;
			if (annexSubclause.getContainingClassifier() == null) {
				throw new RuntimeException("Unable to retrieve containing classifier.");
			}

			final int index = getAnnexSubclauseIndex(annexSubclause);
			return new RelativeBusinessObjectReference(DeclarativeReferenceType.ANNEX_SUBCLAUSE.getId(),
					annexSubclause.getName(), Integer.toString(index));
		}

		throw new RuntimeException("Unexpected business object " + bo);
	}

	@Override
	public boolean canDelete(final CanDeleteContext ctx) {
		return true;
	}

	@Override
	public Optional<GraphicalConfiguration> getGraphicalConfiguration(final GetGraphicalConfigurationContext ctx) {
		return Optional.of(graphicalConfig);
	}

	@Override
	public String getName(final GetNameContext ctx) {
		return ctx.getBusinessObject(NamedElement.class).map(annex -> "{**" + annex.getName() + "**}").orElse("");
	}

	/**
	 * Get the package in which the annex library is contained.
	 * @param annex
	 * @return
	 */
	private AadlPackage getAnnexLibraryPackage(final AnnexLibrary annexLibrary) {
		for (Element o = annexLibrary.getOwner(); o != null; o = o.getOwner()) {
			if (o instanceof AadlPackage) {
				return (AadlPackage) o;
			}
		}

		return null;
	}

	/**
	 * Returns a 0 based index for referencing an annex library in a list that contains only annex libraries with the same type and owner
	 * @param annexLibrary
	 * @return
	 */
	private static int getAnnexLibraryIndex(AnnexLibrary annexLibrary) {
		// Get the default annex library if a parsed annex library was specified. This is needed for the comparison later in the function.
		if (!(annexLibrary instanceof DefaultAnnexLibrary)) {
			if (annexLibrary.eContainer() instanceof DefaultAnnexLibrary) {
				annexLibrary = (AnnexLibrary) annexLibrary.eContainer();
			} else {
				return -1;
			}
		}

		final String annexName = annexLibrary.getName();
		if (annexName == null) {
			return -1;
		}

		// Get the Aadl Package
		Element tmp = annexLibrary.getOwner();
		while (tmp != null && !(tmp instanceof AadlPackage)) {
			tmp = tmp.getOwner();
		}

		int index = 0;
		if (tmp instanceof AadlPackage) {
			for (final AnnexLibrary tmpLibrary : AnnexUtil.getAllDefaultAnnexLibraries((AadlPackage) tmp)) {
				if (tmpLibrary == annexLibrary) {
					return index;
				} else if (annexName.equalsIgnoreCase(tmpLibrary.getName())) {
					index++;
				}
			}
		}

		return -1;
	}

	/**
	 * Returns a 0 based index for referencing an annex subclause in a list that contains only annex subclauses with the same type and owner
	 * @return
	 */
	private static int getAnnexSubclauseIndex(AnnexSubclause annexSubclause) {
		// Get the default annex library if a parsed annex subclause was specified. This is needed for the comparison later in the function.
		if (!(annexSubclause instanceof DefaultAnnexSubclause)) {
			if (annexSubclause.eContainer() instanceof DefaultAnnexSubclause) {
				annexSubclause = (AnnexSubclause) annexSubclause.eContainer();
			} else {
				return -1;
			}
		}

		final String annexName = annexSubclause.getName();
		if (annexName == null) {
			return -1;
		}

		// Get all related classifiers
		final Classifier cl = annexSubclause.getContainingClassifier();
		final EList<Classifier> classifiers = cl.getSelfPlusAllExtended();
		if (cl instanceof ComponentImplementation) {
			ComponentType ct = ((ComponentImplementation) cl).getType();
			if (ct != null) {
				classifiers.addAll(ct.getSelfPlusAllExtended());
			}
		}

		int index = 0;

		// Use reversed view of list so that base classifiers will be first. This is needed to ensure subclauses have unique indices
		for (final Classifier tmpClassifier : Lists.reverse(classifiers)) {
			for (final AnnexSubclause tmpSubclause : tmpClassifier.getOwnedAnnexSubclauses()) {
				if (tmpSubclause == annexSubclause) {
					return index;
				} else if (annexName.equalsIgnoreCase(tmpSubclause.getName())) {
					index++;
				}
			}
		}

		return -1;
	}
}
