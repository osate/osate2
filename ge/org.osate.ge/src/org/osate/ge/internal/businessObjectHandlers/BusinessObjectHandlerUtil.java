package org.osate.ge.internal.businessObjectHandlers;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;

public class BusinessObjectHandlerUtil {
	public static boolean diagramSupportsPackageOrClassifiers(final Object diagramBo) {
		return diagramBo == null || diagramBo instanceof AadlPackage || diagramBo instanceof Classifier;
	}
}
