package fr.tpt.aadl.annex.behavior.utils;

import org.osate.aadl2.Element ;

import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;

public class DimensionException extends Exception
{
   /**
    * 
    */
   private static final long serialVersionUID = -7962508017913234922L ;
   
   public Element _element ;
   
   public DimensionException(Element element, String message)
   {
      super(message) ;
      _element = element ;
   }
   
   public static String formatMessage(TypeHolder type, int exprDim,
                                      int declaredDim)
   {
      StringBuilder sb = new StringBuilder();
      
      sb.append("the type of the expression must be an array type but it is ") ;
      sb.append("resolved as ");
      sb.append(type.klass.getQualifiedName());
      
      return sb.toString() ;
   }
}
