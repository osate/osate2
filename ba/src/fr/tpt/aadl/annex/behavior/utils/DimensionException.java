package fr.tpt.aadl.annex.behavior.utils;

import org.osate.aadl2.Element ;

/**
 * Represents an exception raised when out of array dimension accessing.
 */
public class DimensionException extends Exception
{
   /**
    * 
    */
   private static final long serialVersionUID = -7962508017913234922L ;
   
   public Element _element ;
   
   public boolean _isWarning = false ;
   
   public DimensionException(Element element, String message,
                              boolean isWarning)
   {
      super(message) ;
      _element = element ;
      _isWarning = isWarning ;
   }
   
   public boolean isWarning()
   {
     return _isWarning ;
   }
}
