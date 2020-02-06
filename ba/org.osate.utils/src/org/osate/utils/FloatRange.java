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
 * Represents a range of float number. 
 */
public class FloatRange
{

  public final static FloatRange nullValue = new FloatRange(0f, 0f) ;

  private final float min, max ;
  
  /**
   * Builds a instance of FloatRange with the given parameters.
   * 
   * @param min the float range's lower bound
   * @param max the float range's upper bound
   */
  public FloatRange(float min, float max)
  {
    this.min = min ;
    this.max = max ;
  }

  public FloatRange(float value)
  {
    this(value, value) ;
  }
  
  /**
   * Returns the float range's lower bound.
   * @return the float range's lower bound
   */
  public float getMin()
  {
    return min ;
  }
  
  /**
   * Returns the float range's upper bound.
   * @return the float range's upper bound
   */
  public float getMax()
  {
    return max ;
  }
}