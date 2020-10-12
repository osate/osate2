package org.osate.analysis.security;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.pluginsupport.properties.CodeGenUtil;

public class SecurityLabel {

	public static final SecurityLabel MIN = new SecurityLabel(1, Collections.emptySet());

	public static final String LEVEL_PROPERTY_NAME = "Security::Level";

	public static final String CATEGORY_PROPERTY_NAME = "Security::Level_Caveats";

	private static Property levelProperty = null;

	private static Property categoryProperty = null;

	private static Map<EnumerationLiteral, Integer> literal2level;

	private static Map<Integer, EnumerationLiteral> level2literal;

	public static Optional<SecurityLabel> of(NamedElement ne) {
		int level = -1;

		Optional<EnumerationLiteral> levelLiteral = getLevelEnum(ne, Optional.empty());
		if (levelLiteral.isPresent()) {
			level = literal2level.get(levelLiteral.get());
		} else {
			throw new InternalError("Level enumeration literal not found for " + ne.getQualifiedName());
		}
		try {
			Set<EnumerationLiteral> tags = new HashSet<EnumerationLiteral>();
			Optional<ListValue> caveatsValue = getCategoryList(ne, Optional.empty());
			if (caveatsValue.isPresent()) {
				List<PropertyExpression> lelems = caveatsValue.get().getOwnedListElements();
				for (PropertyExpression nv : lelems) {
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(nv, ne, Optional.empty());
					EnumerationLiteral literal = (EnumerationLiteral) ((NamedValue) resolved).getNamedValue();
					tags.add(literal);
				}
			}
			return Optional.of(new SecurityLabel(level, tags));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public static Optional<EnumerationLiteral> getLevelEnum(NamedElement lookupContext, Optional<Mode> mode) {
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(levelProperty, lookupContext, mode);
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of((EnumerationLiteral) ((NamedValue) resolved).getNamedValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	public static Optional<ListValue> getCategoryList(NamedElement lookupContext, Optional<Mode> mode) {
		try {
			PropertyExpression value = CodeGenUtil.lookupProperty(categoryProperty, lookupContext, mode);
			if (value instanceof ListValue) {
				return Optional.of((ListValue) value);
			}
			PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
			return Optional.of((ListValue) ((NamedValue) resolved).getNamedValue());
		} catch (PropertyNotPresentException e) {
			return Optional.empty();
		}
	}

	static void init(NamedElement ne) {
		levelProperty = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getProperty(), LEVEL_PROPERTY_NAME);
		categoryProperty = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getProperty(), CATEGORY_PROPERTY_NAME);
		EnumerationType levelType = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getPropertyType(),
				"Security_Type_Specifications::Level_Type");
		List<EnumerationLiteral> literals = levelType.getOwnedLiterals();
		literal2level = new HashMap<EnumerationLiteral, Integer>();
		level2literal = new HashMap<Integer, EnumerationLiteral>();
		for (int i = 0; i < literals.size(); i += 1) {
			// enumeration is ordered from high to low security
			int index = literals.size() - i;
			literal2level.put(literals.get(i), index);
			level2literal.put(index, literals.get(i));
		}
	}

	private Integer level;

	private Set<EnumerationLiteral> categories;

	public SecurityLabel(Integer level, Set<EnumerationLiteral> tags) {
		this.level = level;
		categories = new TreeSet<EnumerationLiteral>((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
		categories.addAll(tags);
	}

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the tags
	 */
	public Set<EnumerationLiteral> getTags() {
		return categories;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<EnumerationLiteral> tags) {
		this.categories = tags;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityLabel [" + level2literal.get(level).getName() + ", "
				+ categories.stream().map(EnumerationLiteral::getName).collect(Collectors.joining(", ", "{", "}"))
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (level ^ (level >>> 32));
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
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
			if (other.categories != null) {
				return false;
			}
		} else if (!categories.equals(other.categories)) {
			return false;
		}
		return true;
	}

	public boolean dominates(SecurityLabel that) {
		return this.level >= that.level && this.categories.containsAll(that.categories);
	}

	public boolean greaterThan(SecurityLabel that) {
		return this.dominates(that) && !this.equals(that);
	}

	public boolean lessThan(SecurityLabel that) {
		return that.dominates(this) && !this.equals(that);
	}

	public SecurityLabel join(SecurityLabel that) {
		HashSet<EnumerationLiteral> allCategories = new HashSet<>(this.categories);
		allCategories.addAll(that.categories);
		return new SecurityLabel(Math.max(this.level, that.level), allCategories);
	}

	public SecurityLabel meet(Optional<SecurityLabel> that) {
		if (that.isPresent()) {
			return meet(that.get());
		}
		return this;
	}

	public SecurityLabel meet(SecurityLabel that) {
		HashSet<EnumerationLiteral> commonCategories = new HashSet<>(this.categories);
		commonCategories.removeAll(that.categories);
		return new SecurityLabel(Math.min(this.level, that.level), commonCategories);
	}

//
//	public void setSecurityLevel(final NamedElement ph, final long level) {
//		// Create new property value: An Integer value
//		final IntegerLiteral newpv = Aadl2Factory.eINSTANCE.createIntegerLiteral();
//		// Set the integer value to the new value
//		newpv.setValue(level);
//		// Set the property association
//		ph.setPropertyValue(securityLevel, newpv);
//	}
}
