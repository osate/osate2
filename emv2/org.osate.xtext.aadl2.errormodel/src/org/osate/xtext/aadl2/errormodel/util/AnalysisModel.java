package org.osate.xtext.aadl2.errormodel.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DirectionType;
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
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * The purpose of this class is to keep track of model elements involved in a
 * particular EM analysis.
 *
 * @author phf
 *
 * @deprecated use {@link org.osate.aadl2.errormodel.propagationgraph.PropgationGraph} instead
 *
 */

@Deprecated
public class AnalysisModel {

	protected ComponentInstance root; // component instance that is the root of
	// the analysis
	// propagation paths
	protected Collection<PropagationPathRecord> propagationPaths = new ArrayList<PropagationPathRecord>();
	// component instances that are involved in propagation paths
	protected Collection<ComponentInstance> subcomponents = new LinkedHashSet<ComponentInstance>();
	// connection instances as source or taraget of a propagation path
	protected Collection<ConnectionInstance> connections = new ArrayList<ConnectionInstance>();

	public static AnalysisModel createAnalysisModel(ComponentInstance root) {
		AnalysisModel am = new AnalysisModel(root);
		return am;
	}

	public AnalysisModel(ComponentInstance root) {
		this(root, PropagationPathLevel.LEAF, true);
	}

	public AnalysisModel(ComponentInstance root, boolean complete) {
		this(root, PropagationPathLevel.LEAF, complete);
	}

	/**
	 * build up a propagation path graph of propagations within a system as well
	 * as external ones.
	 *
	 * @param root
	 *            ComponentInstance that is the root of the system
	 * @param level
	 *            LEAF: propagations between leaf (lowest level)components with
	 *            error propagations only TOP: propagations between highest
	 *            level components with error propagations only ALL: between all
	 *            leaf and enclosing components at the source and at the
	 *            destination
	 * @param completeConnectionsOnly
	 *            Only for connections within a system. Otherwise outgoing only
	 *            and incoming only connections will be included.
	 */
	public AnalysisModel(ComponentInstance root, PropagationPathLevel level, boolean completeConnectionsOnly) {
		this.root = root;
		List<ConnectionInstance> cilist = EcoreUtil2.getAllContentsOfType(root, ConnectionInstance.class);
		for (ConnectionInstance connectionInstance : cilist) {
			if (!(completeConnectionsOnly && !connectionInstance.isComplete())) {
				populateConnectionPropagationPaths(connectionInstance, level);
				populateBindingPaths(connectionInstance);

			}
		}
		/**
		 * We also browse the list of all component instances and add user declared propagation paths.
		 * We also add binding related propagation paths.
		 */
		List<ComponentInstance> complist = EcoreUtil2.getAllContentsOfType(root, ComponentInstance.class);
		for (ComponentInstance ci : complist) {
			if (!EMV2Util.hasEMV2Subclause(ci)) {
				continue;
			}
			populateUserDeclaredPropagationPaths(ci);
//			if (ci.getCategory() == ComponentCategory.PROCESS || ci.getCategory() == ComponentCategory.ABSTRACT
//					|| ci.getCategory() == ComponentCategory.SYSTEM || ci.getCategory() == ComponentCategory.PROCESSOR
//					|| ci.getCategory() == ComponentCategory.THREAD || ci.getCategory() == ComponentCategory.VIRTUAL_BUS
//					|| ci.getCategory() == ComponentCategory.THREAD_GROUP
//					|| ci.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
			populateBindingPaths(ci);
//			}
		}
	}

	public boolean impact(PropagationPathEnd src, PropagationPathEnd dst) {
		for (PropagationPathRecord ppr : propagationPaths) {
			if ((ppr.getPathSrc().getComponentInstance() == src.getComponentInstance())
					&& (ppr.getPathSrc().getErrorPropagation() == src.getErrorPropagation())
					&& (ppr.getPathDst().getComponentInstance() == dst.getComponentInstance())
					&& (ppr.getPathDst().getErrorPropagation() == dst.getErrorPropagation())) {
				return true;
			}

			if ((ppr.getPathSrc().getComponentInstance() == src.getComponentInstance())
					&& (ppr.getPathSrc().getErrorPropagation() == src.getErrorPropagation())) {

				ComponentInstance dstCI = ppr.getDstCI();
				List<ErrorPropagation> eps = new ArrayList<ErrorPropagation>();
				ComponentClassifier classifier = dstCI.getComponentClassifier();
				eps.addAll(EMV2Util.getAllOutgoingErrorPropagations(classifier));
				for (ErrorPropagation ep : eps) {
					if (impact(new PropagationPathEnd(dstCI, ep), dst)) {

						return true;
					}

				}

			}
		}
		return false;
	}

