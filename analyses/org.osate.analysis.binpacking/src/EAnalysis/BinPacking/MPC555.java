package EAnalysis.BinPacking;

public class MPC555 extends Processor {

	public MPC555() {
		super();
	}

	public MPC555(Scheduler s) {
		super(s, 500000000.0, new NetInterface[] { new NetInterface(new CANBus()) });
	}

	public MPC555(Scheduler s, NetInterface[] netInterfaces) {
		this(s);
		for (int i = 0; i < netInterfaces.length; i++)
			classNetInterfaces.add(netInterfaces[i]);
	}

	public MPC555(String name, Scheduler s, double speed, NetInterface[] netInterfaces) {
		super(name, s, speed, netInterfaces);
	}
}