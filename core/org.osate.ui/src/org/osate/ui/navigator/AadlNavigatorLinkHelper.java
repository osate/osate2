package org.osate.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.ui.editor.ContributedAadlEditorInput;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlNavigatorLinkHelper implements ILinkHelper {
	private final IURIEditorOpener editorOpener = IResourceServiceProvider.Registry.INSTANCE
			.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(IURIEditorOpener.class);

	@Override
	public IStructuredSelection findSelection(IEditorInput anInput) {
		if (anInput instanceof ContributedAadlEditorInput) {
			try {
				return new StructuredSelection(((ContributedAadlEditorInput) anInput).getStorage());
			} catch (CoreException e) {
				return StructuredSelection.EMPTY;
			}
		} else {
			IFile file = ResourceUtil.getFile(anInput);
			if (file != null) {
				return new StructuredSelection(file);
			} else {
				return StructuredSelection.EMPTY;
			}
		}
	}

	@Override
	public void activateEditor(IWorkbenchPage page, IStructuredSelection structuredSelection) {
		if (structuredSelection == null || structuredSelection.isEmpty()) {
			return;
		}
		Object selected = structuredSelection.getFirstElement();
		if (selected instanceof IFile) {
			IEditorPart editor = page.findEditor(new FileEditorInput((IFile) selected));
			if (editor != null) {
				page.bringToTop(editor);
			}
		} else if (selected instanceof ContributedAadlStorage) {
			ContributedAadlStorage storage = (ContributedAadlStorage) selected;
			IEditorPart editor = page.findEditor(new ContributedAadlEditorInput(storage));
			if (editor != null) {
				page.bringToTop(editor);
			}
		} else if (selected instanceof EObjectURIWrapper) {
			EObjectURIWrapper navigatorNode = (EObjectURIWrapper) selected;
			URI resourceURI = navigatorNode.getUri().trimFragment();
			IEditorPart editor = null;
			if (resourceURI.isPlatformResource()) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IFile file = root.getFile(new Path(null, resourceURI.toPlatformString(true)));
				editor = page.findEditor(new FileEditorInput(file));
			} else if (resourceURI.isPlatformPlugin()) {
				ContributedAadlStorage storage = new ContributedAadlStorage(null, resourceURI);
				editor = page.findEditor(new ContributedAadlEditorInput(storage));
			}
			if (editor != null) {
				page.bringToTop(editor);
				if (editor instanceof XtextEditor) {
					editorOpener.open(navigatorNode.getUri(), true);
				} else {
					IGotoMarker gotoMarkerAdapter = Adapters.adapt(editor, IGotoMarker.class);
					if (gotoMarkerAdapter != null) {
						try {
							IMarker marker = ResourcesPlugin.getWorkspace().getRoot().createMarker(IMarker.MARKER);
							marker.setAttribute("uri", navigatorNode.getUri().toString());
							gotoMarkerAdapter.gotoMarker(marker);
							marker.delete();
						} catch (CoreException e) {
							OsateCorePlugin.log(e);
						}
					}
				}
			}
		}
	}
}