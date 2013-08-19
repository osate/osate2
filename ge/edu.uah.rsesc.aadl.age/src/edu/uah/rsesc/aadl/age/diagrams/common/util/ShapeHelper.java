package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class ShapeHelper {
	public static ContainerShape getChildShapeByElement(final ContainerShape shape, final Element el, final IFeatureProvider fp) {
		for(final Shape c : shape.getChildren()) {
			if(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(c)) == el) {
				return (ContainerShape)c;
			}
		}
		
		return null;
	}
	
	/**
	 * Gets a descendant shape that is linked to a particular AADL element. Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param bo
	 * @param fp
	 * @return
	 */
	public static ContainerShape getDescendantShapeByElement(final ContainerShape shape, final Element el, final IFeatureProvider fp) {
		for(final Shape c : shape.getChildren()) {
			final Object linkedBo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(c));
			if(linkedBo == el) {
				return (ContainerShape)c;
			} else if(linkedBo == null && c instanceof ContainerShape) {
				return getDescendantShapeByElement((ContainerShape)c, el, fp);
			}
		}
		
		return null;
	}
	
	public static Shape getChildShapeByName(final ContainerShape shape, final String name) {
		for(final Shape child : shape.getChildren()) {
			if(name.equals(PropertyUtil.getName(child))) {
				return child;
			}
		}
		
		return null;
	}
}
