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

import java.util.ArrayList ;
import java.util.Collection ;
import java.util.List ;
import java.util.ListIterator ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.Enumerator ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.osate.aadl2.Aadl2Factory ;
import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.ArraySize ;
import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.CalledSubprogram ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ClassifierValue ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.ComponentPrototype ;
import org.osate.aadl2.ComponentPrototypeActual ;
import org.osate.aadl2.ComponentPrototypeBinding ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataPort ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.EventDataPort ;
import org.osate.aadl2.EventPort ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.FeaturePrototypeBinding ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessorClassifier ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyConstant ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.PropertyType ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.Subprogram ;
import org.osate.aadl2.SubprogramAccess ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramPrototype ;
import org.osate.aadl2.SubprogramSubcomponent ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.UnitLiteral ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.parsesupport.LocationReference ;
import org.osate.ba.aadlba.* ;
import org.osate.ba.declarative.ArrayableIdentifier ;
import org.osate.ba.declarative.CommAction ;
import org.osate.ba.declarative.DeclarativeArrayDimension ;
import org.osate.ba.declarative.DeclarativeBehaviorElement ;
import org.osate.ba.declarative.DeclarativePropertyName ;
import org.osate.ba.declarative.DeclarativePropertyReference ;
import org.osate.ba.declarative.DeclarativeTime ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.declarative.NamedValue ;
import org.osate.ba.declarative.QualifiedNamedElement ;
import org.osate.ba.declarative.Reference ;
import org.osate.ba.texteditor.AadlBaHyperlink ;
import org.osate.ba.texteditor.DefaultAadlBaHyperlink ;
import org.osate.ba.unparser.AadlBaUnparser ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.ba.utils.DimensionException ;
import org.osate.utils.Aadl2Utils ;



/**
 * AADL Behavior annex feature's type and data representation checker.
 * 
 * Data type checking is delegated to the given DataTypeChecker implementation
 * (Dependency Injection).
 * 
 */
public class AadlBaTypeChecker
{

  private BehaviorAnnex _ba ;

  private ComponentClassifier _baParentContainer ;

  private AnalysisErrorReporterManager _errManager ;

  private static final String STRING_TYPE_SEPARATOR = " or " ;

  private static final String STRING_PARAMETER_SEPARATOR = ", " ;

  private final DataTypeChecker _dataChecker ;
  
  private final static AadlBaFactory _fact = AadlBaFactory.eINSTANCE ;
  
  private AadlBaHyperlink _hl = new DefaultAadlBaHyperlink() ;

  /**
   * Constructs an AADL behavior annex type checker.
   * Reports any errors with the given error reporter manager.
   *
   * @param ba the given behavior annex
   * @param dataChecker the given data type checker implementation
   * @param errManager the given error reporter manager
   */
  public AadlBaTypeChecker(BehaviorAnnex ba , DataTypeChecker dataChecker,
      AnalysisErrorReporterManager errManager)
  {
    _ba = ba ;
    _baParentContainer = AadlBaVisitors.getParentComponent(ba) ;
    _dataChecker = dataChecker ;
    _errManager = errManager ;
  }

  public void setAadlBaHyperlink(AadlBaHyperlink hl)
  {
    _hl = hl ;
  }
  
  /**
   * Checks the type of the objects referenced during the name resolution phase.
   * Reports any error.
   * 
   * @return {@code true} if all the objects have the excepted types.
   * {@code false} otherwise.
   */
  public boolean checkTypes()
  {
    return  behaviorVariableCheck() &  behaviorTransitionCheck(); 
  }

  /**
   * Document: AADL Behavior Annex draft 
   * Version : 0.94 
   * Type : Semantic rule
   * Section : D.3 Behavior Specification
   * Object : Check semantic rule D.3.(28) 
   * Keys : local variables explicitly typed valid data component classifier
   */
  private boolean behaviorVariableCheck()
  {
    boolean result = true ;
    IntegerValueConstant ivc = null ;
    QualifiedNamedElement uccr ;

    for(BehaviorVariable bv : _ba.getVariables())
    {
      uccr = (QualifiedNamedElement) bv.getDataClassifier() ;
      
      DataClassifier dc = (DataClassifier) 
           uniqueComponentClassifierReferenceResolver(uccr,
                                                      TypeCheckRule.DATA_UCCR) ;
      
      _hl.addToHyperlinking(uccr.getAadlBaLocationReference(),
                            dc) ;
      
      result &= dc != null ;
      bv.setDataClassifier(dc) ;
      
      ListIterator<ArrayDimension> it = bv.getArrayDimensions().listIterator() ;
      
      while(it.hasNext())
      {
        ArrayDimension tmp = it.next() ;
        DeclarativeArrayDimension dad = (DeclarativeArrayDimension) tmp ;
        
        ivc = dad.getDimension()  ;
        ivc = integerValueConstantCheck(ivc) ;
        result &= ivc != null ;

        // The returned value may be different from the tested value
        // because of semantic ambiguity resolution in 
        // integervalueConstantCheck method. So replace if needed.
        if(ivc !=null)
        {
          it.set(integerValueConstantToArrayDimension(ivc)) ;
        }
      }
    }

    return result ;
  }
  
  private String unparseQualifiedNamedElement(QualifiedNamedElement qne)
  {
    StringBuilder sb = new StringBuilder();
    if(qne.getBaNamespace() != null)
    {
      sb.append(qne.getBaNamespace().getId()) ;
      sb.append("::") ;
    }
    
    sb.append(qne.getBaName().getId()) ;
    
    return sb.toString() ;
  }
  
  private Classifier uniqueComponentClassifierReferenceResolver
                                                     (QualifiedNamedElement qne,
                                                      TypeCheckRule rule)
  {
    String unparsed = unparseQualifiedNamedElement(qne) ;
    
    boolean succeed = typeCheck(qne, unparsed,rule, true) != null ;
    
    if(succeed)
    {
      return ((Classifier) qne.getOsateRef()) ;
    }
    else
    {
      return null ;
    }
  }
  
  private ArrayDimension integerValueConstantToArrayDimension(
                                                       IntegerValueConstant ivc)
  {
    ArrayDimension result = Aadl2Factory.eINSTANCE.createArrayDimension() ;
    ArraySize size = result.createSize() ;
    result.setSize(size) ;
    result.setLocationReference(ivc.getLocationReference()) ;
    size.setLocationReference(ivc.getLocationReference()) ;
    
    if(ivc instanceof BehaviorIntegerLiteral)
    {
      size.setSize(((BehaviorIntegerLiteral)ivc).getValue()) ;
    }
    else if(ivc instanceof BehaviorPropertyConstant)
    {
      PropertyExpression pe = null ;
      PropertyConstant pc = ((BehaviorPropertyConstant) ivc).getProperty() ;
      pe = pc.getConstantValue() ;
      
      if(pe instanceof NumberValue)
      {
        double value = ((NumberValue)pe).getScaledValue() ;
        size.setSize((long) value);
      }
      else
      {
        String msg = "cannot evaluate the property constant";
        _errManager.warning(ivc, msg);
      }
    }
    else if(ivc instanceof PropertyReference)
    {
      PropertyReference pr = (PropertyReference) ivc ;
      PropertyNameHolder last = pr.getProperties().
                                              get(pr.getProperties().size()-1) ;
      Element el = last.getProperty().getElement() ;
      
      if(el instanceof NumberValue)
      {
        double value = ((NumberValue)el).getScaledValue() ;
        size.setSize((long) value);
      }
      else
      {
        String msg = "cannot evaluate the property value";
        _errManager.warning(ivc, msg);
      }
    }
    else
    {
      String errorMsg = "integerValueConstantToArrayDimension : " +
            ivc.getClass().getSimpleName()+
            " is not supported yet." ;
        System.err.println(errorMsg) ;
        throw new UnsupportedOperationException(errorMsg) ;
    }
    
    return result ;
  }

  // This method checks the given object and returns an object resolved from
  // semantic ambiguities. On error, reports error and returns null.
  private IntegerValueConstant integerValueConstantCheck(IntegerValueConstant ivc)
  {
    ValueAndTypeHolder holder = valueConstantCheck((ValueConstant)ivc);

    if (typeCheck(ivc, null, holder, DataRepresentation.INTEGER))
    {
      return (IntegerValueConstant) holder.value ;
    }
    else
    {
      return null ;
    }
  }

  // This method checks the given object and returns an object resolved from
  // semantic ambiguities. On error, reports error and returns null.
  private IntegerValue integerValueCheck(IntegerValue iv)
  {
    // Ambiguity between property constant and name without array index
    // has already been resolved in the name resolution phase.

    if(iv instanceof IntegerValueConstant)
    {
      return integerValueConstantCheck((IntegerValueConstant) iv) ;
    }
    else
    {
      return integerValueVariableCheck((IntegerValueVariable) iv) ;
    }
  }

  // This method checks the given object and returns an object resolved from
  // semantic ambiguities. On error, reports error and returns null.
  private IntegerValueVariable integerValueVariableCheck(IntegerValueVariable ivv)
  {
    ValueAndTypeHolder holder = valueVariableCheck((ValueVariable)ivv);

    if(typeCheck(ivv, null, holder, DataRepresentation.INTEGER))
    {
      return (IntegerValueVariable) holder.value ;
    }
    else
    {
      return null ;
    }
  }

  private boolean behaviorTransitionCheck()
  {
    boolean result = true ;
    
    for(BehaviorTransition trans : _ba.getTransitions())
    {
      BehaviorCondition cond = trans.getCondition() ;

      if(cond instanceof DispatchCondition)
      {
        result &= dispatchConditionCheck((DispatchCondition) cond);
      }
      else
      {
        result &= executeConditionCheck((ExecuteCondition) cond) ;
      }

      if(trans.getActionBlock() != null)
      {
        result &= behaviorActionBlockCheck(trans.getActionBlock()) ;
      }
    } 
        
    return result ;
  }

  /**
   * Document: AADL Behavior Annex draft 
   * Version : 0.94 
   * Type : Naming rule
   * Section : D.4 Thread Dispatch Behavior Specification
   * Object : Check naming rules D.4.(N1), D.4.(N2) 
   * Keys : frozen port, subprogram access feature, dispatch trigger condition
   */
  private boolean dispatchConditionCheck(DispatchCondition cond)
  {
    boolean result = false ;

    DispatchTriggerCondition dtc = cond.getDispatchTriggerCondition() ;

    if(dtc != null)
    {
      DispatchTriggerCondition tmp = dispatchTriggerConditionCheck(dtc) ;
      result = tmp != null ;

      // The returned DispatchTriggerCondition may be different from the
      // tested one because of semantic ambiguity resolution in
      // dispatchTriggerConditionCheck method. So replace if needed.
      if (tmp != dtc && result)
      {
        cond.setDispatchTriggerCondition(tmp) ;
      }
    }
    else
    {
      result = true ;
    }

    if(cond.isSetFrozenPorts())
    {
      PortHolder portHolder = null ;
      
      ListIterator<ActualPortHolder> it = cond.getFrozenPorts().listIterator() ;
      
      while(it.hasNext())
      {
        Reference ref = (Reference) it.next() ;
        
        portHolder = frozenPortCheck(ref) ; 
        
        if (portHolder != null)
        {
          it.set((ActualPortHolder) portHolder) ;
        }
        else
        {
          result = false ;
        } 
      }
    }
    
    return result ;
  }

  private PortHolder frozenPortCheck(Reference ref)
  {
    PortHolder result = null ;

    TypeCheckRule stopOnThisRule = TypeCheckRule.FROZEN_PORT ;
    TypeCheckRule checkRules = stopOnThisRule ;
    
    List<ElementHolder> resolvedRef = refResolver(ref, null,
                                                  stopOnThisRule, checkRules) ;
    
    if(resolvedRef != null)
    {
      result = (PortHolder) resolvedRef.get(0) ;
    }
    
    return result ;
  }

  private void reportError (BehaviorElement el, String msg)
  {
//    if(el.eContainer() == null)
//    {
//      DeclarativeUtils.setEcontainer(_ba, el) ;
//    }
    
    _errManager.error(el, msg);
  }

  private void reportTypeError(BehaviorElement el, String name,
                               String expectedTypes,
                               String typeFound)
  {
    String message = "type error for \'" + name + "\', \'" + expectedTypes +
          "\' expected, found \'" + typeFound + "\'.";
    
    reportError(el, message) ;
  }

  private String unparseNameElement(BehaviorElement e)
  {
    if(e instanceof Reference)
    {
      return unparseReference((Reference) e) ;
    }
    else
    {
      AadlBaUnparser unparser = new AadlBaUnparser() ;
      unparser.process(e) ;
      return unparser.getOutput() ;
    }
  }
  
  private String unparseReference(Reference ref)
  {
    return ref.getIds().get(ref.getIds().size() -1).getId() ;
  }

