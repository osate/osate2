/*
 * <copyright>
 * Copyright  2012-2013 by Carnegie Mellon University, all rights reserved.
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
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.errormodel.analysis.actions;

/**
 * Also, this class implement the following consistency rule from
 * the official documentation:
 * C1, C5, C7, C11, C12
 *
 */
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.impl.ConnectedElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathRecord;

public final class ConsistencyAction extends AaxlReadOnlyActionAsJob {
	AnalysisModel model;

	@Override
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.FaultImpactMarker";
	}

	@Override
	protected String getActionName() {
		return "Consistency";
	}

	@Override
	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		monitor.beginTask("ConsistencyCheck", IProgressMonitor.UNKNOWN);

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject) {
			si = ((InstanceObject) obj).getSystemInstance();
		} else {
			return;
		}

		setCSVLog("Consistency", si);
		model = new AnalysisModel(si);
		Collection<PropagationPathRecord> pathlist = model.getPropagationPaths();
		for (PropagationPathRecord path : pathlist) {
			checkPropagationPathErrorTypes(path);
		}
		for (ComponentInstance ci : EMV2Util.getComponentInstancesWithEMV2Subclause(si)) {
			checkComponent(ci, model);
		}
		monitor.done();
	}

	protected void processMatchingErrorPropagation(ConnectionInstance connectionInstance) {
		EList<ConnectionReference> connrefs = connectionInstance.getConnectionReferences();
		ErrorPropagation srcprop = null;
		ErrorPropagation dstprop = null;
		ErrorPropagation srccontain = null;
		ErrorPropagation dstcontain = null;
		for (ConnectionReference connectionReference : connrefs) {
			ConnectionInstanceEnd src = connectionReference.getSource();
			ConnectionInstanceEnd dst = connectionReference.getDestination();
			if (srcprop == null && src instanceof FeatureInstance) {
				srcprop = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) src);
			}
			if (srccontain == null && src instanceof FeatureInstance) {
				srccontain = EMV2Util.getOutgoingErrorContainment((FeatureInstance) src);
			}
			// determine outgoing and find outgoing. if incoming then incoming.
			// once matched, make dst the source and look for the next dst with prop/containment
