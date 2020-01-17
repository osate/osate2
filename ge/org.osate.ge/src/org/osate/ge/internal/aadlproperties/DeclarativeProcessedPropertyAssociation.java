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
package org.osate.ge.internal.aadlproperties;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;

class DeclarativeProcessedPropertyAssociation implements ProcessedPropertyAssociation {
	private final PropertyAssociation propertyAssociation; // Property Association
	private final List<ContainmentPathElement> appliedToPathElements; // ContainedNamedElement - AppliesTo
	private final int processedAppliedToPathElements; // Count of number of ContainmentPathElement processed in the applies to

	public DeclarativeProcessedPropertyAssociation(final PropertyAssociation propertyAssociation,
			final List<ContainmentPathElement> appliedToPathElements, final int processedAppliedToPathElements) {
		this.propertyAssociation = Objects.requireNonNull(propertyAssociation,
				"propertyAssociation must not be null");
		this.appliedToPathElements = Objects.requireNonNull(appliedToPathElements,
				"appliedToPathElements must not be null");
		this.processedAppliedToPathElements = processedAppliedToPathElements;
	}

	@Override
	public PropertyAssociation getPropertyAssociation() {
		return propertyAssociation;
	}

	@Override
	public int getPropertyAssociationOwnerAncestorLevel() {
		return processedAppliedToPathElements;
	}

	@Override
	public boolean isCompletelyProcessed() {
		return appliedToPathElements.size() == processedAppliedToPathElements;
	}

	private List<ContainmentPathElement> getUnprocessedPathElements() {
		return appliedToPathElements.subList(processedAppliedToPathElements, appliedToPathElements.size());
	}

	@Override
	public String getUnprocessedPathDescription() {
		return getUnprocessedPathElements().stream().map(pe -> getNonNullName(pe.getNamedElement()))
				.collect(Collectors.joining(".")).toLowerCase();
	}

	private static String getNonNullName(final NamedElement ne) {
		if (ne == null) {
			return "";
		}

		final String name = ne.getName();
		if (name == null) {
			return "";
		}

		return name;
	}

	@Override
	public boolean hasArrayIndices() {
		for(final ContainmentPathElement e: appliedToPathElements) {
			if(e.getArrayRanges() != null && e.getArrayRanges().size() > 0) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isBindingSpecific() {
		return propertyAssociation.getInBindings() != null && propertyAssociation.getInBindings().size() > 0;
	}

	@Override
	public boolean isModal() {
		for(final ModalPropertyValue mpv : propertyAssociation.getOwnedValues()) {
			if(mpv.getInModes() != null && mpv.getInModes().size() > 0) {
				return true;
			}
		}
		return false;
	}
}