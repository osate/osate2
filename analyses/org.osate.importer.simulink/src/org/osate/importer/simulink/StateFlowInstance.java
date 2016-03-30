package org.osate.importer.simulink;

public class StateFlowInstance {
	private String name;
	private int machineId;
	private int chartId;

	public StateFlowInstance() {
		this.name = "unknown";
		this.machineId = 0;
		this.chartId = 0;
	}

	public void setMachineId(int m) {
		this.machineId = m;
	}

	public void setChartId(int c) {
		this.chartId = c;
	}

	public void setName(String s) {
		this.name = s;
	}

	public String getName() {
		return this.name;
	}

	public int getMachineId() {
		return this.machineId;
	}

	public int getChartId() {
		return this.chartId;
	}
}
