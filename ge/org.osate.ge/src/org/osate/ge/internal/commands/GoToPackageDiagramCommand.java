package org.osate.ge.internal.commands;
import javax.inject.Named;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.DiagramService;

public class GoToPackageDiagramCommand {
	@GetLabel
	public String getLabel() {
		return "Go to Package Diagram";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement) {
		if(namedElement instanceof AadlPackage) {
			return false;
		}

		final Element element = getElement(namedElement);		
		return element != null && element.getElementRoot() instanceof AadlPackage;
	}

	private Element getElement(Object bo) {
		if(bo instanceof EmfContainerProvider) {
			bo = ((EmfContainerProvider) bo).getEmfContainer();
		}

		return bo instanceof Element ? (Element)bo : null;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement,
			final DiagramService diagramService) {
		final Element element = getElement(namedElement);		
		diagramService.openOrCreateDiagramForBusinessObject(element.getElementRoot());
		return true;
	}
}
