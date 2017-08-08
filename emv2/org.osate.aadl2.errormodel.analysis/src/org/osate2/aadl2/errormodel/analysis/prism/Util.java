package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osate.aadl2.errormodel.analysis.handlers.PRISMHandler;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.legacy.PropagationPathEnd;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Equal;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Terminal;

/**
 * Utility methods used for the AADL to PRISM translator
 *
 * @author jdelange
 *
 */
public class Util {

	/**
	 * This method report the complete mapping name for a component.
	 * We map AADL entities into PRISM using the instance model.
	 * Then, to avoid conflict in the naming rules, we use
	 * the complete whole component hierarchy to name a component.
	 * So, a component name will be: instancename_containerinstancename
	 *
	 * @param ci The AADL ComponentInstance object that should be mapped into PRISM
	 * @return The corresponding name for the PRISM model
	 */
	public static String getComponentName(ComponentInstance ci) {
		StringBuffer sb = new StringBuffer();
		ComponentInstance t;

		t = ci;
		while (t != null) {
			sb.append(t.getName().toLowerCase());
			t = t.getContainingComponentInstance();
		}
		return sb.toString();
	}

	/**
	 * Return the name that corresponds to a variable associated
	 * to a feature. The name is built using the ComponentInstance
	 * and the Feature.
	 * @param ci	The ComponentInstance processed and that contains the feature
	 * @param fe	The Feature to map
	 * @return
	 */
	public static String getFeatureName(ComponentInstance ci, String featureName) {
		return getComponentName(ci) + "_" + featureName.toLowerCase();
	}

	/**
	 * Each AADL component mapped into PRISM has a state variable
	 * This method returns the identifier of the state
	 * variable for a given component.
	 * @param ci	The AADL ComponentInstance that should be mapped
	 * @return		The name of the state variable identifier
	 */
	public static String getComponentStateVariableName(ComponentInstance ci) {
		return getComponentName(ci) + "_state";
	}

	/**
	 * Each AADL IN propagation point is mapped into a variable
	 * @param ci	The AADL ComponentInstance that contains
	 *              the incoming propagation point
	 * @param n     The name of the incoming propagation point
	 * @return		The name of the state variable identifier
	 */
	public static String getComponentIncomingPropagationVariableName(ComponentInstance ci, String n) {
		return getComponentName(ci) + "_incoming_propagation_" + n.toLowerCase();
	}

	/**
	 * Find other conditions required to switch from a state to another.
	 * That might be due to the content of the transition itself
	 * (for example, when a transition is triggered from an
	 * incoming error propagation).
	 * propagation
	 * @param instance 	The AADL instance that contains is related to the transition
	 * @param trans 	The transition from the Error Model State Behavior that trigger the switch from one state to another
	 * @return
	 */
	public static List<Expression> findOtherConditions(ComponentInstance instance, ErrorBehaviorTransition trans) {
		List<Expression> exprs = new ArrayList<Expression>();
		ConditionExpression condition;

		condition = trans.getCondition();
		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;
			EventOrPropagation event = EMV2Util.getErrorEventOrPropagation(conditionElement);
			TypeSet typeSet = conditionElement.getConstraint();

			// OsateDebug.osateDebug("[Utils] incoming :" + event);

			if ((event != null) && (event instanceof ErrorPropagation)) {
				ComponentInstance instanceSource = null;
				boolean found = false;
				ErrorPropagation ep = (ErrorPropagation) event;

				// instance.getAllEnclosingConnectionInstances()
				// OsateDebug.osateDebug("[Utils] ErrorPropagation kind:" + ep);
				// OsateDebug.osateDebug("[Utils] ErrorPropagation associated feature:" + associatedFeature);
				for (ConnectionInstance ci : instance.getAllEnclosingConnectionInstances()) {
					for (ConnectionReference cr : ci.getConnectionReferences()) {
						// OsateDebug.osateDebug("[Utils] ErrorPropagation cr dest cl:" + cr.getConnection().getAllDestination());
						// TODO deal with access connections pointing to component instances
						if (EMV2Util.isErrorPropagationOf(ep, (FeatureInstance) cr.getDestination())) {
							// OsateDebug.osateDebug("[Utils] crSource:" + cr.getSource());
							instanceSource = cr.getSource().getContainingComponentInstance();
							found = true;
						}
					}

					if ((found = true) && (instanceSource != null)) {
						// OsateDebug.osateDebug("[Utils] Instance src:" + instanceSource);
						// OsateDebug.osateDebug("[Utils] Feature src:" + featureSource);
						Collection<ErrorSource> flows = EMV2Util
								.getAllErrorSources(instanceSource.getComponentClassifier());
						for (ErrorFlow flow : flows) {

							if (flow instanceof ErrorSource) {
								ErrorSource errorSource = (ErrorSource) flow;
								List<PropagationPathEnd> propagationEnds;
								propagationEnds = Model.getCurrentInstance().getAnalysisModel()
										.getAllPropagationDestinationEnds(instance, errorSource.getOutgoing());
								PropagationPathEnd ppe = propagationEnds.get(0);
								ErrorBehaviorState state = (ErrorBehaviorState) errorSource.getFailureModeReference();
								// OsateDebug.osateDebug("[Utils] ErrorSource feature:" + errorSource.getOutgoing().getFeature());
								if (errorSource.getOutgoing() == ep) {
									TypeSet ts = errorSource.getTypeTokenConstraint();
									TypeToken tt = ts.getTypeTokens().get(0);
									ErrorTypes et = tt.getType().get(0);
									// OsateDebug.osateDebug("[Utils] ErrorSource token:" + et);
									Expression e = new Equal(
											new Terminal(
													Util.getFeatureName(instanceSource, EMV2Util.getPrintName(ep))),
											new Terminal("" + Model.getCurrentInstance().getErrorTypeCode(ppe,
													errorSource.getTypeTokenConstraint().getTypeTokens().get(0)
															.getType().get(0))));

									exprs.add(e);
								}

							}

						}

					}
				}

			}
			// OsateDebug.osateDebug("[Utils] constraint :" + typeSet);
		}

