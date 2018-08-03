package org.osate.annexsupport;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;

public interface AnnexHighlighter {
	void highlightAnnexLibrary(AnnexLibrary library, AnnexHighlighterPositionAcceptor acceptor);

	void highlightAnnexSubclause(AnnexSubclause subclause, AnnexHighlighterPositionAcceptor acceptor);
}
