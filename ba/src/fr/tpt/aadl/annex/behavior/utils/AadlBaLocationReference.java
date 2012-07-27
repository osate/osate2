package fr.tpt.aadl.annex.behavior.utils;

import org.osate.aadl2.parsesupport.LocationReference ;

public class AadlBaLocationReference extends LocationReference
{
  private int _offset = -1 ;
  
  private int _length = -1 ;
  
  private int _column = -1 ;
  
  private String _id = "" ;

  public AadlBaLocationReference()
  {
    // fields are not set.
  }

  public AadlBaLocationReference(String fileName, int lineNumber)
  {
    super(fileName, lineNumber) ;
  }
  
  public AadlBaLocationReference(String fileName, int lineNumber, int offset,
                                  int length, int column, String id)
  {
    super(fileName, lineNumber) ;
    _offset = offset ;
    _length = length ;
    _column = column ;
    _id = id ;
  }
  
  // LocationReference's fields are not set.
  public AadlBaLocationReference(int offset,int length, int column, String id)
  {
    super() ;
    _offset = offset ;
    _length = length ;
    _column = column ;
    _id = id ;
  }
  
  public int getOffset()
  {
    return _offset ;
  }

  public int getLength()
  {
    return _length ;
  }

  public int getColumn()
  {
    return _column ;
  }
  
  public String getId()
  {
    return _id ;
  }
}
