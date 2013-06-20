package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class ErrorModelStateAdapter extends AdapterImpl implements ErrorModelState{

	protected TypeToken token;

	protected ErrorBehaviorState currentErrorState;
	
	protected Collection <TypeToken> visited = new BasicEList<TypeToken>();

	public TypeToken getToken(){
		return token;
	}
	
	public void setToken(TypeToken token){
		this.token = token;
	}
	
	public void setVisitToken(TypeToken token){
		this.token = token;
		visited.add(token);
	}
	
	public void removeVisitedToken(TypeToken token){
		visited.remove(token);
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
		this.visited.clear();
	}

	public Collection<TypeToken> getVisitedTokens() {
		return visited;
	}
	
	public boolean visited(TypeToken tt){
		for(TypeToken tok: visited){
			if (EM2TypeSetUtil.contains(tok, tt)){
				return true;
			}
		}
		return false;
	}


}
