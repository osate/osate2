package org.osate.ge.ui.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Element;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowKind;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.ext.ExtensionConstants;
import org.osate.ge.ext.annotations.Activate;
import org.osate.ge.ext.annotations.CanActivate;
import org.osate.ge.ext.annotations.Deactivate;
import org.osate.ge.ext.annotations.Description;
import org.osate.ge.ext.annotations.Id;
import org.osate.ge.ext.annotations.SelectionChanged;
import org.osate.ge.services.AadlModificationService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ColoringService;
import org.osate.ge.services.ConnectionService;
import org.osate.ge.services.ShapeService;
import org.osate.ge.services.UiService;
import org.osate.ge.services.AadlModificationService.AbstractModifier;
import org.osate.ge.ui.editor.AgeDiagramEditor;

public class CreateFlowImplementationTool {
	@Id
	public final static String ID = "org.osate.ge.ui.tools.CreateFlowImplementationTool";
	
	@Description
	public final static String DESCRIPTION = "Create Flow Implementation";
	
	// TODO
	//@Icon
	//public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateFlowImplementation.gif");
	
	private ColoringService.Coloring coloring = null;
	private ComponentImplementation ci;
	private CreateFlowImplementationDialog createFlowImplementationDialog;
	boolean canActivate = true;

	@CanActivate
	public boolean canActivate(final IDiagramTypeProvider dtp, final BusinessObjectResolutionService bor) {
		return bor.getBusinessObjectForPictogramElement(dtp.getDiagram()) instanceof ComponentImplementation
				&& canActivate;
	}

