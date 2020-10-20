package org.osate.asap.view.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.errormodel.faulttree.util.SiriusUtil;
import org.osate.asap.model.safe2.SystemOverview;
import org.osate.asap.view.AsapUtil;
import org.osate.ui.dialogs.Dialog;

public class FundamentalsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		SystemOverview systemOverview = AsapUtil.getTarget(HandlerUtil.getCurrentSelection(event),
				SystemOverview.class);

		if (systemOverview == null) {
			Dialog.showInfo("ASAP Fundamentals Representation", "Please choose a SAFE2 SystemOverview");
			return IStatus.ERROR;
		}

		// XXX SiriusUtil should be refactored out so we don't have to depend on the faulttree plugin
		SiriusUtil.INSTANCE.autoOpenModel(systemOverview, ResourceUtil.getFile(systemOverview.eResource()).getProject(),
				"viewpoint:/org.osate.asap.view/Hazard Analyst", "Fundamentals", "ASAP: Fundamentals Handler");

		return IStatus.OK;
	}
}
