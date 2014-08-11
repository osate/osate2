package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
	List<Line> lines;

	public Section() {
		this.lines = new ArrayList<Line>();
	}

	public void addLine(Line l) {
		this.lines.add(l);
	}

	public List<Line> getLines() {
		return this.lines;
	}
}
