package org.osate.ge.errormodel.util;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.GraphicalAnnexUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelUtil {
	public static ErrorModelLibrary getOrCreateErrorModelLibrary(final AadlPackage pkg) {
		return (ErrorModelLibrary) GraphicalAnnexUtil.getOrCreateParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
	}

	public static ErrorModelLibrary getErrorModelLibrary(final AadlPackage pkg) {
		return (ErrorModelLibrary) GraphicalAnnexUtil.getFirstParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
	}
}
