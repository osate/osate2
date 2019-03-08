package org.osate.assure.util;

import org.eclipse.core.runtime.Platform;

public class ResoluteUtil {

	private static boolean RESOLUTE_INSTALLED = false;
	private static boolean INSTALL_INITIALIZED = false;

	public static boolean isResoluteInstalled() {
		if (!INSTALL_INITIALIZED) {
			RESOLUTE_INSTALLED = Platform.getBundle("com.rockwellcollins.atc.resolute") != null;
			INSTALL_INITIALIZED = true;
		}
		return RESOLUTE_INSTALLED;
	}

}