  // This method checks the given object and returns an object resolved from
  // semantic ambiguities. On error, reports error and returns null.
  private DispatchTriggerCondition dispatchTriggerConditionCheck(
                                                   DispatchTriggerCondition dtc)
  {
    if(dtc instanceof DispatchTriggerLogicalExpression)
    {
      DispatchTriggerLogicalExpression dtle =
          (DispatchTriggerLogicalExpression) dtc ;

      // dispatch trigger logical expression.
      // Resolves ambiguity between a single dispatch trigger and subprogram 
      // access.
      if(dtle.getDispatchConjunctions().size() == 1)
      {
        DispatchConjunction dc = dtle.getDispatchConjunctions().get(0) ;
        
        List<DispatchTrigger> dispatchTriggers = dc.getDispatchTriggers() ;
        
        if(dispatchTriggers.size() == 1)
        {
          Reference ref = (Reference) dispatchTriggers.get(0) ;
          
          ElementHolder el = dispatchTriggerResolver(ref,
                                     TypeCheckRule.DISPATCH_TRIGGER_CONDITION) ;
          if(el != null)
          {
            if(el instanceof DispatchTrigger)
            {
              dispatchTriggers.set(0, (DispatchTrigger) el) ;
              return dtc ;
            }
            else // Subprogram access case.
            {
              return (DispatchTriggerCondition) el ;
            }
          }
          else
          {
            return null ;
          }
        }
        else
        {
          return dispatchTriggerLogicalExpressionCheck(dtle) ? dtc : null ;
        }
      }
      else
      {
        return dispatchTriggerLogicalExpressionCheck(dtle) ? dtc : null ;
      }
    }
    else
    {
      // CompletionRelativeTimeout case.
      if(dtc instanceof CompletionRelativeTimeout)
      {
        CompletionRelativeTimeout tmp = _fact.createCompletionRelativeTimeout();
        
        if(behaviorTimeCheck((DeclarativeTime) dtc, tmp))
        {
          return tmp ;
        }
        else
        {
          return null ;
        }
      }
      else // Cases of DispatchTriggerConditionStop and TimeoutCatch:
        // There isn't any type to check.
      {
        return dtc ;
      }
    }
  }
  
  private ElementHolder dispatchTriggerResolver(Reference ref,
                                                TypeCheckRule rule)
  {
    TypeCheckRule stopOnThisRule = rule ;
    TypeCheckRule checkRules = stopOnThisRule ;
    List<ElementHolder> resolvedRef = refResolver(ref, null, stopOnThisRule,
                                                  checkRules) ;
    if (resolvedRef != null)
    {
      return resolvedRef.get(0) ;
    }
    else
    {
      return null ;
    }
  }
  
  private boolean behaviorTimeCheck(DeclarativeTime dbt,
                                    BehaviorTime result)
  {
    IntegerValue tmp = integerValueCheck(dbt.getIntegerValue());

    // The returned value may be different from the tested value
    // because of semantic ambiguity resolution in integerValueCheck
    // method. So replace if needed.
    if(tmp != null)
    {
      result.setIntegerValue(tmp) ;
      Identifier unitId = dbt.getUnitId();
      result.setUnit((UnitLiteral) unitId.getOsateRef()) ;
      result.setLocationReference(dbt.getLocationReference());
    }
    
    return tmp != null ;
  }

  private boolean dispatchTriggerLogicalExpressionCheck(
                                          DispatchTriggerLogicalExpression dtle)
  {
    boolean result = true ;
    
    ElementHolder elHolder = null ;

    for(DispatchConjunction dc : dtle.getDispatchConjunctions())
    {
      ListIterator<DispatchTrigger> it = dc.getDispatchTriggers().listIterator();
      
      while(it.hasNext())
      {
        Reference e  = (Reference) it.next() ;
        
        elHolder = dispatchTriggerResolver(e, TypeCheckRule.DISPATCH_TRIGGER) ;
        
        if(elHolder != null)
        {
          it.set((DispatchTrigger) elHolder) ;
        }
        else
        {
          result = false ;
        }
      }
    }

    return result ;
  }

  private boolean executeConditionCheck(ExecuteCondition cond)
  {
    if(cond instanceof ValueExpression)
    {
      ValueAndTypeHolder holder = valueExpressionCheck((ValueExpression) cond);

      // Execute condition is only defined for logical value expression.
      return typeCheck(cond, "the execute condition", holder,
          DataRepresentation.BOOLEAN) ;
    }
    else // Timeout catch and Otherwise cases : no type to check.
    {
      return true ;
    }
  }

  // This method checks the given object and returns a value expression
  // resolved from semantic ambiguities and its data representation. On error,
  // reports error and returns null.
  /** 
   * Document: AADL Behavior Annex draft
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.7 Behavior Expression Language
   * Object : Check legality rules D.7.(L3), partially D.7.(L6)
   * Keys : operand logical operators boolean
   */
  private ValueAndTypeHolder valueExpressionCheck(ValueExpression ve)
  {
    EList<Relation> rl = ve.getRelations() ;

    TypeHolder[] typea = new TypeHolder[rl.size()] ;
    EList<LogicalOperator> opl = ve.getLogicalOperators() ;
    boolean isTopLevelTypePossible = true ;

    // Checks all relations.
    for(int i = 0 ; i < rl.size() ; i++)
    {
      typea[i] = relationCheck(rl.get(i)) ;

      // Current checking has failed but continues because all relations have
      // to be checked.
      if(typea[i] == null)
      {
        isTopLevelTypePossible = false ;
      }
    }

    // If the relation checking are successful, checks operators definition 
    // and evaluates top level value variable type representation.
    if(isTopLevelTypePossible)
    {
      if(rl.size() > 1)
      {
        for(int i = 1 ; i < rl.size() ; i++)
        {
          typea[i] = _dataChecker.checkDefinition(ve, opl.get(i-1), typea[i-1],
              typea[i]) ;
          // Error case : the current operator is not defined.  
          if (typea[i] == null)
          {
            return null ;
          }
        }

        return new ValueAndTypeHolder (ve, typea[typea.length - 1]) ;
      }
      else // As there isn't any operator set, top level type is the unique
        // relation's one.
      {
        return new ValueAndTypeHolder (ve, typea[0]) ;
      }
    }
    else // Relation checking has failed.
    {
      return null ;
    }
  }

  // Returns the top-level relation data representation or null on error.
  // Reports any error.
  /** 
   * Document: AADL Behavior Annex draft
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.7 Behavior Expression Language
   * Object : Check legality rule D.7.(L4) 
   * Keys : operand relational operators supports comparison
   */
  private TypeHolder relationCheck(Relation r)
  {
    TypeHolder th1 = simpleExpressionCheck(r.getFirstExpression()) ;
    TypeHolder th2 = null ;

    if(r.isSetRelationalOperator())
    {
      th2 = simpleExpressionCheck(r.getSecondExpression()) ; 
    }
    else
    {
      return th1 ;
    }

    if(th1 != null && th2 != null)
    {
      return _dataChecker.checkDefinition(r, r.getRelationalOperator(),
          th1, th2);
    }
    else
    {
      return null ;
    }
  }

  // Returns the top-level simple expression type representation or null on
  // error. Reports any error.
  /** 
   * Document: AADL Behavior Annex draft
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.7 Behavior Expression Language
   * Object : Check legality rule D.7.(L5) 
   * Keys : adding other numeric operators support numeric operations
   */
  private TypeHolder simpleExpressionCheck(SimpleExpression se)
  {
    EList<Term> tl = se.getTerms() ;
    TypeHolder[] typea = new TypeHolder[tl.size()] ;
    EList<BinaryAddingOperator> opl = se.getBinaryAddingOperators() ;
    boolean isTopLevelTypePossible = true ;

    // Checks all terms.
    for(int i = 0 ; i < tl.size() ; i++)
    {
      typea[i] = termCheck(tl.get(i)) ;

      // Current checking has failed but continues because all terms have to
      // be checked.
      if(typea[i] == null)
      {
        isTopLevelTypePossible = false ;
      }
    }

    // If the term checking are successful, checks operators definition and
    // evaluates top level simple expression type representation.
    if(isTopLevelTypePossible)
    {
      if(se.isSetUnaryAddingOperator())
      {
        typea[0] = _dataChecker.checkDefinition(se,
            se.getUnaryAddingOperator(),
            typea[0]) ;
        // Error case : the unary adding operator is not defined.  
        if (typea[0] == null)
        {
          return null ;
        }
      }

      if(tl.size() > 1)
      {
        for(int i = 1 ; i < tl.size() ; i++)
        {
          typea[i] = _dataChecker.checkDefinition(se,opl.get(i-1), typea[i-1],
              typea[i]) ;

          // Error case : the current operator is not defined.  
          if (typea[i] == null)
          {
            return null ;
          }
        }

        return typea[typea.length - 1] ;
      }
      else // As there isn't any operator set, top level type is the unique 
        // term's one.
      {
        return typea[0] ;
      }
    }
    else // Term checking has failed.
    {
      return null ;
    }
  }

  // Returns the top-level term type representation or null on error.
  // Reports any error.
  /** 
   * Document: AADL Behavior Annex draft
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.7 Behavior Expression Language
   * Object : Check legality rule D.7.(L5) 
   * Keys : multiplying other numeric operators support numeric operations
   */
  private TypeHolder termCheck(Term t)
  {
    EList<Factor> fl = t.getFactors() ;
    TypeHolder[] typea = new TypeHolder[fl.size()] ;
    EList<MultiplyingOperator> opl = t.getMultiplyingOperators() ;
    boolean isTopLevelTypePossible = true ;

    // Checks all the factors.
    for(int i = 0 ; i < fl.size() ; i++)
    {
      typea[i] = factorCheck(fl.get(i)) ;

      // Current checking has failed but continues because all factors have to
      // be checked.
      if(typea[i] == null)
      {
        isTopLevelTypePossible = false ;
      }
    }

    // If the factor checking are successful, checks operators definition
    // and evaluates top level term type representation.
    if(isTopLevelTypePossible)
    {
      if (fl.size() > 1)
      {
        for (int i = 1 ; i < fl.size() ; i++)
        {
          typea[i] = _dataChecker.checkDefinition(t, opl.get(i-1), typea[i-1],
              typea[i]) ;
          // Error case : the current operator is not defined.  
          if (typea[i] == null)
          {
            return null ;
          }
        }

        return typea[typea.length - 1] ;
      }
      else // As there isn't any operator set, top level type is the unique 
        // factor's one.
      {
        return typea[0] ;
      }
    }
    else
    {
      return null ;
    }
  }

  // Returns the top-level factor type representation or null on error.
  // Reports any error.
  /** 
   * Document: AADL Behavior Annex draft
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.7 Behavior Expression Language 
   * Object : Check legality rule D.7.(L5) 
   * Keys : other numeric operators support numeric operations
   */
  private TypeHolder factorCheck(Factor f)
  {
    Value fValue = f.getFirstValue() ;
    Value sdValue = f.getSecondValue() ;
    ValueAndTypeHolder vth1 = valueCheck(fValue) ;
    ValueAndTypeHolder vth2 = null ;

    if(sdValue != null)
    {
      // Checks second value even if the first value checking has failed. 
      vth2 = valueCheck(sdValue) ;
    }

    if(vth1 != null) // Don't check operator definition on value checking error.
    {
      // The returned value may be different from the tested value
      // because of semantic ambiguity resolution in valueCheck
      // method. So replace if needed.
      f.setFirstValue(vth1.value) ;
      fValue = vth1.value ;

      // Checks Unary operators.
      if(f.isSetUnaryNumericOperator() ||
          f.isSetUnaryBooleanOperator())
      {
        Enumerator op ;

        op =  (
                (f.isSetUnaryBooleanOperator()) ? 
                  f.getUnaryBooleanOperator() : 
                  f.getUnaryNumericOperator()) ;

        return _dataChecker.checkDefinition(f, op, vth1.typeHolder) ;
      }
      else 
      {
        if(f.isSetBinaryNumericOperator())
        {
          if(vth2 != null)
          {
            // The returned value may be different from the tested value
            // because of semantic ambiguity resolution in valueCheck
            // method. So replace if needed.
            f.setSecondValue(vth2.value) ;
            sdValue = vth2.value ;

            return _dataChecker.checkDefinition(f,
                f.getBinaryNumericOperator(),vth1.typeHolder,
                vth2.typeHolder);
          }
          else // Second value error case.
          {
            return null ;
          }
        }
        else // As there isn's any operator, the top level type is the unique
          // value' one.
        {
          return vth1.typeHolder ;
        }
      }
    }
    else // First value error case.
    {
      return null ;
    }
  }

  // This method checks the given object and returns a value
  // resolved from semantic ambiguities and its data representation. On error,
  // reports error and returns null.
  private ValueAndTypeHolder valueCheck(Value v)
  {
    if(v instanceof ValueConstant)
    {
      return valueConstantCheck((ValueConstant) v) ;
    }
    else
    {
      if (v instanceof ValueVariable)
      {
        return valueVariableCheck((ValueVariable) v) ;
      }
      else // Value expression case.
      {
        return valueExpressionCheck((ValueExpression) v) ;
      }
    }
  }
  