//			connectionReference.getConnection().ge
			if (dst instanceof FeatureInstance) {
				ErrorPropagation founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance) dst);
				if (founddst != null) {
					dstprop = founddst;
				}
			}
			if (dst instanceof FeatureInstance) {
				ErrorPropagation founddst = EMV2Util.getIncomingErrorContainment((FeatureInstance) dst);
				if (founddst != null) {
					dstcontain = founddst;
				}
			}
		}
		if (srcprop != null & dstprop != null) {
			// need to check whether all error types are handled by the destination
			checkConnectionErrorTypes(connectionInstance, srcprop, srccontain, dstprop, dstcontain);
		}
		if (connectionInstance.isBidirectional()) {
			srcprop = null;
			dstprop = null;
			srccontain = null;
			dstcontain = null;
			for (ConnectionReference connectionReference : connrefs) {
				ConnectionInstanceEnd src = connectionReference.getSource();
				ConnectionInstanceEnd dst = connectionReference.getDestination();
				if (srcprop == null && dst instanceof FeatureInstance) {
					srcprop = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) dst);
				}
				if (srccontain == null && dst instanceof FeatureInstance) {
					srccontain = EMV2Util.getOutgoingErrorContainment((FeatureInstance) dst);
				}
				if (src instanceof FeatureInstance) {
					ErrorPropagation founddst = EMV2Util.getOutgoingErrorPropagation((FeatureInstance) src);
					if (founddst != null) {
						dstprop = founddst;
					}
				}
				if (src instanceof FeatureInstance) {
					ErrorPropagation founddst = EMV2Util.getOutgoingErrorContainment((FeatureInstance) src);
					if (founddst != null) {
						dstcontain = founddst;
					}
				}
			}
			if (srcprop != null & dstprop != null) {
				// need to check whether all error types are handled by the destination
				checkConnectionErrorTypes(connectionInstance, srcprop, srccontain, dstprop, dstcontain);
			}
		}
	}

	protected void checkConnectionErrorTypes(ConnectionInstance connectionInstance, ErrorPropagation srcprop,
			ErrorPropagation srccontain, ErrorPropagation dstprop, ErrorPropagation dstcontain) {

		if (srcprop != null && dstprop != null) {
			if (!EM2TypeSetUtil.contains(dstprop.getTypeSet(), srcprop.getTypeSet())) {
				error(connectionInstance,
						"C1: Outgoing propagation  " + EMV2Util.getPrintName(srcprop)
								+ EMV2Util.getPrintName(srcprop.getTypeSet())
								+ " has error types not handled by incoming propagation "
								+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srccontain != null && dstcontain != null) {
			if (!EM2TypeSetUtil.contains(srccontain.getTypeSet(), dstcontain.getTypeSet())) {
				error(connectionInstance,
						"C1: Outgoing containment  " + EMV2Util.getPrintName(srcprop)
								+ EMV2Util.getPrintName(srcprop.getTypeSet())
								+ " does not contain error types listed by incoming containment "
								+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srcprop == null && srccontain == null && (dstprop != null || dstcontain != null)) {
			// has an EMV2 subclause but no propagation specification for the feature
			warning(connectionInstance, "C1: Connection source has no error propagation/containment but target does: "
					+ (dstprop != null ? EMV2Util.getPrintName(dstprop) : EMV2Util.getPrintName(dstcontain)));
		}
		if (dstprop == null && dstcontain == null && (srcprop != null || srccontain != null)) {
			// has an EMV2 subclause but no propagation specification for the feature
			error(connectionInstance, "C1: Connection target has no error propagation/containment but source does: "
					+ (srcprop != null ? EMV2Util.getPrintName(srcprop) : EMV2Util.getPrintName(srccontain)));
		}
	}

	protected void checkPropagationPathErrorTypes(PropagationPathRecord path) {
		ErrorPropagation srcprop = path.getPathSrc().getErrorPropagation();
		ErrorPropagation dstprop = path.getPathDst().getErrorPropagation();
		if (srcprop != null && dstprop != null) {
			if (!EM2TypeSetUtil.contains(dstprop.getTypeSet(), srcprop.getTypeSet())) {
				error(path.getConnectionInstance() != null ? path.getConnectionInstance() : path.getSrcCI(),
						"Outgoing propagation  " + EMV2Util.getPrintName(srcprop)
								+ EMV2Util.getPrintName(srcprop.getTypeSet())
								+ " has error types not handled by incoming propagation "
								+ EMV2Util.getPrintName(dstprop) + EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (dstprop == null && srcprop != null) {
			// has an EMV2 subclause but no propagation specification for the feature
			error(path.getConnectionInstance() != null ? path.getConnectionInstance() : path.getSrcCI(),
					"Connection target has no error propagation/containment but source does: "
							+ EMV2Util.getPrintName(srcprop));
		}
	}

	protected void checkComponent(ComponentInstance componentInstance, AnalysisModel model) {

		if (EMV2Util.hasEMV2Subclause(componentInstance)) {

			/**
			 * C1: for each error source there is an error sink.
			 * The error sink handles all the error types form the source.
			 */
			for (ErrorPropagation ep : EMV2Util
					.getAllIncomingErrorPropagations(componentInstance.getComponentClassifier())) {
				/**
				 *
				 * In the following, we check that all the types and subtypes for a given components
				 * are declared as error source for each out propagation. This would be enhanced
				 * when defining different error sources/path for the same propagation point.
				 */
				for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance.getComponentClassifier())) {
					if (ef instanceof ErrorSink) {
						ErrorSink es = (ErrorSink) ef;
						if (es.getIncoming() == ep) {

							for (TypeToken tt : EM2TypeSetUtil.generateAllLeafTypeTokens(ep.getTypeSet(),
									EMV2Util.getUseTypes(ep))) {

								if (!EM2TypeSetUtil.contains(es.getTypeTokenConstraint(), tt)) {
									error(componentInstance,
											"Incoming propagation " + EMV2Util.getPrintName(ep) + " does not declare "
													+ tt.getType().get(0).getName() + " as error source");

								}
							}
						}
					}
				}
			}

			for (ErrorPropagation ep : EMV2Util
					.getAllOutgoingErrorPropagations(componentInstance.getComponentClassifier())) {
//				OsateDebug.osateDebug("ci=" + componentInstance.getName() + "ep =" + EMV2Util.getPrintName(ep));

				/**
				 *
				 * In the following, we check that all the types and subtypes for a given components
				 * are declared as error source for each out propagation. This would be enhanced
				 * when defining different error sources/path for the same propagation point.
				 */
				for (ErrorSource es : EMV2Util.getAllErrorSources(componentInstance.getComponentClassifier())) {
					if (es.getOutgoing() == ep) {

						for (TypeToken tt : EM2TypeSetUtil.generateAllLeafTypeTokens(ep.getTypeSet(),
								EMV2Util.getUseTypes(ep))) {

							if (!EM2TypeSetUtil.contains(es.getTypeTokenConstraint(), tt)) {
								error(componentInstance, "Outgoing propagation " + EMV2Util.getPrintName(ep)
										+ " does not declare " + tt.getType().get(0).getName() + " as error source");

							}
						}
					}
				}

				if (!(componentInstance instanceof SystemInstance) && ep.getDirection() == DirectionType.OUT
						&& model.getAllPropagationPaths(componentInstance, ep).size() == 0) {
					error(componentInstance, "Outgoing propagation " + EMV2Util.getPrintName(ep)
							+ " is missing outgoing propagation paths");

					// OsateDebug.osateDebug("Component " + componentInstance + " does not handle OUT propagation " +
// ep.getName());
					continue;
				}

				for (PropagationPathRecord pp : model.getAllPropagationPaths(componentInstance, ep)) {
					ErrorPropagation ep2 = pp.getPathDst().getErrorPropagation();

//					OsateDebug.osateDebug("epts =" + EMV2Util.getPrintName(ep.getTypeSet()));
//					OsateDebug.osateDebug("ep2ts =" + EMV2Util.getPrintName(ep2.getTypeSet()));
					EList<TypeToken> dstTokens = EM2TypeSetUtil.generateAllLeafTypeTokens(ep2.getTypeSet(),
							EMV2Util.getUseTypes(ep));
//
//					for (TypeToken tt1 : srcTokens)
//					{
//						if (! EM2TypeSetUtil.contains (ep2.getTypeSet(), tt1))
//						{
//							error(componentInstance, "Error type " + EMV2Util.getPrintName(tt1)  +  " between " + EMV2Util.getPrintName(ep) + "/" + EMV2Util.getPrintName(ep.getTypeSet()) + " and " + EMV2Util.getPrintName(ep2) + "/" + EMV2Util.getPrintName(ep2.getTypeSet()));
					//
//						}
//
//					}
					for (TypeToken tt1 : dstTokens) {
						if (!EM2TypeSetUtil.contains(ep.getTypeSet(), tt1)) {
							error(componentInstance,
									"Type " + EMV2Util.getPrintName(tt1) + " is not propagated by the error source "
											+ EMV2Util.getPrintName(ep) + "/" + EMV2Util.getPrintName(ep.getTypeSet())
											+ " but is expected by the error sink " + EMV2Util.getPrintName(ep2) + "/"
											+ EMV2Util.getPrintName(ep2.getTypeSet()));

						}

					}
//					if (!(EM2TypeSetUtil.contains(, ep2.getTypeSet()) && EM2TypeSetUtil.contains(ep2.getTypeSet(), ep.getTypeSet())))
//					{
//						error(componentInstance, "Some errors are not handled between " + EMV2Util.getPrintName(ep) + "/" + EMV2Util.getPrintName(ep.getTypeSet()) + " and " + EMV2Util.getPrintName(ep2) + "/" + EMV2Util.getPrintName(ep2.getTypeSet()));
//						continue;

				}
			}
			for (ErrorPropagation ep : EMV2Util
					.getAllIncomingErrorPropagations(componentInstance.getComponentClassifier())) {
				if (!(componentInstance instanceof SystemInstance) && ep.getDirection() == DirectionType.IN
						&& model.getAllPropagationSourceEnds(componentInstance, ep).size() == 0) {
					error(componentInstance, "Incoming propagation " + EMV2Util.getPrintName(ep)
							+ " is missing incoming propagation paths");

					// OsateDebug.osateDebug("Component " + componentInstance + " does not handle IN propagation " +
// ep.getName());
				}
			}

			/**
			 * End of implementation of C1
			 */

			/**
			 * C2: Transitions of error component behavior use all incoming error propagations and error events
			 *
			 * First, we check that if the component has error propagation, it references
			 * at least ALL error types from ALL incoming propagations.
			 */

			for (ErrorBehaviorTransition ebt : EMV2Util.getAllErrorBehaviorTransitions(componentInstance)) {
				for (ErrorBehaviorEvent ebe : EMV2Util.getAllErrorBehaviorEvents(componentInstance)) {
					boolean found = false;
					for (ConditionElement ce : EMV2Util.getAllConditionElementsFromConditionExpression(ebt)) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
						if (eop != null) {
							if (eop instanceof ErrorEvent) {
								ErrorEvent ee = (ErrorEvent) eop;
								if (ee == ebe) {
									found = true;
								}
							}
						}
					}

					if (!found) {
						error(componentInstance,
								"C2: transition " + EMV2Util.getPrintName(ebt) + " in component "
										+ componentInstance.getName() + " does not reference event "
										+ EMV2Util.getPrintName(ebe));
					}
				}

				for (ErrorSink es : EMV2Util.getAllErrorSinks(componentInstance)) {
					boolean found = false;
					for (ConditionElement ce : EMV2Util.getAllConditionElementsFromConditionExpression(ebt)) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
						if (eop != null) {
							if (eop instanceof ErrorPropagation) {
								ErrorPropagation ep = (ErrorPropagation) eop;

								if (ep == es.getIncoming()) {
									found = true;
								}
							}
						}
					}

					if (!found) {
						error(componentInstance,
								"C2: transition " + EMV2Util.getPrintName(ebt) + " in component "
										+ componentInstance.getName() + " does not reference error sink "
										+ EMV2Util.getPrintName(es));
					}
				}

			}

			/**
			 * End of implementation of C2
			 */

			/**
			 * Rule C3: propagation without a condition
			 * must propagate to an error source declared in the flow.
			 */
			for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(componentInstance)) {
				/**
				 * if the associated condition is null, then, the outgoing propagation
				 * shoulbd an error source.
				 */
				if (opc.getCondition() == null) {
					if (EMV2Util.getErrorSource(componentInstance, opc.getOutgoing()) == null) {
						error(componentInstance,
								"C3: propagation " + EMV2Util.getPrintName(opc) + " in component "
										+ componentInstance.getName()
										+ " has no condition and thus, should output to an error source only");

					}
				}
			}

			/**
			 * End of implementation of C3
			 */

			/**
			 * Rule C4: Outgoing propagation condition with condition must have an associated flow path
			 */
			for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(componentInstance)) {
				if (opc.getCondition() != null) {
					boolean found = false;

					for (ConditionElement ce : EMV2Util.getAllConditionElementsFromConditionExpression(opc)) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
						if (eop != null && (eop instanceof ErrorPropagation)) {
							ErrorPropagation conditionIncoming = (ErrorPropagation) eop;
							for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance)) {
								if (ef instanceof ErrorPath) {
									ErrorPath ep = (ErrorPath) ef;
									ErrorPropagation pathIncoming = ep.getIncoming();
									ErrorPropagation pathOutgoing = ep.getOutgoing();

									if ((conditionIncoming == pathIncoming) && (opc.getOutgoing() == pathOutgoing)) {
										found = true;
									}
								}
							}
						}
					}
					// EMV2Util.getAllConditionElementsFromOutgoingPropagationCondition(opc)
					if (!found) {
						error(componentInstance, "C4: outgoing propagation condition " + EMV2Util.getPrintName(opc)
								+ " in component " + componentInstance.getName() + " does not have error path defined");
					}
				}
			}
			/**
			 * End of implementation of C4
			 */

			/**
			 * Rule C5: In the component error behavior, check that we have a transition between each state
			 * Let also check that if a components has an error state machine, all
			 * states are referenced.
			 */
			if (EMV2Util.hasComponentErrorBehaviorStates(componentInstance)) {
				for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(componentInstance)) {
					boolean found = false;
					for (ErrorBehaviorTransition ebt : EMV2Util.getAllErrorBehaviorTransitions(componentInstance)) {
						if ((ebt.getSource() == ebs) || (ebt.getTarget() == ebs)) {
							found = true;
						}
					}
					if (found == false) {
						error(componentInstance, "State " + EMV2Util.getPrintName(ebs)
								+ " has no associated transition for component " + componentInstance.getName());

					}
				}

			}
			/**
			 * End of implementation of C5
			 */

			/**
			 * Rule C6: Check completeness of all outgoing error propagation condition: we address and cover all error types
			 */
			if (EMV2Util.hasErrorPropagations(componentInstance)) {
				for (ErrorPropagation ep : EMV2Util
						.getAllOutgoingErrorPropagations(componentInstance.getComponentClassifier())) {
					EList<TypeToken> epTokens = EM2TypeSetUtil.generateAllLeafTypeTokens(ep.getTypeSet(),
							EMV2Util.getUseTypes(ep));

					for (TypeToken tt : epTokens) {
						// OsateDebug.osateDebug("check for type" + EMV2Util.getPrintName(tt) );
						boolean found = false;
						for (OutgoingPropagationCondition opc : EMV2Util
								.getAllOutgoingPropagationConditions(componentInstance)) {
							if (opc.getOutgoing() == ep) {

								if (EM2TypeSetUtil.contains(opc.getTypeToken(), tt)) {
									// OsateDebug.osateDebug("found" + EMV2Util.getPrintName(tt) );

									found = true;
								}
							}
						}

						if (!found) {
							error(componentInstance,
									"C6: error propagation " + EMV2Util.getPrintName(ep)
											+ " does not have a corresponding propagation condition for type "
											+ EMV2Util.getPrintName(tt) + "or any other super-type");
						}
					}

				}
			}
			/**
			 * End of implementation of C6
			 */

			/**
			 * Rule C7: we do not propagate error with a condition from a sink
			 */
			for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(componentInstance)) {

				for (ConditionElement ce : EMV2Util.getAllConditionElementsFromConditionExpression(opc)) {
					EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
					if (eop != null) {
						for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance)) {
							if (ef instanceof ErrorSink) {
								ErrorSink es = (ErrorSink) ef;
								if (es.getIncoming() == eop) {
									error(componentInstance,
											"C7: propagation " + EMV2Util.getPrintName(opc) + " in component "
													+ componentInstance.getName() + " depends on an error sink");

								}
							}
						}
					}

				}
			}
			/**
			 * End of implementation of C7
			 */

			/**
			 * Rule C9: Check that there is no transition with the same condition and source state
			 */
			for (ErrorBehaviorTransition ebt1 : EMV2Util.getAllErrorBehaviorTransitions(componentInstance)) {
				for (ErrorBehaviorTransition ebt2 : EMV2Util.getAllErrorBehaviorTransitions(componentInstance)) {
					if ((ebt1 != ebt2) && (ebt1.getSource() == ebt2.getSource())) {
						if (EMV2Util.isEqual(ebt1.getCondition(), ebt2.getCondition())) {
							error(componentInstance,
									"C9: transition " + EMV2Util.getPrintName(ebt1) + " is similar to transition "
											+ EMV2Util.getPrintName(ebt2) + " in component "
											+ componentInstance.getName());

						}
					}
				}
			}
			/**
			 * End of implementation of C9
			 */

			/**
			 * Rule C10: Check that for each state transition, all elements are referenced
			 */
			for (ErrorBehaviorTransition ebt : EMV2Util.getAllErrorBehaviorTransitions(componentInstance)) {
				Collection<ConditionElement> allCE = EMV2Util.getAllConditionElementsFromConditionExpression(ebt);
				for (ErrorSink es : EMV2Util.getAllErrorSinks(componentInstance)) {
					boolean found = false;
					for (ConditionElement ce : allCE) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
						if ((eop != null) && (eop instanceof ErrorPropagation)) {
							if (eop == es.getIncoming()) {
								found = true;
							}
						}
					}
					if (!found) {
						error(componentInstance,
								"C10: transition " + EMV2Util.getPrintName(ebt) + " does not references error sink "
										+ EMV2Util.getPrintName(es) + " in component " + componentInstance.getName());

					}
				}

				for (ErrorBehaviorEvent ebe : EMV2Util.getAllErrorBehaviorEvents(componentInstance)) {
					boolean found = false;
					for (ConditionElement ce : allCE) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
						if ((eop != null) && (eop instanceof ErrorEvent)) {
							if (eop == ebe) {
								found = true;
							}
						}
					}
					if (!found) {
						error(componentInstance,
								"C10: transition " + EMV2Util.getPrintName(ebt) + " does not references error event "
										+ EMV2Util.getPrintName(ebe) + " in component " + componentInstance.getName());

					}
				}
			}

			/**
			 * End of implementation of C10
			 */

			/**
			 * Rule C11: Composite error behavior: indicate the condition for each state of the component
			 *
			 * Let also check that if a components has an composite error state, all
			 * states are referenced.
			 */
			if (EMV2Util.hasCompositeErrorBehavior(componentInstance)) {
				for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(componentInstance)) {
					boolean found = false;
					for (CompositeState cs : EMV2Util.getAllCompositeStates(componentInstance)) {
						if (cs.getState() == ebs) {
							found = true;
						}
					}
					if (found == false) {
						error(componentInstance,
								"C11: state " + EMV2Util.getPrintName(ebs)
										+ " has no associated transition for composite behavior of component "
										+ componentInstance.getName());

					}
				}
			}
			/**
			 * End of implementation of C11
			 */

			/**
			 * Rule C12: Composite error behavior references all subcomponents
			 */
			if (EMV2Util.hasCompositeErrorBehavior(componentInstance)) {
				EList<Subcomponent> subcomponents;

				for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(componentInstance)) {
					subcomponents = new BasicEList<Subcomponent>();

					for (CompositeState cs : EMV2Util.getAllCompositeStates(componentInstance)) {
						if (cs.getState() == ebs) {
							for (ConditionElement ce : EMV2Util.getAllConditionElementsFromConditionExpression(cs)) {
								if (ce instanceof SConditionElement) {
									for (SubcomponentElement se : EMV2Util.getSubcomponents((SConditionElement) ce)) {
										if (se != null) {
											subcomponents.add(se.getSubcomponent());
										}
									}
								}
							}
						}

					}

					for (ComponentInstance ci : componentInstance.getComponentInstances()) {
						boolean found = false;
						for (Subcomponent s : subcomponents) {
							if (s == ci.getSubcomponent()) {
								found = true;
							}
						}
						if (!found) {
							error(componentInstance, "C12: component " + ci.getName() + " is not referenced for state "
									+ EMV2Util.getPrintName(ebs) + " in component " + componentInstance.getName());
						}
					}
				}
			}
			/**
			 * End of implementation of C12
			 */

			/**
			 * Rule C13: Composite error behavior: check compliance between component state machine and composite error state machine
			 */
			if (EMV2Util.hasCompositeErrorBehavior(componentInstance)
					&& EMV2Util.hasComponentErrorBehaviorStates(componentInstance)) {

				/**
				 * For each state, we will get all the conditions for both the error behavior
				 * AND the composite error model.
				 */
				for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(componentInstance)) {
					EList<ConditionElement> elementsBehavior = new BasicEList<ConditionElement>();
					EList<ConditionElement> elementsComposite = new BasicEList<ConditionElement>();
					double probabilityBehavior = 0;
					double probabilityComposite = 0;
					double tmp;
					/**
					 * We retrieve all the elements within the error behavior specifications
					 */
					for (ErrorBehaviorTransition ebt : EMV2Util.getAllErrorBehaviorTransitions(componentInstance)) {
						if (ebt.getTarget() == ebs) {
							elementsBehavior.addAll(EMV2Util.getAllConditionElementsFromConditionExpression(ebt));
						}
					}

					/**
					 * We retrieve all the elements within the composite error behavior
					 */
					for (CompositeState cs : EMV2Util.getAllCompositeStates(componentInstance)) {
						if (cs.getState() == ebs) {
							elementsComposite.addAll(EMV2Util.getAllConditionElementsFromConditionExpression(cs));
						}
					}

					/**
					 * FIXME JD
					 *
					 * For now, we just sum the properties but we should introduce something more intelligent to make
					 * some consistency check and handle the different operators such as and, or, etc.
					 */
					for (ConditionElement ce : elementsComposite) {
						if (ce instanceof SConditionElement) {
							SConditionElement sce = (SConditionElement) ce;
							for (SubcomponentElement se : EMV2Util.getSubcomponents(sce)) {
								se.getSubcomponent();
								// OsateDebug.osateDebug("se=" + se);
								double res = EMV2Properties.getProbability(componentInstance, EMV2Util.getState(sce),
										null);
								if (res == 0) {
									warning(componentInstance,
											"C13: component " + componentInstance.getName()
													+ " does not define occurrence for " + EMV2Util.getPrintName(se)
													+ " and state " + EMV2Util.getPrintName(EMV2Util.getState(sce)));
								} else {
									probabilityComposite = probabilityComposite + res;
								}
							}
						}

					}

					for (ConditionElement ce : elementsBehavior) {
						EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(ce);
						double res = EMV2Properties.getProbability(componentInstance, eop, null);
						// OsateDebug.osateDebug(" PA " + PA);
						if (res == 0) {
							warning(componentInstance,
									"C13: component " + componentInstance.getName()
											+ " does not define occurrence for incoming propagation "
											+ EMV2Util.getPrintName(eop));
						} else {
							probabilityBehavior = probabilityBehavior + res;
						}
					}

					if (probabilityBehavior != probabilityComposite) {
						error(componentInstance,
								"C13: in component " + componentInstance.getName()
										+ " inconsistent probability values for state " + ebs.getName()
										+ " (for composite, probability=" + probabilityComposite
										+ " ; for behavior, probability=" + probabilityBehavior + ")");
					} else {
						info(componentInstance, "C13: component " + componentInstance.getName()
								+ " has consistent probability values for state " + ebs.getName());

					}
				}
			}
			/**
			 * End of implementation of C13
			 */

			/**
			 * Rule C14: Check for undeclared error path
			 */
			for (FeatureInstance fi : componentInstance.getFeatureInstances()) {
				Feature srcFeature = null;
				Feature dstFeature = null;
				EList<ConnectionInstance> connections = fi.getAllEnclosingConnectionInstances();

				srcFeature = fi.getFeature();

				if ((fi.getDirection() != DirectionType.IN) && (fi.getDirection() != DirectionType.IN_OUT)) {
					continue;
				}

				for (ConnectionInstance ci : connections) {
					// OsateDebug.osateDebug("ci=" + ci);

					for (ConnectionReference cr : ci.getConnectionReferences()) {
						Connection conn = cr.getConnection();
						// OsateDebug.osateDebug("conn dest=" + conn.getDestination());
						if ((conn.getDestination() != null) && (conn.getDestination() instanceof ConnectedElement)) {
							ConnectedElement connected = conn.getDestination();
							// OsateDebug.osateDebug("connected dest=" + connected.getConnectionEnd());
							for (FeatureInstance fi2 : componentInstance.getFeatureInstances()) {
								// OsateDebug.osateDebug("fi2=" + fi2.getFeature());

								if ((connected.getConnectionEnd() != null)
										&& (fi2.getFeature() == connected.getConnectionEnd())
										&& (fi2.getFeature() != srcFeature)) {
									dstFeature = fi2.getFeature();
								}
							}

						}

//						for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance))
//						{
//							if (ef instanceof ErrorPath)
//							{
//								ErrorPath ep = (ErrorPath) ef;
//								OsateDebug.osateDebug("ep=" + ep);
//								OsateDebug.osateDebug("ep in  getref=" + ep.getIncoming().getFeatureorPPRefs().get(0).getFeatureorPP());
//								OsateDebug.osateDebug("ep out getref=" + ep.getOutgoing().getFeatureorPPRefs().get(0).getFeatureorPP());
//							}
//						}
					}

				}

				if ((dstFeature != null) && (srcFeature != null)) {
					boolean found = false;
//					OsateDebug.osateDebug("connection between " + srcFeature + " and " + dstFeature);
					for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance)) {
						if (ef instanceof ErrorPath) {
							ErrorPath ep = (ErrorPath) ef;
//							OsateDebug.osateDebug("ep=" + ep);
//							OsateDebug.osateDebug("ep in  getref=" + ep.getIncoming().getFeatureorPPRefs().get(0).getFeatureorPP());
//							OsateDebug.osateDebug("ep out getref=" + ep.getOutgoing().getFeatureorPPRefs().get(0).getFeatureorPP());
							if ((ep.getIncoming().getFeatureorPPRef().getFeatureorPP() == srcFeature)
									&& (ep.getOutgoing().getFeatureorPPRef().getFeatureorPP() == dstFeature)) {
								found = true;
							}
						}
					}
					if (!found) {
						error(componentInstance,
								"C14: in component " + componentInstance.getName() + " missing flow path between "
										+ srcFeature.getName() + " and " + dstFeature.getName());
					}
				}

