package org.osate.ge.ba;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ba.util.BaUtil;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;

public class BaBusinessObjectProvider {
	@Activate
	public Stream<?> getBusinessObjects(final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		final Object bo = boc.getBusinessObject();
		if (bo instanceof Classifier) {
			final BehaviorAnnex ba = BaUtil.getBehaviorAnnex((Classifier) bo);
			if (ba == null) {
				return null;
			}

			return ba.getStates().stream();
		}

		return null;
	}
}
