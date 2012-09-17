package fr.tpt.aadl.annex.behavior.texteditor;

import org.osate.aadl2.Element ;

import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public interface AadlBaHyperlink
{

  public void addToHyperlinking (AadlBaLocationReference location, Element element) ;

}
