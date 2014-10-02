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

package org.osate.ba.unparser ;

import java.util.Iterator ;

import org.eclipse.emf.common.util.AbstractEnumerator ;
import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.Enumerator ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.util.FeatureMap ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.AbstractNamedValue ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.Namespace ;
import org.osate.aadl2.PackageSection ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.modelsupport.AadlConstants ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.parsesupport.AObject ;
import org.osate.aadl2.util.Aadl2Validator ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.Any ;
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorActionSet ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorBooleanLiteral ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorPropertyConstant ;
import org.osate.ba.aadlba.BehaviorRealLiteral ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorStringLiteral ;
import org.osate.ba.aadlba.BehaviorTime ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference ;
import org.osate.ba.aadlba.ClassifierPropertyReference ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;
import org.osate.ba.aadlba.DataComponentReference ;
import org.osate.ba.aadlba.DataSubcomponentHolder ;
import org.osate.ba.aadlba.DispatchCondition ;
import org.osate.ba.aadlba.DispatchConjunction ;
import org.osate.ba.aadlba.DispatchRelativeTimeout ;
import org.osate.ba.aadlba.DispatchTriggerConditionStop ;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression ;
import org.osate.ba.aadlba.ElementHolder ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.ExecutionTimeoutCatch ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.ForOrForAllStatement ;
import org.osate.ba.aadlba.GroupableElement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.IndexableElement ;
import org.osate.ba.aadlba.IntegerRange ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.IterativeVariable ;
import org.osate.ba.aadlba.LockAction ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.LowerBound ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.Otherwise ;
import org.osate.ba.aadlba.PortCountValue ;
import org.osate.ba.aadlba.PortDequeueAction ;
import org.osate.ba.aadlba.PortDequeueValue ;
import org.osate.ba.aadlba.PortFreezeAction ;
import org.osate.ba.aadlba.PortFreshValue ;
import org.osate.ba.aadlba.PortHolder ;
import org.osate.ba.aadlba.PortSendAction ;
import org.osate.ba.aadlba.PropertyElementHolder ;
import org.osate.ba.aadlba.PropertyNameHolder ;
import org.osate.ba.aadlba.PropertySetPropertyReference ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.SharedDataAction ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.TimedAction ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;
import org.osate.ba.aadlba.UnlockAction ;
import org.osate.ba.aadlba.UpperBound ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.aadlba.WhileOrDoUntilStatement ;
import org.osate.ba.aadlba.util.AadlBaSwitch ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.Aadl2Visitors ;
import org.osate.utils.PropertyUtils ;



public class AadlBaUnparser
{

  /**
   * Aadlba switch which overrides methods to process unparsing
   */
  protected AadlBaSwitch<String> aadlbaSwitch = null ;

  /**
   * The unparser buffer
   */
  protected UnparseText aadlbaText ;

  /**
   * 
   */
  protected String DONE = "DONE" ;

  /**
   * List of element from the current model
   */
  protected final EList<Element> resultList = new BasicEList<Element>() ;

  /**
   * Inherits from Osate2 (not used for instance)
   */
  private boolean notCancelled = true ;

  /**
   * Aadlba unparser constructor
   * @param root : annexsubclause root
   * @param indent : indentation position
   */
  public AadlBaUnparser(AnnexSubclause root, String indent)
  {
    //TODO : FIXME : XXX : set indentation position
    aadlbaText = new UnparseText() ;
    this.initSwitches() ;
  }

  public AadlBaUnparser(String indent)
  {
    //TODO : FIXME : XXX : set indentation position
    aadlbaText = new UnparseText() ;
    this.initSwitches() ;
  }

  /**
   * Constructor with default ;
   */
  public AadlBaUnparser()
  {
    //TODO : FIXME : XXX : set indentation position
    aadlbaText = new UnparseText() ;
    this.initSwitches() ;
  }

