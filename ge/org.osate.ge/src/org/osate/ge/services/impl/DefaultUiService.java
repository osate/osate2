package org.osate.ge.services.impl;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.jface.action.IAction;
import org.osate.ge.services.UiService;
import org.osate.ge.ui.editor.AgeDiagramBehavior;

public class DefaultUiService implements UiService {
	private IDiagramTypeProvider dtp;
	
	public DefaultUiService(final IDiagramTypeProvider dtp) {
		this.dtp = dtp;
	}
	
	@Override
	public IAction getActivateToolAction(final String toolId) {
		return getAgeDiagramBehavior().getActivateToolAction(toolId);
	}
	
	@Override
	public void deactivateActiveTool() {
		getAgeDiagramBehavior().deactivateActiveTool();
	}
	
	private AgeDiagramBehavior getAgeDiagramBehavior() {
		if(!(dtp.getDiagramBehavior() instanceof AgeDiagramBehavior)) {
			throw new RuntimeException("Diagram behavior is not of type AgeDiagramBehavior");
		}
		
		final AgeDiagramBehavior diagramBehavior = (AgeDiagramBehavior)dtp.getDiagramBehavior();
		return diagramBehavior;
	}

}
