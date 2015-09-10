package org.osate.ge.diagrams.common.patterns;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.AnchorService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.DiagramModificationService;
import org.osate.ge.services.GhostingService;
import org.osate.ge.services.LabelService;
import org.osate.ge.services.LayoutService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.ShapeCreationService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.util.StringUtil;

/**
 * Pattern for handling Annex libraries and subclauses
 *
 */
public class AnnexPattern extends AgePattern {
	private final static String annexLabelName = "annex_label";
	private final static double topOfFolderOffsetValue = 0.1;
	private final static double tabStartOffsetValue = 0.05;
	private final static double topOfTabOffsetValue = 0.3;
	private final GhostingService ghostingService;
	private final AnchorService anchorService;
	private final ShapeService shapeService;
	private final LabelService labelService;
	private final LayoutService layoutService;
	private final BusinessObjectResolutionService bor;
	private final PropertyService propertyService;
	private final AadlModificationService aadlModService;
	private final DiagramModificationService diagramModService;
	private final ShapeCreationService shapeCreationService;
	private final NamingService namingService;
	private final EClass annexType;

	@Inject
	public AnnexPattern(final GhostingService ghostingService, final AnchorService anchorService, final ShapeService shapeService, final LabelService labelService, 
			final LayoutService layoutService, final BusinessObjectResolutionService bor, final PropertyService propertyService, final AadlModificationService aadlModService,
			final DiagramModificationService diagramModService, final ShapeCreationService shapeCreationService, final NamingService namingService, final @Named("Annex Type") EClass annexType) {
		this.ghostingService = ghostingService;
		this.anchorService = anchorService;
		this.shapeService = shapeService;
		this.labelService = labelService;
		this.layoutService = layoutService;
		this.propertyService = propertyService;
		this.aadlModService = aadlModService;
		this.diagramModService = diagramModService;
		this.shapeCreationService = shapeCreationService;
		this.namingService = namingService;
		this.bor = bor;
		this.annexType = annexType;
	}

	@Override
	public String getCreateName() {
		return StringUtil.camelCaseToUser(annexType.getName());
	}

	/*@Override
	public String getCreateImageId(){
		return AgeImageProvider.getImage(annexType.getName());
	}*/

	@Override
	public boolean isMainBusinessObjectApplicable(final Object mainBusinessObject) {
		final Object bo = AadlElementWrapper.unwrap(mainBusinessObject);
		return bo instanceof AnnexLibrary || bo instanceof AnnexSubclause;
	}

	@Override
	public boolean isPaletteApplicable() {
		if(annexType == null) {
			return false;
		} else if(isAnnexLibrary(annexType, getAnnexLibrary())) {
			return isPackageDiagram();
		} else {
			return /*isAnnexSubclauseType(annexType, getAnnexSubclause()) && */isClassifierDiagram();
		}
	}

	/**
	 * Determine if the current annex type is a AnnexLibrary
	 * @param annexType the current annex type EClass
	 * @param annexSubclause the AnnexLibrary EClass
	 * @return
	 */
	private static boolean isAnnexLibrary(final EClass annexType, final EClass annexLibrary) {
		return annexType == annexLibrary;
	}

	@Override
	public boolean canAdd(final IAddContext context) {
		if(isMainBusinessObjectApplicable(context.getNewObject())) {
			final Object targetBo = bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
			return targetBo instanceof Classifier || targetBo instanceof AadlPackage;
		}

		return false;
	}

	//TODO: delete
	@Override
	public boolean canDelete(final IDeleteContext context) {
		return true;
	}

	//TODO: fix size when added to diagram
	@Override
	public final PictogramElement add(final IAddContext context) {
		final NamedElement neNewAnnex = (NamedElement)AadlElementWrapper.unwrap(context.getNewObject());
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();
		final IGaService gaService = Graphiti.getGaService();
		
		// Create the container shape for the generic representation
		final ContainerShape containerShape = peCreateService.createContainerShape(context.getTargetContainer(), true);
		final Rectangle invisRect = gaService.createInvisibleRectangle(containerShape);

		gaService.setLocation(invisRect, context.getX(), context.getY());

		link(containerShape, new AadlElementWrapper(neNewAnnex));

		// Create Graphics Algorithm
		createGraphicsAlgorithm(containerShape, context.getX(), context.getY(), getDiagram());

		// Finish creating
		refresh(containerShape);

		return containerShape;
	}

