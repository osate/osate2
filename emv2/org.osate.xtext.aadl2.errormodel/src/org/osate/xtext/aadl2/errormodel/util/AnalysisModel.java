package org.osate.xtext.aadl2.errormodel.util;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.VirtualBus;
import org.osate.aadl2.VirtualProcessor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;
/**
 * The purpose of this class is to keep track of model elements involved in a particular EM analysis.
 * @author phf
 *
 */
public class AnalysisModel {

	protected ComponentInstance root; // component instance that is the root of the analysis
	protected EList<PropagationPath> propagationPaths = new BasicEList<PropagationPath>(); // component instances (with emv2 propagations) within the root
	protected EList<ComponentInstance> subcomponents = new UniqueEList<ComponentInstance>(); // component instances (with emv2 propagations) within the root
	protected EList<ConnectionInstance> connections = new BasicEList<ConnectionInstance>(); // connection instances whose bond resources have a emv2 propagation
	
	public AnalysisModel(ComponentInstance root) {
		this.root = root;
		List<ConnectionInstance> cilist = EcoreUtil2.getAllContentsOfType(root, ConnectionInstance.class);
		for (ConnectionInstance connectionInstance : cilist) {
			populateConnectionPropagationPaths(connectionInstance);
		}
		
		/**
		 * 
		 * We also browse the list of all component instances.
		 * Then, for each process, we add an error path between the process
		 * and its associated processor. When being bound to a virtual processor,
		 * we also add a binding between the virtual processor and the physical
		 * processor. Also, the GetActualProcessingBinding returns the parent
		 * processor for virtual processors.
		 */
		List<ComponentInstance> complist = EcoreUtil2.getAllContentsOfType(root, ComponentInstance.class);
		for (ComponentInstance ci : complist)
		{
			if (! EMV2Util.hasEMV2Subclause(ci))
			{
				continue;
			}
			if (ci.getCategory() == ComponentCategory.PROCESS|| ci.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
			{
				populateBindingPaths(ci);
			}
		}
	}
	
	public AnalysisModel(ComponentInstance root, boolean closest) {
		this.root = root;
		List<ConnectionInstance> cilist = EcoreUtil2.getAllContentsOfType(root, ConnectionInstance.class);
		for (ConnectionInstance connectionInstance : cilist) {
			if (closest){
			populateShortestConnectionPropagationPaths(connectionInstance);
			} else {
				populateConnectionPropagationPaths(connectionInstance);
			}
		}
	}
	public EList<ComponentInstance> getSubcomponents() {
		return subcomponents;
	}
	public EList<ConnectionInstance> getConnections() {
		return connections;
	}
	public InstanceObject getRoot() {
		return root;
	}
	public void setRoot(ComponentInstance root) {
		this.root = root;
	}
	
	/**
	 * find the propagation paths with endpoints that are the lowest in the containment hierarchy
	 * @param connectionInstance
	 */
	protected void populateConnectionPropagationPaths(ConnectionInstance connectionInstance){
		EList<ConnectionReference> connrefs = connectionInstance.getConnectionReferences();
		ErrorPropagation srcprop = null;
		ComponentInstance srcCI = null;
		ErrorPropagation dstprop = null;
		ComponentInstance dstCI = null;
		for (ConnectionReference connectionReference : connrefs) {
			ConnectionInstanceEnd src = connectionReference.getSource();
			ConnectionInstanceEnd dst = connectionReference.getDestination();
			if (srcprop == null){ 
				if( src instanceof FeatureInstance){
					// remember the first src with EP
					srcCI = ((FeatureInstance)src).getContainingComponentInstance();
					srcprop = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
				} else if (src instanceof ComponentInstance){
					srcCI = (ComponentInstance) src;
					srcprop = EMV2Util.getOutgoingAccessErrorPropagation(srcCI);
				}
			} 
			// we have source. now find destination
			if (dst instanceof FeatureInstance){
				ErrorPropagation founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance)dst);
				if (founddst != null){
					// remember the last destination with EP
					dstprop = founddst;
					dstCI = ((FeatureInstance)dst).getContainingComponentInstance();
				}
			} else if (dst instanceof ComponentInstance){
				ErrorPropagation founddst = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance)dst);
				if (founddst != null){
					// remember the last destination with EP
					dstprop = founddst;
					dstCI = ((FeatureInstance)dst).getContainingComponentInstance();
				}
			}
		}
		if (srcprop!= null && dstprop!=null){
			propagationPaths.add(new PropagationPath(srcCI, srcprop, dstCI, dstprop));
			subcomponents.add(srcCI);
			subcomponents.add(dstCI);
		}
	}
	
	/**
	 * populate direct bindings from the specified component to its resources
	 * @param ci
	 */
	protected void populateBindingPaths(InstanceObject obj){
		if (obj instanceof ComponentInstance){
			ComponentInstance ci = (ComponentInstance)obj;
			List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding(ci);
			for (ComponentInstance cpu : cpus)
			{
				populateBindingPropagationPaths(ci, cpu,"processor");
			}
			if (!(ci instanceof VirtualProcessor)){
				// do memory bindings
				List<ComponentInstance> mems = InstanceModelUtil.getMemoryBinding(ci);
				for (ComponentInstance mem : mems)
				{
					populateBindingPropagationPaths(ci, mem,"memory");
				}
			}
			if (ci instanceof VirtualBus){
				// do connection bindings
				List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(ci);
				for (ComponentInstance bres : boundresources)
				{
					populateBindingPropagationPaths(ci, bres,"binding");
				}
			}
		} else if (obj instanceof ConnectionInstance){
			// do connection bindings
			List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(obj);
			for (ComponentInstance bres : boundresources)
			{
				populateBindingPropagationPaths((ConnectionInstance)obj, bres,"binding");
			}
		}
	}
	
	/**
	 * This is made to support the binding between component. Here, the first argument is the component 
	 * bound to a resource (e.g. a process) and the boundResource argument the associated resources (e.g. a processor).
	 * @param comp
	 * @param boundResource
	 */
	protected void populateBindingPropagationPaths(ComponentInstance comp, ComponentInstance boundResource,String resourcebindingKind){
		// source prop kind determined by destination and vice versa (BR = bound resource, BC bound component
		boolean added = false;
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource, "bindings");
		ErrorPropagation BCdstprop = EMV2Util.findIncomingErrorPropagation(comp, resourcebindingKind);

		if (BRsrcprop != null && BCdstprop != null ){
			if(EM2TypeSetUtil.contains(BRsrcprop.getTypeSet(), BCdstprop.getTypeSet()))
			{
				propagationPaths.add(new PropagationPath(boundResource, BRsrcprop, comp, BCdstprop));
				added = true;
			} else {
				// error message about mismatch of type set
			}
		}
		ErrorPropagation BCsrcprop = EMV2Util.findOutgoingErrorPropagation(comp,resourcebindingKind );
		 ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource, "bindings");
		 if (BCsrcprop != null && BRdstprop!=null){
			 if (EM2TypeSetUtil.contains(BCsrcprop.getTypeSet(), BRdstprop.getTypeSet()))
			 {
				 propagationPaths.add(new PropagationPath(comp, BCsrcprop, boundResource, BRdstprop));
				 added = true;
			 } else {
				 // error message about mismatch of type set
			 }
		 }
		if (added){
			subcomponents.add(comp);
			subcomponents.add(boundResource);
		}
	}
	
	/**
	 * This is made to support the binding between connection and components. Here, the first argument is the connection 
	 * bound to a resource and the boundResource argument the associated resources (e.g. a bus).
	 * @param conn
	 * @param boundResource
	 */
	protected void populateBindingPropagationPaths(ConnectionInstance conn, ComponentInstance boundResource,String bindingKind){
		boolean added = false;
		// source prop kind determined by destination and vice versa (BR = bound resource, BC bound component
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource, bindingKind);

		if (BRsrcprop != null  )
		{
			propagationPaths.add(new PropagationPath(boundResource, BRsrcprop,conn));
			added = true;
		} else {
			// error message about mismatch of type set
		}
		 ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource, bindingKind);
		if (BRsrcprop != null)
		{
			propagationPaths.add(new PropagationPath(conn, boundResource, BRdstprop));
			added = true;
		} else {
			// error message about mismatch of type set
		}
		if (added){
			connections.add(conn);
			subcomponents.add(boundResource);
		}
	}
	
	/**
	 * find the ends with EP that are the highest in the containment hierarchy
	 * @param connectionInstance
	 */
	protected void populateShortestConnectionPropagationPaths(ConnectionInstance connectionInstance){
		EList<ConnectionReference> connrefs = connectionInstance.getConnectionReferences();
		ErrorPropagation srcprop = null;
		ComponentInstance srcCI = null;
		ErrorPropagation dstprop = null;
		ComponentInstance dstCI = null;
		for (ConnectionReference connectionReference : connrefs) {
			ConnectionInstanceEnd src = connectionReference.getSource();
			ConnectionInstanceEnd dst = connectionReference.getDestination();
			ErrorPropagation foundsrc = null;
			if( src instanceof FeatureInstance){
				// remember the first src with EP
				foundsrc = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
				if (foundsrc != null){
					// remember the highest source with EP
					srcprop = foundsrc;
					srcCI = ((FeatureInstance)src).getContainingComponentInstance();
				}
			} else if (src instanceof ComponentInstance){
				foundsrc = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance)src);
				if (foundsrc != null){
					// remember the highest source with EP
					srcprop = foundsrc;
					srcCI = (ComponentInstance)src;
				}
			}
			if (dstprop == null){
				if (dst instanceof FeatureInstance){
					dstprop = EMV2Util.getIncomingErrorPropagation((FeatureInstance)dst);
					dstCI = ((FeatureInstance)dst).getContainingComponentInstance();
				} else if (dst instanceof ComponentInstance){
					dstprop = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance)dst);
					dstCI = (ComponentInstance)dst;
				}
			}
		}
		if (srcprop!= null && dstprop!= null){
			propagationPaths.add(new PropagationPath(srcCI, srcprop, dstCI, dstprop));
			subcomponents.add(srcCI);
			subcomponents.add(dstCI);
		}
	}
	
	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ComponentInstance ci, ErrorPropagation outEP){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == outEP){
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}
	
	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ConnectionInstance ci){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getConnectionInstance() == ci ){
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}
	
	public EList<PropagationPath> getAllPropagationPaths(ComponentInstance ci, ErrorPropagation outEP){
		EList<PropagationPath> result= new BasicEList<PropagationPath>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == outEP){
				result.add(propagationPathRecord);
			}
		}
		return result;
	}
	
	public EList<PropagationPath> getAllPropagationPaths(ConnectionInstance ci){
		EList<PropagationPath> result= new BasicEList<PropagationPath>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getConnectionInstance() == ci ){
				result.add(propagationPathRecord);
			}
		}
		return result;
	}
	
	public EList<PropagationPathEnd> getAllPropagationSourceEnds(ComponentInstance ci, ErrorPropagation inEP){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == inEP){
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}
	
	public EList<PropagationPathEnd> getAllPropagationSourceEnds(ConnectionInstance ci){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if(src.getConnectionInstance() == ci ){
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}
	
	public EList<PropagationPath> getAllReversePropagationPaths(ComponentInstance ci, ErrorPropagation inEP){
		EList<PropagationPath> result= new BasicEList<PropagationPath>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == inEP){
				result.add(propagationPathRecord);
			}
		}
		return result;
	}

	public EList<PropagationPath> getAllReversePropagationPaths(ConnectionInstance ci){
		EList<PropagationPath> result= new BasicEList<PropagationPath>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if(src.getConnectionInstance() == ci ){
				result.add(propagationPathRecord);
			}
		}
		return result;
	}

	
	/**
	 * return all feature (or for access component) instances that are the connection destination of the given feature instance
	 * The source and destinations are assumed to be components with error models
	 * @param fi
	 * @return list of ConnectionInstanceEnd
	 */
	public EList<ConnectionInstanceEnd> getAllPropagationDestinationEnds(ConnectionInstanceEnd fi){
		EList<ConnectionInstanceEnd> result= new BasicEList<ConnectionInstanceEnd>();
		NamedElement f = null;
		if (fi instanceof FeatureInstance){
		f = ((FeatureInstance)fi).getFeature();
		} else {
			f = ((ComponentInstance)fi).getSubcomponent();
		}
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			ErrorPropagation ep = src.getErrorPropagation();
			Feature srcf = EMV2Util.getFeature(ep);
			if (srcf != null && srcf == f){
				PropagationPathEnd dst = propagationPathRecord.pathDst;
				ErrorPropagation dstep = dst.getErrorPropagation();
				if (dstep != null){
					Feature dstf = EMV2Util.getFeature(dstep);
					ComponentInstance dstCI = dst.getComponentInstance();
					if (dstf != null){
						FeatureInstance dstfi = dstCI.findFeatureInstance(dstf);
						result.add(dstfi);
					} else if (EMV2Util.isAccess(dstep)){
						result.add(dstCI);
					}
				}
			}
		}
		return result;
	}
	

}
