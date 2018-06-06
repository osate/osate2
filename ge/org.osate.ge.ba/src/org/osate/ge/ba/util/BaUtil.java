package org.osate.ge.ba.util;

import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.GraphicalAnnexUtil;

public class BaUtil {
	private static final String ANNEX_NAME = "behavior_specification";

	public static BehaviorAnnex getOrCreateBehaviorAnnex(final Classifier c) {
		return (BehaviorAnnex) GraphicalAnnexUtil.getOrCreateParsedAnnexSubclause(c, ANNEX_NAME,
				AadlBaPackage.eINSTANCE.getBehaviorAnnex());
	}

	public static BehaviorAnnex getBehaviorAnnex(final Classifier c) {
		return (BehaviorAnnex) GraphicalAnnexUtil.getFirstParsedAnnexSubclause(c, ANNEX_NAME,
				AadlBaPackage.eINSTANCE.getBehaviorAnnex());
	}
}
