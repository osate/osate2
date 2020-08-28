package org.osate.modelstats.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.modelstats.ComponentCounter;
import org.osate.modelstats.ElementsCounts;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;

public class CountComponentsHandler extends AaxlReadOnlyHandlerAsJob {
	private String fileName;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
		IFile file = (IFile) selection.getFirstElement();
		fileName = file.getName();
		return null;
	}

	@Override
	protected String getActionName() {
		return "Model Elements Counter";
	}

	@Override
	protected void doAaxlAction(IProgressMonitor monitor, Element root) {
		SystemInstance si = (SystemInstance) root;
		ElementsCounts elementCounts = ComponentCounter.countComponents(si);

		CountComponentsUI dialog = new CountComponentsUI(getShell(), fileName, getActionName(), elementCounts); // creates the dialog object
		getShell().getDisplay().asyncExec(() -> dialog.open()); // opens the dialog
	}
}
