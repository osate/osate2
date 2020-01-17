/**
 * AADL-Utils
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package org.osate.utils ;

/**
 * Represents a range of integer. 
 *
 */
public class IntegerRange
{
  private final int min, max ;

  /**
   * Builds an instance of IntegerRange with the given parameters.
   * 
   * @param min the integer range's lower bound
   * @param max the integer range's upper bound
   */
  public IntegerRange(int min, int max)
  {
    this.min = min ;
    this.max = max ;
  }
  
  /**
   * Returns the integer range's upper bound.
   * @return the integer range's upper bound
   */
  public int getMin()
  {
    return min ;
  }
  
  /**
   * Returns the integer range's lower bound.
   * @return the integer range's lower bound
   */
  public int getMax()
  {
    return max ;
  }
  
  /**
   * Returns the length of the integer range.
   * 
   * @return the length of the integer range
   */
  public int length()
  {
    return max - min ;
  }
}