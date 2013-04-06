package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FTAUtils 
{
	private static ConditionExpression currentCondition  = null;
	private static FTAElement          currentFTAElement = null;
	private static List<String>        currentHandledStates;
	
	private static ComponentInstance findInstance (EList<ComponentInstance> instances, String name)
	{
		for (ComponentInstance ci : instances)
		{
			if (ci.getName().equalsIgnoreCase(name))
			{
				return ci;
			}
		}
		
		return null;
	}
	
	
	public static String getStateHash (ComponentInstance ci,ErrorBehaviorState ebs )
	{
		return ("##" + ci.getName() + ebs.getName()+ "##");
	}
	
	public static FTAElement handleCondition (final ConditionExpression cond, final EList<ComponentInstance> componentInstances)
	{
		FTAElement result;
		
		result = null;
		//OsateDebug.osateDebug("cond="+cond);
		
		if (cond instanceof ConditionElement)
		{
			ConditionElement conditionElement;
			
			conditionElement = (ConditionElement) cond;

			ErrorBehaviorState behaviorState = conditionElement.getReference();

			for (SubcomponentElement subcomponentElement : conditionElement.getSubcomponents())
			{
				Subcomponent subcomponent = subcomponentElement.getSubcomponent();
				//OsateDebug.osateDebug("      subcomponent " + subcomponent);
				ComponentInstance relatedInstance = findInstance(componentInstances, subcomponent.getName());
				//OsateDebug.osateDebug("         instance " + relatedInstance);
				

				
				if (behaviorState != null)
				{
					if ((currentHandledStates != null) && (currentHandledStates.contains(getStateHash(relatedInstance, behaviorState))))
					{
						return null;
					}
					currentHandledStates.add(getStateHash(relatedInstance, behaviorState));
					OsateDebug.osateDebug("[FTAUtils] adding hash" + getStateHash(relatedInstance, behaviorState));
					Event resultEvent = new Event();
					fillFTAEventfromEventState(resultEvent, behaviorState, relatedInstance, componentInstances);

					result = resultEvent;
				}
			}
		}
		
		
		if (cond instanceof SOrExpression)
		{
			SOrExpression sor = (SOrExpression)cond;
			OperatorOr resultOperand = new OperatorOr ();
			for (ConditionExpression conditionExpression : sor.getOperands())
			{
				//OsateDebug.osateDebug("      operand=" + conditionExpression);
				//result += handleCondition (conditionExpression, componentInstances);
				resultOperand.addOperand(handleCondition(conditionExpression, componentInstances));
			}
			result = resultOperand;
		}
		
		if (cond instanceof SAndExpression)
		{
			SAndExpression sae;
			OperatorAnd resultOperator;
			sae = (SAndExpression)cond;
			
			if ((currentFTAElement == null) || ( ! (currentFTAElement instanceof OperatorAnd)))
			{
				resultOperator = new OperatorAnd ();
				currentFTAElement = resultOperator;
				currentHandledStates = new ArrayList<String>();
				for (ConditionExpression conditionExpression : sae.getOperands())
				{
					resultOperator.addOperand(handleCondition(conditionExpression, componentInstances));

				}
				result = resultOperator;
			}
			else
			{
				resultOperator = (OperatorAnd) currentFTAElement;
				for (ConditionExpression conditionExpression : sae.getOperands())
				{
					result = handleCondition(conditionExpression, componentInstances);
					resultOperator.addOperand(result);
				}
			}
			

			return result;
		}
		return result;
	}
	
	
	public static void fillCompositeBehavior (Event ftaEvent, CompositeErrorBehavior compositeErrorBehavior, String stateName, ComponentInstance relatedInstance, final EList<ComponentInstance> componentInstances)
	{
		EList<CompositeState> 		states;
		int 						nBranches;
		OperatorOr					branch;
		
		branch = null;
		nBranches = 0;
		states = compositeErrorBehavior.getStates();
		
		for (CompositeState state : states)
		{
			if (state.getState().getName().equalsIgnoreCase(stateName))
			{
				nBranches++;
			}
		}
		
		if (nBranches > 1)
		{
			branch = new OperatorOr();
			ftaEvent.setIncomingOperator(branch);
		}
		
		for (CompositeState state : states)
		{
			if (state.getState().getName().equalsIgnoreCase(stateName))
			{
				
				ErrorBehaviorState ebs = (ErrorBehaviorState) state.getState();
				currentCondition = null;
				currentFTAElement = null;
				FTAUtils.fillFTAEventfromEventState (ftaEvent, ebs, relatedInstance, componentInstances);
				FTAElement tmp = FTAUtils.handleCondition (state.getCondition(), componentInstances);
				
				if (nBranches == 1)
				{
					if ((tmp != null) && (tmp instanceof Operator))
					{
						ftaEvent.setIncomingOperator((Operator)tmp);
					}

				}
				else
				{
					if (tmp instanceof Operator)
					{
						String desc = "errors";
						Event tmpEvent = new Event();
						tmpEvent.setName("");
						for (FTAElement e : ((Operator) tmp).getOperands())
						{
							if (e instanceof Event)
							{
								desc += " " + ((Event)e).getName();
							}
						}
						tmpEvent.setDescription(desc);
						tmpEvent.showProbability (false);
						tmpEvent.setIncomingOperator((Operator) tmp);
						branch.addOperand(tmpEvent);
					}
					if (tmp instanceof Event)
					{
						branch.addOperand(tmp);
					}
				}
			}
			

		}
	}
	
	
	public static void fillFTAEventfromEventState (Event event, ErrorBehaviorState behaviorState, ComponentInstance relatedComponentInstance, final EList<ComponentInstance> componentInstances)
	{
		TypeSet ts;
		ContainedNamedElement 		PA;
		ts = null;
		PA = null;
		
		if (event == null)
		{
			OsateDebug.osateDebug("[FTAUtils] fillFTAEventfromEventState null event");
			return;
		}
		
		if (behaviorState == null)
		{
			OsateDebug.osateDebug("[FTAUtils] fillFTAEventfromEventState null event");
			return;
		}
		
		
		ts = behaviorState.getTypeSet();
		
		PA = EMV2Util.getHazardProperty(relatedComponentInstance,null,behaviorState,ts);
		
		if (PA == null)
		{
			return;
		}
		
		for (ModalPropertyValue modalPropertyValue : AadlUtil.getContainingPropertyAssociation(PA).getOwnedValues()) {
			PropertyExpression val = modalPropertyValue.getOwnedValue();
			if (val instanceof RecordValue)
			{
				RecordValue rv = (RecordValue)val;
				EList<BasicPropertyAssociation> fields = rv.getOwnedFieldValues();
				BasicPropertyAssociation xref = GetProperties.getRecordField(fields, "description");
				if (xref != null){
					PropertyExpression peVal = xref.getOwnedValue();
					if (peVal instanceof StringLiteral){
						String text = ((StringLiteral)peVal).getValue();
						event.setDescription(text);
					}
				} 
			}
		}
		event.setName(behaviorState.getName() + "/" + relatedComponentInstance.getName()); 
		PA = EMV2Util.getOccurenceDistributionProperty(relatedComponentInstance,null,behaviorState,null);
		//OsateDebug.osateDebug("         PA " + PA);
		double prob = EMV2Util.getOccurenceValue (PA);
		event.setProbability(prob);
		
	}
	
}
