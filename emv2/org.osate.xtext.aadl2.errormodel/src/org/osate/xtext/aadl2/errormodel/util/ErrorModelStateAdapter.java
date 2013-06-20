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
	
	protected TypeSet visited = ErrorModelFactory.eINSTANCE.createTypeSet();

	public TypeToken getToken(){
		return token;
	}
	
	public void setToken(TypeToken token){
		this.token = token;
	}
	
	public boolean setVisitToken(TypeToken token){
		if (EM2TypeSetUtil.contains(visited, token)){
			return false;
		}
		this.token = token;
		visited.getElementType().add(token);
		return true;
	}
	
	public void removeVisitedToken(TypeToken token){
		visited.getElementType().remove(token);
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
		this.visited.getElementType().clear();
	}

	public Collection<TypeToken> getVisitedTokens() {
		return visited.getElementType();
	}
	
	public boolean visited(TypeToken tt){
		return (EM2TypeSetUtil.contains(visited, tt));
	}


}
