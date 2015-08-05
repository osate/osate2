package org.osate.ge.ui.tools;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Flow;
import org.osate.ge.dialogs.CreateFlowsToolsDialog;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ColoringService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.UiService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
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
	IFeatureProvider fp;
	private CreateFlowsToolsDialog createEndToEndFlowDialog;
	ComponentImplementation ci;
	UiService uiService;
	List<PictogramElement> peList = new ArrayList<PictogramElement>();

	// private Label selectionStatusLabel;
	// TODO
	// @Icon
	// public final static ImageDescriptor ICON =
	// Activator.getImageDescriptor("icons/CreateEndToEndFlow.gif");

	@CanActivate
	public boolean canActivate() {
		// TODO
		return true;
	}

	@Activate
	public void activate(final AadlModificationService aadlModService,
			final UiService uiService,
			final ColoringService highlightingService,
			final BusinessObjectResolutionService bor,
			final ConnectionService connectionService,
			final ShapeService shapeService, final IFeatureProvider fp, final NamingService namingService) {
		// Create a coloring object that will allow adjustment of pictogram
		// colors
		coloring = highlightingService.adjustColors();
		// TODO: Create a tool window similiar to the one used in
		// SetBindingAction.

		this.uiService = uiService;
		createEndToEndFlowDialog = new CreateFlowsToolsDialog(Display.getCurrent()
				.getActiveShell(), bor, connectionService, shapeService, fp, namingService, ID);
		//eTEDialog.open();
		if (createEndToEndFlowDialog.open() == Dialog.CANCEL) {
			uiService.deactivateActiveTool();
			return;
		}

		aadlModService.modify(ci,
				new AbstractModifier<ComponentImplementation, Object>() {
					@Override
					public Object modify(final Resource resource,
							final ComponentImplementation ci) {
						// Clear existing flows
						/*
						 * ci.getOwnedEndToEndFlows().clear();
						 * ci.getOwnedFlowImplementations().clear();
						 */

						for (final Flow flow : createEndToEndFlowDialog.getFlows()) {
							if (flow instanceof EndToEndFlow) {
								ci.getOwnedEndToEndFlows().add(
										(EndToEndFlow) flow);
								ci.setNoFlows(false);
							}
						}

						return null;
					}
				});
		// TODO: This should be called when the tool is finished. For example
		// when the tool's window has been closed
		uiService.deactivateActiveTool();
	}

	@Deactivate
	public void deactivate(final IDiagramTypeProvider dtp) {
		System.err.println("Deactivate");
		// TODO
		final TransactionalEditingDomain editingDomain = dtp
				.getDiagramBehavior().getEditingDomain();
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
	public void onSelectionChanged(
			@Named(ToolConstants.SELECTED_PICTOGRAM_ELEMENTS) final PictogramElement[] selectedPes,
			final BusinessObjectResolutionService bor,
			final IDiagramTypeProvider dtp, AadlModificationService aadlModService) {
		ci = (ComponentImplementation) bor.getBusinessObjectForPictogramElement(dtp.getDiagram());

		// Highlight all selected shapes
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {
				//TODO: will just getting last selected pe work?

			/*	
				for (final PictogramElement pe : selectedPes) {
					if (eTEDialog.setTargetPictogramElements(pe)) {
						coloring.setForeground(pe, IColorConstant.RED);
					}
					if (eTEDialog.getDeletedPictogramElement() != null) {
						coloring.setForeground(eTEDialog.getDeletedPictogramElement(), IColorConstant.BLACK);
						eTEDialog.setDeletedPictogramElement();
					}
				}*/
				
				
				if (selectedPes.length > 0) {
					if (createEndToEndFlowDialog.setTargetPictogramElements(selectedPes[selectedPes.length-1])) {
						coloring.setForeground(selectedPes[selectedPes.length-1], IColorConstant.RED);
						
					}
					if (createEndToEndFlowDialog.getDeletedPictogramElement() != null) {
						coloring.setForeground(createEndToEndFlowDialog.getDeletedPictogramElement(), IColorConstant.BLACK);
						createEndToEndFlowDialog.setDeletedPictogramElement();
					}
				}
			}
		});

		// TODO: Implement. Update UI store information, etc as necessary
	}

	
}
