package fr.tpt.aadl.annex.behavior.analyzers;

import java.util.ArrayList ;
import java.util.List ;
import java.util.ListIterator ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.Enumerator ;
import org.eclipse.emf.ecore.EObject ;

import edu.cmu.sei.aadl.aadl2.ArrayableElement ;
import edu.cmu.sei.aadl.aadl2.CalledSubprogram ;
import edu.cmu.sei.aadl.aadl2.ComponentCategory ;
import edu.cmu.sei.aadl.aadl2.ComponentPrototype ;
import edu.cmu.sei.aadl.aadl2.ComponentPrototypeActual ;
import edu.cmu.sei.aadl.aadl2.ComponentPrototypeBinding ;
import edu.cmu.sei.aadl.aadl2.ComponentReference ;
import edu.cmu.sei.aadl.aadl2.DirectionType ;
import edu.cmu.sei.aadl.aadl2.Parameter ;
import edu.cmu.sei.aadl.aadl2.SubprogramAccess ;
import edu.cmu.sei.aadl.aadl2.SubprogramImplementation ;
import edu.cmu.sei.aadl.aadl2.SubprogramSubcomponent ;
import edu.cmu.sei.aadl.aadl2.SubprogramType ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.annex.behavior.aadlba.*;

import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;

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

   private AnalysisErrorReporterManager _errManager ;
   
   private static final String STRING_TYPE_SEPARATOR = " or " ;
   
   private static final String STRING_PARAMETER_SEPARATOR = ", " ;
   
   private final DataTypeChecker _dataChecker ;
   
   /**
    * Constructs an AADL behavior annex type checker.
    * Reports any errors in a given error reporter manager.
    *
    * @param ba the given behavior annex
    * @param dataChecker the given data type checker implementation
    * @param errManager the given error reporter manager
    */
   public AadlBaTypeChecker(BehaviorAnnex ba , DataTypeChecker dataChecker,
                            AnalysisErrorReporterManager errManager)
   {
      _ba = ba ;
      _dataChecker = dataChecker ;
      _errManager = errManager ;
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
      return behaviorVariableCheck() & behaviorTransitionCheck();
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
      IntegerValueConstant tmp = null ;

      for(BehaviorVariable bv : _ba.getBehaviorVariables())
      {
         // Checks local declarators.
         for(Declarator decl : bv.getLocalVariableDeclarators())
         {
            ListIterator<IntegerValueConstant> lit = decl.getArraySizes()
                                                               .listIterator() ;

            while(lit.hasNext())
            {
               ivc = lit.next() ;
               tmp = integerValueConstantCheck(ivc) ;
               result &= tmp != null ;

               // The returned value may be different from the tested value
               // because of semantic ambiguity resolution in 
               // integervalueConstantCheck method. So replace if needed.
               if(tmp != ivc && tmp !=null)
               {
                  lit.set(tmp) ;
               }
            }
         }
         
         UniqueComponentClassifierReference uccr = 
                                bv.getDataUniqueComponentClassifierReference() ;
         
         // The bv's unique component classifier reference type has to be a 
         // data classifier.
         result &= typeCheck(uccr, uccr.getQualifiedName(),
               TypeCheckRule.DATA_UCCR) != null ;
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

      for(BehaviorTransition trans : _ba.getBehaviorTransitions())
      {
         BehaviorCondition cond = trans.getBehaviorConditionOwned() ;

         if(cond instanceof DispatchCondition)
         {
            result &= dispatchConditionCheck((DispatchCondition) cond);
         }
         else
         {
            result &= executeConditionCheck((ExecuteCondition) cond) ;
         }

         if(trans.getBehaviorActionBlockOwned() != null)
         {
            result &= behaviorActionBlockCheck(trans.getBehaviorActionBlockOwned()) ;
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

      DispatchTriggerCondition dtc = cond.getDispatchTriggerConditionOwned() ;

      if(dtc != null)
      {
         DispatchTriggerCondition tmp = dispatchTriggerConditionCheck(dtc) ;
         result = tmp != null ;

         // The returned DispatchTriggerCondition may be different from the
         // tested one because of semantic ambiguity resolution in
         // dispatchTriggerConditionCheck method. So replace if needed.
         if (tmp != dtc && result)
         {
            cond.setDispatchTriggerConditionOwned(tmp) ;
         }
      }

      if(cond.isSetFrozenPorts())
      {
         result &= frozenPortCheck(cond.getFrozenPorts()) ;
      }

      return result ;
   }

   private boolean frozenPortCheck(EList<Identifier> frozenPorts)
   {
      boolean result = true ;

      for(Identifier port : frozenPorts)
      {
         result &= typeCheck(port, port.getId(),
                    TypeCheckRule.FROZEN_PORT) != null;
      }
      
      return result ;
   }

   private void reportError (Element el, String msg)
   {
      _errManager.error(el, msg);
   }
   
   private void reportTypeError(Element el, String name,
                                String expectedTypes,
                                String typeFound)
   {
      String message = "\'" + name + "\' type error: \"" + expectedTypes + "\" expected"
                                                 + ", found \"" + typeFound + "\".";
      
      reportError(el, message) ;
   }
   
   private String unparseNameElement(Element e)
   {
       AadlBaUnparser unparser = new AadlBaUnparser() ;
       unparser.process(e) ;
       return unparser.getOutput() ;
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

         // Ambiguity resolution: subprogram access identifiers are parsed as
         // dispatch trigger logical expression.
         if(dtle.getDispatchConjunctions().size() == 1 &&
               dtle.getDispatchConjunctions().get(0)
                                             .getDispatchTriggers().size() == 1)
         {
            Identifier dt = dtle.getDispatchConjunctions().get(0)
                                                 .getDispatchTriggers().get(0) ;
            Enum<?> e= typeCheck(dt, dt.getId(),
                              TypeCheckRule.DISPATCH_TRIGGER_CONDITION) ;
            if(e != null)
            {
               if(e == FeatureType.PROVIDES_SUBPROGRAM_ACCESS)
               {
                 return dt ;
               }
               else
               {
                  return dtc ;
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
         // CompletionRelativeTimeoutConditionAndCatch case.
         if(dtc instanceof CompletionRelativeTimeoutConditionAndCatch)
         {
            return behaviorTimeCheck((BehaviorTime) dtc) ? dtc : null ;
         }
         else // Cases of DispatchTriggerConditionStop and TimeoutCatch:
              // There isn't any type to check.

         {
            return dtc ;
         }
      }
   }

   private boolean behaviorTimeCheck(BehaviorTime bt)
   {

      IntegerValue tmp = integerValueCheck(bt.getIntegerValueOwned());

      // The returned value may be different from the tested value
      // because of semantic ambiguity resolution in integerValueCheck
      // method. So replace if needed.
      if(tmp != bt.getIntegerValueOwned() && tmp != null)
      {
         bt.setIntegerValueOwned(tmp) ;
      }

      return tmp != null ;
   }

   private boolean dispatchTriggerLogicalExpressionCheck(
                                          DispatchTriggerLogicalExpression dtle)
   {
      boolean result = true ;

      for(DispatchConjunction dc : dtle.getDispatchConjunctions())
      {
         for (Identifier dt : dc.getDispatchTriggers())
         {
            result &= typeCheck(dt, dt.getId(), 
                        TypeCheckRule.DISPATCH_TRIGGER) != null;
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
      else // Relation checking have failed.
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
      TypeHolder th1 = simpleExpressionCheck(r.getSimpleExpressionOwned()) ;
      TypeHolder th2 = null ;
      
      if(r.isSetRelationalOperatorOwned())
      {
         th2 = simpleExpressionCheck(r.getSimpleExpressionSdOwned()) ; 
      }
      else
      {
         return th1 ;
      }
      
      if(th1 != null && th2 != null)
      {
         return _dataChecker.checkDefinition(r, r.getRelationalOperatorOwned(),
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
         if(se.isSetUnaryAddingOperatorOwned())
         {
            typea[0] = _dataChecker.checkDefinition(se,
                                      se.getUnaryAddingOperatorOwned(),
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
      else // Term checking have failed.
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
      Value fValue = f.getValueOwned() ;
      Value sdValue = f.getValueSdOwned() ;
      ValueAndTypeHolder vth1 = valueCheck(fValue) ;
      ValueAndTypeHolder vth2 = null ;;
      
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
         if(vth1.value != fValue)
         {
            f.setValueOwned(vth1.value) ;
            fValue = vth1.value ;
         }
         
         // Checks Unary operators.
         if(f.isSetUnaryNumericOperatorOwned() ||
            f.isSetUnaryBooleanOperatorOwned())
         {
            Enumerator op ;
            
            op =  (
                    (f.isSetUnaryBooleanOperatorOwned()) ? 
                       f.getUnaryBooleanOperatorOwned() : 
                       f.getUnaryNumericOperatorOwned()) ;
            
            return _dataChecker.checkDefinition(f, op, vth1.typeHolder) ;
         }
         else 
         {
            if(f.isSetBinaryNumericOperatorOwned())
            {
               if(vth2 != null)
               {
                  // The returned value may be different from the tested value
                  // because of semantic ambiguity resolution in valueCheck
                  // method. So replace if needed.
                  if(vth2.value != sdValue)
                  {
                     f.setValueSdOwned(vth2.value) ;
                     sdValue = vth2.value ;
                  }
                  
                  return _dataChecker.checkDefinition(f,
                        f.getBinaryNumericOperatorOwned(),vth1.typeHolder,
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
      // Ambiguity between property constant and name without array index
      // has already been resolved in the name resolution phase.

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
      ValueVariable tmp ;

      if(v instanceof PortCountValue || v instanceof PortFreshValue)
      {
         tmp = portCountOrFreshValueCheck((Name) v) ? v : null ;
      }
      else
      {
         if(v instanceof PortDequeueValue)
         {
            tmp = portDequeueValueCheck((PortDequeueValue) v) ? v : null ;
         }
         else
         {
            if(v instanceof DataComponentReference)
            {
               tmp = dataComponentReferenceCheck((DataComponentReference) v)?
                            v : null ;
            }
            else // Ambiguous case between name and unqualified data component
                 // reference. Unqualified data component references are parsed
                 // as name.
            {
               tmp = nameCheckAndResolveAmbiguity(
                                (Name) v, TypeCheckRule.VALUE_VARIABLE) ;
            }
         }
      }
      
      if(tmp != null)
      {
         return new ValueAndTypeHolder(tmp, AadlBaUtils.getTypeHolder(tmp)) ;
      }
      else
      {
         return null ;
      }
   }

   // Checks the given name and resolves the semantic ambiguity between
   // a name and an unqualified data component reference.
   // On error, reports error and returns null.
   // The return object (Name or DataComponentReference) can be 
   // cast into either Target or ValueVariable.
   // As this method may resolve a semantic ambiguity, the return object
   // can be different from the given Name object.
   private ValueVariable nameCheckAndResolveAmbiguity(Name n,
                                                      TypeCheckRule rule)
   {
      Enum<?> e = nameResolver(n, rule) ;
      
      if(e != null)
      {
         // Case of unqualified data component reference.
         if (e == TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME)
         {
            DataComponentReference result = AadlBaFactory.eINSTANCE.
                                                createDataComponentReference() ;
            result.setLocationReference(n.getLocationReference()) ;
            result.getNames().add(n) ;
            result.setAadlRef(n.getAadlRef()) ;

            return result ;
         }
         else // Real name case.
         {
            return n ;
         }
      }
      else // Checking has failed.
      {
         return null ;
      }
   }

   // Checks a name according to the given rule.
   // Returns the matching type or null on error. Reports any error.
   private Enum<?> nameResolver(Name n, TypeCheckRule rule)
   {
      Enum<?> result = null ;
      IntegerValueVariable tmp, iv = null ;
      boolean ivResolved = true ;
      ListIterator<IntegerValueVariable> lit = n.getArrayIndexes().listIterator() ;

      // Checks the array indexes.
      while(lit.hasNext())
      {
         iv = lit.next() ;
         tmp = integerValueVariableCheck(iv) ;

         // The returned IntegerValueVariable may be different from the
         // tested one because of semantic ambiguity resolution in
         // integerValueVariableCheck method. So replace if needed.
         if(tmp != null)
         {
            if(tmp != iv)
            {
               lit.set(tmp) ;
            }
         }
         else
         {
            ivResolved = false ;
         }
      }

      // Checks the identifier according to the given rule.
      Identifier id = n.getIdentifierOwned() ;
      result = typeCheck(id, id.getId(), rule) ;

      return (ivResolved) ? result : null ;
   }

   private boolean dataComponentReferenceCheck(DataComponentReference dcr)
   {
      boolean result ;

      Name firstName = dcr.getNames().get(0) ;
      
      result = nameResolver(firstName,
            TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME) != null ;
      
      Name n ;
      
      for(int i = 1 ; i < dcr.getNames().size() ; i++)
      {
         n = dcr.getNames().get(i) ;
         result &= nameResolver(n,
            TypeCheckRule.DATA_COMPONENT_REFERENCE_OTHER_NAMES) != null ;
      }

      return result;
   }

   private boolean portDequeueValueCheck(PortDequeueValue v)
   {
      return nameResolver(v, TypeCheckRule.PORT_DEQUEUE_VALUE) != null ;
   }

   private boolean portCountOrFreshValueCheck(Name n)
   {
      return nameResolver(n, TypeCheckRule.PORT_COUNT_VALUE) != null ;
   }

   // This method checks the given object and returns a value constant
   // resolved from semantic ambiguities and its data representation. On error,
   // reports error and returns null.
   private ValueAndTypeHolder valueConstantCheck(ValueConstant v)
   {
      if(v instanceof PropertyConstant)
      {
         // Ambiguity between propertyset constant and propertyset value.
         // propertyset values are parsed as propertyset constants.

         PropertyConstant pc = (PropertyConstant) v ;

         // Namespace doens't need to be checked as namespace has no type.
         Enum<?> e = typeCheck(pc, pc.getName(),
                                              TypeCheckRule.PROPERTY) ;
         if (e != null)
         {
            if (e == FeatureType.PROPERTY_VALUE)
            {
               // Builds a PropertyValue object and returns it instead of
               // the property constant which has been parsed.

               PropertyValue pv = AadlBaFactory.eINSTANCE.
                                                          createPropertyValue();

               pv.setAadlRef(pc.getAadlRef()) ;
               pv.setLocationReference(pc.getLocationReference());
               pv.setNamespace(pc.getNamespace());
               pv.setNamespaceSeparator(pc.getNamespaceSeparator());
               pv.setName(pc.getName());
               pv.setQualifiedName(pc.getQualifiedName());
               v = pv ;
            }
         }
         else // Checking has failed.
         {
            return null ;
         }
      }
      // Literal cases. Nothing to do.
      
      return new ValueAndTypeHolder(v, AadlBaUtils.getTypeHolder(v)) ;
   }

   private boolean behaviorActionBlockCheck(BehaviorActionBlock bab)
   {
      boolean result = false ;

      if(bab.getBehaviorTimeOwned() != null)
      {
         result = behaviorTimeCheck(bab.getBehaviorTimeOwned()) ;
      }

      result &= behaviorActionsCheck(bab.getBehaviorActionsOwned()) ;

      return result ;
   }

   private boolean behaviorActionsCheck(BehaviorActions bActs)
   {
      if(bActs instanceof BehaviorAction)
      {
         return behaviorActionCheck((BehaviorAction) bActs);
      }
      else
      {
         boolean result = true ;

         for(BehaviorAction bAct : ((BehaviorActionCollection)bActs).
                                                           getBehaviorActions())
         {
            result &= behaviorActionCheck(bAct) ;
         }

         return result ;
      }
   }

   private boolean behaviorActionCheck(BehaviorAction bAct)
   {
      if(bAct instanceof BehaviorActionBlock)
      {
         return behaviorActionBlockCheck((BehaviorActionBlock) bAct) ;
      }
      else
      {
         if(bAct instanceof BasicAction)
         {
            return basicActionCheck((BasicAction) bAct) ;
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
      boolean result = behaviorActionsCheck(stat.getBehaviorActionsOwned()) ;
      
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
    */
   private boolean forOrForAllStatementCheck(ForOrForAllStatement stat)
   {
      boolean result = behaviorActionsCheck(stat.getBehaviorActionsOwned()) ;
      
      UniqueComponentClassifierReference uccr = 
                             stat.getDataUniqueComponentClassifierReference() ;
      
      // The statement's unique component reference reference has to be   
      // data classifier.
      if(typeCheck(uccr, uccr.getQualifiedName(),
            TypeCheckRule.DATA_UCCR) == null)
      {
         uccr = null ;
         result = false ; 
      }
                         
      ElementValues tmp = elementValuesCheck(stat.getElementValuesOwned());
      result &= tmp != null ;
      
      // The returned element values may be different from the tested one
      // because of semantic ambiguity resolution in elementValuesCheck
      // method. So replace if needed.
      if(tmp != stat.getElementValuesOwned() && tmp != null)
      {
         stat.setElementValuesOwned(tmp) ;
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
            t1 = AadlBaUtils.getTypeHolder((Value) ir.getLowerIntegerValue()) ;
            t2 = AadlBaUtils.getTypeHolder((Value) ir.getUpperIntegerValue()) ;
            
            eleType = _dataChecker.getTopLevelType(t1, t2) ; 
         }
         else // Name or DataComponentReference cases.
         {
            eleType = AadlBaUtils.getTypeHolder((Value) tmp) ;
         }
         
         uccrType = AadlBaUtils.getTypeHolder(uccr) ;
         
         if(! _dataChecker.conformsTo(eleType, uccrType))
         {
            result = false ;
            reportTypeError(uccr, "iterative variable", eleType.toString(),
                                                           uccrType.toString());
         }
      }
      
      return result ;
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
         ElementValues result = null ;
        ForOrForAllStatement parentStat = (ForOrForAllStatement) ev.eContainer() ;
         
         if(ev instanceof Name)
         {
            ValueVariable vv = nameCheckAndResolveAmbiguity((Name) ev, 
                                          TypeCheckRule.ELEMENT_VALUES) ;
            if (vv != null) 
            {
               result = (ElementValues) vv ;
            }
            else // Name or unqualified data component reference error cases.
            {
               result = null ;
            }
         }
         else // Data component reference case.
         {
            DataComponentReference dcr = (DataComponentReference) ev ;
            if(dataComponentReferenceCheck(dcr))
            {
               result = ev ;
            }
            else // Unqualified data component reference error case.
            {
               result = null ;
            }
         }
         
         // Checks data component reference arrayness and reports any error.
         if(result instanceof DataComponentReference)
         {
            if (! dataComponentReferenceArraynessCheck((DataComponentReference)
                                                                        result))
            {
               // Reverts E attributes to before semantic ambiguity resolution. 
               parentStat.setElementValuesOwned(ev) ;
               String message = "\'" + unparseNameElement(ev) + 
                                                          "\' is not an array" ;
               reportError(ev, message) ;
               result = null ;
            }
         }
         
         return result ;
      }
   }
   
   // Checks the arrayness of the given data component reference.
   // Returns true if the dcr is an array, false otherwise.
   // Can't report error because dcr's EObject attributes may not be initialized.
   private boolean dataComponentReferenceArraynessCheck(
                                                     DataComponentReference dcr)
   {
      boolean result = false ;
      
      edu.cmu.sei.aadl.aadl2.Element el = dcr.getAadlRef() ;
      
      if(el instanceof ArrayableElement)
      {
         ArrayableElement ae = (ArrayableElement) el ;
         
         result = ae.getArraySpecification() != null ;
      }
      else // The binded element is not arrayable.
      {
         result = false ;
      }
      
      return result ;
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
         t1 = AadlBaUtils.getTypeHolder((Value) ir.getLowerIntegerValue()) ;
         t2 = AadlBaUtils.getTypeHolder((Value) ir.getUpperIntegerValue()) ;
         
         if(! _dataChecker.conformsTo(t1, t2))
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
      boolean result = true ;
      ValueAndTypeHolder holder = null ;
      
      for(ValueExpression ve : stat.getLogicalValueExpressions())
      {
         holder = valueExpressionCheck(ve) ;
         result &= typeCheck(ve, null, holder, DataRepresentation.BOOLEAN) ; 
      }

      for(BehaviorActions bActs : stat.getBehaviorActionsOwned())
      {
         result &= behaviorActionsCheck(bActs) ;
      }

      return result ;
   }

   private boolean basicActionCheck(BasicAction ba)
   {
      if(ba instanceof AssignmentAction)
      {
         return assignementActionCheck((AssignmentAction) ba) ;
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
               EObject el = ba.eContainer() ;

               if(el instanceof BehaviorActionBlock)
               {
                  ((BehaviorActionBlock) el).setBehaviorActionsOwned
                                                             (resolvedCommAct) ;
                  hasBeenReplaced = true ;
               }
               else if(el instanceof BehaviorActionCollection)
               {
                  BehaviorActionCollection coll = (BehaviorActionCollection) el;
                  
                  ListIterator<BehaviorAction> lit = coll.getBehaviorActions().
                                                                 listIterator();
                  while(lit.hasNext())
                  {
                     if(lit.next() == ba)
                     {
                        lit.set(resolvedCommAct) ;
                        hasBeenReplaced = true ;
                     }
                  }
               }
               else if (el instanceof IfStatement)
               {
                  IfStatement stat = (IfStatement) el ;
                  
                  ListIterator<BehaviorActions> lit = stat.
                                      getBehaviorActionsOwned().listIterator() ;
                  
                  while (lit.hasNext())
                  {
                     BehaviorActions beActions = lit.next() ;
                     if(beActions instanceof BehaviorAction)
                     {
                        BehaviorAction beAct = (BehaviorAction) beActions ;
                        
                        if(beAct == ba)
                        {
                           lit.set(resolvedCommAct) ;
                           hasBeenReplaced = true ;
                        }
                     }
                  }
               }
               else // LoopStatement cases.
               {
                  LoopStatement stat = (LoopStatement) el ;
                  BehaviorActions beActions = stat.getBehaviorActionsOwned() ;
                  
                  if(beActions instanceof BehaviorAction)
                  {
                     stat.setBehaviorActionsOwned(resolvedCommAct) ;
                     hasBeenReplaced = true ;
                  }
               }
               
               if (! hasBeenReplaced)
               {
                  System.err.println("The resolved communication action : " +  
                        unparseNameElement(resolvedCommAct) + 
                           " hasn't been set") ;
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
      boolean result = behaviorTimeCheck(ta.getLowerBehaviorTime());

      if (ta.getUpperBehaviorTime() != null)
      {
         result &= behaviorTimeCheck(ta.getUpperBehaviorTime()) ;
      }

      return false ;
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
      if(ca instanceof SubprogramCallAction)
      {
         return subprogramCallAndPortSendActionChecker((SubprogramCallAction) ca) ;
      }
      else
      {
         if(ca instanceof PortDequeueAction)
         {
            PortDequeueAction pda = (PortDequeueAction) ca ; 
            Target tar = pda.getTargetOwned() ;
            Name portName = pda.getPortName() ;
            
            Enum<?> e =  nameResolver(portName,
                                      TypeCheckRule.PORT_DEQUEUE_ACTION);
            if(tar != null)
            {
               Target tmp  = targetCheck(tar) ;
               
               if(tmp != null)
               {
                  // The returned target may be different from the tested one
                  // because of semantic ambiguity resolution in targetCheck
                  // method. So replace if needed.
                  if(tmp != tar)
                  {
                     pda.setTargetOwned(tmp) ;
                     tar = tmp ;
                  }
                  
                  // Matches the target's data type with the input port's one 
                  // when port dequeue action.
                  if(e != null)
                  {
                     TypeHolder tarType = AadlBaUtils.getTypeHolder(tmp) ;
                     TypeHolder portType = AadlBaUtils.getTypeHolder((Value)
                                                                     portName) ;
                     if (! _dataChecker.conformsTo(portType, tarType))
                     {
                        reportTypeError(ca, "port dequeue action",
                                            portType.toString(),
                                            tarType.toString()) ;
                        return null ;
                     }
                  }
               }
               else
               {
                  return null ;
               }
            }
            
            return (e != null) ? pda : null ;
         }
         else
         {
            if(ca instanceof PortFreezeAction)
            {
               PortFreezeAction pfa = (PortFreezeAction) ca ;
               
               Enum<?> e = nameResolver(pfa,
                                      TypeCheckRule.PORT_FREEZE_ACTION) ;
               return (e != null) ? pfa : null ;
            }
            else // Shared data action cases.
            {
               SharedDataAction sd = (SharedDataAction) ca ;
               
               if(sd.getDataAccessName() != null)
               {
                  Enum<?> e =  nameResolver(sd.getDataAccessName(),
                                       TypeCheckRule.SHARED_DATA_ACTION);
                  return (e != null) ? sd : null ;
               }
               else
               {
                  return sd ;
               }
            }
         }
      }
   }
   
   // This method checks the given object and returns a communication action
   // resolved from semantic ambiguities (subprogram call and port send action).
   // On error, reports error and returns null.
   private CommunicationAction subprogramCallAndPortSendActionChecker
                                                       (SubprogramCallAction sc)
   {
      CommunicationAction result = sc ;
      UniqueComponentClassifierReference uccr = sc.getSubprogramReference() ;
      EList<Name> nl = sc.getSubprogramNames() ;
      EList<ParameterLabel> spl = null ;
      
      if(uccr ==null)
      {
         Name firstName = nl.get(0) ;
         
         // Resolves ambiguities between a subprogram call with one name and 
         // a subprogram call with an unqualified uccr and port send action.
         if(nl.size() == 1)
         {
            Enum<?> e = nameResolver(firstName,
                                TypeCheckRule.SUBPROGRAM_CALL_ACTION_ONE_NAME) ;
            
            // Ambiguity resolutions.
            if (e != null)
            {
               // Unqualified uccr case.
               // This case may be unnecessary as AadlBaNameResolver performs a
               // ambiguity resolution. But this case is left until more 
               // feedbacks.  
               if (e == FeatureType.SUBPROGRAM_CLASSIFIER) 
               {
                  if(! firstName.isSetArrayIndexes())
                  {
                     // Rebuild a proper uccr and set it in the given 
                     // subprogram call action.
                     UniqueComponentClassifierReference tmp = 
                        AadlBaFactory.eINSTANCE
                                   .createUniqueComponentClassifierReference() ;
                     
                     tmp.setAadlRef(firstName.getAadlRef()) ;
                     tmp.setName(firstName.getIdentifierOwned().getId()) ;
                     tmp.setQualifiedName(tmp.getName()) ;
                     tmp.setLocationReference(firstName.getLocationReference());
                     
                     sc.setSubprogramReference(tmp) ;
                     sc.unsetSubprogramNames();
                  }
                  else // Error case : the subprogram classifier can't be an
                      // array.
                  {
                     String msg = "a subprogram classifier can't be an array" ;
                     reportError(sc, msg) ;
                     return null ;
                  }
               }
               else
               {
                  // Port send action case.
                  if (e == TypeCheckRule.OUT_PORT)
                  {
                     PortSendAction psa = AadlBaFactory.eINSTANCE.
                                                        createPortSendAction() ;

                     if(sc.isSetParameterLabels())
                     {
                        spl = sc.getParameterLabels() ;
                        if(spl.size() == 1)
                        {
                           ValueExpression ve = (ValueExpression) spl.get(0) ;

                           ValueAndTypeHolder tmp = valueExpressionCheck(ve) ;

                           if(tmp != null)
                           {
                              // Matches the value expression top level data type 
                              // with the port data type.
                              TypeHolder portType = AadlBaUtils.getTypeHolder(
                                                            (Value) firstName) ;
                              if(! _dataChecker.conformsTo(portType,
                                                                tmp.typeHolder))
                              {
                                 reportTypeError(sc, "port send action",
                                                     portType.toString(),
                                                     tmp.typeHolder.toString());
                                 return null ;
                              }
                              else
                              {
                                 ValueExpression veTmp = (ValueExpression) 
                                                                     tmp.value ;
                                 psa.setValueExpressionOwned(veTmp);
                              }
                           }
                           else // Value expression checking has failed.
                           {
                              return null ;
                           }
                        }
                        else // Error case : Port send action has only one 
                           // value expression.
                        {
                           String msg = "a port send action can't have more than"
                                 + " one value expression" ;
                           reportError(sc, msg) ;
                           return null ;
                        }
                     }
                     
                     psa.setLocationReference(firstName.getLocationReference());
                     psa.setPortName(firstName);
                     
                     return psa ;
                  } // End of port send action case.
               }
            }
            else // Checking has failed.
            {
               return null ;
            }
         } // End of second if.
         else // Checks a subprogram call with two names.
              // The ambiguity between a subprogram call with two names
              // and a subprogram call with a implementation provided uccr
              // has already been resolved in the name resolver (see
              // NameResolver::comunicationActionResolver().
         {
            Enum<?> e = nameResolver(firstName,
                               TypeCheckRule.SUBPROGRAM_CALL_ACTION_FIRST_NAME);
            
            if(e != null)
            {
               Name sdName = nl.get(1);
               
               e = nameResolver(sdName,
                                 TypeCheckRule.SUBPROGRAM_CALL_ACTION_SD_NAME) ;
               if(e == null)
               {
                  return null ;
               }
            }
            else
            {
               return null ;
            }
         }
      } // End of first if.
      else // Checks uccr and reports any error.
      {
         if(typeCheck(uccr, uccr.getQualifiedName(),
               TypeCheckRule.SUBPROGRAM_UCCR) == null)
         {
            return null ;
         }
      }
      
      // Gets subprogram type.
      SubprogramType subprogType = subprogramTypeCheck(sc) ;
      
      // Checks and resolves parameter labels.
      // Event if the subprogram call action doesn't have any parameter labels,
      // the subprogram type may have and vice versa : 
      // subprogramParameterListCheck is also design for these cases. 
      // Binds the subprogram type found to the subprogram call action. 
      if(subprogType != null && subprogramParameterListCheck(sc,
            sc.getParameterLabels(), subprogType.getOwnedParameters()))
      {
         sc.setAadlRef(subprogType) ;
         result = sc ;
      }
      else
      {
         result = null ;
      }

      return result ;
   }
   
   // Recursive method.
   private SubprogramType getSubprogramType(CalledSubprogram sc)
   {
      SubprogramType result = null ;
      
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
         result = getSubprogramType(sa.getSubprogramClassifier()) ;
      }
      else if(sc instanceof SubprogramSubcomponent)
      {
         SubprogramSubcomponent ss = (SubprogramSubcomponent) sc ;
         
         result = getSubprogramType(ss.getSubprogramClassifier()) ;
      }
      
      return result ;
   }
   
   // Gets subprogram type binded to the given subprogram call action.
   // On error, reports error and returns null.
   private SubprogramType subprogramTypeCheck(SubprogramCallAction sca)
   {
      edu.cmu.sei.aadl.aadl2.Element el ;
      SubprogramType result = null ;
      String errorMsg = null ;
      
      if(sca.getSubprogramReference() != null )
      {
         el = sca.getSubprogramReference().getAadlRef() ;
      }
      else 
      {
         if(sca.getSubprogramNames().size() == 1)
         {
            el = sca.getSubprogramNames().get(0).getAadlRef() ;
         }
         else
         {
            el = sca.getSubprogramNames().get(1).getAadlRef() ;
         }
      }
      
      if(el instanceof CalledSubprogram)
      {
         result = getSubprogramType((CalledSubprogram) el) ;
      }
      else if (el instanceof ComponentPrototypeBinding)
      {
         ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) el ;
         
         ComponentPrototypeActual cpa = cpb.getActuals().
                                               get(cpb.getActuals().size() -1) ;
         
         if(cpa instanceof ComponentReference)
         {
            result = (SubprogramType) ((ComponentReference) cpa).getClassifier() ;
         }
         else
         {
            errorMsg = " is not an subprogram prototype" ;
            result = null ;
         }
      }
      else if(el instanceof ComponentPrototype)
      {
         ComponentPrototype cp = (ComponentPrototype) el ;
         
         if(cp.getCategory() == ComponentCategory.SUBPROGRAM)
         {
            if (cp.getConstrainingClassifier() != null)
            {
               result = (SubprogramType) cp.getConstrainingClassifier() ;
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
      else // Error case : the binded object is not an subprogram.
      {
         System.err.println(el) ;
         errorMsg =  "is not subprogram" ;
         result = null ;
      }
      
      // Error reporting.
      if(result == null && errorMsg != null)
      {
         reportError(sca, '\'' + AadlBaUtils.getName(sca) + '\'' + errorMsg) ;
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
   private boolean subprogramParameterListCheck(SubprogramCallAction sca,
                                                EList<ParameterLabel> callParams,
                                                EList<Parameter> subprogParams)
   {
      // Matching the parameter labels with the subprogram prototype.
      // Resolves ambiguity between target and value expression :
      // value expression are for in parameter, target are for out parameter.
      
      //Preliminary checking : on error, reports error and exit early.
      if(callParams.size() != subprogParams.size())
      {
         String subprogramName = AadlBaUtils.getName(sca) ;
         
         reportError(sca, "Invalid number of argument(s) for the subprogram " + 
                                                               subprogramName) ;
         return false ;
      }
      
      boolean isconsistent = true ;
      boolean hasCheckingPassed = true ;
            
      DirectionType direction  ;
      ValueExpression valueExp ;
      ListIterator<ParameterLabel> it = callParams.listIterator() ;
      Value v ;
      Target tar ;
      TypeHolder t1, t2 ;
      ValueAndTypeHolder vth ;
      
      List<TypeHolder> typesFound = new ArrayList<TypeHolder>(callParams.size());
      List<DirectionType> directionsFound = new ArrayList<DirectionType>
                                                           (callParams.size()) ;
      
      List<TypeHolder> expectedTypes = new ArrayList<TypeHolder>
                                                         (subprogParams.size());
      List<DirectionType> expectedDirections = new ArrayList<DirectionType>
                                                        (subprogParams.size()) ;

      // As AADL standard doesn't allow subprogram overloading (two subprogram
      // classifier names can't be the same), parameter labels checking is 
      // driven by the subprogram signature.
      for(Parameter param : subprogParams)
      {
         valueExp = (ValueExpression) it.next() ;
         direction = param.getDirection() ;
         expectedDirections.add(direction) ;
         
         // ValueExpression case.
         if(direction.equals(DirectionType.IN))
         {
            vth = valueExpressionCheck(valueExp) ;
            
            if(vth != null)
            {
               t1 = AadlBaUtils.getTypeHolder(param.getDataClassifier()) ;
               t2 = vth.typeHolder ;
               expectedTypes.add(t1) ;
               typesFound.add(t2) ;
               directionsFound.add(DirectionType.IN);
               
               if(! _dataChecker.conformsTo(t1, t2))
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
         else // Target case : IN_OUT and OUT direction
         {
            v = AadlBaUtils.isOnlyOneValue(valueExp) ;
            
            if(v instanceof Target &&
               ! (v instanceof PortFreshValue) &&
               ! (v instanceof PortCountValue) &&
               ! (v instanceof PortDequeueValue)  )
            {
               tar = targetCheck((Target) v) ;
               
               if(tar != null)
               {
                  t1 = AadlBaUtils.getTypeHolder(param.getDataClassifier()) ;
                  t2 = AadlBaUtils.getTypeHolder(tar) ;
                  expectedTypes.add(t1) ;
                  typesFound.add(t2) ;
                  
                  directionsFound.add(AadlBaUtils.getDirectionType(tar)) ;
                  
                  if(! _dataChecker.conformsTo(t1, t2))
                  {
                     isconsistent = false ;
                  }
                  else
                  {
                     // As checking passed and ambiguity between
                     // ValueExpression and Target has been resoved, it replaces
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
            else
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
               
               // It resolves the type in order to format the error message :
               vth = valueExpressionCheck(valueExp) ;
               
               if(vth != null)
               {
                  t1 = AadlBaUtils.getTypeHolder(param.getDataClassifier()) ;
                  t2 = vth.typeHolder ;
                  expectedTypes.add(t1) ;
                  typesFound.add(t2) ;
                  directionsFound.add(DirectionType.IN);
                  isconsistent = false ;
               }
               else
               {
                  // Error reporting has already been done.
                  hasCheckingPassed = false ;
               }
            }
         }
      }
      
      // Reports consistency error.
      if(! isconsistent && hasCheckingPassed)
      {
         String subprogramName = AadlBaUtils.getName(sca) ;
         
         reportSubprogParamMatchingError(sca, subprogramName, expectedTypes,
                                         expectedDirections, typesFound,
                                         directionsFound) ;
      }
      
      return isconsistent && hasCheckingPassed ;
   }
 
   private void reportSubprogParamMatchingError(
                                         Element e,
                                         String subprogramName,
                                         List<TypeHolder> expectedTypes,
                                         List<DirectionType> expectedDirections,
                                         List<TypeHolder> typesFound,
                                         List<DirectionType> directionsFound)
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
   private boolean assignementActionCheck(AssignmentAction aa)
   {
      Target tmp = targetCheck(aa.getTargetOwned()) ;

      boolean result = tmp != null ;
      
      TypeHolder tarType, expType ;
      tarType = expType = null ;

      // The returned target may be different from the tested target
      // because of semantic ambiguity resolution in targetCheck
      // method. So replace if needed.
      if(tmp != aa.getTargetOwned() && result)
      {
         aa.setTargetOwned(tmp) ;
      }

      if(aa.getValueExpressionOwned() != null)
      {
         ValueAndTypeHolder vth = 
                            valueExpressionCheck(aa.getValueExpressionOwned()) ;
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
            tarType = AadlBaUtils.getTypeHolder(tmp) ;
            result = _dataChecker.conformsTo(tarType, expType) ;
            if(! result)
            {
               reportTypeError(vth.value, "assignement",
                                       tarType.toString(), expType.toString()) ;
            }
         }
      }
      
      return result ;
   }

   // Semantic rule about iterative variable assignment is checked.
   // See BehaviorAnnexFeature.TARGET .
   // This method checks the given object and returns an object resolved from
   // semantic ambiguities. On error, reports error and returns null.
   private Target targetCheck(Target tar)
   {
      // Ambiguous case between name and unqualified data component
      // reference. Unqualified data component references are parsed
      // as name.
      if(tar instanceof Name)
      {
         return (Target) nameCheckAndResolveAmbiguity((Name) tar,
               TypeCheckRule.TARGET) ;
      }
      else
      {
         return (dataComponentReferenceCheck((DataComponentReference) tar)) ?
               tar : null ;
      }
   }

   // Compares the given expected data representation to the ValueAndTypeHolder
   // one.
   // Returns true is the data representation are the same.
   // Otherwise returns false and reports error.
   // If the given ValueAndTypeHolder object is null, it returns false without 
   // reporting any error.
   // If the given name is null, the method will unparse the given element.
   private boolean typeCheck(Element e, String name, ValueAndTypeHolder holder,
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
    * Checks the type of the reference linked to the given element within 
    * the given rule's expected types. Returns the
    * matching type or {@code null} otherwise. Reports any error.
    *
    * @param e the element to be checked
    * @param name the element's name
    * @param rule the checking rule that contains the expected types
    * @return the matching type or {@code null}
    */
   private Enum<?> typeCheck(Element el, String name, TypeCheckRule rule)
   {
      Enum<?> testedEnum = AadlBaUtils.getType(el) ;
      
      Enum<?> result = rule.test(testedEnum) ;
      
      if(result == null)
      {
         String expectedTypes = rule.getExpectedTypes(STRING_TYPE_SEPARATOR) ;
         String typeFound = ((Enumerator) testedEnum).getLiteral();
         reportTypeError(el, name, expectedTypes, typeFound) ;
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
   // Based on a design pattern command like.
   private enum TypeCheckRule implements Enumerator
   {
      
      IN_EVENT_PORT ("in event port", new Enum[] {
            FeatureType.IN_EVENT_PORT,
            FeatureType.IN_OUT_EVENT_PORT}),
      
      IN_EVENT_DATA_PORT ("in event data port", new Enum[] {
            FeatureType.IN_EVENT_DATA_PORT,
            FeatureType.IN_OUT_EVENT_DATA_PORT}),
      
      EVENT_DATA_PORT ("event data port", new Enum[]{
            FeatureType.IN_EVENT_DATA_PORT,
            FeatureType.OUT_EVENT_DATA_PORT,
            FeatureType.IN_OUT_EVENT_DATA_PORT}),
      
      IN_PORT ("in port", new Enum[]{
            FeatureType.IN_DATA_PORT,
            FeatureType.IN_OUT_DATA_PORT,
            
            FeatureType.IN_EVENT_PORT,
            FeatureType.IN_OUT_EVENT_PORT,
            
            FeatureType.IN_EVENT_DATA_PORT,
            FeatureType.IN_OUT_EVENT_DATA_PORT}),
      
      
      OUT_PORT ("out port", new Enum[]{
            FeatureType.OUT_DATA_PORT,
            FeatureType.IN_OUT_DATA_PORT,
            
            FeatureType.OUT_EVENT_PORT,
            FeatureType.IN_OUT_EVENT_PORT,
            
            FeatureType.OUT_EVENT_DATA_PORT,
            FeatureType.IN_OUT_EVENT_DATA_PORT}),
      
      PORT ("port", new Enum[] {
            
            FeatureType.IN_DATA_PORT,
            FeatureType.IN_OUT_DATA_PORT,
            FeatureType.OUT_DATA_PORT,
            
            FeatureType.IN_EVENT_PORT,
            FeatureType.IN_OUT_EVENT_PORT,
            FeatureType.OUT_EVENT_PORT,
            
            FeatureType.IN_EVENT_DATA_PORT,
            FeatureType.IN_OUT_EVENT_DATA_PORT,
            FeatureType.OUT_EVENT_DATA_PORT}),
      
      IN_PARAMETER("in parameter", new Enum[] {
            FeatureType.IN_PARAMETER,
            FeatureType.IN_OUT_PARAMETER}),    
            
      OUT_PARAMETER("out parameter", new Enum[] {
            FeatureType.OUT_PARAMETER,
            FeatureType.IN_OUT_PARAMETER}),      
            
      PARAMETER("parameter", new Enum[] {
         FeatureType.IN_PARAMETER,
         FeatureType.OUT_PARAMETER,
         FeatureType.IN_OUT_PARAMETER}),
         
      DATA_ACCESS("data access", new Enum[] {
         FeatureType.REQUIRES_DATA_ACCESS,
         FeatureType.PROVIDES_DATA_ACCESS }), 
      
      FROZEN_PORT("frozen port", new Enum[] {
            TypeCheckRule.IN_PORT}),
      
      DISPATCH_TRIGGER("dispatch trigger", new Enum[] {
            TypeCheckRule.IN_EVENT_PORT,
            TypeCheckRule.IN_EVENT_DATA_PORT}),
       
      DISPATCH_TRIGGER_CONDITION ("dispatch trigger condition",
         new Enum[]{
            TypeCheckRule.IN_EVENT_PORT,
            TypeCheckRule.IN_EVENT_DATA_PORT,
            FeatureType.PROVIDES_SUBPROGRAM_ACCESS}),
      
      // Always include at the end of an array:
      // because data subcomponent and data access are very high level types.
      DATA_COMPONENT_REFERENCE_FIRST_NAME("data subcomponent" +
            STRING_TYPE_SEPARATOR + "data access" + STRING_TYPE_SEPARATOR +
            "parameter",
         new Enum[] {
            FeatureType.DATA_SUBCOMPONENT,
            TypeCheckRule.DATA_ACCESS,
            TypeCheckRule.PARAMETER}),
                                 
      DATA_COMPONENT_REFERENCE_OTHER_NAMES("data subcomponent",
         new Enum[]{
            FeatureType.DATA_SUBCOMPONENT}),
      
      
      LOCAL_VARIABLE ("local variable", new Enum[] {
            BehaviorAnnexFeatureType.BEHAVIOR_VARIABLE,
            BehaviorAnnexFeatureType.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE}),
                        
      VALUE_VARIABLE ("value variable", new Enum[] {
            TypeCheckRule.IN_PORT,
            TypeCheckRule.IN_PARAMETER,
            TypeCheckRule.LOCAL_VARIABLE,
            TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME}),
                                 
      PROPERTY ("property", new Enum[]{
            FeatureType.PROPERTY_CONSTANT,
            FeatureType.PROPERTY_VALUE}),
                                
      PORT_COUNT_VALUE ("port count value", new Enum[]{
            TypeCheckRule.PORT}),
      
      PORT_DEQUEUE_VALUE ("port dequeue value", new Enum[]{
            TypeCheckRule.IN_PORT}),
 
      ELEMENT_VALUES ("element values", new Enum[] {
            TypeCheckRule.EVENT_DATA_PORT,
            TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME}),    

      TARGET ("target", new Enum[] {
            TypeCheckRule.OUT_PORT,
            TypeCheckRule.OUT_PARAMETER,
            BehaviorAnnexFeatureType.BEHAVIOR_VARIABLE,
            TypeCheckRule.DATA_COMPONENT_REFERENCE_FIRST_NAME}),
                                
      SHARED_DATA_ACTION ("shared data action", new Enum[] {
            FeatureType.REQUIRES_DATA_ACCESS}),
            
      PORT_DEQUEUE_ACTION ("port dequeue action", new Enum[] {
            TypeCheckRule.IN_PORT}),
            
      PORT_FREEZE_ACTION ("port freeze action", new Enum[] {
            TypeCheckRule.IN_PORT}),
                  
      SUBPROGRAM_CALL_ACTION_ONE_NAME ("subprogram call action", new Enum[] {
            FeatureType.SUBPROGRAM_SUBCOMPONENT,
            FeatureType.SUBPROGRAM_PROTOTYPE,
            FeatureType.SUBPROGRAM_CLASSIFIER,
            FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
            FeatureType.COMPONENT_PROTOTYPE_BINDING,
            TypeCheckRule.OUT_PORT}),
      
      SUBPROGRAM_CALL_ACTION_FIRST_NAME ("subprogram call action", new Enum[] {
            FeatureType.REQUIRES_DATA_ACCESS}),
                                
      SUBPROGRAM_CALL_ACTION_SD_NAME ("subprogram call action", new Enum[] {
            FeatureType.PROVIDES_SUBPROGRAM_ACCESS}),
                                   
      DATA_UCCR ("data unique component classifier reference", new Enum[] {
            FeatureType.DATA_CLASSIFIER}),
                                  
      SUBPROGRAM_UCCR ("subprogram unique component classifier reference",
            new Enum[] {FeatureType.SUBPROGRAM_CLASSIFIER})
      ;
      
      String _literal ;
      Enum<?>[] _acceptableTypes ;
      
      TypeCheckRule(String literal, Enum<?>[] acceptableTypes)
      {
         _literal = literal ;
         _acceptableTypes = acceptableTypes ;
      }
      
      /**
       * Returns the expected type names separated by the given type separator
       * string.
       * <BR><BR>
       * Note : this method is not recursive. 
       * 
       * @param typeSeparator the given type separator string 
       * @return the the expected type names separated by the given type
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
         
         return AadlBaUtils.concatenateString(typeSeparator, sa) ;
      }
      
      // Returns the matching feature type or behavior annex feature type
      // otherwise null.
      // Test is recursive.
      public Enum<?> test(Enum<?> other)
      {
         for(Enum<?> e : _acceptableTypes)
         {
            if(e instanceof TypeCheckRule)
            {
               if (testTypeCheckRule((TypeCheckRule)e, other) != null)
               {
                  return e ;
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
                  return e ;
               }
               else
               {
                  continue ;
               }
            }
         }
         
         return null ;
      }
      
      
      private Enum<?> testTypeCheckRule(TypeCheckRule tcr, Enum<?> other)
      {
         for(Enum<?> e : tcr._acceptableTypes)
         {
            if (e instanceof TypeCheckRule)
            {
               if (testTypeCheckRule((TypeCheckRule)e, other) != null)
               {
                  return e ;
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
                  return e ;
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