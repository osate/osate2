/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.tools;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.di.Deactivate;
import org.osate.ge.internal.di.Description;
import org.osate.ge.internal.di.Icon;
import org.osate.ge.internal.di.Id;
import org.osate.ge.internal.di.InternalNames;
import org.osate.ge.internal.di.SelectionChanged;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.GraphitiService;
import org.osate.ge.internal.services.ShapeService;
import org.osate.ge.internal.services.UiService;
import org.osate.ge.internal.services.AadlModificationService.AbstractModifier;
import org.osate.ge.internal.ui.util.DialogPlacementHelper;

public class CreateFlowImplementationTool {
	private static boolean areEquivalent(final Object bo1, final Object bo2) {
		if(!(bo1 instanceof NamedElement && bo2 instanceof NamedElement)) {
			return false;
		}
		
		final String n1 = ((NamedElement)bo1).getName();
		final String n2 = ((NamedElement)bo2).getName();
		return n1 != null && n1.equalsIgnoreCase(n2);
	}
	
	private ColoringService.Coloring coloring = null;
	private ComponentImplementation ci;
	private CreateFlowImplementationDialog dlg;
	private IFeatureProvider fp;
	private List<PictogramElement> previouslySelectedPes = new ArrayList<PictogramElement>();
	boolean canActivate = true;
	private BusinessObjectResolutionService bor;
	
	@Id
	public final static String ID = "org.osate.ge.ui.tools.CreateFlowImplementationTool";

	@Description
	public final static String DESCRIPTION = "Create Flow Implementation";

	@Icon
	public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateFlowImplementation.gif");

	@CanActivate
	public boolean canActivate(final GraphitiService graphiti, final BusinessObjectResolutionService bor) {
		return bor.getBusinessObjectForPictogramElement(graphiti.getDiagram()) instanceof ComponentImplementation
				&& canActivate;
	}

	@Activate
	public void activate(final AadlModificationService aadlModService,
			final UiService uiService,
			final ColoringService highlightingService,
			final BusinessObjectResolutionService bor,
			final GraphitiService graphiti) {
		this.coloring = highlightingService.adjustColors();
		this.fp = graphiti.getFeatureProvider();
		this.bor = bor;
		
		ci = (ComponentImplementation)bor.getBusinessObjectForPictogramElement(graphiti.getDiagram());
		if (ci != null) {
			canActivate = false;
			clearSelection(graphiti.getDiagramTypeProvider());
			dlg = new CreateFlowImplementationDialog(Display.getCurrent().getActiveShell());
			if (dlg.open() == Dialog.CANCEL) {
				uiService.deactivateActiveTool();
				canActivate = true;
				previouslySelectedPes.clear();
				return;
			}

			if (dlg != null && !dlg.getFlows().isEmpty()) {
				aadlModService.modify(ci, new AbstractModifier<ComponentImplementation, Object>() {
					@Override
					public Object modify(final Resource resource, final ComponentImplementation ci) {
						for (final FlowImplementation flowImplementation : dlg.getFlows()) {
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
	public void deactivate(final GraphitiService graphiti) {
		final TransactionalEditingDomain editingDomain = graphiti.getDiagramTypeProvider().getDiagramBehavior().getEditingDomain();
		editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
			@Override
			public void execute() {				
				// Dispose of the coloring object
				if (coloring != null) {
					coloring.dispose();
					coloring = null;
				}	
			}
		});
		
		// Dispose the dialog
		if (dlg != null) {
			dlg.close();
			dlg = null;
		}
		
		this.fp = null;
		this.ci = null;
		this.bor = null;
		this.previouslySelectedPes.clear();		
		canActivate = true;
	}

	private void clearSelection(final IDiagramTypeProvider dtp) {
		dtp.getDiagramBehavior().getDiagramContainer().selectPictogramElements(new PictogramElement[0]);
	}

	@SelectionChanged
	public void onSelectionChanged(@Named(InternalNames.SELECTED_PICTOGRAM_ELEMENTS) final PictogramElement[] selectedPes,
			final BusinessObjectResolutionService bor, final GraphitiService graphiti, final ShapeService shapeService, final ConnectionService connectionService) {
		if (dlg != null && dlg.getShell() != null && dlg.getShell().isVisible()) {
			// If the selection is a valid addition to the flow implementation, add it		
			final TransactionalEditingDomain editingDomain = graphiti.getDiagramTypeProvider().getDiagramBehavior().getEditingDomain();			
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
						@Override
						public void execute() {
							if(dlg != null && dlg.flowSegmentComposite != null && !dlg.flowSegmentComposite.isDisposed()) {
								if(selectedPes.length > 1) {
									dlg.setErrorMessage("Multiple diagram elements selected. Select a single diagram element. " + " " + getDialogMessage());
								} else if(selectedPes.length == 1) {
									// Get the selected pictogram
									PictogramElement pe = selectedPes[0];
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
	
									// Get the business object
									final Object bo = bor.getBusinessObjectForPictogramElement(pe);
									final Context context = shapeService.getClosestBusinessObjectOfType(shape, Context.class);
									String error = null;
									if (pe != null && !(pe instanceof Diagram)) {
										if(dlg.addSelectedElement(bo, context)) {
											if ( areEquivalent(bo, dlg.getFlow().getSpecification())) {
												coloring.setForeground(pe, Color.ORANGE.darker());
											} else if (bo instanceof ModeFeature) {
												coloring.setForeground(pe, Color.MAGENTA.brighter());
											} else {
												coloring.setForeground(pe, Color.MAGENTA.darker());
											}
											previouslySelectedPes.add(pe);
										} else {
											error = "Invalid element selected. ";							
										}
									} 
									
									if(error == null) {
										dlg.setErrorMessage(null);
										dlg.setMessage(getDialogMessage());
									} else {
										dlg.setErrorMessage(error + " " + getDialogMessage());
									}
								}
							}
						}
					});
				}				
			});
		}
	}

