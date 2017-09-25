package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;
import org.osate.ge.internal.util.AadlConnectionUtil;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

public class RefineConnectionCommand {
	private static final StandaloneQuery parentQuery = StandaloneQuery.create((root) -> root.ancestor(1));

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Connection connection,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		final Object parent = queryService.getFirstBusinessObject(parentQuery, boc);
		if(parent instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)parent;
			return connection.getContainingClassifier() != ci;
		}

		return false;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Connection connection,
			@Named(Names.BUSINESS_OBJECT_CONTEXT) final BusinessObjectContext boc,
			final QueryService queryService) {
		return queryService.getFirstBusinessObject(parentQuery, boc);
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Connection connection,
			@Named(Names.MODIFY_BO) final ComponentImplementation containerComponentImplementation) {
		// Set the classifier
		final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil.createConnection(containerComponentImplementation, connection.eClass());
		if(newAadlConnection != null) {
			newAadlConnection.setRefined(connection);
		}

		return true;
	}
}
