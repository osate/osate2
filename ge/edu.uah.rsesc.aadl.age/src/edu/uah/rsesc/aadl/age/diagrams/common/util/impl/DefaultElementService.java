package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.List;

import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.util.ElementService;

/**
 * Contains miscellaneous methods for dealing with AADL elements/named elements
 * @author philip.alldredge
 *
 */
public class DefaultElementService implements ElementService {
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ElementService#listContainsElementWithName(java.util.List, java.lang.String)
	 */
	@Override
	public boolean listContainsElementWithName(final List<? extends NamedElement> elements, final String name) {
		for(final NamedElement el : elements) {
			if(name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ElementService#areNamesEqual(org.osate.aadl2.NamedElement, org.osate.aadl2.NamedElement)
	 */
	@Override
	public boolean areNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getName() == null || e2 == null || e2.getName() == null)
			return false;

		return e1.getName().equalsIgnoreCase(e2.getName());
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ElementService#areQualifiedNamesEqual(org.osate.aadl2.NamedElement, org.osate.aadl2.NamedElement)
	 */
	@Override
	public boolean areQualifiedNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getQualifiedName() == null || e2 == null || e2.getQualifiedName() == null)
			return false;

		return e1.getQualifiedName().equalsIgnoreCase(e2.getQualifiedName());
	}
}
