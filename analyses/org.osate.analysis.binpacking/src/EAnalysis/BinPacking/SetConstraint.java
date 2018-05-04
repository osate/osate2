package EAnalysis.BinPacking;

import java.util.Vector;

/**
 * @author Dionisio de Niz
 * 
 * The SetConstraint is a constrained used to limit the possibilities of
 * assignment from software nodes to hardware nodes. It includes two sets (as
 * vectors) the software set and the hardware set. These sets implies
 * compatibility software to hardware. The hardware set can contain classes,
 * e.g. MPC555.class meaning that any processor of that class would be
 * compatible. For an example see BinPackerTester.SimpleConstrainedTest()
 */
public class SetConstraint extends Constraint implements Cloneable {
	public Vector hardwareMembers = new Vector();

	public SetConstraint() {
	}

	public SetConstraint(Object[] s, Object[] h) {
		if (members == null)
			members = new Vector();

		for (int i = 0; i < s.length; i++) {
			members.add(s[i]);
		}
		for (int i = 0; i < h.length; i++) {
			hardwareMembers.add(h[i]);
		}
	}

	public void addSoftwareMember(Object o) {
		if (!members.contains(o)) {
			members.add(o);
		}
	}

	public void addHardwareMember(Object o) {
		if (!hardwareMembers.contains(o)) {
			hardwareMembers.add(o);
		}
	}

	public boolean isAssignable(SoftwareNode s, HardwareNode h) {
		boolean hardwareMembership = false;
		boolean softwareMembership = false;

		// Does the hardware has membership?
		int hardSize = hardwareMembers.size();
		for (int i = 0; i < hardSize; i++) {
			Object node = hardwareMembers.get(i);
			if (node instanceof Class) {
				Class clazz = (Class) node;
				if (clazz.isInstance(h)) {
					hardwareMembership = true;
					break;
				}
			} else {
				if (node.equals(h)) {
					hardwareMembership = true;
					break;
				}
			}
		}

		int softSize = members.size();
		for (int i = 0; i < softSize; i++) {
			Object node = members.get(i);
			if (node instanceof Class) {
				Class clazz = (Class) node;
				if (clazz.isInstance(s)) {
					softwareMembership = true;
					break;
				}
			} else {
				if (node.equals(s)) {
					softwareMembership = true;
					break;
				}
			}
		}

		return (hardwareMembership && softwareMembership);
	}

	public Object clone() {
		SetConstraint c = new SetConstraint();

		c.members = (Vector) members.clone();
		c.hardwareMembers = (Vector) hardwareMembers.clone();
		return c;
	}
}