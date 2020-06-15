package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.Modification;
import org.osate.ge.internal.ui.editor.FlowContributionItem.HighlightableFlowInfo;
import org.osate.ge.internal.ui.tools.FlowDialogUtil;
import org.osate.ge.internal.util.AadlHelper;
import org.osate.ge.internal.util.ProxyUtil;

public class DeleteFlowContributionItem extends ControlContribution {
	private AgeDiagramEditor editor = null;
	private Button deleteFlowBtn;
	private HighlightableFlowInfo selectedFlow;

	protected DeleteFlowContributionItem(final String id) {
		super(id);
	}

	@Override
	protected Control createControl(final Composite parent) {
		deleteFlowBtn = new Button(parent, SWT.PUSH);
		deleteFlowBtn.setText("Delete");
		updateButton();
		deleteFlowBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				if (editor != null && selectedFlow != null) {
					final AadlModificationService aadlModificationService = Objects.requireNonNull(
							(AadlModificationService) editor.getAdapter(AadlModificationService.class),
							"Unable to retrieve modification service");
					if (selectedFlow.getFlowSegment() instanceof EndToEndFlow) {
						System.err.println(
								selectedFlow.getFlowSegment().getContainingComponentImpl() + " containingimpl");
						// TODO delete should only remove refined
						//
						final Modification<ComponentImplementation, ComponentImplementation> delete = Modification
								.create(selectedFlow.getFlowSegment().getContainingComponentImpl(),
										ci -> {
											final EndToEndFlow eteFlow = ci.getAllEndToEndFlows()
													.stream().filter(endToEndFlow -> getName(
															endToEndFlow)
															.equalsIgnoreCase(getName(
																	selectedFlow
																	.getFlowSegment())))
													.findAny().orElseThrow(() -> new RuntimeException(
															"cannot find ete flow"));
											ci.getAllEndToEndFlows().remove(eteFlow);
											EcoreUtil.remove(eteFlow);
										});

						aadlModificationService.modify(delete);
					} else if (selectedFlow.getFlowSegment() instanceof FlowSpecification) {
						final ComponentImplementation ci = (ComponentImplementation) getContainerComponent(
								selectedFlow.getContainer().getBusinessObject());
						final FlowSpecification resolveFlowSpec = ProxyUtil.resolveOrNull(selectedFlow.getFlowSegment(),
								FlowSpecification.class, ci.eResource().getResourceSet());
						final List<FlowImplementation> impls = ci.getOwnedFlowImplementations()
								.stream()
								.filter(fi -> fi
										.getSpecification() == resolveFlowSpec)
								.collect(Collectors.toList());
						final Optional<FlowImplementation> optFi = getFlowImplementation(impls);
						optFi.ifPresent(fi -> {
							final Modification<ComponentImplementation, ComponentImplementation> delete = Modification
									.create(ci, ciBo -> {
										final int index = ci.getOwnedFlowImplementations().indexOf(fi);
										final FlowImplementation fiToRemove = ciBo.getOwnedFlowImplementations().get(index);
										ciBo.getOwnedFlowImplementations().remove(fiToRemove);
										EcoreUtil.remove(fiToRemove);
									});

							aadlModificationService.modify(delete);
						});
					} else {
						throw new RuntimeException("Unexpected flow type: " + selectedFlow.getFlowSegment());
					}

				}
			}

