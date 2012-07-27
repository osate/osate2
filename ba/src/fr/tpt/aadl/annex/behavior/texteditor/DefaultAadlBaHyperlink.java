package fr.tpt.aadl.annex.behavior.texteditor;

import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder ;

public class DefaultAadlBaHyperlink implements AadlBaHyperlink
{
  @Override
  public void addToHyperlinking(ElementHolder holder)
  {
    // Does nothing.
  }

  @Override
  public ElementHolder getLinkedElement(int offset)
  {
    throw new UnsupportedOperationException() ;
  }
}
