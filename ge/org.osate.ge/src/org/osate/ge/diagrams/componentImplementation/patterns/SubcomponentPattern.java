/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.componentImplementation.patterns;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Text;
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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.diagrams.common.AgeImageProvider;
import org.osate.ge.diagrams.common.patterns.AgePattern;
import org.osate.ge.diagrams.common.patterns.ClassifierPattern;
import org.osate.ge.services.AadlArrayService;
import org.osate.ge.services.AadlFeatureService;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionCreationService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.GraphicsAlgorithmCreationService;
import org.osate.ge.services.HighlightingService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.RefactoringService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.SubcomponentService;
import org.osate.ge.services.UserInputService;
import org.osate.ge.services.VisibilityService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.util.StringUtil;

public class SubcomponentPattern extends AgePattern {
	private static LinkedHashMap<EClass, String> subcomponentTypeToCreateMethodNameMap = new LinkedHashMap<EClass, String>();
	private final AnchorService anchorUtil;
	private final VisibilityService visibilityHelper;
	private final LayoutService layoutService;
	private final ShapeCreationService shapeCreationService;
	private final AadlFeatureService featureService;
	private final SubcomponentService subcomponentService;
	private final ConnectionCreationService connectionCreationService;
	private final GraphicsAlgorithmCreationService graphicsAlgorithmCreator;
	private final HighlightingService highlightingHelper;
	private final AadlModificationService aadlModService;
	private final NamingService namingService;
	private final DiagramModificationService diagramModService;
	private final UserInputService userInputService;
	private final ShapeService shapeService;
	private final RefactoringService refactoringService;
	private final PropertyService propertyService;
	private final AadlArrayService arrayService;
	private final BusinessObjectResolutionService bor;
	private final EClass subcomponentType;

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
	public SubcomponentPattern(final AnchorService anchorUtil, final VisibilityService visibilityHelper, final LayoutService resizeHelper, 
			final ShapeCreationService shapeCreationService, AadlFeatureService featureService, SubcomponentService subcomponentService, 
			final ConnectionCreationService connectionCreationService, final GraphicsAlgorithmCreationService graphicsAlgorithmCreator, 
			final HighlightingService highlightingHelper, final AadlModificationService aadlModService, final NamingService namingService,
			final DiagramModificationService diagramModService, final UserInputService userInputService, final ShapeService shapeService, 
			final RefactoringService refactoringService, final PropertyService propertyService, final AadlArrayService arrayService,
			final BusinessObjectResolutionService bor, final @Named("Subcomponent Type") EClass subcomponentType) {
		this.anchorUtil = anchorUtil;
		this.visibilityHelper = visibilityHelper;
		this.layoutService = resizeHelper;
		this.shapeCreationService = shapeCreationService;
		this.featureService = featureService;
		this.subcomponentService = subcomponentService;
		this.connectionCreationService = connectionCreationService;
		this.graphicsAlgorithmCreator = graphicsAlgorithmCreator;
		this.highlightingHelper = highlightingHelper;
		this.aadlModService = aadlModService;
		this.namingService = namingService;
		this.diagramModService = diagramModService;
		this.userInputService = userInputService;
		this.shapeService = shapeService;
		this.refactoringService = refactoringService;
		this.propertyService = propertyService;
		this.arrayService = arrayService;
		this.bor = bor;
		this.subcomponentType = subcomponentType;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return subcomponentType.isInstance(AadlElementWrapper.unwrap(mainBusinessObject));
	}

	@Override
	public boolean isPaletteApplicable() {
		final Object diagramBo = bor.getBusinessObjectForPictogramElement(getDiagram());
		return isComponentImplementationDiagram() ? SubcomponentPattern.canContainSubcomponentType((ComponentImplementation)diagramBo, subcomponentType) : false;
	}
	
	
	@Override
	public boolean canAdd(final IAddContext context) {
		return isMainBusinessObjectApplicable(context.getNewObject());
	}
	
	@Override
	public boolean canUpdate(final IUpdateContext context) {
		if(!super.canUpdate(context)) {
			return false;
		}
		
		// Return that the shape can be updated if the subcomponent is actually a subcomponent of the component implementation
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		return getComponentImplementation((Shape)context.getPictogramElement()).getAllSubcomponents().contains(sc);
	}
	
