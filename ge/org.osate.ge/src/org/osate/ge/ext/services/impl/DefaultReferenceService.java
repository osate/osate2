package org.osate.ge.ext.services.impl;

import java.util.Objects;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.ext.services.ReferenceService;
import org.osate.ge.services.SerializableReferenceService;

public class DefaultReferenceService implements ReferenceService {
	private final SerializableReferenceService srService;
	
	public DefaultReferenceService(final SerializableReferenceService srService) {
		this.srService = Objects.requireNonNull(srService, "srService must not be null");
	}
	
	@Override
	public AadlPackage getAadlPackage(final String qualifiedName) {
		return srService.getAadlPackage(qualifiedName);
	}

}
