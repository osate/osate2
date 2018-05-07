package EAnalysis.BinPacking;

import java.util.TreeSet;
import java.util.Vector;

public class Duct extends Location {
	public Vector siteMembers;

	public Object clone() {
		Duct d = (Duct) super.clone();
		d.siteMembers = (Vector) siteMembers.clone();
		return d;
	}

	public void addSite(Site s) {
		if (!siteMembers.contains(s))
			siteMembers.add(s);
	}

	public Duct() {
		siteMembers = new Vector();
	}

	public Duct(Site[] sites) {
		siteMembers = new Vector();
		for (int i = 0; i < sites.length; i++)
			siteMembers.add(sites[i]);
	}

	public Duct(double maxPower, double maxSpace, TreeSet supportedGuests) {
		super(maxPower, maxSpace, supportedGuests);
		siteMembers = new Vector();
	}

	public Duct(double maxPower, double maxSpace, SiteGuest[] supportedGuests) {
		super(maxPower, maxSpace, supportedGuests);
		siteMembers = new Vector();
	}

	public Duct(double maxPower, double maxSpace, SiteGuest[] supportedGuests, Site[] sites) {
		super(maxPower, maxSpace, supportedGuests);
		siteMembers = new Vector();
		for (int i = 0; i < sites.length; i++)
			siteMembers.add(sites[i]);
	}
}