package fr.tpt.aadl.annex.behavior.analyzers ;

import java.util.Iterator ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;

import edu.cmu.sei.aadl.aadl2.AnnexSubclause ;
import edu.cmu.sei.aadl.aadl2.Element ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
import fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch ;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch ;

public class AadlBaRulesCheckersDriver
{

   /**
   * Aadlba switch which overrides methods to process rule checking.
   */
   protected AadlBaSwitch<Boolean> aadlbaSwitch = null ;

   /**
   * Inherits from Osate2 (not used for instance)
   */
   private boolean notCancelled = true ;

   private BehaviorAnnex _ba ;
   private AadlBaLegalityRulesChecker _legality ;
   private AadlBaSemanticRulesChecker _semantic ;
   private AadlBaConsistencyRulesChecker _consistency ;

   public AadlBaRulesCheckersDriver(BehaviorAnnex ba,
                                    AnalysisErrorReporterManager errManager)
   {
      _ba = ba ;
      _legality = new AadlBaLegalityRulesChecker(ba, errManager) ;
      _semantic = new AadlBaSemanticRulesChecker(ba, errManager) ;
      _consistency = new AadlBaConsistencyRulesChecker(ba, errManager);
      this.initSwitches() ;
   }

   /**
    * Calls the package-specific switch
    */
   public final boolean process(Element theElement)
   {
      EClass theEClass = theElement.eClass() ;
      if(theEClass.eContainer() == AadlBaPackage.eINSTANCE)
      {
         Boolean result = aadlbaSwitch.doSwitch(theElement) ;
         
         // As default super methods return null, translate null to true means
         // nothing to check.
         if (result == null)
            return true ;
         else
            return result ;
      }
      else
      {
         System.err.println("the given element doesn't come from AADL BA model") ;
         return false ;
      }
   }

   /** 
    * This method checks notCancelled() after each element in the
    * list, and terminates the processing if the traversal has been cancelled.
    */
   public final boolean processEList(final EList<? extends Element> list)
   {
      Iterator<? extends Element> it = list.iterator() ;
      boolean result = true ;

      while(notCancelled && it.hasNext())
      {
         result &= this.process(it.next()) ;
      }

      return result ;
   }

   /**
    * Specific aadlba switch to drive semantic, legality and consistency rules.
    */
   protected void initSwitches()
   {
      aadlbaSwitch = new AadlBaSwitch<Boolean>()
      {
        /**
         * Top-level method to check "behavior_specification" 
         * annexsubclause
         */
         public Boolean caseAnnexSubclause(AnnexSubclause object)
         {
            boolean result = true ;

            if(_ba.isSetBehaviorStates())
            {
               EList<Identifier> initialStates = new BasicEList<Identifier>() ;
               EList<Identifier> completeStates = new BasicEList<Identifier>() ;
               EList<Identifier> finalStates = new BasicEList<Identifier>() ;

               for(BehaviorState bs : _ba.getBehaviorStates())
               {
                  for(Identifier i : bs.getIdentifiers())
                  {
                     if(bs.isInitial())
                     {
                        initialStates.add(i) ;
                     }

                     if(bs.isComplete())
                     {
                        completeStates.add(i) ;
                     }

                     if(bs.isFinal())
                     {
                        finalStates.add(i) ;
                     }
                  }
               } // End of first for.

               result &= _legality.D_3_L1_And_L2_Check(initialStates,
                                                       completeStates,
                                                       finalStates) ;
               result &= _legality.D_3_L3_Check(initialStates, completeStates) ;
               result &= _legality.D_3_L4_Check(initialStates, finalStates) ;

            }// End of first if.

            if(_ba.isSetBehaviorTransitions())
            {
               result &= processEList(_ba.getBehaviorTransitions()) ;
            }

            return result ;
         }
         
         public Boolean caseBehaviorTransition(BehaviorTransition bt)
         {
            boolean result = true ;
            
            // Check source identifiers.
            for(Identifier srcState : bt.getSourceStateIdentifiers())
            {
               result &= _legality.D_3_L6_Check(bt, srcState) ;
               result &= _legality.D_3_L7_Check(bt, srcState) ;
               result &= _legality.D_3_L8_Check(srcState) ;
               result &= _consistency.D_3_C4_Check(bt, srcState) ;
            }
            
            BehaviorCondition bc = bt.getBehaviorConditionOwned() ;
            
            // Check Dispatch condition.
            if(bc instanceof DispatchCondition)
            {
               result &= process(bc) ;
            }
            else // Check Execute condition. Warning Execution condition may be
                 // null.
            {
               result &= _semantic.D_3_18_Checker(bt);
            }
            
            if(bt.getBehaviorActionBlockOwned() != null)
            {
               result &= _legality.D_6_L3_And_L4_Check(
                                             bt.getBehaviorActionBlockOwned()) ;
               
               process(bt.getBehaviorActionBlockOwned()) ;
            }

            return result ;
         }
         
         public Boolean caseBehaviorActionBlock(BehaviorActionBlock bab)
         {
            return process(bab.getBehaviorActionsOwned()) ;
         }
         
         public Boolean caseBehaviorActionCollection(BehaviorActionCollection 
                                                                            bac)
         {
            return processEList(bac.getBehaviorActions()) ;
         }
         
         public Boolean caseIfStatement(IfStatement stat)
         {
            return processEList(stat.getBehaviorActionsOwned()) ;
         }
         
         public Boolean caseLoopStatement(LoopStatement stat)
         {
            return process(stat.getBehaviorActionsOwned()) ;
         }
         
         public Boolean caseTimedAction(TimedAction ta)
         {
            return _legality.D_6_L8_Check(ta) ;
         }
         
         public Boolean caseDispatchCondition (DispatchCondition dc)
         {
            boolean result = _legality.D_3_L5_Check(dc) ;
            
            if(dc.getDispatchTriggerConditionOwned() != null)
            {
               result &= process(dc.getDispatchTriggerConditionOwned()) ; 
            }
            
            return result ;
         }
         
         public Boolean caseTimeoutCatch(TimeoutCatch tc)
         {
            BehaviorTransition btOwner = (BehaviorTransition)
                                                  tc.eContainer().eContainer() ;
            return _legality.D_4_L1_Check(tc, btOwner) ;
         }
         
         public Boolean caseCompletionRelativeTimeoutConditionAndCatch
                             (CompletionRelativeTimeoutConditionAndCatch crtcac)
         {
            BehaviorTransition btOwner = (BehaviorTransition)
                                              crtcac.eContainer().eContainer() ;
            return _legality.D_4_L2_Check(crtcac, btOwner) ;
         }
         
         public Boolean caseDispatchTriggerConditionStop(
                                          DispatchTriggerConditionStop dtcs)
         {
            BehaviorTransition btOwner = (BehaviorTransition)
                                                dtcs.eContainer().eContainer() ;
            
            EList<BehaviorTransition> allTransitions = 
                                                  _ba.getBehaviorTransitions() ;
            
            return _semantic.D_4_6_Check(dtcs, btOwner, allTransitions) ;
         }
      } ;
   }
}
