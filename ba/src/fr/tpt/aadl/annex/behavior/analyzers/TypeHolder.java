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
