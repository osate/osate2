package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureReference;

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
	protected EList<PropagationPath> propagationPaths = new BasicEList<PropagationPath>(); // component instances (with emv2 propagations) within the root
	protected EList<ComponentInstance> subcomponents = new UniqueEList<ComponentInstance>(); // component instances (with emv2 propagations) within the root
	
	public AnalysisModel(ComponentInstance root) {
		this.root = root;
		List<ConnectionInstance> cilist = EcoreUtil2.getAllContentsOfType(root, ConnectionInstance.class);
		for (ConnectionInstance connectionInstance : cilist) {
			populateConnectionPropagationPaths(connectionInstance);
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
		propagationPaths.add(new PropagationPath(srcCI, srcprop, dstCI, dstprop, connectionInstance));
		subcomponents.add(srcCI);
		subcomponents.add(dstCI);
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
		propagationPaths.add(new PropagationPath(srcCI, srcprop, dstCI, dstprop, connectionInstance));
		subcomponents.add(srcCI);
		subcomponents.add(dstCI);
	}
	
	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ComponentInstance ci, ErrorPropagation outEP){
		EList<PropagationPathEnd> result= new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if(src.getComponentInstance() == ci && src.getErrorPropagation() == outEP){
				result.add(propagationPathRecord.getPathDst());
			}
			if (propagationPathRecord.getConni().isBidirectional()){
				src = propagationPathRecord.getPathDst();
				if(src.getComponentInstance() == ci && src.getErrorPropagation() == outEP){
					result.add(propagationPathRecord.getPathSrc());
				}
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
			if (propagationPathRecord.getConni().isBidirectional()){
				src = propagationPathRecord.getPathDst();
				if(src.getComponentInstance() == ci && src.getErrorPropagation() == outEP){
					result.add(propagationPathRecord);
				}
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
			if (propagationPathRecord.getConni().isBidirectional()){
				src = propagationPathRecord.getPathSrc();
				if(src.getComponentInstance() == ci && src.getErrorPropagation() == inEP){
					result.add(propagationPathRecord.getPathDst());
				}
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
			if (propagationPathRecord.getConni().isBidirectional()){
				src = propagationPathRecord.getPathSrc();
				if(src.getComponentInstance() == ci && src.getErrorPropagation() == inEP){
					result.add(propagationPathRecord);
				}
			}
		}
		return result;
	}
	
	
	/**
	 * return all feature (or for access component) instances that are the connection destination of the given feature instance
	 * The soruce and destinations are assumed to be components with error models
	 * @param fi
	 * @return list of ConnectionInstanceEnd
	 */
	public EList<ConnectionInstanceEnd> getAllConnectionDestinations(ConnectionInstanceEnd fi){
		EList<ConnectionInstanceEnd> result= new BasicEList<ConnectionInstanceEnd>();
		ComponentInstance ci = fi.getContainingComponentInstance();
		NamedElement f = null;
		if (fi instanceof FeatureInstance){
		f = ((FeatureInstance)fi).getFeature();
		} else {
			f = ((ComponentInstance)f).getSubcomponent();
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
			if (propagationPathRecord.getConni().isBidirectional()){
				src = propagationPathRecord.getPathDst();
				ep = src.getErrorPropagation();
				srcf = EMV2Util.getFeature(ep);
				if (srcf != null && srcf == f){
					PropagationPathEnd dst = propagationPathRecord.pathSrc;
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
		}
		return result;
	}
	

}
