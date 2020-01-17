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
package org.osate.xtext.aadl2.errormodel.util;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * This class is used to track the error behavior state as well as the tokens associated with a component instance..
 * We can record the current state and token.
 * We also track a history of tokens, i.e., whether the token has been there before.
 * This is useful for identifying cycles when performing impact analysis or other forms os simulated
 * error propagation.
 * @author phf
 *
 */
public interface ErrorModelState {

	/**
	 * set the current state to the token.
	 * Also record it in the visited history.
	 * return true if previously visited.
	 * return false if not previously visited.
	 * @param token
	 * @return
	 */
	public void setVisitToken(ErrorPropagation ep, TypeToken token);

	/**
	 * remove the token from the visited list
	 * @param token
	 */
	public void removeVisitedToken(ErrorPropagation ep, TypeToken token);

	/**
	 * returns true if type token is already in the list of visited tokens.
	 * This test will also return true if its supertype is included
	 * @param tt
	 * @return
	 */
	public boolean visited(ErrorPropagation ep, TypeToken tt);

	/**
	 * current error behavior state of a component
	 * Should only be set for components
	 * FOr states with error types, the type token represents the token
	 * @return
	 */
	public ErrorBehaviorState getErrorState();

	/**
	 * set the current error behavior state of a component
	 * @param errorBehaviorState
	 */
	public void setErrorState(ErrorBehaviorState errorBehaviorState);

	/**
	 * set all elements of error model state to null
	 */
	public void unsetAll();
}
