package fr.tpt.aadl.annex.behavior.texteditor;

import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder ;

public interface AadlBaHyperlink
{
  public void addToHyperlinking (ElementHolder holder) ;

  public ElementHolder getLinkedElement(int offset) ; 
}
