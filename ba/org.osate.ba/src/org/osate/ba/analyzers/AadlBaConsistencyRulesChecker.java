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

package org.osate.ba.analyzers;

import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.common.util.EList ;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode ;
import org.osate.aadl2.ModeTransition ;
import org.osate.aadl2.ModeTransitionTrigger ;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.* ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.Aadl2Visitors ;




public class AadlBaConsistencyRulesChecker
{
	private BehaviorAnnex _ba ;
	private ComponentClassifier _baParentContainer ;
	PackageSection[] _contextsTab ;
	private AnalysisErrorReporterManager _errManager ;

	public AadlBaConsistencyRulesChecker(BehaviorAnnex ba , 
			                               AnalysisErrorReporterManager errManager)
	{
		_ba = ba ;
		_errManager = errManager ;
		_baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
		_contextsTab = AadlBaVisitors.getBaPackageSections(_ba) ;
	}
	
	/**
	 * Document: AADL Behavior Annex draft
	 * Version : 0.94
	 * Type    : Consistency rule
	 * Section : D.3 Behavior Specification 
	 * Object  : Check consistency rule D.3.(C4)
	 * Keys    : complete state mode behavior condition mode transition triggers
	 */
	public boolean D_3_C4_Check(BehaviorTransition btOwner, Identifier srcState)
	{
	   // [OPTIM] -------------------------------------------------------------
      // these checking can be moved to the rules driver in order to optimize.
      
      BehaviorState bs = (BehaviorState) srcState.getBaRef() ;
      BehaviorState declaredState = null ;
      
      if(bs.getName().equalsIgnoreCase(srcState.getId()))
      {
         declaredState = bs ;
      }
      
      // If the srcState doesn't represent a mode: nothing to check for, exit
      // with true.
      if(declaredState.getBindedMode() == null)
      {
         return true ;
      }
      
      // ---------------------------------------------------------------------
      
      // At this point, one of the current behavior transtion's src states
      // represent a mode.
      
      DispatchTriggerLogicalExpression dtle ;
      Mode mode = declaredState.getBindedMode() ;
      
      // As D.3.(C4), behavior state that represents a mode is a complete 
      // state and as D.3.(L6) and D.3(L7) legality rules: only dispatch 
      // trigger logical expression is analyzed.
      if(btOwner.getCondition() instanceof DispatchCondition)
      {
           DispatchCondition dc = (DispatchCondition) btOwner.
                                                   getCondition() ;
           
           if(dc.getDispatchTriggerCondition() instanceof 
                                            DispatchTriggerLogicalExpression)
           {
              dtle = (DispatchTriggerLogicalExpression) 
                        dc.getDispatchTriggerCondition() ;
           }
           else
           {
              // At least, there is one mode transition trigger in a mode
              // transition. So this transition is not consistency.
              reportConsistencyError(srcState, "The behavior transition tries "+
              		"to refine a transition mode but it hasn't got any dispatch "+
              		"trigger logical expression: Behavior Annex D.3.(C4) " +
              		"consistency rule failed") ;
              return false ;
           }
      }
      else
      {
         // D.3.(L6) and D.3(L7) error case. Do not report error but
         // exit with false result.
         return false ;
      }
      
      EList<ModeTransition> lModeTrans = Aadl2Visitors.
               getElementsInNamespace(_baParentContainer,ModeTransition.class) ;
      
      // Can't be out a state/mode if the parent container doesn't declare 
      // any transition mode.
      if(lModeTrans.isEmpty())
      {
         reportConsistencyError(srcState, "The behavior transition tries to " +
               "refine a transition mode while " +
               _baParentContainer.getQualifiedName() + 
               " component hasn't got any transition mode: " +
               "Behavior Annex D.3.(C4) consistency rule failed") ;
         return false ;
      }
      
      // At this point preliminary checking has been passed.
      
      List<String> lModeTriggs = new ArrayList<String>();
      
      // Fetches dispatch trigger names in the given behavior transition.
      List<String> ldispTriggs = new ArrayList<String>() ;
      
      for(DispatchTrigger trigg : AadlBaVisitors.getDispatchTriggers(dtle))
      {
        ActualPortHolder portHolder = (ActualPortHolder) trigg ;
        ldispTriggs.add(portHolder.getPort().getName()) ;
      }
      
      // Checks if the behavior transition is consisting with one of 
      // the mode transitions where the considered mode is contained.
      // Otherwise reports an error.
      for (ModeTransition mTrans : lModeTrans)
      {
         // If the transition mode contains the considered mode:
         if(mTrans.getSource().getName().equalsIgnoreCase(mode.getName()))
         {
            // Fetches mode transition trigger names.
            for(ModeTransitionTrigger mtt : mTrans.getOwnedTriggers())
            {
               lModeTriggs.add(AadlBaUtils.getName(mtt)) ;
            }
            
            // Checks consistency between the two triggers lists without 
            // considering their order.
            if(Aadl2Utils.compareStringList(ldispTriggs, lModeTriggs))
            {
               return true ;
            }
            else
            {
               lModeTriggs.clear() ;
               continue ;
            }
         }
         // Else continue to the next transition mode.
      }
      
      // Error case : the given behavior transition which is out of a mode 
      // is not consisting with any transition mode which involves the considered
      // mode.
      reportConsistencyError(srcState, "The behavior transition tries to " +
         "refine a transition mode but it is not consisting with any " +
         "transition mode of " + _baParentContainer.getQualifiedName() +
         " component: Behavior Annex D.3.(C4) consistency rule failed") ;
      return false ; 
	}

   // TODO Provide column number.
   private void reportConsistencyError(BehaviorElement obj, String msg)
   {
      _errManager.error(obj, msg + ".") ;
   }
}