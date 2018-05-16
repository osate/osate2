package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

public class Section {
	private List<Line> lines;
	private String name;

	public Section(String name) {
		this.lines = new ArrayList<Line>();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void addLine(Line l) {
		this.lines.add(l);
	}

	public List<Line> getLines() {
		return this.lines;
	}
}
