package org.osate.aadl2.errormodel.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

public class AnalysisModel {

	protected ComponentInstance root;
	protected EList<ComponentInstance> subComponents = new UniqueEList<ComponentInstance>();
	protected EList<ConnectionInstance> connections = new UniqueEList<ConnectionInstance>();
	protected EList<FlowSpecificationInstance> flows = new UniqueEList<FlowSpecificationInstance>();
	
	
	
	public AnalysisModel(ComponentInstance root) {
		this.root = root;
		subComponents = EM2Util.getComponentInstancesWithErrorPropagations(root);
	}
	public InstanceObject getRoot() {
		return root;
	}
	public void setRoot(ComponentInstance root) {
		this.root = root;
	}
	public EList<ComponentInstance> getSubComponents() {
		return subComponents;
	}
	public void setSubComponents(EList<ComponentInstance> subComponents) {
		this.subComponents = subComponents;
	}
	
	public ComponentInstance getContainingComponentInstance(InstanceObject ci){
		for (ComponentInstance modelCI : subComponents) {
			if (AadlUtil.containedIn(ci, modelCI)) return modelCI;
		}
		return null;
	}
	
	public EList<ConnectionInstance> getConnections() {
		return connections;
	}
	public void setConnections(EList<ConnectionInstance> connections) {
		this.connections = connections;
	}
	public EList<FlowSpecificationInstance> getFlows() {
		return flows;
	}
	public void setFlows(EList<FlowSpecificationInstance> flows) {
		this.flows = flows;
	}
	
	
}