	/**
	 * Determine message based on currently selected element
	 * @return
	 */
	private String getDialogMessage() {
		String msg;
		if (previouslySelectedPes.size() > 0) {
			//Get last element selected to determine message
			final Object bo = bor.getBusinessObjectForPictogramElement(previouslySelectedPes.get(previouslySelectedPes.size()-1));
			if ((bo instanceof FlowSpecification && areEquivalent(bo, dlg.flowImpl.getSpecification())
				&& ((FlowSpecification)bo).getKind() == FlowKind.SOURCE) || bo instanceof org.osate.aadl2.Connection) {
				msg = "Select a subcomponent flow specification, subcomponent, or a data access feature.";
			} else if (bo instanceof FlowSpecification || bo instanceof DataAccess
					|| bo instanceof Subcomponent) {
				msg = "Select a connection.";
			}  else {
				//Return same message if the selected element was a mode feature
				return dlg.getMessage();
			}
		} else{
			msg = "Select a top-level flow specification to implement.";
		}
		
		msg += "\nOptionally, select a mode or mode transition.";
		
		return msg;
	}

	private class CreateFlowImplementationDialog extends TitleAreaDialog {
		private Composite flowSegmentComposite;
		private StyledText flowSegmentLabel;
		private Button undoButton;
		final private List<FlowImplementation> flows = new ArrayList<FlowImplementation>();
		final private Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		private FlowImplementation flowImpl = null;
		final private List<String> flowSegmentList = new ArrayList<String>();
		final private List<String> modeList = new ArrayList<String>();
		
		CreateFlowImplementationDialog(final Shell parentShell) {
			super(parentShell);
			this.setHelpAvailable(false);
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
		}

		private List<FlowImplementation> getFlows() {
			return Collections.unmodifiableList(flows);
		}

		private FlowImplementation getFlow() {
			return flowImpl;
		}

