/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.internal.patterns;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.internal.AadlElementWrapper;
import org.osate.ge.internal.DefaultAgeResizeConfiguration;
import org.osate.ge.internal.patterns.AgePattern;
import org.osate.ge.internal.ui.dialogs.DefaultSelectSubprogramDialogModel;
import org.osate.ge.internal.ui.dialogs.SelectSubprogramDialog;
import org.osate.ge.internal.Categorized;
import org.osate.ge.Categories;
import org.osate.ge.internal.services.AadlFeatureService;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ComponentImplementationService;
import org.osate.ge.internal.services.ConnectionCreationService;
import org.osate.ge.internal.services.DiagramModificationService;
import org.osate.ge.internal.services.LabelService;
import org.osate.ge.internal.services.LayoutService;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.RefactoringService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.services.GhostingService;
import org.osate.ge.internal.services.ShapeCreationService;
import org.osate.ge.internal.services.StyleService;
import org.osate.ge.internal.services.UserInputService;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ImageHelper;

public class SubprogramCallSequencePattern extends AgePattern implements Categorized {
	private static final String nameShapeName = "label";
	private final NamingService namingService;
	private final ShapeCreationService shapeCreationService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final AadlFeatureService featureService;
	private final ComponentImplementationService componentImplementationService;
	private final GhostingService ghostingService;
	private final StyleService styleService;
	private final LayoutService layoutService;
	private final ShapeService shapeService;
	private final LabelService labelService;
	private final ConnectionCreationService connectionCreationService;
	private final PropertyService propertyService;
	private final RefactoringService refactoringService;
	private final UserInputService userInputService;
	private final BusinessObjectResolutionService bor;
	
	@Inject
	public SubprogramCallSequencePattern(final NamingService namingService, final ShapeCreationService shapeCreationService, final AadlModificationService aadlModService,
			final DiagramModificationService diagramModService, final AadlFeatureService featureService, final ComponentImplementationService componentImplementationService,
			final GhostingService ghostingService, final StyleService styleService, final LayoutService layoutService, 
			final ShapeService shapeService, final LabelService labelService, final ConnectionCreationService connectionCreationService, 
			final PropertyService propertyService, final RefactoringService refactoringService, final UserInputService userInputService, final BusinessObjectResolutionService bor) {
		this.namingService = namingService;
		this.shapeCreationService = shapeCreationService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.featureService = featureService;
		this.componentImplementationService = componentImplementationService;
		this.ghostingService = ghostingService;
		this.styleService = styleService;
		this.shapeService = shapeService;
		this.layoutService = layoutService;
		this.labelService = labelService;
		this.connectionCreationService = connectionCreationService;
		this.propertyService = propertyService;
		this.refactoringService = refactoringService;
		this.userInputService = userInputService;
		this.bor = bor;		
	}
	
	@Override
	public String getCategory() {
		return Categories.SUBPROGRAM_CALLS;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof SubprogramCallSequence;
	}
	
