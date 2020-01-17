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

package org.osate.ba.analyzers;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.Enumerator ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.RangeValue ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorPropertyConstant ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.DataRepresentation ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.PropertyReference ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;
import org.osate.ba.aadlba.Value ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.names.DataModelProperties ;


public class AdaLikeDataTypeChecker implements DataTypeChecker
{
   private AnalysisErrorReporterManager _errManager ;
   
   // Expected data representation for numerics in value expression checking,
   // excepted for operator **
   private final static DataRepresentation[] _numTypes = 
      new DataRepresentation[]{DataRepresentation.INTEGER,
                               DataRepresentation.FLOAT,
                               DataRepresentation.FIXED};
   
   // Expected data representation for numerics in operator ** 
   // expression checking.
   private final static DataRepresentation[] _numTypesWithoutFixed = 
      new DataRepresentation[]{DataRepresentation.INTEGER,
                               DataRepresentation.FLOAT};
   
   // Expected data representation for alphanumerics in value expression
   // checking.
   private final static DataRepresentation[] _alphaNumTypes = 
      new DataRepresentation[]{DataRepresentation.INTEGER,
                               DataRepresentation.FLOAT,
                               DataRepresentation.FIXED,
                               DataRepresentation.CHARACTER,
                               DataRepresentation.STRING};
   
   public AdaLikeDataTypeChecker(AnalysisErrorReporterManager errManager)
   {
      _errManager = errManager ;
   }
   
   @Override
   public boolean conformsTo(TypeHolder type1, TypeHolder type2,
                             boolean hasToCheckDimension)
   {
      boolean result = true ;
      /*
       * As type checking is not mature, we disable it (this method always
       * returns true). It impacts:
       *  _ assignment checking
       *  _ for/forall checking
       *  _ integer range checking
       *  _ port dequeue action checking
       *  _ port send action checking
       *  _ subprogram parameters checking
       * 
       * 
      // Preliminaries checking. 
      if(type1 == null || type2 == null ||
         type1.dataRep == null || type2.dataRep == null || 
         type1.dataRep == DataRepresentation.UNKNOWN && type1.klass == null ||
         type2.dataRep == DataRepresentation.UNKNOWN && type2.klass == null )
      {
         result = false ;
      }
      else 
      {
        // The types are not consistency when their data representation are not
        // the same, excepted Fixed point and universal float.
        if(  (
                type1.dataRep.equals(DataRepresentation.FLOAT) &&
                type1.klass == null &&
                type2.dataRep.equals(DataRepresentation.FIXED)
             )  ||
             (
                type2.dataRep.equals(DataRepresentation.FLOAT) &&
                type2.klass == null &&
                type1.dataRep.equals(DataRepresentation.FIXED)
             )
           )
        {
           result = true ;
        }
        else if( false == type1.dataRep.equals(type2.dataRep) ||
                 (hasToCheckDimension && (type1.dimension != type2.dimension))
               )
    	  {
        	 result = false ;
    	  }
        else if(type1.klass != null && type2.klass != null)
        {
      	 // If both type have a classifier, their classifier's name must match.
      	 result = type1.klass.getQualifiedName().equalsIgnoreCase(
                                                type2.klass.getQualifiedName());
        }
      }
      */
      return result ;
   }
   
   public TypeHolder getTopLevelType(TypeHolder type1,
                                     TypeHolder type2)
   {
      if(conformsTo(type1, type2, true))
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
   public TypeHolder checkDefinition(BehaviorElement e,
                                     Enumerator operator,
                                     TypeHolder operand1,
                                     TypeHolder operand2)
   {
      // Operator ** has special consistency checking.
      if(operator != BinaryNumericOperator.MULTIPLY_MULTIPLY && 
         ! conformsTo(operand1, operand2, true))
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
         
         // Operators = and != are defined for all coherent types.
         if(rop == RelationalOperator.EQUAL ||
            rop == RelationalOperator.NOT_EQUAL)
         {
            return new TypeHolder(DataRepresentation.BOOLEAN, null) ;
         }
         
         expectedTypes = _alphaNumTypes ; 
         
         if (Aadl2Utils.contains(operand1.dataRep, expectedTypes))
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
         if(Aadl2Utils.contains(operand1.dataRep, _numTypes))
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
               if(Aadl2Utils.contains(operand1.dataRep, _numTypes))
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
         if(Aadl2Utils.contains(operand1.dataRep, _numTypesWithoutFixed))
         {
            boolean reportError = false ;
            
            if(operand2.dataRep == DataRepresentation.INTEGER)
            {
               // Datatyped operand case : checks if operand2 is a natural.
               if(operand2.klass != null)
               {
                  EList<org.osate.aadl2.PropertyExpression> l = 
                     PropertyUtils.findPropertyExpression(operand2.klass,
                    		                DataModelProperties.INTEGER_RANGE) ;
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
                     Value val = ((Factor) e).getSecondValue() ;
                     
                     // IntegerLiteral cannot be negative (otherwise parse 
                     // error) so it only checks
                     // PropertyConstants and warns PropertyValues.
                     if (val instanceof BehaviorPropertyConstant)
                     {
                       BehaviorPropertyConstant bpc = (BehaviorPropertyConstant)
                                                                           val ;
                       
                       org.osate.aadl2.PropertyConstant pc = bpc.getProperty() ;
                        
                        org.osate.aadl2.IntegerLiteral intLit = 
                           (org.osate.aadl2.IntegerLiteral)
                              pc.getConstantValue() ;
                        if(intLit.getValue() < 0)
                        {
                           reportError = true ;
                        }
                     }
                     else if(val instanceof PropertyReference)
                     // PropertyValue case : its value can only be evaluated at
                     // runtime so raises a warning.
                     {
                        _errManager.warning(e, "Cannot evaluate if the exponent"+
                                               " is a natural") ;
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
   public TypeHolder checkDefinition(BehaviorElement e,
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
         if(Aadl2Utils.contains(operand.dataRep, _numTypes))
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
   
   private void reportErrorBinaryOperator(BehaviorElement e,
                                          Enumerator operator,
                                          TypeHolder operand1)
   {
      _errManager.error(e, "There is no applicable operator \"" +
            operator.getLiteral() + "\" for type " + operand1.toString()); 
   }
   
   private void reportErrorConsystency(BehaviorElement e,
                                       Enumerator operator,
                                       TypeHolder operand1,
                                       TypeHolder operand2)
   {
      _errManager.error(e, "Invalid operand types for operator \"" + 
            operator.getLiteral() + "\": left operand has type " + 
            operand1.toString() + ", right operand has type " + 
            operand2.toString()) ;
   }
   
   private void reportErrorUnaryOperator(BehaviorElement e,
                                         Enumerator operator,
                                         TypeHolder operand)
   {
      _errManager.error(e, "Operator \"" + operator.getLiteral() + 
            "\" not defined for type " + operand.toString()) ;
   }
}