	/**
	 * Creating the graphics algorithm and setting the location for the new pictogram element
	 * @param containerShape the ContainerShape we are attaching the graphics algorithm to
	 * @param bo the new 
	 * @param x the x-coordinate the new shape will be placed
	 * @param y the y-coordinate the new shape will be placed
	 * @param diagram the current diagram
	 */
	private static void createGraphicsAlgorithm(final ContainerShape containerShape, final int x, final int y, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		final GraphicsAlgorithm csGraphicsAlgorithm = containerShape.getGraphicsAlgorithm();
		final int width = csGraphicsAlgorithm.getWidth();
		final int height = csGraphicsAlgorithm.getHeight();
		final GraphicsAlgorithm ga = createFolderShape(containerShape, width, height, diagram);

		gaService.setLocationAndSize(ga, x, y, width, height);
	}

	/**
	 * Drawing and setting the style for the new GraphicsAlgorithm
	 * @param containerShape the ContainerShape we are attaching the graphics algorithm to
	 * @param width the width of the shape
	 * @param height the height of the shape
	 * @param diagram the current diagram
	 * @return the drawn graphics algorithm
	 */
	private static GraphicsAlgorithm createFolderShape(final ContainerShape containerShape, final int width, final int height, final Diagram diagram) {
		final IGaService gaService = Graphiti.getGaService();
		//Height of tab on folder shape
		final int heightOfTab = (int)(height*topOfFolderOffsetValue);
		//Width from left side of shape to top of tab
		final int tabStartOffset = (int)(width*tabStartOffsetValue);
		//Width of tab
		final int widthOfTab = (int)(width*topOfTabOffsetValue);

		final GraphicsAlgorithm ga = gaService.createPlainPolygon(containerShape, 
				new int[] {
				0, height,
				0, heightOfTab,
				tabStartOffset, 0,
				widthOfTab, 0,
				widthOfTab+tabStartOffset, heightOfTab,
				width, heightOfTab,
				width, height});
		
		setStyle(ga, diagram, gaService);

		return ga;
	}

	/**
	 * Set the style for the new GraphicsAlgorithm
	 * @param ga the new GraphicsAlgorithm
	 * @param diagram the current diagram
	 * @param gaService service for managing GraphicsAlgorithms
	 */
	private static void setStyle(final GraphicsAlgorithm ga, final Diagram diagram, final IGaService gaService) {
		ga.setFilled(true);
		ga.setBackground(gaService.manageColor(diagram, IColorConstant.WHITE));
		ga.setForeground(gaService.manageColor(diagram, IColorConstant.BLACK));
		ga.setLineStyle(LineStyle.SOLID);
		ga.setLineVisible(true);
		ga.setLineWidth(2);
		ga.setTransparency(0.0);
	}

	// Update
	@Override
	public final boolean update(final IUpdateContext context) {
		// TODO: Probably need a way of tagging shapes as being generic...
		// Update the generic representation
		final PictogramElement pe = context.getPictogramElement();
		if(pe instanceof ContainerShape) {
			final ContainerShape shape = (ContainerShape)pe;
			final GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			if(ga == null) {
				createGraphicsAlgorithm(shape, 25, 25, getDiagram());
			}

			refresh((ContainerShape)pe);
		}

		return true;
	}

