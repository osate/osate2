package org.osate.xtext.aadl2.ui.highlighting;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexHighlighter;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor;
import org.osate.annexsupport.AnnexHighlighterRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexSource;

public class Aadl2SemanticHighlightingCalculator implements ISemanticHighlightingCalculator {
	
	@Override
	public void provideHighlightingFor(XtextResource resource, final IHighlightedPositionAcceptor acceptor) {
		final AnnexHighlighterRegistry registry = (AnnexHighlighterRegistry)AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_HIGHLIGHTER_EXT_ID);
		
		for(EObject obj : resource.getContents()) {
			for(AnnexSubclause subclause : EcoreUtil2.eAllOfType(obj, AnnexSubclause.class)) {				
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(subclause, acceptor);
				
				if(annexAcceptor != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(subclause.getName());
					if(highlighter != null)	{
						highlighter.highlightAnnexSubclause(subclause, annexAcceptor);
					}
				}
			}
			
			for(AnnexLibrary library : EcoreUtil2.eAllOfType(obj, AnnexLibrary.class)) {
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(library, acceptor);
				if(library != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(library.getName());
					if(highlighter != null)	{
						highlighter.highlightAnnexLibrary(library, annexAcceptor);
					}
				}
			}
		}
	}
	
	/**
	 * Creates an AnnexHighlighterPositionAcceptor specific to a annex source block 
	 * @param semanticObj the AnnexLibrary or AnnexSubclause to build the acceptor for
	 * @param acceptor the xtext Acceptor that is wraps
	 * @return the new AnnexHighlighterPositionAcceptor or null if one could not be created
	 */
	private AnnexHighlighterPositionAcceptor createAcceptor(EObject semanticObj, final IHighlightedPositionAcceptor acceptor) {
		final AnnexSource annexSource = getAnnexSource(semanticObj);
		
		if(annexSource == null) {
			throw new RuntimeException("Unable to find AnnexSource for object: " + semanticObj);
		}
		
		return new AnnexHighlighterPositionAcceptor() {
			@Override
			public void addPosition(int offset, int length, String... id) {
				if(offset < 0) {
					throw new RuntimeException("Offset is less than 0");
				}
				
				if(offset > annexSource.getSourceText().length()) {
					throw new RuntimeException("Offset is greater than source text length");
				}
				
				// Calculate the absolute offset
				int absOffset = annexSource.getSourceTextOffset() + offset;
				acceptor.addPosition(absOffset, length, id);
			}
		};
	}
	
	private AnnexSource getAnnexSource(EObject obj)	{
		// Find the Annex source information
		for(Adapter adapter : obj.eAdapters()) {
			if(adapter instanceof AnnexSource) {
				return (AnnexSource)adapter;
			}
		}
		
		return null;
	}

}
