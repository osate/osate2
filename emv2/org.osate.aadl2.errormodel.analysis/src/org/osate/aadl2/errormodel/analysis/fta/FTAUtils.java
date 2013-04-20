package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
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
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureReference;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorPropagationImpl;
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
		OsateDebug.osateDebug("[FTAUtils] Did not find the instance " + name);
		return null;
	}
	
	
	public static String getStateHash (ComponentInstance ci,ErrorBehaviorState ebs )
	{
		return ("##" + ci.getName() + ebs.getName()+ "##");
	}
	
	
	private static List<String> getInvolvedSubcomponents (final ConditionExpression cond,  final EList<ComponentInstance> componentInstances)
	{
		List<String> result = new ArrayList<String>();
		if (cond instanceof SOrExpression)
		{
			SOrExpression sor = (SOrExpression) cond;
			
			for (ConditionExpression conditionExpression : sor.getOperands())
			{
				if (conditionExpression instanceof ConditionElement)
				{
					ConditionElement conditionElement;
					
					conditionElement = (ConditionElement) conditionExpression;
					for (SubcomponentElement subcomponentElement : conditionElement.getSubcomponents())
					{
						Subcomponent subcomponent = subcomponentElement.getSubcomponent();
						OsateDebug.osateDebug("cond = " + cond + "      subcomponent=" + subcomponent);
						ComponentInstance relatedInstance = findInstance(componentInstances, subcomponent.getName());
						if (relatedInstance != null)
						{
							result.add (relatedInstance.getName());
						}
					}
				}
			}
		}
		if (cond instanceof SAndExpression)
		{
			SAndExpression sae = (SAndExpression) cond;
	
			for (ConditionExpression conditionExpression : sae.getOperands())
			{
				if (conditionExpression instanceof ConditionElement)
				{
					ConditionElement conditionElement;
					
					conditionElement = (ConditionElement) conditionExpression;
					for (SubcomponentElement subcomponentElement : conditionElement.getSubcomponents())
					{
						Subcomponent subcomponent = subcomponentElement.getSubcomponent();
						OsateDebug.osateDebug("cond = " + cond + "      subcomponent=" + subcomponent);
						ComponentInstance relatedInstance = findInstance(componentInstances, subcomponent.getName());
						if (relatedInstance != null)
						{
							result.add (relatedInstance.getName());
						}
					}
				}
			}
		}
		return result;
	}
	
	public static List<Event> findIncomingPropagations (ComponentInstance relatedInstance, ConditionElement conditionElement)
	{
		List<Event> propagations;
		Classifier cl;
		
		propagations = new ArrayList<Event>();
		cl = relatedInstance.getComponentClassifier();

		OsateDebug.osateDebug("relatedInstance" + relatedInstance);
		OsateDebug.osateDebug("condition ref" + conditionElement.getReference());
		OsateDebug.osateDebug("Classifier=" + cl);
		
		if (EMV2Util.hasComponentErrorBehavior(relatedInstance))
		{
			Collection<ErrorBehaviorTransition> transitions = EMV2Util.getAllErrorBehaviorTransitions(cl);
			for (ErrorBehaviorTransition t : transitions)
			{
				OsateDebug.osateDebug( " trans = " + t);
				OsateDebug.osateDebug("target="  + t.getTarget().getName());
				OsateDebug.osateDebug("condition="  + t.getCondition());
				if (t.getCondition() instanceof ConditionElement)
				{
					ConditionElement ce = (ConditionElement) t.getCondition();
					if (ce.getIncoming() != null)
					{
						EventOrPropagation eop = ce.getIncoming();
						if (eop instanceof ErrorPropagation)
						{
							ErrorPropagation ep = (ErrorPropagation) ce.getIncoming();
							Event newEvent = new Event ();
							String newEventName = "propagation from";
							TypeSet ts = ep.getTypeSet();
							List<FeatureReference> features = ep.getFeaturerefs();
							for (FeatureReference fe : features)
							{
								OsateDebug.osateDebug("fe="  + fe.getFeature());
								newEventName += " " + fe.getFeature().getName();
							}
							for (TypeToken tt : ts.getElementType())
							{
								OsateDebug.osateDebug("tt="  + tt.getType().get(0).getName());
								newEventName += " (type " +tt.getType().get(0).getName() +")";
							}
							newEvent.setName (newEventName);
							newEvent.setEventType(EventType.EVENT);
							propagations.add(newEvent);
							OsateDebug.osateDebug("ep="  + ep);
						}
						if (eop instanceof ErrorEvent)
						{
							
							ErrorEvent ev = (ErrorEvent) ce.getIncoming();
							OsateDebug.osateDebug("ev="  + ev);
						}

					}
				}
			}
		}
		return propagations;
	}

	
	public static void handleCondition (Event event, 
			                            final ErrorBehaviorState resultingBehaviorState, 
			                            final ComponentInstance relatedComponentInstance,
			                            final ConditionExpression cond, 
			                            final EList<ComponentInstance> componentInstances)
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
						List<Event> propagations = findIncomingPropagations (relatedInstance, conditionElement);
						for (Event tmpEvent : propagations)
						{
							event.addSubEvent(tmpEvent);
						}
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
			
			String desc;
			desc = "\"occurrence of one event";
			if(getInvolvedSubcomponents (cond, componentInstances).size() > 0)
			{
				boolean first = true;
				desc += " (from ";
				for (String s : getInvolvedSubcomponents (cond, componentInstances))
				{
					
					if (first == false)
					{
						desc += ", ";
					}
					desc += s;
					first = false;
				}
				desc += ")";
			}
			desc += "\"";

			event.setDescription(desc);
						
			for (ConditionExpression conditionExpression : sor.getOperands())
			{
				//OsateDebug.osateDebug("      operand=" + conditionExpression);
				//result += handleCondition (conditionExpression, componentInstances);
				Event resultEvent = new Event ();
				handleCondition(resultEvent, resultingBehaviorState, relatedComponentInstance, conditionExpression, componentInstances);
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
			String desc;
			desc = "\"combination of events";
			if(getInvolvedSubcomponents (cond, componentInstances).size() > 0)
			{
				boolean first = true;
				desc += " (from ";
				for (String s : getInvolvedSubcomponents (cond, componentInstances))
				{
					
					if (first == false)
					{
						desc += ", ";
					}
					desc += s;
					first = false;
				}
				desc += ")";
			}
			desc += "\"";
			event.setDescription(desc);
						
			for (ConditionExpression conditionExpression : sae.getOperands())
			{
				//OsateDebug.osateDebug("      operand=" + conditionExpression);
				//result += handleCondition (conditionExpression, componentInstances);
				Event resultEvent = new Event ();
				handleCondition(resultEvent, resultingBehaviorState, relatedComponentInstance, conditionExpression, componentInstances);
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
			ftaEvent.setIdentifier("State to " + stateName);
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
				FTAUtils.handleCondition (targetEvent, ebs, relatedInstance, state.getCondition(), componentInstances);
				if (nBranches > 1)
				{
					ftaEvent.addSubEvent(targetEvent);
				}
			}
			

		}
	}
	
	public static String getDescription (ErrorBehaviorState behaviorState, ComponentInstance relatedComponentInstance)
	{
		TypeSet ts;
		ContainedNamedElement 		PA;
		ts = null;
		PA = null;
		
		ts = behaviorState.getTypeSet();
		
		PA = EMV2Util.getHazardProperty(relatedComponentInstance,null,behaviorState,ts);
		
		if (PA == null)
		{
			return null;
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
						text = text.replace('\"', ' ');
						return text;
					}
				} 
			}
		}
		return null;
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
		
		if (relatedComponentInstance == null)
		{
			OsateDebug.osateDebug("[FTAUtils] fillFTAEventfromEventState null event");
			return;
		}
		

		if (getDescription (behaviorState, relatedComponentInstance) != null)
		{
			event.setDescription("\"" + getDescription (behaviorState, relatedComponentInstance) + "(from " + relatedComponentInstance.getName() +")\"");
		}
		
		event.setName(behaviorState.getName() + "/" + relatedComponentInstance.getName()); 
		PA = EMV2Util.getOccurenceDistributionProperty(relatedComponentInstance,null,behaviorState,null);
		//OsateDebug.osateDebug("         PA " + PA);
		double prob = EMV2Util.getOccurenceValue (PA);
		event.setProbability(prob);
		
	}
	
}
