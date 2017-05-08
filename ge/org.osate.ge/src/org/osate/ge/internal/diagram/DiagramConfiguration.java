package org.osate.ge.internal.diagram;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Immutable type which represents the diagram configuration.
 * 
 * @see DiagramConfigurationBuilder
 */
public class DiagramConfiguration {
	private final CanonicalBusinessObjectReference rootBoReference;
	private final Set<String> lcEnabledAadlPropertyNames; // Lowercase AADL property names
	
	DiagramConfiguration(final CanonicalBusinessObjectReference rootBoReference, final Set<String> displayedAadlPropertyNames) {
		this.rootBoReference = rootBoReference == null ? null : rootBoReference;
		this.lcEnabledAadlPropertyNames = Collections.unmodifiableSet(new HashSet<String>(Objects.requireNonNull(displayedAadlPropertyNames, "displayedAadlPropertyNames must not be null")));
	}
	
	public CanonicalBusinessObjectReference getRootBoReference() {
		return rootBoReference;
	}
	
	/**
	 * Returns an unmodifiable collection of enable AADL qualified property names. All names will be lower case.
	 * @return
	 */
	public Set<String> getEnabledAadlPropertyNames() {
		return lcEnabledAadlPropertyNames;
	}
	
	@Override
	public String toString() {
		return "{ root business object reference: " + rootBoReference + " } ";
	}
}
