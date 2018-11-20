/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package org.osate.ba.analyzers;

import java.util.ListIterator ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ClassifierFeature ;
import org.osate.aadl2.ClassifierValue ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.EnumerationType ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.ListType ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.Mode ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.PackageSection ;
import org.osate.aadl2.ProcessorClassifier ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.PropertyType ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.RecordType ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.UnitLiteral ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.Any ;
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.BasicAction ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionCollection ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorCondition ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;
import org.osate.ba.aadlba.DataRepresentation ;
import org.osate.ba.aadlba.DispatchCondition ;
import org.osate.ba.aadlba.DispatchConjunction ;
import org.osate.ba.aadlba.DispatchTriggerCondition ;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.ForOrForAllStatement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.IntegerRange ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.IntegerValueConstant ;
import org.osate.ba.aadlba.IntegerValueVariable ;
import org.osate.ba.aadlba.IterativeVariable ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.PropertyNameField ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.TimedAction ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueConstant ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.aadlba.ValueVariable ;
import org.osate.ba.aadlba.WhileOrDoUntilStatement ;
import org.osate.ba.declarative.ArrayableIdentifier ;
import org.osate.ba.declarative.CommAction ;
import org.osate.ba.declarative.DeclarativeArrayDimension ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativeBehaviorTransition ;
import org.osate.ba.declarative.DeclarativeFactory ;
import org.osate.ba.declarative.DeclarativePropertyName ;
import org.osate.ba.declarative.DeclarativePropertyReference ;
import org.osate.ba.declarative.DeclarativeTime ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.declarative.NamedValue ;
import org.osate.ba.declarative.QualifiedNamedElement ;
import org.osate.ba.declarative.Reference ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.Aadl2Visitors ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.names.DataModelProperties ;


/**
 * A AADL behavior annex name resolver.
 * 
 */
public class AadlBaNameResolver
{
   private BehaviorAnnex _ba ;
   private ComponentClassifier _baParentContainer ;
   PackageSection[] _contextsTab ;
   private AnalysisErrorReporterManager _errManager ;
   
   // Time units property set names.
   public static final String TIME_UNITS_PROPERTY_SET = "AADL_Project" ;
   public static final String TIME_UNITS_PROPERTY_ID = "Time_Units";
   
   // Iterative variables scope handler.
   private EList<IterativeVariable> _itvScope = 
                                            new BasicEList<IterativeVariable>();
   
   /**
    * Constructs an AADL behavior annex name resolver for a given behavior annex
    *  and reports any errors in a given error reporter manager.
    * 
    * @param ba the given behavior annex
    * @param errManager the given error reporter manager
    */
   public AadlBaNameResolver(BehaviorAnnex ba , 
                             AnalysisErrorReporterManager errManager)
   {
      _ba = ba ;
      _errManager = errManager ;
      _baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
      _contextsTab = AadlBaVisitors.getBaPackageSections(_ba) ;
   }

