package fr.tpt.aadl.annex.behavior.analyzers;

import org.eclipse.emf.common.util.Enumerator ;

/**
 * Data type checker specifications.
 * 
 */
public interface DataTypeChecker
{
   /**
    * Checks if the given binary operator is defined for the given operands.  
    * Returns the type of the result (top level type) but on error, reports error
    * and returns null.
    * 
    * @param e the element that the given operator belongs to
    * @param operator the given operator
    * @param operand1 the left operand
    * @param operand2 the right operand
    * @return he type of the result or {@code null} on error
    */
   TypeHolder checkDefinition(fr.tpt.aadl.annex.behavior.aadlba.Element e,
                              Enumerator operator,
                              TypeHolder operand1,
                              TypeHolder operand2);
   
   /**
    * Checks if the given unary operator is defined for the given operand.  
    * Returns the type of the result (top level type) but on error, reports error
    * and returns null.
    * 
    * @param e the element that the given operator belongs to
    * @param operator the given operator
    * @param operand the given operand
    * @return the type of the result or {@code null} on error
    */
   TypeHolder checkDefinition(fr.tpt.aadl.annex.behavior.aadlba.Element e,
                              Enumerator operator,
                              TypeHolder operand);
   
   /**
    * Returns {@code true} if the given type1 conforms to the given type 2.
    * Otherwise returns {@code false}.
    * 
    * @param type1 the given type1
    * @param type2 the given type2
    */
   boolean conformsTo(TypeHolder type1, TypeHolder type2) ;
   
   /**
    * Checks if the type1 conforms to type2 
    * (see {@link #conformsTo(TypeHolder, TypeHolder)}) and returns the top 
    * level type of the given types. 
    * 
    * @param type1 the given type1
    * @param type2 the given type2
    * @return the top level type of the given types. 
    */
   TypeHolder getTopLevelType(TypeHolder type1, TypeHolder type2) ;
}
