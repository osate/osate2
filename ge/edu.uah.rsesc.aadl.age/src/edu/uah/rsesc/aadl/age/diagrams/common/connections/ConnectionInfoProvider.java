package edu.uah.rsesc.aadl.age.diagrams.common.connections;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * Should not be implemented. Implement AbstractConnectionInfoProvider instead
 * @author philip.alldredge
 *
 */
public interface ConnectionInfoProvider {	
	/**
	 * Returns whether or not the connection info provider applies to connections with the specified business object
	 * @param bo
	 * @return
	 */
	boolean isBusinessObjectApplicable(final Object bo);
	
	/**
	 * Returns the "owner" shape. That is, the shape that is responsible for updating the connection. Should be the same class that created the connection.
	 * @param connection a fully created connection. It must have a business object associated with it and anchors should be set
	 * @return
	 */
	ContainerShape getOwnerShape(final Connection connection);

	/**
	 * Returns the anchors for the connection based on the specified owner shape
	 * @param ownerShape
	 * @param bo
	 * @return an array containing the anchors or null if both anchors could not be found. The first element should be the start anchor and the second should be the end anchor.
	 */
	Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo);
}
