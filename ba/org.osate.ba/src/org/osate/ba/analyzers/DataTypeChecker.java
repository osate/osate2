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

import org.eclipse.emf.common.util.Enumerator ;
import org.osate.ba.aadlba.BehaviorElement ;


/**
 * Data type checker specifications.
 */
public interface DataTypeChecker
{
   /**
    * Checks if the given binary operator is defined for the given operands.  
    * Returns the type of the result (top level type) but on error, reports error
    * and returns null.
    * 
    * @param e the behavior element that the given operator belongs to
    * @param operator the given operator
    * @param operand1 the left operand
    * @param operand2 the right operand
    * @return he type of the result or {@code null} on error
    */
   TypeHolder checkDefinition(BehaviorElement e,
                              Enumerator operator,
                              TypeHolder operand1,
                              TypeHolder operand2);
   
   /**
    * Checks if the given unary operator is defined for the given operand.  
    * Returns the type of the result (top level type) but on error, reports error
    * and returns null.
    * 
    * @param e the behavior element that the given operator belongs to
    * @param operator the given operator
    * @param operand the given operand
    * @return the type of the result or {@code null} on error
    */
   TypeHolder checkDefinition(BehaviorElement e,
                              Enumerator operator,
                              TypeHolder operand);
   
   /**
    * Returns {@code true} if the given type1 conforms to the given type 2.
    * Otherwise returns {@code false}.
    * 
    * @param type1 the given type1
    * @param type2 the given type2
    * @param hasToCheckDimension if {@code true}, checks type's array dimension.
    * else it doesn't.
    */
   boolean conformsTo(TypeHolder type1, TypeHolder type2,
                      boolean hasToCheckDimension) ;
   
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
