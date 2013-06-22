/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: CreateConnectionsSwitch.java,v 1.21 2010-06-14 01:21:51 lwrage Exp $
 */
package org.osate.aadl2.instantiation;

import static org.osate.aadl2.ComponentCategory.BUS;
import static org.osate.aadl2.ComponentCategory.DATA;
import static org.osate.aadl2.ComponentCategory.DEVICE;
import static org.osate.aadl2.ComponentCategory.PROCESSOR;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM_GROUP;
import static org.osate.aadl2.ComponentCategory.THREAD;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_PROCESSOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.DeviceImpl;
import org.osate.aadl2.impl.ParameterImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.OsateDebug;

/**
 * This class adds all connection instances to an instance model.
 */
public class CreateConnectionsSwitch extends AadlProcessingSwitchWithProgress {

	/**
	 * A stack of indices into feature groups. If the connections goes into
	 * feature #n when going up the hierarchy, it must come out at feature #n
	 * when going down the hierarchy. This can happen at any level, so we need a
	 * stack.
	 */
	private Stack<Integer> upIndex = new Stack<Integer>();
	private Stack<FeatureInstance> upFeature = new Stack<FeatureInstance>();

	/**
	 * Keeps track of indices used when going down into feature groups after we
	 * run out of indices in the up stack.
	 */
	private Stack<Integer> downIndex = new Stack<Integer>();
	private Stack<FeatureInstance> downFeature = new Stack<FeatureInstance>();

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache = null;

