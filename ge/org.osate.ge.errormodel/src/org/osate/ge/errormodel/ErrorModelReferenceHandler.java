package org.osate.ge.errormodel;

import javax.inject.Named;

import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.BuildReference;
import org.osate.ge.ext.annotations.ResolveReference;

public class ErrorModelReferenceHandler {
	@BuildReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return null;
	}
	
	@ResolveReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] ref) {
		return null;
	}
}
