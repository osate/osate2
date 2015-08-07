package org.osate.ge.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.ui.tools.CreateEndToEndFlowTool;

public class CreateFlowsToolsDialog extends TitleAreaDialog {
	BusinessObjectResolutionService bor;
	final ConnectionService connectionService;
	List<Flow> flows = new ArrayList<Flow>();
	Composite flowSegmentComposite;
	GridData gridData;

	Text nameText = null;
	NamingService namingService;
	final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
	String title;
	ShapeService shapeService;
	Flow flow;
	PictogramElement deletedPE = null;
	Object prevETEFlow = null;
	public CreateFlowsToolsDialog(final Shell parentShell,
			final BusinessObjectResolutionService bor,
			final ConnectionService connectionService, ShapeService shapeService, final NamingService namingService, final String ID) {
		super(parentShell);
		this.setHelpAvailable(false);
		this.bor = bor;
		this.connectionService = connectionService;
		this.namingService = namingService;
		this.title = ID;
		this.shapeService = shapeService;
		
		setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
		if (ID.equals(CreateEndToEndFlowTool.ID)) {
			flow = (EndToEndFlow) pkg.getEFactoryInstance().create(pkg.getEndToEndFlow());
		} else {
			flow = (FlowImplementation)pkg.getEFactoryInstance().create(pkg.getFlowImplementation());
		}
	}

	public List<Flow> getFlows() {
		return Collections.unmodifiableList(flows);
	}

	public boolean setTargetPictogramElements(PictogramElement pe, Object bo, Object ciType, Object selectedETEFlow) {
		if (flow instanceof EndToEndFlow) {
			final boolean endToEndFlowSelected = selectedETEFlow != null;
			final EndToEndFlow newFlow = (EndToEndFlow)flow;
			final Element selectedEle = (Element)bo;
			
			if ((selectedEle instanceof FlowSpecification) && ((FlowSpecification)selectedEle).getNamespace().equals(ciType)
					|| (newFlow.getInModeOrTransitions().size() != 0 && !(selectedEle instanceof ModeFeature))) {
				return false;
			}

			if (endToEndFlowSelected) {
				if (selectedETEFlow.equals(prevETEFlow)) {
					return true;
				}
				
				if (newFlow.getAllFlowSegments().size() > 0 && !(newFlow.getAllFlowSegments().get(newFlow.getAllFlowSegments().size()-1).getFlowElement() instanceof org.osate.aadl2.Connection)) {
					return false;
				}
				prevETEFlow = selectedETEFlow;
				EndToEndFlowSegment eteFlowSeg = newFlow.createOwnedEndToEndFlowSegment();
				eteFlowSeg.setFlowElement((EndToEndFlowElement) selectedETEFlow);
				addFlowSegment(newFlow, eteFlowSeg);
				return true;
			}
			
			Context context;
			if (pe instanceof Connection) {
				context = bor.getBusinessObjectForPictogramElement(connectionService.getOwnerShape((Connection) pe)) instanceof Subcomponent ? (Context) bor
						.getBusinessObjectForPictogramElement(connectionService
								.getOwnerShape((Connection) pe)) : null;
			} else if (selectedEle instanceof Mode) {
				context = null;
			} else {
				return false;
			}
			//if first element is not a source
			if (newFlow.getAllFlowSegments().size() == 0) {
				if ((selectedEle instanceof FlowSpecification)) {
					if (((FlowSpecification)selectedEle).getKind() != FlowKind.SOURCE) {
						return false;
					}
				} else {
					return false;
				}
			}

			if (isValid(newFlow, selectedEle, selectedETEFlow)) {
				if (!endToEndFlowSelected) {
					if ((selectedEle instanceof FlowSpecification || selectedEle instanceof org.osate.aadl2.Connection)) {
						addFlowSegment(newFlow, createEndToEndFlowSegments(selectedEle, context, newFlow));
					} else {
						addFlowSegment(newFlow, selectedEle);
					}
				}
				return true;
			}
		} else if(flow instanceof FlowImplementation) {

		}
		return false;
	}

	private boolean validFirstElement(EndToEndFlow newFlow, Element selectedEle) {
		return (selectedEle instanceof FlowSpecification) && (((FlowSpecification)selectedEle).getKind() == FlowKind.SOURCE);
	}

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

	private EndToEndFlowSegment createEndToEndFlowSegments(
			final Element selectedEle, final Context context, final EndToEndFlow newFlow) {
		EndToEndFlowSegment eteFlowSegment = ((EndToEndFlow) newFlow)
				.createOwnedEndToEndFlowSegment();
		eteFlowSegment.setFlowElement((EndToEndFlowElement) selectedEle);
		eteFlowSegment.setContext(context);
		((EndToEndFlow) newFlow).getOwnedEndToEndFlowSegments().add(eteFlowSegment);
		return eteFlowSegment;
	}

