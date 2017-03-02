package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElementProxy;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;

@ModifiesBusinessObjects
public class RefineFlowSpecificationCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final FlowSpecification fs,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		if(!(diagram instanceof ComponentType)) {
			return false;
		}

		return fs.getContainingClassifier() != diagram;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final FlowSpecification fs,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElementProxy diagramElement,
			final QueryService queryService) {
		final ComponentType ct = (ComponentType)queryService.getFirstBusinessObject(parentQuery, diagramElement);

		// Refine the flow specification
		final FlowSpecification newFs = ct.createOwnedFlowSpecification();
		newFs.setKind(fs.getKind());
		newFs.setRefined(fs);

		return true;
	}
}
