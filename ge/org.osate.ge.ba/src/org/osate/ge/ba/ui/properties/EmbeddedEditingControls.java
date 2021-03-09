package org.osate.ge.ba.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

class EmbeddedEditingControls {
	private final Label label;
	private StyledText styledText;
	private Button saveBtn;
	private OsateXtextAdatper xtextAdapter;

	public EmbeddedEditingControls(final Composite parent, final boolean isSingleSelection) {
		label = new Label(parent, SWT.NONE);
		styledText = new StyledText(parent, SWT.NONE);
	}

	public Label getLabel() {
		return label;
	}

	public void dispose() {

	}

	private static class OsateXtextAdatper extends OsateStyledTextXtextAdapter {
		private static final IXtextFakeContextResourcesProvider contextFakeResourceProvider = IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER;

		public OsateXtextAdatper(final IProject project) {
			super(BehaviorTransitionPropertySection.injector, contextFakeResourceProvider, project);
		}

		public SourceViewer getSourceviewer() {
			return super.getXtextSourceviewer();
		}

		@Override
		public XtextDocument getXtextDocument() {
			return super.getXtextDocument();
		}
	}
}
