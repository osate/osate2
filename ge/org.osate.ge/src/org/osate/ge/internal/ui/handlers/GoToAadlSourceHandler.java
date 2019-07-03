package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class GoToAadlSourceHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final Object selectedBo = selectedBusinessObjectContexts.get(0).getBusinessObject();
			final EObject boEObj = getEObject(selectedBo);
			if (boEObj != null) {
				final URI uri = EcoreUtil.getURI(boEObj);
				if (uri != null && boEObj.eResource() instanceof XtextResource) {
					final XtextResource res = (XtextResource) boEObj.eResource();
					if (res.getResourceServiceProvider().get(GlobalURIEditorOpener.class) != null) {
						enabled = true;
					}
				}
			}
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected BOCs
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final Object selectedBo = selectedBusinessObjectContexts.get(0).getBusinessObject();
		final EObject boEObj = getEObject(selectedBo);
		if (boEObj == null) {
			throw new RuntimeException("Unsupported type: " + selectedBo);
		}

		final URI uri = Objects.requireNonNull(EcoreUtil.getURI(boEObj), "Unable to get URI for business object");
		if (!(boEObj.eResource() instanceof XtextResource)) {
			throw new RuntimeException("The resource of the loaded business object resource is not an XtextResource");
		}

		final XtextResource res = (XtextResource) boEObj.eResource();
		final GlobalURIEditorOpener opener = Objects.requireNonNull(
				(GlobalURIEditorOpener) res.getResourceServiceProvider().get(GlobalURIEditorOpener.class),
				"unable to get global URI Editor opener");
		opener.open(uri, true);
		return true;
	}

	private static EObject getEObject(final Object bo) {
		if (bo instanceof EObject) {
			return (EObject) bo;
		} else if (bo instanceof EmfContainerProvider) {
			return ((EmfContainerProvider) bo).getEmfContainer();
		} else {
			return null;
		}
	}
}