		/**
		 * @param bo - business object that is selected
		 * @param context - context of selected PE
		 * @return - true or false depending if the selected element was added to the flow implementation
		 */
		public boolean addSelectedElement(final Object bo, final Context context) {
			final Element selectedEle = (Element)bo;
			if (isValid((Element)getRefinedElement(selectedEle), context)) {
				if (areEquivalent(selectedEle, flowImpl.getSpecification()) && context == null) {
					return addFlowSegmentOrModeFeature(selectedEle);
				} else if (selectedEle instanceof FlowSpecification || selectedEle instanceof DataAccess) {
					return addFlowSegmentOrModeFeature(createOwnedFlowSegment((Element)bo, context));
				} else if (selectedEle instanceof Subcomponent || selectedEle instanceof org.osate.aadl2.Connection) {
					//Create flow segment with context = null because all valid connections and subcomponents belong to diagram
					return addFlowSegmentOrModeFeature(createOwnedFlowSegment((Element)bo, null));
				} else {
					return addFlowSegmentOrModeFeature(selectedEle);
				}
			}
			return false;
		}

		/**
		 * @param ctx - context of the selected element
		 * @param flowElement - selected element or recently added flow segment
		 * @return name of the element to be shown in dialog
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

		/**
		 * Updates the OK button
		 */
		private void updateWidgets() {
			setNavigationButtonsEnabled(isCompleteAndValid());
		}

		/**
		 * Determines if the flow implementation is complete and valid based on it's
		 * flow segment information. Used for updating the dialog widgets
		 * @return true or false
		 */
		private boolean isCompleteAndValid() {
			if (flowImpl != null) {
				if (flowImpl.getOwnedElements().isEmpty()) {
					return true;
				} else {
					if (flowImpl.getKind() == FlowKind.PATH) {
						final Object prevEle = getRefinedElement(getPreviousSegmentElement());
						if (prevEle instanceof org.osate.aadl2.Connection) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
							final Feature feature = flowImpl.getSpecification().getOutEnd().getFeature();
							if (con.isBidirectional()) {
								return areEquivalent(con.getDestination().getConnectionEnd(), feature)
										|| areEquivalent(con.getSource().getConnectionEnd(), feature);
							} else {
								return areEquivalent(con.getDestination().getConnectionEnd(), feature);
							}
						}
					} else {
						return flowImpl.getOwnedFlowSegments().size() % 2 == 0;
					}
				}
			}
			return false;
		}

		/**
		 * Set OK button to enabled or disabled based on if the flow implementation is complete and valid
		 * @param enabled - true if flow implementation is complete and valid, false otherwise
		 */
		private void setNavigationButtonsEnabled(final boolean enabled) {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			if (okBtn != null) {
				getButton(IDialogConstants.OK_ID).setEnabled(enabled);
			}
			if (undoButton != null) {
				undoButton.setEnabled(flowImpl != null && flowImpl.getSpecification() != null);
			}
		}

