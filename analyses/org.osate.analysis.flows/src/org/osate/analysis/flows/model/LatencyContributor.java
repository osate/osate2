package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.NamedElement;

public class LatencyContributor {
	private double minValue;
	private double maxValue;
	private NamedElement relatedElement;
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

}
