package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.DiagramElement;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.query.StandaloneDiagramElementQuery;
import org.osate.ge.internal.services.QueryService;

public class SetFeatureKindCommand {
	private static final StandaloneDiagramElementQuery parentQuery = StandaloneDiagramElementQuery.create((root) -> root.ancestor(1));
	private final AccessType accType;

	public SetFeatureKindCommand(final AccessType accType) {
		this.accType = accType;
	}

	@GetLabel
	public String getLabel() {
		return accType == AccessType.PROVIDES ? "Set Kind to Provides" : "Set Kind to Requires";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Access af,
			@Named(InternalNames.DIAGRAM_ELEMENT_PROXY) final DiagramElement diagramElement,
			final QueryService queryService) {
		final Object diagram = queryService.getFirstBusinessObject(parentQuery, diagramElement);
		final Classifier classifier = af.getContainingClassifier();
		return classifier == diagram && (classifier instanceof FeatureGroupType || classifier instanceof ComponentType);
	}

	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final Access af) {
		return accType != af.getKind();
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Access af) {
		af.setKind(accType);
		return true;
	}
}
