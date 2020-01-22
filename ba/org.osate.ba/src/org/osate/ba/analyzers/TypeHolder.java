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

import org.osate.aadl2.DataClassifier ;
import org.osate.ba.aadlba.DataRepresentation ;

/**
 * AADL type holder definition. 
 *
 */
public class TypeHolder
{
   /**
    * Holds a DataRepresentation that models Data_Model::Data_Representation.  
    */
   public DataRepresentation dataRep = DataRepresentation.UNKNOWN ;
   
   /**
    * Holds a DataClassifier.
    */
   public DataClassifier klass ;

   
   /**
    * Holds the number of dimension of the type. Default dimension is zero.
    */
   public int dimension = 0;
   
   /**
    * Holds the size of each dimension of the type.
    */
   public long[] dimension_sizes = new long[0]; ;
   
   private final static String ARRAY_DIMENSION_TOKEN = "[]" ;
   
   /**
    * Builds a TypeHolder object with default attributes ({@code null}).
    */
   public TypeHolder() {}
   
   /**
    * Builds a TypeHolder object with the given parameters.
    * 
    * @param dataRep the data representation or DataRepresentation.Unknown
    * @param klass the Classifier or {@code null}
    */
   public TypeHolder(DataRepresentation dataRep, DataClassifier klass)
   {
      this.dataRep = dataRep ;
      this.klass = klass ;
   }
   
   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();
      
      if(klass != null)
         result.append(klass.getQualifiedName()) ;
      else
         result.append(dataRep.getLiteral()) ;
      
      for(int i = 0 ; i < dimension ; i++)
      {
         result.append(ARRAY_DIMENSION_TOKEN) ;
      }
      
      return result.toString() ;
   }
}
