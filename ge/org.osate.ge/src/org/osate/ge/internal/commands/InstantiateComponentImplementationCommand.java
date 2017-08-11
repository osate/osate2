package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;

public class InstantiateComponentImplementationCommand {
	@GetLabel
	public String getLabel() {
		return "Instantiate";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ComponentImplementation compImpl) {
		return true;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ComponentImplementation compImpl) {
		try {
			InstantiateModel.buildInstanceModelFile(compImpl);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