	/**
	 * Create a new instance.
	 * 
	 * @param pm the progress monitor
	 * @param errMgr the error manager
	 * @param classifierCache cache of known instantiated classifiers, may be
	 *            null
	 */
	public CreateConnectionsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
		this.classifierCache = classifierCache;
	}

	private boolean isOpposite (Feature feature, Subcomponent sub,Connection connection) 
	{
		List<Feature> 	features= feature.getAllFeatureRefinements();
		EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
		if (features.contains(connection.getAllSource())&& subs.contains(connection.getAllSourceContext())){
			return false;
		} else {
			if (connection.isBidirectional()&& features.contains(connection.getAllDestination())&&
				subs.contains(connection.getAllDestinationContext()) ){
			// we are going the other way on a bi-directional connection
			return true;
			}
		}
		return false;
	}
		
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch#initSwitches
	 * ()
	 */
	@Override
	protected void initSwitches() 
	{
		instanceSwitch = new InstanceSwitch<String>() 
		{
			boolean inArray = false;
			String prefix = "";

			public String caseComponentInstance(final ComponentInstance ci) throws UnsupportedOperationException 
			{
				if (!(ci instanceof SystemInstance)) 
				{
					if (!inArray) 
					{
						for (Long index : ci.getIndices()) 
						{
							if (index > 1) 
							{
								inArray = true;
								prefix = ci.getContainingComponentInstance().getInstanceObjectPath() + "."
										+ ci.getName();
							}
						}
					} 
					else 
					{
						inArray = ci.getInstanceObjectPath().startsWith(prefix);
					}
					
					if (!inArray) 
					{
						// process first component of innermost array only
						instantiateConnections(ci);
					}
				}
				return DONE;
			}
		};
	}

	/**
	 * Create all connection instances that start at a component instance.
	 * 
	 * @param ci The component that is the ultimate source; this should be a
	 *            thread, processor or device
	 * @throws InstantiationException 
	 */
	// TODO-LW: handle access to subprograms and subprogram groups
	// TODO-LW: connections inside threads (mode conn, access)
	// TODO-LW: warning if connection incomplete
	private void instantiateConnections(final ComponentInstance ci) throws UnsupportedOperationException 
	{
		ComponentCategory cat = ci.getCategory();
		Subcomponent sub = ci.getSubcomponent();
		ComponentInstance parentci = ci.getContainingComponentInstance();
		List<Connection> parentConns = 
				InstanceUtil.getComponentImplementation(parentci, 0, classifierCache).getAllConnections();

		if (parentci instanceof SystemInstance) 
		{
			monitor.subTask("Creating connections in  " + ci.getName());
		}

		if (cat == DATA || cat == BUS || cat == SUBPROGRAM || cat == SUBPROGRAM_GROUP)
		{
			// connection instance may start at a shared component
			for (Connection conn : filterStartingConnections(parentConns, sub))
			{
				boolean opposite = sub.getAllSubcomponentRefinements().contains(conn.getAllDestination());

				appendSegment(ConnectionInfo.newConnectionInfo(ci), conn, parentci, opposite);
				if (monitor.isCanceled()) 
				{
					return;
				}
			}
		} 
		else 
		{
			// connection instance may start at a feature
			List<Connection> outsideSubConns = filterOutgoingConnections(parentConns, sub);
			ComponentImplementation cimpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
			@SuppressWarnings("unchecked")
			List<Connection> insideSubConns = cimpl != null ? cimpl.getAllConnections() : Collections.EMPTY_LIST;
			boolean hasOutgoingFeatureSubcomponents = 
					AadlUtil.hasOutgoingFeatureSubcomponents(ci.getComponentInstances());
			FeatureInstance prevFi = null;
			for (FeatureInstance featurei : ci.getFeatureInstances()) 
			{
				if (prevFi == null || !prevFi.getName().equalsIgnoreCase(featurei.getName())){
				Feature feature = featurei.getFeature();
				// TODO warning if subcomponents with outgoing features exist
				if (AadlUtil.hasOutgoingFeatures(featurei)) 
				{
					List<Connection> outgoingConns = filterOutgoingConnections(outsideSubConns, feature, sub);
					boolean connectedInside = false;
					boolean destinationFromInside = false;

					// warn if there's an incomplete connection
					if (hasOutgoingFeatureSubcomponents&&
							((cat != THREAD && cat != PROCESSOR && cat != DEVICE && cat != VIRTUAL_PROCESSOR)
							// in case of a provides bus access we want to start from the bus.
							|| ((cat == PROCESSOR || cat == DEVICE || cat == ComponentCategory.MEMORY)
							&& feature instanceof BusAccess&& ((BusAccess)feature).getKind() == AccessType.PROVIDES))) {
						connectedInside = isConnectionEnd(insideSubConns, feature);
						destinationFromInside = isDestination(insideSubConns, feature);
					}

					// first see if mode transitions are triggered by a
//					 doModeTransitionConnections(ci, featurei);

					for (Connection conn : outgoingConns) 
					{
						// conn is first segment if it can't continue inside the subcomponent
						if (!(destinationFromInside || conn.isBidirectional() && connectedInside)) 
						{
							prevFi = featurei;
							
							boolean opposite = isOpposite (feature, sub, conn);

							appendSegment(ConnectionInfo.newConnectionInfo(featurei), conn, parentci, opposite);
							if (monitor.isCanceled()) 
							{
								return;
							}
						}
					}
				}
				}
			}
		}
	}
	
	private int getFeatureIndex(FeatureInstance fi){
		Element fgi = fi.getOwner();
		if (fgi instanceof FeatureInstance){
			EList<FeatureInstance> flist = ((FeatureInstance) fgi).getFeatureInstances();
			return flist.indexOf(fi);
		}
		return -1;
	}
	
	private boolean isSame(FeatureInstance up, FeatureInstance down){
		if (up.getName().equalsIgnoreCase(down.getName())){
			return true;
		}
		FeatureGroupType upfgt = ((FeatureGroup)((FeatureInstance)up.getOwner()).getFeature()).getFeatureGroupType();
		FeatureGroupType downfgt = ((FeatureGroup)((FeatureInstance)down.getOwner()).getFeature()).getFeatureGroupType();
		if (upfgt.isInverseOf(downfgt)&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()){
			return (getFeatureIndex(up)==getFeatureIndex(down));
		}
		return false;
	}

	/**
	 * Append a segment to a connection instance.
	 * 
	 * @param newSegment the declarative connection to be added to the
	 *            connection instance
	 * @param ci the component that contains the new segment
	 * @param goOpposite the current declarative connection is bidirectional and
	 *            we are following it toward its source
	 * @param conni the connection instance representing the semantic connection
	 */
	// TODO-LW: set 'complete' in conn info
	private void appendSegment(ConnectionInfo connInfo, final Connection newSegment, final ComponentInstance ci,
			final boolean goOpposite) 
	{
		final boolean didModeTransitionConnection = doModeTransitionConnections(ci, connInfo, newSegment);
		final ConnectionEnd fromEnd = goOpposite ? newSegment.getAllDestination() : newSegment.getAllSource();
		final Context fromCtx = goOpposite ? newSegment.getAllDestinationContext() : newSegment.getAllSourceContext();
		ConnectionEnd toEnd = goOpposite ? newSegment.getAllSource() : newSegment.getAllDestination();
		final Context toCtx = goOpposite ? newSegment.getAllSourceContext() : newSegment.getAllDestinationContext();
		final ComponentInstance toCi = (toCtx instanceof Subcomponent) ? ci
				.findSubcomponentInstance((Subcomponent) toCtx) : null;
		final boolean finalComponent = isConnectionEndingComponent(toCtx);
		final boolean dstEmpty = toCtx instanceof Subcomponent && toCi.getComponentInstances().isEmpty();
		ConnectionInstanceEnd fromFi = null;
		ConnectionInstanceEnd toFi = null;
		FeatureInstance pushedFeature = null;
		FeatureInstance poppedFeature = null;
		FeatureInstance downedFeature = null;

		/*
		 * FIX JD
		 * If we have a data component directly connected
		 * to a subprogram parameter, we do not handle it because
		 * we do not deal with parameter connection within the instance
		 * model.
		 * See bug #220
		 */
		if ((toEnd instanceof ParameterImpl) && 
			((fromEnd instanceof DataSubcomponent) || (fromEnd instanceof DataAccess)))
		{
			return;
		}
		
		/*
		 * Fix JD bug #222
		 */
		if ((toEnd instanceof DataAccess) && (toEnd.getContainingClassifier() != null ) && (toEnd.getContainingClassifier() instanceof SubprogramType))
		{
			return;
		}
		
		if (toCtx instanceof Subcomponent && toCi == null) {
			if (!(toCtx instanceof SubprogramSubcomponent)) {
				error(ci, "Instantiation error: no component instance for subcomponent " + toCtx.getName());
			}
			return;
		}

		if (!(fromEnd instanceof Subcomponent)) {
			// fromEnd is a feature
			final ComponentInstance fromCi = (fromCtx instanceof Subcomponent) ? ci
					.findSubcomponentInstance((Subcomponent) fromCtx) : null;
			if (fromCtx instanceof Subcomponent && fromCi == null) {
				if (!(fromCtx instanceof SubprogramSubcomponent)) {
					error(ci, "Instantiation error: no component instance for subcomponent " + fromCtx.getName());
				}
				return;
			}
			List<FeatureInstance> fiList = null;

			if (fromCtx instanceof FeatureGroup) {
				// TODO phf: find index and compare with stack
				FeatureInstance fgi = (FeatureInstance) AadlUtil.findNamedElementInList(ci.getFeatureInstances(),
						fromCtx.getName());
				if (fgi != null) {
					fiList = fgi.getFeatureInstances();
					fromFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, fromEnd.getName());
				}
				if (fromFi!= null){
					if (!upFeature.empty()) {
						FeatureInstance popfi = upFeature.peek();
						if (!isSame(popfi ,(FeatureInstance)fromFi)) {
							// did not match
							return;
						} else {
							poppedFeature = upFeature.pop();
						}
					} else {
						downFeature.push((FeatureInstance)fromFi);
						downedFeature = (FeatureInstance)fromFi;
					}
				}
			} else {
				fiList = (fromCi != null ? fromCi : ci).getFeatureInstances();
				fromFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, fromEnd.getName());
			}
		} else {
			fromFi = ci.findSubcomponentInstance((Subcomponent)fromEnd);
		}
		if (!(toEnd instanceof Subcomponent)) {
			List<FeatureInstance> fiList = null;

			if (toCtx instanceof FeatureGroup) {

				FeatureInstance fgi = (FeatureInstance) AadlUtil.findNamedElementInList(ci.getFeatureInstances(),
						toCtx.getName());
				if (fgi != null) {
					fiList = fgi.getFeatureInstances();
					toFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, toEnd.getName());
				}
				if (toFi != null){
						upFeature.push((FeatureInstance)toFi);
						pushedFeature = (FeatureInstance)toFi;
				}
			} else {
				fiList = (toCi != null ? toCi : ci).getFeatureInstances();
				toFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, toEnd.getName());
			}
		} else {
			toFi = ci.findSubcomponentInstance((Subcomponent)toEnd);
		}

		if (!connInfo.addSegment(newSegment, fromFi, toFi, ci, goOpposite)) {
			if (toFi == null) {
				error(ci,
						"Connection from " + connInfo.src.getInstanceObjectPath() + " via "
								+ newSegment.getQualifiedName()
								+ " has no valid direction. Connection instance not created.");
			} else {
				error(ci,
						"Connection from " + connInfo.src.getInstanceObjectPath() + " to "
								+ toFi.getInstanceObjectPath()
								+ " has no valid direction. Connection instance not created.");
			}
			return;
		}

		// first check if the connection must end with the new segment

		if (toEnd instanceof Subcomponent) {
			// connection ends at a shared data, bus, or subprogram (group)
			finalizeConnectionInstance(ci.getSystemInstance(), connInfo,
					ci.findSubcomponentInstance((Subcomponent) toEnd));
		} else {
			Feature toFeature = (Feature) toEnd;

			if (toEnd instanceof Parameter || finalComponent && !(toEnd instanceof FeatureGroup)) {
				// connection ends at a parameter or at a simple feature of a
				// thread, device, or (virtual) processor
				FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
				if (dstFi == null) {
					error(toCi, "Destination feature " + toFeature.getName() + " not found. No connection created.");
				} else {
					connInfo.complete &= true;
					finalizeConnectionInstance(ci, connInfo, dstFi);
				}
			} else

			if (finalComponent && toEnd instanceof FeatureGroup) {
				// connection ends at a feature that is contained in a feature group
				// of a thread, device, or (virtual) processor
				FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
				if (dstFi == null) {
					error(toCi, "Destination feature " + toFeature.getName() + " not found. No connection created.");
				} else {
					connInfo.complete = true;
					finalizeConnectionInstance(ci, connInfo, dstFi);
				}
			} else

			if (dstEmpty) {
				// connection ends because the destination component does not
				// contain any subcomponents
				FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
				if (dstFi == null) {
					error(toCi, "Destination feature " + toFeature.getName() + " not found. No connection created.");
				} else {
					finalizeConnectionInstance(ci, connInfo, dstFi);
				}
			} else

			// the connection may have more segments

			if (!(toCtx instanceof Subcomponent)) {
				// going up hierarchy, connection goes to a feature in the component
				// implementation
				if (ci instanceof SystemInstance) {
					if (toCtx instanceof FeatureGroup){
						// XXX: PHF: going up into an element of a feature group
						// should we go to the FG or to the feature?
						finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance((FeatureGroup)toCtx));
					} else {
						finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance(toFeature));
					}
				} else {
					if (toCtx instanceof FeatureGroup) {
						toFeature = (FeatureGroup) toCtx;
						// toFeature now points to the enclosing feature group
						// this should be the starting feature for the next connection
					}

					ComponentInstance nextCi = ci.getContainingComponentInstance();
					List<Connection> parentConns = InstanceUtil.getComponentImplementation(nextCi, 0, classifierCache)
							.getAllConnections();
					List<Connection> conns = filterOutgoingConnections(parentConns, toFeature, ci.getSubcomponent());

					if (conns.isEmpty() && !didModeTransitionConnection) {

						// TODO phf: we should not create the instance while we are only outgoing
						// if we do toFeature may point to the feature group rather than the feature of the feature group
						// How does finalize handle such a feature group?
						finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance(toFeature));
					} else {
						if (!conns.isEmpty()) {
							for (Connection nextConn : conns) {
								// note: nextConn goes either up or across
								final ConnectionInfo clone = connInfo.cloneInfo();
								boolean opposite = false;

								if (nextConn.isBidirectional()) {
									ConnectionEnd nextDst = nextConn.getAllDestination();

									if (nextDst instanceof Feature) {
										Feature nextDstFeature = (Feature) nextDst;
										FeatureInstance nextDstFi = nextCi.findFeatureInstance(nextDstFeature);

										if (nextDstFi == null) {
											// next goes across
											Context nextDstCtx = nextConn.getAllDestinationContext();

											if (nextDstCtx instanceof Subcomponent) {
												ComponentInstance nextDstSubi = nextCi
														.findSubcomponentInstance((Subcomponent) nextDstCtx);
												nextDstFi = nextDstSubi.findFeatureInstance(nextDstFeature);
											}
										}
										if (nextDstFi != null) {
											opposite = ci.findFeatureInstance(toFeature) == nextDstFi;
										}
									}
								}

								appendSegment(clone, nextConn, nextCi, opposite);
							}
						}
					}
				}
			} else {
				// going down hierarchy or across

				if (toCtx instanceof Subcomponent && toCi == null) {
					if (!(toCtx instanceof SubprogramSubcomponent)) {
						error(ci, "Instantiation error: no component instance for subcomponent " + toCtx.getName());
					}
					return;
				}

				toFi = toCi.findFeatureInstance(toFeature);

				if (toFi == null) {
					error(ci, "Could not find instance object for feature " + toEnd.getName() + " of subcomponent "
							+ ((Subcomponent) toCtx).getName() + ". No connection instance created.");
					return;
				}

				ComponentImplementation toImpl = InstanceUtil.getComponentImplementation(toCi, 0, classifierCache);
				if (toImpl == null) {
					finalizeConnectionInstance(ci, connInfo, toFi);
				} else {
					// there is a toImpl
					List<Connection> conns = AadlUtil.getIngoingConnections(toImpl, toFeature);

					
					if (conns.isEmpty()) {
						List<Subcomponent> subs = toImpl.getAllSubcomponents();

						if (!subs.isEmpty()) {
							if (!isValidFinalComponent(toCtx)) {
								warning(ci,
										"No connection declaration from feature " + toEnd.getName() + " of component "
												+ ((Subcomponent) toCtx).getName()
												+ " to subcomponents. Connection instance ends at "
												+ ((Subcomponent) toCtx).getName());
							}
							finalizeConnectionInstance(ci, connInfo, toFi);
						}
					} else {
						// we may need to stop at the processor in addition to going in
						if ((toImpl instanceof ProcessorImplementation || toImpl instanceof DeviceImplementation || toImpl instanceof MemoryImplementation)
								&&!(toEnd instanceof BusAccess && ((BusAccess)toEnd).getKind() == AccessType.PROVIDES )){
							final ConnectionInfo clone = connInfo.cloneInfo();
							finalizeConnectionInstance(ci, clone, toFi);
						}
						// we have ingoing connections that start with toFeature as End or as Cxt
						for (Connection nextConn : conns) {
							final ConnectionInfo clone = connInfo.cloneInfo();

							// TODO-LW: check if this logic is correct
							EList<Feature> toflist = toFeature.getAllFeatureRefinements();
							final boolean opposite = toflist.contains(nextConn.getAllDestination())
									|| toflist.contains(nextConn.getAllDestinationContext());
							appendSegment(clone, nextConn, toCi, opposite);
						}
					}
				}
			}
		}
		if (pushedFeature != null) {
			if (!upFeature.empty()) {
				upFeature.pop();
			} else {
				warning(ci, "Popping from empty upindex");
			}
		}
		if (poppedFeature != null) {
			if (downFeature.empty()) {
				upFeature.push(poppedFeature);
			} else {
				// remove from downIndex
				warning(ci, "Trying to push back on while downIndex is not empty");
			}
		}
		if (downedFeature != null) {
			// remove from downIndex
			FeatureInstance popfeature = downFeature.pop();
			if (!isSame(popfeature,downedFeature)) {
				// should be the same 
				warning(ci, "Did not match popped downIndex");
			}
		}
	}

	// ------------------------------------------------------------------------
	// Post-process completed connection instance
	// ------------------------------------------------------------------------

	protected void finalizeConnectionInstance(ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd dstEnd) {

		FeatureInstance  upFi = null;
		if (dstEnd instanceof FeatureInstance){
			FeatureInstance dstFi = (FeatureInstance)dstEnd;

			if (dstFi.getCategory() == FeatureCategory.FEATURE_GROUP && !upFeature.isEmpty()) {
				upFi = upFeature.pop();
				EList<FeatureInstance> flist = dstFi.getFeatureInstances();
				FeatureInstance resFi = (FeatureInstance) AadlUtil.findNamedElementInList(flist, upFi.getName());
				if (resFi == null){  // do index only if we have inverse feature groups and they have their own element names
					FeatureGroupType upfgt = ((FeatureGroup)((FeatureInstance)upFi.getOwner()).getFeature()).getFeatureGroupType();
					FeatureGroupType downfgt = ((FeatureGroup)dstFi.getFeature()).getFeatureGroupType();
					if (upfgt.isInverseOf(downfgt)&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()){
						dstFi = flist.get(getFeatureIndex(upFi));
					}
				} else {
					dstFi = resFi;
				}
			}
			if (connInfo.src instanceof FeatureInstance) {
				FeatureInstance srcFi = (FeatureInstance) connInfo.src;

				if (srcFi.getFeatureInstances().isEmpty() && dstFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
				} else {
					// src and/or dst is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcFi, dstFi);
				}
			} else if (connInfo.src instanceof ComponentInstance) {
				ComponentInstance srcCi = (ComponentInstance) connInfo.src;

				if (dstFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
				} else {
					// dst is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcCi, dstFi);
				}
			} else {
				error(parentci.getSystemInstance(), "Connection source is neither a feature nor a component: "
						+ connInfo.src.getInstanceObjectPath() + " => " + connInfo.src.getInstanceObjectPath());
			}
			if (upFi  != null) {
				upFeature.push(upFi );
			}
		} else {
			// Component Instance
			ComponentInstance dstCi = (ComponentInstance) dstEnd;

			if (connInfo.src instanceof FeatureInstance) {
				FeatureInstance srcFi = (FeatureInstance) connInfo.src;

				if (srcFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstCi);
				} else {
					// src is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcFi, dstCi);
				}
			} else if (connInfo.src instanceof ComponentInstance) {
				error(parentci.getSystemInstance(),
						"Connection source and destination are components: " + connInfo.src.getInstanceObjectPath()
						+ " => " + connInfo.src.getInstanceObjectPath());
			} else {
				error(parentci.getSystemInstance(), "Connection source is neither a feature nor a component: "
						+ connInfo.src.getInstanceObjectPath() + " => " + connInfo.src.getInstanceObjectPath());
			}
		}
	}


	protected ConnectionInstance addConnectionInstance(final SystemInstance systemInstance,
			final ConnectionInfo connInfo, final ConnectionInstanceEnd dstI) {
		// check for duplicate connection instance

		// with arrays we can get duplicates that we don't need
		ComponentInstance container = connInfo.container;

		if (container == null) {
			container = systemInstance;
		}
		for (ConnectionInstance test : container.getConnectionInstances()) {
			// check for duplicates and do not create
			if (connInfo.src == test.getSource() && dstI == test.getDestination()){
				return null;
			}
			// the next lines determine whether a connection is bi-directional and set a flag rather than creating a second connection instance
			if (connInfo.src == test.getDestination() && dstI == test.getSource()&& test.getKind() == ConnectionKind.ACCESS_CONNECTION){
				test.setBidirectional(true);
				return test;
			}
		}
		boolean duplicate = false;

		// Generate a name for the connection
		String containerPath = (connInfo.container != null) ? connInfo.container.getInstanceObjectPath() : systemInstance.getName();
		int len =  containerPath.length() + 1 ;
		String srcPath = connInfo.src.getInstanceObjectPath();
		StringBuffer sb = new StringBuffer();
		String dstPath = "xxx";
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		srcPath = srcPath.substring(i);
		sb.append(srcPath);
		sb.append(" -> ");
		if (dstI != null) {
			dstPath = dstI.getInstanceObjectPath();
			i = (dstPath.startsWith(containerPath)) ? len : 0;
			dstPath = dstPath.substring(i);
			sb.append(dstPath);
		}

		ConnectionInstance conni = null;
		if (!duplicate) {
			conni = connInfo.createConnectionInstance(sb.toString(), dstI);

			if (conni == null) {
				warning(container,
						"Connection sequence from " + srcPath + " to "
								+ dstPath
								+ " is only outgoing. No connection instance created.");
				return null;
			} else {
				container.getConnectionInstances().add(conni);
			}

			// determine whether connection is delayed
			// TODO-LW: restore functionality
			// if (conni instanceof PortConnectionInstance) {
			// PortConnectionInstance pci = (PortConnectionInstance) conni;
			// pci.setTiming(pci.computeConnectionTiming());
			// }

			// set in modes for connection instance. those modes where both src and
			// dest are active.
			fillInModes(conni);
			fillInModeTransitions(conni);
			// perform checking on matching src and dst ports
			// we need to do this since the wrong element from a port group may have
			// been picked
			// if (conni instanceof PortConnectionInstance) {
			// this.checkSemanticConnection((PortConnectionInstance) conni);
			// }
		}
		return conni;
	}
	
	private FeatureInstance getTopFeatureInstance(FeatureInstance fi){
		FeatureInstance topfi = fi;
		while (topfi.getOwner() instanceof FeatureInstance){
			topfi = (FeatureInstance)topfi.getOwner();
		}
		return topfi;
	}

	/**
	 * Handle the case where one of the ends (or both) is a port group. Create
	 * multiple connection instances.
	 * 
	 * @param parentci
	 * @param connInfo
	 * @param srcEnd
	 * @param dstEnd
	 */
	private void balanceFeatureGroupEnds(final ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd srcEnd, ConnectionInstanceEnd dstEnd) {

		if (!upFeature.isEmpty()) {
			// dstEnd is higher up in the hierarchy than srcEnd:
			// we need to match from latest to the oldest in stack
			// going down into the FG nesting hierarchy
			for (int count = upFeature.size() - 1; count >= 0; count--) {
				EList<FeatureInstance> flist = ((FeatureInstance) dstEnd).getFeatureInstances();
				FeatureInstance upFi = upFeature.get(count);
				FeatureInstance resFi = (FeatureInstance) AadlUtil.findNamedElementInList(flist, upFi.getName());
				if (resFi == null){  // do index only if we have inverse feature groups and they have their own element names
					FeatureGroupType upfgt = ((FeatureGroup)((FeatureInstance)upFi.getOwner()).getFeature()).getFeatureGroupType();
					FeatureGroupType downfgt = ((FeatureGroup)((FeatureInstance) dstEnd).getFeature()).getFeatureGroupType();
					if (upfgt.isInverseOf(downfgt)&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()){
						dstEnd = flist.get(getFeatureIndex(upFi));
					}
				} else {
					dstEnd = resFi;
				}
			}
		} else if (!downIndex.isEmpty()) {
			// dstEnd is further down in the hierarchy than srcEnd: find feature corresponding to dstEnd
			// We need to match from the oldest to the latest in stack
			// This is a down stack, i.e., the highest element got pushed first an dis the oldest.
			for (int count = 0 ; count <downFeature.size() ; count++) {
				FeatureInstance downFi = downFeature.get(count);
				EList<FeatureInstance> flist = ((FeatureInstance) srcEnd).getFeatureInstances();
				FeatureInstance resFi = (FeatureInstance) AadlUtil.findNamedElementInList(flist, downFi.getName());
				if (resFi == null){  // do index only if we have inverse feature groups and they have their own element names
					FeatureGroupType upfgt = ((FeatureGroup)((FeatureInstance)downFi.getOwner()).getFeature()).getFeatureGroupType();
					FeatureGroupType downfgt = ((FeatureGroup)((FeatureInstance) srcEnd).getFeature()).getFeatureGroupType();
					if (upfgt.isInverseOf(downfgt)&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()){
						dstEnd = flist.get(getFeatureIndex(downFi));
					}
				} else {
					dstEnd = resFi;
				}
//				int idx = downFeature.get(count);
//				if (idx >= 0 && idx < ((FeatureInstance) srcEnd).getFeatureInstances().size()){
//					srcEnd = ((FeatureInstance) srcEnd).getFeatureInstances().get(idx);
//				}
			}
		}

		if (srcEnd instanceof ComponentInstance && dstEnd instanceof ComponentInstance) {
			// TODO-LW: error
		} else if (srcEnd instanceof ComponentInstance || dstEnd instanceof ComponentInstance) {
			addConnectionInstance(parentci.getSystemInstance(), connInfo, dstEnd);
		} else {
			expandFeatureGroupConnection(parentci, connInfo, srcEnd, dstEnd);
		}
	}

	/**
	 * @param parentci
	 * @param connInfo
	 * @param srcEnd
	 * @param dstEnd
	 */
	private void expandFeatureGroupConnection(final ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd srcEnd, ConnectionInstanceEnd dstEnd) {
		ConnectionInstanceEnd oldSrc = connInfo.src;

		if (srcEnd instanceof FeatureInstance && dstEnd instanceof FeatureInstance) {
			Iterator<FeatureInstance> srcIter = ((FeatureInstance) srcEnd).getFeatureInstances().iterator();

			if (srcIter.hasNext()) {
				Iterator<FeatureInstance> dstIter = ((FeatureInstance) dstEnd).getFeatureInstances().iterator();

				while (srcIter.hasNext() && dstIter.hasNext()) {
					ConnectionInstanceEnd src = srcIter.next();
					ConnectionInstanceEnd dst = dstIter.next();

					if (src instanceof FeatureInstance && !((FeatureInstance) src).getFeatureInstances().isEmpty()) {
						expandFeatureGroupConnection(parentci, connInfo, src, dst);
					} else {
						if (((FeatureInstance) src).getDirection() != DirectionType.IN) {
							connInfo.src = src;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dst);
						} else if (((FeatureInstance) dst).getDirection() != DirectionType.OUT) {
							connInfo.src = dst;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, src);
						}
					}
				}
			} else {
				addConnectionInstance(parentci.getSystemInstance(), connInfo, dstEnd);
			}
		}
		connInfo.src = oldSrc;
	}

	/**
	 * check semantic consistency of connections between ports/port
	 * groups/paramaters
	 * 
	 * @param conni
	 */
	// TODO-LW: implement new AADL2 rules
