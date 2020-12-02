package org.osate.annexsupport;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EValidator.Descriptor;

public class AnnexValidatorDescriptor implements Descriptor {

	private EValidator registeredValidator;

	AnnexValidatorDescriptor(EValidator validator) {
		registeredValidator = validator;
	}

	@Override
	public EValidator getEValidator() {
		return new AnnexValidator(registeredValidator);
	}

}
