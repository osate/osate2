package edu.uah.rsesc.aadl.age.services.impl;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.ShapeService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;

public class DefaultShapeService implements ShapeService {
	private final PropertyService propertyUtil;
	private final VisibilityService visibilityHelper;
	private final BusinessObjectResolutionService bor;
	
	public DefaultShapeService(final PropertyService propertyUtil, final VisibilityService visibilityHelper, final BusinessObjectResolutionService bor) {
		this.propertyUtil = propertyUtil;
		this.visibilityHelper = visibilityHelper;
		this.bor = bor;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getChildShapeByElementQualifiedName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */
	@Override
	public Shape getChildShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && areQualifiedNamesEqual((NamedElement)bo, el)) {
				return c;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getChildShapeByElementName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */
	@Override
	public Shape getChildShapeByElementName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && areNamesEqual((NamedElement)bo, el)) {
				return c;
			}
		}
		return null;
	}
		
	@Override
	public Shape getDescendantShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(c);			
			if(childBo instanceof NamedElement && areQualifiedNamesEqual((NamedElement)childBo, el)) {
				return c;
			} else if(childBo == null && c instanceof ContainerShape) {
				final Shape recResult = getDescendantShapeByElementQualifiedName((ContainerShape)c, el);
				if(recResult != null) {
					return recResult;
				}
			}
		}

		return null;
	}	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getDescendantShapeByElementName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */	
	@Override
	public Shape getDescendantShapeByElementName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(c);			
			if(childBo instanceof NamedElement && areNamesEqual((NamedElement)childBo, el)) {
				return c;
			} else if(childBo == null && c instanceof ContainerShape) {
				final Shape recResult = getDescendantShapeByElementName((ContainerShape)c, el);
				if(recResult != null) {
					return recResult;
				}
			}
		}
		
		return null;
	}	

	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getChildShapeByName(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.String)
	 */
	@Override
	public Shape getChildShapeByName(final ContainerShape shape, final String name) {
		for(final Shape child : visibilityHelper.getNonGhostChildren(shape)) {
			if(name.equals(propertyUtil.getName(child))) {
				return child;
			}
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#doesShapeContain(org.eclipse.graphiti.mm.pictograms.Shape, org.eclipse.graphiti.mm.pictograms.Shape)
	 */
	@Override
	public boolean doesShapeContain(final Shape s1, final Shape s2) {
		Shape temp = s2.getContainer();
		while(temp != null) {
			if(temp == s1) {
				return true;
			}
			
			temp = temp.getContainer();
		}
		return false;
	}
	
	private boolean areNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getName() == null || e2 == null || e2.getName() == null)
			return false;

		return e1.getName().equalsIgnoreCase(e2.getName());
	}
	
	private boolean areQualifiedNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getQualifiedName() == null || e2 == null || e2.getQualifiedName() == null)
			return false;

		return e1.getQualifiedName().equalsIgnoreCase(e2.getQualifiedName());
	}
}
