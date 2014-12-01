package org.osate.ge.ui.editor;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osate.ge.Activator;
import org.osate.ge.services.PropertyService;

public class IncreaseNestingDepthAction extends SelectionAction {
	public static final String ID = "org.osate.ge.ui.editor.IncreaseNestingLevelAction";
	public static final ImageDescriptor IMAGE_DESCRIPTOR = Activator.getImageDescriptor("icons/arrow_incr_nesting.png");
	
	private final AgeDiagramEditor editor;
	private final PropertyService propertyService;
	
	public IncreaseNestingDepthAction(final AgeDiagramEditor editor, final PropertyService propertyService) {
		super(editor);
		this.editor = editor;
		this.propertyService = propertyService;
		setId(ID);
		setText("Increase Nesting Depth");
		setHoverImageDescriptor(IMAGE_DESCRIPTOR);
	}

	@Override
	public void run() {
		final Diagram diagram = editor.getDiagramTypeProvider().getDiagram();
		final UpdateContext ctx = new UpdateContext(diagram);
		final IUpdateFeature feature = editor.getDiagramTypeProvider().getFeatureProvider().getUpdateFeature(ctx);
		
		// Set the selected mode property on the diagram and update the diagram
		editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain()) {
			@Override
			protected void doExecute() {
				final int currentDepth = propertyService.getNestingDepth(diagram);
				propertyService.setNestingDepth(diagram, currentDepth + 1);
				
				if(feature != null && feature.canUpdate(ctx)) {
					editor.getDiagramBehavior().executeFeature(feature, ctx);
				}
			}				
		});
	}

	@Override
	protected boolean calculateEnabled() {
		return true;
	}
}
