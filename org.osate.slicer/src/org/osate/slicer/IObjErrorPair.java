package org.osate.slicer;

import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.instance.InstanceObject;

/**
 * Utility class representing the pairing of a feature instance, error source, or error sink and error(s)
 * propagated from it. Used by reachability methods to return results.
 *
 * @author sprocter
 *
 */
public class IObjErrorPair {
	private InstanceObject iobj;
	private TypeTokenInstance token;

	/**
	 * Create a new pair
	 * @param iobj Either a feature, error source, or error sink instance
	 * @param error Error(s) propagated into or out of {@link IObjErrorPair#iobj}
	 */
	public IObjErrorPair(InstanceObject iobj, TypeTokenInstance token) {
		this.iobj = iobj;
		this.token = token;
	}

	public InstanceObject getComponent() {
		return iobj;
	}

	public void setComponent(InstanceObject feat) {
		this.iobj = feat;
	}

	public TypeTokenInstance getErrorToken() {
		return token;
	}

	public void setError(TypeTokenInstance token) {
		this.token = token;
	}
}