	// Add
	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			final Object targetBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
			return targetBo instanceof BehavioredImplementation || targetBo instanceof Subcomponent;
		}

		return false;
	}
	
	@Override
	public final PictogramElement add(final IAddContext context) {
		final SubprogramCallSequence cs = (SubprogramCallSequence)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		
        // Create the container shape
        final ContainerShape shape = peCreateService.createContainerShape(context.getTargetContainer(), true);
        link(shape, new AadlElementWrapper(cs));       
        
        // Finish creating
        refresh(shape, cs, context.getX(), context.getY());
        
        return shape;
	}
	
	// Update
	@Override
	public final boolean update(final IUpdateContext context) {
		final PictogramElement pe = context.getPictogramElement();
		final SubprogramCallSequence cs = (SubprogramCallSequence)bor.getBusinessObjectForPictogramElement(pe);
		
		if(pe instanceof ContainerShape) {
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if(ga == null) {
				refresh((ContainerShape)pe, cs, 255, 255);
			} else {
				refresh((ContainerShape)pe, cs, ga.getX(), ga.getY());
			}
		}
		return true;
	}
	
	private List<SubprogramCallOrder> getSubprogramCallOrders(List<SubprogramCall> subprogramCalls) {
		final List<SubprogramCallOrder> callOrders = new ArrayList<SubprogramCallOrder>();
		
		// Create SubprogramCallOrder objects to store the order of the subprogram calls
		for(int i = 1; i < subprogramCalls.size(); i++) {
			callOrders.add(new SubprogramCallOrder(subprogramCalls.get(i-1), subprogramCalls.get(i)));
		}
		
		return callOrders;
	}
	
	// Shared Between add and update
	private void refresh(final ContainerShape shape, final SubprogramCallSequence cs, final int x, final int y) {
		propertyService.setIsLogicalTreeNode(shape, true);
		
		// Handle ghosting
		ghostingService.setIsGhost(shape, false);
		ghostingService.ghostChildren(shape);
		
		final List<SubprogramCall> subprogramCalls = cs.getOwnedSubprogramCalls();

		// Create/Update subprogram call shapes
		shapeCreationService.createUpdateShapes(shape, subprogramCalls, 25, true, 30, 25, true, 20);
	
		// Create connections to represent the order of the subprogram calls
		connectionCreationService.createUpdateConnections(shape, getSubprogramCallOrders(subprogramCalls));

		// Create labels
        labelService.createLabelShape(shape, nameShapeName, cs, getName(cs));
        
        // Create appropriate symbol
        final GraphicsAlgorithm oldGa = shape.getGraphicsAlgorithm();
        final IGaService gaService = Graphiti.getGaService();
        final GraphicsAlgorithm ga = gaService.createPlainRectangle(shape);
        if(oldGa != null) {
        	ga.setWidth(oldGa.getWidth());
        	ga.setHeight(oldGa.getHeight());
        }
        ga.setStyle(styleService.getStyle("subprogram_call_sequence"));
        ga.setFilled(false);
        
        // Layout the contents of the graphics algorithm. This sets the position and size of the graphics algorithm
		layout(shape, cs, x, y);    
	}
	
	// Move
	@Override 
	protected void postMoveShape(final IMoveShapeContext context) {
		super.postMoveShape(context);

		layoutService.checkShapeBoundsWithAncestors((ContainerShape)context.getPictogramElement());
	}
	
	// Resize
	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return !propertyService.isTransient(context.getPictogramElement()); // Don't allow resizing of transient shapes such as labels
	}
	
	@Override
	public IResizeConfiguration getResizeConfiguration(IResizeShapeContext context) {
		final DefaultAgeResizeConfiguration conf = new DefaultAgeResizeConfiguration();
		conf.setMinimumSize(layoutService.getMinimumWidth(), layoutService.getMinimumHeight());
		return conf;		
	}

	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();			
		super.resizeShape(context);

		layoutService.checkShapeBoundsWithAncestors(shape);

		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());
	}
	
	// Layout
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
		final Shape nameShape = getNameShape(shape);
		
		// Create the graphics algorithm for the shape
		final int newSize[] = layoutService.getMinimumSize(shape);
		if(nameShape != null) {
			newSize[0] = Math.max(Math.max(newSize[0], layoutService.getMinimumWidth()), nameShape.getGraphicsAlgorithm().getWidth() + 30);
			newSize[1] = Math.max(Math.max(newSize[1], layoutService.getMinimumHeight()), nameShape.getGraphicsAlgorithm().getHeight() + 30);
		}
		
		gaService.setLocationAndSize(shape.getGraphicsAlgorithm(), x, y, newSize[0], newSize[1]);
		
        // Layout labels
		if(nameShape != null) {
			final int shapeWidth = shape.getGraphicsAlgorithm().getWidth();
			gaService.setLocation(nameShape.getGraphicsAlgorithm(), (shapeWidth - nameShape.getGraphicsAlgorithm().getWidth()) / 2, 5);
		}
		
		return true;	
	}
	
	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, nameShapeName);
	}
	
	// Create
	@Override
	public boolean isPaletteApplicable() {
		return bor.getBusinessObjectForPictogramElement(getDiagram()) instanceof BehavioredImplementation;
	}
	
	@Override
	public String getCreateName() {
		return "Subprogram Call Sequence";
	}
		
	@Override
	public String getCreateImageId(){
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		return ImageHelper.getImage(p.getSubprogramCallSequence().getName());
	}
	
	@Override
	public boolean canCreate(final ICreateContext context) {	
		final Object containerBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		return !(context.getTargetContainer() instanceof Diagram) && containerBo instanceof BehavioredImplementation;
	}
	
	@Override
	public Object[] create(final ICreateContext context) {
		final BehavioredImplementation bi = (BehavioredImplementation)bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		if(bi == null) {
			return EMPTY;
		}
		
		final DefaultSelectSubprogramDialogModel subprogramSelectionModel = new DefaultSelectSubprogramDialogModel(featureService, componentImplementationService, bi);
		final SelectSubprogramDialog dlg = new SelectSubprogramDialog(Display.getCurrent().getActiveShell(), subprogramSelectionModel);
		if(dlg.open() == Dialog.CANCEL) {
			return EMPTY;
		}
		
		// Get the CallContext and Called Subprogram
		final CallContext callContext = subprogramSelectionModel.getCallContext(dlg.getSelectedContext());		
		final CalledSubprogram calledSubprogram = subprogramSelectionModel.getCalledSubprogram(dlg.getSelectedSubprogram());
	
		// Get the classifier
		final String newScsName = namingService.buildUniqueIdentifier(bi, "new_call_sequence");
		final String initialSubprogramCallName = namingService.buildUniqueIdentifier(bi, "new_call");
		
		// Make the modification
		final SubprogramCallSequence newScs = aadlModService.modify(bi, new AbstractModifier<BehavioredImplementation, SubprogramCallSequence>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public SubprogramCallSequence modify(final Resource resource, final BehavioredImplementation bi) {
				
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(bi);
	 			
	 			final SubprogramCallSequence newScs = bi.createOwnedSubprogramCallSequence();
	 			newScs.setName(newScsName);

	 			// Create an initial call. Needed because call sequences must have at least one call
	 			final SubprogramCall initialSubprogramCall = newScs.createOwnedSubprogramCall();
	 			initialSubprogramCall.setName(initialSubprogramCallName);	 			
	 			initialSubprogramCall.setContext(callContext);
	 			initialSubprogramCall.setCalledSubprogram(calledSubprogram);

	 			AadlHelper.ensurePackageIsImported(bi, callContext);
	 			AadlHelper.ensurePackageIsImported(bi, calledSubprogram);
	 			
				// Clear the no calls flag
	 			bi.setNoCalls(false);
				
				return newScs;
			}
			
			@Override
			public void beforeCommit(final Resource resource, final BehavioredImplementation bi, final SubprogramCallSequence newScs) {
				diagramMod.commit();
				shapeCreationService.createShape(context.getTargetContainer(), newScs, context.getX(), context.getY());							
			}
		});

		// Return the new call sequence if it was created
		return newScs == null ? EMPTY : new Object[] {newScs};
	}
	
	// Direct Edit / Rename
    @Override
    public boolean canDirectEdit(final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
        final Object bo = bor.getBusinessObjectForPictogramElement(pe);
        final GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

        if (bo instanceof SubprogramCallSequence && pe instanceof Shape && ga instanceof Text && nameShapeName.equals(propertyService.getName(pe))) {
        	final SubprogramCallSequence cs = (SubprogramCallSequence)bo;
        	return cs.getContainingClassifier() == getComponentImplementation((Shape)pe);
        }
        
        return false;
    }
    
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
    
    public String getInitialValue(final IDirectEditingContext context) {
    	final SubprogramCallSequence cs = (SubprogramCallSequence)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
    	return getName(cs);
    }
    
    public void setValue(final String value, final IDirectEditingContext context) {
    	final PictogramElement pe = context.getPictogramElement();
    	final SubprogramCallSequence cs = (SubprogramCallSequence)bor.getBusinessObjectForPictogramElement(pe);  	
    	refactoringService.renameElement(cs, value);
    }
    
    // Delete
	@Override
	public boolean canDelete(final IDeleteContext context) {
		final PictogramElement pe = context.getPictogramElement();
        final Object bo = bor.getBusinessObjectForPictogramElement(pe);

        if (bo instanceof SubprogramCallSequence && pe instanceof Shape) {
        	final SubprogramCallSequence cs = (SubprogramCallSequence)bo;
        	return cs.getContainingClassifier() == getComponentImplementation((Shape)pe);
        }

		return false;
	}

	@Override
	public void delete(final IDeleteContext context) {
		if(!userInputService.confirmDelete(context)) {
			return;
		}

		final SubprogramCallSequence cs = (SubprogramCallSequence)bor.getBusinessObjectForPictogramElement(context.getPictogramElement());
		aadlModService.modify(cs, new AbstractModifier<SubprogramCallSequence, Object>() {
			private DiagramModificationService.Modification diagramMod;
			
			@Override
			public Object modify(final Resource resource, final SubprogramCallSequence cs) {
				// Handle diagram updates
	 			diagramMod = diagramModService.startModification();
	 			final Classifier classifier = cs.getContainingClassifier();
	 			diagramMod.markOpenRelatedDiagramsAsDirty(classifier);	 			
	 			
				// Just remove the call sequence. In the future it would be helpful to offer options for refactoring the model so that it does not
				// cause errors.
				EcoreUtil.remove(cs);
				
				return null;
			}		
			
	 		@Override
			public void beforeCommit(final Resource resource, final SubprogramCallSequence cs, final Object modificationResult) {
				diagramMod.commit();
			}
		});
				
		// Clear selection
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}
    
    // Shared
	/**
	 * Returns the first component implementation associated with the specified or a containing shape.
	 * @param shape
	 * @return
	 */
	private ComponentImplementation getComponentImplementation(final Shape shape) {
		return shapeService.getClosestBusinessObjectOfType(shape, ComponentImplementation.class);
	}
	
	private String getName(final SubprogramCallSequence cs) {
		return cs.getName() == null ? "" : cs.getName();
	}	
}
