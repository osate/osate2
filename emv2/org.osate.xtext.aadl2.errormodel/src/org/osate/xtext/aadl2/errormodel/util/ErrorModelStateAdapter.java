package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class ErrorModelStateAdapter extends AdapterImpl implements ErrorModelState {

	protected TypeToken token;

	protected ErrorBehaviorState currentErrorState;

	protected Collection<TypeToken> visited = new BasicEList<TypeToken>();

	public TypeToken getToken() {
		return token;
	}

	public void setToken(TypeToken token) {
		this.token = token;
	}

	public void setVisitToken(TypeToken token) {
		this.token = token;
		visited.add(token);
	}

	public void removeVisitedToken(TypeToken token) {
		visited.remove(token);
	}

	public void unsetToken() {
		token = null;
	}

	public ErrorBehaviorState getErrorState() {
		return currentErrorState;
	}

	public void setErrorState(ErrorBehaviorState errorBehaviorState) {
		currentErrorState = errorBehaviorState;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ErrorModelState.class;
	}

	public void unsetAll() {
		token = null;
		currentErrorState = null;
		visited.clear();
	}

	public Collection<TypeToken> getVisitedTokens() {
		return visited;
	}

	public boolean visited(TypeToken tt) {
		for (TypeToken tok : visited) {
			if (EM2TypeSetUtil.contains(tok, tt)) {
				return true;
			}
		}
		return false;
	}

}
