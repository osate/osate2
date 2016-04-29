/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
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
	
	public static String buildUniqueIdentifier(final ErrorBehaviorStateMachine sm, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(sm);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);		
	}
	
	/**
	 * Returns null if validation succeeds. Otherwise, returns a reason the name is not valid.
	 * @param lib
	 * @param oldName
	 * @param newName
	 * @return
	 */
	public static String validateName(final ErrorModelLibrary lib, final String oldName, final String newName) {
		return validateName(buildNameSet(lib), oldName, newName);
	}
	
	public static String validateName(final ErrorBehaviorStateMachine sm, final String oldName, final String newName) {
		return validateName(buildNameSet(sm), oldName, newName);
	}
	
	public static String validateName(final Set<String> existingNames, final String oldName, final String newName) {
    	if(newName.equalsIgnoreCase(oldName)) {
    		// Name is unchanged
    		return null;
    	}
    	
		final Set<String> existingIdentifiers = existingNames;
		if(existingIdentifiers.contains(newName.toLowerCase())) {
			return "The specified name conflicts with an existing element.";
		}
		
		return null;
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
	
	private static Set<String> buildNameSet(final ErrorBehaviorStateMachine sm) {
		final Set<String> names = new HashSet<String>();
		ErrorModelNamingHelper.addToNameSet(names, sm.getEvents());
		ErrorModelNamingHelper.addToNameSet(names, sm.getStates());
		ErrorModelNamingHelper.addToNameSet(names, sm.getTransitions());
		return names;
	}
		
	public static void addToNameSet(final Set<String> names, final Collection<? extends NamedElement> elements) {
		for(final NamedElement el : elements) {
			if(el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
	}
}
