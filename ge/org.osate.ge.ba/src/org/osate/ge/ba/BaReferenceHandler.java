package org.osate.ge.ba;

import javax.inject.Named;

import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.di.BuildRelativeReference;
import org.osate.ge.di.Names;

public class BaReferenceHandler {
	private final static String BA_REFERENCE_PREFIX = "ba.";
	private final static String TYPE_STATE = BA_REFERENCE_PREFIX + "state";
	
	@BuildRelativeReference
	public String[] getRelativeReference(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof BehaviorState) {
			return new String[] {TYPE_STATE, ((BehaviorState)bo).getFullName()};				
		}
		
		return null;
	}
	
	// TODO: Support canonical references as needed
	/*
	@BuildReference
	public String[] getReference(final @Named(Names.BUSINESS_OBJECT) Object bo, final ReferenceBuilderService refBuilder) {
		return null;
	}
	
	@ResolveReference
	public Object getReferencedObject(final @Named(Names.REFERENCE) String[] ref, final ReferenceResolutionService refService) {
		return null;
	}
	*/
}
