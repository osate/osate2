package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
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
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement) {
		return namedElement instanceof ComponentImplementation && ((ComponentImplementation)namedElement).getType() != null;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement,
			final DiagramService diagramService) {
		final Classifier componentType = ((ComponentImplementation)namedElement).getType();
		diagramService.openOrCreateDiagramForRootBusinessObject(componentType);
		return true;
	}
}
