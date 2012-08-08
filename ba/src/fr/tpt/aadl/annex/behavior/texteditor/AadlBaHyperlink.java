package fr.tpt.aadl.annex.behavior.texteditor;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public interface AadlBaHyperlink
{

  public void addToHyperlinking (AadlBaLocationReference location, BehaviorElement element) ;

}
