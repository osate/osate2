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
