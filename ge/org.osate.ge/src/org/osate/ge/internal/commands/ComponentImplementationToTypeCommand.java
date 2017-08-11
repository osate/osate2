package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.DiagramService;

public class ComponentImplementationToTypeCommand {
	@GetLabel
	public String getLabel() {
		return "Go to Type Diagram";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ComponentImplementation componentImpl) {
		return componentImpl.getType() != null;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ComponentImplementation componentImpl,
			final DiagramService diagramService) {
		return diagramService.openOrCreateDiagramForBusinessObject(componentImpl.getType()) != null;
	}
}
