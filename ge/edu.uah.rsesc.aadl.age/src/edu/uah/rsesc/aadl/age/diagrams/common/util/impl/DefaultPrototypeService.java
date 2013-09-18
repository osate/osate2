package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.ResolvePrototypeUtil;

import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PrototypeService;

public class DefaultPrototypeService implements PrototypeService {
	private BusinessObjectResolver bor;
	
	public DefaultPrototypeService(final BusinessObjectResolver bor) {
		this.bor = bor;
	}

	@Override
	public Element getPrototypeBindingContext(final Shape shape) {
		ContainerShape temp = shape.getContainer();
		
		while(temp != null) {
			Object bo = bor.getBusinessObjectForPictogramElement(temp);
			if(bo instanceof ComponentClassifier || bo instanceof FeatureGroupType) {
				return (Classifier)bo;
			} else if(bo instanceof Subcomponent) {
				return (Subcomponent)bo;
			} else if(bo instanceof FeatureGroup){
				return getFeatureGroupTypeOrActual(temp.getContainer(), (FeatureGroup)bo);
			}

			temp = temp.getContainer();
		}
		return null;
	}
	
	/**
	 * Returns either the feature group type or the actual prototype
	 * @param shape
	 * @param fg
	 * @param fp
	 * @return
	 */
	// TODO: Define what shape is supposed to be
	private Element getFeatureGroupTypeOrActual(final Shape shape, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(shape);
			if(bindingContext != null) {
				return resolveFeatureGroupPrototypeToActual(fg.getFeatureGroupPrototype(), bindingContext);
			} else {
				return null;
			}
		}
	}

	private FeatureGroupPrototypeActual resolveFeatureGroupPrototypeToActual(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding)ResolvePrototypeUtil.resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		
		return fgpb.getActual();
	}
}