   private boolean assignmentActionResolver(AssignmentAction act)
   {
      boolean result = false ;
      Target t = act.getTarget() ;
      
      result = targetResolver(t) ;
      
      if(! (act.getValueExpression() instanceof Any))
      {
         result &= valueExpressionResolver(act.getValueExpression()) ;
      }
      
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 0.94 
    * Type : Naming rule
    * Section : D.3 Behavior Specification
    * Object : Check naming rule D.3.(N1) 
    * Keys : name uniqueness
    *
    * Conflicts and duplicate names are reported in the given error report
    * manager. Link the complete states that represent a mode.
    * 
    * @return {@code true} if behavior annex's rule is satisfied. {@code false}
    * otherwise. 
    */
   private boolean behaviorComponentsUniquenessCheck()
   {
      boolean result = true ;
      
      // Separated check in order to improve visibility and performance.
      result = parentComponentIdentifiersUniquenessCheck() ;

      EList<BehaviorVariable> lvars = _ba.getVariables() ;
      EList<BehaviorState> lstates = _ba.getStates() ;
      EList<BehaviorTransition> ltrans = _ba.getTransitions() ;
      
      for (int i = 0 ; i < lvars.size() - 1 ; i++)
      {
        for(int j = i+1 ; j < lvars.size() ; j++)
        {
          if(lvars.get(i).getName().equalsIgnoreCase(lvars.get(j).getName()))
          {
            reportDuplicateNameError(lvars.get(j), lvars.get(i)) ;
            result = false ;
          }
        }
      }
      
      for (int i = 0 ; i < lstates.size() - 1 ; i++)
      {
        for(int j = i+1 ; j < lstates.size() ; j++)
        {
          if(lstates.get(i).getName().equalsIgnoreCase(lstates.get(j).getName()))
          {
            reportDuplicateNameError(lstates.get(j), lstates.get(i)) ;
            result = false ;
          }
        }
      }
      
      for (int i = 0 ; i < ltrans.size() - 1 ; i++)
      {
        if(ltrans.get(i).getName()==null)
          continue ;
        
        for(int j = i+1 ; j < ltrans.size() ; j++)
        {
          if (ltrans.get(j).getName()==null)
            continue;
          if(ltrans.get(i).getName().equalsIgnoreCase(ltrans.get(j).getName()))
          {
            reportDuplicateNameError(ltrans.get(j), ltrans.get(i)) ;
            result = false ;
          }
        }
      }

      for(BehaviorVariable v : lvars)
      {
        String bvName = v.getName() ; 
        
        for(BehaviorState s : lstates)
        {
           String bsName = s.getName() ;
          
           if(bsName.equalsIgnoreCase(bvName))
           {
              reportDuplicateNameError(s, v) ;
              result = false ;
           }
        }
        
        for(BehaviorTransition t : ltrans)
        {
           String btName = t.getName() ;
           
           if(btName != null && btName.equalsIgnoreCase(bvName))
           {
              reportDuplicateNameError(t, v) ;
              result = false ;
           }
        }
      }

      for(BehaviorState s : lstates)
      {
         String bsName = s.getName() ;
         
         for(BehaviorTransition t : ltrans)
         {
            String btName = t.getName() ;
            
            if(btName != null && btName.equalsIgnoreCase(bsName))
            {
               reportDuplicateNameError(t, s) ;
               result = false ;
            }
         }
      }
      
      return result ;
   }

   private boolean basicActionResolver(BasicAction act)
   {
      // Case of assignment action.
      if(act instanceof AssignmentAction)
      {
         return assignmentActionResolver((AssignmentAction) act) ;
      }
      else // Case of communication action.
      {
         if(act instanceof CommAction)
         {
            return communicationActionResolver((CommAction) act) ;
         }
         else // Case of timed action.
         {
            return timedActionResolver((TimedAction) act) ;
         }
      }
   }

   private boolean transDestStateResolver(DeclarativeBehaviorTransition trans)
   {
      BehaviorState state = null ;
      Identifier id = trans.getDestState() ;
      state = AadlBaVisitors.findBehaviorState(_ba, id.getId()) ;
      if(state != null)
      {
         id.setBaRef(state);
         return true ;
      }
      else
      {
         reportNameError(id, id.getId()) ;
         return false ;
      }
   }
   
   private boolean transSrcStateResolver(DeclarativeBehaviorTransition trans)
   {
      boolean result = true ;
      BehaviorState state = null ;
      for(Identifier id : trans.getSrcStates())
      {
         state = AadlBaVisitors.findBehaviorState(_ba, id.getId()) ;
         if(state != null)
         {
            id.setBaRef(state) ;
         }
         else
         {
            reportNameError(id, id.getId()) ;
            result = false ;
         }
      }
      return result ;
   }
   
   /**
    * Document: AADL Behavior Annex draft 
    * Version : 0.94 
    * Type : Naming rule
    * Section : D.3 Behavior Specification
    * Object : Check naming rule D.3.(N2) 
    * Keys : empty execution condition
    * 
    * Resolves the names in behavior annex's transitions. 
    * 
    * @return {@code true} if all names are resolved. {@code false} otherwise. 
    */
   private boolean behaviorTransitionResolver()
   {
        boolean result = true ;
        
        for(BehaviorTransition tmp : _ba.getTransitions())
        {
           DeclarativeBehaviorTransition trans = (DeclarativeBehaviorTransition)
                                                                           tmp ;
          
           result &= transDestStateResolver(trans) ;
           result &= transSrcStateResolver(trans) ;
           
           BehaviorCondition cond = trans.getCondition() ;
           
           // According to D.3.(N2) Naming rule : behavior condition can be null
           // as no condition means always true.
           if(cond != null)
           {
              // Case of a dispatch condition
              if( cond instanceof DispatchCondition)
              {
                 result &= dispatchConditionResolver((DispatchCondition)cond);
              }
              else // Case of a execute condition
              {
                 if( cond instanceof ValueExpression)
                 {
                   result &= valueExpressionResolver((ValueExpression) cond) ;
                 }
              }
           }
           
           BehaviorActionBlock block = trans.getActionBlock() ;
           
           // Behavior actions of an behavior transition may not exist.            
           if(block != null)
           {
              result &= behaviorActionBlockResolver(block) ;
           }
        }
        return result ;
   }
   
   private boolean behaviorActionBlockResolver(BehaviorActionBlock block)
   {
      boolean result = behaviorActionsResolver(block.getContent());
      
      // Check timeout option.
      if(block.getTimeout() != null)
      {
         result &= behaviorTimeResolver((DeclarativeTime) block.getTimeout()) ;
      }
      
      return result ;
   }

   private boolean baVariableResolver(Identifier id, boolean hasToReport)
   {
      String variableName = id.getId() ;
      
      BehaviorVariable v = AadlBaVisitors.findBehaviorVariable(_ba,
                                                               variableName) ;
      
      if(v != null)
      {
         id.setBaRef(v) ;
         return true ;
      }
      else
      {
         if (hasToReport)
         {
            reportNameError(id, variableName) ;
         }
         return false ;
      }
   }
   
   private boolean ifStatementResolver(IfStatement stat)
   {
     boolean result = true ;
     
     result &= valueExpressionResolver(stat.getLogicalValueExpression()) ;
     
     result &= behaviorActionsResolver(stat.getBehaviorActions()) ;
     
     ElseStatement elseStat = stat.getElseStatement() ;
     
     if( elseStat != null)
     {
       if(elseStat instanceof IfStatement)
       {
         result &= ifStatementResolver((IfStatement) elseStat) ;
       }
       else
       {
         result &= behaviorActionsResolver(elseStat.getBehaviorActions()) ;
       }
     }
     
     return result ;
   }
   
   private boolean behaviorActionResolver(BehaviorAction act)
   {
      boolean result = true ;
      
      // Case of basic action.
      if(act instanceof BasicAction)
      {
         result = basicActionResolver((BasicAction)act) ;
      }
      else
      {
         if(act instanceof BehaviorActionBlock)
         {
            result = behaviorActionBlockResolver((BehaviorActionBlock)act);
         }
         else
         {
            // Case of IF statement.
            if(act instanceof IfStatement)
            {
              result = ifStatementResolver ((IfStatement) act) ;
            }
            else
            {
               // Case if WHILE and DO UNTIL statement.
               if(act instanceof WhileOrDoUntilStatement)
               {
                  WhileOrDoUntilStatement stat = (WhileOrDoUntilStatement) act ;
                  result = valueExpressionResolver(stat
                                                 .getLogicalValueExpression()) ;
                  result &= behaviorActionsResolver(stat
                                                   .getBehaviorActions()) ;
               }
               else // Case of FOR and FOR ALL statement.
               {
                  
                  ForOrForAllStatement stat = (ForOrForAllStatement) act ;
                  
                  IterativeVariable itVar = stat.getIterativeVariable() ;
                  
                  
                  // Resolves unique component classifier reference.
                  QualifiedNamedElement uccr = (QualifiedNamedElement) 
                                                     itVar.getDataClassifier() ;
                  
                  result = qualifiedNamedElementResolver(uccr, true) ;
                  
                  // Checks the for/forall's iterative variable.
                  result &= iterativeVariableUniquenessCheck(itVar); 
                  
                  // Add the for/forall statment's iterative variable to 
                  // the scope handler.
                  _itvScope.add(itVar);
                  
                  // Check element values.
                  result &= elementValuesResolver(stat.getIteratedValues());
                  
                  // Check behavior actions.
                  result &= behaviorActionsResolver(stat.getBehaviorActions()) ;
                  
                  // remove the for/forall statment's iterative variable from
                  // the scope handler (after checking for/forall's behavior
                  // actions.
                  _itvScope.remove(itVar);
               }
            }// End of third else.
         }// End of second else.
      }// End of first else.
      
      return result ;
   }

   /** 
   * Document: AADL Behavior Annex draft
   * Version : 0.94 
   * Type : Naming rule
   * Section : D.6 Behavior Action Language
   * Object : Check naming rule D.6.(N1) 
   * Keys : element variable identifier for control construct iterative variable
   */ 
   private boolean iterativeVariableUniquenessCheck(IterativeVariable itv)
   {
      // Check uniqueness towards AADL elements.
      boolean result = featureNameUniquenessCheck(itv);
      
      // Check uniqueness towards BA local variable.
      result &= behaviorVariableNameUniquenessCheck(itv);
      
      // Check uniqueness towards others iterative variables according
      // to their scope. 
      result &= iterativeVariableUniquenessWithinScopeHandler(itv) ;
      
      return result ;
   }
   
   private boolean iterativeVariableUniquenessWithinScopeHandler(
                                                          IterativeVariable itv)
   {
     IterativeVariable sameId = AadlBaUtils.compareNamedElementList(
                                                     itv.getName(), _itvScope) ;
     if( sameId == null)
     {
       return true ;
     }
     else
     {
        // Report error.
        _errManager.error(itv, "duplicate local variable for " + itv.getName());
        return false ;
     }
   }
   
   // Just the opposite of featureResolver.
   private boolean featureNameUniquenessCheck(IterativeVariable itv)
   {
      String nameToFind = itv.getName(); 
      
      Feature f = Aadl2Visitors.findFeatureInComponent(_baParentContainer,
                                                        nameToFind) ;
      if (f == null)
      {
         return true ;
      }
      else
      {
         // Report error.
         _errManager.error(itv, "duplicate local variable for " + itv.getName());
         
         return false ;
      }
   }
   
   // Checks if the given iterative variable is declared within the current
   // scope handler.
   private boolean iterativeVariableScopeCheck(Identifier itv,
                                             boolean hasToReport)
   {
     IterativeVariable sameId = AadlBaUtils.compareNamedElementList(itv.getId(),
                                                                   _itvScope) ;
     if( sameId != null)
     {
       itv.setBaRef(sameId) ;
       return true ;
     }
     else
     {
       // Report error.
       if (hasToReport) 
       {
         reportNameError(itv, itv.getId()) ;
       }
       return false ;
     }
   }
   
   private boolean behaviorVariableNameUniquenessCheck(IterativeVariable itv)
   {
      String variableName = itv.getName() ;
      
      BehaviorVariable v = AadlBaVisitors.findBehaviorVariable
                                                           (_ba, variableName) ; 
      if(v == null)
      {
         return true ;
      }
      else
      {
         // Report error.
         _errManager.error(itv, "duplicate local variable for " + itv.getName());
         
         return false ;
      }
   }

   private boolean behaviorActionsResolver(BehaviorActions acts)
   {
      boolean result = true ;
      
      // Case of single behavior action.
      if(acts instanceof BehaviorAction)
      {
         result = behaviorActionResolver((BehaviorAction)acts) ;
      }
      else // Case of behavior action collection (behavior action sequence or set)
      {
         for(BehaviorAction act : ((BehaviorActionCollection)acts).getActions())
         {
            result &= behaviorActionResolver(act) ;
         }
      }

      return result ;
   }

   private boolean behaviorTimeResolver(DeclarativeTime bt)
   {
     Identifier timeUnit = bt.getUnitId() ;
     
     
     boolean result = integerValueResolver(bt.getIntegerValue());
     result &= timeUnitResolver(timeUnit);
     if(result && bt.getIntegerValue() instanceof BehaviorIntegerLiteral)
     {
       BehaviorIntegerLiteral bil = (BehaviorIntegerLiteral) bt.getIntegerValue();
       bil.setUnit((UnitLiteral) timeUnit.getOsateRef());
     }
     return result;
   }

   private boolean communicationActionResolver(CommAction act)
   {
     boolean result = true ;
     
     if(act.getTarget() != null)
     {
       result &= targetResolver(act.getTarget()) ;
     }
     
     if(act.getQualifiedName() != null)
     {
       result &= qualifiedNamedElementResolver(act.getQualifiedName(), true) ;
     }
     
     if(act.getReference() != null)
     {
       // Ambiguous cases : 
       // _ unqualified unique component classifier reference
       //   without implementation information provided, are parsed as reference
       //   (single name) without array index.
       // _ unqualified unique component classifier reference with
       //   implementation information provided and a reference (two names)
       //   without array index.
       
       Reference ref = act.getReference() ;
       EList<ArrayableIdentifier> ids = ref.getIds() ;
       boolean hasArrayIndex = false ;
       
       // unqualified unique component classifier reference have at most two
       // names.
       if(ids.size() > 2)
       {
         result &= refResolver(ref) ;
       }
       else
       {
         for (ArrayableIdentifier id : ids)
         {
           if(id.isSetArrayIndexes())
           {
             hasArrayIndex = true ;
           }
         }
         
         // unique component classifier reference can't have array index.
         if(hasArrayIndex)
         {
           result &= refResolver(ref) ;
         }
         else
         {
           // Resolves ambiguous case between unqualified unique component
           // classifier reference and a reference with only one name.
           
           ArrayableIdentifier idComponent = ids.get(0) ;
           
           StringBuilder subprogramName = new StringBuilder() ;
           subprogramName.append(idComponent.getId()) ;
           
           if(ids.size() == 2)
           {
             ArrayableIdentifier idImplementation = ids.get(1) ;
             subprogramName.append('.');
             subprogramName.append(idImplementation.getId()) ;
           }
           
           QualifiedNamedElement qne =
                 DeclarativeFactory.eINSTANCE.createQualifiedNamedElement() ;
           
           // Clone the identifier as object reference in the most of the AADLBA
           // Front End emf meta model classes are unique (the containment
           // attribute set to true).
           Identifier idClone = DeclarativeFactory.eINSTANCE.createIdentifier();
           idClone.setLocationReference(idComponent.getLocationReference()) ;
           idClone.setId(subprogramName.toString()) ;
           
           qne.setBaName(idClone) ;
           qne.setBaNamespace(null) ;
           qne.setLocationReference(idComponent.getLocationReference()) ;

           if(qualifiedNamedElementResolver(qne, false))
           {
             act.setReference(null) ;
             act.setQualifiedName(qne) ;
             act.setLocationReference(qne.getLocationReference()) ;

             result &= true ;
           }
           else
           {
             result &= refResolver(ref) ;
           }
         }
       }
     }
     
     if(act.isSetParameters())
     {
       result &= subprogramParameterListResolver(act.getParameters()) ;
     }
     
     return result ;
   }
  
   /* dispatch_condition ::=
        on dispatch [ dispatch_trigger_condition ] [ frozen frozen_ports ] */
   private boolean dispatchConditionResolver(DispatchCondition cond)
   {
      boolean result = true ;
      
      DispatchTriggerCondition dtc = cond.getDispatchTriggerCondition() ;
      
      // Dtc can be null as no dispatch trigger condition means always true. 
      if(dtc != null)
      {
         result = dispatchTriggerConditionResolver(dtc) ;
      }
    
      if (cond.isSetFrozenPorts())
      {
        for(Element id : cond.getFrozenPorts())
        {
           result &= refResolver((Reference) id);
        }
      }

      return result ;
   }
   
   /*   dispatch_trigger_condition ::=
        dispatch_trigger_logical_expression
      | provides_subprogram_access_name
      | stop
      | completion_relative_timeout_condition_and_catch
      | dispatch_relative_timeout_catch */
   private boolean dispatchTriggerConditionResolver(
                                                   DispatchTriggerCondition dtc) 
   {
      boolean result = false ;
      
      // Subprogram access are parsed as dispatch trigger logical expression.
      if (dtc instanceof DispatchTriggerLogicalExpression)
      {
         result = dispatchTriggerLogicalExpressionResolver
                    ((DispatchTriggerLogicalExpression) dtc);
      }
      else if (dtc instanceof CompletionRelativeTimeout)
      {
        result = behaviorTimeResolver((DeclarativeTime)dtc);
      }  
      else // Cases of TimeoutCatch and DispatchTriggerConditionStop
              // : no name to check for.
      {
            result = true ;
      }
      
      return result ;
   }
 
   private boolean dispatchTriggerLogicalExpressionResolver
                                         (DispatchTriggerLogicalExpression dtle)
   {
      boolean result = true ;
      
      for(DispatchConjunction dc : dtle.getDispatchConjunctions())
      {
        for(Element e : dc.getDispatchTriggers())
        {
          Reference trigg = (Reference) e ;
          result &= refResolver(trigg);
        }
      }
      
      return result ;
   }

   private boolean elementValuesResolver(ElementValues values)
   {
      // Case of integer range.
      if(values instanceof IntegerRange)
      {
         return integerRangeResolver((IntegerRange) values) ;
      }
      else
      {
         return refResolver((Reference) values) ;
      }
   }

   private boolean featureResolver(Classifier parentContainer,
                                     Identifier id, boolean hasToReport)
   {
      String nameToFind = id.getId(); 
      
      Feature f = Aadl2Visitors.findFeatureInComponent(parentContainer,
                                                       nameToFind) ;
      if (f != null)
      {
         id.setOsateRef(f);
         return true ;
      }
      else 
      {
          if (hasToReport)
          {
             reportNameError(id, nameToFind);
          }
          return false ;
      }
   }
   
   // Resolves identifier within the behavior variables and iterative variables.
   private boolean identifierBaResolver(Identifier id, boolean hasToReport)
   {
      // First try to resolve within ba's variables names but 
      // don't report any error.
      if(baVariableResolver(id, false))
      {
         return true ;
      }
      else
      {
         // Second try to resolve within iterative variable scope handler.
         if(iterativeVariableScopeCheck(id, false))
         {
            return true ;
         }
         else
         {
             // Report error.
           if (hasToReport)
             {
                reportNameError(id, id.getId());
             }
            
           return false ;
         }
      }
   }
   
   // Resolves identifiers within the prototypes, features and subcomponent of
   // the given component.
   private boolean identifierComponentResolver(Identifier id,                                 
                                               Classifier component,
                                               boolean hasToReport)
   {
    // Resolves within the given component features names.
    if(featureResolver(component, id, false))
    {
       return true ;  
    }
    else
    {
       // Resolves within the given component subcomponent names.
       if(subcomponentIdResolver(id,component, false))
       {
           return true ;
       }
       else
       {
          //Resolves within the given component feature prototypes.
         if(featurePrototypeResolver(id, component, false))
         {
           return true ;
         }
         else
         {
           // At last try to resolve within the 
           // property Data_Model::Element Names
           if (component instanceof DataClassifier)
           {
             return structOrUnionOrArrayIdResolver(id,
                                        (DataClassifier) component,
                                        true) ;
           }
           else
           {
             // Report error.
             if (hasToReport)
             {
               reportNameError(id, id.getId());
             }
                  
             return false ;
           }
         }
       }
    }
   }
   
   // Resolves the given identifier within the property Data_Model::Element 
   // Names of a declared struct or union component (event if element names is
   // set). If the given component is not declared as a struct or union, it 
   // returns false and reports error according to the hasToReport flag.
   private boolean structOrUnionOrArrayIdResolver(Identifier id,
                                       DataClassifier component,
                                       boolean hasToReport)
   {
    boolean result = false ;
    
    DataRepresentation rep = AadlBaUtils.getDataRepresentation(component);
    
    if(rep == DataRepresentation.STRUCT || rep == DataRepresentation.UNION)
    {
      EList<PropertyExpression> lpv = 
                                  PropertyUtils.findPropertyExpression(component,
                                            DataModelProperties.ELEMENT_NAMES) ;
      ListValue lv = null ;
      StringLiteral sl = null ;
      int index1 = 0 ;
      int index2 = 0 ;
      
      for1:
      for(PropertyExpression pe : lpv)
      {
        lv = (ListValue) pe ;
        
        for(PropertyExpression pex : lv.getOwnedListElements())
        {
          sl = (StringLiteral) pex ;
          
          if(id.getId().equalsIgnoreCase(sl.getValue()))
          {
            result = true ;
            break for1 ;
          }
          
          index2++ ;
        }
        
        index1++ ;
      }
      
      // Binds the element name's base type.
      if (result)
      {
        EList<PropertyExpression> lpv2 = 
                                  PropertyUtils.findPropertyExpression(component,
                                                DataModelProperties.BASE_TYPE) ;
        
        ClassifierValue cv ;
        
        cv = (ClassifierValue ) ((ListValue) lpv2.get(index1)).
                                     getOwnedListElements().get(index2) ;
        
        id.setOsateRef(cv) ;
      }
    }
    else if (rep == DataRepresentation.ARRAY)
    {
      EList<PropertyExpression> lpv =
         PropertyUtils.findPropertyExpression(component,
                                          DataModelProperties.BASE_TYPE) ;
      
      if(lpv.isEmpty() == false)
      {
        ClassifierValue cv ;
        
        cv = (ClassifierValue ) ((ListValue) lpv.get(0)).
                                     getOwnedListElements().get(0) ;
        
        result = identifierComponentResolver(id, cv.getClassifier(),
                                             hasToReport) ;
      }
      else
      {
        result = false ;
      }
    }
    
    if(! result && hasToReport)
    {
      reportNameError(id, id.getId()) ;
    }
    
    return result ;
   }

   private boolean featurePrototypeResolver(Identifier id,
                                            Classifier component,
                                            boolean hasToReport)
   {
      String nameToFind = id.getId() ;

      PrototypeBinding pb = Aadl2Visitors.findPrototypeBindingInComponent
                                                        (component, nameToFind);
      
      // first: try to find any prototype binding that matches the given
      // identifier. Prototype binding means prototype refining.
      if(pb != null)
      {
         id.setOsateRef(pb);
         return true ;
      }
      else // If there isn't any matching prototype binding, try to find
           // a matching prototype declaration. 
      {
         Prototype proto = Aadl2Visitors.findPrototypeInComponent
                                                        (component, nameToFind);
         if (proto != null)
         {
            id.setOsateRef(proto);
            return true ;
         }
         else 
         {
            if (hasToReport)
            {
               reportNameError(id, nameToFind);
            }
            return false ;
         }
      }
   }
   
   private boolean integerRangeResolver(IntegerRange range)
   {
      boolean result = integerValueResolver(range.getUpperIntegerValue());
      result &= integerValueResolver(range.getLowerIntegerValue()) ;
      return result ;
   }

   /* integer_value ::=
         integer_value_variable
       | integer_value_constant */
   private boolean integerValueResolver(IntegerValue value)
   {
     if(value instanceof IntegerValueVariable)
     {
        return integerValueVariableResolver((IntegerValueVariable)value);
     }
     else
     {  
        return integerValueConstantResolver((IntegerValueConstant)value);
     }  
   }

   private boolean integerValueVariableResolver(IntegerValueVariable value)
   {
      return valueVariableResolver((ValueVariable)value, (ValueVariable)value) ;
   }

   private boolean integerValueConstantResolver(IntegerValueConstant value)
   {
      return valueConstantResolver((ValueConstant)value) ;
   }

   /**
    * Resolves the names in behavior annex.
    * 
    * @return {@code true} if all names are resolved. {@code false} otherwise.
    */
   public boolean resolveNames()
   {
      boolean result = this.behaviorComponentsUniquenessCheck() ;
      
      // Continue other checking if only BA's components uniqueness 
      // is ensured.
      if (result)
      {
         result &= this.behaviorVariableResolver() ;
         result &= this.behaviorTransitionResolver() ;
      }
      
      return result ;
   }
   
   // Searches within the _baParentContainer.
   private boolean refResolver(Reference nameObj)
   {
      return refResolver(_baParentContainer, nameObj) ;
   }
   
   // Resolves Reference objects (arrayable identifiers)
   // within parent component's features ones and ba's variables ones and
   // for/forall's iterative variable scope handler.
   private boolean refResolver(Classifier parentContainer,
                               Reference ref)
   {
      boolean result = true ;
      boolean currentIdResult = false ;
      
      ListIterator<ArrayableIdentifier> it = ref.getIds().listIterator() ;
      
      // Checks ArrayableIdentifier objects.
      while(it.hasNext())
      {
        ArrayableIdentifier id = it.next() ;
        
        // Case of features or subcomponents without classifier.
        // Can't resolve within a null parent classifier.
        if(parentContainer == null)
        {
          result = false ;
          reportNameError(id, id.getId());
          break ;
        }
        
        if(parentContainer == _baParentContainer)
        {
          currentIdResult = identifierBaResolver(id, false) ;
        }
        
        if (! currentIdResult)
        {
          currentIdResult = identifierComponentResolver(id, parentContainer,
                                                        true) ;
        }
        
        if(id.isSetArrayIndexes())
        {
          // Checks array indexes names.
          for (IntegerValue index : id.getArrayIndexes())
          {
             // Recursive call.
             result &= integerValueResolver(index);
          }
        }

        // If the current id is found, fetch the container for the next id.
        if(currentIdResult && it.hasNext())
        {
          Element el = AadlBaTypeChecker.getBindedElement(id) ;
          
          // AadlBaUtils.getClassifier is not useful as BehaviorVariables have
          // not been type checked already.
          if(el instanceof BehaviorVariable)
          {
            
            QualifiedNamedElement qne = (QualifiedNamedElement)
                                           ((BehaviorVariable)el).
                                                        getDataClassifier() ;
            parentContainer = (Classifier) qne.getOsateRef();
          }
          else if(el instanceof IterativeVariable)
          {
            IterativeVariable itv = (IterativeVariable) el ;
            QualifiedNamedElement qne = (QualifiedNamedElement) itv.
                                                           getDataClassifier() ;
            parentContainer = (Classifier) qne.getOsateRef() ;
          }
          else
          {
            parentContainer = AadlBaUtils.getClassifier(el, parentContainer);
          }
        }
        
        // Add the current id result to the global result.
        result &= currentIdResult ;
        
        // Reset.
        currentIdResult = false ;
        
        // Don't continue if the current id is not found.
        if(result == false)
        {
          break ;
        }
      }
      
      // Binds with the last id reference.
      ArrayableIdentifier lastId = ref.getIds().get((ref.getIds().size() -1)) ;
      
      ref.setOsateRef(lastId.getOsateRef());
      ref.setBaRef(lastId.getBaRef());
      
      return result ;
   }
   
   private void reportDuplicateNameError(BehaviorElement be, NamedElement ne)
   {
     String neName = ne.getName() ;
     
     _errManager.error(be, "duplicate name error: " + neName + " at line " +
           be.getLocationReference().getLine() + " conflict with the element" +
             " with the same name located at line " + 
                Aadl2Utils.getLocationReference(ne).getLine()) ;
   }
   
   /**
    * Check behavior annex's sub component uniqueness within behavior annex's
    * parent component scope. Conflicts are reported.
    */
   private boolean parentComponentIdentifiersUniquenessCheck()
   {
      boolean result = true ;
      
      EList<org.osate.aadl2.NamedElement> lcc = 
                        new BasicEList<org.osate.aadl2.NamedElement>(0) ;

      // Merges parent component' subcomponents lists.
      lcc.addAll(Aadl2Visitors.getElementsInNamespace(_baParentContainer,
                                                       Data.class)) ;
      lcc.addAll(Aadl2Visitors.getElementsInNamespace(_baParentContainer,
                                                       Mode.class)) ;
      lcc.addAll(Aadl2Visitors.getElementsInNamespace(_baParentContainer,
                                                       Feature.class)) ;

      EList<BehaviorVariable> lvars = _ba.getVariables() ;
      EList<BehaviorState> lstates = _ba.getStates() ;
      EList<BehaviorTransition> ltrans = _ba.getTransitions() ;

      // Check uniqueness within the parent component.
      for(org.osate.aadl2.NamedElement ne : lcc)
      {
         for(BehaviorVariable v : lvars)
         {
           String bvName = v.getName() ; 
           
           String neName = ne.getName() ;
           
           if(bvName.equalsIgnoreCase(neName))
           {
              reportDuplicateNameError(v, ne) ;
              result = false ;
           }
         }

         for(BehaviorState s : lstates)
         {
            String bsName = s.getName() ;
            
            if(bsName.equalsIgnoreCase(ne.getName()))
            {
               // Complete states that represent modes are exceptions of 
               // D.3.(N1) naming rule.
               // Links the identifier with the mode.
               if(ne instanceof Mode)
               {
                  if(s.isComplete() == false)
                  {
                    _errManager.error(s, "Behavior state " + bsName + 
                          " must be declared complete in order to represent " + 
                                 "mode " + ne.getName() + " located at line " + 
                                 Aadl2Utils.getLocationReference(ne).getLine());
                                                                result = false ;
                  }
                  else
                  {
                    s.setBindedMode((Mode) ne) ;
                  }
               }
               else
               {
                  reportDuplicateNameError(s, ne) ;
                  result = false ;
               }
            }
         }

         for(BehaviorTransition t : ltrans)
         {
            String btName = t.getName() ;
            if(btName != null && btName.equalsIgnoreCase(ne.getName()))
            {
               reportDuplicateNameError(t, ne) ;
               result = false ;
            }
         }
      }
      
      return result ;
   }

   private boolean subcomponentIdResolver(Identifier id,
                                          Classifier parentComponent,
                                          boolean hasToReport)
   {
      String nameToFind = id.getId() ;
      
      Subcomponent subc = Aadl2Visitors.findSubcomponentInComponent
                                                  (parentComponent, nameToFind);

      if (subc != null)
      {
         id.setOsateRef(subc);
         return true ;
      }
      else 
      {
          if (hasToReport)
          {
             reportNameError(id, nameToFind);
          }
          return false ;
      }
   }

   private boolean subprogramParameterListResolver(EList<ParameterLabel> spl)
   {
      boolean result = true ;
      
      for (ParameterLabel pLabel : spl)
      {
         // Targets are parsed as value expression with only one value.
         // Targets are equivalent to value, syntactically.
         result &= valueExpressionResolver((ValueExpression) pLabel);
      }
      
      return result ;
   }

   private boolean targetResolver(Target tar)
   {
      return refResolver((Reference) tar) ;
   }
   
   private boolean timedActionResolver(TimedAction act)
   {
      boolean result = behaviorTimeResolver((DeclarativeTime) act.getLowerTime()) ;

      if(act.getUpperTime() != null)
      {
         result &= behaviorTimeResolver((DeclarativeTime) act.getUpperTime());
      }
      
      if(act.isSetProcessorClassifier())
      {
        for(ProcessorClassifier pc : act.getProcessorClassifier())
        {
          result &= qualifiedNamedElementResolver((QualifiedNamedElement) pc, true) ;
        }
      }
      
      return result ;
   }
   
   // Checks behavior time's time unit according to property set Time_Units and 
   // binds if checking is successful.
   private boolean timeUnitResolver(Identifier unitIdentifier)
   {
      PackageSection context = Aadl2Visitors.getContainingPackageSection(_ba);
      
      NamedElement pt = Aadl2Visitors.findElementInPropertySet
                                           (TIME_UNITS_PROPERTY_ID,
                                            TIME_UNITS_PROPERTY_SET,
                                            context) ;
      // Property set Time_Units is found.
      if (pt instanceof org.osate.aadl2.UnitsType)
      {
         org.osate.aadl2.UnitsType ut = (org.osate.aadl2.UnitsType) pt ;
         
         // Find the given time unit in the enumeration.
         org.osate.aadl2.UnitLiteral ul = ut.findLiteral(
                                                       unitIdentifier.getId()) ;
         // The given time unit is found.
         if(ul != null)
         {
            unitIdentifier.setOsateRef(ul) ;
            return true ;
         }
         else
         {
            _errManager.error(unitIdentifier, unitIdentifier.getId() +
                             " is not a valid time unit according " +
                             "to the property set Time_Units.") ;
            return false ;
         }
      }
      else
      {
         _errManager.error(unitIdentifier,
                           "Property set Time_Units is not found") ;
         return false ;
      }
   }

   private boolean qualifiedNamedElementResolver(QualifiedNamedElement qne,
                                                 boolean hasToReport)
   {
     String packageName = null ;
     EObject ne ;
     boolean hasNamespace = qne.getBaNamespace() != null ; 
        
     if(hasNamespace)
     {
        packageName = qne.getBaNamespace().getId() ;
     }

     // Now check the type in each current package's sections.
     for(PackageSection context: _contextsTab)
     {
        ne = Aadl2Visitors.findElementInPackage(qne.getBaName().getId(),
                                                packageName, context) ;
        
        if(ne == null)
        {
          ne = Aadl2Visitors.findElementInPropertySet(qne.getBaName().getId(),
                                                  packageName, context) ;
        }

        // An element is found.
        if(ne != null && ne instanceof NamedElement)
        {
          // Links unique component classifier reference with named element found.
          qne.setOsateRef((Element) ne) ;
          qne.getBaName().setOsateRef((Element) ne);
          
          if(hasNamespace)
          {
           qne.getBaNamespace().setOsateRef(((NamedElement) ne).getNamespace());
          }
                              
          return true ;
        }
     }
        
     // The element is not found.
     if(hasToReport)
     {
       StringBuilder qualifiedName = new StringBuilder() ; 
       
       if(hasNamespace)
       {
         qualifiedName.append(qne.getBaNamespace().getId()) ;
         qualifiedName.append("::") ;
       }
       
       qualifiedName.append(qne.getBaName().getId()) ;
       
       reportNameError(qne, qualifiedName.toString()) ;
     }
        
     return false ;
   }
   
   // Check constant value names means to check names
   // within behavior property reference ones or property set constant ones.
   /* value_constant ::=
           boolean_literal
         | numeric_literal
         | string_literal
         | property_constant
         | property_reference */
   private boolean valueConstantResolver(ValueConstant value)
   {
     if(value instanceof DeclarativePropertyReference)
     {
       return propertyReferenceResolver((DeclarativePropertyReference) value) ; 
     }
     else // Other literals : they don't contain any name.
     {
       return true ;
     }
   }

   private boolean propertyReferenceResolver(DeclarativePropertyReference ref)
   {
     if(ref.isPropertySet())
     {
       // Property reference or property constant from a property set.
       return propertySetpropertyReferenceResolver(ref) ;
     }
     else if(ref.getQualifiedName() != null) 
     {
       // Property reference from a qualified classifier.
       return classifierPropertyReferenceResolver(ref, true) == 0 ;
     }
     else
     {
       EList<ArrayableIdentifier> ids = ref.getReference().getIds() ;
       
       if(ids.size() > 2)
       {
         // Unqualified classifier reference cannot have more then two identifiers
         // so the Reference object is true classifier feature.
         return classifierFeaturePropertyReferenceResolver(ref) ;
       }
       else
       {
         // Ambiguous case: between an unqualified classifier and a classifier
         // feature.
         
         // First try as an unqualified classifier
         // Instantiate a QualifiedNamedElement from Reference's identifiers.
         
         QualifiedNamedElement qne = DeclarativeFactory.eINSTANCE.
                                                 createQualifiedNamedElement() ;
         
         Identifier nameId = DeclarativeFactory.eINSTANCE.createIdentifier() ;
         
         String name = ids.get(0).getId() ;
         
         if(ids.size() == 2)
         {
           name += '.' + ids.get(1).getId() ;
         }
         
         nameId.setId(name);
         nameId.setLocationReference(ids.get(0).getLocationReference());
         
         qne.setBaName(nameId);
         qne.setLocationReference(nameId.getLocationReference());
         
         ref.setQualifiedName(qne);
         short classifierResult = 
                                classifierPropertyReferenceResolver(ref, false);
         
         switch(classifierResult)
         {
           case 0: {
                     ref.setReference(null); // Unset reference.
                     return true ;
                   }
           
           // Second try as a classifier feature.
           case 1: { 
                     if(classifierFeaturePropertyReferenceResolver(ref))
                     {
                       ref.setQualifiedName(null);
                       return true ;
                     }
                     else
                     {
                       return  false ;
                     }
                   }
           
           case 2: // The classifier has been found but one or more property 
                   // names are not found. Errors have already been reported.
           default: {return false ; }
         }
       }
     }
   }
   
  private boolean classifierFeaturePropertyReferenceResolver(
                                               DeclarativePropertyReference ref)
  {
    Reference component = ref.getReference() ;
    
    if(refResolver(component))
    {
      PropertyAssociation pa = null ;
      Classifier type = null ;
      Identifier propertyNameId =  ref.getPropertyNames().get(0).
                                                              getPropertyName();
      Element el = (component.getOsateRef() != null) ? component.getOsateRef() :
                                                       component.getBaRef();
      if(el instanceof PrototypeBinding)
      {
        PrototypeBinding pb = (PrototypeBinding) el ;
        type = AadlBaUtils.getClassifier(pb, pb.getContainingClassifier());
      }
      else if(el instanceof ClassifierFeature)
      {
        ClassifierFeature cf = (ClassifierFeature) el ;
        
        // Fetch the own property association of the classifier feature. 
        pa = PropertyUtils.findPropertyAssociation(propertyNameId.getId(), cf);
        
        if(pa == null)
        {
          type = AadlBaUtils.getClassifier(cf,
                                           cf.getContainingClassifier()) ; 
        }
      }
      else if(el instanceof BehaviorVariable)
      {
        BehaviorVariable bv = (BehaviorVariable) el ;
        DeclarativeBehaviorElement de = (DeclarativeBehaviorElement)
                                                        bv.getDataClassifier() ;
        if(de.getOsateRef() instanceof Classifier)
        {
          type = (Classifier) de.getOsateRef() ;
        }
      }
      else // Cannot resolve or unimplemented cases.
      {
        String msg = "the type of \'" + ((NamedElement)el).getName() +
                     "\' cannot be resolved" ;
        _errManager.error(el, msg);
      }
      
      // If the property is not found within the classifier feature definition,
      // search within its type.
      if(pa == null && type != null)
      {
        pa = PropertyUtils.findPropertyAssociation(propertyNameId.getId(),
                                                   type);
      }
      
      if(pa != null)
      {
        ref.getPropertyNames().get(0).setOsateRef(pa);
        propertyNameId.setOsateRef(pa);
        
        return propertyNameResolver(ref.getPropertyNames()) ;
      }
      else
      {
        reportNameError(propertyNameId, propertyNameId.getId()) ;
        return false ;
      }
    }
    else
    { 
      return false ; // refResolver has already reported the error.
    }
  }

  // return result code:
  // 0 : resolution has passed.
  // 1 : classifier is not found.
  // 2 : classifier has been found but one or more property names are not found.
  private short classifierPropertyReferenceResolver(
                                               DeclarativePropertyReference ref,
                                               boolean hasToReport)
  {
    if(qualifiedNamedElementResolver(ref.getQualifiedName(), hasToReport))
    {
      Classifier klass = (Classifier) ref.getQualifiedName().getOsateRef() ;
      Identifier propertyNameId =  ref.getPropertyNames().get(0).getPropertyName();
      
      PropertyAssociation pa = PropertyUtils.findPropertyAssociation(
                                              propertyNameId.getId(), klass) ;
      if(pa != null)
      {
        ref.getPropertyNames().get(0).setOsateRef(pa);
        propertyNameId.setOsateRef(pa);
        
        return (short) ((propertyNameResolver(ref.getPropertyNames())) ? 0 : 2) ;
      }
      else
      {
        reportNameError(propertyNameId, propertyNameId.getId()) ;
        return 2 ;
      }
    }
    else
    {
      return 1 ;
    }
  }

   private boolean propertySetpropertyReferenceResolver
                                              (DeclarativePropertyReference ref)
   {
     Identifier propertyNameId =  ref.getPropertyNames().get(0).getPropertyName();
     String packageName = null ;
     
     if(ref.getQualifiedName() != null)
     {
       packageName = ref.getQualifiedName().getBaNamespace().getId() ;
     }
     
     NamedElement ne = null ;
     
     // Now check the type in each current package's sections.
     for(PackageSection context: _contextsTab)
     {
       ne = Aadl2Visitors.findElementInPropertySet(propertyNameId.getId(),
                                                   packageName, context) ;
       if(ne != null)
       {
         propertyNameId.setOsateRef(ne);
         ref.getPropertyNames().get(0).setOsateRef(ne);
         
         if(packageName != null)
         {
           ref.getQualifiedName().getBaNamespace().setOsateRef(ne.getNamespace());
           ref.getQualifiedName().setOsateRef(ne.getNamespace());
         }
         
         if(ne instanceof Property)
         {
           Property p = (Property) ne ;
           
           // First search within the default values.
           if(p.getDefaultValue() != null)
           {
             PropertyExpression pe = p.getDefaultValue() ;
             propertyNameId.setOsateRef(pe);
             ref.getPropertyNames().get(0).setOsateRef(pe);
           }
           
           return propertyNameResolver(ref.getPropertyNames()) ;
         }
         else if(ne instanceof PropertyType) 
         {                                      
           if(ne instanceof EnumerationType)
           {
             return propertyNameResolver(ref.getPropertyNames()) ;
           }
           else
           {
             // It doesn't make any sense
             // for the other types.
             String msg = "reference to property type (other than enumeration" +
                          " type) is not supported";
             _errManager.error(ref.getPropertyNames().get(1).getPropertyName(),
                               msg);
             return false ;
           }
         }
         else // Property constant case.
         {
           if(ref.getPropertyNames().size() > 1)
           {
             // Property constants haven't any sub property.
             String msg = "property names are not supported for property constant";
             _errManager.error(ref.getPropertyNames().get(1).getPropertyName(),
                               msg);
             return false ;
           }
           else
           {
             DeclarativePropertyName firstDpn = ref.getPropertyNames().get(0) ;
             
             if (null != firstDpn.getField() || firstDpn.isSetIndexes())
             {
               // Property constants haven't any property field.
               String msg = "property fields are not supported for property constant" ;
               
               BehaviorElement bel = (null != firstDpn.getField()) ? 
                                                           firstDpn.getField() :
                                                   firstDpn.getIndexes().get(0);
               _errManager.error(bel, msg);
               
               return false ;
             }
             else
             {
               return true ;
             }
           }
         }
       }
     }
     
     reportNameError(propertyNameId, propertyNameId.getId()) ;
     
     return false ;
   }
   
   private boolean propertyNameResolver(EList<DeclarativePropertyName> propertyNames)
   {
     // Ambiguity between a property literal and a property name without field.
     // So the next property name is evaluated.
     
     // The first property name has already been resolved, excepted its field. 
     ListIterator<DeclarativePropertyName> it = propertyNames.listIterator() ;
     DeclarativePropertyName currentName = it.next() ;
     
     Element previousContainer = null ;
     int previousContainerId = -1 ;
     
     // Then resolve the property field.
     if(false == propertyIndexAndFieldResolution(currentName))
     {
       return false ;
     }
          
     while(it.hasNext())
     {
       previousContainer = currentName.getOsateRef() ;
       previousContainerId = previousContainer.eClass().getClassifierID() ;
       currentName = it.next() ;
       
       // Case of properties defined by a property association.
       if(Aadl2Package.PROPERTY_ASSOCIATION == previousContainerId)
       {
         PropertyAssociation pa =
              (PropertyAssociation) previousContainer ;

         if(propertyAssociationResolver(pa, currentName) &&
            propertyIndexAndFieldResolution(currentName))
         {
           continue ;
         }
         else // Property association may exist but doesn't define the 
              // property that interests us. So search within the property
              // definition.
         {
           previousContainer = pa.getProperty() ;
         }
       }
       
       // The sub property is defined within a property expression. 
       if(previousContainer instanceof PropertyExpression)
       {
         if(propertyValueResolver((PropertyExpression) previousContainer,
                                                                 currentName) &&
            propertyIndexAndFieldResolution(currentName))
         {
           continue ;
         }
         else // Try with the property expression type definition.
         {
           previousContainer = PropertyUtils.getContainingProperty((PropertyExpression) 
                                                     previousContainer) ;
         }
       }
       
       previousContainerId = previousContainer.eClass().getClassifierID() ;
       
       // Try to resolve the property name within the property declaration.
       if(Aadl2Package.PROPERTY == previousContainerId)
       {
         Property p = (Property) previousContainer ;
         
         if(propertyDeclarationResolver(p, currentName) &&
            propertyIndexAndFieldResolution(currentName))
         {
           continue ;
         } // Then the property type definition.
         else if(propertyTypeResolver(p.getPropertyType(), currentName) &&
                 propertyIndexAndFieldResolution(currentName))
         {
           continue ;
         }
         else
         {
           // propertyTypeResolver and propertyFieldResolution report any error.
           return false ;
         }
       }    //BasciProperty EMF identifier == Aadl2Package.LIST_VALUE, why ???? 
       else if(previousContainer instanceof BasicProperty) // Use instanceof instead.
       {
         // The sub property is defined within a Record field (basic property).
         BasicProperty bp = (BasicProperty) previousContainer ;
         
         
         
         if(propertyTypeResolver(bp.getPropertyType(), currentName) &&
            propertyIndexAndFieldResolution(currentName))
         {
           continue ;
         }
         else
         {
           // propertyTypeResolver and propertyFieldResolution report any error.
           return false ;
         }
       } // The property is defined within the type of a record.
       else if (Aadl2Package.RECORD_TYPE == previousContainerId)
       {
         RecordType rt = (RecordType) previousContainer ;
         
         if(recordFieldResolver(rt, currentName) &&
            propertyIndexAndFieldResolution(currentName))
         {
           continue ;
         }
         else
         {
           return false ;
         }
       }
       else  if(Aadl2Package.ENUMERATION_TYPE == previousContainerId)
       {
         EnumerationType type = (EnumerationType) previousContainer ;
         return enumerationTypeResolver(type, currentName) ;
       }
       else // other types like ListType, etc.
       {
         // As it doesn't make any sense to look after a name in a property type
         // report an error.
         
         reportNameError(currentName.getPropertyName(),
                         currentName.getPropertyName().getId());
         return false ;
       }
     } // End of while.
     
     return true ;
   }
   
  private boolean recordFieldResolver(RecordType rt,
                                      DeclarativePropertyName declPropertyName)
  {
    String name = declPropertyName.getPropertyName().getId() ;
    
    for(BasicProperty bp : rt.getOwnedFields())
    {
      if(bp.getName().equalsIgnoreCase(name))
      {
        declPropertyName.setOsateRef(bp);
        declPropertyName.getPropertyName().setOsateRef(bp);
        return true ;
      }
    }
    
    return false ;
  }

  private boolean propertyValueResolver(PropertyExpression pe,
                                        DeclarativePropertyName currentName)
  {
    String name = currentName.getPropertyName().getId() ;
    try
    {
      Element found = PropertyUtils.getValue(pe, name) ;
      if(found != null)
      {
        currentName.setOsateRef(found);
        currentName.getPropertyName().setOsateRef(found);
        return true ;
      }
      else
      {
        return false ;
      }
    }
    catch(UnsupportedOperationException e)
    {
      return false ;
    }
  }

  private boolean propertyTypeResolver(PropertyType type,
                                       DeclarativePropertyName declPropertyName)
  {
    int typeId = type.eClass().getClassifierID() ;
    String name = declPropertyName.getPropertyName().getId() ;
    
    switch(typeId)
    {
      case Aadl2Package.ENUMERATION_TYPE:
      {
        return enumerationTypeResolver((EnumerationType)type, declPropertyName) ;
      }
      
      case Aadl2Package.RECORD_TYPE:
      {
        RecordType recordType = (RecordType) type ;
        for(BasicProperty bp : recordType.getOwnedFields())
        {
          if(bp.getName().equalsIgnoreCase(name))
          {
            declPropertyName.setOsateRef(bp);
            declPropertyName.getPropertyName().setOsateRef(bp);
            return true ;
          }
        }
        
        return false ;
      }
      
      case Aadl2Package.LIST_TYPE: // Type of ListType is ListType and not its 
                                   // owned element type.
      {
        reportNameError(declPropertyName, name);
        return false ;
      }
      default:
      {
        String msg = "property literals are only supported for enumeration and"+
                     " record property type";
        _errManager.error(declPropertyName, msg);
        return false ;
      }
    }
  }

  private boolean enumerationTypeResolver(EnumerationType type,
                                          DeclarativePropertyName declPropertyName)
  {
    EnumerationType enumType = (EnumerationType) type ;
    for(EnumerationLiteral literal : enumType.getOwnedLiterals())
    {
      if(literal.getName().equalsIgnoreCase(declPropertyName.getPropertyName().getId()))
      {
        declPropertyName.setOsateRef(literal);
        declPropertyName.getPropertyName().setOsateRef(literal);
        return true ;
      }
    }
    
    return false ;
  }

  private boolean propertyDeclarationResolver(Property property,
                                            DeclarativePropertyName declProName)
  {
    PropertyExpression pe = property.getDefaultValue() ;
    String name = declProName.getPropertyName().getId() ;
    if(pe != null)
    {
      try
      {
        Element found = PropertyUtils.getValue(pe, name);
        if(found != null)
        {
          declProName.setOsateRef(found);
          declProName.getPropertyName().setOsateRef(found);
          return true ;
        }
        else
        {
          return false ;
        }
      }
      catch (UnsupportedOperationException e)
      {
        return false ;
      }
    }
    else
    {
      return false ;
    }
  }

  private boolean propertyAssociationResolver(PropertyAssociation pa,
                                            DeclarativePropertyName declProName)
  {
    EList<PropertyExpression> pel = PropertyUtils.getPropertyExpression(pa) ;
    PropertyExpression pe = pel.get(pel.size() -1) ;
    String name = declProName.getPropertyName().getId() ;
    
    try
    {
      Element tmp = PropertyUtils.getValue(pe, name);
      
      if(tmp != null)
      {
        declProName.setOsateRef(tmp);
        declProName.getPropertyName().setOsateRef(tmp);
        return true ;
      }
      else
      {
        return false ;
      }
    }
    catch (UnsupportedOperationException e)
    {
      return false ;
    }
  }

  private BasicProperty getPropertyDeclaration(Element el)
  {
    if(Aadl2Package.PROPERTY_ASSOCIATION == el.eClass().getClassifierID())
    {
      return ((PropertyAssociation)el).getProperty() ;
    }
    else if(Aadl2Package.PROPERTY == el.eClass().getClassifierID())
    {
      return (Property) el ;
    }
    else if(el instanceof PropertyExpression)
    {
      return PropertyUtils.getContainingProperty((PropertyExpression) el) ;
    }
    //BasicProperty EMF identifier == Aadl2Package.LIST_VALUE, why ???? 
    else if(el instanceof BasicProperty)
    {
      return (BasicProperty) el ;
    }
    else
    {
      String msg = el.getClass().getSimpleName() + " is not supported" ;
      System.err.println(msg) ;
      throw new UnsupportedOperationException(msg) ;
    }
  }
  
  private boolean propertyIndexAndFieldResolution(DeclarativePropertyName declProName)
  {
    boolean hasField = declProName.getField() != null ;
    boolean hasIndex = declProName.isSetIndexes() ;
    
    if(hasField)
    {
      return propertyFieldResolution(declProName) ;
    }
    else if(hasIndex)
    {
      return propertyIndexResolver(declProName) ;
    }
    else
    {
      return true ;
    }
  }
   
  private boolean propertyFieldResolution(DeclarativePropertyName declProName)
  {
    PropertyNameField field = declProName.getField() ;
    Element el = declProName.getOsateRef() ;
    BasicProperty bProperty = getPropertyDeclaration(el) ;
    int nameTypeId = bProperty.getPropertyType().eClass().getClassifierID() ;

    // Upper and lower bound fields are only supported for range property
    // type.
    if(nameTypeId == Aadl2Package.RANGE_TYPE)
    {
      return true ;
    }
    else
    {
      String msg =
            "upper or lower bound keyword are only supported for"
                  + " range property type" ;
      _errManager.error(field, msg) ;
      return false ;
    }
  }
  
  private boolean propertyIndexResolver(DeclarativePropertyName declProName)
  {
    Element el = declProName.getOsateRef() ;
    BasicProperty bProperty = getPropertyDeclaration(el) ;
    int nameTypeId = bProperty.getPropertyType().eClass().getClassifierID() ;
    EList<IntegerValue> indexes = declProName.getIndexes() ;
    
    if(nameTypeId == Aadl2Package.ENUMERATION_TYPE)
    {
      if(indexes.size() == 1)
      {
        return integerValueResolver(indexes.get(0)) ;
      }
      else
      {
        String msg =
              "multiple integer index is not only supported for property enumeration" ;
        _errManager.error(indexes.get(1), msg) ;
        return false ;
      }
    }
    else if(nameTypeId == Aadl2Package.LIST_TYPE ||
            Aadl2Package.LIST_VALUE == el.eClass().getClassifierID())
    {
      for(int fieldIndex=0 ; fieldIndex < indexes.size() ; fieldIndex++)
      {
        IntegerValue iv = indexes.get(fieldIndex) ;
        
        if(propertyFieldIndexResolver(el, iv, bProperty, fieldIndex, declProName))
        {
          continue ;
        }
        else
        {
          return false ;
        }
      }
      
      return true ;
    }
    else
    {
      String msg =
            "integer index is only supported for list of properties or " +
            "property enumerations" ;
      _errManager.error(indexes.get(0), msg) ;
      return false ;
    }
  }
  
  private boolean propertyFieldIndexResolver(Element el, IntegerValue field,
                                             BasicProperty bProperty,
                                             int fieldIndex,
                                            DeclarativePropertyName declProName)
  {
    if(integerValueResolver(field))
    {
      // Link to the default value, if it exists.
      if(Aadl2Package.LIST_VALUE == el.eClass().getClassifierID() &&
         propertyFieldListValueResolver(field, (ListValue) el, fieldIndex,
                                        declProName))
      {
        return true ;
      }
      else if (Aadl2Package.PROPERTY_ASSOCIATION == el.eClass().getClassifierID())
      {
        PropertyAssociation pa = (PropertyAssociation) el ;
        ModalPropertyValue mpv = pa.getOwnedValues().get(pa.getOwnedValues().size()-1) ;
        PropertyExpression pe = mpv.getOwnedValue() ;
        if(Aadl2Package.LIST_VALUE == pe.eClass().getClassifierID())
        {
          return propertyFieldListValueResolver(field, (ListValue) pe,
                                                fieldIndex, declProName) ;
        }
      }
      // the else statements: link with the property type.
      
      ListType lt = (ListType) bProperty.getPropertyType() ;
      declProName.setOsateRef(lt.getElementType()) ;
      return true ;
    }
    else
    {
      return false ;
    }
  }

  private boolean propertyFieldListValueResolver(IntegerValue field,
                                                 ListValue lv,
                                                 int fieldIndex,
                                            DeclarativePropertyName declProName)
  {
    if(AadlBaPackage.BEHAVIOR_INTEGER_LITERAL == field.eClass().getClassifierID())
    {
      BehaviorIntegerLiteral bil = (BehaviorIntegerLiteral) field ;
      Long index = bil.getValue() ;
      return propertyFieldListIndexResolver(index.intValue(), lv, fieldIndex,
                                            declProName) ;
    }
    else
    // As field is an integer value variable, the integer 
    // value cannot be evaluated at compile time. So raise
    // a warning
    {
      String msg = "integer variable as a property array index is not evaluated." ;
      _errManager.warning(declProName.getIndexes().get(fieldIndex), msg) ;
      return false ;
    }
  }

   private boolean propertyFieldListIndexResolver(int index,
                                                  ListValue lv,
                                                  int fieldIndex,
                                            DeclarativePropertyName declProName)
   {
     if(index >= 0)
     {
       // Check list bound:
       EList<PropertyExpression> values = lv.getOwnedListElements() ;
       if(values.size() < index)
       {
         // Report out of bounds error.
         String msg = "array out of bound, size is: " + values.size();
         _errManager.error(declProName.getIndexes().get(fieldIndex), msg) ;
         return false ;
       }
       else
       {
         declProName.setOsateRef(values.get(index));
         return true ;
       }
     }
     else
     {
       // Report out of bounds error.
       String msg = "negative array bound";
       _errManager.error(declProName.getIndexes().get(fieldIndex), msg) ;
       return false ;
     }
   }

   private boolean valueExpressionResolver(ValueExpression expr)
   {
      boolean result = true ;
      int seNb = 0 ;
      SimpleExpression se ;
      Value v ;
      int vNb = 0 ;
      
      // Iterates over relations.
      for(Relation r : expr.getRelations())
      {
         se = r.getFirstExpression() ;
         
         // Treats simple expression(s).
         do
         {
            // Iterates over Terms.
            for(Term t : se.getTerms())
            {
               // Iterate over Factors.
               for (Factor f : t.getFactors())
               {
                  v = f.getFirstValue() ;
                  
                  // Treats value(s).
                  do
                  {
                    result &= valueResolver(v) ; 
                    v = f.getSecondValue() ;
                    vNb++ ;
                  } while (v != null && vNb != 2) ;
                  
                  vNb = 0 ;
               }// End of for factors.
            }// End of for terms.
            
            se = r.getSecondExpression() ;
            seNb++ ;
         } while(se != null && seNb != 2) ;

         seNb = 0 ;
      }// End of for relations.
      
      return result ;
   }
   
  private boolean valueResolver(Value value)
  {
    if(value instanceof ValueVariable)
    {
      return valueVariableResolver(value, (ValueVariable) value) ;
    }
    else if(value instanceof ValueConstant)
    {
      return valueConstantResolver((ValueConstant) value) ;
    }
    else // Case of value expression : recursive call.
    {
      return valueExpressionResolver((ValueExpression) value) ;
    }
  }
   
   // Check data component ref, ba variable name or feature name contained 
   // in ValueVariable.
   /* // value_variable ::=
      //   incoming_port_name
      // | incoming_port_name ?
      // | incoming_port_data_component_reference
      // | port_name' count
      // | port_name' fresh */
   private boolean valueVariableResolver(BehaviorElement toBeSet,
                                         ValueVariable value)
   {
      if(value instanceof Reference)
      {
         return refResolver((Reference)value) ;
      }
      else // NamedValue case.
      {
        Reference ref = ((NamedValue) value).getReference() ;
        return refResolver(ref) ; 
      }
   }
   
   /**
    * Resolves the behavior annex's variables.
    * 
    * @return {@code true} if all names are resolved. {@code false} otherwise.
    */
   private boolean behaviorVariableResolver()
   {
      boolean result = true ;
      QualifiedNamedElement uccr ;
      
      // For each behavior variable, check if declared unique component 
      // classifier reference exists.
      for(BehaviorVariable v : _ba.getVariables())
      {
         
        uccr = (QualifiedNamedElement) v.getDataClassifier() ;

        result &= qualifiedNamedElementResolver(uccr, true) ;
         
        for(ArrayDimension tmp : v.getArrayDimensions())
        {
          IntegerValueConstant ivc = ((DeclarativeArrayDimension)tmp).
                                                                getDimension() ; 
          result &= integerValueConstantResolver(ivc) ;
        }
      }
      return result ;
   }

   // TODO Provide column number.
   private void reportNameError(BehaviorElement el, String name) 
   {
//     if(el.eContainer() == null)
//     {
//       DeclarativeUtils.setEcontainer(_ba, el) ;
//     } 
     
     _errManager.error(el, "\'" + name + "\' is not found");
   }
}