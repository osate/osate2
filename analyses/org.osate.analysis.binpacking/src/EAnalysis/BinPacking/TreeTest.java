/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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