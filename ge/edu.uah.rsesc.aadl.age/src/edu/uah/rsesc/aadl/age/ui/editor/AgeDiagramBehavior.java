package edu.uah.rsesc.aadl.age.ui.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.ui.xtext.AgeXtextUtil;

public class AgeDiagramBehavior extends DiagramBehavior {
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
	
	public AgeDiagramBehavior(IDiagramContainerUI diagramContainer) {
		super(diagramContainer);
	}

	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}
	
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {
		
		return new DefaultRefreshBehavior(this) {
			protected void autoUpdate() {
				IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
				Diagram diagram = diagramTypeProvider.getDiagram();
				IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
				IUpdateContext updateCtx = new UpdateContext(diagram);
				featureProvider.updateIfPossible(updateCtx);
				refresh();
			}
		};
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
