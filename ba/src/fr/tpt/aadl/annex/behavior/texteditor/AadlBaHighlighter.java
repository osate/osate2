package fr.tpt.aadl.annex.behavior.texteditor;

import java.util.List ;

import org.osate.aadl2.AnnexLibrary ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.annexsupport.AnnexHighlighter ;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;

public class AadlBaHighlighter implements AnnexHighlighter {

    @Override
    public void highlightAnnexLibrary(AnnexLibrary library,
            AnnexHighlighterPositionAcceptor acceptor) {
        // TODO Auto-generated method stub
    }

    @Override
    public void highlightAnnexSubclause(AnnexSubclause subclause,
            AnnexHighlighterPositionAcceptor acceptor) {
        // TODO Auto-generated method stub

        if(subclause instanceof BehaviorAnnex)
        {
          // TODO : fetch BehaviorElementPosition list.
          
          List<BehaviorElementPosition> bepl = null ;
          
          for (BehaviorElementPosition bep : bepl)
          {
            bep.addPosition(acceptor) ;
          }
        }
    }
}