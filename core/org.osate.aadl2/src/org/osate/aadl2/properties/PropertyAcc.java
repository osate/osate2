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
package org.osate.aadl2.properties;

import java.util.LinkedList;
import java.util.List;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;

/**
 * Fill this in
 *
 * @author lwrage, jdelange
 */
public class PropertyAcc {

	private final Property property;
	private final List<PropertyAssociation> assocs = new LinkedList<PropertyAssociation>();

	public PropertyAcc(final Property property) {
		this.property = property;
	}

	public boolean add(PropertyAssociation pa) {
		if (pa.getProperty().equals(property) && pa.getAppliesTos().isEmpty()) {
			assocs.add(pa);
			return !property.isList();
		}
		return false;
	}

	/**
	 * Accumulate the associations for the given property as found
	 * in the immediate properties attribute of the given property holder.
	 *
	 * @param holder
	 *            The property holder whose properties attribute is of interest
	 * @return If we're done.
	 */
	public boolean addLocal(NamedElement target) {

		for (PropertyAssociation pa : target.getOwnedPropertyAssociations()) {
			if (pa.getProperty().equals(property) && pa.getAppliesTos().isEmpty()) {
				assocs.add(pa);

				return !property.isList();
			}
		}
		return false;
	}

	/**
	 * Accumulate the associations for the given property as found in the
	 * contained property associations of the target's containing component.
	 * Considers the contained property associations whose applies to list is of
	 * length 1, and that element is the target property holder.
	 *
	 * @param target
	 *            The named element whose property values are being looked up
	 * @param container
	 *            The containing classifier of <code>target</code>, whose
	 *            contained property associations are of interest.
	 * @return If we're done
	 */
	public boolean addLocalContained(NamedElement target, NamedElement container) {
		for (PropertyAssociation pa : container.getOwnedPropertyAssociations()) {

			if (pa.getProperty().equals(property)) {
				for (ContainedNamedElement cne : pa.getAppliesTos()) {
					if (cne.getContainmentPathElements().size() == 1) {
						ContainmentPathElement cpe = cne.getContainmentPathElements().get(0);
						if (cpe.getArrayRanges().isEmpty() && cpe.getNamedElement() == target) {
							assocs.add(pa);
							return !property.isList();
						}
					}
				}
			}
		}
		return false;
	}

	public List<PropertyAssociation> getAssociations() {
		return assocs;
	}

	public PropertyAssociation first() {
		if (!assocs.isEmpty()) {
			return assocs.get(0);
		}
		return null;
	}
}
