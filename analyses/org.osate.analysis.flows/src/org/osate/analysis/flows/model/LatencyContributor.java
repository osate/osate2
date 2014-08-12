package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;
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
public class LatencyContributor {

	/**
	 * This represents the max and min value of the latency
	 * for this contributor.
	 */
	private double minValue;
	private double maxValue;

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
	private List<LatencyContributor> subContributors;

	public LatencyContributor() {
		this.minValue = 0.0;
		this.maxValue = 0.0;
		this.relatedElement = null;
		this.subContributors = new ArrayList<LatencyContributor>();
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

	public NamedElement getElement() {
		return this.relatedElement;
	}

	public void setElement(NamedElement ne) {
		this.relatedElement = ne;
	}

	public List<Line> export() {
		List<Line> lines;
		Line myLine;

		lines = new ArrayList<Line>();

		myLine = new Line();

		myLine.addContent("Latency Contributor " + this.relatedElement.getName());
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
