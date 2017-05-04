package org.osate.ge.ba;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;

public class BaBusinessObjectProvider {
	@Activate
	public Stream<?> getBusinessObjects(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		if(bo instanceof BehaviorAnnex) {
			final BehaviorAnnex ba = (BehaviorAnnex)bo;
			return ba.getStates().stream();
		}
		
		return null;		
	}
}