	@Activate
	public void activate(final AadlModificationService aadlModService,
			final UiService uiService,
			final ColoringService highlightingService,
			final BusinessObjectResolutionService bor,
			final IDiagramTypeProvider dtp) {
		this.coloring = highlightingService.adjustColors();
		final AgeDiagramEditor editor = (AgeDiagramEditor) dtp.getDiagramBehavior().getDiagramContainer();
		editor.getActionRegistry().getAction(CreateFlowImplementationTool.ID).setEnabled(false);
		ci = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(dtp.getDiagram());
		if (ci != null) {
			canActivate = false;
			clearSelection(dtp);
			final Shell dialogShell = new Shell();
			final Rectangle rect = editor.getSite().getShell().getBounds();
			dialogShell.setLocation((rect.x - 150), (rect.y - 100));
			createFlowImplementationDialog = new CreateFlowImplementationDialog(dialogShell);
			if (createFlowImplementationDialog.open() == Dialog.CANCEL) {
				uiService.deactivateActiveTool();
				canActivate = true;
				return;
			}
			
			if (!createFlowImplementationDialog.getFlows().isEmpty()) {
				aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, Object>() {
				@Override
				public Object modify(final Resource resource, final ComponentImplementation ci) {
					for (final FlowImplementation flowImplementation : createFlowImplementationDialog.getFlows()) {
						ci.getOwnedFlowImplementations().add(flowImplementation);
						ci.setNoFlows(false);
					}
					return null;
				}
				});
				
			}
			uiService.deactivateActiveTool();
		}
	}


	@Deactivate
	public void deactivate(final IDiagramTypeProvider dtp) {
		final TransactionalEditingDomain editingDomain = dtp
				.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {
				// Dispose of the coloring object
				if (coloring != null) {
					if (createFlowImplementationDialog != null) {
						createFlowImplementationDialog.close();
					}
					coloring.dispose();
				}
				canActivate = true;
			}
		});
		clearSelection(dtp);
	}

	private void clearSelection(final IDiagramTypeProvider dtp) {
		dtp.getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
		dtp.getDiagramBehavior().refresh();
	}
	
	@SelectionChanged
	public void onSelectionChanged(@Named(ExtensionConstants.SELECTED_PICTOGRAM_ELEMENTS) final PictogramElement[] selectedPes,
			final BusinessObjectResolutionService bor, final IDiagramTypeProvider dtp, final ShapeService shapeService, final ConnectionService connectionService) {
		// Highlight all selected shapes
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {
				for (PictogramElement pe : selectedPes) {
					//System.err.println(pe + " pe");
					Shape shape = null;
					if (pe instanceof Connection) {
						shape = connectionService.getOwnerShape((Connection) pe);
					} else if (pe instanceof ConnectionDecorator) {
						final ConnectionDecorator cd = ((ConnectionDecorator) pe);
						pe = cd.getConnection();
						shape = connectionService.getOwnerShape((Connection) pe);
					} else if (shape == null && pe instanceof Shape) {
						shape = (Shape)pe;
					}
					//System.err.println(shape + " shape");
					final Object bo = bor.getBusinessObjectForPictogramElement(pe);
					final Context context = shapeService.getClosestBusinessObjectOfType(shape, Context.class);
					//System.err.println(bo + " bo");
					//System.err.println(context + " context");
					if (pe != null && createFlowImplementationDialog != null && createFlowImplementationDialog.setTargetPictogramElements(bo, ci.getType(), context)) {
						if (bo.equals(createFlowImplementationDialog.getFlow().getSpecification())) {
							coloring.setForeground(pe, IColorConstant.DARK_ORANGE);
						} else if(bo instanceof ModeFeature) {
							coloring.setForeground(pe, IColorConstant.LIGHT_ORANGE);
						} else {
							coloring.setForeground(pe, IColorConstant.ORANGE);
						}
						createFlowImplementationDialog.setMessage(getMessage(bo));
					}
				}
			}
		});
	}
	
	private String getMessage(final Object bo) {
		final String addModeFeaturesString = "mode feature if neccessary.";
		if (bo instanceof FlowSpecification && ((FlowSpecification)(bo)).getKind().equals(FlowKind.SINK)) {
			return "Select a valid connection or " + addModeFeaturesString;
		} else if (bo instanceof FlowSpecification && ((FlowSpecification)(bo)).getKind().equals(FlowKind.SOURCE)) {
			return "Select a valid subcomponent flow specification or " + addModeFeaturesString;
		} else if (bo instanceof FlowSpecification && ((FlowSpecification)(bo)).getKind().equals(FlowKind.PATH)) {
			return "Select a valid connection or " + addModeFeaturesString;
		} else if (bo instanceof org.osate.aadl2.Connection) {
			return "Select a valid flow specification or " + addModeFeaturesString;
		}
		return "Select a valid element";
	}

	private class CreateFlowImplementationDialog extends TitleAreaDialog {
		Composite flowSegmentComposite;
		StyledText flowSegmentLabel;
		final List<FlowImplementation> flows = new ArrayList<FlowImplementation>();
		final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		FlowImplementation flowImpl = null;

		CreateFlowImplementationDialog(final Shell parentShell) {
			super(parentShell);
			this.setHelpAvailable(false);
			setShellStyle(SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.ON_TOP| SWT.DIALOG_TRIM | SWT.MIN);
		}

		public List<FlowImplementation> getFlows() {
			return Collections.unmodifiableList(flows);
		}
		

 FlowImplementation getFlow() {
			return flowImpl;
		}
		
		public boolean setTargetPictogramElements(final Object bo, final ComponentType ciType, final Context context) {
			final Element selectedEle = (Element)bo;
			if (isValid(selectedEle, ciType)) {
				if (selectedEle instanceof org.osate.aadl2.Connection || selectedEle instanceof FlowSpecification) {
					addFlowSegment(selectedEle, (Context)(selectedEle instanceof org.osate.aadl2.Connection ? null : context));
					return true;
				} else {
					addFlowSegment(selectedEle, null);
					return true;
				}
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

		private void updateWidgets() {
			setNavigationButtonsEnabled(isCompleteAndValid());
		}

		private boolean isCompleteAndValid() {
			if (flowImpl.getOwnedFlowSegments().isEmpty() && flowImpl != null) {
				return true;
			}
			if (flowImpl.getKind().equals(FlowKind.PATH)) {
				Object prevEle = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement();
				if (prevEle instanceof org.osate.aadl2.Connection && ((org.osate.aadl2.Connection)prevEle).getDestination().getConnectionEnd().equals(
						flowImpl.getSpecification().getOutEnd().getFeature())) {
					return true;
				}
			} else if (flowImpl.getKind().equals(FlowKind.SOURCE) || flowImpl.getKind().equals(FlowKind.SINK)) {
				return flowImpl.getOwnedFlowSegments().size() % 2 == 0;
			}
			return false;
		}

		private void setNavigationButtonsEnabled(boolean enabled) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			}
		}

		final List<String> flowSpecificationList = new ArrayList<String>();
		final List<String> modeList = new ArrayList<String>();
		private void addFlowSegment(final Object object, final Context context) {
			if (!flowSegmentComposite.isDisposed()) {
				flowSegmentLabel.setEnabled(true);
				final FlowSpecification fs = flowImpl.getSpecification();
				if (object instanceof FlowSpecification || object instanceof org.osate.aadl2.Connection || object instanceof Subcomponent || object instanceof DataAccess) {
					final FlowEnd flowOutEnd = fs.getOutEnd();
					final FlowEnd flowInEnd = fs.getInEnd();
					//path
					if (fs.getKind().equals(FlowKind.PATH) && flowInEnd != null && flowOutEnd != null) {
						if (flowImpl.getSpecification() == object) {
							flowSpecificationList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");
							flowSpecificationList.add(getSegmentName(flowOutEnd.getContext(), flowOutEnd.getFeature()));
						} else {
							flowImpl.getOwnedFlowSegments().add(createOwnedFlowSegement((Element)object, context));
							flowSpecificationList.add(flowSpecificationList.size() - 1, getSegmentName(context, (NamedElement) object) + "  ->");
						}
					}
					//source
					else if (fs.getKind().equals(FlowKind.SOURCE) && flowOutEnd != null) {
						if (flowImpl.getSpecification() == object) {
							flowSpecificationList.add(getSegmentName(flowOutEnd.getContext(), flowOutEnd.getFeature()));
						} else {
							flowImpl.getOwnedFlowSegments().add(createOwnedFlowSegement((Element) object, context));
							if (flowImpl.getOwnedFlowSegments().size() == 1) {
								flowSpecificationList.add(0, getSegmentName(context, (NamedElement) object) + "  ->");
							} else {
								flowSpecificationList.add(flowSpecificationList.size()-1, getSegmentName(context, (NamedElement)object) + "  ->");
							}
						}
					}
					//sink
					else if (fs.getKind().equals(FlowKind.SINK) && flowInEnd != null) {
						if (flowImpl.getSpecification() == object) {
							flowSpecificationList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");		
						} else {
							flowImpl.getOwnedFlowSegments().add(createOwnedFlowSegement((Element)object, context));
							if (flowImpl.getOwnedFlowSegments().size() == 1) {
								flowSpecificationList.add(getSegmentName(context, (NamedElement)object));
							} else {
								flowSpecificationList.add("->  " + getSegmentName(context, (NamedElement)object));
							}
						}
					}
				} else if (object instanceof ModeFeature) {
					final ModeFeature mf = (ModeFeature)object;
					if (flowImpl.getInModeOrTransitions().size() == 1) {
						modeList.add("  in modes  (" + mf.getName());
					} else {
						modeList.add(", " + mf.getName());
					}
				}
				
				final int specificationStringStart = getSpecificationString();
				final String specificationString = flowSegmentLabel.getText();
				final int modeStringStart = specificationString.length();
				flowSegmentLabel.setText(specificationString + getModeString());
				flowSegmentLabel.setStyleRange(new StyleRange(specificationStringStart - 5 - flowImpl.getKind().toString().length(), 5 + flowImpl.getKind().toString().length(), Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				if (modeList.size() > 0) {
					flowSegmentLabel.setStyleRange(new StyleRange(modeStringStart, 12, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				}
				flowSegmentComposite.pack();
				flowSegmentComposite.layout(true);
				updateWidgets();
			}
		}

		private int getSpecificationString() {
			String segmentString = flowImpl.getSpecification().getName() + ":" + "  flow " + flowImpl.getKind();
			final int length = segmentString.length();
			for (String string : flowSpecificationList) {
				segmentString = segmentString + "  " + string;
			}
			flowSegmentLabel.setText(segmentString);
			return length;
		}
		
		private String getModeString() {
			String modeString = "";
			for (String string : modeList) {
				modeString = modeString + string;
			}
			return modeString == "" ? modeString : modeString + ")";
		}

		private boolean isValid(final Element selectedEle, final ComponentType ciType) {
			if (flowImpl != null) {
				if (selectedEle instanceof ModeFeature) {
					flowImpl.getInModeOrTransitions().add((ModeFeature)selectedEle);
					return true;
				} else if (flowImpl.getKind().equals(FlowKind.PATH)) {
					if (flowImpl.getOwnedFlowSegments().isEmpty() && selectedEle instanceof org.osate.aadl2.Connection) {
						final org.osate.aadl2.Connection con = ((org.osate.aadl2.Connection)selectedEle);
						//Connection source or destination must match specification feature.
						return (con.getSource().getConnectionEnd().equals(flowImpl.getSpecification().getOutEnd().getFeature())
								|| con.getDestination().getConnectionEnd().equals(flowImpl.getSpecification().getOutEnd().getFeature()));
					} else if (!flowImpl.getOwnedFlowSegments().isEmpty()) {
						final Object prevEle = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement();
						if (selectedEle instanceof org.osate.aadl2.Connection) {
							if ((prevEle instanceof FlowSpecification)) {
								//previous element FlowSpecification feature must match Connection source
								final FlowEnd flowOutEnd = ((FlowSpecification)prevEle).getOutEnd();
								return flowOutEnd != null && flowOutEnd.getFeature().equals(((org.osate.aadl2.Connection)selectedEle).getSource().getConnectionEnd());
							} else if (prevEle instanceof Subcomponent) {
								final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection) selectedEle;
								if (con.getSource().getContext() == prevEle) {
									return true;
								}
								return false;
							} else if (prevEle instanceof DataAccess) {
								return true;
							}
						} else if (selectedEle instanceof FlowSpecification) {
							if (prevEle instanceof org.osate.aadl2.Connection) {
								final FlowEnd flowInEnd = ((FlowSpecification)selectedEle).getInEnd();
								return (flowInEnd != null && ((org.osate.aadl2.Connection)prevEle).getDestination().getConnectionEnd().equals(flowInEnd.getFeature()));
							}
						} else if (selectedEle instanceof Subcomponent) {
							if (prevEle instanceof org.osate.aadl2.Connection) {
								final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection) prevEle;
								if (con.getDestination().getContext() == selectedEle) {
									return true;
								}
							}
						} else if (selectedEle instanceof DataAccess) {
							DataAccess da = (DataAccess)selectedEle;
							
							return true;
						}
					}
				} else if (flowImpl.getOwnedFlowSegments().isEmpty()) {
					//System.err.println(selectedEle + " selectedEle");
					return flowImpl.getKind().equals(FlowKind.SOURCE) ? (selectedEle instanceof FlowSpecification && !((FlowSpecification)selectedEle).getNamespace().equals(flowImpl.getSpecification().getNamespace()))
							|| selectedEle instanceof DataAccess :
						selectedEle instanceof org.osate.aadl2.Connection;
				} else if (!flowImpl.getOwnedFlowSegments().isEmpty()) {
					final Object prevEle = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement();
					return  (selectedEle instanceof org.osate.aadl2.Connection && (prevEle instanceof FlowSpecification || prevEle instanceof Subcomponent || prevEle instanceof DataAccess)) || 
							((selectedEle instanceof Subcomponent || selectedEle instanceof DataAccess || ((selectedEle instanceof FlowSpecification &&
							!((FlowSpecification)selectedEle).getNamespace().equals(flowImpl.getSpecification().getNamespace()))) && (prevEle instanceof org.osate.aadl2.Connection)));
				}
			} else if (flowImpl == null && ((selectedEle instanceof FlowSpecification) && ((FlowSpecification)selectedEle).getNamespace().equals(ciType))) {
				flowImpl = (FlowImplementation)pkg.getEFactoryInstance().create(pkg.getFlowImplementation());
				final FlowSpecification flowSpec = (FlowSpecification)selectedEle;
				flowImpl.setSpecification(flowSpec);
				flowImpl.setKind(flowSpec.getKind());
				return true;
			}
			return false;
		}

		private FlowSegment createOwnedFlowSegement(final Element flowElement, final Context context) {
			final FlowSegment flowSeg = flowImpl.createOwnedFlowSegment();
			flowSeg.setContext(context);
			flowSeg.setFlowElement((FlowElement) flowElement);
			return flowSeg;
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Create Flow Implementation");
			newShell.setSize(450, 250);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select Elements");
			setMessage("Select a valid flow specification.");
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				okBtn.setEnabled(false);
				okBtn.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						flows.add(flowImpl);
					}
				});
			}
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite) super.createDialogArea(parent);
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
			rowData.height = 85;
			rowData.width = 400;
			flowSegmentLabel.setLayoutData(rowData);
			flowSegmentLabel.setLayout(new RowLayout());
			
			return container;
		}
	}
}
