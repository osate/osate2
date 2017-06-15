package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.osate.aadl2.Classifier;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.util.EditorUtil;

public class CreateNewDiagramCommand {
	@GetLabel
	public String getLabel() {
		return "Create New Diagram";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Object bo) {
		return bo instanceof Classifier;
	}

	@Activate
	public void activate(@Named(Names.BUSINESS_OBJECT) final Object bo,
			final DiagramService diagramService) {
		final IFile file = diagramService.createDiagram(bo);
		if(file != null) {
			EditorUtil.openEditor(file, true);
		}
	}
}
