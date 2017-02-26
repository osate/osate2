package org.osate.ge.internal.boTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BusinessObjectTreeConfiguration {
	private final Collection<Rule> enabledRules;
	private final Collection<EnabledProviderGroupNode> enabledProviders;	
	
	public BusinessObjectTreeConfiguration(final Collection<Rule> enabledRules,
			final Collection<EnabledProviderGroupNode> enabledProviders) {
		this.enabledRules = Collections.unmodifiableCollection(new ArrayList<>(Objects.requireNonNull(enabledRules, "enabledRules must not be null")));
		this.enabledProviders = Collections.unmodifiableCollection(new ArrayList<>(Objects.requireNonNull(enabledProviders, "enabledProviders must not be null")));
	}
}
