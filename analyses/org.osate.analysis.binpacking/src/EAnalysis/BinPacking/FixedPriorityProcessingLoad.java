package EAnalysis.BinPacking;

public interface FixedPriorityProcessingLoad extends ProcessingLoad {

	public void setPriority(long priority);

	public long getPriority();
}