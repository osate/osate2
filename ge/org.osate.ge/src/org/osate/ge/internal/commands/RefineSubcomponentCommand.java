package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;
import org.osate.ge.internal.util.SubcomponentUtil;

@ModifiesBusinessObjects
public class RefineSubcomponentCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		if(diagram instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)diagram;
			return sc.getContainingClassifier() != ci && SubcomponentUtil.canContainSubcomponentType(ci, sc.eClass());
		}

		return false;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		final ComponentImplementation ci = (ComponentImplementation)queryService.getFirstBusinessObject(parentQuery, diagramElement);
		// Refine the subcomponent
		final Subcomponent newSc = SubcomponentUtil.createSubcomponent(ci, sc.eClass());
		newSc.setRefined(sc);
		return true;
	}
}
