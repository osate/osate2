package fr.tpt.aadl.annex.behavior.texteditor;

import java.util.ArrayList ;
import java.util.HashMap;
import java.util.List ;
import java.util.Map;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;

import fr.tpt.aadl.annex.behavior.AadlBaParserAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference ;

public class XtextAadlBaHighlighter implements AadlBaHighlighter
{
  
  private List<AadlBaLocationReference> _elementToHighlight =
        new ArrayList<AadlBaLocationReference>() ;
  
  @Override
  public void addToHighlighting(int annexOffset, Token token, String id)
  {
    int offset = ((CommonToken)token).getStartIndex();
    int length = token.getText().length() ;
    int column = token.getCharPositionInLine() ;
    
    // DEBUG
    System.out.println("token : " + token.getText() + ", offset : " + offset + ", char length : " + length);
    
    _elementToHighlight.add(new AadlBaLocationReference(annexOffset, offset, length, column,
                                                        id));
  }
  
  public List<AadlBaLocationReference> getElementsToHighlitght(BehaviorAnnex annex)
  {
	  return _elementToHighlight;
  }

  @Override
  public void addToHighlighting(int annexOffset, int relativeOffset, int length, String id) {
	_elementToHighlight.add(new AadlBaLocationReference(annexOffset, relativeOffset, length, 0,
              id));
  }
  
}
