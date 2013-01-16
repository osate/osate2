package org.osate.aadl2.errormodel.analysis;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Feature;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
/**
 * The purpose of this class is to keep track of model elements involved in a particular EM analysis.
 * @author phf
 *
 */
public class AnalysisModel {

	protected ComponentInstance root; // component instance that is the root of the analysis
	protected EList<ComponentInstance> subComponents = new UniqueEList<ComponentInstance>(); // component instances (with emv2 propagations) within the root
	protected Multimap <ConnectionInstanceEnd,ConnectionInstanceEnd> outgoingConnections = HashMultimap.create(); // connections key: srcFI, value colelction of dstFI.
	protected Multimap <ConnectionInstanceEnd,ConnectionInstanceEnd> incomingConnections = HashMultimap.create();  
	protected EList<FlowSpecificationInstance> flows = new UniqueEList<FlowSpecificationInstance>(); // flow spec instances of the subcomponents
	
	
	public AnalysisModel(ComponentInstance root) {
		this.root = root;
		subComponents = EM2Util.getComponentInstancesWithErrorPropagations(root);
		for (ComponentInstance ci : subComponents){
			populateOutgoingConnections(ci);
		}
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
	/**
	 * find component instance in Analysis Model subcomponent list that contains the specified CI
	 * @param ci
	 * @return
	 */
	public ComponentInstance getContainingComponentInstance(InstanceObject ci){
		for (ComponentInstance modelCI : subComponents) {
			if (AadlUtil.containedIn(ci, modelCI)) return modelCI;
		}
		return null;
	}
	
	public Collection<ConnectionInstanceEnd> getConnectionDestinations(ConnectionInstanceEnd fi) {
		return outgoingConnections.get(fi);
	}
	
	public Collection<ConnectionInstanceEnd> getConnectionSources(ConnectionInstanceEnd fi) {
		if (incomingConnections == null){
			incomingConnections = Multimaps.invertFrom(outgoingConnections, incomingConnections);
		}
		return incomingConnections.get(fi);
	}
	
	public EList<FlowSpecificationInstance> getFlows() {
		return flows;
	}
	public void setFlows(EList<FlowSpecificationInstance> flows) {
		this.flows = flows;
	}
	
	 
	/**
	 * find outgoing connection that goes through the feature of the specified component instance
	 * @param ci Component instance
	 * @param fi Feature instance
	 * @return list of connection instances going through the feature
	 */
	protected void  populateOutgoingConnections(ComponentInstance ci) {
		EList<FeatureInstance> fil = ci.getFeatureInstances();
		for (FeatureInstance fi : fil) {
			Feature f = fi.getFeature();
			Iterable<ConnectionInstance> it = ci.getSystemInstance().getAllConnectionInstances();// allEnclosingConnectionInstances();
			for (ConnectionInstance connectionInstance : it) {
				ConnectionInstanceEnd src = connectionInstance.getSource();
				ComponentInstance srcci = src.getContainingComponentInstance();
				if (Aadl2InstanceUtil.containedIn(srcci, ci)) {
					EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
					for (ConnectionReference connectionReference : connreflist) {
						ComponentInstance pci = connectionReference.getContext();
						Connection conn = connectionReference.getConnection();
						ConnectionEnd ce = conn.getAllSource();
						if (pci == ci.getContainingComponentInstance() && ce == f){
							// 
							ConnectionInstanceEnd dst = connectionInstance.getDestination();
							ComponentInstance dstci = getContainingComponentInstance(dst);
							ConnectionInstanceEnd desti = Aadl2InstanceUtil.getDestEndPointInstance(dstci,connectionInstance);
							outgoingConnections.put(fi,desti);
						}
					}
				}
			}
		}
	}
	
	protected ConnectionInstanceEnd getDestEndPointInstance(ConnectionInstance connectionInstance){
		ConnectionInstanceEnd dst = connectionInstance.getDestination();
		ComponentInstance dstci = getContainingComponentInstance(dst);
		return Aadl2InstanceUtil.getDestEndPointInstance(dstci,connectionInstance);
	}
	
	protected ConnectionInstanceEnd getSrcEndPointInstance(ConnectionInstance connectionInstance){
		ConnectionInstanceEnd src = connectionInstance.getSource();
		ComponentInstance srcci = getContainingComponentInstance(src);
		return Aadl2InstanceUtil.getDestEndPointInstance(srcci,connectionInstance);
	}

	
	
}
