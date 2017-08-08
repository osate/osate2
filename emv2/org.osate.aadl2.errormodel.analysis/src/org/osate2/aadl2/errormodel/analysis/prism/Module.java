package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.AndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.SConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.legacy.PropagationPathEnd;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate2.aadl2.errormodel.analysis.prism.expression.And;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Equal;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Or;
import org.osate2.aadl2.errormodel.analysis.prism.expression.Terminal;

/**
 * Class that implements a PRISM module. Basically,
 * one PRISM module is created for each ComponentInstance
 * of the AADL instance model.
 * @author jdelange
 *
 */
public class Module {
	private List<Command> commands;
	private ComponentInstance aadlComponent;
	private int nStates;
	private Model associatedModel;
	private Map<String, Integer> statesMap;
	private List<Formula> formulas;
	private Map<String, Integer> vars;

	/**
	 *
	 * @param ci	The AADL component that corresponds to this PRISM module
	 * @param m		The PRISM model that contains this module
	 */
	public Module(ComponentInstance ci, Model m) {
		commands = new ArrayList<Command>();
		formulas = new ArrayList<Formula>();
		associatedModel = m;
		aadlComponent = ci;
		nStates = 0;
		statesMap = new HashMap<String, Integer>();
		vars = new HashMap<String, Integer>();
	}

	/**
	 *
	 * @param ci	The AADL component that corresponds to this PRISM module
	 * @param m		The PRISM model that contains this module
	 * @param ns	Number of states (in that case, we do not auto-detect the number of states)
	 */
	public Module(ComponentInstance ci, Model m, int ns) {
		this(ci, m);
		nStates = ns;
	}

