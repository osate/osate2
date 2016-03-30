package EAnalysis.BinPacking;

public class CANBus extends Link {
	public CANBus() {
		super(new CapacityComparator(), new EDFScheduler(new BandwidthComparator()), 1000000.0);
	}

	public CANBus(double capacity) {
		super(new CapacityComparator(), new EDFScheduler(new BandwidthComparator()), capacity);
	}
}