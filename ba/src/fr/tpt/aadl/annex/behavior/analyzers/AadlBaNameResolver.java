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

package fr.tpt.aadl.annex.behavior.analyzers;

import java.util.HashSet ;
import java.util.ListIterator ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.Mode ;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace ;
import org.osate.aadl2.PackageSection ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import fr.tpt.aadl.annex.behavior.aadlba.*;
import fr.tpt.aadl.annex.behavior.declarative.*;

import fr.tpt.aadl.annex.behavior.names.DataModelProperties;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaVisitors ;

/**
 * A AADL behavior annex name resolver.
 * 
 * @author GET Telecom-Paristech
 * 
 */
public class AadlBaNameResolver
{
   private BehaviorAnnex _ba ;
   private ComponentClassifier _baParentContainer ;
   PackageSection[] _contextsTab ;
   private AnalysisErrorReporterManager _errManager ;
   
   // Time units property set name.
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
      
      Set<String> svars = new HashSet<String>() ;
      Set<String> sstates = new HashSet<String>() ;
      Set<String> strans = new HashSet<String>(ltrans.size()) ;

      for(BehaviorVariable v : lvars)
      {
        String bvName = v.getName() ; 
        
        for(BehaviorState s : lstates)
        {
           String bsName = s.getName() ;
          
           if(bsName.equalsIgnoreCase(bvName))
           {
              _errManager.error(s, "conflict with " + bvName + 
                    " at line " + v.getLocationReference().getLine()) ;
              result = false ;
           }
        }
        
        for(BehaviorTransition t : ltrans)
        {
           String btName = t.getName() ;
           
           if(btName != null && btName.equalsIgnoreCase(bvName))
           {
              _errManager.error(t, "conflict with " + bvName +
                  " at line " + v.getLocationReference().getLine()) ;
              result = false ;
           }
        }
        
        if(! svars.add(bvName))
        {
           _errManager.error(v, "duplicate name for1 " + bvName) ;
           result = false ;
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
               _errManager.error(t, "conflict with " + bsName
                     + " at line " + s.getLocationReference().getLine()) ;
               result = false ;
            }
         }
         if(!sstates.add(bsName))
         {
            _errManager.error(s, "duplicate name for " + bsName) ;
            result = false ;
         }
      }

      for(BehaviorTransition t : ltrans)
      {
         String btName = t.getName() ;
         if(btName != null && !(strans.add(btName)))
         {
            _errManager.error(t, "duplicate name for " + btName) ;
            result = false ;
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
           // as a void condition means always true.
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
                  
                  // Set the for structure's element variable type as BA
                  // referenced entity.
                                    
                  result &= iterativeVariableUniquenessCheck(itVar); 
                  
                  // Add the for/forall statment's iterative variable to 
                  // the scope handler.
                  _itvScope.add(itVar);
                  
                  // Check element values.
                  result &= elementValuesResolver(stat.getIteratedValues());
                  
                  // Check behavior actions.
                  result &= behaviorActionsResolver(stat.getBehaviorActions()) ;
                  
                  // remove the for/forall statment's iterative variable from
                  // the scope handler.
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
   
   // Just the opposite of checkFeatureName.
   private boolean featureNameUniquenessCheck(IterativeVariable itv)
   {
      String nameToFind = itv.getName(); 
      
      Feature f = AadlBaVisitors.findFeatureInComponent(_baParentContainer,
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
   
   private boolean iterativeVariableResolver(Identifier itv,
                                             boolean hasToReport)
   {
     IterativeVariable sameId = AadlBaUtils.compareNamedElementList(itv.getId(),
                                                                   _itvScope) ;
     if( sameId != null)
     {
       // Resolve the iterative variable with its declaration.
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
     
     
     return integerValueResolver(bt.getIntegerValue()) &
            timeUnitResolver(timeUnit);
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
       //   (single id) without array index.
       // _ unqualified unique component classifier reference with
       //   implementation information provided and a reference (two ids)
       //   without array index.
       
       Reference ref = act.getReference() ;
       EList<ArrayableIdentifier> ids = ref.getIds() ;
       boolean hasArrayIndex = false ;
       
       // unqualified unique component classifier reference have at most two
       // identifiers.
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
           // classifier reference and a reference with only one id.
           
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
           
           // Clone the identifier as class members of the MetaModel are set as
           // unique instance.
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
   
/*   
   private boolean communicationActionResolver(CommunicationAction act)
   {
      if(act instanceof SharedDataAction)
      {
         SharedDataAction sda = (SharedDataAction) act ;
         
         // Cases of name !< or name !>
         if(sda.getDataAccessName() != null)
         {
            return refResolver(sda.getDataAccessName()) ;
         }
         else // Cases of * !< or * !> 
         {
            return true ;
         }
      }
      
      if(act instanceof PortFreezeAction)
      {
         return refResolver((PortFreezeAction)act) ;
      }
      
      if(act instanceof PortDequeueAction)
      {
         PortDequeueAction pda = (PortDequeueAction) act ;
         boolean result = refResolver(pda.getPortName()) ;
         
         // PortDequeueAction's target may be null.
         if(pda.getTargetOwned() != null)
         {
            result &= targetResolver(pda.getTargetOwned()) ;
         }
         
         return result ;
      }
      
      //Case of subprogram call
      boolean result = true ;
      
      SubprogramCallAction sca = (SubprogramCallAction) act ;
      EList<Name> names = sca.getSubprogramNames() ;
      
      if(sca.isSetSubprogramNames())
      {
         Name n1 = names.get(0) ;
         Name n2 = null ;
         
         if(names.size() == 2)
         {
            n2 = names.get(1);
         }
         
         // Resolves name and name.name cases.
         if(n1.isSetArrayIndexes() || (n2 !=  null && n2.isSetArrayIndexes()))
         {
            result = subprogramCallNamesResolver(n1, n2) ;
         }
         else // Resolves ambiguous case between unqualified unique component
              // classifier reference and a name or name.name without array
              // index.
         {
            StringBuilder name = new StringBuilder() ;
            name.append(n1.getIdentifierOwned().getId());
            
            if(n2 != null)
            {
               name.append("." + n2.getIdentifierOwned().getId());
            }
            
            UniqueComponentClassifierReference uccr = 
            	AadlBaFactory.eINSTANCE
                      .createUniqueComponentClassifierReference();
            
            Identifier nameId = AadlBaFactory.eINSTANCE.createIdentifier();
            nameId.setId(name.toString()) ;
            uccr.setName(nameId) ;
            uccr.setQualifiedName(uccr.getName());
            
            // Try name.name as a unique component classifier reference.
            if(uniqueComponentClassifierRefResolver(uccr, false))
            {
               sca.unsetSubprogramNames();
               uccr.setLocationReference(n1.getLocationReference());
               sca.setSubprogramReference(uccr);
               result = true ;
            }
            else // Try name.name as a subprogram call.
            {
               result = subprogramCallNamesResolver(n1, n2) ;
            }
         }
      }
      else //Case of unique component classifier reference.
      {
         result = uniqueComponentClassifierRefResolver(
                                           sca.getSubprogramReference(), true) ; 
      }
      
      // SubprogramParameterList may be unset.
      // value expressions are parsed as subprogram parameter list with only one
      // parameter label.
      if(sca.isSetParameterLabels())
      {
         result &= subprogramParameterListResolver(
                                       sca.getParameterLabels()) ;
      }
      
      return result ;
   }
*/
/*
   
   private boolean dataComponentRefResolver(DataComponentReference dcr)
   {
	   boolean result = false ;
	   
	   DataClassifier parentComponent = null ;
	   
	   EList<Name> nameList = dcr.getNames() ;
	      
	   Iterator<Name> it = nameList.iterator() ;
	      
	   Name currentName = it.next() ;
	   Name precedentName = currentName ;
	      
	   // Check the dcr's first name which can be a subcomponent name or an 
	   // access feature name. 
	   
	   result = refResolver(currentName) ;
	   
	   if (result)
	   {
		   while(it.hasNext())
		   {
			   currentName = it.next() ;
			   
			   // Unresolved data prototype returns null.
			   parentComponent = AadlBaUtils.getDataClassifier(precedentName) ;
			   
			   if(parentComponent == null)
			   {
				   reportNameError(currentName,
						           currentName.getIdentifierOwned().getId()) ;
				   result = false ;
				   break ;
			   }
			   
			   result = dataSubcomponentNameResolver(currentName,
					                                 parentComponent) ;
			   if(! result)
			   {
				   break ;
			   }
			   else
			   {
				   precedentName = currentName ;
				   continue ;
			   }
		   }
		   
		   if (result)
		   {
			   dcr.setAadlRef(currentName.getAadlRef()) ;
			   dcr.setBaRef(currentName.getBaRef()) ;
		   }
	   }
	   
	   return result ;
   }
   
   private boolean dataSubcomponentNameResolver(Name name,
		                                          DataClassifier component)
   {
	   boolean result = false ;
	   
	   Identifier id = name.getIdentifierOwned() ;
	   
	   result = subcomponentIdResolver(id, component, false) ;
	   
	   if(! result)
	   {
		   result = structOrUnionIdResolver(id, component, true) ;
	   }
	   
	   name.setAadlRef(id.getAadlRef()) ;
	   name.setBaRef(id.getBaRef()) ;
	   
	   // Check array indexes names.
	   for (IntegerValue index : name.getArrayIndexes())
	   {
	       // Recursive call.
	       result &= integerValueResolver(index);
	   }
	   
	   return result ;
   }

*/  
  
   /* dispatch_condition ::=
        on dispatch [ dispatch_trigger_condition ] [ frozen frozen_ports ] */
   private boolean dispatchConditionResolver(DispatchCondition cond)
   {
      boolean result = true ;
      
      DispatchTriggerCondition dtc = cond.getDispatchTriggerCondition() ;
      
      // Dtc can be null as a void dispatch trigger condition means always true. 
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
      | provides_subprogram_access_identifier
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
      
      Feature f = AadlBaVisitors.findFeatureInComponent(parentContainer,
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
         if(iterativeVariableResolver(id, false))
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
   
   // Resolves identifier within the prototypes, features and subcomponent of
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
	    			 return structOrUnionIdResolver(id,
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
   
   // Resolves the given identifier within the property Data_Model::Element Names
   // of a declared struct or union component (event if element names is set).
   // If the given component is not declared as a struct or union, it returns
   // false and reports error according to the hasToReport flag.
   private boolean structOrUnionIdResolver(Identifier id,
		                                   DataClassifier component,
		                                   boolean hasToReport)
   {
	  boolean result = false ;
	  
	  DataRepresentation rep = AadlBaUtils.getDataRepresentation(component);
	  
	  if(rep == DataRepresentation.STRUCT || rep == DataRepresentation.UNION)
	  {
		  EList<PropertyExpression> lpv = 
                            AadlBaGetProperties.getPropertyExpression(component,
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
                  AadlBaGetProperties.getPropertyExpression(component,
   		              DataModelProperties.BASE_TYPE) ;
			  
			  ClassifierValue cv ;
			  
			  cv = (ClassifierValue ) ((ListValue) lpv2.get(index1)).
			                               getOwnedListElements().get(index2) ;
			  
			  id.setOsateRef(cv) ;
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

      PrototypeBinding pb = AadlBaVisitors.findPrototypeBindingInComponent
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
         Prototype proto = AadlBaVisitors.findPrototypeInComponent
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
   
   // Search within the _baParentContainer.
   private boolean refResolver(Reference nameObj)
   {
      return refResolver(_baParentContainer, nameObj) ;
   }
   
   // Resolves Reference Object (arrayable identifiers)
   // within parent component's features ones and ba's variables ones and
   // for structure element variables scope handler.
   private boolean refResolver(Classifier parentContainer,
                               Reference ref)
   {
      boolean result = true ;
      boolean currentIdResult = false ;
      
      ListIterator<ArrayableIdentifier> it = ref.getIds().listIterator() ;
      
      
      // Check ArrayableIdentifier objects.
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
          // Check array indexes names.
          for (IntegerValue index : id.getArrayIndexes())
          {
             // Recursive call.
             result &= integerValueResolver(index);
          }
        }

        // If the current id is found, proceed to the next id.
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
          else
          {
            parentContainer = AadlBaUtils.getClassifier(el, _baParentContainer);
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
      
      // Bind with the last id reference.
      ArrayableIdentifier lastId = ref.getIds().get((ref.getIds().size() -1)) ;
      
      ref.setOsateRef(lastId.getOsateRef());
      ref.setBaRef(lastId.getBaRef());
      
      return result ;
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

      // Merge parent component' subcomponents lists.
      lcc.addAll(AadlBaVisitors.getElementsInNamespace(_baParentContainer,
                                                       Data.class)) ;
      lcc.addAll(AadlBaVisitors.getElementsInNamespace(_baParentContainer,
                                                       Mode.class)) ;
      lcc.addAll(AadlBaVisitors.getElementsInNamespace(_baParentContainer,
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
           
           if(bvName.equalsIgnoreCase(ne.getName()))
           {
              _errManager.error(v, "conflict with " + ne.getName()
                    + " at line " + ne.getLocationReference().getLine()) ;
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
                                           ne.getLocationReference().getLine());
                                                                result = false ;
                  }
                  else
                  {
                    s.setBindedMode((Mode) ne) ;
                  }
               }
               else
               {
                  _errManager.error(s, "conflict with " + ne.getName()
                        + " at line " + ne.getLocationReference().getLine());
                  result = false ;
               }
            }
         }

         for(BehaviorTransition t : ltrans)
         {
            String btName = t.getName() ;
            if(btName != null && btName.equalsIgnoreCase(ne.getName()))
            {
               _errManager.error(t, "conflict with " + ne.getName()
                     + " at line " + ne.getLocationReference().getLine()) ;
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
      
      Subcomponent subc = AadlBaVisitors.findSubcomponentInComponent
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
      
      return result ;
   }
   
   // Checks behavior time's time unit according to property set Time_Units and 
   // binds if checking is successful.
   private boolean timeUnitResolver(Identifier unitIdentifier)
   {
      PackageSection context = AadlBaVisitors.getContainingPackageSection(_ba);
      
      PropertiesLinkingService pls = PropertiesLinkingService.
                                          getPropertiesLinkingService(context) ;
      
      EObject ne=pls.findNamedElementInPredeclaredPropertySets(AadlBaVisitors.INITIALIZE_ENTRYPOINT_PROPERTY_NAME, context, null);
      if(ne==null)
      {
        PropertySet ps = pls.findPropertySet(context, TIME_UNITS_PROPERTY_SET);
        if(ps!=null)
          ne = ps.findNamedElement(TIME_UNITS_PROPERTY_ID);
      }
      
      
      
      // Property set Time_Units is found.
      if (ne instanceof org.osate.aadl2.UnitsType)
      {
         org.osate.aadl2.UnitsType ut = (org.osate.aadl2.UnitsType) ne ;
         
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

	   PropertiesLinkingService pls = null ;
	   
	   // Now check the type in each current package's sections.
	   for(Namespace ns: _contextsTab)
	   {
	      pls = PropertiesLinkingService.getPropertiesLinkingService(ns) ;
	      
	      // If namespace is null than the element must be declared in the
	      // current package.
	      ne = pls.findNamedElementInAadlPackage(packageName,
	                                             qne.getBaName().getId(), ns);
	         
	      if(ne == null)
	      {
	        ne=pls.findNamedElementInPredeclaredPropertySets(qne.getBaName().getId(), ns, null);
	        if(ne==null)
	        {
	              PropertySet ps = pls.findPropertySet(ns, packageName);
	              if(ps!=null)
	                ne = ps.findNamedElement(qne.getBaName().getId());
	        }
	      }
	      // An element is found.
	      if(ne != null && ne instanceof NamedElement)
	      {
	        // Link unique component classifier reference with
	        // named element found.
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
   // within behavior property set value ones or property set constant ones.
   /* value_constant ::=
           boolean_literal
         | numeric_literal
         | string_literal
         | property_constant
         | property_value */
   private boolean valueConstantResolver(ValueConstant value)
   {
     if(value instanceof Enumeration)
     {
       return behaviorEnumLiteralResolver((Enumeration) value);
     }
     else if(value instanceof QualifiedNamedElement)
     {
       return qualifiedNamedElementResolver((QualifiedNamedElement) value,
                                             true);
     }
     else // Other literals : they don't contain any name.
     {
       return true ;
     }
   }

   private boolean behaviorEnumLiteralResolver(Enumeration enu)
   {
	   boolean result = qualifiedNamedElementResolver(enu, true) ;
	  
	   if(result)
	   {
		   Classifier c = (Classifier) enu.getOsateRef() ;
		  
		   Identifier propertyName = enu.getProperty() ;
		  
		   EList<PropertyExpression> pel = 
		     AadlBaGetProperties.getPropertyExpression(c, propertyName.getId());
		  
		   Identifier wrongId = null ;
		  
		   if(! pel.isEmpty())
		   {
			   ListValue lv = (ListValue) pel.get(0) ;
			   propertyName.setOsateRef(lv) ;
			  
			   StringLiteral sl ;
			   Identifier enumLiteral = enu.getLiteral();
			  
			   for(PropertyExpression pe : lv.getOwnedListElements())
			   {
				   sl = (StringLiteral) pe ;
				   if(sl.getValue().equalsIgnoreCase(enumLiteral.getId()))
				   {
					   enumLiteral.setOsateRef(sl) ;
					   enu.setOsateRef(sl) ;
					   return true ;
				   }
			   }
			  
			   // Matching has failed. Set report variables.
			   wrongId = enumLiteral ;
		   }
		   else // Property enumerators is not found.
		   {
			   wrongId= propertyName ;
		   }
		  
		   // At this point, resolution has failed. Reports error and returns
		   // false.
		   reportNameError(wrongId, wrongId.getId()) ;
		   result = false ;
	   }

	   return result ;
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
    // Ambiguous case.
    if(value instanceof NamedValue)
    {
      Reference ref = ((NamedValue) value).getReference() ;
      
      return refResolver(ref) ;
    }
    else if(value instanceof Reference)
    {
      // Ambiguous case : unqualified propertysets (constant or value) 
      // are parsed as reference without array index.
      
      Reference ref = (Reference) value ;
      
      EList<ArrayableIdentifier> ids = ref.getIds() ;
      
      // Unqualified propertysets only have one id.
      if(ids.size() > 1)
      {
        return valueVariableResolver(value, (ValueVariable) value) ;
      }
      else
      {
        ArrayableIdentifier id = ids.get(0) ;
        
        // Unqualified propertysets can't have array index.
        if(id.isSetArrayIndexes())
        {
          return valueVariableResolver(value, (ValueVariable) value) ;
        }
        else
        {
          // At the point, we will test if value can be resolved as an value 
          // variable or an unqualified propertyset (constant or value).
          
          QualifiedNamedElement qne =
                DeclarativeFactory.eINSTANCE.createQualifiedNamedElement() ;
          
          // Clone the identifier as class members of the MetaModel are set as
          // unique instance.
          Identifier idClone = DeclarativeFactory.eINSTANCE.createIdentifier();
          idClone.setLocationReference(id.getLocationReference()) ;
          idClone.setId(id.getId()) ;
          
          qne.setBaName(idClone) ;
          qne.setBaNamespace(null) ;
          qne.setLocationReference(id.getLocationReference()) ;

          if(qualifiedNamedElementResolver(qne, false))
          {
            Factor parentContainer = (Factor) value.eContainer() ;

            // Set the property constant object instead of the name object
            // into the parent container.
            if(parentContainer.getFirstValue().equals(value))
            {
              parentContainer.setFirstValue(qne) ;
            }
            else
            {
              parentContainer.setSecondValue(qne) ;
            }

            return true ;
          }
          else
          {
            return valueVariableResolver(ref, ref) ;
          }
        }
      }
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
   /* value_variable ::=
           incoming_port_name
         | incoming_port_name ?
         | subprogram_parameter_name
         | local_variable_name
         | data_component_reference
         | port_name ’ count
         | port_name ’ fresh */
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
   private void reportNameError(BehaviorElement obj, String name) 
   {
      _errManager.error(obj, "\'" + name + "\' is not found");
   }
}