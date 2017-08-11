package org.osate.ge.internal.services.impl;

import java.util.Objects;

import org.eclipse.jface.action.IAction;
import org.osate.ge.internal.services.EditorProvider;
import org.osate.ge.internal.services.UiService;

public class DefaultUiService implements UiService {
	private final EditorProvider editorProvider;
	
	public DefaultUiService(final EditorProvider editorProvider) {
		this.editorProvider = Objects.requireNonNull(editorProvider, "editorProvider must not be null");
	}
	
	@Override
	public IAction getActivateToolAction(final String toolId) {
		return editorProvider.getEditor().getActivateToolAction(toolId);
	}
	
	@Override
	public void deactivateActiveTool() {
		editorProvider.getEditor().deactivateActiveTool();
	}
	
	@Override
	public void clearSelection() {
		editorProvider.getEditor().clearSelection();
	}
}
