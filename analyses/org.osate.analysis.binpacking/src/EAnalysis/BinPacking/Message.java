package EAnalysis.BinPacking;

public class Message extends SoftwareNode implements Cloneable {
	protected SoftwareNode sender;

	protected SoftwareNode receiver;

	public Message() {
		super();
	}

	public Message(SoftwareNode s, SoftwareNode r) {
		this();
		sender = s;
		receiver = r;
		if (sender == null || receiver == null) {
			double i = s.getBandwidth() + r.getBandwidth();
		}
	}

	public Message(SoftwareNode s, SoftwareNode r, String name) {
		this(s, r);
		this.name = name;
	}

	public Message(long cycles, long period, long deadline, SoftwareNode s, SoftwareNode r) {
		super(cycles, period, deadline);
		sender = s;
		receiver = r;
		if (sender == null || receiver == null) {
			double i = s.getBandwidth() + r.getBandwidth();
		}
	}

	public Message(long cycles, long period, long deadline, SoftwareNode s, SoftwareNode r, String name) {
		this(cycles, period, deadline, s, r);
		this.name = name;
	}

	/**
	 * Returns the partner of
	 * 
	 * @param self
	 */
	public SoftwareNode getPartner(SoftwareNode self) {
		return (self.equals(sender) ? receiver : sender);
	}

	/**
	 * Set the partner of
	 * 
	 * @param self
	 *            to
	 * @param p
	 */
	public void setPartner(SoftwareNode self, SoftwareNode p) {
		if (self == null || p == null) {
			double d = self.getBandwidth() + p.getBandwidth();
		}
		if (self.equals(sender))
			receiver = p;
		else
			sender = p;
	}

	public SoftwareNode getSender() {
		return sender;
	}

	public void setSender(SoftwareNode n) {
		if (n == null) {
			double d = n.getBandwidth();
		}
		sender = n;
	}

	public SoftwareNode getReceiver() {
		return receiver;
	}

	public void setReceiver(SoftwareNode n) {
		if (n == null) {
			double d = n.getBandwidth();
		}
		receiver = n;
	}

	public Object clone() {
		Message m = (Message) super.clone();
		m.sender = sender;
		m.receiver = receiver;
		return m;
	}
}