	public Collection<PropagationPathRecord> getPropagationPaths() {
		return propagationPaths;
	}

	public Collection<ComponentInstance> getSubcomponents() {
		return subcomponents;
	}

	public Collection<ConnectionInstance> getConnections() {
		return connections;
	}

	public InstanceObject getRoot() {
		return root;
	}

	public void setRoot(ComponentInstance root) {
		this.root = root;
	}

	public void printPropagationPaths() {
		Collection<PropagationPathRecord> pl = getPropagationPaths();
		for (PropagationPathRecord propagationPath : pl) {
			OsateDebug.osateDebug("PP src " + propagationPath.getSrcCI().getComponentInstancePath() + ":"
					+ generateErrorPropTypeSetText(propagationPath.getPathSrc().getErrorPropagation()) + " dst "
					+ propagationPath.getDstCI().getComponentInstancePath() + ":"
					+ generateErrorPropTypeSetText(propagationPath.getPathDst().getErrorPropagation())
					+ (propagationPath.getConnectionInstance() != null
					? " conni " + propagationPath.getConnectionInstance().getName() : ""));
		}
	}

	public String generateErrorPropTypeSetText(ErrorPropagation ep) {
		if (ep == null) {
			return "";
		}
		TypeSet ts = ep.getTypeSet();
		return ((EMV2Util.getPrintName(ep)) + (ts != null ? " " + EMV2Util.getPrintName(ts) : ""));
	}