  // This method checks the given object and returns a value variable
  // resolved from semantic ambiguities and its data representation. On error,
  // reports error and returns null.
  private ValueAndTypeHolder valueVariableCheck(ValueVariable v)
  {
    List<ElementHolder> ehl = null ;
    ValueVariable tmpResult = null ;
    ActualPortHolder port ;
    TypeCheckRule stopRule ;
    TypeCheckRule[] checkRules ;
    
    if(v instanceof Reference)
    {
      port = null ;
      stopRule = TypeCheckRule.VV_STOP_RULE ;
      
      checkRules = new TypeCheckRule[]
                   {
                     TypeCheckRule.VV_COMPONENT_REFERENCE_FIRST_NAME,
                     TypeCheckRule.DATA_COMPONENT_REFERENCE_OTHER_NAMES
                   } ;
    }
    else // NamedValue case.
    {
      NamedValue nv = (NamedValue) v ;
      v = nv.getReference() ;
              
      if(nv.isCount())
      {
        port = _fact.createPortCountValue() ;
        stopRule = TypeCheckRule.PORT_COUNT_VALUE ;
      }
      else if (nv.isDequeue())
      {
        port = _fact.createPortDequeueValue() ;
        stopRule = TypeCheckRule.PORT_DEQUEUE_VALUE ;
      }
      else
      {
        port = _fact.createPortFreshValue() ;
        stopRule = TypeCheckRule.PORT_FRESH_VALUE ;
      }
      
      port.setLocationReference(v.getLocationReference()) ;
      checkRules = new TypeCheckRule[] {stopRule} ;
    }
    
    ehl = refResolver((Reference) v, port, stopRule, checkRules) ;
    if(ehl != null)
    {
      tmpResult = referenceToValueVariable(ehl) ;
      
      if(tmpResult instanceof PortFreshValue)
      {
        PortFreshValue pfv = (PortFreshValue) tmpResult ;
        AadlBaVisitors.putFreshPort(_ba, pfv.getPort()) ;
      }
      
      return this.getValueAndTypeHolder(tmpResult, v) ;
    }
    else
    {
      return null ;
    }
  }
  
  // Null proof.
  @SuppressWarnings("all")
  private ValueVariable referenceToValueVariable(List<ElementHolder> resolvedRef)
  {
    ValueVariable result = null ;
    
    if(resolvedRef != null)
    {
      if(resolvedRef.size() > 1)
      {
        DataComponentReference dcr = _fact.createDataComponentReference() ;
        dcr.setLocationReference(resolvedRef.get(0).getLocationReference()) ;
        dcr.getData().addAll((Collection<? extends DataHolder>) resolvedRef);
        result = dcr ;
      }
      else
      {
        result = (ValueVariable) resolvedRef.get(0) ;
      }
    }
    
    return result ;
  }
  
  private ValueAndTypeHolder getValueAndTypeHolder(Value v, Element errorRef)
  {
    try
    {
      return new ValueAndTypeHolder(v, AadlBaUtils.getTypeHolder(v,
                                                           _baParentContainer));
    }
    catch(DimensionException e)
    {
      e._element = errorRef ;
      reportDimensionException(e) ;
      return null ;
    }
  }
  
  // Checks group rules by default.
  // Special attention is provided for Value or Target that are not
  // data component references (ex: PortHolder): if stopOnThisRule is found
  // and extra information exists (ex: port.port which syntactically correct but
  // semantically wrong), it will report extraneous information error.
  // If given port is not null, elementHolderResolver will try to set it 
  // (optimize reinstanciation when using design pattern decoration, for 
  // PortActions and PortValues).
  // Also, IterativeVariable and BehaviorVariable instances can't have any
  // group information. It will report extraneous information error if
  // groups are provided.
  // This method can't detect if there is not enought information (currently 
  // just for required_data_access_name.provided_subprogram_access_name case).
  private List<ElementHolder> refResolver(Reference ref, ActualPortHolder port,
                                          TypeCheckRule stopOnThisRule,
                                          TypeCheckRule... checkRules)
  {
    List<ElementHolder> result = new ArrayList<ElementHolder>(ref.getIds().
                                                                       size()) ;
    Enum<?> currentResult = null ;

    ElementHolder currentElementholder = null ;
    int currentIndexRule = 0 ;
    TypeCheckRule currentRule = checkRules[currentIndexRule] ;
    TypeCheckRule lastRule = checkRules[checkRules.length -1] ;
    boolean hasToContinue = true ;
    
    ArrayList<GroupHolder> grpl = new ArrayList<GroupHolder>
                                                         (ref.getIds().size()) ;
    
    ListIterator<ArrayableIdentifier> it = ref.getIds().listIterator() ;
    
    while(it.hasNext())
    {
      ArrayableIdentifier id = it.next() ;
      
      currentResult = typeCheck(id, id.getId(), TypeCheckRule.GROUPS, false) ;
      
      // The current id represents a group, so store it in the groups stack.
      if(currentResult != null)
      {
        currentElementholder = elementHolderResolver(id, currentResult, port) ;
        grpl.add((GroupHolder) currentElementholder) ;
      }
      else // Checks given rules: if ref.getIds().size > rules.length then
           // use the last given rule for the extra ids.
      {
        currentResult = typeCheck(id, id.getId(), currentRule, true) ;
        
        if(currentResult != null)
        {
          currentElementholder = elementHolderResolver(id, currentResult, port);
          result.add(currentElementholder) ;
          
          if(currentElementholder instanceof GroupableElement)
          {
            if(false == grpl.isEmpty())
            {
              GroupableElement ge = (GroupableElement) currentElementholder ;
              
              // Flush GroupHolder List.
              if(false == grpl.isEmpty())
              {
                ge.getGroupHolders().addAll(grpl) ;
                grpl.clear() ;
              }
            }
          }
          else if(false == grpl.isEmpty())
          {
            // Reports error of a not GroupableHolder that have group information.
            String msg = id.getId() + " can't have group information." ; 
            reportError(id, msg) ;
            return null ;
          }
          
          // Tests if a type that stop the checking is found.
          hasToContinue = stopOnThisRule.testTypeCheckRule(currentResult) 
                                                                       == null ; 
          if(it.hasNext())
          {
            currentIndexRule++ ;
            
            // Extra information (it passes the name resolved),
            // has been given whereas the stop type is reached.
            // So report error.
            if(hasToContinue == false)
            {
              // To much information.
              String msg = id.getId() + " can't have any more tokens." ;
              reportError(id, msg) ;
              return null ;
            }
            else // Stop type is not reached or is null that means there is 
                 // not id number limit.
            {
              // If the number of ids is greater than the number of given
              // rules: use the last rule for the extra ids. Only for data
              // component reference.
              currentRule = (currentIndexRule < checkRules.length) ? 
                                                checkRules[currentIndexRule] :
                                                lastRule ;
            }
          }
        }
        else
        {
          // Error reporting has already been done.
          return null ;
        }
      }
      
      // Checks array indexes.
      if(id.isSetArrayIndexes())
      {
        if(currentElementholder instanceof IndexableElement)
        {
          IndexableElement currentIndexableElement = (IndexableElement) 
                                                          currentElementholder ;
          
          boolean isConsistent = true ;
          
          List<IntegerValue> resolvedValues = new ArrayList<IntegerValue>
                                                    (id.getArrayIndexes().size());
          
          for(IntegerValue iv : id.getArrayIndexes())
          {
            // Reports any error.
            IntegerValue resolvedValue = integerValueCheck(iv) ;
            if(resolvedValue != null)
            {
              resolvedValues.add(resolvedValue) ;
            }
            else
            {
              isConsistent = false ;
            }
          }
          
          // Avoid collection concurrency modification between id's integer values
          // and currentIndexableElement's one.
          if(isConsistent)
          {
            currentIndexableElement.getArrayIndexes().addAll(resolvedValues) ;
          }
        }
        else
        {
          // Not an arrayable element.
          String msg = currentElementholder.getElement().getName() +
                                                    " can't have array index." ;
          reportError(currentElementholder, msg) ;
          return null ;
        }
      }
      if(result.isEmpty() && false==grpl.isEmpty())
      {
        String expectedTypes = currentRule.getExpectedTypes(STRING_TYPE_SEPARATOR) ;
        String errMsg = "Wrong type in "+stopOnThisRule.getLiteral()+"; expected types are: "+ expectedTypes;
        this.reportError(ref, errMsg);
      }
    } // End of for.
    if(result.isEmpty())
      return null;
    return result ;
  }
  
  // It doesn't perform any check.
  // It just builds an element holder according to the given type.
  // If port is not null, it will set the given port.
  private ElementHolder elementHolderResolver(ArrayableIdentifier id,
                                              Enum<?> type,
                                              ActualPortHolder port)
  {
    ElementHolder result = null ;
    
    if(type instanceof FeatureType)
    {
      FeatureType t = (FeatureType) type ;
      
      switch(t)
      {
        case IN_DATA_PORT:
        case OUT_DATA_PORT:
        case IN_OUT_DATA_PORT:
        {
          if(port == null)
          {
            DataPortHolder tmp  = _fact.createDataPortHolder() ;
            tmp.setDataPort((DataPort) id.getOsateRef()) ;
            result = tmp ;
          }
          else
          {
            port.setPort((Port)id.getOsateRef()) ;
            result = port ;
          }
          
          break ;
        }
        
        case IN_EVENT_DATA_PORT:
        case OUT_EVENT_DATA_PORT:
        case IN_OUT_EVENT_DATA_PORT:
        {
          if(port == null)
          {
            EventDataPortHolder tmp = _fact.createEventDataPortHolder() ;
            tmp.setEventDataPort((EventDataPort) id.getOsateRef()) ;
            result = tmp ;
          }
          else
          {
            port.setPort((Port)id.getOsateRef()) ;
            result = port ;
          }
          
          break ;
        }
        
        case IN_EVENT_PORT:
        case OUT_EVENT_PORT:
        case IN_OUT_EVENT_PORT:
        {
          if(port == null)
          {
            EventPortHolder tmp = _fact.createEventPortHolder() ;
            tmp.setEventPort((EventPort) id.getOsateRef()) ;
            result = tmp ;
          }
          else
          {
            port.setPort((Port)id.getOsateRef()) ;
            result = port ;
          }
          
          break ;
        }
        
        case REQUIRES_DATA_ACCESS:
        case PROVIDES_DATA_ACCESS:
        {
          DataAccessHolder tmp = _fact.createDataAccessHolder() ;
          tmp.setDataAccess((DataAccess) id.getOsateRef()) ;
          result = tmp ;
          break ;
        }
        
        case DATA_SUBCOMPONENT:
        {
          DataSubcomponentHolder tmp = _fact.createDataSubcomponentHolder() ;
          tmp.setDataSubcomponent((DataSubcomponent) id.getOsateRef()) ;
          result = tmp ;
          break ;
        }
        
        case CLASSIFIER_VALUE:
        {
          ClassifierValue cv = (ClassifierValue) id.getOsateRef() ;
          DataClassifier dc = (DataClassifier) cv.getClassifier() ;
          
          
          StructUnionElement sue = _fact.createStructUnionElement() ;
          sue.setLocationReference(Aadl2Utils.getLocationReference(dc)) ;
          sue.setDataClassifier(dc) ;
          sue.setName(id.getId()) ;
          
          StructUnionElementHolder sueHolder = _fact.
                                              createStructUnionElementHolder() ;
          sueHolder.setStructUnionElement(sue) ;
          
          // Set econtainer as ElementHolder::element is not containment.
          InternalEObject parent = (InternalEObject) sueHolder ;
          InternalEObject child = (InternalEObject) sue ;
          
          child.eBasicSetContainer(parent,
                                   AadlBaPackage.STRUCT_UNION_ELEMENT_HOLDER,
                                   null) ;
          result = sueHolder ;
          break ;
        }
        
        case IN_PARAMETER:
        case OUT_PARAMETER:
        case IN_OUT_PARAMETER:
        {
          ParameterHolder tmp = _fact.createParameterHolder() ;
          tmp.setParameter((Parameter) id.getOsateRef()) ;
          result = tmp ;
          break ;
        }
        
        case SUBPROGRAM_CLASSIFIER:
        case SUBPROGRAM_SUBCOMPONENT:
        {
          SubprogramHolder tmp = _fact.createSubprogramHolder() ;
          tmp.setSubprogram((Subprogram) id.getOsateRef()) ;
          result = tmp ;
          break ;
        }
        
        case REQUIRES_SUBPROGRAM_ACCESS:
        case PROVIDES_SUBPROGRAM_ACCESS:
        {
          SubprogramAccessHolder tmp = _fact.createSubprogramAccessHolder() ;
          tmp.setSubprogramAccess((SubprogramAccess) id.getOsateRef()) ;
          result = tmp ;
          break ;
        }
        
        case FEATURE_GROUP:
        case SUBPROGRAM_GROUP:
        case THREAD_GROUP:
        case REQUIRES_SUBPROGRAM_GROUP_ACCESS:
        case PROVIDES_SUBPROGRAM_GROUP_ACCESS:
        {
          GroupHolder tmp = _fact.createGroupHolder() ;
          tmp.setGroup((NamedElement) id.getOsateRef()) ;
          result = tmp ;
          break ;
        }
        
        case SUBPROGRAM_PROTOTYPE:
        {
          Element el = id.getOsateRef() ;
          SubprogramPrototypeHolder tmp = _fact.createSubprogramPrototypeHolder() ;
          if (el instanceof PrototypeBinding)
          {
            PrototypeBinding pb = (PrototypeBinding) el ;
            tmp.setPrototype(pb.getFormal()) ;
            tmp.setPrototypeBinding(pb) ;
          }
          else
          {
            Prototype p = (Prototype) el ;
            tmp.setPrototype(p) ;
          }
          
          result = tmp ;
          break ;
        }
        
        case IN_DATA_PORT_PROTOTYPE:
        case OUT_DATA_PORT_PROTOTYPE:
        case IN_OUT_DATA_PORT_PROTOTYPE:
        case IN_EVENT_DATA_PORT_PROTOTYPE:
        case OUT_EVENT_DATA_PORT_PROTOTYPE:
        case IN_OUT_EVENT_DATA_PORT_PROTOTYPE:
        case IN_EVENT_PORT_PROTOTYPE:
        case OUT_EVENT_PORT_PROTOTYPE:
        case IN_OUT_EVENT_PORT_PROTOTYPE:
        {
          Element el = id.getOsateRef() ;
          PortPrototypeHolder tmp = _fact.createPortPrototypeHolder() ;
          if (el instanceof PrototypeBinding)
          {
            PrototypeBinding pb = (PrototypeBinding) el ;
            tmp.setPrototype(pb.getFormal()) ;
            tmp.setPrototypeBinding(pb) ;
          }
          else
          {
            Prototype p = (Prototype) el ;
            tmp.setPrototype(p) ;
          }
          
          result = tmp ;
          break ;
        }
        
        case REQUIRES_DATA_ACCESS_PROTOTYPE:
        case PROVIDES_DATA_ACCESS_PROTOTYPE:
        {
          Element el = id.getOsateRef() ;
          DataAccessPrototypeHolder tmp = _fact.createDataAccessPrototypeHolder() ;
          if (el instanceof PrototypeBinding)
          {
            PrototypeBinding pb = (PrototypeBinding) el ;
            tmp.setPrototype(pb.getFormal()) ;
            tmp.setPrototypeBinding(pb) ;
          }
          else
          {
            Prototype p = (Prototype) el ;
            tmp.setPrototype(p) ;
          }
          
          result = tmp ;
          break ;
        }
        
        case FEATURE_GROUP_PROTOTYPE:
        case FEATURE_GROUP_PROTOTYPE_BINDING:  
        case SUBPROGRAM_GROUP_PROTOTYPE:
        case THREAD_GROUP_PROTOTYPE:
        case REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE:
        case PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE:
        {
          Element el = id.getOsateRef() ;
          GroupPrototypeHolder tmp = _fact.createGroupPrototypeHolder() ;
          if (el instanceof PrototypeBinding)
          {
            PrototypeBinding pb = (PrototypeBinding) el ;
            tmp.setPrototype(pb.getFormal()) ;
            tmp.setPrototypeBinding(pb) ;
          }
          else
          {
            Prototype p = (Prototype) el ;
            tmp.setPrototype(p) ;
          }
          result = tmp ;
          break ;
        }
        
        case IN_FEATURE_PROTOTYPE:
        case OUT_FEATURE_PROTOTYPE:
        case IN_OUT_FEATURE_PROTOTYPE:
        {
          Element el = id.getOsateRef() ;
          FeaturePrototypeHolder tmp = _fact.createFeaturePrototypeHolder() ;
          if (el instanceof PrototypeBinding)
          {
            PrototypeBinding pb = (PrototypeBinding) el ;
            tmp.setPrototype(pb.getFormal()) ;
            tmp.setPrototypeBinding(pb) ;
          }
          else
          {
            Prototype p = (Prototype) el ;
            tmp.setPrototype(p) ;
          }
          
          result = tmp ;
          break ;
        }
        
        default:
        {
          String errorMsg = "type: " + type.toString() + 
                " is not supported yet." ;
            System.err.println(errorMsg) ;
            throw new UnsupportedOperationException(errorMsg) ;
        }
      }
    }
    else
    {
      BehaviorFeatureType t = (BehaviorFeatureType) type ;
      
      switch(t)
      {
        case BEHAVIOR_VARIABLE:
        {
          BehaviorVariableHolder tmp = _fact.createBehaviorVariableHolder() ;
          tmp.setVariable((BehaviorVariable) id.getBaRef()) ;
          result = tmp ;
          break ;
        }
        
        case ITERATIVE_VARIABLE:
        {
          IterativeVariableHolder ivh = _fact.createIterativeVariableHolder() ;
          ivh.setIterativeVariable((IterativeVariable) id.getBaRef()) ;
          result = ivh ;
          break ;
        }
      
        default:
        {
          String errorMsg = "type: " + type.toString() + 
                " is not supported yet." ;
            System.err.println(errorMsg) ;
            throw new UnsupportedOperationException(errorMsg) ;
        }
      }
    }
    
    result.setLocationReference(id.getLocationReference()) ;
    
    _hl.addToHyperlinking(id.getAadlBaLocationReference(), result) ;    
    
    return result ;
  }

