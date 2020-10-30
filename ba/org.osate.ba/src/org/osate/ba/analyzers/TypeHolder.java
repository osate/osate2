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
   private DataRepresentation dataRep = DataRepresentation.UNKNOWN ;

   /**
    * Holds a DataClassifier.
    */
   private DataClassifier klass ;


   /**
    * Holds the number of dimension of the type. Default dimension is zero.
    */
   private int dimension = 0;

   /**
    * Holds the size of each dimension of the type.
    */
   private long[] dimension_sizes = new long[0] ;

   private static final String ARRAY_DIMENSION_TOKEN = "[]" ;

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
      this.setDataRep(dataRep) ;
      this.setKlass(klass) ;
   }

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      if(getKlass() != null)
      {
        result.append(getKlass().getQualifiedName()) ;
      }
      else
      {
        result.append(getDataRep().getLiteral()) ;
      }

      for(int i = 0 ; i < getDimension() ; i++)
      {
         result.append(ARRAY_DIMENSION_TOKEN) ;
      }

      return result.toString() ;
   }

  public DataRepresentation getDataRep()
  {
    return dataRep;
  }

  public void setDataRep(DataRepresentation dataRep)
  {
    this.dataRep = dataRep;
  }

  public DataClassifier getKlass()
  {
    return klass;
  }

  public void setKlass(DataClassifier klass)
  {
    this.klass = klass;
  }

  public int getDimension()
  {
    return dimension;
  }

  public void setDimension(int dimension)
  {
    this.dimension = dimension;
  }

  public long[] getDimensionSizes()
  {
    return dimension_sizes;
  }

  public void setDimensionSizes(long[] dimension_sizes)
  {
    this.dimension_sizes = dimension_sizes;
  }
}