			private Optional<FlowImplementation> getFlowImplementation(List<FlowImplementation> impls) {
				if (impls.size() == 1) {
					return Optional.of(impls.get(0));
				} else {
					final M dlg = new M(Display.getCurrent().getActiveShell(), impls, "Select", null,
							"Choose the flow implementation to delete.", MessageDialog.CONFIRM, 0, "OK", "Cancel");
					if (dlg.open() == Window.OK) {
						return Optional.of(dlg.selectedFi);
					}
				}

				return Optional.empty();
			}
		});
		return deleteFlowBtn;
	}

	private Object getContainerComponent(final Object container) {
		if (container instanceof Subcomponent) {
			final Subcomponent sc = (Subcomponent) container;
			return sc.getComponentImplementation();
		}

		return container;
	}

	// TODO duplicate in editflowcontirbutionitem
	private class M extends MessageDialog {
		private ComboViewer comboViewer;
		private final List<FlowImplementation> input;
		private FlowImplementation selectedFi;

		public M(Shell parentShell, final List<FlowImplementation> input, String dialogTitle, Image dialogTitleImage,
				String dialogMessage, int dialogImageType, int defaultIndex, String... dialogButtonLabels) {
			super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, defaultIndex,
					dialogButtonLabels);
			setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
			this.input = input;
		}

		@Override
		protected void configureShell(final Shell shell) {
			super.configureShell(shell);
			shell.setMinimumSize(new Point(550, 275));
		}

		@Override
		protected Control createCustomArea(final Composite parent) {
			final Composite composite = new Composite(parent, SWT.BORDER);
			final GridLayout layout = new GridLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.verticalSpacing = 0;
			layout.horizontalSpacing = 0;
			layout.numColumns = 2;
			composite.setLayout(layout);

			composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			composite.setFont(parent.getFont());

			new Label(composite, SWT.NONE).setText("Flow Implementation: ");
			comboViewer = new ComboViewer(composite, SWT.READ_ONLY);

			final StyledText flowSegmentLabels = FlowDialogUtil.createFlowSegmentLabel(composite);
			flowSegmentLabels.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());
			comboViewer.setContentProvider(ArrayContentProvider.getInstance());
			comboViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					final FlowImplementation fi = (FlowImplementation) element;
					return fi.getSpecification().getName();
				}
			});

			comboViewer.addSelectionChangedListener(event -> {
				selectedFi = (FlowImplementation) event.getStructuredSelection().getFirstElement();
				String flowStr = "";
				final List<String> flowSegmentStrings = new ArrayList<>();
				if (selectedFi.getInEnd() != null) {
					flowSegmentStrings.add(flowEndToString(selectedFi.getInEnd()));
				}

				for (final FlowSegment seg : selectedFi.getOwnedFlowSegments()) {
					flowSegmentStrings.add(flowSegmentToString(seg));
				}

				if (selectedFi.getOutEnd() != null) {
					flowSegmentStrings.add(flowEndToString(selectedFi.getOutEnd()));
				}

				flowStr += flowSegmentStrings.stream().collect(Collectors.joining(" -> "));

				final int modeStartIndex = flowStr.length();
				if (!selectedFi.getInModeOrTransitions().isEmpty()) {
					flowStr += " in modes (" + selectedFi.getInModeOrTransitions().stream().map(mf -> mf.getName())
							.collect(Collectors.joining(", ")) + ")";
				}
				final int modeEndIndex = flowStr.length();

				flowStr += ";";

				flowSegmentLabels.setText(flowStr);

				if (modeStartIndex != modeEndIndex) {
					flowSegmentLabels.setStyleRange(new StyleRange(modeStartIndex, 10,
							Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED), null, SWT.BOLD));
				}
			});

			comboViewer.setInput(input);
			System.err.println(input.get(0) + " inputget(0");
			comboViewer.setSelection(new StructuredSelection(input.get(0)));

			return composite;
		}

		// TODO Flow segments may be refined, make sure to use getrootelement before getting names for segments

		private String flowEndToString(final FlowEnd flowEnd) {
			final StringBuilder sb = new StringBuilder();
			if (flowEnd.getContext() != null) {
				sb.append(getName(flowEnd.getContext()));
				sb.append('.');
			}

			if (flowEnd.getFeature() != null) {
				sb.append(getName(flowEnd.getFeature()));
			}

			return sb.toString();
		}

		private String flowSegmentToString(final FlowSegment flowSegment) {
			final StringBuilder sb = new StringBuilder();
			if (flowSegment.getContext() != null) {
				sb.append(getName(flowSegment.getContext()));
				sb.append('.');
			}

			if (flowSegment.getFlowElement() != null) {
				sb.append(getName(flowSegment.getFlowElement()));
			}

			return sb.toString();
		}

	}

	// TODO move to util?
	private String getName(NamedElement ne) {
		ne = (NamedElement) AadlHelper.getRootRefinedElement(ne);
		return ne.getName() == null ? "<unknown>" : ne.getName();
	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (this.editor != newEditor) {
			// Update the editor
			if (newEditor instanceof AgeDiagramEditor) {
				this.editor = (AgeDiagramEditor) newEditor;
			} else {
				this.editor = null;
			}
		} else {
			updateButton();
		}
	}

	/**
	 * Updates the enabled state of the show flow button determined by the state of the selected flow
	 */
	public void updateEditFlowItem(final HighlightableFlowInfo selectedFlow) {
		this.selectedFlow = selectedFlow;
		updateButton();
	}

	private void updateButton() {
		if (deleteFlowBtn != null && !deleteFlowBtn.isDisposed()) {
			deleteFlowBtn.setEnabled(selectedFlow == null ? false : selectedFlow.getFlowSegment() != null);
		}
	}
}
