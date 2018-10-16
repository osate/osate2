package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;

class FlowSpecificationInstanceHandler {
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		return fsi.getName();
	}
}
