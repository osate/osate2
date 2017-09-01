package org.osate.ge.internal.ui.properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.ge.BusinessObjectContext;

public class ConfigureInModesSection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		private static Object parent = null;
		@Override
		public boolean select(final Object toTest) {
			if (PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof ModalElement)) {
				final BusinessObjectContext boc = Adapters.adapt(toTest, BusinessObjectContext.class);
				final ModalElement me = (ModalElement) boc.getBusinessObject();
				if (parent == null) {
					parent = boc.getParent().getBusinessObject();
					return me.getContainingClassifier() instanceof ComponentClassifier;
				}

				final Object tmpParent = boc.getParent().getBusinessObject();
				return (me.getContainingClassifier() instanceof ComponentClassifier) && parent == tmpParent;
			}

			return false;
		}

		private static void resetParent() {
			parent = null;
		}
	}

	private List<Control> modeControls;
	private Map<ModeButton, ComboViewer> modeBtnCtrls;
	private List<ModeFeature> childModeFeatures;
	private Map<ModeFeature, ModeFeature> localToChildModeMap;
	private boolean inAllModes;
	private BusinessObjectSelection selectedBos;
	Composite container;
	Composite composite;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		container = getWidgetFactory().createFlatFormComposite(parent);
		container.setLayout(new GridLayout(2, false));

		final Label label = getWidgetFactory().createLabel(container, "Configure In Modes:");
		GridDataFactory.fillDefaults().applyTo(label);
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		Filter.resetParent();
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		boolean enabledDerivedCombo = false;
		System.err.println("refresh");
		if (composite != null) {
			composite.dispose();
		}

		composite = getWidgetFactory().createComposite(container);
		final Set<ModalElement> selectedModalElements = selectedBos.boStream(ModalElement.class).map(a -> a)
				.collect(Collectors.toSet());
		// Why hashset?
		ArrayList<Mode> intersectionDerivedModes = null;
		final ComponentClassifier cc = (ComponentClassifier) ((ModalElement) selectedModalElements.toArray()[0])
				.getContainingClassifier();
		final List<ModeFeature> allLocalModeFeatures = new ArrayList<>(cc.getAllModes());
		for (final ModalElement modalElement : selectedModalElements) {
			if (modalElement instanceof Subcomponent) {
				final Subcomponent sc = (Subcomponent) modalElement;
				final ComponentType ct = sc.getComponentType();
				if (ct != null) {
					for (final Mode mb : ct.getOwnedModes()) {
						if (mb.isDerived()) {
							if (intersectionDerivedModes == null) {
								intersectionDerivedModes = new ArrayList<>();
								intersectionDerivedModes.addAll(ct.getOwnedModes());
								break;
							}
							intersectionDerivedModes.retainAll(ct.getOwnedModes());
							break;
						}
					}
				}
			} else if (modalElement instanceof AnnexSubclause) {

			} else if (modalElement instanceof ModalPath) {

			} else if (modalElement instanceof ModalPropertyValue) {

			} else if (modalElement instanceof SubprogramCallSequence) {

			} else {
				// not supported
			}
		}

		if (intersectionDerivedModes != null && !intersectionDerivedModes.isEmpty()) {
			enabledDerivedCombo = true;
			for (Mode m : intersectionDerivedModes) {
				System.err.println(m + " intersectionalMode");
			}
		} else {
			System.err.println("DISABLE DROPDOWNS");
		}

		modeBtnCtrls = new HashMap<ModeButton, ComboViewer>();
		modeControls = new ArrayList<>();
		// if intersection != null and not empty

		// for(final ModalElement modalElement : selectedDirections) {

		/*
		 * final ComponentClassifier cc = (ComponentClassifier) ((ModalElement) selectedModalElements.toArray()[0])
		 * .getContainingClassifier();
		 * final List<ModeFeature> allLocalModeFeatures = new ArrayList<ModeFeature>(cc.getAllModes());
		 * // final List<ModeFeature> localModeTransitions = new ArrayList<>();
		 * localToChildModeMap = new HashMap<ModeFeature, ModeFeature>();
		 * modeBtnCtrls = new HashMap<ModeButton, ComboViewer>();
		 * modeControls = new ArrayList<>();
		 *
		 * final Button allModesBtn = getWidgetFactory().createButton(composite, "All Modes", SWT.CHECK);
		 * final GridData allModesGridData = new GridData();
		 *
		 *
		 * final Label modeSeparator = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		 * final GridData modeSeparatorLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		 *
		 * for (final ModalElement modalElement : selectedModalElements) {
		 * if (modalElement instanceof Subcomponent) {
		 * final Subcomponent sc = (Subcomponent) modalElement;
		 *
		 *
		 * Build the child mode names from the subcomponents required modes
		 * childModeFeatures = new ArrayList<ModeFeature>();
		 * if (sc.getComponentType() != null) {
		 * final List<Mode> childModes = sc.getComponentType().getAllModes();
		 * for (final Mode childMode : childModes) {
		 * if (childMode.isDerived()) {
		 * childModeFeatures.add(childMode);
		 * }
		 * }
		 * }
		 *
		 *
		 * Build the local to child mode map from the mode bindings
		 * for (final ModeBinding modeBinding : sc.getOwnedModeBindings()) {
		 * final ModeFeature localModeName = modeBinding.getParentMode();
		 * final ModeFeature childModeName = modeBinding.getDerivedMode() == null ? null
		 * : modeBinding.getDerivedMode();
		 * localToChildModeMap.put(localModeName, childModeName);
		 * }
		 * } else if (modalElement instanceof org.osate.aadl2.Connection || modalElement instanceof FlowSpecification) {
		 * // allLocalModeFeatures.addAll(cc.getAllModeTransitions());
		 * for (ModeTransition mt : cc.getAllModeTransitions()) {
		 * if (allLocalModeFeatures.contains(mt)) {
		 * allLocalModeFeatures.add(mt);
		 * }
		 * }
		 * childModeFeatures = null;
		 *
		 * final ModalPath modalPath = (ModalPath) modalElement;
		 * for (final ModeFeature mf : modalPath.getInModeOrTransitions()) {
		 * localToChildModeMap.put(mf, null);
		 * }
		 * } else {
		 * throw new RuntimeException("Unsupported type: " + modalElement.getClass());
		 * }
		 *
		 *
		 * Sort mode and transition names for dialog menu
		 *
		 * }
		 * // final List<ModeFeature> localModeFeatures = new ArrayList<ModeFeature>();
		 * // short alllocalmodefeatures?
		 * for (final ModeFeature tmpMode : allLocalModeFeatures) {
		 * if (tmpMode instanceof Mode) {
		 * // if (!localModeFeatures.contains(tmpMode)) {
		 * addLocalMode(composite, tmpMode);
		 * // localModeFeatures.add(tmpMode);
		 * // }
		 * } else {
		 * if (tmpMode instanceof ModeTransition) {
		 * // if (!localModeFeatures.contains(tmpMode)) {
		 * localModeTransitions.add(tmpMode);
		 *
		 * Sort transition names
		 * // Collections.sort(localModeTransitions);
		 * final GridData modeTransitionSeparatorLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		 * final Label modeTransitionSeparator = new Label(composite, SWT.HORIZONTAL | SWT.SEPARATOR);
		 * modeTransitionSeparatorLayoutData.horizontalSpan = childModeFeatures == null ? 1 : 3;
		 * modeTransitionSeparator.setLayoutData(modeTransitionSeparatorLayoutData);
		 * addLocalMode(composite, tmpMode);
		 * }
		 * }
		 * }
		 *
		 * final GridLayout layout = new GridLayout(childModeFeatures == null ? 1 : 3, false);
		 * composite.setLayout(layout);
		 * GridDataFactory.fillDefaults().applyTo(composite);
		 *
		 * allModesGridData.horizontalSpan = layout.numColumns;
		 * allModesBtn.setLayoutData(allModesGridData);
		 * allModesBtn.setSelection(inAllModes);
		 *
		 * modeSeparatorLayoutData.horizontalSpan = layout.numColumns;
		 * modeSeparator.setLayoutData(modeSeparatorLayoutData);
		 *
		 *
		 * update all check boxes when all modes is selected
		 * updateEnabledStateOfModeControls(!allModesBtn.getSelection());
		 * allModesBtn.addSelectionListener(new SelectionAdapter() {
		 *
		 * @Override
		 * public void widgetSelected(final SelectionEvent e) {
		 * updateEnabledStateOfModeControls(!allModesBtn.getSelection());
		 * inAllModes = allModesBtn.getSelection();
		 * if (inAllModes) {
		 * selectedBos.modify(NamedElement.class, ne -> {
		 * if (ne instanceof Subcomponent) {
		 * final Subcomponent sc = (Subcomponent) ne;
		 * sc.getOwnedModeBindings().clear();
		 * } else if (ne instanceof Connection || ne instanceof FlowSpecification) {
		 * final ModalPath mp = (ModalPath) ne;
		 * mp.getInModeOrTransitions().clear();
		 * }
		 * });
		 * }
		 *
		 * for (final ModeButton modeBtn : modeBtnCtrls.keySet()) {
		 * modeBtn.getModeButton().setSelection(true);
		 * }
		 *
		 * }
		 * });
		 */
	}

	private void updateEnabledStateOfModeControls(final boolean value) {
		for (final ModeButton modeBtn : modeBtnCtrls.keySet()) {
			final Button btn = modeBtn.getModeButton();
			final ComboViewer comboViewer = modeBtnCtrls.get(modeBtn);
			if (comboViewer != null) {
				comboViewer.getCombo().setEnabled(value);
			}

			if (!value) {
				btn.setSelection(true);
			}
			btn.setEnabled(value);
		}
		for (final Control c : modeControls) {
			c.setEnabled(value);
		}
	}

	private void addLocalMode(final Composite container, final ModeFeature modeFeature) {
		final Button modeBtn = getWidgetFactory().createButton(container, modeFeature.getName(), SWT.CHECK);
		final ModeButton modeButton = new ModeButton(modeBtn, modeFeature);

		/*
		 * Set checked state
		 */ if (localToChildModeMap.containsKey(modeFeature)) {
			 modeBtn.setSelection(true);
		 }

		 /*
		  * Create child mode drop down
		  */ final ComboViewer childModeFld;

		  if (childModeFeatures == null) {
			  childModeFld = null;
		  } else {
			  final Label mappedLabel = getWidgetFactory().createLabel(container, "->", SWT.CENTER);
			  mappedLabel.setText("->");
			  modeControls.add(mappedLabel);

			  /*
			   * Create mapped child mode combo
			   */ childModeFld = new ComboViewer(container, SWT.DROP_DOWN | SWT.READ_ONLY);
			   childModeFld.setContentProvider(ArrayContentProvider.getInstance());
			   childModeFld.setLabelProvider(new LabelProvider() {
				   @Override
				   public String getText(final Object element) {
					   if (element instanceof ModeFeature) {
						   final ModeFeature modalFeature = (ModeFeature) element;
						   return modalFeature.getName();
					   }
					   return "                ";
				   }
			   });

			   childModeFld.add("");
			   // Sort child modes' names
			   // Collections.sort(childModes);
			   /*
			    * for (final ModeFeature childMode : childModes) {
			    * childModeFld.add(childMode.getName());
			    * }
			    */

			   childModeFld.add(childModeFeatures.toArray());

			   final ModeFeature mappedChildModeName = localToChildModeMap.get(modeFeature);
			   if (mappedChildModeName != null) {
				   childModeFld.setSelection(new StructuredSelection(mappedChildModeName));
			   }
		  }

		  modeBtnCtrls.put(modeButton, childModeFld);

		  final SelectionListener selectionListener = new SelectionAdapter() {
			  @Override
			  public void widgetSelected(final SelectionEvent e) {
				  selectedBos.modify(NamedElement.class, ne -> {
					  boolean allSelection = true;
					  for (final ModeButton modeBtn : modeBtnCtrls.keySet()) {
						  if (!modeBtn.getModeButton().getSelection()) {
							  allSelection = false;
						  }
					  }

					  if (ne instanceof Subcomponent) {
						  final Subcomponent msc = (Subcomponent) ne;
						  if (inAllModes || allSelection) {
							  msc.getOwnedModeBindings().clear();
						  } else if (modeBtn.getSelection()) {
							  final Object selection = ((StructuredSelection) childModeFld.getSelection())
									  .getFirstElement();
							  final ModeFeature childMode = selection instanceof ModeFeature ? (ModeFeature) selection
									  : null;
							  final ModeBinding existingModeBinding = getModeBinding(msc);
							  if (existingModeBinding != null) {
								  msc.getOwnedModeBindings().remove(existingModeBinding);
							  }

							  final ModeBinding newModeBinding = msc.createOwnedModeBinding();
							  newModeBinding.setParentMode((Mode) modeFeature);
							  newModeBinding.setDerivedMode((Mode) childMode);
						  } else {
							  msc.getOwnedModeBindings().clear();
							  for (final ModeButton modeBtn : modeBtnCtrls.keySet()) {
								  if (modeBtn.getModeButton().getSelection()) {
									  final ComboViewer comboViewer = modeBtnCtrls.get(modeBtn);
									  final Object selection = ((StructuredSelection) comboViewer.getSelection())
											  .getFirstElement();
									  final ModeFeature childMode = selection instanceof ModeFeature
											  ? (ModeFeature) selection
													  : null;
											  final ModeBinding newModeBinding = msc.createOwnedModeBinding();
											  newModeBinding.setParentMode((Mode) modeBtn.getModeFeature());
											  newModeBinding.setDerivedMode((Mode) childMode);
								  }
							  }
						  }
					  } else if (ne instanceof Connection || ne instanceof FlowSpecification) {
						  final ModalPath mp = (ModalPath) ne;
						  if (inAllModes || allSelection) {
							  mp.getInModeOrTransitions().clear();
						  } else if (modeBtn.getSelection()) {
							  mp.getInModeOrTransitions().add(modeFeature);
						  } else {
							  mp.getInModeOrTransitions().clear();
							  for (final ModeButton modeBtn : modeBtnCtrls.keySet()) {
								  if (modeBtn.getModeButton().getSelection()) {
									  mp.getInModeOrTransitions().add(modeBtn.getModeFeature());
								  }
							  }
						  }
					  }
				  });
			  }

			  private ModeBinding getModeBinding(final Subcomponent sc) {
				  for (final ModeBinding mb : sc.getOwnedModeBindings()) {
					  if (mb.getParentMode() == modeFeature) {
						  return mb;
					  }
				  }
				  return null;
			  }
		  };

		  // Register selection listeners
		  modeBtn.addSelectionListener(selectionListener);
		  if (childModeFld != null) {
			  childModeFld.getCombo().addSelectionListener(selectionListener);
		  }
	}

	private class ModeButton {
		final Button modeBtn;
		final ModeFeature modeFeature;

		public ModeButton(final Button modeBtn, final ModeFeature modeFeature) {
			this.modeBtn = modeBtn;
			this.modeFeature = modeFeature;
		}

		private Button getModeButton() {
			return modeBtn;
		}

		private ModeFeature getModeFeature() {
			return modeFeature;
		}
	}
}
