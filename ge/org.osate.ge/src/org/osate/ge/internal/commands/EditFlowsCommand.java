package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowImplementation;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.EditFlowsDialog;

public class EditFlowsCommand {

	@GetLabel
	public String getLabel() {
		return "Edit Flows...";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ComponentImplementation compImpl) {
		return true;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Object bo) {
		return bo;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ComponentImplementation compImpl,
			final NamingService namingService, final AadlModificationService aadlModService) {
		// Show the edit flows dialog
		final EditFlowsDialog dlg = new EditFlowsDialog(Display.getCurrent().getActiveShell(), namingService, compImpl);
		if(dlg.open() == Window.CANCEL) {
			return false;
		}

		// Clear existing flows
		compImpl.getOwnedEndToEndFlows().clear();
		compImpl.getOwnedFlowImplementations().clear();

		for(final Flow flow : dlg.getFlows()) {
			if(flow instanceof EndToEndFlow) {
				compImpl.getOwnedEndToEndFlows().add((EndToEndFlow)flow);
				compImpl.setNoFlows(false);
			} else if(flow instanceof FlowImplementation) {
				compImpl.getOwnedFlowImplementations().add((FlowImplementation)flow);
				compImpl.setNoFlows(false);
			}
		}

		return true;
	}
}
