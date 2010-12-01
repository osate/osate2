package fr.tpt.aadl.annex.behavior.analyzers ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.DataImplementation ;
import edu.cmu.sei.aadl.aadl2.DataSubcomponent ;
import edu.cmu.sei.aadl.aadl2.DataType ;
import edu.cmu.sei.aadl.aadl2.DeviceImplementation ;
import edu.cmu.sei.aadl.aadl2.DeviceType ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.Port ;
import edu.cmu.sei.aadl.aadl2.PropertyAssociation ;
import edu.cmu.sei.aadl.aadl2.SubprogramImplementation ;
import edu.cmu.sei.aadl.aadl2.SubprogramType ;
import edu.cmu.sei.aadl.aadl2.ThreadImplementation ;
import edu.cmu.sei.aadl.aadl2.ThreadType ;

import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import edu.cmu.sei.osate.workspace.names.standard.ThreadProperties ;
import edu.cmu.sei.osate.workspace.names.standard.TimingProperties ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.ExecuteCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.Name ;
import fr.tpt.aadl.annex.behavior.aadlba.NamedElement ;
import fr.tpt.aadl.annex.behavior.aadlba.UniqueComponentClassifierReference ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;

/*
--------------------------------------------------------------------------------
SEMANTIC RULES
--------------------------------------------------------------------------------

.behavior annex subclause/specification
-------------------------------------------
- X.3.(2) in modes, all modes > nothing to do
- X.3.(20) annex subclause and aadl core language consistency
- X.3.(21) SUBPROGRAM CALLS and behavior annex subclause

.automaton
-------------------------------------------
#subprograms
- X.3.(8) subprogram's automaton must contain one initial state...
          no complete state
          -> check_subprogram_automaton
             .> check one initial state, check one final, no complete 
- X.3.(12) modes and subprograms

#threads and devices
- X.3.(9) complete state...
- X.3.(13) components and modes
- X.3.(14) out transition, complete state, dispatch condition
- X.3.(16) dispatch condition
- X.3.(21) SUBPROGRAM CALLS and behavior annex subclause
- X.3.(22) thread automaton and AADL core semantics
- X.3.(23) behavior specification
- X.4.(1) consistency between aadl core port frozen...

#others components
- X.3.(10)
- X.3.(13) components and modes
- X.3.(23) behavior specification


.states
-------------------------------------------
- X.3.(11) final state cannot accept outgoing transitions


.variables
-------------------------------------------
- X.3.(27) local variables must be typed
- X.3.(28) if persistent variables, not oblige to have data subcomp


.transitions
-------------------------------------------
- X.3.(15) transitions and conditions
- X.3.(18) transitions and priority numbers
- X.3.(19) transitions and actions


.conditions
-------------------------------------------
- X.3.(16) dispatch conditions
- X.3.(17) execute conditions
- X.3.(24) dipatch conditions refinement
- X.3.(25) dispatch condition, priority...
- X.3.(26) timeout dispatch condition, Period property

- X.4.(2) dipatch condition, transition, out complete state
- X.4.(3) dispatch condition, timeout et aadl core language
- X.4.(4) dispatch condition, transition, complete and final state
          aadl core language
- X.4.(5) dispatch condition, event data dispatch trigger. Same as legality rule
          X.4(12). Implemented.
- X.4.(6) dispatch trigger, numeral, ormore, orless


.ports
-------------------------------------------
- X.5.(6) ports, input_time property, output_time, aadl consistency
- X.5.(7) 
- X.5.(13) output out or in out ports, data access features, incoming parameter
- X.5.(15) send, receive output on ports


.data components
-------------------------------------------
- X.5.(11) shared data, concurrency control protocol
- X.5.(12) shared data, concurrency control protocol, 3 sc


.subprograms
-------------------------------------------
- X.5.(18)
- X.5.(19)
- X.5.(20) nothing to implement

.basic actions
-------------------------------------------
- X.6.(3) assignment action target references in assignments
- X.6.(4) communication actions ports parameters subprogram calls
- X.6.(5) timed actions and computation
- X.6.(6) timed actions and time values and aadl core language properties

.assignment actions
-------------------------------------------
- X.6.(15) out and assignment actions
- X.6.(16) assignment actions re-used in same action sets
- X.6.(17) target, expressions matching types. Same as legality rule X.6(14).
           Chosen to be implemented instead of the legality rule X.6(14).

.timed actions
-------------------------------------------
- X.6.(18) timed actions cannont be used in action sets
- X.6.(19) computation and behavior time unit

.timeout
-------------------------------------------
- X.6.(7) timeout and execution block

.behavior expressions
-------------------------------------------
- X.7.(1) 
- X.7.(2) 
- X.7.(3) 
- X.7.(4) 
*/

