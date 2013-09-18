package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.List;

import org.osate.aadl2.NamedElement;

public interface ElementService {

	boolean listContainsElementWithName(List<? extends NamedElement> elements,
			String name);

	boolean areNamesEqual(NamedElement e1, NamedElement e2);

	boolean areQualifiedNamesEqual(NamedElement e1, NamedElement e2);

}