  private void reportDimensionException(DimensionException de)
  {
    StringBuilder msg = new StringBuilder();
    
    if(de._element instanceof BehaviorElement)
    {
      msg.append('"') ;
      msg.append(this.unparseNameElement((BehaviorElement) de._element)) ;
      msg.append("\" ") ;
    }
    
    msg.append(de.getMessage());
    
    _errManager.error(de._element, msg.toString()) ;
  }

 // This method checks the given object and returns a value constant
 // resolved from semantic ambiguities and its data representation. On error,
 // reports error and returns null.
 private ValueAndTypeHolder valueConstantCheck(ValueConstant v)
 {
   ValueAndTypeHolder result = null ;
   ValueConstant tmpResult = null ;
   
   if(v instanceof DeclarativePropertyReference)
   {
     tmpResult = propertyReferenceResolver((DeclarativePropertyReference) v) ;
   }
   else // Literal cases. Nothing to do.
   {
     tmpResult = v ;
   }

   if (tmpResult != null)
   {
     result = getValueAndTypeHolder(tmpResult, v) ;
   }
   
   return result ;
 }
  
  private ValueConstant propertyReferenceResolver(DeclarativePropertyReference
                                                  ref)
  {
    ValueConstant result = null ;
    
    if(ref.isPropertySet())
    {
      DeclarativePropertyName firstName = ref.getPropertyNames().get(0) ;
      
      // Property constant from a property set.
      if(firstName.getOsateRef() instanceof PropertyConstant)
      {
        BehaviorPropertyConstant tmp = _fact.createBehaviorPropertyConstant() ;
        tmp.setProperty((PropertyConstant) firstName.getOsateRef());
        if(ref.getQualifiedName() != null)
        {
          tmp.setPropertySet((PropertySet) ref.getQualifiedName().
                                                                 getOsateRef());
        }
        result = tmp ;
      }
      else // Property value case.
      {
        PropertySetPropertyReference tmp = _fact.
                                          createPropertySetPropertyReference() ;
        propertyNameListResolver(ref.getPropertyNames(), tmp.getProperties()) ;
        
        if(ref.getQualifiedName() != null)
        {
          tmp.setPropertySet((PropertySet) ref.getQualifiedName().
                                                                 getOsateRef());
        }
        result = tmp ;
      }
    }
    else if(ref.getQualifiedName() != null) // [qualified] classifier case. 
    {
      ClassifierPropertyReference tmp = _fact.createClassifierPropertyReference();
      tmp.setClassifier((Classifier) ref.getQualifiedName().getOsateRef());
      propertyNameListResolver(ref.getPropertyNames(), tmp.getProperties()) ;
      result = tmp ;
    }
    else // Classifier feature case.
    {
      ClassifierFeaturePropertyReference tmp = _fact.
                                    createClassifierFeaturePropertyReference() ;
      
      classifierFeatureResolver(tmp, ref.getReference()) ;
      propertyNameListResolver(ref.getPropertyNames(), tmp.getProperties()) ;
      result = tmp ;
    }
    
    result.setLocationReference(ref.getLocationReference());
    return result ;
  }

  private void propertyNameListResolver(EList<DeclarativePropertyName> dpns,
                                           EList<PropertyNameHolder> result)
  {
    PropertyNameHolder pnh = null ;
    PropertyElementHolder peh = null ;
    EList<IntegerValue> indexes = null ;
    LocationReference loc = null ;
    Element global, primary ;
    
    for(DeclarativePropertyName dpn : dpns)
    {
      pnh = _fact.createPropertyNameHolder() ;
      pnh.setLocationReference(dpn.getLocationReference());
      
      global = dpn.getOsateRef() ;
      primary = dpn.getPropertyName().getOsateRef() ;
      
      if(primary != global) // Item list case.
      {
        loc = dpn.getPropertyName().getLocationReference() ;
        peh = propertyElementHolderResolver(primary, loc);
      }
      else
      {
        loc = dpn.getLocationReference() ;
        peh = propertyElementHolderResolver(global, loc);
        
      }
      
      indexes = peh.getArrayIndexes() ;
      
      if(dpn.getField() != null)
      {
        pnh.setField(dpn.getField());
      }
      else
      {
        for(IntegerValue iv : dpn.getIndexes())
        {
          IntegerValue tmp = integerValueCheck(iv) ; // Report any error.
          if(tmp != null)
          {
            indexes.add(tmp) ;
          }
        }
      }
      
      pnh.setProperty(peh);
      result.add(pnh) ;
    }
  }
  
  private PropertyElementHolder propertyElementHolderResolver(Element el,
                                                              LocationReference loc)
  {
    PropertyElementHolder result = null ;
    
    if(el instanceof BasicProperty)
    {
      BasicProperty bp = (BasicProperty) el ;
      BasicPropertyHolder tmp = _fact.createBasicPropertyHolder() ;
      tmp.setBasicProperty(bp) ;
      result = tmp ; 
    }
    else if(el  instanceof PropertyAssociation)
    {
      PropertyAssociation pa = (PropertyAssociation) el ;
      PropertyAssociationHolder tmp = _fact.createPropertyAssociationHolder();
      tmp.setPropertyAssociation(pa);
      result = tmp ;
    }
    else if(el instanceof PropertyExpression)
    {
      PropertyExpression pe = (PropertyExpression) el ;
      PropertyExpressionHolder tmp = _fact.createPropertyExpressionHolder();
      tmp.setPropertyExpression(pe);
      result = tmp ;
    }
    else if(el instanceof PropertyType)
    {
      PropertyType pt = (PropertyType) el ;
      PropertyTypeHolder tmp = _fact.createPropertyTypeHolder();
      tmp.setPropertyType(pt);
      result = tmp ;
    }
    else if(el instanceof EnumerationLiteral)
    {
      EnumerationLiteral enumLit = (EnumerationLiteral) el ;
      EnumLiteralHolder tmp = _fact.createEnumLiteralHolder();
      tmp.setEnumLiteral(enumLit);
      result = tmp ;
    }
    else
    {
      String errorMsg = "type: " + el.getClass().getSimpleName() + 
            " is not supported yet." ;
        System.err.println(errorMsg) ;
        throw new UnsupportedOperationException(errorMsg) ;
    }
    
    result.setLocationReference(loc);
    return result ;
  }
  
  private void classifierFeatureResolver(ClassifierFeaturePropertyReference result,
                                         Reference ref)
  {
    List<ElementHolder> holders = refResolver(ref, null, TypeCheckRule.NOTHING,
                                                         TypeCheckRule.ALL) ;
    result.setComponent((ClassifierFeatureHolder) holders.get(0));
  }

  private boolean behaviorActionBlockCheck(BehaviorActionBlock bab)
  {
    boolean result = true ;

    if(bab.getTimeout() != null)
    {
      BehaviorTime resolvedTime = _fact.createBehaviorTime() ;
      result = behaviorTimeCheck((DeclarativeTime) bab.getTimeout(),
                                 resolvedTime) ;
      bab.setTimeout(resolvedTime) ;
    }

    result &= behaviorActionsCheck(bab.getContent(), bab) ;

    return result ;
  }

  private boolean behaviorActionsCheck(BehaviorActions bActs, Object 
                                                                parentContainer)
  {
    if(bActs instanceof BehaviorAction)
    {
      return behaviorActionCheck((BehaviorAction) bActs, parentContainer);
    }
    else // BehaviorCollection case.
    {
      boolean result = true ;

      ListIterator<BehaviorAction> it = ((BehaviorActionCollection)bActs).
                                            getActions().listIterator() ;
      while(it.hasNext()) 
      {
        BehaviorAction bAct = it.next() ;
        result &= behaviorActionCheck(bAct, it) ;
      }

      return result ;
    }
  }

  private boolean behaviorActionCheck(BehaviorAction bAct, Object 
                                                             parentContainer)
  {
    if(bAct instanceof BehaviorActionBlock)
    {
      return behaviorActionBlockCheck((BehaviorActionBlock) bAct) ;
    }
    else
    {
      if(bAct instanceof BasicAction)
      {
        return basicActionCheck((BasicAction) bAct, parentContainer) ;
      }
      else // Conditional statements cases.
      {
        return condStatementCheck((CondStatement) bAct) ;
      }
    }
  }

  private boolean condStatementCheck(CondStatement stat)
  {
    if(stat instanceof IfStatement)
    {
      return ifStatementCheck((IfStatement) stat) ;
    }
    else
    {
      if(stat instanceof ForOrForAllStatement)
      {
        return forOrForAllStatementCheck((ForOrForAllStatement) stat) ;
      }
      else // While or do until statement cases.
      {
        return whileOrDoUntilStatementCheck((WhileOrDoUntilStatement) stat);
      }
    }
  }

