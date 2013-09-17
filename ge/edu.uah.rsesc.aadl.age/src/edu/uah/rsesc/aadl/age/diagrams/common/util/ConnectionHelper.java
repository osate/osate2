package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.AadlConnectionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.ConnectionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.FlowSpecificationInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.GeneralizationInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.ModeTransitionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.mapping.BusinessObjectResolver;
import edu.uah.rsesc.aadl.age.diagrams.common.mapping.DefaultBusinessObjectResolver;

//TODO: This class should have instance methods and be driven by an extension point or similar mechanism.
public class ConnectionHelper {	
	public static Connection getConnection(final ContainerShape ownerShape, final Object bo, final IFeatureProvider fp) {
		// Get the diagram
		final Diagram diagram = getDiagram(ownerShape);
		
		// Find all connections that match the anchors
		for(final Connection c : diagram.getConnections()) {
			if(getOwnerShape(c, fp) == ownerShape && AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(c)) == bo) {
				return c;
			}
		}
		
		return null;
	}

	public static Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo, final IFeatureProvider fp) {
		final ConnectionInfoProvider p = getInfoProvider(bo, fp);
		if(p != null) {
			return p.getAnchors(ownerShape, bo);
		}

		return null;
	}	
	
	public static ContainerShape getOwnerShape(final Connection connection, final IFeatureProvider fp) {
		final ConnectionInfoProvider p = getInfoProvider(AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(connection)), fp);
		if(p != null) {
			return p.getOwnerShape(connection);
		}
		
		return null;
	}
	
	private static ConnectionInfoProvider getInfoProvider(final Object bo, final IFeatureProvider fp) {
		final BusinessObjectResolver bor = new DefaultBusinessObjectResolver(fp);
		final Diagram diagram = fp.getDiagramTypeProvider().getDiagram();
		final ConnectionInfoProvider[] infoProviders = new ConnectionInfoProvider[] {
				new AadlConnectionInfoProvider(bor, diagram),
				new FlowSpecificationInfoProvider(bor, diagram),
				new GeneralizationInfoProvider(bor, diagram),
				new ModeTransitionInfoProvider(bor, diagram)
		};
		
		for(final ConnectionInfoProvider p : infoProviders) {
			if(p.isBusinessObjectApplicable(bo)) {
				return p;
			}
		}
		
		return null;
	}
	
	
	// TODO: In the future, the object will have a reference to the diagram...
	private static Diagram getDiagram(Shape shape) {
		while(shape != null) {
			if(shape instanceof Diagram) {
				return (Diagram)shape;
			}
			shape = shape.getContainer();
		}
		
		return null;
	}
	
}
