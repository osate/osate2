package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.analysis.flows.reporting.model.Line;

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
public abstract class LatencyContributor {

	public enum LatencyContributorMethod {
		DEADLINE, PERIOD, WCET, UNKNOWN
	};

	/**
	 * This represents the max and min value of the latency
	 * for this contributor.
	 */
	private double minValue;
	private double maxValue;

	/**
	 * methods represent what is the model elements used
	 * to compute the min or max value
	 */
	private LatencyContributorMethod worstCaseMethod;
	private LatencyContributorMethod bestCaseMethod;

	/**
	 * The sub contributors are basically what are the other
	 * elements that can incur a latency in addition to the
	 * related element. A good example is a bus for a 
	 * connection. The connection is the latency contributor
	 * and the bus is a sub-contributor (it adds potentially
	 * some latency).
	 */
	private List<LatencyContributor> subContributors;

	public LatencyContributor() {
		this.worstCaseMethod = LatencyContributorMethod.UNKNOWN;
		this.bestCaseMethod = LatencyContributorMethod.UNKNOWN;
		this.minValue = 0.0;
		this.maxValue = 0.0;
		this.subContributors = new ArrayList<LatencyContributor>();
	}

	public String mapMethodToString(LatencyContributorMethod method) {
		switch (method) {
		case DEADLINE:
			return "deadline";
		case WCET:
			return "execution time";
		case PERIOD:
			return "period";
		}
		return "unknown";
	}

	public List<LatencyContributor> getSubContributors() {
		return this.subContributors;
	}

	public void addSubContributor(LatencyContributor lc) {
		this.subContributors.add(lc);
	}

	public void setMinimum(double d) {
		this.minValue = d;
	}

	public void setMaximum(double d) {
		this.maxValue = d;
	}

	public double getMinimum() {
		return this.minValue;
	}

	public double getMaximum() {
		return this.maxValue;
	}

	protected abstract String getContributorName();

	public List<Line> export() {
		List<Line> lines;
		Line myLine;

		lines = new ArrayList<Line>();

		myLine = new Line();

		myLine.addContent("Latency Contributor " + this.getContributorName());
		myLine.addContent(this.minValue + "ms");
		myLine.addContent(this.maxValue + "ms");

		lines.add(myLine);

		/**
		 * We also add the lines of all the sub-contributors.
		 */
		for (LatencyContributor lc : this.subContributors) {
			lines.addAll(lc.export());
		}
		return lines;
	}
}
