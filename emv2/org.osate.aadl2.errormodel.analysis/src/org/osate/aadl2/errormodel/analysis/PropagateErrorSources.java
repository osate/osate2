/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR conditi-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.errormodel.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Connection;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd;
import org.osate.aadl2.errormodel.PropagationGraph.util.Util;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OrmoreExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.util.EMSUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelState;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelStateAdapterFactory;

import com.google.common.collect.HashMultimap;

/**
 * This class initiates a fault impact analysis starting with error sources.
 * The level of impact analysis (how deep) can be set as parameter (with a default of 7)
 * @author phf
 */
public class PropagateErrorSources {
	protected WriteToFile report;
	protected PropagationGraph faultModel;
	protected Collection<EObject> visited;
	protected int maxLevel = 7;
	private Map<ComponentInstance, List<String>> alreadyTreated;

	public PropagateErrorSources(String reportType, ComponentInstance root) {
		report = new WriteToFile(reportType, root);
		faultModel = Util.generatePropagationGraph(root, false);
		visited = new HashSet<EObject>();
		alreadyTreated = new HashMap<ComponentInstance, List<String>>();

	}

	public PropagateErrorSources(String reportType, ComponentInstance root, int maxLevel) {
		this(reportType, root);
		this.maxLevel = maxLevel;
	}

