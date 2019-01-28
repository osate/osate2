package org.osate.analysis.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class SecurityPolicy {

	public enum PolicyElement {
		NO_WRITE_UP, NO_READ_UP, NO_WRITE_DOWN, NO_READ_DOWN, NO_INTERPARTITION
	}

	public enum Access {
		READ, WRITE
	}

	public List<PolicyElement> elements = new ArrayList<>();

	private static Property securityPolicyProperty = null;

	public static Optional<SecurityPolicy> of(NamedElement ne) {
		if (securityPolicyProperty == null) {
			securityPolicyProperty = GetProperties.lookupPropertyDefinition(ne, "SecurityProps::PolicyElements");
		}
		try {
			final List<? extends PropertyExpression> pes = ne.getPropertyValueList(securityPolicyProperty);
			Set<PolicyElement> elems = new HashSet<>();

			for (PropertyExpression pe : pes) {
				EnumerationLiteral literal = (EnumerationLiteral) ((NamedValue) pe).getNamedValue();

				for (PolicyElement ev : PolicyElement.values()) {
					String enumName = ev.name().replaceAll("_", "");
					if (enumName.equalsIgnoreCase(literal.getName())) {
						elems.add(ev);
						break;
					}
				}
			}
			return Optional.of(new SecurityPolicy(elems));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public SecurityPolicy(PolicyElement... elements) {
		Collections.addAll(this.elements, elements);
	}

	public SecurityPolicy(Collection<PolicyElement> elements) {
		this.elements.addAll(elements);
	}

	public boolean isValid(Access dir, SecurityLabel label1, SecurityLabel label2) {
		if (label1.equals(label2)) {
			return true;
		}
		boolean down = label1.greaterThan(label2);
		boolean up = label1.lessThan(label2);
		boolean valid = true;
		for (PolicyElement pe : elements) {
			switch (pe) {
			case NO_READ_UP:
				if (dir == Access.READ && up) {
					valid = false;
				}
				break;
			case NO_READ_DOWN:
				if (dir == Access.READ && down) {
					valid = false;
				}
				break;
			case NO_WRITE_UP:
				if (dir == Access.WRITE && up) {
					valid = false;
				}
				break;
			case NO_WRITE_DOWN:
				if (dir == Access.WRITE && down) {
					valid = false;
				}
				break;
			default:
				break;
			}
			if (!valid) {
				break;
			}
		}
		return valid;
	}
}
