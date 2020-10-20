package org.osate.asap.view.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.errormodel.faulttree.util.SiriusUtil;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.asap.view.AsapUtil;
import org.osate.ui.dialogs.Dialog;

public class ContainmentHandler extends AbstractHandler {

	@SuppressWarnings("restriction")
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		SystemInstance systemInstance;
		InstanceObject object = AsapUtil.getTarget(HandlerUtil.getCurrentSelection(event), SystemInstance.class);
		if (object == null) {
			Dialog.showInfo("ASAP Containment Representation", "Please choose an instance model");
			return IStatus.ERROR;
		}

		systemInstance = object.getSystemInstance();

		// XXX SiriusUtil should be refactored out so we don't have to depend on the faulttree plugin
		SiriusUtil.INSTANCE.autoOpenModel(systemInstance, ResourceUtil.getFile(systemInstance.eResource()).getProject(),
				"viewpoint:/org.osate.asap.view/Hazard Analyst", "Containment", "ASAP: Containment Handler");

		return IStatus.OK;
	}
}
