package EAnalysis.BinPacking;

import java.util.TreeSet;

public class HardwareNode implements CapacityProvider, SiteGuest {

	static long nextUniqueID = 0;

	long uniqueID = 0;

	public long getUniqueID() {
		return uniqueID;
	}

	Object semanticObject = null;

	public void setSemanticObject(Object o) {
		semanticObject = o;
	}

	public Object getSemanticObject() {
		return semanticObject;
	}

	/**
	 * in watts
	 */
	public double powerRequirement = 0.0;

	public double getPowerRequirement() {
		return powerRequirement;
	}

	/**
	 * in square centimeters
	 */
	public double spaceRequirement = 0.0;

	public double getSpaceRequirement() {
		return spaceRequirement;
	}

	Location hostSite = null;

	public void setHost(Location l) {
		hostSite = l;
	}

	public Location getHost() {
		return hostSite;
	}

	public String name;

	/**
	 * Speed: either cycles per second or bits per second.
	 */
	public double cyclesPerSecond = 0.0;

	/**
	 * cycles per second.
	 */

	public double getAvailableCapacity() {
		return (scheduler.getAvailableCapacity() * cyclesPerSecond);
	}

	protected Scheduler scheduler;

	public static void cloneTo(HardwareNode from, HardwareNode to) {
		try {
			to.scheduler = (Scheduler) from.scheduler.getClass().newInstance();
			to.scheduler.cloneTo(from.scheduler, to.scheduler);
			to.scheduler.setHardwareNode(to);
			to.cyclesPerSecond = from.cyclesPerSecond;
			to.name = from.name;
			to.powerRequirement = from.powerRequirement;
			to.spaceRequirement = from.spaceRequirement;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HardwareNode() {
		uniqueID = ++nextUniqueID;
	}

	public HardwareNode(Scheduler s, double cyclesPerSec) {
		this();
		scheduler = s;
		s.setHardwareNode(this);
		cyclesPerSecond = cyclesPerSec;
	}

	public HardwareNode(String n, Scheduler s, double c) {
		this(s, c);
		name = n;
	}

	public TreeSet getTaskSet() {
		return scheduler.getTaskSet();
	}

	public boolean addIfFeasible(ProcessingLoad sNode) {
		/* check to see if it fits */

		boolean b = scheduler.addIfFeasible(sNode);
		// if (b && sNode instanceof SoftwareNode )
		// BinPackerTester.progress += ( sNode instanceof CompositeSoftNode) ?
		// ((CompositeSoftNode)sNode).getBasicComponents().size() : 1;
		return b;
	}

	public void removeFromFeasibleSet(ProcessingLoad sNode) {
		scheduler.removeFromFeasibleSet(sNode);
	}

	public boolean canAddToFeasibility(ProcessingLoad sNode) {
		return scheduler.canAddToFeasibility(sNode);
	}

	public boolean canReplace(HardwareNode other) {
		/* compatibles */
		if (other.getClass().isAssignableFrom(getClass()) || getClass().isAssignableFrom(other.getClass())) {
			Scheduler sched = (Scheduler) ((BaseScheduler) other.scheduler).clone();
			sched.setHardwareNode(this);
			if (sched.isSchedulable(other.getTaskSet())) {
				return true;
			}
		}
		return false;
	}

	public double getCyclesPerSecond() {
		// TODO Auto-generated method stub
		return cyclesPerSecond;
	}

}
