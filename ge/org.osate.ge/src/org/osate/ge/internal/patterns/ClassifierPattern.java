/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.AbstractText;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.DefaultAgeResizeConfiguration;
import org.osate.ge.internal.Categorized;
import org.osate.ge.internal.services.AadlArrayService;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AnchorService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ComponentImplementationService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.GraphicsAlgorithmCreationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.PropertyService.BindingType;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.SubcomponentService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.internal.util.StringUtil;
import org.osate.xtext.aadl2.properties.util.DeploymentProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.ge.internal.styles.StyleConstants;
import org.osate.ge.Categories;

/**
 * A pattern for top level classifier shapes as well as subcomponents.
 */
public class ClassifierPattern extends AgePattern implements Categorized {
	public static String BINDING_CONNECTION_TYPE = "generic_binding";
	private static final int classifierMinimumWidth = 300;
	private static final int classifierMinimumHeight = 325;
	private static final LinkedHashMap<EClass, String> subcomponentTypeToCreateMethodNameMap = new LinkedHashMap<EClass, String>();
	private static final String labelShapeName = "label";
	private static final String subcomponentTypeLabelShapeName = "subcomponent_type_label";
	private final GhostingService ghostingService;
	private final LayoutService layoutService;
	private final ShapeService shapeService;
	private final ShapeCreationService shapeCreationService;
	private final AadlFeatureService featureService;
	private final SubcomponentService subcomponentService;
	private final ConnectionService connectionService;
	private final ConnectionCreationService connectionCreationService;
	private final StyleService styleUtil;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final PropertyService propertyService;
	private final AadlArrayService arrayService;
	private final ColoringService highlightingService;
	private final AnchorService anchorService;
	private final AadlModificationService aadlModService;
	private final NamingService namingService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final RefactoringService refactoringService;
	private final ComponentImplementationService componentImplementationService;
	private final BusinessObjectResolutionService bor;
	private final EClass subcomponentType; // The subcomponent the pattern is responsible for handling. null if the pattern is for handling a classifier.
	
	/**
	 * Populate the map that contains the subcomponent type to create method name mapping
	 */
	static {
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		subcomponentTypeToCreateMethodNameMap.put(p.getAbstractSubcomponent(), "createOwnedAbstractSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getBusSubcomponent(), "createOwnedBusSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getDataSubcomponent(), "createOwnedDataSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getDeviceSubcomponent(), "createOwnedDeviceSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getMemorySubcomponent(), "createOwnedMemorySubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getProcessSubcomponent(), "createOwnedProcessSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getProcessorSubcomponent(), "createOwnedProcessorSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSubprogramSubcomponent(), "createOwnedSubprogramSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSubprogramGroupSubcomponent(), "createOwnedSubprogramGroupSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getSystemSubcomponent(), "createOwnedSystemSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getThreadSubcomponent(), "createOwnedThreadSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getThreadGroupSubcomponent(), "createOwnedThreadGroupSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getVirtualBusSubcomponent(), "createOwnedVirtualBusSubcomponent");
		subcomponentTypeToCreateMethodNameMap.put(p.getVirtualProcessorSubcomponent(), "createOwnedVirtualProcessorSubcomponent");
	}
	
	public static Collection<EClass> getSubcomponentTypes() {
		return subcomponentTypeToCreateMethodNameMap.keySet();
	}
	
