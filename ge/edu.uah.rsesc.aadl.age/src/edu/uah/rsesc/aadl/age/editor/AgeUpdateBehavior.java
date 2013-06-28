package edu.uah.rsesc.aadl.age.editor;

import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class AgeUpdateBehavior extends DefaultUpdateBehavior {
	public AgeUpdateBehavior(DiagramEditor diagramEditor) {
		super(diagramEditor);
	}

	// Use this editing domain?
	/*
	@Override
	protected void createEditingDomain() {
		// TODO: Need API instead of hard coding
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		initializeEditingDomain(editingDomain);
	}
	
	@Override
	protected void disposeEditingDomain() {
	}
	
	
	// Test 
	@Override
	protected void handleChangedResources() {
		final IDiagramTypeProvider dtp = diagramEditor.getDiagramTypeProvider();
		final Diagram diagram = dtp.getDiagram();
		final IFeatureProvider featureProvider = dtp.getFeatureProvider();
		final UpdateContext updateContext = new UpdateContext(diagram);
		OsateResourceUtil.refreshResourceSet();
		diagramEditor.refreshContent(); // TODO: Remove this
		this.getEditingDomain().getCommandStack().execute(new RecordingCommand(this.getEditingDomain()) {
			@Override
			protected void doExecute() {
				featureProvider.getUpdateFeature(updateContext).execute(updateContext);
			}
		});
	}
	*/
}
