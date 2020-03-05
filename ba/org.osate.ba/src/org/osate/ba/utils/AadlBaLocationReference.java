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

import org.osate.aadl2.parsesupport.LocationReference;

public class AadlBaLocationReference extends LocationReference
{
  
  private int _annexOffset = 0;
  private int _column = -1 ;
  
  private String _id = "" ;
  
  public AadlBaLocationReference()
  {
    // fields are not set.
  }

  public AadlBaLocationReference(int annex, String fileName, int lineNumber)
  {
    super(fileName, lineNumber) ;
    _annexOffset = annex;
  }
  
  public AadlBaLocationReference(int annex, String fileName, int lineNumber, int offset,
                                  int length, int column, String id)
  {
    super(fileName, lineNumber) ;
    super.setOffset(offset) ;
    super.setLength(length) ;
    _annexOffset=annex;
    _column = column ;
    _id = id ;
  }
  
  // LocationReference's fields are not set.
  public AadlBaLocationReference(int annex, int offset,int length, int column, String id)
  {
    super() ;
    super.setOffset(offset) ;
    super.setLength(length) ;
    _annexOffset = annex;
    _column = column ;
    _id = id ;
  }

  public int getColumn()
  {
    return _column ;
  }
  
  public String getId()
  {
    return _id ;
  }
  
  public int getAbsoluteOffset()
  {
	  return (_annexOffset + super.getOffset()) ;
  }
  
  public int getRelativeOffset()
  {
    return super.getOffset() ;
  }
  
  @Override
  public int getOffset() 
  {
	  return this.getAbsoluteOffset() ;
  };
  
  public int getAnnexOffset()
  {
    return _annexOffset ;
  }
  
  @Override
  public AadlBaLocationReference clone()
  {
    
    
    AadlBaLocationReference clone = new 
                                  AadlBaLocationReference(this._annexOffset,
                                		  				  this.getFilename(),
                                                          this.getLine(),
                                                          this.getOffset(),
                                                          this.getLength(),
                                                          this.getColumn(),
                                                          this.getId()) ;
                                                               
    return clone ;
  }
  
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    
    sb.append("line: ") ;
    sb.append(this.getLine()) ;
    sb.append(", column:") ;
    sb.append(this.getColumn()) ;
    sb.append(", offset:") ;
    sb.append(this.getOffset()) ;
    
    return sb.toString() ;
  }
}
