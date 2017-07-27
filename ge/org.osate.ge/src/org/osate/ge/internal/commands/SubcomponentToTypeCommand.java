package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.Subcomponent;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.DiagramService;

public class SubcomponentToTypeCommand {
	@GetLabel
	public String getLabel() {
		return "Go to Type Diagram";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Subcomponent subcomponent) {
		return subcomponent.getComponentType() != null;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Subcomponent subcomponent,
			final DiagramService diagramService) {
		return diagramService.openOrCreateDiagramForBusinessObject(subcomponent.getComponentType()) != null;
	}
}
