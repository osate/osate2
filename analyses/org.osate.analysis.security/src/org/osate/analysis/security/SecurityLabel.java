/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.analysis.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;

public class SecurityLabel {

	/// lowest possible security label
	public static final SecurityLabel MIN = new SecurityLabel(1, Collections.emptySet());

	/// Property name used for security levels
	public static final String LEVEL_PROPERTY_NAME = "SecurityClassificationProperties::Security_Level";

	/// Property name used for security categories
	public static final String CATEGORY_PROPERTY_NAME = "SecurityClassificationProperties::Security_Level_Caveats";

	/// Available security levels, based on the user-provided configuration
	private static Property levelProperty = null;

	/// Available security categories, based on the user-provided configuration
	private static Property categoryProperty = null;

	/// Lookup map from literals to levels
	private static Map<EnumerationLiteral, Integer> literal2level = new HashMap<EnumerationLiteral, Integer>();

	/// Lookup map from integer levels to literals
	private static Map<Integer, EnumerationLiteral> level2literal = new HashMap<Integer, EnumerationLiteral>();

	/// Set of available categories
	private static Set<EnumerationLiteral> maxCategories = new HashSet<EnumerationLiteral>();

	/// Level of this security label object
	private Integer level;

	/// categories used by this security label object
	private Set<EnumerationLiteral> categories;

