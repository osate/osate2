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
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
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
	
	/*@Icon
	public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateFlowImplementation.gif");
	*/
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
		final AgeDiagramEditor editor = (AgeDiagramEditor)dtp.getDiagramBehavior().getDiagramContainer();
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
		final TransactionalEditingDomain editingDomain = dtp.getDiagramBehavior().getEditingDomain();
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
					Shape shape = null;
					if (pe instanceof Connection) {
						shape = connectionService.getOwnerShape((Connection)pe);
					} else if (pe instanceof ConnectionDecorator) {
						final ConnectionDecorator cd = ((ConnectionDecorator)pe);
						pe = cd.getConnection();
						shape = connectionService.getOwnerShape((Connection)pe);
					} else if (shape == null && pe instanceof Shape) {
						shape = (Shape)pe;
					}
					
					final Object bo = bor.getBusinessObjectForPictogramElement(pe);
					final Context context = shapeService.getClosestBusinessObjectOfType(shape, Context.class);
					if (pe != null && createFlowImplementationDialog != null && createFlowImplementationDialog.setTargetPictogramElements(bo, context)) {
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
		} else if (bo instanceof ModeFeature) {
			return createFlowImplementationDialog.getMessage();
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
	
		public FlowImplementation getFlow() {
			return flowImpl;
		}
		
		public boolean setTargetPictogramElements(final Object bo, final Context context) {
			final Element selectedEle = (Element)bo;
			if (isValid(selectedEle, context)) {
				if (selectedEle.equals(flowImpl.getSpecification())) {
					return addFlowSegment(selectedEle);
				} else if (selectedEle instanceof FlowSpecification || selectedEle instanceof DataAccess) {
					return addFlowSegment(createOwnedFlowSegment((Element)bo, context));
				} else if (selectedEle instanceof org.osate.aadl2.Connection) {
					return addFlowSegment(createOwnedFlowSegment((Element)bo, context));
				} else if (selectedEle instanceof Subcomponent) {
					return addFlowSegment(createOwnedFlowSegment((Element)bo, null));
				} else {
					return addFlowSegment(selectedEle);
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
			} else if (flowImpl.getKind().equals(FlowKind.PATH)) {
				final Object prevEle = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement();
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

		final List<String> flowSegmentList = new ArrayList<String>();
		final List<String> modeList = new ArrayList<String>();
		private boolean addFlowSegment(final Object object) {
			if (!flowSegmentComposite.isDisposed()) {
				flowSegmentLabel.setEnabled(true);
				final FlowSpecification fs = flowImpl.getSpecification();
				if (fs != null) {
				final FlowEnd flowOutEnd = fs.getOutEnd();
				final FlowEnd flowInEnd = fs.getInEnd();
				if (object != null) {
					//path
					if (fs.getKind().equals(FlowKind.PATH) && flowInEnd != null && flowOutEnd != null) {
						if (flowImpl.getSpecification().equals(object)) {
							flowSegmentList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");
							flowSegmentList.add(getSegmentName(flowOutEnd.getContext(), flowOutEnd.getFeature()));
						} else if (object instanceof FlowSegment) {
							final FlowSegment flowSegment = (FlowSegment)object;
							flowSegmentList.add(flowSegmentList.size()-1, getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) + "  ->");
						}
					}
					//source
					else if (fs.getKind().equals(FlowKind.SOURCE) && flowOutEnd != null) {
						if (flowImpl.getSpecification().equals(object)) {
							flowSegmentList.add(getSegmentName(flowOutEnd.getContext(), flowOutEnd.getFeature()));
						} else if (object instanceof FlowSegment) {
							final FlowSegment flowSegment = (FlowSegment)object;
							flowSegmentList.add(flowImpl.getOwnedFlowSegments().size() == 1 ? 0 : flowSegmentList.size()-1, 
								getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) + "  ->");
						}
					}
					//sink
					else if (fs.getKind().equals(FlowKind.SINK) && flowInEnd != null) {
						if (flowImpl.getSpecification().equals(object)) {
							flowSegmentList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");		
						} else if (object instanceof FlowSegment) {
							final FlowSegment flowSegment = (FlowSegment)object;
							flowSegmentList.add(flowImpl.getOwnedFlowSegments().size() == 1 ?
								getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) :
								"->  " + getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()));
						}
					}
				} else if (object instanceof ModeFeature) {
					final ModeFeature mf = (ModeFeature)object;
					flowImpl.getInModeOrTransitions().add(mf);
					modeList.add(flowImpl.getInModeOrTransitions().size() == 1 ? "  in modes  (" + mf.getName() : ", " + mf.getName());
				}
				setFlowImplementationString();
				updateWidgets();
				return true;
			}
			}
			return false;
		}

		private void setFlowImplementationString() {
			String segmentString = flowImpl.getSpecification().getName() + ":" + "  flow " + flowImpl.getKind();
			final int nameStringLength = segmentString.length();
			for (final String string : flowSegmentList) {
				segmentString = segmentString + "  " + string;
			}
			final String modeString = getModeString();
			flowSegmentLabel.setText(segmentString + modeString);
			flowSegmentLabel.setStyleRange(new StyleRange(nameStringLength - 5 - flowImpl.getKind().toString().length(), 5 + flowImpl.getKind().toString().length(), Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
			if (modeString != "") {
				flowSegmentLabel.setStyleRange(new StyleRange(segmentString.length(), 12, Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
			}
		}
		
		private String getModeString() {
			String modeString = "";
			for (final String string : modeList) {
				modeString = modeString + string;
			}
			return modeString == "" ? modeString : modeString + ")";
		}

		private boolean isValid(final Element selectedEle, final Context context) {
			if (flowImpl != null) {
				if (selectedEle instanceof ModeFeature) {
					return ((ModeFeature)selectedEle).getNamespace().equals(ci);
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
								final FlowEnd flowInEnd = ((FlowSpecification)prevEle).getInEnd();
								return ((flowOutEnd != null && flowOutEnd.getFeature().equals(((org.osate.aadl2.Connection)selectedEle).getSource().getConnectionEnd()))
									|| (flowInEnd != null && flowInEnd.getFeature().equals(((org.osate.aadl2.Connection)selectedEle).getSource().getConnectionEnd())));
							} else if (prevEle instanceof Subcomponent) {
								final ConnectedElement con = ((org.osate.aadl2.Connection)selectedEle).getSource();
								final Feature feature = (Feature)con.getConnectionEnd();
								final Context conContext = con.getContext();
								if (conContext == prevEle && conContext instanceof Subcomponent) {
									//Check if feature in the impl has any connection ends
									for (final org.osate.aadl2.Connection c : ((Subcomponent)conContext).getComponentImplementation().getAllConnections()) {
										if (c.getSource().getConnectionEnd().equals(feature)) {
											return false;
										}
									}
									return true;
								}
							} else {
								return prevEle instanceof DataAccess;
							}
						} else if (selectedEle instanceof FlowSpecification) {
							if (prevEle instanceof org.osate.aadl2.Connection) {
								final FlowEnd flowInEnd = ((FlowSpecification)selectedEle).getInEnd();
								final FlowEnd flowOutEnd = ((FlowSpecification)selectedEle).getOutEnd();
								return ((flowOutEnd != null && flowOutEnd.getFeature().equals(((org.osate.aadl2.Connection)prevEle).getDestination().getConnectionEnd()))
										|| (flowInEnd != null && flowInEnd.getFeature().equals(((org.osate.aadl2.Connection)prevEle).getDestination().getConnectionEnd())));
							}
						} else if (selectedEle instanceof Subcomponent) {
							if (prevEle instanceof org.osate.aadl2.Connection) {
								final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
								if (con.getDestination().getContext() == selectedEle) {
									return true;
								}
							}
						} else if (selectedEle instanceof DataAccess) {
							return prevEle instanceof org.osate.aadl2.Connection && context == null;
						}
					}
				} else if (flowImpl.getOwnedFlowSegments().isEmpty()) {
					if (flowImpl.getKind().equals(FlowKind.SOURCE)) {
						if (selectedEle instanceof FlowSpecification) {
							return context != null && context.getNamespace().equals(ci);
						} else if (selectedEle instanceof DataAccess) {
							return context == null;
						} else if (selectedEle instanceof Subcomponent) {
							return ((Subcomponent)selectedEle).getNamespace().equals(ci);
						}
					} else {
						return selectedEle instanceof org.osate.aadl2.Connection;
					}
				} else if (!flowImpl.getOwnedFlowSegments().isEmpty()) {
					final Object prevEle = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement();
					if (selectedEle instanceof FlowSpecification) {
						return context.getNamespace().equals(ci) && prevEle instanceof org.osate.aadl2.Connection;
					} else if (selectedEle instanceof org.osate.aadl2.Connection) {
						org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)selectedEle;
						return ((con.getDestination().getContext() != null && con.getDestination().getContext().getNamespace().equals(ci)) 
								|| (con.getSource().getContext() != null && con.getSource().getContext().getNamespace().equals(ci)))
								&& prevEle instanceof FlowSpecification || prevEle instanceof Subcomponent || prevEle instanceof DataAccess;
					} else if (selectedEle instanceof DataAccess) {
						return context == null && prevEle instanceof org.osate.aadl2.Connection;
					} else if (selectedEle instanceof Subcomponent) {
						return ((Subcomponent)selectedEle).getNamespace().equals(ci) && prevEle instanceof org.osate.aadl2.Connection;
					}
				}
			} else if (flowImpl == null && ((selectedEle instanceof FlowSpecification) && ((FlowSpecification)selectedEle).getNamespace().equals(ci.getType()))) {
				flowImpl = (FlowImplementation)pkg.getEFactoryInstance().create(pkg.getFlowImplementation());
				final FlowSpecification flowSpec = (FlowSpecification)selectedEle;
				flowImpl.setSpecification(flowSpec);
				flowImpl.setKind(flowSpec.getKind());
				return true;
			}
			return false;
		}

		private FlowSegment createOwnedFlowSegment(final Element flowElement, final Context context) {
			final FlowSegment flowSeg = flowImpl.createOwnedFlowSegment();
			flowSeg.setContext(context);
			flowSeg.setFlowElement((FlowElement)flowElement);
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
			rowData.height = 85;
			rowData.width = 400;
			flowSegmentLabel.setLayoutData(rowData);
			flowSegmentLabel.setLayout(new RowLayout());
			
			return container;
		}
	}
}
