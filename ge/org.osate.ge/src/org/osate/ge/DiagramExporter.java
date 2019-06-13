package org.osate.ge;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.swt.SWT;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.diagram.ColoringProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.impl.SimpleActionExecutor;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.internal.util.ProjectUtil;
import org.osgi.framework.FrameworkUtil;

public class DiagramExporter {

	private static org.eclipse.graphiti.mm.pictograms.Diagram readDiagram(final IFile diagramFile) throws IOException {
		// Image container bounds
		final ContainerBounds containerBounds = new ContainerBounds();
		final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		final IProject project = ProjectUtil.getProject(uri);

		// Create diagram
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization.readMetaModelDiagram(uri);

		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain();
		final DummyDiagramBehavior dummyDiagramBehavior = new DummyDiagramBehavior(editingDomain, project);
		final DummyDiagramTypeProvider dummyDiagramTypeProvider = new DummyDiagramTypeProvider(dummyDiagramBehavior);

		final AgeDiagram ageDiagram = DiagramSerialization.createAgeDiagram(project, mmDiagram,
				getExtensionRegistryService(dummyDiagramTypeProvider.getClass()));

		// Create an empty Graphiti diagram
		final org.eclipse.graphiti.mm.pictograms.Diagram diagram = Graphiti.getPeService()
				.createDiagram(GraphitiAgeDiagram.AADL_DIAGRAM_TYPE_ID, "", true);

		// The resource needs to be added to an editing domain for use with the editor. Otherwise, the figures will not be updated.
		final URI ignoredUri = URI.createHierarchicalURI("osate_ge_ignore", null, null,
				new String[] { "internal.aadl_diagram" }, null, null);
		final Resource diagramResource = editingDomain.getResourceSet().createResource(ignoredUri);
		editingDomain.getCommandStack().execute(new AbstractCommand() {
			@Override
			protected boolean prepare() {
				return true;
			}

			@Override
			public void execute() {
				diagramResource.getContents().add(diagram);
			}

			@Override
			public boolean canUndo() {
				return false;
			}

			@Override
			public void redo() {
			}
		});

		try (final GraphitiAgeDiagram graphitiAgeDiagram = layoutAndCreateGraphitiAgeDiagram(dummyDiagramTypeProvider,
				ageDiagram, diagram, editingDomain)) {
			editingDomain.getCommandStack().execute(new AbstractCommand() {
				@Override
				protected boolean prepare() {
					return true;
				}

				@Override
				public void execute() {
					// Set container bounds for image
					setDiagramContainerBounds(containerBounds, diagram);

					// Set elements relative to (0,0)
					moveDiagramElements(containerBounds, diagram);

					// Create a invisible rectangle around diagram elements for image
					final ContainerShape boundsShape = Graphiti.getPeCreateService().createContainerShape(diagram,
							true);
					final Rectangle r = Graphiti.getGaService().createInvisibleRectangle(boundsShape);
					r.setWidth(-containerBounds.minX + containerBounds.maxX + containerBounds.padding * 2);
					r.setHeight(-containerBounds.minY + containerBounds.maxY + containerBounds.padding * 2);
				}

				@Override
				public boolean canUndo() {
					return false;
				}

				@Override
				public void redo() {
				}
			});

			return diagram;
		}
	}

	/**
	 * Converts an AADL diagram file to a PNG image.
	 *
	 * @param diagramFile the diagram file to be exported
	 * @param outputFile  the file the image will be written to
	 */
	public static void exportDiagramAsPng(final IFile diagramFile, final File outputFile) throws IOException {

		final org.eclipse.graphiti.mm.pictograms.Diagram diagram = readDiagram(diagramFile);
		// Export to image
		exportDiagramToImage(diagram, outputFile);
	}

	/**
	 * Converts an AADL diagram file to a PNG image.
	 *
	 * @param diagramFile  the diagram file to be exported
	 * @param outputStream the stream the image will be written to
	 */
	public static void exportDiagramAsPng(final IFile diagramFile, final ImageOutputStream outputStream)
			throws IOException {

		final org.eclipse.graphiti.mm.pictograms.Diagram diagram = readDiagram(diagramFile);
		// Export to image
		exportDiagramToImage(diagram, outputStream);
	}

	/**
	 * Converts an AADL diagram file to a PNG image.
	 *
	 * @param diagramFile  the diagram file to be exported
	 * @param outputStream the stream the image will be written to
	 */
	public static void exportDiagramAsPng(final IFile diagramFile, final OutputStream outputStream) throws IOException {

		final org.eclipse.graphiti.mm.pictograms.Diagram diagram = readDiagram(diagramFile);
		// Export to image
		exportDiagramToImage(diagram, outputStream);
	}

	private static ExtensionRegistryService getExtensionRegistryService(final Class<?> clazz) {
		return Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(FrameworkUtil.getBundle(clazz).getBundleContext())
				.get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
	}

	private static void exportDiagramToImage(final Diagram diagram, final File outputFile) throws IOException {
		final byte[] bytes = GraphitiUi.getImageService().convertDiagramToBytes(diagram, SWT.IMAGE_PNG);
		final BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
		ImageIO.write(img, "png", outputFile);
	}

	private static void exportDiagramToImage(final Diagram diagram, final ImageOutputStream outputStream)
			throws IOException {
		final byte[] bytes = GraphitiUi.getImageService().convertDiagramToBytes(diagram, SWT.IMAGE_PNG);
		final BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
		ImageIO.write(img, "png", outputStream);
	}

