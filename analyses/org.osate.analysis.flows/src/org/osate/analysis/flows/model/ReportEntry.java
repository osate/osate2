package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

public class ReportEntry {

	List<LatencyContributor> contributors;

	public ReportEntry() {
		this.contributors = new ArrayList<LatencyContributor>();
	}

	public void addContributor(LatencyContributor lc) {
		this.contributors.add(lc);
	}

	public List<LatencyContributor> getContributors() {
		return this.contributors;
	}

	public double getMinimumLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getMinimum();
		}

		return res;
	}

	public double getMaximumLatency() {
		double res = 0.0;
		for (LatencyContributor lc : contributors) {
			res = res + lc.getMaximum();
		}

		return res;
	}

}
