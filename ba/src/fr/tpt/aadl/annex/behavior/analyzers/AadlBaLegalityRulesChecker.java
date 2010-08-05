package fr.tpt.aadl.annex.behavior.analyzers ;

import java.util.Iterator ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.DeviceImplementation ;
import edu.cmu.sei.aadl.aadl2.DeviceType ;
import edu.cmu.sei.aadl.aadl2.DirectionType ;
import edu.cmu.sei.aadl.aadl2.EventDataPort ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.ThreadImplementation ;
import edu.cmu.sei.aadl.aadl2.ThreadType ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import edu.cmu.sei.osate.workspace.names.standard.ThreadProperties ;
import edu.cmu.sei.osate.workspace.names.standard.TimingProperties ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.impl.NumericLiteralImpl ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;

/*
--------------------------------------------------------------------------------
LEGALITY RULES
--------------------------------------------------------------------------------

.conditions
-------------------------------------------
- X.4.(L12) dispatch trigger condition, event data port and value others. Same
            as semantic rule X.4.(5). Implemented.


.timeout
-------------------------------------------
- X.4.(L13) timeout value, aadl core language property


.assignment actions
-------------------------------------------
- X.6.(L14) type of target and expression must match. Same as semantic rule X.6(17). 
            Not implemented.
- X.6.(L15) element_variable_identifier of for control struct is not a target
- X.6.(L16) action set and local variable
- X.6.(L17) action set and port variable


.timed actions
-------------------------------------------
- X.6.(L21) computation max >= min


.subprogram
-------------------------------------------
- X.6.(L18) parameter list and subprogram signature must match


.ports
-------------------------------------------
- X.6.(L20) port name only one dimension array


.expressions
-------------------------------------------
- X.7.(L22) a (L27)
 */

public class AadlBaLegalityRulesChecker
{
	private BehaviorAnnex _ba ;
	private ComponentClassifier _baParentContainer ;
	PackageSection[] _contextsTab ;
	private AnalysisErrorReporterManager _errManager ;

	public AadlBaLegalityRulesChecker(BehaviorAnnex ba,
	                                  AnalysisErrorReporterManager errManager)
	{
		_ba = ba ;
		_errManager = errManager ;
		_baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
		_contextsTab = AadlBaVisitors.getBaPackageSections(_ba) ;
	}

	public boolean checkLegalityRules()
	{
		boolean result = false ;

		result = checkTimeoutAndPeriodProperty() ;
		result &= checkValueOthersInDispatchTriggerCondition() ;
 
		return result ;
	}

	private boolean checkInputTimeAndFrozenPorts()
	{
		// TODO : to be implemented
		return false ;
	}

	// Return true if event data port checking succeed.
	// Populates EList if dispatch triggers can't be paired within the same 
	// dispatch logical expression.
	private boolean buildValueOthersTriggerListsInDispatchLogicalExpression
	                         (DispatchLogicalExpression dle,
	                          EList<DispatchTrigger> lunsolvedExternalWithValue,
	                          EList<DispatchTrigger> lunsolvedExternalWithOthers)
	{
	   boolean result = true ;
	   
	   EList<DispatchTrigger> lunsolvedInternalWithValue = 
	                                          new BasicEList<DispatchTrigger>() ;
	   EList<DispatchTrigger> lunsolvedInternalWithOthers = 
	                                          new BasicEList<DispatchTrigger>() ;
	   
	   for(DispatchTrigger trigg : dle.getDispatchTriggers())
	   {
	      // Case of a dispatch logical expression : recursive call.
	      if (trigg.getTheDispatchLogicalExpression() != null)
	      {
	         buildValueOthersTriggerListsInDispatchLogicalExpression(
	                                     trigg.getTheDispatchLogicalExpression(),
	                                           lunsolvedInternalWithValue,
	                                           lunsolvedInternalWithOthers);
	      }
	      else 
	      {
	         // TODO : numeral case.
	         
	         // Case of a simple dispatch trigger
	         
	         // Add concerned dispatch triggers to the list depending on its 
	         // value/others nature.
	         if(trigg.getValueConstantOwned() != null)
	         {
	            if(dle.isAndExpression())
	            {
	               // Case of AND relation.
	               // The current dispatch trigger can have its complementary
	               // within its behavior transition. So try to solve it.
	               lunsolvedInternalWithValue.add(trigg) ;
	            }
	            else // Case of OR or XOR relation.
	            {
	               // The current dispatch trigger can't have its complementary
	               // within its behavior condition. So try to solve it with
	               // the others behavior transitions.
	               lunsolvedExternalWithValue.add(trigg) ;
	            }
	            
	            // Check event data port. It Reports any error.
	            result &= AadlBaUtils.checkIdentifier(trigg.getIdentifierOwned(),
                                         EventDataPort.class, DirectionType.IN,
                                         _errManager) ;
	         }
	         
	         // Same as above but for keyword other.
	         if(trigg.isOthers())
	         {
	            if(dle.isAndExpression())
               {
                  lunsolvedInternalWithOthers.add(trigg) ;
               }
               else
               {
                  lunsolvedExternalWithOthers.add(trigg) ;
               }
	            
	            // Check event data port. It reports any error.
	            result &= AadlBaUtils.checkIdentifier(trigg.getIdentifierOwned(),
                                         EventDataPort.class, DirectionType.IN,
                                         _errManager) ;
	         }
	      } // End of else
	   } // End of for.
	   
	   if (result)
	   {
	      // Event data port and value checking succeed.
	      // Compare internal lists to find unresolved dispatch triggers.
	      compareDispatchTriggersValueOthersLists(lunsolvedInternalWithValue,
	                                              lunsolvedInternalWithOthers,
	                                              lunsolvedExternalWithValue) ;
	      compareDispatchTriggersValueOthersLists(lunsolvedInternalWithOthers,
	                                              lunsolvedInternalWithValue,
	                                              lunsolvedExternalWithOthers) ;
	     
	   }
	   
	   // Don't compare lists if checking failed.
	   return result ;
	}
	
