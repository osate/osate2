package edu.uah.rsesc.aadl.age.diagrams.pkg.patterns;

import javax.inject.Inject;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.func.IDelete;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Realization;
import org.osate.aadl2.TypeExtension;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.patterns.AgeConnectionPattern;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;
import edu.uah.rsesc.aadl.age.services.ConnectionCreationService;
import edu.uah.rsesc.aadl.age.services.ConnectionService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService;
import edu.uah.rsesc.aadl.age.services.StyleService;
import edu.uah.rsesc.aadl.age.services.UserInputService;
import edu.uah.rsesc.aadl.age.services.VisibilityService;
import edu.uah.rsesc.aadl.age.services.AadlModificationService.AbstractModifier;

public class PackageGeneralizationPattern extends AgeConnectionPattern {
	private final StyleService styleUtil;
	private final AadlModificationService modificationService;
	private final ConnectionService connectionService;
	private final ConnectionCreationService connectionCreationService;
	private final UserInputService userInputService;
	private final BusinessObjectResolutionService bor;	
	
	@Inject
	public PackageGeneralizationPattern(final VisibilityService visibilityHelper, final StyleService styleUtil, 
			final AadlModificationService modificationService, final ConnectionService connectionService, 
			final ConnectionCreationService connectionCreationService, final UserInputService userInputService, final BusinessObjectResolutionService bor) {
		super(visibilityHelper);
		this.styleUtil = styleUtil;
		this.modificationService = modificationService;
		this.connectionService = connectionService;
		this.connectionCreationService = connectionCreationService;
		this.userInputService = userInputService;
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
		final ContainerShape ownerShape = connectionService.getOwnerShape(connection);
		return (ownerShape == null) ? null : connectionService.getAnchors(ownerShape, generalization);		
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
		final NamedElement srcEl = (NamedElement)getShapeBusinessObject(context.getSourceAnchor());
		final URI dstElUri = EcoreUtil.getURI((EObject)getShapeBusinessObject(context.getTargetAnchor()));
				
		// Make the modification
		final Generalization generalization = modificationService.modify(srcEl, new AbstractModifier<NamedElement, Generalization>() {
			@Override
			public Generalization modify(final Resource resource, final NamedElement srcEl) {
				final EObject dstEl = resource.getResourceSet().getEObject(dstElUri, true);
				
				if(srcEl instanceof ComponentType) {
					final ComponentType ct = (ComponentType)srcEl;
					final TypeExtension te = ct.createOwnedExtension();
					te.setExtended((ComponentType)dstEl);
					return te;
				} else if(srcEl instanceof ComponentImplementation) {
					final ComponentImplementation ci = (ComponentImplementation)srcEl;
					final ImplementationExtension ie = ci.createOwnedExtension();
					ie.setExtended((ComponentImplementation)dstEl);
					return ie;
				} else if(srcEl instanceof FeatureGroupType) {
					final FeatureGroupType fgt = (FeatureGroupType)srcEl;
					final GroupExtension ge = fgt.createOwnedExtension();
					ge.setExtended((FeatureGroupType)dstEl);
					return ge;
				}
				
				return null;
			}			
		});		
				
		// Create/Get the connection
		if(generalization == null) {
			return null;
		}
		
		final Connection connection = connectionCreationService.createUpdateConnection(getDiagram(), generalization);
		return connection;
	}

	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (bo instanceof TypeExtension || bo instanceof ImplementationExtension || bo instanceof GroupExtension);
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		// Make the modification
		final Generalization generalization = (Generalization)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		modificationService.modify(generalization, new AbstractModifier<Generalization, Object>() {
			@Override
			public Object modify(final Resource resource, final Generalization generalization) {
				EcoreUtil.delete(generalization);
				
				return null;
			}			
		});	
		
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
}
