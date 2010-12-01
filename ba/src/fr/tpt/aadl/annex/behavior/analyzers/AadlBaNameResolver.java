package fr.tpt.aadl.annex.behavior.analyzers;

import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.Data ;
import edu.cmu.sei.aadl.aadl2.DataAccess ;
import edu.cmu.sei.aadl.aadl2.DataSubcomponent ;
import edu.cmu.sei.aadl.aadl2.Feature ;
import edu.cmu.sei.aadl.aadl2.Mode ;
import edu.cmu.sei.aadl.aadl2.Namespace ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.Prototype;
import edu.cmu.sei.aadl.aadl2.Subcomponent ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.AadlBaFactory ;
import fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex ;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter ;
import fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction ;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.DoUntilStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.Factor ;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Name ;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel ;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue ;
import fr.tpt.aadl.annex.behavior.aadlba.Relation ;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList ;
import fr.tpt.aadl.annex.behavior.aadlba.Target ;
import fr.tpt.aadl.annex.behavior.aadlba.Term ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Value ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.WhileStatement ;

// TODO : optimize name resolution between feature, subcomponent names 
//        see checkNameObj method. 
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
   
   // Contains Element variable identifiers of for and forall structures.
   private EList<Identifier> _lForElementIds = new BasicEList<Identifier>();
   
   // Time units property set name.
   public static final String TIME_UNITS_PROPERTY_SET = "Time_Units" ; 
   
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

   private boolean checkAssignmentActionNames(AssignmentAction act)
   {
      boolean result = false ;
      Target t = act.getTargetOwned() ;
      
      result = checkTargetNames(t) ;
      
      if(! act.isAny())
      {
         result &= checkValueExpressionNames(act.getValueExpressionOwned()) ;
      }
      
      return result ;
   }

   /**
    * Check the behavior annex's rule X.3.(N1) <BR><BR>
    * Conflicts and duplicate names are reported in the given error report
    * manager.
    * 
    * @return {@code true} if behavior annex's rule is satisfied. {@code false}
    * otherwise. 
    */
   private boolean checkBaComponentsUniqueness()
   {
      boolean result = true ;
      
      // Separated check in order to improve visibility and performance.
      result = checkParentComponentIdentifiersUniqueness() ;

      EList<BehaviorVariable> lvars = _ba.getVariables() ;
      EList<BehaviorState> lstates = _ba.getStates() ;
      EList<BehaviorTransition> ltrans = _ba.getTransitions() ;
      
      Set<String> svars = new HashSet<String>() ;
      Set<String> sstates = new HashSet<String>() ;
      Set<String> strans = new HashSet<String>(ltrans.size()) ;

      for(BehaviorVariable v : lvars)
      {
         for(Declarator d : v.getLocalVariableDeclarators())
         {
            for(BehaviorState s : lstates)
            {
               for(Identifier ids : s.getBehaviorStateIdentifiers())
               {
                  if(ids.getId().equalsIgnoreCase(d.getName()))
                  {
                     _errManager.error(ids, "conflict with " + d.getName()
                           + " at line " + d.getLocationReference().getLine()) ;
                     result = false ;
                  }
               }
            }
            for(BehaviorTransition t : ltrans)
            {
               Identifier idt = t.getTransitionIdentifier() ;
               if(idt != null && idt.getId().equalsIgnoreCase(d.getName()))
               {
                  _errManager.error(t, "conflict with " + d.getName()
                        + " at line " + d.getLocationReference().getLine()) ;
                  result = false ;
               }
            }
            if(!svars.add(d.getName()))
            {
               _errManager.error(d, "duplicate name for " + d.getName()) ;
               result = false ;
            }
         }
      }

      for(BehaviorState s : lstates)
      {
         for(Identifier ids : s.getBehaviorStateIdentifiers())
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
      
      List<String> lforElementVariables = new ArrayList<String>();
      BehaviorActions beActions = null ;
      
      // Check for/forall element variable uniqueness.
      for(BehaviorTransition t : ltrans)
      {
         beActions = t.getBehaviorActionsOwned() ;
         
         result &= checkForForAllElementVariableUniqueness(beActions,
                                                        lforElementVariables) ;
      }
      
      return result ;
   }

   private boolean checkBasicActionNames(BasicAction act)
   {
      // Case of assignment action.
      if(act instanceof AssignmentAction)
      {
         return checkAssignmentActionNames((AssignmentAction) act) ;
      }
      else // Case of communication action.
      {
         if(act instanceof CommunicationAction)
         {
            return checkCommunicationActionNames((CommunicationAction)
                                                                  act) ;
         }
         else // Case of timed action.
         {
            return checkTimedActionNames((TimedAction) act) ;
         }
      }
   }

   private boolean checkBaTransDestStateName(BehaviorTransition trans)
   {
      BehaviorState state = null ;
      Identifier id = trans.getDestinationStateIdentifier() ;
      state = AadlBaVisitors.findBehaviorState(_ba, id.getId()) ;
      if(state != null)
      {
         id.setBaReferencedEntity(state);
         return true ;
      }
      else
      {
         reportNameError(id, id.getId()) ;
         return false ;
      }
   }
   
   private boolean checkBaTransSrcStateNames(BehaviorTransition trans)
   {
      boolean result = true ;
      BehaviorState state = null ;
      for(Identifier id : trans.getSourceStateIdentifiers())
      {
         state = AadlBaVisitors.findBehaviorState(_ba, id.getId()) ;
         if(state != null)
         {
            id.setBaReferencedEntity(state) ;
         }
         else
         {
            reportNameError(id, id.getId()) ;
            result = false ;
         }
      }
      return result ;
   }
   
// behavior_transition ::=
// [ transition_identifier [ [ behavior_transition_priority ] ] : ]
// source_state_identifier { , source_state_identifier }* 
//  -[ behavior_condition ]->
// destination_state_identifier [ { behavior_actions } [timeout behavior_time]];

//behavior_transition_priority ::= numeral
   /**
    * Resolves the names in behavior annex's transitions. 
    * 
    * @return {@code true} if all names are resolved. {@code false} otherwise. 
    */
   private boolean checkBaTransitionNames()
   {
        boolean result = true ;
        
        for(BehaviorTransition trans : _ba.getTransitions())
        {
           result &= checkBaTransSrcStateNames(trans) ;
           result &= checkBaTransDestStateName(trans) ;
           
           BehaviorCondition cond = trans.getBehaviorConditionOwned() ;
           
           // According to X.3.(N2) Naming rule : behavior condition can be null
           // as a void condition means always true.
           if(cond != null)
           {
              // Case of a dispatch condition
              if( cond instanceof DispatchCondition)
              {
                 result &= checkDispatchConditionNames((DispatchCondition)cond);
              }
              else // Case of a execute condition
              {
                 ExecuteCondition exeCond = (ExecuteCondition) cond ;
                 
                 if(! exeCond.isCatchTimeout())
                 {
                   result &= checkValueExpressionNames(
                                                 exeCond.getValueExpression()) ;
                 }
              }
           }
           
           BehaviorActions acts = trans.getBehaviorActionsOwned() ;
           
           // Behavior actions of an behavior transition may not exist.            
           if(acts != null)
           {
              result &= checkBehaviorActionsNames(acts) ;
           }
           
           // Check timeout option.
           if(trans.getTimeout() != null)
           {
              result &= checkBehaviorTimeNames(trans.getTimeout()) ;
           }
           
        }
        return result ;
   }

   private boolean checkBaVariableName(Identifier id, boolean hasToReport)
   {
      String variableName = id.getId() ;
      
      BehaviorVariable v = AadlBaVisitors.findBehaviorVariable(_ba,
                                                               variableName) ;
      
      if(v != null)
      {
         id.setBaReferencedEntity(v) ;
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
   
   private boolean checkBaVariableNameUniqueness(Identifier id)
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

   private boolean checkBehaviorActionNames(BehaviorAction act)
   {
      boolean result = true ;
      
      // Case of basic action.
      if(act.isBasicAction())
      {
         result = checkBasicActionNames(act.getBasicActionOwned()) ;
      }
      else
      {
         CondStatement cond = act.getCondStatementOwned() ;
         
         // Case of IF statement.
         if(cond instanceof IfStatement)
         {
            IfStatement stat = (IfStatement) cond ;
             
            for(ValueExpression expr : stat.getValueExpressionOwned())
            {
               result &= checkValueExpressionNames(expr) ;
            }
            
            for(BehaviorActions acts : stat.getBehaviorActionsOwned())
            {
               result &= checkBehaviorActionsNames(acts) ;
            }
         }
         else
         {
            // Case if WHILE and DO UNTIL statement.
            if(cond instanceof WhileStatement || cond instanceof 
                                                               DoUntilStatement)
            {
               ValueExpression expr ;
               BehaviorActions acts ;
               
               if(cond instanceof WhileStatement)
               {
                  expr = ((WhileStatement) cond).getValueExpressionOwned() ;
                  acts = ((WhileStatement) cond).getBehaviorActionsOwned() ;
               }
               else
               {
                  expr =  ((DoUntilStatement) cond).getValueExpressionOwned() ;
                  acts = ((DoUntilStatement) cond).getBehaviorActionsOwned() ;
               }
               
               result = checkValueExpressionNames(expr) ;
               result &= checkBehaviorActionsNames(acts) ;
            }
            else
            {
               // According to X.6.(N5) no need to check local variable name.
               // Case of FOR and FOR ALL statement.
               if(cond instanceof ForOrForAllStatement)
               {
                  ForOrForAllStatement stat = (ForOrForAllStatement) cond ;
                  
                  // Add the for structure's element variable in the scope
                  // handler.
                  _lForElementIds.add(stat.getElement()) ;
                  
                  // Check unique component classifier reference. It may be null.
                  UniqueComponentClassifierReference uccr = 
                                               stat.getDataUniqueCmtClassRef() ;
                  
                  if(uccr != null)
                  {
                     result = checkUniqueComponentClassifierRefNames(uccr, true) ;
                     
                     // Set the for structure's element variable type as BA
                     // referenced entity.
                     stat.getElement().setBaReferencedEntity(uccr);
                  }
                  
                  // Check element values.
                  result &= checkElementValuesNames(
                                                 stat.getElementValuesOwned()) ;
                  
                  // Check behavior actions.
                  result &= checkBehaviorActionsNames(
                                               stat.getBehaviorActionsOwned()) ;
                  
                  // Remove the for structure's element variable off the scope
                  // handler.
                  _lForElementIds.remove(stat.getElement()) ;
               }
            }
         }
      }
      
      return result ;
   }

   private boolean checkBehaviorActionsNames(BehaviorActions acts)
   {
      boolean result = true ;
      
      for(BehaviorAction act : acts.getBehaviorAction())
      {
         // The behavior action is a behavior actions.
         if ( act.getBehaviorActionsOwned() != null)
         {
            // Recursive call.
            result &= checkBehaviorActionsNames(act.getBehaviorActionsOwned()) ;
            
            if(act.getTimeout() != null)
            {
               result &= checkBehaviorTimeNames(act.getTimeout()) ;
            }
         }
         else // Case of behavior action.
         {
            result &= checkBehaviorActionNames(act) ;
         }
      }
      
      return result ;
   }

   private boolean checkBehaviorTimeNames(BehaviorTime bt)
   {
      return checkIntegerValueNames(bt.getIntegerValueOwned()) &
             checkTimeUnit(bt.getUnitIdentifier());
   }

   private boolean checkCommunicationActionNames(CommunicationAction act)
   {
      boolean result = false ;
      
      // Case of * !< or * !> or catch (timeout)
      if(act.isAll() || act.isCatchTimeout())
      {
         result = true ; // No name to be checked.
      }
      else
      {
      // Case of unique component classifier reference.
         if(act.isSetDataUniqueComponentClassifierReference())
         {
            result = checkUniqueComponentClassifierRefNames(
                                act.getDataUniqueComponentClassifierReference(),
                                 true) ;
         }
         else // Test the element name owned.
         {
            if( act.getActionType() == CommActionParameter.EXCLAMATION &&
                (! act.getEltNameOwned().isSetArrayIndexListOwned() )
              )
                
            {
               UniqueComponentClassifierReference uccr =AadlBaFactory.eINSTANCE.
                                     createUniqueComponentClassifierReference();
               
               uccr.setName(act.getEltNameOwned().getIdentifier().getId()) ;
               
               result = checkUniqueComponentClassifierRefNames(uccr, false) ;
               
               if(result)
               {
                  act.setDataUniqueComponentClassifierReference(uccr);
                  act.setEltNameOwned(null) ;
               }
               else
               {
                  result = checkNameObject(act.getEltNameOwned()) ;
               }
            }
            else
            {
               result = checkNameObject(act.getEltNameOwned()) ;
            }
         }
         
         // Case of "input port name  ? (target)"
         if(act.isHasTarget())
         {
            result &= checkTargetNames(act.getTarOwned()) ;
         }
         else
         {
            // Case of "output port name ! (value expression)"
            if (act.isHasValueExpression())
            {
               result &= checkValueExpressionNames(act.getValueExprOwned()) ;
            }
            else
            {  // Case of "ucr or name ! (subprogram parameter list)"
               if (act.isSetSubpgmParamListOwned()) 
               {
                  result &= checkSubprogramParameterListNames(
                                                act.getSubpgmParamListOwned()) ;
               }
               // Else : nothing to do. 
            }
         }
      }// End of first if.
      
      return result ;
   }

   private boolean checkDataComponentRefNames(DataComponentReference dcr)
   {
      boolean result ;
      
      Iterator<Name> it = dcr.getElementsNameOwned().iterator() ;
      
      Name componentName = it.next() ;
      
      // Check the dcr's first name which can be a subcomponent name or an 
      // access feature name. 
      
      result = checkNameObject(componentName) ;
      
      // Then set parentComponent for the next dcr's name.
      if(result && it.hasNext())
      {
         ComponentClassifier parentComponent = null ;
         
         edu.cmu.sei.aadl.aadl2.Element nameId = componentName.getIdentifier()
                                                    .getAadlReferencedEntity() ;
         // the dcr's first name represents a data access feature.
         if(nameId instanceof DataAccess)
         {
            // May be null.
            parentComponent = ((DataAccess) nameId).getDataClassifier() ;
         }
         else
         {
            // or the dcr's first name represents a data subcomponent.
            if (nameId instanceof DataSubcomponent)
            {
               // May be null.
               parentComponent = ((DataSubcomponent) nameId).getClassifier() ; 
            }
            else
            {
               // report error then return
               reportNameError(componentName.getIdentifier(),
                     componentName.getIdentifier().getId() +
                           " (as a data access feature or data subcomponent)") ;
               return false ;
            }
         }
         
         // For the other dcr's names :
         while(it.hasNext())
         {
            componentName = it.next() ;
            
            // Check the name within his parent component's namespace.
            result = checkNameObject(parentComponent, componentName) ;
            
            nameId = componentName.getIdentifier().getAadlReferencedEntity() ;
            
            if(result)
            {
               // Get set the parent component for the next dcr's name.               
               if(nameId instanceof DataSubcomponent)
               {
                  parentComponent = ((DataSubcomponent) nameId).getClassifier(); 
               }
               else
               {
                  // Report error then return.
                  reportNameError(componentName.getIdentifier(),
                        componentName.getIdentifier().getId() +
                            " (as a data access feature or data subcomponent)");
                  return false;
               }
            }
            else
            {
               // Error has already been reported.
               return false ;
            }
         }
      }
      return result ;
   }

   /* dispatch_condition ::=
         on dispatch [ dispatch_logical_expression ]
         [ frozen frozen_ports ]
      frozen_ports ::=
         in_port_identifier { , in_port_identifier }* */
   private boolean checkDispatchConditionNames(DispatchCondition cond)
   {
      boolean result = true ;
      
      DispatchLogicalExpression expr = cond.getTheDispatchLogicalExpression() ;
      
      // Expr can be null as a void dispatch logical expression means always true. 
      if(expr != null)
      {
         result = checkDispatchLogicalExpressionNames(expr) ;
      }
    
      // Check frozen port names case. X.4.(N3) naming rule.
      if (cond.isHasFrozenPorts())
      {
        for(Identifier id : cond.getFrozenPorts())
        {
           result &= checkFeatureName(id, true) ;
        }
      }

      return result ;
   }
   
   /* dispatch_logical_expression ::=
            dispatch_trigger
            [ { or dispatch_trigger }*
            | { and dispatch_trigger }*
            | { xor dispatch_trigger }* ]
         |  stop */
   private boolean checkDispatchLogicalExpressionNames(
                                          DispatchLogicalExpression expr) 
   {
      boolean result = true ;
      
      for(DispatchTrigger trigg : expr.getDispatchTriggers())
      {
         // Dispatch logical expression as dispatch trigger case.
         if(trigg.getTheDispatchLogicalExpression() != null)
         {
            // Recursive call.
            result &= checkDispatchLogicalExpressionNames(
                           trigg.getTheDispatchLogicalExpression());
         }
         else // Case of Dispatch trigger free from dispatch logical expression 
         {
            result &= checkDispatchTriggerNames(trigg) ;
         }
      }
      
      return result ;
   }
   
   /* dispatch_trigger ::=
         [ not ]
         (
              ( dispatch_logical_expression )
            | timeout [ behavior_time ]
            | in_event_port_identifier
            | in_event_data_port_identifier
            | in_event_data_port_identifier ( ( value_constant | others ) )
            | provides_subprogram_access_identifier
            | numeral [ ormore | orless ] ( dispatch_trigger {, dispatch_trigger }* )
          )
       behavior_time ::= integer_value unit_identifier */
   private boolean checkDispatchTriggerNames(DispatchTrigger trigg)
   {
      boolean result = true ;
      
      // Case of Numeral.
      if(trigg.isSetDispatchTriggers()) 
      {
         for(DispatchTrigger dt : trigg.getDispatchTriggers())
         {
            // Recursive call.
            result &= checkDispatchTriggerNames(dt) ;
         }
      }
      else
      {
         // Case of timeout.
         if (trigg.isTimeout())
         {
            // Behavior time may not be provided.
            if(trigg.getTheBehaviorTime() != null)
            {
               result = checkBehaviorTimeNames(trigg.getTheBehaviorTime()) ;
            }
         }
         else // Case of in event [data] port or subprogram access. X.4.(N4) 
              // naming rule.
         {
            // at this point id can't be null.
            Identifier id = trigg.getIdentifierOwned() ;
            boolean tmp ;
            
            // Check if id is an in event [data] port or subprogram access
            // means check id's name within ba's parent component features ones.               
            tmp= checkFeatureName(id, true) ;
            result = tmp ;
            
            // Check value constant case.
            if (tmp && trigg.getValueConstantOwned() != null) 
            {
               ValueConstant value = trigg.getValueConstantOwned() ;
               result &= checkValueConstantName(value) ;
            }
         }// End of second else.
      }// End of first else.
      return result ;
   }

   private boolean checkElementValuesNames(ElementValues values)
   {
      // Case of integer range.
      if(values instanceof IntegerRange)
      {
         return checkIntegerRangeNames((IntegerRange) values) ;
      }
      else
      {
         // Case of event data port name.
         if(values instanceof Name)
         {
            return checkNameObject((Name) values) ;
         }
         else
         {
            // Case of data component reference.            
            if (values instanceof DataComponentReference)
            {
               return checkDataComponentRefNames((DataComponentReference) values) ;
            }
            else
            {
               // XXX Should raise an error ?
               return false;
            }
         }
      }
   }

   private boolean checkFeatureName(Identifier id, boolean hasToReport)
   {
      String nameToFind = id.getId(); 
      
      Feature f = AadlBaVisitors.findFeatureInComponent(_baParentContainer,
                                                        nameToFind) ;

      if (f != null)
      {
         id.setAadlReferencedEntity(f);
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

   // Just the opposite of checkFeatureName.
   private boolean checkFeatureNameUniqueness(Identifier id)
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
   
   // Check for/forall structure's element variable name uniqueness
   // towards themselves and AADL elements.
   // BehaviorActions object may be null (batch processing).
   // XXX TEMPORARY MEASURE (in addition of the above purpose): 
   // Extends for/forall element variable uniqueness to the BA's local
   // variables. This temporary measure SHOULD BE REMOVED after the AADL
   // commitee's CLARIFICATION of the behavior of for/forall element variable 
   // towards BA's local variable.
   private boolean checkForForAllElementVariableUniqueness
                                                     (BehaviorActions beActions,
                                              List<String> lforElementVariables)
   {
      boolean result = true ;
      
      if(beActions != null)
      {
         for(BehaviorAction beAct : beActions.getBehaviorAction())
         {
            // Case of for/forall structures.
            if(beAct.isFor())
            {
               ForOrForAllStatement forStat = (ForOrForAllStatement)
                                                 beAct.getCondStatementOwned() ; 
               
               Identifier element = forStat.getElement() ;
               
               // Check uniqueness towards AADL elements.
               result &= checkFeatureNameUniqueness(element);
               
               // Check uniqueness towards for/forall element variable according
               // to their scope.           
               for (String s : lforElementVariables)
               {
                  // Case of an for/forall element variable name same as an 
                  // other one within its scope (nested for/forall structures).   
                  if(element.getId().equalsIgnoreCase(s))
                  {
                     result = false ;
                     
                     // Report error.
                     _errManager.error(element, "Duplicate local variable " +
                           element.getId());
                  }
               }
               
               // XXX TEMPORARY MEASURE ****************************************
               
               // Check uniqueness towards BA local variable.
               result &= checkBaVariableNameUniqueness(element);
               
               
               // END OF TEMPORARY MEASU****************************************
               
               // Store the for structure's element variable name so as to check
               // the rule.
               lforElementVariables.add(element.getId()) ;
               
               // Recursive call.
               result &= checkForForAllElementVariableUniqueness(
                                              forStat.getBehaviorActionsOwned(),
                                                          lforElementVariables);
               
               // Remove the for structure's element variable name as the for
               // structure element variable scope end here.
               
               lforElementVariables.remove(forStat.getElement().getId());
               
               continue ;
            } // End of first if.
            
            // Recursive calls. ***
            
            // Case of behavior actions.
            if(beAct.isBehaviorActions())
            {
               result &= checkForForAllElementVariableUniqueness(
                                                beAct.getBehaviorActionsOwned(),
                                                          lforElementVariables);
               
               continue ;
            }
            
            // Case of if structure.
            if(beAct.isIf())
            {
               IfStatement ifStat = (IfStatement) beAct.getCondStatementOwned();
               
               for(BehaviorActions tmp : ifStat.getBehaviorActionsOwned())
               {
                  result &= checkForForAllElementVariableUniqueness(tmp,
                        lforElementVariables);
               }
               
               continue ;
            }
            
            // Case of other loops except for/forall structure.
            if(beAct.isLoop())
            {
               LoopStatement otherLoopStat = (LoopStatement) 
                                                 beAct.getCondStatementOwned() ;
               
               result &= checkForForAllElementVariableUniqueness(
                                        otherLoopStat.getBehaviorActionsOwned(),
                                                          lforElementVariables);
            }
            
         } // End of first for.
      }

      return result ;
   }
   
   private boolean checkIdentifierName(ComponentClassifier parentContainer,
                                       Identifier id)
   {
      // Case of a Behavior annex component.
      if(parentContainer == _baParentContainer)
      {
         // First, check within for structure's element variables scope.
         // Don't report any error.
         if(checkWithinForStructureElementScope(id))
         {
            return true ;
         }
         else
         {
            // In second, check within ba's variables names but 
            // don't report any error.
            if(checkBaVariableName(id, false))
            {
               return true ;
            }
            else
            {
               // Third, check within ba's parent container features names.
               if(checkFeatureName(id, false))
               {
                  return true ;  
               }
               else
               {
            	   if(checkSubcomponentName(parentContainer, id, false))
            	   {
            		   return true ;
            	   }
               }
               
            }
         }
      }
      
      // At last check subcomponent names within given parent container and
      // report any error.
      //return checkSubcomponentName(parentContainer, id, true);
      
      // FIXME : TODO : XXX : GL : Add for support prototype_identifier
      // Need to write an errata for the SEI
      return checkPrototypeName(parentContainer, id, true);
   }

   private boolean checkIntegerRangeNames(IntegerRange range)
   {
      boolean result = checkIntegerValueNames(range.getUpperIntegerValue());
      result &= checkIntegerValueNames(range.getLowerIntegerValue()) ;
      return result ;
   }

   /* integer_value ::=
         integer_value_variable
       | integer_value_constant */
   private boolean checkIntegerValueNames(IntegerValue value)
    {
      if(value instanceof ValueVariable)
      {
         return checkValueVariableName(value, (ValueVariable)value) ;
      }
      else
      {
         return checkValueConstantName((ValueConstant)value) ;
      }
    }

   /**
    * Resolves the names in behavior annex.
    * 
    * @return {@code true} if all names are resolved. {@code false} otherwise.
    */
   public boolean resolveNames()
   {
      boolean result = this.checkBaComponentsUniqueness() ;
      
      // Continue other checking if only BA's components uniqueness 
      // is ensured.
      if (result)
      {
         result &= this.checkVariablesNames() ;
         result &= this.checkBaTransitionNames() ;
      }
      
      return result ;
   }
   
   private boolean checkNameObject(Name nameObj)
   {
      return checkNameObject(_baParentContainer, nameObj) ;
   }
   
   // Check Name Object'names means to check names (identifier and array index)
   // within parent component's features ones and ba's variables ones and
   // for structure element variables scope handler.
   // name ::= identifier { array_index }*
   // array_index :: [ integer_value_variable ]
   private boolean checkNameObject(ComponentClassifier parentContainer,
                                   Name nameObj)
   {
      boolean result = false ;
      
      // Check Identifier name.
      result = checkIdentifierName(parentContainer, nameObj.getIdentifier()) ;
      
      nameObj.setAadlReferencedEntity(nameObj.getIdentifier()
                                                    .getAadlReferencedEntity());
      nameObj.setBaReferencedEntity(nameObj.getIdentifier()
                                                      .getBaReferencedEntity());
      
      
      // Check array indexes names.
      for (ArrayIndex index : nameObj.getArrayIndexListOwned())
      {
         // Recursive call.
         result &= checkValueVariableName(index,
                                          index.getIntegerValueVariableOwned());
      }
      return result ;
   }

   /**
    * Check behavior annex's sub component uniqueness within behavior annex's
    * parent component scope. Conflits are reported in the given error report
    * manager.
    * 
    */
   private boolean checkParentComponentIdentifiersUniqueness()
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

      EList<BehaviorVariable> lvars = _ba.getVariables() ;
      EList<BehaviorState> lstates = _ba.getStates() ;
      EList<BehaviorTransition> ltrans = _ba.getTransitions() ;

      // Check uniqueness within the parent component.
      for(edu.cmu.sei.aadl.aadl2.NamedElement ne : lcc)
      {
         for(BehaviorVariable v : lvars)
         {
            for(Declarator d : v.getLocalVariableDeclarators())
            {
               if(d.getName().equalsIgnoreCase(ne.getName()))
               {
                  _errManager.error(d, "conflict with " + ne.getName()
                        + " at line " + ne.getLocationReference().getLine()) ;
                  result = false ;
               }
            }
         }

         for(BehaviorState s : lstates)
         {
            for(Identifier ids : s.getBehaviorStateIdentifiers())
            {
               if(ids.getId().equalsIgnoreCase(ne.getName()))
               {
                  _errManager.error(ids, "conflict with " + ne.getName()
                        + " at line " + ne.getLocationReference().getLine()) ;
                  result = false ;
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

   private boolean checkSubcomponentName(ComponentClassifier parentComponent,
                                         Identifier id, boolean hasToReport)
   {
      String nameToFind = id.getId() ;
      
      Subcomponent subc = AadlBaVisitors.findSubcomponentInComponent
                                               (parentComponent, nameToFind);

      if (subc != null)
      {
         id.setAadlReferencedEntity(subc);
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
   
   private boolean checkPrototypeName(ComponentClassifier parentComponent,
		   Identifier id, boolean hasToReport)
   {
	   String nameToFind = id.getId() ;

	   Prototype proto = AadlBaVisitors.findPrototypeInComponent
	   (parentComponent, nameToFind);

	   if (proto != null)
	   {
		   id.setAadlReferencedEntity(proto);
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


   private boolean checkSubprogramParameterListNames(SubprogramParameterList spl)
   {
      boolean result = true ;
      
      for (ParameterLabel pLabel : spl.getParameterList())
      {
         // Case of parameter label is a value expression.
         if(pLabel instanceof ValueExpression)
         {
            result &= checkValueExpressionNames((ValueExpression) pLabel);
         }
         else // Case of parameter label is a target.
         {
            result &= checkTargetNames((Target) pLabel) ;
         }
      }
      
      return result ;
   }

   private boolean checkTargetNames(Target tar)
   {
      return checkDataComponentRefNames(tar.getDataComponentReferenceOwned()) ;
   }
   
   private boolean checkTimedActionNames(TimedAction act)
   {
      boolean result = true ;
      
      for(BehaviorTime bt : act.getBehaviorTimesOwned())
      {
         result &= checkBehaviorTimeNames(bt) ;
      }
      return result ;
   }
   
   // Checks behavior time's time unit according to property set Time_Units and 
   // binds if checking is successful.
   private boolean checkTimeUnit(Identifier unitIdentifier)
   {
      PackageSection context = AadlBaVisitors.getContainingPackageSection(_ba);
      
      edu.cmu.sei.aadl.aadl2.NamedElement ne = 
         AadlBaVisitors.findNamedElementInPropertySet(
                                        null, TIME_UNITS_PROPERTY_SET, context);
      
      // Property set Time_Units is found.
      if (ne != null && ne instanceof edu.cmu.sei.aadl.aadl2.UnitsType)
      {
         edu.cmu.sei.aadl.aadl2.UnitsType ut = 
                                         (edu.cmu.sei.aadl.aadl2.UnitsType) ne ;
         
         // Find the given time unit in the enumeration.
         edu.cmu.sei.aadl.aadl2.UnitLiteral ul = ut.findLiteral(
                                                       unitIdentifier.getId()) ;
         
         // The given time unit is found.
         if(ul != null)
         {
            unitIdentifier.setAadlReferencedEntity(ul) ;
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

   private boolean checkUniqueComponentClassifierRefNames(
                                         UniqueComponentClassifierReference ucr,
                                         boolean hasToReport)
                                                          
   {
      String packageName = ucr.getQualifiedName() ;
      edu.cmu.sei.aadl.aadl2.NamedElement ne ;
      
      // If qualified name is null than the element must be declared in the
      // current package.
      if(packageName == null)
      {
         packageName = _contextsTab[0].getName() ;
      }
      
      // Now check the type in each current package's sections.
      for(Namespace ns: _contextsTab)
      {
         ne = AadlBaVisitors.findNamedElementInAadlPackage(packageName,
                                                         ucr.getName(), ns) ;
         
         // An element is found.
         if(ne != null)
         {
               // Link unique component classifier reference with
               // named element found.
               ucr.setAadlReferencedEntity(ne) ;
               return true ;
         }
      }
      
      // No Element is found.
      if(hasToReport)
      {
         String qualifiedName =
            AadlBaVisitors.getQualifiedName(ucr.getQualifiedName(),
                                            ucr.getName()) ;
         reportNameError(ucr, qualifiedName) ;
      }
      
      return false ;
   }

   // Check constant value names means to check names
   // within property set value ones or property set constant ones.
   /* value_constant ::=
           boolean_literal
         | numeric_literal
         | string_literal
         | property_constant
         | property_value */
   private boolean checkValueConstantName(ValueConstant value)
   {
      if(value instanceof PropertyValue || value instanceof PropertyConstant)
      {
         fr.tpt.aadl.annex.behavior.aadlba.NamedElement pro = 
                        (fr.tpt.aadl.annex.behavior.aadlba.NamedElement) value ;
         String propertySetName = pro.getQualifiedName();
         PackageSection[] contextsTab =AadlBaVisitors.getBaPackageSections(_ba);
         edu.cmu.sei.aadl.aadl2.NamedElement ne ;
         
         // If qualified name is null than the property must be declared in the
         // current package.
         if(propertySetName == null)
         {
            propertySetName = contextsTab[0].getName() ;
         }
         
         // Now check the type in each current package's sections.
         for(Namespace ns: contextsTab)
         {
            ne = AadlBaVisitors.findNamedElementInPropertySet(propertySetName,
                                                             pro.getName(), ns);
            // A element is found.
            if(ne != null)
            {
               value.setAadlReferencedEntity(ne) ;
               return true ;
            }
         }
         // No element is found.
         String qualifiedName =
            AadlBaVisitors.getQualifiedName(pro.getQualifiedName(),
                                            pro.getName()) ;
         reportNameError(value, qualifiedName) ;
         
         return false ; 
      }
      else // Value doesn't contain any name.
      {
         return true ;
      }
   }

   private boolean checkValueExpressionNames(ValueExpression expr)
   {
      boolean result = true ;
      int seNb = 0 ;
      SimpleExpression se ;
      Value v ;
      int vNb = 0 ;
      
      // Iterate over relations.
      for(Relation r : expr.getRelationsOwned())
      {
         se = r.getSimpleExpressionOwned() ;
         
         // Treat simple expression(s).
         do
         {
            // Iterate over Terms.
            for(Term t : se.getTermsOwned())
            {
               // Iterate over Factors.
               for (Factor f : t.getFactorsOwned())
               {
                  v = f.getValueOwned() ;
                  
                  // Treat value(s).
                  do
                  {
                    result &= checkValueNames(v) ; 
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

   private boolean checkValueNames(Value value)
   {
      // Case of a value variable.
      if(value instanceof ValueVariable)
      {
         return checkValueVariableName(value, (ValueVariable)value) ;
      }
      else
      {
         // Case of a value constant.
         if(value instanceof ValueConstant)
         {
            return checkValueConstantName((ValueConstant)value) ; 
         }
         else // Case of value expression : recursive call.
         {
            return checkValueExpressionNames((ValueExpression) value) ;
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
   private boolean checkValueVariableName(Element toBeSet, ValueVariable value)
   {
      // Case of port name or subprogram access name.
      if(value.getDataComponentReferenceOwned() == null)
      {
         Name nameObj = value.getElementNameOwned() ;
         return checkNameObject(nameObj) ;
      }
      else // Case of data component reference.
      {
         return checkDataComponentRefNames(value.getDataComponentReferenceOwned());
      }
   }
   
   /**
    * Resolves the names in behavior annex's variables.
    * 
    * @return {@code true} if all names are resolved. {@code false} otherwise.
    */
   private boolean checkVariablesNames()
   {
      boolean result = true ;
      UniqueComponentClassifierReference uccr ;
      
      // For each behavior variable, check if declared unique component 
      // classifier reference exists.
      for(BehaviorVariable v : _ba.getVariables())
      {
         uccr = v.getDataUniqueComponentClassifierReference() ;

         result &=checkUniqueComponentClassifierRefNames(uccr, true);
      }
      return result ;
   }
   
   // Check the given Identifier object versus for struture's element variables
   // Identifier objects.
   // It doesn't report error.
   private boolean checkWithinForStructureElementScope(Identifier id)
   {
      boolean result = false ;
      
      for(Identifier el : _lForElementIds)
      {
         if(id.getId().equalsIgnoreCase(el.getId()))
         {
            result = true ;
            break ;
         }
      }
      
      return result ;
   }

   // TODO Provide column number.
   private void reportNameError(Element obj, String name) 
   {
      _errManager.error(obj, "\'" + name + "\' is not found");
   }
}