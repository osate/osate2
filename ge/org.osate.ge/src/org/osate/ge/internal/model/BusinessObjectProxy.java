package org.osate.ge.internal.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EClass;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectReferenceService;

/**
 * Object which may be provided by a business object provider in place of another object which make be expensive to return. The intended use is for cases like packages
 * in contextless diagrams where returning the package requires loading the source. Proxy EObjects are not used because they do not contain all the necessary data
 * for determining name and icons. This object is handled specially by the graphical editor.
 * The business object tree updater will replace it with the resolved object in the business object tree. The result of which is that most of the code-base can safely assume that the business object
 * is not a proxy.
 * */
public class BusinessObjectProxy {
	private final String name;
	private final EClass eClass;
	private final CanonicalBusinessObjectReference canonicalReference;
	private final RelativeBusinessObjectReference relativeReference;

	public BusinessObjectProxy(final String name, final EClass eClass,
			final CanonicalBusinessObjectReference canonicalReference,
			final RelativeBusinessObjectReference relativeReference) {
		this.name = Objects.requireNonNull(name, "name must not be null");
		this.eClass = Objects.requireNonNull(eClass, "eClass must not be null");
		this.canonicalReference = Objects.requireNonNull(canonicalReference, "canonicalReference must not be null");
		this.relativeReference = Objects.requireNonNull(relativeReference, "relativeReference must not be null");
	}

	public final String getName() {
		return name;
	}

	public final EClass getEClass() {
		return eClass;
	}

	public final CanonicalBusinessObjectReference getCanonicalReference() {
		return canonicalReference;
	}

	public final RelativeBusinessObjectReference getRelativeReference() {
		return relativeReference;
	}

	public Object resolve(final ProjectReferenceService projectReferenceService) {
		return projectReferenceService.resolve(canonicalReference);
	}
}
