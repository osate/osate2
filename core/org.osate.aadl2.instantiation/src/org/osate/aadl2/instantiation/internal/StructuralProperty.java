/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.InstanceObject;

/**
 * A property of the standard {@code Communication_Properties} property set whose value decides how many
 * instances a declaration over arrays stands for. Both apply to a connection and to a flow specification,
 * and both have to be cached on the provisional instances before either expansion runs, which is why
 * {@code InstantiateModel} splits them out of the properties it caches at the end.
 * <p>
 * The one place that knows the names is here, so that what
 * {@link #isStructural(Property) is cached early} and what
 * {@link #cachedOn(InstanceObject) is read back} cannot drift apart.
 */
enum StructuralProperty {
	/** Which elements of the two arrays are paired up. */
	CONNECTION_PATTERN("Connection_Pattern"),

	/** Which pairs of element indices are paired up, listed one by one. */
	CONNECTION_SET("Connection_Set");

	private static final String COMMUNICATION_PROPERTIES = "Communication_Properties";

	private final String propertyName;

	StructuralProperty(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * Is this one of the properties that decide how many instances a declaration expands into?
	 *
	 * @param property the property definition to test
	 */
	static boolean isStructural(Property property) {
		for (var structural : values()) {
			if (structural.matches(property)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The association of this property cached on an instance object.
	 *
	 * @param io the instance object the value was cached on
	 * @return the association, or {@code null} if the object carries no value for this property
	 */
	PropertyAssociation cachedOn(InstanceObject io) {
		for (var pa : io.getOwnedPropertyAssociations()) {
			if (matches(pa.getProperty())) {
				return pa;
			}
		}
		return null;
	}

	/**
	 * The alternatives of a {@code Connection_Pattern} value. The property is a list of dimension pattern
	 * values, and a dimension pattern value is a list with one literal per array dimension, so the
	 * alternatives are the outer list and the elements paired up are the union over them.
	 *
	 * @param patternPA the cached {@code Connection_Pattern} association
	 */
	static List<List<PropertyExpression>> alternativesOf(PropertyAssociation patternPA) {
		var alternatives = new ArrayList<List<PropertyExpression>>();
		for (var alternative : valueOf(patternPA)) {
			alternatives.add(((ListValue) alternative).getOwnedListElements());
		}
		return alternatives;
	}

	/**
	 * One pair of a {@code Connection_Set} value: the index of a source element and the index of a
	 * destination element, one integer per array dimension of that end.
	 */
	record IndexPair(List<Long> source, List<Long> destination) {
	}

	/**
	 * The element index pairs of a {@code Connection_Set} value.
	 *
	 * @param setPA the cached {@code Connection_Set} association
	 */
	static List<IndexPair> pairsOf(PropertyAssociation setPA) {
		var pairs = new ArrayList<IndexPair>();
		for (var pair : valueOf(setPA)) {
			var record = (RecordValue) pair;
			pairs.add(new IndexPair(indices(record, "src"), indices(record, "dst")));
		}
		return pairs;
	}

	/** The elements of the list value of an association. Both properties are lists. */
	private static List<PropertyExpression> valueOf(PropertyAssociation pa) {
		return ((ListValue) pa.getOwnedValues().get(0).getOwnedValue()).getOwnedListElements();
	}

	/** The integers of one field of a {@code Connection_Pair} record value. */
	private static List<Long> indices(RecordValue record, String field) {
		var indices = new ArrayList<Long>();
		for (BasicPropertyAssociation fieldValue : record.getOwnedFieldValues()) {
			if (fieldValue.getProperty().getName().equalsIgnoreCase(field)) {
				for (var index : ((ListValue) fieldValue.getOwnedValue()).getOwnedListElements()) {
					indices.add(((IntegerLiteral) index).getValue());
				}
			}
		}
		return indices;
	}

	/**
	 * Is this the property definition of this constant? Compared by name and by the name of the owning
	 * property set, because the standard property sets are resolved per model rather than shared.
	 */
	private boolean matches(Property property) {
		return propertyName.equalsIgnoreCase(property.getName()) && property.getOwner() instanceof PropertySet ps
				&& COMMUNICATION_PROPERTIES.equalsIgnoreCase(ps.getName());
	}
}