  private boolean whileOrDoUntilStatementCheck(WhileOrDoUntilStatement stat)
  {
    boolean result = behaviorActionsCheck(stat.getBehaviorActions(), stat) ;

    ValueExpression ve = stat.getLogicalValueExpression() ;

    ValueAndTypeHolder holder = valueExpressionCheck(ve) ;

    result &= typeCheck(ve, null, holder, DataRepresentation.BOOLEAN);

    return result ;
  }

  
  /**
   * Document: AADL Behavior Annex draft 
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.6 Behavior Action Language
   * Object : Check legality rule D.6.(L2) 
   * Keys : for forall iterative variable not valid assignment target
   * 
    */
  private boolean forOrForAllStatementCheck(ForOrForAllStatement stat)
  {
    IterativeVariable itVar = stat.getIterativeVariable() ;
    boolean result = iterativeVariableCheck(itVar) ;
    
    result &= behaviorActionsCheck(stat.getBehaviorActions(), stat) ;
    
    ElementValues tmp = elementValuesCheck(stat.getIteratedValues());
    result &= tmp != null ;

    // The returned element values may be different from the tested one
    // because of semantic ambiguity resolution in elementValuesCheck
    // method. So replace if needed.
    if(tmp != stat.getIteratedValues() && tmp != null)
    {
      stat.setIteratedValues(tmp) ;
    }

    // Matches the element values data type and the uccr's one.
    if(result)
    {
      TypeHolder eleType ;
      TypeHolder uccrType ;

      if(tmp instanceof IntegerRange)
      {
        IntegerRange ir = (IntegerRange) tmp ;
        TypeHolder t1, t2 ;
        try
        {
          t1 = AadlBaUtils.getTypeHolder((Value) ir.getLowerIntegerValue(),
                                         _baParentContainer);
          t2 = AadlBaUtils.getTypeHolder((Value) ir.getUpperIntegerValue(),
                                         _baParentContainer);
        }
        catch (DimensionException de)
        {
              reportDimensionException(de) ;
              return false ;
        }

        eleType = _dataChecker.getTopLevelType(t1, t2) ;
        // Integer Ranges are one dimension kind of integer collection.
        // => pass the arrayness checking.
        eleType.dimension = 1 ;
      }
      else // Name or DataComponentReference cases.
      {
        try
        {
           eleType = AadlBaUtils.getTypeHolder((Value) tmp) ;
        }
        catch (DimensionException de)
        {
          reportDimensionException(de) ;
          return false ;
        }
         
        if(tmp instanceof EventDataPortHolder)
        {
          // Event ports are one dimension events queue.
          // => pass the arrayness checking.
          eleType.dimension = 1 ;
        }
      }
      
      try
      {
         uccrType = AadlBaUtils.getTypeHolder(itVar);
      }
      catch (DimensionException de)
      {
        reportDimensionException(de) ;
        return false ;
      }
      
      // iterative variable's UCCR syntax cannot express array 
      // ([] are not allowed). Also, this implementation of AADL behavior
      // annex, doesn't allow the use of iterative variable's types which are
      // declared as array (data model annex).
      if(uccrType.dimension > 0)
      {
         StringBuilder message = new StringBuilder( 
            "the for/forall iterative variable's type cannot be an array.") ; 
               
         message.append(" Found \'");      
         message.append(uccrType.toString()); 
            message.append("\'.") ;
         reportError(tmp, message.toString()) ;
         result = false ;
      }
      
      if(_dataChecker.conformsTo(eleType, uccrType, false))
      {
         result=true;
      }
      else
      {
         StringBuilder sb = new StringBuilder(
               "\'iterative variable\' type error:");
         sb.append(" an array of \"") ;
         sb.append(uccrType.toString());
         sb.append("\" expected, found \"") ;
         sb.append(eleType.toString()) ;
         sb.append("\".");
         reportError(stat, sb.toString()) ;
      }
      
      // Checks data component reference arrayness and reports any error.
      if(eleType.dimension == 0)
      {
         String message = "\'" + unparseNameElement(tmp) + 
               "\' is not an array" ;
         reportError(tmp, message) ;
         result = false ;
      }
    }
    return result ;
  }
  
  private boolean iterativeVariableCheck(IterativeVariable itVar)
  {
    QualifiedNamedElement qne = (QualifiedNamedElement) 
                                                     itVar.getDataClassifier() ;
    
    // The statement's unique component reference reference has to be   
    // data classifier.
    Classifier dataClassifier = uniqueComponentClassifierReferenceResolver(qne,
                                                      TypeCheckRule.DATA_UCCR) ;
    
    itVar.setDataClassifier((DataClassifier) dataClassifier) ;
    
    return dataClassifier != null ;
  }


  // This method checks the given object and returns a element values
  // resolved from semantic ambiguities. On error, reports error and returns
  // null.
  private ElementValues elementValuesCheck(ElementValues ev)
  {
    if(ev instanceof IntegerRange)
    {
      if(integerRangeCheck((IntegerRange) ev))
      {
        return ev ;
      }
      else // Integer range error case.
      {
        return null ;
      }
    }
    else
    {
      TypeCheckRule stopRule = TypeCheckRule.EVENT_DATA_PORT ;
      TypeCheckRule[] checkRules  = new TypeCheckRule[]
            {TypeCheckRule.ELEMENT_VALUES,
             TypeCheckRule.DATA_COMPONENT_REFERENCE_OTHER_NAMES} ;
      
      List<ElementHolder> ehl = refResolver((Reference) ev, null, stopRule,
                                            checkRules) ;
      
      // Can reuse this method as PortHolder and DataComponentVariable are also
      // ElementValues.
      return (ElementValues) referenceToValueVariable(ehl) ;
    }
  }

  // Checks the given integer range and checks the consistency between 
  // the integer values.
  private boolean integerRangeCheck(IntegerRange ir)
  {
    boolean result = false ;

    IntegerValue original = ir.getLowerIntegerValue() ;
    IntegerValue tmp = integerValueCheck(original);

    result = tmp != null ;

    if(result && tmp != original)
    {
      ir.setLowerIntegerValue(tmp) ;
    }

    original = ir.getUpperIntegerValue() ;
    tmp = integerValueCheck(original);
    result &= tmp != null ;

    if(tmp != null && tmp != original)
    {
      ir.setUpperIntegerValue(tmp) ;
    }

    // Matches the two integer value data types.
    if(result)
    {
      TypeHolder t1, t2 ;
      
      try
      {
        t1 = AadlBaUtils.getTypeHolder((Value) ir.getLowerIntegerValue(),
                                       _baParentContainer) ;
        t2 = AadlBaUtils.getTypeHolder((Value) ir.getUpperIntegerValue(),
                                       _baParentContainer) ;
      }
      catch (DimensionException de)
         {
            reportDimensionException(de) ;
            return false ;
         }
      
      if(! _dataChecker.conformsTo(t1, t2, true))
      {
        result = false ;
        reportError(ir, "\'integer range\' error type : its integer values"+
            " are not consistent") ;
      }
    }

    return result ;
  }

  private boolean ifStatementCheck(IfStatement stat)
  {
    boolean result ;
    ValueAndTypeHolder holder = null ;
    
    ValueExpression ve = stat.getLogicalValueExpression() ;
    holder = valueExpressionCheck(ve) ;
    result = typeCheck(ve, null, holder, DataRepresentation.BOOLEAN) ;
    
    result &= behaviorActionsCheck(stat.getBehaviorActions(), stat);
    
    ElseStatement elseStat = stat.getElseStatement() ;
    
    if(elseStat != null)
    {
      // Elif case.
      if(elseStat instanceof IfStatement)
      {
        result &= ifStatementCheck((IfStatement) elseStat) ;
      }
      else
      {
        result &= behaviorActionsCheck(elseStat.getBehaviorActions(), elseStat);
      }
    }

    return result ;
  }
  
  @SuppressWarnings("all")
  private boolean basicActionCheck(BasicAction ba, Object parentContainer)
  {
    if(ba instanceof AssignmentAction)
    {
      return assignmentActionCheck((AssignmentAction) ba) ;
    }
    else
    {
      if (ba instanceof CommunicationAction)
      {
        CommunicationAction resolvedCommAct =
                            communicationActionCheck((CommunicationAction) ba) ;
        boolean result = resolvedCommAct != null ;
        
        // The returned communication action may be different from the
        // tested one because of semantic ambiguity resolution in
        // communicationActionCheck method. So replace if needed.
        if(resolvedCommAct != ba && result)
        {
          // [DEBUG]
          boolean hasBeenReplaced = false ;
          
          if(parentContainer instanceof ListIterator<?>)
          {
            ((ListIterator) parentContainer).set(resolvedCommAct) ;
            hasBeenReplaced = true ;
          }
          else if(parentContainer instanceof ElseStatement) 
          {
             // And also IfStatement.
            ((ElseStatement)parentContainer).setBehaviorActions(resolvedCommAct);
            hasBeenReplaced = true ;
          }
          else if(parentContainer instanceof LoopStatement)
          {
            ((LoopStatement)parentContainer).setBehaviorActions(resolvedCommAct);
            hasBeenReplaced = true ;
          }
          else if(parentContainer instanceof BehaviorActionBlock)
          {
            ((BehaviorActionBlock)parentContainer).setContent(resolvedCommAct);
            hasBeenReplaced = true ;
          }
          
          if (! hasBeenReplaced)
          {
            String msg = "The resolved communication action: " +  
                  unparseNameElement(resolvedCommAct) + 
                  " hasn't been set" ;
            
            System.err.println(msg) ;
            throw new RuntimeException(msg);
          }
        }

        return  result;
      }
      else // Timed action case.
      {
        return timedActionCheck((TimedAction) ba) ;
      }
    }
  }

  private boolean timedActionCheck(TimedAction ta)
  {
    BehaviorTime resolvedTime = _fact.createBehaviorTime() ;
    
    boolean result = behaviorTimeCheck((DeclarativeTime) ta.getLowerTime(),
                                       resolvedTime);
    ta.setLowerTime(resolvedTime) ;

    if (ta.getUpperTime() != null)
    {
      resolvedTime = _fact.createBehaviorTime() ;
      result &= behaviorTimeCheck((DeclarativeTime) ta.getUpperTime(),
                                  resolvedTime);
      ta.setUpperTime(resolvedTime) ;
    }
    
    if(ta.isSetProcessorClassifier())
    {
      List<ProcessorClassifier> qnes = new ArrayList<ProcessorClassifier>
                                          (ta.getProcessorClassifier().size()) ; 
      qnes.addAll(ta.getProcessorClassifier())       ;
      ta.unsetProcessorClassifier();
      
      QualifiedNamedElement qne ;
      Classifier tmp ;
      
      for(int i = 0 ; i < qnes.size() ; i++)
      {
        qne = (QualifiedNamedElement) qnes.get(i) ;
        tmp = uniqueComponentClassifierReferenceResolver(qne,
                                                 TypeCheckRule.PROCESSOR_RULE) ;
        if(tmp != null)
        {
          try
          { 
            ta.getProcessorClassifier().add((ProcessorClassifier) tmp) ;
          }
          catch(IllegalArgumentException e)
          {
            // if the user set the same more than once.
            System.out.println("catch IllegalArgumentException AadlTypeChecker") ;
          }
        }
        else
        {
          result = false ;
        }
      }
    }
    
    return result ;
  }

  private PortDequeueAction portDequeueActionResolver(CommAction comAct)
  {
    Target tarTmp = null ;
    boolean tarCheckResult = true ;
    TypeCheckRule stopOnThisRule = TypeCheckRule.IN_PORT ;
    TypeCheckRule checkRule = TypeCheckRule.PORT_DEQUEUE_VALUE ; 
    List<ElementHolder> resolvedRef = refResolver(comAct.getReference(), null,
                                                  stopOnThisRule, checkRule) ;
    
    if(comAct.getTarget() != null)
    {
      tarTmp = targetCheck(comAct.getTarget(), stopOnThisRule) ;
      if(tarTmp == null)
      {
        tarCheckResult = false ;
      }
    }
    
    if(resolvedRef != null)
    {
      if(tarCheckResult)
      {
        PortHolder portHolder = (PortHolder) resolvedRef.get(0) ;
        PortDequeueAction result = _fact.createPortDequeueAction() ;
        result.setPort((ActualPortHolder) portHolder) ;
        
        // Port dequeue action may not have any target.
        if(tarTmp != null)
        {
          result.setTarget(tarTmp) ;
          
          // Matches the target's data type with the input port's one 
          // when port dequeue action.
          TypeHolder tarType, portType ;
          
          try
          {
              portType = AadlBaUtils.getTypeHolder(portHolder,
                                                   _baParentContainer) ;
              tarType = AadlBaUtils.getTypeHolder(tarTmp, _baParentContainer) ;
          }
          catch (DimensionException de)
          {
            de._element = comAct ;
            reportDimensionException(de) ;
            return null  ;
          }
          
          if (false == _dataChecker.conformsTo(portType, tarType, true))
          {
            reportTypeError(comAct, "port dequeue action",
                            portType.toString(),
                            tarType.toString()) ;
            return null ;
          }
        }
        
        result.setLocationReference(comAct.getLocationReference()) ;
        
        return result ;
      }
      else
      {
        return null ;
      }
    }
    else
    {
      return null ;
    }
  }
  
  
  private SubprogramCallAction qualifiedSubprogramClassifierCallActionResolver
                                                             (CommAction comAct)
  {
    QualifiedNamedElement qne = comAct.getQualifiedName() ;
    TypeCheckRule rule = TypeCheckRule.SUBPROGRAM_UCCR ; 
    Subprogram sub = (Subprogram) 
                       uniqueComponentClassifierReferenceResolver(qne, rule) ;
    if(sub != null)
    {
      // Gets subprogram type.
      Classifier subprogType = subprogramTypeCheck(comAct) ;
      
      // Checks and resolves parameter labels.
      // Event if the subprogram call action doesn't have any parameter labels,
      // the subprogram type may have and vice versa: 
      // subprogramParameterListCheck is also design for these cases. 
      // It also binds the subprogram type found to the subprogram call action. 
      if(subprogType != null)
      {
        if (subprogramParameterListCheck(comAct, comAct.getParameters(),
                                         subprogType))
        {
          SubprogramCallAction result = _fact.createSubprogramCallAction() ;
          SubprogramHolder sh = _fact.createSubprogramHolder() ;
          sh.setLocationReference(comAct.getLocationReference()) ;
          sh.setSubprogram(sub) ;
          result.setSubprogram(sh) ;
          result.setLocationReference(comAct.getLocationReference()) ;
          result.getParameterLabels().addAll(comAct.getParameters()) ;
          return result ;
        }
        else
        {
          return null ;
        }
      }
      else
      {
        return null ;
      }
    }
    else
    {
      return  null ;
    }
  }
  
