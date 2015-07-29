package org.osate.ge.services.impl;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.osate.ge.services.UiService;
import org.osate.ge.ui.editor.AgeDiagramBehavior;

public class DefaultUiService implements UiService {
	private IDiagramTypeProvider dtp;
	
	public DefaultUiService(final IDiagramTypeProvider dtp) {
		this.dtp = dtp;
	}
	
	@Override
	public void deactivateActiveTool() {
		if(!(dtp.getDiagramBehavior() instanceof AgeDiagramBehavior)) {
			throw new RuntimeException("Diagram behavior is not of type AgeDiagramBehavior");
		}
		
		final AgeDiagramBehavior diagramBehavior = (AgeDiagramBehavior)dtp.getDiagramBehavior();
		diagramBehavior.deactivateActiveTool();
	}

}
