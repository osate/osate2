package edu.uah.rsesc.aadl.age.editor;

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
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.widgets.Display;
import edu.uah.rsesc.aadl.age.xtext.AgeXtextUtil;
import edu.uah.rsesc.aadl.age.xtext.ModelChangeListener;

public class AgeDiagramEditor extends DiagramEditor {
	public static final String DIAGRAM_EDITOR_ID = "edu.uah.rsesc.aadl.age.editor.AgeDiagramEditor";
	public static final String EXTENSION = ".aadl_diagram";
	
	private ModelChangeListener modelListener = new ModelChangeListener() {
		@Override
		public void modelChanged() {
			// TODO: Check which resource changed.
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {						
					// Update the entire diagram
					// TODO: See if this calls the classifiers update or just the diagram one.. May need to pass lots of items to the update?
					getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });
				}

			});
			
		}
		
	};
	
	public AgeDiagramEditor() {
	}
	
	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}
	
	@Override
	protected DefaultRefreshBehavior createRefreshBehavior() {
		return new DefaultRefreshBehavior(this) {
			protected void autoUpdate() {
				IDiagramTypeProvider diagramTypeProvider = diagramEditor.getDiagramTypeProvider();
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
		// Execute the feature and flush the command stack if the feature can not be undone.
		// This will prevent the user being able to perform partial undo's when the features does not support it
		final boolean canUndo = feature.canUndo(context);
		final Object ret = super.executeFeature(feature, context);
		final TransactionalEditingDomain editingDomain = this.getEditingDomain();
		if(!canUndo) {
			editingDomain.getCommandStack().flush();	
		}
		
		return ret;
	}
	
}