public class AadlBaSemanticRulesChecker
{
   private BehaviorAnnex _ba ;
   private ComponentClassifier _baParentContainer ;
   PackageSection[] _contextsTab ;
   private AnalysisErrorReporterManager _errManager ;

   public AadlBaSemanticRulesChecker(BehaviorAnnex ba, AnalysisErrorReporterManager errManager)
   {
      _ba = ba ;
      _errManager = errManager ;
      _baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
      _contextsTab = AadlBaVisitors.getBaPackageSections(_ba) ;
   }

   /*
    * BEGIN DRIVER ROUTINES SEMANTIC ANALYSER
    */

   /**
    * This function drives the semantic analysis.
    */
   public boolean checkSemanticRules()
   {
      boolean result = true ; // FIXME : TODO : init at false when finish

      // result = checkAnnexSubclauseSpecification() ; // FIXME : TODO :
      // uncomment when finish

      //automatons
      result &= this.checkAutomatons() ;

      //states
      result &= this.checkFinalStates() ;

      //variables
      result &= this.checkVariables() ;

      //conditions
      result &= this.checkBehaviorConditionsInTransitions() ;
      result &= this.checkConditions() ;

      // ports
      result &= this.checkOutputs() ;

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rules
    * Section : X.3 Behavior Specification 
    * Object : Check semantic rule X.3.(21) 
    * Keys : annex subclause, subprogram calls, aadl core language
    */
   private boolean checkAnnexSubclauseSpecification()
   {
      boolean result = true ;

      /*
       * SubprogramCallSequence scs = null ; EList<SubprogramCallSequence>
       * lcalls = null ;
       * 
       * // if the component has subprogram call sequences
       * if(!((ComponentImplementation) _baParentContainer).isNoCalls()) {
       * 
       * if(_baParentContainer instanceof ThreadImplementation) { lcalls =
       * ((ThreadImplementation) _baParentContainer)
       * .getOwnedSubprogramCallSequences() ; } else if(_baParentContainer
       * instanceof AbstractImplementation) { lcalls =
       * ((AbstractImplementation) _baParentContainer)
       * .getOwnedSubprogramCallSequences() ; }
       * 
       * Iterator it = null ; it = lcalls.iterator() ;
       * 
       * while(it.hasNext()) { // TODO : FIXME : wait AADL FORUM response
       * System.out.println("aadl-ba semantic rule 21") ; }
       * 
       * } else { result = true ; }
       */

      return result ;
   }

   /**
    * This function drives the semantic analysis of behavior automaton.
    */
   private boolean checkAutomatons()
   {
      boolean result = true ;

      // all AADL components
      result &= checkComponentAutomaton() ;

      // only subprogram components
      if(_baParentContainer instanceof SubprogramType || _baParentContainer instanceof SubprogramImplementation)
      {
         result &= checkSubprogramAutomaton() ;
      }

      return result ;
   }

   /* END DRIVER ROUTINES SEMANTIC ANALYSER */

   /**
    * Checks modes and states semantic rules in subprogram automatons.
    */
   private boolean checkSubprogramAutomaton()
   {
      boolean result = false ;

      // FIXME : TODO : disabled since checkComponentStatesAutomaton verify this rule
      //result = checkSubprogramStatesAutomaton();
      result = checkSubprogramModesAutomaton() ;

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X.3 Behavior Specification Object : Check semantic rule X.3.(8)
    * Keys : subprogram, initial complete final states
    */
   // FIXME : TODO : disabled since checkComponentStatesAutomaton verify this rule
   /*
   private boolean checkSubprogramStatesAutomaton() {
      boolean result = true;

      String reportElements = null;

      EList<BehaviorState> lbs = null;
      EList<Identifier> lbsi = null;
      EList<Identifier> lbsinitial = new BasicEList<Identifier>();
      EList<Identifier> lbscomplete = new BasicEList<Identifier>();
      EList<Identifier> lbsfinal = new BasicEList<Identifier>();

      if (_baParentContainer instanceof SubprogramType
            || _baParentContainer instanceof SubprogramImplementation) {
         if (_ba.isSetStates()) {
            lbs = _ba.getStates();

            for (BehaviorState bs : lbs) {
               if (bs.isInitial()) {
                  lbsi = bs.getBehaviorStateIdentifiers();
                  for (Identifier i : lbsi) {
                     lbsinitial.add(i);
                  }
               }

               if (bs.isComplete()) {
                  lbsi = bs.getBehaviorStateIdentifiers();
                  for (Identifier i : lbsi) {
                     lbscomplete.add(i);
                  }
               }

               if (bs.isFinal()) {
                  lbsi = bs.getBehaviorStateIdentifiers();
                  for (Identifier i : lbsi) {
                     lbsfinal.add(i);
                  }
               }
            }

            if (lbsinitial.size() > 1) {
               result = false;
               reportElements = AadlBaUtils.ListToString(lbsinitial);
               this.reportSemanticError(_ba, _baParentContainer
                     .getQualifiedName()
                     + " has more than one intial state : "
                     + reportElements
                     + " : Behavior Annex X.3.(8) semantic rule failed");
            }

            if (lbscomplete.size() > 0) {
               result = false;
               reportElements = AadlBaUtils.ListToString(lbscomplete);
               this.reportSemanticError(_ba, _baParentContainer
                     .getQualifiedName()
                     + " has complete state : "
                     + reportElements
                     + " : Behavior Annex X.3.(8) semantic rule failed");
            }

            if (lbsfinal.size() > 1) {
               result = false;
               reportElements = AadlBaUtils.ListToString(lbsinitial);
               this.reportSemanticError(_ba, _baParentContainer
                     .getQualifiedName()
                     + " has more than one final state : "
                     + reportElements
                     + " : Behavior Annex X.3.(8) semantic rule failed");
            }
         }
      } else {
         result = false;
         this.reportSemanticError(_ba, _baParentContainer.getQualifiedName()
               + "is not a subprogram component");
      }


    * if(result == false) { this.reportSemanticError(_ba,
    * _baParentContainer.getQualifiedName() +
    * " : Behavior Annex X.3.(8) semantic rule failed") ; }


      return result;
   }*/

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification 
    * Object : Check semantic rule X.3.(12) 
    * Keys : subprogram, modes, automaton
    */
   private boolean checkSubprogramModesAutomaton()
   {
      // FIXME : XXX : NYI
      boolean result = true ;

      return result ;
   }

   /**
    * Checks semantic rules in all AADL components automaton except subprogram
    * automaton.
    */
   private boolean checkComponentAutomaton()
   {
      boolean result = false ;

      result = checkComponentStatesAutomaton() ;
      result &= checkFrozenPortsAndAadlCoreLanguage() ;

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.4 Thread Dispatch Behavior Specification 
    * Object : Check semantic rule X.4.(1) 
    * Keys : behavior subclauses, dispatch condition, frozen ports, AADL core language
    */
   private boolean checkFrozenPortsAndAadlCoreLanguage()
   {
      boolean result = true ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification 
    * Object : Check semantic rules X.3.(8), X.3.(9), X.3.(10), X.3.(22), X.3.(23) 
    * Keys : threads, devices, others, subprogram components
    * initial complete final states, automaton, aadl core semantics
    */
   private boolean checkComponentStatesAutomaton()
   {
      // FIXME : TODO : check X.3.(10) and X.3.(23) conflict and check

      boolean result = false ;

      String reportElements = null ;

      EList<BehaviorState> lbs = null ;
      EList<Identifier> lbsi = null ;
      EList<Identifier> lbsinitial = new BasicEList<Identifier>() ;
      EList<Identifier> lbscomplete = new BasicEList<Identifier>() ;
      EList<Identifier> lbsfinal = new BasicEList<Identifier>() ;

      if(_ba.isSetStates())
      {
         lbs = _ba.getStates() ;

         for(BehaviorState bs : lbs)
         {
            if(bs.isInitial())
            {
               lbsi = bs.getBehaviorStateIdentifiers() ;
               for(Identifier i : lbsi)
               {
                  lbsinitial.add(i) ;
               }
            }

            if(bs.isComplete())
            {
               lbsi = bs.getBehaviorStateIdentifiers() ;
               for(Identifier i : lbsi)
               {
                  lbscomplete.add(i) ;
               }
            }

            if(bs.isFinal())
            {
               lbsi = bs.getBehaviorStateIdentifiers() ;
               for(Identifier i : lbsi)
               {
                  lbsfinal.add(i) ;
               }
            }
         }

         // Subprogram aadl components
         if(_baParentContainer instanceof SubprogramType || _baParentContainer instanceof SubprogramImplementation)
         {
            if(lbsinitial.size() > 1)
            {
               result = false ;
               reportElements = AadlBaUtils.ListToString(lbsinitial) ;
               this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has more than one initial state : " + reportElements + " : Behavior Annex X.3.(8) semantic rule failed") ;
            }
            else
               if(lbsinitial.size() == 0)
               {
                  result = false ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no initial state" + " : Behavior Annex X.3.(8) semantic rule failed") ;
               }

            if(lbscomplete.size() > 0)
            {
               result = false ;
               reportElements = AadlBaUtils.ListToString(lbscomplete) ;
               this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has complete state : " + reportElements + " : Behavior Annex X.3.(8) semantic rule failed") ;
            }

            if(lbsfinal.size() > 1)
            {
               result = false ;
               reportElements = AadlBaUtils.ListToString(lbsinitial) ;
               this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has more than one final state : " + reportElements + " : Behavior Annex X.3.(8) semantic rule failed") ;
            }
            else
               if(lbsfinal.size() == 0)
               {
                  result = false ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no final state" + " : Behavior Annex X.3.(8) semantic rule failed") ;
               }
         }
         // Threads and devices aadl components
         else
            if(_baParentContainer instanceof ThreadType || _baParentContainer instanceof ThreadImplementation || _baParentContainer instanceof DeviceType || _baParentContainer instanceof DeviceImplementation)
            {

               if(lbsinitial.size() > 1)
               {
                  result = false ;
                  reportElements = AadlBaUtils.ListToString(lbsinitial) ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has more than one initial state : " + reportElements + " : Behavior Annex X.3.(9), X.3.(22), X.3.(23) semantic rules failed") ;
               }
               else
                  if(lbsinitial.size() == 0)
                  {
                     result = false ;
                     this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no initial state" + " : Behavior Annex X.3.(9), X.3.(22), X.3.(23) semantic rules failed") ;
                  }

               if(lbscomplete.size() == 0)
               {
                  result = false ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no complete state" + " : Behavior Annex X.3.(9), X.3.(22), X.3.(23) semantic rules failed") ;
               }

               if(lbsfinal.size() == 0)
               {
                  result = false ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no final state" + " : Behavior Annex X.3.(9), X.3.(22), X.3.(23) semantic rules failed") ;
               }

            }
         // Others aadl components
            else
            {
               if(lbsinitial.size() > 1)
               {
                  result = false ;
                  reportElements = AadlBaUtils.ListToString(lbsinitial) ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has more than one initial state : " + reportElements + " : Behavior Annex X.3.(10), X.3.(23) semantic rules failed") ;
               }
               else
                  if(lbsinitial.size() == 0)
                  {
                     this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no initial state" + " : Behavior Annex X.3.(10), X.3.(23) semantic rules failed") ;
                  }

               if(lbscomplete.size() == 0)
               {
                  result = false ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no complete state" + " : Behavior Annex X.3.(10), X.3.(23) semantic rules failed") ;
               }

               if(lbsfinal.size() == 0)
               {
                  result = false ;
                  this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has no final state" + " : Behavior Annex X.3.(10), X.3.(23) semantic rules failed") ;
               }
               else
                  if(lbsfinal.size() > 1)
                  {
                     result = false ;
                     reportElements = AadlBaUtils.ListToString(lbsfinal) ;
                     this.reportSemanticError(lbs.get(0), _baParentContainer.getQualifiedName() + " has more than one final state : " + reportElements + " : Behavior Annex X.3.(10), X.3.(23) semantic rules failed") ;
                  }
            }
      }

      /*
       * if(result == false) { this.reportSemanticError(_ba,
       * _baParentContainer.getQualifiedName() +
       * " : Behavior Annex X.3.(9), X.3.(22), X.3.(23) semantic rules failed"
       * ) ; }
       */

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification 
    * Object : Check semantic rule X.3.(11) 
    * Keys : component automaton, final states, outgoing transitions
    */
   private boolean checkFinalStates()
   {
      boolean result = true ;

      String reportElements = null ;

      EList<BehaviorTransition> lbt = null ;
      EList<Identifier> lbtsource = null ;
      EList<Identifier> lbs = new BasicEList<Identifier>() ;

      BehaviorState bs = null ;

      if(_ba.isSetTransitions())
      {
         lbt = _ba.getTransitions() ;

         for(BehaviorTransition bt : lbt)
         {
            if(bt.isSetSourceStateIdentifiers())
            {
               lbtsource = bt.getSourceStateIdentifiers() ;

               for(Identifier i : lbtsource)
               {
                  bs = AadlBaVisitors.findBehaviorState(_ba, i.getId()) ;
                  if(bs.isFinal() && !bs.isInitial() && !bs.isComplete())
                  {
                     for(Identifier id : bs.getBehaviorStateIdentifiers())
                     {
                        lbs.add(id) ;
                     }
                  }
               }
            }
            else
            {
               result = false ;
               this.reportSemanticError(bt, " has no source state, cannot check Behavior Annex X.3.(11) semantic rule") ;
            }
         }

         if(lbs.size() > 0)
         {
            result = false ;
            reportElements = AadlBaUtils.ListToString(lbs) ;
            this.reportSemanticError(_ba, _baParentContainer.getQualifiedName() + " has final states with outgoing transitions : " + reportElements + " : Behavior Annex X.3.(11) semantic rule failed") ;
         }
      }
      else
      {
         this.reportSemanticWarning(_ba, _baParentContainer.getQualifiedName() + " has no transition, cannot check Behavior Annex X.3.(11) semantic rule") ;
      }

      return result ;
   }

   /**
    * This function drives the semantic analysis of behavior variables.
    */
   private boolean checkVariables()
   {
      // FIXME : TODO : remove this function ?
      boolean result = false ;
      result = this.checkLocalAndStatesVariables() ;

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification 
    * Object : Check semantic rule X.3.(27), X.3.(28) 
    * Keys : local variables, state variables, data component classifier
    */
   private boolean checkLocalAndStatesVariables()
   {
      // TODO : FIXME : check the function
      boolean result = false ;

      EList<BehaviorVariable> lbv = null ;

      UniqueComponentClassifierReference uccr = null ;
      if(_ba.isSetVariables())
      {
         lbv = _ba.getVariables() ;

         for(BehaviorVariable bv : lbv)
         {
            // TODO : FIXME : check if it's only for non persistent variable
            if(!bv.isPersistent())
            {
               uccr = bv.getDataUniqueComponentClassifierReference() ;

               if(uccr.getAadlReferencedEntity() instanceof DataImplementation || uccr.getAadlReferencedEntity() instanceof DataType || uccr.getAadlReferencedEntity() instanceof DataSubcomponent)
               {
                  result = true ;
               }
               else
               {
                  result = false ;
                  this.reportSemanticError(uccr, uccr.getName() + " is not a valid data component classifier for local variables" + " : Behavior Annex X.3.(27), X.3.(28) semantic rules failed") ;
               }
            }
         }
      }
      else
      {
         this.reportSemanticWarning(_ba, _baParentContainer.getQualifiedName() + " has no variable, cannot check Behavior Annex X.3.(27), X.3.(28) semantic rules") ;
      }

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X. 
    * Object : Check semantic rule X. 
    * Keys :
    */
   private boolean checkBehaviorConditionsInTransitions()
   {
      // FIXME : TODO : Is this function really use ?
      boolean result = true ;

      EList<BehaviorTransition> lbt = null ;

      lbt = _ba.getTransitions() ;

      for(BehaviorTransition bt : lbt)
      {
         if(bt.isSetBehaviorConditionOwned())
         {
            if(bt.getBehaviorConditionOwned() instanceof DispatchCondition || bt.getBehaviorConditionOwned() instanceof ExecuteCondition)
            {
               result &= true ;
            }
            else
            {
               result = false ;
               this.reportSemanticError(bt, " transition guard is not a dispatch condition," + "an execute condition or empty" + " : Behavior Annex X.3.(15) semantic rule failed") ;
            }
         }
      }
      return result ;
   }

   /**
    * This function drives the semantic analysis of dispatch and execute
    * conditions.
    */
   private boolean checkConditions()
   {
      boolean result = true ;
      result &= this.checkDispatchConditionOutOfCompleteStates() ;
      result &= this.checkExecuteConditionOutOfExecutionStates() ;

      // check consistency between AADL Dispatch_Trigger property
      // and dispatch trigger used in Behavior dispatch condition
      result &= this.checkDispatchTriggers() ;

      if(_baParentContainer instanceof ThreadImplementation || _baParentContainer instanceof ThreadType || _baParentContainer instanceof DeviceImplementation || _baParentContainer instanceof DeviceType)
      {
         result &= this.checkDispatchConditionAndTimeout() ;
      }

      result &= this.checkEventDataDispatchTriggerAndOthers() ;
      result &= this.checkNumeralOrmoreOrlessInDispatchTriggers() ;

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification
    * Object : Check semantic rules X.3.(16), X.4.(2)
    * Keys : dispatch condition, out complete state
    */
   private boolean checkDispatchConditionOutOfCompleteStates()
   {
      boolean result = true ;

      Element elt = null ;
      EList<Identifier> lbti = null ;
      EList<BehaviorTransition> lbt = null ;

      lbt = _ba.getTransitions() ;

      for(BehaviorTransition bt : lbt)
      {
         if(bt.isSetBehaviorConditionOwned())
         {
            if(bt.getBehaviorConditionOwned() instanceof DispatchCondition)
            {
               lbti = bt.getSourceStateIdentifiers() ;
               for(Identifier i : lbti)
               {
                  elt = i.getBaReferencedEntity() ;
                  if(!((BehaviorState) elt).isComplete())
                  {
                     result = false ;
                     this.reportSemanticError(bt, " dispatch condition out of " + i.getId() + " which is not a complete state" + " : Behavior Annex X.3.(16), X.4.(2) semantic rules failed") ;
                  }
               }
            }
         }
      }
      // FIXME : TODO : check dispatch condition as boolean expression
      // FIXME : TODO : AADL core language part
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification
    * Object : Check semantic rule X.3.(17)
    * Keys : execute condition, out execute state
    */
   private boolean checkExecuteConditionOutOfExecutionStates()
   {
      boolean result = true ;

      Element elt = null ;
      EList<Identifier> lbti = null ;
      EList<BehaviorTransition> lbt = null ;

      lbt = _ba.getTransitions() ;

      for(BehaviorTransition bt : lbt)
      {
         if(bt.isSetBehaviorConditionOwned())
         {
            if(bt.getBehaviorConditionOwned() instanceof ExecuteCondition)
            {
               lbti = bt.getSourceStateIdentifiers() ;
               for(Identifier i : lbti)
               {
                  elt = i.getBaReferencedEntity() ;
                  if(((BehaviorState) elt).isInitial() && !((BehaviorState) elt).isComplete() && !((BehaviorState) elt).isFinal())
                  {
                     result &= result ;
                  }
                  else
                     if(((BehaviorState) elt).isInitial() || ((BehaviorState) elt).isComplete() || ((BehaviorState) elt).isFinal())
                     {
                        result = false ;
                        this.reportSemanticError(bt, " execute condition out of " + i.getId() + " which is not an execution state" + " : Behavior Annex X.3.(17) semantic rule failed") ;
                     }
               }
            }
         }
      }
      // FIXME : TODO : check execute condition as logical expression

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification
    * Object : Check semantic rule X.3.(24)
    * Keys : dispatch trigger, aadl property, dispatch condition, refinement
    */
   private boolean checkDispatchTriggers()
   {
      boolean result = true ;

      // FIXME : TODO : improve function for property in component type
      EList<BehaviorTransition> lbt = null ;
      EList<PropertyAssociation> lpa = null ;
      EList<String> lportsBehaviorDispatchTrigger = new BasicEList<String>() ;
      EList<String> lportsPropertyDispatchTrigger = null ;
      EList<DispatchTrigger> ldt = new BasicEList<DispatchTrigger>() ;

      if(_ba.isSetTransitions())
      {
         lbt = _ba.getTransitions() ;

         lpa = AadlBaGetProperties.getPropertyAssociations(_baParentContainer, AadlBaGetProperties.DISPATCH_TRIGGER) ;

         // FIXME : TODO : change the condition test
         if(!lpa.isEmpty())
         {
            lportsPropertyDispatchTrigger = AadlBaGetProperties.getPropertyDispatchTriggers(lpa) ;
            ldt = AadlBaVisitors.getBehaviorDispatchTriggers(lbt) ;

            // construct the string port behavior dispatch triggers list
            for(DispatchTrigger dt : ldt)
            {
               if(dt.isSetIdentifierOwned())
               {
                  lportsBehaviorDispatchTrigger.add(dt.getIdentifierOwned().getId()) ;
               }
            }

            for(String s : lportsPropertyDispatchTrigger)
            {
               if(!lportsBehaviorDispatchTrigger.contains(s))
               {
                  result = false ;
                  this.reportSemanticError(lbt.get(0), s + " specified in AADL Dispatch_Trigger property" + " is not used in dispatch conditions" + " : Behavior Annex X.3.(24) semantic rule failed") ;
               }
            }
         }
      }
      else
      {
         this.reportSemanticWarning(_ba, _baParentContainer.getQualifiedName() + " has no transition, cannot check semantic rule X.3.(24)") ;
      }
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.3 Behavior Specification
    * Object : Check semantic rules X.3.(26), X.4.(3)
    * Keys : dispatch condition, timeout, dispatch protocol, period
    */
   private boolean checkDispatchConditionAndTimeout()
   {
      boolean result = true ;

      // FIXME : TODO : improve function for property in component type
      // FIXME : TODO : check & test this function
      EList<BehaviorTransition> lbt = null ;
      PropertyAssociation dispatchProtocol = null ;
      PropertyAssociation period = null ;
      EList<edu.cmu.sei.aadl.aadl2.PropertyValue> lpv = null ;
      String value = null ;

      if(_ba.isSetTransitions())
      {
         lbt = _ba.getTransitions() ;

         // check dispatch protocol and period property definition
         dispatchProtocol = AadlBaGetProperties.getPropertyAssociation(_baParentContainer, ThreadProperties.DISPATCH_PROTOCOL) ;

         // FIXME : TODO : change the condition test with IsDefineDispatchProtocol
         if(dispatchProtocol != null)
         {
            lpv = AadlBaGetProperties.getPropertyValue(dispatchProtocol) ;

            if(lpv.get(0) instanceof edu.cmu.sei.aadl.aadl2.EnumerationValue)
            {
               value = ((edu.cmu.sei.aadl.aadl2.EnumerationValue) lpv.get(0)).getLiteral().getName() ;
            }

            if(value.equalsIgnoreCase(AadlBaGetProperties.TIMED) || value.equalsIgnoreCase(AadlBaGetProperties.HYBRID))
            {

               period = AadlBaGetProperties.getPropertyAssociation(_baParentContainer, TimingProperties.PERIOD) ;

               if(period == null)
               {
                  result = false ;
                  this.reportSemanticError(lbt.get(0), " the AADL Thread_Properties::Period is not defined" + " : Behavior Annex X.3.(26), X.4.(3) semantic rules failed") ;
               }
            }
         }
      }
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.4 Thread Dispatch Behavior Specification
    * Object : Check semantic rule X.4.(4)
    * Keys : stop, dispatch triggers, execution state, final state
    */
   private boolean checkStopFinalizationTransition()
   {
      boolean result = true ;

      // FIXME : TODO : NYI

      return result ;
   }

   // XXX Same as legality rule X.4.(L12)
   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.4 Thread Dispatch Behavior Specification
    * Object : Check semantic rule X.4.(5)
    * Keys : event data port, dispatch trigger, constant value, others
    */
   private boolean checkEventDataDispatchTriggerAndOthers()
   {
      boolean result = true ;
      boolean hasOthers = false ;

      Identifier id = null ;

      EList<BehaviorTransition> lbt = null ;
      EList<DispatchTrigger> ldt = null ;

      if(_ba.isSetTransitions())
      {
         lbt = _ba.getTransitions() ;

         // get all dispatch triggers
         ldt = AadlBaVisitors.getBehaviorDispatchTriggers(lbt) ;

         if(!ldt.isEmpty())
         {
            for(DispatchTrigger dt : ldt)
            {
               if(dt.isSetValueConstantOwned())
               {
                  id = dt.getIdentifierOwned() ;

                  for(DispatchTrigger dt2 : ldt)
                  {
                     if(dt2.isSetIdentifierOwned() && dt2.getIdentifierOwned().getId().equalsIgnoreCase(id.getId()))
                     {
                        if(dt2.isOthers())
                        {
                           hasOthers = true ;
                        }
                     }
                  }

                  if(!hasOthers)
                  {
                     result = false ;
                     this.reportSemanticError(dt, " event data dispatch trigger has a constant value parameter and no others" + " : Behavior Annex X.4.(5) semantic rule failed") ;
                  }
               }
            }
         }
      }
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.4 Thread Dispatch Behavior Specification
    * Object : Check semantic rule X.4.(6)
    * Keys : numeral, ormore, orless, dispatch trigger
    */
   private boolean checkNumeralOrmoreOrlessInDispatchTriggers()
   {
      boolean result = true ;

      EList<BehaviorTransition> lbt = null ;
      EList<DispatchTrigger> ldt = null ;

      if(_ba.isSetTransitions())
      {
         lbt = _ba.getTransitions() ;

         // get all dispatch triggers
         ldt = AadlBaVisitors.getBehaviorDispatchTriggers(lbt) ;

         if(!ldt.isEmpty())
         {
            for(DispatchTrigger dt : ldt)
            {
               // check if it has numeral
               if(dt.isSetNumeralOwned())
               {
                  if(dt.getNumeralOwned().getNumeralValue() > dt.getDispatchTriggers().size())
                  {
                     result = false ;
                     this.reportSemanticError(dt.getNumeralOwned(), " illegal numeral which is greater than dispatch trigger set" + " : Behavior Annex X.4.(6) semantic rule failed") ;
                  }
               }
            }
         }
      }

      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft 
    * Version : 2.13 
    * Type : Semantic rule
    * Section : X.5 Component Interaction Behavior Specification 
    * Object : Check semantic rule X.5.(13) 
    * Keys : output, in, in out, port, parameter, subprogram classifier
    * subprogram subcomponent, subprogram access, 
    */
   // FIXME : XXX: TODO : GL : Add prototype identifier support
   private boolean checkOutputs()
   {
      boolean result = true ;

      EList<BehaviorTransition> lbt = null ;
      EList<NamedElement> lne = null ;

      if(_ba.isSetTransitions())
      {
         lbt = _ba.getTransitions() ;

         // get output in behavior actions elt!(...)
         lne = AadlBaVisitors.getAllOutputInBehaviorActions(lbt) ;

         for(NamedElement ne : lne)
         {
            // unique subprogram component classifier reference case
            if(ne instanceof UniqueComponentClassifierReference)
            {
               if(!(((UniqueComponentClassifierReference) ne).getAadlReferencedEntity() instanceof edu.cmu.sei.aadl.aadl2.SubprogramClassifier))
               {
                  result = false ;
                  this.reportSemanticError((UniqueComponentClassifierReference) ne, 
                        ((UniqueComponentClassifierReference) ne).getName()
                        + " is not a subprogram classifier reference" 
                        + " : Behavior Annex X.5.(13) semantic rule failed") ;
               }
            }
            else
            {
               if(ne instanceof Name)
               {
                  // case of out port
                  if(((Name) ne).getIdentifier().getAadlReferencedEntity() instanceof edu.cmu.sei.aadl.aadl2.Port)
                  {  
                     edu.cmu.sei.aadl.aadl2.Port p = (Port) ((Name) ne).getIdentifier().getAadlReferencedEntity();

                     if (p.getDirection() != edu.cmu.sei.aadl.aadl2.DirectionType.IN_OUT 
                           && p.getDirection() != edu.cmu.sei.aadl.aadl2.DirectionType.OUT)
                     {
                        result = false ;
                        this.reportSemanticError(ne,
                              ((Name) ne).getIdentifier().getId() 
                              + " is not an out or in out port"
                              + " : Behavior Annex X.5.(13) semantic rule failed");
                     }
                  }
                  // case of out parameter in assignment action
                  else
                     if(((Name) ne).getIdentifier().getAadlReferencedEntity() instanceof edu.cmu.sei.aadl.aadl2.Parameter)
                     {
                        edu.cmu.sei.aadl.aadl2.Parameter p = (edu.cmu.sei.aadl.aadl2.Parameter) ((Name) ne).getIdentifier().getAadlReferencedEntity();

                        if (p.getDirection() != edu.cmu.sei.aadl.aadl2.DirectionType.IN_OUT 
                              && p.getDirection() != edu.cmu.sei.aadl.aadl2.DirectionType.OUT)
                        {
                           result = false ;
                           this.reportSemanticError(ne,
                                 ((Name) ne).getIdentifier().getId() 
                                 + " is not an out or in out parameter"
                                 + " : Behavior Annex X.5.(13) semantic rule failed");
                        }
                     }
                  // case of others components except subprogram subcomponent and subprogram access
                  // FIXME : TODO : XXX : GL : add prototype support
                  else 
                     if(!(((Name) ne).getIdentifier().getAadlReferencedEntity() instanceof edu.cmu.sei.aadl.aadl2.SubprogramSubcomponent) 
                           && !(((Name) ne).getIdentifier().getAadlReferencedEntity() instanceof edu.cmu.sei.aadl.aadl2.SubprogramAccess)
                           && !(((Name) ne).getIdentifier().getAadlReferencedEntity() instanceof edu.cmu.sei.aadl.aadl2.Prototype))
                     {
                        result = false ;
                        this.reportSemanticError(ne, ne.getName() 
                              + " is not a subprogram subcomponent, subprogram access or port" + " : Behavior Annex X.5.(13) semantic rule failed") ;
                     }
               }
            }
         }
      }
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkPorts()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkDataComponents()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkSubprogramComponents()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkActions()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkBasicActions()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkAssignmentActions()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkTimedActions()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   /**
    * Document: AADL Behavior Annex draft Version : 2.13 Type : Semantic rule
    * Section : X. Object : Check semantic rule X. Keys :
    */
   private boolean checkExpressions()
   {
      boolean result = false ;
      // TODO : FIXME : NYI
      return result ;
   }

   // TODO Provide column number.
   private void reportSemanticError(Element obj, String name)
   {
      _errManager.error(obj, "Behavior Semantic Error: " + name + ".") ;
   }

   private void reportSemanticWarning(Element obj, String name)
   {
      _errManager.warning(obj, "Behavior Semantic Warning: " + name + ".") ;
   }
}