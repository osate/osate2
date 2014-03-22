package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.VirtualBus;
import org.osate.aadl2.VirtualProcessor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;
/**
 * The purpose of this class is to keep track of model elements involved in a particular EM analysis.
 * @author phf
 *
 */
public class AnalysisModel {

	protected ComponentInstance root; // component instance that is the root of the analysis
	protected EList<PropagationPathRecord> propagationPaths = new BasicEList<PropagationPathRecord>(); // component instances (with emv2 propagations) within the root
	protected EList<ComponentInstance> subcomponents = new UniqueEList<ComponentInstance>(); // component instances (with emv2 propagations) within the root
	protected EList<ConnectionInstance> connections = new BasicEList<ConnectionInstance>(); // connection instances whose bond resources have a emv2 propagation
	
	public AnalysisModel(ComponentInstance root) {
		this(root, false);
// printPropagationPaths();
	}
	public boolean impact (PropagationPathEnd src, PropagationPathEnd dst)
	{
		for (PropagationPathRecord ppr : propagationPaths)
		{ 
			if ((ppr.getPathSrc().getComponentInstance() == src.getComponentInstance()) && 
				(ppr.getPathSrc().getErrorPropagation() == src.getErrorPropagation()) &&
				(ppr.getPathDst().getComponentInstance() == dst.getComponentInstance()) && 
				(ppr.getPathDst().getErrorPropagation() == dst.getErrorPropagation()))
			{
				return true;
			}
			
			if ((ppr.getPathSrc().getComponentInstance() == src.getComponentInstance()) && 
				(ppr.getPathSrc().getErrorPropagation() == src.getErrorPropagation()))
			{
				
				ComponentInstance dstCI = ppr.getDstCI();
				List<ErrorPropagation> eps = new ArrayList<ErrorPropagation>();
				ComponentClassifier classifier = dstCI.getComponentClassifier();
				eps.addAll (EMV2Util.getAllOutgoingErrorPropagations(classifier));
				for (ErrorPropagation ep : eps)
				{
						if (impact (new PropagationPathEnd(dstCI,ep), dst))
						{
							
							return true;
						}
					
				}
				
			}
		}
		return false;
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
			if (ci.getCategory() == ComponentCategory.PROCESS|| ci.getCategory() == ComponentCategory.ABSTRACT||ci.getCategory() == ComponentCategory.SYSTEM|| ci.getCategory() == ComponentCategory.PROCESSOR|| ci.getCategory() == ComponentCategory.THREAD||
					ci.getCategory() == ComponentCategory.THREAD_GROUP|| ci.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
			{
				populateBindingPaths(ci);
			}
			populatePropagationPaths(ci);
		}
	}

