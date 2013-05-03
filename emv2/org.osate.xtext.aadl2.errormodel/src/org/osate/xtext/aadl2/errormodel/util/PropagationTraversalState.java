package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class PropagationTraversalState {
	TypeToken token;
	
	Collection<TypeToken> sourceTokenSet;
	
	String result;

	public PropagationTraversalState(Collection<TypeToken> sourceTokenSet, String result) {
		super();
		this.sourceTokenSet = sourceTokenSet;
		this.result = result;
	}

	public TypeToken getToken() {
		return token;
	}

	public void setToken(TypeToken token) {
		this.token = token;
	}

	public Collection<TypeToken> getSourceTokenSet() {
		return sourceTokenSet;
	}

	public void setSourceTokenSet(Collection<TypeToken> sourceTokenSet) {
		this.sourceTokenSet = sourceTokenSet;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
