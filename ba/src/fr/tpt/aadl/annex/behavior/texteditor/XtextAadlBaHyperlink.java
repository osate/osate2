package fr.tpt.aadl.annex.behavior.texteditor;

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
  public void addToHyperlinking(AadlBaLocationReference location, BehaviorElement element) {
    ba.getLinks().put(location, element) ;
  }

  
}
