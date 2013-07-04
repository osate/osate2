package org.osate.xtext.aadl2.errormodel.util;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

public class PropagationPathEnd {
	
	InstanceObject instanceObject;
	ErrorPropagation errorPropagation;
	public PropagationPathEnd(InstanceObject compconnInstance,
			ErrorPropagation errorPropagation) {
		this.instanceObject = compconnInstance;
		this.errorPropagation = errorPropagation;
	}

	public ComponentInstance getComponentInstance() {
		if( instanceObject instanceof ComponentInstance) return (ComponentInstance)instanceObject;
		if (instanceObject instanceof FeatureInstance) return instanceObject.getComponentInstance();
		return null;
	}
	
	public ConnectionInstanceEnd getConnectionInstanceEnd() {
		if( instanceObject instanceof ConnectionInstanceEnd) return (ConnectionInstanceEnd)instanceObject;
		return null;
	}
	
	public FeatureInstance getFeatureInstance() {
		if( instanceObject instanceof FeatureInstance) return (FeatureInstance)instanceObject;
		return null;
	}

	public ConnectionInstance getConnectionInstance() {
		return instanceObject instanceof ConnectionInstance?(ConnectionInstance)instanceObject:null;
	}

	public ErrorPropagation getErrorPropagation() {
		return errorPropagation;
	}

}