	@Override
	public boolean canMoveShape(final IMoveShapeContext context) {
		return super.canMoveShape(context);
	}
	
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(shape));
		this.refresh(shape, sc, context.getX(), context.getY(), context.getWidth(), context.getHeight());
		
		if(layoutService.checkContainerSize(shape)) {
			getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();
		}
		
		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());
	}

	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		if(layoutService.checkContainerSize((ContainerShape)context.getPictogramElement())) {
			getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();
		}
	}
	
	@Override
	public IReason updateNeeded(final IUpdateContext context) {
		return Reason.createFalseReason();
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {	
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(sc));        
				
		// Finish Creating the Shape
        refresh(shape, sc, context.getX(), context.getY(), 0, 0);

        return shape;
	}

	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final Subcomponent sc = (Subcomponent)AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pe));
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			final int x, y, width, height;
			if(ga == null) {
				x = y = 25;
				width = height = 0;
			} else {
				x = ga.getX();
				y = ga.getY();
				width = ga.getWidth();
				height = ga.getHeight();
			}
			this.refresh((ContainerShape)pe, sc, x, y, width, height);
		}
		return true;
	}
	
	private void refresh(final ContainerShape shape, final Subcomponent sc, final int x, final int y, final int minWidth, final int minHeight) {
		visibilityHelper.setIsGhost(shape, false);
		
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
		// Remove invalid flow specifications from the diagram
		visibilityHelper.ghostInvalidConnections(null);
		
		// Remove invalid shapes
		visibilityHelper.ghostInvalidShapes(shape);

// TODO: Marker
		final Set<Shape> childShapesToGhost = new HashSet<Shape>();
		childShapesToGhost.addAll(visibilityHelper.getNonGhostChildren(shape));

		// Create/update child shapes
		final Classifier classifier = subcomponentService.getComponentClassifier(shape,  sc);
		if(classifier != null) {
			final List<Shape> touchedShapes = new ArrayList<Shape>();
			shapeCreationService.createUpdateFeatureShapes(shape, featureService.getAllOwnedFeatures(classifier), touchedShapes);
			childShapesToGhost.removeAll(touchedShapes);
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
		
		// Create/Update Flow Specifications
		if(componentType != null) {
			connectionCreationService.createUpdateConnections(shape, componentType.getAllFlowSpecifications());
		} 

		// Ghost child shapes that were not updated
		for(final Shape child : childShapesToGhost) {
			visibilityHelper.setIsGhost(child, true);
		}
		
		// Create label
        final Shape labelShape = peCreateService.createShape(shape, false);
        propertyService.setIsManuallyPositioned(labelShape, true);
        link(labelShape, new AadlElementWrapper(sc));
        final String name = getLabelText(sc);
        final GraphicsAlgorithm labelBackground = graphicsAlgorithmCreator.createTextBackground(labelShape);		
        final Text labelText = graphicsAlgorithmCreator.createLabelGraphicsAlgorithm(labelBackground, name);
        final IDimension textSize = GraphitiUi.getUiLayoutService().calculateTextSize(labelText.getValue(), labelText.getStyle().getFont());
        
		// Create Subcomponent Type Indicator
        final Shape subcomponentTypeIndicatorShape = peCreateService.createShape(shape, false);
        propertyService.setIsManuallyPositioned(subcomponentTypeIndicatorShape, true);
        final String subcomponentTypeName = getTypeText(sc);
        final GraphicsAlgorithm subcomponentTypeLabelBackground = graphicsAlgorithmCreator.createTextBackground(subcomponentTypeIndicatorShape);
        final MultiText subcomponentTypeText = graphicsAlgorithmCreator.createMultiLineLabelGraphicsAlgorithm(subcomponentTypeLabelBackground, subcomponentTypeName);
        final IDimension unpaddedSubcomponentTypeTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(subcomponentTypeText.getValue(), subcomponentTypeText.getStyle().getFont(), true);
        
        // Currently adding padding to work around incorrect size being returned by calculateTextSize(). 
        final int paddedTypeTextWidth = unpaddedSubcomponentTypeTextSize.getWidth() + 10;
        final int paddedTypeTextHeight = unpaddedSubcomponentTypeTextSize.getHeight() + 10;
        
		// Adjust size. Width and height
		final IGaService gaService = Graphiti.getGaService();
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// Calculate max width and height
		int maxWidth = Math.max(minWidth, 150);
		int maxHeight = Math.max(minHeight, 50);
		final int extraWidth = 50;
		final int extraHeight = 30;
		maxWidth = Math.max(maxWidth, Math.max(textSize.getWidth(), paddedTypeTextWidth) + extraWidth);
		for(final Shape childShape : visibilityHelper.getNonGhostChildren(shape)) {
			final GraphicsAlgorithm childGa = childShape.getGraphicsAlgorithm();
			
			// Ignore shape like the label when determining size.
			if(getBusinessObjectForPictogramElement(childShape) != null) {
				maxWidth = Math.max(maxWidth, childGa.getWidth() + extraWidth);
				maxHeight = Math.max(maxHeight, childGa.getY() + childGa.getHeight() + extraHeight);
			}
		}		

		// Create the graphics Algorithm
		ga = graphicsAlgorithmCreator.createClassifierGraphicsAlgorithm(shape, sc, maxWidth, maxHeight);  
		gaService.setLocation(ga, x, y);
		ga.setFilled(false);
		
		// Set the position of the text
		gaService.setLocationAndSize(labelText, 0, 0, textSize.getWidth(), textSize.getHeight());
		gaService.setLocationAndSize(labelBackground, (ga.getWidth() - textSize.getWidth()) / 2, 2, textSize.getWidth(), textSize.getHeight());
		gaService.setLocationAndSize(subcomponentTypeText, 0, 0, paddedTypeTextWidth, paddedTypeTextHeight);
		gaService.setLocationAndSize(subcomponentTypeLabelBackground, (ga.getWidth() - paddedTypeTextWidth) / 2, labelText.getY()+textSize.getHeight(), paddedTypeTextWidth, paddedTypeTextHeight);
		
		// Set color based on current mode
		highlightingHelper.highlight(sc, null, ga);		
	
		layoutService.layoutChildren(shape);
		anchorUtil.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}
		
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

		// TODO: Show types of all subcomponents if collapsed?
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

	@Override
	public boolean canCreate(final ICreateContext context) {
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		return !(context.getTargetContainer() instanceof Diagram) && (containerBo instanceof ComponentImplementation ? SubcomponentPattern.canContainSubcomponentType((ComponentImplementation)containerBo, subcomponentType) : false);
	}
	
	@Override
	public String getCreateImageId(){
		return AgeImageProvider.getImage(subcomponentType);
	}
	
	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(subcomponentType.getName());
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
	public Object[] create(final ICreateContext context) {
		final Subcomponent newSubcomponent = aadlModService.modify(getComponentImplementation(context.getTargetContainer()), new AbstractModifier<ComponentImplementation, Subcomponent>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Subcomponent modify(final Resource resource, final ComponentImplementation ci) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markRelatedDiagramsAsDirty(ci);

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
	
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final Subcomponent sc = (Subcomponent)bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()));
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());
		return sc.getContainingClassifier() == containerBo;
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
	 			diagramMod.markRelatedDiagramsAsDirty(getComponentImplementation((Shape)context.getPictogramElement()));
	 			
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
    public String checkValueValid(final String value, final IDirectEditingContext context) {
    	return namingService.checkNameValidity((NamedElement)bor.getBusinessObjectForPictogramElement(context.getPictogramElement()), value);
    }
 
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
        final Object bo = bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
        
        // To be able to be renamed the subcomponent must be contained by the component implementation represented by the diagram and it must not be refined
        if (bo instanceof Subcomponent && ga instanceof Text) {
        	final Subcomponent sc = (Subcomponent)bo;
        	return sc.getContainingClassifier() == getComponentImplementation((Shape)context.getPictogramElement()) && sc.getRefined() == null;
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
	
	/**
	 * Returns whether the specified component implementation supports subcomponents of the specified type
	 * @param subcomponentOwner
	 * @param subcomponentClass
	 * @return
	 */
	public static boolean canContainSubcomponentType(final ComponentImplementation subcomponentOwner, final EClass subcomponentClass) {
		return getSubcomponentCreateMethod(subcomponentOwner, subcomponentClass) != null;
	}
}
