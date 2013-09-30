package edu.uah.rsesc.aadl.age.diagrams.pkg.patterns;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
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
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.ModificationService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.ModificationService.Modifier;

public class PackageGeneralizationPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;
	private final ConnectionService connectionHelper;
	private final ModificationService modificationService;
	private final ConnectionService connectionService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public PackageGeneralizationPattern(final VisibilityService visibilityHelper, final StyleService styleUtil, final ConnectionService connectionHelper, 
			final ModificationService modificationService, final ConnectionService connectionService, final BusinessObjectResolutionService bor) {
		super(visibilityHelper);
		this.styleUtil = styleUtil;
		this.connectionHelper = connectionHelper;
		this.modificationService = modificationService;
		this.connectionService = connectionService;
		this.bor = bor;
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
        createArrow(arrowConnectionDecorator, styleUtil.getGeneralizationArrowHeadStyle());
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
		final Style style = isImplements ? styleUtil.getImplementsStyle() : styleUtil.getExtendsStyle();
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
	
	@Override
	public String getCreateName() {
		return "Extension";
	}
	
	@Override
	public boolean canCreate(final ICreateConnectionContext context) {		
		if(context.getSourceAnchor() == null || context.getTargetAnchor() == null) {
			return false;
		}
		
		// Get the business objects for the source and destination shapes
		final Object srcBo = getShapeBusinessObject(context.getSourceAnchor());
		final Object dstBo = getShapeBusinessObject(context.getTargetAnchor());
		
		// Ensure they are valid and are not the same
		if(srcBo == null || dstBo == null || srcBo == dstBo) {
			return false;
		}
		
		// Rules: 
		// Abstract types can be extended by any type.
		// Types can be extended by other types in their category
		// Implementations can extend other implementations with same category and abstract implementation in some cases. 
		// Feature Group Types can extend other feature group types
		if(srcBo instanceof ComponentType) {
			return dstBo instanceof AbstractType || dstBo.getClass() == srcBo.getClass();
		} else if(srcBo instanceof ComponentImplementation) {
			return dstBo instanceof AbstractImplementation || dstBo.getClass() == srcBo.getClass();
		} else if(srcBo instanceof FeatureGroupType) {
			return dstBo instanceof FeatureGroupType;
		}
		
		return false;
	}
	
	@Override
	public boolean canStartConnection(final ICreateConnectionContext context) {
		final Anchor anchor = context.getSourceAnchor();
		if(anchor == null) {
			return false;
		}

		// Determine whether it is a valid starting object
		final Object bo = getShapeBusinessObject(anchor);
		if(bo instanceof ComponentType) {
			final ComponentType ct = (ComponentType)bo;
			return ct.getOwnedExtension() == null;
		} else if(bo instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)bo;
			return ci.getOwnedExtension() == null;
		} else if(bo instanceof FeatureGroupType) {
			final FeatureGroupType fgt = (FeatureGroupType)bo;
			return fgt.getOwnedExtension() == null;
		}
		
		return false;
    }
	
	private Object getShapeBusinessObject(final Anchor anchor) {
		return bor.getBusinessObjectForPictogramElement(anchor.getParent());
	}
	
	@Override
	public Connection create(final ICreateConnectionContext context) {
		// Get the business objects for the source and destination shapes
		final Object srcBo = getShapeBusinessObject(context.getSourceAnchor());
		final Object dstBo = getShapeBusinessObject(context.getTargetAnchor());
				
		// Make the modification
		final AadlPackage pkg = (AadlPackage)bor.getBusinessObjectForPictogramElement(getDiagram());
		final Generalization generalization = modificationService.modifyModel(pkg, new Modifier<Generalization>() {
			@Override
			public Generalization modify(final Resource resource) {
				if(srcBo instanceof ComponentType) {
					final ComponentType ct = (ComponentType)srcBo;
					final TypeExtension te = ct.createOwnedExtension();
					te.setExtended((ComponentType)dstBo);
					return te;
				} else if(srcBo instanceof ComponentImplementation) {
					final ComponentImplementation ci = (ComponentImplementation)srcBo;
					final ImplementationExtension ie = ci.createOwnedExtension();
					ie.setExtended((ComponentImplementation)dstBo);
					return ie;
				} else if(srcBo instanceof FeatureGroupType) {
					final FeatureGroupType fgt = (FeatureGroupType)srcBo;
					final GroupExtension ge = fgt.createOwnedExtension();
					ge.setExtended((FeatureGroupType)dstBo);
					return ge;
				}
				
				return null;
			}			
		});
				
		// Get and return the new connection
		if(generalization != null) {
			final Connection connection = connectionService.getConnection(getDiagram(), generalization);
			System.out.println(connection);
			return connection;
		}
		return null;
	}
}
