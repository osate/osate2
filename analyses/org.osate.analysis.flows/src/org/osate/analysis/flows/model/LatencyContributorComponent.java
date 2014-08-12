package org.osate.analysis.flows.model;

import java.util.List;

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
	private ComponentInstance relatedComponentInstance;

	/**
	 * The sub contributors are basically what are the other
	 * elements that can incur a latency in addition to the
	 * related element. A good example is a bus for a 
	 * connection. The connection is the latency contributor
	 * and the bus is a sub-contributor (it adds potentially
	 * some latency).
	 */
	private List<LatencyContributorComponent> subContributors;

	public LatencyContributorComponent(ComponentInstance ci) {
		super();
		this.relatedComponentInstance = ci;
	}

	protected String getContributorName() {
		return "component " + relatedComponentInstance.getName();
	}

}