  // This method checks the given object and returns a communication action
  // resolved from semantic ambiguities. On error, reports error and returns
  // null.
  /**
   * Document: AADL Behavior Annex draft 
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.6 Behavior Action Language
   * Object : Check legality rule D.6.(L6) 
   * Keys : dequeue value port target
   */
  private CommunicationAction communicationActionCheck(CommunicationAction ca)
  {
    CommAction comAct = (CommAction) ca ;
    
    // Subprogram qualified classifier call.
    if(comAct.getQualifiedName() != null)
    {
      return qualifiedSubprogramClassifierCallActionResolver(comAct) ;
    }
    // Port dequeue call.
    else if(comAct.isPortDequeue())
    {
      return portDequeueActionResolver(comAct) ;
    }
    // Port freeze call.
    else if(comAct.isPortFreeze())
    {
      return portFreezeActionResolver(comAct);
    }
    // Shared action call.
    else if (comAct.isLock() || comAct.isUnlock())
    {
      return sharedActionResolver(comAct) ;
    }
    else // Ambiguous cases.
    {
      return subprogramCallActionAndPortSendActionResolver(comAct) ;
    }
  }
  
  // Resolves semantic ambiguities (subprogram call and port send action).
  // On error, reports error and returns null.
  private CommunicationAction subprogramCallActionAndPortSendActionResolver
                                                             (CommAction comAct)
  {
    TypeCheckRule stopOnThisRule = TypeCheckRule.OUT_PORT ;
    TypeCheckRule[] checkRules = new TypeCheckRule[]
          { TypeCheckRule.SUBPROGRAM_CALL_ACTION_FIRST_NAME,
            TypeCheckRule.SUBPROGRAM_CALL_ACTION_SD_NAME
          } ;
    
    List<ElementHolder> resolvedRef = refResolver(comAct.getReference(),
                                                  null, stopOnThisRule,
                                                  checkRules) ;
    
    if(resolvedRef != null)
    {
      // Port send action case.
      if(resolvedRef.get(0) instanceof PortHolder)
      {
        ActualPortHolder portHolder = (ActualPortHolder) resolvedRef.get(0) ;
        return portSendActionResolver(portHolder, comAct) ;
      }
      else // Subprogram call action case. 
      {
        return subprogramCallActionResolver(resolvedRef, comAct) ;
      }
    }
    else
    {
      return null ;
    }
  }

  private SubprogramCallAction subprogramCallActionResolver
                                               (List<ElementHolder> resolvedRef,
                                                CommAction comAct)
  {
    // Gets subprogram type.
    Classifier subprogType = subprogramTypeCheck(comAct) ;
    
    // Checks and resolves parameter labels.
    // Event if the subprogram call action doesn't have any parameter labels,
    // the subprogram type may have and vice versa : 
    // subprogramParameterListCheck is also design for these cases. 
    // It also binds the subprogram type found to the subprogram call action. 
    if(subprogType != null)
    {
      if (subprogramParameterListCheck(comAct, comAct.getParameters(),
                                       subprogType))
      {
        SubprogramCallAction result = _fact.createSubprogramCallAction() ;
        result.getParameterLabels().addAll(comAct.getParameters()) ;
        
        ElementHolder firstHolder = resolvedRef.get(0) ;
        ElementHolder secondHolder = null ;
        
        if(resolvedRef.size() == 2)
        {
          secondHolder = resolvedRef.get(1) ;
        }
        
        if(firstHolder instanceof SubprogramHolderProxy) 
        {
          // RefResolver can't detect that error. So do it.
          if(resolvedRef.size() != 2)
          {
            String msg = "missing subprogram access for : " + 
              firstHolder.getElement().getName() ;
            
            reportError(firstHolder, msg) ;
            
            return null ;
          }
          else
          {
            result.setProxy((SubprogramHolderProxy) firstHolder) ;
            result.setSubprogram((CalledSubprogramHolder) secondHolder) ;
          }
        }
        else
        {
          result.setSubprogram((CalledSubprogramHolder) firstHolder) ;
        }
        
        result.setLocationReference(comAct.getLocationReference()) ;
        
        return result ;
      }
      else
      {
        return null ;
      }
    }
    else
    {
      return null ;
    }
  }

  private CommunicationAction portSendActionResolver(ActualPortHolder portHolder,
                                                     CommAction comAct)
  {
    PortSendAction portSendActionResult = _fact.createPortSendAction() ;
    
    if(comAct.isSetParameters())
    {
      List<ParameterLabel> pll = comAct.getParameters() ;
      
      if(pll.size() == 1)
      {
        ValueExpression ve = (ValueExpression) pll.get(0) ;

        ValueAndTypeHolder tmp = valueExpressionCheck(ve) ;

        if(tmp != null)
        {
          portSendActionResult.setPort(portHolder) ;
          
          // Matches the value expression top level data type 
          // with the port data type.
          TypeHolder portType ;
          
          try
          {
             portType = AadlBaUtils.getTypeHolder(portHolder, _baParentContainer) ;
          }
          catch (DimensionException de)
          {
             reportDimensionException(de) ;
             return null ;
          }
              
          if(! _dataChecker.conformsTo(portType,
              tmp.typeHolder, true))
          {
            reportTypeError(comAct, "port send action",
                portType.toString(),
                tmp.typeHolder.toString());
            return null ;
          }
          else
          {
            ValueExpression veTmp = (ValueExpression) 
                tmp.value ;
            portSendActionResult.setValueExpression(veTmp) ;
          }
        }
        else // Value expression checking has failed.
        {
          return null ;
        }
      }
      else // Error case : Port send action has only one value expression.
      {
        return null ;
      }
    }
    else
      portSendActionResult.setPort(portHolder);
    
    portSendActionResult.setLocationReference(comAct.getLocationReference());
    
    return portSendActionResult ;
  }

  private SharedDataAction sharedActionResolver(CommAction comAct)
  {
    DataAccessHolder dah = null ;
    SharedDataAction result = null ;
    
    if(comAct.getReference() != null)
    {
      TypeCheckRule checkRules = TypeCheckRule.SHARED_DATA_ACTION ;
      TypeCheckRule stopOnThisRule = checkRules ;
      List<ElementHolder> resolvedRef = refResolver(comAct.getReference(),
                                                    null,
                                                    stopOnThisRule, checkRules);
      if(resolvedRef != null)
      {
        dah = (DataAccessHolder) resolvedRef.get(0) ;
      }
      else
      {
        return null ;
      }
    }
    
    if(comAct.isLock())
    {
      result = _fact.createLockAction() ;
    }
    else
    {
      result = _fact.createUnlockAction() ;
    }
    
    result.setDataAccess(dah) ;
    result.setLocationReference(comAct.getLocationReference()) ;
    
    return result ;
  }

  private PortFreezeAction portFreezeActionResolver(CommAction comAct)
  {
    TypeCheckRule checkRules = TypeCheckRule.IN_PORT ;
    TypeCheckRule stopOnThisRule = TypeCheckRule.PORT_FREEZE_ACTION ;
    
    PortFreezeAction pfa = _fact.createPortFreezeAction() ;
    
    List<ElementHolder> resolvedRef = refResolver(comAct.getReference(), pfa,
                                          stopOnThisRule, checkRules) ;
    if(resolvedRef != null)
    {
      return (PortFreezeAction) resolvedRef.get(0) ;
    }
    else
    {
      return null ;
    }
  }

  // Recursive method.
  private Classifier getSubprogramType(CalledSubprogram sc)
  {
    Classifier result = null ;
    
    if(sc instanceof SubprogramImplementation)
    {
      result = ((SubprogramImplementation) sc).getType() ;
    }
    else if (sc instanceof SubprogramType)
    {
      result = (SubprogramType) sc ;
    }
    else if(sc instanceof SubprogramAccess)
    {
      SubprogramAccess sa = (SubprogramAccess) sc ;
      result = sa.getClassifier() ;
    }
    else if(sc instanceof SubprogramSubcomponent)
    {
      SubprogramSubcomponent ss = (SubprogramSubcomponent) sc ;
      result = ss.getClassifier() ;
    }

    return result ;
  }

  // Gets subprogram type binded to the given subprogram call action.
  // On error, reports error and returns null.
  private Classifier subprogramTypeCheck(CommAction comAct)
  {
    Element el = null ; 
    
    if(comAct.getReference() != null)
    {
      el = comAct.getReference().getOsateRef() ;
    }
    else
    {
      el = comAct.getQualifiedName().getOsateRef() ;
    }
    
    Classifier result = null ;
    String errorMsg = null ;
    
    if(el instanceof ComponentPrototype)
    {
      ComponentPrototype cp = (ComponentPrototype) el ;

      if(cp instanceof SubprogramPrototype)
      {
        ComponentClassifier cc = cp.getConstrainingClassifier() ;
        
        if (cc != null && cc instanceof SubprogramType)
        {
          result = (SubprogramType) cc ;
        }
        else
        {
          errorMsg = " is not a defined subprogram prototype" ;
          result = null ;
        }
      }
      else
      {
        errorMsg = " is not an subprogram prototype" ;
        result = null ;
      }
    }
    else if(el instanceof CalledSubprogram) // Always after ComponentPrototype 
    {                                       // case.
      result = getSubprogramType((CalledSubprogram) el) ;
    }
    else if (el instanceof ComponentPrototypeBinding)
    {
      ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) el ;

      // Takes the last binding.
      ComponentPrototypeActual cpa = cpb.getActuals().
          get(cpb.getActuals().size() -1) ;

      if(cpa.getSubcomponentType() instanceof SubprogramType)
      {
        result = (SubprogramType) cpa.getSubcomponentType() ;
      }
      else
      {
        errorMsg = " is not an subprogram prototype" ;
        result = null ;
      }
    }
    else // Error case : the binded object is not an subprogram.
    {
      errorMsg =  "is not subprogram" ;
      result = null ;
    }

    // Error reporting.
    if(result == null && errorMsg != null)
    {
      String subprogramName = unparseReference(comAct.getReference()) ;
      reportError(comAct, '\'' + subprogramName + '\'' + errorMsg) ;
    }
    
