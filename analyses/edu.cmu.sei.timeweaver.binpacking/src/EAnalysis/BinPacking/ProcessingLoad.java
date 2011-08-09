package EAnalysis.BinPacking;

public interface ProcessingLoad {
	/**
	 * Set the hardware node where this processing load is deployed
	 */
	public void setDeployedTo(HardwareNode n);

	/**
	 * get the hardware node where this processing load is deployed
	 */
	public HardwareNode getDeployedTo();

	/**
	 * Get the period int nanoseconds
	 */
	public long getPeriod();

	/**
	 * get deadline int nanoseconds
	 */
	public long getDeadline();

	/**
	 * number of cycles
	 */
	public long getCycles();

	/**
	 * bandwidth int cycles per second
	 */
	public double getBandwidth();

	public String getName();

	public long getCyclesPerSecond();

	public long getUniqueID();
}