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
import java.util.Iterator ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.Classifier;
import edu.cmu.sei.aadl.aadl2.ClassifierValue;
import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.Data ;
import edu.cmu.sei.aadl.aadl2.DataAccess ;
import edu.cmu.sei.aadl.aadl2.DataClassifier;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.Feature ;
import edu.cmu.sei.aadl.aadl2.ListValue;
import edu.cmu.sei.aadl.aadl2.Mode ;
import edu.cmu.sei.aadl.aadl2.NamedElement;
import edu.cmu.sei.aadl.aadl2.Namespace ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.Prototype ;
import edu.cmu.sei.aadl.aadl2.PrototypeBinding ;
import edu.cmu.sei.aadl.aadl2.StringLiteral;
import edu.cmu.sei.aadl.aadl2.Subcomponent ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import edu.cmu.sei.aadl.aadl2.PropertyExpression ;

import fr.tpt.aadl.annex.behavior.aadlba.*;

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
   public static final String TIME_UNITS_PROPERTY_SET = "Time_Units" ;
   
   // Iterative variables scope handler.
   private EList<Identifier> _itvScope = new BasicEList<Identifier>();
   
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
      Target t = act.getTargetOwned() ;
      
      result = targetResolver(t) ;
      
      if(! act.isAny())
      {
         result &= valueExpressionResolver(act.getValueExpressionOwned()) ;
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

      EList<BehaviorVariable> lvars = _ba.getBehaviorVariables() ;
      EList<BehaviorState> lstates = _ba.getBehaviorStates() ;
      EList<BehaviorTransition> ltrans = _ba.getBehaviorTransitions() ;
      
      Set<String> svars = new HashSet<String>() ;
      Set<String> sstates = new HashSet<String>() ;
      Set<String> strans = new HashSet<String>(ltrans.size()) ;

      for(BehaviorVariable v : lvars)
      {
         for(Declarator d : v.getLocalVariableDeclarators())
         {
            for(BehaviorState s : lstates)
            {
               for(Identifier ids : s.getIdentifiers())
               {
                  if(ids.getId().equalsIgnoreCase(d.getIdentifierOwned().getId()))
                  {
                     _errManager.error(ids, "conflict with " + d.getIdentifierOwned().getId()
                           + " at line " + d.getLocationReference().getLine()) ;
                     result = false ;
                  }
               }
            }
            for(BehaviorTransition t : ltrans)
            {
               Identifier idt = t.getTransitionIdentifier() ;
               if(idt != null && idt.getId().equalsIgnoreCase(d.getIdentifierOwned().getId()))
               {
                  _errManager.error(t, "conflict with " + d.getIdentifierOwned().getId()
                        + " at line " + d.getLocationReference().getLine()) ;
                  result = false ;
               }
            }
            if(!svars.add(d.getIdentifierOwned().getId()))
            {
               _errManager.error(d, "duplicate name for " + d.getIdentifierOwned().getId()) ;
               result = false ;
            }
         }
      }

      for(BehaviorState s : lstates)
      {
         for(Identifier ids : s.getIdentifiers())
         {
            for(BehaviorTransition t : ltrans)
            {
               Identifier idt = t.getTransitionIdentifier() ;
               if(idt != null && idt.getId().equalsIgnoreCase(ids.getId()))
               {
                  _errManager.error(t, "conflict with " + ids.getId()
                        + " at line " + ids.getLocationReference().getLine()) ;
                  result = false ;
               }
            }
            if(!sstates.add(ids.getId()))
            {
               _errManager.error(ids, "duplicate name for " + ids.getId()) ;
               result = false ;
            }
         }
      }

      for(BehaviorTransition t : ltrans)
      {
         Identifier idt = t.getTransitionIdentifier() ;
         if(idt != null && !(strans.add(idt.getId())))
         {
            _errManager.error(t, "duplicate name for " + idt.getId()) ;
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
         if(act instanceof CommunicationAction)
         {
            return communicationActionResolver((CommunicationAction)
                                                                  act) ;
         }
         else // Case of timed action.
         {
            return timedActionResolver((TimedAction) act) ;
         }
      }
   }

   private boolean transDestStateResolver(BehaviorTransition trans)
   {
      BehaviorState state = null ;
      Identifier id = trans.getDestinationStateIdentifier() ;
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
   
   private boolean transSrcStateResolver(BehaviorTransition trans)
   {
      boolean result = true ;
      BehaviorState state = null ;
      for(Identifier id : trans.getSourceStateIdentifiers())
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
        
        for(BehaviorTransition trans : _ba.getBehaviorTransitions())
        {
           result &= transSrcStateResolver(trans) ;
           result &= transDestStateResolver(trans) ;
           
           BehaviorCondition cond = trans.getBehaviorConditionOwned() ;
           
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
           
           BehaviorActionBlock block = trans.getBehaviorActionBlockOwned() ;
           
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
      boolean result = behaviorActionsResolver(block.getBehaviorActionsOwned());
      
      // Check timeout option.
      if(block.getBehaviorTimeOwned() != null)
      {
         result &= behaviorTimeResolver(block.getBehaviorTimeOwned()) ;
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
               IfStatement stat = (IfStatement) act ;
                
               for(ValueExpression expr : stat.getLogicalValueExpressions())
               {
                  result &= valueExpressionResolver(expr) ;
               }
               
               for(BehaviorActions acts : stat.getBehaviorActionsOwned())
               {
                  result &= behaviorActionsResolver(acts) ;
               }
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
                                                   .getBehaviorActionsOwned()) ;
               }
               else // Case of FOR and FOR ALL statement.
               {
                  
                  ForOrForAllStatement stat = (ForOrForAllStatement) act ;
                  
                  // Resolves unique component classifier reference.
                  UniqueComponentClassifierReference uccr = 
                               stat.getDataUniqueComponentClassifierReference();
                  
                  result = uniqueComponentClassifierRefResolver(uccr, true) ;
                  
                  // Set the for structure's element variable type as BA
                  // referenced entity.
                  Identifier itv = stat.getElementIdentifier() ;
                  
                  itv.setBaRef(uccr);
                  
                  result &= iterativeVariableUniquenessCheck(itv); 
                  
                  // Add the for/forall statment's iterative variable to 
                  // the scope handler.
                  _itvScope.add(itv);
                  
                  // Check element values.
                  result &= elementValuesResolver(
                                                 stat.getElementValuesOwned()) ;
                  
                  // Check behavior actions.
                  result &= behaviorActionsResolver(
                                               stat.getBehaviorActionsOwned()) ;
                  
                  // remove the for/forall statment's iterative variable from
                  // the scope handler.
                  _itvScope.remove(itv);
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
   * Keys : element variable identifier for control construct
   */ 
   private boolean iterativeVariableUniquenessCheck(Identifier itv)
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
   
   private boolean iterativeVariableUniquenessWithinScopeHandler(Identifier itv)
   {
      Identifier sameId = AadlBaUtils.compareIdentifiersList(itv, _itvScope) ;
      if( sameId == null)
      {
        return true ;
      }
      else
      {
         // Report error.
         _errManager.error(itv, "Duplicate local variable " + itv.getId());
         return false ;
      }
   }
   
   // Just the opposite of checkFeatureName.
   private boolean featureNameUniquenessCheck(Identifier id)
   {
      String nameToFind = id.getId(); 
      
      Feature f = AadlBaVisitors.findFeatureInComponent(_baParentContainer,
                                                        nameToFind) ;
      if (f == null)
      {
         return true ;
      }
      else
      {
         // Report error.
         _errManager.error(id, "Duplicate local variable " + id.getId());
         
         return false ;
      }
   }
   
   private boolean iterativeVariableResolver(Identifier itv, boolean hasToReport)
   {
      Identifier sameId = AadlBaUtils.compareIdentifiersList(itv, _itvScope) ;
      if( sameId != null)
      {
        // Resolve the iterative variable with its declaration.
        itv.setBaRef(sameId.getBaRef()) ;
        
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
   
   private boolean behaviorVariableNameUniquenessCheck(Identifier id)
   {
      String variableName = id.getId() ;
      
      BehaviorVariable v = AadlBaVisitors.findBehaviorVariable(_ba,
                                                               variableName) ;
      
      if(v == null)
      {
         return true ;
      }
      else
      {
         // Report error.
         _errManager.error(id, "Duplicate local variable " + id.getId());
         
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
         for(BehaviorAction act : ((BehaviorActionCollection)acts).getBehaviorActions())
         {
            result &= behaviorActionResolver(act) ;
         }
      }

      return result ;
   }

   private boolean behaviorTimeResolver(BehaviorTime bt)
   {
      return integerValueResolver(bt.getIntegerValueOwned()) &
             timeUnitResolver(bt.getUnitIdentifier());
   }

   // Resolves the given subprogram call action's names.
   // n2 can be null. n1 can't be null.
   // this resolver is not designed for n1 and n2 representing a unique
   // component reference with a provided implementation information. 
   private boolean subprogramCallNamesResolver(Name n1, Name n2)
   {
      boolean result = nameResolver(n1) ;
      
      // Resolves second name.
      if(result && n2 != null)
      {
         ComponentClassifier parentComponent = null ;
         
         Element nameId = n1.getIdentifierOwned().getAadlRef() ;
         // the first name should represent a required data access.
         if(nameId instanceof DataAccess)
         {
            // May be null.
            parentComponent = ((DataAccess) nameId).getDataClassifier() ;
         }
         else // Reports error then returns.
         {
            reportNameError(n1.getIdentifierOwned(),
                            n1.getIdentifierOwned().getId() +
                            " (as a data access)") ;
            return false ;
         }
         
         result = nameResolver(parentComponent, n2) ;
      }
      
      return result ;
   }
   
   
   private boolean communicationActionResolver(CommunicationAction act)
   {
      if(act instanceof SharedDataAction)
      {
         SharedDataAction sda = (SharedDataAction) act ;
         
         // Cases of name !< or name !>
         if(sda.getDataAccessName() != null)
         {
            return nameResolver(sda.getDataAccessName()) ;
         }
         else // Cases of * !< or * !> 
         {
            return true ;
         }
      }
      
      if(act instanceof PortFreezeAction)
      {
         return nameResolver((PortFreezeAction)act) ;
      }
      
      if(act instanceof PortDequeueAction)
      {
         PortDequeueAction pda = (PortDequeueAction) act ;
         boolean result = nameResolver(pda.getPortName()) ;
         
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
	   
	   result = nameResolver(currentName) ;
	   
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
   
   /* dispatch_condition ::=
        on dispatch [ dispatch_trigger_condition ] [ frozen frozen_ports ] */
   private boolean dispatchConditionResolver(DispatchCondition cond)
   {
      boolean result = true ;
      
      DispatchTriggerCondition dtc = cond.getDispatchTriggerConditionOwned() ;
      
      // Dtc can be null as a void dispatch trigger condition means always true. 
      if(dtc != null)
      {
         result = dispatchTriggerConditionResolver(dtc) ;
      }
    
      if (cond.isSetFrozenPorts())
      {
        for(Identifier id : cond.getFrozenPorts())
        {
           result &= featureResolver(_baParentContainer, id, true) ;
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
      
      if (dtc instanceof DispatchTriggerLogicalExpression)
      {
         result = dispatchTriggerLogicalExpressionResolver
                    ((DispatchTriggerLogicalExpression) dtc);
      }
      else
      {
         if (dtc instanceof CompletionRelativeTimeoutConditionAndCatch)
         {
            result = behaviorTimeResolver((BehaviorTime)dtc);
         }
         else // Cases of TimeoutCatch and DispatchTriggerConditionStop
              // : no name to check for.
         {
            result = true ;
         }
      }
      
      return result ;
   }
 

   private boolean dispatchTriggerLogicalExpressionResolver
                                         (DispatchTriggerLogicalExpression dtle)
   {
      boolean result = true ;
      
      for(DispatchConjunction dc : dtle.getDispatchConjunctions())
      {
         for(Identifier trigg : dc.getDispatchTriggers())
         {
            result &= identifierComponentResolver(trigg, _baParentContainer,
            		                              true) ;
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
         // Case of event data port name.
         if(values instanceof Name)
         {
            return nameResolver((Name) values) ;
         }
         else // Case of data component reference.
         {
            return dataComponentRefResolver((DataComponentReference) values) ;
         }
      }
   }

   private boolean featureResolver(ComponentClassifier parentContainer,
                                   Identifier id, boolean hasToReport)
   {
      String nameToFind = id.getId(); 
      
      Feature f = AadlBaVisitors.findFeatureInComponent(parentContainer,
                                                        nameToFind) ;

      if (f != null)
      {
         id.setAadlRef(f);
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
		    								   ComponentClassifier component,
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
			  
			  id.setAadlRef(cv) ;
		  }
	  }
	  
	  if(! result && hasToReport)
	  {
		  reportNameError(id, id.getId()) ;
	  }
	  
	  return result ;
   }

   private boolean featurePrototypeResolver(Identifier id,
		                             ComponentClassifier component,
		                             boolean hasToReport)
   {
      String nameToFind = id.getId() ;

      PrototypeBinding pb = AadlBaVisitors.findPrototypeBindingInComponent
            (component, nameToFind);
      
      // first: try to find any prototype binding that matches the given
      // identifier.
      if(pb != null)
      {
         id.setAadlRef(pb);
         return true ;
      }
      else // If there isn't any matching prototype binding, try to find
           // a matching prototype declaration. 
      {
         Prototype proto = AadlBaVisitors.findPrototypeInComponent
                                               (component, nameToFind);
         if (proto != null)
         {
            id.setAadlRef(proto);
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
      if(value instanceof Name)
      {
         Name n = (Name) value ;
         if(n.isSetArrayIndexes())
         {
            return integerValueVariableResolver((IntegerValueVariable)value);
         }
         else // Ambiguous case : unqualified behavior propertysets 
              // (constant or value) are parsed as name without array index.
            
         {
            BehaviorPropertyConstant pc = AadlBaFactory.eINSTANCE
                                              .createBehaviorPropertyConstant();
            pc.setName(n.getIdentifierOwned()) ;
            pc.setQualifiedName(pc.getName());
            
            if(propertyConstantResolver(pc, false))
            {
               pc.setLocationReference(n.getLocationReference());
               
               BehaviorElement parentContainer = (BehaviorElement) 
                                                            value.eContainer() ;
               
               // Set the behavior property constant object instead of the name
               // object into the parent container.
               if(parentContainer instanceof BehaviorTime)
               {
                  ((BehaviorTime) parentContainer).setIntegerValueOwned(pc) ;
               }
               else
               {
                  if (parentContainer instanceof IntegerRange)
                  {
                     IntegerRange ir = (IntegerRange) parentContainer ;
                     
                     if(ir.getLowerIntegerValue().equals(value))
                     {
                        ir.setLowerIntegerValue(pc) ;
                     }
                     else
                     {
                        ir.setUpperIntegerValue(pc);
                     }
                  }
                  else // Only for [DEBUG] purpose.
                  {
                     System.err.println("Can't set the resolved " +
                     		                                "property constant");
                  }
               }
               
               return true ;
            }
            else
            {
               return integerValueVariableResolver(n);
            }
         }
      }
      else
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
   private boolean nameResolver(Name nameObj)
   {
      return nameResolver(_baParentContainer, nameObj) ;
   }
   
   // Resolves Name Object (identifier and array index)
   // within parent component's features ones and ba's variables ones and
   // for structure element variables scope handler.
   // name ::= identifier { array_index }*
   // array_index :: [ integer_value_variable ]
   private boolean nameResolver(ComponentClassifier parentContainer,
                                Name nameObj)
   {
      boolean result = false ;
      
      // Check Identifier name.
      Identifier id = nameObj.getIdentifierOwned() ;
      
      if(parentContainer == _baParentContainer)
      {
    	  result = identifierBaResolver(id, false) ;
      }
      
      if (! result)
      {
    	  result = identifierComponentResolver(id, parentContainer, true) ;
      }
      
      nameObj.setAadlRef(id.getAadlRef());
      nameObj.setBaRef(id.getBaRef());
      
      // Check array indexes names.
      for (IntegerValue index : nameObj.getArrayIndexes())
      {
         // Recursive call.
         result &= integerValueResolver(index);
      }
      return result ;
   }

   /**
    * Check behavior annex's sub component uniqueness within behavior annex's
    * parent component scope. Conflicts are reported.
    */
   private boolean parentComponentIdentifiersUniquenessCheck()
   {
      boolean result = true ;
      
      EList<edu.cmu.sei.aadl.aadl2.NamedElement> lcc = 
                        new BasicEList<edu.cmu.sei.aadl.aadl2.NamedElement>(0) ;

      // Merge parent component' subcomponents lists.
      lcc.addAll(AadlBaVisitors.getElementsInNamespace(_baParentContainer,
                                                       Data.class)) ;
      lcc.addAll(AadlBaVisitors.getElementsInNamespace(_baParentContainer,
                                                       Mode.class)) ;
      lcc.addAll(AadlBaVisitors.getElementsInNamespace(_baParentContainer,
                                                       Feature.class)) ;

      EList<BehaviorVariable> lvars = _ba.getBehaviorVariables() ;
      EList<BehaviorState> lstates = _ba.getBehaviorStates() ;
      EList<BehaviorTransition> ltrans = _ba.getBehaviorTransitions() ;

      // Check uniqueness within the parent component.
      for(edu.cmu.sei.aadl.aadl2.NamedElement ne : lcc)
      {
         for(BehaviorVariable v : lvars)
         {
            for(Declarator d : v.getLocalVariableDeclarators())
            {
               if(d.getIdentifierOwned().getId().equalsIgnoreCase(ne.getName()))
               {
                  _errManager.error(d, "conflict with " + ne.getName()
                        + " at line " + ne.getLocationReference().getLine()) ;
                  result = false ;
               }
            }
         }

         for(BehaviorState s : lstates)
         {
            for(Identifier ids : s.getIdentifiers())
            {
               if(ids.getId().equalsIgnoreCase(ne.getName()))
               {
                  // Complete states that represent modes are exceptions of 
                  // D.3.(N1) naming rule.
                  // Links the identifier with the mode.
                  if(ne instanceof Mode)
                  {
                     if(s.isComplete())
                     {
                        ids.setAadlRef(ne) ;
                     }
                     else
                     {
                        _errManager.error(ids, "Behavior state " + ids.getId() + 
                           " must be declared complete in order to represent " + 
                           "mode " + ne.getName() + " located at line " + 
                           ne.getLocationReference().getLine());
                        result = false ;
                     }
                  }
                  else
                  {
                     _errManager.error(ids, "conflict with " + ne.getName()
                           + " at line " + ne.getLocationReference().getLine());
                     result = false ;
                  }
               }
            }
         }

         for(BehaviorTransition t : ltrans)
         {
            Identifier idt = t.getTransitionIdentifier() ;
            if(idt != null && idt.getId().equalsIgnoreCase(ne.getName()))
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
		                                  ComponentClassifier parentComponent,
		                                  boolean hasToReport)
   {
      String nameToFind = id.getId() ;
      
      Subcomponent subc = AadlBaVisitors.findSubcomponentInComponent
                                               (parentComponent, nameToFind);

      if (subc != null)
      {
         id.setAadlRef(subc);
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
      if(tar instanceof Name)
      {
         return nameResolver((Name) tar) ;
      }
      else
      {
         return dataComponentRefResolver((DataComponentReference) tar) ;
      }
   }
   
   private boolean timedActionResolver(TimedAction act)
   {
      boolean result = behaviorTimeResolver(act.getLowerBehaviorTime()) ;

      if(act.getUpperBehaviorTime() != null)
      {
         result &= behaviorTimeResolver(act.getUpperBehaviorTime());
      }
      
      return result ;
   }
   
   // Checks behavior time's time unit according to property set Time_Units and 
   // binds if checking is successful.
   private boolean timeUnitResolver(Identifier unitIdentifier)
   {
      PackageSection context = AadlBaVisitors.getContainingPackageSection(_ba);
      
      edu.cmu.sei.aadl.aadl2.NamedElement ne = 
         AadlBaVisitors.findNamedElementInPropertySet(
                                        null, TIME_UNITS_PROPERTY_SET, context);
      
      // Property set Time_Units is found.
      if (ne instanceof edu.cmu.sei.aadl.aadl2.UnitsType)
      {
         edu.cmu.sei.aadl.aadl2.UnitsType ut = 
                                         (edu.cmu.sei.aadl.aadl2.UnitsType) ne ;
         
         // Find the given time unit in the enumeration.
         edu.cmu.sei.aadl.aadl2.UnitLiteral ul = ut.findLiteral(
                                                       unitIdentifier.getId()) ;
         
         // The given time unit is found.
         if(ul != null)
         {
            unitIdentifier.setAadlRef(ul) ;
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

   private boolean behaviorNamedElement(BehaviorNamedElement bne,
		                                boolean hasToReport)
   {
	   String packageName = null ;
	   NamedElement ne ;
	   boolean hasNamespace = bne.getNamespace() != null ; 
	      
	   if(hasNamespace)
	   {
	      packageName = bne.getNamespace().getId() ;
	   }

	   // Now check the type in each current package's sections.
	   for(Namespace ns: _contextsTab)
	   {
	      // If namespace is null than the element must be declared in the
	      // current package.
	      ne = AadlBaVisitors.findNamedElementInAadlPackage(packageName,
	    		                                    bne.getName().getId(), ns) ;
	         
	      // An element is found.
	      if(ne != null)
	      {
	           // Link unique component classifier reference with
	           // named element found.
	    	  bne.setAadlRef(ne) ;
	    	  bne.getName().setAadlRef(ne);
	    	  bne.getQualifiedName().setAadlRef(ne) ;
	          if(hasNamespace)
	          {
	        	 bne.getNamespace().setAadlRef(ne.getNamespace()) ;
	          }
	                              
	          return true ;
	      }
	   }
	      
	   // The element is not found.
	   if(hasToReport)
	   {
	      reportNameError(bne, bne.getQualifiedName().getId()) ;
	   }
	      
	   return false ;
   }
   
   
   private boolean uniqueComponentClassifierRefResolver(
                                         UniqueComponentClassifierReference ucr,
                                         boolean hasToReport)
   {
      return behaviorNamedElement(ucr, hasToReport) ;
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
      if(value instanceof BehaviorPropertyConstant)
      {
         return propertyConstantResolver((BehaviorPropertyConstant) value, true);
      }
      if(value instanceof BehaviorEnumerationLiteral)
      {
    	  return behaviorEnumLiteralResolver((BehaviorEnumerationLiteral)value);
      }
      else // Other literals : they don't contain any name.
      {
         return true ;
      }
   }

   private boolean behaviorEnumLiteralResolver(BehaviorEnumerationLiteral bel)
   {
	  boolean result = behaviorNamedElement(bel, true) ;
	  
	  if(result)
	  {
		  Classifier c = (Classifier) bel.getAadlRef() ;
		  
		  Identifier propertyName = bel.getPropertyIdentifier() ; 
		  
		  EList<PropertyExpression> pel = 
		     AadlBaGetProperties.getPropertyExpression(c, propertyName.getId());
		  
		  Identifier wrongId = null ;
		  
		  if(! pel.isEmpty())
		  {
			  ListValue lv = (ListValue) pel.get(0) ;
			  propertyName.setAadlRef(lv) ;
			  
			  StringLiteral sl ;
			  Identifier enumLiteral = bel.getElementListIdentifier();
			  
			  for(PropertyExpression pe : lv.getOwnedListElements())
			  {
				  sl = (StringLiteral) pe ;
				  if(sl.getValue().equalsIgnoreCase(enumLiteral.getId()))
				  {
					  enumLiteral.setAadlRef(sl) ;
					  bel.setAadlRef(sl) ;
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

   /*
    * Checks names in a behavior property constant and report any error.
    */
   private boolean propertyConstantResolver(BehaviorPropertyConstant pc,
                                            boolean hasToReport)
   {
	  NamedElement ne ;
	  String propertySetNamespace = null ;
      
	  PackageSection[] contextsTab =AadlBaVisitors.getBaPackageSections(_ba);
	  
	  boolean hasNamespace = pc.getNamespace() != null ;
      if (hasNamespace)
      {
    	  propertySetNamespace = pc.getNamespace().getId() ;
      }
      else 
      {
    	  // If qualified name is null than the property must be declared in the
          // current package.
    	  propertySetNamespace = contextsTab[0].getName() ;
      }

      // Now check the type in each current package's sections.
      for(Namespace ns: contextsTab)
      {
         ne = AadlBaVisitors.findNamedElementInPropertySet(propertySetNamespace,
                                                      pc.getName().getId(), ns);
         // An element is found.
         if(ne != null)
         {
            pc.setAadlRef(ne) ;
            pc.getName().setAadlRef(ne);
            pc.getQualifiedName().setAadlRef(ne) ;
            
            if(hasNamespace)
            {
            	pc.getNamespace().setAadlRef(ne.getNamespace()) ;
            }
            
            return true ;
         }
      }
      // The element is not found.
      if(hasToReport) 
      {
         reportNameError(pc, pc.getQualifiedName().getId()) ;
      }
      return false ; 
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
         se = r.getSimpleExpressionOwned() ;
         
         // Treats simple expression(s).
         do
         {
            // Iterates over Terms.
            for(Term t : se.getTerms())
            {
               // Iterate over Factors.
               for (Factor f : t.getFactors())
               {
                  v = f.getValueOwned() ;
                  
                  // Treats value(s).
                  do
                  {
                    result &= valueResolver(v) ; 
                    v = f.getValueSdOwned() ;
                    vNb++ ;
                  } while (v != null && vNb != 2) ;
                  
                  vNb = 0 ;
               }// End of for factors.
            }// End of for terms.
            
            se = r.getSimpleExpressionSdOwned() ;
            seNb++ ;
         } while(se != null && seNb != 2) ;

         seNb = 0 ;
      }// End of for relations.
      
      return result ;
   }

   private boolean valueResolver(Value value)
   {
      // Ambiguous case.
      if(value instanceof Name)
      {
         Name n = (Name) value ;
         if(n.isSetArrayIndexes())
         {
            return valueVariableResolver(value, (ValueVariable)value) ;
         }
         else // Ambiguous case : unqualified propertysets (constant or value) 
              // are parsed as name without array index.
            
         {
            BehaviorPropertyConstant pc = AadlBaFactory.eINSTANCE
                                              .createBehaviorPropertyConstant();
            pc.setName(n.getIdentifierOwned()) ;
            pc.setQualifiedName(pc.getName());
            
            if(propertyConstantResolver(pc, false))
            {
               pc.setLocationReference(n.getLocationReference());
               
               Factor parentContainer = (Factor) value.eContainer() ;
               
               // Set the property constant object instead of the name object
               // into the parent container.
               if(parentContainer.getValueOwned().equals(value))
               {
                  parentContainer.setValueOwned(pc) ;
               }
               else
               {
                  parentContainer.setValueSdOwned(pc) ;
               }
               
               return true ;
            }
            else
            {
               return valueVariableResolver(n, n) ;
            }
         }
      }
      else
      {
      // Case of a value variable.
         if(value instanceof ValueVariable)
         {
            return valueVariableResolver(value, (ValueVariable)value) ;
         }
         else
         {
            // Case of a value constant.
            if(value instanceof ValueConstant)
            {
               return valueConstantResolver((ValueConstant)value) ; 
            }
            else // Case of value expression : recursive call.
            {
               return valueExpressionResolver((ValueExpression) value) ;
            }
         }
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
      if(value instanceof Name)
      {
         return nameResolver((Name)value) ;
      }
      else
      {
         return dataComponentRefResolver((DataComponentReference) value);
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
      UniqueComponentClassifierReference uccr ;
      
      // For each behavior variable, check if declared unique component 
      // classifier reference exists.
      for(BehaviorVariable v : _ba.getBehaviorVariables())
      {
         uccr = v.getDataUniqueComponentClassifierReference() ;

         result &= uniqueComponentClassifierRefResolver(uccr, true) ;
         
         for(Declarator d : v.getLocalVariableDeclarators())
         {
            result &= declaratorResolver(d) ;
         }
      }
      return result ;
   }
   
   private boolean declaratorResolver(Declarator d)
   {
      boolean result = true ;
      // Resolves only array size.
      for(IntegerValueConstant ivc : d.getArraySizes())
      {
         result &= integerValueConstantResolver(ivc) ;
      }
      
      return result ;
   }

   // TODO Provide column number.
   private void reportNameError(BehaviorElement obj, String name) 
   {
      _errManager.error(obj, "\'" + name + "\' is not found");
   }
}