//				for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance))
//				{
//					if (ef instanceof ErrorPath)
//					{
//						ErrorPath ep = (ErrorPath) ef;
//						OsateDebug.osateDebug("ep=" + ep);
//						OsateDebug.osateDebug("ep in  getref=" + ep.getIncoming().getFeatureorPPRefs());
//						OsateDebug.osateDebug("ep out getref=" + ep.getOutgoing().getFeatureorPPRefs());
//					}
//
//					if (ef instanceof ErrorSink)
//					{
//						ErrorSink es = (ErrorSink) ef;
//						OsateDebug.osateDebug("es in  getref=" + es.getIncoming().getFeatureorPPRefs());
//
//
//					}
//
//					if (ef instanceof ErrorSource)
//					{
//						ErrorSource es = (ErrorSource)ef;
//						OsateDebug.osateDebug("es out getref=" + es.getOutgoing().getFeatureorPPRefs());
//
//					}
//
//				}

			}

			/**
			 * End of implementation of C14
			 */

			/**
			 * Rule C15: Check that if a component declare an error path, any connection from the associated feature go into a feature which is also an error sink
			 */
			for (ErrorFlow ef : EMV2Util.getAllErrorFlows(componentInstance)) {
				/**
				 * First, we take all error sink from a component
				 */
				if ((componentInstance.getComponentClassifier() instanceof ComponentImplementation)
						&& (ef instanceof ErrorSink)) {
					ErrorSink es = (ErrorSink) ef;
					Feature src = (Feature) es.getIncoming().getFeatureorPPRef().getFeatureorPP();
					ComponentImplementation impl = (ComponentImplementation) componentInstance.getComponentClassifier();
					// OsateDebug.osateDebug("src="+src);

					/**
					 * We inspect the connection of the feature related to this error sink
					 */
					for (Connection conn : impl.getAllConnections()) {
						// OsateDebug.osateDebug("conn src="+conn.getSource());
						ConnectedElementImpl ceiSrc = (ConnectedElementImpl) conn.getSource();

						if (ceiSrc.getConnectionEnd() == src) {
							boolean found = false;

							ConnectedElementImpl ceiDst = (ConnectedElementImpl) conn.getDestination();
							// OsateDebug.osateDebug("before");

							/**
							 * Then, we finally check that the feature of the component
							 * is an error sink. For that, we retrieve the component
							 * that contains the destination and finally inspect all
							 * its error flow and check that it declares
							 * an error sink for this feature.
							 */
							if (ceiDst.getConnectionEnd() instanceof Feature) {
								// OsateDebug.osateDebug("after");

								Feature featureDst = (Feature) ceiDst.getConnectionEnd();
								// OsateDebug.osateDebug("feature" + featureDst);
								// OsateDebug.osateDebug("classifier" + conn.getAllDstContextComponent());
								Subcomponent sub = (Subcomponent) conn.getAllDstContextComponent();
								// OsateDebug.osateDebug("sub" + sub.getComponentImplementation());
								ComponentClassifier cl = null;
								if (sub.getContainingClassifier() != null) {
									cl = (ComponentClassifier) sub.getContainingClassifier();
								}
								if (sub.getComponentImplementation() != null) {
									cl = sub.getComponentImplementation();
								}

								for (ErrorFlow ef2 : EMV2Util.getAllErrorFlows(cl)) {

									// OsateDebug.osateDebug("ef2="+ef2);
									if (ef2 instanceof ErrorSink) {
										// OsateDebug.osateDebug("ef2 error sink="+ef2);

										ErrorSink es2 = (ErrorSink) ef2;
										Feature dst = (Feature) es2.getIncoming().getFeatureorPPRef().getFeatureorPP();
										// OsateDebug.osateDebug("src="+src);

										// OsateDebug.osateDebug("featureDst="+featureDst);
										// OsateDebug.osateDebug("dst="+dst);
										if (dst == featureDst) {
											found = true;
										}
									}
								}
							}

							if (!found) {
								error(componentInstance,
										"C15: in component " + componentInstance.getName() + " feature " + src.getName()
												+ " is an error sink while it is connected to a non error-sink");
							}

						}
					}
				}

			}
			/**
			 * End of implementation of C15
			 */

		}

	}

}
