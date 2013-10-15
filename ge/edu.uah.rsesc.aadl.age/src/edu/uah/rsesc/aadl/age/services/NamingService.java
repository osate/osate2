package edu.uah.rsesc.aadl.age.services;

import org.osate.aadl2.Namespace;

public interface NamingService {
	/**
	 * Builds an identifier using the specified base that doesn't conflict with identifiers in the specified namespace
	 * @param namespace
	 * @param baseIdentifier
	 * @return an identifier that is unique in the specified namespace
	 */
	String buildUniqueIdentifier(Namespace namespace, String baseIdentifier);
}
