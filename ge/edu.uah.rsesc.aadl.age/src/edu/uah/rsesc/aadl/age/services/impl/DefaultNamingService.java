package edu.uah.rsesc.aadl.age.services.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;

import edu.uah.rsesc.aadl.age.services.NamingService;

public class DefaultNamingService implements NamingService {
	@Override
	public String buildUniqueIdentifier(final Namespace namespace, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(namespace.getMembers());
		
		// Resolve naming conflicts
		String newIdentifier = baseIdentifier;
		boolean done = false;
		int num = 1;
		do {			
			if(existingIdentifiers.contains(newIdentifier.toLowerCase())) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while(!done);
		
		return newIdentifier;
	}
	
	/**
	 * Builds a set containing the names of a list of elements
	 * @param elements
	 * @param namedElements
	 * @return
	 */
	private Set<String> buildNameSet(final Collection<? extends NamedElement> elements) {
		final Set<String> names = new HashSet<String>();
		for(final NamedElement el : elements) {
			if(el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
		return names;
	}
}
