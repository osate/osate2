package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ElementService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

public class DefaultShapeService implements ShapeService {
	private final ElementService elementHelper;
	private final PropertyService propertyUtil;
	private final VisibilityService visibilityHelper;
	private final BusinessObjectResolver bor;
	
	public DefaultShapeService(final ElementService elementHelper, final PropertyService propertyUtil, final VisibilityService visibilityHelper, final BusinessObjectResolver bor) {
		this.elementHelper = elementHelper;
		this.propertyUtil = propertyUtil;
		this.visibilityHelper = visibilityHelper;
		this.bor = bor;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getChildShapeByElementQualifiedName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */
	@Override
	public ContainerShape getChildShapeByElementQualifiedName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && elementHelper.areQualifiedNamesEqual((NamedElement)bo, el)) {
				return (ContainerShape)c;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getChildShapeByElementName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */
	@Override
	public ContainerShape getChildShapeByElementName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			Object bo = bor.getBusinessObjectForPictogramElement(c);
			if(bo instanceof NamedElement && elementHelper.areNamesEqual((NamedElement)bo, el)) {
				return (ContainerShape)c;
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getDescendantShapeByElement(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.Element)
	 */	
	@Override
	public ContainerShape getDescendantShapeByElement(final ContainerShape shape, final Element el) {
		for(final Shape c : shape.getChildren()) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(c);
			if(childBo == el) {
				return (ContainerShape)c;
			} else if(childBo == null && c instanceof ContainerShape) {
				return getDescendantShapeByElement((ContainerShape)c, el);
			}
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService#getDescendantShapeByElementName(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.NamedElement)
	 */	
	@Override
	public ContainerShape getDescendantShapeByElementName(final ContainerShape shape, final NamedElement el) {
		for(final Shape c : shape.getChildren()) {
			final Object childBo = bor.getBusinessObjectForPictogramElement(c);			
			if(childBo instanceof NamedElement && elementHelper.areNamesEqual((NamedElement)childBo, el)) {
				return (ContainerShape)c;
			} else if(childBo == null && c instanceof ContainerShape) {
				return getDescendantShapeByElement((ContainerShape)c, el);
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
}
