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

import java.util.List ;

import org.eclipse.emf.common.util.EList ;

import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ba.aadlba.* ;
import org.osate.ba.declarative.DeclarativeBehaviorTransition ;
import org.osate.ba.declarative.Identifier ;


public class AadlBaSemanticRulesChecker
{
   private AnalysisErrorReporterManager _errManager ;

   public AadlBaSemanticRulesChecker(AnalysisErrorReporterManager errManager)
   {
      _errManager = errManager ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 0.94 
    * Type : Semantic rule
    * Section : D.3 Behavior Specification 
    * Object : Check semantic rule D.3.(18) 
    * Keys : execute condition state pure initial
    */
   public boolean D_3_18_Checker(DeclarativeBehaviorTransition bt)
   {
      BehaviorState bs ;
      boolean result = true ;
      
      List<Identifier> sourceStateList = bt.getSrcStates() ;
      
      for (Identifier srcState : sourceStateList)
      {
         bs = (BehaviorState) srcState.getBaRef() ;
         
         // Error case : only transition out of execution states or pure
         // initial state may have execute condition.
         if(bs.isComplete() || bs.isFinal())
         {
            this.reportSemanticError(srcState, "Only transition out of " +
               "execution states or states that are intial only may have " +
                  "execute condition: Behavior Annex D.3.(18) semantic rule " +
                     "failed") ;
            
            result = false ;
         }
      }
      
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 0.94 
    * Type : Semantic rule
    * Section : D.4 Thread Dispatch Behavior Specification
    * Object : Check semantic rule D.4.(5)
    * Keys : dispatch relative timeout condition catch timed thread complete
    * state period property
    */
    // => D.4.(5) is implemented along D.4.(L1) .
   
   /**
    * Document: AADL Behavior Annex draft 
    * Version : 0.94 
    * Type : Semantic rule
    * Section : D.4 Thread Dispatch Behavior Specification
    * Object : Check semantic rule D.4.(6)
    * Keys : stop dispatch initiation finalization complete final execute states
    */
   public boolean D_4_6_Check(DispatchTriggerConditionStop stopStatement,
                              DeclarativeBehaviorTransition btOwner,
                              EList<BehaviorTransition> allTransitions)
   {
      boolean result = true ;
    
      List<Identifier> sourceStateList = btOwner.getSrcStates() ;
      
      // Check the source states : they must be complete states.
      BehaviorState tmpState ;
      for (Identifier srcState : sourceStateList)
      {
        tmpState = (BehaviorState) srcState.getBaRef() ;
         
         if(! tmpState.isComplete())
         {
            this.reportSemanticError(stopStatement, "The stop dispatch trigger "+
               "statement must be declared in an outgoing transition of a " +
                  "complete state: Behavior Annex D.4.(6) semantic rule failed");
            result = false ;
            break;
         }
      }
      
      // Create a transitions array because the array will be modified.
      // See transitionEndToFinalStateDriver.
      DeclarativeBehaviorTransition[] transArray = 
                      new DeclarativeBehaviorTransition[allTransitions.size()] ;
      
      allTransitions.toArray(transArray) ;
      
      int btOwnerIndex = allTransitions.indexOf(btOwner) ;
      
      if (!transitionEndToFinalStateCheck(btOwner, btOwnerIndex, transArray))
      {
         reportSemanticError(stopStatement, "The stop dispatch trigger "+
            "statement must be declared in a transition that ends to final" +
               " state possibly via one or more execution states: " +
                  "Behavior Annex D.4.(6) semantic rule failed") ;
         result = false ;
      }
      
      return result ;
   }
   
   private boolean transitionEndToFinalStateDriver(
                                     DeclarativeBehaviorTransition btOwner,
                                     int btOwnerIndex,
                                     DeclarativeBehaviorTransition[] transArray)
   {
      String destState = btOwner.getDestState().getId() ; 
      
      // As more than one transition can have the owner's destination state 
      // as a source state, it must 
      // find a next transition (except the given Owner to avoid circular 
      // recursion) and tests if it ends to a final state 
      // possibly via one or more execution states.
      transArray[btOwnerIndex] = null ;
      
      DeclarativeBehaviorTransition bt ;
      
      for(int i = 0 ; i < transArray.length ; i++)
      {
         bt = transArray[i] ;
         
         if(bt != null)
         {
           List<Identifier> sourceStateList = bt.getSrcStates() ;
           
           for (Identifier srcState : sourceStateList)
            {
               if(srcState.getId().equalsIgnoreCase(destState))
               {
                  
                  if(transitionEndToFinalStateCheck(bt, i, transArray))
                  {
                     return true ;
                  }
               }
            }
         }
      }
      
      // At this point, no transition ends to a final state or there is not any
      // more transition to check for.
      
      return false ;
   }
   
   // Check the destination states : the transition must end to a final state
   // possibly via one or more execution states.
   private boolean transitionEndToFinalStateCheck(
                                     DeclarativeBehaviorTransition bt,
                                     int btIndex,
                                     DeclarativeBehaviorTransition[] transArray)
   {
      BehaviorState tmpState ;
      tmpState = (BehaviorState) bt.getDestState().getBaRef() ; 
            
      // Error cases : destination state is not execute or final.
      if(!tmpState.isFinal() && (tmpState.isComplete() || tmpState.isInitial()))
      {
         return false ;
      }
      else
      {
         // Execution state case.
         if(! tmpState.isFinal())
         {
            // Check if the transition owner ends to a final state.
            return transitionEndToFinalStateDriver(bt, btIndex, transArray) ;
         }
         else // The state is a final state: check passed.
            return true ;
      }
   }
   
   // TODO Provide column number.
   private void reportSemanticError(BehaviorElement obj, String msg)
   {
      _errManager.error(obj, msg + ".") ;
   }
}