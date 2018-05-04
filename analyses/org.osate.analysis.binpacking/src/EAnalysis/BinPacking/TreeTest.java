package EAnalysis.BinPacking;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeTest {
	public static void main(String args[]) {
		Comparator comparator = new BandwidthComparator();
		TreeSet s = new TreeSet(comparator);
		TreeMap m = new TreeMap(comparator);
		SoftwareNode nF = new SoftwareNode(25, 100000, 100000, comparator, "F");
		SoftwareNode nG = new SoftwareNode(25, 100000, 100000, comparator, "G");
		SoftwareNode nH = new SoftwareNode(25, 100000, 100000, comparator, "F");
		SoftwareNode nI = new SoftwareNode(25, 100000, 100000, comparator, "G");
		SoftwareNode nJ = new SoftwareNode(25, 100000, 100000, comparator, "F");
		SoftwareNode nK = new SoftwareNode(25, 100000, 100000, comparator, "G");
		s.add(nG);
		s.add(nF);
		s.add(nH);
		s.add(nI);
		s.add(nJ);
		s.add(nK);
		m.put(nG, nF);
		m.put(nH, nG);
		m.put(nI, nH);
		m.put(nJ, nI);
		m.put(nK, nJ);
		System.out.println("s(" + s + ") s.contains(nG) = " + s.contains(nG));
		System.out.println("s(" + s + ") s.contains(nH) = " + s.contains(nH));
		System.out.println("s(" + s + ") s.contains(nI) = " + s.contains(nI));
		System.out.println("s(" + s + ") s.contains(nJ) = " + s.contains(nJ));
		System.out.println("m(" + m + ") m.get(nG) = " + m.get(nG));
		System.out.println("m(" + m + ") m.get(nH) = " + m.get(nH));
		System.out.println("m(" + m + ") m.get(nI) = " + m.get(nI));
		System.out.println("m(" + m + ") m.get(nJ) = " + m.get(nJ));
		TreeSet cs = (TreeSet) s.clone();
		TreeMap cm = (TreeMap) m.clone();

		System.out.println("cs(" + cs + ") cs.contains(nG) = " + cs.contains(nG));
		System.out.println("cs(" + cs + ") cs.contains(nH) = " + cs.contains(nH));
		System.out.println("cs(" + cs + ") cs.contains(nI) = " + cs.contains(nI));
		System.out.println("cs(" + cs + ") cs.contains(nJ) = " + cs.contains(nJ));

		System.out.println("\n\n");

		System.out.println("cs.remove(" + nJ + ") = " + cs.remove(nJ));
		System.out.println("cs.remove(" + nI + ") = " + cs.remove(nI));
		System.out.println("cs.remove(" + nH + ") = " + cs.remove(nH));
		System.out.println("cs.remove(" + nG + ") = " + cs.remove(nG));

		System.out.println("cm(" + cm + ") cm.get(nG) = " + cm.get(nG));
		System.out.println("cm(" + cm + ") cm.get(nH) = " + cm.get(nH));
		System.out.println("cm(" + cm + ") cm.get(nI) = " + cm.get(nI));
		System.out.println("cm(" + cm + ") cm.get(nJ) = " + cm.get(nJ));

	}
}