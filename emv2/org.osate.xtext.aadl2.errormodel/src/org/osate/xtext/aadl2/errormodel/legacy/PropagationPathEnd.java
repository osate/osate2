package org.osate.xtext.aadl2.errormodel.legacy;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

public class PropagationPathEnd {

	InstanceObject instanceObject;
	ErrorPropagation errorPropagation;

	public PropagationPathEnd(InstanceObject compconnInstance, ErrorPropagation errorPropagation) {
		instanceObject = compconnInstance;
		this.errorPropagation = errorPropagation;
	}

	public ComponentInstance getComponentInstance() {
		if (instanceObject instanceof ComponentInstance) {
			return (ComponentInstance) instanceObject;
		}
		return null;
	}

	public ConnectionInstance getConnectionInstance() {
		return instanceObject instanceof ConnectionInstance ? (ConnectionInstance) instanceObject : null;
	}

	public ErrorPropagation getErrorPropagation() {
		return errorPropagation;
	}

}
