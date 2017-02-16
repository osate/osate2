package org.osate.ge.internal.graphiti.features;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.query.PictogramQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootPictogramQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;
import org.osate.ge.internal.services.PropertyService;

public class SelectAncestorFeature extends AbstractCustomFeature {
	private final QueryRunner queryRunner;
	private final PictogramQuery<Object> query = new RootPictogramQuery(() -> this.rootPictogramElement).ancestor(1);
	private PictogramElement rootPictogramElement;
	
	@Inject
	public SelectAncestorFeature(final IFeatureProvider fp, final PropertyService propertyService, final ConnectionService connectionService, final BusinessObjectResolutionService bor, final InternalReferenceBuilderService refBuilder)  {
		super(fp);
		queryRunner = new QueryRunner(propertyService, connectionService, bor, refBuilder);
	}

	@Override
    public String getName() {
        return "Select Container";
    }
 
    @Override
    public String getDescription() {
        return "Selects a diagram element's container.";
    }
 
    @Override
	public boolean isAvailable(final IContext context) {
    	// Make the command available if the selection is a shape and has at least one logical parent
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();		
		if(customCtx.getPictogramElements().length != 1) {
			return false;
		}
		
		rootPictogramElement = pes[0];
		return queryRunner.getFirstPictogramElement(query, null) != null;
	}
   
    @Override
    public boolean canExecute(final ICustomContext context) {
		return true;
    }
    
	@Override
	public void execute(final ICustomContext context) {
		// Select the first logic parent
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();		

		rootPictogramElement = pes[0];
		final PictogramElement ancestor = queryRunner.getFirstPictogramElement(query, null);
		if(ancestor != null) {
			getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[]{ancestor});			
		}
	}

}
