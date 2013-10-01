package edu.uah.rsesc.aadl.age.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.aadl2.Element;

/**
 * Contains methods for creating Graphiti connections
 * @author philip.alldredge
 *
 */
public interface ConnectionCreationService {
	void createUpdateConnections(ContainerShape ownerShape,	List<? extends Element> elements);

	Connection createUpdateConnection(ContainerShape ownerShape, Element el);
}
