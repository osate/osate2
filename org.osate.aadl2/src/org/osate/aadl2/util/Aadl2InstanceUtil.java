package org.osate.aadl2.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Feature;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

public class Aadl2InstanceUtil {
	
	/**
	 * get outgoing connection instances from the component instance or any contained component instance
	 * @param ci component instance
	 * @return list of connection instances
	 */
	public static EList<ConnectionInstance> getOutgoingConnections(ComponentInstance ci){
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		SystemInstance si = ci.getSystemInstance();
		EList<ConnectionInstance> connilist = si.getConnectionInstances();
		for (ConnectionInstance connectionInstance : connilist) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if (containedIn(src,ci)&&!containedIn(dst, ci)){
				result.add(connectionInstance);
			}
		}
		return result;
	}
	/**
	 * get incoming connection instances from the component instance or any contained component instance
	 * @param ci component instance
	 * @return list of connection instances
	 */
	public static EList<ConnectionInstance> getIncomingConnections(ComponentInstance ci){
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		SystemInstance si = ci.getSystemInstance();
		EList<ConnectionInstance> connilist = si.getConnectionInstances();
		for (ConnectionInstance connectionInstance : connilist) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if (!containedIn(src,ci)&&containedIn(dst, ci)){
				result.add(connectionInstance);
			}
		}
		return result;
	}
	/**
	 * find outgoing connection that goes through the feature of the specified component instance
	 * @param ci Component instance
	 * @param fi Feature instance
	 * @return list of connection instances going through the feature
	 */
	public static EList<ConnectionInstance> getOutgoingConnection(ComponentInstance ci,FeatureInstance fi){
		Feature f = fi.getFeature();
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		SystemInstance si = ci.getSystemInstance();
		EList<ConnectionInstance> connilist = si.getConnectionInstances();
		for (ConnectionInstance connectionInstance : connilist) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ComponentInstance srcci = src.getContainingComponentInstance();
			if (containedIn(srcci,ci)){
				EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
				for (ConnectionReference connectionReference : connreflist) {
					ComponentInstance pci = connectionReference.getContext();
					Connection conn = connectionReference.getConnection();
					ConnectionEnd ce = conn.getAllSource();
					if (pci == ci.getContainingComponentInstance() && ce == f)
						result.add(connectionInstance);
				}
			}
		}
		return result;
	}
	/**
	 * find incoming connection that goes through the feature of the specified component instance
	 * @param ci Component instance
	 * @param fi Feature instance
	 * @return list of connection instances going through the feature
	 */
	public static EList<ConnectionInstance> getIncomingConnection(ComponentInstance ci,FeatureInstance fi){
		Feature f = fi.getFeature();
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		SystemInstance si = ci.getSystemInstance();
		EList<ConnectionInstance> connilist = si.getConnectionInstances();
		for (ConnectionInstance connectionInstance : connilist) {
			ConnectionInstanceEnd dest = connectionInstance.getDestination();
			ComponentInstance destci = dest.getContainingComponentInstance();
			if (containedIn(destci,ci)){
				EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
				for (ConnectionReference connectionReference : connreflist) {
					ComponentInstance pci = connectionReference.getContext();
					Connection conn = connectionReference.getConnection();
					ConnectionEnd ce = conn.getAllSource();
					if (pci == ci.getContainingComponentInstance() && ce == f)
						result.add(connectionInstance);
				}
			}
		}
		return result;
	}
	
	public static boolean isOutgoingConnection(ConnectionInstance connectionInstance,ComponentInstance ci){
			ConnectionInstanceEnd src = connectionInstance.getSource();
			if (containedIn(src,ci)){
				return true;
			}
		return false;
	}
	
	
	public static boolean isIncomingConnection(ConnectionInstance connectionInstance,ComponentInstance ci){
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if (containedIn(dst,ci)){
				return true;
			}
		return false;
	}
	
	
	public static boolean containedIn(InstanceObject element, InstanceObject parent){
		while (element != null){
			if (element == parent) return true;
			element = (InstanceObject)element.getOwner();
		}
		return false;
	}
	
	public static AnnexSubclause getAnnexSubclause (ComponentInstance ci, String annexName){
		ComponentClassifier cl = ci.getComponentClassifier();
		EList<AnnexSubclause> asclist = cl.getAllAnnexSubclauses();
		for (AnnexSubclause annexSubclause : asclist) {
			if (annexSubclause.getName().equalsIgnoreCase(annexName)){
				return annexSubclause;
			}
		}
		return null;
	}
	
	/**
	 * Find the source endpoint of the connection in the specified component instance
	 * the endpoint can be a feature instance or a component instance
	 * The connection instance may go inside the component instance
	 * @param ci context component instance
	 * @param conni connection instance
	 * @return InstanceObject
	 */
	public static InstanceObject getSrcEndPointInstance(ComponentInstance ci, ConnectionInstance conni){
		for (ConnectionReference connRef : conni.getConnectionReferences()) {
			if (connRef.getContext() == ci){
				Connection conn = connRef.getConnection();
				final ConnectionEnd srcF = conn.getAllSource();
				final Context srcCtxt = conn.getAllSourceContext();
				final InstanceObject srcInstance = conni.getInstantiatedEndPoint(connRef.getContext(), srcF, srcCtxt);
				return srcInstance;
			}
		}
		return null;
	}

	/**
	 * Find the destination endpoint of the connection in the specified component instance
	 * the endpoint can be a feature instance or a component instance
	 * The connection instance may go inside the component instance
	 * @param ci context component instance
	 * @param conni connection instance
	 * @return InstanceObject
	 */
	public static InstanceObject getDestEndPointInstance(ComponentInstance ci, ConnectionInstance conni){
		for (ConnectionReference connRef : conni.getConnectionReferences()) {
			if (connRef.getContext() == ci){
				Connection conn = connRef.getConnection();
				final ConnectionEnd dstF = conn.getAllDestination();
				final Context dstCtxt = conn.getAllDestinationContext();
				final InstanceObject dstInstance = conni.getInstantiatedEndPoint(connRef.getContext(), dstF, dstCtxt);
				return dstInstance;
			}
		}
		return null;
	}

}
