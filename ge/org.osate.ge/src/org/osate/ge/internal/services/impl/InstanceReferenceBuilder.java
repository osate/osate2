/*
Copyright (c) 2015, Rockwell Collins.
Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
package org.osate.ge.internal.services.impl;

import javax.inject.Named;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.di.Names;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.di.BuildCanonicalReference;
import org.osate.ge.di.BuildRelativeReference;

public class InstanceReferenceBuilder {
	final static String ID = "org.osate.ge.diagrams.instance";
	final static String SYSTEM_INSTANCE_KEY = "system_instance";
	final static String COMPONENT_INSTANCE_KEY = "component_instance";
	final static String FEATURE_INSTANCE_KEY = "feature_instance";
	final static String CONNECTION_REFERENCE_KEY = "connection_reference";
	
	@BuildRelativeReference 
	public String[] getRelativeReference(final SystemInstanceLoadingService systemInstanceLoader, final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof InstanceObject) {
			final InstanceObject io = (InstanceObject)bo;
			final String systemInstanceKey = systemInstanceLoader.getKey(io.getSystemInstance());
			if(systemInstanceKey == null) {
				return null;
			}
			
			if(bo instanceof SystemInstance) {
				return new String[] {ID, SYSTEM_INSTANCE_KEY, systemInstanceKey};
			} else if(bo instanceof ComponentInstance) {
				return new String[] {ID, COMPONENT_INSTANCE_KEY, io.getName()};
			} else if(bo instanceof FeatureInstance) {
				return new String[] {ID,FEATURE_INSTANCE_KEY, io.getName()};
			} else if(bo instanceof ConnectionReference) {
				return new String[] {ID,CONNECTION_REFERENCE_KEY, buildConnectionReferenceId((ConnectionReference)bo)};
			}			
		}
		
		return null;
	}
	
	@BuildCanonicalReference
	public String[] getReference(final SystemInstanceLoadingService systemInstanceLoader, final @Named(Names.BUSINESS_OBJECT) Object bo) {
		if(bo instanceof InstanceObject) {
			final InstanceObject io = (InstanceObject)bo;
			final String systemInstanceKey = systemInstanceLoader.getKey(io.getSystemInstance());
			if(systemInstanceKey == null) {
				return null;
			}
			
			if(bo instanceof SystemInstance) {
				return new String[] {ID, SYSTEM_INSTANCE_KEY, systemInstanceKey};
			} else if(bo instanceof ComponentInstance) {
				return new String[] {ID, COMPONENT_INSTANCE_KEY, systemInstanceKey, io.getInstanceObjectPath().toLowerCase()};
			} else if(bo instanceof FeatureInstance) {
				return new String[] {ID,FEATURE_INSTANCE_KEY, systemInstanceKey, io.getInstanceObjectPath().toLowerCase()};
			} else if(bo instanceof ConnectionReference) {
				return new String[] {ID,CONNECTION_REFERENCE_KEY, systemInstanceKey, buildConnectionReferenceId((ConnectionReference)bo)};
			}			
		}
		
		return null;
	}	
	
	static String buildConnectionReferenceId(final ConnectionReference cr) {
		return cr.getSource().getInstanceObjectPath().toLowerCase() + " -> " + cr.getDestination().getInstanceObjectPath().toLowerCase();
	}
}