	private static void exportDiagramToImage(final Diagram diagram, final OutputStream outputStream)
			throws IOException {
		final byte[] bytes = GraphitiUi.getImageService().convertDiagramToBytes(diagram, SWT.IMAGE_PNG);
		final BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
		ImageIO.write(img, "png", outputStream);
	}

	private static GraphitiAgeDiagram layoutAndCreateGraphitiAgeDiagram(
			final DummyDiagramTypeProvider dummyDiagramTypeProvider, final AgeDiagram ageDiagram, final Diagram diagram,
			final TransactionalEditingDomain editingDomain) {
		// Update diagram
		((AgeFeatureProvider) dummyDiagramTypeProvider.getFeatureProvider()).getDiagramUpdater()
		.updateDiagram(ageDiagram);

		// Layout diagram
		ageDiagram.modify("Update Diagram",
				m -> DiagramElementLayoutUtil.layoutIncrementally(ageDiagram, m,
						(LayoutInfoProvider) dummyDiagramTypeProvider.getCurrentToolBehaviorProvider()
						.getAdapter(LayoutInfoProvider.class)));

		// Set the coloring service field. It is needed
		final ColoringProvider coloringProvider = () -> Collections.emptyMap();
		return new GraphitiAgeDiagram(ageDiagram, diagram, new SimpleActionExecutor(), coloringProvider, () -> {
		});
	}

	// Shift elements
	private static void moveDiagramElements(final ContainerBounds containerBounds, final Diagram diagram) {
		final int xOffset = -containerBounds.minX + containerBounds.padding;
		final int yOffset = -containerBounds.minY + containerBounds.padding;
		for (final Shape s : diagram.getChildren()) {
			final GraphicsAlgorithm ga = s.getGraphicsAlgorithm();
			ga.setX(xOffset + ga.getX());
			ga.setY(yOffset + ga.getY());
		}

		for (final Connection c : diagram.getConnections()) {
			if (c instanceof FreeFormConnection) {
				final FreeFormConnection ffc = (FreeFormConnection) c;
				for (final Point p : ffc.getBendpoints()) {
					p.setX(xOffset + p.getX());
					p.setY(yOffset + p.getY());
				}
			}
		}
	}

	private static void setDiagramContainerBounds(final ContainerBounds containerBounds, final Diagram diagram) {
		for (final Shape shape : diagram.getChildren()) {
			final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			updateBounds(containerBounds, ga.getX(), ga.getX() + ga.getWidth(), ga.getY(), ga.getY() + ga.getHeight());
		}

		updateBounds(containerBounds, diagram.getConnections());
	}

	// Ensure that connections are inside image bounds
	private static void updateBounds(final ContainerBounds containerBounds, final EList<Connection> connections) {
		for (final Connection c : connections) {
			if (c instanceof FreeFormConnection) {
				final FreeFormConnection fc = (FreeFormConnection) c;
				for (final Point p : fc.getBendpoints()) {
					updateBounds(containerBounds, p.getX(), p.getY());
				}
			}

			updateBounds(containerBounds, c);
		}
	}

	// Make sure connection decorators are contained within the image
	private static void updateBounds(final ContainerBounds containerBounds, final Connection c) {
		for (final ConnectionDecorator cd : c.getConnectionDecorators()) {
			if (cd.isLocationRelative()) {
				final GraphicsAlgorithm labelGA = cd.getGraphicsAlgorithm();
				final ILocation loc = GraphitiUi.getPeService().getConnectionMidpoint(c, cd.getLocation());
				final int labelX = loc.getX() + labelGA.getX();
				final int labelY = loc.getY() + labelGA.getY();
				updateBounds(containerBounds, labelX, labelX + labelGA.getWidth(), labelY, labelY + labelGA.getY());
			}
		}
	}

	private static void updateBounds(final ContainerBounds containerBounds, final int x, final int y) {
		updateBounds(containerBounds, x, x, y, y);
	}

	// Update image bounds
	private static void updateBounds(final ContainerBounds containerBounds, final int minX, final int maxX,
			final int minY, final int maxY) {
		containerBounds.minX = Math.min(containerBounds.minX, minX);
		containerBounds.maxX = Math.max(containerBounds.maxX, maxX);
		containerBounds.minY = Math.min(containerBounds.minY, minY);
		containerBounds.maxY = Math.max(containerBounds.maxY, maxY);
	}

	// Container bounds for diagram image
	private static class ContainerBounds {
		// Padding around image
		final int padding = 20;

		// Image bounds
		int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
	}

	private static class DummyDiagramTypeProvider extends AgeDiagramTypeProvider {
		final DummyDiagramBehavior ageDiagramBehavior;

		public DummyDiagramTypeProvider(final DummyDiagramBehavior ageDiagramBehavior) {
			super();
			this.ageDiagramBehavior = ageDiagramBehavior;
		}

		@Override
		public IDiagramBehavior getDiagramBehavior() {
			return ageDiagramBehavior;
		}
	}

	private static class DummyDiagramBehavior extends AgeDiagramBehavior {
		private final TransactionalEditingDomain editingDomain;
		private final IProject project;

		public DummyDiagramBehavior(final TransactionalEditingDomain editingDomain, final IProject project) {
			super(null);
			this.editingDomain = editingDomain;
			this.project = project;
		}

		@Override
		public IProject getProject() {
			return project;
		}

		@Override
		public TransactionalEditingDomain getEditingDomain() {
			return editingDomain;
		}
	}
}
