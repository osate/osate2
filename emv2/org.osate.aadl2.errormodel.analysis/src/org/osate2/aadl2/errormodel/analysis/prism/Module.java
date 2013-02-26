package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.Element;
import org.osate.aadl2.errormodel.analysis.actions.PRISMAction;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;
import org.osate2.aadl2.errormodel.analysis.prism.expression.*;

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
				sb.append (t.getProbability());	
				sb.append (" : ");
				sb.append ("(");
				sb.append (t.getExpression().toString());
				sb.append (")");
				alreadyOne = true;
			}
			
			/**
			 * If the sum of all probability is not reached, we keep the same state, nothing change
			 */
			if (sum < 1.0)
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
		ErrorModelSubclause errorModelSubclause = EM2Util.getErrorAnnexClause(aadlComponent);
		ComponentErrorBehavior errorBehavior = EM2Util.getComponentErrorBehavior (aadlComponent.getComponentClassifier());
		ErrorBehaviorStateMachine componentStateMachine = EM2Util.getContainingErrorBehaviorStateMachine(aadlComponent.getComponentClassifier());
		
		if (errorModelSubclause != null)
		{
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
				OsateDebug.osateDebug("[PRISM][Module.java]    ErrorTransition " + trans);
				OsateDebug.osateDebug("[PRISM][Module.java]       src= " + trans.getSource().getName());
				OsateDebug.osateDebug("[PRISM][Module.java]       target= " + trans.getTarget());
				OsateDebug.osateDebug("[PRISM][Module.java]       cond= " + trans.getCondition());
				OsateDebug.osateDebug("[PRISM][Module.java]       destination= " + trans.getDestinationBranches());

				
				tmpState = statesMap.get(trans.getSource().getName());
				
				Expression before = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent)),
											   new Terminal (""+tmpState));
				
				
				command = new Command ();
				command.setCondition (before);
				
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
					tmpState = statesMap.get(trans.getTarget().getName());
					after = new Equal (new Terminal (Util.getComponentStateVariableName(aadlComponent), true),
								   new Terminal (""+tmpState));
					command.addTransition (new Transition (probability, after));
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
						command.addTransition (new Transition (mainProbability * probability, after));

					}
				}

				
				this.commands.add (command);
			}
			
		}
		
		return this;
	}
}
