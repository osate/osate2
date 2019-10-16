package org.osate.alisa2.view;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * Utility methods used in > 1 classes go here.
 * @author sprocter
 *
 */
public class AsapUtil {

	/**
	 * Get the root error type associated with the given type. We walk up the
	 * type's hierarchy until we're at the top, then return that.
	 * TODO: Arguably this should be in EMV2Util
	 *
	 * @param err The type to get the root type from
	 * @return The root type (which may be the 'err' parameter, if it has no supertype)
	 */
	public static ErrorType getRootType(ErrorType err) {
		ErrorType ret = err;
		while (ret.getSuperType() != null) {
			ret = ret.getSuperType();
		}
		return ret;
	}

}
