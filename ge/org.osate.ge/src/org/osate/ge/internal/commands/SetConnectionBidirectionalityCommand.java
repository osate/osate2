package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ParameterConnection;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.ModifiesBusinessObjects;

@ModifiesBusinessObjects
public class SetConnectionBidirectionalityCommand {
	final boolean bidirectionalValue;
	public SetConnectionBidirectionalityCommand(boolean bidirectionalValue) {
		this.bidirectionalValue = bidirectionalValue;
	}

	@GetLabel
	public String getLabel() {
		return bidirectionalValue ? "Change to Bidirectional" : "Change to Unidirectional";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		final ComponentImplementation ci = connection.getSource().getContainingComponentImpl();

		return connection.isBidirectional() != bidirectionalValue &&
				connection.getRefined() == null &&
				ci != null &&
				connection.getContainingClassifier() == ci;
	}

	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		if(connection instanceof ParameterConnection) {
			return false;
		}

		return true;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Connection connection) {
		connection.setBidirectional(bidirectionalValue);
		return true;
	}
}
