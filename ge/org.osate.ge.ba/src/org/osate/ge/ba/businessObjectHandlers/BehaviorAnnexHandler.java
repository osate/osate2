package org.osate.ge.ba.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;

public class BehaviorAnnexHandler {
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) BehaviorAnnex ba) {
		return true;
	}
}
