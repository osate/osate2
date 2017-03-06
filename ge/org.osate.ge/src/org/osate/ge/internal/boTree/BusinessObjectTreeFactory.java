package org.osate.ge.internal.boTree;

import java.util.List;
import java.util.Objects;

public class BusinessObjectTreeFactory {
	public static BusinessObjectTree createBusinessObjectTree(final BusinessObjectTreeConfiguration config, 
			final List<BusinessObjectProvider> allProviders, // TODO: Should be in priority order
			final Object rootBusinessObject) {
		Objects.requireNonNull(config, "config must not be null");
		Objects.requireNonNull(allProviders, "allProviders must not be null");

		// TODO: Build business object tree using config.
		// Track the rules
		
		throw new RuntimeException("Not Implemented");
	}
}
