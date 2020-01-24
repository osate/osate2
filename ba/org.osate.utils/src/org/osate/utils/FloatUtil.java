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

import java.math.BigDecimal ;

/**
 * BigDecimal framework front end for arithmetic operations on float values.
 */
public class FloatUtil
{
  /**
   * Sums the given float values.
   * 
   * @param values the given values
   * @return the sum
   */
  public static float add(float... values)
  {
    BigDecimal res = new BigDecimal("0") ;

    for(float f : values)
    {
      BigDecimal bf = new BigDecimal(f + "") ;
      res = res.add(bf) ;
    }

    return res.floatValue() ;
  }
  
  /**
   * Subtracts the given left float value by the given right float value.
   * 
   * @param left the left float value
   * @param right the right float value
   * @return the subtraction result
   */
  public static float subtract(float left,
                               float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;
    return iLeft.subtract(iRight).floatValue() ;
  }
  
  /**
   * Divides the given left float value by the given right float value.
   * 
   * @param left the left float value
   * @param right the right float value
   * @return the division result
   */
  public static float divide(float left,
                             float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;

    try
    {
      return iLeft.divide(iRight).floatValue() ;
    }
    catch(Exception e)
    {
      return iLeft.divide(iRight, BigDecimal.ROUND_HALF_DOWN).floatValue() ;
    }
  }
  
  /**
   * Divides the given left float value by the given right float value and 
   * returns the smallest integer value of division result that is not less than
   * the result.
   * 
   * @param left the left float value
   * @param right the right float value
   * @return the smallest integer value of division result that is not less than
   * the result
   */
  public static int ceil_divide(float left,
                                float right)
  {
    float resF = divide(left, right) ;

    if(((int) resF) != resF)
    {
      return 1 + (int) resF ;
    }
    else
    {
      return (int) resF ;
    }
  }

  /**
   * Multiplies the given left float value by the given right float value.
   * 
   * @param left the left float value
   * @param right the right float value
   * @return the multiplication result
   */
  public static float multiply(float left,
                               float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;
    return iLeft.multiply(iRight).floatValue() ;
  }
}