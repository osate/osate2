package edu.uah.rsesc.aadl.age.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import edu.uah.rsesc.aadl.age.services.GhostPurgerService;
import edu.uah.rsesc.aadl.age.services.PropertyService;

public class DefaultGhostPurgerService implements GhostPurgerService {
	private final PropertyService propertyService;
	
	public DefaultGhostPurgerService(final PropertyService propertyService) {
		this.propertyService = propertyService;
	}
	
	@Override
	public void purgeGhosts(final Diagram diagram) {
		final List<PictogramElement> ghosts = new ArrayList<PictogramElement>();
		// Find all ghost connections
		for(final Connection connection : diagram.getConnections()) {
			if(propertyService.isGhost(connection)) {
				ghosts.add(connection);
			}
		}
		
		// Find all ghost shapes
		findGhostShapes(diagram, ghosts);
		
		for(final PictogramElement pe : ghosts) {
			EcoreUtil.delete(pe, true);
		}
	}

	/**
	 * Returns all shapes that are ghosts. Ghosts are shapes that have been hidden because their linked business object is no longer valid.
	 * Does not include ghosts that are children of ghosts.
	 * @param shape
	 * @param ghostShapes
	 */
	private void findGhostShapes(final Shape shape, final List<PictogramElement> ghostShapes) {
		if(propertyService.isGhost(shape)) {
			ghostShapes.add(shape);
		} else {
			if(shape instanceof ContainerShape) {
				for(final Shape child : ((ContainerShape)shape).getChildren()) {
					findGhostShapes(child, ghostShapes);
				}
			}
		}
	}
}
