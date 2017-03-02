package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.ModifiesBusinessObjects;
import org.osate.ge.internal.util.AadlConnectionUtil;

@ModifiesBusinessObjects
public class RefineConnectionCommand {

	@GetLabel
	public String getLabel() {
		return "Refine";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		// Check that the shape represents a subcomponent and that the subcomponent is not owned by the classifier represented by the shape's container
		final ComponentImplementation ci = connection.getSource().getContainingComponentImpl();
		return ci != null && connection.getContainingClassifier() != ci && ci.getAllConnections().contains(connection);
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		final ComponentImplementation containerComponentImplementation = connection.getSource().getContainingComponentImpl();

		// Set the classifier
		final org.osate.aadl2.Connection newAadlConnection = AadlConnectionUtil.createConnection(containerComponentImplementation, connection.eClass());
		if(newAadlConnection != null) {
			newAadlConnection.setRefined(connection);
		}

		return true;
	}
}
