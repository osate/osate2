package org.osate.ge.internal.util;

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
import org.osate.ge.BusinessObjectContext;

public class AadlPrototypeUtil {
	public static ComponentClassifier getComponentClassifier(final Element bindingContext, final Subcomponent sc) {
		if(sc.getPrototype() == null) {
			return sc.getClassifier();
		} else {
			if(bindingContext == null) {
				return null;
			}
			
			final ComponentClassifier cc = ResolvePrototypeUtil.resolveComponentPrototype(sc.getPrototype(), bindingContext);
			if(cc != null) {
				return cc;
			}

			return sc.getPrototype().getConstrainingClassifier();	
		}
	}

	public static FeatureGroupType getFeatureGroupType(final Element bindingContext, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			if(bindingContext != null) {
				final FeatureGroupType fgt = ResolvePrototypeUtil.resolveFeatureGroupPrototype(fg.getFeatureGroupPrototype(), bindingContext);
				if(fgt != null) {
					return fgt;
				}
				return fg.getFeatureGroupPrototype().getConstrainingFeatureGroupType();
			}			
		}

		return null;
	}
	
	public static Element getPrototypeBindingContext(final BusinessObjectContext boContext) {
		final BusinessObjectContext container = boContext.getParent();
		if(container != null) {
			return getPrototypeBindingContextByContainer(container);
		}		
					
		return null;
	}
	
	public static Element getPrototypeBindingContextByContainer(final BusinessObjectContext boContext) {
		BusinessObjectContext temp = boContext;
		
		while(temp != null) {
			Object bo = temp.getBusinessObject();
			if(bo instanceof ComponentClassifier || bo instanceof FeatureGroupType) {
				return (Classifier)bo;
			} else if(bo instanceof Subcomponent) {
				return (Subcomponent)bo;
			} else if(bo instanceof FeatureGroup){
				if(temp.getParent() != null) {
					return getFeatureGroupTypeOrActual(temp.getParent(), (FeatureGroup)bo);	
				}
				return null;
			}

			temp = temp.getParent();
		}
		return null;
	}
	
	/**
	 * Returns either the feature group type or the actual prototype
	 * @param 
	 * @param fg
	 * @param fp
	 * @return
	 */
	private static Element getFeatureGroupTypeOrActual(final BusinessObjectContext boContext, final FeatureGroup fg) {
		if(fg.getFeatureGroupPrototype() == null) {
			return fg.getAllFeatureGroupType();
		} else {
			final Element bindingContext = getPrototypeBindingContext(boContext);
			if(bindingContext != null) {
				return resolveFeatureGroupPrototypeToActual(fg.getFeatureGroupPrototype(), bindingContext);
			} else {
				return null;
			}
		}
	}
	
	private static FeatureGroupPrototypeActual resolveFeatureGroupPrototypeToActual(Prototype proto, Element context) {
		FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding)ResolvePrototypeUtil.resolvePrototype(proto, context);

		if (fgpb == null) {
			// cannot resolve
			return null;
		}
		
		return fgpb.getActual();
	}
}
