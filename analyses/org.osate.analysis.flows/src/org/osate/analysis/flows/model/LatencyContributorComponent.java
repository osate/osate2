package org.osate.analysis.flows.model;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.VirtualBus;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * A latency Contributor represents something in the flow
 * that can contribute to increase/decrease the latency.
 *
 * This class contains the result for a latency contributor
 * with min/max latency.
 *
 * @author julien
 *
 */
public class LatencyContributorComponent extends LatencyContributor {
	public LatencyContributorComponent(NamedElement ci) {
		super();
		this.relatedElement = ci;
	}

	@Override
	protected String getContributorType() {
		ComponentInstance relatedComponentInstance;
		ComponentType relatedComponentType;

		if (relatedElement instanceof ComponentInstance) {
			relatedComponentInstance = (ComponentInstance) relatedElement;
			if (relatedComponentInstance.getCategory() == ComponentCategory.VIRTUAL_BUS) {
				return "protocol";
			}
			if (relatedComponentInstance.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
				return "partition";
			}
			return relatedComponentInstance.getCategory().getName();
		}
		if (relatedElement instanceof VirtualBus) {
			return "protocol";
		}
		if (relatedElement instanceof ComponentClassifier) {
			relatedComponentType = (ComponentType) relatedElement;
			return relatedComponentType.getCategory().getName();
		}
		return "component";
	}

}
