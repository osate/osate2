package org.osate.ge.errormodel.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

public class ErrorModelNamingHelper {
	public static String buildUniqueIdentifier(final ErrorModelLibrary lib, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(lib);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);		
	}
	
	public static String buildUniqueIdentifier(final ErrorModelSubclause sc, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(sc);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);		
	}
	
	private static String buildUniqueIdentifier(final Set<String> existingIdentifiers, final String baseIdentifier) {
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
	
	private static Set<String> buildNameSet(final ErrorModelLibrary lib) {
		final Set<String> names = new HashSet<String>();
		addToNameSet(names, lib.getBehaviors());
		addToNameSet(names, lib.getMappings());
		addToNameSet(names, lib.getTransformations());
		addToNameSet(names, lib.getTypes());
		addToNameSet(names, lib.getTypesets());
		return names;
	}
	
	private static Set<String> buildNameSet(final ErrorModelSubclause sc) {
		final Set<String> names = new HashSet<String>();
		addToNameSet(names, sc.getConnectionErrorSources());
		addToNameSet(names, sc.getErrorDetections());
		addToNameSet(names, sc.getEvents());
		addToNameSet(names, sc.getFlows());
		addToNameSet(names, sc.getOutgoingPropagationConditions());
		addToNameSet(names, sc.getPaths());
		addToNameSet(names, sc.getPoints());
		addToNameSet(names, sc.getPropagations());
		addToNameSet(names, sc.getStates());
		addToNameSet(names, sc.getTransitions());		
		return names;
	}
	
	private static void addToNameSet(final Set<String> names, final Collection<? extends NamedElement> elements) {
		for(final NamedElement el : elements) {
			if(el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
	}
}
