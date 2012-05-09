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

public class UnitConversion
{

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
