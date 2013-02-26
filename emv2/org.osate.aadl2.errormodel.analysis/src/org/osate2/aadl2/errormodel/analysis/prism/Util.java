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

public class Util {
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
	
	public static String getComponentStateVariableName (ComponentInstance ci)
	{
		return getComponentName(ci)+"_state";
	}
	
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