	/**
	 * Constructs a {@link SecurityLabel} based on the given level and categories
	 *
	 * @param level level of this label
	 * @param catgories categories of this label
	 */
	public SecurityLabel(Integer level, Set<EnumerationLiteral> categories) {
		this.level = level;
		this.categories = new TreeSet<EnumerationLiteral>((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
		this.categories.addAll(categories);
	}

	/**
	 * Determines the Security label of the named element in relation to the first seen level/category definition.
	 *
	 * @param ne Element for which the security level will be determined
	 * @return Security label held by the element or empty if not
	 */
	public static Optional<SecurityLabel> of(NamedElement ne) {
		init(ne);

		int level = -1;
		try {
			NamedValue levelValue = (NamedValue) ne.getSimplePropertyValue(levelProperty);
			EnumerationLiteral levelLiteral = (EnumerationLiteral) levelValue.getNamedValue();
			level = literal2level.get(levelLiteral);
		} catch (Exception e) {
			return Optional.empty();
		}
		try {
			Set<EnumerationLiteral> tags = new HashSet<EnumerationLiteral>();
			ListValue caveatsValue = (ListValue) ne.getSimplePropertyValue(categoryProperty);
			List<PropertyExpression> lelems = caveatsValue.getOwnedListElements();
			for (PropertyExpression nv : lelems) {
				EnumerationLiteral literal = (EnumerationLiteral) ((NamedValue) nv).getNamedValue();
				tags.add(literal);
			}
			return Optional.of(new SecurityLabel(level, tags));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	/**
	 * Initializes {@link SecurityLabel#levelProperty} and {@link SecurityLabel#categoryProperty} based on the provided element.
	 * Updates the {@link SecurityLabel#literal2level} and {@link SecurityLabel#level2literal} lookup tables based on aforementioned values.
	 *
	 * @param ne Element used for initialization
	 */
	private static void init(NamedElement ne) {
		Property newLevelProperty = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getProperty(),
				LEVEL_PROPERTY_NAME);
		Property newCategoryProperty = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getProperty(),
				CATEGORY_PROPERTY_NAME);

		// Update the reference property level/category in case they changed or are unknown
		if (levelProperty != newLevelProperty || categoryProperty != newCategoryProperty) {
			levelProperty = newLevelProperty;
			categoryProperty = newCategoryProperty;

			literal2level.clear();
			level2literal.clear();
			EnumerationType levelType = (EnumerationType) levelProperty.getOwnedPropertyType();
			List<EnumerationLiteral> literals = levelType.getOwnedLiterals();
			for (int i = 0; i < literals.size(); i += 1) {
				// enumeration is ordered from high to low security
				int index = literals.size() - i;
				literal2level.put(literals.get(i), index);
				level2literal.put(index, literals.get(i));
			}

			// Get all existing categories
			ListType categoryType = (ListType) categoryProperty.getOwnedPropertyType();
			EnumerationType categoryElements = (EnumerationType) categoryType.getOwnedElementType();
			List<EnumerationLiteral> categories = categoryElements.getOwnedLiterals();

			maxCategories.clear();
			maxCategories.addAll(categories);
		}
	}

	/**
	 * Gets the security level of this {@link SecurityLabel}
	 *
	 * @return Level of this {@link SecurityLabel}
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * Sets the security level of this {@link SecurityLabel}.
	 * Level must be in range of {@link SecurityLabel#level2literal}.
	 *
	 * @param new security level
	 */
	public void setLevel(Integer level) throws IllegalArgumentException {
		if (!level2literal.containsKey(level)) {
			throw new IllegalArgumentException("Security level: " + level + "is not defined.");
		}
		this.level = level;
	}

	/**
	 * Gets the security categories of this {@link SecurityLabel}.
	 *
	 * @return Categories used in this label
	 */
	public Set<EnumerationLiteral> getCategories() {
		return categories;
	}

	/**
	 * Sets the categories used in this {@link SecurityLabel}.
	 * All categories passed must be in {@link SecurityLabel#categoryProperty}
	 *
	 * @param new categories
	 */
	public void setTags(Set<EnumerationLiteral> categories) {
		if (!maxCategories.containsAll(categories)) {
			throw new IllegalArgumentException(
					"Security categories: " + categories + " are not compliant with property set definitions.");
		}

		this.categories = categories;
	}

	@Override
	public String toString() {
		return "SecurityLabel [" + level2literal.get(level).getName() + ", "
				+ categories.stream().map(EnumerationLiteral::getName).collect(Collectors.joining(", ", "{", "}"))
				+ "]";
	}

	/**
	 * Combined HashCode based on level and categories
	 */
	@Override
	public int hashCode() {
		return Objects.hash(level, categories);
	}

	/**
	 * Checks if two {@link SecurityLabel}s are identical. (same level and categories)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SecurityLabel other = (SecurityLabel) obj;
		if (level != other.level) {
			return false;
		}
		if (categories == null) {
			if (categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if {@code this} {@link SecurityLabel} dominated {@code that}.
	 * Note: A security labels dominates another security label, if and only if, it has the same or a higher level
	 * 		 and contains all categories of the other security label.
	 *
	 * @param that Other security label
	 * @return True if {@code this} dominates {@code that}
	 */
	public boolean dominates(SecurityLabel that) {
		return this.level >= that.level && categories.containsAll(that.categories);
	}

	/**
	 * Checks if one Security level is greater than the other.
	 * This check returns false, if both have the same security requirements.
	 *
	 * @param that Other security label
	 * @return True if {@code this} has a higher Security level than {@code that}.
	 */
	public boolean greaterThan(SecurityLabel that) {
		return this.dominates(that) && !this.equals(that);
	}

	/**
	 * Checks if one Security level is lower than the other.
	 * This check return false, if both have the same security requirement.
	 *
	 * @param that Other security label
	 * @return True {@code this} has a lower Security Level than {@code that}.
	 */
	public boolean lessThan(SecurityLabel that) {
		return that.dominates(this) && !this.equals(that);
	}

	/**
	 * Joins this Security label with {@code that}. The result of this operation is a Security label
	 * with the larger level of the two inputs and the combined set of categories.
	 *
	 * @param that Other security label
	 * @return security label with least highest combined privileges
	 */
	public SecurityLabel join(SecurityLabel that) {
		HashSet<EnumerationLiteral> allCategories = new HashSet<>(categories);
		allCategories.addAll(that.categories);
		return new SecurityLabel(Math.max(this.level, that.level), allCategories);
	}

	/**
	 * {@link SecurityLabel#meet(SecurityLabel)}s two Security labels, if that is present.
	 * @param that Optional other security label
	 * @return Result of {@link #meet(SecurityLabel)} if {@code that} is present
	 */
	public SecurityLabel meet(Optional<SecurityLabel> that) {
		if (that.isPresent()) {
			return meet(that.get());
		}
		return this;
	}

	/**
	 * Returns the lower bound of {@code this} and {@code that} security label.
	 * The result of this operation is a security label with the lower security level and categories, which are only accessible by both labels.
	 *
	 * @param that Other security label
	 * @return new security label containing the lower level and common categories
	 */
	public SecurityLabel meet(SecurityLabel that) {
		HashSet<EnumerationLiteral> commonCategories = new HashSet<>(categories);
		commonCategories.removeAll(that.categories);
		return new SecurityLabel(Math.min(this.level, that.level), commonCategories);
	}

}
