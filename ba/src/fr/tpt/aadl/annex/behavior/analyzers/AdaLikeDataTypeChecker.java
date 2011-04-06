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

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.Enumerator ;

import edu.cmu.sei.aadl.aadl2.DataClassifier ;
import edu.cmu.sei.aadl.aadl2.RangeValue ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation ;
import fr.tpt.aadl.annex.behavior.aadlba.Element ;
import fr.tpt.aadl.annex.behavior.aadlba.Factor ;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.PropertyValue ;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.Value ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaGetProperties ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;

public class AdaLikeDataTypeChecker implements DataTypeChecker
{
   private AnalysisErrorReporterManager _errManager ;
   
   // Expected data representation for numerics in value expression checking.
   private final static DataRepresentation[] _numTypes = 
      new DataRepresentation[]{DataRepresentation.INTEGER,
                               DataRepresentation.FLOAT};
   
   // Expected data representation for alphanumerics in value expression
   // checking.
   private final static DataRepresentation[] _alphaNumTypes = 
      new DataRepresentation[]{DataRepresentation.INTEGER,
                               DataRepresentation.FLOAT,
                               DataRepresentation.CHARACTER,
                               DataRepresentation.STRING};
   
   // Expected data representation for alphanumeric + boolean in value
   // expression checking.
   private final static DataRepresentation[] _alphaNumBoolTypes = 
      new DataRepresentation[]{DataRepresentation.INTEGER,
                               DataRepresentation.FLOAT,
                               DataRepresentation.CHARACTER,
                               DataRepresentation.STRING,
                               DataRepresentation.BOOLEAN};

   public AdaLikeDataTypeChecker(AnalysisErrorReporterManager errManager)
   {
      _errManager = errManager ;
   }
   
   @Override
   public boolean conformsTo(TypeHolder type1, TypeHolder type2)
   {
      boolean result = true ;
      
      // Preliminaries checking. 
      if(type1 == null || type2 == null ||
         type1.dataRep == null || type2.dataRep == null || 
         type1.dataRep == DataRepresentation.UNKNOWN && type1.klass == null ||
         type2.dataRep == DataRepresentation.UNKNOWN && type2.klass == null )
      {
         result = false ;
      }
      // The types are not consistency when their data representation are not
      // the same.
      else if(! type1.dataRep.equals(type2.dataRep))
      {
         result = false ;
      }
      // If both type have a classifier, their classifier's name must match.
      // Note that data structure are accepted as their data representation are
      // DataRepresentation.UNKNOWN .
      else if(type1.klass != null && type2.klass != null)
      {
         result = type1.klass.getQualifiedName().equalsIgnoreCase(
                                                type2.klass.getQualifiedName());
      }
      
      return result ;
   }
   
   public TypeHolder getTopLevelType(TypeHolder type1, TypeHolder type2)
   {
      if(conformsTo(type1, type2))
         return getTopLevelTypeWithoutConsistencyChecking(type1, type2) ;
      else
         return null ;
   }
   
   private TypeHolder getTopLevelTypeWithoutConsistencyChecking(TypeHolder type1,
                                                                TypeHolder type2)
   {
      TypeHolder result = new TypeHolder();
      result.dataRep = type1.dataRep ;
      DataClassifier c = (type1.klass != null) ? type1.klass : type2.klass ;
      result.klass = c ;
      return result ;
   }