	/**
	 * find the propagation paths between component instances with error propagations.
	 * This method handles different levels.
	 * It also handles both complete and incomplete connection instances (the latter are out only and in only connections
	 * @param connectionInstance
	 * @param level LEAF (lowest), TOP (highest), ALL (all combinations)
	 */
	protected void populateConnectionPropagationPaths(ConnectionInstance connectionInstance,
			PropagationPathLevel level) {
		SystemOperationMode som = connectionInstance.getSystemInstance().getCurrentSystemOperationMode();
		if (!connectionInstance.isActive(som)) {
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
			if (!connectionReference.isActive(som)) {
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
				switch (level) {
				case TOP:
					srcprop = foundEP;
					srcCI = src.getComponentInstance();
					break;
				case LEAF:
					if (srcprop == null) {
						srcprop = foundEP;
						srcCI = src.getComponentInstance();
					}
					break;
				case ALL:
					addlSrcEP.add(foundEP);
					addlSrcCI.add(src.getComponentInstance());
					break;
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
				switch (level) {
				case TOP:
					if (dstprop == null) {
						dstprop = founddst;
						dstCI = dst.getComponentInstance();
					}
					break;
				case LEAF:
					dstprop = founddst;
					dstCI = dst.getComponentInstance();
					break;
				case ALL:
					addlDstEP.add(foundEP);
					addlDstCI.add(src.getComponentInstance());
					break;
				}
			}

		}
		// done with all connection references
		// record the results
		switch (level) {
		case TOP:
		case LEAF:
			if (srcprop != null && dstprop != null) {
				// we found a source and destination. Add it if not already
				// there.
				addPropagationpathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
			} else {
				if (srcprop != null && addlSrcEP.size() > 1) {
					dstprop = addlSrcEP.get(addlSrcEP.size() - 1);
					dstCI = addlSrcCI.get(addlSrcCI.size() - 1);
				}
			}
			break;
		case ALL:
			// add all combinations
			// FIXME: this is obviously wrong
			for (int i = 0; i < addlSrcCI.size(); i++) {
				for (int j = 0; i < addlDstCI.size(); i++) {
					srcCI = addlSrcCI.get(i);
					srcprop = addlSrcEP.get(i);
					dstCI = addlDstCI.get(i);
					dstprop = addlDstEP.get(i);
					addPropagationpathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
				}
			}
			break;
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
				if (!connectionReference.isActive(som)) {
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
					switch (level) {
					case TOP:
						srcprop = foundEP;
						srcCI = src.getComponentInstance();
						break;
					case LEAF:
						if (srcprop == null) {
							srcprop = foundEP;
							srcCI = src.getComponentInstance();
						}
						break;
					case ALL:
						addlSrcEP.add(foundEP);
						addlSrcCI.add(src.getComponentInstance());
						break;
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
					switch (level) {
					case TOP:
						if (dstprop == null) {
							dstprop = founddst;
							dstCI = dst.getComponentInstance();
						}
						break;
					case LEAF:
						dstprop = founddst;
						dstCI = dst.getComponentInstance();
						break;
					case ALL:
						addlDstEP.add(foundEP);
						addlDstCI.add(src.getComponentInstance());
						break;
					}
				}
			}
			// done with all connection references
			// record the results
			switch (level) {
			case TOP:
			case LEAF:
				if (srcprop != null && dstprop != null) {
					// we found a source and destination. Add it if not already
					// there.
					addPropagationpathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
				} else {
					if (srcprop != null && addlSrcEP.size() > 1) {
						dstprop = addlSrcEP.get(addlSrcEP.size() - 1);
						dstCI = addlSrcCI.get(addlSrcCI.size() - 1);
					}
				}
				break;
			case ALL:
				// add all combinations
				// FIXME: this is obviously wrong
				for (int i = 0; i < addlSrcCI.size(); i++) {
					for (int j = 0; i < addlDstCI.size(); i++) {
						srcCI = addlSrcCI.get(i);
						srcprop = addlSrcEP.get(i);
						dstCI = addlDstCI.get(i);
						dstprop = addlDstEP.get(i);
						addPropagationpathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
					}
				}
				break;
			}
		}
	}

	/**
	 * add a propagation path record only if it does not exist already.
	 * It also updates the list of "saubcomponent" i.e., component instances involved in propagation paths
	 * @param srcCI
	 * @param srcprop
	 * @param dstCI
	 * @param dstprop
	 * @param connectionInstance
	 */
	private void addPropagationpathRecord(ComponentInstance srcCI, ErrorPropagation srcprop, ComponentInstance dstCI,
			ErrorPropagation dstprop, ConnectionInstance connectionInstance) {
		if (!existsPropagationPath(srcCI, srcprop, dstCI, dstprop, connectionInstance)) {
			PropagationPathRecord path = new PropagationPathRecord(srcCI, srcprop, dstCI, dstprop, connectionInstance);
			propagationPaths.add(path);
			subcomponents.add(srcCI);
			subcomponents.add(dstCI);
		}
	}

	/**
	 * populate direct bindings from the specified component to its resources
	 *
	 * @param ci
	 */
	protected void populateBindingPaths(InstanceObject obj) {
		if (obj instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) obj;
			List<ComponentInstance> cpus = InstanceModelUtil.getProcessorBinding(ci);
			for (ComponentInstance cpu : cpus) {
				populateBindingPropagationPaths(ci, cpu, "processor");
			}
			if (!(ci instanceof VirtualProcessor)) {
				// do memory bindings
				List<ComponentInstance> mems = InstanceModelUtil.getMemoryBinding(ci);
				for (ComponentInstance mem : mems) {
					populateBindingPropagationPaths(ci, mem, "memory");
				}
			}
			if (ci instanceof VirtualBus) {
				// do connection bindings
				List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(ci);
				for (ComponentInstance bres : boundresources) {
					populateBindingPropagationPaths(ci, bres, "connection");
				}
			}
			List<ComponentInstance> systems = InstanceModelUtil.getFunctionBinding(ci);
			for (ComponentInstance system : systems) {
				populateBindingPropagationPaths(ci, system, "binding");
			}
		} else if (obj instanceof ConnectionInstance) {
			// do connection bindings
			List<ComponentInstance> boundresources = InstanceModelUtil.getConnectionBinding(obj);
			if (boundresources.isEmpty()) {
				boundresources = InstanceModelUtil.deriveBoundBuses((ConnectionInstance) obj);
			}
			for (ComponentInstance bres : boundresources) {
				populateBindingPropagationPaths((ConnectionInstance) obj, bres, "connection");
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
	protected void populateBindingPropagationPaths(ComponentInstance comp, ComponentInstance boundResource,
			String resourcebindingKind) {
		// source prop kind determined by destination and vice versa (BR = bound
		// resource, BC bound component
		boolean added = false;
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");
		ErrorPropagation BCdstprop = EMV2Util.findIncomingErrorPropagation(comp.getComponentClassifier(),
				resourcebindingKind);

		if (BRsrcprop != null && BCdstprop != null) {
			addPropagationpathRecord(boundResource, BRsrcprop, comp, BCdstprop, null);
		}
		ErrorPropagation BCsrcprop = EMV2Util.findOutgoingErrorPropagation(comp.getComponentClassifier(),
				resourcebindingKind);
		ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");
		if (BCsrcprop != null && BRdstprop != null) {
			addPropagationpathRecord(comp, BCsrcprop, boundResource, BRdstprop, null);
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
	protected void populateBindingPropagationPaths(ConnectionInstance conn, ComponentInstance boundResource,
			String bindingKind) {
		boolean added = false;
		// source prop kind determined by destination and vice versa (BR = bound
		// resource, BC bound component
		ErrorPropagation BRsrcprop = EMV2Util.findOutgoingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");

		if (BRsrcprop != null) {
			propagationPaths.add(new PropagationPathRecord(boundResource, BRsrcprop, conn));
			added = true;
		}
		ErrorPropagation BRdstprop = EMV2Util.findIncomingErrorPropagation(boundResource.getComponentClassifier(),
				"bindings");
		if (BRdstprop != null) {
			propagationPaths.add(new PropagationPathRecord(conn, boundResource, BRdstprop));
			added = true;
		}
		if (added) {
			connections.add(conn);
			subcomponents.add(boundResource);
		}
	}

	/**
	 * populate with user declared propagation paths declared in this component
	 * instance the paths are between subcomponents
	 *
	 * @param ci
	 *            ComponentInstance
	 */
	protected void populateUserDeclaredPropagationPaths(InstanceObject obj) {
		if (obj instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) obj;
			Collection<PropagationPath> pplist = EMV2Util.getAllPropagationPaths(ci.getComponentClassifier());
			for (PropagationPath propagationPath : pplist) {
				addUserDeclaredPropagationPath(ci, propagationPath);
			}
		}
	}

	protected void addUserDeclaredPropagationPath(ComponentInstance ci, PropagationPath pp) {
		ErrorPropagation srcEP = null;
		ErrorPropagation dstEP = null;
		ComponentInstance srcCI = getComponentInstance(ci, EMV2Util.getSubcomponents(pp.getSource()));
		ComponentInstance dstCI = getComponentInstance(ci, EMV2Util.getSubcomponents(pp.getTarget()));
		if (srcCI != null) {
			srcEP = EMV2Util.findErrorPropagation(srcCI.getComponentClassifier(),
					pp.getSource().getPropagationPoint().getName(), DirectionType.OUT);
		}
		if (dstCI != null) {
			dstEP = EMV2Util.findErrorPropagation(srcCI.getComponentClassifier(),
					pp.getTarget().getPropagationPoint().getName(), DirectionType.IN);
		}
		addPropagationpathRecord(srcCI, srcEP, dstCI, dstEP, null);

	}

	protected ComponentInstance getComponentInstance(ComponentInstance ci, EList<SubcomponentElement> sublist) {
		ComponentInstance result = ci;
		for (SubcomponentElement subcomponentElement : sublist) {
			result = result.findSubcomponentInstance(subcomponentElement.getSubcomponent());
			if (result == null) {
				return null;
			}
		}
		return result;
	}

	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ComponentInstance ci, ErrorPropagation outEP) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if (src.getComponentInstance() == ci && src.getErrorPropagation() == outEP) {
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}

	public EList<PropagationPathEnd> getAllPropagationDestinationEnds(ConnectionInstance ci) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			if (propagationPathRecord.getConnectionInstance() == ci) {
				result.add(propagationPathRecord.getPathDst());
			}
		}
		return result;
	}

	/**
	 * return all propagation paths out of the outgoing error propagation we
	 * assume that any type token to be propagated meets the ep type constraint
	 *
	 * @param ci
	 * @param outEP
	 * @return
	 */
	public EList<PropagationPathRecord> getAllPropagationPaths(ComponentInstance ci, ErrorPropagation outEP) {
		EList<PropagationPathRecord> result = new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if (src.getComponentInstance() == ci) {
				if (src.getErrorPropagation() == outEP) {
					result.add(propagationPathRecord);
				} else {
					// check if one EP is in an ancestor feature instance
					FeatureInstance outepfi = EMV2Util.findFeatureInstance(outEP, ci);
					FeatureInstance srcfi = EMV2Util.findFeatureInstance(src.getErrorPropagation(), ci);
					if (Aadl2InstanceUtil.containedIn(outepfi, srcfi)
							|| Aadl2InstanceUtil.containedIn(srcfi, outepfi)) {
						result.add(propagationPathRecord);
					}
				}
			}
		}
		return result;
	}