	public void setMaxDepth(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public Collection<ComponentInstance> getSubcomponents() {
		return faultModel.getComponents();
	}

	public void addText(String text) {
		if (report != null) {
			report.addOutput(text);
		}
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void addTextNewline(String text) {
		if (report != null) {
			report.addOutputNewline(text);
		}
	}

	public void addNewline() {
		if (report != null) {
			report.addOutputNewline("");
		}
	}

	public void saveReport() {
		report.saveToFile();
	}

	public void reportTableHeading() {
		report.addOutput("Component, Initial Failure Mode, 1st Level Effect");
		for (int i = 2; i <= maxLevel; i++) {
			report.addOutput(", Failure Mode, " + (i == 2 ? "second" : i == 3 ? "third" : Integer.toString(i) + "th")
					+ " Level Effect");
		}
		report.addOutputNewline(", More");
	}

	public void reportExternalTableHeading() {
		report.addOutput("Root System, External Error Source, 1st Level Effect");
		for (int i = 2; i <= maxLevel; i++) {
			report.addOutput(", Failure Mode, " + (i == 2 ? "second" : i == 3 ? "third" : Integer.toString(i) + "th")
					+ " Level Effect");
		}
		report.addOutputNewline(", More");
	}

	public void reportImpactHeading() {
		report.addOutputNewline("Fault Impact of System Internal Error Sources\n");
	}

	public void reportExternalImpactHeading() {
		report.addOutputNewline("\n\nFault Impact of System External Error Sources\n");
	}

	/**
	 * Put an entry into the report based on the prefix, entryText and any postfix processing based on level
	 * @param entryText String assumed to provide any comma before each entry
	 * @param curLevel last level reported
	 */
	public void reportEntry(String entryText, int curLevel) {
		report.addOutputNewline(entryText);
	}

	private void processTransition(ComponentInstance ci, ErrorBehaviorEvent event, TypeToken eventtype,
			ErrorBehaviorTransition trans, ConditionElement conditionElement, String componentText,
			HashMultimap<ErrorPropagation, String> handledPropagations) {
		EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(conditionElement);
		TypeSet constraint = conditionElement.getConstraint();
		if (eop instanceof ErrorPropagation) {
			return;
		}
		if (eop.getName().equalsIgnoreCase(event.getName())) {
			// match the event
			if (eventtype != null && constraint != null && !EMV2TypeSetUtil.contains(constraint, eventtype)) {
				return;
			}
			ErrorBehaviorState targetstate = trans.getTarget();
			TypeSet statetype = null;
			if (targetstate.getTypeSet() != null) {
				statetype = trans.getTargetToken();
			}
			// we have the state and possibly a type
			for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(ci)) {
				if (EMV2TypeSetUtil.isNoError(opc.getTypeToken()) || opc.getCondition() != null) {
					continue;
				}
				if (opc.isAllStates() || (opc.getState() != null
						&& targetstate.getName().equalsIgnoreCase(opc.getState().getName()))) {
					// either typeless state or type is contained in opc type constraint on state
					TypeSet statetypeconstraint = opc.getTypeTokenConstraint();
					if (statetypeconstraint == null || statetype == null
							|| EMV2TypeSetUtil.contains(statetypeconstraint, statetype)) {
						ErrorTypes outtype = opc.getTypeToken();
						if (outtype == null) {
							outtype = statetype;
						}
						if (opc.isAllPropagations()) {
							Collection<ErrorPropagation> oeps = EMV2Util
									.getAllOutgoingErrorPropagations(ci.getComponentClassifier());
							for (ErrorPropagation ep : oeps) {
								if (outtype == null) {
									if (eventtype != null) {
										traceErrorPaths(ci, ep, eventtype, 2, componentText + ", " + "error event "
												+ event.getName() + EMV2Util.getPrintName(eventtype));
										handledPropagations.put(ep, EMV2Util.getPrintName(eventtype));
									}
								} else {
									EList<TypeToken> result = EMV2TypeSetUtil
											.generateAllLeafTypeTokens((TypeSet) outtype, EMV2Util.getUseTypes(opc));
									for (TypeToken tt : result) {
										traceErrorPaths(ci, ep, tt, 2, componentText + ", " + "error event "
												+ event.getName() + EMV2Util.getPrintName(eventtype));
										handledPropagations.put(ep, EMV2Util.getPrintName(tt));
									}
								}
							}
						} else {
							ErrorPropagation ep = opc.getOutgoing();
							if (outtype == null) {
								if (eventtype != null) {
									traceErrorPaths(ci, ep, eventtype, 2, componentText + ", " + "error event "
											+ event.getName() + EMV2Util.getPrintName(eventtype));
									handledPropagations.put(ep, EMV2Util.getPrintName(eventtype));
								}
							} else {
								EList<TypeToken> result = EMV2TypeSetUtil.generateAllLeafTypeTokens((TypeSet) outtype,
										EMV2Util.getUseTypes(opc));
								for (TypeToken tt : result) {
									traceErrorPaths(ci, ep, tt, 2, componentText + ", " + "error event "
											+ event.getName() + EMV2Util.getPrintName(eventtype));
									handledPropagations.put(ep, EMV2Util.getPrintName(tt));
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * traverse error flow if the component instance is an error source
	 * @param ci component instance
	 */
	public void startErrorFlows(ComponentInstance ci) {
		Collection<ErrorSource> eslist = EMV2Util.getAllErrorSources(ci.getComponentClassifier());
		String componentText = ci.getComponentInstancePath();
		HashMultimap<ErrorPropagation, String> handledPropagations = HashMultimap.create();
		for (ErrorBehaviorEvent event : EMV2Util.getAllErrorBehaviorEvents(ci)) {
			if (!(event instanceof ErrorEvent) || !Util.conditionHolds((ErrorEvent) event, ci)) {
				continue;
			}
			TypeSet sourcetype = ((ErrorEvent) event).getTypeSet();
			if (sourcetype == null) {
				// no type on event
				for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(ci)) {
					if (trans.getCondition() instanceof ConditionElement) {
						ConditionElement conditionElement = (ConditionElement) trans.getCondition();
						processTransition(ci, event, null, trans, conditionElement, componentText, handledPropagations);
					} else if (trans.getCondition() instanceof OrmoreExpression) {
						EList<ConditionExpression> elems = ((OrmoreExpression) trans.getCondition()).getOperands();
						for (ConditionExpression conditionExpression : elems) {
							if (conditionExpression instanceof ConditionElement) {
								ConditionElement conditionElement = (ConditionElement) conditionExpression;
								processTransition(ci, event, null, trans, conditionElement, componentText,
										handledPropagations);
							}
						}
					} else if (trans.getCondition() instanceof OrExpression) {
						EList<ConditionExpression> elems = ((OrExpression) trans.getCondition()).getOperands();
						for (ConditionExpression conditionExpression : elems) {
							if (conditionExpression instanceof ConditionElement) {
								ConditionElement conditionElement = (ConditionElement) conditionExpression;
								processTransition(ci, event, null, trans, conditionElement, componentText,
										handledPropagations);
							}
						}
					}
				}
			} else {
				EList<TypeToken> tokens = EMV2TypeSetUtil.generateAllLeafTypeTokens(((ErrorEvent) event).getTypeSet(),
						EMV2Util.getUseTypes(event));
				for (TypeToken typeToken : tokens) {
					for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(ci)) {
						// TODO do expressions other than a single error event
						// the only one that makes sense is an or of error events
						if (trans.getCondition() instanceof ConditionElement) {
							ConditionElement conditionElement = (ConditionElement) trans.getCondition();
							processTransition(ci, event, typeToken, trans, conditionElement, componentText,
									handledPropagations);
						} else if (trans.getCondition() instanceof OrmoreExpression) {
							EList<ConditionExpression> elems = ((OrmoreExpression) trans.getCondition()).getOperands();
							for (ConditionExpression conditionExpression : elems) {
								if (conditionExpression instanceof ConditionElement) {
									ConditionElement conditionElement = (ConditionElement) conditionExpression;
									processTransition(ci, event, typeToken, trans, conditionElement, componentText,
											handledPropagations);
								}
							}
						} else if (trans.getCondition() instanceof OrExpression) {
							EList<ConditionExpression> elems = ((OrExpression) trans.getCondition()).getOperands();
							for (ConditionExpression conditionExpression : elems) {
								if (conditionExpression instanceof ConditionElement) {
									ConditionElement conditionElement = (ConditionElement) conditionExpression;
									processTransition(ci, event, typeToken, trans, conditionElement, componentText,
											handledPropagations);
								}
							}
						}
					}
				}
			}
		}
		for (ErrorSource errorSource : eslist) {
			if (!Util.conditionHolds(errorSource, ci)) {
				continue;
			}
			EMSUtil.unsetAll(ci.getSystemInstance());
			Collection<ErrorPropagation> eplist = EMV2Util.getOutgoingPropagationOrAll(errorSource);
			TypeSet ts = errorSource.getTypeTokenConstraint();
			ErrorBehaviorState failureMode = errorSource.getFailureModeReference();
			TypeSet failureTypeSet = null;
			if (failureMode != null) {
				failureTypeSet = failureMode.getTypeSet();
			} else {
				// reference to named type set
				// or type set constructor
				failureTypeSet = errorSource.getFailureModeType();
			}
			String failuremodeDesc = errorSource.getFailureModeDescription();
			for (ErrorPropagation ep : eplist) {
				TypeSet tsep = ep.getTypeSet();
				if (ts != null || tsep != null) {
					EList<TypeToken> result = ts != null ? ts.getTypeTokens() : tsep.getTypeTokens();
					for (TypeToken typeToken : result) {
						String failuremodeText;
						if (handledPropagations.containsEntry(ep, EMV2Util.getPrintName(typeToken))) {
							continue;
						}
						if (failuremodeDesc == null) {
							failuremodeText = generateOriginalFailureModeText(failureMode != null ? failureMode
									: (failureTypeSet != null ? failureTypeSet : typeToken));
						} else {
							failuremodeText = failuremodeDesc;
						}
						traceErrorPaths(ci, ep, typeToken, 2, componentText + "," + failuremodeText);
					}
				}
			}
		}

	}

	/**
	 * Start with an external incoming error propagation as source
	 * @param ci component instance
	 */
	public void startExternalFlows(ComponentInstance root) {
		Collection<ErrorPropagation> eplist = EMV2Util.getAllIncomingErrorPropagations(root.getComponentClassifier());
		String componentText = generateComponentInstanceText(root);
		if (eplist.isEmpty()) {
			return;
		}
		reportExternalImpactHeading();
		reportExternalTableHeading();
		for (ErrorPropagation ep : eplist) {
			EMSUtil.unsetAll(root);
			TypeSet tsep = ep.getTypeSet();
			if (tsep != null) {
				EList<TypeToken> result = tsep.getTypeTokens();
				// XXX use this if we want all leaf types: EM2TypeSetUtil.generateAllLeafTypeTokens(tsep,EMV2Util.getContainingTypeUseContext(errorSource));
				for (TypeToken typeToken : result) {
					String failuremodeText = generateErrorPropTypeTokenText(ep, typeToken);
					traceErrorPaths(root, ep, typeToken, 2, componentText + ", " + failuremodeText);
				}
			}
		}
	}

	/**
	 * Start with the source of a connection instance
	 * @param ci component instance
	 */
	public void startConnectionSourceFlows(ComponentInstance root) {
		Collection<ErrorSource> ceslist = EMV2Util.getAllConnectionErrorSources(root.getComponentClassifier());
		if (ceslist.isEmpty()) {
			return;
		}
		for (ErrorSource ces : ceslist) {
			if (!Util.conditionHolds(ces, root)) {
				continue;
			}
			EMSUtil.unsetAll(root.getSystemInstance());
			// find connection instances that this connection is part of
			String connName = ces.getSourceModelElement().getName();
			ConnectionInstance conni = InstanceUtil.findConnectionInstance(root,
					(Connection) ces.getSourceModelElement());
			EList<PropagationPathEnd> ends = Util.getAllPropagationDestinationEnds(faultModel, conni);
			if (ends.size() == 0) {
				return;
			}
			PropagationPathEnd ppe = ends.get(0);
			ErrorPropagation destEP = ppe.getErrorPropagation();
			ComponentInstance destci = ppe.getComponentInstance();
			TypeSet fmType = ces.getFailureModeType();
			String failuremodeDesc = ces.getFailureModeDescription();
			TypeSet tsep = ces.getTypeTokenConstraint();
			EList<TypeToken> result = tsep.getTypeTokens();
			// XXX use this if we want all leaf types: EM2TypeSetUtil.generateAllLeafTypeTokens(tsep,EMV2Util.getContainingTypeUseContext(errorSource));
			for (TypeToken typeToken : result) {
				String failuremodeText;
				if (failuremodeDesc == null) {
					failuremodeText = generateOriginalFailureModeText(fmType != null ? fmType : typeToken);
				} else {
					failuremodeText = failuremodeDesc;
				}
				String effectText = generateOriginalFailureModeText(typeToken);

				String connText = generateComponentPropagationPointText(destci, destEP);
				traceErrorFlows(destci, destEP, typeToken, 0,
						"Connection " + connName + "," + failuremodeText + "," + effectText + " -> " + connText);
			}
		}
	}

	/**
	 * get the text to be used for the item (Component or feature)
	 * that is the source of a failure mode
	 * @param ci component instance
	 * @return String
	 */
	public String generateConnectionInstanceEndText(ConnectionInstanceEnd io) {
		if (io instanceof FeatureInstance) {
			FeatureInstance fi = (FeatureInstance) io;
			ComponentInstance ci = fi.getContainingComponentInstance();
			String finame = fi.getQualifiedName();
			return ci.getQualifiedName() + ":" + finame;
		}
		if (io instanceof ComponentInstance) {
			return generateComponentInstanceText((ComponentInstance) io);
		} else {
			return io.getName();
		}
	}

	/**
	 * get the text to be used for the item (Component or system instance)
	 * that is the source of a failure mode
	 * @param ci component instance
	 * @return String
	 */
	public String generateComponentInstanceText(ComponentInstance io) {
		if (io instanceof SystemInstance) {
			return io.getName();
//			SystemImplementation simpl = ((SystemInstance)io).getSystemImplementation();
//			return simpl.getName();
		} else {
			return io.getComponentInstancePath();
		}
	}

	/**
	 * get the text for the failure mode
	 * @param io Error State or Type token
	 * @return String
	 */
	public String generateOriginalFailureModeText(EObject io) {
		if (io instanceof ErrorBehaviorState) {
			ErrorBehaviorState ev = (ErrorBehaviorState) io;
			return ev.getName();
		} else if (io instanceof TypeToken) {
			return EMV2Util.getPrintName((TypeToken) io);
		} else if (io instanceof TypeSet) {
			return "\"" + EMV2Util.getPrintName((TypeSet) io) + "\"";
		} else {
			return "NoError";
		}
	}

	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateComponentPropagationPointText(ComponentInstance io, ErrorPropagation ep) {
		return (generateComponentInstanceText(io) + (ep != null ? ":" + EMV2Util.getPrintName(ep) : ""));
	}

	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateComponentPropagationPointTypeTokenText(ComponentInstance io, ErrorPropagation ep,
			TypeToken tt) {
		return (generateComponentInstanceText(io) + (ep != null ? ":" + EMV2Util.getPrintName(ep) : "")
				+ (tt != null ? " " + EMV2Util.getPrintName(tt) : ""));
	}

	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateErrorPropTypeTokenText(ErrorPropagation ep, TypeToken tt) {
		return ((ep != null ? EMV2Util.getPrintName(ep) : "") + (tt != null ? " " + EMV2Util.getPrintName(tt) : ""));
	}

	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateTypeTokenErrorPropText(ErrorPropagation ep, TypeToken tt) {
		return ((tt != null ? EMV2Util.getPrintName(tt) : "") + (ep != null ? " " + EMV2Util.getPrintName(ep) : ""));
	}

	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param ep Error Propagation
	 */
	public String generateErrorPropTypeSetText(ErrorPropagation ep) {
		if (ep == null) {
			return "";
		}
		TypeSet ts = ep.getTypeSet();
		return ((EMV2Util.getPrintName(ep)) + (ts != null ? " " + EMV2Util.getPrintName(ts) : ""));
	}

	/**
	 * report on Failure mode.
	 * note: error propagation ep can be null.
	 * @param ci Instance Object
	 * @param ep Error Propagation
	 */
	public String generateFailureModeText(ComponentInstance ci, ErrorPropagation ep, TypeToken tt) {
		return ci.getComponentInstancePath() + (tt != null ? " " + EMV2Util.getPrintName(tt) : "");
	}

	/**
	 * report on ci object with optional error propagation.
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateComponentErrorPropText(ComponentInstance ci, ErrorPropagation ep, TypeToken tt) {
		return generateComponentInstanceText(ci) + ":" + generateErrorPropTypeTokenText(ep, tt);
	}

	/**
	 * report on ci object with optional error propagation.
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateComponentTypeTokenText(ComponentInstance ci, TypeToken tt) {
		return generateComponentInstanceText(ci) + ":" + (tt != null ? " " + EMV2Util.getPrintName(tt) : "");
	}

	/**
	 * traverse to the destination of the propagation path
	 * @param conni
	 */
	protected void traceErrorPaths(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, int depth,
			String entryText) {
		ErrorModelState st = null;
		FeatureInstance fi = EMV2Util.findFeatureInstance(ep, ci);
		if (fi != null) {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(fi, ErrorModelState.class);
		} else {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(ci, ErrorModelState.class);
		}
		if (st.visited(ep, tt)) {
			// we were there before.
			String effectText = "," + generateTypeTokenErrorPropText(ep, tt);
			reportEntry(entryText + effectText + " -> [Propagation Cycle],,", depth);
			return;
		} else {
			st.setVisitToken(ep, tt);
		}
		EList<PropagationGraphPath> paths = Util.getAllPropagationPaths(faultModel, ci, ep);
		String effectText = "," + generateTypeTokenErrorPropText(ep, tt);
		if (paths.isEmpty()) {
			if (fi != null) {
				EList<ConnectionInstance> conns = fi.getSrcConnectionInstances();
				if (conns.isEmpty()) {
					reportEntry(entryText + effectText + " -> [No Outgoing Connection],,", depth);
				} else {
					for (ConnectionInstance connectionInstance : conns) {
						reportEntry(entryText + "," + (tt != null ? EMV2Util.getPrintName(tt) + " " : "")
								+ connectionInstance.getName() + "[No In Propagation],,", depth);
					}
				}
			} else if (EMV2Util.getPropagationPoint(ep) != null) {
				reportEntry(entryText + effectText + " -> [No Propagation Point Connection],,", depth);
			} else if (ep.getKind() != null) {
				reportEntry(entryText + effectText + " -> [No Binding],,", depth);
			} else {
				reportEntry(entryText + effectText + " -> [Could not find propagation feature],,", depth);
			}
		} else {
			for (PropagationGraphPath path : paths) {
				ConnectionInstance pathConni = path.getConnection();
				TypeMappingSet typeEquivalence = EMV2Util
						.getAllTypeEquivalenceMapping(ci.getContainingComponentInstance());
				TypeToken mappedtt = tt;
				TypeToken resulttt = tt;
				TypeToken xformedtt = tt;
				if (typeEquivalence != null) {
					mappedtt = EMV2TypeSetUtil.mapTypeToken(tt, typeEquivalence);
					if (mappedtt != null) {
						resulttt = mappedtt;
					}
				}
				if (pathConni != null) {
					// find the connection transformation rules if we have a connection path
					ComponentInstance contextCI = pathConni.getComponentInstance();
					TypeTransformationSet tts = EMV2Util.getAllTypeTransformationSet(contextCI);
					// TODO find contributor type token by looking for the state/out prop type.
					if (tts != null) {
						xformedtt = EMV2TypeSetUtil.mapTypeToken(tt, null, tts);
						if (xformedtt == null && mappedtt != null) {
							xformedtt = EMV2TypeSetUtil.mapTypeToken(mappedtt, null, tts);
						}
						if (xformedtt != null) {
							resulttt = xformedtt;
						}
					}
				}
				EList<PropagationPathEnd> dstEnds;
				ConnectionInstance dstConni = path.getPathDst().getConnectionInstance();
				String connSymbol = " -> ";
				if (dstConni != null) {
					// we have a connection binding path with a connection instance as target
					dstEnds = Util.getAllPropagationDestinationEnds(faultModel, dstConni);
					connSymbol = " -Conn-> ";
					// find the connection transformation rules
					ComponentInstance contextCI = dstConni.getComponentInstance();
					TypeTransformationSet tts = EMV2Util.getAllTypeTransformationSet(contextCI);
					// TODO find source type token by looking for the state/out prop type.
					if (tts != null) {
						xformedtt = EMV2TypeSetUtil.mapTypeToken(null, tt, tts);
						if (xformedtt == null && mappedtt != null) {
							xformedtt = EMV2TypeSetUtil.mapTypeToken(null, mappedtt, tts);
						}
						if (xformedtt != null) {
							resulttt = xformedtt;
						}
					}
				} else {
					dstEnds = new BasicEList<PropagationPathEnd>();
					dstEnds.add(path.getPathDst());
				}
				for (PropagationPathEnd propagationPathEnd : dstEnds) {
					ComponentInstance destci = propagationPathEnd.getComponentInstance();
					ErrorPropagation destEP = propagationPathEnd.getErrorPropagation();
					TypeSet dstTS = destEP.getTypeSet();
					TypeToken targettt = null;
					if (tt != null && EMV2TypeSetUtil.contains(dstTS, tt)) {
						targettt = tt;
					} else if (mappedtt != null && EMV2TypeSetUtil.contains(dstTS, mappedtt)) {
						targettt = mappedtt;
					} else if (xformedtt != null && EMV2TypeSetUtil.contains(dstTS, xformedtt)) {
						targettt = xformedtt;
					}
					if (targettt == null) {
						// type token or mapped/xformed type token is not contained in incoming EP
						String connText = connSymbol
								+ generateComponentPropagationPointTypeTokenText(destci, destEP, resulttt)
								+ " [Unhandled Type]";
						reportEntry(entryText + effectText + connText, depth);
					} else if (destci instanceof SystemInstance) {
						// we have an external propagation (out only connection)
						String connText = connSymbol + generateComponentPropagationPointText(destci, destEP)
								+ " [External Effect]";
						reportEntry(entryText + effectText + connText, depth);
					} else if (pathConni != null && Aadl2InstanceUtil.outOnly(pathConni) && !pathConni.isComplete()) {
						// outgoing only, but not ending at root
						String connText = connSymbol + generateComponentPropagationPointText(destci, destEP)
								+ " [External Effect]";
						reportEntry(entryText + effectText + connText, depth);
					} else if (destci != null && destEP != null) {
						String connText = connSymbol + generateComponentPropagationPointText(destci, destEP);
						traceErrorFlows(destci, destEP, targettt, depth, entryText + effectText + connText);
					}
				}
			}
		}
		st.removeVisitedToken(ep, tt);

	}

	/**
	 * traverse through the destination of the connection instance
	 * @param conni
	 */
	protected void traceErrorFlows(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, int depth,
			String entryText) {
		if (ci == null) {
			return;
		}
		/**
		 * With alreadyTreated, we have a cache that keep track of existing report
		 * text for each component. For each component, we maintain a list of existing
		 * entryText already reported. So, we do not duplicate the error report for each component
		 * and make sure to report each entry only once.
		 */
		if (!alreadyTreated.containsKey(ci)) {
			alreadyTreated.put(ci, new ArrayList<String>());
		}
		if (alreadyTreated.get(ci).contains(entryText)) {
			return;
		}

		alreadyTreated.get(ci).add(entryText);
		boolean handled = false;
		Collection<ErrorFlow> outefs = EMV2Util.findErrorFlowFromComponentInstance(ci, ep);
		for (ErrorFlow ef : outefs) {
			if (ef instanceof ErrorSink && Util.conditionHolds(ef, ci)) {
				/**
				 * We try to find additional error propagation for this error sink.
				 * For example, if the error sink triggers to switch to
				 * another behavior state and that states is used to propagate
				 * an error through an error source. Then, we do not consider
				 * it as an error sink but as an error path and continue
				 * to trace the flow using this additional error propagation.
				 */
				if (EMV2TypeSetUtil.contains(ef.getTypeTokenConstraint(), tt)) {
					String maskText = ", " + generateFailureModeText(ci, ep, tt) + " [Masked],";
					reportEntry(entryText + maskText, depth);
					handled = true;
				} else {
					Collection<TypeToken> intersection = EMV2TypeSetUtil
							.getConstrainedTypeTokens(ef.getTypeTokenConstraint(), tt);
					for (TypeToken typeToken : intersection) {
						String maskText = ", " + generateFailureModeText(ci, ep, typeToken) + " [Masked],";
						reportEntry(entryText + maskText, depth);
						handled = true;
					}
				}
			} else if (ef instanceof ErrorPath) { // error path
				Collection<ErrorPropagation> eplist = EMV2Util.getOutgoingPropagationOrAll((ErrorPath) ef);
				ErrorPropagation inep = ((ErrorPath) ef).getIncoming();
				if (ef.getTypeTokenConstraint() != null ? EMV2TypeSetUtil.contains(ef.getTypeTokenConstraint(), tt)
						: (inep != null ? EMV2TypeSetUtil.contains(inep.getTypeSet(), tt)
								: ((ErrorPath) ef).isAllIncoming())) {
					TypeToken newtt = EMV2Util.mapToken(tt, ef);
					for (ErrorPropagation outp : eplist) {
						traceErrorPaths(ci, outp, newtt, depth + 1,
								entryText + ", " + generateFailureModeText(ci, ep, tt));
						handled = true;
					}
				} else {
					Collection<TypeToken> intersection = Collections.emptyList();
					TypeSet ts = null;
					if (ef.getTypeTokenConstraint() != null) {
						ts = ef.getTypeTokenConstraint();
					} else if (inep != null) {
						ts = inep.getTypeSet();
					}
					if (ts != null) {
						intersection = EMV2TypeSetUtil.getConstrainedTypeTokens(ts, tt);
					}
					for (TypeToken typeToken : intersection) {
						TypeToken newtt = EMV2Util.mapToken(typeToken, ef);
						for (ErrorPropagation outp : eplist) {
							traceErrorPaths(ci, outp, newtt, depth + 1,
									entryText + ",\"" + generateFailureModeText(ci, ep, typeToken) + " [Subtype]\"");
							handled = true;
						}
					}
				}
			}
		}
		if (!handled) {
			// no error flows:. and no flows condition
			// try flows or propagate to all outgoing error propagations
			EList<FlowSpecificationInstance> flowlist = ci.getFlowSpecifications();
			if (!flowlist.isEmpty()) {
				for (FlowSpecificationInstance flowSpecificationInstance : flowlist) {
					if (flowSpecificationInstance.getSource() != null && flowSpecificationInstance.getSource()
							.getFeature() == EMV2Util.getErrorPropagationFeature(ep, ci)) {
						FeatureInstance outfi = flowSpecificationInstance.getDestination();
						if (outfi != null) {
							ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(outfi);
							if (outp != null) {
								TypeToken newtt = EMV2Util.mapToken(tt, flowSpecificationInstance);
								if (EMV2TypeSetUtil.contains(outp.getTypeSet(), newtt)) {
									traceErrorPaths(ci, outp, newtt, depth + 1,
											entryText + ", " + generateFailureModeText(ci, ep, tt) + " [FlowPath]");
									handled = true;
								} else {
									Collection<TypeToken> intersection = EMV2TypeSetUtil
											.getConstrainedTypeTokens(outp.getTypeSet(), newtt);
									for (TypeToken typeToken : intersection) {
										traceErrorPaths(ci, outp, typeToken, depth + 1, entryText + ", "
												+ generateFailureModeText(ci, ep, tt) + " [FlowPath TypeSubset]");
										handled = true;
									}
								}
							}
						} else {
							// do all since we have a flow sink
							EList<FeatureInstance> filist = ci.getFeatureInstances();
							boolean res = doAllOutPropagationsOrFeatures(ci, filist, ep, tt, depth, entryText);
							if (res) {
								handled = true;
							}
						}
					}
				}
			} else {
				// now all outgoing propagations or features since we did not find flows
				EList<FeatureInstance> filist = ci.getFeatureInstances();
				boolean res = doAllOutPropagationsOrFeatures(ci, filist, ep, tt, depth, entryText);
				if (res) {
					handled = true;
				}
			}
		}
		if (!handled) {
			String errorText = "," + generateFailureModeText(ci, ep, tt) + " [Unhandled Failure Effect]";
			reportEntry(entryText + errorText, depth);
		}
	}

	protected boolean doAllOutPropagationsOrFeatures(ComponentInstance ci, EList<FeatureInstance> filist,
			ErrorPropagation ep, TypeToken tt, int depth, String entryText) {
		boolean handled = false;

		for (FeatureInstance fi : filist) {

			if (fi.getFlowDirection().outgoing())

			{
				ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(fi);
				if (outp != null) {
					TypeToken newtt = EMV2Util.mapToken(tt, null);
					if (EMV2TypeSetUtil.contains(outp.getTypeSet(), newtt)) {
						traceErrorPaths(ci, outp, newtt, depth + 1,
								entryText + "," + generateFailureModeText(ci, ep, tt) + " [All Out Props]");
						handled = true;
					} else {
						Collection<TypeToken> intersection = EMV2TypeSetUtil.getConstrainedTypeTokens(outp.getTypeSet(),
								newtt);
						if (intersection.isEmpty()) {
							String errorText = ",\"" + generateFailureModeText(ci, outp, newtt)
									+ " [Not in type constraint " + EMV2Util.getPrintName(outp.getTypeSet()) + " ]\"";
							reportEntry(entryText + errorText, depth);
							handled = true;
						} else {
							for (TypeToken typeToken : intersection) {
								traceErrorPaths(ci, outp, typeToken, depth + 1,
										entryText + "," + generateFailureModeText(ci, ep, tt) + " [All Out Subtype]");
								handled = true;
							}
						}
					}
				} else {
					if (!fi.getFeatureInstances().isEmpty()) {
						boolean res = doAllOutPropagationsOrFeatures(ci, fi.getFeatureInstances(), ep, tt, depth,
								entryText);
						if (res) {
							handled = true;
						} else {
							// report only for the top feature instance
							if (fi.getOwner() instanceof ComponentInstance) {
								String errorText = "," + generateFailureModeText(ci, outp, tt)
										+ " [No feature with out propagation ]";
								reportEntry(entryText + errorText, depth);
							}
						}
					}
				}
			}
		}
		return handled;
	}
}
