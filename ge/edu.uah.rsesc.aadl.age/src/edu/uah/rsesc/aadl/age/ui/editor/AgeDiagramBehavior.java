package edu.uah.rsesc.aadl.age.ui.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.DiagramService;
import edu.uah.rsesc.aadl.age.services.PropertyService;
import edu.uah.rsesc.aadl.age.services.impl.DefaultDiagramService;
import edu.uah.rsesc.aadl.age.ui.xtext.AgeXtextUtil;

import java.util.Map;

public class AgeDiagramBehavior extends DiagramBehavior {
	private final PropertyService propertyUtil;
	private final DiagramService diagramService;
	
	public AgeDiagramBehavior(final IDiagramContainerUI diagramContainer, final PropertyService propertyUtil, final DiagramService diagramService) {
		super(diagramContainer);
		this.propertyUtil = propertyUtil;
		this.diagramService = diagramService;
	}	
	
	private IXtextModelListener modelListener = new IXtextModelListener() {
		@Override
		public void modelChanged(final XtextResource resource) {
			if(resource.getContents().size() > 0) {
				final EObject contents = resource.getContents().get(0);
				final Object bo = AadlElementWrapper.unwrap(getDiagramTypeProvider().getFeatureProvider().getBusinessObjectForPictogramElement(getDiagramTypeProvider().getDiagram()));
				if(contents instanceof NamedElement && bo instanceof NamedElement) {
					final NamedElement namedElement = (NamedElement)bo;
					final String resourceContentsName = ((NamedElement)contents).getQualifiedName();
					final AadlPackage relevantPkg = bo instanceof AadlPackage ? (AadlPackage)bo : (AadlPackage)namedElement.getNamespace().getOwner();

					if(resourceContentsName.equalsIgnoreCase(relevantPkg.getQualifiedName())) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {			
								// Update the entire diagram
								getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });
							}
						});	
					}
				}
			}					
		}	
	};

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}
	
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {		
		return new DefaultRefreshBehavior(this) {
			@Override
			protected void autoUpdate() {
				IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
				Diagram diagram = diagramTypeProvider.getDiagram();
				IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
				IUpdateContext updateCtx = new UpdateContext(diagram);
				featureProvider.updateIfPossible(updateCtx);
				refresh();
			}
			
			@Override
			public void refresh() {
				// Update the toolbars
				if(getDiagramContainer() instanceof EditorPart) {
					((EditorPart)getDiagramContainer()).getEditorSite().getActionBars().getToolBarManager().update(true);
				}
				
				super.refresh();
			}
		};
	}
	
	@Override
	protected DefaultPersistencyBehavior createPersistencyBehavior() {
		return new DefaultPersistencyBehavior(this) {
			protected Set<Resource> save(final TransactionalEditingDomain editingDomain, final Map<Resource, Map<?, ?>> saveOptions, final IProgressMonitor monitor) {
				final Diagram diagram = getDiagramTypeProvider().getDiagram();
				final List<PictogramElement> ghosts = new ArrayList<PictogramElement>();
				
				// Find all ghost connections
				for(final Connection connection : diagram.getConnections()) {
					if(propertyUtil.isGhost(connection)) {
						ghosts.add(connection);
					}
				}
				
				// Find all ghost shapes
				findGhostShapes(diagram, ghosts);
				
				// Delete all the orphans
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					@Override
					protected void doExecute() {
						for(final PictogramElement pe : ghosts) {
							EcoreUtil.delete(pe, true);
						}
					}				
				});				
				
				// Save the diagram				
				final Set<Resource> retValue = super.save(editingDomain, saveOptions, monitor);
				
				// Set the persistent properties
				diagramService.savePersistentProperties(diagram);
				
				return retValue;
			}
		};
	}
	
	/**
	 * Returns all shapes that are ghosts. Ghosts are shapes that have been hidden because their linked business object is no longer valid.
	 * Does not include ghosts that are children of ghosts.
	 * @param shape
	 * @param ghostShapes
	 */
	private void findGhostShapes(final Shape shape, final List<PictogramElement> ghostShapes) {
		if(propertyUtil.isGhost(shape)) {
			ghostShapes.add(shape);
		} else {
			if(shape instanceof ContainerShape) {
				for(final Shape child : ((ContainerShape)shape).getChildren()) {
					findGhostShapes(child, ghostShapes);
				}
			}
		}
	}
	
	@Override
	protected void registerBusinessObjectsListener() {
		AgeXtextUtil.addModelListener(modelListener);
	}
	
	@Override
	protected void unregisterDiagramResourceSetListener() {
		AgeXtextUtil.removeModelListener(modelListener);
	}

	/**
	 * Implementation of executeFeature that flushes the command stack if a command that cannot be undone is executed.
	 */
	@Override
	public Object executeFeature(IFeature feature, IContext context) {
		// Ensure command stack is valid. May receive an async command after editor is closed
		final TransactionalEditingDomain editingDomain = this.getEditingDomain();
		if(editingDomain != null && editingDomain.getCommandStack() != null) {
			// Execute the feature and flush the command stack if the feature can not be undone.
			// This will prevent the user being able to perform partial undo's when the features does not support it
			final boolean canUndo = feature.canUndo(context);
			final Object ret = super.executeFeature(feature, context);
			if(!canUndo) {
				editingDomain.getCommandStack().flush();
			}
			
			return ret;
		}
		
		return null;
	}
}