		/**
		 * Creates/Updates the dialog flow implementation information
		 * @param object - the object holding information of the Flow Implementation's Flow Specification,
		 * recently addedFlow Segment, or Mode Feature
		 * @return whether the flow segment added
		 */
		private boolean addFlowSegmentOrModeFeature(final Object object) {
			if (!flowSegmentComposite.isDisposed()) {
				flowSegmentLabel.setEnabled(true);
				final FlowSpecification fs = flowImpl.getSpecification();
				if (fs != null) {
					final FlowEnd flowOutEnd = fs.getOutEnd();
					final FlowEnd flowInEnd = fs.getInEnd();
					if (object instanceof ModeFeature) {
						final ModeFeature mf = (ModeFeature)object;
						flowImpl.getInModeOrTransitions().add(mf);
						modeList.add(flowImpl.getInModeOrTransitions().indexOf(mf) == 0 ? "  in modes  (" + mf.getName() : ", " + mf.getName());
					} else {
						//path
						if (fs.getKind() == FlowKind.PATH) {
							if (flowImpl.getSpecification() == object) {
								flowSegmentList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");
								flowSegmentList.add(getSegmentName(flowOutEnd.getContext(), flowOutEnd.getFeature()));
							} else if (object instanceof FlowSegment) {
								final FlowSegment flowSegment = (FlowSegment)object;
								flowSegmentList.add(flowSegmentList.size()-1, getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) + "  ->");
							}
						}
						//source
						else if (fs.getKind() == FlowKind.SOURCE) {
							if (flowImpl.getSpecification() == object) {
								flowSegmentList.add(getSegmentName(flowOutEnd.getContext(), flowOutEnd.getFeature()));
							} else if (object instanceof FlowSegment) {
								final FlowSegment flowSegment = (FlowSegment)object;
								flowSegmentList.add(flowImpl.getOwnedFlowSegments().indexOf(flowSegment) == 0 ? 0 : flowSegmentList.size()-1,
										getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) + "  ->");
							}
						}
						//sink
						else if (fs.getKind() == FlowKind.SINK) {
							if (flowImpl.getSpecification() == object) {
								flowSegmentList.add(getSegmentName(flowInEnd.getContext(), flowInEnd.getFeature()) + "  ->");		
							} else if (object instanceof FlowSegment) {
								final FlowSegment flowSegment = (FlowSegment)object;
								flowSegmentList.add(flowImpl.getOwnedFlowSegments().indexOf(flowSegment) == 0 ?
										getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()) :
											"->  " + getSegmentName(flowSegment.getContext(), flowSegment.getFlowElement()));
							}
						}
					} 
					
