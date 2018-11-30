package org.osate.ge.internal.graphiti.diagram;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Color;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ChopboxAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeConnectionTerminator;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.graphics.internal.ConnectionTerminatorSize;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.graphics.internal.Poly;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.BeforeModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationChangedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.ElementAddedEvent;
import org.osate.ge.internal.diagram.runtime.ElementRemovedEvent;
import org.osate.ge.internal.diagram.runtime.ElementUpdatedEvent;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.styling.StyleCalculator;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.graphiti.AnchorNames;
import org.osate.ge.internal.graphiti.ShapeNames;
import org.osate.ge.internal.graphiti.graphics.AgeGraphitiGraphicsUtil;
import org.osate.ge.internal.services.ActionExecutor;

/**
 * Class that integrates AgeDiagram with Graphiti.
 * Handles updating the Graphiti diagram to reflect changes in the AgeDiagram.
 * The Graphiti diagram must not be modified directly.
 * Not all style fields are supported as both the graphical configuration or diagram element style.
 *
 */
public class GraphitiAgeDiagram implements NodePictogramBiMap, AutoCloseable {
	public final static String AADL_DIAGRAM_TYPE_ID = "AADL Diagram";
	public final static String incompleteIndicator = "*";
	private final static int defaultWrappingLabelWidth = 100;

	// Padding to wrapping label shapes
	// This value is based on the padding added by the ELK layout process. Ideally, this value should be provided
	// to ELK via the LayoutInfoProvider. If this value is misconfigured, repeated layouts will change the width of shapes
	// which including wrapping labels
	private final static int wrappingLabelPadding = 10;
	private final static int wrappingLabelMinWidth = 50;

	// This is additional padding to prevent wrapping label text from extending all the way to the right edge of the note shape.
	// Will need to be adjusted if/when additional business object handlers use wrapping labels. Could be made part
	// of the diagram configuration.
	// If this value is larger than min width, it could result in negative widths. That must not be occur.
	private final static int wrappingLabelInnerPaddingX = 22 - wrappingLabelPadding;

	private LocalResourceManager localResourceManager = new LocalResourceManager(AgeDiagramTypeProvider.getResources());

	private final UpdaterListener updateListener;
	private final AgeDiagram ageDiagram;
	private final Diagram graphitiDiagram;
	private final ColoringProvider coloringProvider;
	private final LabelHelper labelHelper = new LabelHelper();
	private final Map<PictogramElement, DiagramNode> pictogramElementToDiagramNodeMap = new HashMap<>();
	private final Map<DiagramNode, PictogramElement> diagramNodeToPictogramElementMap = new HashMap<>();
	private final GraphitiDiagramModificationListener modificationListener = new GraphitiDiagramModificationListener();
	private final StyleCalculator finalStyleProvider;
	private Map<DiagramElement, org.osate.ge.graphics.Color> overrideForegroundColorMap = Collections.emptyMap();

	public interface UpdaterListener {
		// Called when an update is finished
		void onUpdateFinished();
	}

	/**
	 *
	 * @param ageDiagram is the AgeDiagram that will be associated with the Graphiti Diagram
	 * @param graphitiDiagram is the internal graphiti diagram to associated with the Graphiti Age Diagram.
	 * It is a parameter rather than creating it in the constructor to work around initializing sequence issues.
	 * @param editingDomain is the editing domain to use to make modifications to the diagram. It must not contain any other diagrams.
	 */
	public GraphitiAgeDiagram(final AgeDiagram ageDiagram, final Diagram graphitiDiagram,
			final ActionExecutor actionExecutor, final ColoringProvider coloringProvider,
			final UpdaterListener updateListener) {
		this.ageDiagram = Objects.requireNonNull(ageDiagram, "ageDiagram must not be null");
		this.updateListener = Objects.requireNonNull(updateListener, "updateListener must not be null");
		this.graphitiDiagram = Objects.requireNonNull(graphitiDiagram, "graphitiDiagram must not be null");
		addMapping(ageDiagram, graphitiDiagram);
		this.coloringProvider = Objects.requireNonNull(coloringProvider, "coloringProvider must not be null");

		this.finalStyleProvider = new StyleCalculator(ageDiagram.getConfiguration(), de -> {
			final org.osate.ge.graphics.Color foreground = overrideForegroundColorMap.get(de);
			if (foreground == null) {
				return Style.EMPTY;
			} else {
				return StyleBuilder.create().foregroundColor(foreground).build();
			}
		});

		// Perform the initial update of the graphiti diagram
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(graphitiDiagram);
		if (editingDomain == null) {
			buildGraphitiDiagram();
		} else {
			editingDomain.getCommandStack().execute(new AbstractCommand() {
				@Override
				protected boolean prepare() {
					return true;
				}

				@Override
				public void execute() {
					buildGraphitiDiagram();
				}

				@Override
				public boolean canUndo() {
					return false;
				}

				@Override
				public void redo() {
				}
			});

		}

		// Listen for resource change
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
		ageDiagram.addModificationListener(modificationListener); // Listen for updates

		// Register the specified action executor with the diagram
		ageDiagram.setActionExecutor(actionExecutor);
	}

