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

package org.osate.ba.texteditor;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;
import java.util.WeakHashMap ;

import org.antlr.v4.runtime.Token ;
import org.antlr.v4.runtime.CommonToken ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.ba.utils.AadlBaLocationReference ;


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
    
    _elementToHighlight.add(new AadlBaLocationReference(annexOffset, offset, length, column,
                                                        id));
  }
  
  public List<AadlBaLocationReference> getElementsToHighlitght()
  {
	  return _elementToHighlight;
  }

  @Override
  public void addToHighlighting(int annexOffset, int relativeOffset, int length, String id) {
	_elementToHighlight.add(new AadlBaLocationReference(annexOffset, relativeOffset, length, 0,
              id));
  }
  
  private XtextAadlBaHighlighter() {}

  private static Map<AnnexSubclause, XtextAadlBaHighlighter> _highlighterPerAnnex = 
      new WeakHashMap<AnnexSubclause, XtextAadlBaHighlighter>();
  
  public static XtextAadlBaHighlighter getHighlighter(AnnexSubclause as)
  {
    if(_highlighterPerAnnex.get(as)==null)
    {
      XtextAadlBaHighlighter ht = new XtextAadlBaHighlighter();
      _highlighterPerAnnex.put(as, ht);
    }
    return _highlighterPerAnnex.get(as) ;
  }

  public void cleanup()
  {
    _elementToHighlight.clear();
  }
  
}
