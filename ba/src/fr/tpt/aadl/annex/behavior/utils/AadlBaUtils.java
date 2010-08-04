package fr.tpt.aadl.annex.behavior.utils;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.cmu.sei.aadl.aadl2.DirectedFeature ;
import edu.cmu.sei.aadl.aadl2.DirectionType ;
import edu.cmu.sei.aadl.aadl2.NamedElement;
import edu.cmu.sei.aadl.aadl2.parsesupport.AObject ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.NumericLiteral ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueVariable ;

public class AadlBaUtils {

   /**
    * Check if a given class is a superclass or a superinterface of the 
    * identifier's referenced entity (aadl or behavior annex).
    * <BR><BR>
    * Check referenced entity's direction with a given one only if the
    * referenced entity is an implementation of the DirectedFeature interface
    * and if the given direction is not null. Otherwise do nothing.
    * <BR><BR>
    * Reports any error with a given error reporter manager.
    * 
    * @param id the Identifier object to be checked.
    * @param klass the class 
    * @param direction the given direction
    * @param errManager the given error reporter manager
    * @return {@code true} if checking passed. {@code false} otherwise.
    */
   public static boolean checkIdentifier(Identifier id,
                                  Class<? extends AObject> klass,
                                  DirectionType direction,
                                  AnalysisErrorReporterManager errManager)
   {
      if(id.getBaReferencedEntity() == null && 
         id.getAadlReferencedEntity() == null)
      {
         errManager.error(id, "Behavior Semantic Error: " +  id.getId() +
                            " : reference entity is not found.") ;
         return false ;
      }
      else // Case of an existing reference entity. 
      {
         AObject obj = null ;
         
         // Case of NOT a BA referenced entity.
         if (id.getBaReferencedEntity() == null || 
             (! klass.isAssignableFrom(id.getBaReferencedEntity().getClass())))
         {
            // Case of NOT a AADL referenced entity :
            // the referenced entity is not the suitable type.
            if (! klass.isAssignableFrom(
                                       id.getAadlReferencedEntity().getClass()))
            {
               errManager.error(id, "Behavior Semantic Error: " + id.getId() +
                     " : wrong type. A \"" + klass.getSimpleName() + 
                     "\" entity is excepted") ;
               return false ;
            }
            else
            {
               obj = id.getAadlReferencedEntity() ;
            }
         }
         else
         {
            obj = id.getBaReferencedEntity() ;
         }
         
         // Check direction.
         if(direction != null && DirectedFeature.class.isAssignableFrom(klass))
         {
            
            DirectionType currentDirection =
               ((DirectedFeature)obj).getDirection() ;
            
            if(direction == currentDirection)
            {
               return true ;
            }
            else
            {
               errManager.error(id, "Behavior Semantic Error: " + id.getId() +
                  " : wrong direction. A \"" + direction.getName() +
                    "\" entity is excepted") ;
               return false ;
            }
         } 
         else // Case of a none directed feature or caller don't want to
              // check direction.
         {
            return true ;
         }
      }// End of first else.
   }
   
   // TODO : to be implemented
   // Is considered as an integer value :
   
   // Within value variable
   // _ local variable
   // _ data component reference
   // _ port count
   
   // Within value constant
   // _ numeric literal
   // _ property set constant
   // _ property set value
   
   // Warning : ambiguity between name and unqualified property set constant
   // or value.
   
