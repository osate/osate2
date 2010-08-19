package fr.tpt.aadl.annex.behavior.analyzers ;

import java.util.ArrayList ;
import java.util.Comparator ;
import java.util.HashSet ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Set ;

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
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral ;
import fr.tpt.aadl.annex.behavior.aadlba.Target ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
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
      result &= checkForForAllElementVariableAsTarget() ;
      result &= checkActionSetVariables();
      result &= checkBasicActions();
      
      return result ;
   }
   
   // Performs basic action checking.
   private boolean checkBasicActions()
   {
      boolean result = true ;
      BehaviorActions behActions = null ;
      EList<BasicAction> lBasicActions = null ;
      
      for(BehaviorTransition bt : _ba.getTransitions())
      {
         behActions = bt.getBehaviorActionsOwned() ;
         
         lBasicActions = AadlBaVisitors.getBasicActions(behActions) ;
         
         for(BasicAction basicAct : lBasicActions)
         {
            // Assignment action checking.
            if(basicAct instanceof AssignmentAction)
            {
               AssignmentAction aa = (AssignmentAction) basicAct ;
               result &= checkPortOneDimensionArray(aa);
               continue ;
            }
            
            // Timed action checking.
            if(basicAct instanceof TimedAction)
            {
               TimedAction ta = (TimedAction) basicAct ;
               try { result &= checkTimedActionsMinMaxParam(ta) ; }
               catch (ClassCastException e)
               {
                  reportLegalityWarning(ta,
                        "cannot check legality rule X.6.(L21) " +
                        "because one of the behavior times is not a numerical "+
                        "literal integer constant") ;
               }
               continue ;
            }
         }
      }
      
      return result ;
   }
   
   /**
    * Document: AADL Behavior Annex draft
    * Version : 2.13
    * Type    : Legality rule
    * Section : X.6 Assignment actions
    * Object  : Check legality rule X.6.(L21)
    * Keys    : timed actions, max min parameter
    */
   // Throws ClassCastException if behavior time are not numeric literal
   // integer constants.
   private boolean checkTimedActionsMinMaxParam(TimedAction timedAct)
                                                       throws ClassCastException
   {
      boolean result = true ;
      
      EList<BehaviorTime> lbt = timedAct.getBehaviorTimesOwned() ;
      
      // Check integer values.
      for(BehaviorTime bt : lbt)
      {
         result &= AadlBaUtils.checkBehaviorTime(bt, _errManager);
      }
      
      if (lbt.size() == 2)
      {
         Comparator<BehaviorTime> comp =
                                    AadlBaUtils.createBehaviorTimeComparator() ;
         
         boolean tmp = comp.compare(lbt.get(0), lbt.get(1)) <= 0 ;
         
         // Legality rule X.6.(L21) failure reporting.
         if(! tmp)
         {
            reportLegalityError(lbt.get(0), " in timed actions, the value of " +
                  " the first parameter must be lesser than the second one : " +
                  "Behavior Annex X.6.(L21) legality rule failed") ;
         }
         
         return result & tmp ;
      }
      else // No need to check as only one behavior time is given.
      {
         return result ;
      }
   }

   /**
    * Document: AADL Behavior Annex draft
    * Version : 2.13
    * Type    : Legality rule
    * Section : X.6 Assignment actions
    * Object  : Check legality rule X.6.(L20)
    * Keys    : port name, one dimension array
    */
   private boolean checkPortOneDimensionArray(AssignmentAction assignAct)
   {
      // TODO to be implemented.
      return false ;
   }

   /**
    * Document: AADL Behavior Annex draft
    * Version : 2.13
    * Type    : Legality rule
    * Section : X.6 Assignment actions
    * Object  : Check legality rule X.6.(L16), X.6.(L17)
    * Keys    : action set, local variable, port variable
    */
   private boolean checkActionSetVariables()
   {
      BehaviorActions beActions = null ;
      
      // Temporary list of dcr passed between recursive calls of
      // buildActionSetAssignedValuesLists method.
      List<DataComponentReference> lActionSetDcr =
                                       new ArrayList<DataComponentReference>() ;
      
      // Set of duplicated dcr between several action sets.
      Set<DataComponentReference> lDuplicates =
                                          new HashSet<DataComponentReference>();
      
      for(BehaviorTransition bt : _ba.getTransitions())
      {
         beActions = bt.getBehaviorActionsOwned() ;
         
         // Behavior transition's behavior actions may be null.
         if(beActions != null)
         {
            buildActionSetAssignedValuesLists(beActions, lActionSetDcr,
                                                                  lDuplicates) ;
            // Clear list between two calls in order to
            // avoid creating a list at each call of
            // buildActionSetAssignedValuesLists.
            lActionSetDcr.clear() ;
         }
      }
      
      for(DataComponentReference dcr : lDuplicates)
      {
         reportLegalityError(dcr, " assigned values are not accessible to"
         	+ " expressions of other assignment actions in the same action set" 
            + " : Behavior Annex X.6.(L16) or X.6.(L17) legality rule failed") ;
      }
      
      return lDuplicates.isEmpty() ;
   }
   
   /**
    * Recursively builds a list of assigned values contained
    * in a given BehaviorActions tree and checks for duplicates and populates 
    * a duplicate list every action set nodes met in the tree.<BR><BR>
    * 
    * A special attention is given to report legality rules X.6.(L16) and (L17)
    * failures : in order to help the user to correct his errors, the duplicate
    * list contains all instances of duplicate assigned values. 
    * 
    * @param beActions The given BehaviorActions tree.
    * @param lActionSetDcr The list of assigned valued
    * @param lDuplicates The list of duplicated assigned values.
    */
   @SuppressWarnings("unchecked") // As Java 1.6 can't create generic array.
   private void buildActionSetAssignedValuesLists(BehaviorActions beActions,
                                     List<DataComponentReference> lActionSetDcr,
                                        Set<DataComponentReference> lDuplicates)
   {
      // Current assigned values list reference. It can be lActionSetDcr
      // (the recursive list) or, in case of action set node, the list created 
      // to collect the assigned values contained in the current BehaviorAction
      // of the action set.
      List<DataComponentReference> lCurrentActionSetDcr = null ;
      
      // An array to keep the reference of the created lists.
      List<DataComponentReference> llActionSetDcr[] = null ;
      
      // List of BehaviorAction objects contained in the given BehaviorActions
      // tree.
      List<BehaviorAction> lbeActs = beActions.getBehaviorAction() ;
      
      // Current BehaviorAction object.
      BehaviorAction behAct = null ;
      
      // If the given BehaviorActions is a action set, create the array as
      // a list of assigned values will be created for each 
      // action set's behavior action.
      if(beActions.isSet())
      {
         llActionSetDcr = new List[lbeActs.size()];
      }
      
      // For each BehaviorAction of the given BehaviorActions.
      for(int i = 0 ; i < lbeActs.size() ; i++)
      {
         behAct = lbeActs.get(i) ;
         
         // In case of an action set, create a list to collect assigned values
         // in the current BehaviorAction.
         if(beActions.isSet())
         {
            lCurrentActionSetDcr = new ArrayList<DataComponentReference>() ;
            llActionSetDcr[i] = lCurrentActionSetDcr ;
         }
         else // In the case of action sequence or a simple BehaviorActions :
              // use the recursive list of assigned values.
         {
            lCurrentActionSetDcr = lActionSetDcr ;
         }
         
         // Case of assignment action. Add the data component reference to the
         // current assigned values list.
         if(behAct.isBasicAction() && behAct.getBasicActionOwned() instanceof
                                                               AssignmentAction)
         {
            DataComponentReference tmp = ((AssignmentAction)
                                 behAct.getBasicActionOwned()).getTargetOwned()
                                             .getDataComponentReferenceOwned() ;
            lCurrentActionSetDcr.add(tmp) ;
            continue ;
         }
         
         // *** Case of recursive calls ***
         
         // Case of behavior actions.
         if(behAct.isBehaviorActions())
         {
            buildActionSetAssignedValuesLists(behAct.getBehaviorActionsOwned(),
                                              lCurrentActionSetDcr,
                                              lDuplicates) ;
            continue ;
         }
         
         // Case of if structure.
         if(behAct.isIf())
         {
            IfStatement ifStat = (IfStatement) behAct.getCondStatementOwned() ;
            for (BehaviorActions tmp : ifStat.getBehaviorActionsOwned())
            {
               buildActionSetAssignedValuesLists(tmp, lCurrentActionSetDcr,
                                                 lDuplicates) ;
            }
            continue ;
         }
         
         // Case of loops structures.
         if(behAct.isLoop())
         {
            LoopStatement loopStat = (LoopStatement) behAct
                                                      .getCondStatementOwned() ;
            buildActionSetAssignedValuesLists(loopStat.getBehaviorActionsOwned(),
                                            lCurrentActionSetDcr, lDuplicates) ;
            continue ;
         }
      } // End of first for.
      
      // If the given BehaviorActions is an action set, check for duplicate
      // assigned values in the lists from the BehaviorAction of the
      // action set. Complexity is O(n²) as the lists are not sorted.
      if(beActions.isSet())
      {
         List<DataComponentReference> lCurrent = null ;
         List<DataComponentReference> lOther = null ;
         Comparator<DataComponentReference> comp = AadlBaUtils
                                     .createDataComponentReferenceComparator() ;
         
         // Optimization flag to avoid adding the same dcr to the duplicate 
         // list.
         boolean hasToAdd = true ;
         
         // Compare the lists between them (no need to consider the final list).
         for(int i = 0 ; i < llActionSetDcr.length - 1 ; i++)
         {
            lCurrent = llActionSetDcr[i] ;
            
            for(DataComponentReference dcrCurrent : lCurrent)
            {
               // Compare current list with the others.
               for(int j = i+1 ; j < llActionSetDcr.length ; j++ )
               {
                  lOther = llActionSetDcr[j] ;
               
                  for(DataComponentReference dcrOther : lOther)
                  {
                     // Case of duplicate assigned value.
                     if(comp.compare(dcrCurrent, dcrOther) == 0)
                     {
                        // Add the current dcr if it hasn't be done yet.
                        if(hasToAdd)
                        {
                           lDuplicates.add(dcrCurrent) ;
                           hasToAdd = true ;
                        }
                     
                        lDuplicates.add(dcrOther) ;
                     }
                  }
               }
               
               hasToAdd = true ;
            }
         }
         
         // Add all assigned values in the recursive list for any higher level
         // action set checking.
         for (List<DataComponentReference> l : llActionSetDcr)
         {
            lActionSetDcr.addAll(l) ;
         }
      } // End of if(beActions.isSet()).
   }

  /**
    * Document: AADL Behavior Annex draft
    * Version : 2.13
    * Type    : Legality rule
    * Section : X.6 Assignment actions
    * Object  : Check legality rule X.6.(L15)
    * Keys    : assignment actions, for structure element, target
    */
   private boolean checkForForAllElementVariableAsTarget()
   {
      boolean result = true ;
      
      BehaviorActions beActions = null ;
      
      List<String> lforElementVariables = new ArrayList<String>() ;
      
      for(BehaviorTransition bt : _ba.getTransitions())
      {
         beActions = bt.getBehaviorActionsOwned() ;
         
         // Behavior transition's behavior actions may be null.
         if(beActions != null)
         {
            result &= checkForForAllElementVariableAsTarget(beActions,
                                                          lforElementVariables);
         }
      }
      
      return result ;
   }
   
   // Check X.6.(L15) rule for BehaviorActions objects and report any error.
   private boolean checkForForAllElementVariableAsTarget(
                                                      BehaviorActions beActions,
                                             List<String> lforElementVariables)
   {
      boolean result = true ;
      
      for(BehaviorAction beAct : beActions.getBehaviorAction())
      {
         // Case of basic action : check the rule (for structure's element
         // variable is not a valid assignment target).
         if(beAct.isBasicAction())
         {
            BasicAction basicAct = beAct.getBasicActionOwned() ;
            
            // Case of an assignment action. 
            if(basicAct instanceof AssignmentAction)
            {
               result &= checkForForAllElementVariableAsTarget(
                                 ((AssignmentAction) basicAct).getTargetOwned(),
                                            lforElementVariables) ;
            }
            
            // The other basic actions are not affected by this rule.
            continue ;
         }
         
         // *** Cases of recursive calls. ***
         
         // Case of behavior actions.
         if(beAct.isBehaviorActions())
         {
            result &= checkForForAllElementVariableAsTarget(
                                                beAct.getBehaviorActionsOwned(),
                                                lforElementVariables);
            continue ;
         }
         
         // Case of if structure. 
         if(beAct.isIf())
         {
            IfStatement ifStat = (IfStatement) beAct.getCondStatementOwned() ;
            
            for(BehaviorActions tmp : ifStat.getBehaviorActionsOwned())
            {
               result &= checkForForAllElementVariableAsTarget(tmp,
                                                          lforElementVariables);
            }
            continue ;
         }
         
         // Case of for/forall structures.
         if(beAct.isFor())
         {
            ForOrForAllStatement forStat = (ForOrForAllStatement)
                                                 beAct.getCondStatementOwned() ; 
            
            // Store the for structure's element variable name so as to check
            // the rule.
            lforElementVariables.add(forStat.getElement().getId()) ;
            
            result &= checkForForAllElementVariableAsTarget(
                                              forStat.getBehaviorActionsOwned(),
                                                lforElementVariables) ;
            
            
            // Remove the for structure's element variable name as the for
            // structure element variable scope end here.
            
            lforElementVariables.remove(forStat.getElement().getId());
            
            continue ;
         }
         
         // The other loops except the for/forall structure
         // (while and do until).
         if(beAct.isLoop())
         {
            LoopStatement otherLoopStat = (LoopStatement) 
                                                 beAct.getCondStatementOwned() ;
            
            result &= checkForForAllElementVariableAsTarget(
                                       otherLoopStat.getBehaviorActionsOwned(),
                                       lforElementVariables);
            continue ;
         }
      } // End of first for.
      
      return result ;
   }

   // Check X.6.(L15) rule for Target objects and report any error.
   // XXX : for structure's element variable substitute to any elements that have
   // the same name, until AADL BA committee clarifies its behavior towards  
   // BA local variable. SEE AadlBaNameResolver::checkForForAllElementVariable.
   private boolean checkForForAllElementVariableAsTarget(Target target,
                                    List<String> lforElementVariables)
   {
      // Ambiguity between a none qualified data component reference and a 
      // name.
      // Check the first name of data component reference names list only.
      
      Identifier targetId = target
         .getDataComponentReferenceOwned().getElementsNameOwned()
            .get(0).getIdentifier() ;
      
      for(String s : lforElementVariables)
      {
         // Case of a for structure's element variable used as a assignment
         // target.
         if(targetId.getId().equalsIgnoreCase(s))
         {
            // Report X.6.(L15) rule break.
            
            reportLegalityError(targetId,"Assignment target "+targetId.getId()+
            " is not a valid target: Behavior Annex X.6.(L15) legality rules " +
            "failed");
            
            return false ;
         }
      }
      
      return true ;
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
                  // the other behavior transitions.
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
   // unpaired dispatch triggers. Remove paired dispatch triggers from their
   // list.
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
   // TODO : can't test it as soon as timed or hybrid dispatch protocol are not
   // recognized by Osate.
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
                  // Check the rule only if the behavior time is contain a 
                  // numerical literal integer constant. Otherwise raise
                  // a warning.
                  if(time.getIntegerValueOwned() instanceof NumericLiteral)
                  {
                     lpv = AadlBaGetProperties.getPropertyValue(_baParentContainer,
                           ThreadProperties.DISPATCH_PROTOCOL) ;

                     value = ((edu.cmu.sei.aadl.aadl2.EnumerationValue)lpv.get(0))
                                                       .getLiteral().getName() ;

                     // Check the rule only for timed or hybrid dispatch 
                     // protocol.
                     if(value.equalsIgnoreCase(AadlBaGetProperties.TIMED) ||
                        value.equalsIgnoreCase(AadlBaGetProperties.HYBRID) ||
                        value.equalsIgnoreCase("periodic"))
                     {
                        lpv = AadlBaGetProperties.getPropertyValue(
                                  _baParentContainer, TimingProperties.PERIOD) ;

                        value = ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)lpv.get(0))
                                                             .getValueString() ;
                        unit = ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)lpv.get(0))
                                                           .getUnit().getName();
                        
                        // Case of NOT equivalent behavior times.
                        if (!(((NumericLiteral)time.getIntegerValueOwned())
                                    .getNumValue().equalsIgnoreCase(value) 
                               && time.getUnitIdentifier().getId()
                                                       .equalsIgnoreCase(unit)))
                        {
                           result = false ;
                           this.reportLegalityError(time, 
                                       " timeout behavior time must be equal to"
                                       + " AADL period property : Behavior" +
                                      " Annex X.4.(L13) legality rules failed");
                           continue ;
                        }
                     }
                  }
                  else // The behavior time doesn't contain a numerical 
                       // literal integer constant.
                  {
                        reportLegalityWarning(time, 
                          "cannot check legality rule X.4.(L13) because the " +
                          "behavior time is not a numerical literal integer " +
                          "constant") ;
                  } // End of third if.
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
   
   private void reportLegalityWarning(Element obj, String name)
   {
      _errManager.warning(obj, "Behavior Legality Warning: " + name + ".") ;
   }
}