	public EList<PropagationPathRecord> getAllPropagationPaths(ConnectionInstance ci) {
		EList<PropagationPathRecord> result = new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			if (src.getConnectionInstance() == ci) {
				result.add(propagationPathRecord);
			}
		}
		return result;
	}

	public EList<PropagationPathEnd> getAllPropagationSourceEnds(ComponentInstance ci, ErrorPropagation inEP) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd dst = propagationPathRecord.getPathDst();
			if (dst.getComponentInstance() == ci && dst.getErrorPropagation() == inEP) {
				result.add(propagationPathRecord.getPathSrc());
			}
		}
		return result;
	}

	public EList<PropagationPathEnd> getAllPropagationSourceEnds(ConnectionInstance ci) {
		EList<PropagationPathEnd> result = new BasicEList<PropagationPathEnd>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd dst = propagationPathRecord.getPathDst();
			if (dst.getConnectionInstance() == ci) {
				result.add(propagationPathRecord.getPathSrc());
			}
		}
		return result;
	}

	public EList<PropagationPathRecord> getAllReversePropagationPaths(ComponentInstance ci, ErrorPropagation inEP) {
		EList<PropagationPathRecord> result = new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if (src.getComponentInstance() == ci && src.getErrorPropagation() == inEP) {
				result.add(propagationPathRecord);
			}
		}
		return result;
	}

	public EList<PropagationPathRecord> getAllReversePropagationPaths(ConnectionInstance ci) {
		EList<PropagationPathRecord> result = new BasicEList<PropagationPathRecord>();
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathDst();
			if (src.getConnectionInstance() == ci) {
				result.add(propagationPathRecord);
			}
		}
		return result;
	}

	/**
	 * return all feature (or for access component) instances that are the
	 * connection destination of the given feature instance The source and
	 * destinations are assumed to be components with error models
	 *
	 * @param fi
	 * @return list of ConnectionInstanceEnd
	 */
	public EList<ConnectionInstanceEnd> getAllPropagationDestinationEnds(ConnectionInstanceEnd fi) {
		EList<ConnectionInstanceEnd> result = new BasicEList<ConnectionInstanceEnd>();
		NamedElement f = null;
		if (fi instanceof FeatureInstance) {
			f = ((FeatureInstance) fi).getFeature();
		} else {
			f = ((ComponentInstance) fi).getSubcomponent();
		}
		for (PropagationPathRecord propagationPathRecord : propagationPaths) {
			PropagationPathEnd src = propagationPathRecord.getPathSrc();
			ErrorPropagation ep = src.getErrorPropagation();
			Feature srcf = EMV2Util.getFeature(ep);
			if (srcf != null && srcf == f) {
				PropagationPathEnd dst = propagationPathRecord.pathDst;
				ErrorPropagation dstep = dst.getErrorPropagation();
				if (dstep != null) {
					Feature dstf = EMV2Util.getFeature(dstep);
					ComponentInstance dstCI = dst.getComponentInstance();
					if (dstf != null) {
						FeatureInstance dstfi = dstCI.findFeatureInstance(dstf);
						result.add(dstfi);
					} else if (EMV2Util.isAccess(dstep)) {
						result.add(dstCI);
					}
				}
			}
		}
		return result;
	}

	private boolean existsPropagationPath(ComponentInstance srcCI, ErrorPropagation srcEP, ComponentInstance dstCI,
			ErrorPropagation dstEP, ConnectionInstance conni) {
		for (PropagationPathRecord pp : propagationPaths) {
			if (pp.getConnectionInstance() == conni && pp.getSrcCI() == srcCI && pp.getDstCI() == dstCI
					&& pp.getPathSrc().getErrorPropagation() == srcEP
					&& pp.getPathDst().getErrorPropagation() == dstEP) {
				return true;
			}
		}
		return false;
	}

}
