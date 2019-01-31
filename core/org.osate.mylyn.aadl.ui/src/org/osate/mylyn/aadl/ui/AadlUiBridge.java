package org.osate.mylyn.aadl.ui;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.mylyn.context.core.IInteractionElement;
import org.eclipse.mylyn.context.ui.AbstractContextUiBridge;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

public final class AadlUiBridge extends AbstractContextUiBridge {

	public AadlUiBridge() {
		super();
	}

	@Override
	public void open(final IInteractionElement element) {
		System.out.println("OPEN " + element.getHandleIdentifier());
	}

	@Override
	public void close(final IInteractionElement element) {
		System.out.println("CLOSE " + element.getHandleIdentifier());
	}

	@Override
	public boolean acceptsEditor(final IEditorPart editorPart) {
		return false;
	}

	@Override
	public IInteractionElement getElement(final IEditorInput input) {
		return null;
	}

	@Override
	public List<TreeViewer> getContentOutlineViewers(final IEditorPart editorPart) {
		return Collections.emptyList();
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