    return result ;
  }

  // This method checks the given parameter labels and matches them against the 
  // subprogram parameters. It resolves target/value expression semantic
  // ambiguities. On error, reports error and returns false.
  // Event if the subprogram call action doesn't have any parameter labels,
  // the subprogram type may have and vice versa : subprogramParameterListCheck
  /// is also design for these cases.
  /**
   * Document: AADL Behavior Annex draft 
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.6 Behavior Action Language
   * Object : Check legality rule D.6.(L5) 
   * Keys : parameter list match signature subprogram call
   */
  private boolean subprogramParameterListCheck(CommAction comAct,
                                               EList<ParameterLabel> callParams,
                                               Classifier subprogType)
  {
    // Fetches sorted subprogram feature list.
    
    List<Feature> tmp = Aadl2Utils.orderFeatures(subprogType) ;
    List<Feature> subprogFeat = new ArrayList<Feature>(tmp.size()) ;
    
    for(Feature feat : tmp)
    {
      if(feat instanceof DataAccess || feat instanceof Parameter)
      {
        subprogFeat.add(feat) ;
      }
    }
    
    // Matching the parameter labels with the subprogram signature.
    // Resolves ambiguity between target and value expression:
    // value expression are for in parameter, target are for out parameter.

    //Preliminary checking : on error, reports error and exit early.
    if(callParams.size() != subprogFeat.size())
    {
      String subprogramName = null ;
      
      if(comAct.getReference() != null)
      {
        subprogramName = unparseReference(comAct.getReference()) ;
      }
      else
      {
        subprogramName = unparseQualifiedNamedElement(comAct.getQualifiedName());
      }
      
      reportError(comAct, "Invalid number of argument(s) for the subprogram " + 
          subprogramName) ;
      return false ;
    }

    boolean isconsistent = true ;
    boolean hasCheckingPassed = true ;

    Enum<?> currentDirRight  ;
    ValueExpression valueExp ;
    ListIterator<ParameterLabel> it = callParams.listIterator() ;
    Value v ;
    Target tar ;
    TypeHolder t1, t2 ;
    ValueAndTypeHolder vth ;

    List<TypeHolder> typesFound = new ArrayList<TypeHolder>(callParams.size());
    List<Enum<?>> dirRightsFound = new ArrayList<Enum<?>> (callParams.size()) ;

    List<TypeHolder> expectedTypes = new ArrayList<TypeHolder>
    (subprogFeat.size());
    List<Enum<?>> expectedDirRight = new ArrayList<Enum<?>>
    (subprogFeat.size()) ;

    // As AADL standard doesn't allow subprogram overloading (two subprogram
    // classifier names can't be the same), parameter labels checking is 
    // driven by the subprogram signature.
    for(Feature feat : subprogFeat)
    {
      if(feat instanceof Parameter)
      {
        Parameter param = (Parameter) feat ;
        currentDirRight = param.getDirection() ;
        expectedDirRight.add(currentDirRight) ;
      }
      else // DataAccess case.
      {
        DataAccess data = (DataAccess) feat ;
        currentDirRight = Aadl2Utils.getDataAccessRight(data) ;
        expectedDirRight.add(currentDirRight) ;
      }
      
      valueExp = (ValueExpression) it.next() ;
      
      Classifier klass = AadlBaUtils.getClassifier(feat,_baParentContainer);
      
      // ValueExpression case.
      if(currentDirRight == DirectionType.IN ||
         currentDirRight == Aadl2Utils.DataAccessRight.read_only)
      {
        vth = valueExpressionCheck(valueExp) ;

        if(vth != null)
        {
          try
          {
             t1 = AadlBaUtils.getTypeHolder(klass) ;
          }
          catch (DimensionException de)
          {
            reportDimensionException(de) ;
            return false ;
          }
          
          t2 = vth.typeHolder ;
          expectedTypes.add(t1) ;
          typesFound.add(t2) ;
          dirRightsFound.add(DirectionType.IN);

          if(! _dataChecker.conformsTo(t1, t2, true))
          {
            isconsistent = false ;
          }
        }
        else // Value expression checking error case.
        {
          // Error reporting has already been done.
          hasCheckingPassed = false ;
        }
      }
      else if(currentDirRight != Aadl2Utils.DataAccessRight.unknown)
      {
        v = AadlBaUtils.isOnlyOneValue(valueExp) ;

        if(v instanceof Target) // Target case.
        {
          TypeCheckRule stopOnThisRule = TypeCheckRule.DATA_ACCESS;
          tar = targetCheck((Target) v, stopOnThisRule) ;

          if(tar != null)
          {
            try
            {
               t1 = AadlBaUtils.getTypeHolder(klass) ;
               t2 = AadlBaUtils.getTypeHolder(tar, _baParentContainer) ;
            }
            catch (DimensionException de)
                {
                   reportDimensionException(de) ;
                   return false ;
                }
            
            expectedTypes.add(t1) ;
            typesFound.add(t2) ;
            
            Enum<?> dirRightFound = AadlBaUtils.getDirectionType(tar) ;
            
            if(dirRightFound == null)
            {
              dirRightFound = AadlBaUtils.getDataAccessRight(tar) ;
            }
            
            dirRightsFound.add(dirRightFound) ;

            if(! _dataChecker.conformsTo(t1, t2, true))
            {
              isconsistent = false ;
            }
            else
            {
              // As checking passed and ambiguity between
              // ValueExpression and Target has been resolved, it replaces
              // the value expression by the target as parameter label.
              it.set(tar) ;
            }
          }
          else // Target checking error case.
          {
            // Error reporting has already been done.
            hasCheckingPassed = false ;
          }
        }
        else // Value expression taken as a target -> warning arithmetic pointer operation.
        {
          // Due to target/value expression semantic ambiguity, the parsing
          // phase may have introduced a semantic errors :

          // If v == null :               
          // The parameter label has
          // to be a value expression with a single value when the expected
          // subprogram parameter is IN_OUT or OUT.

          // If v is not instanceof Target but ValueExpression or Value 
          // like :
          //       _ IntegerConstant or ValueConstant
          //       _ PortFreshValue
          //       _ PortCountValue
          //       _ PortDequeueValue
          // It resolves the type in order to format the warning message:
          
          vth = valueExpressionCheck(valueExp) ;

          if(vth != null)
          {
            try
            {
               t1 = AadlBaUtils.getTypeHolder(klass) ;
            }
            catch (DimensionException de)
            {
              reportDimensionException(de) ;
              return false ;
            }
            
            t2 = vth.typeHolder ;
            expectedTypes.add(t1) ;
            typesFound.add(t2) ;
            dirRightsFound.add(DirectionType.IN);
            
            StringBuilder msg = new StringBuilder() ;
            msg.append('\'');
            msg.append(unparseNameElement(valueExp)) ;
            msg.append("\': is an read only value and it is used as a writable value");
            
            // Reports a warning.
            reportWarning(valueExp, msg.toString());
          }
          else
          {
            // Error reporting has already been done.
            hasCheckingPassed = false ;
          }
        }
      }
      else
      {
        reportError(valueExp, "can't fetch data access right. Set the default "+
                              "right in memory_properties.aadl") ;
      }
    }

    // Reports consistency error.
    if(! isconsistent && hasCheckingPassed)
    {
      String subprogramName = null ;
      
      if(comAct.getReference() != null)
      {
        subprogramName = unparseReference(comAct.getReference()) ;
      }
      else
      {
        subprogramName = unparseQualifiedNamedElement(comAct.getQualifiedName());
      }
      
      reportSubprogParamMatchingError(comAct, subprogramName, expectedTypes,
          expectedDirRight, typesFound,
          dirRightsFound) ;
    }

    return isconsistent && hasCheckingPassed ;
  }

  private void reportWarning(Element el, String msg)
  {
    _errManager.warning(el, msg) ;
  }

  private void reportSubprogParamMatchingError(
                                         BehaviorElement e,
                                         String subprogramName,
                                         List<TypeHolder> expectedTypes,
                                         List<Enum<?>> expectedDirections,
                                         List<TypeHolder> typesFound,
                                         List<Enum<?>> directionsFound)
  {
    StringBuilder msg = new StringBuilder("The subprogram ") ;
    msg.append(subprogramName);
    msg.append('(');

    if(! expectedTypes.isEmpty())
    {
      int index = 0 ;

      for(TypeHolder th : expectedTypes)
      {
        msg.append(expectedDirections.get(index++)) ;
        msg.append(' ') ;
        msg.append(th.toString()) ;
        msg.append(STRING_PARAMETER_SEPARATOR) ;
      }

      // Remove the last separator.
      msg.delete(msg.length()- STRING_PARAMETER_SEPARATOR.length(),
          msg.length()) ;
    }

    msg.append(") is not applicable for the arguments (");

    if(! typesFound.isEmpty())
    {
      int index = 0 ;

      for(TypeHolder th : typesFound)
      {
        msg.append(directionsFound.get(index++)) ;
        msg.append(' ') ;
        msg.append(th.toString()) ;
        msg.append(STRING_PARAMETER_SEPARATOR) ;
      }

      // Remove the last separator.
      msg.delete(msg.length()- STRING_PARAMETER_SEPARATOR.length(),
          msg.length()) ;

    }

    msg.append(')');

    reportError(e, msg.toString()) ;
  }

  /**
   * Document: AADL Behavior Annex draft 
   * Version : 0.94 
   * Type : Legality rule
   * Section : D.6 Behavior Action Language
   * Object : Check legality rule D.6.(L1) 
   * Keys : assignment action value expression target match type consistency
   */
  private boolean assignmentActionCheck(AssignmentAction aa)
  {
    TypeCheckRule stopOnThisRule = TypeCheckRule.ASSIGNMENT_TARGET;
    Target tmp = targetCheck(aa.getTarget(), stopOnThisRule) ;

    boolean result = tmp != null ;

    TypeHolder tarType, expType ;
    tarType = expType = null ;

    // The returned target may be different from the tested target
    // because of semantic ambiguity resolution in targetCheck
    // method. So replace if needed.
    if(tmp != aa.getTarget() && result)
    {
      aa.setTarget(tmp) ;
    }

    ValueExpression ve = aa.getValueExpression() ;
    
    if(ve != null && (false == ve instanceof Any))
    {
      ValueAndTypeHolder vth = 
          valueExpressionCheck(aa.getValueExpression()) ;
      if (vth != null)
      {
        expType = vth.typeHolder ;
      }
      else
      {
        result = false ;
      }

      if(result)
      {
        // Performs data type consistency checking.
        try
        {
           tarType = AadlBaUtils.getTypeHolder(tmp, _baParentContainer) ;
        }
        catch (DimensionException de)
        {
           reportDimensionException(de) ;
              return false ;
        }
        
        result = _dataChecker.conformsTo(tarType, expType, true) ;
        
        if(! result)
        {
          reportTypeError(vth.value, "assignment",
              tarType.toString(), expType.toString()) ;
        }
      }
    }

    return result ;
  }

  // Semantic rule about iterative variable assignment is checked.
  // This method checks the given object and returns an object resolved from
  // semantic ambiguities. On error, reports error and returns null.
  private Target targetCheck(Target tar, TypeCheckRule stopOnThisRule)
  {
    TypeCheckRule[] checkRules = new TypeCheckRule[]
          {
            TypeCheckRule.TARGET_COMPONENT_REFERENCE_FIRST_NAME,
            TypeCheckRule.DATA_COMPONENT_REFERENCE_OTHER_NAMES
          } ; 
    
    List<ElementHolder> resolvedRef = refResolver((Reference) tar, null,
                                                  stopOnThisRule, checkRules) ;
    
    return (Target) referenceToValueVariable(resolvedRef) ;
  }
  
  // Compares the given expected data representation to the ValueAndTypeHolder
  // one. Returns true is the data representation are the same.
  // Otherwise returns false and reports error.
  // If the given ValueAndTypeHolder object is null, it returns false without 
  // reporting any error (error reporting has already been done ?).
  // If the given name is null, the method will unparse the given element.
  private boolean typeCheck(BehaviorElement e, String name,
                            ValueAndTypeHolder holder,
                            DataRepresentation expectedDataRepresentation)
  {
    boolean result = false ;

    if(holder != null)
    {
      result = expectedDataRepresentation == holder.typeHolder.dataRep ;

      if(! result)
      {
        if (name == null)
        {
          name = unparseNameElement(e) ;
        }
        reportTypeError(e, name, expectedDataRepresentation.getName(),
            holder.typeHolder.toString()) ;
      }
    }

    return result ;
  }

  /**
   * Return the element binded to the given declarative behavior element.
   * 
   * @param el the given declarative behavior element
   * @return the binded element
   */
  static  Element getBindedElement(DeclarativeBehaviorElement el)
  {
    org.osate.aadl2.Element result = el.getOsateRef() ;

    if(result == null)
    {
      result = el.getBaRef() ;
    }

    return result ;
  }
  
  /**
   * Returns the feature type of the element binded to the given behavior
   * annex element.
   * 
   * @param el the given behavior annex element
   * @return the feature type of the binded element
   */
  static Enum<?> getType(DeclarativeBehaviorElement el)
  {
    org.osate.aadl2.Element testedEl = AadlBaTypeChecker.getBindedElement(el);

    Enum<?> result ;

    if (testedEl instanceof BehaviorElement)
    {
      result = AadlBaUtils.getBehaviorAnnexFeatureType(
          (BehaviorElement)testedEl);
    }
    else
    {
      result = AadlBaUtils.getFeatureType(testedEl) ;
    }

    return result ;
  }
  
  /**
   * Checks the type of the reference binded to the given declarative behavior
   * element within the given rule's expected types. Returns the
   * matching feature type or {@code null} otherwise. Reports any error if 
   * hasToReport is {@code true}.
   *
   * @param dbe the declarative behavior element to be checked
   * @param name the behavior element's name
   * @param rule the checking rule that contains the expected types
   * @param hasToReport flag for report error
   * @return the matching feature type or {@code null}
   */
  private Enum<?> typeCheck(DeclarativeBehaviorElement dbe, String name,
                            TypeCheckRule rule, boolean hasToReport)
  {
    Enum<?> result = rule.test(dbe, _baParentContainer) ;

    if(result == null && hasToReport)
    {

      Enum<?> testedEnum = AadlBaTypeChecker.getType(dbe) ;

      // Resolves feature prototype binding.
      if(testedEnum == FeatureType.FEATURE_PROTOTYPE_BINDING)
      {
        Element el = AadlBaTypeChecker.getBindedElement(dbe) ;
        testedEnum = AadlBaUtils.getFeatPrototypeType(
            (FeaturePrototypeBinding) el) ;
      }

      String expectedTypes = rule.getExpectedTypes(STRING_TYPE_SEPARATOR) ;
      String typeFound = ((Enumerator) testedEnum).getLiteral();
      reportTypeError(dbe, name, expectedTypes, typeFound) ;
    }

    return result ;
  }

  // Convenient class that holds a value and its type representation.
  private class ValueAndTypeHolder
  {
    public Value value ;
    public TypeHolder typeHolder ;

    public ValueAndTypeHolder(Value v, TypeHolder typeHolder)
    {
      this.value = v ;
      this.typeHolder = typeHolder ;
    }
  }

  // Behavior annex type checking rules.
  // Based on a design pattern command.
  private enum TypeCheckRule implements Enumerator
  {
    ALL ("any type", new Enum[] {})
    {
      @Override
      public Enum<?> testTypeCheckRule(Enum<?> other)
      {
        return other ;
      }
    },
    
    NOTHING ("no type", new Enum[] {})
    {
      @Override
      public Enum<?> test(DeclarativeBehaviorElement dbe,
                          ComponentClassifier baParentContainer)
      {
        return null ;  
      }
    },
    
    IN_EVENT_PORT("in event port", new Enum[]
          {FeatureType.IN_EVENT_PORT,
           FeatureType.IN_OUT_EVENT_PORT}),

    IN_EVENT_DATA_PORT("in event data port", new Enum[]
          {FeatureType.IN_EVENT_DATA_PORT,
           FeatureType.IN_OUT_EVENT_DATA_PORT}),

    EVENT_DATA_PORT("event data port", new Enum[]
          {FeatureType.IN_EVENT_DATA_PORT,
           FeatureType.OUT_EVENT_DATA_PORT,
           FeatureType.IN_OUT_EVENT_DATA_PORT}),

    IN_PORT("in port", new Enum[]
          {FeatureType.IN_DATA_PORT,
           FeatureType.IN_OUT_DATA_PORT,
           FeatureType.IN_EVENT_PORT,
           FeatureType.IN_OUT_EVENT_PORT,
           FeatureType.IN_EVENT_DATA_PORT,
           FeatureType.IN_OUT_EVENT_DATA_PORT}),

    OUT_PORT("out port", new Enum[]
          {FeatureType.OUT_DATA_PORT,
           FeatureType.IN_OUT_DATA_PORT,
           FeatureType.OUT_EVENT_PORT,
           FeatureType.IN_OUT_EVENT_PORT,
           FeatureType.OUT_EVENT_DATA_PORT,
           FeatureType.IN_OUT_EVENT_DATA_PORT}),

    PORT("port", new Enum[]
          {FeatureType.IN_DATA_PORT,
           FeatureType.IN_OUT_DATA_PORT,
           FeatureType.OUT_DATA_PORT,
           FeatureType.IN_EVENT_PORT,
           FeatureType.IN_OUT_EVENT_PORT,
           FeatureType.OUT_EVENT_PORT,
           FeatureType.IN_EVENT_DATA_PORT,
           FeatureType.IN_OUT_EVENT_DATA_PORT,
           FeatureType.OUT_EVENT_DATA_PORT}),

    IN_PORT_PROTOTYPE("in port prototype", new Enum[]
           {FeatureType.IN_DATA_PORT_PROTOTYPE,
            FeatureType.IN_OUT_DATA_PORT_PROTOTYPE,
            FeatureType.IN_EVENT_PORT_PROTOTYPE,
            FeatureType.IN_OUT_EVENT_PORT_PROTOTYPE,
            FeatureType.IN_EVENT_DATA_PORT_PROTOTYPE,
            FeatureType.IN_OUT_EVENT_DATA_PORT_PROTOTYPE}),

    OUT_PORT_PROTOTYPE("out port prototype", new Enum[]
           {FeatureType.OUT_DATA_PORT_PROTOTYPE,
            FeatureType.IN_OUT_DATA_PORT_PROTOTYPE,
            FeatureType.OUT_EVENT_PORT_PROTOTYPE,
            FeatureType.IN_OUT_EVENT_PORT_PROTOTYPE,
            FeatureType.OUT_EVENT_DATA_PORT_PROTOTYPE,
            FeatureType.IN_OUT_EVENT_DATA_PORT_PROTOTYPE}),
    
    FEATURE_PROTOTYPE("feature prototype", new Enum[]
           {FeatureType.IN_FEATURE_PROTOTYPE,
            FeatureType.OUT_FEATURE_PROTOTYPE,
            FeatureType.IN_OUT_FEATURE_PROTOTYPE}), 
           
    IN_PARAMETER("in parameter", new Enum[]
          {FeatureType.IN_PARAMETER,
           FeatureType.IN_OUT_PARAMETER}),

    OUT_PARAMETER("out parameter", new Enum[]
          {FeatureType.OUT_PARAMETER,
           FeatureType.IN_OUT_PARAMETER}),

    PARAMETER("parameter", new Enum[]
          {FeatureType.IN_PARAMETER,
           FeatureType.OUT_PARAMETER,
           FeatureType.IN_OUT_PARAMETER}),

    DATA_ACCESS("data access", new Enum[]
          {FeatureType.REQUIRES_DATA_ACCESS,
           FeatureType.PROVIDES_DATA_ACCESS}),
    
    DATA_ACCESS_PROTOTYPE("data access prototype", new Enum[]
          {FeatureType.REQUIRES_DATA_ACCESS_PROTOTYPE,
           FeatureType.PROVIDES_DATA_ACCESS_PROTOTYPE}),

    FROZEN_PORT("frozen port", new Enum[]
          {TypeCheckRule.IN_PORT}),

    DISPATCH_TRIGGER("dispatch trigger", new Enum[]
          {TypeCheckRule.IN_EVENT_PORT,
           TypeCheckRule.IN_EVENT_DATA_PORT}),

    DISPATCH_TRIGGER_CONDITION("dispatch trigger condition", new Enum[]
          {TypeCheckRule.IN_EVENT_PORT,
           TypeCheckRule.IN_EVENT_DATA_PORT,
           FeatureType.PROVIDES_SUBPROGRAM_ACCESS}),

    // Always include at the end of an array:
    // because data subcomponent and data access are very high level feature types.
    DATA_COMPONENT_REFERENCE_FIRST_NAME("data subcomponent" +
          STRING_TYPE_SEPARATOR + "data access" + STRING_TYPE_SEPARATOR +
          "behavior variable" +
          STRING_TYPE_SEPARATOR + "data access feature prototype", new Enum[]
          {FeatureType.DATA_SUBCOMPONENT,
           TypeCheckRule.DATA_ACCESS,
           TypeCheckRule.DATA_ACCESS_PROTOTYPE,
           TypeCheckRule.FEATURE_PROTOTYPE,
           BehaviorFeatureType.BEHAVIOR_VARIABLE}),

    DATA_COMPONENT_REFERENCE_OTHER_NAMES("data field", new Enum[]
          {FeatureType.DATA_SUBCOMPONENT,
           TypeCheckRule.DATA_ACCESS,
           TypeCheckRule.DATA_ACCESS_PROTOTYPE,
           TypeCheckRule.FEATURE_PROTOTYPE,
           FeatureType.CLASSIFIER_VALUE}),

    // Always include at the end of an array:
    // because data subcomponent and data access are very high level feature types.
    VV_COMPONENT_REFERENCE_FIRST_NAME(
          DATA_COMPONENT_REFERENCE_FIRST_NAME._literal + STRING_TYPE_SEPARATOR +
         "in parameter" + STRING_TYPE_SEPARATOR + "incomming port (prototype)" +
             STRING_TYPE_SEPARATOR + "iterative variable", new Enum[]
          {TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME,
           TypeCheckRule.IN_PARAMETER,
           TypeCheckRule.IN_PORT,
           TypeCheckRule.IN_PORT_PROTOTYPE,
           BehaviorFeatureType.ITERATIVE_VARIABLE}),

    PROPERTY("property", new Enum[]
          {FeatureType.PROPERTY_CONSTANT,
           FeatureType.PROPERTY_VALUE}),

    PORT_COUNT_VALUE("port count value", new Enum[]
          {TypeCheckRule.PORT}),
          
    PORT_FRESH_VALUE("port fresh value", new Enum[]
          {TypeCheckRule.PORT}),

    PORT_DEQUEUE_VALUE("port dequeue value", new Enum[]
          {TypeCheckRule.IN_PORT}),

    ELEMENT_VALUES("element values", new Enum[]
          {TypeCheckRule.EVENT_DATA_PORT,
           TypeCheckRule.PARAMETER,
           TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME}),

    // Always include at the end of an array:
    // because data subcomponent and data access are very high level feature types.
    TARGET_COMPONENT_REFERENCE_FIRST_NAME(
          DATA_COMPONENT_REFERENCE_FIRST_NAME._literal + STRING_TYPE_SEPARATOR +
            "out parameter" + STRING_TYPE_SEPARATOR + "outgoing port (prototype)",
                new Enum[]
          {TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME,
           TypeCheckRule.OUT_PARAMETER,
           TypeCheckRule.OUT_PORT,
           TypeCheckRule.OUT_PORT_PROTOTYPE}),

    SHARED_DATA_ACTION("shared data action", new Enum[]
          {FeatureType.REQUIRES_DATA_ACCESS}),

    PORT_DEQUEUE_ACTION("port dequeue action", new Enum[]
          {TypeCheckRule.IN_PORT}),

    PORT_FREEZE_ACTION("port freeze action", new Enum[]
          {TypeCheckRule.IN_PORT}),

    SUBPROGRAM_CALL_ACTION_FIRST_NAME("subprogram call action", new Enum[]
          {FeatureType.SUBPROGRAM_SUBCOMPONENT,
           FeatureType.SUBPROGRAM_PROTOTYPE,
           FeatureType.SUBPROGRAM_CLASSIFIER,
           FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
           FeatureType.REQUIRES_DATA_ACCESS,
           FeatureType.DATA_SUBCOMPONENT,
           BehaviorFeatureType.BEHAVIOR_VARIABLE,
           TypeCheckRule.OUT_PORT}),

    SUBPROGRAM_CALL_ACTION_SD_NAME("subprogram call action", new Enum[]
          {FeatureType.PROVIDES_SUBPROGRAM_ACCESS}),

    DATA_UCCR("data unique component classifier reference", new Enum[]
          {FeatureType.DATA_CLASSIFIER}),

    SUBPROGRAM_UCCR("subprogram unique component classifier reference", new Enum[]
          {FeatureType.SUBPROGRAM_CLASSIFIER}),
    
    GROUPS ("group (prototype)", new Enum[]
          {FeatureType.FEATURE_GROUP,
           FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
           FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
           FeatureType.THREAD_GROUP,
           FeatureType.SUBPROGRAM_GROUP,
           FeatureType.THREAD_GROUP_PROTOTYPE,
           FeatureType.SUBPROGRAM_GROUP_PROTOTYPE,
           FeatureType.FEATURE_GROUP_PROTOTYPE,
           FeatureType.FEATURE_GROUP_PROTOTYPE_BINDING,
           FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE,
           FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE}),
    
    TARGET_STOP_RULE ("target stop rule", new Enum[]
          {TypeCheckRule.OUT_PORT,
           TypeCheckRule.OUT_PORT_PROTOTYPE
          }),
          
    VV_STOP_RULE ("value variable stop rule", new Enum[]
          {TypeCheckRule.IN_PORT,
           TypeCheckRule.IN_PORT_PROTOTYPE
          }),
          
          
    PROCESSOR_RULE("processor unique component classifier reference", new Enum[]
          {FeatureType.PROCESSOR_CLASSIFIER}),
    
    ASSIGNMENT_TARGET("assignment left hand side", new Enum[]
        {TypeCheckRule.TARGET_STOP_RULE}) ;
    
    String _literal ;
    Enum<?>[] _acceptableTypes ;

    TypeCheckRule(String literal, Enum<?>[] acceptableTypes)
    {
      _literal = literal ;
      _acceptableTypes = acceptableTypes ;
    }

    /**
     * Returns the expected feature type names separated by the given type
     * separator string.
     * <BR><BR>
     * Note : this method is not recursive. 
     * 
     * @param typeSeparator the given type separator string 
     * @return the the expected feature type names separated by the given type
     * separator string.
     */
    public String getExpectedTypes(String typeSeparator)
    {
      Enum<?>[] ea = this._acceptableTypes ;

      String[] sa = new String[ea.length];
      int i = 0 ;

      for(Enum<?> e : ea)
      {
        sa[i] = ((Enumerator)e).getLiteral();
        i++ ;
      }

      return Aadl2Utils.concatenateString(typeSeparator, sa) ;
    }

    /**
     * Returns the rule's matching FeatureType or BehaviorAnnexFeatureType
     * enumeration of the given DeclarativeBehaviorElement object. If there is
     * no matching, it returns {@code null}. This test is recursive.
     * 
     * @param dbe the given DeclarativeBehaviorElement object
     * @param baParentContainer behavior parent component
     * @return the rule's matching feature type or {@code null}
     */
    public Enum<?> test(DeclarativeBehaviorElement dbe,
                        ComponentClassifier baParentContainer)
    {
      Enum<?> testedEnum = AadlBaTypeChecker.getType(dbe) ;

      // Resolves feature prototype binding in order to compare the rule
      // to the resolved feature prototype.
      if(testedEnum.equals(FeatureType.FEATURE_PROTOTYPE_BINDING))
      {
        FeaturePrototypeBinding fpb = (FeaturePrototypeBinding) 
              AadlBaTypeChecker.getBindedElement(dbe) ;
        testedEnum = AadlBaUtils.getFeatPrototypeType(fpb) ;
      }
      
      // Resolves component prototype binding in order to compare the rule
      // to the resolved component prototype.
      if(testedEnum.equals(FeatureType.COMPONENT_PROTOTYPE_BINDING))
      {
        ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) 
              AadlBaTypeChecker.getBindedElement(dbe) ;
        testedEnum = AadlBaUtils.getCompPrototypeType(cpb) ;
      }
      
      return testTypeCheckRule(testedEnum) ;
    }

    public Enum<?> testTypeCheckRule(Enum<?> other)
    {
      return testTypeCheckRule(this, other) ;
    }
    
    private static Enum<?> testTypeCheckRule(TypeCheckRule tcr, Enum<?> other)
    {
      for(Enum<?> e : tcr._acceptableTypes)
      {
        if (e instanceof TypeCheckRule)
        {
          Enum<?> result = testTypeCheckRule((TypeCheckRule)e, other) ;
          
          if (result != null)
          {
            return result ;
          }
          else
          {
            continue ;
          }
        }
        else
        {
          if (e.equals(other))
          {
            return other ;
          }
          else
          {
            continue ;
          }
        }
      }

      return null ;
    }

    @Override
    public String getLiteral()
    {
      return _literal ;
    }

    @Override
    public String getName()
    {
      throw new UnsupportedOperationException() ;
    }

    @Override
    public int getValue()
    {
      throw new UnsupportedOperationException() ;
    }
  }   
}