  /**
   * Calls the package-specific switch
   */
  public final String process(BehaviorElement theElement)
  {
    /**
     * This checks to make sure we only invoke doSwitch with non-null
     * objects This is necessary as some feature retrieval methods may
     * return null
     */
    if(theElement == null)
    {
      return null ;
    }
    
    EClass theEClass = theElement.eClass() ;
    if(aadlbaSwitch != null &&
          theEClass.eContainer() == AadlBaPackage.eINSTANCE)
      aadlbaSwitch.doSwitch(theElement) ;
    else
      System.err.println("aadlba unparsing failed for : " +
        theElement.getClass().getSimpleName()) ;

    return this.getOutput() ;
  }

  /** 
   * This method checks notCancelled() after each element in the
   * list, and terminates the processing if the traversal has been cancelled.
   */
  public final EList<Element> processEList(final EList<? extends BehaviorElement> list)
  {
    for(Iterator<? extends BehaviorElement> it = list.iterator() ; notCancelled &&
          it.hasNext() ;)
    {
      this.process(it.next()) ;
    }
    return resultList ;
  }

  /**
   * Does processing of list with separators
   * 
   * @param list
   * @param separator
   */
  @SuppressWarnings("rawtypes")
  public void processEList(EList list,
                           String separator)
  {
    boolean first = true ;
    for(Iterator it = list.iterator() ; it.hasNext() ;)
    {
      if(!first)
      {
        if(separator == AadlConstants.newlineChar)
        {
          aadlbaText.addOutputNewline(AadlConstants.emptyString) ;
        }
        else
        {
          aadlbaText.addOutput(separator) ;
        }
      }
      first = false ;
      Object o = it.next() ;
      if(o instanceof FeatureMap.Entry)
      {
        o = ((FeatureMap.Entry) o).getValue() ;
      }
      if(o instanceof AObject)
        this.process((BehaviorElement) o) ;
      else if(o instanceof AbstractEnumerator)
        aadlbaText.addOutput(((AbstractEnumerator) o).getName().toLowerCase()) ;
      else
        aadlbaText.addOutput("processEList: oh my, oh my!!") ;
    }
  }

  /**
   * Unparse comment
   * 
   * @param obj
   */
  /*private void processComments(final Element obj) {
    if (obj != null) {
      EList el = obj.getOwnedComments();
      for (Iterator it = el.iterator(); it.hasNext();) {
        String comment = ((Comment) it.next()).getBody();
        if (!comment.startsWith("--") && !comment.startsWith("/*")) {
          comment = "--" + (comment.charAt(0) == ' ' ? "" : " ") + comment;
        } else if (comment.startsWith("/*")) {
          comment = comment.substring(2, comment.length() - 2);
          comment = "--" + (comment.charAt(0) == ' ' ? "" : " ") + comment;
          comment = comment.replaceAll("\n", "\n--");
        }
        aadlbaText.addOutputNewline(comment);
      }
    }
  }*/

  /**
   * Returns the unparsed output as a single String
   * 
   * @return String
   */
  public String getOutput()
  {
    return aadlbaText.getParseOutput() ;
  }