	@Inject
	public ClassifierPattern(final GhostingService ghostingService, final LayoutService layoutService, final ShapeService shapeService, final ShapeCreationService shapeCreationService,
			final AadlFeatureService featureService, final SubcomponentService subcomponentService, final ConnectionCreationService connectionCreationService, final StyleService styleUtil,
			final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, final PropertyService propertyService, final AadlArrayService arrayService,
			final ColoringService highlightingService, final AnchorService anchorService, final AadlModificationService aadlModService, final NamingService namingService, 
			final DiagramModificationService diagramModService, final UserInputService userInputService, final RefactoringService refactoringService, 
			final ConnectionService connectionService, final ComponentImplementationService componentImplementationService, final BusinessObjectResolutionService bor, 
			final @Named("Subcomponent Type") EClass subcomponentType) {
		this.ghostingService = ghostingService;
		this.layoutService = layoutService;
		this.shapeService = shapeService;
		this.shapeCreationService = shapeCreationService;
		this.featureService = featureService;
		this.subcomponentService = subcomponentService;
		this.connectionCreationService = connectionCreationService;
		this.styleUtil = styleUtil;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.propertyService = propertyService;
		this.arrayService = arrayService;
		this.highlightingService = highlightingService;
		this.anchorService = anchorService;
		this.aadlModService = aadlModService;
		this.namingService = namingService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.refactoringService = refactoringService;
		this.connectionService = connectionService;
		this.componentImplementationService = componentImplementationService;
		this.bor = bor;
		this.subcomponentType = subcomponentType;
	}
	
	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof Classifier || bo instanceof Subcomponent;
	}
	
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
	
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			final Object targetBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
			return targetBo instanceof Classifier || targetBo instanceof Subcomponent;
		}
		
		return false;
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		if(bor.getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Subcomponent) {
			return super.canMoveShape(context);
		} else {
			return false;
		}
	}
	
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		super.postMoveShape(context);
		layoutService.checkShapeBoundsWithAncestors(((ContainerShape)context.getPictogramElement()));
		
		// Update Connection Anchors
		final ContainerShape shape = (ContainerShape)context.getShape();
		updateConnectionAnchors(shape);
	}
	
	private void updateConnectionAnchors(final Shape shape) {
		connectionService.updateConnectionAnchors(shape);
		
		// Check child shapes
		if(shape instanceof ContainerShape) {
			final ContainerShape containerShape = (ContainerShape)shape;
			for(Shape childShape : containerShape.getChildren()) {
				final Object childBo = bor.getBusinessObjectForPictogramElement(childShape);

				// Don't recurse into other subcomponents
				if(!(childBo instanceof Subcomponent)) {
					updateConnectionAnchors(childShape);
				}
			}
		}
	}
	
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return true;
	}
	
	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();			
		super.resizeShape(context);
		layoutService.checkShapeBoundsWithAncestors(shape);
		
		// Update Connection Anchors
		updateConnectionAnchors(shape);
		
		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());		
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final Element bo = (Element)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(bo));       
        
        // Finish creating
        refresh(shape, bo, context.getX(), context.getY());
        
        return shape;
	}

	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y;
			if(ga == null) {
				x = 25;
				y = 25;
			} else {
				x = ga.getX();
				y = ga.getY();
			}
			this.refresh((ContainerShape)pe, bo, x, y);
		}
		return true;
	}	
	
	private Classifier getClassifier(final ContainerShape shape) {
		final Object bo = bor.getBusinessObjectForPictogramElement(shape);
		final Classifier classifier;
		if(bo instanceof Classifier) {
			classifier = (Classifier)bo;
		} else if(bo instanceof Subcomponent) {
			classifier = (Classifier)subcomponentService.getComponentClassifier(shape,  (Subcomponent)bo);
		} else if(bo == null) {
			throw new RuntimeException("Unexpected case. Business object is null.");
		} else {
			throw new RuntimeException("Unexpected case. Business object is of unexpected type: " + bo.getClass());
		}	
		
		return classifier;
	}
	
	private void refresh(final ContainerShape shape, final Object bo, final int x, final int y) {
		propertyService.setIsLogicalTreeNode(shape, true);
		ghostingService.setIsGhost(shape, false);
		anchorService.removeAnchorsWithoutConnections(shape);
		
		// Determine whether the subcomponent/classifier should be shown based on the the depth level setting
		final int depthLevel = shapeService.getDepthLevel(shape) - 1; // Subtract 1 because of the container shape that contains all other shapes
		final boolean showContents = depthLevel <= propertyService.getNestingDepth(getDiagram());
		
		// Ghost children
		ghostingService.ghostChildren(shape);
		
		// Ghost descendant connections if contents should not be shown. Flow specs will be unghosted when they are updated.
		if(!showContents) {
			ghostDescendantConnections(shape);
		}
		
		final Classifier classifier = getClassifier(shape);
		if(classifier != null) {
			shapeCreationService.createUpdateFeatureShapes(shape, featureService.getAllDeclaredFeatures(classifier));
		}
		
		if(showContents) {
			// Create component implementation specific shapes
			if(classifier instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation)classifier;
				shapeCreationService.createUpdateFeatureShapes(shape, componentImplementationService.getAllInternalFeatures(ci));
				shapeCreationService.createUpdateFeatureShapes(shape, componentImplementationService.getAllProcessorFeatures(ci));
				shapeCreationService.createUpdateShapes(shape, ci.getAllSubcomponents(), 25, true, 30, 25, true, 20);		
			}
			
			if(classifier instanceof BehavioredImplementation) {
				final BehavioredImplementation bi = (BehavioredImplementation)classifier;
				shapeCreationService.createUpdateShapes(shape, componentImplementationService.getAllSubprogramCallSequences(bi), 25, true, 30, 25, true, 20);
			}
			
			// Create/Update Modes and Mode Transitions
			if(classifier instanceof ComponentClassifier) {
				final ComponentClassifier cc = (ComponentClassifier)classifier;			
				shapeCreationService.createUpdateModeShapes(shape, cc.getAllModes());
			}
			
			// Annex Subclauses
			if(classifier instanceof Classifier) {
				updateAnnexSubclauses(shape, getAllDefaultAnnexSubclauses((Classifier)classifier));		
			}
		}

		if(showContents) {
			// Create mode transitions
			if(classifier instanceof ComponentClassifier) {
				final ComponentClassifier cc = (ComponentClassifier)classifier;
				connectionCreationService.createUpdateConnections(shape, cc.getAllModeTransitions());
			}

			// Create connections
			if(classifier instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation)classifier;
				connectionCreationService.createUpdateConnections(shape, ci.getAllConnections());
			}
		}
		
		// Create/Update Flow Specifications
		final ComponentType componentType;
		if(classifier instanceof ComponentType) {
			componentType = (ComponentType)classifier;
		} else if(classifier instanceof ComponentImplementation) {
			componentType = ((ComponentImplementation)classifier).getType();
		} else {
			componentType = null;
		}
		if(componentType != null) {
			connectionCreationService.createUpdateConnections(shape, componentType.getAllFlowSpecifications());
		}	
		
		// Update label and graphics algorithms
		if(bo instanceof Subcomponent) {	
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
			final Subcomponent sc = (Subcomponent)bo;
			
			// Create label
	        final Shape labelShape = peCreateService.createShape(shape, false);
	        propertyService.setName(labelShape, labelShapeName);
	        propertyService.setIsManuallyPositioned(labelShape, true);
	        propertyService.setIsTransient(labelShape, true);
	        link(labelShape, new AadlElementWrapper(sc));
	        final String name = getLabelText(sc);
	        final GraphicsAlgorithm labelBackground = graphicsAlgorithmCreator.createTextBackground(labelShape);		
	        graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelBackground, name);
	        
			// Create Subcomponent Type Indicator
	        final Shape subcomponentTypeIndicatorShape = peCreateService.createShape(shape, false);
	        propertyService.setName(subcomponentTypeIndicatorShape, subcomponentTypeLabelShapeName);
	        propertyService.setIsManuallyPositioned(subcomponentTypeIndicatorShape, true);
	        propertyService.setIsTransient(subcomponentTypeIndicatorShape, true);
	        final String subcomponentTypeName = getTypeText(sc);
	        final GraphicsAlgorithm subcomponentTypeLabelBackground = graphicsAlgorithmCreator.createTextBackground(subcomponentTypeIndicatorShape);
	        graphicsAlgorithmCreator.createMultiLineLabelGraphicsAlgorithm(subcomponentTypeLabelBackground, subcomponentTypeName);
		}	

		layout(shape, bo, x, y);

		// Create/update the chopbox anchor
		anchorService.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
		
		// If the shape is not a subcomponent, then refresh binding indicators
		if(bo instanceof ComponentImplementation && showContents) {			
			refreshBindingIndicators(shape, (ComponentImplementation)bo);
		}
	}	

	/**
	 * Creates and updates pictogram elements for annex subclauses
	 * If specialized handling for the parsed pictogram element is implemented, then it is used. Otherwise, generic annex handling is used.
	 * @param subclauses a collection containing the default annex subclauses 
	 */
	private void updateAnnexSubclauses(final ContainerShape container, final Collection<AnnexSubclause> subclauses) {
		for(final AnnexSubclause subclause : subclauses) {
			final NamedElement parsedAnnexSubclause = getParsedAnnexSubclause(subclause);
			final boolean specializedHandling = parsedAnnexSubclause != null && shapeCreationService.createUpdateShape(container, parsedAnnexSubclause);
			
			if(!specializedHandling) {
				shapeCreationService.createUpdateShape(container, subclause);
			}
		}
	}
	
	private NamedElement getParsedAnnexSubclause(final AnnexSubclause annexSubclause) {
		if(annexSubclause instanceof DefaultAnnexSubclause) {
			final NamedElement parsedSubclause = ((DefaultAnnexSubclause) annexSubclause).getParsedAnnexSubclause();
			
			// Don't return subclauses which inherit from DefaultAnnexSubclause
			if(parsedSubclause instanceof DefaultAnnexLibrary) {
				return null;
			}
			
			return parsedSubclause;
		}
		
		return null;
	}
	
	// Starting Binding Handling
	// The Binding Tracker class is used to track information regarding a particular binding(such as actual_connection_binding). The data is built each time a classifier is refreshed.
	private static class BindingTracker {		
		private final Set<PictogramElement> finalizedPictogramElements = new HashSet<PictogramElement>(); // Stores all the shapes that have their binding stored.
		public final Map<PictogramElement, List<PictogramElement>> bindings = new HashMap<PictogramElement, List<PictogramElement>>();
		public final PropertyService.BindingType bindingType;
		
		public BindingTracker(final PropertyService.BindingType bindingType) {
			this.bindingType = bindingType;
		}
		
		public boolean isPictogramElementFinalized(final PictogramElement pe) {
			return finalizedPictogramElements.contains(pe);
		}
		
		public void finalizePictogramElement(final PictogramElement boundPictogramElement) {
			finalizedPictogramElements.add(boundPictogramElement);
		}
		
		public void prependBinding(final PictogramElement boundPictogramElement, final PictogramElement targetPictogramElement) {
			List<PictogramElement> targetPictogramElements = bindings.get(boundPictogramElement);
			if(!bindings.containsKey(boundPictogramElement)) {
				targetPictogramElements = new LinkedList<PictogramElement>();
				bindings.put(boundPictogramElement, targetPictogramElements);
			}
			
			targetPictogramElements.add(0, targetPictogramElement);
		}		
	}

	private void refreshBindingIndicators(final ContainerShape classifierShape, final ComponentImplementation classifier) {
		// Create binding trackers for each binding type we are interested in
		final Map<Property, BindingTracker> bindingTrackerMap = new HashMap<Property, BindingTracker>();
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ACTUAL_CONNECTION_BINDING), new BindingTracker(BindingType.ACTUAL_CONNECTION));
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ALLOWED_CONNECTION_BINDING), new BindingTracker(BindingType.ALLOWED_CONNECTION));
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ACTUAL_FUNCTION_BINDING), new BindingTracker(BindingType.ACTUAL_FUNCTION));
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ACTUAL_MEMORY_BINDING), new BindingTracker(BindingType.ACTUAL_MEMORY));
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ALLOWED_MEMORY_BINDING), new BindingTracker(BindingType.ALLOWED_MEMORY));
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ACTUAL_PROCESSOR_BINDING), new BindingTracker(BindingType.ACTUAL_PROCESSOR));
		bindingTrackerMap.put(GetProperties.lookupPropertyDefinition(classifierShape, DeploymentProperties._NAME, DeploymentProperties.ALLOWED_PROCESSOR_BINDING), new BindingTracker(BindingType.ALLOWED_PROCESSOR));		

		processBindings(bindingTrackerMap, classifier, classifierShape);
		
		// Create Binding Connections
		final Font decoratorFont = GraphitiUi.getGaService().manageDefaultFont(getDiagram());
		final Diagram diagram = getDiagram();
		for(final Entry<Property, BindingTracker> bindingTrackerMapEntry : bindingTrackerMap.entrySet()) {
			final BindingTracker bindingTracker = bindingTrackerMapEntry.getValue();
			final boolean showBindingType = propertyService.getShowConnectionBindingType(diagram, bindingTracker.bindingType);
			for(final Entry<PictogramElement, List<PictogramElement>> bindingEntry : bindingTracker.bindings.entrySet()) {
				final PictogramElement boundPictogramElement = bindingEntry.getKey();
				int targetShapeNumber = 0; // Number displayed on the binding connection
				for(final PictogramElement targetPictogramElement : bindingEntry.getValue()) {
					if(targetPictogramElement != null) {
						final IPeCreateService peCreateService = Graphiti.getPeCreateService();
						final Connection bindingConnection = peCreateService.createFreeFormConnection(getDiagram());
						bindingConnection.setVisible(showBindingType);
						propertyService.setConnectionType(bindingConnection, BINDING_CONNECTION_TYPE);
						propertyService.setIsTransient(bindingConnection, true);
						propertyService.setBindingType(bindingConnection, bindingTracker.bindingType);
						
						final Anchor boundShapeAnchor = getBindingAnchor(boundPictogramElement);
						final Anchor targetShapeAnchor = getBindingAnchor(targetPictogramElement);
						if(boundShapeAnchor != null && targetShapeAnchor != null) {
							bindingConnection.setStart(boundShapeAnchor);
							bindingConnection.setEnd(targetShapeAnchor);
							createBindingGraphicsAlgorithm(bindingConnection);		
							
							// Create label text decorator
							final String labelTxtValue = bindingTrackerMapEntry.getKey().getName() + " [" + targetShapeNumber + "]";
							final IGaService gaService = Graphiti.getGaService();
							final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(bindingConnection, true, 0.5, true);
							propertyService.setIsUnselectable(textDecorator, true);
							final Text text = gaService.createDefaultText(getDiagram(), textDecorator);
							text.setStyle(styleUtil.getStyle(StyleConstants.LABEL_STYLE));
							int labelTxtWidth = GraphitiUi.getUiLayoutService().calculateTextSize(labelTxtValue, decoratorFont).getWidth();
							gaService.setLocation(text, -labelTxtWidth/2, 10);
						    text.setValue(labelTxtValue);
						    textDecorator.setVisible(showBindingType);
						    
							// Create the arrow
					        final ConnectionDecorator arrowConnectionDecorator = peCreateService.createConnectionDecorator(bindingConnection, false, 1.0, true);    
					        createBindingArrow(arrowConnectionDecorator, styleUtil.getStyle(StyleConstants.DECORATOR_STYLE));
						}
					}
					
					// Increment shape number regardless of whether a connection was created to ensure the number matches the index in the target shape list
					targetShapeNumber++;
				}
			}
		}	
		
	}
	
	/**
	 * Populates the binding trackers with binding information for the specified classifier
	 * @param bindingTrackerMap
	 * @param classifier
	 * @param classifierShape
	 */
	private void processBindings(final Map<Property, BindingTracker> bindingTrackerMap, final Classifier classifier, final ContainerShape classifierShape) {
		for(final Classifier tmpClassifier : classifier.getSelfPlusAllExtended()) {
			if(tmpClassifier instanceof ComponentImplementation) {
				final ComponentImplementation ci = (ComponentImplementation)tmpClassifier;
				for(final Subcomponent sc : ci.getOwnedSubcomponents()) {
					if(sc.getOwnedPropertyAssociations().size() > 0) {
						// Get subcomponent shape
						final Shape subcomponentShape = shapeService.getChildShapeByElementName(classifierShape, sc);
						if(subcomponentShape instanceof ContainerShape) {
							// Process the subcomponent's bindings
							processBindings(bindingTrackerMap, sc.getOwnedPropertyAssociations(), (ContainerShape)subcomponentShape);
						}
					}
				}
			}

			processBindings(bindingTrackerMap, tmpClassifier.getOwnedPropertyAssociations(), classifierShape); 
		}

		// Process Subcomponent Bindings
		if(classifier instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)classifier;
			for(final Subcomponent sc : ci.getAllSubcomponents()) {
				final Shape subcomponentShape = shapeService.getChildShapeByElementName(classifierShape, sc);				
				if(subcomponentShape != null) {
					final Classifier subcomponentClassifier = subcomponentService.getComponentClassifier(subcomponentShape, sc);
					if(subcomponentClassifier != null && subcomponentShape instanceof ContainerShape) {
						processBindings(bindingTrackerMap, subcomponentClassifier, (ContainerShape)subcomponentShape);
					}
				}
			}	
		}
	}
	
	private void processBindings(final Map<Property, BindingTracker> bindingTrackerMap, final List<PropertyAssociation> propertyAssociations, final ContainerShape ctxShape) {
		final Set<Property> relevantProperties = bindingTrackerMap.keySet();
		for(final PropertyAssociation pa : propertyAssociations) {
			// Check if the property is of interest
			if(relevantProperties.contains(pa.getProperty())) {
				// Get the binding tracker
				final BindingTracker bindingTracker = bindingTrackerMap.get(pa.getProperty());
				
				// Get the shape(s) it applies to
				if(pa.getAppliesTos().size() == 0) {
					processBinding(bindingTracker, ctxShape, pa, ctxShape);
				} else {
					for(final ContainedNamedElement appliesTo : pa.getAppliesTos()) {
						final PictogramElement appliesToPictogramElement = getReferencedPictogramElement(ctxShape, appliesTo);
						processBinding(bindingTracker, appliesToPictogramElement, pa, ctxShape);
					}
				}
			}
		}
	}
	
	private void processBinding(final BindingTracker bindingTracker, final PictogramElement boundPictogramElement, final PropertyAssociation pa, final ContainerShape propAssocCtxShape) {
		if(boundPictogramElement != null && !bindingTracker.isPictogramElementFinalized(boundPictogramElement)) {			
			// in the typical case(property association only applies to one object?)
			// Find referenced shapes			
			for(final ModalPropertyValue pv : pa.getOwnedValues()) {				
				if(pv.getOwnedValue() instanceof ListValue) {
					final ListValue lv = (ListValue)pv.getOwnedValue();
					final List<PropertyExpression> listPropExpressions = lv.getOwnedListElements();
					
					// Iterate backwards so we can prepend bindings properly.
					for(int i = listPropExpressions.size() - 1; i >= 0; i--) {
						final PropertyExpression listPropExpression = listPropExpressions.get(i);
						if(listPropExpression instanceof ReferenceValue) {
							final ReferenceValue referenceValue = (ReferenceValue)listPropExpression;
							final PictogramElement referencedPictogramElement = getReferencedPictogramElement(propAssocCtxShape, referenceValue);
							bindingTracker.prependBinding(boundPictogramElement, referencedPictogramElement);
						}
					}
				}
			}
			
			// Finalize the shape
			if(!pa.isAppend()) {
				bindingTracker.finalizePictogramElement(boundPictogramElement);
			}
		}
	}	

	/**
	 * Returns the pictogram referenced by a ContainedNamedElement. Looks for connections or shapes owned by the root shape with a matching BO.
	 * @param rootShape
	 * @param containedNamedElement
	 * @return
	 */
	private PictogramElement getReferencedPictogramElement(final ContainerShape rootShape, final ContainedNamedElement containedNamedElement) {
		ContainerShape shape = rootShape;
		for(final ContainmentPathElement pe : containedNamedElement.getContainmentPathElements()) {
			if(pe.getNamedElement() instanceof org.osate.aadl2.Connection) {
				if(pe.getNamedElement().getName() != null) {
					for(Connection c : getDiagram().getConnections()) {
						if(shape == connectionService.getOwnerShape(c)) {
							final Object connectionBo = bor.getBusinessObjectForPictogramElement(c);
							if(connectionBo instanceof org.osate.aadl2.Connection && 
									pe.getNamedElement().getName().equalsIgnoreCase(((org.osate.aadl2.Connection)connectionBo).getName()) && 
									c.isVisible()) {
								return c;
							}
						}
					}
					
					return null;
				}
			} else {
				final Shape childShape = shapeService.getChildShapeByElementName(shape, pe.getNamedElement());
				if(childShape instanceof ContainerShape) {
					shape = (ContainerShape)childShape;
				} else {
					return null; 
				}				
			}
		}
		
		return shape;
	}
	
	private Anchor getBindingAnchor(final PictogramElement pe) {
		if(pe instanceof Shape) {
			return Graphiti.getPeService().getChopboxAnchor((Shape)pe);
		} else if(pe instanceof Connection) {
			return connectionService.getMidpointAnchor((Connection)pe);
		} else {
			return null;
		}
	}
	
	private void createBindingGraphicsAlgorithm(final Connection connection) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline polyline = gaService.createPlainPolyline(connection);
		final Style style = styleUtil.getStyle(StyleConstants.MODE_TRANSITION_TRIGGER_STYLE);
		polyline.setStyle(style);
	}
	
	private GraphicsAlgorithm createBindingArrow(final GraphicsAlgorithmContainer gaContainer, final Style style) {
	    final IGaService gaService = Graphiti.getGaService();
	    final GraphicsAlgorithm ga = gaService.createPlainPolygon(gaContainer, new int[] {
	    		-6, 4, 
	    		2, 0, 
	    		-6, -4});
	    ga.setStyle(style);
	    return ga;
	}	
	
	// End Binding Handling

	// Ghost all connections that are owned by the shape or descendants
	private void ghostDescendantConnections(final Shape shape) {
		for(final Connection c : getDiagram().getConnections()) {
			final Shape ownerShape = connectionService.getOwnerShape(c);
			if(isDescendantOrSame(shape, ownerShape)) {
				ghostingService.setIsGhost(c,  true);
			}
		}
	}
	
	private boolean isDescendantOrSame(final Shape container, Shape shapeToCheck) {
		while(shapeToCheck != null) {
			if(shapeToCheck == container) {
				return true;
			}
			
			shapeToCheck = shapeToCheck.getContainer();
		}

		return false;
	}
	
	private GraphicsAlgorithm getBackgroundFromLabelShape(final Shape labelShape) {
		final GraphicsAlgorithm bg = labelShape.getGraphicsAlgorithm();
		if(bg == null || bg.getGraphicsAlgorithmChildren().size() < 1) {
			return null;
		}
		
		return bg;
	}
	
	private AbstractText getTextFromLabelShape(final Shape labelShape) {
		final GraphicsAlgorithm bg = getBackgroundFromLabelShape(labelShape);
		if(bg == null) {
			return null;
		}
		
		final GraphicsAlgorithm txtGa = bg.getGraphicsAlgorithmChildren().get(0);
		if(txtGa instanceof AbstractText) {
			return (AbstractText)txtGa;
		}
		
		return null;
	}
	
	private Shape getLabelShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, labelShapeName);
	}
	
	private Shape getSubcomponentTypeLabelShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, subcomponentTypeLabelShapeName);
	}

	public boolean canLayout(ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}
	
	@Override
	public boolean layout(ILayoutContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final int x = shape.getGraphicsAlgorithm().getX();
		final int y = shape.getGraphicsAlgorithm().getY();
		return layout(shape, bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), x , y);
	}
	
	private boolean layout(final ContainerShape shape, final Object bo, final int x, final int y) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm ga;			
		
		if(bo instanceof Subcomponent) {	
	        // Determine text sizing
	        // Currently adding padding to work around incorrect size being returned by calculateTextSize().
			final Shape labelShape = getLabelShape(shape);
			final GraphicsAlgorithm labelBackground = getBackgroundFromLabelShape(labelShape);
			final AbstractText labelText = getTextFromLabelShape(labelShape);
			
			final Shape subcomponentTypeLabelShape = getSubcomponentTypeLabelShape(shape);
			final GraphicsAlgorithm subcomponentTypeLabelBackground = getBackgroundFromLabelShape(subcomponentTypeLabelShape);
			final AbstractText subcomponentTypeText = getTextFromLabelShape(subcomponentTypeLabelShape);
			final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelText.getValue(), labelText.getStyle().getFont());
	        final IDimension unpaddedSubcomponentTypeTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(subcomponentTypeText.getValue(), subcomponentTypeText.getStyle().getFont(), true);
	        final int paddedLabelTextWidth = textSize.getWidth() + 15;
	        final int paddedLabelTextHeight = textSize.getHeight() + 5;
	        final int paddedTypeTextWidth = unpaddedSubcomponentTypeTextSize.getWidth() + 15;
	        final int paddedTypeTextHeight = unpaddedSubcomponentTypeTextSize.getHeight() + 5;
	        
	        // Sets initialize position and size of text. Centering will be done when the final size of the shape is determined
	        gaService.setLocationAndSize(labelText, 0, 0, paddedLabelTextWidth, paddedLabelTextHeight);
	        gaService.setLocationAndSize(labelBackground, 0, 0, paddedLabelTextWidth, paddedLabelTextHeight);
	        gaService.setLocationAndSize(subcomponentTypeText, 0, 0, paddedTypeTextWidth, paddedTypeTextHeight);
			gaService.setLocationAndSize(subcomponentTypeLabelBackground, 0, 0, paddedTypeTextWidth, paddedTypeTextHeight);

	        final int[] newSize = layoutService.getMinimumSize(shape);
	        ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, (Subcomponent)bo, newSize[0], newSize[1]);	                
			gaService.setLocation(ga, x, y);
	        
			// Set the position and size of the text	        
			gaService.setLocation(labelBackground, (ga.getWidth() - paddedLabelTextWidth) / 2, 2);
			gaService.setLocation(subcomponentTypeLabelBackground, (ga.getWidth() - paddedTypeTextWidth) / 2, labelText.getY()+paddedLabelTextHeight);
		} else {
			final Classifier classifier = getClassifier(shape);
			final int newSize[] = layoutService.getMinimumSize(shape);
			
			// Enforce a minimum size for classifiers
			newSize[0] = Math.max(newSize[0], classifierMinimumWidth);
			newSize[1] = Math.max(newSize[1], classifierMinimumHeight);
			
			if(classifier instanceof FeatureGroupType) { // Use a rectangle for feature group types because the feature group shape is not ideal as a container for features.
				ga = gaService.createRectangle(shape);
				ga.setStyle(styleUtil.getStyle("feature-group-type-edit"));
				gaService.setLocationAndSize(ga, x, y, newSize[0], newSize[1]);
			} else {
				ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, classifier, newSize[0], newSize[1]);
				gaService.setLocation(ga, x, y);
			}
		}
		
		highlightingService.applyColoring(shape);
		
		layoutService.layoutChildren(shape);
		
		ga.setFilled(false);
		return true;
	}

	// Labels
	private String getSubcomponentName(final Subcomponent sc) {
		return sc.getName() == null ? "" : sc.getName();
	}
	
	private String getLabelText(final Subcomponent sc) {
		return getSubcomponentName(sc) + arrayService.getDimensionUserString(sc);
	}
	
	private String getTypeText(final Subcomponent sc) {
		String retVal = "";
        final SubcomponentType scType = subcomponentService.getAllSubcomponentType(sc);
        
		if(scType != null) {
			retVal += scType.getQualifiedName();
		}

		// Add text for each of the implementation references (for arrays)
		final List<ComponentImplementationReference> implRefs = subcomponentService.getArrayComponentImplementationReferences(sc);
		if(implRefs.size() != 0) {
			retVal += "\n(";			
			for(int i = 0; i < implRefs.size(); i++) {
				final ComponentImplementationReference ref = implRefs.get(i);
				if(ref.getImplementation() != null) {
					if(ref.getImplementation().eIsProxy()) {
						retVal += "<unresolved>";
					} else {
						retVal += ref.getImplementation().getQualifiedName();
					}
				}
				
				if(i == (implRefs.size() - 1)) {
					retVal += ")";
				} else {
					retVal += ",\n";					
				}
				
			}
		}
		
		return retVal;
	}
	
	// Create
	@Override
	public boolean isPaletteApplicable() {
		if(subcomponentType == null || !isComponentImplementationDiagram()) {
			return false;
		}
		
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return ClassifierPattern.canContainSubcomponentType((ComponentImplementation)diagramBo, subcomponentType);
	}
	
	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(subcomponentType.getName());
	}
		
	@Override
	public String getCreateImageId(){
		return ImageHelper.getImage(subcomponentType.getName());
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {
		if(subcomponentType == null) {
			return false;
		}
		
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		return !(context.getTargetContainer() instanceof Diagram) && (containerBo instanceof ComponentImplementation ? ClassifierPattern.canContainSubcomponentType((ComponentImplementation)containerBo, subcomponentType) : false);
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		final Subcomponent newSubcomponent = aadlModService.modify(getComponentImplementation(context.getTargetContainer()), new AbstractModifier<ComponentImplementation, Subcomponent>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Subcomponent modify(final Resource resource, final ComponentImplementation ci) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(ci);

				final String name = namingService.buildUniqueIdentifier(ci, "new_subcomponent");
				final Subcomponent sc = createSubcomponent(ci, subcomponentType);
				sc.setName(name);
				
				// Reset the no subcomponents flag
				ci.setNoSubcomponents(false);
			
				return sc;
			}
			
	 		@Override
			public void beforeCommit(final Resource resource, final ComponentImplementation ci, final Subcomponent newSubcomponent) {
				diagramMod.commit();
				shapeCreationService.createShape(context.getTargetContainer(), newSubcomponent, context.getX(), context.getY());
			}
		});
		
		return newSubcomponent == null ? EMPTY : new Object[] {newSubcomponent};
	}

	/**
	 * Returns whether the specified component implementation supports subcomponents of the specified type
	 * @param subcomponentOwner
	 * @param subcomponentClass
	 * @return
	 */
	public static boolean canContainSubcomponentType(final ComponentImplementation subcomponentOwner, final EClass subcomponentClass) {
		return getSubcomponentCreateMethod(subcomponentOwner, subcomponentClass) != null;
	}
	
	private static Method getSubcomponentCreateMethod(final ComponentImplementation subcomponentOwner, final EClass subcomponentType) {
		// Determine the method name of the type of subcomponent
		final String methodName = subcomponentTypeToCreateMethodNameMap.get(subcomponentType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = subcomponentOwner.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
	public static Subcomponent createSubcomponent(final ComponentImplementation subcomponentOwner, final EClass subcomponentClass) {
		try {
			return (Subcomponent)getSubcomponentCreateMethod(subcomponentOwner, subcomponentClass).invoke(subcomponentOwner);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Delete
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final PictogramElement pe = context.getPictogramElement();
		if(pe instanceof Shape) {		
			final Shape shape = (Shape)pe;
			final Object bo = bor.getBusinessObjectForPictogramElement(pe);
			if(bo instanceof Subcomponent) {	
				final Subcomponent sc = (Subcomponent)bo;
				final Object containerBo = bor.getBusinessObjectForPictogramElement(shape.getContainer());
				return sc.getContainingClassifier() == containerBo;
			}
		}
		
		return false;
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}
		
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		aadlModService.modify(sc, new AbstractModifier<Subcomponent, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final Subcomponent sc) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(getComponentImplementation((Shape)context.getPictogramElement()));
	 			
				// Just remove the classifier. In the future it would be helpful to offer options for refactoring the model so that it does not
				// cause errors.
				EcoreUtil.remove(sc);
				
				return null;
			}		
			
	 		@Override
			public void beforeCommit(final Resource resource, final Subcomponent sc, final Object modificationResult) {
				diagramMod.commit();
			}
		});
				
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
	
	// Renaming	
	@Override
	public int getEditingType() {
        return TYPE_TEXT;
    }

	@Override
	public boolean stretchFieldToFitText() {
		return true;
	}
	
    @Override
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }
 
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
        final Object bo = bor.getBusinessObjectForPictogramElement(pe);
        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        
        // To be able to be renamed the subcomponent must be contained by the component implementation represented by the diagram and it must not be refined
        if (bo instanceof Subcomponent && pe instanceof Shape && ga instanceof Text) {
        	final Subcomponent sc = (Subcomponent)bo;
        	return sc.getContainingClassifier() == getComponentImplementation((Shape)pe) && sc.getRefined() == null;
        }
        return false;
    }
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return getSubcomponentName(sc);
    }
    
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(pe);  	
    	refactoringService.renameElement(sc, value);
    }

	@Override
	public String getCategory() {
		return Categories.SUBCOMPONENTS;
	}
	
	/**
	 * Returns all the default annex subclauses owned by a classifier or any extended or implemented classifiers.
	 * @param topClassifier
	 * @return
	 */
	private static EList<AnnexSubclause> getAllDefaultAnnexSubclauses(final Classifier topClassifier) {
		final EList<AnnexSubclause> result = new BasicEList<AnnexSubclause>();
		if(topClassifier == null) {
			return result;
		}
		
		final EList<Classifier> classifiers = topClassifier.getSelfPlusAllExtended();
		if (topClassifier instanceof ComponentImplementation) {
			ComponentType ct = ((ComponentImplementation) topClassifier).getType();
			final EList<Classifier> tclassifiers = ct.getSelfPlusAllExtended();
			classifiers.addAll(tclassifiers);
		}
		
		for (Classifier classifier : classifiers) {
			result.addAll(classifier.getOwnedAnnexSubclauses());
		}
		return result;
	}
	
	@Override
	public IResizeConfiguration getResizeConfiguration(final IResizeShapeContext context) {
		final DefaultAgeResizeConfiguration conf = new DefaultAgeResizeConfiguration();
		if(bor.getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof Classifier) {
			conf.setMinimumSize(classifierMinimumWidth, classifierMinimumHeight);
		} else {
			conf.setMinimumSize(layoutService.getMinimumWidth(), layoutService.getMinimumHeight());
		}
		return conf;		
	}
	
}