	// Refresh
	private void refresh(final ContainerShape shape) {
		ghostingService.setIsGhost(shape, false);

		final NamedElement annexElement = (NamedElement)bor.getBusinessObjectForPictogramElement(shape);
		final Set<Shape> childShapesToGhost = new HashSet<Shape>(shapeService.getNonGhostChildren(shape));
		final List<Shape> touchedShapes = new ArrayList<>();

		// Ghost Shapes
		childShapesToGhost.removeAll(touchedShapes);
		for(final Shape child : childShapesToGhost) {
			ghostingService.setIsGhost(child, true);
		}

		// Create label shape
		labelService.createLabelShape(shape, annexLabelName,  annexElement, annexElement.getName());

		// Layout
		layoutPictogramElement(shape);

		anchorService.createOrUpdateChopboxAnchor(shape, chopboxAnchorName);
	}	

	// Layout
	@Override
	public boolean canLayout(final ILayoutContext context) {
		return isMainBusinessObjectApplicable(getBusinessObjectForPictogramElement(context.getPictogramElement())) && context.getPictogramElement() instanceof ContainerShape;
	}

	//TODO: change annex library name?
	@Override
	public boolean canDirectEdit(final IDirectEditingContext context) {
		return true;
	};

	@Override
	public boolean canResizeShape(final IResizeShapeContext context) {
		return true;
	};

