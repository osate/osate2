package org.osate.aadl2.errormodel.analysis.fta;

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
			SAndExpression sae = (SAndExpression)cond;
			OperatorAnd resultOperator;
			resultOperator = new OperatorAnd ();

			for (ConditionExpression conditionExpression : sae.getOperands())
			{
				resultOperator.addOperand(handleCondition(conditionExpression, componentInstances));

			}
			result = resultOperator;
		}
		return result;
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
		event.setName(behaviorState.getName()); 
		PA = EMV2Util.getOccurenceDistributionProperty(relatedComponentInstance,null,behaviorState,null);
		//OsateDebug.osateDebug("         PA " + PA);
		double prob = EMV2Util.getOccurenceValue (PA);
		event.setProbability(prob);
		
	}
	
}
