/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
