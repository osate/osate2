package fr.tpt.aadl.annex.behavior.texteditor;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexHighlighter;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference;

public class AadlBaSemanticHighlighter implements AnnexHighlighter
{

	@Override
	public void highlightAnnexLibrary(AnnexLibrary library,
			AnnexHighlighterPositionAcceptor acceptor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void highlightAnnexSubclause(AnnexSubclause subclause,
			AnnexHighlighterPositionAcceptor acceptor) {
		XtextAadlBaHighlighter ht = (XtextAadlBaHighlighter) ((BehaviorAnnex)subclause).getHighlighters().get(subclause);
		for (AadlBaLocationReference location : ht.getElementsToHighlitght((BehaviorAnnex)subclause))
	    {
	       acceptor.addPosition(location.getSuperOffset(), location.getLength(),
	                            location.getId());
	    }
		
	}
}
