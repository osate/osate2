package fr.tpt.aadl.annex.behavior.texteditor;

import org.osate.aadl2.Element ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public class XtextAadlBaHyperlink implements AadlBaHyperlink // extends EObjectAtOffsetHelper ???
{

  BehaviorAnnex ba;
  public XtextAadlBaHyperlink(BehaviorAnnex ba)
  {
		this.ba=ba;
  }

@Override
  public void addToHyperlinking(AadlBaLocationReference location, Element element) {
    ba.getLinks().put(location, element) ;
  }

  
}