	/**
	 * Produce a String that contains the code that maps the
	 * AADL ComponentInstance into a PRISM module. It contains
	 * both formulas and module code.
	 *
	 * Note that the method process() shall be called before
	 * so that all necessary objects are created/instantiated
	 * to generated/produce the code.
	 *
	 * @return The code to be written in the PRISM model file
	 */
	public String getPrismCode() {
		StringBuffer sb = new StringBuffer();
		sb.append("module " + Util.getComponentName(aadlComponent) + "\n");
		if (nStates > 0) {
			sb.append("\t" + Util.getComponentName(aadlComponent) + "_state: [ 0 .. " + (nStates - 1) + "] init 0;\n");
		}

		if (vars.size() > 0) {
			for (String s : vars.keySet()) {
				int size = vars.get(s);
				sb.append("\t" + s.toLowerCase() + ": [ 0 .. " + size + "] init 0;\n");
			}
		}

		/**
		 * Here, we write each command with transition/probability that
		 * triggers state changes.
		 */
		for (Command command : commands) {
			double sum;
			boolean alreadyOne = false;
			sum = 0.0;
			sb.append("\t[] " + command.getCondition().toString() + " -> ");
			for (Transition t : command.getTransitions()) {
				sum = sum + t.getProbability();
				if (alreadyOne) {
					sb.append(" + ");
				}
				if (t.useProbability()) {
					sb.append(t.getProbability());
					sb.append(" : ");
				}

				boolean firstExpression = true;
				for (Expression e : t.getExpressions()) {
					if (!firstExpression) {
						sb.append(" & ");
					}
					sb.append("(");
					sb.append(e.toString());
					sb.append(")");
					firstExpression = false;
				}
				alreadyOne = true;
			}

			/**
			 * If the sum of all probability is not reached, we keep
			 * the same state, nothing change.
			 * We do that ONLY for DTMC since having a sum of all
			 * probability from a given state must be equal to 1.
			 * We do not have this probability for CTMC because
			 * CTMC models an occurence of an event.
			 */
			if ((associatedModel.getType() == ModelType.DTMC) && (sum < 1.0)) {
				sb.append(" + ");

				sb.append(1.0 - sum);
				sb.append(" : ");
				sb.append("(");
				if (command.getCondition() instanceof Equal) {
					Equal e = (Equal) command.getCondition();
					Expression left = e.getLeft();
					if (left instanceof Terminal) {
						Terminal t = (Terminal) left;
						t.setUpdate(true);
					}
				}
				sb.append(command.getCondition().toString());
				sb.append(")");
				alreadyOne = true;
			}
			sb.append(";\n");

		}
		sb.append("endmodule\n");

		/**
		 * Generate code for each formula associated
		 * with this module (for example, a formula
		 * that check the state of a module/component).
		 */
		for (Formula f : formulas) {
			sb.append("\n");
			sb.append(f.getPRISMCode());
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * This method try to find additional assignment to do when switching to
	 * the targetmode. The intent here is to assign all values when switching
	 * to another state.
	 *
	 * @param targetState The target state in which the statemachine will be
	 * @return 	A List that contains all expression that should be performed
	 *   		(mostly assignment) when switching to this state. The list
	 *   		is empty if nothing shall be performed.
	 */
	private List<Expression> getAdditionalAssignments(ErrorBehaviorState targetState) {
		List<Expression> exprs;
		List<PropagationPathEnd> propagationEnds;
		Expression expr;
		boolean reset;
		int value;
		String varName;
		List<String> varsUpdated;

		exprs = new ArrayList<Expression>();
		varsUpdated = new ArrayList<String>();

		for (OutgoingPropagationCondition opc : EMV2Util
				.getAllOutgoingPropagationConditions(aadlComponent.getComponentClassifier())) {

			// OsateDebug.osateDebug("opc=" + opc);
			if ((opc.getState().getName().equalsIgnoreCase(targetState.getName())) && (opc.getCondition() != null)) {
				reset = false;
			} else {
				reset = true;
			}

			propagationEnds = associatedModel.getAnalysisModel().getAllPropagationDestinationEnds(aadlComponent,
					opc.getOutgoing());

			for (PropagationPathEnd ppe : propagationEnds) {
				NamedElement connectedFeature = ppe.getErrorPropagation().getFeatureorPPRef().getFeatureorPP();

				ErrorTypes et = opc.getTypeToken();
				// OsateDebug.osateDebug("TYPE" + et.getName() +";state=" + targetState.getName());

				if (reset) {
					value = 0;
				} else {
					value = associatedModel.getErrorTypeCode(ppe, et);
				}

				varName = Util.getComponentIncomingPropagationVariableName(ppe.getComponentInstance(),
						connectedFeature.getName());

				if (!varsUpdated.contains(varName)) {

					expr = new Equal(new Terminal(varName, true), new Terminal("" + value));

					varsUpdated.add(varName);
					exprs.add(expr);
				}
			}
		}

		return exprs;
	}

	/**
	 * Map a single element from a ConditionExpression into a PRISM entity
	 * This is used mostly to map Composite Error Condition
	 * into PRISM artifacts.
	 *
	 * @param conditionElement - The Element to map into PRISM
	 * @return A PRISM Expression that represents the conditionElement from the
	 *         AADL EMV2, null if this cannot be mapped.
	 */
	private Expression handleElement(final SConditionElement conditionElement) {

		ErrorBehaviorState behaviorState = EMV2Util.getState(conditionElement);

		for (SubcomponentElement subcomponentElement : EMV2Util.getSubcomponents(conditionElement)) {
			Subcomponent subcomponent = subcomponentElement.getSubcomponent();

			if (behaviorState != null) {
				return new Terminal(subcomponent.getName() + Util.getComponentName(aadlComponent) + "_is_"
						+ behaviorState.getName().toLowerCase());

			}
		}

		return new Terminal("unknown");
	}

	/**
	 * Mao a condition from a composite error behavior into a PRISM expression
	 *
	 * @param cond	The Condition from the Error Composite Behavior to map
	 * @return A PRISM Expression, null if this cannot be mapped
	 */
	private Expression handleCompositeCondition(final ConditionExpression cond) {
		Expression res = null;

		if (cond instanceof SConditionElement) {
			res = handleElement((SConditionElement) cond);
		}

		if (cond instanceof OrExpression) {
			OrExpression sor = (OrExpression) cond;
			res = new Or(handleCompositeCondition(sor.getOperands().get(0)),
					handleCompositeCondition(sor.getOperands().get(1)));

		}

		if (cond instanceof AndExpression) {
			AndExpression sae = (AndExpression) cond;
			res = new And(handleCompositeCondition(sae.getOperands().get(0)),
					handleCompositeCondition(sae.getOperands().get(1)));

		}
		return res;
	}

	/**
	 * This method process the AADL component and creates
	 * all PRISM objects and artifact to generate code.
	 * This method shall be called before the getPrismCode()
	 * method.
	 *
	 * @return The actual module instance
	 */
	public Module process() {
		/**
		 * Here, we map the states of the error state machine
		 * into a number. For that, we add the corresponding
		 * number to a HashMap. Then, we can retrieve
		 * the associated value of a state using the state name (a String)
		 * in the HashMap (called statesMap). There is one particular
		 * case for the default state that is always associated
		 * with 0.
		 */
		Collection<ErrorBehaviorState> errorStates = EMV2Util
				.getAllErrorBehaviorStates(aadlComponent.getComponentClassifier());

		int stateIndex = 1;
		int stateValue;
		for (ErrorBehaviorState state : errorStates) {
			stateValue = stateIndex;
			if (state.isIntial()) {
				stateValue = 0;
			} else {
				stateValue = stateIndex++;
			}
			statesMap.put(state.getName(), stateValue);

			/**
			 * Add an helper formula to easily know if the component reach a given state or not
			 * It generates formulas such as
			 * formula COMPONENT_IS_STATENAME = COMPONENT_STATE_VAR = STATE_VALUE
			 */
			Expression fe = new Equal(new Terminal(Util.getComponentStateVariableName(aadlComponent)),
					new Terminal("" + stateValue));
			Formula f = new Formula(Util.getComponentName(aadlComponent) + "_is_" + state.getName().toLowerCase(), fe);
			formulas.add(f);
		}
		nStates = errorStates.size();

		/**
		 * Here, we see if we have any error propagation.
		 * If yes, then, we declare a variable for each OUT port.
		 * The variable can have N values, N being the number of potential
		 * error types propagated. The variable has a value 0 if no error
		 * is propagated.
		 */
		Collection<ErrorPropagation> outprops = EMV2Util
				.getAllOutgoingErrorPropagations(aadlComponent.getComponentClassifier());
		for (ErrorPropagation ep : outprops) {
			Map<String, Integer> tmpMap = new HashMap<String, Integer>();
			int errorVal = 1;
			TypeSet ts = ep.getTypeSet();
			for (TypeToken tt : ts.getTypeTokens()) {
				for (ErrorTypes et : tt.getType()) {

					associatedModel.addErrorType(et.getName());
					tmpMap.put(et.getName(), errorVal++);
				}
			}
		}
		Collection<ErrorPropagation> inprops = EMV2Util
				.getAllIncomingErrorPropagations(aadlComponent.getComponentClassifier());
		for (ErrorPropagation ep : inprops) {

			/**
			 * For each incoming propagation point, we add a variable for the component.
			 * This variable might be updated/changed by other components connected
			 * to this incoming propagation.
			 */
			FeatureorPPReference fr = ep.getFeatureorPPRef();
			NamedElement feature = fr.getFeatureorPP();

			int errorVal = 1;
			TypeSet ts = ep.getTypeSet();
			for (TypeToken tt : ts.getTypeTokens()) {
				for (ErrorTypes et : tt.getType()) {
					associatedModel.addErrorType(et.getName());
					Expression e = new Equal(
							new Terminal(
									Util.getComponentIncomingPropagationVariableName(aadlComponent, feature.getName())),
							new Terminal("" + errorVal++));

					Formula f = new Formula(
							Util.getComponentIncomingPropagationVariableName(aadlComponent, feature.getName()) + "_get_"
									+ et.getName().toLowerCase(),
							e);
					formulas.add(f);
				}

				associatedModel.getGlobals().put(
						Util.getComponentIncomingPropagationVariableName(aadlComponent, feature.getName()),
						errorVal - 1);

			}
		}

		/**
		 * For each statement of the composite error behavior
		 * we map it into a formula so that we can use it for making
		 * evaluation/computation.
		 * For each composite state, we have something like
		 *
		 */
		Collection<CompositeState> compositestates = EMV2Util
				.getAllCompositeStates(aadlComponent.getComponentClassifier());
		int n = 0;

		for (CompositeState state : compositestates) {
			Expression e = handleCompositeCondition(state.getCondition());

			Formula f = new Formula(
					Util.getComponentName(aadlComponent) + "_is_" + state.getState().getName().toLowerCase() + n, e);
			formulas.add(f);
			n++;
		}

		/**
		 *
		 * Then, we generate command for each transition.
		 */
		for (ErrorBehaviorTransition trans : EMV2Util
				.getAllErrorBehaviorTransitions(aadlComponent.getComponentClassifier())) {
			handleTransition(trans);
		}

		for (OutgoingPropagationCondition opc : EMV2Util
				.getAllOutgoingPropagationConditions(aadlComponent.getComponentClassifier())) {
			handleOutgoingPropagationCondition(opc);
		}
		return this;
	}

	private void handleOutgoingPropagationCondition(OutgoingPropagationCondition outgoingPropagation) {
		Command command;
		Expression before;
		Expression after;
		Transition transaction;
		String incomingPropagationName;
		List<PropagationPathEnd> propagationEnds;

		int tmpState;
		int errorValue;
		propagationEnds = associatedModel.getAnalysisModel().getAllPropagationDestinationEnds(aadlComponent,
				outgoingPropagation.getOutgoing());

		for (PropagationPathEnd ppe : propagationEnds) {
			command = new Command();

			NamedElement connectedFeature = ppe.getErrorPropagation().getFeatureorPPRef().getFeatureorPP();

			incomingPropagationName = connectedFeature.getName();

			tmpState = statesMap.get(outgoingPropagation.getState().getName());

			before = new Equal(new Terminal(Util.getComponentStateVariableName(aadlComponent)),
					new Terminal("" + tmpState));

			errorValue = associatedModel.getErrorTypeCode(ppe, outgoingPropagation.getTypeToken());
			after = new Equal(new Terminal(Util.getComponentIncomingPropagationVariableName(ppe.getComponentInstance(),
					incomingPropagationName), true), new Terminal("" + errorValue));
			transaction = new Transition(after);

			for (Command c : commands) {

				if ((c.getCondition() instanceof Equal) && (c.getCommandType() == CommandType.PROPAGATION)) {
					if (c.getCondition().toString().equals(before.toString())) {
						c.getTransitions().get(0).addExpression(after);
						return;
					}
				}
			}

			command.setCommandType(CommandType.PROPAGATION);
			command.setCondition(before);
			command.addTransition(transaction);
			commands.add(command);
		}
	}

	private Expression handleTransitionCondition(ConditionExpression condition) {
		Expression result = null;

		if (condition instanceof ConditionElement) {
			ConditionElement conditionElement = (ConditionElement) condition;
			EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(conditionElement);
			if (eop instanceof ErrorPropagation) {
				int errorTypeValue = 0;
				// FIXME Julien: Find the appropriate id that correspond to the propagation code
				ErrorPropagation incomingErrorPropagation = (ErrorPropagation) eop;
				List<PropagationPathEnd> propagationEnds = associatedModel.getAnalysisModel()
						.getAllPropagationSourceEnds(aadlComponent, incomingErrorPropagation);

				for (PropagationPathEnd ppe : propagationEnds) {
					NamedElement connectedFeature = ppe.getErrorPropagation().getFeatureorPPRef().getFeatureorPP();

					ErrorTypes et = incomingErrorPropagation.getTypeSet().getTypeTokens().get(0).getType().get(0);

					if (conditionElement.getConstraint().getTypeTokens().isEmpty()) {
						errorTypeValue = 0;
					} else {
						errorTypeValue = associatedModel.getErrorTypeCode(ppe, et);
					}
				}
				result = new Equal(
						new Terminal(Util.getComponentIncomingPropagationVariableName(aadlComponent,
								incomingErrorPropagation.getFeatureorPPRef().getFeatureorPP().getName())),
						new Terminal("" + errorTypeValue));
			}
		}
		if (condition instanceof AndExpression) {
			AndExpression andExpression = (AndExpression) condition;
			result = new And(handleTransitionCondition(andExpression.getOperands().get(0)),
					handleTransitionCondition(andExpression.getOperands().get(1)));
		}

		return result;
	}

	private void handleTransition(ErrorBehaviorTransition trans) {
		Command command;
		Expression after = null;
		double probability;
		int tmpState;

		tmpState = statesMap.get(trans.getSource().getName());

		Expression before = new Equal(new Terminal(Util.getComponentStateVariableName(aadlComponent)),
				new Terminal("" + tmpState));

		command = new Command();

		/**
		 * This is a simple transition like this
		 * tfail: Operational -[Failure ]-> Failed;
		 * In that case, we take the probability from the OccurenceDistribution
		 * value associated to the event failure (named Failure in the following
		 * example).
		 */

		if (trans.getTarget() != null) {
			probability = Util.translateConditionToProbability(aadlComponent, trans.getCondition());

			if (probability == 0) {
				if (trans.getCondition() instanceof ConditionElement) {
					ConditionElement conditionElement = (ConditionElement) trans.getCondition();
					EventOrPropagation eop = EMV2Util.getErrorEventOrPropagation(conditionElement);
					// OsateDebug.osateDebug("[Utils] incoming :" + event);
					if ((eop != null) && (eop instanceof ErrorEvent)) {
						/*
						 * If the probability is 0 and this is just an event, we should not generate anything.
						 * We just return and do not add any new command.
						 */
						return;
					}
				}

				Expression conditionExpression = handleTransitionCondition(trans.getCondition());
				if (conditionExpression != null) {
					before = new And(before, conditionExpression);
				}

				tmpState = statesMap.get(trans.getTarget().getName());
				after = new Equal(new Terminal(Util.getComponentStateVariableName(aadlComponent), true),
						new Terminal("" + tmpState));
				Transition transaction = new Transition(after);

				/**
				 * We try to find if other variables may be updated when switching
				 * to the new state. The getAdditionalAssignments () provides
				 * a list of expression to perform for that particular case.
				 */
				List<Expression> additionalAssignments = getAdditionalAssignments(trans.getTarget());

				for (Expression e : additionalAssignments) {
					transaction.addExpression(e);

				}

				command.addTransition(transaction);
			} else {

				tmpState = statesMap.get(trans.getTarget().getName());
				after = new Equal(new Terminal(Util.getComponentStateVariableName(aadlComponent), true),
						new Terminal("" + tmpState));
				Transition transaction = new Transition(probability, after);

				/**
				 * We try to find if other variables may be updated when switching
				 * to the new state. The getAdditionalAssignments () provides
				 * a list of expression to perform for that particular case.
				 */
				List<Expression> additionalAssignments = getAdditionalAssignments(trans.getTarget());

				for (Expression e : additionalAssignments) {
					transaction.addExpression(e);

				}

				command.addTransition(transaction);
			}
		}

		/**
		 * When we have a destination branch, this is the case when we have
		 * a transition like this:
		 * 			treset: Failed -[ ResetEvent ]->  (Operational with 0.8, Failed with 0.2);
		 * It means that, from the same state, we can go to different other
		 * states with different probability. Here, when we are in failed and ResetEvent
		 * is triggered, we go to Operational with a probability of 0.8 or stay
		 * in Failed with a probability of 0.2.
		 */
		if (trans.getDestinationBranches() != null) {
			double mainProbability = Util.translateConditionToProbability(aadlComponent, trans.getCondition());

			List<TransitionBranch> branches = trans.getDestinationBranches();
			for (TransitionBranch tb : branches) {
				probability = Double.parseDouble(tb.getValue().getRealvalue());

				tmpState = statesMap.get(tb.getTarget().getName());
				after = new Equal(new Terminal(Util.getComponentStateVariableName(aadlComponent), true),
						new Terminal("" + tmpState));
				Transition transition = new Transition(mainProbability * probability, after);

				/**
				 * We try to find if other variables may be updated when switching
				 * to the new state. The getAdditionalAssignments () provides
				 * a list of expression to perform for that particular case.
				 */
				List<Expression> additionalAssignments = getAdditionalAssignments(tb.getTarget());
				for (Expression e : additionalAssignments) {
					transition.addExpression(e);

				}

				command.addTransition(transition);

			}
		}

		/**
		 * We try to find other conditions that may trigger
		 * this transition (guard conditions).
		 */
		for (Expression e : Util.findOtherConditions(aadlComponent, trans)) {
			before = new And(before, e);
		}
		command.setCondition(before);
		commands.add(command);

	}

}
