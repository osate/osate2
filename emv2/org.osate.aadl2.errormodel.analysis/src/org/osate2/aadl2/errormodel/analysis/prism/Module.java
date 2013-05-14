package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.errormodel.analysis.actions.PRISMAction;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPaths;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
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
	private List<Command> 			commands;
	private ComponentInstance 		aadlComponent;
	private int 					nStates;
	private Model					associatedModel;
	private Map<String,Integer>		statesMap;
	private	List<Formula>			formulas;
	private Map<String,Integer>		vars;
	/**
	 * 
	 * @param ci	The AADL component that corresponds to this PRISM module
	 * @param m		The PRISM model that contains this module
	 */
	public Module (ComponentInstance ci, Model m)
	{
		this.commands 			= new ArrayList<Command>();
		this.formulas 			= new ArrayList<Formula>();
		this.associatedModel    = m;
		this.aadlComponent 		= ci;
		this.nStates 			= 0;
		this.statesMap			= new HashMap<String,Integer>();
		this.vars    			= new HashMap<String,Integer>();
	}
	
	/**
	 * 
	 * @param ci	The AADL component that corresponds to this PRISM module
	 * @param m		The PRISM model that contains this module
	 * @param ns	Number of states (in that case, we do not auto-detect the number of states)
	 */
	public Module (ComponentInstance ci, Model m, int ns)
	{
		this (ci, m);
		this.nStates 			= ns;
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
	public String getPrismCode ()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append ("module " + Util.getComponentName (aadlComponent) + "\n");
		if (this.nStates > 0)
		{
			sb.append ("\t" + Util.getComponentName (aadlComponent) + "_state: [ 0 .. "+ (this.nStates - 1) +"] init 0;\n");
		}
		
		if (this.vars.size() > 0)
		{
			for (String s : this.vars.keySet())
			{
				int size = this.vars.get(s);
				sb.append ("\t" + Util.getComponentName (aadlComponent) + "_"+s.toLowerCase()+": [ 0 .. "+ size +"] init 0;\n");
			}
		}
		
		/**
		 * Here, we write each command with transition/probability that
		 * triggers state changes.
		 */
		for (Command command : commands)
		{
			double sum;
			boolean alreadyOne = false;
			sum = 0.0;
			sb.append ("\t[] " + command.getCondition().toString() +" -> ");
			for (Transition t : command.getTransitions())
			{
				sum = sum + t.getProbability();
				if (alreadyOne)
				{
					sb.append (" + ");	
				}
				if (t.useProbability())
				{
					sb.append (t.getProbability());	
					sb.append (" : ");
				}
				
				boolean firstExpression = true;
				for (Expression e : t.getExpressions())
				{
					if ( ! firstExpression )
					{
						sb.append ( " & ");
					}
					sb.append ("(");
					sb.append (e.toString());
					sb.append (")");
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
			if ((this.associatedModel.getType() == ModelType.DTMC) && (sum < 1.0))
			{
				sb.append (" + ");	
			
				sb.append (1.0 - sum);	
				sb.append (" : ");
				sb.append ("(");
				if (command.getCondition() instanceof Equal)
				{
					Equal e = (Equal)command.getCondition();
					Expression left = e.getLeft();
					if (left instanceof Terminal)
					{
						Terminal t = (Terminal) left;
						t.setUpdate(true);
					}
				}
				sb.append (command.getCondition().toString());
				sb.append (")");
				alreadyOne = true;
			}
			sb.append (";\n");

		}
		sb.append ("endmodule\n");
		
		/**
		 * Generate code for each formula associated
		 * with this module (for example, a formula
		 * that check the state of a module/component).
		 */
		for (Formula f : this.formulas)
		{
			sb.append ("\n");
			sb.append (f.getPRISMCode());
			sb.append ("\n");
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
	private List<Expression> getAdditionalAssignments (ErrorBehaviorState targetState)
	{
		List<Expression> exprs = new ArrayList<Expression>();
		
		ErrorModelSubclause errorModelSubclause = EMV2Util.getClassifierEMV2Subclause(aadlComponent.getComponentClassifier());

		if (errorModelSubclause.getErrorPropagations() != null)
		{
			for (ErrorFlow ef : errorModelSubclause.getErrorPropagations().getFlows())
			{
				if (ef instanceof ErrorSource)
				{
					ErrorSource errorSource = (ErrorSource)ef;
					Expression expr = null;
					expr = new Equal (new Terminal (Util.getFeatureName (aadlComponent, EMV2Util.getPrintName(errorSource.getOutgoing())), true),
									  new Terminal ("0"));

					if (errorSource.getFailureModeReference() instanceof ErrorBehaviorState)
					{
						ErrorBehaviorState state = (ErrorBehaviorState)errorSource.getFailureModeReference();
						if (state.getName() == targetState.getName())
						{
							TypeToken tt = errorSource.getTypeTokenConstraint().getElementType().get(0);
							String tokenName = tt.getType().get(0).getName();
							//OsateDebug.osateDebug("tokenName" + tokenName);
							expr = new Equal (new Terminal (Util.getFeatureName (aadlComponent, EMV2Util.getPrintName(errorSource.getOutgoing())), true),
									        		    new Terminal ("" + this.associatedModel.getPropagationMap().get(EMV2Util.getPrintName(errorSource.getOutgoing())).get(tokenName)));
							
						}
					}
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
	private Expression handleElement (final ConditionElement conditionElement)
	{

		ErrorBehaviorState behaviorState = conditionElement.getReference();

		for (SubcomponentElement subcomponentElement : conditionElement.getSubcomponents())
		{
			Subcomponent subcomponent = subcomponentElement.getSubcomponent();
			
			if (behaviorState != null)
			{
				return new Terminal (subcomponent.getName() + Util.getComponentName(aadlComponent) + "_is_" + behaviorState.getName().toLowerCase());

			}
		}
		
		return new Terminal ("unknown");
	}
	
	/**
	 * Mao a condition from a composite error behavior into a PRISM expression
	 * 
	 * @param cond	The Condition from the Error Composite Behavior to map
	 * @return A PRISM Expression, null if this cannot be mapped
	 */
	private Expression handleCompositeCondition (final ConditionExpression cond)
	{
		Expression res = null;
		
		if (cond instanceof ConditionElement)
		{
			res = handleElement((ConditionElement)cond);
		}
		
		if (cond instanceof SOrExpression)
		{
			SOrExpression sor = (SOrExpression)cond;
			res = new Or (handleCompositeCondition(sor.getOperands().get(0)), handleCompositeCondition(sor.getOperands().get(1)));
			
		}
		
		if (cond instanceof SAndExpression)
		{
			SAndExpression sae = (SAndExpression)cond;
			res = new And (handleCompositeCondition(sae.getOperands().get(0)), handleCompositeCondition(sae.getOperands().get(1)));
			
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
	public Module process ()
	{
		Command command;
		Expression after = null;
		double probability;
		int tmpState;
		
		OsateDebug.osateDebug("[PRISM][Module.java] Process " + aadlComponent.getName());
		
		ErrorBehaviorStateMachine useStateMachine = null;
		ErrorPropagations propagations = null;
		ComponentErrorBehavior errorBehavior = null;
		ErrorBehaviorStateMachine componentStateMachine = null;
		ErrorModelSubclause errorModelSubclause = null;
		
		errorModelSubclause = EMV2Util.getClassifierEMV2Subclause (aadlComponent.getComponentClassifier());
		
		if (errorModelSubclause == null)
		{
			return this;
		}
		
		errorBehavior = errorModelSubclause.getComponentBehavior();
		componentStateMachine = errorModelSubclause.getUseBehavior();
		CompositeErrorBehavior compositeErrorBehavior = errorModelSubclause.getCompositeBehavior();
		OsateDebug.osateDebug("[PRISM][Module.java] errorModelSubclause=" + errorModelSubclause);
		OsateDebug.osateDebug("[PRISM][Module.java] errorBehavior=" + errorBehavior);
		OsateDebug.osateDebug("[PRISM][Module.java] componentStateMachine=" + componentStateMachine);

		OsateDebug.osateDebug("[PRISM][Module.java] compositeErrorBehavior=" + compositeErrorBehavior);

		if (errorModelSubclause != null)
		{
			if (errorModelSubclause.getPropagationPaths() != null)
			{
				for ( PropagationPoint pp : errorModelSubclause.getPropagationPaths().getPoints())
				{
					OsateDebug.osateDebug("[PRISM][Module.java] pp=" + pp);
	
				}
			}
	
			useStateMachine = errorModelSubclause.getUseBehavior();
			OsateDebug.osateDebug("[PRISM][Module.java] Process error model annex subclause of " + aadlComponent.getName());

			if (useStateMachine != null)
			{
				for (ErrorBehaviorState behaviorState : errorModelSubclause.getUseBehavior().getStates())
				{
					OsateDebug.osateDebug("[PRISM][Module.java]    Use Behavior state " + behaviorState.getName());
				}
			}
		}
		
		if ((useStateMachine == null) && (componentStateMachine == null))
		{
			PRISMAction.reportWarning(aadlComponent,
					"Component " + aadlComponent.getName() + " should have an associated state machine");
		}
		
		/**
		 * Here, we map the states of the error state machine
		 * into a number. For that, we add the corresponding
		 * number to a HashMap. Then, we can retrieve
		 * the associated value of a state using the state name (a String)
		 * in the HashMap (called statesMap). There is one particular
		 * case for the default state that is always associated
		 * with 0.
		 */
		if (useStateMachine != null)
		{
			int stateIndex = 1;
			int stateValue;
			for (ErrorBehaviorState state : useStateMachine.getStates())
			{
				stateValue = stateIndex;
				if (state.isIntial())
				{
					stateValue = 0;
				}
				else
				{
					stateValue = stateIndex++;
				}
				statesMap.put(state.getName(), stateValue);

				/**
				 * Add an helper formula to easily know if the component reach a given state or not
				 * It generates formulas such as
				 * formula COMPONENT_IS_STATENAME = COMPONENT_STATE_VAR = STATE_VALUE
				 */
				Expression fe = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent)), new Terminal (""+stateValue));
				Formula f = new Formula (Util.getComponentName(aadlComponent)+"_is_"+state.getName().toLowerCase(), fe);
				this.formulas.add (f);
			}
			this.nStates = useStateMachine.getStates().size();
		}
		
		if (componentStateMachine != null)
		{
			OsateDebug.osateDebug("[PRISM][Module.java] Process state machine of " + aadlComponent.getName());

			for (ErrorBehaviorState behaviorState : componentStateMachine.getStates())
			{
				OsateDebug.osateDebug("state" + behaviorState);

			}
		}
		
		/**
		 * Here, we see if we have any error propagation.
		 * If yes, then, we declare a variable for each OUT port.
		 * The variable can have N values, N being the number of potential
		 * error types propagated. The variable has a value 0 if no error
		 * is propagated.
		 */
		if ((errorModelSubclause != null) && (errorModelSubclause.getErrorPropagations() != null))
		{
			propagations = errorModelSubclause.getErrorPropagations();
			for (ErrorPropagation ep : propagations.getPropagations())
			{
				OsateDebug.osateDebug("[PRISM][Module.java] Process propagation " + ep);
				
				/**
				 * For each incoming propagation point, we add a variable for the component.
				 * This variable might be updated/changed by other components connected
				 * to this incoming propagation.
				 */
				if (ep.getDirection().incoming())
				{
					OsateDebug.osateDebug("[PRISM][Module.java] incoming error propagation" + ep);
					for (FeatureReference fr : ep.getFeaturerefs())
					{
						NamedElement feature;
						feature = fr.getFeature();
						
						OsateDebug.osateDebug("[PRISM][Module.java]    " + feature.getName());
						int errorVal = 1;
						TypeSet ts = ep.getTypeSet();
						OsateDebug.osateDebug("[PRISM][Module.java] typeset " + ts);
						for (TypeToken tt : ts.getElementType())
						{
							for (ErrorType et : tt.getType())
							{
								OsateDebug.osateDebug("[PRISM][Module.java] typetoken " + et);

								this.associatedModel.addErrorType (et.getName());
								Expression e  = new Equal (new Terminal (Util.getComponentIncomingPropagationVariableName(this.aadlComponent, feature.getName())),
										        new Terminal (""+errorVal++));
								
								Formula f = new Formula (Util.getComponentIncomingPropagationVariableName(this.aadlComponent, feature.getName())+"_get_" + et.getName().toLowerCase() , e);
								this.formulas.add (f);
							}

						}
						this.vars.put (Util.getComponentIncomingPropagationVariableName(this.aadlComponent, feature.getName()), errorVal - 1);
					}
				}
				
				
				if (ep.getDirection().outgoing())
				{
					Map<String,Integer> tmpMap = new HashMap<String,Integer>();
					int errorVal = 1;
					TypeSet ts = ep.getTypeSet();
					OsateDebug.osateDebug("[PRISM][Module.java] typeset " + ts);
					for (TypeToken tt : ts.getElementType())
					{
						for (ErrorType et : tt.getType())
						{
							OsateDebug.osateDebug("[PRISM][Module.java] typetoken " + et);

							this.associatedModel.addErrorType (et.getName());
							tmpMap.put(et.getName(), errorVal++);
						}

					}
					//this.vars.put (EMV2Util.getPrintName(ep), errorVal - 1);
					this.associatedModel.getPropagationMap().put(EMV2Util.getPrintName(ep), tmpMap);
				}
			}
		}
		
		
		/**
		 * For each statement of the composite error behavior
		 * we map it into a formula so that we can use it for making
		 * evaluation/computation.
		 * For each composite state, we have something like
		 * 
		 */
		if (compositeErrorBehavior != null)
		{
			EList<CompositeState> states = compositeErrorBehavior.getStates();
			int n = 0;
			
			for (CompositeState state : states)
			{
				Expression e = handleCompositeCondition (state.getCondition());

				Formula f = new Formula (Util.getComponentName(aadlComponent)+"_is_" + state.getState().getName().toLowerCase() + n, e);
				this.formulas.add (f);
				n++;
			}
		}
		
		handleComponentBehavior (errorBehavior);
		
		if ( (errorBehavior == null) && (errorModelSubclause != null ) && (errorModelSubclause.getUseBehavior() != null))
		{
			OsateDebug.osateDebug("[Module] process state machine from errormodel subclause");
			handleBehavior (errorModelSubclause.getUseBehavior());
		}
		
		return this;
	}
	

	private void handleBehavior (ErrorBehaviorStateMachine errorBehavior)
	{
		if (errorBehavior != null)
		{
			OsateDebug.osateDebug("[PRISM][Module.java] Process error behavior of " + aadlComponent.getName());

			
			for (ErrorBehaviorEvent ed : errorBehavior.getEvents())
			{
				OsateDebug.osateDebug("[PRISM][Module.java]    ErrorEvent " + ed);
			}
			
			for (ErrorBehaviorTransition trans : errorBehavior.getTransitions())
			{
				handleTransition (trans);
			}
			
			
			
		}		
	}
	private void handleComponentBehavior (ComponentErrorBehavior errorBehavior)
	{
		if (errorBehavior != null)
		{
			OsateDebug.osateDebug("[PRISM][Module.java] Process error behavior of " + aadlComponent.getName());
	
			for (ErrorDetection ed : errorBehavior.getErrorDetections())
			{
				OsateDebug.osateDebug("[PRISM][Module.java]    ErrorDerection " + ed);
			}
			
			for (ErrorBehaviorEvent ed : errorBehavior.getEvents())
			{
				OsateDebug.osateDebug("[PRISM][Module.java]    ErrorEvent " + ed);
			}
			
			for (ErrorBehaviorTransition trans : errorBehavior.getTransitions())
			{
				handleTransition (trans);
			}
			
			for (OutgoingPropagationCondition opc : errorBehavior.getOutgoingPropagationConditions())
			{
				OsateDebug.osateDebug("[PRISM][Module.java]    OutgoingPropagationCondition " + opc);
				OsateDebug.osateDebug("[PRISM][Module.java]       state=" + opc.getState());
				OsateDebug.osateDebug("[PRISM][Module.java]       outgoing=" + opc.getOutgoing());
				handleOutgoingPropagationCondition (opc);
			}
			
		}		
	}

	private void handleOutgoingPropagationCondition (OutgoingPropagationCondition outgoingPropagation)
	{
		Command command;
		Expression before;
		Expression after;
		Transition transaction;
		FeatureInstance correspondingFeatureInstance;
		String incomingPropagationName;
		ErrorPropagation incomingPropagation; 
		int tmpState;

		OsateDebug.osateDebug("[PRISM][Module.java] handleOutgoingPropagationCondition " + outgoingPropagation);
		
		incomingPropagation = null;
		command = new Command();
		correspondingFeatureInstance = EMV2Util.findFeatureInstance(outgoingPropagation.getOutgoing(), this.aadlComponent);
		for (ConnectionInstance ci : correspondingFeatureInstance.getDstConnectionInstances())
		{
			OsateDebug.osateDebug("[PRISM][Module.java] cidest " + ci.getDestination());

			OsateDebug.osateDebug("[PRISM][Module.java] cicomp " + ci.getDestination().getContainingComponentInstance());
			
			//ErrorPropagation ep = EMV2Util.getIncomingErrorPropagation(ci.getDestination().getContainingComponentInstance());
			//OsateDebug.osateDebug("[PRISM][Module.java] ep " + ep);


		}
		ErrorPropagation founddst = EMV2Util.getIncomingErrorPropagation(correspondingFeatureInstance);
		if (founddst != null)
		{
			OsateDebug.osateDebug("[PRISM][Module.java] incoming propagation " + correspondingFeatureInstance);
			incomingPropagation = founddst;
		}
			
		
		if (incomingPropagation == null)
		{
			return;
		}
		Feature incomingFeature = (Feature) incomingPropagation.getFeaturerefs().get(0).getFeature();
		
		incomingPropagationName = incomingPropagation.getFeaturerefs().get(0).getFeature().getName();
		
		tmpState = statesMap.get(outgoingPropagation.getState().getName());
		
		before = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent)),
				   new Terminal (""+tmpState));
		
		after = new Equal (new Terminal (Util.getComponentIncomingPropagationVariableName(correspondingFeatureInstance.getContainingComponentInstance(), incomingPropagationName), true),
				   new Terminal (""+tmpState));
		transaction = new Transition (after);

		for (Command c : this.commands)
		{

			if ((c.getCondition() instanceof Equal) && (c.getCommandType() == CommandType.PROPAGATION))
			{
				if (c.getCondition().toString().equals(before.toString()))
				{
					c.getTransitions().get(0).addExpression(after);
					return;
				}
			}
		}
		
		command.setCommandType(CommandType.PROPAGATION);
		command.setCondition (before);
		command.addTransition(transaction);
		this.commands.add (command);
	}
	
	private void handleTransition (ErrorBehaviorTransition trans)
	{
		Command command;
		Expression after = null;
		double probability;
		int tmpState;
		
		OsateDebug.osateDebug("[PRISM][Module.java]    ErrorTransition " + trans);
		OsateDebug.osateDebug("[PRISM][Module.java]       src= " + trans.getSource().getName());
		OsateDebug.osateDebug("[PRISM][Module.java]       target= " + trans.getTarget());
		OsateDebug.osateDebug("[PRISM][Module.java]       cond= " + trans.getCondition());
		OsateDebug.osateDebug("[PRISM][Module.java]       destination= " + trans.getDestinationBranches());

		
		tmpState = statesMap.get(trans.getSource().getName());
		
		Expression before = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent)),
									   new Terminal (""+tmpState));
		
		
		command = new Command ();
		
		/**
		 * This is a simple transition like this
		 * tfail: Operational -[Failure ]-> Failed;
		 * In that case, we take the probability from the OccurenceDistribution
		 * value associated to the event failure (named Failure in the following
		 * example).
		 */
		
		if (trans.getTarget() != null)
		{
			probability = Util.translateConditionToProbability (aadlComponent, trans.getCondition());
			
			if (probability == 0)
			{
				return;
			}
			
			tmpState = statesMap.get(trans.getTarget().getName());
			after = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent), true),
						   new Terminal (""+tmpState));
			Transition transaction = new Transition (probability, after);
			
			/**
			 * We try to find if other variables may be updated when switching
			 * to the new state. The getAdditionalAssignments () provides
			 * a list of expression to perform for that particular case.
			 */
			List<Expression> additionalAssignments = getAdditionalAssignments(trans.getTarget());
			
			for (Expression e : additionalAssignments)
			{
				transaction.addExpression(e);
		
			}
			
			command.addTransition (transaction);
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
		if(trans.getDestinationBranches() != null)
		{
			double mainProbability = Util.translateConditionToProbability (aadlComponent, trans.getCondition());

			List<TransitionBranch> branches = trans.getDestinationBranches();
			for (TransitionBranch tb : branches)
			{
				OsateDebug.osateDebug("[PRISM][Module.java]          dest = " + tb);
				probability = Double.parseDouble(tb.getValue().getRealvalue());
				OsateDebug.osateDebug("[PRISM][Module.java]          probability = " + probability);
				OsateDebug.osateDebug("[PRISM][Module.java]          mainProbability = " + mainProbability);


				tmpState = statesMap.get(tb.getTarget().getName());
				after = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent), true),
							   new Terminal (""+tmpState));
				Transition transition = new Transition (mainProbability * probability, after);
				
				/**
				 * We try to find if other variables may be updated when switching
				 * to the new state. The getAdditionalAssignments () provides
				 * a list of expression to perform for that particular case.
				 */
				List<Expression> additionalAssignments = getAdditionalAssignments(tb.getTarget());
				for (Expression e : additionalAssignments)
				{
					transition.addExpression(e);
			
				}
				
				command.addTransition (transition);

			}
		}

		/**
		 * We try to find other conditions that may trigger
		 * this transition (guard conditions).
		 */
		for (Expression e : Util.findOtherConditions (aadlComponent, trans))
		{
			before = new And (before, e);
		}
		command.setCondition (before);
		this.commands.add (command);
	
	}
	
}
