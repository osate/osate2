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
 * A collection of time unit conversion methods. 
 */
public class UnitConversion
{
  
  /**
   * Returns the given value expressed in the given time unit in milliseconds. 
   * <BR><BR>
   * time unit format supported:<BR><BR>
   * _ hr for hour<BR>
   * _ min for minute<BR>
   * _ sec for second<BR>
   * _ ms for millisecond<BR>
   * _ us for microsecond<BR>
   * _ ns for nanosecond<BR>
   * _ ps for picosecond<BR>
   * 
   * @param value the given value
   * @param sourceUnit the given time unit
   * @return the value in milliseconds
   */
  public static float convertInMs(float value,
                                  String sourceUnit)
  {
    if(sourceUnit.equals("hr"))
    {
      float min = FloatUtil.multiply(value, 60) ;
      return convertInMs(min, "min") ;
    }

    if(sourceUnit.equals("min"))
    {
      float sec = FloatUtil.multiply(value, 60) ;
      return convertInMs(sec, "sec") ;
    }

    if(sourceUnit.equals("sec"))
    {
      float ms = FloatUtil.multiply(value, 1000) ;
      return ms ;
    }

    if(sourceUnit.equals("ms"))
    {
      return value ;
    }

    if(sourceUnit.equals("us"))
    {
      float ms = FloatUtil.divide(value, 1000) ;
      return ms ;
    }

    if(sourceUnit.equals("ns"))
    {
      float us = FloatUtil.divide(value, 1000) ;
      return convertInMs(us, "us") ;
    }

    if(sourceUnit.equals("ps"))
    {
      float ns = FloatUtil.divide(value, 1000) ;
      return convertInMs(ns, "ns") ;
    }

    return value ;
  }
}