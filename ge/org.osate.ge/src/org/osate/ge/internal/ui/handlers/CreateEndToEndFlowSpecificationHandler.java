package org.osate.ge.internal.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ge.internal.ui.tools.CreateEndToEndFlowSpecificationTool;

public class CreateEndToEndFlowSpecificationHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		AgeHandlerUtil.activateTool(event, new CreateEndToEndFlowSpecificationTool());
		return null;
	}
}
