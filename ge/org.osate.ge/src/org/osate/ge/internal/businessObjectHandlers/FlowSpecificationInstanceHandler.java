package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.inject.Named;

import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.ge.di.GetName;
import org.osate.ge.di.Names;

class FlowSpecificationInstanceHandler {
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) FlowSpecificationInstance fsi) {
		return fsi.getName();
	}

	/**
	 * Gets an array of business objects which describes the logical diagram element path to the flow end.
	 * @param fsi
	 * @param flowEnd
	 * @param addFeatureInstance - get the source or destination FeatureInstance of the FlowSpecificationInstance
	 * @return
	 */
	protected static Object[] getBusinessObjectsPathToFlowEnd(final FlowSpecificationInstance fsi,
			final FlowEnd flowEnd, final Function<FlowSpecificationInstance, FeatureInstance> addFeatureInstance) {
		final List<Object> path = new ArrayList<>(2);
		// For feature groups
		if (flowEnd != null && flowEnd.getContext() instanceof Feature) {
			path.add(fsi.getComponentInstance().findFeatureInstance((Feature) flowEnd.getContext()));
		}

		path.add(addFeatureInstance.apply(fsi));

		return path.toArray();
	}
}
