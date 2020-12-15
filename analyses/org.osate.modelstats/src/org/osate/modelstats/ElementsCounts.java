package org.osate.modelstats;

import java.util.Map;

import org.osate.aadl2.ComponentCategory;

public class ElementsCounts {
	private final int totalComponentCount;
	private final int connectionsCount;
	private final int endToEndFlowsCount;
	private final Map<ComponentCategory, Integer> individualCompnentCounts;

	public ElementsCounts(Map<ComponentCategory, Integer> indCompCounts, int conCount, int eteCount) {
		individualCompnentCounts = indCompCounts;
		connectionsCount = conCount;
		endToEndFlowsCount = eteCount;
		totalComponentCount = individualCompnentCounts.values().stream().mapToInt(x -> x).sum();
	}

	public int getConnectionsCount() {
		return connectionsCount;
	}

	public int getEndToEndFlowsCount() {
		return endToEndFlowsCount;
	}

	public int getTotalComponentCount() {
		return totalComponentCount;
	}

	public Map<ComponentCategory, Integer> getComponentCountMap() {
		return individualCompnentCounts;
	}
}
