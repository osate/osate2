package org.osate.ge.ba.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

class OsateEmbeddedXtextAdapter extends OsateStyledTextXtextAdapter {
	private static final IXtextFakeContextResourcesProvider contextFakeResourceProvider = IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER;

	public OsateEmbeddedXtextAdapter(final IProject project) {
		super(BehaviorTransitionPropertySection.injector, contextFakeResourceProvider, project);
	}

	public SourceViewer getSourceviewer() {
		return super.getXtextSourceviewer();
	}

	@Override
	public XtextDocument getXtextDocument() {
		return super.getXtextDocument();
	}

	public String getText() {
		return getFakeResource().getParseResult().getRootNode().getText();
	}

	public XtextResource getFakeResource() {
		return getFakeResourceContext().getFakeResource();
	}

	public String serialize(final EObject rootElement) {
		return getFakeResource().getSerializer().serialize(rootElement);
	}
}