//	private void checkSemanticConnection(ConnectionInstance conni) {
		// perform checking on matching src and dst ports
		// we need to do this since the wrong element from a port group may have
		// been picked
		/*
		 * FeatureInstance srcI = conni.getSrc(); FeatureInstance dstI =
		 * conni.getDst(); if (srcI == null || dstI == null) return; Feature
		 * srcPort = conni.getSrc().getFeature(); Feature dstPort =
		 * conni.getDst().getFeature(); if (srcPort.eClass() !=
		 * dstPort.eClass()) { error(conni, "Source '" + srcPort.getName() +
		 * "' and destination '" + dstPort.getName() +
		 * "' port categories do not match for semantic connection '" +
		 * conni.getName() + "'"); } else { if (srcPort instanceof FeatureGroup)
		 * { FeatureGroupType spgt = ((FeatureGroup)
		 * srcPort).getFeatureGroupType(); if (spgt != null &&
		 * !spgt.isInverseOf(((FeatureGroup) dstPort).getFeatureGroupType())) {
		 * error(conni, "Source '" + srcPort.getName() + "' and destination '" +
		 * dstPort.getName() +
		 * "' are not inverse port group types for semantic connection '" +
		 * conni.getName() + "'"); } } else { FeatureGroup srcpg = null;
		 * FeatureGroup dstpg = null; if (srcI.eContainer() instanceof
		 * FeatureInstance) { srcpg = (FeatureGroup) ((FeatureInstance)
		 * srcI.eContainer()).getFeature(); } if (dstI.eContainer() instanceof
		 * FeatureInstance) { dstpg = (FeatureGroup) ((FeatureInstance)
		 * dstI.eContainer()).getFeature(); } // TODO take care of inverse in
		 * port group type DirectionType sDir = null; DirectionType dDir = null;
		 * if (srcPort instanceof Port) { sDir = ((Port)
		 * srcPort).getDirection(srcpg); // take care of inverse in port group
		 * type } else if (srcPort instanceof Parameter) sDir = ((Parameter)
		 * srcPort).getDirection(); if (dstPort instanceof Port) { dDir =
		 * ((Port) dstPort).getDirection(dstpg); // take care of inverse in port
		 * group type } else if (dstPort instanceof Parameter) dDir =
		 * ((Parameter) dstPort).getDirection(); if (sDir != null && dDir !=
		 * null) { if (!((sDir == DirectionType.OUT && (dDir == DirectionType.IN
		 * || dDir == DirectionType.IN_OUT)) || (sDir == DirectionType.IN_OUT &&
		 * (dDir == DirectionType.IN || dDir == DirectionType.IN_OUT)))) {
		 * error(conni, "Incorrect port direction: " + sDir.getName() + " '" +
		 * srcPort.getName() + "' -> " + dDir.getName() + " '" +
		 * dstPort.getName() + "'"); } } if
		 * (!AadlUtil.matchingClassifier(srcPort.getAllClassifier(),
		 * dstPort.getAllClassifier())) { error(conni, "Source '" +
		 * srcPort.getName() + "' and destination '" + dstPort.getName() +
		 * "' port data types do not match for semantic connection '" +
		 * conni.getName() + "'"); } } }
		 */
