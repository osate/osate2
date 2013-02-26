package org.osate2.aadl2.errormodel.analysis.prism;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

/**
 * Utility methods used for the AADL to PRISM translator
 * 
 * @author jdelange
 *
 */
public class Util 
{
	
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
	public static String getComponentName (ComponentInstance ci)
	{
		StringBuffer sb = new StringBuffer();
		ComponentInstance t;
		
		t = ci;
		while ( t != null)
		{
			sb.append(t.getName().toLowerCase());
			t = t.getContainingComponentInstance();
		}
		return sb.toString();
	}
	
	/**
	 * Each AADL component mapped into PRISM has a state variable
	 * This method returns the identifier of the state
	 * variable for a given component.
	 * @param ci	The AADL ComponentInstance that should be mapped
	 * @return		The name of the state variable identifier
	 */
	public static String getComponentStateVariableName (ComponentInstance ci)
	{
		return getComponentName(ci)+"_state";
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
	public static double translateConditionToProbability (ComponentInstance instance, ConditionExpression condition)
	{
		double res = 0.0;
		OsateDebug.osateDebug("[Utils] translateConditionToProbability:" + condition);
		if (condition instanceof ConditionElement)
		{
			ConditionElement conditionElement 	= (ConditionElement) condition;
			EventOrPropagation event   		  	= (EventOrPropagation) conditionElement.getIncoming();
			TypeSet typeSet						= (TypeSet) conditionElement.getConstraint();
			
			
			OsateDebug.osateDebug("[Utils]    incoming :" + event);
			if ((event != null) && (event instanceof ErrorEvent))
			{

				ErrorEvent ee = (ErrorEvent) event;
				OsateDebug.osateDebug("[Utils]       Event kind:" + ee);

				ContainedNamedElement PA = EM2Util.getOccurenceDistributionProperty(instance,null,ee,null);
				OsateDebug.osateDebug("[Utils]       PA :" + PA);

				res = EM2Util.getOccurenceValue (PA);
			}
			
			if ((event != null) && (event instanceof RecoverEvent))
			{
				RecoverEvent re = (RecoverEvent) event;
				OsateDebug.osateDebug("[Utils]       Recover kind:" + re);

				ContainedNamedElement PA = EM2Util.getOccurenceDistributionProperty(instance,null,re,null);
				OsateDebug.osateDebug("[Utils]       PA :" + PA);

				res = EM2Util.getOccurenceValue (PA);
			}
			OsateDebug.osateDebug("[Utils]    constraint :" + typeSet);
		}
		
		return res;
	}
}
