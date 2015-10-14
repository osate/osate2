package org.osate.ge.services.impl;

import java.util.Objects;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.osate.aadl2.Element;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.SerializableReferenceService;

public class DefaultSerializableReferenceService implements SerializableReferenceService {
	private final DeclarativeReferenceHandler declarativeReferenceHandler;
	
	public DefaultSerializableReferenceService(final IDiagramTypeProvider diagramTypeProvider) {
		this.declarativeReferenceHandler = new DeclarativeReferenceHandler(diagramTypeProvider);
	}
	
	@Override
	public String getReference(final Object bo) {
		return declarativeReferenceHandler.getReference(bo);
	}
		
	@Override
	public Object getReferencedObject(final String reference) {
		Objects.requireNonNull(reference, "reference must not be null");
		
		// Break the reference into segments
		final String[] refSegs = reference.split(" ");
		if(refSegs.length < 2) {
			return null;
		}
				
		final Object referencedObject = declarativeReferenceHandler.getReferencedObject(reference, refSegs);		
		return referencedObject instanceof Element ?  new AadlElementWrapper((Element)referencedObject) : null;
	}
}
