package org.osate.mylyn.aadl.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.mylyn.context.core.IInteractionElement;
import org.eclipse.mylyn.context.ui.AbstractContextUiBridge;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.UiUtil;
import org.osate.xtext.aadl2.ui.outline.Aadl2OutlinePage;

public final class AadlUiBridge extends AbstractContextUiBridge {
	private static final String AADL_EXTENSION = "AADL";
	private final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();

	public AadlUiBridge() {
		super();
	}

	private static IWorkbenchPage getPage() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	}

	private Element getElementFromHandle(final String handle) {
		try {
			return (Element) resourceSet.getEObject(URI.createURI(handle), true);
		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public void open(final IInteractionElement element) {
		UiUtil.getInstance().openDeclarativeModelElementAsJob(getPage(),
				getElementFromHandle(element.getHandleIdentifier()));
	}

	@Override
	public void close(final IInteractionElement element) {
		System.out.println("CLOSE " + element.getHandleIdentifier());
	}

	@Override
	public boolean acceptsEditor(final IEditorPart editorPart) {
		if (editorPart instanceof XtextEditor) {
			final IEditorInput editorInput = editorPart.getEditorInput();
			if (editorInput instanceof FileEditorInput) {
				final IFile file = ((FileEditorInput) editorInput).getFile();
				return file.getFileExtension().toUpperCase().equals(AADL_EXTENSION);
			}
		}
		return false;
	}

	@Override
	public IInteractionElement getElement(final IEditorInput input) {
		return null;
	}

	@Override
	public List<TreeViewer> getContentOutlineViewers(final IEditorPart editorPart) {
		final List<TreeViewer> viewers = new ArrayList<>();
		final Object out = editorPart.getAdapter(IContentOutlinePage.class);
		if (out instanceof Aadl2OutlinePage) {
			final Aadl2OutlinePage aadl2Out = (Aadl2OutlinePage) out;
			viewers.add(aadl2Out.getTreeViewer());
		}
		return viewers;
	}

	@Override
	public Object getObjectForTextSelection(final TextSelection selection, final IEditorPart editor) {
		return null;
	}

	@Override
	public String getContentType() {
		return AadlStructureBridge.CONTENT_TYPE;
	}

}
