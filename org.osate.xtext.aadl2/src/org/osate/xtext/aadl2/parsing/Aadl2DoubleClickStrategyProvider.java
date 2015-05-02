package org.osate.xtext.aadl2.parsing;

import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.doubleClicking.FixedCharCountPartitionDoubleClickSelector;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;

import com.google.inject.Inject;

// configures in thee strategy that handles clicking within ANNEXTEXT
public class Aadl2DoubleClickStrategyProvider extends DoubleClickStrategyProvider {

	@Inject
	private Aadl2TokenStrategy myDefaultDoubleClickStrategy;

	@Override
	public ITextDoubleClickStrategy getStrategy(ISourceViewer sourceViewer, String contentType,
			String documentPartitioning) {
		if (TerminalsTokenTypeToPartitionMapper.COMMENT_PARTITION.equals(contentType)) {
			return new FixedCharCountPartitionDoubleClickSelector(documentPartitioning, 0, 0);
		}
		if (TerminalsTokenTypeToPartitionMapper.SL_COMMENT_PARTITION.equals(contentType)) {
			return new FixedCharCountPartitionDoubleClickSelector(documentPartitioning, 0, 0);
		}
		if (TerminalsTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION.equals(contentType)) {
			return new FixedCharCountPartitionDoubleClickSelector(documentPartitioning, 1, 1);
		}
		return myDefaultDoubleClickStrategy;
	}

}
