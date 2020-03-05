/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2013 TELECOM ParisTech and CNRS
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

package org.osate.ba.utils;

import org.osate.aadl2.Element ;

/**
 * Represents an exception raised when out of array dimension accessing.
 */
public class DimensionException extends Exception
{
   /**
    * 
    */
   private static final long serialVersionUID = -7962508017913234922L ;
   
   public Element _element ;
   
   public boolean _isWarning = false ;
   
   public DimensionException(Element element, String message,
                              boolean isWarning)
   {
      super(message) ;
      _element = element ;
      _isWarning = isWarning ;
   }
   
   public boolean isWarning()
   {
     return _isWarning ;
   }
}