	private void buildGraphitiDiagram() {
		ageDiagram.modify("Initial Update", m -> createUpdateElementsFromAgeDiagram(m));
		refreshDiagramStyles(); // Update style of graphiti pictogram elements.
	}

	// When an image resource is added/removed/modified, the diagram updates accordingly
	private IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		@Override
		public void resourceChanged(IResourceChangeEvent event) {
			final AgeDiagram ageDiagram = getAgeDiagram();
			for (final DiagramNode dn : ageDiagram.getAllDiagramNodes().filter(dn -> dn instanceof DiagramElement)
					.collect(Collectors.toSet())) {
				final DiagramElement de = (DiagramElement) dn;
				final IPath image = de.getStyle().getImagePath();
				if (image != null) {
					// Check if diagram needs an update
					final boolean resource = isDiagramUpdateRequired(event.getDelta(), image);
					if (resource) {
						// Only update diagram if an image that is referenced by the diagram is modified/added/removed
						Display.getDefault().asyncExec(() -> {
							ageDiagram.modify("Update Diagram After Resource Change", m -> {
								createUpdateElementsFromAgeDiagram(m);
							});
						});
						break;
					}
				}
			}
		}

		/**
		 * Determine if resource added/removed/changed is referenced by the diagram
		 * @param delta
		 * @param image path
		 * @return
		 */
		private boolean isDiagramUpdateRequired(final IResourceDelta delta, final IPath image) {
			if (delta != null) {
				if (delta.getKind() == IResourceDelta.ADDED) {
					final IPath movedFromPath = delta.getMovedFromPath();
					final IPath fullPath = delta.getFullPath();
					final IPath compPath = movedFromPath == null ? fullPath : movedFromPath;
					return image.equals(compPath);
				}

				if (delta.getKind() == IResourceDelta.REMOVED) {
					final IPath movedToPath = delta.getMovedToPath();
					final IPath compPath = movedToPath == null ? delta.getFullPath() : movedToPath;
					return image.equals(compPath);
				}

				for (final IResourceDelta childDelta : delta.getAffectedChildren()) {
					final boolean updateRequired = isDiagramUpdateRequired(childDelta, image);
					if (updateRequired) {
						return updateRequired;
					}
				}
			}
			return false;
		}

	};

	private void refreshOverrideForegroundColorMap() {
		overrideForegroundColorMap = coloringProvider.buildForegroundColorMap();
	}

	/**
	 * Creates/Updates and lays out graphiti elements for all diagram elements. Does not remove elements which are no longer in the graphiti diagram.
	 */
	private void createUpdateElementsFromAgeDiagram(final DiagramModification mod) {
		ensureCreatedChildren(ageDiagram, graphitiDiagram);
		updateChildren(mod, ageDiagram, true);
		LayoutUtil.layoutDepthFirst(graphitiDiagram, mod, ageDiagram, GraphitiAgeDiagram.this); // Layout
		updateImageResources(ageDiagram.getAllDiagramNodes());
		finishUpdating(ageDiagram);
	}

	@Override
	public void close() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		localResourceManager.dispose();
		ageDiagram.removeModificationListener(modificationListener);
	};

	public void modify(final String label, final DiagramModifier modifier) {
		this.ageDiagram.modify(label, modifier);
	}

	/**
	 * Stores mapping between the diagram node and the pictogram element
	 * @param dn
	 * @param pe
	 */
	private void addMapping(final DiagramNode dn, final PictogramElement pe) {
		diagramNodeToPictogramElementMap.put(dn, pe);
		pictogramElementToDiagramNodeMap.put(pe, dn);
	}

	/**
	 * Removes the mapping for the specified diagram node and all children
	 * @param dn
	 */
	private void removeMappingForBranch(final DiagramNode dn) {
		// Remove mapping for children
		for (final DiagramNode child : dn.getDiagramElements()) {
			removeMappingForBranch(child);
		}

// Remove mapping for the element itself
		final PictogramElement pe = getPictogramElement(dn);
		pictogramElementToDiagramNodeMap.remove(pe);
		diagramNodeToPictogramElementMap.remove(dn);
	}

	/**
	 * Ensures graphiti elements for children of the specified node have been created
	 * @param dn
	 * @param containerShape
	 */
	private void ensureCreatedChildren(final DiagramNode dn, final PictogramElement containerPe) {
		for (final DiagramElement e : dn.getDiagramElements()) {
			ensureCreatedDiagramElement(e, containerPe);
		}
	}

	/**
	 * Creates/updates the pictogram element. Also creates most anchors. Connection anchors are not created. They are lazily created.
	 * @param de
	 * @param containerShape
	 */
	private void ensureCreatedDiagramElement(final DiagramElement de, final PictogramElement containerPe) {
		final Graphic g = de.getGraphic();

		// Create/Update the pictogram Element
		final PictogramElement pe = createUpdatePictogramElementForGraphic(graphitiDiagram, g, containerPe,
				getPictogramElement(de));
		Objects.requireNonNull(pe, "pe must not be null");

		// Set whether the pictogram element is active based if the graphic is a decoration
		if (de.getGraphicalConfiguration().isDecoration) {
			pe.setActive(!(containerPe instanceof Connection) || g instanceof Label);

			if (containerPe instanceof Connection) {
				if (!(g instanceof Label || g instanceof Poly)) {
					throw new RuntimeException("Unsupported connection decoration graphic: " + g);
				}
			} else {
				if (!(g instanceof Label)) {
					throw new RuntimeException("Unsupported shape decoration graphic: " + g);
				}
			}
		}

		addMapping(de, pe);

		// Configure PE if one exists
		if (pe instanceof Shape) {
			final Shape shape = ((Shape) pe);
			AnchorUtil.createOrUpdateChopboxAnchor(shape);

			if (de.getDockArea() != null) {
				// Create/update named anchors for all docked shapes
				AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.FLOW_SPECIFICATION, 0, 0, false);
				AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.INTERIOR_ANCHOR, 0, 0, false);
				AnchorUtil.createOrUpdateFixPointAnchor(shape, AnchorNames.EXTERIOR_ANCHOR, 0, 0, false);
			}
		}

		// Update Children
		ensureCreatedChildren(de, pe);
	}

	private void updateChildren(final DiagramModification mod, final DiagramNode elementContainer,
			final boolean recursive) {
		for (final DiagramElement e : elementContainer.getDiagramElements()) {
			updateDiagramElement(mod, e, recursive);
		}
	}

	/**
	 * Refreshes transient shapes and updates pictogram element properties based on the diagram element.
	 * @param de
	 * @param recursive
	 */
	private void updateDiagramElement(final DiagramModification mod, final DiagramElement de, final boolean recursive) {
		final Graphic g = de.getGraphic();

		final PictogramElement pe = getPictogramElement(de);
		if (pe == null) {
			return;
		}

		// Configure PE if one exists
		if (pe instanceof Shape) {
			final Shape shape = ((Shape) pe);

			// Remove all unnamed non-chopbox anchors that do not have an incoming or outgoing connection
			final Iterator<Anchor> it = shape.getAnchors().iterator();
			while (it.hasNext()) {
				final Anchor anchor = it.next();
				if (!(anchor instanceof ChopboxAnchor)
						&& (anchor.getIncomingConnections().size() + anchor.getOutgoingConnections().size()) == 0
						&& PropertyUtil.getName(anchor) == null) {
					it.remove();
				}
			}

			PropertyUtil.setDockArea(pe, de.getDockArea());

			// Delete Transient Shapes
			if (shape instanceof ContainerShape) {
				List<Shape> shapesToDelete = null; // Shapes that should be deleted
				final ContainerShape containerShape = (ContainerShape) shape;
				for (final Shape childShape : containerShape.getChildren()) {
					if (PropertyUtil.isTransient(childShape)) {
						if (shapesToDelete == null) {
							shapesToDelete = new ArrayList<Shape>();
						}

						shapesToDelete.add(childShape);
					}
				}

				// Delete all shapes that were marked for deletion
				if (shapesToDelete != null) {
					for (final Shape s : shapesToDelete) {
						EcoreUtil.delete(s, true);
					}
				}
			}
		} else if (pe instanceof Connection) {
			final Connection connection = (Connection) pe;
			final AgeConnection ac = ((AgeConnection) g);

			// Set Anchors
			if (ac.isFlowIndicator) {
				connection.setStart(getAnchor(de.getStartElement(), true));
				// If it is a flow indicator, get the appropriate anchor from the start element
				final PictogramElement startPe = diagramNodeToPictogramElementMap.get(de.getStartElement());
				connection.setEnd(AnchorUtil.getAnchorByName(startPe, AnchorNames.FLOW_SPECIFICATION));
			} else {
				connection.setStart(
						getAnchor(de.getStartElement(), useInteriorAnchor(de.getStartElement(), de.getEndElement())));
				connection.setEnd(
						getAnchor(de.getEndElement(), useInteriorAnchor(de.getEndElement(), de.getStartElement())));
			}

			final GraphicsAlgorithm ga = connection.getGraphicsAlgorithm();
			ga.setStyle(null);
			ga.setLineStyle(
					AgeGraphitiGraphicsUtil.toGraphitiLineStyle(de.getGraphicalConfiguration().style.getLineStyle()));
			ga.setLineWidth(2);
			ga.setForeground(Graphiti.getGaService().manageColor(graphitiDiagram, IColorConstant.BLACK));

			if (pe instanceof FreeFormConnection) {
				final FreeFormConnection ffc = (FreeFormConnection) pe;
				final List<org.eclipse.graphiti.mm.algorithms.styles.Point> graphitiBendpoints = ffc.getBendpoints();
				graphitiBendpoints.clear();
				for (final org.osate.ge.graphics.Point bendpoint : de.getBendpoints()) {
					graphitiBendpoints.add(Graphiti.getGaService().createPoint((int) Math.round(bendpoint.x),
							(int) Math.round(bendpoint.y)));
				}
			}
		}

		// Update Children
		if (recursive) {
			updateChildren(mod, de, recursive);
		}

		// Build the primary label which includes the element's name
		final String completenessSuffix = de.getCompleteness() == Completeness.INCOMPLETE ? incompleteIndicator : "";
		final Style finalStyle = finalStyleProvider.getStyle(de);
		final String primaryLabelStr = (!finalStyle.getPrimaryLabelVisible().booleanValue() || de.getLabelName() == null)
				? null
						: (de.getLabelName() + completenessSuffix);

		if (pe instanceof ContainerShape) {
			final double fontSize = de.getStyle().getFontSize() == null ? Style.DEFAULT.getFontSize()
					: de.getStyle().getFontSize();

			// Create Labels
			if (primaryLabelStr != null) {
				final Shape labelShape;
				if (de.getGraphicalConfiguration().primaryLabelIsMultiline) {
					final int labelWidth = de.hasSize()
							? Math.max((int) de.getWidth() - wrappingLabelPadding, wrappingLabelMinWidth)
									: defaultWrappingLabelWidth;
							labelShape = labelHelper.createWrappingLabelShape(graphitiDiagram, (ContainerShape) pe,
									ShapeNames.primaryLabelShapeName, primaryLabelStr, fontSize, labelWidth,
									wrappingLabelInnerPaddingX);
				} else {
					labelShape = labelHelper.createLabelShape(graphitiDiagram, (ContainerShape) pe,
							ShapeNames.primaryLabelShapeName, primaryLabelStr, fontSize);
				}
				labelShape.setActive(false);
			}

			final String annotation = de.getGraphicalConfiguration().annotation;
			if (annotation != null) {
				final Shape annotationShape = labelHelper.createLabelShape(graphitiDiagram, (ContainerShape) pe,
						ShapeNames.annotationShapeName, annotation, fontSize);
				annotationShape.setActive(false);
			}
		} else if (pe instanceof Connection) {
			final Connection connection = (Connection) pe;
			final AgeConnection ageConnection = (AgeConnection) de.getGraphic();

			// Clear all decorators which are not associated with a diagram node
			connection.getConnectionDecorators().removeIf((cd) -> getDiagramNode(cd) == null);

			final IGaService gaService = Graphiti.getGaService();

			// Create label decorator
			double labelX = 0;
			double labelY = 0;
			if (primaryLabelStr != null) {
				final IPeCreateService peCreateService = Graphiti.getPeCreateService();
				final ConnectionDecorator textDecorator = peCreateService.createConnectionDecorator(connection, true,
						ageConnection.isFlowIndicator ? 1.0 : 0.5, true);
				final Text text = gaService.createDefaultText(graphitiDiagram, textDecorator);
				PropertyUtil.setIsStylingChild(text, true);
				PropertyUtil.setName(textDecorator, ShapeNames.primaryLabelShapeName);
				text.setValue(primaryLabelStr);

				TextUtil.setStyleAndSize(graphitiDiagram, text, de.getStyle().getFontSize());

				final org.osate.ge.graphics.Point primaryLabelPosition = de.getConnectionPrimaryLabelPosition();
				if (primaryLabelPosition == null) {
					// Set default position
					final IDimension labelTextSize = GraphitiUi.getUiLayoutService().calculateTextSize(primaryLabelStr,
							text.getFont());
					if (ageConnection.isFlowIndicator) { // Special default position for flow indicator labels
						labelX = -28; // Position the label such that it the default text does not intersect with the border when docked on the left or on the
						// right
						labelY = 5;
					} else {
						labelX = -labelTextSize.getWidth() / 2;
						labelY = -labelTextSize.getHeight() - 2;
					}
				} else {
					labelX = primaryLabelPosition.x;
					labelY = primaryLabelPosition.y;
				}

				gaService.setLocation(text, (int) Math.round(labelX), (int) Math.round(labelY));
			}

			// Create Graphiti decorators for connection terminators
			createDecorator(connection, ageConnection.srcTerminator, 0.0);
			createDecorator(connection, ageConnection.dstTerminator, 1.0);
		}

		// Refresh the Top Level Graphics Algorithm. Connections do not have their graphics algorithms recreated because they all have the same type of
		// GraphicsAlgorithm
		// and because there are issues when recreating the graphics algorithm of connections. Upon update, the connections may disappear.
		if (pe instanceof Shape) {
			final Shape shape = (Shape) pe;
			// Set the position of the refreshed graphics algorithm
			final IGaService gaService = Graphiti.getGaService();
			final GraphicsAlgorithm newGa = gaService.createInvisibleRectangle(shape);
			PropertyUtil.setIsStylingContainer(newGa, true);

			// Only set the size if it already has one assigned. Otherwise, leave it to the layout algorithm.
			if (de.hasSize()) {
				final int width = Math.max(10, (int) Math.round(de.getWidth()));
				final int height = Math.max(10, (int) Math.round(de.getHeight()));

				// Set Size
				gaService.setSize(newGa, width, height);
			}

			// Set Position
			final org.osate.ge.graphics.Point position = de.getPosition();
			if (position != null) {
				gaService.setLocation(newGa, (int) Math.round(position.x), (int) Math.round(position.y));
				PropertyUtil.setIsLayedOut(pe, true);
			}
		}
	}

	/**
	 * Finishes updating all elements contained in the diagram.
	 */
	private void finishUpdating(final AgeDiagram diagram) {
		for (final DiagramElement element : diagram.getDiagramElements()) {
			finishUpdating(element);
		}
	}

	/**
	 * Finishes updating a diagram element.
	 * Refreshes the control points and anchors of connections related to the specified element.
	 * This function depends on the position of connection anchors so it should be executed after layout has been performed for all relevant elements.
	 * Applies any colors provided by the coloring provider.
	 */
	private void finishUpdating(final DiagramElement element) {
		final PictogramElement pe = getPictogramElement(element);
		if (pe instanceof Shape) {
			final Shape shape = ((Shape) pe);
			AnchorUtil.updateConnectionAnchors(shape, GraphitiAgeDiagram.this);
		} else if (pe instanceof Connection) {
			AnchorUtil.updateConnectionAnchor(element, (Connection) pe, GraphitiAgeDiagram.this);
		}

		for (final DiagramElement child : element.getDiagramElements()) {
			finishUpdating(child);
		}
	}

	/**
	 * Creates or updates a pictogram element as appropriate to match the specified graphic.
	 * @param graphitiDiagram
	 * @param graphic
	 * @param shapeContainer is the container to use when creating shapes.
	 * @param pe is the current pictogram element for the graphic.
	 * @return
	 */
	private static PictogramElement createUpdatePictogramElementForGraphic(final Diagram graphitiDiagram,
			final Graphic graphic, final PictogramElement containerPe, PictogramElement pe) {
		final IPeCreateService peCreateService = Graphiti.getPeCreateService();

		// Create/Change Pictogram Element Based on the Graphic
		if (graphic instanceof AgeConnection) {
			// Remove the PE If it is of the wrong type...
			if (pe != null) {
				if (!(pe instanceof Connection)) {
					EcoreUtil.delete(pe, true);
					pe = null;
				}
			}

			if (pe == null) {
				// Create the connection
				pe = peCreateService.createFreeFormConnection(graphitiDiagram);

				final GraphicsAlgorithm ga = Graphiti.getGaService().createPlainPolyline(pe);
				PropertyUtil.setIsStylingContainer(ga, true);
				PropertyUtil.setIsStylingChild(ga, true);
			}

		} else if (graphic instanceof AgeShape) {
			// Remove the PE If it is of the wrong type...
			if (pe != null) {
				if (!(pe instanceof Shape)) {
					EcoreUtil.delete(pe, true);
					pe = null;
				}
			}

			if (pe == null) {
				if (containerPe instanceof ContainerShape) {
					// Create the container shape
					pe = peCreateService.createContainerShape((ContainerShape) containerPe, true);
				} else if (containerPe instanceof Connection) {
					pe = peCreateService.createConnectionDecorator((Connection) containerPe, true, 0.5, true);
					PropertyUtil.setIsStylingContainer(pe, !(graphic instanceof Label));
				} else {
					throw new RuntimeException("Unsupported container: " + containerPe);
				}

			}
		} else {
			throw new RuntimeException("Unsupported graphic: " + graphic);
		}

		return pe;
	}

	@Override
	public final DiagramNode getDiagramNode(final PictogramElement pe) {
		return pictogramElementToDiagramNodeMap.get(pe);
	}

	public final DiagramElement getDiagramElement(final PictogramElement pe) {
		final DiagramNode dn = getDiagramNode(pe);
		return dn instanceof DiagramElement ? (DiagramElement) dn : null;
	}

	@Override
	public PictogramElement getPictogramElement(final DiagramNode dn) {
		return diagramNodeToPictogramElementMap.get(dn);
	}

	/**
	 * Same as getClosestDiagramNode, but returns null if result is not a DiagramElement.
	 * @param pe
	 * @return
	 */
	public DiagramElement getClosestDiagramElement(final PictogramElement pe) {
		final DiagramNode dn = getClosestDiagramNode(pe);
		return dn instanceof DiagramElement ? (DiagramElement) dn : null;
	}

	/**
	 * Looks for a diagram node associated for the pictogram element.
	 * If one is not available, it looks in the pictogram element ancestors until there are no more ancestors to check.
	 * @param pe
	 * @return
	 */
	public DiagramNode getClosestDiagramNode(PictogramElement pe) {
		DiagramNode result = getDiagramNode(pe);
		while (result == null) {
			if (pe instanceof ConnectionDecorator) {
				pe = ((ConnectionDecorator) pe).getConnection();
			} else if (pe instanceof Shape) {
				pe = ((Shape) pe).getContainer();
			} else {
				break;
			}

			result = getDiagramNode(pe);
		}

		return result;
	}

	public Diagram getGraphitiDiagram() {
		return graphitiDiagram;
	}

	public AgeDiagram getAgeDiagram() {
		return ageDiagram;
	}

	// Refreshes the override color map and the style of the specified elements. Does not refresh their descendants.
	// Must be called within a transaction
	public void refreshStyle(final Collection<DiagramElement> elements) {
		refreshOverrideForegroundColorMap();
		for (final DiagramElement de : elements) {
			refreshStyle(de);
		}
	}

	private void refreshStyle(final DiagramElement de) {
		final PictogramElement pe = getPictogramElement(de);
		if (pe != null) {
			StyleUtil.refreshStyle(graphitiDiagram, pe, de, finalStyleProvider, this);
		}
	}

	// Must be called inside the proper transaction
	public void refreshDiagramStyles() {
		refreshOverrideForegroundColorMap();
		// Refresh Coloring
		refreshChildrenStyles(getAgeDiagram());
	}

	private void refreshChildrenStyles(final DiagramNode n) {
		for (final DiagramElement child : n.getDiagramElements()) {
			refreshChildrenStyles(child);
			refreshStyle(child);
		}
	}

	/**
	 *
	 * @param de
	 * @param useInteriorAnchor whether to use the interior anchor it exists. Otherwise the exterior anchor is used if it exists.
	 * @return
	 */
	private Anchor getAnchor(final DiagramElement de, final boolean useInteriorAnchor) {
		final PictogramElement pe = diagramNodeToPictogramElementMap.get(de);
		if (pe == null) {
			return null;
		}

		if (pe instanceof Connection) {
			return AnchorUtil.getOrCreateConnectionAnchor(de, (Connection) pe, this);
		} else if (pe instanceof AnchorContainer) {
			final AnchorContainer anchorContainer = (AnchorContainer) pe;
			final String anchorName = useInteriorAnchor ? AnchorNames.INTERIOR_ANCHOR : AnchorNames.EXTERIOR_ANCHOR;
			final Anchor namedAnchor = AnchorUtil.getAnchorByName(anchorContainer, anchorName);
			if (namedAnchor != null) {
				return namedAnchor;
			}

			return Graphiti.getPeService().getChopboxAnchor(anchorContainer);
		} else {
			return null;
		}
	}

	private void createDecorator(final Connection connection, final AgeConnectionTerminator terminator,
			final double position) {
		if (terminator != null) {
			final IPeCreateService peCreateService = Graphiti.getPeCreateService();
			final ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, position, true);
			PropertyUtil.setIsStylingContainer(cd, true);
			final Diagram diagram = connection.getParent();
			final Color black = Graphiti.getGaService().manageColor(diagram, IColorConstant.BLACK);
			final Color white = Graphiti.getGaService().manageColor(diagram, IColorConstant.WHITE);

			final Polyline ga;
			switch (terminator.type) {
			case FILLED_ARROW:
				ga = createPolygonArrow(cd, terminator.size);
				ga.setForeground(black);
				ga.setBackground(black);
				PropertyUtil.setIsStylingChild(ga, true);
				break;

			case OPEN_ARROW:
				ga = createPolygonArrow(cd, terminator.size);
				ga.setForeground(black);
				ga.setBackground(white);
				PropertyUtil.setIsStylingChild(ga, false);
				PropertyUtil.setIsStylingOutlineEnabled(ga, true);
				break;

			case LINE_ARROW:
				ga = createLineArrow(cd, terminator.size);
				ga.setForeground(black);
				ga.setBackground(white);
				PropertyUtil.setIsStylingChild(ga, true);
				break;

			case ORTHOGONAL_LINE:
				ga = createOrthogonalLine(cd);
				ga.setForeground(black);
				ga.setBackground(white);
				PropertyUtil.setIsStylingChild(ga, true);
				break;

			default:
				throw new RuntimeException("Unsupported terminator type: " + terminator.type);
			}

			AgeGraphitiGraphicsUtil.shrinkPolyline(ga); // Sets the width

			if (terminator.reversed) {
				AgeGraphitiGraphicsUtil.mirrorX(ga);
			}
		}
	}

	private Polyline createOrthogonalLine(final GraphicsAlgorithmContainer gaContainer) {
		final IGaService gaService = Graphiti.getGaService();
		final Polyline ga = gaService.createPlainPolyline(gaContainer, new int[] { 0, 8, 0, -8 });
		ga.setLineWidth(2);

		return ga;
	}

	private Polyline createLineArrow(final GraphicsAlgorithmContainer gaContainer,
			final ConnectionTerminatorSize size) {
		final IGaService gaService = Graphiti.getGaService();
		switch (size) {
		case REGULAR:
			return gaService.createPlainPolyline(gaContainer, new int[] { -10, 6, 2, 0, -10, -6 });
		case SMALL:
			return gaService.createPlainPolyline(gaContainer, new int[] { -6, 5, 2, 0, -6, -5 });
		}

		throw new RuntimeException("Unsupported connection terminator size: " + size);
	}

	private Polyline createPolygonArrow(final GraphicsAlgorithmContainer gaContainer,
			final ConnectionTerminatorSize size) {
		final IGaService gaService = Graphiti.getGaService();
		switch (size) {
		case REGULAR:
			return gaService.createPlainPolygon(gaContainer, new int[] { -10, 6, 2, 0, -10, -6 });
		case SMALL:
			return gaService.createPlainPolygon(gaContainer, new int[] { -6, 4, 2, 0, -6, -4 });
		}

		throw new RuntimeException("Unsupported connection terminator size: " + size);
	}

	private DiagramNode getUndockedDiagramNode(DiagramNode n) {
		while (n instanceof DiagramElement) {
			final DiagramElement e = ((DiagramElement) n);
			if (e.getDockArea() == null) {
				return e;
			}

			n = e.getContainer();
		}
		return n;

	}

	// OPTIMIZE: This uses a simple algorithm where a diagram update is performed when a new item is added. Ideally, it would only update the affected items.
	private class GraphitiDiagramModificationListener implements DiagramModificationListener {
		private boolean inBeforeModificationsCompleted = false;
		private boolean needFullUpdate = false;
		private final Set<DiagramElement> elementsToUpdate = new LinkedHashSet<>();
		private final Set<DiagramElement> elementsToRemove = new LinkedHashSet<>();

		@Override
		public void diagramConfigurationChanged(final DiagramConfigurationChangedEvent e) {
			needFullUpdate = true;
			finalStyleProvider.setDiagramConfiguration(ageDiagram.getConfiguration());
		}

		@Override
		public void elementAdded(final ElementAddedEvent e) {
			if (!inBeforeModificationsCompleted) {
				onElementAdded(e.element);
			}
		}

		private void onElementAdded(final DiagramElement element) {
			elementsToRemove.remove(element);
			needFullUpdate = true;
			elementsToUpdate.clear(); // Clear all elements to update. They will not be processed if an element has been added.
		}

		@Override
		public void elementRemoved(final ElementRemovedEvent e) {
			if (!inBeforeModificationsCompleted) {
				elementsToRemove.add(e.element);
				elementsToUpdate.remove(e.element);
			}
		}

		@Override
		public void elementUpdated(final ElementUpdatedEvent e) {
			// Don't store updated elements when an element has been added. The add will trigger a complete update.
			// Ignore elements which don't have a graphical configuration.
			if (!needFullUpdate && e.element.getGraphicalConfiguration() != null
					&& !inBeforeModificationsCompleted) {
				// If the pictogram element type and the graphic type do not agree on whether the element is a connection, treat the update as an addition.
				// This ensures the the pictogram element is recreated.
				final boolean peIsConnection = getPictogramElement(e.element) instanceof Connection;
				final boolean graphicIsConnection = e.element.getGraphic() instanceof AgeConnection;
				if (peIsConnection == graphicIsConnection) {
					// All updates are treated the same at this point. Each element is updated and containers are layed out.
					if (!elementsToRemove.contains(e.element)) {
						// If the element is already in the elements to update set, remove it so that it will be inserted at the end of the set
						if (elementsToUpdate.contains(e.element)) {
							elementsToUpdate.remove(e.element);
						}

						elementsToUpdate.add(e.element);
					}
				} else {
					onElementAdded(e.element);
				}
			}
		}

		@Override
		public void beforeModificationsCompleted(BeforeModificationsCompletedEvent event) {
			Display.getDefault().syncExec(() -> {
				try {
					inBeforeModificationsCompleted = true;

					// Remove elements
					for (final DiagramElement element : elementsToRemove) {
						// Remove any contained connections first. Connections are stored at the diagram level in the Graphiti model so they need to be
						// deleted
						// individually.
						removeContainedConnections(element);

						final PictogramElement pe = getPictogramElement(element);
						if (pe != null) {
							EcoreUtil.delete(pe, true);
						}

						// Remove the mapping
						removeMappingForBranch(element);
					}

					if (needFullUpdate) {
						createUpdateElementsFromAgeDiagram(event.mod);
					} else {
						final Set<DiagramNode> nodesToLayout = new HashSet<>();

						// Update modified elements
						for (final DiagramElement element : elementsToUpdate) {
							final PictogramElement pe = getPictogramElement(element);
							updateDiagramElement(event.mod, element, false);

							if (pe instanceof ContainerShape || pe instanceof ConnectionDecorator) {
								final DiagramNode undockedContainer = getUndockedDiagramNode(
										element.getContainer());
								nodesToLayout.add(undockedContainer);
							} else if (pe instanceof Connection) { // Relayout connections
								// Relayout the entire diagram. This is needed because line width of connection do not
								// update visually until the diagram layout. Unsure what actually triggers the update of the UI
								nodesToLayout.add(getAgeDiagram()); //
								// nodesToLayout.add(getUndockedDiagramNode(element));
							}
						}

						// Layout Nodes
						// OPTIMIZE: It would be more efficient to only layout the nodes that need to be layed out instead of laying out all descendants of
						// the
						// container.
						nodesToLayout.removeIf((n) -> collectionContainsAnyAncestor(nodesToLayout, n)); // Filter out elements whose parents are in the
						// collection
						// of nodes to layout

						Set<DiagramElement> elementsToCheckParentsForLayout = new HashSet<>(); // Contains the set of diagram elements whose parents need to
						// be
						// checked to see if they should be layed out
						for (final DiagramNode n : nodesToLayout) {
							if (n instanceof AgeDiagram) {
								LayoutUtil.layoutDepthFirst(graphitiDiagram, event.mod, (AgeDiagram) n,
										GraphitiAgeDiagram.this);
							} else if (n instanceof DiagramElement) {
								LayoutUtil.layoutDepthFirst(graphitiDiagram, event.mod, (DiagramElement) n,
										GraphitiAgeDiagram.this);
								elementsToCheckParentsForLayout.add((DiagramElement) n);
							}
						}

						// Check the elements to see if their parents need to be layed out
						while (elementsToCheckParentsForLayout.size() > 0) {
							final HashSet<DiagramElement> parentsToLayout = new HashSet<>();
							for (final DiagramElement e : elementsToCheckParentsForLayout) {
								// Check if the element's parent needs to be layed out.
								if (parentNeedsLayout(e)) {
									parentsToLayout.add((DiagramElement) e.getParent());
								}
							}

							// Layout the parents
							for (final DiagramElement parentToLayout : parentsToLayout) {
								// Get the pictogram element and lay it out if it is a shape
								final PictogramElement parentPe = getPictogramElement(parentToLayout);
								if (parentPe instanceof ContainerShape) {
									LayoutUtil.layout(graphitiDiagram, event.mod, parentToLayout,
											(ContainerShape) parentPe, GraphitiAgeDiagram.this);
								}
							}

							// Check the parents next
							elementsToCheckParentsForLayout = parentsToLayout; // Check the parents next
						}

						// Update affected connections
						for (final DiagramElement element : elementsToUpdate) {
							finishUpdating(element);
						}
					}

					// Refresh the entire diagram's color. A model change could affect any number of diagram elements.
					refreshDiagramStyles();
					updateImageResources(getAgeDiagram().getAllDiagramNodes());
				} finally {
					inBeforeModificationsCompleted = false;
				}
			});

		}

		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent event) {
			needFullUpdate = false;
			elementsToRemove.clear();
			elementsToUpdate.clear();

			Display.getDefault().syncExec(() -> {
				updateListener.onUpdateFinished();
			});

		}

		/**
		 * Returns true if the parent of the specified diagram elements needs to be layed out.
		 * @param de
		 * @return
		 */
		private boolean parentNeedsLayout(final DiagramElement de) {
			// Check if the element's parent needs to be layed out.
			if (de.getContainer() instanceof DiagramElement) {
				final DiagramElement parent = (DiagramElement) de.getContainer();
				if (!(parent.getGraphic() instanceof AgeConnection)
						&& (de.getX() < 0 || de.getY() < 0 || parent.getWidth() < de.getX() + de.getWidth()
						|| parent.getHeight() < de.getY() + de.getHeight())) {
					return true;
				}
			}

			return false;
		}

		private boolean collectionContainsAnyAncestor(final Collection<?> collection, final DiagramNode n) {
			DiagramNode t = n.getContainer();
			while (t != null) {
				if (collection.contains(t)) {
					return true;
				}
				t = t.getContainer();
			}
			return false;
		}

		/**
		 * Removes all connections contained in the specified element or its descendants.
		 */
		private void removeContainedConnections(final DiagramElement e) {
			for (final DiagramElement element : e.getDiagramElements()) {
				final PictogramElement pe = getPictogramElement(element);
				removeContainedConnections(element);

				if (pe instanceof Connection) {
					EcoreUtil.delete(pe, true);
				}
			}
		}
	}

	/**
	 * Returns whether the connection going from e1 to e2 should use the interior anchor for e1 if it exists.
	 * @param e1
	 * @param e2
	 * @return
	 */
	private static boolean useInteriorAnchor(final DiagramElement e1, final DiagramElement e2) {
		return isInsideUndockedContainer(e2, e1);
	}

	/**
	 * Returns whether e1 is inside the first undocked container in the hierarchy of e2
	 * @param e1
	 * @param e2
	 * @return
	 */
	private static boolean isInsideUndockedContainer(final DiagramElement e1, final DiagramElement e2) {
		// Get the first diagram element in each hierarchy which doesn't have a dock area set.
		DiagramNode nd2 = e2;
		while (nd2 instanceof DiagramElement && ((DiagramElement) nd2).getDockArea() != null) {
			nd2 = nd2.getParent();
		}

		if (!(nd2 instanceof DiagramElement)) {
			return false;
		}

		// Check if e1 is inside the first undocked element in the e2 hierarchy
		for (DiagramNode t1 = e1; t1 != null; t1 = t1.getParent()) {
			if (t1 == nd2) {
				return true;
			}
		}

		return false;
	}

	private void updateImageResources(final Stream<DiagramNode> allDiagramNodes) {
		final LocalResourceManager newResourceManager = new LocalResourceManager(AgeDiagramTypeProvider.getResources());
		try {
			final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			for (final DiagramNode dn : allDiagramNodes.filter(dn -> dn instanceof DiagramElement)
					.collect(Collectors.toSet())) {
				final DiagramElement de = (DiagramElement) dn;
				// Check if diagram element is an image figure
				if (DiagramElementPredicates.supportsImage(de) && Boolean.TRUE.equals(de.getStyle().getShowAsImage())) {
					final IPath imagePath = de.getStyle().getImagePath();
					final IResource imageResource = workspaceRoot.findMember(imagePath.toPortableString());
					if (imageResource != null) {
						try {
							// Image location
							final URL rawLocationURL = imageResource.getRawLocationURI().toURL();
							final ImageDescriptor imageDesc = ImageDescriptor.createFromURL(rawLocationURL);
							// Create image
							newResourceManager.createImage(imageDesc);
						} catch (final MalformedURLException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		} finally {
			localResourceManager.dispose();
			localResourceManager = newResourceManager;
		}
	}
}