   @Override
   public TypeHolder checkDefinition(fr.tpt.aadl.annex.behavior.aadlba.Element e,
                                     Enumerator operator,
                                     TypeHolder operand1,
                                     TypeHolder operand2)
   {
      // Operator ** has special consistency checking.
      if(operator != BinaryNumericOperator.MULTIPLY_MULTIPLY && 
         ! conformsTo(operand1, operand2))
      {
         reportErrorConsystency(e, operator, operand1, operand2);
         return null ;
      }
      
      if(operator instanceof LogicalOperator)
      {
         if(operand1.dataRep == DataRepresentation.BOOLEAN)
         {
            return getTopLevelTypeWithoutConsistencyChecking(operand1, operand1) ;
         }
         else
         {
            reportErrorBinaryOperator(e, operator, operand1);
            return null ;
         }
      }
      else if(operator instanceof RelationalOperator)
      {
         RelationalOperator rop = (RelationalOperator) operator ;
         DataRepresentation[] expectedTypes = null ;
         
         if(rop == RelationalOperator.EQUAL ||
            rop == RelationalOperator.NOT_EQUAL)
         {
            expectedTypes = _alphaNumBoolTypes ;
         }
         else
         {
            expectedTypes = _alphaNumTypes ; 
         }
         
         if (AadlBaUtils.contains(operand1.dataRep, expectedTypes))
         {
            return new TypeHolder(DataRepresentation.BOOLEAN, null) ;
         }
         else
         {
            reportErrorBinaryOperator(e, operator, operand1);
            return null ;
         }
      }
      else if(operator instanceof BinaryAddingOperator)
      {
         if(AadlBaUtils.contains(operand1.dataRep, _numTypes))
         {
            return getTopLevelTypeWithoutConsistencyChecking(operand1, operand2) ;
         }
         else
         {
            reportErrorBinaryOperator(e, operator, operand1);
            return null ;
         }
      }
      else if(operator instanceof MultiplyingOperator)
      {
         MultiplyingOperator op = (MultiplyingOperator) operator ;
         
         switch(op)
         {
            case MULTIPLY :
            case DIVIDE :
            {
               if(AadlBaUtils.contains(operand1.dataRep, _numTypes))
               {
                  return getTopLevelTypeWithoutConsistencyChecking(operand1,
                                                                   operand2);
               }
               else
               {
                  reportErrorBinaryOperator(e, operator, operand1);
                  return null ;
               }
            }
            
            case MOD :
            case REM :
            {
               if(operand1.dataRep == DataRepresentation.INTEGER)
               {
                  return getTopLevelTypeWithoutConsistencyChecking(operand1,
                                                                   operand2) ;
               }
               else
               {
                  reportErrorBinaryOperator(e, operator, operand1);
                  return null ;
               }
            }
            
            default : return null ;
         }
      } 
      else if(operator instanceof BinaryNumericOperator)
      {
         // Checks operands consistency:
         if(AadlBaUtils.contains(operand1.dataRep, _numTypes))
         {
            boolean reportError = false ;
            
            if(operand2.dataRep == DataRepresentation.INTEGER)
            {
               // Datatyped operand case : checks if operand2 is a natural.
               if(operand2.klass != null)
               {
                  EList<edu.cmu.sei.aadl.aadl2.PropertyValue> l = 
                     AadlBaGetProperties.getPropertyValue(operand2.klass,
                                            AadlBaGetProperties.INTEGER_RANGE) ;
                  if(l.size() > 0)
                  {
                     RangeValue rv = (RangeValue) l.get(l.size()-1) ;
                     if (rv.getMinimumValue().getScaledValue() < 0)
                     {
                        reportError = true ;
                     }
                  }
                  else
                  {
                     reportError = true ;
                  }
               }
               else // constant data case : checks if the constant value is not
                    // negative. 
               {
                  if(e instanceof Factor)
                  {
                     Value val = ((Factor) e).getValueSdOwned() ;
                     
                     // IntegerLiteral cannot be negative (otherwise parse 
                     // error) so it only checks
                     // PropertyConstants and warns PropertyValues.
                     if (val instanceof PropertyConstant)
                     {
                        edu.cmu.sei.aadl.aadl2.PropertyConstant pc = 
                           (edu.cmu.sei.aadl.aadl2.PropertyConstant) 
                              val.getAadlRef() ;
                        
                        edu.cmu.sei.aadl.aadl2.IntegerLiteral intLit = 
                           (edu.cmu.sei.aadl.aadl2.IntegerLiteral)
                              pc.getConstantValue() ;
                        if(intLit.getValue() < 0)
                        {
                           reportError = true ;
                        }
                     }
                     else if(val instanceof PropertyValue)
                     // PropertyValue case : its value can only be evaluated at
                     // runtime so raises a warning.
                     {
                        _errManager.warning(e, "Exponent must be of type " +
                              "natural") ;
                     }
                  }
               }
            }
            else
            {
               reportError = true ;
            }
            
            if(reportError)
            {
               _errManager.error(e, "exponent must be of type natural, found " + 
                              operand2.toString()) ;
               return null ;
            }
            else
            {
               return operand1 ;
            }
         }
         else
         {
            reportErrorConsystency(e, operator, operand1, operand2) ;
            return null ;
         }
      }
      else
      {
         String errorMsg = "operator : " + operator.getName() +
         " is not supported." ;
         System.err.println(errorMsg) ;
         throw new UnsupportedOperationException(errorMsg) ;
      }
   }

   @Override
   public TypeHolder checkDefinition(fr.tpt.aadl.annex.behavior.aadlba.Element e,
                                     Enumerator operator,
                                     TypeHolder operand)
   {
      if(operator == null || operator.getValue() == 0 || operand == null ||
         operand.dataRep == null ||
         operand.dataRep == DataRepresentation.UNKNOWN && operand.klass == null)   
      {
         reportErrorUnaryOperator(e, operator, operand);
         return null ;
      }
      
      if(operator instanceof UnaryAddingOperator || 
         operator instanceof UnaryNumericOperator)
      {
         if(AadlBaUtils.contains(operand.dataRep, _numTypes))
         {
            return operand ;
         }
         else
         {
            reportErrorUnaryOperator(e, operator, operand);
            return null ;
         }
      }
      else if(operator instanceof UnaryBooleanOperator)
      {
         if(operand.dataRep == DataRepresentation.BOOLEAN)
         {
            return operand ;
         }
         else
         {
            reportErrorUnaryOperator(e, operator, operand);
            return null ;
         }
      }
      else
      {
         String errorMsg = "operator : " + operator.getName() +
         " is not supported." ;
         System.err.println(errorMsg) ;
         throw new UnsupportedOperationException(errorMsg) ;
      }
   }
   
   private void reportErrorBinaryOperator(Element e,
                                          Enumerator operator,
                                          TypeHolder operand1)
   {
      _errManager.error(e, "There is no applicable operator \"" +
            operator.getLiteral() + "\" for type " + operand1.toString()); 
   }
   
   private void reportErrorConsystency(Element e,
                                          Enumerator operator,
                                          TypeHolder operand1,
                                          TypeHolder operand2)
   {
      _errManager.error(e, "Invalid operand types for operator \"" + 
            operator.getLiteral() + "\": left operand has type " + 
            operand1.toString() + ", right operand has type " + 
            operand2.toString()) ;
   }
   
   private void reportErrorUnaryOperator(Element e,
                                          Enumerator operator,
                                          TypeHolder operand)
   {
      _errManager.error(e, "Operator \"" + operator.getLiteral() + 
            "\" not defined for type " + operand.toString()) ;
   }
}