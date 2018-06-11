package org.osate.ge.internal.ui.handlers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.imageio.ImageIO;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Handle;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.ui.parts.AbstractEditPartViewer;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.ISaveImageFeature;
import org.eclipse.graphiti.features.context.ISaveImageContext;
import org.eclipse.graphiti.features.context.impl.SaveImageContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramSerialization;
import org.osate.ge.internal.graphiti.AgeDiagramTypeProvider;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.graphiti.diagram.ColoringProvider;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.AgeDiagramBehavior;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class ExportDiagram extends AbstractHandler {

	private AgeDiagram ageDiagram;

	@Override
	public void dispose() {
		// TODO dispose on close automatically
		System.err.println("dispose");
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(true);
		// final boolean enabled = calculateEnabled(evaluationContext);
		// setBaseEnabled(enabled);
	}

	private boolean calculateEnabled(final Object evaluationContext) {
		final IEditorPart activeEditor = AgeHandlerUtil.getActiveEditorFromContext(evaluationContext);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			return false;
		}

		final AgeDiagramEditor ageEditor = (AgeDiagramEditor) activeEditor;
		final GraphitiAgeDiagram graphitiAgeDiagram = ageEditor.getGraphitiAgeDiagram();
		if (graphitiAgeDiagram == null) {
			return false;
		}

		final IFeatureProvider fp = ageEditor.getDiagramTypeProvider().getFeatureProvider();
		if (fp == null) {
			return false;
		}

		final ISaveImageFeature feature = fp.getSaveImageFeature();
		if (feature == null) {
			return false;
		}

		return feature.canSave(createSaveImageContext());
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IFile diagramFile = (IFile) HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();
		final URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
		final IProject project = updateProjectByUri(uri);

		// ExtensionManager.getSingleton();
		final org.eclipse.graphiti.mm.pictograms.Diagram diagram = loadDiagram(uri);

		final TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.createEditingDomain();// TransactionUtil..getEditingDomain(diagram);
		System.err.println("EDITING DOMAIN: " + editingDomain);
		final DummyEditor dummyEditor = new DummyEditor(editingDomain, project);
		dummyEditor.getGraphicalViewer().setRootEditPart(new ScalableRootEditPart());

		// Set the coloring service field. It is needed
		final ColoringProvider coloringProvider = () -> Collections.emptyMap();

		final AgeFeatureProvider fp = (AgeFeatureProvider) dummyEditor.getDiagramTypeProvider().getFeatureProvider();
		System.err.println(fp + " fp");
		fp.getDiagramUpdater().updateDiagram(ageDiagram);
		System.err.println("A:" + dummyEditor.getEditingDomain());

		GraphitiAgeDiagram graphitiAgeDiagram = new GraphitiAgeDiagram(
				ageDiagram, diagram, dummyEditor.getEditingDomain(),
				c -> {
					dummyEditor.getEditingDomain().getCommandStack().execute(new AbstractCommand() {
						@Override
						protected boolean prepare() {
							return true;
						}

						@Override
						public void execute() {
							c.execute();
						}

						@Override
						public boolean canUndo() {
							return false;
						}

						@Override
						public void redo() {
						}
					});

				},
				coloringProvider, () -> {
				});


		ageDiagram.modify("Export", m -> {
			final byte[] bytes = GraphitiUi.getImageService().convertDiagramToBytes(diagram, SWT.IMAGE_PNG);
			try {
				final BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
				File outputfile = new File("save_image.jpg");
				ImageIO.write(img, "jpg", outputfile);
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		return null;
	}

	private int getAllChildren(int minX, final EList<Shape> children) {
		for (final Shape shape : children) {
			final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			if (minX > ga.getX()) {
				minX = ga.getX();
			}

			// System.err.println(shape + " X,Y: " + ga.getX() + ", " + ga.getY());
		}

		return minX;
	}

	private void shiftAll(int shiftX, final EList<Shape> children) {
		for (final Shape shape : children) {
			if (shape instanceof ContainerShape) {
				shiftAll(shiftX, ((ContainerShape) shape).getChildren());
			}
			final GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();
			ga.setX(shiftX + ga.getX());
			System.err.println(shape + " X,Y: " + ga.getX() + ", " + ga.getY());
		}
	}

	public org.eclipse.graphiti.mm.pictograms.Diagram loadDiagram(final URI uri) {
		final IProject project = updateProjectByUri(uri);
		final org.osate.ge.diagram.Diagram mmDiagram = DiagramSerialization.readMetaModelDiagram(uri);
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extRegistry = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");

		ageDiagram = DiagramSerialization.createAgeDiagram(project, mmDiagram, extRegistry);
		// ageDiagram.addModificationListener(ageDiagramModificationListener);

		// Display warning if the diagram is stored with a newer version of the diagram file format.
		if (mmDiagram.getFormatVersion() > DiagramSerialization.FORMAT_VERSION) {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(),
					"Diagram Created with Newer Version of OSATE", "The diagram '" + uri.lastSegment()
					+ "' was created with a newer version of the OSATE. The diagram may not be correctly displayed. Saving the diagram with the running version of OSATE may result in the loss of diagram information.");
		}

		// Create an empty Graphiti diagram. It will be updated after in initDiagramTypeProvider() after the diagram type provider is initialized and
		// the required services are available.
		return Graphiti.getPeService().createDiagram(GraphitiAgeDiagram.AADL_DIAGRAM_TYPE_ID, "", true);
	}

	private IProject updateProjectByUri(final URI uri) {
		final IPath projectPath = new Path(uri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if (!(projectResource instanceof IProject)) {
			throw new RuntimeException("Unable to determine project");
		}

		return (IProject) projectResource;
	}

	private ISaveImageContext createSaveImageContext() {
		SaveImageContext context = new SaveImageContext();
		return context;
	}

	private class DummyGraphicalViewer extends AbstractEditPartViewer implements GraphicalViewer {
		@Override
		public Control createControl(Composite parent) {
			return null;
		}

		@Override
		public EditPart findObjectAtExcluding(org.eclipse.draw2d.geometry.Point location,
				@SuppressWarnings("rawtypes") Collection exclusionSet, Conditional conditional) {
			return null;
		}

		@Override
		public Handle findHandleAt(org.eclipse.draw2d.geometry.Point p) {
			return null;
		}
	}

	private class DummyDiagramTypeProvider extends AgeDiagramTypeProvider {
		final AgeDiagramBehavior ageDiagramBehavior;

		public DummyDiagramTypeProvider(final AgeDiagramBehavior ageDiagramBehavior) {
			this.ageDiagramBehavior = ageDiagramBehavior;
		}

		@Override
		public IDiagramBehavior getDiagramBehavior() {
			return ageDiagramBehavior;
		}
	}

	private class DummyDiagramBehavior extends AgeDiagramBehavior {
		private final IProject project;
		private final DefaultEditDomain editDomain = new DefaultEditDomain((IEditorPart) this.getDiagramContainer());
		private final TransactionalEditingDomain editingDomain;

		public DummyDiagramBehavior(final TransactionalEditingDomain editingDomain,
				final IDiagramContainerUI diagramContainer, final IProject project) {
			super(diagramContainer);
			this.editingDomain = editingDomain;
			this.project = project;
		}

		@Override
		public DefaultEditDomain getEditDomain() {
			return editDomain;
		}

		@Override
		protected DefaultUpdateBehavior createUpdateBehavior() {
			return new DefaultUpdateBehavior(this);
		}

		@Override
		public TransactionalEditingDomain getEditingDomain() {
			return editingDomain;
		}

		@Override
		public IProject getProject() {
			return project;
		}
	}

	private class DummyEditor extends AgeDiagramEditor {
		private final AgeDiagramBehavior behavior;
		private final AgeDiagramTypeProvider dtp;

		private DummyGraphicalViewer dummyGraphicalViewer = new DummyGraphicalViewer();

		public DummyEditor(final TransactionalEditingDomain editingDomain, final IProject project) {
			this.behavior = new DummyDiagramBehavior(editingDomain, this, project);
			this.dtp = new DummyDiagramTypeProvider(behavior);
		}

		@Override
		public GraphicalViewer getGraphicalViewer() {
			return dummyGraphicalViewer;
		}

		@Override
		public DiagramBehavior getDiagramBehavior() {
			return behavior;
		}

		@Override
		public IDiagramTypeProvider getDiagramTypeProvider() {
			return dtp;
		}

		@Override
		public TransactionalEditingDomain getEditingDomain() {
			return behavior.getEditingDomain();
		}

		@Override
		public DefaultEditDomain getEditDomain() {
			return behavior.getEditDomain();
		}
	}
}
