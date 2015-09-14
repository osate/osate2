package org.osate.ge.ui.tools;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.ge.Activator;
import org.osate.ge.ext.ExtensionConstants;
import org.osate.ge.ext.annotations.Activate;
import org.osate.ge.ext.annotations.CanActivate;
import org.osate.ge.ext.annotations.Deactivate;
import org.osate.ge.ext.annotations.Description;
import org.osate.ge.ext.annotations.Icon;
import org.osate.ge.ext.annotations.Id;
import org.osate.ge.ext.annotations.SelectionChanged;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ColoringService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.UiService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.ui.tools.CreateEndToEndFlowTool;
import org.osate.ge.ui.util.ToolsDialogPlacementHelper;

public class CreateEndToEndFlowTool {
	private ColoringService.Coloring coloring = null;
	private CreateFlowsToolsDialog createEndToEndFlowDialog;
	private ComponentImplementation ci;
	private IDiagramTypeProvider dtp;
	private BusinessObjectResolutionService bor;
	private boolean canActivate = true;
	private final List<PictogramElement> previouslySelectedPes = new ArrayList<PictogramElement>();

	@Id
	public final static String ID = "org.osate.ge.ui.tools.CreateEndToEndFlowTool";

	@Description
	public final static String DESCRIPTION = "Create End to End Flow Specification";

	@Icon
	public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateEndToEndFlow.gif");

	@CanActivate
	public boolean canActivate(final IDiagramTypeProvider dtp, final BusinessObjectResolutionService bor) {
		return bor.getBusinessObjectForPictogramElement(dtp.getDiagram()) instanceof ComponentImplementation
				&& canActivate;
	}