					//Updates the dialog flow implementation segments
					setFlowImplementationString();
					//Update OK button
					updateWidgets();
					return true;
				}
			}
			return false;
		}

		/**
		 * Sets the dialog flow implementation information and the style range for rich text
		 */
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

		/**
		 * @return the In Modes or Transitions information
		 */
		private String getModeString() {
			String modeString = "";
			for (final String string : modeList) {
				modeString = modeString + string;
			}
			return modeString == "" ? modeString : modeString + ")";
		}
		
		/**
		 * Determines if the selected element is valid to be added to Flow Implementation
		 * @param selectedEle - selected element
		 * @param context - context of element
		 * @return
		 */
		private boolean isValid(final Element selectedEle, final Context context) {
			if (flowImpl != null) {
				final Object prevEle = getRefinedElement(getPreviousSegmentElement());
				final FlowSpecification flowImplFlowSpec = flowImpl.getSpecification();
				if (selectedEle instanceof ModeFeature) {
					return context == null;
				} else if (flowImpl.getOwnedFlowSegments().isEmpty()) {
					FlowKind flowKind = flowImpl.getSpecification().getKind();
					if (flowKind == FlowKind.PATH) {
						if (selectedEle instanceof org.osate.aadl2.Connection && context == null) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)selectedEle;
							final Feature inFlowFeature = flowImplFlowSpec.getInEnd().getFeature();
							final Feature outFlowFeature = flowImplFlowSpec.getOutEnd().getFeature();
							final ConnectedElement dest = con.getDestination();
							final ConnectedElement src = con.getSource();
							if (con.isBidirectional()) {
								if (dest.getContext() == null && 
										areEquivalent(inFlowFeature, dest.getConnectionEnd()) || 
										areEquivalent(inFlowFeature, src.getConnectionEnd()) || 
										areEquivalent(outFlowFeature, dest.getConnectionEnd()) || 
										areEquivalent(outFlowFeature, src.getConnectionEnd())) {
									return true;
								}
							} else {
								if (areEquivalent(inFlowFeature, src.getConnectionEnd())
										|| (areEquivalent(outFlowFeature, dest.getConnectionEnd()) && dest.getContext() == null)) {
									return true;
								}
							}
						}

					} else if (flowKind == FlowKind.SINK) {
						if(context == null && selectedEle instanceof org.osate.aadl2.Connection) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)selectedEle;
							if (con.isBidirectional()) {
								if ((areEquivalent(flowImplFlowSpec.getInEnd().getFeature(), con.getDestination().getConnectionEnd()) && con.getDestination().getContext() == null)
										|| (areEquivalent(flowImplFlowSpec.getInEnd().getFeature(), con.getSource().getConnectionEnd()) && con.getSource().getContext() == null)) {
									return true;
								}
							} else {
								if (areEquivalent(flowImplFlowSpec.getInEnd().getFeature(), con.getSource().getConnectionEnd()) && con.getSource().getContext() == null) {
									return true;
								}
							}
						}
					} else if(flowKind == FlowKind.SOURCE) {
						if (selectedEle instanceof FlowSpecification) {
							return context != null;
						} else if (selectedEle instanceof Subcomponent) {
							return isValidSubcomponent((Context)getRefinedElement(selectedEle));
						} else if (selectedEle instanceof DataAccess) {
							return context == null;
						}
					}
				} else {
					if (context != null && selectedEle instanceof FlowSpecification && prevEle instanceof org.osate.aadl2.Connection
							&& isValidSubcomponent((Context)getRefinedElement(context))) {
						final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
						final FlowSpecification fs = ((FlowSpecification)selectedEle);
						final FlowEnd flowEnd = fs.getKind() == FlowKind.SINK ? fs.getInEnd() : fs.getOutEnd();
						if (fs.getKind() == FlowKind.PATH) {
							FlowEnd flowInEnd = fs.getInEnd();
							
							return areEquivalent(con.getDestination().getConnectionEnd(), flowEnd.getFeature()) ||
									areEquivalent(con.getSource().getConnectionEnd(), flowEnd.getFeature()) ||
											areEquivalent(con.getDestination().getConnectionEnd(), flowInEnd.getFeature()) ||
													areEquivalent(con.getSource().getConnectionEnd(), flowInEnd.getFeature());
						} else {
							return areEquivalent(con.getSource().getConnectionEnd(), flowEnd.getFeature()) || areEquivalent(con.getDestination().getConnectionEnd(), flowEnd.getFeature());
						}
					} else if (selectedEle instanceof org.osate.aadl2.Connection) {
						final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)(getRefinedElement(selectedEle));
						if (prevEle instanceof FlowSpecification) {
							return isValidConnectionAfterFlowSpecification((FlowSpecification)prevEle, con, context);
						} else if (prevEle instanceof Subcomponent) {
							final Context subContext = (Context)getRefinedElement(prevEle);
							final Feature flowEndFeature = flowImplFlowSpec.getKind() == FlowKind.SINK ? flowImplFlowSpec.getInEnd().getFeature() : flowImplFlowSpec.getOutEnd().getFeature();
							final Context srcCtx = con.getSource().getContext();
							final Context destCtx = con.getDestination().getContext();
							final ConnectionEnd destCE = con.getDestination().getConnectionEnd();
							final ConnectionEnd srcCE = con.getSource().getConnectionEnd();
							if (context == null) {
								if (areEquivalent(srcCtx, subContext) && ((destCE instanceof DataAccess || isValidSubcomponent((Context)getRefinedElement(destCtx))) || (areEquivalent(destCE, flowEndFeature) && destCtx == null))
										|| (areEquivalent(destCtx, subContext) && ((srcCE instanceof DataAccess || isValidSubcomponent(srcCtx))))) {
									return true;
								}
							} else {
								return areEquivalent(con.getSource().getContext(), subContext)
										&& areEquivalent(con.getDestination().getContext(), subContext);
							}
						} else if (prevEle instanceof DataAccess) {
							return context == null || isValidSubcomponent((Context)getRefinedElement(context));
						}
					} else if (selectedEle instanceof DataAccess) {
						return context == null && prevEle instanceof org.osate.aadl2.Connection;
					} else if (selectedEle instanceof Subcomponent) {
						if (prevEle instanceof org.osate.aadl2.Connection) {
							final org.osate.aadl2.Connection con = (org.osate.aadl2.Connection)prevEle;
							final Context subContext = (Context)getRefinedElement(context);
							return (areEquivalent(con.getSource().getContext(), subContext)
									|| areEquivalent(con.getDestination().getContext(), subContext));
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

		/**
		 * Check if the connection is a valid ending connection or connected to a valid data access
		 * @param fs - previous flow specification selected
		 * @param con - current connection
		 * @param context - current context
		 */
		private boolean isValidConnectionAfterFlowSpecification(final FlowSpecification fs, final org.osate.aadl2.Connection con, final Context context) {
			if (isValidSubcomponent((Context)getRefinedElement(context)) || context == null) {
				final Feature flowFeature = fs.getKind() == FlowKind.SINK ? fs.getInEnd().getFeature() : fs.getOutEnd().getFeature();
				final Feature flowImplFeature = flowImpl.getKind() == FlowKind.SINK ? flowImpl.getSpecification().getInEnd().getFeature() : flowImpl.getSpecification().getOutEnd().getFeature();
				final ConnectionEnd destCE = con.getDestination().getConnectionEnd();
				final ConnectionEnd srcCE = con.getSource().getConnectionEnd();
				final Context destCtx = con.getDestination().getContext();
				final Context srcCtx = con.getSource().getContext();
				if (fs.getKind() == FlowKind.PATH) {
					final Feature inFlowFeature = fs.getInEnd().getFeature();
					if ((areEquivalent(flowFeature, srcCE) && areEquivalent(flowImplFeature, destCE) && destCtx == null)
							|| (areEquivalent(flowFeature, destCE) && areEquivalent(flowImplFeature, srcCE) && srcCtx == null)
							|| (areEquivalent(inFlowFeature, srcCE) && areEquivalent(flowImplFeature, destCE) && destCtx == null)
							|| (areEquivalent(inFlowFeature, destCE) && areEquivalent(flowImplFeature, srcCE) && srcCtx == null)
							|| (srcCE instanceof DataAccess && srcCtx == null)
							|| (destCE instanceof DataAccess && destCtx == null)) {
						return true;
					}
				} else {
					if ((areEquivalent(flowFeature, srcCE) && areEquivalent(flowImplFeature, destCE) && destCtx == null)
							|| (areEquivalent(flowFeature, destCE) && areEquivalent(flowImplFeature, srcCE) && srcCtx == null)
							|| (areEquivalent(srcCE, flowFeature) && destCE instanceof DataAccess && destCtx == null)
							|| (areEquivalent(destCE, flowFeature) && srcCE instanceof DataAccess && srcCtx == null)) {
						return true;
					}
				}
				//If the connection was not a valid ending connection or connected to a DataAccess,
				//check validitity
				return isValidConnection(fs, con);
			}
			return false;
		}

		private Object getPreviousSegmentElement() {
			return flowImpl.getOwnedFlowSegments().size() > 0 ? getRefinedElement(flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1).getFlowElement()) : null;
		}

		//Checks for valid subcomponent in the diagram
		private boolean isValidSubcomponent(final Context context) {
			for (final Subcomponent subcomponent : ci.getAllSubcomponents()) {
				if (areEquivalent(subcomponent, context)) {
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

		/**
		 * Checks if the connection is valid based off of previous flow specification
		 * if connection is not a valid ending connection
		 * @param fs - previous flowSpec
		 * @param con - current connection selected
		 * @param context - current context of selection
		 * @return
		 */
		private boolean isValidConnection(final FlowSpecification fs, final org.osate.aadl2.Connection con) {
			final ConnectionEnd destCE = (ConnectionEnd)getRefinedElement(con.getDestination().getConnectionEnd());
			final ConnectionEnd srcCE = (ConnectionEnd)getRefinedElement(con.getSource().getConnectionEnd());
			final Feature flowFeature = fs.getKind() == FlowKind.SINK ? fs.getInEnd().getFeature() : fs.getOutEnd().getFeature();
			if (fs.getKind() == FlowKind.PATH) {
				final FlowEnd inFlowFeature = fs.getInEnd();
				return areEquivalent(inFlowFeature, destCE)
						|| areEquivalent(inFlowFeature, srcCE)
						|| areEquivalent(flowFeature, destCE)
						|| areEquivalent(flowFeature, srcCE);
			} else {
				//Rules for source and sink
				return areEquivalent(flowFeature, destCE)
						|| areEquivalent(flowFeature, srcCE);
			}
		}

		//Creates FlowSegment and returns the new FlowSegment
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
			newShell.setLocation(DialogPlacementHelper.getOffsetRectangleLocation(Display.getCurrent().getActiveShell().getBounds(), 50, 50));
			newShell.setSize(540, 250);
			newShell.setImage(ICON.createImage());
			newShell.setMinimumSize(300, 215);
		}

		@Override
		public void create() {
			super.create();
			setTitle("Select Elements");
			setMessage(CreateFlowImplementationTool.this.getDialogMessage());
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			flowSegmentComposite = (Composite)super.createDialogArea(parent);
			GridLayout layout = (GridLayout)flowSegmentComposite.getLayout();
			layout.marginLeft = 10;
			layout.marginTop = 5;
			
			flowSegmentLabel = new StyledText(flowSegmentComposite, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
			flowSegmentLabel.setEditable(false);
			flowSegmentLabel.setEnabled(false);
			flowSegmentLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			flowSegmentLabel.setMargins(5, 5, 5, 5);
			flowSegmentLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			return flowSegmentComposite;
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

			undoButton = new Button(buttonBar, SWT.PUSH);
			undoButton.setEnabled(false);
			undoButton.setText("Undo");
			undoButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final int prevPesSize = previouslySelectedPes.size();
					if (prevPesSize > 0) {
						final PictogramElement removedPe = previouslySelectedPes.get(prevPesSize-1);
						previouslySelectedPes.remove(prevPesSize-1);
						
						final TransactionalEditingDomain editingDomain = fp.getDiagramTypeProvider().getDiagramBehavior().getEditingDomain();
						editingDomain.getCommandStack().execute(new NonUndoableToolCommand() {
							@Override
							public void execute() {
								coloring.setForeground(removedPe, Color.BLACK);
							};
						});
						
						final Object ob = bor.getBusinessObjectForPictogramElement(removedPe);
						if (areEquivalent(ob, flowImpl.getSpecification()) && prevPesSize == 1) {
							flowImpl.setSpecification(null);
							flowImpl = null;
						} else if (!(ob instanceof ModeFeature)) {
							final FlowSegment flowSegment = flowImpl.getOwnedFlowSegments().get(flowImpl.getOwnedFlowSegments().size()-1);
							flowImpl.getOwnedFlowSegments().remove(flowSegment);
							EcoreUtil.remove(flowSegment);
						} else {
							flowImpl.getInModeOrTransitions().remove(flowImpl.getInModeOrTransitions().size()-1);
						}

						//Clear strings for refresh
						flowSegmentList.clear();
						modeList.clear();
						flowSegmentLabel.setText("");
						if (flowImpl != null) {
							addFlowSegmentOrModeFeature(flowImpl.getSpecification());
							for (final FlowSegment flowSegment : flowImpl.getOwnedFlowSegments()) {
								addFlowSegmentOrModeFeature(flowSegment);
							}
							for (final ModeFeature modeFeature : flowImpl.getInModeOrTransitions()) {
								addFlowSegmentOrModeFeature(modeFeature);
							}
						}
						clearSelection(fp.getDiagramTypeProvider());
						updateWidgets();
					}
				}
			});

			final GridData removeBtnData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
			removeBtnData.horizontalIndent = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			undoButton.setLayoutData(removeBtnData);

			final Control buttonControl = super.createButtonBar(buttonBar);
			buttonControl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			okBtn.setEnabled(false);
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
