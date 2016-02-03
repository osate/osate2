package org.osate.ge.ext.services;

import org.osate.aadl2.AadlPackage;

public interface ReferenceService {
	AadlPackage getAadlPackage(String qualifiedName);
}
