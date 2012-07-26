package fr.tpt.aadl.annex.behavior.texteditor;

import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;

public class BehaviorElementPosition
{
  public int offset = -1 ;
  
  public int length = -1 ; 
  
  public String id ;
  
  public void addPosition(AnnexHighlighterPositionAcceptor acceptor)
  {
    acceptor.addPosition(offset, length, id) ;
  }
  
  public BehaviorElementPosition(int offset, String id, int length)
  {
    this.offset = offset ;
    this.id = id ;
    this.length = length ;
  }
}
