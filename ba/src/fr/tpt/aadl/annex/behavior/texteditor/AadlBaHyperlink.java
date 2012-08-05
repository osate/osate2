package fr.tpt.aadl.annex.behavior.texteditor;

import org.osate.aadl2.Element;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public interface AadlBaHyperlink
{

  public void addToHyperlinking (AadlBaLocationReference location, BehaviorElement element) ;

  public Element getLinkedElement(int offset) ;

}
