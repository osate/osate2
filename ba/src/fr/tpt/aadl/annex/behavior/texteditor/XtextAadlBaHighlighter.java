package fr.tpt.aadl.annex.behavior.texteditor;

import java.util.ArrayList ;
import java.util.List ;

import org.antlr.runtime.Token;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;

import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference ;

public class XtextAadlBaHighlighter implements AadlBaHighlighter
{
  private AnnexHighlighterPositionAcceptor _acceptor ;
  
  public XtextAadlBaHighlighter(AnnexHighlighterPositionAcceptor acceptor)
  {
    _acceptor = acceptor ;
  }
  
  private List<AadlBaLocationReference> _elementToHighlight =
        new ArrayList<AadlBaLocationReference>() ;
  
  @Override
  public void addToHighlighting(Token token, String id)
  {
    int offset = token.getTokenIndex() ;
    int length = token.getText().length() ;
    int column = token.getCharPositionInLine() ;
    
    // DEBUG
    System.out.println("token : " + token.getText() + ", offset : " + offset + ", char length : " + length);
    
    _elementToHighlight.add(new AadlBaLocationReference(offset, length, column,
                                                        id));                     
  }
  
  @Override
  public void highlightNow()
  {
    for (AadlBaLocationReference location : _elementToHighlight)
    {
      _acceptor.addPosition(location.getOffset(), location.getLength(),
                            location.getId());
    }
  }
}
