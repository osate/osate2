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
	private static List<String>        currentHandledStates;
	
	public static void init ()
	{
		currentHandledStates = new ArrayList<String>();
	}
	
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
	
	public static void handleCondition (Event event, final ConditionExpression cond, final EList<ComponentInstance> componentInstances)
	{
		if (cond instanceof ConditionElement)
		{
			ConditionElement conditionElement;
			
			conditionElement = (ConditionElement) cond;

			ErrorBehaviorState behaviorState = conditionElement.getReference();

			for (SubcomponentElement subcomponentElement : conditionElement.getSubcomponents())
			{
				Subcomponent subcomponent = subcomponentElement.getSubcomponent();
				OsateDebug.osateDebug("cond = " + cond + "      subcomponent=" + subcomponent);
				ComponentInstance relatedInstance = findInstance(componentInstances, subcomponent.getName());
				//OsateDebug.osateDebug("         instance " + relatedInstance);
				
				if (behaviorState != null)
				{

					if (event.getEventType() != EventType.NORMAL)
					{
						Event resultEvent = new Event();
						resultEvent.setEventType(EventType.NORMAL);
						fillFTAEventfromEventState(resultEvent, behaviorState, relatedInstance, componentInstances);
						
						event.addSubEvent(resultEvent);
					}
					else
					{
						fillFTAEventfromEventState(event, behaviorState, relatedInstance, componentInstances);
					}
				}
			}
		}
		
		
		if (cond instanceof SOrExpression)
		{
			SOrExpression sor = (SOrExpression)cond;
			if ((event.getEventType() != EventType.NORMAL) && (event.getEventType() != EventType.OR))
			{
				OsateDebug.osateDebug("[FTAUtils] Inconsistent composite behavior, expecting an OR condition");
			}
			event.setEventType(EventType.OR);
			for (ConditionExpression conditionExpression : sor.getOperands())
			{
				//OsateDebug.osateDebug("      operand=" + conditionExpression);
				//result += handleCondition (conditionExpression, componentInstances);
				Event resultEvent = new Event ();
				handleCondition(resultEvent, conditionExpression, componentInstances);
				event.addSubEvent(resultEvent);
			}
		}
		
		if (cond instanceof SAndExpression)
		{
			SAndExpression sae = (SAndExpression) cond;
			if ((event.getEventType() != EventType.NORMAL) && (event.getEventType() != EventType.AND))
			{
				OsateDebug.osateDebug("[FTAUtils] Inconsistent composite behavior, expecting an AND condition");
			}
			event.setEventType(EventType.AND);
			for (ConditionExpression conditionExpression : sae.getOperands())
			{
				//OsateDebug.osateDebug("      operand=" + conditionExpression);
				//result += handleCondition (conditionExpression, componentInstances);
				Event resultEvent = new Event ();
				handleCondition(resultEvent, conditionExpression, componentInstances);
				event.addSubEvent(resultEvent);
			}
		}
	}
	
	
	public static void fillCompositeBehavior (Event ftaEvent, CompositeErrorBehavior compositeErrorBehavior, String stateName, ComponentInstance relatedInstance, final EList<ComponentInstance> componentInstances)
	{
		EList<CompositeState> 		states;
		int 						nBranches;

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
			ftaEvent.setEventType(EventType.OR);
			ftaEvent.setName("State to " + stateName);
		}
		
		for (CompositeState state : states)
		{
			if (state.getState().getName().equalsIgnoreCase(stateName))
			{
				
				ErrorBehaviorState ebs = (ErrorBehaviorState) state.getState();

				Event targetEvent;
				if (nBranches > 1)
				{
					targetEvent = new Event();
				}
				else
				{
					targetEvent = ftaEvent;
				}
				FTAUtils.fillFTAEventfromEventState (targetEvent, ebs, relatedInstance, componentInstances);
				FTAUtils.handleCondition (targetEvent, state.getCondition(), componentInstances);
				if (nBranches > 1)
				{
					ftaEvent.addSubEvent(targetEvent);
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
