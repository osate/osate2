package fr.tpt.aadl.annex.behavior.utils;

import org.osate.aadl2.parsesupport.LocationReference ;

import fr.tpt.aadl.annex.behavior.AadlBaParserAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;

public class AadlBaLocationReference extends LocationReference
{
  
  private BehaviorAnnex _ba = null;
  private int _column = -1 ;
  
  private String _id = "" ;

  public AadlBaLocationReference()
  {
    // fields are not set.
  }

  public AadlBaLocationReference(BehaviorAnnex annex, String fileName, int lineNumber)
  {
    super(fileName, lineNumber) ;
    _ba = annex;
  }
  
  public AadlBaLocationReference(BehaviorAnnex annex, String fileName, int lineNumber, int offset,
                                  int length, int column, String id)
  {
    super(fileName, lineNumber) ;
    super.setOffset(offset) ;
    super.setLength(length) ;
    _ba=annex;
    _column = column ;
    _id = id ;
  }
  
  // LocationReference's fields are not set.
  public AadlBaLocationReference(BehaviorAnnex annex, int offset,int length, int column, String id)
  {
    super() ;
    super.setOffset(offset) ;
    super.setLength(length) ;
    _ba = annex;
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

  @Override
  public int getOffset() 
  {
	return AadlBaParserAction.offsetMap.get(_ba)+super.getOffset();
  };
  
  @Override
  public AadlBaLocationReference clone()
  {
    
    
    AadlBaLocationReference clone = new 
                                  AadlBaLocationReference(this._ba,
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
