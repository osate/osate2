package org.osate.aadl2.errormodel.PropagationGraph.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.VirtualBus;
import org.osate.aadl2.VirtualProcessor;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphFactory;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPath;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class Util {

	public static PropagationGraph generatePropagationGraph(ComponentInstance root, boolean completeConnectionsOnly) {
		PropagationGraph pg = PropagationGraphFactory.eINSTANCE.createPropagationGraph();
		pg.setRoot(root);
		pg.setName(root.getName());
		List<ConnectionInstance> cilist = EcoreUtil2.getAllContentsOfType(root, ConnectionInstance.class);
		for (ConnectionInstance connectionInstance : cilist) {
			if (!(completeConnectionsOnly && !connectionInstance.isComplete())) {
				populateConnectionPropagationPaths(pg, connectionInstance);
				populateBindingPaths(pg, connectionInstance);

			}
		}
		String pgname = root.getName();
		URI pgURI = EcoreUtil.getURI(root).trimFragment().trimSegments(1).appendSegment("reports")
				.appendSegment("propagationgraph").appendSegment(pgname + ".propagationgraph");
		AadlUtil.makeSureFoldersExist(new Path(pgURI.toPlatformString(true)));
		OsateResourceUtil.saveEMFModel(pg, pgURI, root);
		return pg;
	}

	/**
	 * find the propagation paths between component instances with error propagations.
	 * This method handles different levels.
	 * It also handles both complete and incomplete connection instances (the latter are out only and in only connections
	 * @param connectionInstance
	 * @param level LEAF (lowest), TOP (highest), ALL (all combinations)
	 */
	protected static void populateConnectionPropagationPaths(PropagationGraph pg,
			ConnectionInstance connectionInstance) {
		SystemOperationMode som = connectionInstance.getSystemInstance().getCurrentSystemOperationMode();
		if (!isActive(connectionInstance, som)) {
			return;
		}
		EList<ConnectionReference> connrefs = connectionInstance.getConnectionReferences();
		if (connrefs.isEmpty()) {
			return;
		}
		ErrorPropagation srcprop = null;
		ComponentInstance srcCI = null;
		ErrorPropagation dstprop = null;
		ComponentInstance dstCI = null;
		ConnectionReference first = connrefs.get(0);
		// inonly is an incomplete connection instance that is only incoming,
		// i.e., we only have incoming propagations.
		boolean inonly = (first.getSource().getComponentInstance() == first.getContext());
		ConnectionReference last = connrefs.get(connrefs.size() - 1);
		// outonly is an incomplete connection instance that is only outgoing,
		// i.e., we only have outgoing propagations.
		boolean outonly = (last.getDestination().getComponentInstance() == last.getContext());
		// list of additional source error propagations (i.e., those of
		// enclosing components.
		List<ComponentInstance> addlSrcCI = new ArrayList<ComponentInstance>();
		List<ErrorPropagation> addlSrcEP = new ArrayList<ErrorPropagation>();
		List<ComponentInstance> addlDstCI = new ArrayList<ComponentInstance>();
		List<ErrorPropagation> addlDstEP = new ArrayList<ErrorPropagation>();
		for (ConnectionReference connectionReference : connrefs) {
			if (!isActive(connectionReference, som)) {
				continue;
			}
			ConnectionInstanceEnd src = connectionReference.getSource();
			ConnectionInstanceEnd dst = connectionReference.getDestination();
			// remember the first (lowest in the hierarchy) src component
			// instance with Error propagation
			// srcprop is null until we found the source error propagation
			ErrorPropagation foundEP = null;
			if (src instanceof FeatureInstance) {
				if (inonly) {
					foundEP = EMV2Util.getIncomingErrorPropagation((FeatureInstance) src);
				} else {
					foundEP = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) src);
				}
			} else if (src instanceof ComponentInstance) {
				// deal with an access connection pointing to a component
				// instance instead of a feature instance
				if (inonly) {
					foundEP = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) src);
				} else {
					foundEP = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) src);
				}
			}
			if (foundEP != null) {
				if (srcprop == null) {
					srcprop = foundEP;
					srcCI = src.getComponentInstance();
				}
			}
			// We look for destination error propagations
			// it should be incoming except when outonly
			ErrorPropagation founddst = null;
			if (dst instanceof FeatureInstance) {
				if (outonly) {
					founddst = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) dst);
				} else {
					founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance) dst);
				}
			} else if (dst instanceof ComponentInstance) {
				// a shared model element
				if (outonly) {
					founddst = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) dst);
				} else {
					founddst = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) dst);
				}
			}
			if (founddst != null) {
				dstprop = founddst;
				dstCI = dst.getComponentInstance();
			}
		}
		// done with all connection references
		// record the results
		if (srcprop != null && dstprop != null) {
			// we found a source and destination. Add it if not already
			// there.
			addPropagationpathRecord(pg, srcCI, srcprop, dstCI, dstprop, connectionInstance);
		} else {
			if (srcprop != null && addlSrcEP.size() > 1) {
				dstprop = addlSrcEP.get(addlSrcEP.size() - 1);
				dstCI = addlSrcCI.get(addlSrcCI.size() - 1);
			}
		}
		if (connectionInstance.isBidirectional()) {
			// now work in the inverse direction since the conneciton is
			// bi-directional
			srcprop = null;
			srcCI = null;
			dstprop = null;
			dstCI = null;
			addlSrcCI.clear();
			addlSrcEP.clear();
			addlDstCI.clear();
			addlDstEP.clear();
			for (int i = connrefs.size() - 1; i >= 0; i--) {
				ConnectionReference connectionReference = connrefs.get(i);
				if (!isActive(connectionReference, som)) {
					continue;
				}
				ConnectionInstanceEnd dst = connectionReference.getSource();
				ConnectionInstanceEnd src = connectionReference.getDestination();
				ErrorPropagation foundEP = null;
				if (src instanceof FeatureInstance) {
					if (inonly) {
						foundEP = EMV2Util.getIncomingErrorPropagation((FeatureInstance) src);
					} else {
						foundEP = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) src);
					}
				} else if (src instanceof ComponentInstance) {
					// deal with an access connection pointing to a component
					// instance instead of a feature instance
					if (inonly) {
						foundEP = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) src);
					} else {
						foundEP = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) src);
					}
				}

				if (foundEP != null) {
					if (srcprop == null) {
						srcprop = foundEP;
						srcCI = src.getComponentInstance();
					}
				}
				// We look for destination error propagations
				// it should be incoming except when outonly
				ErrorPropagation founddst = null;
				if (dst instanceof FeatureInstance) {
					if (outonly) {
						founddst = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) dst);
					} else {
						founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance) dst);
					}
				} else if (dst instanceof ComponentInstance) {
					// a shared model element
					if (outonly) {
						founddst = EMV2Util.getOutgoingAccessErrorPropagation((ComponentInstance) dst);
					} else {
						founddst = EMV2Util.getIncomingAccessErrorPropagation((ComponentInstance) dst);
					}
				}
				if (founddst != null) {
					dstprop = founddst;
					dstCI = dst.getComponentInstance();
				}
			}
			// done with all connection references
			// record the results
			if (srcprop != null && dstprop != null) {
				// we found a source and destination. Add it if not already
				// there.
				addPropagationpathRecord(pg, srcCI, srcprop, dstCI, dstprop, connectionInstance);
			} else {
				if (srcprop != null && addlSrcEP.size() > 1) {
					dstprop = addlSrcEP.get(addlSrcEP.size() - 1);
					dstCI = addlSrcCI.get(addlSrcCI.size() - 1);
				}
			}
		}
	}

	private static boolean isActive(ConnectionInstance ci, SystemOperationMode som) {
		if (som != null) {
			List<SystemOperationMode> inSOMs = ci.getExistsInModes();
			if (inSOMs != null && !inSOMs.contains(som)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isActive(ConnectionReference cr, SystemOperationMode som) {
		if (som != null) {
			ComponentInstance ci = cr.getContext();
			ConnectionInstanceEnd src = cr.getSource();
			ConnectionInstanceEnd dst = cr.getDestination();
			return isActive(ci, som) && isActive(src, som) && isActive(dst, som);
		}
		return true;
	}

	private static boolean isActive(ConnectionInstanceEnd end, SystemOperationMode som) {
		if (som != null) {
			ComponentInstance ci;
			if (end instanceof ComponentInstance) {
				ci = (ComponentInstance) end;
			} else if (end instanceof FeatureInstance) {
				FeatureInstance fi = (FeatureInstance) end;
				ci = fi.getComponentInstance();
			} else {
				return false;
			}
			return isActive(ci, som);
		}
		return true;
	}

	private static boolean isActive(ComponentInstance ci, SystemOperationMode som) {
		List<SystemOperationMode> inSOMs = ci.getExistsInModes();
		return inSOMs == null || inSOMs.contains(som);
	}

	/**
	 * add a propagation path record only if it does not exist already.
	 * It also updates the list of "components" i.e., component instances involved in propagation paths
	 * @param srcCI
	 * @param srcprop
	 * @param dstCI
	 * @param dstprop
	 * @param connectionInstance
	 */
	private static void addPropagationpathRecord(PropagationGraph pg, ComponentInstance srcCI, ErrorPropagation srcprop,
			ComponentInstance dstCI, ErrorPropagation dstprop, ConnectionInstance connectionInstance) {
		if (!existsPropagationPath(pg, srcCI, srcprop, dstCI, dstprop, connectionInstance)) {
			PropagationPath path = PropagationGraphFactory.eINSTANCE.createPropagationPath();
			PropagationPathEnd srcPE = PropagationGraphFactory.eINSTANCE.createPropagationPathEnd();
			PropagationPathEnd dstPE = PropagationGraphFactory.eINSTANCE.createPropagationPathEnd();
			srcPE.setComponentInstance(srcCI);
			srcPE.setErrorPropagation(srcprop);
			dstPE.setComponentInstance(dstCI);
			dstPE.setErrorPropagation(dstprop);
			path.setPathSrc(srcPE);
			path.setPathDst(dstPE);
			// new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
			pg.getPropagationPaths().add(path);
			pg.getComponents().add(srcCI);
			pg.getComponents().add(dstCI);
			pg.getConnections().add(connectionInstance);
		}
	}

	private static void addPropagationpathRecord(PropagationGraph pg, ConnectionInstance srcConni,
			ComponentInstance dstCI, ErrorPropagation dstprop) {
		PropagationPath path = PropagationGraphFactory.eINSTANCE.createPropagationPath();
		PropagationPathEnd srcPE = PropagationGraphFactory.eINSTANCE.createPropagationPathEnd();
		PropagationPathEnd dstPE = PropagationGraphFactory.eINSTANCE.createPropagationPathEnd();
		srcPE.setConnectionInstance(srcConni);
		srcPE.setErrorPropagation(null);
		dstPE.setComponentInstance(dstCI);
		dstPE.setErrorPropagation(dstprop);
		path.setPathSrc(srcPE);
		path.setPathDst(dstPE);
		pg.getPropagationPaths().add(path);
		pg.getComponents().add(dstCI);
	}

	private static void addPropagationpathRecord(PropagationGraph pg, ComponentInstance srcCI, ErrorPropagation srcprop,
			ConnectionInstance dstConni) {
		PropagationPath path = PropagationGraphFactory.eINSTANCE.createPropagationPath();
		PropagationPathEnd srcPE = PropagationGraphFactory.eINSTANCE.createPropagationPathEnd();
		PropagationPathEnd dstPE = PropagationGraphFactory.eINSTANCE.createPropagationPathEnd();
		srcPE.setComponentInstance(srcCI);
		srcPE.setErrorPropagation(srcprop);
		dstPE.setConnectionInstance(dstConni);
		dstPE.setErrorPropagation(null);
		path.setPathSrc(srcPE);
		path.setPathDst(dstPE);
		// new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
		pg.getPropagationPaths().add(path);
		pg.getComponents().add(srcCI);
	}

	private static boolean existsPropagationPath(PropagationGraph pg, ComponentInstance srcCI, ErrorPropagation srcEP,
			ComponentInstance dstCI, ErrorPropagation dstEP, ConnectionInstance conni) {
		for (PropagationPath pp : pg.getPropagationPaths()) {
			if (pp.getConnection() == conni && pp.getPathSrc() == srcCI && pp.getPathDst() == dstCI
					&& pp.getPathSrc().getErrorPropagation() == srcEP
					&& pp.getPathDst().getErrorPropagation() == dstEP) {
				return true;
			}
		}
		return false;
	}

	/**
	 * populate direct bindings from the specified component to its resources
	 *
	 * @param ci
	 */
	protected static void populateBindingPaths(PropagationGraph pg, InstanceObject obj) {
		if (obj instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) obj;
			List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding(ci);
			for (ComponentInstance cpu : cpus) {
				populateBindingPropagationPaths(pg, ci, cpu, "processor");
			}
			if (!(ci instanceof VirtualProcessor)) {
				// do memory bindings
				List<ComponentInstance> mems = InstanceModelUtil.getMemoryBinding(ci);
				for (ComponentInstance mem : mems) {
					populateBindingPropagationPaths(pg, ci, mem, "memory");
				}
			}
			if (ci instanceof VirtualBus) {
				// do connection bindings
				List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(ci);
				for (ComponentInstance bres : boundresources) {
					populateBindingPropagationPaths(pg, ci, bres, "connection");
				}
			}
			List<ComponentInstance> systems = InstanceModelUtil.getFunctionBinding(ci);
			for (ComponentInstance system : systems) {
				populateBindingPropagationPaths(pg, ci, system, "binding");
			}
		} else if (obj instanceof ConnectionInstance) {
			// do connection bindings
			List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(obj);
			if (boundresources.isEmpty()) {
				boundresources = InstanceModelUtil.deriveBoundBuses((ConnectionInstance) obj);
			}
			for (ComponentInstance bres : boundresources) {
				populateBindingPropagationPaths(pg, (ConnectionInstance) obj, bres, "connection");
			}
		}
	}

	/**
	 * Add a binding as propagation path.
	 * The first argument is the component bound to a resource (e.g. a process) and the
	 * boundResource argument the associated resources (e.g. a processor).
	 * We will add the propagation path in each direction if declared in the EMV2 annex.
	 * @param comp
	 * @param boundResource
	 */
	private static void populateBindingPropagationPaths(PropagationGraph pg, ComponentInstance comp,
			ComponentInstance boundResource, String resourcebindingKind) {
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");
		ErrorPropagation BCdstprop = EMV2Util.findIncomingErrorPropagation(comp.getComponentClassifier(),
				resourcebindingKind);

		if (BRsrcprop != null && BCdstprop != null) {
			addPropagationpathRecord(pg, boundResource, BRsrcprop, comp, BCdstprop, null);
		}
		ErrorPropagation BCsrcprop = EMV2Util.findOutgoingErrorPropagation(comp.getComponentClassifier(),
				resourcebindingKind);
		ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");
		if (BCsrcprop != null && BRdstprop != null) {
			addPropagationpathRecord(pg, comp, BCsrcprop, boundResource, BRdstprop, null);
		}
	}

	/**
	 * This is made to support the binding between connection and components.
	 * Here, the first argument is the connection bound to a resource and the
	 * boundResource argument the associated resources (e.g. a bus).
	 *
	 * @param conn
	 * @param boundResource
	 */
	private static void populateBindingPropagationPaths(PropagationGraph pg, ConnectionInstance conn,
			ComponentInstance boundResource, String bindingKind) {
		boolean added = false;
		// source prop kind determined by destination and vice versa (BR = bound
		// resource, BC bound component
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");

		if (BRsrcprop != null) {
			addPropagationpathRecord(pg, boundResource, BRsrcprop, conn);
			added = true;
		}
		ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");
		if (BRdstprop != null) {
			addPropagationpathRecord(pg, conn, boundResource, BRdstprop);
			added = true;
		}
		if (added) {
			pg.getConnections().add(conn);
			pg.getComponents().add(boundResource);
		}
	}

	/**
	 * return all propagation paths out of the outgoing error propagation we
	 * assume that any type token to be propagated meets the ep type constraint
	 *
	 * @param ci
	 * @param outEP
	 * @return
	 */
	public static EList<PropagationPath> getAllPropagationPaths(PropagationGraph pg, ComponentInstance ci,
			ErrorPropagation outEP) {
		EList<PropagationPath> result = new BasicEList<PropagationPath>();
		for (PropagationPath propagationPath : pg.getPropagationPaths()) {
			PropagationPathEnd src = propagationPath.getPathSrc();
			if (src.getComponentInstance() == ci) {
				if (src.getErrorPropagation() == outEP) {
					result.add(propagationPath);
				} else {
					// check if one EP is in an ancestor feature instance
					FeatureInstance outepfi = EMV2Util.findFeatureInstance(outEP, ci);
					FeatureInstance srcfi = EMV2Util.findFeatureInstance(src.getErrorPropagation(), ci);
					if (Aadl2InstanceUtil.containedIn(outepfi, srcfi)
							|| Aadl2InstanceUtil.containedIn(srcfi, outepfi)) {
						result.add(propagationPath);
					}
				}
			}
		}
		return result;
	}

	public static EList<PropagationPath> getAllPropagationPaths(PropagationGraph pg, ConnectionInstance ci) {
		EList<PropagationPath> result = new BasicEList<PropagationPath>();
		for (PropagationPath propagationPath : pg.getPropagationPaths()) {
			PropagationPathEnd src = propagationPath.getPathSrc();
			if (src.getConnectionInstance() == ci) {
				result.add(propagationPath);
			}
		}
		return result;
	}

	public static EList<PropagationPath> getAllReversePropagationPaths(PropagationGraph pg, ComponentInstance ci,
			ErrorPropagation inEP) {
		EList<PropagationPath> result = new BasicEList<PropagationPath>();
		for (PropagationPath propagationPath : pg.getPropagationPaths()) {
			PropagationPathEnd src = propagationPath.getPathDst();
			if (src.getComponentInstance() == ci && src.getErrorPropagation() == inEP) {
				result.add(propagationPath);
			}
		}
		return result;
	}

	public static EList<PropagationPath> getAllReversePropagationPaths(PropagationGraph pg, ConnectionInstance ci) {
		EList<PropagationPath> result = new BasicEList<PropagationPath>();
		for (PropagationPath propagationPath : pg.getPropagationPaths()) {
			PropagationPathEnd src = propagationPath.getPathDst();
			if (src.getConnectionInstance() == ci) {
				result.add(propagationPath);
			}
		}
		return result;
	}

	public static EList<PropagationPathEnd> getAllPropagationDestinationEnds(PropagationGraph pg, ComponentInstance ci,
			ErrorPropagation outEP) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : pg.getPropagationPaths()) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if (src.getComponentInstance() == ci && src.getErrorPropagation() == outEP) {
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}

	public static EList<PropagationPathEnd> getAllPropagationDestinationEnds(PropagationGraph pg,
			ConnectionInstance ci) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : pg.getPropagationPaths()) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if (src.getConnectionInstance() == ci) {
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}

	public static EList<PropagationPathEnd> getAllPropagationSourceEnds(PropagationGraph pg, ComponentInstance ci,
			ErrorPropagation inEP) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : pg.getPropagationPaths()) {
			PropagationPathEnd dst = propagationPathRecord.getPathDst();
			if (dst.getComponentInstance() == ci && dst.getErrorPropagation() == inEP) {
				result.add(propagationPathRecord.getPathSrc());
			}
		}
		return result;
	}

	public static EList<PropagationPathEnd> getAllPropagationSourceEnds(PropagationGraph pg, ConnectionInstance ci) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPath propagationPathRecord : pg.getPropagationPaths()) {
			PropagationPathEnd dst = propagationPathRecord.getPathDst();
			if (dst.getConnectionInstance() == ci) {
				result.add(propagationPathRecord.getPathSrc());
			}
		}
		return result;
	}

}