   // Notes : 
   // _ this doesn't parse string literal. Meaning string literals are not 
   // true integer values.
   // AnalysisErrorReporterManager so as to report any error.
   public static  boolean checkIntegerValue(IntegerValue value, 
                                        AnalysisErrorReporterManager errManager)
   {
      // TODO : to be implemented.
      boolean result = true ;
      
      try
      {
         if (value instanceof ValueVariable)
         {
            // Warning : ambiguity between one name value variable (data 
            // component reference, port name, subprogram parameter, local
            // variable) and also predeclared property set constant and value (
            // one name also).
            
            // Case of true date component reference.
            if(value instanceof DataComponentReference)
            {
               // TODO : to be implemented.
            }
            else // Case of one name integer value.
            {
               // TODO : to be implemented.
            }
         }
         else
         {
            if (value instanceof ValueConstant)
            {
               // Case of numeric literal.
               if(value instanceof NumericLiteral)
               {
               // TODO : to be implemented.
               }
               else
               {
                  // Case of a qualified property set constant.
                  if (value instanceof fr.tpt.aadl.annex.behavior.aadlba.
                                                               PropertyConstant)
                  {
                  // TODO : to be implemented.
                  }
                  else
                  {
                     // Case of a qualified property set value.
                     if (value instanceof fr.tpt.aadl.annex.behavior.aadlba.
                                                                  PropertyValue)
                     {
                     // TODO : to be implemented.
                        // see edu.cmu.sei.aadl.aadl2.PropertyConstant getType.
                     }
                     else // Case of unsupported types.
                     {
                        // TODO : to be implemented.
                     }
                  }
               }
            }
            else // Case of type not supported.
            {
            // TODO : to be implemented.
            }
         }
      }
      catch (Exception e)
      {
         // TODO : to be implemented.
         return false ;
      }
      
      return result ;
   }
   
   /**
    * Compare a given Identifier objects list to an other. The matching
    * is based on identifier's name (case insensitive). Lists orders are
    *  not taken in account.
    * 
    * @param l1  the given list
    * @param l2 the other list
    * @return {@code true} if the first list contains the same identifier's
    * names than the second one (in any order). {@code false} otherwise.
    */
   static public boolean compareIdentifiersList(EList<Identifier> l1,
                                         EList<Identifier> l2)
   {
      boolean tmp = false ;
      
      for (Identifier id1 : l1)
      {
         for (Identifier id2 : l2)
         {
            if(id1.getId().equalsIgnoreCase(id2.getId()))       
            {
               tmp = true ;
               break ;
            }
         }
         
         // Matching case : reset tmp flag.
         if (tmp)
         {
            tmp = false ;
         }
         else // Unmatching case : stop comparing.
         {
            return false ;
         }
      }
      return true ;
   }
   
   /**
	 * Constructs a string with the identifier of elements
	 * in a list.
	 * 
	 * @param l the given list of elements
	 * @return the string composed of all element identifiers
	 */
	public static String ListToString(EList<Identifier> l) {

		String result = "";

		for (Identifier i : l) {
			result += i.getId() + ":" + i.getLocationReference().getLine() + " ";
		}
		return result;
	}
	
	
	// Import frome AadlUtil modelsupport
	/**
	 * find (first) Named Element matching name in the Elist; any elements that
	 * are not NamedElements are skipped.
	 * 
	 * @param el Elist of NamedElements
	 * @param name String
	 * @return NamedElement
	 */
	public static NamedElement findNamedElementInList(List<?> el, String name) {
		if (el != null) {
			Iterator<?> it = el.iterator();

			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();

					if (n != null && n.length() > 0 && name.equalsIgnoreCase(n)) {
						return (NamedElement) o;
					}
				}
			}
		}
		return null;
	}

	/**
	 * find all Named Elements matching name in the Elist; any elements that are
	 * not NamedElements are skipped.
	 * 
	 * @param el Elist of NamedElements
	 * @param name String
	 * @return EList of NamedElements that match the name
	 */
	public static EList<NamedElement> findNamedElementsInList(List<?> el, String name) {
		EList<NamedElement> result = new BasicEList<NamedElement>();

		if (el != null) {
			Iterator<?> it = el.iterator();
			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();
					if (n != null && name.length() > 0 && name.equalsIgnoreCase(n)) {
						result.add((NamedElement) o);
					}
				}
			}
		}
		return result;
	}
}
