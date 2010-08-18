package fr.tpt.aadl.annex.behavior.utils;

import java.util.Comparator ;
import java.util.Iterator ;
import java.util.List ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.DirectedFeature ;
import edu.cmu.sei.aadl.aadl2.DirectionType ;
import edu.cmu.sei.aadl.aadl2.NamedElement ;
import edu.cmu.sei.aadl.aadl2.UnitLiteral ;
import edu.cmu.sei.aadl.aadl2.parsesupport.AObject ;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.Name ;
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
    * @param direction the given direction or {@code null}
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
   
   /**
    * Check a given BehaviorTime object (check its integer value).<BR><BR>
    * 
    * Reports any error with a given error reporter manager.
    * 
    * @param behTime the given BehaviorTime object
    * @param errManager  the given error reporter manager.
    * @return {@code true} if checking passed. {@code false} otherwise.
    */
   public static boolean checkBehaviorTime(BehaviorTime behTime,
                                        AnalysisErrorReporterManager errManager)
   {
      // As time unit is check during name resolution, only check integer value
      // owned.
      return checkIntegerValue(behTime.getIntegerValueOwned(), errManager) ;
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
    * is based on identifier's name (case insensitive). Lists may not be sorted
    * so complexity is O(n²).
    * 
    * @param l1  the given list (sorted or not)
    * @param l2 the other list (sorted or not)
    * @return {@code true} if the first list contains the same identifier's
    * names than the second one. {@code false} otherwise.
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
    * Create a DataComponentReference objects comparator.<BR><BR> 
    * 
    * This comparator doesn't support array indexes comparison, meaning that two
    * data component references with the same names and different array indexes
    * are considered as equals since the array index are integer variables and
    * the behavior annex doesn't perform dynamic checking.<BR><BR>
    * 
    * It does not perform data component reference checking.
    * 
    * @return a data component reference Comparator object. 
    */
   static public Comparator<DataComponentReference>
                                        createDataComponentReferenceComparator()
   {
      return new Comparator<DataComponentReference>()
      {
         public int compare(DataComponentReference dcr1,
                            DataComponentReference dcr2)
         {
            int result = 0 ;
            
            Name n1 = null ;
            Name n2 = null ;
            
            EList<Name> ln1 = null ;
            EList<Name> ln2 = null ;
            
            
            // This comparator compares two list of names with the same size or
            // it compares the largest size one with the smallest one in order
            // to avoid index out of bounds exception.
            if(dcr1.getElementsNameOwned().size() >= 
               dcr2.getElementsNameOwned().size())
            {
               ln1 = dcr1.getElementsNameOwned() ;
               ln2 = dcr2.getElementsNameOwned() ;
            }
            else
            {
               ln2 = dcr1.getElementsNameOwned() ;
               ln1 = dcr2.getElementsNameOwned() ;
            }
            
            // Compare the dcr's names one to one.
            for(int i = 0 ; i < ln1.size() ; i++)
            {
               n1 = ln1.get(i) ;
               
               // Since dcr can have different size of qualifying names,
               // this avoids index out of bounds exception.
               if(i < ln2.size())
               {
                  n2 = ln2.get(i) ;
                  result = n1.getIdentifier().getId().compareToIgnoreCase(
                                                   n2.getIdentifier().getId()) ;
                  
                  if(result != 0)
                  {
                     return result ;
                  }
               }
               else // return the comparison result between null and the current
                    // first list's name in case of second list's size smaller. 
               {
                  return  n1.getIdentifier().getId().compareToIgnoreCase(null) ;
               }
            }
            
            return result ;
         }
      } ;
   }
   
   /**
    * Create a behavior time comparator.<BR><BR>
    * 
    * This comparator supports time units (from AADL property set Time_Units)
    * comparison. For example, comparing 60 sec and 1 min returns 0.<BR><BR>
    * 
    * It only supports behavior time with numeric literal constant integer
    * values (NumericLiteral). Otherwise it throws a ClassCastException. 
    * 
    * @return a behavior time comparator
    * @throws ClassCastException if behavior time are not numeric literal
    * constant integer values (NumericLiteral)
    */
   public static Comparator<BehaviorTime> createBehaviorTimeComparator()
   {
      return new Comparator<BehaviorTime>()
      {
         public int compare(BehaviorTime behT1, BehaviorTime behT2)
         {
            IntegerValue iv1 = behT1.getIntegerValueOwned() ;
            IntegerValue iv2 = behT2.getIntegerValueOwned() ;
            
            if(iv1 instanceof NumericLiteral &&
               iv2 instanceof NumericLiteral)
            {
                  double d1 = Double.parseDouble(((NumericLiteral) iv1)
                                                                .getNumValue());
                  double d2 = Double.parseDouble(((NumericLiteral) iv2)
                                                                .getNumValue());
                  
                  UnitLiteral unit1 = (UnitLiteral) behT1.getUnitIdentifier()
                                                    .getAadlReferencedEntity() ;
                  UnitLiteral unit2 = (UnitLiteral) behT2.getUnitIdentifier()
                                                    .getAadlReferencedEntity() ;
                  
                  double relativeFact = unit1.getAbsoluteFactor(unit2) ; 
                                   
                  // Convert to the smallest time unit. In order to keep 
                  // the highest precision.
                  if (relativeFact < 1)
                  {
                     d2 *= unit2.getAbsoluteFactor(unit1) ; 
                  }
                  else
                  {
                     d1 *= relativeFact ;
                  }
                  
                  return (d1<d2 ? -1 : (d1==d2 ? 0 : 1));
            }
            else
            {
               throw new ClassCastException("Can't compare BehaviorTime with " +
                     "IntegerValue other than those of Numerical type") ;
            }
         }
      } ;
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
