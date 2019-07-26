package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class ErrorModelStateAdapter extends AdapterImpl implements ErrorModelState {
	private class EMNode {
		protected TypeToken token;
		protected ErrorPropagation ep;

	}

	protected EMNode emnode;

	protected ErrorBehaviorState currentErrorState;

	protected Collection<EMNode> visited = new BasicEList<EMNode>();

	@Override
	public void setVisitToken(ErrorPropagation ep, TypeToken token) {
		this.emnode = new EMNode();
		emnode.ep = ep;
		emnode.token = token;
		visited.add(this.emnode);
	}

	@Override
	public void removeVisitedToken(ErrorPropagation ep,TypeToken token) {
		EMNode found = findEMNode(ep, token);
		visited.remove(found);
	}

	@Override
	public ErrorBehaviorState getErrorState() {
		return currentErrorState;
	}

	@Override
	public void setErrorState(ErrorBehaviorState errorBehaviorState) {
		currentErrorState = errorBehaviorState;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ErrorModelState.class;
	}

	@Override
	public void unsetAll() {
		emnode = null;
		currentErrorState = null;
		visited.clear();
	}

	@Override
	public boolean visited(ErrorPropagation ep, TypeToken tt) {
		return findEMNode(ep, tt) != null;
	}

	private EMNode findEMNode(ErrorPropagation ep, TypeToken tt) {
		for (EMNode emn : visited) {
			if (emn.ep == ep && EMV2TypeSetUtil.contains(emn.token, tt)) {
				return emn;
			}
		}
		return null;
	}

}