		return exprs;
	}

	/**
	 * Translate a condition from the Error Model annex into a probability
	 * for PRISM. Let's consider the following model (see below), this method would
	 * return the ProbabilityValue for each Event (Failure or ResetEvent).
	 *
	 * 	  system implementation main.i
	 * 	    annex EMV2 {**
	 *       use types ErrorLibrary;
	 *   	use behavior ErrorModelLibrary::Simple;
	 *  	component error behavior
	 *	events
	 *		FailEvent: error event;
	 *		ResetEvent: recover event;
	 *	transitions
	 *		tfail: Operational -[Failure ]-> Failed;
	 *		treset: Failed -[ ResetEvent ]-> Operational;
	 *	end component;
	 *	properties
	 *		EMV2::OccurrenceDistribution => [ ProbabilityValue => 0.1 ; Distribution => Fixed;] applies to Failure;
	 *		EMV2::OccurrenceDistribution => [ ProbabilityValue => 0.2 ; Distribution => Fixed;] applies to ResetEvent;
	 *
	 *	**};
	 * end main.i;
	 *
	 * @param ComponentInstance that contains the conditon
	 * @param The condition to map
	 * @return The probability, if any. 0.0 if no probability is found
	 */
	public static double translateConditionToProbability(ComponentInstance instance, ConditionExpression condition) {
		double res = 0.0;
		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;
			EventOrPropagation event = EMV2Util.getErrorEventOrPropagation(conditionElement);
			;
			TypeSet typeSet = conditionElement.getConstraint();

			// OsateDebug.osateDebug("[Utils] incoming :" + event);
			if ((event != null) && (event instanceof ErrorEvent)) {

				ErrorEvent ee = (ErrorEvent) event;
				// OsateDebug.osateDebug("[Utils] Event kind:" + ee);

				List<EMV2PropertyAssociation> PAList = EMV2Properties.getOccurrenceDistributionProperty(instance, ee,
						null);
				EMV2PropertyAssociation PA = PAList.isEmpty() ? null : PAList.get(0);
				if (PA != null) {
					/**
					 * 
					 * Consistency check for the distribution method
					 * for event occurence
					 *  1. For DTMC, we are supposed to have fixed probability.
					 *  2. For CTMC, we are supposed to have poisson/exponential occurence rate.
					 */
					if ((Model.getCurrentInstance().getType() == ModelType.DTMC)
							&& (!EMV2Properties.getOccurrenceType(PA).equals("fixed"))) {
						/**
						 * Have to find out why the reportWarning does not work right now.
						 */
						OsateDebug.osateDebug("[Util] WRONG TYPE on " + ee + " component " + instance);
						PRISMHandler.reportWarning(instance,
								"Distribution occurence should be set to fixed for DTMC generation");
					}

					if ((Model.getCurrentInstance().getType() == ModelType.CTMC)
							&& (!EMV2Properties.getOccurrenceType(PA).equals("poisson"))
							&& (!EMV2Properties.getOccurrenceType(PA).equals(EMV2Properties.INVALID_OCCURRENCE_TYPE))) {
						/**
						 * Have to find out why the reportWarning does not work right now.
						 */
						OsateDebug.osateDebug("[Util] WRONG TYPE on " + ee + " component " + instance + " found="
								+ EMV2Properties.getOccurrenceType(PA));
						PRISMHandler.reportWarning(instance,
								"Distribution occurence should be set to poisson for CTMC generation");
					}
					res = EMV2Properties.getProbability(instance, ee, null);
				}
			}

			if ((event != null) && (event instanceof RecoverEvent)) {
				RecoverEvent re = (RecoverEvent) event;
				// OsateDebug.osateDebug("[Utils] Recover kind:" + re);

				res = EMV2Properties.getProbability(instance, re, null);
			}

			/**
			 * In case of an ErrorPropagation, we assume the probability
			 * to switch is 100% and that there is no other event that
			 * may trigger a switch. This might be changed when improving
			 * the generator.
			 */
			/*
			 * FIXME Julien: has to check if this logic really make sense
			 * spent two hours to figure out why we have a probability
			 * of 1.0 in CTMC !
			 */
			if ((event != null) && (event instanceof ErrorPropagation)
					&& (Model.getCurrentInstance().getType() == ModelType.DTMC)) {
				res = 1.0;
			}
			// OsateDebug.osateDebug("[Utils] constraint :" + typeSet);
		}

		return res;
	}

	public static String getStringFromModelType(ModelType mt) {
		if (mt == ModelType.DTMC) {
			return "dtmc";
		}
		if (mt == ModelType.CTMC) {
			return "ctmc";
		}
		return "unknown_type";
	}

	public static ModelType getModelTypeFromString(String s) {
		if (s.equals("dtmc")) {
			return ModelType.DTMC;
		}
		if (s.equals("ctmc")) {
			return ModelType.CTMC;
		}
		return ModelType.UNKNOWN;

	}

}
