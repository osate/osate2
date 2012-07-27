package fr.tpt.aadl.annex.behavior.texteditor;

import java.util.HashMap ;
import java.util.Map ;

import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder ;

public class XtextAadlBaHyperlink implements AadlBaHyperlink // extends EObjectAtOffsetHelper ???
{
  Map<Integer, ElementHolder> _links = new HashMap
        <Integer, ElementHolder>() ;
  
  @Override
  public void addToHyperlinking(ElementHolder holder)
  {
    int offset = holder.getAadlBaLocationReference().getOffset() ;
    _links.put(offset, holder) ;
  }

  @Override
  public ElementHolder getLinkedElement(int offset)
  {
    return _links.get(offset) ;
  }
}
