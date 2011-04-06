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

import edu.cmu.sei.aadl.aadl2.DataClassifier ;
import fr.tpt.aadl.annex.behavior.aadlba.DataRepresentation ;

/**
 * AADL type holder definition. 
 *
 */
public class TypeHolder
{
   /**
    * Holds a DataRepresentation that models Data_Model::Data_Representation.  
    */
   public DataRepresentation dataRep ;
   
   /**
    * Holds a DataClassifier.
    */
   public DataClassifier klass ;
   
   /**
    * Builds a TypeHolder object with uninitialized attributes ({@code null}).
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
      if(klass != null)
         return klass.getQualifiedName() ;
      else
         return dataRep.getLiteral() ;
   }
}
