package org.osate.ge.internal.commands;
import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.ModifiesBusinessObjects;

@ModifiesBusinessObjects
public class SwitchDirectionOfConnectionCommand {

	@GetLabel
	public String getLabel() {
		return "Switch Direction";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		final ComponentImplementation ci = connection.getSource().getContainingComponentImpl();
		return ci != null && connection.getContainingClassifier() == ci && connection.getRefined() == null;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		final ConnectedElement ceSource = connection.getSource();
		connection.setSource(connection.getDestination());
		connection.setDestination(ceSource);

		return true;
	}
}