//	}

	// ------------------------------------------------------------------------
	// Methods related to mode transition connections
	// ------------------------------------------------------------------------

	/**
	 * handles the situation that a mode transition may name an event port in a
	 * thread (or other leaf component instance) and that port is not the
	 * destination of a connection instance - it is the start of a connection
	 * instance
	 * 
	 * @param ci ComponentInstance
	 * @param fi FeatureInstance
	 * @return true if we created a ModetransitionInstance
	 */
	private boolean doModeTransitionConnections(ComponentInstance ci, FeatureInstance fi) {
		boolean didTransition = false;
		if (fi.getCategory() == FeatureCategory.EVENT_PORT) {
			Subcomponent sub = ci.getSubcomponent();
			Feature f = fi.getFeature();

			for (ModeTransitionInstance mti : ci.getContainingComponentInstance().getModeTransitionInstances()) {
				for (ModeTransitionTrigger trigger : mti.getModeTransition().getOwnedTriggers()) {
					if (trigger instanceof TriggerPort) {
						Port o = ((TriggerPort) trigger).getPort();
						Context co = ((TriggerPort) trigger).getContext();

						if (f == o && co == sub) {
							addConnectionInstance(ci.getSystemInstance(), ConnectionInfo.newModeTransition(fi), mti);
							didTransition = true;
						}
					} else {
						//TODO-LW: what if it's a processor port or internal event?
					}
				}
			}
		}
		return didTransition;
	}

	/**
	 * As we are following connection declarations we need to check whether the
	 * destination of the connection is named in one of the mode transitions of
	 * the component instance that is the destination of the connection being
	 * added
	 * 
	 * @param parentci The component that is the context in which the
	 *            connections are declared
	 * @param pci PortConnectionInstance that is being created
	 * @param conn connection being added to the ConnectionInstance
	 * @return true if we created a ModetransitionInstance
	 */
	private boolean doModeTransitionConnections(final ComponentInstance parentci, ConnectionInfo connInfo,
			Connection conn) {
		boolean didTransition = false;
		if (!(conn instanceof PortConnection || conn instanceof FeatureGroupConnection)) {
			return false;
		}
		ComponentInstance parent = null;
		Context fc = conn.getAllDestinationContext();
		Element connContext = null;
		if (fc instanceof ComponentImplementation || fc instanceof FeatureGroup) { // we
			// have
			// an
			// outgoing
			// connection
			parent = (ComponentInstance) parentci.eContainer();
			connContext = parentci.getSubcomponent();
		} else if (fc instanceof Subcomponent) {
			parent = parentci.findSubcomponentInstance((Subcomponent) fc);
			connContext = ((Subcomponent) fc).getAllClassifier();
		}
		if (parent == null) {
			return false;
		}
		EList<ModeTransitionInstance> mtl = parent.getModeTransitionInstances();
		Feature f = (Feature) conn.getAllDestination();
		for (Iterator<ModeTransitionInstance> it = mtl.iterator(); it.hasNext();) {
			ModeTransitionInstance mti = it.next();
			ModeTransition mt = mti.getModeTransition();
			Context co = null;
			for (ModeTransitionTrigger trigger : mt.getOwnedTriggers()) {
				if (trigger instanceof TriggerPort) {
					Port o = ((TriggerPort) trigger).getPort();
					co = ((TriggerPort) trigger).getContext();
					NamedElement context = co;
					if (context instanceof FeatureGroup)
						context = parent.getSubcomponent().getAllClassifier();
					if (f == o && context == connContext) {
						final ConnectionInstance mtci = addConnectionInstance(parentci.getSystemInstance(),
								connInfo.convertToModeTransition(), mti);
						fillInModes(mtci);
						fillInModeTransitions(mtci);
						didTransition = true;
					}
				} else {
					// TODO-LW: what if it's a processor port or internal event?
				}
			}
		}
		return didTransition;
	}

	// ------------------------------------------------------------------------
	// Helper methods related to modes
	// ------------------------------------------------------------------------

	private void fillInModeTransitions(ConnectionInstance conni) {
		ComponentInstance ci = conni.getContainingComponentInstance();

		for (ConnectionReference connRef : conni.getConnectionReferences()) {
			Connection conn = connRef.getConnection();

			for (ModeTransition mt : conn.getAllInModeTransitions()) {
				ModeTransitionInstance mti = ci.findModeTransitionInstance(mt);

				if (mti != null) {
					conni.getInModeTransitions().add(mti);
				}
			}
		}
	}

	/**
	 * For the given connection instance, identify all connection declarations
	 * with "in modes." For all possible mode combinations of those "in modes," add
	 * those SOMs that contain the mode instance combinations.
	 * 
	 * @param conni the connection instance
	 */
	private void fillInModes(ConnectionInstance conni) {
		ListIterator<ConnectionReference> refIter = conni.getConnectionReferences().listIterator();

		while (refIter.hasNext()) {
			ConnectionReference connRef = refIter.next();
			Connection conn = connRef.getConnection();
			ComponentInstance ci = connRef.getContext();
			EList<Mode> connModes = conn.getAllInModes();
			EList<ModeInstance> mis = null;

			if (connModes.isEmpty()) {
				while (!(ci instanceof SystemInstance)) {
					if (ci.getInModes().isEmpty()) {
						ci = ci.getContainingComponentInstance();
					} else {
						mis = ci.getInModes();
						break;
					}
				}
			} else {
				mis = new BasicEList<ModeInstance>();
				for (Mode m : connModes) {
					mis.add(ci.findModeInstance(m));
				}
			}
			if (mis != null) {
				for (ModeInstance mi : mis) {
					generateModeCombinations(conni, refIter,
							new BasicEList<ModeInstance>(Collections.singletonList(mi)));
				}
				if (conni.getInSystemOperationModes().isEmpty()) {
					warning(conni.getContainingComponentInstance(), "Connection " + conni.getName() + " was removed because it is not active in any system operation mode");
					EcoreUtil.delete(conni);
				}
				break;
			}
		}
	}

	/*
	 * 
	 * @param conni Connection Instance
	 * 
	 * @param mis the set of mode instances of modal connection declarations in
	 * the connection instance that make up a mode configuration; the complete
	 * set must be contained in the SOMs to be added to the connection instance
	 * 
	 * @param cmodes the set of modes in the inmodes declaration of the
	 * conenction declaration with index idx in the list of connection
	 * declarations that make up the connection instance
	 * 
	 * @param idx the index of the connection declaration in the connection
	 * instance whose mode set is being processed
	 */
	private void generateModeCombinations(ConnectionInstance conni, ListIterator<ConnectionReference> refIter,
			List<ModeInstance> mis) {
		if (!refIter.hasNext()) {
			// add SOMs based on mis
			SystemInstance si = (SystemInstance) conni.getElementRoot();
			List<SystemOperationMode> somList = si.getSystemOperationModesFor(mis);

			// check if all parts of the connection exist
			outer: for (SystemOperationMode som : somList) {
				if (conni.getSource().isActive(som) && conni.getDestination().isActive(som)) {
					for (ConnectionReference cr : conni.getConnectionReferences()) {
						if (!cr.getContext().isActive(som)) {
							continue outer;
						}
					}
					conni.getInSystemOperationModes().add(som);
				}
			}
		} else {
			ConnectionReference connRef = refIter.next();
			Connection conn = connRef.getConnection();
			ComponentInstance ci = connRef.getContext();
			EList<Mode> connModes = conn.getAllInModes();
			List<ModeInstance> nextMis = null;

			if (connModes.isEmpty()) {
				while (!(ci instanceof SystemInstance)) {
					if (ci.getInModes().isEmpty()) {
						ci = ci.getContainingComponentInstance();
					} else {
						nextMis = ci.getInModes();
						break;
					}
				}
			} else {
				nextMis = new BasicEList<ModeInstance>();
				for (Mode m : connModes) {
					nextMis.add(ci.findModeInstance(m));
				}
			}
			if (nextMis != null) {
				for (ModeInstance mi : nextMis) {
					mis.add(mi);
					generateModeCombinations(conni, refIter, mis);
					mis.remove(mi);
				}
			} else {
				generateModeCombinations(conni, refIter, mis);
			}
			refIter.previous();
		}
	}

	// ------------------------------------------------------------------------
	// Helper methods for filtering connection lists
	// ------------------------------------------------------------------------

	/**
	 * Filter all (port or access) connections that start with a subcomponent.
	 * 
	 * @param connlist all connections in the component instance that contains
	 *            the subcomponent
	 * @param sub a subcomponent
	 * @return the connections from connlist that start with the subcomponent
	 */
	protected List<Connection> filterStartingConnections(List<Connection> connlist, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>(connlist.size());
		EList<Subcomponent> sublist = sub.getAllSubcomponentRefinements();
		for (Connection conn : connlist) {
			if (sublist.contains(conn.getAllSource())  || (conn.isBidirectional() && sublist.contains(conn.getAllDestination()))) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Filter connections that leave a subcomponent through one of its features.
	 * 
	 * @param connlist all connections in the component instance that contains
	 *            the subcomponent
	 * @param sub a subcomponent
	 * @return those connections from connlist that go out of the subcomponent
	 */
	private List<Connection> filterOutgoingConnections(List<Connection> connlist, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>();
		List<Subcomponent> subs = sub.getAllSubcomponentRefinements();

		for (Connection conn : connlist) {
			if (subs.contains(conn.getAllSourceContext()) || conn.isBidirectional()
					&& subs.contains(conn.getAllDestinationContext())) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Filter connections that enter a subcomponent through one of its features.
	 * 
	 * @param connlist all connections in the component instance that contains
	 *            the subcomponent
	 * @param sub a subcomponent
	 * @return those connections from connlist that have a subcomponent feature
	 *         as their destination
	 */
//	private List<Connection> filterIncomingConnections(List<Connection> connlist, Subcomponent sub) {
//		List<Connection> result = new ArrayList<Connection>(connlist.size());
//		List<Subcomponent> sclist = sub.getAllSubcomponentRefinements();
//
//		for (Connection conn : connlist) {
//			if (sclist.contains(conn.getAllDestinationContext()) || conn.isBidirectional()
//					&& sclist.contains(conn.getAllSourceContext())) {
//				result.add(conn);
//			}
//		}
//		return result;
//	}

	/**
	 * get incoming connections for specified feature This method does not work
	 * on subcomponent, because we need the enclosing subcomponent rather than
	 * the enclosing component implementation in order to get the subcomponent
	 * inheritance correct Otherwise the incorrect connections get picked up
	 * 
	 * @param incomingconnlist
	 * @param feature subcomponent feature that is the destination of a
	 *            connection
	 * @return connections with feature as destination
	 */
	public List<Connection> filterIncomingConnections(List<Connection> incomingconnlist, Feature feature) {
		List<Connection> result = new ArrayList<Connection>(incomingconnlist.size());
		List<Feature> featurel = feature.getAllFeatureRefinements();

		for (Connection conn : incomingconnlist) {
			if (featurel.contains(conn.getAllDestination()) || conn.isBidirectional()
					&& featurel.contains(conn.getAllSource())) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Get outgoing connections for specified feature port group connections are
	 * non-directional, i.e., they are always added
	 * 
	 * @param conns a list of connections that go away from a subcomponent
	 * @param feature subcomponent feature that can be the source of a
	 *            connection
	 * @return connections with feature as source for ConnectionInstances
	 */
	public List<Connection> filterOutgoingConnections(List<Connection> conns, Feature feature) {
		List<Connection> result = new ArrayList<Connection>(conns.size());
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			if (features.contains(conn.getAllSource()) || conn.isBidirectional()
					&& features.contains(conn.getAllDestination()))
				result.add(conn);
		}
		return result;
	}

	/**
	 * Get outgoing connections for specified feature port group connections are
	 * non-directional, i.e., they are always added
	 * 
	 * @param conns a list of connections that go away from a subcomponent
	 * @param feature subcomponent feature that can be the source of a
	 *            connection
	 * @return connections with feature as source for ConnectionInstances
	 */
	public List<Connection> filterOutgoingConnections(List<Connection> conns, Feature feature, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>(conns.size());
		List<Feature> features = feature.getAllFeatureRefinements();
		EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
		for (Connection conn : conns) {
			if ((features.contains(conn.getAllSource()) && subs.contains(conn.getAllSourceContext()))
					|| (conn.isBidirectional() && features.contains(conn.getAllDestination()) && subs.contains(conn
							.getAllDestinationContext())))
				result.add(conn);
		}
		return result;
	}

	/**
	 * Check if one of the connections in a list points to a feature.
	 * 
	 * @param conns a list of connections owned by a subcomponent
	 * @param feature a subcomponent feature
	 * @return whether one of the connections points to the feature
	 */
	public boolean isDestination(List<Connection> conns, Feature feature) {
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			if (features.contains(conn.getAllDestination()) || conn.isBidirectional()
					&& features.contains(conn.getAllSource())) {
				return true;
			}
			if ((features.contains(conn.getAllDestinationContext()) || conn.isBidirectional()
					&& features.contains(conn.getAllSourceContext()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if one of the connections in a list has a feature as its end.
	 * 
	 * @param conns a list of connections owned by a subcomponent
	 * @param feature a subcomponent feature
	 * @return whether the feature is an end of one of the connections
	 */
	public boolean isConnectionEnd(List<Connection> conns, Feature feature) {
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			if (features.contains(conn.getAllDestination()) || features.contains(conn.getAllSource()))
				return true;
			if ((features.contains(conn.getAllDestinationContext()) || features.contains(conn.getAllSourceContext())))
				return true;
		}
		return false;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean isConnectionEndingComponent(final Context ctx) {
		return ctx instanceof ThreadSubcomponent || ctx instanceof DeviceSubcomponent;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean isValidFinalComponent(final Context ctx) {
		return ctx instanceof ThreadSubcomponent || ctx instanceof DeviceSubcomponent
				|| ctx instanceof ProcessorSubcomponent || ctx instanceof VirtualProcessorSubcomponent;
	}

}
