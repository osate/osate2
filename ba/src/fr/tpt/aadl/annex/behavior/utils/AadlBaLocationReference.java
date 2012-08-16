package fr.tpt.aadl.annex.behavior.utils;

import org.osate.aadl2.parsesupport.LocationReference;

public class AadlBaLocationReference extends LocationReference
{
  
  private int annexOffset = 0;
  private int _column = -1 ;
  
  private String _id = "" ;
  
  public AadlBaLocationReference()
  {
    // fields are not set.
  }

  public AadlBaLocationReference(int annex, String fileName, int lineNumber)
  {
    super(fileName, lineNumber) ;
    annexOffset = annex;
  }
  
  public AadlBaLocationReference(int annex, String fileName, int lineNumber, int offset,
                                  int length, int column, String id)
  {
    super(fileName, lineNumber) ;
    super.setOffset(offset) ;
    super.setLength(length) ;
    annexOffset=annex;
    _column = column ;
    _id = id ;
  }
  
  // LocationReference's fields are not set.
  public AadlBaLocationReference(int annex, int offset,int length, int column, String id)
  {
    super() ;
    super.setOffset(offset) ;
    super.setLength(length) ;
    annexOffset = annex;
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
  
  public int getSuperOffset()
  {
	  return super.getOffset();
  }
  
  @Override
  public int getOffset() 
  {
	return annexOffset+super.getOffset();
  };
  
  @Override
  public AadlBaLocationReference clone()
  {
    
    
    AadlBaLocationReference clone = new 
                                  AadlBaLocationReference(this.annexOffset,
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