	public PictogramElement getDeletedPictogramElement() {
		return deletedPE;
	}

	public void setDeletedPictogramElement() {
		deletedPE = null;
	}

	private void addFlowSegment(final EndToEndFlow flow,
			final Object object) {
		if (flow instanceof EndToEndFlow) {
			final EndToEndFlow eTEFlow = (EndToEndFlow)flow;

			// TODO: All connections?
			/*Button deleteFlowSegmentButton = new Button(flowSegmentComposite,
					SWT.PUSH);
			deleteFlowSegmentButton.setText("Delete");
			deleteFlowSegmentButton
			.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					deletedPE = fp.getPictogramElementForBusinessObject(eteFlowSegment.getFlowElement());
					fp.getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer().setPictogramElementsForSelection(new PictogramElement[0]);
					fp.getDiagramTypeProvider().getDiagramBehavior().refresh();
					EcoreUtil.remove(eteFlowSegment);
					potentialFlowSegments.remove(new FlowSegmentInfo(eteFlowSegment.getContext(), (NamedElement) eteFlowSegment.getFlowElement()));
					updateFlowPane(eTEFlow);
				}
			});*/
			if (!flowSegmentComposite.isDisposed()) {
			final Label flowSegmentLabel = new Label(flowSegmentComposite,
					SWT.NONE);
			gridData = new GridData();
			gridData.widthHint = 200;
			if (object instanceof EndToEndFlowSegment) {
				EndToEndFlowSegment eteFlowSegment = (EndToEndFlowSegment) object;
					flowSegmentLabel.setText(getSegmentName(
							eteFlowSegment.getContext(),
							eteFlowSegment.getFlowElement()));
					flowSegmentLabel.setLayoutData(gridData);
					final Label flowSegmentDetailsLabel = new Label(
							flowSegmentComposite, SWT.None);
					gridData = new GridData();
					gridData.widthHint = 200;
					flowSegmentDetailsLabel.setText("Detail Message");
					flowSegmentDetailsLabel.setLayoutData(gridData);
			} else if (object instanceof ModeFeature) {
				ModeFeature mf = (ModeFeature)object;
				flowSegmentLabel.setText(mf.getName());
				flowSegmentLabel.setLayoutData(gridData);
				final Label flowSegmentDetailsLabel = new Label(
						flowSegmentComposite, SWT.None);
				gridData = new GridData();
				gridData.widthHint = 200;
				flowSegmentDetailsLabel.setText("Detail Message");
				flowSegmentDetailsLabel.setLayoutData(gridData);
			}
			updateWidgets(eTEFlow);
		}
		flowSegmentComposite.pack();
		flowSegmentComposite.layout(true);
		}
	}

	private void updateWidgets(Flow flow) {
			EndToEndFlow eteFlow = (EndToEndFlow) flow;	
			setNavigationButtonsEnabled(true);
			setNavigationButtonsEnabled(isCompleteAndValid(eteFlow) && !eteFlow.getName().equals(""));
	}

	private boolean isCompleteAndValid(EndToEndFlow eteFlow) {
		return (eteFlow.getAllFlowSegments().size() > 2 && eteFlow.getAllFlowSegments().size() % 2 == 1
				&& (eteFlow.getAllFlowSegments().get(0).getFlowElement() instanceof FlowSpecification || eteFlow.getAllFlowSegments().get(0).getFlowElement() instanceof EndToEndFlow)
				&& eteFlow.getAllFlowSegments().get(eteFlow.getAllFlowSegments().size()-1).getFlowElement() instanceof FlowSpecification);
	}

	

	private void setNavigationButtonsEnabled(boolean enabled) {
		final Button okBtn = getButton(IDialogConstants.OK_ID);
		if (okBtn != null) {
			getButton(IDialogConstants.OK_ID).setEnabled(enabled);
		}
	}

