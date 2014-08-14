package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.analysis.flows.reporting.model.Line;
import org.osate.analysis.flows.reporting.model.ReportSeverity;

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
		DEADLINE, PERIOD, WCET, IMMEDIATE, UNKNOWN, DELAYED, SAMPLED, SPECIFIED, TRANSMISSION_TIME
	};

	/**
	 * This represents the max and min value of the latency
	 * for this contributor.
	 */
	private double minValue;
	private double maxValue;

	/**
	 * The expected minimum and maximum latency values.
	 */
	private double expectedMin;
	private double expectedMax;

	/**
	 * Some comments we would like to add in the report.
	 */
	private String comments;

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
		this.expectedMax = 0.0;
		this.expectedMin = 0.0;
		this.subContributors = new ArrayList<LatencyContributor>();
		this.comments = "";
	}

	public String getComments() {
		return this.comments;
	}

	public void addComment(String c) {
		this.comments = this.comments + " - " + c;
	}

	public void setComments(String c) {
		this.comments = c;
	}

	public void setExpectedMaximum(double d) {
		this.expectedMax = d;
	}

	public void setExpectedMinimum(double d) {
		this.expectedMin = d;
	}

	public static String mapMethodToString(LatencyContributorMethod method) {
		switch (method) {
		case DEADLINE:
			return "deadline";
		case WCET:
			return "execution time";
		case PERIOD:
			return "period";
		case DELAYED:
			return "delayed connection";
		case SAMPLED:
			return "sampled connection";
		case IMMEDIATE:
			return "immediate local connection";
		case SPECIFIED:
			return "specified";
		case TRANSMISSION_TIME:
			return "transmission time";
		}
		return "unknown";
	}

	public void setWorstCaseMethod(LatencyContributorMethod m) {
		this.worstCaseMethod = m;
	}

	public void setBestCaseMethod(LatencyContributorMethod m) {
		this.bestCaseMethod = m;
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
		double res = this.minValue;
		for (LatencyContributor lc : subContributors) {
			res = lc.getMinimum();
		}

		return res;
	}

	public double getMaximum() {
		double res = this.maxValue;
		for (LatencyContributor lc : subContributors) {
			res = lc.getMaximum();
		}

		return res;
	}

	protected abstract String getContributorName();

	protected abstract String getContributorType();

	public List<Line> export() {
		List<Line> lines;
		Line myLine;

		lines = new ArrayList<Line>();

		myLine = new Line();
		myLine.setSeverity(ReportSeverity.UNKNOWN);

		myLine.addContent(this.getContributorType() + " " + this.getContributorName());
		if (this.expectedMin != 0.0) {
			myLine.addContent(this.expectedMin + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getMinimum() + "ms");
		myLine.addContent(mapMethodToString(bestCaseMethod));
		if (this.expectedMax != 0.0) {
			myLine.addContent(this.expectedMax + "ms");
		} else {
			myLine.addContent(""); // the min expected value
		}
		myLine.addContent(this.getMaximum() + "ms");
		myLine.addContent(mapMethodToString(worstCaseMethod));

		if ((this.expectedMax != 0.0) && (this.maxValue > this.expectedMax)) {
			myLine.setSeverity(ReportSeverity.WARNING);
		}

		if ((this.expectedMin != 0.0) && (this.minValue > this.expectedMin)) {
			myLine.setSeverity(ReportSeverity.WARNING);
		}

		myLine.addContent(this.getComments());

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
