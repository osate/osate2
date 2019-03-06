package com.rockwellcollins.atc.resolute.analysis.execution;

import java.util.Comparator;

import org.osate.aadl2.NamedElement;

import com.rockwellcollins.atc.resolute.analysis.values.NamedElementValue;

public class NamedElementComparator implements Comparator<NamedElement> {
	@Override
	public int compare(NamedElement arg0, NamedElement arg1) {
		if (arg0 == arg1) {
			return 0;
		}

		String text0 = new NamedElementValue(arg0).toString();
		String text1 = new NamedElementValue(arg1).toString();
		int r = text0.compareToIgnoreCase(text1);
		if (r != 0) {
			return r;
		}

		r = Integer.compare(arg0.hashCode(), arg1.hashCode());
		if (r == 0) {
			throw new IllegalArgumentException("Unable to order distinct objects via hashcode");
		}
		return r;
	}
}