	private boolean isValid(Flow flow, Element selectedEle, Object object) {
		if (flow instanceof EndToEndFlow) {
			EndToEndFlow eTEFlow = (EndToEndFlow)flow;
			if (selectedEle instanceof ModeFeature && isCompleteAndValid(eTEFlow)) {
				eTEFlow.getInModeOrTransitions().add((ModeFeature)selectedEle);
				return true;
			}

			if ((eTEFlow.getAllFlowSegments().size() == 0)) {
				return validFirstElement(eTEFlow, selectedEle);
			}
			
			Element prevEle = null;
			if (object != null) {
				return true;
			}
			if (eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size() - 1).getFlowElement() instanceof EndToEndFlow) {
				EndToEndFlow tempETEFlow = (EndToEndFlow) eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size() - 1).getFlowElement();
				prevEle = (tempETEFlow).getAllFlowSegments().get((tempETEFlow).getAllFlowSegments().size()-1).getFlowElement();
			} else {
				prevEle = eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size()-1).getFlowElement();
			}

			if (prevEle != null) {
				if ((prevEle instanceof org.osate.aadl2.Connection)
						&& (selectedEle instanceof FlowSpecification)) {
					FlowSpecification segFs = (FlowSpecification)selectedEle;
					if (segFs.getKind() == FlowKind.SINK || segFs.getKind() == FlowKind.PATH) {
						Object ob = segFs.getInEnd().getFeature();
						org.osate.aadl2.Connection prevCon = (org.osate.aadl2.Connection)prevEle;
						if (prevCon.isBidirectional() && !(((Object)prevCon.getSource().getConnectionEnd()).equals(ob) || ((Object)prevCon.getDestination().getConnectionEnd()).equals(ob))) {
							return false;
						} else if (!prevCon.isBidirectional() && !((Object)prevCon.getDestination().getConnectionEnd()).equals(ob)) {
							return false;
						}
					} else {
						return false;
					}

				} else if ((prevEle instanceof FlowSpecification)
						&& (selectedEle instanceof org.osate.aadl2.Connection)) {
					FlowSpecification segFs = (FlowSpecification)prevEle;
					if (segFs.getKind() == FlowKind.SOURCE || segFs.getKind() == FlowKind.PATH) {
						Object prevOb = segFs.getOutEnd().getFeature();
						org.osate.aadl2.Connection segCon = (org.osate.aadl2.Connection)selectedEle;
						if (segCon.isBidirectional() && !(((Object)segCon.getSource().getConnectionEnd()).equals(prevOb) || ((Object)segCon.getDestination().getConnectionEnd()).equals(prevOb))) {
							return false;
						} else if (!segCon.isBidirectional() && !((Object)segCon.getSource().getConnectionEnd()).equals(prevOb)) {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		//TODO: fix title
		newShell.setText(title);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container = (Composite) super
				.createDialogArea(parent);
		final ScrolledComposite flowSegmentScrolled = new ScrolledComposite(
				container, SWT.V_SCROLL);
		final GridData flowSegmentScrolledGridData = new GridData(SWT.FILL,
				SWT.FILL, true, true);
		flowSegmentScrolledGridData.minimumWidth = 250;
		flowSegmentScrolledGridData.minimumHeight = 300;
		flowSegmentScrolledGridData.grabExcessHorizontalSpace = true;
		flowSegmentScrolled.setLayoutData(flowSegmentScrolledGridData);
		flowSegmentScrolled.setLayout(new GridLayout(1, false));

		flowSegmentComposite = new Composite(flowSegmentScrolled, SWT.NONE);
		GridData flowSegmentGridData = new GridData(SWT.FILL, SWT.FILL,
				true, true);
		flowSegmentComposite.setLayoutData(flowSegmentGridData);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
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

		final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM,
				true, false);
		buttonBarData.grabExcessHorizontalSpace = true;
		buttonBarData.grabExcessVerticalSpace = false;
		buttonBar.setLayoutData(buttonBarData);

		buttonBar.setFont(parent.getFont());

		final Label nameLabel = new Label(buttonBar, SWT.NONE);
		nameLabel.setText("Name: ");
		final GridData nameLabelData = new GridData(SWT.LEFT, SWT.CENTER,
				true, true);
		nameLabelData.grabExcessHorizontalSpace = true;
		nameLabelData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		nameLabel.setLayoutData(nameLabelData);

		nameText = new Text(buttonBar, SWT.DEFAULT);
		final GridData nameTextData = new GridData(SWT.LEFT, SWT.CENTER,
				true, true);
		nameTextData.grabExcessHorizontalSpace = true;
		nameTextData.widthHint = 250;
		nameText.setLayoutData(nameTextData);
		nameText.setEditable(true);
		nameText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (namingService.isValidIdentifier(nameText.getText())) {
					flow.setName(nameText.getText());
					updateWidgets((EndToEndFlow) flow);
				} else {
					flow.setName("");
					updateWidgets((EndToEndFlow) flow);
				}
			}
		});

		final Control buttonControl = super.createButtonBar(buttonBar);
		buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				true, false));
		final Button okBtn = getButton(IDialogConstants.OK_ID);
		okBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				flows.add(flow);
			}
		});

		if (okBtn != null) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		}
		return buttonBar;
	}
}
