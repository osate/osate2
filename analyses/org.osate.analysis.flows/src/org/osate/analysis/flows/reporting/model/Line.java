package org.osate.analysis.flows.reporting.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
	List<String> content;

	public Line() {
		this.content = new ArrayList<String>();
	}

	public void addContent(String s) {
		this.content.add(s);
	}

	public List<String> getContent() {
		return this.content;
	}

}
