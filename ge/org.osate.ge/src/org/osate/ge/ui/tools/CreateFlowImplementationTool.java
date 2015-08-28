package org.osate.ge.ui.tools;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import org.osate.aadl2.ConnectionEnd;
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
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.diagrams.common.AadlElementWrapper;
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
	private IFeatureProvider fp;
	private List<PictogramElement> previouslySelectedPes = new ArrayList<PictogramElement>();
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
			final IDiagramTypeProvider dtp, final IFeatureProvider fp) {
		this.coloring = highlightingService.adjustColors();
		this.fp = fp;
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
			IFeatureProvider fp, final BusinessObjectResolutionService bor, final IDiagramTypeProvider dtp, final ShapeService shapeService, final ConnectionService connectionService) {
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
					if (createFlowImplementationDialog != null) {
						if(createFlowImplementationDialog.getRemovedFlowSegment() != null) {
							coloring.setForeground(createFlowImplementationDialog.getRemovedFlowSegment(), Color.BLACK);
							createFlowImplementationDialog.setRemovedFlowSegment(null);
							return;
						}
						if (pe != null && createFlowImplementationDialog.canAddSelectedElement(bo, context)) {
							if (bo.equals(createFlowImplementationDialog.getFlow().getSpecification())) {
								coloring.setForeground(pe, Color.ORANGE.darker());
							} else if(bo instanceof ModeFeature) {
								coloring.setForeground(pe, Color.ORANGE.brighter());
							} else {
								coloring.setForeground(pe, Color.ORANGE);
							}
							previouslySelectedPes.add(pe);
							createFlowImplementationDialog.setMessage(getMessage(bo));
						}
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
		private Composite flowSegmentComposite;
		private StyledText flowSegmentLabel;
		final private List<FlowImplementation> flows = new ArrayList<FlowImplementation>();
		final private Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private FlowImplementation flowImpl = null;
		private PictogramElement removedPictogramElement;
		
		CreateFlowImplementationDialog(final Shell parentShell) {
			super(parentShell);
			this.setHelpAvailable(false);
			setShellStyle(SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.ON_TOP| SWT.DIALOG_TRIM | SWT.MIN);
		}

		public void setRemovedFlowSegment(final PictogramElement setValue) {
			removedPictogramElement = setValue;
			previouslySelectedPes.remove(setValue);
		}

		public PictogramElement getRemovedFlowSegment() {
			return removedPictogramElement;
		}

		public List<FlowImplementation> getFlows() {
			return Collections.unmodifiableList(flows);
		}

		public FlowImplementation getFlow() {
			return flowImpl;
		}

		public boolean canAddSelectedElement(final Object bo, final Context context) {
			final Element selectedEle = (Element)bo;
			if (isValid((Element)getRefinedElement(selectedEle), context)) {
				if (selectedEle.equals(flowImpl.getSpecification()) && context == null) {
					return addFlowSegment(selectedEle);
				} else if (selectedEle instanceof FlowSpecification || selectedEle instanceof DataAccess) {
					return addFlowSegment(createOwnedFlowSegment((Element)bo, context));
				} else if (selectedEle instanceof Subcomponent || selectedEle instanceof org.osate.aadl2.Connection) {
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
			if (flowImpl != null && flowImpl.getOwnedFlowSegments().isEmpty()) {
				return true;
			} else if (flowImpl.getKind().equals(FlowKind.PATH)) {
				final Object prevEle = getRefinedElement(getPreviousSegmentElement());
				if (prevEle instanceof org.osate.aadl2.Connection) {
					final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
					Feature feature = flowImpl.getSpecification().getOutEnd().getFeature();
					if (con.isBidirectional()) {
						return con.getDestination().getConnectionEnd() == feature
								|| con.getSource().getConnectionEnd() == feature;
					} else {
						return con.getDestination().getConnectionEnd() == feature;
					}
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
					if (!(object instanceof ModeFeature)) {
						//path
						if (fs.getKind().equals(FlowKind.PATH) && flowInEnd != null && flowOutEnd != null) {
							if (flowImpl.getSpecification() == (object)) {
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
								flowSegmentList.add(flowImpl.getOwnedFlowSegments().indexOf(flowSegment) == 0 ? 0 : flowSegmentList.size()-1,
										getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) + "  ->");
							}
						}
						//sink
						else if (fs.getKind().equals(FlowKind.SINK) && flowInEnd != null) {
							if (flowImpl.getSpecification().equals(object)) {
								flowSegmentList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");		
							} else if (object instanceof FlowSegment) {
								final FlowSegment flowSegment = (FlowSegment)object;
								flowSegmentList.add(flowImpl.getOwnedFlowSegments().indexOf(flowSegment) == 0 ?
										getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) :
											"->  " + getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()));
							}
						}
					} else {
						final ModeFeature mf = (ModeFeature)object;
						flowImpl.getInModeOrTransitions().add(mf);
						modeList.add(flowImpl.getInModeOrTransitions().indexOf(mf) == 0 ? "  in modes  (" + mf.getName() : ", " + mf.getName());
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
			final Object prevEle = getRefinedElement(getPreviousSegmentElement());
				final FlowSpecification sourceFlowSpec = flowImpl.getSpecification();
				if (selectedEle instanceof ModeFeature) {
					return context == null;
				} else if (sourceFlowSpec.getKind().equals(FlowKind.PATH)) {
					if (flowImpl.getOwnedFlowSegments().isEmpty()) {
						if (selectedEle instanceof org.osate.aadl2.Connection && context == null) {
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)(getRefinedElement(selectedEle));
							FlowEnd inFlowEnd = sourceFlowSpec.getInEnd();
							FlowEnd outFlowEnd = sourceFlowSpec.getOutEnd();
							if (con.isBidirectional()) {
								if ((inFlowEnd.getFeature() == con.getDestination().getConnectionEnd() && con.getDestination().getContext() == null)
										|| (inFlowEnd.getFeature() == con.getSource().getConnectionEnd() && con.getSource().getContext() == null)
										|| (outFlowEnd.getFeature() == con.getDestination().getConnectionEnd() && con.getDestination().getContext() == null)
										|| (outFlowEnd.getFeature() == con.getSource().getConnectionEnd() && con.getSource().getContext() == null)) {
									return true;
								}
							} else {
								if ((inFlowEnd.getFeature() == con.getSource().getConnectionEnd()
										|| outFlowEnd.getFeature() == con.getDestination().getConnectionEnd()) && con.getSource().getContext() == null) {
									return true;
								}
							}
						}
					} else {
						if (selectedEle instanceof org.osate.aadl2.Connection) {
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)selectedEle;
							if (prevEle instanceof FlowSpecification) {
								FlowSpecification fs = (FlowSpecification)prevEle;
								if (checkSubcomponentOwner((Context)getRefinedElement(context)) || context == null) {
									FlowEnd flowEnd = null;
									if (fs.getKind() == FlowKind.SINK) {
										flowEnd = fs.getInEnd();
									} else {
										flowEnd = fs.getOutEnd();
									}
									
									ConnectionEnd destCE = con.getDestination().getConnectionEnd();
									ConnectionEnd srcCE = con.getSource().getConnectionEnd();

									if (con.isBidirectional()) {
										if ((flowEnd.getFeature() == destCE
												|| flowEnd.getFeature() == srcCE)
												&& (sourceFlowSpec.getOutEnd().getFeature() == destCE
												|| sourceFlowSpec.getOutEnd().getFeature() == srcCE)) {
											return true;
										}
									} else {
										if (flowEnd.getFeature() == srcCE && sourceFlowSpec.getOutEnd().getFeature() == destCE) {
											return true;
										} 
									}
									return checkValidConnection(fs, con, context);
								}
							} else if (prevEle instanceof Subcomponent) {
								final Context subContext = (Context)getRefinedElement(context);
								if (con.getDestination().getContext() != null && con.getSource().getContext() != null) {
									if (con.isBidirectional()) {
										if (getRefinedElement(con.getDestination().getContext()) == subContext
												|| getRefinedElement(con.getSource().getContext()) == subContext) {
											return true;
										}
									} else {
										if (getRefinedElement(con.getSource().getContext()) == subContext) {
											return true;
										}
									}
								} return false;
							} else {
								return prevEle instanceof DataAccess;
							}
						} else if (prevEle instanceof org.osate.aadl2.Connection) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
							if (selectedEle instanceof FlowSpecification) {
								if (context != null) {
									return con.getSource().getConnectionEnd() != sourceFlowSpec.getOutEnd().getFeature()
											&& con.getDestination().getConnectionEnd() != sourceFlowSpec.getOutEnd().getFeature();
								}
							} else if (selectedEle instanceof Subcomponent) {
								final Context subContext = (Context)getRefinedElement(context);
								return (getRefinedElement(con.getSource().getContext()) == subContext
										|| getRefinedElement(con.getDestination().getContext()) == subContext)
										&& con.getSource().getConnectionEnd() != sourceFlowSpec.getOutEnd().getFeature()
										&& con.getDestination().getConnectionEnd() != sourceFlowSpec.getOutEnd().getFeature();
							} else if (selectedEle instanceof FlowSpecification) {
								checkValidConnection((FlowSpecification)selectedEle, con, context);
							} else if (selectedEle instanceof DataAccess) {
								return prevEle instanceof org.osate.aadl2.Connection && context == null;
							}
						}
					}
				} else if (sourceFlowSpec.getKind() == FlowKind.SOURCE) {
					if (flowImpl.getOwnedFlowSegments().isEmpty()) {
						if (selectedEle instanceof FlowSpecification) {
							return context != null && context.getNamespace().equals(ci);
						} else if (selectedEle instanceof DataAccess) {
							return context == null;
						} else if (selectedEle instanceof Subcomponent) {
							return checkSubcomponentOwner((Context)getRefinedElement(selectedEle));
						}
					} else {
						if (selectedEle instanceof FlowSpecification) {
							return context != null && context.getNamespace() == ci && prevEle instanceof org.osate.aadl2.Connection;
						} else if (selectedEle instanceof org.osate.aadl2.Connection) {
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)(getRefinedElement(selectedEle));
							if (prevEle instanceof FlowSpecification) {						
								FlowSpecification fs = ((FlowSpecification)prevEle);
								FlowEnd flowEndTest = fs.getKind() == FlowKind.SINK ? fs.getInEnd() : fs.getOutEnd();
								if (checkSubcomponentOwner((Context)getRefinedElement(context)) || context == null) {
										if (con.isBidirectional()) {
											if ((sourceFlowSpec.getOutEnd().getFeature() == con.getDestination().getConnectionEnd()
													|| sourceFlowSpec.getOutEnd().getFeature() == con.getSource().getConnectionEnd())
													&& (flowEndTest.getFeature() == con.getDestination().getConnectionEnd()
													|| flowEndTest.getFeature() == con.getSource().getConnectionEnd())) {
												return true;
											}
										} else {
											if (sourceFlowSpec.getOutEnd().getFeature() == con.getDestination().getConnectionEnd()
													&& flowEndTest.getFeature() == con.getSource().getConnectionEnd()) {
												return true;
											}
										}
									return checkValidConnection(fs, con, context);
								}
							} else if (prevEle instanceof Subcomponent) {
								return context == null;
							} else if (prevEle instanceof DataAccess) {
								return true;
							}
						} else if (selectedEle instanceof DataAccess) {
							return context == null && prevEle instanceof org.osate.aadl2.Connection;
						} else if (selectedEle instanceof Subcomponent) {
							if (prevEle instanceof org.osate.aadl2.Connection) {
								final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
								final Context subContext = (Context)getRefinedElement(context);
								return (getRefinedElement(con.getSource().getContext()) == subContext
									|| getRefinedElement(con.getDestination().getContext()) == subContext);
							}
						}
					} 
				} else if (sourceFlowSpec.getKind() == FlowKind.SINK) {
					if (flowImpl.getOwnedFlowSegments().isEmpty()) {
						if(context == null && selectedEle instanceof org.osate.aadl2.Connection) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)selectedEle;
							if (con.isBidirectional()) {
								if (sourceFlowSpec.getInEnd().getFeature() == con.getDestination().getConnectionEnd()
									|| sourceFlowSpec.getInEnd().getFeature() == con.getSource().getConnectionEnd()) {
									return true;
								}
							} else {
								if (sourceFlowSpec.getInEnd().getFeature() == con.getSource().getConnectionEnd()) {
									return true;
								}
							}
						}
					} else {
						if (context != null && selectedEle instanceof FlowSpecification && prevEle instanceof org.osate.aadl2.Connection
							&& checkSubcomponentOwner((Context)getRefinedElement(context))) {
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)getRefinedElement(prevEle);
							FlowSpecification fs = ((FlowSpecification)selectedEle);
							FlowEnd flowEnd = fs.getKind() == FlowKind.SINK ? fs.getInEnd() : fs.getOutEnd();
							if (fs.getKind() == FlowKind.PATH) {
								FlowEnd flowEnd2 = fs.getInEnd();
								return con.getDestination().getConnectionEnd() == flowEnd.getFeature() ||
										con.getSource().getConnectionEnd() == flowEnd.getFeature() ||
										con.getDestination().getConnectionEnd() == flowEnd2.getFeature() ||
										con.getSource().getConnectionEnd() == flowEnd2.getFeature();
							} else if (con.isBidirectional()) {
								return con.getSource().getConnectionEnd() == flowEnd.getFeature() || con.getDestination().getConnectionEnd() == flowEnd.getFeature();
							} else {
								return con.getDestination().getConnectionEnd() == flowEnd.getFeature();
							}
						} else if (selectedEle instanceof org.osate.aadl2.Connection) {
							org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)(getRefinedElement(selectedEle));
							if (prevEle instanceof FlowSpecification) {
								FlowSpecification fs = ((FlowSpecification)prevEle);
								FlowEnd flowEndTest = fs.getKind() == FlowKind.SINK ? fs.getInEnd() : fs.getOutEnd();
								if (checkSubcomponentOwner((Context)getRefinedElement(context)) || context == null) {
										if (con.isBidirectional()) {
											if ((sourceFlowSpec.getInEnd().getFeature() == con.getDestination().getConnectionEnd()
													|| sourceFlowSpec.getInEnd().getFeature() == con.getSource().getConnectionEnd())
													&& (flowEndTest.getFeature() == con.getDestination().getConnectionEnd()
													|| flowEndTest.getFeature() == con.getSource().getConnectionEnd())) {
												return true;
											}
										} else {
											if (sourceFlowSpec.getInEnd().getFeature() == con.getDestination().getConnectionEnd()
													&& flowEndTest.getFeature() == con.getSource().getConnectionEnd()) {
												return true;
											}
										}
									return checkValidConnection(fs, con, context);
								}		
							} else if (prevEle instanceof Subcomponent) {
								final Context subContext = (Context)getRefinedElement(prevEle);
								if (con.isBidirectional()) {
									if ((con.getSource().getContext() == subContext && con.getDestination().getContext() == null && con.getDestination().getConnectionEnd() instanceof DataAccess && con.getDestination().getContext() == null)
											|| (con.getDestination().getContext() == subContext && con.getSource().getContext() == null && con.getSource().getConnectionEnd() instanceof DataAccess && con.getSource().getContext() == null)) {
										return true;
									} else {
										return getRefinedElement(con.getSource().getContext()) == subContext
											&& getRefinedElement(con.getDestination().getContext()) == subContext;
									}
								} else {
									if (getRefinedElement(con.getSource().getContext()) == subContext && con.getDestination().getContext() == null && con.getDestination().getConnectionEnd() instanceof DataAccess) {
										return true;
									} else if (getRefinedElement(con.getDestination().getContext()) == subContext && con.getSource().getContext() == null) {
										return true;
									}
									return getRefinedElement(con.getSource().getContext()) == subContext
											&& getRefinedElement(con.getDestination().getContext()) == subContext;
								}
							}
						} else if (selectedEle instanceof Subcomponent) {
							if (prevEle instanceof org.osate.aadl2.Connection) {
								final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
								final Context subContext = (Context)getRefinedElement(context);
								if (con.isBidirectional()) {
									return (getRefinedElement(con.getSource().getContext()) == subContext
										|| getRefinedElement(con.getDestination().getContext()) == subContext);
								} else {
									return getRefinedElement(con.getDestination().getContext()) == subContext;
								}
							}
								
						} else if (selectedEle instanceof DataAccess) {
							return context == null && prevEle instanceof org.osate.aadl2.Connection;
						}
					}
				}
			} else if (((selectedEle instanceof FlowSpecification) && context == null)) {
				flowImpl = (FlowImplementation)pkg.getEFactoryInstance().create(pkg.getFlowImplementation());
				final FlowSpecification flowSpec = (FlowSpecification)selectedEle;
				flowImpl.setSpecification(flowSpec);
				flowImpl.setKind(flowSpec.getKind());
				return true;
			}
			return false;
		}
		
		public Object getPreviousSegmentElement() {
			return flowImpl.getOwnedFlowSegments().size() > 0 ? getRefinedElement(flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement()) : null;
		}
		
		private boolean checkSubcomponentOwner(final Context context) {
			for (final Subcomponent owned : ci.getOwnedSubcomponents()) {
				if (getRefinedElement(owned) == context) {
					return true;
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

		private boolean checkValidConnection(final FlowSpecification fs, final org.osate.aadl2.Connection connection, Context context) {
			final ConnectedElement destCE = (ConnectedElement)getRefinedElement(connection.getDestination());
			final ConnectedElement srcCE = (ConnectedElement)getRefinedElement(connection.getSource());
			
			final FlowEnd flowOutEnd = fs.getOutEnd();
			final FlowEnd flowInEnd =  fs.getInEnd();

			if (destCE.getContext() != null && srcCE.getContext() != null) {
				if (fs.getKind() == FlowKind.PATH) {
					if (connection.isBidirectional()) {
						return flowInEnd.getFeature() == destCE.getConnectionEnd()
							|| flowInEnd.getFeature() == srcCE.getConnectionEnd()
							|| flowOutEnd.getFeature() == destCE.getConnectionEnd()
							|| flowOutEnd.getFeature() == srcCE.getConnectionEnd();
					} else {
						return flowInEnd.getFeature() == srcCE.getConnectionEnd()
							|| flowOutEnd.getFeature() == srcCE.getConnectionEnd();
					}
				} else if (fs.getKind() == FlowKind.SINK) {
					return flowInEnd.getFeature() == destCE.getConnectionEnd()
						|| flowInEnd.getFeature() == srcCE.getConnectionEnd();
				} else {
					return flowOutEnd.getFeature() == destCE.getConnectionEnd()
						|| flowOutEnd.getFeature() == srcCE.getConnectionEnd();
				}
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
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite container = (Composite)super.createDialogArea(parent);
			flowSegmentComposite = new Composite(container, SWT.CENTER);
			final RowLayout rowLayout = new RowLayout();
			rowLayout.marginLeft = 10;
			rowLayout.marginTop = 5;
			rowLayout.marginRight = 10;
			flowSegmentComposite.setLayout(rowLayout);

			flowSegmentLabel = new StyledText(flowSegmentComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
			flowSegmentLabel.setEditable(false);
			flowSegmentLabel.setEnabled(false);
			flowSegmentLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			flowSegmentLabel.setMargins(5, 5, 5, 5);
			final RowData rowData = new RowData();
			rowData.height = 75;
			rowData.width = 392;
			flowSegmentLabel.setLayoutData(rowData);
			flowSegmentLabel.setLayout(new RowLayout());

			return container;
		}

		@Override
		protected Control createButtonBar(final Composite parent) {
			final Composite buttonBar = new Composite(parent, SWT.NONE);
			final GridLayout buttonBarLayout = new GridLayout();
			buttonBarLayout.numColumns = 2;
			buttonBar.setLayout(buttonBarLayout);
			final GridData buttonBarData = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
			buttonBar.setLayoutData(buttonBarData);
			buttonBar.setFont(parent.getFont());

			final Button removeButton = new Button(buttonBar, SWT.PUSH);
			removeButton.setText("Undo");
			removeButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					int prevPesSize = previouslySelectedPes.size();
					if (prevPesSize > 0) {
						final PictogramElement removedPe = previouslySelectedPes.get(prevPesSize-1);
						setRemovedFlowSegment(removedPe);
						final EObject ob = (EObject)AadlElementWrapper.unwrap(fp.getBusinessObjectForPictogramElement(removedPe));

						if (ob == flowImpl.getSpecification() && prevPesSize == 1) {
							flowImpl.setSpecification(null);
							flowImpl = null;
						} else if (!(ob instanceof ModeFeature)) {
							final FlowSegment flowSegment = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1);
							flowImpl.getOwnedFlowSegments().remove(flowSegment);
							EcoreUtil.remove(flowSegment);
						} else {
							flowImpl.getInModeOrTransitions().remove(flowImpl.getInModeOrTransitions().size()-1);
						}

						flowSegmentList.clear();
						modeList.clear();
						flowSegmentLabel.setText("");
						if (flowImpl != null) {
							addFlowSegment(flowImpl.getSpecification());
							for (final FlowSegment c : flowImpl.getOwnedFlowSegments()) {
								addFlowSegment(c);
							}
							for (final ModeFeature m : flowImpl.getInModeOrTransitions()) {
								addFlowSegment(m);
							}
						}
						clearSelection(fp.getDiagramTypeProvider());
					}
				}
			});

			final GridData removeBtnData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
			removeBtnData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			removeButton.setLayoutData(removeBtnData);

			final Control buttonControl = super.createButtonBar(buttonBar);
			buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					flows.add(flowImpl);
				}
			});

			return buttonBar;
		}
	}

	
}
