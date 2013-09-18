package edu.uah.rsesc.aadl.age.services;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

/**
 * Contains methods for working with Graphiti connections
 * @author philip.alldredge
 *
 */
public interface ConnectionService {

	Connection getConnection(ContainerShape ownerShape, Object bo);

	Anchor[] getAnchors(ContainerShape ownerShape, Object bo);

	ContainerShape getOwnerShape(Connection connection);
}