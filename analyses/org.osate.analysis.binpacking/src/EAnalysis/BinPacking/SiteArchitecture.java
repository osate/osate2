package EAnalysis.BinPacking;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class SiteArchitecture implements Cloneable {

	public Object clone() {
		Hashtable originalToClone = new Hashtable();
		SiteArchitecture sa = new SiteArchitecture();
		for (Iterator sites = sitesBySize.iterator(); sites.hasNext();) {
			Site s = (Site) sites.next();
			Site siteClone = (Site) s.clone();
			originalToClone.put(s, siteClone);
			sa.addSite(siteClone);
		}

		Vector processedDucts = new Vector();

		for (Iterator sites = sitesBySize.iterator(); sites.hasNext();) {
			Site originalSite = (Site) sites.next();
			Site clonedSite = (Site) originalToClone.get(originalSite);
			TreeSet connectivityVector = (TreeSet) siteConnectivityMatrix.get(originalSite);
			if (connectivityVector != null) {
				// TreeSet clonedConnVector = new TreeSet(new HostComparator());
				for (Iterator ducts = connectivityVector.iterator(); ducts.hasNext();) {
					Duct d = (Duct) ducts.next();
					if (processedDucts.contains(d))
						continue;

					processedDucts.add(d);

					Duct cloneDuct = new Duct(d.maximumPower, d.maximumSpace, d.potentialGuests);
					for (int i = 0; i < d.siteMembers.size(); i++) {
						Site originalPartner = (Site) d.siteMembers.get(i);
						Site clonedPartner = (Site) originalToClone.get(originalPartner);
						cloneDuct.addSite(clonedPartner);
					}
					sa.addDuct(cloneDuct);

					// for (int i=0; i<d.siteMembers.size(); i++)
					// {
					// Site originalPartner = (Site) d.siteMembers.get(i);
					// Site clonedPartner = (Site)
					// originalToClone.get(originalPartner);
					// TreeSet clonedPartnerConnVector = (TreeSet)
					// sa.siteConnectivityMatrix.remove(clonedPartner);
					// if (clonedPartnerConnVector == null)
					// {
					// clonedPartnerConnVector = new TreeSet(new
					// HostComparator());
					// }
					// clonedPartnerConnVector.add(cloneDuct);
					// sa.siteConnectivityMatrix.put(clonedPartner,
					// clonedPartnerConnVector);
					// }
				}
				// sa.siteConnectivityMatrix.put(clonedSite, clonedConnVector);
				// System.out.println("clone() added
				// map(site("+clonedSite.hashCode()+"),
				// vector("+clonedConnVector+"))");
			}
		}

		// BinPackerTester.showSiteArchitecture(this);
		// BinPackerTester.showSiteArchitecture(sa);

		return sa;
	}

	/**
	 * The size of the site is calculated by their available hosting capacity
	 */
	public TreeSet sitesBySize = new TreeSet(new HostComparator());

	/**
	 * Set of Connetivity vectors ordered by site.
	 */
	public TreeMap siteConnectivityMatrix = new TreeMap(new HostComparator());

	public boolean neighbor(Site siteOne, Site siteTwo) {
		TreeSet connectivityVector = (TreeSet) siteConnectivityMatrix.get(siteOne);
		if (connectivityVector == null)
			return false;
		for (Iterator iter = connectivityVector.iterator(); iter.hasNext();) {
			Duct d = (Duct) iter.next();
			if (d.siteMembers.contains(siteTwo))
				return true;
		}
		return false;
	}

	public Duct getDuctBetween(Site siteOne, Site siteTwo) {
		if (siteOne == null || siteTwo == null)
			return null;

		TreeSet connectivityVector = (TreeSet) siteConnectivityMatrix.get(siteOne);
		if (connectivityVector == null) {
			System.out.println("site(" + siteOne + ") connectivity = null");
			return null;
		}

		for (Iterator iter = connectivityVector.iterator(); iter.hasNext();) {
			Duct d = (Duct) iter.next();
			if (d.siteMembers.contains(siteTwo))
				return d;
		}
		System.out.println("\t\t no common duct from site(" + siteOne + ")");
		return null;
	}

	public void addSite(Site s) {
		sitesBySize.add(s);
	}

	/**
	 * add a site guest and reposition the site based on its new size
	 */
	public void addSiteGuest(HardwareNode n, Site s) {
		/* reposition regarding new size */
		sitesBySize.remove(s);
		Object o = siteConnectivityMatrix.remove(s);
		s.addGuest(n);
		siteConnectivityMatrix.put(s, o);
		sitesBySize.add(s);
	}

	/**
	 * add a duct guest and reposition the duct in the connectivity matrix based
	 * on the new size
	 */
	public void addDuctGuest(HardwareNode l, Duct d) {
		int siteMemberSize = d.siteMembers.size();
		for (int i = 0; i < siteMemberSize; i++) {
			TreeSet siteConnVector = (TreeSet) siteConnectivityMatrix.get(d.siteMembers.get(i));

			/* reposition duct based on new size */
			siteConnVector.remove(d);
		}
		boolean b = d.addGuest(l);
		System.out.println(
				"Adding duct guest.space(" + l.spaceRequirement + ") duct(" + d + ").space(" + d.availableSpace + ")");
		for (int i = 0; i < siteMemberSize; i++) {
			TreeSet siteConnVector = (TreeSet) siteConnectivityMatrix.get(d.siteMembers.get(i));

			siteConnVector.add(d);
		}
	}

	public void addDuct(Duct d) {
		int siteMembersSize = d.siteMembers.size();
		for (int i = 0; i < siteMembersSize; i++) {
			Site site1 = (Site) d.siteMembers.elementAt(i);
			TreeSet site1ConnVector = (TreeSet) siteConnectivityMatrix.remove(site1);
			if (site1ConnVector == null) {
				site1ConnVector = new TreeSet(new HostComparator());
			}
			if (!site1ConnVector.contains(d))
				site1ConnVector.add(d);
			siteConnectivityMatrix.put(site1, site1ConnVector);
		}
	}
}