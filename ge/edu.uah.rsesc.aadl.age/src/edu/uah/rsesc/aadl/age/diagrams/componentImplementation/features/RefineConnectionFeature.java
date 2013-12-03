package edu.uah.rsesc.aadl.age.diagrams.componentImplementation.features;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.componentImplementation.patterns.ConnectionPattern;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ShapeService;

public class RefineConnectionFeature extends AbstractCustomFeature {
	private final AadlModificationService aadlModService;
	private final ShapeService shapeService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public RefineConnectionFeature(final AadlModificationService aadlModService, final ShapeService shapeService, final BusinessObjectResolutionService bor, final IFeatureProvider fp) {
		super(fp);
		this.aadlModService = aadlModService;
		this.shapeService = shapeService;
		this.bor = bor;
	}

	@Override
    public String getName() {
        return "Refine";
    }
	
	@Override
	public boolean canUndo(final IContext context) {
		return false;
	}
	
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		final PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length < 1 || !(customCtx.getPictogramElements()[0] instanceof Connection)) {
			return false;
		}
		
		// Check that the shape represents a subcomponent and that the subcomponent is not owned by the classifier represented by the shape's container
		final Connection connection = (Connection)pes[0];		
		final Object bo = bor.getBusinessObjectForPictogramElement(connection);
		final ComponentImplementation ci = getComponentImplementation(connection);
		return bo instanceof org.osate.aadl2.Connection && ci != null && ((org.osate.aadl2.Connection)bo).getContainingClassifier() != ci;
	}
    
    @Override
    public boolean canExecute(final ICustomContext context) {
    	return true;
    }
        
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Connection connection) {
		final AnchorContainer startContainer = connection.getStart().getParent();
		if(!(startContainer instanceof Shape)) {
			return null;
		}
		
		return shapeService.getClosestBusinessObjectOfType((Shape)startContainer, ComponentImplementation.class);
	}
	
	@Override
	public void execute(final ICustomContext context) {
		final Connection connection = (Connection)context.getPictogramElements()[0];
		final org.osate.aadl2.Connection aadlConnection = (org.osate.aadl2.Connection)bor.getBusinessObjectForPictogramElement(connection);
		final ComponentImplementation containerComponentImplementation = getComponentImplementation(connection);
		
		// Set the classifier
		aadlModService.modify(aadlConnection, new AbstractModifier<org.osate.aadl2.Connection, org.osate.aadl2.Connection>() {
			@Override
			public org.osate.aadl2.Connection modify(final Resource resource, final org.osate.aadl2.Connection aadlConnection) {
				final org.osate.aadl2.Connection newAadlConnection = ConnectionPattern.createConnection(containerComponentImplementation, aadlConnection.eClass());
				if(newAadlConnection != null) {
					newAadlConnection.setRefined(aadlConnection);
				}

				return newAadlConnection;
			}			
			
			@Override
			public void beforeCommit(final Resource resource, final org.osate.aadl2.Connection aadlConnection, final org.osate.aadl2.Connection newAadlConnection) {
				// Relink the connection
				getFeatureProvider().link(connection, new AadlElementWrapper(newAadlConnection));
			}
		});
	}	
}
