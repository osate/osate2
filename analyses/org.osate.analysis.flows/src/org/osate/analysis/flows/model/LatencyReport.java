package org.osate.analysis.flows.model;

import java.util.ArrayList;
import java.util.List;

public class LatencyReport {
	private List<ReportEntry> entries;

	public LatencyReport() {
		this.entries = new ArrayList<ReportEntry>();
	}

	public List<ReportEntry> getEntries() {
		return this.entries;
	}

	public void save() {

	}
}
