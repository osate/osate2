package edu.uah.rsesc.aadl.age.diagrams.common.connections;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public abstract class AbstractConnectionInfoProvider implements ConnectionInfoProvider {
	private final BusinessObjectResolutionService bor;
	private final Diagram diagram;
	
	public AbstractConnectionInfoProvider(final BusinessObjectResolutionService bor, final Diagram diagram) {
		this.bor = bor;
		this.diagram = diagram;
	}

	protected final Object getBusinessObject(final Connection connection) {
		return this.getBusinessObjectResolver().getBusinessObjectForPictogramElement(connection);
	}

	protected final BusinessObjectResolutionService getBusinessObjectResolver() {
		return this.bor;
	}
	
	/**
	 * Returns all connections in the diagram
	 * @return
	 */
	protected final List<Connection> getConnections() {
		return this.diagram.getConnections();
	}
}
