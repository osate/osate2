/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.mylyn.aadl.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.mylyn.commons.core.StatusHandler;
import org.eclipse.mylyn.context.core.IInteractionElement;
import org.eclipse.mylyn.context.ui.AbstractContextUiBridge;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.Element;
import org.osate.ui.UiUtil;
import org.osate.xtext.aadl2.ui.outline.Aadl2OutlinePage;

public final class AadlUiBridge extends AbstractContextUiBridge {
	private static final String AADL_EXTENSION = "AADL";
	private final ResourceSet resourceSet = new ResourceSetImpl();

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
		try {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if (page != null) {
				List<IEditorReference> toClose = new ArrayList<IEditorReference>(4);
				for (IEditorReference reference : page.getEditorReferences()) {
					try {
						final IEditorInput editorInput = reference.getEditorInput();
						if (editorInput instanceof FileEditorInput) {
							final IFile file = ((FileEditorInput) editorInput).getFile();
							final Element input = ((IAdaptable) file).getAdapter(Element.class);
							if (input != null
									&& element.getHandleIdentifier().equals(EcoreUtil.getURI(input).toString())) {
								toClose.add(reference);
							}
						}
					} catch (PartInitException e) {
						// ignore
					}
				}
				if (toClose.size() > 0) {
					page.closeEditors(toClose.toArray(new IEditorReference[toClose.size()]), true);
				}
			}
		} catch (Throwable t) {
			StatusHandler
					.log(new Status(IStatus.ERROR, AadlBridgePlugin.ID_PLUGIN, "Could not auto close editor", t));
		}
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
		/*
		 * I'm not sure what this method is meant to do. I searched the mylyn source code, and as far as I can tell,
		 * this method is never even called. The Java and Resource bridges has non-trivial implementations of this, but
		 * I'm not sure what they are really doing. On the other hand, the Ant and PDE bridges just return null,
		 * so clearly that is a safe option. We do that here.
		 */
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
		/*
		 * This only ever called with selection being null, at least this is true as of March 2019. It is also
		 * true that it is safe to return null here, as that is what the Ant and PDE bridges do. I think
		 * it's supposed to take the current text selection and turn it into an object whose structural handle
		 * can be retrieved. When the selection is null it is supposed to return the object represented by the
		 * top-level of the editor.
		 *
		 * However, returning null causes the caller to get the structural handle of the IResource being
		 * edited by the given editor. Again, considering that this method is only ever called with null,
		 * there doesn't seem to be any reason to return anything but null. It won't make a big difference
		 * to the caller if the object is the resource or the package/property set contained in the resource.
		 */
		return null;
	}

	@Override
	public String getContentType() {
		return AadlStructureBridge.CONTENT_TYPE;
	}

}
