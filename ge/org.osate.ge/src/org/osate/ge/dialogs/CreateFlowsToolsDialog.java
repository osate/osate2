package org.osate.ge.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
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
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.NamingService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.ui.tools.CreateEndToEndFlowTool;

public class CreateFlowsToolsDialog extends TitleAreaDialog {
	BusinessObjectResolutionService bor;
	ConnectionService connectionService;
	private final List<FlowSegmentInfo> potentialFlowSegments = new ArrayList<FlowSegmentInfo>();
	List<Flow> flows = new ArrayList<Flow>();
	Composite flowSegmentComposite;
	GridData gridData;
	IFeatureProvider fp;
	Text nameText = null;
	NamingService namingService;
	final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();

	Flow flow;
	PictogramElement deletedPE = null;

	public CreateFlowsToolsDialog(Shell parentShell,
			BusinessObjectResolutionService bor,
			ConnectionService connectionService, ShapeService shapeService,
			IFeatureProvider fp, NamingService namingService, String ID) {
		super(parentShell);
		System.err.println(ID + " ID");
		this.setHelpAvailable(false);
		this.bor = bor;
		this.connectionService = connectionService;
		this.fp = fp;
		this.namingService = namingService;
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

	public List<FlowSegmentInfo> getFlowSegmentInfos() {
		return potentialFlowSegments;
	}

	public boolean setTargetPictogramElements(PictogramElement pe) {
		if (flow instanceof EndToEndFlow) {
			EndToEndFlow newFlow = (EndToEndFlow) flow;
			if (pe instanceof Connection) {
				Element selectedEle = (Element) bor.getBusinessObjectForPictogramElement(pe);
				Context context = bor.getBusinessObjectForPictogramElement(connectionService.getOwnerShape((Connection) pe)) instanceof Subcomponent ? (Context) bor
						.getBusinessObjectForPictogramElement(connectionService
								.getOwnerShape((Connection) pe)) : null;
						//if (selectedEle instanceof FlowSpecification|| selectedEle instanceof org.osate.aadl2.Connection) {
						if (newFlow.getAllFlowSegments().size() == 0) {
							if ((selectedEle instanceof FlowSpecification)) {
								if (((FlowSpecification)selectedEle).getKind() != FlowKind.SOURCE) {
									return false;
								}
							} else {
								return false;
							}
						}
						/*if (newFlow.getAllFlowSegments().size() == 0 && !validFirstElement(newFlow, selectedEle)) {
								return false;
						}*/
						FlowSegmentInfo newflowSegmentInfo = new FlowSegmentInfo(context, (NamedElement) selectedEle);
						for (FlowSegmentInfo flowSegmentInfo : potentialFlowSegments) {
							if (flowSegmentInfo.equals(newflowSegmentInfo)) {
								return false;
							}
						}
						
						System.err.println(selectedEle + " before");
						if (isValid(newFlow, selectedEle)) {
							addFlowSegment(newFlow, createEndToEndFlowSegments(selectedEle, context, newFlow));
							potentialFlowSegments.add(newflowSegmentInfo);
							return true;
						}
			}
		} else if(flow instanceof FlowImplementation) {
		
		}
		return false;
	}

	private boolean validFirstElement(EndToEndFlow newFlow, Element selectedEle) {
		if ((selectedEle instanceof FlowSpecification) && (((FlowSpecification)selectedEle).getKind() == FlowKind.SOURCE)) {
			return true;
		}
		return false;
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

	private void updateFlowPane(final Flow flow) {
		if (flow instanceof EndToEndFlow) {
			EndToEndFlow eTEFlow = (EndToEndFlow)flow;
			for (Control child : flowSegmentComposite.getChildren()) {
				if (!child.isDisposed()) {
					child.dispose();
				}
			}

			for (final EndToEndFlowSegment eTEFlowSegment : eTEFlow
					.getAllFlowSegments()) {
				addFlowSegment(eTEFlow, eTEFlowSegment);
			}
		}
		flowSegmentComposite.pack();
		flowSegmentComposite.layout(true);
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
			final EndToEndFlowSegment eteFlowSegment) {
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
			final Label flowSegmentLabel = new Label(flowSegmentComposite,
					SWT.NONE);
			gridData = new GridData();
			gridData.widthHint = 200;
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

			updateWidgets(eTEFlow);
		}
		flowSegmentComposite.pack();
		flowSegmentComposite.layout(true);
	}

	private void updateWidgets(Flow flow) {
	/*	for (FlowSegmentInfo fsinfo : potentialFlowSegments) {
			isValid(eteFlow, fsinfo.flowElement);
		}*/
		//if (potentialFlowSegments.size() > 0) {
		if (flow instanceof EndToEndFlow) {
		EndToEndFlow eteFlow = (EndToEndFlow) flow;	
		
		eteFlow.getName();
		System.err.println(eteFlow.getAllFlowSegments().size() + " size");
		if (eteFlow.getAllFlowSegments().size() < 3
				|| (eteFlow.getAllFlowSegments().size() % 2) != 1) {
			setNavigationButtonsEnabled(false);
		} else {
			setNavigationButtonsEnabled(true);
		}
		
		
			/*boolean result = true;
			for (int i = 0; result && i < potentialFlowSegments.size(); i++) {
				result = isValid(eteFlow, potentialFlowSegments.get(i).flowElement);
			}*/
			//System.err.println(result + " result");
			//setNavigationButtonsEnabled(result && eteFlow != null && !eteFlow.getName().isEmpty());
		//}
		
		
		}
		/*setNavigationButtonsEnabled((eteFlow == null || eteFlow.getName().isEmpty()) ? false
				: isCompleteAndValid(eteFlow));*/
	}

	private boolean isCompleteAndValid(Flow eteFlow) {
		if (flow instanceof EndToEndFlow) {
			EndToEndFlow eTEFlow = (EndToEndFlow)flow;
			// TODO: More rules for validation, Context? flowspec & connection have same source/feature
			// TODO: Cleanup. Is it possible to have 1 function that is used for
			// all the checks?
			// Perform a basic validity check. Ensure that the number of
			// elements is reasonable, that there aren't any null segments, and
			// that connections are not adjacent in the segment list
			// Check for minimum number of flow segments
			
			if (eTEFlow.getAllFlowSegments().size() < 3
					|| (eTEFlow.getAllFlowSegments().size() % 2) != 1) {
				return false;
			}
		}
		return true;
	}

			/*EndToEndFlowSegment prevSegment = null;
			for (final EndToEndFlowSegment seg : eTEFlow.getAllFlowSegments()) {
				if (seg.getFlowElement() == null) {
					return false;
				}

				if (prevSegment == null) {
					// start_subcomponent_flow_or_etef_identifier
					if (seg.getFlowElement() instanceof Connection) {
						return false;
					}
				} else {
					// Ensure that two connections or two flow paths are not
					// connected to one another
					if ((prevSegment.getFlowElement() instanceof org.osate.aadl2.Connection) == (seg
							.getFlowElement() instanceof org.osate.aadl2.Connection)) {
						return false;
					}

					//TODO: SOURCE: OUTEND.getfeature
					//		SINK: INEND.getfeature
					if (seg.getFlowElement() instanceof FlowSpecification && prevSegment.getFlowElement() instanceof org.osate.aadl2.Connection) {
						FlowSpecification segFs = (FlowSpecification)seg.getFlowElement();
						if (segFs.getKind() == FlowKind.SINK || segFs.getKind() == FlowKind.PATH) {
							Object ob = segFs.getInEnd().getFeature();
							org.osate.aadl2.Connection prevCon = (org.osate.aadl2.Connection)prevSegment.getFlowElement();
							if (prevCon.isBidirectional() && !(((Object)prevCon.getSource().getConnectionEnd()).equals(ob) || ((Object)prevCon.getDestination().getConnectionEnd()).equals(ob))) {
								System.err.println("AAA");
								return false;
							} else if (!prevCon.isBidirectional() && !((Object)prevCon.getDestination().getConnectionEnd()).equals(ob)) {
								System.err.println("BBB");
								return false;
							}
						}
					}

					if (seg.getFlowElement() instanceof org.osate.aadl2.Connection && prevSegment.getFlowElement() instanceof FlowSpecification) {
						FlowSpecification segFs = (FlowSpecification)prevSegment.getFlowElement();
						if (segFs.getKind() == FlowKind.SOURCE || segFs.getKind() == FlowKind.PATH) {
							Object prevOb = segFs.getOutEnd().getFeature();
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)seg.getFlowElement();
							if (con.isBidirectional() && !(((Object)con.getSource().getConnectionEnd()).equals(prevOb) || ((Object)con.getDestination().getConnectionEnd()).equals(prevOb))) {
								System.err.println("CCC");
								return false;
							} else if (!con.isBidirectional() && !((Object)con.getSource().getConnectionEnd()).equals(prevOb)) {
								System.err.println("DDD");
								return false;
							}
						} else {
							return false;
						}
					}

				}
				prevSegment = seg;
			}
		}
		return true;
	}*/

	private void setNavigationButtonsEnabled(boolean enabled) {
		final Button okBtn = getButton(IDialogConstants.OK_ID);
		if (okBtn != null) {
			getButton(IDialogConstants.OK_ID).setEnabled(enabled);
		}
	}

	private boolean isValid(Flow flow, Element selectedEle) {
		System.err.println(selectedEle + " After");
		if (flow instanceof EndToEndFlow) {
			EndToEndFlow eTEFlow = (EndToEndFlow)flow;

			// TODO: More rules for validation, Context? flowspec & connection have same source/feature
			// TODO: Cleanup. Is it possible to have 1 function that is used for
			// all the checks?
			// Perform a basic validity check. Ensure that the number of
			// elements is reasonable, that there aren't any null segments, and
			// that connections are not adjacent in the segment list
			// Check for minimum number of flow segments
			
			if ((selectedEle != null && eTEFlow.getAllFlowSegments().size() == 0 && validFirstElement(eTEFlow, selectedEle))) {
				System.err.println();
				System.err.println("FIRST ELE");
				return true;
			}
		/*	if (eTEFlow.getAllFlowSegments().size() < 3
					|| (eTEFlow.getAllFlowSegments().size() % 2) != 1) {
				return false;
			}*/
			Element prevEle = null;
			for (EndToEndFlowSegment ele : eTEFlow.getAllFlowSegments()) {
				if (ele.getFlowElement() == selectedEle && eTEFlow.getAllFlowSegments().indexOf(ele) == 0) {
					return true;
					//prevEle = eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().indexOf(ele)-1 > 0 ? eTEFlow.getAllFlowSegments().indexOf(ele)-1 : 0).getFlowElement();
				} else {
					System.err.println("else");
					prevEle = eTEFlow.getAllFlowSegments().get(eTEFlow.getAllFlowSegments().size()-1).getFlowElement();
				}
			} 
			System.err.println(prevEle + " prev eleAAA");
			if ((prevEle instanceof org.osate.aadl2.Connection)
					&& (selectedEle instanceof FlowSpecification)) {
				FlowSpecification segFs = (FlowSpecification)selectedEle;
				if (segFs.getKind() == FlowKind.SINK || segFs.getKind() == FlowKind.PATH) {
					Object ob = segFs.getInEnd().getFeature();
					org.osate.aadl2.Connection prevCon = (org.osate.aadl2.Connection)prevEle;
					if (prevCon.isBidirectional() && !(((Object)prevCon.getSource().getConnectionEnd()).equals(ob) || ((Object)prevCon.getDestination().getConnectionEnd()).equals(ob))) {
						System.err.println("AAA");
						return false;
					} else if (!prevCon.isBidirectional() && !((Object)prevCon.getDestination().getConnectionEnd()).equals(ob)) {
						System.err.println("BBB");
						return false;
					}
				}

			} else if ((prevEle instanceof FlowSpecification)
					&& (selectedEle instanceof org.osate.aadl2.Connection)) {
				System.err.println("here");
				FlowSpecification segFs = (FlowSpecification)prevEle;
				if (segFs.getKind() == FlowKind.SOURCE || segFs.getKind() == FlowKind.PATH) {
					System.err.println("ZZZ");
					Object prevOb = segFs.getOutEnd().getFeature();
					org.osate.aadl2.Connection segCon = (org.osate.aadl2.Connection)selectedEle;
					if (segCon.isBidirectional() && !(((Object)segCon.getSource().getConnectionEnd()).equals(prevOb) || ((Object)segCon.getDestination().getConnectionEnd()).equals(prevOb))) {
						System.err.println("CCC");
						return false;
					} else if (!segCon.isBidirectional() && !((Object)segCon.getSource().getConnectionEnd()).equals(prevOb)) {
						System.err.println("DDD");
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

			/*EndToEndFlowSegment prevSegment = null;
			for (final EndToEndFlowSegment seg : eTEFlow.getAllFlowSegments()) {
				if (seg.getFlowElement() == null) {
					return false;
				}

				if (prevSegment == null) {
					// start_subcomponent_flow_or_etef_identifier
					if (seg.getFlowElement() instanceof Connection) {
						return false;
					}
				} else {
					// Ensure that two connections or two flow paths are not
					// connected to one another
					if ((prevSegment.getFlowElement() instanceof org.osate.aadl2.Connection) == (seg
							.getFlowElement() instanceof org.osate.aadl2.Connection)) {
						return false;
					}

					//TODO: SOURCE: OUTEND.getfeature
					//		SINK: INEND.getfeature
					if (seg.getFlowElement() instanceof FlowSpecification && prevSegment.getFlowElement() instanceof org.osate.aadl2.Connection) {
						FlowSpecification segFs = (FlowSpecification)seg.getFlowElement();
						if (segFs.getKind() == FlowKind.SINK || segFs.getKind() == FlowKind.PATH) {
							Object ob = segFs.getInEnd().getFeature();
							org.osate.aadl2.Connection prevCon = (org.osate.aadl2.Connection)prevSegment.getFlowElement();
							if (prevCon.isBidirectional() && !(((Object)prevCon.getSource().getConnectionEnd()).equals(ob) || ((Object)prevCon.getDestination().getConnectionEnd()).equals(ob))) {
								System.err.println("AAA");
								return false;
							} else if (!prevCon.isBidirectional() && !((Object)prevCon.getDestination().getConnectionEnd()).equals(ob)) {
								System.err.println("BBB");
								return false;
							}
						}
					}

					if (seg.getFlowElement() instanceof org.osate.aadl2.Connection && prevSegment.getFlowElement() instanceof FlowSpecification) {
						FlowSpecification segFs = (FlowSpecification)prevSegment.getFlowElement();
						if (segFs.getKind() == FlowKind.SOURCE || segFs.getKind() == FlowKind.PATH) {
							Object prevOb = segFs.getOutEnd().getFeature();
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)seg.getFlowElement();
							if (con.isBidirectional() && !(((Object)con.getSource().getConnectionEnd()).equals(prevOb) || ((Object)con.getDestination().getConnectionEnd()).equals(prevOb))) {
								System.err.println("CCC");
								return false;
							} else if (!con.isBidirectional() && !((Object)con.getSource().getConnectionEnd()).equals(prevOb)) {
								System.err.println("DDD");
								return false;
							}
						} else {
							return false;
						}
					}

				}

				prevSegment = seg;
			}


		} else if(flow instanceof FlowImplementation) {
			System.err.println("ZZZZZZ");
			final FlowImplementation fi = (FlowImplementation)flow;
			if(fi.getKind() == FlowKind.SOURCE) {
				//{ subcomponent_flow_identifier -> connection_identifier -> }*
				FlowSegment prevSegment = null;				
				if((fi.getOwnedFlowSegments().size() % 2) != 0) {
					return false;
				}

				for(final FlowSegment seg : fi.getOwnedFlowSegments()) {
					if(seg.getFlowElement() == null) {
						return false;
					}

					if(prevSegment == null) {
						if(seg.getFlowElement() instanceof Connection) {
							return false;
						}
					} else if((prevSegment.getFlowElement() instanceof Connection) == (seg.getFlowElement() instanceof Connection)) { 
						// Ensure that two connections or two flow paths are not connected to one another
						return false;
					}

					prevSegment = seg;
				}
			} else if(fi.getKind() == FlowKind.SINK) {
				//{ -> connection_identifier -> subcomponent_flow_identifier }*
				FlowSegment prevSegment = null;				
				if((fi.getOwnedFlowSegments().size() % 2) != 0) {
					return false;
				}

				for(final FlowSegment seg : fi.getOwnedFlowSegments()) {
					if(seg.getFlowElement() == null) {
						return false;
					}

					if(prevSegment == null) {
						if(!(seg.getFlowElement() instanceof Connection)) {
							return false;
						}
					} else if((prevSegment.getFlowElement() instanceof Connection) == (seg.getFlowElement() instanceof Connection)) {
						// Ensure that two connections or two flow paths are not connected to one another
						return false;
					}

					prevSegment = seg;
				}
			} else if(fi.getKind() == FlowKind.PATH) {
				//	[ { -> connection_identifier -> subcomponent_flow_identifier }+
				//  -> connection_identifier ]
				FlowSegment prevSegment = null;				
				if((fi.getOwnedFlowSegments().size() % 2) != 1) {
					return false;
				}

				for(final FlowSegment seg : fi.getOwnedFlowSegments()) {
					if(seg.getFlowElement() == null) {
						return false;
					}

					if(prevSegment == null) {
						if(!(seg.getFlowElement() instanceof Connection)) {
							return false;
						}
					} else if((prevSegment.getFlowElement() instanceof Connection) == (seg.getFlowElement() instanceof Connection)) {
						// Ensure that two connections or two flow paths are not connected to one another
						return false;
					}

					prevSegment = seg;
				}
			} else {
				return false;
			}
		}*/


	@Override
	protected void configureShell(final Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Edit Flows");
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
					System.err.println(flow.getName());
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

class FlowSegmentInfo {
	public final Context context;
	public final NamedElement flowElement;

	public FlowSegmentInfo(final Context context,
			final NamedElement flowElement) {
		this.context = context;
		this.flowElement = flowElement;
	}


	public int hashCode() {
		return (context == null ? 0 : context.hashCode())
				+ (flowElement == null ? 0 : flowElement.hashCode());
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj == this)
			return true;

		if (!(obj instanceof FlowSegmentInfo))
			return false;

		final FlowSegmentInfo rhs = (FlowSegmentInfo) obj;
		return ((context == null && rhs.context == null) || (context != null && context
				.equals(rhs.context)))
				&& ((flowElement == null && rhs.flowElement == null) || (flowElement != null && flowElement
				.equals(rhs.flowElement)));
	}

}
