package org.osate.xtext.aadl2.errormodel.util;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public interface ErrorModelState {

	/**
	 * the type token associated with a given model object
	 * For model objects that also have an error state the typetoken applies to the state
	 * @return
	 */
	public TypeToken getToken();
	
	/**
	 * set the type token for model object
	 * @param token
	 */
	public void setToken(TypeToken token);
	
	/**
	 * set the type token for model object to null
	 * @param token
	 */
	public void unsetToken();

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
