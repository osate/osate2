package edu.uah.rsesc.aadl.age.diagrams.common.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ClassifierHelper;
import edu.uah.rsesc.aadl.age.ui.util.DiagramOpener;

/**
 * Drill down feature. Does not inherit from AbstractDrillDownFeature because it will create diagrams if needed.
 * @author philip.alldredge
 *
 */
public class DrillDownFeature extends AbstractCustomFeature {
	public DrillDownFeature(final IFeatureProvider fp) {
		super(fp);
	}

	@Override
    public String getName() {
        return "Open associated diagram";
    }
 
    @Override
    public String getDescription() {
        return "Open the diagram associated with this model element";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1 && !(pes[0] instanceof Diagram)) {
            Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pes[0]));
            if(bo instanceof Package || bo instanceof Classifier) {
                return true;
            }
            
            if(getSubcomponentClassifier(pes[0], bo) != null) {
            	return true;
            }
        }
        return false;
    }

    @Override
	public void execute(final ICustomContext context) {
		if(context.getPictogramElements().length > 0) {
			final Object bo = AadlElementWrapper.unwrap(this.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]));
			if(bo instanceof NamedElement) {
				final NamedElement element;
				if(bo instanceof Subcomponent) {
					element = getSubcomponentClassifier(context.getPictogramElements()[0], bo);
				} else {
					element = (NamedElement)bo;
				}
				DiagramOpener.create().openOrCreateDiagram(element);
			}
		}
	}
    
    /**
     * Returns the appropriate classifier if the business object is for a subcomponent
     * @param pe
     * @param bo
     * @return
     */
    private Classifier getSubcomponentClassifier(final PictogramElement pe, final Object bo) {
    	if(pe instanceof Shape && bo instanceof Subcomponent) {
        	return ClassifierHelper.getComponentClassifier((Shape)pe, (Subcomponent)bo, getFeatureProvider());
        }
    	return null;
    }
}
