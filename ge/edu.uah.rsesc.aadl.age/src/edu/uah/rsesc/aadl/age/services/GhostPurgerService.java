package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.pictograms.Diagram;

/**
 * Service for purging ghosts. Not part of the visibility service due to needing to be used by the Diagram Editor with minimal dependencies.
 * Not intended by use outside the core framework at this time. Not injected into patterns and services.
 * @author philip.alldredge
 *
 */
public interface GhostPurgerService {
	/**
	 * Finds and removes all ghosts from the diagram
	 */
	void purgeGhosts(Diagram diagram);
}
