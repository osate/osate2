package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.util.SubcomponentUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class RefineSubcomponentCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);
		if(parent instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)parent;
			return sc.getContainingClassifier() != ci && SubcomponentUtil.canContainSubcomponentType(ci, sc.eClass());
		}

		return false;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstBusinessObject(parentQuery, boc);
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Subcomponent sc,
			@Named(Names.MODIFY_BO) final ComponentImplementation ci) {
		// Refine the subcomponent
		final Subcomponent newSc = SubcomponentUtil.createSubcomponent(ci, sc.eClass());
		newSc.setRefined(sc);
		return true;
	}
}
