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
package org.osate.ge.internal.model;

import java.util.Collection;
import java.util.Objects;
import java.util.UUID;

import org.osate.aadl2.Property;

import com.google.common.collect.ImmutableList;

/**
 * Stores all property values for a particular property which have the same owner and reference the same model element.
 * The owner of the property value is not necessarily the same model element to which the property value is applied.
 *
 */
public class PropertyValueGroup {
	private final Property property;
	private final UUID referencedId; // Optional. The diagram element that is referenced by the property value group. Needed for property values which are
	// represented as a connection.
	private final ImmutableList<AgePropertyValue> values;

	public PropertyValueGroup(final Property property,
			final UUID referencedId,
			final Collection<AgePropertyValue> values) {
		this.property = Objects.requireNonNull(property, "property must not be null");
		this.referencedId = referencedId;
		this.values = ImmutableList.copyOf(values);
	}

	public final Property getProperty() {
		return property;
	}

	public final UUID getReferenceId() {
		return referencedId;
	}

	public final ImmutableList<AgePropertyValue> getPropertyValues() {
		return values;
	}

	public final AgePropertyValue getFirstValueBasedOnCompletelyProcessedAssociation() {
		for(final AgePropertyValue pv : values) {
			if(pv.isBasedOnCompletelyProcessedAssociation()) {
				return pv;
			}
		}

		return null;
	}

	// Determine whether the property value group contains multiple values, values based on not-completely processed property associations,
	// or non-fully resolved references.
	public final boolean isAbstract() {
		boolean isAbstract = false;
		if (getPropertyValues().size() > 1) {
			isAbstract = true;
		} else {
			final AgePropertyValue firstValueFromCompleteAssociation = getFirstValueBasedOnCompletelyProcessedAssociation();

			// If there is a value based on a completely processed property association, then the reference shouldn't be shown as being partial
			isAbstract = firstValueFromCompleteAssociation == null || !firstValueFromCompleteAssociation.isReferenceFullyResolved();
		}

		return isAbstract;
	}
}