	@Override
	public void resizeShape(final IResizeShapeContext context) {
		final ContainerShape shape = (ContainerShape)context.getPictogramElement();	

		super.resizeShape(context);

		layoutService.checkContainerSize(shape);

		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();

		// When the graphics algorithm is recreated, the selection is lost. This triggers the selection to be restored on the next editor refresh 
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().getSelectedPictogramElements());		
	};

	@Override
	public boolean layout(final ILayoutContext context) {
		final ContainerShape containerShape = (ContainerShape)context.getPictogramElement();
		final int x = containerShape.getGraphicsAlgorithm().getX();
		final int y = containerShape.getGraphicsAlgorithm().getY();
		/*final NamedElement neNewAnnex = (NamedElement)bor.getBusinessObjectForPictogramElement(containerShape);*/

		final IGaService gaService = Graphiti.getGaService();
		final Shape nameShape = Objects.requireNonNull(getNameShape(containerShape), "unable to retrieve name shape");
		propertyService.setIsUnselectable(nameShape, true);
		
		// Determine size of the shape
		final int[] newSize = layoutService.adjustChildShapePositions(containerShape); 

		final GraphicsAlgorithm nameShapeGraphicsAlgorithm = nameShape.getGraphicsAlgorithm();
		// Enforce a minimum size for classifiers
		newSize[0] = Math.max(Math.max(newSize[0], layoutService.getMinimumWidth()), nameShapeGraphicsAlgorithm.getWidth() + 30);
		newSize[1] = Math.max(Math.max(newSize[1], layoutService.getMinimumHeight()), nameShapeGraphicsAlgorithm.getHeight() + 30);
		
		final GraphicsAlgorithm csGraphicsAlgorithm = containerShape.getGraphicsAlgorithm();
		gaService.setSize(csGraphicsAlgorithm, newSize[0], newSize[1]);

		// Create new graphics algorithm
		createGraphicsAlgorithm(containerShape, x, y, getDiagram());

		
		final int shapeWidth = csGraphicsAlgorithm.getWidth();
		//Get offset for height of folder tab
		final int shapeHeight = csGraphicsAlgorithm.getHeight() + (int)(csGraphicsAlgorithm.getHeight()*topOfFolderOffsetValue);
		// Layout Labels
		gaService.setLocation(nameShapeGraphicsAlgorithm, (shapeWidth - nameShapeGraphicsAlgorithm.getWidth()) / 2, ((shapeHeight - (nameShapeGraphicsAlgorithm.getHeight()))/2));		

		// Refresh. For some reason if it is not refreshed, some shapes may not be drawn correctly.
		getFeatureProvider().getDiagramTypeProvider().getDiagramBehavior().refresh();

		return true;
	}

	private Shape getNameShape(final ContainerShape shape) {
		return shapeService.getChildShapeByName(shape, annexLabelName);
	}

	@Override
	public boolean canCreate(final ICreateContext context) {
		if(context.getTargetConnection() == null) {
			if(annexType == null) {
				return false;
			} else if(isAnnexLibrary(annexType, getAnnexLibrary())) {
				return isPackageDiagram() && context.getTargetContainer() instanceof Diagram;
			} else {
				return isClassifierDiagram() && isValidClassifier(context);
			}
		}

		return false;
	};

	private boolean isValidClassifier(final ICreateContext context) {
		return !(context.getTargetContainer() instanceof Diagram) && bor.getBusinessObjectForPictogramElement(getDiagram()) == bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
	}

	@Override
	public Object[] create(final ICreateContext context) {
		final NamedElement containerElement = (NamedElement)bor.getBusinessObjectForPictogramElement(context.getTargetContainer());
		final AnnexNameDialog annexNameDialog = new AnnexNameDialog(Display.getCurrent().getActiveShell(), containerElement, namingService, getDialogTitleAndMessage(annexType));
		if (annexNameDialog.open() == Dialog.CANCEL || annexNameDialog.getValue() == null) {
			return null;
		}

		final Object newAnnexObject = createAndModifyAnnex(context, containerElement, annexNameDialog.getValue(), annexType);

		return newAnnexObject == null ? null : new Object[] {newAnnexObject};
	}

	private Object createAndModifyAnnex(final ICreateContext context, final NamedElement targetContainer, final String newAnnexName, final EClass annexType) {
		final NamedElement newAnnex = aadlModService.modify(targetContainer, new AbstractModifier<NamedElement, NamedElement>() {
			private DiagramModificationService.Modification diagramMod;

			@Override
			public NamedElement modify(final Resource resource, final NamedElement neNewAnnex) {
				diagramMod = diagramModService.startModification();
				final NamedElement newAnnex = createAnnex(targetContainer, newAnnexName, annexType);
				
				return newAnnex;
			}

			@Override
			public void beforeCommit(final Resource resource, final NamedElement aadlPackage, final NamedElement neNewAnnex) {
				diagramMod.commit();
				shapeCreationService.createShape(context.getTargetContainer(), neNewAnnex, context.getX(), context.getY());
			}
		});

		// If the shape was dropped on the diagram, set the location of the new shape
		if(newAnnex != null && context.getTargetContainer() instanceof Diagram) {
			Shape newShape = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), newAnnex);

			// If the update feature hasn't been called, add the shape to the diagram
			if(newShape == null) {
				final AddContext addContext = new AddContext();
				addContext.setTargetContainer(getDiagram());
				addContext.setNewObject(new AadlElementWrapper(newAnnex));				

				// Execute the add feature
				final IAddFeature addFeature = this.getFeatureProvider().getAddFeature(addContext);
				if(addFeature != null && addFeature.canAdd(addContext)) {
					addFeature.execute(addContext);
				}

				// Try to find the shape again
				newShape = shapeService.getDescendantShapeByElementQualifiedName(getDiagram(), newAnnex);			
			}

			if(newShape != null) {
				Graphiti.getGaService().setLocation(newShape.getGraphicsAlgorithm(), context.getX(), context.getY());
				propertyService.setIsLayedOut(newShape, true);
			}
		}

		return newAnnex;
	}

	/**
	 * Determine which type of Annex to create then return the new Annex
	 * @param targetContainer the element the new AnnexLibrary or AnnexSubclause will be added to
	 * @param newAnnexName the name of the new AnnexLibrary or AnnexSubclause
	 * @param annexType the current annex type, either AnnexLibrary or AnnexSubclause
	 * @return the new AnnexLibrary or AnnexSubclause
	 */
	protected static NamedElement createAnnex(final NamedElement targetContainer, final String newAnnexName, final EClass annexType) {
		final NamedElement neContainer = getClassifier(targetContainer) != null ? getClassifier(targetContainer)
			: Objects.requireNonNull(getAadlPackage(targetContainer), "AadlPackage cannot be null.");
		return isAnnexLibrary(annexType, getAnnexLibrary()) ? createAnnexLibrary(neContainer, newAnnexName)
			: createAnnexSubclause(neContainer, newAnnexName);
	}

	private static EClass getAnnexLibrary() {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getAnnexLibrary();
	}

	private static Classifier getClassifier(final NamedElement targetContainer) {
		return targetContainer instanceof Classifier ? (Classifier)targetContainer : null;
	}

	/**
	 * Creating the new AnnexLibrary
	 * @param neContainer the element the new AnnexSubclause is being added to
	 * @param newAnnexLibraryName the name of the new AnnexLibrary
	 * @return
	 */
	private static AnnexLibrary createAnnexLibrary(final NamedElement neContainer, final String newAnnexLibraryName) {
		final DefaultAnnexLibrary annexLibrary = (DefaultAnnexLibrary)((AadlPackage)neContainer).getPublicSection().createOwnedAnnexLibrary(getAnnexLibrary());
		annexLibrary.setSourceText("{** **}");
		annexLibrary.setName(newAnnexLibraryName);

		return annexLibrary;
	}

	/**
	 * Creating the new AnnexSubclause
	 * @param neContainer the element the new AnnexSubclause is being added to
	 * @param newAnnexSubclauseName the name of the new AnnexSubclause
	 * @return
	 */
	private static AnnexSubclause createAnnexSubclause(final NamedElement neContainer, final String newAnnexSubclauseName) {
		final DefaultAnnexSubclause annexSubclause = (DefaultAnnexSubclause)((Classifier)neContainer).createOwnedAnnexSubclause(getAnnexSubclause());
		annexSubclause.setName(newAnnexSubclauseName);
		annexSubclause.setSourceText("{** **}");

		return annexSubclause;
	}

	private static EClass getAnnexSubclause() {
		return Aadl2Factory.eINSTANCE.getAadl2Package().getAnnexSubclause();
	}

	private static AadlPackage getAadlPackage(final NamedElement targetContainer) {
		return targetContainer instanceof AadlPackage ? (AadlPackage)targetContainer : null;
	}

	/**
	 * The dialog for naming the new AnnexLibrary or AnnexSubclause
	 */
	private static class AnnexNameDialog extends InputDialog {
		public AnnexNameDialog(final Shell parentShell, final NamedElement targetContainer, final NamingService namingService, final String[] dialogTitleAndMessage) {
			super(parentShell, dialogTitleAndMessage[0], dialogTitleAndMessage[1], "", new IInputValidator() {
				@Override
				public String isValid(final String newName) {
					boolean invalid = false;
					//Check if target has name in use
				//	System.err.println(targetContainer.getNamespace());
					if(targetContainer.getNamespace() != null) {
						namingService.isNameInUse(targetContainer.getNamespace(), newName);
					}
					if(/*isNameInUse(targetContainer, newName) || */!namingService.isValidIdentifier(newName)) {
						invalid = true;
					}

					return invalid ? "The specified name is not valid." : null;
				}
			});
		}
		
		private static boolean isNameInUse(final NamedElement namedElement, final String newName) {
			for (final Element element : namedElement.allOwnedElements()) {
				if(element instanceof NamedElement) {
					if(((NamedElement)element).getName().equalsIgnoreCase(newName)) {
						
						return true;
					}
				}
			}
			
			return false;
		}
	}
	
	/**
	 * Determine title and message for input dialog
	 * @param annexType AnnexLibrary or AnnexSubclause
	 * @return the title and message for the input dialog
	 */
	private static String[] getDialogTitleAndMessage(final EClass annexType) {
		final String[] dialogTitleAndMessage = new String[2];
		if(isAnnexLibrary(annexType, getAnnexLibrary())) {
			dialogTitleAndMessage[0] = "Create Annex Library";
			dialogTitleAndMessage[1] = "Enter a name for the new Annex Library.";
		} else {
			dialogTitleAndMessage[0] = "Create Annex Subclause";
			dialogTitleAndMessage[1] = "Enter a name for the new Annex Subclause.";
		}

		return dialogTitleAndMessage;
	}
}
