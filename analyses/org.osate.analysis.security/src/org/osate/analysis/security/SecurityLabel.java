package org.osate.analysis.security;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class SecurityLabel {

	private static Property securityLabelProperty = null;

	public static Optional<SecurityLabel> of(NamedElement ne) {
		if (securityLabelProperty == null) {
			securityLabelProperty = GetProperties.lookupPropertyDefinition(ne, "SecurityProps::Label");
		}
		try {
			final PropertyExpression pe = ne.getSimplePropertyValue(securityLabelProperty);
			if (pe instanceof RecordValue) {
				RecordValue rv = (RecordValue) pe;
				long level = -1;
				Set<EnumerationLiteral> tags = new HashSet<>();
				for (BasicPropertyAssociation field : rv.getOwnedFieldValues()) {
					if (field.getProperty().getName().equalsIgnoreCase("level")) {
						List<EnumerationLiteral> literals = ((EnumerationType) field.getProperty().getPropertyType())
								.getOwnedLiterals();
						EnumerationLiteral ev = (EnumerationLiteral) ((NamedValue) field.getValue()).getNamedValue();
						for (int i = 0; i < literals.size(); i += 1) {
							if (ev == literals.get(i)) {
								level = i;
							}
						}
					} else if (field.getProperty().getName().equalsIgnoreCase("tags")) {
						List<PropertyExpression> lelems = ((ListValue) field.getValue()).getOwnedListElements();
						for (PropertyExpression nv : lelems) {
							EnumerationLiteral literal = (EnumerationLiteral) ((NamedValue) nv).getNamedValue();

							tags.add(literal);
						}
					}
				}
				return Optional.of(new SecurityLabel(level, tags));
			} else {
				return Optional.empty();
			}
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	/**
	 * @return the securityLabelProperty
	 */
	public static Property getSecurityLabelProperty() {
		return securityLabelProperty;
	}

	/**
	 * @return the securityLabelProperty
	 */
	public static Property getSecurityLabelProperty(NamedElement ne) {
		if (securityLabelProperty == null) {
			securityLabelProperty = GetProperties.lookupPropertyDefinition(ne, "SecurityProperties::SecurityLabel");
		}
		return securityLabelProperty;
	}

	/**
	 * @param securityLabelProperty the securityLabelProperty to set
	 */
	public static void setSecurityLabelProperty(Property securityLabelProperty) {
		SecurityLabel.securityLabelProperty = securityLabelProperty;
	}

	private long level;

	private Set<EnumerationLiteral> tags;

	public SecurityLabel(long level, Set<EnumerationLiteral> tags) {
		this.level = level;
		this.tags = tags;
	}

	/**
	 * @return the level
	 */
	public long getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(long level) {
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
		return "SecurityLabel [level=" + level + ", tags="
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
		result = prime * result + (int) (level ^ (level >>> 32));
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
		return !this.greaterThan(that);
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
