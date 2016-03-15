/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import org.osate.aadl2.SubprogramCall;

/**
 * Used to store the ordering of subprogram calls.
 *
 */
public class SubprogramCallOrder {
	public final SubprogramCall previousSubprogramCall; // The subprogram call before the subprogram call stored in subprogramCall
	public final SubprogramCall subprogramCall;
	
	public SubprogramCallOrder(final SubprogramCall previousSubprogramCall, final SubprogramCall subprogramCall) {
		this.previousSubprogramCall = previousSubprogramCall;
		this.subprogramCall = subprogramCall;
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
}
