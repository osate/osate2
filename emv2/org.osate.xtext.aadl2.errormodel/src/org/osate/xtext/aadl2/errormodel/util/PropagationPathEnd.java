package org.osate.xtext.aadl2.errormodel.util;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

public class PropagationPathEnd {
	
	ComponentInstance componentInstance;
	ErrorPropagation errorPropagation;
	public PropagationPathEnd(ComponentInstance componentInstance,
			ErrorPropagation errorPropagation) {
		super();
		this.componentInstance = componentInstance;
		this.errorPropagation = errorPropagation;
	}
	public ComponentInstance getComponentInstance() {
		return componentInstance;
	}
	public void setComponentInstance(ComponentInstance componentInstance) {
		this.componentInstance = componentInstance;
	}
	public ErrorPropagation getErrorPropagation() {
		return errorPropagation;
	}
	public void setErrorPropagation(ErrorPropagation errorPropagation) {
		this.errorPropagation = errorPropagation;
	}

}