	public EList<PropagationPathRecord> getPropagationPaths() {
		return propagationPaths;
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
	
	public void printPropagationPaths(){
		EList<PropagationPathRecord> pl = getPropagationPaths();
		for (PropagationPathRecord propagationPath : pl) {
			OsateDebug.osateDebug("PP src "+propagationPath.getSrcCI().getComponentInstancePath()+":"+generateErrorPropTypeSetText(propagationPath.getPathSrc().getErrorPropagation())+" dst "+
					propagationPath.getDstCI().getComponentInstancePath()+":"+generateErrorPropTypeSetText(propagationPath.getPathSrc().getErrorPropagation())+
					(propagationPath.getConnectionInstance()!=null?" conni "+propagationPath.getConnectionInstance().getName():""));
		}
	}
	public String generateErrorPropTypeSetText( ErrorPropagation ep){
		if (ep == null) return "";
		TypeSet ts = ep.getTypeSet();
		return(
				(EMV2Util.getPrintName(ep))+
				(ts!=null?" "+EMV2Util.getPrintName(ts):""));
}
	
	/**
	 * find the propagation paths with endpoints that are the lowest in the containment hierarchy
	 * @param connectionInstance
	 */
	protected void populateConnectionPropagationPaths(ConnectionInstance connectionInstance){
		EList<ConnectionReference> connrefs = connectionInstance.getConnectionReferences();
		if (connrefs.isEmpty()) return;
		ErrorPropagation srcprop = null;
		ComponentInstance srcCI = null;
		ErrorPropagation dstprop = null;
		ComponentInstance dstCI = null;
		ConnectionReference first = connrefs.get(0);
		boolean inonly = (first.getSource().getComponentInstance() == first.getContext());
		ConnectionReference last = connrefs.get(connrefs.size()-1);
		boolean outonly = (last.getDestination().getComponentInstance() == last.getContext());
		EList<ComponentInstance> addlSrcCI = new BasicEList<ComponentInstance>();
		EList<ErrorPropagation> addlSrcEP = new BasicEList<ErrorPropagation>();
		for (ConnectionReference connectionReference : connrefs) {
			ConnectionInstanceEnd src = connectionReference.getSource();
			ConnectionInstanceEnd dst = connectionReference.getDestination();
			if (srcprop == null){ 
				// remember the first src with EP
				ErrorPropagation foundEP = null;
				if( src instanceof FeatureInstance){
					if (inonly){
						foundEP = EMV2Util.getIncomingErrorPropagation((FeatureInstance)src);
					} else	{
						foundEP = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
					}  
				} else if (src instanceof ComponentInstance){
					// a shared model element 
					if( inonly){
						foundEP = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) src);
					} else {
						foundEP = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) src) ;
					}
				}
				if(foundEP != null){
					srcprop = foundEP;
					srcCI = src.getComponentInstance();
				}
			} else {
				// for enclosing components record an outgoing path 
				// this is because we may have an incoming path ending here.
				ErrorPropagation foundEP = null;
				if( src instanceof FeatureInstance){
					if (inonly){
						foundEP = EMV2Util.getIncomingErrorPropagation((FeatureInstance)src);
					} else {
						foundEP = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
					}
				} else if (src instanceof ComponentInstance){
					// a shared model element 
					if( inonly){
						foundEP = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) src);
					} else {
						foundEP = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) src) ;
					}
				}
				if(foundEP != null){
					addlSrcEP.add(foundEP);
					addlSrcCI.add(src.getComponentInstance());
				}

			}
			// we have source. now find destination
			ErrorPropagation founddst=null;
			if( dst instanceof FeatureInstance){
				if( outonly){
					founddst = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)dst);
				} else {
					founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance)dst);
				}
			} else if (dst instanceof ComponentInstance){
				// a shared model element 
				if( outonly){
					founddst = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) dst);
				} else {
					founddst = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) dst) ;
				}
			}
			if (founddst != null){
				// remember the last destination with EP
				dstprop = founddst;
				dstCI = dst.getComponentInstance();
			}

		}
		if (srcprop!= null && dstprop!=null){
			if (!existsPropagationPath(srcCI, srcprop, dstCI, dstprop,connectionInstance)){
				PropagationPathRecord path = new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop,connectionInstance);
				propagationPaths.add(path);
				subcomponents.add(srcCI);
				subcomponents.add(dstCI);
			}
			for (int i = 0; i<addlSrcCI.size();i++) {
				srcCI = addlSrcCI.get(i);
				srcprop = addlSrcEP.get(i);
				if (!existsPropagationPath(srcCI, srcprop, dstCI, dstprop,connectionInstance)){
					PropagationPathRecord path = new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop,connectionInstance);
					propagationPaths.add(path);
					subcomponents.add(srcCI);
				}
			}
		}
		if (connectionInstance.isBidirectional()){
			addlSrcCI.clear();
			addlSrcEP.clear();
			for (int i= connrefs.size()-1; i>= 0 ;i--) {
				ConnectionReference connectionReference = connrefs.get(i);
				ConnectionInstanceEnd dst = connectionReference.getSource();
				ConnectionInstanceEnd src = connectionReference.getDestination();
				if (srcprop == null){ 
					// remember the first src with EP
					ErrorPropagation foundEP = null;
					if( src instanceof FeatureInstance){
						if (inonly){
							foundEP = EMV2Util.getIncomingErrorPropagation((FeatureInstance)src);
						} else	{
							foundEP = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
						}  
					} else if (src instanceof ComponentInstance){
						// a shared model element 
						if( inonly){
							foundEP = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) src);
						} else {
							foundEP = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) src) ;
						}
					}
					if(foundEP != null){
						srcprop = foundEP;
						srcCI = src.getComponentInstance();
					}
				} else {
					// for enclosing components record an outgoing path 
					// this is because we may have an incoming path ending here.
					ErrorPropagation foundEP = null;
					if( src instanceof FeatureInstance){
						if (inonly){
							foundEP = EMV2Util.getIncomingErrorPropagation((FeatureInstance)src);
						} else {
							foundEP = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
						}
					} else if (src instanceof ComponentInstance){
						// a shared model element 
						if( inonly){
							foundEP = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) src);
						} else {
							foundEP = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) src) ;
						}
					}
					if(foundEP != null){
						addlSrcEP.add(foundEP);
						addlSrcCI.add(src.getComponentInstance());
					}

				}
				// we have source. now find destination
				ErrorPropagation founddst=null;
				if( dst instanceof FeatureInstance){
					if( outonly){
						founddst = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)dst);
					} else {
						founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance)dst);
					}
				} else if (dst instanceof ComponentInstance){
					// a shared model element 
					if( outonly){
						founddst = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) dst);
					} else {
						founddst = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) dst) ;
					}
				}
				if (founddst != null){
					// remember the last destination with EP
					dstprop = founddst;
					dstCI = dst.getComponentInstance();
				}

			}
			if (srcprop!= null && dstprop!=null){
				if (!existsPropagationPath(srcCI, srcprop, dstCI, dstprop,connectionInstance)){
					PropagationPathRecord path = new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop,connectionInstance);
					propagationPaths.add(path);
					subcomponents.add(srcCI);
					subcomponents.add(dstCI);
				}
				for (int i = 0; i<addlSrcCI.size();i++) {
					srcCI = addlSrcCI.get(i);
					srcprop = addlSrcEP.get(i);
					if (!existsPropagationPath(srcCI, srcprop, dstCI, dstprop,connectionInstance)){
						PropagationPathRecord path = new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop,connectionInstance);
						propagationPaths.add(path);
						subcomponents.add(srcCI);
					}
				}
			}
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
					populateBindingPropagationPaths(ci, bres,"connection");
				}
			}
			List<ComponentInstance> systems = InstanceModelUtil.getFunctionBinding(ci);
			for (ComponentInstance system : systems)
			{
				populateBindingPropagationPaths(ci, system,"binding");
			}
		} else if (obj instanceof ConnectionInstance){
			// do connection bindings
			List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(obj);
			if (boundresources.isEmpty()){
				boundresources = InstanceModelUtil.connectedByHardware((ConnectionInstance)obj);
			}
			for (ComponentInstance bres : boundresources)
			{
				populateBindingPropagationPaths((ConnectionInstance)obj, bres,"connection");
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
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(), "bindings");
		ErrorPropagation BCdstprop = EMV2Util.findIncomingErrorPropagation(comp.getComponentClassifier(), resourcebindingKind);

		if (BRsrcprop != null && BCdstprop != null ){
//			if(EM2TypeSetUtil.contains(BCdstprop.getTypeSet(), BRsrcprop.getTypeSet()))
//			{
				propagationPaths.add(new PropagationPathRecord(boundResource, BRsrcprop, comp, BCdstprop,null));
				added = true;
//			} else {
//				// error message about mismatch of type set
//			}
		}
		ErrorPropagation BCsrcprop = EMV2Util.findOutgoingErrorPropagation(comp.getComponentClassifier(),resourcebindingKind );
		 ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(), "bindings");
		 if (BCsrcprop != null && BRdstprop!=null){
//			 if (EM2TypeSetUtil.contains(BCsrcprop.getTypeSet(), BRdstprop.getTypeSet()))
//			 {
				 propagationPaths.add(new PropagationPathRecord(comp, BCsrcprop, boundResource, BRdstprop,null));
				 added = true;
//			 } else {
//				 // error message about mismatch of type set
//			 }
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
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(), bindingKind);

		if (BRsrcprop != null  )
		{
			propagationPaths.add(new PropagationPathRecord(boundResource, BRsrcprop,conn));
			added = true;
		} else {
			// error message about mismatch of type set
		}
		 ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(), bindingKind);
		if (BRdstprop != null)
		{
			propagationPaths.add(new PropagationPathRecord(conn, boundResource, BRdstprop));
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
	 * populate propagation paths declared in this component instance
	 * the paths are between subcomponents
	 * @param ci ComponentInstance
	 */
	protected void populatePropagationPaths(InstanceObject obj){
		if (obj instanceof ComponentInstance){
			ComponentInstance ci = (ComponentInstance)obj;
			Collection<PropagationPath> pplist = EMV2Util.getAllPropagationPaths(ci.getComponentClassifier());
			for (PropagationPath propagationPath : pplist) {
				addPropagationPath(ci,propagationPath);
			}
		}
	}
	
	protected void addPropagationPath(ComponentInstance ci,PropagationPath pp){
		ErrorPropagation srcEP = null;
		ErrorPropagation dstEP = null;
		ComponentInstance srcCI = getComponentInstance(ci, pp.getSource().getSubcomponents());
		ComponentInstance dstCI = getComponentInstance(ci, pp.getTarget().getSubcomponents());
		if (srcCI != null){
			srcEP = EMV2Util.findErrorPropagation(srcCI.getComponentClassifier(), pp.getSource().getPropagationPoint().getName(), DirectionType.OUT);
		}
		if (dstCI != null){
			dstEP = EMV2Util.findErrorPropagation(srcCI.getComponentClassifier(), pp.getTarget().getPropagationPoint().getName(), DirectionType.IN);
		}
		if (srcEP != null && dstEP != null){
			propagationPaths.add(new PropagationPathRecord(srcCI, srcEP, dstCI, dstEP));
			subcomponents.add(srcCI);
			subcomponents.add(dstCI);
		}
	}
	
	protected ComponentInstance getComponentInstance (ComponentInstance ci, EList<SubcomponentElement> sublist){
		ComponentInstance result = ci;
		for (SubcomponentElement subcomponentElement : sublist) {
			result = result.findSubcomponentInstance(subcomponentElement.getSubcomponent());
			if (result == null) return null;
		}
		return result;
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
			propagationPaths.add(new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop,connectionInstance));
			subcomponents.add(srcCI);
			subcomponents.add(dstCI);
		}
	}
	
	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ComponentInstance ci, ErrorPropagation outEP){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == outEP){
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}
	
	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ConnectionInstance ci){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getConnectionInstance() == ci ){
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}
	
	/**
	 * return all propagation paths out of the outgoing error propagation
	 * we assume that any type token to be propagated meets the ep type constraint
	 * @param ci
	 * @param outEP
	 * @return
	 */
	public EList<PropagationPathRecord> getAllPropagationPaths(ComponentInstance ci, ErrorPropagation outEP){
		EList<PropagationPathRecord> result= new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getComponentInstance() == ci ){
				if( src.getErrorPropagation() == outEP){
					result.add(propagationPathRecord);
				} else {
					// check if one EP is in an ancestor feature instance
					FeatureInstance outepfi = EMV2Util.findFeatureInstance(outEP, ci);
					FeatureInstance srcfi = EMV2Util.findFeatureInstance(src.getErrorPropagation(), ci);
					if (Aadl2InstanceUtil.containedIn(outepfi, srcfi)||Aadl2InstanceUtil.containedIn(srcfi,outepfi)){
						result.add(propagationPathRecord);
					}
				}
			}
		}
		return result;
	}
	
	public EList<PropagationPathRecord> getAllPropagationPaths(ConnectionInstance ci){
		EList<PropagationPathRecord> result= new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getConnectionInstance() == ci ){
				result.add(propagationPathRecord);
			}
		}
		return result;
	}
	
	public EList<PropagationPathEnd> getAllPropagationSourceEnds(ComponentInstance ci, ErrorPropagation inEP){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd dst = propagationPathRecord.getPathDst();
			if(dst.getComponentInstance() == ci && dst.getErrorPropagation() == inEP){
				result.add(propagationPathRecord.getPathSrc());
			}
		}
		return result;
	}
	
	public EList<PropagationPathEnd> getAllPropagationSourceEnds(ConnectionInstance ci){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd dst = propagationPathRecord.getPathDst();
			if(dst.getConnectionInstance() == ci ){
				result.add(propagationPathRecord.getPathSrc());
			}
		}
		return result;
	}
	
	public EList<PropagationPathRecord> getAllReversePropagationPaths(ComponentInstance ci, ErrorPropagation inEP){
		EList<PropagationPathRecord> result= new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == inEP){
				result.add(propagationPathRecord);
			}
		}
		return result;
	}

	public EList<PropagationPathRecord> getAllReversePropagationPaths(ConnectionInstance ci){
		EList<PropagationPathRecord> result= new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
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
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
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
	
	public boolean existsPropagationPath(
			ComponentInstance srcCI, ErrorPropagation srcEP,
			ComponentInstance dstCI, ErrorPropagation dstEP, ConnectionInstance conni) {
		for (PropagationPathRecord pp : propagationPaths){
			if (pp.getConnectionInstance() == conni
					&& pp.getSrcCI()==srcCI && pp.getDstCI() == dstCI
					&& pp.getPathSrc().getErrorPropagation() == srcEP
					&& pp.getPathDst().getErrorPropagation() == dstEP) return true;
		}
		return false;
	}

	

}
