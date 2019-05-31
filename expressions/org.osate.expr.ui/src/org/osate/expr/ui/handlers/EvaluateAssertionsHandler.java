package org.osate.expr.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class EvaluateAssertionsHandler extends AbstractHandler {
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		/*
		 * This handler's enablement in the plugin.xml file ensures that it is only executed with a selection of exactly
		 * one and that the selection is either an IFile containing a SystemInstance or an EObjectURIWrapper pointing
		 * to a ComponentInstance.
		 */
		Object selection = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		ResourceSet resourceSet = new ResourceSetImpl();
		final ComponentInstance component;
		if (selection instanceof IFile) {
			IFile file = (IFile) selection;
			URI uri = OsateResourceUtil.toResourceURI(file);
			component = (ComponentInstance) resourceSet.getResource(uri, true).getContents().get(0);
		} else if (selection instanceof EObjectURIWrapper) {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) selection;
			component = (ComponentInstance) resourceSet.getEObject(wrapper.getUri(), true);
		} else {
			throw new ExecutionException("Unexpected selection: " + selection);
		}
		System.out.println("Execute Assertions: " + component);
		return null;
	}
}