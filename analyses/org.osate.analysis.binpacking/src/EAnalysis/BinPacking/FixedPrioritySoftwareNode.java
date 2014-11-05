package EAnalysis.BinPacking;

public class FixedPrioritySoftwareNode extends SoftwareNode implements FixedPriorityProcessingLoad {
	long priority = 0;

	public void setPriority(long p) {
		priority = p;
	}

	public long getPriority() {
		return priority;
	}

	long completionTime = 0;

	public void setCompletionTime(long c) {
		completionTime = c;
	}

	public long getCompletionTime() {
		return completionTime;
	}

	public FixedPrioritySoftwareNode(long priority, long cycles, long period, long deadline) {
		super(cycles, period, deadline);
		this.priority = priority;
	}

	public FixedPrioritySoftwareNode(long priority, long cycles, long period, long deadline, String name) {
		super(cycles, period, deadline, name);
		this.priority = priority;
	}

	public FixedPrioritySoftwareNode(long cycles, long period, long deadline, String name) {
		super(cycles, period, deadline, name);
	}
}