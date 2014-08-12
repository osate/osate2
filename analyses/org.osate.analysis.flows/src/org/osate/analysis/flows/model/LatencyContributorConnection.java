package org.osate.analysis.flows.model;

import org.osate.aadl2.instance.ConnectionInstance;

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
public class LatencyContributorConnection extends LatencyContributor {

	public enum ConnectionType {
		DELAYED, SAMPLED, IMMEDIATE
	};

	/**
	 * The relatedElement represents the AADL element that
	 * is related to this latency contributor. In that case,
	 * this is a connection
	 */
	private ConnectionInstance relatedConnection;

	public LatencyContributorConnection(ConnectionInstance ci) {
		super();
		this.relatedConnection = ci;
	}

	protected String getContributorName() {
		return "connection " + relatedConnection.getName();
	}

}
