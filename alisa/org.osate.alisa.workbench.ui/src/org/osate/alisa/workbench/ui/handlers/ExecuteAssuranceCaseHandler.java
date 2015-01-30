package org.osate.alisa.workbench.ui.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.osate.alisa.workbench.alisa.AssuranceCaseConfiguration;
import org.osate.ui.dialogs.Dialog;

public class ExecuteAssuranceCaseHandler extends EditorObjectHandler {

	@Override
	protected IStatus runJob(EObject sel, IProgressMonitor monitor) {
		if (sel instanceof AssuranceCaseConfiguration) {
			AssuranceCaseConfiguration plan = (AssuranceCaseConfiguration) sel;
			try {
//				ac = InstantiateModel.buildInstanceModelFile(compImpl);
			} catch (Exception e) {
				Dialog.showError("Assurance case Generate",
						"Error while generating teh assurance case: " + e.getMessage());
				return Status.CANCEL_STATUS;
			}
		} else {
			Dialog.showError("Assurance case Generate", "You must select an Assurance Case Plan to generate");
			return Status.CANCEL_STATUS;
		}
		return Status.OK_STATUS;
	}

	@Override
	protected String getJobName() {
		return "Execute Assurance Case";
	}

}
