package org.osate.ge.errormodel;

import javax.inject.Named;

import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.GetReference;
import org.osate.ge.ext.annotations.GetReferencedObject;

public class ErrorModelReferenceHandler {
	@GetReference
	public String getReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		System.err.println("GET REFERENCE");
		return null;
	}
	
	@GetReferencedObject
	public Object getReferencedObject(final @Named(Names.REFERENCE) String reference, final @Named(Names.REFERENCE_SEGMENTS) String[] refSegs) {
		System.err.println("GET REFERENCED OBJECT");
		return null;
	}
}
