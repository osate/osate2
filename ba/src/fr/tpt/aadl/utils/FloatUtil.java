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
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.utils ;

import java.math.BigDecimal ;

public class FloatUtil
{

  public FloatUtil()
  {
  }

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

  public static float subtract(float left,
                               float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;
    return iLeft.subtract(iRight).floatValue() ;
  }

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

  public static float multiply(float left,
                               float right)
  {
    BigDecimal iLeft = new BigDecimal(left + "") ;
    BigDecimal iRight = new BigDecimal(right + "") ;
    return iLeft.multiply(iRight).floatValue() ;
  }
}
