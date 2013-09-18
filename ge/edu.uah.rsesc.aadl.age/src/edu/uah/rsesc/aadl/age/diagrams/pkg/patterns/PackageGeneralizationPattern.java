package edu.uah.rsesc.aadl.age.diagrams.pkg.patterns;

import javax.inject.Inject;

import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.VisibilityService;

public class PackageGeneralizationPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;
	private final ConnectionService connectionHelper;
	
	@Inject
	public PackageGeneralizationPattern(final VisibilityService visibilityHelper, final StyleService styleUtil, final ConnectionService connectionHelper) {
		super(visibilityHelper);
		this.styleUtil = styleUtil;
		this.connectionHelper = connectionHelper;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object unwrappedObj = AadlElementWrapper.unwrap(mainBusinessObject);
		return (unwrappedObj instanceof Realization || 
    				unwrappedObj instanceof TypeExtension || 
    				unwrappedObj instanceof ImplementationExtension ||
    				unwrappedObj instanceof GroupExtension);
	}
	
	@Override
	protected void createDecorators(final Connection connection) {
		connection.getConnectionDecorators().clear();
		
		// Create the arrow
        final ConnectionDecorator arrowConnectionDecorator = Graphiti.getPeCreateService().createConnectionDecorator(connection, false, 0.0, true);    
        createArrow(arrowConnectionDecorator, styleUtil.getGeneralizationArrowHeadStyle(getDiagram()));
	}
	
	@Override
	protected void createGraphicsAlgorithm(final Connection connection) {
		final Generalization generalization = getGeneralization(connection);
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		setGraphicsAlgorithmStyle(polyline, generalization);
	}
	
	private void setGraphicsAlgorithmStyle(final GraphicsAlgorithm ga, final Generalization generalization) {
		final boolean isImplements = generalization instanceof Realization;
		final Style style = isImplements ? styleUtil.getImplementsStyle(getDiagram()) : styleUtil.getExtendsStyle(getDiagram());
		ga.setStyle(style);
	}
	
	private GraphicsAlgorithm createArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-15, 10, 
	    		0, 0, 
	    		-15, -10});
	    ga.setStyle(style);
	    return ga;
	}

	protected Generalization getGeneralization(final Connection connection) {
		return (Generalization)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));		
	}
	
	@Override
	protected Anchor[] getAnchors(final Connection connection) {
		final Generalization generalization = getGeneralization(connection);
		final ContainerShape ownerShape = connectionHelper.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionHelper.getAnchors(ownerShape, generalization);		
	}
	
	protected void createGraphicsAlgorithmOnUpdate(final Connection connection)	{ 
		final Generalization generalization = (Generalization)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(connection));
		// CLEAN-UP: As of 8/9/13 updating the graphics algorithm is causing the generalizations to disappear on the 2nd update(1st update after the initial load). Unknown cause.
		// First noticed after updating to Kepler. So for now, we just set the style since strictly speaking, recreating the graphics algorithm isn't necessary.
		//createGraphicsAlgorithm(connection, generalization);
		setGraphicsAlgorithmStyle(connection.getGraphicsAlgorithm(), generalization);
	}
}
