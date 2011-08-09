package EAnalysis.BinPacking;

public class Site extends Location {
	public Site() {
	}

	public Site(double maxPower, double maxSpace, SiteGuest[] supportedGuests) {
		super(maxPower, maxSpace, supportedGuests);
	}

	public boolean addGuest(HardwareNode node) {
		if (node instanceof Link) {
			/* links do not consume resources in sites */
			guests.add(node);
			((SiteGuest) node).setHost(this);
			return true;
		} else {
			return super.addGuest(node);
		}
	}
}