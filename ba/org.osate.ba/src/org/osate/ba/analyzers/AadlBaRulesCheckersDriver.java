/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.analyzers ;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;

import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionCollection ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorCondition ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;
import org.osate.ba.aadlba.DispatchCondition ;
import org.osate.ba.aadlba.DispatchRelativeTimeout ;
import org.osate.ba.aadlba.DispatchTriggerConditionStop ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.LoopStatement ;
import org.osate.ba.aadlba.Otherwise ;
import org.osate.ba.aadlba.TimedAction ;
import org.osate.ba.aadlba.util.AadlBaSwitch ;
import org.osate.ba.declarative.DeclarativeBehaviorTransition ;
import org.osate.ba.declarative.Identifier ;


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
  private AnalysisErrorReporterManager _errManager ;
  private DeclarativeBehaviorTransition _currentBt ;

  public AadlBaRulesCheckersDriver(BehaviorAnnex ba,
                                   AnalysisErrorReporterManager errManager)
  {
    _ba = ba ;
    _legality = new AadlBaLegalityRulesChecker(ba, errManager) ;
    _semantic = new AadlBaSemanticRulesChecker(errManager) ;
    _consistency = new AadlBaConsistencyRulesChecker(ba, errManager) ;
    _errManager = errManager ;
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
      if(result == null)
        return true ;
      else
        return result ;
    }
    else
    {
      // Declarative objects are not supported.
      System.err.println("the given element -" + theElement.getClass().getSimpleName() + 
                         "- doesn't come from AADL BA model") ;
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

            if(_ba.isSetStates())
            {
               EList<BehaviorState> initialStates = new BasicEList<BehaviorState>() ;
               EList<BehaviorState> completeStates = new BasicEList<BehaviorState>() ;
               EList<BehaviorState> finalStates = new BasicEList<BehaviorState>() ;

               for(BehaviorState bs : _ba.getStates())
               {
                  if(bs.isInitial())
                  {
                     initialStates.add(bs) ;
                  }

                  if(bs.isComplete())
                  {
                     completeStates.add(bs) ;
                  }

                  if(bs.isFinal())
                  {
                     finalStates.add(bs) ;
                  }
               } // End of first for.

               result &= _legality.D_3_L1_And_L2_Check(initialStates,
                                                       completeStates,
                                                       finalStates) ;
               result &= _legality.D_3_L3_Check(initialStates, completeStates) ;
               result &= _legality.D_3_L4_Check(initialStates, finalStates) ;

            }// End of first if.

            if(_ba.isSetTransitions())
            {
              otherwiseCheck(_ba) ;
              
              for(BehaviorTransition bt : _ba.getTransitions())
              {
                result &= caseBehaviorTransition(bt) ;
              }
            }

            return result ;
         }
         
         // A warning is raised if there is more than one transition with
         // an otherwise execute condition.
         private void otherwiseCheck(BehaviorAnnex ba)
         {
           boolean otherwise = false ;
           BehaviorTransition[] dead_trans = new 
                              BehaviorTransition[ba.getTransitions().size()-1];
           
           int index = 0 ;
           
           List<BehaviorTransition> btTmp = new 
                    ArrayList<BehaviorTransition>
                              (ba.getTransitions().size()-1);
           
           for (BehaviorState s : ba.getStates())
           {
             for(BehaviorTransition bt : ba.getTransitions())
             {
               DeclarativeBehaviorTransition tmp = (DeclarativeBehaviorTransition)
                                                                            bt ;
               for(Identifier src : tmp.getSrcStates())
               {
                 if(s.getName().equalsIgnoreCase(src.getId()))
                 {
                   btTmp.add(tmp) ;
                 }
               }
             }
             
             for(BehaviorTransition bt : btTmp)
             {
               if(bt.getCondition() instanceof Otherwise)
               {
                 if(otherwise)
                 {
                   dead_trans[index] = bt ;
                   index++ ;
                 }
                 else
                 {
                   otherwise = true ;
                 }
               }
             }
             
             btTmp.clear() ;
             otherwise = false ;
           }
           
           // Report a warning.
           for(--index ; index >= 0 ; index--)
           {
             reportWarning(dead_trans[index],
                           "unreachable transition") ;
           }
         }
         
         // TODO Provide column number.
         private void reportWarning(BehaviorElement obj, String message) 
         {
            _errManager.warning(obj, message);
         }
         
         public Boolean caseBehaviorTransition(BehaviorTransition tmp)
         {
           _currentBt = (DeclarativeBehaviorTransition) tmp ;
           
           boolean result = true ;
            
            List<Identifier> sourceStateList = _currentBt.getSrcStates() ;
            
            // Check source identifiers.
            
            for(Identifier srcState : sourceStateList)
            {
               result &= _legality.D_3_L6_Check(_currentBt, srcState) ;
               result &= _legality.D_3_L7_Check(_currentBt, srcState) ;
               result &= _legality.D_3_L8_Check(srcState) ;
               result &= _consistency.D_3_C4_Check(_currentBt, srcState) ;
            }
            
            BehaviorCondition bc = _currentBt.getCondition() ;
            
            // Check Dispatch condition.
            if(bc instanceof DispatchCondition)
            {
               result &= process(bc) ;
            }
            /*
            else // Check Execute condition. Warning execution condition may be
                 // null.
            {
               result &= _semantic.D_3_18_Checker(_currentBt);
            }
            */
            
            if(_currentBt.getActionBlock() != null)
            {
               result &= _legality.D_6_L3_And_L4_Check(
                                             _currentBt.getActionBlock()) ;
               
               process(_currentBt.getActionBlock()) ;
            }

            return result ;
         }
         
         public Boolean caseBehaviorActionBlock(BehaviorActionBlock bab)
         {
            return process(bab.getContent()) ;
         }
         
         public Boolean caseBehaviorActionCollection(BehaviorActionCollection 
                                                                            bac)
         {
            return processEList(bac.getActions()) ;
         }
         
         public Boolean caseIfStatement(IfStatement stat)
         {
           boolean result = process(stat.getBehaviorActions()) ; 
           
           if(stat.getElseStatement() != null)
           {
             result &= process(stat.getElseStatement()) ;
           }
           
           return result ;
         }
         
         public Boolean caseElseStatement(ElseStatement elseStat)
         {
           return process(elseStat.getBehaviorActions()) ;
         }
         
         public Boolean caseLoopStatement(LoopStatement stat)
         {
            return process(stat.getBehaviorActions()) ;
         }
         
         public Boolean caseTimedAction(TimedAction ta)
         {
            return _legality.D_6_L8_Check(ta) ;
         }
         
         public Boolean caseDispatchCondition (DispatchCondition dc)
         {
            boolean result = _legality.D_3_L5_Check(dc) ;
            
            if(dc.getDispatchTriggerCondition() != null)
            {
               result &= process(dc.getDispatchTriggerCondition()) ; 
            }
            
            return result ;
         }
         
         public Boolean caseDispatchRelativeTimeout(DispatchRelativeTimeout tc)
         {
            return _legality.D_4_L1_Check(tc, _currentBt) ;
         }
         
         public Boolean caseCompletionRelativeTimeout
                                              (CompletionRelativeTimeout crtcac)
         {
           return _legality.D_4_L2_Check(crtcac, _currentBt) ;
         }
         
         public Boolean caseDispatchTriggerConditionStop(
                                          DispatchTriggerConditionStop dtcs)
         {
            EList<BehaviorTransition> allTransitions = 
                                                  _ba.getTransitions() ;
            
            return _semantic.D_4_6_Check(dtcs, _currentBt, allTransitions) ;
         }
      } ;
   }
}
