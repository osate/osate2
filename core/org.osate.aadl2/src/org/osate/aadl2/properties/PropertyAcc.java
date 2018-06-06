/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
	 * @param ph
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