	// Compare two list of dispatch triggers. Populates unsolved list with
	// unpaired dispatch triggers.
	private void compareDispatchTriggersValueOthersLists
	                                            (EList<DispatchTrigger> l1,
	                                             EList<DispatchTrigger> l2,
	                                             EList<DispatchTrigger> unsolved)
	{
	   boolean hasComplementary = false ;
	   
	   EList<Identifier> identifiersL1 = new BasicEList<Identifier>() ;
	   EList<Identifier> identifiersL2 = new BasicEList<Identifier>() ;
	   Iterator<DispatchTrigger> it2 = l2.iterator() ;
	   DispatchTrigger other = null ;
	   
	   for(DispatchTrigger trigg : l1)
      {
	      // Get behavior transition' source states list
	      // for this dispatch trigger
         identifiersL1.addAll(AadlBaVisitors.getBehaviorTransition(trigg)
                                                  .getSourceStateIdentifiers());
         
         // Add event data port identifier to the list.
         identifiersL1.add(trigg.getIdentifierOwned()) ;
         
         // Try to find a complementary to the current trigger.
         while(it2.hasNext())
         {
            other = it2.next() ;
            
            // Get behavior transition' source states list
            // for this dispatch trigger
            identifiersL2.addAll(AadlBaVisitors.getBehaviorTransition(other)
                                                 .getSourceStateIdentifiers()) ;
            
            // Add event data port identifier to the list.
            identifiersL2.add(other.getIdentifierOwned()) ;
            
            // compare to find the complementary dispatch trigger.
            hasComplementary |= AadlBaUtils.compareIdentifiersList(identifiersL1,
                                                                identifiersL2) ;
            
            // Reset list for the next trigger.
            identifiersL2.clear() ;
            
            if (hasComplementary)
            {
               // Remove matching DispatchTrigger.
               it2.remove() ;
               break ; // continue to the next dispatch trigger in l1.
            }
         }
         
         // Reset iterator.
         it2 = l2.iterator() ;
         
         if (hasComplementary)
         {
            // Case of the current dispatch trigger has a complementary one.
            // Reset hasComplementary flag.
            hasComplementary = false ;
         }
         else 
         {
            // Case of the current dispatch trigger hasn't a complementary one.
            // Then store it to the unsolved dispatch triggers list.
            unsolved.add(trigg) ;
         }
         
         // Reset list for the next trigger.
         identifiersL1.clear();
         
      } // End of first for.
	}
	
