package edu.uah.rsesc.aadl.age.diagrams.common;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.osate.aadl2.Generalization;

import edu.uah.rsesc.aadl.age.diagrams.common.features.DrillDownFeature;

public class AgeDiagramTypeProvider extends AbstractDiagramTypeProvider {
	
	@Override
	public boolean isAutoUpdateAtStartup() {
		return true;
	}	
	
	// Tool behaviors are provided to modify the business object equality check. This is needed in the case of Generalization because the owner is one of the defining
	// characteristics and is not checked by the default check which uses EcoreUtil.equals().
	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders = new IToolBehaviorProvider[] { new DefaultToolBehaviorProvider(this) {
            	@Override
				public boolean equalsBusinessObjects(final Object o1, final Object o2) {            	
            		if(o1 instanceof Generalization) {
            			return o1.equals(o2);
            		} 
            		return super.equalsBusinessObjects(o1, o2);
            	}
            	
            	@Override
            	public ICustomFeature getDoubleClickFeature(final IDoubleClickContext context) {
            	    final ICustomFeature customFeature = new DrillDownFeature(getFeatureProvider());
            	    if(customFeature.canExecute(context)) {
            	        return customFeature;
            	    }
            	 
            	    return super.getDoubleClickFeature(context);
            	 }
            	
            	/**
            	 * Override of getSelection that checks the shape and containers and returns the first shape with a business object. Allows using active objects without them being
            	 * selectable.
            	 */
            	@Override
            	public PictogramElement getSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {
            		if(originalPe instanceof Shape) {
            			// Return the first shape that has a business object
            			Shape shape = (Shape)originalPe;
            			while(this.getFeatureProvider().getBusinessObjectForPictogramElement(shape) == null && shape != null) {
            				shape = shape.getContainer();
            			}

            			return shape;
            		}
					return null;
            	}
            }};
        }
        return toolBehaviorProviders;
    }
}
