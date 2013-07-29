package edu.uah.rsesc.aadl.age.diagrams.type.patterns;

import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgePattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.GraphicsAlgorithmCreator;
import edu.uah.rsesc.aadl.age.diagrams.common.util.PropertyUtil;
import edu.uah.rsesc.aadl.age.util.StyleUtil;

public class TypeFeaturePattern extends AgePattern {
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		return AadlElementWrapper.unwrap(mainBusinessObject) instanceof Feature;
	}
	
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			if(context.getTargetContainer() instanceof Diagram) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public PictogramElement add(final IAddContext context) {
		final Feature feature = (Feature)AadlElementWrapper.unwrap(context.getNewObject());
		final Diagram diagram = getDiagram();
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();

        // Create the container shape
        final ContainerShape container = peCreateService.createContainerShape(diagram, true);
        // TODO: Need to tag feature with additional information?
   		//PropertyUtil.setTypeName(container, getClassifierTypeName(feature));
        link(container, new AadlElementWrapper(feature));
        
		// Determine the label text
        final String labelTxt = getLabelText(feature);
        
		// Create label
        final Shape labelShape = peCreateService.createShape(container, false);
        final Text label = createLabelGraphicsAlgorithm(labelShape, labelTxt);
        
        // Set the size        
        final IDimension labelSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxt, label.getStyle().getFont());
		gaService.setLocationAndSize(label, 0, 0, labelSize.getWidth(), labelSize.getHeight());
		
		// Create symbol
        final Shape featureShape = peCreateService.createShape(container, false);
        final GraphicsAlgorithm featureGa = gaService.createPlainRectangle(featureShape);
        gaService.setLocationAndSize(featureGa,  0,  labelSize.getHeight(), 10, 10);
                
		// Set the graphics algorithm fo the container to an invisible rectangle to set hte bounds				
        final GraphicsAlgorithm ga = gaService.createPlainRectangle(container);
        ga.setTransparency(1.0);

        // Set size as appropriate
        gaService.setLocationAndSize(ga, context.getX(), context.getY(), Math.max(getWidth(label), getWidth(featureShape.getGraphicsAlgorithm())), 
        		Math.max(getHeight(label), getHeight(featureShape.getGraphicsAlgorithm())));
           
        // TODO: Anchor should be associated with feature shape instead or use a different type of anchor
        // Create anchor
        peCreateService.createChopboxAnchor(container);

        return container;
        
	}
	
	private int getWidth(final GraphicsAlgorithm ga) {
		return ga.getX() + ga.getWidth();
	}
	
	private int getHeight(final GraphicsAlgorithm ga) {
		return ga.getY() + ga.getHeight();
	}
	
	public final String getLabelText(final Feature feature) {
		return feature.getName();
	}
	
	// TODO: Have a generic label style and share between all patterns
	
	private Text createLabelGraphicsAlgorithm(final Shape labelShape, final String labelTxt) {
		final IGaService gaService = Graphiti.getGaService();
		final Text text = gaService.createPlainText(labelShape, labelTxt);
        text.setStyle(StyleUtil.getClassifierLabelStyle(this.getDiagram()));
        // TODO: Style
        return text;
	}
	
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		/*
		final PictogramElement pe = context.getPictogramElement();
		final Classifier classifier = (Classifier)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		final String actualTypeName = getClassifierTypeName(classifier);
		final String storedTypeName = PropertyUtil.getTypeName(pe);	
		if(!actualTypeName.equals(storedTypeName)) {
			return Reason.createTrueReason("Type is out of date");
		}
		
		final Text label = getLabel((ContainerShape)pe);
		if(label == null || !label.getValue().equals(getLabelText(classifier))) {
			return Reason.createTrueReason("Label is out of date");			
		}
*/
		return Reason.createFalseReason();
	}
}