  /**
   * Specific aadlba switch to unparse components
   */
  protected void initSwitches()
  {

    aadlbaSwitch = new AadlBaSwitch<String>()
    {

      /**
       * Top-level method to unparse "behavior_specification" 
       * annexsubclause
       */
      public String caseAnnexSubclause(AnnexSubclause object)
      {
        //FIXME : TODO : update location reference
        process((BehaviorAnnex) object) ;
        return DONE ;
      }

      /**
       * Unparse behaviorannex
       */
      public String caseBehaviorAnnex(BehaviorAnnex object)
      {
        //FIXME : TODO : update location reference
        if(object.isSetVariables())
        {
          aadlbaText.addOutputNewline("variables") ;
          aadlbaText.incrementIndent() ;
          processEList(object.getVariables()) ;
          aadlbaText.decrementIndent() ;
        }
        if(object.isSetStates())
        {
          aadlbaText.addOutputNewline("states") ;
          aadlbaText.incrementIndent() ;
          processEList(object.getStates()) ;
          aadlbaText.decrementIndent() ;
        }
        if(object.isSetTransitions())
        {
          aadlbaText.addOutputNewline("transitions") ;
          aadlbaText.incrementIndent() ;
          processEList(object.getTransitions()) ;
          aadlbaText.decrementIndent() ;

        }
        return DONE ;
      }

      /**
       * Unparse behaviorvariable
       */
      public String caseBehaviorVariable(BehaviorVariable object)
      {
        //FIXME : TODO : update location reference
        aadlbaText.addOutput(object.getName()) ;

        for(ArrayDimension ad : object.getArrayDimensions())
        {
          aadlbaText.addOutput("[") ;
          aadlbaText.addOutput(Long.toString(ad.getSize().getSize())) ;
          aadlbaText.addOutput("]") ;
        }

        aadlbaText.addOutput(" : ") ;
        aadlbaText.addOutput(object.getDataClassifier().getQualifiedName()) ;
        aadlbaText.addOutputNewline(" ;") ;
        return DONE ;
      }

      /**
       * Unparse behaviorstate
       */
      public String caseBehaviorState(BehaviorState object)
      {
        //FIXME : TODO : update location reference
        aadlbaText.addOutput(object.getName()) ;
        aadlbaText.addOutput(" : ") ;
        if(object.isInitial())
          aadlbaText.addOutput("initial ") ;
        if(object.isComplete())
          aadlbaText.addOutput("complete ") ;
        if(object.isFinal())
          aadlbaText.addOutput("final ") ;
        aadlbaText.addOutputNewline("state ;") ;
        return DONE ;
      }

      /**
       * Unparse behaviortransition
       */
      public String caseBehaviorTransition(BehaviorTransition object)
      {
        //FIXME : TODO : update location reference
        String tid = object.getName() ;
        Long num = object.getPriority() ;
        if(tid != null)
        {
          aadlbaText.addOutput(tid) ;
          if(num != AadlBaVisitors.DEFAULT_TRANSITION_PRIORITY)
          {// numeral
            aadlbaText.addOutput(" [") ;
            aadlbaText.addOutput(String.valueOf(num)) ;
            aadlbaText.addOutput("]") ;
          }
          aadlbaText.addOutput(" : ") ;
        }
        aadlbaText.addOutput(object.getSourceState().getName()) ;
        aadlbaText.addOutput(" -[") ;
        process(object.getCondition()) ;
        aadlbaText.addOutput("]-> ") ;
        aadlbaText.addOutput(object.getDestinationState().getName()) ;
        if(object.getActionBlock() != null)
        {
          aadlbaText.addOutput(" ") ;
          process(object.getActionBlock()) ;
        }
        aadlbaText.addOutputNewline(" ;") ;

        return DONE ;
      }

      public String caseExecutionTimeoutCatch(ExecutionTimeoutCatch object)
      {
        aadlbaText.addOutput("timeout") ;
        return DONE ;
      }

      public String caseOtherwise(Otherwise object)
      {
        aadlbaText.addOutput("otherwise") ;
        return DONE ;
      }

      /**
       * Unparse dispatchcondition
       */
      public String caseDispatchCondition(DispatchCondition object)
      {
        //FIXME : TODO : update location reference
        aadlbaText.addOutput("on dispatch") ;
        if(object.getDispatchTriggerCondition() != null)
        {
          aadlbaText.addOutput(" ") ;
          process(object.getDispatchTriggerCondition()) ;
        }

        if(object.isSetFrozenPorts())
        {
          aadlbaText.addOutput(" frozen ") ;
          processEList(object.getFrozenPorts(), ", ") ;
        }

        return DONE ;
      }

      public String caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
      {
        aadlbaText.addOutput("stop") ;
        return DONE ;
      }

      public String caseDispatchRelativeTimeout(DispatchRelativeTimeout object)
      {
        aadlbaText.addOutput("timeout ") ;
        return DONE ;
      }
      
      public String caseCompletionRelativeTimeout(CompletionRelativeTimeout object)
      {
        aadlbaText.addOutput("timeout ") ;
        caseBehaviorTime(object) ;
        return DONE ;
      }

      public String caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
      {

        processEList(object.getDispatchConjunctions(), " or ") ;
        return DONE ;
      }

      public String caseDispatchConjunction(DispatchConjunction object)
      {
        processEList(object.getDispatchTriggers(), " and ") ;
        return DONE ;
      }

      public String caseBehaviorActionBlock(BehaviorActionBlock object)
      {
        aadlbaText.addOutput("{") ;
        process(object.getContent()) ;
        if(object.getTimeout() != null)
        {
          aadlbaText.addOutput(" timeout ") ;
          process(object.getTimeout()) ;
        }
        aadlbaText.addOutput("}") ;
        return DONE ;
      }

      public String caseBehaviorActionSequence(BehaviorActionSequence object)
      {
        processEList(object.getActions(), " ;\n") ;
        return DONE ;
      }

      public String caseBehaviorActionSet(BehaviorActionSet object)
      {
        processEList(object.getActions(), " &\n") ;
        return DONE ;
      }

      /**
       * Unparse ifstatement
       */
      public String caseIfStatement(IfStatement object)
      {
        //FIXME : TODO : update location reference
        
        boolean hasToOutputTerminator = true ;
        
        if(object.isElif())
        {
          aadlbaText.addOutput(" elsif (") ;
          hasToOutputTerminator = false ;
        }
        else
        {
          aadlbaText.addOutput("if (") ;
          hasToOutputTerminator = true ;
        }
        
        process(object.getLogicalValueExpression()) ;
        aadlbaText.addOutput(") ") ;
        
        process(object.getBehaviorActions()) ;
        
        if(object.getElseStatement() != null)
        {
          process(object.getElseStatement()) ;
        }
        
        if(hasToOutputTerminator)
        {
          aadlbaText.addOutputNewline(" end if") ;
        }

        return DONE ;
      }
      
      public String caseElseStatement(ElseStatement object)
      {
        aadlbaText.addOutput(" else ") ;
        process(object.getBehaviorActions()) ;        
        return DONE ;
      }

      /**
       * Unparse fororforallstatement
       */
      public String caseForOrForAllStatement(ForOrForAllStatement object)
      {
        //FIXME : TODO : update location reference
        if(object.isForAll())
        {
          aadlbaText.addOutput("forall (") ;
        }
        else
        {
          aadlbaText.addOutput("for (") ;
        }
        
        process(object.getIterativeVariable()) ;
        aadlbaText.addOutput(" in ") ;
        process(object.getIteratedValues()) ;
        aadlbaText.addOutputNewline(")") ;
        aadlbaText.addOutputNewline("{") ;
        aadlbaText.incrementIndent() ;
        process(object.getBehaviorActions()) ;
        aadlbaText.decrementIndent() ;
        aadlbaText.addOutputNewline("") ;
        aadlbaText.addOutputNewline("}") ;
        return DONE ;
      }
      
      public String caseIterativeVariable(IterativeVariable iv)
      {
        aadlbaText.addOutput(iv.getName()) ;
        aadlbaText.addOutput(" : ") ;
        aadlbaText.addOutput(iv.getDataClassifier().getName()) ;
        
        return DONE ;
      }

      public String caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object)
      {
        if(object.isDoUntil())
          return caseDoUntilStatement(object) ;
        else
          return caseWhileStatement(object) ;
      }

      /**
       * Unparse whilestatement
       */

      public String caseWhileStatement(WhileOrDoUntilStatement object)
      {
        //FIXME : TODO : update location reference
        aadlbaText.addOutput("while (") ;
        process(object.getLogicalValueExpression()) ;
        aadlbaText.addOutputNewline(")") ;
        aadlbaText.addOutputNewline("{") ;
        aadlbaText.incrementIndent() ;
        process(object.getBehaviorActions()) ;
        aadlbaText.decrementIndent() ;
        aadlbaText.addOutputNewline("") ;
        aadlbaText.addOutputNewline("}") ;
        return DONE ;
      }

      /**
       * Unparse dountilstatement
       */
      public String caseDoUntilStatement(WhileOrDoUntilStatement object)
      {
        //FIXME : TODO : update location reference
        aadlbaText.addOutputNewline("do") ;
        process(object.getBehaviorActions()) ;
        aadlbaText.addOutputNewline("") ;
        aadlbaText.addOutput("until (") ;
        process(object.getLogicalValueExpression()) ;
        aadlbaText.addOutputNewline(")") ;
        return DONE ;
      }

      /**
       * Unparse integerrange
       */
      public String caseIntegerRange(IntegerRange object)
      {
        //FIXME : TODO : update location reference
        process(object.getLowerIntegerValue()) ;
        aadlbaText.addOutput(" .. ") ;
        process(object.getUpperIntegerValue()) ;
        return DONE ;
      }

      /**
       * Unparse timedaction
       */
      public String caseTimedAction(TimedAction object)
      {
        aadlbaText.addOutput("computation (") ;
        process(object.getLowerTime()) ;
        if(object.getUpperTime() != null)
        {
          aadlbaText.addOutput(" .. ") ;
          process(object.getUpperTime()) ;
        }
        aadlbaText.addOutput(")") ;
        return DONE ;
      }

      /**
       * Unparse assignmentaction
       */
      public String caseAssignmentAction(AssignmentAction object)
      {
        //FIXME : TODO : update location reference
        process(object.getTarget()) ;
        aadlbaText.addOutput(" := ") ;
        process(object.getValueExpression()) ;
        return DONE ;
      }
      
      public String caseAny(Any object)
      {
        aadlbaText.addOutput("any") ;
        return DONE ;
      }
      
      public String caseElementHolder(ElementHolder el)
      {
        Element refContainer = Aadl2Visitors.getContainingPackageSection(el.getElement());
        Element holderPackageOrPropertySet = Aadl2Visitors.getContainingPackageSection(el);
        if(refContainer!=null && holderPackageOrPropertySet!=null &&
              false==holderPackageOrPropertySet.equals(refContainer)
              && false==(el instanceof DataSubcomponentHolder))
        {
          StringBuilder sb = new StringBuilder(el.getElement().getQualifiedName());
          String prefix=sb.substring(0, sb.lastIndexOf("::")+2);
          aadlbaText.addOutput(prefix);
        }
      
        if(el instanceof GroupableElement)
        {
          GroupableElement ge = (GroupableElement) el ;
          if(ge.isSetGroupHolders())
          {
            processEList(ge.getGroupHolders(), ".") ;
            aadlbaText.addOutput(".") ;
          }
        }
        
        aadlbaText.addOutput(el.getElement().getName()) ;
        
        if(el instanceof IndexableElement)
        {
          IndexableElement ie = (IndexableElement) el ;
          
          if(ie.isSetArrayIndexes())
          {
            caseArrayIndex(ie.getArrayIndexes()) ;
          }
        }
        
        return DONE ;
      }
      
      /**
       * Unparse arrayindex
       */
      public String caseArrayIndex(EList<IntegerValue> object)
      {
        //FIXME : TODO : update location reference
        for(IntegerValue iv : object)
        {
          aadlbaText.addOutput("[") ;
          process(iv) ;
          aadlbaText.addOutput("]") ;
        }
        return DONE ;
      }

      /**
       * Unparse datacomponentreference
       */
      public String caseDataComponentReference(DataComponentReference object)
      {
        //FIXME : TODO : update location reference
        processEList(object.getData(), ".") ;
        return DONE ;
      }

      public String caseSubprogramCallAction(SubprogramCallAction object)
      {
        if(object.getProxy() != null)
        {
          process(object.getProxy()) ;
          aadlbaText.addOutput(".") ;
        }
        
        process(object.getSubprogram()) ;
        aadlbaText.addOutput(" !") ;

        if(object.isSetParameterLabels())
        {
          aadlbaText.addOutput(" (") ;
          processEList(object.getParameterLabels(), ", ") ;
          aadlbaText.addOutput(")") ;
        }
        return DONE ;
      }

      public String casePortSendAction(PortSendAction object)
      {
        process(object.getPort()) ;
        aadlbaText.addOutput(" !") ;

        if(object.getValueExpression() != null)
        {
          aadlbaText.addOutput(" (") ;
          process(object.getValueExpression()) ;
          aadlbaText.addOutput(")") ;
        }
        return DONE ;
      }

      public String casePortFreezeAction(PortFreezeAction object)
      {
        return casePortActionOrValue(object, " >>") ;
      }

      public String casePortDequeueAction(PortDequeueAction object)
      {
        process(object.getPort()) ;
        aadlbaText.addOutput(" ?") ;
        if(object.getTarget() != null)
        {
          aadlbaText.addOutput(" (") ;
          process(object.getTarget()) ;
          aadlbaText.addOutput(")") ;
        }
        return DONE ;
      }

      public String caseLockAction(LockAction object)
      {
        return caseSharedDataAction(object, "!<") ;
      }

      public String caseUnlockAction(UnlockAction object)
      {
        return caseSharedDataAction(object, "!>") ;
      }

      public String caseSharedDataAction(SharedDataAction object,
                                         String token)
      {
        if(object.getDataAccess() != null)
        {
          process(object.getDataAccess()) ;
          aadlbaText.addOutput(" ") ;
        }
        else
          aadlbaText.addOutput("*") ;

        aadlbaText.addOutput(token) ;
        return DONE ;
      }

      /**
       * Unparse behaviortime
       */
      public String caseBehaviorTime(BehaviorTime object)
      {
        //FIXME : TODO : update location reference
        process(object.getIntegerValue()) ;
        aadlbaText.addOutput(" ") ;
        aadlbaText.addOutput(object.getUnit().getName()) ;
        return DONE ;
      }

      public String casePortDequeueValue(PortDequeueValue object)
      {
        return casePortActionOrValue(object, " ?") ;
      }

      public String casePortCountValue(PortCountValue object)
      {
        return casePortActionOrValue(object, "' count") ;
      }

      public String casePortFreshValue(PortFreshValue object)
      {
        return casePortActionOrValue(object, "' fresh") ;
      }

      public String casePortActionOrValue(PortHolder object,
                                          String token)
      {
        caseElementHolder(object) ;
        aadlbaText.addOutput(token) ;
        return DONE ;
      }

      /**
       * Unparse booleanliteral
       */
      public String caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
      {
        //FIXME : TODO : update location reference
        if(object.isValue())
          aadlbaText.addOutput("true") ;
        else
          aadlbaText.addOutput("false") ;
        return DONE ;
      }

      /**
       * Unparse stringliteral
       */
      public String caseBehaviorStringLiteral(BehaviorStringLiteral object)
      {
        //FIXME : TODO : update location reference
        aadlbaText.addOutput(object.getValue()) ;
        return DONE ;
      }

      public String caseBehaviorRealLiteral(BehaviorRealLiteral object)
      {
        aadlbaText.addOutput(String.valueOf(object.getValue())) ;
        return DONE ;
      }

      public String caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
      {
        aadlbaText.addOutput(Long.toString(object.getValue())) ;
        return DONE ;
      }

      /**
       * Unparse valueexpression
       */
      public String caseValueExpression(ValueExpression object)
      {
        //FIXME : TODO : update location reference
        Iterator<Relation> itRel = object.getRelations().iterator() ;
        process(itRel.next()) ;

        if(object.isSetLogicalOperators())
        {
          Iterator<LogicalOperator> itOp =
                object.getLogicalOperators().iterator() ;
          while(itRel.hasNext())
          {
            LogicalOperator lo = itOp.next();
            if(lo!=LogicalOperator.NONE)
              aadlbaText.addOutput(" " + lo.getLiteral() + " ") ;
            process(itRel.next()) ;
          }
        }
        return DONE ;
      }

      /**
       * Unparse relation
       */
      public String caseRelation(Relation object)
      {
        //FIXME : TODO : update location reference
        process(object.getFirstExpression()) ;
        if(object.getSecondExpression() != null)
        {
          if(object.getRelationalOperator()!=RelationalOperator.NONE)
            aadlbaText.addOutput(" " +
                  object.getRelationalOperator().getLiteral() + " ") ;
          process(object.getSecondExpression()) ;
        }
        return DONE ;
      }

      /**
       * Unparse simpleexpression
       */
      public String caseSimpleExpression(SimpleExpression object)
      {
        //FIXME : TODO : update location reference
        if(object.isSetUnaryAddingOperator() && object.getUnaryAddingOperator()!=UnaryAddingOperator.NONE)
          aadlbaText.addOutput(object.getUnaryAddingOperator()
                .getLiteral()) ;

        Iterator<Term> itTerm = object.getTerms().iterator() ;

        process(itTerm.next()) ;

        if(object.isSetBinaryAddingOperators())
        {
          Iterator<BinaryAddingOperator> itOp =
                object.getBinaryAddingOperators().iterator() ;
          while(itTerm.hasNext())
          {
            BinaryAddingOperator bao = itOp.next(); 
            if(bao!=BinaryAddingOperator.NONE)
              aadlbaText.addOutput(" " + bao.getLiteral() + " ") ;
            process(itTerm.next()) ;
          }
        }

        return DONE ;
      }

      /**
       * Unparse term
       */
      public String caseTerm(Term object)
      {
        //FIXME : TODO : update location reference
        Iterator<Factor> itFact = object.getFactors().iterator() ;

        process(itFact.next()) ;

        if(object.isSetMultiplyingOperators())
        {
          Iterator<MultiplyingOperator> itOp =
                object.getMultiplyingOperators().iterator() ;
          while(itFact.hasNext())
          {
            MultiplyingOperator mo = itOp.next();
            if(mo!=MultiplyingOperator.NONE)
              aadlbaText.addOutput(" " + mo.getLiteral() + " ") ;
            process(itFact.next()) ;
          }
        }
        return DONE ;
      }

      /**
       * Unparse factor
       */
      public String caseFactor(Factor object)
      {
        //FIXME : TODO : update location reference
        if(object.isSetUnaryNumericOperator()  ||
              object.isSetUnaryBooleanOperator() )
        {
          Enumerator e = null ;
          if(object.isSetUnaryNumericOperator())
          {
            e = object.getUnaryNumericOperator() ;
            if(e!=UnaryNumericOperator.NONE)
              aadlbaText.addOutput(e.getLiteral() + " ") ;
          }
          else if(object.isSetUnaryBooleanOperator())
          {
            e = object.getUnaryBooleanOperator() ;
            if(e!=UnaryBooleanOperator.NONE)
              aadlbaText.addOutput(e.getLiteral() + " ") ;
          }
          
        }

        if(object.getFirstValue() instanceof ValueExpression)
        {
          aadlbaText.addOutput("(") ;
          process(object.getFirstValue()) ;
          aadlbaText.addOutput(")") ;
        }
        else
        {
          process(object.getFirstValue()) ;
        }

        if(object.isSetBinaryNumericOperator())
        {
          BinaryNumericOperator bno = object.getBinaryNumericOperator();
          if(bno!=BinaryNumericOperator.NONE)
            aadlbaText.addOutput(" " +
                  bno.getLiteral() + " ") ;
          if(object.getSecondValue() instanceof ValueExpression)
          {
            aadlbaText.addOutput("(") ;
            process(object.getSecondValue()) ;
            aadlbaText.addOutput(")") ;
          }
          else
          {
            process(object.getSecondValue()) ;
          }
        }
        return DONE ;
      }
      
      public String caseBehaviorPropertyConstant(BehaviorPropertyConstant object)
      {
        aadlbaText.addOutput("#");
        
        if(object.getPropertySet() != null)
        {
          aadlbaText.addOutput(object.getPropertySet().getQualifiedName());
          aadlbaText.addOutput("::");
        }
        
        aadlbaText.addOutput(object.getProperty().getName());
        
        return DONE ;
      }
      
      public String casePropertySetPropertyReference(PropertySetPropertyReference object)
      {
        aadlbaText.addOutput("#");
        
        if(object.getPropertySet() != null)
        {
          aadlbaText.addOutput(object.getPropertySet().getQualifiedName());
          aadlbaText.addOutput("::");
        }
        
        processEList(object.getProperties(), ".") ;
        
        return DONE ;
      }

      public String caseClassifierPropertyReference(ClassifierPropertyReference object)
      {
        org.osate.aadl2.Classifier c = object.getClassifier() ;
        
        String toAdd = null ;
        
        String classifierPackageName = c.getElementRoot().getName() ;
        
        String propertyRefPackageName = object.getElementRoot().getName() ;
        
        if(false == classifierPackageName.equalsIgnoreCase(propertyRefPackageName))
        {
          toAdd = c.getQualifiedName() ;
        }
        else
        {
          toAdd = c.getName() ;
        }
        
        aadlbaText.addOutput(toAdd) ;
        aadlbaText.addOutput("#");
        processEList(object.getProperties(), ".") ;
        return DONE ;
      }
      
      public String caseClassifierFeaturePropertyReference(ClassifierFeaturePropertyReference object)
      {
        process(object.getComponent()) ;
        aadlbaText.addOutput("#");
        processEList(object.getProperties(), ".") ;
        return DONE ;
      }
      
      public String casePropertyNameHolder(PropertyNameHolder pnh)
      {
        PropertyElementHolder peh = pnh.getProperty() ;
        Element el = peh.getElement() ;
        
        if(el instanceof NamedElement)
        {
          aadlbaText.addOutput(((NamedElement)el).getName());
        }
        else if(el instanceof PropertyAssociation)
        {
          aadlbaText.addOutput(((PropertyAssociation)el).getProperty().getName()) ;
        }
        else
        {
          String tmp = unparse((PropertyExpression) el) ;
          aadlbaText.addOutput(tmp);
        }
        
        if(pnh.isSetField())
        {
          aadlbaText.addOutput(".") ;
          process(pnh.getField()) ;
        }
        else if(peh.isSetArrayIndexes())
        {
          caseArrayIndex(peh.getArrayIndexes()) ;
        }
          
        return DONE ;
      }
      
      public String caseUpperBound(UpperBound object)
      {
        aadlbaText.addOutput("upper_bound");
        return DONE ;
      }
      
      public String caseLowerBound(LowerBound object)
      {
        aadlbaText.addOutput("lower_bound");
        return DONE ;
      }
    } ;
  }
  
  // This is very specific to AADL BA. It cannot be used elsewhere.
  private static String unparse(PropertyExpression pe)
  {
    int type = pe.eClass().getClassifierID() ;
    String result = "" ;
    
    switch(type)
    {
      case Aadl2Package.STRING_LITERAL:
      {
        result = ((StringLiteral)pe).getValue() ; break;
      }
      
      case Aadl2Package.LIST_VALUE:
      case Aadl2Package.REAL_LITERAL:
      case Aadl2Package.BOOLEAN_LITERAL:
      case Aadl2Package.NUMBER_VALUE:
      case Aadl2Package.INTEGER_LITERAL:
      case Aadl2Package.RECORD_VALUE:
      case Aadl2Package.RANGE_VALUE:
      {
        BasicProperty container = PropertyUtils.getContainingProperty(pe) ;
        result = container.getName() ;
        break ;
      }
      
      case Aadl2Package.NAMED_VALUE:
      {
        NamedValue nv = (NamedValue) pe ;
        AbstractNamedValue anv = nv.getNamedValue() ;
        if(anv instanceof PropertyExpression)
        {
          result = unparse((PropertyExpression) anv) ;
        }
        else if(anv instanceof EnumerationLiteral)
        {
          BasicProperty container = PropertyUtils.getContainingProperty(pe) ;
          result = container.getName() ;
          break ;
        }
        else
        {
          String msg = anv.getClass().getSimpleName() + " is not supported (in NamedValue)" ;
          System.err.println(msg) ;
          throw new UnsupportedOperationException(msg) ;
        }
        
        break ;
      }
      
      default:
      {
        String msg = "unparsing " + pe.getClass().getSimpleName() +
                     " is not supported yet" ;
        System.err.println(msg);
        throw new UnsupportedOperationException(msg) ;
      }
    }
    
    return result ;
  }
}