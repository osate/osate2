package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FlowSpecification;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class RefineFlowSpecificationCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final FlowSpecification fs,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);
		if(!(parent instanceof ComponentType)) {
			return false;
		}

		return fs.getContainingClassifier() != parent;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final FlowSpecification fs,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstBusinessObject(parentQuery, boc);
	}
	
	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final FlowSpecification fs,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final ComponentType ct = (ComponentType)queryService.getFirstBusinessObject(parentQuery, boc);

		// Refine the flow specification
		final FlowSpecification newFs = ct.createOwnedFlowSpecification();
		newFs.setKind(fs.getKind());
		newFs.setRefined(fs);

		return true;
	}
}
