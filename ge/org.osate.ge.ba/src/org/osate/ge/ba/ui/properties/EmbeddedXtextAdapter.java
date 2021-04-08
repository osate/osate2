package org.osate.ge.ba.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

class EmbeddedXtextAdapter extends OsateStyledTextXtextAdapter {
	private final EmbeddedTextValue textValue;
	private static final IXtextFakeContextResourcesProvider contextFakeResourceProvider = IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER;
	final static Injector injector = Aadl2Activator.getInstance()
			.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);

	EmbeddedXtextAdapter(final IProject project, final EmbeddedTextValue textValue) {
		super(injector, contextFakeResourceProvider, project);
		this.textValue = textValue;
	}

	SourceViewer getSourceviewer() {
		return super.getXtextSourceviewer();
	}

	@Override
	public XtextDocument getXtextDocument() {
		return super.getXtextDocument();
	}

	String getText() {
		return getFakeResource().getParseResult().getRootNode().getText();
	}

	XtextResource getFakeResource() {
		return getFakeResourceContext().getFakeResource();
	}

	String serialize(final EObject rootElement) {
		return getFakeResource().getSerializer().serialize(rootElement);
	}

	@Override
	public void adapt(final StyledText styledText, final boolean decorate) {
		super.adapt(styledText, decorate);
		final XtextDocument xtextDoc = getXtextDocument();
		final SourceViewer srcViewer = getSourceviewer();
		xtextDoc.set(textValue.getWholeText());
		srcViewer.setDocument(xtextDoc, srcViewer.getAnnotationModel(), textValue.getEditableTextOffset(),
				textValue.getEditableText().length());
	}

	@Override
	public void adapt(final StyledText styledText) {
		adapt(styledText, true);
	}

	String getEditableText() {
		return textValue.getEditableText();
	}
}
