package EAnalysis.BinPacking;

public class Ethernet extends Link {
	public Ethernet() {
		super(new CapacityComparator(), new EDFScheduler(new BandwidthComparator()), 10000000.0);
	}
}