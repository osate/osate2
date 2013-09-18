package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.aadl2.Element;

public interface ConnectionService {

	Connection getConnection(ContainerShape ownerShape, Object bo);

	Anchor[] getAnchors(ContainerShape ownerShape, Object bo);

	ContainerShape getOwnerShape(Connection connection);

	// CLEAN-UP: Consider moving to another helper/utility class
	void createUpdateConnections(ContainerShape ownerShape,
			List<? extends Element> elements);

	void createUpdateConnection(ContainerShape ownerShape, Element el);

}