package EAnalysis.BinPacking;

public class NetInterface implements CapacityProvider, Cloneable {
	protected Link link = null;

	public Object clone() {
		try {
			NetInterface n = new NetInterface();
			n.link = (Link) link.getClass().newInstance();
			HardwareNode.cloneTo(link, n.link);
			return n;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getAvailableCapacity() {
		return link.getAvailableCapacity();
	}

	public boolean available() {
		return (link == null);
	}

	public void connectTo(Link l) {
		link = l;
	}

	public Link getLink() {
		return link;
	}

	public void disconnect() {
		link = null;
	}

	public NetInterface() {
	}

	public NetInterface(Link l) {
		link = l;
	}
}