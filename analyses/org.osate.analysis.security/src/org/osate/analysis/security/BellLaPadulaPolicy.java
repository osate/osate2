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

public class BellLaPadulaPolicy {

	public enum PolicyElement {
		NO_WRITE_UP, NO_READ_UP, NO_WRITE_DOWN, NO_READ_DOWN, NO_FLOW_UP, NO_FLOW_DOWN, NO_CONTAINMENT_UP, NO_CONTAINMENT_DOWN, NO_INTERPARTITION
	}

	public enum Access {
		READ, WRITE, FLOW, CONTAINMENT
	}

	public List<PolicyElement> elements = new ArrayList<>();

	private static Property securityPolicyProperty = null;

	public static Optional<BellLaPadulaPolicy> of(NamedElement ne) {
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
			return Optional.of(new BellLaPadulaPolicy(elems));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public BellLaPadulaPolicy(PolicyElement... elements) {
		Collections.addAll(this.elements, elements);
	}

	public BellLaPadulaPolicy(Collection<PolicyElement> elements) {
		this.elements.addAll(elements);
	}

	public boolean allows(Access dir, SecurityLabel label1, SecurityLabel label2) {
		if (label1.equals(label2)) {
			return true;
		}
		boolean down = label1.dominates(label2);
		boolean up = label2.dominates(label1);
		if (!(up || down)) {
			return false;
		}
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
			case NO_FLOW_UP:
				if (dir == Access.FLOW && up) {
					valid = false;
				}
				break;
			case NO_FLOW_DOWN:
				if (dir == Access.FLOW && down) {
					valid = false;
				}
				break;
			case NO_CONTAINMENT_UP:
				if (dir == Access.CONTAINMENT && up) {
					valid = false;
				}
				break;
			case NO_CONTAINMENT_DOWN:
				if (dir == Access.CONTAINMENT && down) {
					valid = false;
				}
				break;
			case NO_INTERPARTITION:
				valid = false;
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
