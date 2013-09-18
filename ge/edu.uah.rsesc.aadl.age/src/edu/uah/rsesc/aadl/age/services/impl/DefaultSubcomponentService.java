package edu.uah.rsesc.aadl.age.services.impl;

import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;

import edu.uah.rsesc.aadl.age.services.PrototypeService;
import edu.uah.rsesc.aadl.age.services.SubcomponentService;

public class DefaultSubcomponentService implements SubcomponentService {
	private final PrototypeService prototypeService;
	
	public DefaultSubcomponentService(final PrototypeService prototypeService) {
		this.prototypeService = prototypeService;
	}
	
	@Override
	public ComponentClassifier getComponentClassifier(final Shape shape, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			return sc.getClassifier();
		} else {
			final Element bindingContext = prototypeService.getPrototypeBindingContext(shape);
			if(bindingContext != null) {
				final ComponentClassifier cc = ResolvePrototypeUtil.resolveComponentPrototype(sc.getPrototype(), bindingContext);
				if(cc != null) {
					return cc;
				}

				return sc.getPrototype().getConstrainingClassifier();
			}			
		}

		return null;
	}	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#getComponentCategory(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public ComponentCategory getComponentCategory(final Shape shape, final Subcomponent sc) {
		final ComponentClassifier c = getComponentClassifier(shape, sc);
		return c == null ? sc.getCategory() : c.getCategory();
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierService#isImplementation(org.eclipse.graphiti.mm.pictograms.Shape, org.osate.aadl2.Subcomponent)
	 */
	@Override
	public boolean isImplementation(final Shape shape, final Subcomponent sc) {
		final ComponentClassifier c = getComponentClassifier(shape, sc);
		return c == null ? false : c instanceof ComponentImplementation;
	}
}