	@Activate
	public void activate(final AadlModificationService aadlModService,
			final UiService uiService,
			final ColoringService highlightingService,
			final BusinessObjectResolutionService bor, final IDiagramTypeProvider dtp, final NamingService namingService) {
		this.dtp = dtp;
		this.bor = bor;
		// Create a coloring object that will allow adjustment of pictogram
		coloring = highlightingService.adjustColors();

		ci = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(dtp.getDiagram());
		if (ci != null) {
			canActivate = false;
			clearSelection(dtp);
			final Display display = Display.getCurrent();
			createEndToEndFlowDialog = new CreateFlowsToolsDialog(display.getActiveShell(), namingService);
			if (createEndToEndFlowDialog.open() == Dialog.CANCEL) {
				uiService.deactivateActiveTool();
				canActivate = true;
				previouslySelectedPes.clear();
				return;
			}

			if (!createEndToEndFlowDialog.getFlows().isEmpty()) {
				aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, Object>() {
					@Override
					public Object modify(final Resource resource, final ComponentImplementation ci) {
						for (EndToEndFlow eteFlow : createEndToEndFlowDialog.getFlows()) {
							ci.getOwnedEndToEndFlows().add(eteFlow);
							ci.setNoFlows(false);
						}
						return null;
					}
				});
			}
			previouslySelectedPes.clear();
			uiService.deactivateActiveTool();
		}
	}

	@Deactivate
	public void deactivate(final IDiagramTypeProvider dtp) {
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {
				// Dispose of the coloring object
				if (coloring != null) {
					if (createEndToEndFlowDialog != null) {
						createEndToEndFlowDialog.close();
					}
					coloring.dispose();
				}
				canActivate = true;
			}
		});
	}

	/**
	 * Clear selection for refresh
	 */
	private void clearSelection(final IDiagramTypeProvider dtp) {
		dtp.getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}

	@SelectionChanged
	public void onSelectionChanged(@Named(ExtensionConstants.SELECTED_PICTOGRAM_ELEMENTS) final PictogramElement[] selectedPes,
			final BusinessObjectResolutionService bor, final ShapeService shapeService, final ConnectionService connectionService) {
		// Highlight all selected shapes
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {
				for (PictogramElement pe : selectedPes) {
					Shape shape = null;
					if (pe instanceof Connection) {
						shape = connectionService.getOwnerShape((Connection)pe);
					} else if (pe instanceof ConnectionDecorator) {
						final ConnectionDecorator cd = ((ConnectionDecorator)pe);
						pe = cd.getConnection();
						shape = connectionService.getOwnerShape((Connection)pe);
					}

					final Object bo = bor.getBusinessObjectForPictogramElement(pe);
					final Context context = shapeService.getClosestBusinessObjectOfType(shape, Context.class);

					if (createEndToEndFlowDialog != null) {
						//if a PE has been removed, color it black
						if(createEndToEndFlowDialog.getRemovedElement() != null) {
							coloring.setForeground(createEndToEndFlowDialog.getRemovedElement(), Color.BLACK);
							createEndToEndFlowDialog.setRemovedElement(null);
						} else if (pe != null && createEndToEndFlowDialog.canAddSelectedElement(bo, context)) {
							if (bo instanceof ModeFeature) {
								coloring.setForeground(pe, Color.MAGENTA.brighter());
							} else if (createEndToEndFlowDialog.eTEFlow != null && createEndToEndFlowDialog.eTEFlow.getAllFlowSegments().size() == 1) {
								coloring.setForeground(pe, Color.ORANGE.darker());
							} else {
								coloring.setForeground(pe, Color.MAGENTA.darker());
							}
							previouslySelectedPes.add(pe);
						}
						if (createEndToEndFlowDialog.flowSegmentComposite != null && !createEndToEndFlowDialog.flowSegmentComposite.isDisposed()) {
							createEndToEndFlowDialog.setMessage(getDialogMessage());
						}
					}
				}
			}
		});
	}

	//Determine message based on currently selected element
	private String getDialogMessage() {
		String msg = "";
		if (previouslySelectedPes.size() > 0) {
			final Object bo = bor.getBusinessObjectForPictogramElement(previouslySelectedPes.get(previouslySelectedPes.size()-1));
			if(bo instanceof FlowSpecification || bo instanceof org.osate.aadl2.Connection) {
				if (bo instanceof FlowSpecification) {
					final FlowSpecification fs = (FlowSpecification)bo;
					if (fs.getKind() != FlowKind.SINK) {
						msg = "Select a connection.";
					}
				} else if (bo instanceof org.osate.aadl2.Connection) {
					msg = "Select a flow specification.";
				}
			} else {
				return createEndToEndFlowDialog.getMessage();
			}
		} else {
			msg = "Select a starting flow specification.";
		}
				
		if(msg.length() != 0) {
			msg += "\n";
		}
		msg += "Optionally, select a mode or mode transition.";
		
		return msg;
	}

	private class CreateFlowsToolsDialog extends TitleAreaDialog {
		private final List<EndToEndFlow> flows = new ArrayList<EndToEndFlow>();
		private Button undoButton;
		private Composite flowSegmentComposite;
		private StyledText flowSegmentLabel;
		private Text newETEFlowName;
		private NamingService namingService;
		private PictogramElement removedPictogramElement = null;
		private final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		final List<String> segmentList = new ArrayList<String>();
		final List<String> modeList = new ArrayList<String>();
		private final EndToEndFlow eTEFlow = (EndToEndFlow) pkg.getEFactoryInstance().create(pkg.getEndToEndFlow());
		public CreateFlowsToolsDialog(final Shell parentShell, final NamingService namingService) {
			super(parentShell);
			this.setHelpAvailable(false);
			this.namingService = namingService;
			setShellStyle(SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.ON_TOP | SWT.DIALOG_TRIM | SWT.MIN);
		}

		private List<EndToEndFlow> getFlows() {
			return Collections.unmodifiableList(flows);
		}

		/**
		 * Determines if the object selected is valid
		 * @param bo - current object selected
		 * @param context - current context
		 * @return - true or false depending if the object selected is valid
		 */
		private boolean canAddSelectedElement(final Object bo, final Context context) {
			final Element selectedEle = (Element)bo;
			if (isValid((Element)getRefinedElement(selectedEle), context)) {
				if (selectedEle instanceof org.osate.aadl2.Connection) {
					//Create flow segment with context = null because all valid connections belong to diagram
					return canAddFlowSegmentOrModeFeature(createEndToEndFlowSegments(selectedEle, null));
				} else if (selectedEle instanceof FlowSpecification) {
					return canAddFlowSegmentOrModeFeature(createEndToEndFlowSegments(selectedEle, context));
				} else {
					return canAddFlowSegmentOrModeFeature(selectedEle);
				}
			}
			return false;
		}

		/**
		 * @param selectedEle - current element
		 * @param context - current context
		 * @return - true or false depending on if the selected element is a valid start element
		 */
		private boolean isValidFirstElement(final Element selectedEle, final Context context) {
			return selectedEle instanceof FlowSpecification && ((FlowSpecification)selectedEle).getKind() == FlowKind.SOURCE
					&& isValidSubcomponent((Context)getRefinedElement(context));
		}

		/**
		 * Determines if subcomponent is valid context
		 * @param context - context of the selected element
		 */
		private boolean isValidSubcomponent(final Context context) {
			for (final Subcomponent subC : ci.getAllSubcomponents()) {
				if (getRefinedElement(subC) == context) {
					return true;
				}
			}
			return false;
		}

		/**
		 * @param ctx - context of element
		 * @param flowElement - element added to flow segments
		 * @return - name of segment for dialog
		 */
		private String getSegmentName(final Context ctx,
				final NamedElement flowElement) {
			String name = "";
			if (ctx != null) {
				name += ctx.getName() == null ? "<unknown>" : ctx.getName();
				name += ".";
			}
			name += flowElement.getName() == null ? "<unknown>" : flowElement
					.getName();
			return name;
		}

		private EndToEndFlowSegment createEndToEndFlowSegments(final Element selectedEle, final Context context) {
			final EndToEndFlowSegment eteFlowSegment = eTEFlow.createOwnedEndToEndFlowSegment();
			eteFlowSegment.setFlowElement((EndToEndFlowElement) selectedEle);
			eteFlowSegment.setContext(context);
			eTEFlow.getOwnedEndToEndFlowSegments().add(eteFlowSegment);
			return eteFlowSegment;
		}

		/**
		 * @param object - Flow segment or mode feature added to End to End Flow
		 * @return - true or false depending on if the object was added to End to End Flow
		 */
		private boolean canAddFlowSegmentOrModeFeature(final Object object) {
			if (!flowSegmentComposite.isDisposed()) {
				flowSegmentLabel.setEnabled(true);
				if (object instanceof EndToEndFlowSegment) {
					final EndToEndFlowSegment eteFlowSegment = (EndToEndFlowSegment)object;
					if (eTEFlow.getAllFlowSegments().indexOf(eteFlowSegment) == 0) {
						segmentList.add(getSegmentName(eteFlowSegment.getContext(), eteFlowSegment.getFlowElement()));
					} else {
						segmentList.add("  ->  " + getSegmentName(eteFlowSegment.getContext(), eteFlowSegment.getFlowElement()));
					}
				} else if (object instanceof ModeFeature) {
					final ModeFeature mf = (ModeFeature)object;
					eTEFlow.getInModeOrTransitions().add(mf);
					if (eTEFlow.getInModeOrTransitions().indexOf(mf) == 0) {
						modeList.add("  in modes  (" + mf.getName());
					} else {
						modeList.add(", " + mf.getName());
					}
				}

				setEndToEndFlowString();
				updateWidgets();
				return true;
			}
			return false;
		}

		/**
		 * Sets the dialog text for segments
		 */
		private void setEndToEndFlowString() {
			String segmentString = "";
			for (final String string : segmentList) {
				segmentString += string;
			}
			final String modeString = getModeString();
			flowSegmentLabel.setText(segmentString + modeString);
			if (modeString != "") {
				flowSegmentLabel.setStyleRange(new StyleRange(segmentString.length(), 12, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
			}
		}

		private String getModeString() {
			String modeString = "";
			for (final String string : modeList) {
				modeString += string;
			}
			return modeString == "" ? modeString : modeString + ")";
		}

		/**
		 * Sets PictogramElement removed from End to End Flow and removes from previous PE list
		 * @param setValue
		 */
		private void setRemovedElement(final PictogramElement setValue) {
			removedPictogramElement = setValue;
			previouslySelectedPes.remove(setValue);
		}

		private PictogramElement getRemovedElement() {
			return removedPictogramElement;
		}

		private void updateWidgets() {
			createEndToEndFlowDialog.setMessage(CreateEndToEndFlowTool.this.getDialogMessage());
			setNavigationButtonsEnabled(isCompleteAndValid() && eTEFlow.getName().length() != 0);
		}

		private boolean isCompleteAndValid() {
			return (eTEFlow.getAllFlowSegments().size() > 2 && eTEFlow.getAllFlowSegments().size() % 2 == 1
					&& eTEFlow.getAllFlowSegments().get(0).getFlowElement() instanceof FlowSpecification
					&& eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size()-1).getFlowElement() instanceof FlowSpecification);
		}

		private void setNavigationButtonsEnabled(final boolean enabled) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			}
			if (undoButton != null) {
				undoButton.setEnabled(eTEFlow != null && (eTEFlow.getInModeOrTransitions().size() > 0 || eTEFlow.getAllFlowSegments().size() > 0));
			}
		}

		private Object getPreviousSegmentElement() {
			return eTEFlow.getAllFlowSegments().size() > 0 ? getRefinedElement(eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size()-1).getFlowElement()) : null;
		}

		/**
		 * Determines if the selected element is valid to be added to Flow Implementation
		 * @param selectedEle - selected element
		 * @param context - context of element
		 * @return
		 */
		private boolean isValid(final Element selectedEle, final Context context) {
			if ((eTEFlow.getAllFlowSegments().size() == 0 && selectedEle instanceof FlowSpecification)) {
				return isValidFirstElement(selectedEle, context);
			} else if (selectedEle instanceof ModeFeature) {
				return context == null;
			} else {
				final Object prevEle = getRefinedElement(getPreviousSegmentElement());
				if (prevEle != null) {
					if ((prevEle instanceof org.osate.aadl2.Connection)
							&& (selectedEle instanceof FlowSpecification) && isValidSubcomponent((Context) getRefinedElement(context))) {
						final FlowSpecification segFs = (FlowSpecification)selectedEle;
						final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
						if (segFs.getKind() == FlowKind.SINK || segFs.getKind() == FlowKind.PATH) {
							if (con.isBidirectional()) {
								if (con.getDestination().getConnectionEnd() == segFs.getInEnd().getFeature()
										|| con.getSource().getConnectionEnd() == segFs.getInEnd().getFeature()) {
									return true;
								}
							} else {
								if (con.getDestination().getConnectionEnd() == segFs.getInEnd().getFeature()) {
									return true;
								}
							}
						}
					} else if ((prevEle instanceof FlowSpecification)
							&& (selectedEle instanceof org.osate.aadl2.Connection)) {
						final FlowSpecification segFs = (FlowSpecification)prevEle;
						if (segFs.getKind() == FlowKind.SOURCE || segFs.getKind() == FlowKind.PATH) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)selectedEle;
							return isValidConnection(segFs, con, context);
						}
					}
				}
			}
			return false;
		}

		private Object getRefinedElement(final Object ce) {
			if(ce instanceof RefinableElement) {
				final RefinableElement refinedElement = ((RefinableElement)ce).getRefinedElement();
				return refinedElement == null ? ce : getRefinedElement(refinedElement);
			}

			return ce;
		}

		/**
		 * Check the connections validity
		 * @param fs - previous FlowSpecification selected
		 * @param connection - current selected connection
		 * @param context - context of the connection
		 */
		private boolean isValidConnection(final FlowSpecification fs, final org.osate.aadl2.Connection connection, final Context context) {
			final ConnectionEnd destCE = (ConnectionEnd)getRefinedElement(connection.getDestination().getConnectionEnd());
			final ConnectionEnd srcCE = (ConnectionEnd)getRefinedElement(connection.getSource().getConnectionEnd());
			if (context != null && !isValidSubcomponent((Context)getRefinedElement(context))) {
				return false;
			}

			if (connection.getDestination().getContext() != null && connection.getSource().getContext() != null) {
				final Feature flowFeature = fs.getKind() == FlowKind.SINK ? fs.getInEnd().getFeature() : fs.getOutEnd().getFeature();
				if (fs.getKind() == FlowKind.PATH) {
					final Feature inFlowFeature = fs.getInEnd().getFeature();
					if (connection.isBidirectional()) {
						return inFlowFeature == destCE
								|| inFlowFeature == srcCE
								|| flowFeature == destCE
								|| flowFeature == srcCE;
					} else {
						return flowFeature == srcCE
								|| inFlowFeature == destCE;
					}
				} else if (fs.getKind() == FlowKind.SINK) {
					return flowFeature == srcCE || flowFeature == destCE;
				} else {
					if (connection.isBidirectional()) {
						return flowFeature == destCE || flowFeature == srcCE;
					}
					return flowFeature == srcCE;
				}
			}
			return false;
		}


		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Create End To End Flow");
			newShell.setLocation(ToolsDialogPlacementHelper.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(475, 275);
			newShell.setImage(ICON.createImage());
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select Elements");
			setMessage(CreateEndToEndFlowTool.this.getDialogMessage());
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite)super.createDialogArea(parent);
			flowSegmentComposite = new Composite(container, SWT.CENTER);
			final RowLayout rowLayout = new RowLayout();
			rowLayout.marginLeft = 10;
			rowLayout.marginTop = 5;
			flowSegmentComposite.setLayout(rowLayout);

			flowSegmentLabel = new StyledText(flowSegmentComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
			flowSegmentLabel.setEditable(false);
			flowSegmentLabel.setEnabled(false);
			flowSegmentLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			flowSegmentLabel.setMargins(5, 5, 5, 5);
			final RowData rowData = new RowData();
			rowData.height = 100;
			rowData.width = 415;
			flowSegmentLabel.setLayoutData(rowData);
			flowSegmentLabel.setLayout(new RowLayout());

			return container;
		}

		@Override
		protected Control createButtonBar(final Composite parent) {
			final Composite buttonBar = new Composite(parent, SWT.NONE);
			final GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.horizontalSpacing = 0;
			buttonBarLayout.numColumns = 4;
			buttonBar.setLayout(buttonBarLayout);
			final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
			buttonBar.setLayoutData(buttonBarData);
			buttonBar.setFont(parent.getFont());

			final Label nameLabel = new Label(buttonBar, SWT.NONE);
			nameLabel.setText("Name: ");
			final GridData nameLabelData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
			nameLabelData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			nameLabel.setLayoutData(nameLabelData);

			newETEFlowName = new Text(buttonBar, SWT.DEFAULT);
			final GridData nameTextData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
			nameTextData.widthHint = 180;
			newETEFlowName.setLayoutData(nameTextData);
			newETEFlowName.setEditable(true);
			newETEFlowName.setOrientation(SWT.LEFT_TO_RIGHT);
			newETEFlowName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(final KeyEvent e) {
					final String errorMsg;
					if(!namingService.isValidIdentifier(newETEFlowName.getText())) {
						errorMsg = "Name is not a valid identifier";	
					} else if(namingService.isNameInUse(ci, newETEFlowName.getText())) {
						errorMsg = "The specified name is already is use.";
					} else {
						errorMsg = null;
					}
					
					createEndToEndFlowDialog.setErrorMessage(errorMsg);
					eTEFlow.setName(newETEFlowName.getText());
					updateWidgets();
				}
			});

			undoButton = new Button(buttonBar, SWT.PUSH);
			undoButton.setEnabled(false);
			undoButton.setText("Undo");
			undoButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					int prevPesSize = previouslySelectedPes.size();
					if (prevPesSize > 0) {
						final PictogramElement removedPe = previouslySelectedPes.get(prevPesSize-1);
						setRemovedElement(removedPe);
						final Object ob = bor.getBusinessObjectForPictogramElement(removedPe);
						if (ob instanceof ModeFeature)  {
							eTEFlow.getInModeOrTransitions().remove(eTEFlow.getInModeOrTransitions().size()-1);
						} else {
							final EndToEndFlowSegment flowSegment = eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size()-1);
							eTEFlow.getAllFlowSegments().remove(flowSegment);
							EcoreUtil.remove(flowSegment);
						}
						
						//Clear strings for refresh
						segmentList.clear();
						modeList.clear();
						flowSegmentLabel.setText("");
						for (EndToEndFlowSegment c : eTEFlow.getAllFlowSegments()) {
							canAddFlowSegmentOrModeFeature(c);
						}
						for (ModeFeature m : eTEFlow.getInModeOrTransitions()) {
							canAddFlowSegmentOrModeFeature(m);
						}

						clearSelection(dtp);
						updateWidgets();
					}
				}
			});

			final GridData removeBtnData = new GridData(SWT.LEFT, SWT.CENTER, true, false);
			removeBtnData.horizontalIndent = 4;
			removeBtnData.widthHint = 45;
			undoButton.setLayoutData(removeBtnData);

			super.createButtonBar(buttonBar);
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
			okBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					flows.add(eTEFlow);
				}
			});

			final GridData okBtnData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
			okBtnData.widthHint = 65;
			okBtn.setLayoutData(okBtnData);

			final GridData cancelBtnData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
			cancelBtnData.widthHint = 65;
			final Button cancelBtn = getButton(IDialogConstants.CANCEL_ID);
			cancelBtn.setLayoutData(cancelBtnData);

			return buttonBar;
		}
	}



}

