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
import java.util.Comparator ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;
import java.util.WeakHashMap ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.DeviceClassifier ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.MetaclassReference ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.PackageSection ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.ThreadClassifier ;
import org.osate.aadl2.VirtualProcessorClassifier ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.BasicAction ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionCollection ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTime ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.BehaviorVariableHolder ;
import org.osate.ba.aadlba.CompletionRelativeTimeout ;
import org.osate.ba.aadlba.DispatchCondition ;
import org.osate.ba.aadlba.DispatchRelativeTimeout ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.LoopStatement ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.TimedAction ;
import org.osate.ba.declarative.DeclarativeBehaviorTransition ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.Aadl2Visitors ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.names.DispatchTriggerProperties ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;
import org.osate.xtext.aadl2.properties.util.ThreadProperties ;
import org.osate.xtext.aadl2.properties.util.TimingProperties ;

@SuppressWarnings("unused")
public class AadlBaLegalityRulesChecker
{
  private BehaviorAnnex _ba ;
  private ComponentClassifier _baParentContainer ;
  private AnalysisErrorReporterManager _errManager ;
  private final static String LIST_SEPARATOR =", " ;

  private Map<BehaviorState, BehaviorTransition> _alreadyFoundCompletionRelativeTimeoutConditionCatchTransition =
                                                                                                                new WeakHashMap<BehaviorState, BehaviorTransition>() ;
  private Map<BehaviorState, BehaviorTransition> _alreadyFoundDispatchRelativeTimeoutTransition =
                                                                                                new WeakHashMap<BehaviorState, BehaviorTransition>() ;
  private List<BehaviorTransition> _alreadyReportedErroneousTransition =
        new ArrayList<BehaviorTransition>();
  public AadlBaLegalityRulesChecker(BehaviorAnnex ba,
                                    AnalysisErrorReporterManager errManager)
  {
    _ba = ba ;
    _errManager = errManager ;
    _baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rules D.3.(L1), D.3.(L2)
   * Keys : subprogram components initial complete final states
   */
  public boolean D_3_L1_And_L2_Check (EList<BehaviorState> initialStates,
                                      EList<BehaviorState> completeStates,
                                      EList<BehaviorState> finalStates)
  {
    boolean result = true ;

    if(_baParentContainer instanceof SubprogramClassifier)
    {
      String reportElements = null ;

      if(initialStates.size() > 1)
      {
        result = false ;
        reportElements = AadlBaUtils.identifierListToString(initialStates,
                                                            LIST_SEPARATOR);
        this.reportLegalityError(_ba, _baParentContainer.getQualifiedName() +
                                 " can't have more than one initial state : " + reportElements +
              " : Behavior Annex D.3.(L1) legality rule failed") ;
      }
      else
        if(initialStates.size() == 0)
        {
          result = false ;
          this.reportLegalityError(_ba,
                                   _baParentContainer.getQualifiedName() + " has no initial" +
                "state : Behavior Annex D.3.(L1) legality rule failed") ;
        }

      if(completeStates.size() > 0)
      {
        result = false ;
        reportElements = AadlBaUtils.identifierListToString(completeStates,
                                                            LIST_SEPARATOR) ;
        this.reportLegalityError(_ba, _baParentContainer.getQualifiedName() +
                                 " can't have complete state : " + reportElements +
              " : Behavior Annex D.3.(L2) legality rule failed") ;
      }

      if(finalStates.size() > 1)
      {
        result = false ;
        reportElements = AadlBaUtils.identifierListToString(finalStates,
                                                            LIST_SEPARATOR) ;
        this.reportLegalityError(_ba, _baParentContainer.getQualifiedName() +
                                 " has more than one final state : " + reportElements +
              " : Behavior Annex D.3.(L1) legality rule failed") ;
      }
      else
      {
        if(finalStates.size() == 0)
        {
          result = false ;
          this.reportLegalityError(_ba,
                                   _baParentContainer.getQualifiedName() + " has no final " +
                "state : Behavior Annex D.3.(L1) legality rule failed") ;
        }
      }
    } // End of first if.

    return result ;
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rule D.3.(L3)
   * Keys : threads, suspendable devices initial complete states
   */
  public boolean D_3_L3_Check (EList<BehaviorState> initialStates,
                               EList<BehaviorState> completeStates)
  {
    boolean result = true ;

    if(_baParentContainer instanceof ThreadClassifier ||
          _baParentContainer instanceof DeviceClassifier ||
          _baParentContainer instanceof VirtualProcessorClassifier)
    {
      String reportElements = null ;

      if(initialStates.size() > 1)
      {
        result = false ;
        reportElements = AadlBaUtils.identifierListToString(initialStates,
                                                            LIST_SEPARATOR) ;
        this.reportLegalityError(_ba, _baParentContainer.getQualifiedName() +
                                 " can't have more than one initial state : " + reportElements +
              " : Behavior Annex D.3.(L3) legality rule failed") ;
      }
      else
        if(initialStates.size() == 0)
        {
          result = false ;
          this.reportLegalityError(_ba, _baParentContainer.getQualifiedName()+
                                   " has no initial state : " +
                "Behavior Annex D.3.(L3) legality rule failed") ;
        }

      if(completeStates.size() == 0)
      {
        result = false ;
        this.reportLegalityError(_ba, _baParentContainer.getQualifiedName() +
                                 " has no complete state : " +
              "Behavior Annex D.3.(L3) legality rule failed") ;
      }
    }

    return result ;
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rule D.3.(L4)
   * Keys : threads, components initialization finalization entrypoints initial
   * final states
   */
  // Suspended legality rule checking: need standard improvement.
  public boolean D_3_L4_Check (EList<BehaviorState> initialStates,
                               EList<BehaviorState> finalStates)
  {
    boolean result = true ;
    /*
      // As the user can add component which have initialization and finalization
      // entrypoints, fetches the component list.

      PackageSection[] contextsTab =AadlBaVisitors.getBaPackageSections(_ba);

      PropertiesLinkingService pls = new PropertiesLinkingService() ;

      EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();

      EObject ne=pls.findNamedElementInPredeclaredPropertySets(
                             AadlBaVisitors.INITIALIZE_ENTRYPOINT_PROPERTY_NAME,
                             contextsTab[0], reference);
      if(ne==null)
      {
        PropertySet ps = pls.findPropertySet(contextsTab[0],
                              AadlBaVisitors.INITIALIZE_ENTRYPOINT_PROPERTYSET);
        if(ps!=null)
          ne = ps.findNamedElement(AadlBaVisitors.
                                      INITIALIZE_ENTRYPOINT_PROPERTY_NAME);
      }

      ArrayList<Class<? extends org.osate.aadl2.Element>> klassl =
         new ArrayList<Class<? extends org.osate.aadl2.Element>>() ;

      Class<? extends org.osate.aadl2.Element> klass ;

      StringBuilder klassName = new StringBuilder();

      String firstChar ;
      int firstCharIndex ;

      if (ne != null)
      {
    	  EList<PropertyOwner> pol = ((Property) ne).getAppliesTos() ;
    	  // For each component that the initialize entrypoint property is applied
          // to, gets the component's name and transform into the corresponding
          // class name and populates the class list.
          for (PropertyOwner p : pol)
          {
             klassName.append(AadlBaVisitors.SEI_AADL2_PACKAGE_NAME);
             klassName.append('.');

             firstCharIndex = klassName.length() ;

             klassName.append(((MetaclassReference) p).getMetaclass().getName()) ;

             firstChar = klassName.substring(firstCharIndex, firstCharIndex+1) ;

             // Transform the first char of the property name to upper case.
             firstChar.toUpperCase() ;

             klassName.setCharAt(firstCharIndex, firstChar.charAt(0)) ;

             klassName.append(AadlBaVisitors.SEI_AADL2_CLASSIFIER_SUFFIX);

             try
             {
                klass = (Class<? extends org.osate.aadl2.Element>)
                            Class.forName(klassName.toString()) ;

                klassl.add(klass);
             }
             catch (java.lang.ClassNotFoundException e)
             {
                continue ;
             }
             finally
             {
                klassName.setLength(0) ;
             }
          }

          // Checks the rule for the given component list.
          for(Class<? extends org.osate.aadl2.Element> tmp : klassl)
          {
             if(tmp.isAssignableFrom(_baParentContainer.getClass()))
             {
                String reportElements = null ;

                if(initialStates.size() > 1)
                {
                   result = false ;
                   reportElements = AadlBaUtils.identifierListToString(initialStates,
                                                                   LIST_SEPARATOR) ;
                   this.reportLegalityError(_ba, _baParentContainer.getQualifiedName()
                         + " can't have more than one initial state : " +
                           reportElements +
                             " : Behavior Annex D.3.(L4) legality rule failed") ;
                }
                else
                   if(initialStates.size() == 0)
                   {
                      result = false ;
                      this.reportLegalityWarning(_ba, _baParentContainer.
                                                              getQualifiedName()
                            + " has no initial state : " +
                              "Behavior Annex D.3.(L4) legality rule warning") ;
                   }

                if(finalStates.size() == 0)
                {
                   result = false ;
                   this.reportLegalityWarning(_ba,
                      _baParentContainer.getQualifiedName() +
                         " has no final state : Behavior Annex D.3.(L4)"+
                            " legality rules warning") ;
                }

                return result ;
             }
          }
      }
      else
      {
    	  String reportElements = null ;

          if(initialStates.size() > 1)
          {
             result = false ;
             reportElements = AadlBaUtils.identifierListToString(initialStates,
                                                             LIST_SEPARATOR) ;
             this.reportLegalityError(_ba, _baParentContainer.getQualifiedName()
                   + " can't have more than one initial state : " +
                     reportElements +
                       " : Behavior Annex D.3.(L4) legality rule failed") ;
          }
          else
             if(initialStates.size() == 0)
             {
                result = false ;
                this.reportLegalityWarning(_ba, _baParentContainer.getQualifiedName()
                      + " has no initial state : " +
                        "Behavior Annex D.3.(L4) legality rule failed") ;
             }

          if(finalStates.size() == 0)
          {
             result = false ;
             this.reportLegalityWarning(_ba,
                _baParentContainer.getQualifiedName() +
                   " has no final state : Behavior Annex D.3.(L4)"+
                      " legality rules failed") ;
          }

          return result ;
      }
     */
    return result ;
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rule D.3.(L5)
   * Keys : subprogram dispatch condition transition
   */
  public boolean D_3_L5_Check(DispatchCondition dc)
  {
    boolean canBeDispatched = false;
    // Only accept dispatch conditions on components for which a Dispatch_Protocl can be associated
    PackageSection[] contextsTab =AadlBaVisitors.getBaPackageSections(_ba);
    PropertiesLinkingService pls = Aadl2Visitors.getPropertiesLinkingService(contextsTab[0]) ;

    Property dispatchProtocolProperty = pls.findPropertyDefinition(_baParentContainer,
                                                                   AadlBaVisitors.DISPATCH_PROTOCOL_PROPERTY_NAME);
    if(dispatchProtocolProperty!=null)
    {
      List<MetaclassReference> appliesToMetaClasses = dispatchProtocolProperty.getAppliesToMetaclasses();
      for(MetaclassReference mClass: appliesToMetaClasses)
      {
        String mMetaClassName = mClass.getMetaclass().getName();
        String CategoryName = _baParentContainer.getCategory().getName();
        if(mMetaClassName.equalsIgnoreCase(CategoryName))
        {
          canBeDispatched=true;
          break;
        }
      }
    }
    ComponentCategory cc = _baParentContainer.getCategory();
    if(cc.equals(ComponentCategory.ABSTRACT))
    {
      this.reportLegalityWarning(dc, "Using a dispatch condition in an abstract component "
          + "means this component can only be refined into a component category on which the "
          + "Dispatch_Protocol property can be applied");
    }
    else if(canBeDispatched==false)
    {
      this.reportLegalityError(dc, cc.getName()+" components cannot contain" +
          " a dispatch condition in any of their transitions: they cannot be dispatched " +
          "(extension of Behavior Annex D.3.(L5) legality rule)") ;

      return false ;
    }
    return true;

  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rule D.3.(L6)
   * Keys : transition complete state dispatch condition
   */
  public boolean D_3_L6_Check(BehaviorTransition bt,
                              Identifier transSrcStateIdentifier)
  {
    BehaviorState tmp = (BehaviorState) transSrcStateIdentifier.getBaRef() ;

    // D.3.(L6) error case.
    if(bt.getCondition() instanceof DispatchCondition &&
          ! tmp.isComplete())
    {
      this.reportLegalityError(transSrcStateIdentifier, "Only transition " +
            "out of complete states may have dispatch condition : Behavior " +
            "Annex D.3.(L6) legality rule failed") ;

      return false ;
    }
    else
    {
      return true ;
    }
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rule D.3.(L7)
   * Keys : transition complete state dispatch condition
   */
  public boolean D_3_L7_Check(BehaviorTransition bt,
                              Identifier transSrcStateIdentifier)
  {
    BehaviorState tmp = (BehaviorState) transSrcStateIdentifier.getBaRef() ;

    // D.3.(L7) error case.
    if(tmp.isComplete() && (! (bt.getCondition()
          instanceof DispatchCondition)) && (tmp.getBindedMode()==null ))
    {
      this.reportLegalityError(transSrcStateIdentifier, "Transitions out " +
            "of complete states must have dispatch condition : Behavior Annex"+
            " D.3.(L7) legality rule failed") ;
      return false ;
    }
    else
    {
      return true ;
    }
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.3 Behavior Specification
   * Object : Check legality rule D.3.(L8)
   * Keys : transition out final state
   */
  public boolean D_3_L8_Check(Identifier transSrcStateIdentifier)
  {
    BehaviorState tmp = (BehaviorState) transSrcStateIdentifier.getBaRef() ;

    // D.3.(L8) error case.
    if(tmp.isFinal() && ! (tmp.isComplete() || tmp.isInitial()))
    {
      this.reportLegalityError(transSrcStateIdentifier, "Transitions out " +
            "of final states are not allowed : Behavior Annex" +
            " D.3.(L8) legality rule failed") ;
      return false ;
    }
    else
    {
      return true ;
    }
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule and Semantic rule
   * Section : D.4 Thread Dispatch Behavior Specification
   * Object : Check legality rule D.4.(L1) and semantic rule D.4.(5)
   * Keys : dispatch relative timeout condition catch timed thread complete
   * state period property
   */
  public boolean D_4_L1_Check(DispatchRelativeTimeout tc,
                              DeclarativeBehaviorTransition bt)
  {
    List<Identifier> sourceState = bt.getSrcStates()  ;

    if(sourceState.size() == 1)
    {
      BehaviorState bs = (BehaviorState) (sourceState.get(0)).getBaRef() ;
      if(false==_alreadyFoundDispatchRelativeTimeoutTransition.containsKey(bs)
            &&
            bs.isComplete())
      {
        // If the ba's parent container is not a Thread, the return value
        // list will be empty.

        EList<org.osate.aadl2.PropertyExpression> vl ;
        vl = PropertyUtils.findPropertyExpression(_baParentContainer,
                                                 ThreadProperties.DISPATCH_PROTOCOL) ;
        if(vl.size() > 0)
        {
          org.osate.aadl2.PropertyExpression value =
                vl.get(vl.size()-1) ;

          if(value instanceof NamedValue &&
                ((NamedValue) value).getNamedValue()
                instanceof EnumerationLiteral)
          {
            EnumerationLiteral el = (EnumerationLiteral)
                  ((NamedValue) value).getNamedValue() ;

            String literal = el.getName() ;

            if(literal.equalsIgnoreCase(DispatchTriggerProperties.TIMED))
            {
              boolean hasPeriod = false ;

              Long period = PropertyUtils.getIntValue(_baParentContainer,
                                                      TimingProperties.PERIOD) ;
              hasPeriod = period != null ;

              if(hasPeriod)
              {
                _alreadyFoundDispatchRelativeTimeoutTransition.put(bs, bt);
                return true ;
              }
              else // Error case: period property must be declared in the
              // ba's parent container.
              {
                reportLegalityError(tc, "The dispatch relative timeout"+
                      " and catch statement must declared in timed " +
                      " thread with a period property properly set: " +
                      " Behavior Annex D.4.(5) semantic rule failed") ;

                // Early exit to skip the next error reporting.
                return false ;
              }
            }
          }
        }

        // Error case : it must only be declared for timed thread.
        this.reportLegalityError(tc, "The dispatch relative timeout and" +
              " catch statement must only be declared for timed thread: " +
              "Behavior Annex D.4.(L1) legality rule failed") ;
      }
      else // Error case : It must be declared in an outgoing transition of
        // a complete state.
      {
        if(false == _alreadyReportedErroneousTransition.contains(bt))
        {
          this.reportLegalityError(tc, "The dispatch relative timeout and " +
                "catch statement must be declared in an outgoing transition "+
                "of a complete state: Behavior Annex" +
                " D.4.(L1) legality rule failed") ;
          _alreadyReportedErroneousTransition.add(bt) ;
        }
      }
    }
    else // Error case : It must be declared in only one transition of the source state.
    {
      // If transition source states list is > 1, report errors for the
      // furthers timeout catch.
      this.reportLegalityError(tc, "The dispatch relative timeout and catch"+
            " statement must be declared in only one transition: " +
            "Behavior Annex D.4.(L1) legality rule failed") ;
    }

    return false ;
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type : Legality rule
   * Section : D.4 Thread Dispatch Behavior Specification
   * Object : Check legality rule D.4.(L2)
   * Keys : dispatch completion relative timeout condition catch complete
   * state
   */
  public Boolean D_4_L2_Check(CompletionRelativeTimeout crtcac
                              , DeclarativeBehaviorTransition bt)
  {
    List<Identifier> sourceState = bt.getSrcStates() ;

    if(! _alreadyFoundCompletionRelativeTimeoutConditionCatchTransition
          .containsKey(sourceState) &&
          sourceState.size() == 1)
    {
      BehaviorState bs = (BehaviorState) (sourceState.get(0)).getBaRef() ;
      // Positive case.
      if(bs.isComplete())
      {
        _alreadyFoundCompletionRelativeTimeoutConditionCatchTransition.put(bs, bt);

        EList<org.osate.aadl2.PropertyExpression> vl ;
        vl = PropertyUtils.findPropertyExpression(_baParentContainer,
                                                 ThreadProperties.DISPATCH_PROTOCOL) ;
        if(vl.size() > 0)
        {
          org.osate.aadl2.PropertyExpression value =
                vl.get(vl.size()-1) ;

          if(value instanceof NamedValue &&
                ((NamedValue) value).getNamedValue()
                instanceof EnumerationLiteral)
          {
            EnumerationLiteral el = (EnumerationLiteral)
                  ((NamedValue) value).getNamedValue() ;

            String literal = el.getName() ;

            if(literal.equalsIgnoreCase(DispatchTriggerProperties.TIMED))
            {
              boolean hasPeriod = false ;

              Long period = PropertyUtils.getIntValue(_baParentContainer,
                                                      TimingProperties.PERIOD) ;
              hasPeriod = period != null ;
              Long timeoutConstantValue = null;
              IntegerValue iv = crtcac.getIntegerValue();
              if(iv instanceof IntegerLiteral)
              {
                timeoutConstantValue = ((IntegerLiteral) iv).getValue();
              }
              boolean timeoutIsConstant = timeoutConstantValue!=null;
              // Check that timeout is lower than period,
              // otherwise it is inconsistent.
              if(hasPeriod
                    && timeoutIsConstant
                    && period<timeoutConstantValue)
              {
                this.reportLegalityError(crtcac, "The completion relative timeout" +
                      " condition and catch statement must have a value greater or" +
                      " equal to the Period of the thread it is defined in (otherwise)" +
                      " timeout condition can never occur") ;
              }
            }
          }
        }

        return true ;
      }
      else // Error case : it must be declared in an outgoing transition of
        // a complete state.
      {
        this.reportLegalityError(crtcac, "The completion relative timeout" +
              " condition and catch statement must be declared in an " +
              "outgoing transition of a complete state: Behavior Annex" +
              " D.4.(L2) legality rule failed") ;
      }
    }
    else // Error case : it must be declared in at most one transition.
    {
      // If transition source states list is > 1, report errors for the
      // furthers completion timeout catch.
      if(false==_alreadyReportedErroneousTransition.contains(bt))
      {
        this.reportLegalityError(crtcac, "The completion relative timeout " +
              "condition and catch statement must be declared in only one " +
              "transition: Behavior Annex D.4.(L2) legality rule failed") ;
        _alreadyReportedErroneousTransition.add(bt);
      }
    }

    return false ;
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type    : Legality rule
   * Section : D.6 Behavior Action Language
   * Object  : Check legality rules D.6.(L3), D.6.(L4)
   * Keys    : local variable port variable assigned action set
   */
  public boolean D_6_L3_And_L4_Check(BehaviorActionBlock bab)
  {
    BehaviorActions beActions = bab.getContent() ;

    // Temporary list of targets passed between recursive calls of
    // buildActionSetAssignedValuesLists method.
    List<Target> lActionSetTar = new ArrayList<Target>() ;

    // Set of duplicated targets between multiple action sets.
    Set<Target> lDuplicates = new HashSet<Target>();

    buildActionSetAssignedTargetLists(beActions,
                                      lActionSetTar,
                                      lDuplicates) ;
    String localVariableErrorMsg = "The same local variable must not be " +
          "assigned to in different actions of an action set" +
          ": Behavior Annex D.6.(L3) legality rules failed" ;
    String portErrorMsg = "The same port variable must not be assigned to " +
          "in different actions of an action set: "+
          "Behavior Annex D.6.(L4) legality rules failed" ;

    String tmp ;

    for(Target tar : lDuplicates)
    {
      // Local variable case.
      if(tar instanceof BehaviorVariableHolder)
      {
        tmp = localVariableErrorMsg ;
      }
      else // Port case.
      {
        tmp = portErrorMsg ;
      }

      reportLegalityError(tar, tmp);
    }

    return lDuplicates.isEmpty() ;
  }

  /**
   * Recursively builds a list of assigned target contained
   * in a given BehaviorActions tree and checks for duplicated targets every time
   * it meet a Behavior Action Set node. It populates the given set with
   * duplicated targets.<BR><BR>
   *
   * A special attention is given to report legality rules D.6.(L3) and (L4)
   * failures : in order to help the user to correct his errors, the duplicates
   * list contains all instances of duplicated assigned targets.
   *
   * @param beActions The given BehaviorActions tree.
   * @param lActionSetDcr The list of assigned targets
   * @param lDuplicates The set of duplicated assigned targets.
   */
  @SuppressWarnings("unchecked") // As Java 1.6 can't create generic array.
  private void buildActionSetAssignedTargetLists(BehaviorActions beActions,
                                                 List<Target> lActionSetTar,
                                                 Set<Target> lDuplicates)
  {
    // Note: lActionSetTar can't be a Java'Set object because, duplicated
    // assigned targets is legal in behavior action sequence.

    // ***** Processing leafs of the behavior actions tree:

    // Basic action cases.
    if(beActions instanceof BasicAction)
    {
      if(beActions instanceof AssignmentAction)
      {
        lActionSetTar.add(((AssignmentAction)beActions).getTarget()) ;
      }

      return ;
    }

    // Behavior Action Block case.
    if(beActions instanceof BehaviorActionBlock)
    {
      BehaviorActionBlock tmp = (BehaviorActionBlock) beActions ;

      buildActionSetAssignedTargetLists(tmp.getContent(),
                                        lActionSetTar, lDuplicates) ;
      return ;
    }

    // If Statement case.
    if(beActions instanceof IfStatement)
    {
      IfStatement ifStat = (IfStatement) beActions ;
      BehaviorActions tmp =  ifStat.getBehaviorActions() ;
      buildActionSetAssignedTargetLists(tmp, lActionSetTar,
                                        lDuplicates) ;

      if(ifStat.getElseStatement() != null)
      {
        tmp = ifStat.getElseStatement() ;
        buildActionSetAssignedTargetLists(tmp, lActionSetTar,
                                          lDuplicates) ;
      }

      return ;
    }

    if(beActions instanceof ElseStatement)
    {
      ElseStatement elseStat = (ElseStatement) beActions ;
      BehaviorActions tmp =  elseStat.getBehaviorActions() ;
      buildActionSetAssignedTargetLists(tmp, lActionSetTar,
                                        lDuplicates) ;

      return ;
    }

    // Loop Statement case.
    if(beActions instanceof LoopStatement)
    {
      LoopStatement tmp = (LoopStatement) beActions ;

      buildActionSetAssignedTargetLists(tmp.getBehaviorActions(),
                                        lActionSetTar, lDuplicates) ;
      return ;
    }

    // ***** Processing containers:

    // List of BehaviorAction objects contained in the given BehaviorActions
    // tree.
    List<BehaviorAction> lbeActs = ((BehaviorActionCollection)beActions)
          .getActions() ;

    // Behavior Action Sequence case:
    if(beActions instanceof BehaviorActionSequence)
    {
      for(BehaviorAction tmp : lbeActs)
      {
        buildActionSetAssignedTargetLists(tmp, lActionSetTar,
                                          lDuplicates) ;
      }

      return ;
    }

    // Behavior Action Set case:

    // Current BehaviorAction object.
    BehaviorAction behAct ;

    // Creates an array which will handle the lists of assigned targets. One
    // list for each behavior action of the action set.
    List<Target>[] llActionSetTar = null ;
    llActionSetTar = new List[lbeActs.size()];

    // For each BehaviorAction of the given BehaviorActionCollection.
    for(int i = 0 ; i < lbeActs.size() ; i++)
    {
      behAct  =lbeActs.get(i) ;
      llActionSetTar[i] = new ArrayList<Target>() ;
      buildActionSetAssignedTargetLists(behAct, llActionSetTar[i],
                                        lDuplicates) ;
    }

    // Check for duplicated assigned targets in the lists of the
    // action set. Complexity is O(n^2) as the lists are not sorted.

    List<Target> lCurrent = null ;
    List<Target> lOther = null ;

    // Optimization flag to avoid adding the same target to the duplicates
    // set.
    boolean hasToAdd = true ;

    // Compare the lists between them.
    for(int i = 0 ; i < llActionSetTar.length - 1 ; i++)
    {
      lCurrent = llActionSetTar[i] ;

      for(Target currentTar : lCurrent)
      {
        // Compare current list with the others.
        for(int j = i+1 ; j < llActionSetTar.length ; j++ )
        {
          lOther = llActionSetTar[j] ;

          for(Target otherTar : lOther)
          {
            // Case of duplicated assigned target.
            if(AadlBaUtils.isSameTarget(currentTar, otherTar))
            {
              // Add the current target if it hasn't be done yet.
              if(hasToAdd)
              {
                lDuplicates.add(currentTar) ;
                hasToAdd = false ;
              }

              // Add the other target to help the user finding his errors.
              lDuplicates.add(otherTar) ;
            }
          }
        }

        // Reset the flag for the next target.
        hasToAdd = true ;
      }
    }

    // Add all assigned targets in the recursively transmitted list for any
    // higher level action set checking.
    for (List<Target> l : llActionSetTar)
    {
      lActionSetTar.addAll(l) ;
    }
  }

  /**
   * Document: AADL Behavior Annex draft
   * Version : 0.94
   * Type    : Legality rule
   * Section : D.6 Behavior Action Language
   * Object  : Check legality rule D.6.(L8)
   * Keys    : timed actions, max min time values
   *
   * At static analysis phase, D.6.(L8) can only be
   * checked with behavior time objects that contain IntegerLiteral objects.
   * Otherwise (with IntegerValueVariable objects), this checker returns
   * always true.
   */
  public boolean D_6_L8_Check(TimedAction timedAct)
  {
    BehaviorTime btMin = timedAct.getLowerTime();
    BehaviorTime btMax = timedAct.getUpperTime();

    if (btMax != null)
    {
      Comparator<BehaviorTime> comp =
            AadlBaUtils.createBehaviorTimeComparator() ;
      int compResult ;

      try
      {
        compResult = comp.compare(btMin, btMax) ;
      }
      catch (UnsupportedOperationException e)
      {
        // On exception, D_6_L8_Check returns true and don't report error as
        // the rule can only be checked at runtime when behavior time objects
        // contain IntegerValueVariable objects.
        compResult = 0 ;
      }

      // Error case : max time value is strictly lesser than min time value.
      if(compResult > 0)
      {
        reportLegalityError(timedAct, "In timed actions, the value of " +
              " the first parameter must be lesser than the second one: " +
              "Behavior Annex D.6.(L8) legality rule failed") ;
        return false ;
      }
      else
      {
        return true ;
      }
    }
    else // No need to check as only one time value is given.
    {
      return true ;
    }
  }

  // TODO Provide column number.
  private void reportLegalityError(BehaviorElement obj, String msg)
  {
    _errManager.error(obj, msg + ".") ;
  }

  // TODO Provide column number.
  private void reportLegalityWarning(BehaviorElement obj, String msg)
  {
    _errManager.warning(obj, msg + ".") ;
  }
}