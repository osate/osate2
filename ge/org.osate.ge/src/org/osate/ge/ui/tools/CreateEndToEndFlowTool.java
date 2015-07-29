package org.osate.ge.ui.tools;

import javax.inject.Named;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ColoringService;
import org.osate.ge.services.UiService;
import org.osate.ge.ui.tools.annotations.Activate;
import org.osate.ge.ui.tools.annotations.CanActivate;
import org.osate.ge.ui.tools.annotations.Deactivate;
import org.osate.ge.ui.tools.annotations.Description;
import org.osate.ge.ui.tools.annotations.Id;
import org.osate.ge.ui.tools.annotations.SelectionChanged;

public class CreateEndToEndFlowTool {
	@Id
	public final static String ID = "org.osate.ge.ui.tools.CreateEndToEndFlowTool";
	
	@Description
	public final static String DESCRIPTION = "Create End to End Flow Specification";
	
	private ColoringService.Coloring coloring = null;
	
	// TODO
	//@Icon
	//public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateEndToEndFlow.gif");
	
	@CanActivate
	public boolean canActivate() {
		// TODO
		return true;
	}
	
	@Activate
	public void activate(final UiService uiService, final ColoringService highlightingService) {
		System.err.println("Activate");
		
		// Create a coloring object that will allow adjustment of pictogram colors
		coloring = highlightingService.adjustColors();
		// TODO: Create a tool window similiar to the one used in SetBindingAction.
		
		// TODO: This should be called when the tool is finished. For example when the tool's window has been closed
		//uiService.deactivateActiveTool();
	}
	
	@Deactivate
	public void deactivate(final IDiagramTypeProvider dtp) {
		System.err.println("Deactivate");

		// TODO
		
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {			
			@Override
			public void execute() {				
				// Dispose of the coloring object
				coloring.dispose();
				coloring = null;
			}
		});
	}
	
	@SelectionChanged
	public void onSelectionChanged(@Named(ToolConstants.SELECTED_PICTOGRAM_ELEMENTS) final PictogramElement[] selectedPes, final BusinessObjectResolutionService bor, final IDiagramTypeProvider dtp) {
		System.err.println("Selection Changed. Selected: ");
		
		// Highlight all selected shapes
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {			
			@Override
			public void execute() {				
				for(final PictogramElement pe : selectedPes) {
					System.err.println(bor.getBusinessObjectForPictogramElement(pe));
					coloring.setForeground(pe, IColorConstant.RED);
				}
			}
		});
		
		// TODO: Implement. Update UI store information, etc as necessary
	}
}
