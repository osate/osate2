package org.osate.analysis.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;

public class SecurityLabel {

	private static Property securityLevelProperty = null;

	private static Property securityCaveatsProperty = null;

	private static Map<EnumerationLiteral, Integer> literal2level = new HashMap<EnumerationLiteral, Integer>();

	private static Map<Integer, EnumerationLiteral> level2literal = new HashMap<Integer, EnumerationLiteral>();

	public static Optional<SecurityLabel> of(NamedElement ne) {
		if (securityLevelProperty == null) {
			init(ne);
		}

		int level = -1;
		try {
			NamedValue levelValue = (NamedValue) ne.getSimplePropertyValue(securityLevelProperty);
			EnumerationLiteral levelLiteral = (EnumerationLiteral) levelValue.getNamedValue();
			level = literal2level.get(levelLiteral);
		} catch (Exception e) {
		}
		try {
			Set<EnumerationLiteral> tags = new HashSet<EnumerationLiteral>();
			ListValue caveatsValue = (ListValue) ne.getSimplePropertyValue(securityCaveatsProperty);
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

	private static void init(NamedElement ne) {
		securityLevelProperty = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getProperty(),
				"Security_Classification_Properties::Security_Level");
		securityCaveatsProperty = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getProperty(),
				"Security_Classification_Properties::Security_Level_Caveats");
		EnumerationType levelType = Aadl2GlobalScopeUtil.get(ne, Aadl2Package.eINSTANCE.getPropertyType(),
				"Security_Type_Specifications::Level_Type");
		List<EnumerationLiteral> literals = levelType.getOwnedLiterals();
		for (int i = 0; i < literals.size(); i += 1) {
			// enumeration is ordered from high to low security
			int index = literals.size() - i;
			literal2level.put(literals.get(i), index);
			level2literal.put(index, literals.get(i));
		}
	}

	private Integer level;

	private Set<EnumerationLiteral> tags;

	public SecurityLabel(Integer level, Set<EnumerationLiteral> tags) {
		this.level = level;
		this.tags = tags;
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
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<EnumerationLiteral> tags) {
		this.tags = tags;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SecurityLabel [level=" + level2literal.get(level).getName()
				+ ", tags="
				+ tags.stream().map(EnumerationLiteral::getName).collect(Collectors.joining(", ", "{", "}")) + "]";
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
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
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
		if (tags == null) {
			if (other.tags != null) {
				return false;
			}
		} else if (!tags.equals(other.tags)) {
			return false;
		}
		return true;
	}

	public boolean dominates(SecurityLabel that) {
		return this.level >= that.level && this.tags.containsAll(that.tags);
	}

	public boolean greaterThan(SecurityLabel that) {
		return this.dominates(that) && !this.equals(that);
	}

	public boolean lessThan(SecurityLabel that) {
		return that.dominates(this) && !this.equals(that);
	}

	public SecurityLabel join(SecurityLabel that) {
		HashSet<EnumerationLiteral> allTags = new HashSet<>(this.tags);
		allTags.addAll(that.tags);
		return new SecurityLabel(Math.max(this.level, that.level), allTags);
	}

	public SecurityLabel meet(SecurityLabel that) {
		HashSet<EnumerationLiteral> allTags = new HashSet<>(this.tags);
		allTags.removeAll(that.tags);
		return new SecurityLabel(Math.min(this.level, that.level), allTags);
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