	// XXX : same as semantic rule X.4.(5)
	/**
    * Document: AADL Behavior Annex draft
    * Version : 2.13
    * Type    : Legality rule
    * Section : X.4 Thread Dispatch Behavior Specification
    * Object  : Check legality rule X.4.(L12)
    * Keys    : dispatch trigger, event data port, others
    */
	private boolean checkValueOthersInDispatchTriggerCondition()
	{
		boolean result = true ;
		
	   EList<DispatchTrigger> lwithValue = new BasicEList<DispatchTrigger>();
	   EList<DispatchTrigger> lwithOther = new BasicEList<DispatchTrigger>();
	   EList<DispatchTrigger> unsolved = new BasicEList<DispatchTrigger>();
	   
	   BehaviorCondition baCond = null ;
	   DispatchLogicalExpression dle = null ;
		
	   // Preliminaries checking and build dispatch trigger condition lists.
	   for(BehaviorTransition trans : _ba.getTransitions())
	   {
	      baCond = trans.getBehaviorConditionOwned() ;
	      
	      // Behavior condition may be null.
	      if(baCond != null && baCond instanceof DispatchCondition)
	      {
	         dle=((DispatchCondition) baCond).getTheDispatchLogicalExpression();
	         
	         // DispatchLogicalExpression may be null.
	         if (dle != null)
	         {
	            result &= 
	                      buildValueOthersTriggerListsInDispatchLogicalExpression
	                                              (dle, lwithValue, lwithOther) ;
	         }
	      }
	   }
	   
	   if (result) 
	   {
	      // Compare lists to find pair of dispatch trigger with value and with
	      // keyword others.
	      
	      compareDispatchTriggersValueOthersLists(lwithValue, lwithOther,
	                                                                  unsolved) ;
	      
	      compareDispatchTriggersValueOthersLists(lwithOther, lwithValue,
                                                                     unsolved) ;
	      for(DispatchTrigger trigg : unsolved)
         {
	         reportLegalityError(trigg, "Dispatch trigger hasn't a complementary"
	               + " one : Behavior Annex X.4.(L12) legality rules failed");
         }
	      
	      // Return false if any unsolved dispatch trigger.
	      result = unsolved.isEmpty() ;
	   }
	   
	   // Don't compare lists if preliminaries checking failed.
      return result ;
	}
   
   /**
	 * Document: AADL Behavior Annex draft 
	 * Version : 2.13 
	 * Type : Legality rule
	 * Section : X.4 Thread Dispatch Behavior Specification
	 * Object : Check legality rule X.4.(L13)
	 * Keys : dispatch trigger, timeout, behavior time
	 */
	// TODO : not tested yet.
	private boolean checkTimeoutAndPeriodProperty()
	{
		boolean result = true ;

		String value = null ;
		String unit = null ;

		BehaviorTime time = null ;
		
		EList<DispatchTrigger> ldt = null ;
		EList<BehaviorTransition> lbt = null ;
		EList<edu.cmu.sei.aadl.aadl2.PropertyValue> lpv = null ;
		if(_ba.isSetTransitions() &&
				(_baParentContainer instanceof ThreadImplementation
						|| _baParentContainer instanceof ThreadType 
						|| _baParentContainer instanceof DeviceImplementation 
						|| _baParentContainer instanceof DeviceType))
		{
			lbt = _ba.getTransitions() ;

			// FIXME : TODO : check if it have DispatchTriggers
			ldt = AadlBaVisitors.getBehaviorDispatchTriggers(lbt) ;

			// check if timeout triggers have behavior time
			for(DispatchTrigger dt : ldt)
			{
				if(dt.isTimeout() && dt.isSetTheBehaviorTime())
				{
				   time = dt.getTheBehaviorTime() ;
				   
				   // Check behavior time's integer value.
               // The method used reports any error.
               if (AadlBaUtils.checkIntegerValue(time.getIntegerValueOwned(),
                                                 _errManager))
               {
                  lpv = AadlBaGetProperties.getPropertyValue(_baParentContainer,
                        ThreadProperties.DISPATCH_PROTOCOL) ;

                  value = ((edu.cmu.sei.aadl.aadl2.EnumerationValue)lpv.get(0))
                                                       .getLiteral().getName() ;

                  if(value.equalsIgnoreCase(AadlBaGetProperties.TIMED) ||
                        value.equalsIgnoreCase(AadlBaGetProperties.HYBRID))
                  {
                     lpv = AadlBaGetProperties.getPropertyValue(
                                  _baParentContainer, TimingProperties.PERIOD) ;

                     value = ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)lpv.get(0))
                                                             .getValueString() ;
                     unit = ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)lpv.get(0))
                                                           .getUnit().getName();
                     
                     // Case of NOT equivalent behavior times.
                     if (!(((NumericLiteralImpl)time.getIntegerValueOwned())
                                 .getNumValue().equalsIgnoreCase(value) 
                            && time.getUnitIdentifier().equalsIgnoreCase(unit)))
                     {
                        result = false ;
                        this.reportLegalityError(time, 
                                       " timeout behavior time must be equal to"
                                                       + " AADL period property" 
                         + " : Behavior Annex X.4.(L13) legality rules failed");
                        continue ;
                     }
                  }
               } // End of second if.
               else // Case of behavior time is not an integer value.
               {
                  result = false ;
               }
				} // End of first if.
			} // End of for.
		}
		return result ;
	}

   // TODO Provide column number.
	private void reportLegalityError(Element obj, String name)
	{
		_errManager.error(obj, "Behavior Legality Error: " + name + ".") ;
	}

}