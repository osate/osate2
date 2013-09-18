package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.List;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Element;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.AadlConnectionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.ConnectionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.FlowSpecificationInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.GeneralizationInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.connections.ModeTransitionInfoProvider;
import edu.uah.rsesc.aadl.age.diagrams.common.util.AnchorService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ShapeService;

//TODO:Split class so that one will be the utility class and one will be the delegate to the extensions
public class DefaultConnectionService implements ConnectionService {	
	private final ConnectionInfoProvider[] infoProviders;
	private final BusinessObjectResolutionService bor;
	private final IFeatureProvider fp;
	
	public DefaultConnectionService(final AnchorService anchorUtil, final ShapeService shapeHelper, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		this.bor = bor;
		this.fp = fp;
		
		// TODO: Use extension point or something
		final Diagram diagram = getDiagram();
		infoProviders = new ConnectionInfoProvider[] {
				new AadlConnectionInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new FlowSpecificationInfoProvider(bor, diagram, anchorUtil, shapeHelper),
				new GeneralizationInfoProvider(bor, diagram, shapeHelper),
				new ModeTransitionInfoProvider(bor, diagram, anchorUtil, shapeHelper)
		};
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#getConnection(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Connection getConnection(final ContainerShape ownerShape, final Object bo) {
		// Get the diagram
		final Diagram diagram = getDiagram();
		
		// Find all connections that match the anchors
		for(final Connection c : diagram.getConnections()) {
			if(getOwnerShape(c) == ownerShape && bor.getBusinessObjectForPictogramElement(c) == bo) {
				return c;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#getAnchors(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.lang.Object)
	 */
	@Override
	public Anchor[] getAnchors(final ContainerShape ownerShape, final Object bo) {
		final ConnectionInfoProvider p = getInfoProvider(bo);
		if(p != null) {
			return p.getAnchors(ownerShape, bo);
		}

		return null;
	}	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#getOwnerShape(org.eclipse.graphiti.mm.pictograms.Connection)
	 */
	@Override
	public ContainerShape getOwnerShape(final Connection connection) {
		final ConnectionInfoProvider p = getInfoProvider(bor.getBusinessObjectForPictogramElement(connection));
		if(p != null) {
			return p.getOwnerShape(connection);
		}
		
		return null;
	}
	
	// CLEAN-UP: Consider moving to another helper/utility class
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#createUpdateConnections(org.eclipse.graphiti.mm.pictograms.ContainerShape, java.util.List)
	 */
	@Override
	public void createUpdateConnections(final ContainerShape ownerShape, final List<? extends Element> elements) {
		for(final Element el : elements) {
			createUpdateConnection(ownerShape, el);
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService#createUpdateConnection(org.eclipse.graphiti.mm.pictograms.ContainerShape, org.osate.aadl2.Element)
	 */
	@Override
	public void createUpdateConnection(final ContainerShape ownerShape, final Element el) {
		final PictogramElement pictogramElement = getConnection(ownerShape, el);
		if(pictogramElement == null) {			
			final Anchor[] anchors = getAnchors(ownerShape, el);
			if(anchors != null) {
				final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
				addContext.setNewObject(new AadlElementWrapper(el));
				addContext.setTargetContainer(ownerShape);
				
				final IAddFeature addFeature = fp.getAddFeature(addContext);
				if(addFeature != null && addFeature.canAdd(addContext)) {
					addFeature.add(addContext);
				}
			}
		} else {
			final UpdateContext updateContext = new UpdateContext(pictogramElement);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Update the connection regardless of whether it is "needed" or not.
			if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
			}
		}
	}	
	
	private ConnectionInfoProvider getInfoProvider(final Object bo) {
		for(final ConnectionInfoProvider p : infoProviders) {
			if(p.isBusinessObjectApplicable(bo)) {
				return p;
			}
		}
		
		return null;
	}
	
	private Diagram getDiagram() {
		return fp.getDiagramTypeProvider().getDiagram();
	}
}
