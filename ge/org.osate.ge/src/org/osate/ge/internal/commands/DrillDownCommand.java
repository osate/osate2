package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.services.SubcomponentService;

public class DrillDownCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Open Associated Diagram";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy diagramElement,
			final SubcomponentService subcomponentService,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		return diagram != null && namedElement != diagram &&
				(namedElement instanceof ComponentType || namedElement instanceof ComponentImplementation || namedElement instanceof FeatureGroupType || namedElement instanceof Subcomponent);
	}
	
	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy diagramElement,
			final SubcomponentService subcomponentService) {
		if(namedElement instanceof Package || namedElement instanceof Classifier) {
			return true;
		}

		if(namedElement instanceof Subcomponent) {
			if(subcomponentService.getComponentClassifier(diagramElement, (Subcomponent)namedElement) != null) {
				return true;
			}
		}

		return false;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final NamedElement namedElement,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy diagramElement,
			final SubcomponentService subcomponentService,
			final DiagramService diagramService) {
		diagramService.openOrCreateDiagramForRootBusinessObject(namedElement instanceof Subcomponent ? 
				subcomponentService.getComponentClassifier(diagramElement, (Subcomponent)namedElement) : namedElement);

		return false;
	}
}
