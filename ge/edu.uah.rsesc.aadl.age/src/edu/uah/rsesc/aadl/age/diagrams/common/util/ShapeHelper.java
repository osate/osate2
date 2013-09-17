package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;

public class ShapeHelper {
	/**
	 * Gets a child shape tied to a particular element. Delegates to comparison by element name because there are scenarios where names can be duplicated. For example
	 * an invalid model during copy and paste operations.
	 * @param shape
	 * @param el
	 * @param fp
	 * @return
	 */
	public static ContainerShape getChildShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el, final BusinessObjectResolver bor) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && ElementHelper.areQualifiedNamesEqual((NamedElement)bo, el)) {
				return (ContainerShape)c;
			}
		}
		return null;
	}
	
	// REMOVE-ME when no longer needed
	public static ContainerShape getChildShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el, final IFeatureProvider fp) {
		for(final Shape c : shape.getChildren()) {
			Object bo = AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(c));
			if(bo instanceof NamedElement && ElementHelper.areQualifiedNamesEqual((NamedElement)bo, el)) {
				return (ContainerShape)c;
			}
		}
		return null;
	}
	
	public static ContainerShape getChildShapeByElementName(final ContainerShape shape, final NamedElement el, final BusinessObjectResolver bor) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && ElementHelper.areNamesEqual((NamedElement)bo, el)) {
				return (ContainerShape)c;
			}
		}
		return null;
	}
	
	/**
	 * Gets a descendant shape that is linked to a particular AADL element. Does not look at children if the child shape is associated with another object.
	 * @param shape
	 * @param bo
	 * @param bor
	 * @return
	 */	
	public static ContainerShape getDescendantShapeByElement(final ContainerShape shape, final Element el, final BusinessObjectResolver bor) {
		for(final Shape c : shape.getChildren()) {
			final Object linkedBo = bor.getBusinessObjectForPictogramElement(c);
			if(linkedBo == el) {
				return (ContainerShape)c;
			} else if(linkedBo == null && c instanceof ContainerShape) {
				return getDescendantShapeByElement((ContainerShape)c, el, bor);
			}
		}
		
		return null;
	}

	public static Shape getChildShapeByName(final ContainerShape shape, final String name) {
		for(final Shape child : VisibilityHelper.getNonGhostChildren(shape)) {
			if(name.equals(PropertyUtil.getName(child))) {
				return child;
			}
		}
		
		return null;
	}
	
	/**
	 * Determines whether s1 contains s2
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean doesShapeContain(final Shape s1, final Shape s2) {
		Shape temp = s2.getContainer();
		while(temp != null) {
			if(temp == s1) {
				return true;
			}
			
			temp = temp.getContainer();
		}
		return false;
	}
}
