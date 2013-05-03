package org.osate.xtext.aadl2.errormodel.util;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class ErrorModelStateAdapter extends AdapterImpl implements ErrorModelState{

	protected TypeToken token;

	protected ErrorBehaviorState currentErrorState;

	public TypeToken getToken(){
		return token;
	}
	
	public void setToken(TypeToken token){
		this.token = token;
	}
	
	public void unsetToken(){
		this.token = null;
	}

	public ErrorBehaviorState getErrorState(){
		return currentErrorState;
	}
	
	public void setErrorState(ErrorBehaviorState errorBehaviorState) {
		this.currentErrorState = errorBehaviorState;
	}
	
	public boolean isAdapterForType(Object type){
		return type == ErrorModelState.class;
	}
	
	public void unsetAll(){
		this.token = null;
		this.currentErrorState = null;
		
	}


}
