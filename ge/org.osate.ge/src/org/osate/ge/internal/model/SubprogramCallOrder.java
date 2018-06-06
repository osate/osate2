/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.SubprogramCall;
import org.osate.ge.EmfContainerProvider;

/**
 * Used to store the ordering of subprogram calls.
 *
 */
public class SubprogramCallOrder implements EmfContainerProvider {
	public final SubprogramCall previousSubprogramCall; // The subprogram call before the subprogram call stored in subprogramCall
	public final SubprogramCall subprogramCall;
	
	public SubprogramCallOrder(final SubprogramCall previousSubprogramCall, final SubprogramCall subprogramCall) {
		this.previousSubprogramCall = Objects.requireNonNull(previousSubprogramCall, "previousSubprogramCall must not be null");
		this.subprogramCall = Objects.requireNonNull(subprogramCall, "subprogramCall must not be null");
	}
	
	@Override
	public int hashCode() {
		return previousSubprogramCall.hashCode() + subprogramCall.hashCode();
	}
	
	@Override
    public boolean equals(final Object obj) {
		if(!(obj instanceof SubprogramCallOrder)) {
			return false;
		}
		
		if(obj == this) {
			return true;
		}
		
		final SubprogramCallOrder rhs = (SubprogramCallOrder)obj;
		
		// Consider the call orders equal if the same model objects are referenced.
		return previousSubprogramCall == rhs.previousSubprogramCall && subprogramCall == rhs.subprogramCall;
	}

	@Override
	public EObject getEmfContainer() {
		// The container of the subprogram call should be a subprogram call sequence which is the logical container of the subprogram call order
		return subprogramCall.eContainer();
	}
	
	public static List<SubprogramCallOrder> getSubprogramCallOrders(final List<SubprogramCall> subprogramCalls) {
		final List<SubprogramCallOrder> callOrders = new ArrayList<SubprogramCallOrder>();
		
		// Create SubprogramCallOrder objects to store the order of the subprogram calls
		for(int i = 1; i < subprogramCalls.size(); i++) {
			callOrders.add(new SubprogramCallOrder(subprogramCalls.get(i-1), subprogramCalls.get(i)));
		}
		
		return callOrders;
	}
}
