package org.osate.analysis.flows.model;

import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.VirtualBusType;
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

	/**
	 * The relatedElement represents the AADL element that
	 * is related to this latency contributor. Mostly, it is
	 * a component or a connection.
	 */
	private NamedElement relatedElement;

	/**
	 * The sub contributors are basically what are the other
	 * elements that can incur a latency in addition to the
	 * related element. A good example is a bus for a 
	 * connection. The connection is the latency contributor
	 * and the bus is a sub-contributor (it adds potentially
	 * some latency).
	 */
	private List<LatencyContributorComponent> subContributors;

	public LatencyContributorComponent(NamedElement ci) {
		super();
		this.relatedElement = ci;
	}

	protected String getContributorName() {
		return relatedElement.getName();
	}

	protected String getContributorType() {
		ComponentInstance relatedComponentInstance;
		ComponentType relatedComponentType;

		if (relatedElement instanceof ComponentInstance) {
			relatedComponentInstance = (ComponentInstance) relatedElement;

			if (relatedComponentInstance.getCategory() == ComponentCategory.THREAD) {
				return "Thread";
			}

			if (relatedComponentInstance.getCategory() == ComponentCategory.DEVICE) {
				return "Device";
			}

			if (relatedComponentInstance.getCategory() == ComponentCategory.BUS) {
				return "Bus";
			}
		}
		if (relatedElement instanceof ComponentClassifier) {
			relatedComponentType = (ComponentType) relatedElement;
			relatedComponentType.getCategory().toString();
		}

		if (relatedElement instanceof VirtualBusType) {
			return "Protocol";
		}

		return "Component";
	}

}
