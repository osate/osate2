package org.osate.ge.ui.tools;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.internal.GraphitiUIPlugin;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ColoringService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.DiagramService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.UiService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.services.impl.DefaultDiagramService;
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
	//private PictogramElement selectedPE = null;
	private CreateEndToEndFlowToolDialog eTEDialog;
	ComponentImplementation ci;
	//private Label selectionStatusLabel;
	// TODO
	//@Icon
	//public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateEndToEndFlow.gif");

	@CanActivate
	public boolean canActivate() {
		// TODO
		return true;
	}

	@Activate
	public void activate(final AadlModificationService aadlModService, final UiService uiService, final ColoringService highlightingService, final BusinessObjectResolutionService bor, final ConnectionService connectionService, final ShapeService shapeService) {
		System.err.println("Activate");
		// Create a coloring object that will allow adjustment of pictogram colors
		coloring = highlightingService.adjustColors();
		// TODO: Create a tool window similiar to the one used in SetBindingAction.

		eTEDialog = new CreateEndToEndFlowToolDialog(Display.getCurrent().getActiveShell(), bor, connectionService, shapeService);
		if(eTEDialog.open() == Dialog.CANCEL) {
			uiService.deactivateActiveTool();
			return;
		}
		
		aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, Object>() {
			@Override
			public Object modify(final Resource resource, final ComponentImplementation ci) {
				// Clear existing flows
/*				ci.getOwnedEndToEndFlows().clear();
				ci.getOwnedFlowImplementations().clear();*/
				
				for(final Flow flow : eTEDialog.getFlows()) {
					if(flow instanceof EndToEndFlow) {
						ci.getOwnedEndToEndFlows().add((EndToEndFlow)flow);
						ci.setNoFlows(false);
					}
				}

				return null;
			}
		});

		/*for (Flow e : eTEDialog.getFlows()) {
			System.err.println(e.getName());
		}*/
		// TODO: This should be called when the tool is finished. For example when the tool's window has been closed
		uiService.deactivateActiveTool();
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
		//System.err.println("Selection Changed. Selected: ");
		// Highlight all selected shapes
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		System.err.println(bor.getBusinessObjectForPictogramElement(dtp.getDiagram()) + " CI");
		ci= (ComponentImplementation) bor.getBusinessObjectForPictogramElement(dtp.getDiagram());
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {			
			@Override
			public void execute() {				
				for(final PictogramElement pe : selectedPes) {
					if (eTEDialog.setTargetPictogramElements(pe)) {
						coloring.setForeground(pe, IColorConstant.RED);
						//eTEDialog.updateButtons();
					}
				}
			}
		});

		// TODO: Implement. Update UI store information, etc as necessary

	}

	private static class FlowSegmentInfo {
		public final Context context;
		public final NamedElement flowElement;

		public FlowSegmentInfo(final Context context, final NamedElement flowElement) {
			this.context = context;
			this.flowElement = flowElement;
		}

		public int hashCode() {
			return (context == null ? 0 : context.hashCode()) + (flowElement == null ? 0 : flowElement.hashCode());
		}

		public boolean equals(Object obj) {
			if(obj == null)
				return false;

			if(obj == this)
				return true;

			if(!(obj instanceof FlowSegmentInfo))
				return false;

			final FlowSegmentInfo rhs = (FlowSegmentInfo)obj;
			return ((context == null && rhs.context == null) || (context != null && context.equals(rhs.context))) &&
					((flowElement == null && rhs.flowElement == null) || (flowElement != null && flowElement.equals(rhs.flowElement)));
		}
	}

	private static class CreateEndToEndFlowToolDialog extends TitleAreaDialog {
		BusinessObjectResolutionService bor;
		ConnectionService connectionService;
		private final List<FlowSegmentInfo> potentialFlowSegments = new ArrayList<FlowSegmentInfo>();
		//private Label selectionStatusLabel;
		List<Flow> flows = new ArrayList<Flow>();
		Composite flowSegmentComposite;
		GridData gridData;
		final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		final EndToEndFlow newFlow = (EndToEndFlow)pkg.getEFactoryInstance().create(pkg.getEndToEndFlow());

		public CreateEndToEndFlowToolDialog(Shell parentShell, BusinessObjectResolutionService bor, ConnectionService connectionService, ShapeService shapeService) {
			super(parentShell);
			this.setHelpAvailable(false);
			this.bor = bor;
			this.connectionService = connectionService;
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
		}

		public List<Flow> getFlows() {
			return flows;
		}

	/*	public void updateButtons() {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if(okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}
		}*/

		public boolean setTargetPictogramElements(PictogramElement pe) {
			if (pe instanceof Connection) {
				int index = newFlow.getOwnedEndToEndFlowSegments().size();
				Element selectedEle = (Element) bor.getBusinessObjectForPictogramElement(pe);
				Context context = bor.getBusinessObjectForPictogramElement(connectionService.getOwnerShape((Connection) pe)) instanceof Subcomponent ? (Context) bor.getBusinessObjectForPictogramElement(connectionService.getOwnerShape((Connection) pe)) : null;
				addFlowSegment(newFlow, selectedEle, context, index++);
			}  else {
				return false;
			}
			return true;
		}

		private String getSegmentName(final Context ctx, final NamedElement flowElement) {
			String name = "";
			if(ctx != null) {
				name += ctx.getName() == null ? "<unknown>" : ctx.getName();
				name += ".";
			}

			name += flowElement.getName() == null ? "<unknown>" : flowElement.getName();
			potentialFlowSegments.add(new FlowSegmentInfo(ctx, flowElement));
			return name;
		}
		
		private void updateFlowPane(final EndToEndFlow eteFlow) {
			
			for(Control child : flowSegmentComposite.getChildren()) {
				if(!child.isDisposed()) {
					child.dispose();
				}
		    }
			int index = 0;
			for (final EndToEndFlowSegment eteFlowSegment : eteFlow.getAllFlowSegments()) {
				eteFlow.getOwnedEndToEndFlowSegments().move(index, eteFlowSegment);
				
				Button deleteFlowSegmentButton = new Button(flowSegmentComposite, SWT.PUSH);
				deleteFlowSegmentButton.setText("Delete");
				deleteFlowSegmentButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						EcoreUtil.remove(eteFlowSegment);						
						System.err.println(eteFlow.getAllFlowSegments().size() + " size");
						updateFlowPane(eteFlow);
					}
				});
				
				final Label flowSegmentLabel = new Label(flowSegmentComposite, SWT.NONE);
				gridData = new GridData();
				gridData.widthHint = 200;
				flowSegmentLabel.setText(getSegmentName(eteFlowSegment.getContext(), eteFlowSegment.getFlowElement()));

				flowSegmentLabel.setLayoutData(gridData);
				final Label flowSegmentDetailsLabel = new Label(flowSegmentComposite, SWT.None);
				gridData = new GridData();
				gridData.widthHint = 200;
				flowSegmentDetailsLabel.setText("Detail Message");
				flowSegmentDetailsLabel.setLayoutData(gridData);

				updateWidgets(eteFlow);
			}
			
		
			
			flowSegmentComposite.pack();
			flowSegmentComposite.layout(true);
			
		}

		private void addFlowSegment(final EndToEndFlow eteFlow, final Element selectedEle, Context context, int index) {
			//TODO: All connections?
			System.err.println(index);
			if (selectedEle instanceof FlowSpecification || selectedEle instanceof org.osate.aadl2.Connection) {
				//EndToEndFlowSegment eteFlowSegment = eteFlow.createOwnedEndToEndFlowSegment();
				eteFlow.getOwnedEndToEndFlowSegments().move(index, eteFlow.createOwnedEndToEndFlowSegment());
				final EndToEndFlowSegment eteFlowSegment = eteFlow.getOwnedEndToEndFlowSegments().get(index);
				eteFlowSegment.setContext(context);
				eteFlowSegment.setFlowElement((EndToEndFlowElement) selectedEle);
				/*for (EndToEndFlowSegment e : eteFlow.getOwnedEndToEndFlowSegments()) {
					e.setContext(context);
					e.setFlowElement((EndToEndFlowElement)selectedEle);
				}*/
				Button deleteFlowSegmentButton = new Button(flowSegmentComposite, SWT.PUSH);
				deleteFlowSegmentButton.setText("Delete");
				deleteFlowSegmentButton.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						System.err.println(selectedEle + " selectedEleETEEE");
						EcoreUtil.remove(eteFlowSegment);						
						System.err.println(eteFlow.getAllFlowSegments().size() + " size");
						updateFlowPane(eteFlow);
					}
				});
				/*deleteFlowSegmentButton.addSelectionListener(new SelectionListener() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						System.err.println(selectedEle.getElementRoot().getName());
						EcoreUtil.remove(selectedEle);
						flowSegmentComposite.pack();
						flowSegmentComposite.layout(true);
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
*/
				final Label flowSegmentLabel = new Label(flowSegmentComposite, SWT.NONE);
				gridData = new GridData();
				gridData.widthHint = 200;
				flowSegmentLabel.setText(getSegmentName(context, (NamedElement)selectedEle));

				flowSegmentLabel.setLayoutData(gridData);
				final Label flowSegmentDetailsLabel = new Label(flowSegmentComposite, SWT.None);
				gridData = new GridData();
				gridData.widthHint = 200;
				flowSegmentDetailsLabel.setText("Detail Message");
				flowSegmentDetailsLabel.setLayoutData(gridData);

				updateWidgets(eteFlow);
				//index++;
				flowSegmentComposite.pack();
				flowSegmentComposite.layout(true);
			}
		}

		private void updateWidgets(EndToEndFlow eteFlow) {
			System.err.println(eteFlow == null);
			setNavigationButtonsEnabled(eteFlow == null ? false : isValid(eteFlow));
		}

		private void setNavigationButtonsEnabled(boolean enabled) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if(okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			}
		}

		private boolean isValid(EndToEndFlow eteFlow) {
			// TODO: Cleanup. Is it possible to have 1 function that is used for all the checks?
			// Perform a basic validity check. Ensure that the number of elements is reasonable, that there aren't any null segments, and that connections are not adjacent in the segment list
			// Check for minimum number of flow segments
			if(eteFlow.getAllFlowSegments().size() < 3 || (eteFlow.getAllFlowSegments().size() % 2) != 1) {
				System.err.println("AAAA");
				return false;
			}

			EndToEndFlowSegment prevSegment = null;
			for(final EndToEndFlowSegment seg : eteFlow.getAllFlowSegments()) {
				System.err.println(seg.getFlowElement());
				if(seg.getFlowElement() == null) {
					System.err.println("BBB");
					return false;
				}

				if(prevSegment == null) {
					// start_subcomponent_flow_or_etef_identifier
					if(seg.getFlowElement() instanceof Connection) {
						System.err.println("CCC");
						return false;
					}
				} else {
					// Ensure that two connections or two flow paths are not connected to one another
					if((prevSegment.getFlowElement() instanceof org.osate.aadl2.Connection) == (seg.getFlowElement() instanceof org.osate.aadl2.Connection)) {
						System.err.println("DDDD");
						return false;
					}
				}
				
				prevSegment = seg;
			}		

			return true;
		}
		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Edit Flows");
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);
			final ScrolledComposite flowSegmentScrolled = new ScrolledComposite(container, SWT.V_SCROLL);
			final GridData flowSegmentScrolledGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			flowSegmentScrolledGridData.minimumWidth = 250;
			flowSegmentScrolledGridData.minimumHeight = 300;
			flowSegmentScrolledGridData.grabExcessHorizontalSpace = true;
			flowSegmentScrolled.setLayoutData(flowSegmentScrolledGridData);
			flowSegmentScrolled.setLayout(new GridLayout(1, false));

			flowSegmentComposite = new Composite(flowSegmentScrolled, SWT.NONE);
			GridData flowSegmentGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			flowSegmentComposite.setLayoutData(flowSegmentGridData);
			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 3;
			flowSegmentComposite.setLayout(gridLayout);
			flowSegmentScrolled.setContent(flowSegmentComposite);

			return container;
		}

		@Override
		protected Control createButtonBar(final Composite parent) {
			final Composite buttonBar = new Composite(parent, SWT.NONE);
			final GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.numColumns = 4;
			buttonBar.setLayout(buttonBarLayout);

			final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
			buttonBarData.grabExcessHorizontalSpace = true;
			buttonBarData.grabExcessVerticalSpace = false;
			buttonBar.setLayoutData(buttonBarData);

			buttonBar.setFont(parent.getFont());

			final Label nameLabel = new Label(buttonBar, SWT.NONE);
			nameLabel.setText("Name: ");
			final GridData nameLabelData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
			nameLabelData.grabExcessHorizontalSpace = true;
			nameLabelData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			nameLabel.setLayoutData(nameLabelData);

			final Text nameText = new Text(buttonBar, SWT.DEFAULT);
			final GridData nameTextData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
			nameTextData.grabExcessHorizontalSpace = true;
			nameTextData.widthHint = 250;
			nameText.setLayoutData(nameTextData);
			nameText.setEditable(true);
			nameText.addKeyListener(new KeyListener() {
				
				@Override
				public void keyReleased(KeyEvent e) {
					newFlow.setName(nameText.getText());
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					
					
				}
			});

			final Control buttonControl = super.createButtonBar(buttonBar);
			buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent e) {
					flows.add(newFlow);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			if(okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}
			return buttonBar;
		}
	}

}
